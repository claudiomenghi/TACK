package ta.visitors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.google.common.base.Stopwatch;
import com.google.common.io.ByteStreams;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.AssignNextVariable;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.KeepBoundedVariableConstant;
import formulae.cltloc.atoms.KeepVariableConstant;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.relations.CLTLocEQRelation;
import formulae.cltloc.relations.CLTLocRelation;
import formulae.cltloc.relations.Relation;
import ta.Clock;
import ta.StateAP;
import ta.SystemDecl;
import ta.TA;
import ta.Variable;
import ta.VariableAssignementAP;
import ta.state.State;
import ta.transition.Transition;
import ta.transition.assignments.ClockAssignement;
import ta.transition.assignments.VariableAssignement;
import ta.transition.guard.ClockConstraintAtom;
import ta.visitors.liveness.Liveness2CLTLoc;
import ta.visitors.sync.WeakBroadcastSync;
import ta.visitors.sync.ChannelSynch;
import ta.visitors.sync.WeakBroadcastSync;
import ta.visitors.sync.Sync2CLTLoc;

public class TANetwork2CLTLocRC extends TANetwork2CLTLoc {

	private Map<Entry<TA, String>, Integer> mapStateId;

	private Map<Integer, String> mapIdStateName;

	private Map<Integer, TA> mapIdTA;

	protected final File statisticsFile;
	protected PrintWriter writer;
	
	private Set<Sync2CLTLoc> sync=new HashSet<>();

	public TANetwork2CLTLocRC() {
		this.statisticsFile = new File("TA2CLTLocstatistics.txt");
		try {
			writer = new PrintWriter(statisticsFile);
		} catch (FileNotFoundException e) {
			writer = new PrintWriter(ByteStreams.nullOutputStream());
			e.printStackTrace();
		}
		
		this.sync.add(new WeakBroadcastSync(this));
		this.sync.add(new ChannelSynch());
	}
	

	public TANetwork2CLTLocRC(Liveness2CLTLoc converter) {
		super(converter);
		this.statisticsFile = new File("TA2CLTLocstatistics.txt");
		try {
			writer = new PrintWriter(statisticsFile);
		} catch (FileNotFoundException e) {
			writer = new PrintWriter(ByteStreams.nullOutputStream());
			e.printStackTrace();
		}
		this.sync.add(new WeakBroadcastSync(this));
		this.sync.add(new ChannelSynch());
	}

	/**
	 * encodes the property phi1 of the paper
	 * 
	 * @param system
	 *            the system to be considered
	 * @return the property phi1
	 */
	protected CLTLocFormula getInitialStateConstraint(SystemDecl system) {
		return system.getTimedAutomata().stream()
				.map(ta -> (CLTLocFormula) new CLTLocEQRelation(
						formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(STATE_PREFIX + ta.getId(),
								getPossibleStateVariableValues(ta)),
						new Constant(this.getId(ta, ta.getInitialState()))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	public Set<Integer> getPossibleStateVariableValues(TA ta) {
		return ta.getStates().stream().map(s -> this.getId(ta, s)).collect(Collectors.toSet());
	}

	private Set<Integer> getPossibleTransitionVariableValues(TA ta) {
		Set<Integer> values = new HashSet<>();
		ta.getTransitions().stream().forEach(t -> values.add(t.getId()));
		values.add(-1);
		return values;
	}

	/**
	 * encodes the property phi2 of the paper
	 * 
	 * @param system
	 *            the system to be considered
	 * @return the property phi2
	 */
	protected CLTLocFormula getInitialVariableValuesConstraint(SystemDecl system) {
		CLTLocFormula globalVariables = system
				.getVariableDeclaration().stream().map(
						v -> (CLTLocFormula) new CLTLocEQRelation(
								system.isBounded(v.getId())
										? formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(v.getId(),
												system.getBound(v.getId()))
										: new formulae.cltloc.atoms.Variable(v.getId()),
								new Constant(v.getExp().evaluate())))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula localVariables = system.getTimedAutomata().stream()
				.map(ta -> ta.getLocalVariables().stream()
						.map(v -> (CLTLocFormula) new CLTLocEQRelation(
								ta.isBounded(v.getName()) ? formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
										ta.getIdentifier() + "_" + v.getName(),
										ta.getLocalVariables().contains(v) ? ta.getBound(v.getName())
												: system.getBound(v.getName())

								) : new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName()),
								new Constant(ta.getInitialValue(v).value)))
						.reduce(CLTLocFormula.TRUE, conjunctionOperator))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return CLTLocFormula.getAnd(globalVariables, localVariables);
	}

	/**
	 * encodes the property phi4 of the paper
	 * 
	 * @param system
	 *            the system to be considered
	 * @return the property phi4 of the paper
	 */
	private CLTLocFormula getTransitionConstraint(SystemDecl system) {

		CLTLocFormula ret1 = CLTLocFormula.TRUE;
		for (TA ta : system.getTimedAutomata()) {
			CLTLocFormula f = CLTLocFormula.TRUE;
			for (Transition t : ta.getTransitions()) {
				CLTLocFormula transFormula = implicationOperator
						.apply(new CLTLocEQRelation(
								formulae.cltloc.atoms.BoundedVariable.getBoundedVariable("t" + ta.getId(),
										this.getPossibleTransitionVariableValues(ta)),
								new Constant(t.getId())),
								CLTLocFormula.getAnd(
										new CLTLocEQRelation(
												formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
														STATE_PREFIX + ta.getId(),
														this.getPossibleStateVariableValues(ta)),
												new Constant(this.getId(ta, t.getSource()))),
										this.getVariableGuard(system, ta, t), this.getAssignVariables(system, ta, t),
										nextOperator
												.apply(CLTLocFormula.getAnd(
														new CLTLocEQRelation(
																formulae.cltloc.atoms.BoundedVariable
																		.getBoundedVariable(STATE_PREFIX + ta.getId(),
																				this.getPossibleStateVariableValues(
																						ta)),
																new Constant(this.getId(ta, t.getDestination()))),
														this.getClockGuard(ta, t),
														t.getDestination().getInvariant().accept(ta,
																new ReverseInvariantVisitor()),
														this.getAssignclock(ta, t)))));
				f = conjunctionOperator.apply(f, transFormula);
			}
			ret1 = conjunctionOperator.apply(ret1, f);
		}

		CLTLocFormula ret2 = getSync(system);

		

		return (CLTLocFormula) CLTLocFormula.getAnd(ret1, ret2);

	}


	private CLTLocFormula getSync(SystemDecl system) {
		
		CLTLocFormula f = this.sync.stream().map(s -> s.getSyncConstraint(system)).reduce(conjunctionOperator).orElse(CLTLocFormula.TRUE);
		
		return f;
	}

	
	

	public int getId(TA ta, State s) {
		if (!this.mapStateId.containsKey(new AbstractMap.SimpleEntry<>(ta, s.getStringId()))) {
			throw new IllegalArgumentException("TA with name: " + ta.getId() + ", " + ta.getIdentifier() + " state "
					+ s.getStringId() + " not found");
		}
		return this.mapStateId.get(new AbstractMap.SimpleEntry<>(ta, s.getStringId()));
	}

	public CLTLocFormula getClockGuard(TA ta, Transition t) {

		Set<ClockConstraintAtom> assignments = t.getGuard().getClockConstraints();
		CLTLocFormula f = assignments.stream().map(c -> {
			String prefix = ta.getLocalClocks().contains(c.getClock()) ? ta.getIdentifier() + "_" : "";
			return (CLTLocFormula) 
			new CLTLocRelation(new CLTLocClock(prefix + c.getClock().getName() + "_0"), new Constant(c.getValue()),
					Relation.parse(c.getOperator().toString())); 
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		return f;

	}

	public CLTLocFormula getVariableGuard(SystemDecl system, TA ta, Transition t) {
		return (CLTLocFormula) t.getGuard().getConditions().stream().map(condition -> {
			String prefix = ta.getLocalVariables().contains(condition.getVariable()) ? ta.getIdentifier() + "_" : "";

			formulae.cltloc.atoms.Variable v = ((ta.getLocalVariables().contains(condition.getVariable())
					&& ta.isBounded(condition.getVariable().getName()))
					|| (system.isBounded(condition.getVariable().getName())))
							? formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
									prefix + condition.getVariable().getName(),
									ta.getLocalVariables().contains(condition.getVariable())
											? ta.getBound(condition.getVariable().getName())
											: system.getBound(condition.getVariable().getName()))
							: new formulae.cltloc.atoms.Variable(prefix + condition.getVariable().getName());

			return (CLTLocFormula) new CLTLocRelation(

					v, new Constant(condition.getValue()), Relation.parse(condition.getOperator().toString()));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	protected CLTLocFormula getAssignVariables(SystemDecl system, TA ta, Transition t) {
		Set<VariableAssignement> assignments = t.getAssignement().getVariableassigments();
		return assignments.stream().map(v -> {
			String prefix = ta.getLocalVariables().contains(v.getVariable()) ? ta.getIdentifier() + "_" : "";

			formulae.cltloc.atoms.Variable variable = ((ta.getLocalVariables().contains(v.getVariable())
					&& ta.isBounded(v.getVariable().getName())) || (system.isBounded(v.getVariable().getName())))
							? formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
									prefix + v.getVariable().getName(),
									ta.getLocalVariables().contains(v.getVariable())
											? ta.getBound(v.getVariable().getName())
											: system.getBound(v.getVariable().getName()))
							: new formulae.cltloc.atoms.Variable(prefix + v.getVariable().getName());

			return (CLTLocFormula) new AssignNextVariable(variable,
					v.getValue().accept(new Expression2CLTLocExpression()));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}

	protected CLTLocFormula getAssignclock(TA ta, Transition t) {
		Set<ClockAssignement> assignments = t.getAssignement().getClockassigments();
		return assignments.stream().map(c -> {
			String prefix = ta.getLocalClocks().contains(c.getClock()) ? ta.getIdentifier() + "_" : "";
			return (CLTLocFormula) // CLTLocDisjunction.getCLTLocDisjunction(
			new CLTLocRelation(new CLTLocClock(prefix + c.getClock().getName() + "_0"),
					new Constant(c.getValue().value), Relation.EQ); // ,
			// new CLTLocRelation(new CLTLocClock(prefix + c.getClock().getName() + "_1"),
			// new Constant(c.getValue().value), Relation.EQ));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	public Map<Entry<TA, String>, Integer> getMapStateId() {
		return this.mapStateId;
	}

	public CLTLocFormula convert(SystemDecl system, Set<StateAP> propositionsOfInterest,
			Set<VariableAssignementAP> atomicpropositionsVariable) {

		this.mapStateId = new HashMap<>();
		this.mapIdTA = new HashMap<>();
		this.mapIdStateName = new HashMap<>();
		int count = 0;
		for (TA ta : system.getTimedAutomata()) {
			for (State s : ta.getStates()) {
				mapStateId.put(new AbstractMap.SimpleEntry<>(ta, s.getStringId()), count);
				mapIdStateName.put(count, s.getStringId());
				count++;
			}
			this.mapIdTA.put(ta.getId(), ta);
		}

		Stopwatch testTimer = Stopwatch.createUnstarted();

		testTimer.start();
		CLTLocFormula clockConstraint = this.getClock1(system);

		CLTLocFormula automaton = CLTLocFormula.getAnd(this.getInitialStateConstraint(system),
				this.getInitialVariableValuesConstraint(system));

		CLTLocFormula semantic = CLTLocFormula.getAnd(this.initialFirstValues(system, propositionsOfInterest),
				this.initAssignments(system, atomicpropositionsVariable));

		CLTLocFormula glo = globallyOperator.apply(CLTLocFormula.getAnd(
				this.labeIsAreTrueOnlyInTheStates(system, propositionsOfInterest),
				this.intervalsAreRightClosed(propositionsOfInterest),
				this.variablesAreTrueOnlyIfAssignmentsAreSatisfied(system, atomicpropositionsVariable),
				this.variableIntervalsAreRightClosed(atomicpropositionsVariable),
				this.getLivenessConverter().getLivenessConstraint(system), this.getInvariant(system),
				this.getTransitionConstraint(system), this.stateChangesImpliesTransition(system),
				this.resetImpliesTransition(system), this.variableChangeImpliesTransition(system),
				this.eachAutomatonIsInOneOfItsStates(system)));

		testTimer.stop();
		writer.write("variable1: " + testTimer.elapsed(TimeUnit.MILLISECONDS) + "\n");

		return CLTLocFormula.getAnd(clockConstraint, automaton, semantic, glo);
	}

	/**
	 * @return the mapIdStateName
	 */
	public Map<Integer, String> getMapIdStateName() {
		return mapIdStateName;
	}

	/**
	 * @param mapIdStateName
	 *            the mapIdStateName to set
	 */
	public void setMapIdStateName(Map<Integer, String> mapIdStateName) {
		this.mapIdStateName = mapIdStateName;
	}

	/**
	 * @return the mapIdTA
	 */
	public Map<Integer, TA> getMapIdTA() {
		return mapIdTA;
	}

	/**
	 * @param mapIdTA
	 *            the mapIdTA to set
	 */
	public void setMapIdTA(Map<Integer, TA> mapIdTA) {
		this.mapIdTA = mapIdTA;
	}

	protected CLTLocFormula getClock1(SystemDecl system) {

		Set<Clock> clocks = system.getGlobalClocks();

		CLTLocFormula globalClocks = clocks.stream().map(c -> {
			return (CLTLocFormula) // CLTLocFormula.getAnd(
			new CLTLocRelation(new CLTLocClock(c.getName() + "_0"), new Constant(0), Relation.EQ); // ,
			// new CLTLocRelation(new CLTLocClock(c.getName() + "_1"), new Constant(0),
			// Relation.GE),
			// new CLTLocNegation(new CLTLocSelector(c.getName() + "_v")));

		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula localClocks = system.getTimedAutomata().stream().map(ta -> ta.getLocalClocks().stream().map(c -> {
			String prefix = ta.getIdentifier() + "_";
			return (CLTLocFormula) // CLTLocFormula.getAnd(
			new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_0"), new Constant(0), Relation.EQ); // ,
			// new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_1"), new
			// Constant(0), Relation.GE),
			// new CLTLocNegation(new CLTLocSelector(prefix + c.getName() + "_v")));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator)).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return CLTLocFormula.getAnd(globalClocks, localClocks);
	}

	/**
	 * encodes formula phi5 of the paper
	 * 
	 * @param system
	 *            the system to be considered
	 * @return the property phi5 of the paper
	 */
	protected CLTLocFormula stateChangesImpliesTransition(SystemDecl system) {

		CLTLocFormula f = CLTLocFormula.TRUE;

		for (TA ta : system.getTimedAutomata()) {
			CLTLocFormula taFormula = CLTLocFormula.TRUE;

			Set<Integer> possibleStateVariables = this.getPossibleStateVariableValues(ta);

			Set<Integer> possibleTransitionVariables = this.getPossibleTransitionVariableValues(ta);

			for (State s1 : ta.getStates()) {
				for (State s2 : ta.successors(s1)) {
					if (!s1.equals(s2)) {
						CLTLocFormula trans = implicationOperator.apply(
								conjunctionOperator.apply(
										new CLTLocEQRelation(
												formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
														STATE_PREFIX + ta.getId(), possibleStateVariables),
												Constant.getConstant(this.getId(ta, s1))),
										new CLTLocNext(new CLTLocEQRelation(
												formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
														STATE_PREFIX + ta.getId(), possibleStateVariables),
												Constant.getConstant(this.getId(ta, s2))))),
								ta.getTransitions(s1, s2).stream()
										.map(t1 -> (CLTLocFormula) new CLTLocEQRelation(
												formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
														"t" + ta.getId(), possibleTransitionVariables),
												Constant.getConstant(t1.getId())))
										.reduce(CLTLocFormula.FALSE, disjunctionOperator));

						taFormula = conjunctionOperator.apply(taFormula, trans);
					}
				}

			}
			f = conjunctionOperator.apply(f, taFormula);

			CLTLocFormula stateUpdate = CLTLocFormula.TRUE;
			for (State s1 : ta.getStates()) {

				CLTLocFormula currentState = new CLTLocEQRelation(formulae.cltloc.atoms.BoundedVariable
						.getBoundedVariable(STATE_PREFIX + ta.getId(), possibleStateVariables),
						Constant.getConstant(this.getId(ta, s1)));

				CLTLocFormula f3 = new CLTLocEQRelation(formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
						STATE_PREFIX + ta.getId(), possibleStateVariables), Constant.getConstant(this.getId(ta, s1)));

				for (State s2 : ta.successors(s1)) {
					f3 = disjunctionOperator.apply(f3,
							new CLTLocEQRelation(formulae.cltloc.atoms.BoundedVariable
									.getBoundedVariable(STATE_PREFIX + ta.getId(), possibleStateVariables),
									Constant.getConstant(this.getId(ta, s2))));

				}
				stateUpdate = conjunctionOperator.apply(stateUpdate,
						implicationOperator.apply(currentState, nextOperator.apply(f3)));
			}

			f = conjunctionOperator.apply(f, stateUpdate);

		}

		return f;

		/*
		 * CLTLocFormula f=(CLTLocFormula) system.getTimedAutomata() .stream().map( ta
		 * -> (CLTLocFormula) ta.getStates().stream() .map(s1 -> (CLTLocFormula)
		 * ta.getStates().stream().filter(s2 -> !s2.equals(s1)) .map(s2 ->
		 * (CLTLocFormula) implicationOperator.apply( conjunctionOperator.apply( new
		 * CLTLocEQRelation(
		 * formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(STATE_PREFIX +
		 * ta.getId(), this.getPossibleStateVariableValues(ta)), new Constant(
		 * this.getId(ta, s1))), new CLTLocNext(new CLTLocEQRelation(
		 * formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(STATE_PREFIX +
		 * ta.getId(), this.getPossibleStateVariableValues(ta)), new
		 * Constant(this.getId(ta, s2))))), ta.getTransitions().stream() .filter(t1 ->
		 * t1.getSource().equals(s1) && t1.getDestination().equals(s2)) .map(t1 ->
		 * (CLTLocFormula) new CLTLocEQRelation(
		 * formulae.cltloc.atoms.BoundedVariable.getBoundedVariable("t" + ta.getId(),
		 * this.getPossibleTransitionVariableValues(ta)), new Constant(t1.getId())))
		 * .reduce(CLTLocFormula.FALSE, disjunctionOperator)))
		 * .reduce(CLTLocFormula.TRUE, conjunctionOperator)) .reduce(CLTLocFormula.TRUE,
		 * conjunctionOperator)) .reduce(CLTLocFormula.TRUE, conjunctionOperator);
		 */

	}

	protected CLTLocFormula getInvariant(SystemDecl system) {

		return (CLTLocFormula) system.getTimedAutomata().stream().map(ta ->

		(CLTLocFormula) ta.getStates().stream().map(s -> {
			if (!s.getInvariant().accept(ta, new NormalInvariantVisitor()).equals(CLTLocFormula.TRUE)) {
				return (CLTLocFormula) implicationOperator.apply(
						new CLTLocEQRelation(formulae.cltloc.atoms.BoundedVariable
								.getBoundedVariable(STATE_PREFIX + ta.getId(), this.getPossibleStateVariableValues(ta)),
								new Constant(this.getId(ta, s))),
						new CLTLocNext(s.getInvariant().accept(ta, new NormalInvariantVisitor())));
			} else {
				return CLTLocFormula.TRUE;
			}

		}).reduce(CLTLocFormula.TRUE, conjunctionOperator))

				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}

	protected CLTLocFormula eachAutomatonIsInOneOfItsStates(SystemDecl system) {

		return (CLTLocFormula) system.getTimedAutomata().stream()
				.map(ta -> (CLTLocFormula) ta.getStates().stream()
						.map(s1 -> (CLTLocFormula) new CLTLocEQRelation(formulae.cltloc.atoms.BoundedVariable
								.getBoundedVariable(STATE_PREFIX + ta.getId(), this.getPossibleStateVariableValues(ta)),
								new Constant(this.getId(ta, s1))))
						.reduce(CLTLocFormula.FALSE, disjunctionOperator))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	private CLTLocFormula getTransitionsThatResetTheGlobalClock(SystemDecl system, Clock c) {
		CLTLocFormula f = (CLTLocFormula) system.getTimedAutomata().stream()
				.filter(ta -> !ta.getLocalClocks().contains(c))
				.map(ta -> ta.getTransitions().stream().filter(t -> t.getAssignement().assign(c))
						.map(t -> (CLTLocFormula) new CLTLocEQRelation(formulae.cltloc.atoms.BoundedVariable
								.getBoundedVariable("t" + ta.getId(), this.getPossibleTransitionVariableValues(ta)),
								new Constant(t.getId())))
						.reduce(CLTLocFormula.FALSE, disjunctionOperator))
				.reduce(CLTLocFormula.FALSE, disjunctionOperator);
		return f;
	}

	private CLTLocFormula getTransitionsThatResetTheLocalClock(SystemDecl system, Clock c) {
		CLTLocFormula f = (CLTLocFormula) system.getTimedAutomata().stream()
				.filter(ta -> ta.getLocalClocks().contains(c))
				.map(ta -> ta.getTransitions().stream().filter(t -> t.getAssignement().assign(c))
						.map(t -> (CLTLocFormula) new CLTLocEQRelation(formulae.cltloc.atoms.BoundedVariable
								.getBoundedVariable("t" + ta.getId(), this.getPossibleTransitionVariableValues(ta)),
								new Constant(t.getId())))
						.reduce(CLTLocFormula.FALSE, disjunctionOperator))
				.reduce(CLTLocFormula.FALSE, disjunctionOperator);
		return f;
	}

	/**
	 * encodes formula phi6 of the paper
	 * 
	 * @param system
	 *            the system to be considered
	 * @return the property phi6 of the paper
	 */
	protected CLTLocFormula resetImpliesTransition(SystemDecl system) {
		Set<Clock> clocks = system.getGlobalClocks();
		CLTLocFormula globalClocks = clocks.stream().map(c -> {
			CLTLocFormula f = this.getTransitionsThatResetTheGlobalClock(system, c);

			return (CLTLocFormula) implicationOperator.apply(new CLTLocNext( // CLTLocDisjunction.getCLTLocDisjunction(
					new CLTLocRelation(new CLTLocClock(c.getName() + "_0"), zero, Relation.EQ)), f); // ,
			// new CLTLocRelation(new CLTLocClock(c.getName() + "_1"), zero, Relation.EQ))),
			// f);
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula localClocks = system.getTimedAutomata().stream().map(ta -> ta.getLocalClocks().stream().map(c -> {
			String prefix = ta.getIdentifier() + "_";
			CLTLocFormula f = this.getTransitionsThatResetTheLocalClock(system, c);

			return (CLTLocFormula) implicationOperator.apply(new CLTLocNext( // CLTLocDisjunction.getCLTLocDisjunction(
					new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_0"), zero, Relation.EQ)), f);
			// new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_1"), zero,
			// Relation.EQ))), f);
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator)).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return CLTLocFormula.getAnd(globalClocks, localClocks);
	}

	/**
	 * encodes formula phi7 of the paper
	 * 
	 * @param system
	 *            the system to be considered
	 * @return the property phi7 of the paper
	 */
	protected CLTLocFormula variableChangeImpliesTransition(SystemDecl system) {
		Set<Variable> variables = system.getGlobalVariables();

		CLTLocFormula globalVariables = variables.stream().map(v -> {

			KeepVariableConstant keepConstant = system.isBounded(v.getName())
					? new KeepBoundedVariableConstant(formulae.cltloc.atoms.BoundedVariable
							.getBoundedVariable(v.getName(), system.getBound(v.getName())))
					: new KeepVariableConstant(new formulae.cltloc.atoms.Variable(v.getName()));

			return implicationOperator.apply(negationOperator.apply(keepConstant), system.getTimedAutomata().stream()
					.filter(ta -> !ta.getLocalVariables().contains(v))
					.map(ta -> (CLTLocFormula) ta.getTransitions().stream()
							.filter(t -> t.getAssignement().assignedVariables().contains(v))
							.map(t -> (CLTLocFormula) new CLTLocEQRelation(formulae.cltloc.atoms.BoundedVariable
									.getBoundedVariable("t" + ta.getId(), this.getPossibleTransitionVariableValues(ta)),
									new Constant(t.getId())))
							.reduce(CLTLocFormula.FALSE, disjunctionOperator))
					.reduce(CLTLocFormula.FALSE, disjunctionOperator));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula localVariables = system.getTimedAutomata().stream()
				.map(ta -> ta.getLocalVariables().stream().map(v -> {
					KeepVariableConstant keepConstant = ta.isBounded(v.getName())
							? new KeepBoundedVariableConstant(formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
									ta.getIdentifier() + "_" + v.getName(), ta.getBound(v.getName())))
							: new KeepVariableConstant(
									new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName()));

					return implicationOperator.apply(negationOperator.apply(keepConstant),
							(CLTLocFormula) ta.getTransitions().stream()
									.filter(t -> t.getAssignement().assignedVariables().contains(v))
									.filter(t -> t.getAssignement().assignedVariables().contains(v))
									.map(t -> (CLTLocFormula) new CLTLocEQRelation(
											formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(ta.getIdentifier(),
													this.getPossibleTransitionVariableValues(ta)),
											new Constant(t.getId())))
									.reduce(CLTLocFormula.FALSE, disjunctionOperator));

				}).reduce(CLTLocFormula.TRUE, conjunctionOperator)).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return CLTLocFormula.getAnd(localVariables, globalVariables);
	}

	/**
	 * encodes the liveness condition phisem1
	 * 
	 * @param system
	 *            the system to be considered
	 * @return the liveness condition phisem1
	 */
	protected CLTLocFormula livenessEachTAperformsATransition(SystemDecl system) {

		CLTLocFormula f = CLTLocFormula.TRUE;
		for (TA ta : system.getTimedAutomata()) {
			CLTLocFormula taf = CLTLocFormula.FALSE;
			Set<Integer> values = this.getPossibleTransitionVariableValues(ta);

			taf = eventuallyOperator.apply(ta.getTransitions().stream()
					.map(t -> (CLTLocFormula) new CLTLocEQRelation(
							formulae.cltloc.atoms.BoundedVariable.getBoundedVariable("t" + ta.getId(), values),
							new Constant(t.getId())))
					.reduce(CLTLocFormula.FALSE, disjunctionOperator));

			f = conjunctionOperator.apply(f, taf);
		}

		return f;
	}

	protected CLTLocFormula labeIsAreTrueOnlyInTheStates(SystemDecl system, Set<StateAP> propositionsOfInterest) {

		return (CLTLocFormula) propositionsOfInterest.stream()
				.map(ap -> (CLTLocFormula) iffOperator.apply(rest.apply(ap.getEncodingSymbol()), system
						.getTimedAutomata().stream().filter(ta -> ta.getIdentifier().equals(ap.getAutomata())).map(
								ta -> (CLTLocFormula) ta
										.getStates().stream().filter(Objects::nonNull).filter(
												s -> s.getStringId().equals(ap.getState()))
										.map(s -> (CLTLocFormula) new CLTLocEQRelation(
												formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
														STATE_PREFIX + ta.getId(),
														this.getPossibleStateVariableValues(ta)),
												new Constant(this.getId(ta, s))))
										.reduce(CLTLocFormula.TRUE, conjunctionOperator))
						.reduce(CLTLocFormula.TRUE, conjunctionOperator)))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}

	protected CLTLocFormula intervalsAreRightClosed(Set<StateAP> propositionsOfInterest) {
		return (CLTLocFormula) propositionsOfInterest.stream()
				.map(ap -> iffOperator.apply(rest.apply(ap.getEncodingSymbol()),
						nextOperator.apply(first.apply(ap.getEncodingSymbol()))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	protected CLTLocFormula initialFirstValues(SystemDecl system, Set<StateAP> propositionsOfInterest) {

		return propositionsOfInterest
				.stream().map(
						ap -> iffOperator
								.apply(first.apply(ap.getEncodingSymbol()),
										(CLTLocFormula) system.getTimedAutomata().stream()
												.filter(ta -> ta.getIdentifier().equals(ap.getAutomata()))
												.map(ta -> (CLTLocFormula) ta.getStates().stream()
														.filter(s -> s.getStringId().equals(ap.getState()))
														.map(s -> (CLTLocFormula) new CLTLocEQRelation(
																formulae.cltloc.atoms.BoundedVariable
																		.getBoundedVariable(STATE_PREFIX + ta.getId(),
																				this.getPossibleStateVariableValues(
																						ta)),
																new Constant(this.getId(ta, s)))

														).reduce(CLTLocFormula.TRUE, conjunctionOperator))
												.reduce(CLTLocFormula.TRUE, conjunctionOperator)))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	protected CLTLocFormula variablesAreTrueOnlyIfAssignmentsAreSatisfied(SystemDecl system,
			Set<VariableAssignementAP> atomicpropositionsVariable) {

		return (CLTLocFormula) atomicpropositionsVariable.stream().map(ap ->

		{
			if (ap.getAutomaton().equals("")) {
				formulae.cltloc.atoms.Variable variable =

						system.isBounded(ap.getVariable().getName())
								? formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(ap.getVariable().getName(),
										system.getBound(ap.getVariable().getName()))
								: new formulae.cltloc.atoms.Variable(
										(ap.getAutomaton() != "" ? ap.getAutomaton() + "_" : "")
												+ ap.getVariable().getName());
				return (CLTLocFormula) iffOperator.apply(rest.apply(ap.getEncodingSymbol()),
						(CLTLocFormula) new CLTLocEQRelation(

								variable, new Constant(ap.getValue().value)));
			} else {
				for (TA ta : system.getTimedAutomata()) {
					if (ta.getIdentifier().equals(ap.getAutomaton())) {

						if (ta.isBounded(ap.getVariable().getName())) {
							formulae.cltloc.atoms.Variable variable = formulae.cltloc.atoms.BoundedVariable
									.getBoundedVariable(ap.getAutomaton() + "_" + ap.getVariable().getName(),
											ta.getBound(ap.getVariable().getName()));
							return (CLTLocFormula) iffOperator.apply(rest.apply(ap.getEncodingSymbol()),
									(CLTLocFormula) new CLTLocEQRelation(

											variable, new Constant(ap.getValue().value)));
						} else {
							formulae.cltloc.atoms.Variable variable = new formulae.cltloc.atoms.Variable(
									ap.getAutomaton() + "_" + ap.getVariable().getName());
							return (CLTLocFormula) iffOperator.apply(rest.apply(ap.getEncodingSymbol()),
									(CLTLocFormula) new CLTLocEQRelation(

											variable, new Constant(ap.getValue().value)));
						}
					}
				}
				throw new IllegalArgumentException("The formula is not correct; a timed automaton with name "
						+ ap.getAutomaton() + " not present in the network");

			}

		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}

	protected CLTLocFormula variableIntervalsAreRightClosed(Set<VariableAssignementAP> atomicpropositionsVariable) {
		return (CLTLocFormula) atomicpropositionsVariable.stream()
				.map(ap -> iffOperator.apply(rest.apply(ap.getEncodingSymbol()),
						nextOperator.apply(first.apply(ap.getEncodingSymbol()))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	protected CLTLocFormula initAssignments(SystemDecl system, Set<VariableAssignementAP> atomicpropositionsVariable) {

		return (CLTLocFormula) atomicpropositionsVariable.stream().map(ap -> {

			if (ap.getAutomaton().equals("")) {
				formulae.cltloc.atoms.Variable variable = system.isBounded(ap.getVariable().getName())
						? formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(ap.getVariable().getName(),
								system.getBound(ap.getVariable().getName()))
						: new formulae.cltloc.atoms.Variable(ap.getVariable().getName());

				return (CLTLocFormula) iffOperator.apply(first.apply(ap.getEncodingSymbol()),

						(CLTLocFormula) new CLTLocEQRelation(variable, new Constant(ap.getValue().value)));
			} else {
				for (TA ta : system.getTimedAutomata()) {
					if (ta.getIdentifier().equals(ap.getAutomaton())) {

						if (!ta.containsVariable(ap.getVariable().getName())) {
							throw new IllegalArgumentException("The variable: " + ap.getVariable().getName()
									+ " is not a variable of the TA " + ta.getIdentifier());
						}
						formulae.cltloc.atoms.Variable variable = ta.isBounded(ap.getVariable().getName())
								? formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
										ap.getAutomaton() + "_" + ap.getVariable().getName(),
										ta.getBound(ap.getVariable().getName()))
								: new formulae.cltloc.atoms.Variable(
										ap.getAutomaton() + "_" + ap.getVariable().getName());

						return (CLTLocFormula) iffOperator.apply(first.apply(ap.getEncodingSymbol()),

								(CLTLocFormula) new CLTLocEQRelation(variable, new Constant(ap.getValue().value)));
					}
				}
				throw new IllegalArgumentException(
						"The timed automaton with identifier " + ap.getAutomaton() + " does not exist");
			}
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}
}
