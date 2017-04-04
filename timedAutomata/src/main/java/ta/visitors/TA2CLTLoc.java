package ta.visitors;

import java.io.PrintStream;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.KeepVariableConstant;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.binary.CLTLocRelease;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.relations.CLTLocRelation;
import formulae.cltloc.relations.Relation;
import ta.AP;
import ta.Clock;
import ta.StateAP;
import ta.SystemDecl;
import ta.TA;
import ta.Variable;
import ta.VariableAssignementAP;
import ta.state.ExpInvariant;
import ta.state.State;
import ta.transition.Transition;
import ta.transition.guard.ClockConstraint;

public class TA2CLTLoc {

	private CLTLocFormula variable1;
	private CLTLocFormula variable2;
	private CLTLocFormula variable3;

	private CLTLocFormula clock1;
	private CLTLocFormula clock2;
	private CLTLocFormula clock3;

	private CLTLocFormula phi1;
	private CLTLocFormula phi2;
	private CLTLocFormula phi3;
	private CLTLocFormula phi4;
	private CLTLocFormula phi5;
	private CLTLocFormula phi6;
	private CLTLocFormula phi7;

	private static final Constant zero = new Constant(0);

	public static final BinaryOperator<CLTLocFormula> conjunctionOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		if (left.equals(CLTLocFormula.TRUE)) {
			return right;
		}
		if (right.equals(CLTLocFormula.TRUE)) {
			return left;
		}
		return new CLTLocConjunction(left, right);
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

	public static final BinaryOperator<CLTLocFormula> implicationOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");
		if (right.equals(CLTLocFormula.TRUE)) {
			return CLTLocFormula.TRUE;
		}
		return new CLTLocImplies(left, right);
	};

	public static final Function<Entry<TA, ClockConstraint>, CLTLocFormula> clockConstraint2CLTLoc = (entry) -> {
		return entry.getValue().accept(new TA2CLTLocVisitor(entry.getKey()));
	};

	public static final UnaryOperator<CLTLocFormula> negationOperator = CLTLocNegation::new;
	public static final UnaryOperator<CLTLocFormula> globallyOperator = CLTLocGlobally::new;
	public static final UnaryOperator<CLTLocFormula> nextOperator = (formula) -> {
		Preconditions.checkNotNull(formula, "The formula cannot be null");

		return new CLTLocNext(formula);
	};
	
	public static final UnaryOperator<CLTLocFormula> Y = CLTLocYesterday::new;


	private static final Function<AP, CLTLocFormula> ap2CLTLocRESTAp = ap -> new CLTLocAP("H_" + ap.getName());
	private static final Function<AP, CLTLocFormula> ap2CLTLocFIRSTAp = ap -> new CLTLocAP("P_" + ap.getName());

	private static final Function<Entry<TA, State>, CLTLocFormula> state2Ap = (s) -> new CLTLocAP(
			s.getKey().getIdentifier() + "." + s.getValue().getId());

	public CLTLocFormula convert(SystemDecl system, TA ta, Set<AP> propositionsOfInterest, boolean integer) {

		this.variable1 = this.getVariable1(ta);
		this.variable2 = this.getVariable2(ta);
		this.variable3 = this.getVariable3(ta);

		CLTLocFormula variableconst = conjunctionOperator.apply(this.variable1,
				conjunctionOperator.apply(this.variable2, this.variable3));

		this.clock1 = this.getClock1(system, ta);
		this.clock2 = this.getClock2(system, ta);
		this.clock3 = this.getClock3(system, ta);

		CLTLocFormula clockconst = conjunctionOperator.apply(this.clock1,
				conjunctionOperator.apply(this.clock2, this.clock3));

		phi1 = this.getPhi1(system, ta);
		phi2 = this.getPhi2(ta);
		phi3 = this.getPhi3(ta);

		phi4 = this.getPhi4(system, ta);

		phi5 = this.getPhi5(ta, propositionsOfInterest, integer);
		phi6 = this.getPhi6(ta, propositionsOfInterest, integer);
		phi7 = this.getPhi7(ta, propositionsOfInterest, integer);
		CLTLocFormula taFormula = CLTLocFormula.getAnd(phi1, phi2, phi3, phi4, phi5, phi6, phi7);


		return Y.apply(CLTLocFormula.getAnd(variableconst, clockconst, taFormula));

	}

	private CLTLocFormula getVariable1(TA ta) {

		Set<Variable> variables = ta.getVariables();

		CLTLocFormula ret = variables.stream()
				.map(c -> (CLTLocFormula) new CLTLocRelease(
						new CLTLocRelation(new formulae.cltloc.atoms.Variable(c.getName() + "_v"), new Constant(1),
								Relation.EQ),
						new CLTLocConjunction(
								new CLTLocRelation(
										new formulae.cltloc.atoms.Variable(c.getName() + "_v"), new Constant(0),
										Relation.EQ),
								new CLTLocRelation(new formulae.cltloc.atoms.Variable(c.getName() + "0"),
										new Constant(ta.getInitialValue(c).value), Relation.EQ))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return ret;
	}

	private CLTLocFormula getVariable2(TA ta) {

		Set<Variable> variables = ta.getVariables();

		CLTLocFormula ret = variables.stream().map(c -> (CLTLocFormula) new CLTLocGlobally(new CLTLocImplies(
				new CLTLocRelation(new formulae.cltloc.atoms.Variable(c.getName() + "_v"), new Constant(0),
						Relation.EQ),
				new CLTLocRelease(
						new CLTLocRelation(new formulae.cltloc.atoms.Variable(c.getName() + "_v"), new Constant(1),
								Relation.EQ),
						new CLTLocConjunction(
								new CLTLocRelation(new formulae.cltloc.atoms.Variable(c.getName() + "_v"),
										new Constant(0), Relation.EQ),
								new KeepVariableConstant(new formulae.cltloc.atoms.Variable(c.getName() + "0")))))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return ret;
	}

	private CLTLocFormula getVariable3(TA ta) {

		Set<Variable> variables = ta.getVariables();

		CLTLocFormula ret = variables.stream().map(c -> (CLTLocFormula) new CLTLocGlobally(new CLTLocImplies(
				new CLTLocRelation(new formulae.cltloc.atoms.Variable(c.getName() + "_v"), new Constant(1),
						Relation.EQ),
				new CLTLocRelease(
						new CLTLocRelation(new formulae.cltloc.atoms.Variable(c.getName() + "_v"), new Constant(0),
								Relation.EQ),
						new CLTLocConjunction(
								new CLTLocRelation(new formulae.cltloc.atoms.Variable(c.getName() + "_v"),
										new Constant(1), Relation.EQ),
								new KeepVariableConstant(new formulae.cltloc.atoms.Variable(c.getName() + "1")))))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return ret;
	}

	private CLTLocFormula getClock2(SystemDecl system, TA ta) {

		Set<Clock> clocks = ta.getClocks();

		CLTLocFormula f1 = clocks.stream().map(c -> {
			String prefix = ta.getIdentifier() + ".";
			return (CLTLocFormula) new CLTLocGlobally(new CLTLocImplies(
					new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "0"), zero, Relation.EQ),
					new CLTLocNext(new CLTLocRelease(
							new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "1"), zero, Relation.EQ),
							new CLTLocConjunction(
									new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getName() + "_v"),
											zero, Relation.EQ),
									new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "0"), zero,
											Relation.GE))))));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula f2 = system.getClockDeclarations().stream()
				.map(c -> (CLTLocFormula) new CLTLocGlobally(new CLTLocImplies(
						new CLTLocRelation(new CLTLocClock(c.getId() + "0"), zero, Relation.EQ), new CLTLocNext(
								new CLTLocRelease(
										new CLTLocRelation(new CLTLocClock(c.getId() + "1"), zero,
												Relation.EQ),
										new CLTLocConjunction(
												new CLTLocRelation(new formulae.cltloc.atoms.Variable(c.getId() + "_v"),
														zero, Relation.EQ),
												new CLTLocRelation(new CLTLocClock(c.getId() + "0"), zero,
														Relation.GE)))))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return CLTLocFormula.getAnd(f1, f2);
	}

	private CLTLocFormula getClock3(SystemDecl system, TA ta) {

		Set<Clock> clocks = ta.getClocks();

		CLTLocFormula f1 = clocks.stream().map(c -> {
			String prefix = ta.getIdentifier() + ".";
			return (CLTLocFormula) new CLTLocGlobally(new CLTLocImplies(
					new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "1"), zero, Relation.EQ),
					new CLTLocNext(new CLTLocRelease(
							new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "0"), zero, Relation.EQ),
							new CLTLocConjunction(
									new CLTLocRelation(
											new formulae.cltloc.atoms.Variable(prefix + c.getName() + "_v"),
											new Constant(1), Relation.EQ),
									new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "1"), zero,
											Relation.GE))))));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula f2 = system.getClockDeclarations().stream()
				.map(c -> (CLTLocFormula) new CLTLocGlobally(new CLTLocImplies(
						new CLTLocRelation(new CLTLocClock(c.getId() + "1"), zero, Relation.EQ), new CLTLocNext(
								new CLTLocRelease(
										new CLTLocRelation(new CLTLocClock(c.getId() + "0"), zero,
												Relation.EQ),
										new CLTLocConjunction(
												new CLTLocRelation(new formulae.cltloc.atoms.Variable(c.getId() + "_v"),
														new Constant(1), Relation.EQ),
												new CLTLocRelation(new CLTLocClock(c.getId() + "1"), zero,
														Relation.GE)))))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return CLTLocFormula.getAnd(f1, f2);
	}

	private CLTLocFormula getClock1(SystemDecl system, TA ta) {

		Set<Clock> clocks = ta.getClocks();

		CLTLocFormula f1 = clocks.stream().map(c -> {
			String prefix = ta.getIdentifier() + ".";
			return (CLTLocFormula) new CLTLocRelease(
					new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "1"), new Constant(0), Relation.EQ),
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getName() + "_v"),
									new Constant(0), Relation.EQ),
							new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "0"), new Constant(0),
									Relation.GE)));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula f2 = system.getClockDeclarations().stream()
				.map(c -> (CLTLocFormula) new CLTLocRelease(
						new CLTLocRelation(new CLTLocClock(c.getId() + "1"), new Constant(0), Relation.EQ),
						new CLTLocConjunction(
								new CLTLocRelation(new formulae.cltloc.atoms.Variable(c.getId() + "_v"),
										new Constant(0), Relation.EQ),
								new CLTLocRelation(new CLTLocClock(c.getId() + "0"), new Constant(0), Relation.GE))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return CLTLocFormula.getAnd(f1, f2);
	}

	private CLTLocFormula getPhi1(SystemDecl system, TA ta) {

		CLTLocFormula f1 = new CLTLocGlobally(ta.getStates().stream().map(s -> implicationOperator.apply(
				state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, s)),
				ta.getStates().stream().filter(s1 -> !s1.equals(s))
						.map(s1 -> negationOperator.apply(state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, s1))))
						.reduce(conjunctionOperator).orElse(state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, s)))))
				.reduce(conjunctionOperator).orElse(CLTLocFormula.TRUE));

		return CLTLocFormula.getAnd(f1);
	}

	private CLTLocFormula getPhi2(TA ta) {

		// the automaton is in its initial statate
		CLTLocFormula initState = state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, ta.getInitialState()));
		// the initial assignments olds

		CLTLocFormula initAssignment = ta.getVariables().stream().map(v -> (CLTLocFormula)

		CLTLocFormula.getAnd(
				new CLTLocRelation(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "." + v.getName() + "_v"),
						new Constant(0), Relation.EQ),
				new CLTLocRelation(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "." + v.getName() + "0"),
						new Constant(ta.getInitialValue(v).value), Relation.EQ))

		).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return CLTLocFormula.getAnd(initState, initAssignment);
	}

	private CLTLocFormula getPhi3(TA ta) {

		if (ta.getStates().size() > 0) {

			CLTLocFormula subFormulaPhi3 = ta.getStates().stream().map(s ->

			{

				if (s.getInvariant().accept(new TA2CLTLocVisitor(ta)).equals(CLTLocFormula.TRUE)) {
					return (CLTLocFormula) CLTLocFormula.TRUE;
				} else {
					return (CLTLocFormula) implicationOperator.apply(state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, s)),
							new TA2CLTLocVisitor(ta).visit((ExpInvariant)s.getInvariant(), s));
				}
			}

			).reduce(CLTLocFormula.TRUE, conjunctionOperator);

			return globallyOperator.apply(subFormulaPhi3);
		} else {

			return CLTLocFormula.TRUE;
		}
	}

	private CLTLocFormula getPhi5(TA ta, Set<AP> propositionsOfInterest, boolean assignement) {

		 final Set<String> namesOfStates=ta.getStates().stream().map(s -> s.getId()).collect(Collectors.toSet());
		
		if (assignement) {
			CLTLocFormula phi5StatesSubformula = propositionsOfInterest.stream().map(ap -> {
				
				
				if(ap instanceof VariableAssignementAP){
					VariableAssignementAP tmp = (VariableAssignementAP) ap;
				return (CLTLocFormula) new CLTLocIff(
						new CLTLocAP(
								"H_" + tmp.getEncodingSymbol()),
						new CLTLocDisjunction(
								new CLTLocConjunction(
										new CLTLocRelation(
												new formulae.cltloc.atoms.Variable(tmp.getVariable().getName() + "_v"),
												new Constant(0), Relation.EQ),
										new CLTLocRelation(
												new formulae.cltloc.atoms.Variable(tmp.getVariable().getName() + "0"),
												new Constant(tmp.getValue().value), Relation.EQ)),
								new CLTLocConjunction(
										new CLTLocRelation(
												new formulae.cltloc.atoms.Variable(tmp.getVariable().getName() + "_v"),
												new Constant(1), Relation.EQ),
										new CLTLocRelation(
												new formulae.cltloc.atoms.Variable(tmp.getVariable().getName() + "1"),
												new Constant(tmp.getValue().value), Relation.EQ))));
				}
				else{
					
					 return (CLTLocFormula) 
							new CLTLocIff(
									new CLTLocAP(ap.getName()), 
							new CLTLocAP(
							"H_" +ap.getName()));
				}
			}).reduce(CLTLocFormula.TRUE, conjunctionOperator);
			
			return new CLTLocGlobally(phi5StatesSubformula);
		} else {
			if (ta.getStates().size() > 0) {

				
				CLTLocFormula phi5StatesSubformula = ta.getStates().stream()
						.map((s) -> implicationOperator.apply(state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, s)),
								conjunctionOperator.apply(
										s.getValid(propositionsOfInterest).stream().map(ap2CLTLocRESTAp)
												.reduce(conjunctionOperator).orElse(CLTLocFormula.TRUE),
										s.getValid(propositionsOfInterest).stream()
												.map((ap) -> negationOperator.apply(ap2CLTLocRESTAp.apply(ap)))
												.reduce(conjunctionOperator).orElse(CLTLocFormula.TRUE))))
						.reduce(CLTLocFormula.TRUE, conjunctionOperator);
				return globallyOperator.apply(phi5StatesSubformula);
			} else {

				return CLTLocFormula.TRUE;
			}
		}
	}

	private CLTLocFormula getPhi4(SystemDecl system, TA ta) {

		Set<Clock> clocks = ta.getClocks();
		Set<CLTLocFormula> clockFormulae = clocks.stream().map(c -> {
			String prefix = ta.getIdentifier() + ".";
			return new CLTLocDisjunction(
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getName()+"_v"), new Constant(0),
									Relation.EQ),
							new CLTLocRelation(new CLTLocClock(prefix + c.getName()+"0"), new Constant(0), Relation.GE)),
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getName()+"_v"), new Constant(1),
									Relation.EQ),
							new CLTLocRelation(new CLTLocClock(prefix + c.getName()+ "1"), new Constant(0), Relation.GE)));
		}).collect(Collectors.toSet());

		Set<Clock> otherClocks = ta.getAllclocks();
		otherClocks.removeAll(clocks);
		clockFormulae.addAll(otherClocks.stream().map(c -> {
			String prefix = "";
			return new CLTLocDisjunction(
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getName()+ "_v"), new Constant(0),
									Relation.EQ),
							new CLTLocRelation(new CLTLocClock(prefix   + c.getName()+ "0"), new Constant(0), Relation.GE)),
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix  + c.getName()+ "_v"), new Constant(1),
									Relation.EQ),
							new CLTLocRelation(new CLTLocClock(prefix  + c.getName()+ "1"), new Constant(0), Relation.GE)));
		}).collect(Collectors.toSet()));

		CLTLocFormula clocksGeZero = clockFormulae.stream().reduce(CLTLocFormula.TRUE, conjunctionOperator);

		Set<Variable> variables = ta.getVariables();
		Set<CLTLocFormula> keepConstantVariables = variables.stream()
				.map(v -> new CLTLocDisjunction(
						new CLTLocConjunction(
								new CLTLocRelation(
										new formulae.cltloc.atoms.Variable(
												ta.getIdentifier() + "." + v.getName() + "_v"),
										new Constant(0), Relation.EQ),
								new KeepVariableConstant(new formulae.cltloc.atoms.Variable(
										ta.getIdentifier() + "." + v.getName() + "0"))),
						new CLTLocConjunction(
								new CLTLocRelation(
										new formulae.cltloc.atoms.Variable(
												ta.getIdentifier() + "." + v.getName() + "_v"),
										new Constant(1), Relation.EQ),
								new KeepVariableConstant(new formulae.cltloc.atoms.Variable(
										ta.getIdentifier() + "." + v.getName() + "1")))))
				.collect(Collectors.toSet());

		Set<Variable> otherVariables = ta.getAllVariables();
		otherVariables.removeAll(variables);

		keepConstantVariables.addAll(otherVariables.stream()
				.map(v -> new CLTLocDisjunction(
						new CLTLocConjunction(
								new CLTLocRelation(new formulae.cltloc.atoms.Variable(v.getName() + "_v"),
										new Constant(0), Relation.EQ),
								new KeepVariableConstant(new formulae.cltloc.atoms.Variable(v.getName() + "0"))),
						new CLTLocConjunction(new CLTLocRelation(new formulae.cltloc.atoms.Variable(v.getName() + "_v"),
								new Constant(1), Relation.EQ),
								new KeepVariableConstant(new formulae.cltloc.atoms.Variable(v.getName() + "1")))))
				.collect(Collectors.toSet()));

		CLTLocFormula keepConstantVariablesFormula = keepConstantVariables.stream().reduce(CLTLocFormula.TRUE,
				conjunctionOperator);

		CLTLocFormula ret = ta.getStates().stream().map(state -> implicationOperator.apply(
				state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, state)),
				nextOperator.apply(disjunctionOperator.apply(
						conjunctionOperator.apply(state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, state)),
								conjunctionOperator.apply(clocksGeZero, keepConstantVariablesFormula)),
						ta.getOutgoingTransitions(state).stream()
								.map(t -> conjunctionOperator.apply(
										state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, t.getDestination())),
										conjunctionOperator.apply(this.getGuardConditions(ta, t, variables, clocks),
												this.getAssignConditions(ta, t, variables, clocks))))
								.reduce(CLTLocFormula.FALSE, disjunctionOperator)))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);
		return globallyOperator.apply(ret);
		 
	}

	private CLTLocFormula getGuardConditions(TA ta, Transition t, Set<Variable> variables, Set<Clock> clocks) {

		CLTLocFormula formula1 = t.getGuard().getClockConstraints().stream()
				.map(constraint -> clockConstraint2CLTLoc.apply(new AbstractMap.SimpleEntry<>(ta, constraint)))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula formula2 = t.getGuard().getConditions().stream().map(c -> c.accept(new TA2CLTLocVisitor(ta)))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return conjunctionOperator.apply(formula1, formula2);
	}

	private CLTLocFormula getAssignConditions(TA ta, Transition t, Set<Variable> variables, Set<Clock> clocks) {

		Set<String> clocksId = clocks.stream().map(c -> c.getName()).collect(Collectors.toSet());
		Set<String> assignedClocks = t.getAssignement().getClockassigments().stream().map(c -> c.getClock().getName())
				.collect(Collectors.toSet());
		Set<String> notAssignedClocks = new HashSet<>(clocksId);
		notAssignedClocks.removeAll(assignedClocks);

		CLTLocFormula notAssignedClocksCLTLoc = notAssignedClocks.stream().map(c -> {

				String prefix = ta.getClocks().contains(new Clock(c)) ? ta.getIdentifier() + "." : "";
			return (CLTLocFormula) new CLTLocDisjunction(
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c + "_v"), new Constant(0),
									Relation.EQ),
							new CLTLocRelation(new CLTLocClock(prefix + c + "0"), new Constant(0), Relation.GE)
							
					)
					,
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c + "_v"), new Constant(1),
									Relation.EQ),
									new CLTLocRelation(new CLTLocClock(prefix + c + "1"), new Constant(0), Relation.GE)
							)
							
						
					);
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula assignedClocksCLTLoc = t.getAssignement().getClockassigments().stream().map(c -> {

			String prefix = ta.getClocks().contains(c.getClock()) ? ta.getIdentifier() + "." : "";

			return (CLTLocFormula) new CLTLocDisjunction(
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getClock().getName() + "_v"), new Constant(0),
									Relation.EQ),
							new CLTLocRelation(new CLTLocClock(prefix + c.getClock().getName() + "1"), new Constant(c.getValue().value),
										Relation.EQ)
								
									)
							,
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getClock().getName() + "_v"), new Constant(1),
									Relation.EQ),
							new CLTLocRelation(new CLTLocClock(prefix + c.getClock().getName() + "0"), new Constant(c.getValue().value),
									Relation.EQ))
							
							);
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		
		Set<String> variableId = variables.stream().map(c -> c.getName()).collect(Collectors.toSet());
		Set<String> assignedVariables = t.getAssignement().getVariableassigments().stream()
				.map(c -> c.getVariable().getName()).collect(Collectors.toSet());
		Set<String> notAssignedVariables = new HashSet<>(variableId);
		notAssignedVariables.removeAll(assignedVariables);

		CLTLocFormula notAssignedVariablesCLTLoc = notAssignedVariables.stream().map(c -> {


			String prefix = ta.getVariables().contains(new Variable(c)) ? ta.getIdentifier() + "." : "";

			return (CLTLocFormula) new CLTLocDisjunction(
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c + "_v"), new Constant(0),
									Relation.EQ),
							new KeepVariableConstant(new formulae.cltloc.atoms.Variable(prefix + c + "0"))),
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c + "_v"), new Constant(1),
									Relation.EQ),
							new KeepVariableConstant(new formulae.cltloc.atoms.Variable(prefix + c + "1"))));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);


		CLTLocFormula assignedVariablesCLTLoc = t.getAssignement().getVariableassigments().stream().map(c -> {
			
			String prefix = ta.getVariables().contains(c.getVariable()) ? ta.getIdentifier() + "." : "";

			return (CLTLocFormula) new CLTLocDisjunction(
					new CLTLocConjunction(
						new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getVariable().getName() + "_v"),
								new Constant(0), Relation.EQ),
						new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getVariable().getName() + "1"),
								new Constant(c.getValue().evaluate()), Relation.EQ)
						),
					new CLTLocConjunction(
							new CLTLocRelation(
									new formulae.cltloc.atoms.Variable(prefix + c.getVariable().getName() + "_v"),
									new Constant(1), Relation.EQ),
							new CLTLocRelation(
									new formulae.cltloc.atoms.Variable(prefix + c.getVariable().getName() + "0"),
									new Constant(c.getValue().evaluate()), Relation.EQ)
							
							
							
							));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);



		return conjunctionOperator.apply(notAssignedClocksCLTLoc, conjunctionOperator.apply(assignedClocksCLTLoc,
				conjunctionOperator.apply(notAssignedVariablesCLTLoc, assignedVariablesCLTLoc)));
	}

	private CLTLocFormula getPhi6(TA ta, Set<AP> propositionsOfInterest, boolean assignement) {
		Function<AP, CLTLocFormula> phi6Subformula = (a) -> a.accept(new TA2CLTLocVisitor(ta));

		CLTLocFormula andSubformula = propositionsOfInterest.stream().map(phi6Subformula).reduce(CLTLocFormula.TRUE,
				conjunctionOperator);
		return globallyOperator.apply(andSubformula);
	}

	private CLTLocFormula getPhi7(TA ta, Set<AP> propositionsOfInterest, boolean assignement) {
		
		final Set<String> namesOfStates=ta.getStates().stream().map(s -> s.getId()).collect(Collectors.toSet());
		
		if (assignement) {

			return propositionsOfInterest.stream().map(ap -> {
				if(ap instanceof VariableAssignementAP){
				VariableAssignementAP tmp = (VariableAssignementAP) ap;
				
				
				if(ta.getInitialValue(new Variable(tmp.getVariable().getName())).equals(tmp.getValue())){
					return ap2CLTLocFIRSTAp.apply(new AP(tmp.getEncodingSymbol()));
				}
				else{
					return TA2CLTLoc.negationOperator.apply(
							ap2CLTLocFIRSTAp.apply(new AP(tmp.getEncodingSymbol())));
				}
				
				
				}
				else{

					if(ap instanceof StateAP &&
							ta.getIdentifier().equals(((StateAP)ap).getAutomata())
							&& 
							ta.getInitialState().getId().equals(((StateAP)ap).getState())){
						return ap2CLTLocFIRSTAp.apply(new AP(ap.getName())); 
					}
					else{
						return CLTLocFormula.TRUE;
					}
				}
			}).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		} else {
			return propositionsOfInterest.stream().map(ap2CLTLocFIRSTAp).reduce(CLTLocFormula.TRUE,
					conjunctionOperator);
		}
	}

	public CLTLocFormula getPhi1() {
		return phi1;
	}

	public CLTLocFormula getPhi2() {
		return phi2;
	}

	public CLTLocFormula getPhi3() {
		return phi3;
	}

	public CLTLocFormula getPhi4() {
		return phi4;
	}

	public CLTLocFormula getPhi5() {
		return phi5;
	}

	public CLTLocFormula getPhi6() {
		return phi6;
	}

	public CLTLocFormula getPhi7() {
		return phi7;
	}

	public CLTLocFormula getClock1() {
		return clock1;
	}

	public CLTLocFormula getClock2() {
		return clock2;
	}

	public CLTLocFormula getClock3() {
		return clock3;
	}

	public CLTLocFormula getVariable1() {
		return variable1;
	}

	public CLTLocFormula getVariable2() {
		return variable2;
	}

	public CLTLocFormula getVariable3() {
		return variable3;
	}

	public void printFancy(PrintStream fancyprint) {
		fancyprint.println("variable1: " + this.variable1);
		fancyprint.println("variable2: " + this.variable2);
		fancyprint.println("variable3: " + this.variable3);

		fancyprint.println("clock1: " + this.clock1);
		fancyprint.println("clock2: " + this.clock2);
		fancyprint.println("clock3: " + this.clock3);

		fancyprint.println("phi1: " + this.phi1);
		fancyprint.println("phi2: " + this.phi2);
		fancyprint.println("phi3: " + this.phi3);
		fancyprint.println("phi4: " + this.phi4);
		fancyprint.println("phi5: " + this.phi5);
		fancyprint.println("phi6: " + this.phi6);
		fancyprint.println("phi7: " + this.phi7);
	}
}
