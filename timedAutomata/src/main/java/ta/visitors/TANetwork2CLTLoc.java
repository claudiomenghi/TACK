package ta.visitors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.io.ByteStreams;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocSelector;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.KeepBoundedVariableConstant;
import formulae.cltloc.atoms.KeepVariableConstant;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.binary.CLTLocRelease;
import formulae.cltloc.operators.unary.CLTLocEventually;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.relations.CLTLocEQRelation;
import formulae.cltloc.relations.CLTLocRelation;
import formulae.cltloc.relations.Relation;
import ta.AP;
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
import ta.transition.guard.ClockConstraint;
import ta.transition.guard.ClockConstraintAtom;

public class TANetwork2CLTLoc {

	public static final CLTLocFormula ORIGIN = CLTLocFormula.getNeg(new CLTLocYesterday(CLTLocFormula.TRUE));

	private Map<Entry<TA, String>, Integer> mapStateId;
	public static final Constant zero = new Constant(0);

	protected final File statisticsFile;
	protected PrintWriter writer;

	public static final Function<Integer, CLTLocFormula> rest = (s) -> new CLTLocAP("H_" + s);

	public static final Function<Integer, CLTLocFormula> first = (s) -> new CLTLocAP("P_" + s);

	public static final BinaryOperator<CLTLocFormula> conjunctionOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		if (left.equals(CLTLocFormula.TRUE)) {
			return right;
		}
		if (left.equals(CLTLocFormula.FALSE)) {
			return left;
		}
		if (right.equals(CLTLocFormula.TRUE)) {
			return left;
		}
		if (right.equals(CLTLocFormula.FALSE)) {
			return right;
		}
		return new CLTLocConjunction(left, right);
	};

	public static final BinaryOperator<CLTLocFormula> iffOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		if (left.equals(CLTLocFormula.TRUE)) {
			return right;
		}
		if (right.equals(CLTLocFormula.TRUE)) {
			return left;
		}
		return new CLTLocIff(left, right);
	};

	public static final BinaryOperator<CLTLocFormula> disjunctionOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");
		if (left.equals(CLTLocFormula.FALSE)) {
			return right;
		}
		if (right.equals(CLTLocFormula.FALSE)) {
			return left;
		}
		return new CLTLocDisjunction(left, right);
	};

	public static final UnaryOperator<CLTLocFormula> eventuallyOperator = (formula) -> {

		return new CLTLocEventually(formula);
	};

	public static final BinaryOperator<CLTLocFormula> implicationOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");
		if (right.equals(CLTLocFormula.TRUE)) {
			return CLTLocFormula.TRUE;
		}
		return new CLTLocImplies(left, right);
	};

	public static final UnaryOperator<CLTLocFormula> negationOperator = CLTLocNegation::new;
	public static final UnaryOperator<CLTLocFormula> globallyOperator = (formula) -> {
		if (formula.equals(CLTLocFormula.TRUE)) {
			return formula;
		}
		return new CLTLocGlobally(formula);
	};

	public static final UnaryOperator<CLTLocFormula> nextOperator = (formula) -> {
		Preconditions.checkNotNull(formula, "The formula cannot be null");

		if (formula.equals(CLTLocFormula.TRUE)) {
			return formula;
		}
		return new CLTLocNext(formula);
	};

	public static final UnaryOperator<CLTLocFormula> Y = CLTLocYesterday::new;

	// private static final Function<AP, CLTLocFormula> ap2CLTLocRESTAp = ap ->
	// new CLTLocAP("H_" + ap.getName());
	private static final Function<AP, CLTLocFormula> ap2CLTLocFIRSTAp = ap -> new CLTLocAP("P_" + ap.getName());

	protected static final Function<Entry<TA, State>, CLTLocFormula> state2Ap = (s) -> new CLTLocAP(
			s.getKey().getIdentifier() + "_" + s.getValue().getStringId());

	protected static final Function<Entry<TA, String>, CLTLocFormula> sendEvent2Ap = (s) -> new CLTLocAP(
			s.getKey().getIdentifier() + "_?" + s.getValue());

	protected static final Function<Entry<TA, String>, CLTLocFormula> tauEvent2Ap = (s) -> new CLTLocAP(
			s.getKey().getIdentifier() + "_" + s.getValue());

	protected static final Function<Entry<TA, String>, CLTLocFormula> receiveEvent2Ap = (s) -> new CLTLocAP(
			s.getKey().getIdentifier() + "_!" + s.getValue());

	protected static final BinaryOperator<CLTLocFormula> xorOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		if (left.equals(CLTLocFormula.FALSE)) {
			return right;
		}

		if (right.equals(CLTLocFormula.FALSE)) {
			return left;
		}

		return CLTLocFormula.getOr(CLTLocFormula.getAnd(left, negationOperator.apply(right)),
				CLTLocFormula.getAnd(negationOperator.apply(left), right));
	};

	public TANetwork2CLTLoc() {
		this.statisticsFile = new File("TA2CLTLocstatistics.txt");
		try {
			writer = new PrintWriter(statisticsFile);
		} catch (FileNotFoundException e) {
			writer = new PrintWriter(ByteStreams.nullOutputStream());
			e.printStackTrace();
		}
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
						new formulae.cltloc.atoms.BoundedVariable("s" + ta.getId(), getPossibleStateVariableValues(ta)),
						new Constant(this.getId(ta, ta.getInitialState()))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	private Set<Integer> getPossibleStateVariableValues(TA ta){
		return ta.getStates().stream().map(s -> this.getId(ta, s)).collect(Collectors.toSet());
	}
	
	private Set<Integer> getPossibleTransitionVariableValues(TA ta){
		return ta.getTransitions().stream().map(t -> t.getId()).collect(Collectors.toSet());
	}
	/**
	 * encodes the property phi2 of the paper
	 * 
	 * @param system
	 *            the system to be considered
	 * @return the property phi2
	 */
	protected CLTLocFormula getInitialVariableValuesConstraint(SystemDecl system) {
		CLTLocFormula globalVariables= system.getVariableDeclaration().stream()
				.map(v -> (CLTLocFormula) new CLTLocEQRelation(
						system.isBounded(v.getId()) ?
						new formulae.cltloc.atoms.BoundedVariable(v.getId(), system.getBound(v.getId()))
								:
						new formulae.cltloc.atoms.Variable(v.getId()),
						new Constant(v.getExp().evaluate())))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		CLTLocFormula localVariables=system.getTimedAutomata().stream().map(ta -> 
				ta.getLocalVariables().stream().map(v ->
							(CLTLocFormula) new CLTLocEQRelation(
									ta.isBounded(v.getName()) ?
									new formulae.cltloc.atoms.BoundedVariable(ta.getIdentifier()+"_"+v.getName(), ta.getBound(v.getName()))
											:
									new formulae.cltloc.atoms.Variable(ta.getIdentifier()+"_"+v.getName()),
															new Constant(	ta.getInitialValue(v).value))).reduce(CLTLocFormula.TRUE, conjunctionOperator)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
				
				
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
		return system.getTimedAutomata()
				.stream().map(
						ta -> ta.getTransitions().stream()
								.map(t -> implicationOperator.apply(new CLTLocEQRelation(
										new formulae.cltloc.atoms.BoundedVariable("t" + ta.getId(), this.getPossibleTransitionVariableValues(ta)), new Constant(t.getId())),
										CLTLocFormula.getAnd(
												new CLTLocEQRelation(
														new formulae.cltloc.atoms.BoundedVariable("s" + ta.getId(), this.getPossibleStateVariableValues(ta)),
														new Constant(this.getId(ta, t.getSource()))),
												this.getVariableGuard(ta, t),
												nextOperator.apply(
														CLTLocFormula.getAnd(
																new CLTLocEQRelation(
																		new formulae.cltloc.atoms.BoundedVariable(
																				"s" + ta.getId(), this.getPossibleStateVariableValues(ta)),
																		new Constant(
																				this.getId(ta, t.getDestination()))),
																
																this.getClockGuard(ta, t),
																t.getDestination().getInvariant().accept(ta, new ReverseInvariantVisitor()),
																this.getAssignVariables(ta, t),
																this.getAssignclock(ta, t))))))
								.reduce(CLTLocFormula.TRUE, conjunctionOperator))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}

	protected int getId(TA ta, State s) {
		return this.mapStateId.get(new AbstractMap.SimpleEntry<>(ta, s.getStringId()));
	}

	protected CLTLocFormula getClockGuard(TA ta, Transition t) {

		Set<ClockConstraintAtom> assignments = t.getGuard().getClockConstraints();
		return assignments.stream().map(c -> {
			String prefix = ta.getLocalClocks().contains(c.getClock()) ? ta.getIdentifier() + "_" : "";
			return (CLTLocFormula) new CLTLocDisjunction(
					CLTLocFormula.getAnd(new CLTLocNegation(new CLTLocSelector(prefix + c.getClock().getName() + "_v")),
							new CLTLocRelation(new CLTLocClock(prefix + c.getClock().getName() + "_0"),
									new Constant(c.getValue()), Relation.parse(c.getOperator().toString())
									)),
					CLTLocFormula.getAnd(new CLTLocSelector(prefix + c.getClock().getName() + "_v"),
							new CLTLocRelation(new CLTLocClock(prefix + c.getClock().getName() + "_1"),
									new Constant(c.getValue()), Relation.parse(c.getOperator().toString()))));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}

	protected CLTLocFormula getVariableGuard(TA ta, Transition t) {
		return (CLTLocFormula) t.getGuard().getConditions().stream().map(condition -> {
			String prefix = ta.getLocalVariables().contains(condition.getVariable()) ? ta.getIdentifier() + "_" : "";

			formulae.cltloc.atoms.Variable v=ta.isBounded(condition.getVariable().getName()) ?
							new formulae.cltloc.atoms.BoundedVariable(prefix + condition.getVariable().getName(), ta.getBound(condition.getVariable().getName()))
									:
							new formulae.cltloc.atoms.Variable(prefix + condition.getVariable().getName());
			
			return (CLTLocFormula) new CLTLocEQRelation(
					
					v
					,
					new Constant(condition.getValue()));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	protected CLTLocFormula getAssignVariables(TA ta, Transition t) {
		Set<VariableAssignement> assignments = t.getAssignement().getVariableassigments();
		return assignments.stream().map(v -> {
			String prefix = ta.getLocalVariables().contains(v.getVariable()) ? ta.getIdentifier() + "_" : "";

			
			formulae.cltloc.atoms.Variable variable=ta.isBounded(v.getVariable().getName()) ?
					new formulae.cltloc.atoms.BoundedVariable(prefix + v.getVariable().getName(), ta.getBound(v.getVariable().getName()))
							:
					new formulae.cltloc.atoms.Variable(prefix + v.getVariable().getName());
					
			
			return (CLTLocFormula) new CLTLocEQRelation(
					variable,
					new Constant(v.getValue().evaluate()));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}

	protected CLTLocFormula getAssignclock(TA ta, Transition t) {
		Set<ClockAssignement> assignments = t.getAssignement().getClockassigments();
		return assignments.stream().map(c -> {
			String prefix = ta.getLocalClocks().contains(c.getClock()) ? ta.getIdentifier() + "_" : "";
			return (CLTLocFormula) new CLTLocDisjunction(
					new CLTLocRelation(new CLTLocClock(prefix + c.getClock().getName() + "_0"),
							new Constant(c.getValue().value), Relation.EQ),
					new CLTLocRelation(new CLTLocClock(prefix + c.getClock().getName() + "_1"),
							new Constant(c.getValue().value), Relation.EQ));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	public Map<Entry<TA, String>, Integer> getMapStateId() {
		return this.mapStateId;
	}

	public CLTLocFormula convert(SystemDecl system, Set<StateAP> propositionsOfInterest,
			Set<VariableAssignementAP> atomicpropositionsVariable) {

		this.mapStateId = new HashMap<>();

		int count = 0;
		for (TA ta : system.getTimedAutomata()) {
			for (State s : ta.getStates()) {
				mapStateId.put(new AbstractMap.SimpleEntry<>(ta, s.getStringId()), count);
				count++;
			}
		}

		Stopwatch testTimer = Stopwatch.createUnstarted();

		testTimer.start();
		CLTLocFormula clockConstraint = 
				CLTLocFormula.getAnd(
						this.getClock1(system), 
						this.getClock2(system),
						this.getClock3(system));

		CLTLocFormula automaton = CLTLocFormula.getAnd(this.getInitialStateConstraint(system),
				this.getInitialVariableValuesConstraint(system),
				globallyOperator.apply(CLTLocFormula.getAnd(
						this.getInvariant(system),
						this.getTransitionConstraint(system),
						this.stateChangesImpliesTransition(system), this.resetImpliesTransition(system),
						this.variableChangeImpliesTransition(system), this.eachAutomatonIsInOneOfItsStates(system))),
				this.finallyOneTransitionPerformed(system));
		
		CLTLocFormula semantic = CLTLocFormula.getAnd(
				globallyOperator
						.apply(CLTLocFormula.getAnd(
								this.labeIsAreTrueOnlyInTheStates(system, propositionsOfInterest),
								this.intervalsAreRightClosed(propositionsOfInterest),
								this.variablesAreTrueOnlyIfAssignmentsAreSatisfied(system, atomicpropositionsVariable),
								this.variableIntervalsAreRightClosed(atomicpropositionsVariable))),
				this.initialFirstValues(system, propositionsOfInterest),
				this.initAssignments(system, atomicpropositionsVariable));
		testTimer.stop();
		writer.write("variable1: " + testTimer.elapsed(TimeUnit.MILLISECONDS) + "\n");

		return CLTLocFormula.getAnd(clockConstraint
				, automaton
				, semantic
				);
	}
	

	protected CLTLocFormula getClock1(SystemDecl system) {

		Set<Clock> clocks = system.getGlobalClocks();
	

		CLTLocFormula globalClocks = clocks.stream().map(c -> {
			return (CLTLocFormula) CLTLocFormula.getAnd(
					new CLTLocRelation(new CLTLocClock(c.getName() + "_0"), new Constant(0), Relation.EQ),
					new CLTLocRelation(new CLTLocClock(c.getName() + "_1"), new Constant(0), Relation.GE),
					new CLTLocNegation(new CLTLocSelector(c.getName() + "_v")));

		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula localClocks = system.getTimedAutomata().stream().map(ta -> ta.getLocalClocks().stream().map(c -> {
			String prefix = ta.getIdentifier()+"_";
			return (CLTLocFormula) CLTLocFormula.getAnd(
					new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_0"), new Constant(0), Relation.EQ),
					new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_1"), new Constant(0), Relation.GE),
					new CLTLocNegation(new CLTLocSelector(prefix + c.getName() + "_v")));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator)).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return CLTLocFormula.getAnd(globalClocks, localClocks);
	}

	protected CLTLocFormula getClock2(SystemDecl system) {

		Set<Clock> clocks = system.getGlobalClocks();

		CLTLocFormula globalClocks = clocks.stream().map(c -> {
			return (CLTLocFormula) new CLTLocGlobally(new CLTLocImplies(
					new CLTLocRelation(new CLTLocClock(c.getName() + "_0"), zero, Relation.EQ),
					new CLTLocNext(new CLTLocRelease(
							new CLTLocRelation(new CLTLocClock(c.getName() + "_1"), zero, Relation.EQ),
							new CLTLocConjunction(new CLTLocNegation(new CLTLocSelector(c.getName() + "_v")),
									new CLTLocRelation(new CLTLocClock(c.getName() + "_0"), zero, Relation.GE))))));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		CLTLocFormula localClocks = system.getTimedAutomata().stream().map(ta -> ta.getLocalClocks().stream().map(c -> {
			String prefix = ta.getIdentifier()+"_";
			return (CLTLocFormula) new CLTLocGlobally(new CLTLocImplies(
					new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_0"), zero, Relation.EQ),
					new CLTLocNext(new CLTLocRelease(
							new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_1"), zero, Relation.EQ),
							new CLTLocConjunction(new CLTLocNegation(new CLTLocSelector(prefix + c.getName() + "_v")),
									new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_0"), zero,
											Relation.GE))))));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator)).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return CLTLocFormula.getAnd(globalClocks, localClocks);
	}

	protected CLTLocFormula getClock3(SystemDecl system) {

		Set<Clock> clocks = system.getClockDeclarations().stream().map(c -> (Clock) new Clock(c.getId()))
				.collect(Collectors.toSet());
		
		CLTLocFormula globalClocks = clocks.stream()
				.map(c -> (CLTLocFormula) new CLTLocGlobally(new CLTLocImplies(
						new CLTLocRelation(new CLTLocClock(c.getName() + "_1"), zero, Relation.EQ),
							new CLTLocNext(
								new CLTLocRelease(
										new CLTLocRelation(new CLTLocClock(c.getName() + "_0"), zero,
												Relation.EQ),
										new CLTLocConjunction(new CLTLocSelector(c.getName() + "_v"),
												new CLTLocRelation(new CLTLocClock(c.getName() + "_1"), zero,
														Relation.GE)))))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula localClocks = system.getTimedAutomata().stream().map(ta -> ta.getLocalClocks().stream().map(c -> {
			String prefix = ta.getIdentifier()+"_";
			return (CLTLocFormula) new CLTLocGlobally(
					new CLTLocImplies(
							new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_1"), zero, Relation.EQ),
							new CLTLocNext(new CLTLocRelease(
									new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_0"), zero,
											Relation.EQ),
									new CLTLocConjunction(new CLTLocSelector(prefix + c.getName() + "_v"),
											new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_1"), zero,
													Relation.GE))))));
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
		return (CLTLocFormula) system.getTimedAutomata()
				.stream().map(
						ta -> (CLTLocFormula) ta.getStates().stream()
								.map(s1 -> (CLTLocFormula) ta.getStates().stream().filter(s2 -> !s2.equals(s1))
										.map(s2 -> (CLTLocFormula) implicationOperator.apply(
												conjunctionOperator.apply(
														new CLTLocEQRelation(
																new formulae.cltloc.atoms.BoundedVariable("s" + ta.getId(), this.getPossibleStateVariableValues(ta)),
																new Constant(
																		this.getId(ta, s1))),
														new CLTLocNext(new CLTLocEQRelation(
																new formulae.cltloc.atoms.BoundedVariable("s" + ta.getId(), this.getPossibleStateVariableValues(ta)),
																new Constant(this.getId(ta, s2))))),
												ta.getTransitions().stream()
														.filter(t1 -> t1.getSource().equals(s1)
																&& t1.getDestination().equals(s2))
														.map(t1 -> (CLTLocFormula) new CLTLocEQRelation(
																new formulae.cltloc.atoms.BoundedVariable("t" + ta.getId(), this.getPossibleTransitionVariableValues(ta)),
																new Constant(t1.getId())))
														.reduce(CLTLocFormula.FALSE, disjunctionOperator)))
										.reduce(CLTLocFormula.TRUE, conjunctionOperator))
								.reduce(CLTLocFormula.TRUE, conjunctionOperator))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}
	
	
	
	
	
	protected CLTLocFormula getInvariant(SystemDecl system) {
		return (CLTLocFormula) system.getTimedAutomata()
				.stream().map(ta -> 
						
						(CLTLocFormula) ta.getStates().stream().map(s ->
						(CLTLocFormula) 
						implicationOperator.apply(
								new CLTLocEQRelation(new formulae.cltloc.atoms.BoundedVariable("s" + ta.getId(), this.getPossibleStateVariableValues(ta)),
								new Constant(this.getId(ta, s)))
								,
								new CLTLocNext(s.getInvariant().accept(ta, new NormalInvariantVisitor()))))
						.reduce(CLTLocFormula.TRUE, conjunctionOperator)
						)
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}

	protected CLTLocFormula eachAutomatonIsInOneOfItsStates(SystemDecl system) {

		return (CLTLocFormula) system.getTimedAutomata().stream().map(ta -> (CLTLocFormula) ta.getStates().stream()
				.map(s1 -> (CLTLocFormula) new CLTLocEQRelation(new formulae.cltloc.atoms.BoundedVariable("s" + ta.getId(), this.getPossibleStateVariableValues(ta)),
						new Constant(this.getId(ta, s1))))
				.reduce(CLTLocFormula.FALSE, disjunctionOperator)).reduce(CLTLocFormula.TRUE, conjunctionOperator);
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
			return (CLTLocFormula) implicationOperator.apply(
					new CLTLocNext(
							new CLTLocDisjunction(
									new CLTLocRelation(new CLTLocClock(c.getName() + "_0"), zero, Relation.EQ),
									new CLTLocRelation(new CLTLocClock(c.getName() + "_1"), zero, Relation.EQ))),
					(CLTLocFormula) system.getTimedAutomata().stream().filter(ta -> !ta.getLocalClocks().contains(c))
							.map(ta -> ta.getTransitions().stream().filter(t -> t.getAssignement().assign(c))
									.map(t -> (CLTLocFormula) new CLTLocEQRelation(
											new formulae.cltloc.atoms.BoundedVariable("t" + ta.getId(), this.getPossibleTransitionVariableValues(ta)),
											new Constant(t.getId())))
									.reduce(CLTLocFormula.FALSE, disjunctionOperator))
							.reduce(CLTLocFormula.FALSE, disjunctionOperator)

			);
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula localClocks = system.getTimedAutomata().stream().map(ta -> ta.getLocalClocks().stream().map(c -> {
			String prefix = ta.getIdentifier()+"_";
			return (CLTLocFormula) implicationOperator.apply(
					new CLTLocNext(
							new CLTLocDisjunction(
									new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_0"), zero, Relation.EQ),
									new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "_1"), zero,
											Relation.EQ))),
					ta.getTransitions().stream().filter(t -> t.getAssignement().assign(c))
							.map(t -> (CLTLocFormula) new CLTLocEQRelation(
									new formulae.cltloc.atoms.BoundedVariable("t" + ta.getId(), this.getPossibleTransitionVariableValues(ta)), new Constant(t.getId())))
							.reduce(CLTLocFormula.FALSE, disjunctionOperator));
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

		CLTLocFormula globalVariables = variables.stream().map(v -> 
			{
				
				KeepVariableConstant keepConstant=
						system.isBounded(v.getName()) ?
								new KeepBoundedVariableConstant(
										new formulae.cltloc.atoms.BoundedVariable(v.getName(), system.getBound(v.getName())))
								:
							new KeepVariableConstant(
									new formulae.cltloc.atoms.Variable(v.getName()))
							;
						
				return implicationOperator.apply(
				negationOperator.apply(keepConstant),
				system.getTimedAutomata().stream().filter(ta -> !ta.getLocalVariables().contains(v))
						.map(ta -> (CLTLocFormula) ta.getTransitions().stream()
								.filter(t -> t.getAssignement().assignedVariables().contains(v))
								.map(t -> (CLTLocFormula) new CLTLocEQRelation(
										new formulae.cltloc.atoms.BoundedVariable("t" + ta.getId(), this.getPossibleTransitionVariableValues(ta)), new Constant(t.getId())))
								.reduce(CLTLocFormula.FALSE, disjunctionOperator))
						.reduce(CLTLocFormula.FALSE, disjunctionOperator));
				}
				)
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula localVariables = system.getTimedAutomata().stream()
				.map(ta -> ta.getLocalVariables().stream().map(v -> 
					{ 
						KeepVariableConstant keepConstant=
							system.isBounded(v.getName()) ?
									new KeepBoundedVariableConstant(
											new formulae.cltloc.atoms.BoundedVariable(ta.getIdentifier()+"_"+v.getName(), system.getBound(v.getName())))
									:
								new KeepVariableConstant(
										new formulae.cltloc.atoms.Variable(ta.getIdentifier()+"_"+v.getName()));
											
							return implicationOperator.apply(
										negationOperator
												.apply(keepConstant),
										(CLTLocFormula) ta.getTransitions().stream()
												.filter(t -> t.getAssignement().assignedVariables().contains(v))
												.filter(t -> t.getAssignement().assignedVariables().contains(v))
												.map(t -> (CLTLocFormula) new CLTLocEQRelation(
														new formulae.cltloc.atoms.BoundedVariable("t" + ta.getId(), this.getPossibleTransitionVariableValues(ta)), new Constant(t.getId())))
												.reduce(CLTLocFormula.FALSE, disjunctionOperator));
										
						}).reduce(CLTLocFormula.TRUE, conjunctionOperator)
				)
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return CLTLocFormula.getAnd(localVariables, globalVariables);
	}

	/**
	 * encodes the liveness condition phisem1
	 * 
	 * @param system
	 *            the system to be considered
	 * @return the liveness condition phisem1
	 */
	protected CLTLocFormula finallyOneTransitionPerformed(SystemDecl system) {

		return system.getTimedAutomata().stream().map(ta -> globallyOperator.apply(eventuallyOperator.apply(ta
				.getTransitions().stream()
				.map(t -> (CLTLocFormula) new CLTLocEQRelation(new formulae.cltloc.atoms.BoundedVariable("t" + ta.getId(), this.getPossibleTransitionVariableValues(ta)),
						new Constant(t.getId())))
				.reduce(CLTLocFormula.FALSE, disjunctionOperator)
				)
				)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	protected CLTLocFormula labeIsAreTrueOnlyInTheStates(SystemDecl system, Set<StateAP> propositionsOfInterest) {

		return (CLTLocFormula) propositionsOfInterest.stream().map(ap -> (CLTLocFormula) iffOperator.apply(
				rest.apply(ap.getEncodingSymbol()),
				system.getTimedAutomata().stream().filter(ta -> ta.getIdentifier().equals(ap.getAutomata())).map(ta -> (CLTLocFormula) ta.getStates().stream()
						.filter(Objects::nonNull).filter(s -> s.getStringId().equals(ap.getState()))
						.map(s -> (CLTLocFormula) new CLTLocEQRelation(
								new formulae.cltloc.atoms.BoundedVariable("s" + ta.getId(), this.getPossibleStateVariableValues(ta)), new Constant(this.getId(ta, s))))
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

		return propositionsOfInterest.stream().map(ap -> iffOperator.apply(
				first.apply(ap.getEncodingSymbol()),
				(CLTLocFormula) system.getTimedAutomata().stream().filter(ta -> ta.getIdentifier().equals(ap.getAutomata()))
				.map(
						ta -> (CLTLocFormula) ta.getStates().stream()
						.filter(s -> s.getStringId().equals(ap.getState()))
						.map(s -> (CLTLocFormula) new CLTLocEQRelation(
								new formulae.cltloc.atoms.BoundedVariable("s" + ta.getId(), this.getPossibleStateVariableValues(ta)), new Constant(this.getId(ta, s)))
								
								).reduce(CLTLocFormula.TRUE, conjunctionOperator)
						)
						.reduce(CLTLocFormula.TRUE, conjunctionOperator)))
						.reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	protected CLTLocFormula variablesAreTrueOnlyIfAssignmentsAreSatisfied(SystemDecl system,
			Set<VariableAssignementAP> atomicpropositionsVariable) {

		return (CLTLocFormula) atomicpropositionsVariable
				.stream().map(
						ap -> 
						{
							formulae.cltloc.atoms.Variable variable=system.isBounded(ap.getVariable().getName()) ?
									new formulae.cltloc.atoms.BoundedVariable(
											(ap.getAutomaton() != null ? ap.getAutomaton() + "_" : "")
													+ ap.getVariable().getName(), system.getBound(ap.getVariable().getName()))
									:
										new formulae.cltloc.atoms.Variable(
												(ap.getAutomaton() != null ? ap.getAutomaton() + "_" : "")
														+ ap.getVariable().getName());
									;
								return (CLTLocFormula) iffOperator.apply(rest.apply(ap.getEncodingSymbol()),
								(CLTLocFormula) new CLTLocEQRelation(
										
										variable,
										new Constant(ap.getValue().value)));
						}
						)
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}

	protected CLTLocFormula variableIntervalsAreRightClosed(Set<VariableAssignementAP> atomicpropositionsVariable) {
		return (CLTLocFormula) atomicpropositionsVariable.stream()
				.map(ap -> iffOperator.apply(rest.apply(ap.getEncodingSymbol()),
						nextOperator.apply(first.apply(ap.getEncodingSymbol()))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	protected CLTLocFormula initAssignments(SystemDecl system, Set<VariableAssignementAP> atomicpropositionsVariable) {

		return (CLTLocFormula) atomicpropositionsVariable
				.stream().map(
						ap ->{
							
							formulae.cltloc.atoms.Variable variable=
									system.isBounded(ap.getVariable().getName()) ?
											new formulae.cltloc.atoms.BoundedVariable(
													(ap.getAutomaton() != null ? ap.getAutomaton() + "_" : "")
													+ ap.getVariable().getName(), system.getBound(ap.getVariable().getName()))
											:
									new formulae.cltloc.atoms.Variable(
									(ap.getAutomaton() != null ? ap.getAutomaton() + "_" : "")
									+ ap.getVariable().getName());
									
							return (CLTLocFormula) iffOperator.apply(first.apply(ap.getEncodingSymbol()),
						
								(CLTLocFormula) new CLTLocEQRelation(
										variable,
										new Constant(ap.getValue().value)));
						}
						)
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}
}
