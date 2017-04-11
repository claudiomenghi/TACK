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

import org.omg.Messaging.SyncScopeHelper;

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

	protected CLTLocFormula variable1;

	protected CLTLocFormula clock1;
	protected CLTLocFormula clock2;
	protected CLTLocFormula clock3;

	protected CLTLocFormula phi1;
	protected CLTLocFormula phi2;
	protected CLTLocFormula phi3;
	protected CLTLocFormula phi4;
	protected CLTLocFormula phi5;
	protected CLTLocFormula phi6;
	protected CLTLocFormula phi7;
	
	protected CLTLocFormula network1;
	protected CLTLocFormula network2;
	protected CLTLocFormula network3;

	private static final Constant zero = new Constant(0);

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

		if(left.equals(CLTLocFormula.TRUE)){
			return right;
		}
		if(right.equals(CLTLocFormula.TRUE)){
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
	public static final UnaryOperator<CLTLocFormula> globallyOperator = (formula) ->
	{
		if(formula.equals(CLTLocFormula.TRUE)){
			return formula;
		}
		return new CLTLocGlobally(formula);
	};
	
	public static final UnaryOperator<CLTLocFormula> nextOperator = (formula) -> {
		Preconditions.checkNotNull(formula, "The formula cannot be null");

		return new CLTLocNext(formula);
	};
	
	public static final UnaryOperator<CLTLocFormula> Y = CLTLocYesterday::new;


	private static final Function<AP, CLTLocFormula> ap2CLTLocRESTAp = ap -> new CLTLocAP("H_" + ap.getName());
	private static final Function<AP, CLTLocFormula> ap2CLTLocFIRSTAp = ap -> new CLTLocAP("P_" + ap.getName());

	protected static final Function<Entry<TA, State>, CLTLocFormula> state2Ap = (s) -> new CLTLocAP(
			s.getKey().getIdentifier() + "_" + s.getValue().getId());

	protected static final Function<Entry<TA, String>, CLTLocFormula> sendEvent2Ap = (s) -> new CLTLocAP(
			s.getKey().getIdentifier() + "_?" + s.getValue());
	
	protected static final Function<Entry<TA, String>, CLTLocFormula> receiveEvent2Ap = (s) -> new CLTLocAP(
			s.getKey().getIdentifier() + "_!" + s.getValue());
	
	
	protected static final BinaryOperator<CLTLocFormula> xorOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		if(left.equals(CLTLocFormula.FALSE)){
			return right;
		}
		
		if(right.equals(CLTLocFormula.FALSE)){
			return left;
		}
		
		return CLTLocFormula.getOr(
					CLTLocFormula.getAnd(
						left,
						negationOperator.apply(right)
					), 
					CLTLocFormula.getAnd(
						negationOperator.apply(left),
						right
					)
			);
	};
	
	
	
	public CLTLocFormula convert(SystemDecl system, TA ta, Set<StateAP> propositionsOfInterest, Set<VariableAssignementAP> atomicpropositionsVariable) {

		this.variable1=this.getVariable1(ta);
		
		
		CLTLocFormula variableconst = this.variable1;

		this.clock1 = this.getClock1(system, ta);
		this.clock2 = this.getClock2(system, ta);
		this.clock3 = this.getClock3(system, ta);
		
		CLTLocFormula clockconst = 
				CLTLocFormula.getAnd( this.clock1,this.clock2, this.clock3);

		this.phi1 = this.getPhi1(system, ta);
		this.phi2 = this.getPhi2(ta);
		this.phi3 = this.getPhi3(ta);
		
		this.phi4 = this.getPhi4(system, ta);
		this.phi5 = this.getPhi5(ta, propositionsOfInterest, atomicpropositionsVariable);
		this.phi6 = this.getPhi6(ta, propositionsOfInterest, atomicpropositionsVariable);
		this.phi7 = this.getPhi7(ta, propositionsOfInterest, atomicpropositionsVariable);


		CLTLocFormula taFormula = CLTLocFormula.getAnd(this.phi1, this.phi2, this.phi3, this.phi4, this.phi5, this.phi6, this.phi7);


		return Y.apply(CLTLocFormula.getAnd(variableconst, clockconst, taFormula));
	
	}
	
	

protected CLTLocFormula getVariable1(TA ta) {

		CLTLocFormula f1 = 
				ta.getVariables().stream().map( 
				v ->{
				return (CLTLocFormula) 
						CLTLocFormula.getAnd(
						new CLTLocRelation(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName() + "0"), new Constant(0), Relation.EQ),
						new CLTLocRelation(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName() + "1"), new Constant(0), Relation.GE),					
						new CLTLocRelation(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName() + "_v"), new Constant(0), Relation.EQ)
						);
				}
			).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return f1;
	}

	


	protected CLTLocFormula getClock2(SystemDecl system, TA ta) {

		Set<Clock> clocks = ta.getClocks();

		CLTLocFormula f1 = clocks.stream().map(c -> {
			String prefix = ta.getIdentifier() + "_";
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

	protected CLTLocFormula getClock3(SystemDecl system, TA ta) {

		Set<Clock> clocks = ta.getClocks();

		CLTLocFormula f1 = clocks.stream().map(c -> {
			String prefix = ta.getIdentifier() + "_";
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

	
	protected CLTLocFormula getClock1(SystemDecl system, TA ta) {

		Set<Clock> clocks = ta.getClocks();

		CLTLocFormula f0 = clocks.stream().map(c -> {
			String prefix = ta.getIdentifier() + "_";
			return (CLTLocFormula) 
					CLTLocFormula.getAnd(
					new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "0"), new Constant(0), Relation.EQ),
					new CLTLocRelation(new CLTLocClock(prefix + c.getName() + "1"), new Constant(0), Relation.GE),					
					new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getName() + "_v"), new Constant(0), Relation.EQ)
					);
					
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		return f0;
	}

	
	
	
	protected CLTLocFormula getPhi1(SystemDecl system, TA ta) {

		CLTLocFormula f1 = ta.getStates().stream().map(s -> implicationOperator.apply(
				state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, s)),
				ta.getStates().stream().filter(s1 -> !s1.equals(s))
						.map(s1 -> negationOperator.apply(state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, s1))))
						.reduce(conjunctionOperator).orElse(state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, s)))))
				.reduce(conjunctionOperator).orElse(CLTLocFormula.TRUE);

		CLTLocFormula f2= ta.getStates().stream().map(s -> (CLTLocFormula) state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, s)))
				.reduce(disjunctionOperator).orElse(CLTLocFormula.FALSE);

		
		return new CLTLocGlobally(CLTLocFormula.getAnd(f1,  f2));
	}

	protected CLTLocFormula getPhi2(TA ta) {

		// the automaton is in its initial statate
		CLTLocFormula initState = state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, ta.getInitialState()));
		// the initial assignments olds

		CLTLocFormula initAssignment = ta.getVariables().stream().map(v -> (CLTLocFormula)

		CLTLocFormula.getAnd(
				new CLTLocRelation(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName() + "_v"),
						new Constant(0), Relation.EQ),
				new CLTLocRelation(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName() + "0"),
						new Constant(ta.getInitialValue(v).value), Relation.EQ))

		).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return CLTLocFormula.getAnd(initState, initAssignment);
	}

	protected CLTLocFormula getPhi3(TA ta) {

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

	protected CLTLocFormula getPhi5(TA ta, Set<StateAP> propositionsOfInterest,  Set<VariableAssignementAP> atomicpropositionsVariable) {

		 
		CLTLocFormula phi5StatesSubformula = atomicpropositionsVariable.stream().map(ap -> {
				VariableAssignementAP tmp = (VariableAssignementAP) ap;
				return (CLTLocFormula) new CLTLocIff(
						new CLTLocAP(
								"H_" + tmp.getEncodingSymbol()),
						new CLTLocDisjunction(
								new CLTLocConjunction(
										new CLTLocRelation(
												new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_"+tmp.getVariable().getName() + "_v"),
												new Constant(0), Relation.EQ),
										new CLTLocRelation(
												new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_"+tmp.getVariable().getName() + "0"),
												new Constant(tmp.getValue().value), Relation.EQ)),
								new CLTLocConjunction(
										new CLTLocRelation(
												new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_"+tmp.getVariable().getName() + "_v"),
												new Constant(1), Relation.EQ),
										new CLTLocRelation(
												new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_"+tmp.getVariable().getName() + "1"),
												new Constant(tmp.getValue().value), Relation.EQ))));
				
			}).reduce(CLTLocFormula.TRUE, conjunctionOperator);
			
		
		CLTLocFormula phi5StatesSubformulab=ta.getStates().stream()
				.map((s) -> 
				{
					
					Set<StateAP> propositionsOfs=propositionsOfInterest.stream().filter(ap -> ap.getAutomata().equals(ta.getIdentifier())).collect(Collectors.toSet()); 
					if(s.getValid(propositionsOfs).isEmpty()){
						return CLTLocFormula.TRUE;
					}
					else{
					 return iffOperator.apply(
							state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, s)),
									s.getValid(propositionsOfs).stream().map(ap -> (CLTLocFormula) new CLTLocAP(
											"H_" + ap.getEncodingSymbol()))
									.reduce(conjunctionOperator).orElse(CLTLocFormula.TRUE)
									);
					}
				}
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		return globallyOperator.apply(CLTLocFormula.getAnd(phi5StatesSubformula, phi5StatesSubformulab));

				
		
	}

	protected CLTLocFormula getPhi4(SystemDecl system, TA ta) {


		CLTLocFormula ret = ta.getStates().stream().map(state -> (CLTLocFormula) 
				implicationOperator.apply(
						state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, state)),
						disjunctionOperator.apply(
							this.remainInCurrentState(system, ta, state),
							ta.getOutgoingTransitions(state).stream()	.map(t -> 
								(CLTLocFormula) 
								CLTLocFormula.getAnd(
										nextOperator.apply(state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, t.getDestination()))),
										this.getGuardConditions(ta, t),
										this.getAssignConditions(ta, t)
									)
								).reduce(CLTLocFormula.FALSE, disjunctionOperator)
					)
				)
			).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		

		return globallyOperator.apply(ret);
		 
	}

	
	private CLTLocFormula remainInCurrentState(SystemDecl system, TA ta, State state){
		
		Set<Clock> clocks = ta.getClocks();
		Set<CLTLocFormula> clockFormulae = clocks.stream().map(c -> {
			String prefix = ta.getIdentifier() + "_";
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
						CLTLocFormula.getAnd(
								new CLTLocRelation(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName() + "_v"),new Constant(0), Relation.EQ),
								nextOperator.apply(	new CLTLocRelation(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName() + "_v"),new Constant(0), Relation.EQ)),
								new KeepVariableConstant(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName() + "0"))
								
								),
						CLTLocFormula.getAnd(
								new CLTLocRelation(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName() + "_v"),new Constant(1), Relation.EQ),
								nextOperator.apply(	new CLTLocRelation(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName() + "_v"),new Constant(1), Relation.EQ)),
								new KeepVariableConstant(new formulae.cltloc.atoms.Variable(ta.getIdentifier() + "_" + v.getName() + "1"))
						)))
				.collect(Collectors.toSet());

		Set<Variable> otherVariables = ta.getAllVariables();
		otherVariables.removeAll(variables);

		keepConstantVariables.addAll(otherVariables.stream()
				.map(v -> new CLTLocDisjunction(
						CLTLocFormula.getAnd(
								new CLTLocRelation(new formulae.cltloc.atoms.Variable(v.getName() + "_v"),new Constant(0), Relation.EQ),
								nextOperator.apply(new CLTLocRelation(new formulae.cltloc.atoms.Variable(v.getName() + "_v"),new Constant(0), Relation.EQ)),
								new KeepVariableConstant(new formulae.cltloc.atoms.Variable(v.getName() + "0"))
								),
						CLTLocFormula.getAnd(
								new CLTLocRelation(new formulae.cltloc.atoms.Variable(v.getName() + "_v"), new Constant(1), Relation.EQ),
								nextOperator.apply(new CLTLocRelation(new formulae.cltloc.atoms.Variable(v.getName() + "_v"),new Constant(1), Relation.EQ)),
								new KeepVariableConstant(new formulae.cltloc.atoms.Variable(v.getName() + "1"))
								
								)))
				.collect(Collectors.toSet()));

		CLTLocFormula keepConstantVariablesFormula = keepConstantVariables.stream().reduce(CLTLocFormula.TRUE,
				conjunctionOperator);
		
		return CLTLocFormula.getAnd(
							nextOperator.apply(state2Ap.apply(new AbstractMap.SimpleEntry<>(ta, state))),
							nextOperator.apply(clocksGeZero), 
							keepConstantVariablesFormula);
	}
	
	private CLTLocFormula getGuardConditions(TA ta, Transition t) {

		CLTLocFormula formula1 = t.getGuard().getClockConstraints().stream()
				.map(constraint -> clockConstraint2CLTLoc.apply(new AbstractMap.SimpleEntry<>(ta, constraint)))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula formula2 = t.getGuard().getConditions().stream().map(c -> c.accept(new TA2CLTLocVisitor(ta)))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return conjunctionOperator.apply(formula1, formula2);
	}

	private CLTLocFormula getAssignConditions(TA ta, Transition t) {

		Set<Variable> variables = ta.getVariables();
		Set<Clock> clocks=ta.getClocks();
		Set<String> clocksId = clocks.stream().map(c -> c.getName()).collect(Collectors.toSet());
		Set<String> assignedClocks = t.getAssignement().getClockassigments().stream().map(c -> c.getClock().getName())
				.collect(Collectors.toSet());
		Set<String> notAssignedClocks = new HashSet<>(clocksId);
		notAssignedClocks.removeAll(assignedClocks);

		// the not assigned clock should remain not change
		CLTLocFormula notAssignedClocksCLTLoc = notAssignedClocks.stream().map(c -> {
					String prefix = ta.getClocks().contains(new Clock(c)) ? ta.getIdentifier() + "_" : "";
					
					return (CLTLocFormula) new CLTLocDisjunction(
								new CLTLocConjunction(
										new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c + "_v"), new Constant(0),
												Relation.EQ),
										new CLTLocNext(
												new CLTLocConjunction(
														new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c + "_v"), new Constant(0),
																Relation.EQ),
														new CLTLocRelation(new CLTLocClock(prefix + c + "0"), new Constant(0), Relation.GE)
												)
										)
										
								)
								,
								new CLTLocConjunction(
										new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c + "_v"), new Constant(1),
												Relation.EQ),
										new CLTLocNext(
												new CLTLocConjunction(
														new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c + "_v"), new Constant(1),
																Relation.EQ),
														new CLTLocRelation(new CLTLocClock(prefix + c + "1"), new Constant(0), Relation.GE)
												)
										)
								)
						);
				 }).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		
		CLTLocFormula assignedClocksCLTLoc = t.getAssignement().getClockassigments().stream().map(c -> {
			String prefix = ta.getClocks().contains(c.getClock()) ? ta.getIdentifier() + "_" : "";
			return (CLTLocFormula) new CLTLocDisjunction(
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getClock().getName() + "_v"), new Constant(0),
									Relation.EQ),
							new CLTLocNext(
									new CLTLocConjunction(
											new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getClock().getName() + "_v"), new Constant(1),
													Relation.EQ),
											new CLTLocRelation(new CLTLocClock(prefix + c.getClock().getName() + "1"), new Constant(0), Relation.GE)
									)
							)
					),
					new CLTLocConjunction(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getClock().getName() + "_v"), new Constant(1),
									Relation.EQ),
							new CLTLocNext(
									new CLTLocConjunction(
											new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getClock().getName() + "_v"), new Constant(0),
													Relation.EQ),
											new CLTLocRelation(new CLTLocClock(prefix + c.getClock().getName() + "0"), new Constant(0), Relation.GE)
									)
							)
					)
			);
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		
		Set<String> variableId = variables.stream().map(c -> c.getName()).collect(Collectors.toSet());
		Set<String> assignedVariables = t.getAssignement().getVariableassigments().stream()
				.map(c -> c.getVariable().getName()).collect(Collectors.toSet());
		Set<String> notAssignedVariables = new HashSet<>(variableId);
		notAssignedVariables.removeAll(assignedVariables);

		CLTLocFormula notAssignedVariablesCLTLoc = notAssignedVariables.stream().map(c -> {
			String prefix = ta.getVariables().contains(new Variable(c)) ? ta.getIdentifier() + "_" : "";
			return (CLTLocFormula) new CLTLocDisjunction(
					CLTLocFormula.getAnd(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c + "_v"), new Constant(0),
									Relation.EQ),
							new CLTLocNext(new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c + "_v"), new Constant(0),
									Relation.EQ)),
							new KeepVariableConstant(new formulae.cltloc.atoms.Variable(prefix + c + "0"))),
					CLTLocFormula.getAnd(
							new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c + "_v"), new Constant(1),
									Relation.EQ),
							new CLTLocNext(new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c + "_v"), new Constant(1),
									Relation.EQ)),
							new KeepVariableConstant(new formulae.cltloc.atoms.Variable(prefix + c + "1"))));
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);


		CLTLocFormula assignedVariablesCLTLoc = t.getAssignement().getVariableassigments().stream().map(c -> {
			String prefix = ta.getVariables().contains(c.getVariable()) ? ta.getIdentifier() + "_" : "";

			return (CLTLocFormula) new CLTLocDisjunction(
				CLTLocFormula.getAnd(
						new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getVariable().getName() + "_v"),
								new Constant(0), Relation.EQ),
						new CLTLocNext(
								CLTLocFormula.getAnd(
										new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getVariable().getName() + "_v"),
													new Constant(1), Relation.EQ),
										new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getVariable().getName() + "1"),
												new Constant(c.getValue().evaluate()), Relation.EQ)
									)
							)
						)
				,
				  CLTLocFormula.getAnd(
							new CLTLocRelation(
									new formulae.cltloc.atoms.Variable(prefix + c.getVariable().getName() + "_v"),
									new Constant(1), Relation.EQ),
							new CLTLocNext(
									CLTLocFormula.getAnd(
											new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getVariable().getName() + "_v"),
														new Constant(0), Relation.EQ),
											new CLTLocRelation(new formulae.cltloc.atoms.Variable(prefix + c.getVariable().getName() + "0"),
													new Constant(c.getValue().evaluate()), Relation.EQ)
										)
								)
						)
				);
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);




		return CLTLocFormula.getAnd(
						notAssignedClocksCLTLoc, 
						assignedClocksCLTLoc,
						notAssignedVariablesCLTLoc, 
						assignedVariablesCLTLoc);
	}

	protected CLTLocFormula getPhi6(TA ta, Set<StateAP> propositionsOfInterest,Set<VariableAssignementAP> atomicpropositionsVariable) {
		Function<AP, CLTLocFormula> phi6Subformula = (a) -> a.accept(new TA2CLTLocVisitor(ta));

		CLTLocFormula andSubformula = propositionsOfInterest.stream().map(phi6Subformula).reduce(CLTLocFormula.TRUE,
				conjunctionOperator);
		
		
		CLTLocFormula andSubformula2 = atomicpropositionsVariable.stream().map(phi6Subformula).reduce(CLTLocFormula.TRUE,
				conjunctionOperator);
		
		
		
		return globallyOperator.apply(CLTLocFormula.getAnd(andSubformula,andSubformula2));
	}

	protected CLTLocFormula getPhi7(TA ta, Set<StateAP> propositionsOfInterest,Set<VariableAssignementAP> atomicpropositionsVariable) {
		
		
		CLTLocFormula f1=atomicpropositionsVariable.stream().map(ap -> {
				VariableAssignementAP tmp = (VariableAssignementAP) ap;
				if(ta.getInitialValue(new Variable(tmp.getVariable().getName())).equals(tmp.getValue())){
					return ap2CLTLocFIRSTAp.apply(new AP(tmp.getEncodingSymbol()));
				}
				else{
					return TA2CLTLoc.negationOperator.apply(
							ap2CLTLocFIRSTAp.apply(new AP(tmp.getEncodingSymbol())));
				}
				}
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
				
				
				
			
	
		CLTLocFormula f2=propositionsOfInterest.stream().map( ap ->{
			
					if(	ta.getIdentifier().equals(ap.getAutomata())
							&& 
							ta.getInitialState().getId().equals(ap.getState())){
						return ap2CLTLocFIRSTAp.apply(new AP(ap.getEncodingSymbol())); 
					}
					else{
						return CLTLocFormula.TRUE;
					}
			}).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		
		return CLTLocFormula.getAnd(f1, f2);
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


	public void printFancy(PrintStream fancyprint) {
		fancyprint.println("variable1: " + this.variable1);
		fancyprint.flush();
		fancyprint.println("clock1: " + this.clock1);
		fancyprint.flush();
		fancyprint.println("clock2: " + this.clock2);
		fancyprint.flush();
		fancyprint.println("clock3: " + this.clock3);
		fancyprint.flush();

		fancyprint.println("phi1: " + this.phi1);
		fancyprint.flush();
		fancyprint.println("phi2: " + this.phi2);
		fancyprint.flush();
		fancyprint.println("phi3: " + this.phi3);
		fancyprint.flush();
		fancyprint.println("phi4: " + this.phi4);
		fancyprint.flush();
		fancyprint.println("phi5: " + this.phi5);
		fancyprint.flush();
		fancyprint.println("phi6: " + this.phi6);
		fancyprint.flush();
		fancyprint.println("phi7: " + this.phi7);
		fancyprint.flush();

		fancyprint.println("network1: " + this.network1);
		fancyprint.flush();
		fancyprint.println("network2: " + this.network2);
		fancyprint.flush();
		fancyprint.println("network3: " + this.network3);
		fancyprint.flush();
		
	}
}
