package ta.visitors;

import java.io.PrintStream;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Set;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.KeepVariableConstant;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.binary.CLTLocRelease;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNext;
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

public class TANetwork2CLTLoc extends TA2CLTLoc {

	
	
	public CLTLocFormula convert(SystemDecl system, Set<StateAP> propositionsOfInterest, Set<VariableAssignementAP> atomicpropositionsVariable) {

		this.variable1=
				conjunctionOperator.apply(
						this.getVariable1(system)
						, 
				system.getTimedAutomata().stream().map(ta ->
					(CLTLocFormula) this.getVariable1(ta)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator));
		
		CLTLocFormula variableconst = this.variable1;

		
		this.clock1 =
				conjunctionOperator.apply(
						this.getClock1(system)
						, 
				system.getTimedAutomata().stream().map(ta ->
						this.getClock1(system, ta)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator));
		
		this.clock2 = 
				conjunctionOperator.apply(
						this.getClock2(system)
						, 
				system.getTimedAutomata().stream().map(ta ->
						this.getClock2(system, ta)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator));
		
		this.clock3 = 
				conjunctionOperator.apply(
						this.getClock3(system)
						, 
				system.getTimedAutomata().stream().map(ta ->
						this.getClock3(system, ta)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator));
		
		
		CLTLocFormula clockconst = 
				CLTLocFormula.getAnd( this.clock1,this.clock2, this.clock3);

		this.phi1 = system.getTimedAutomata().stream().map(ta ->
					this.getPhi1(system, ta)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		this.phi2 = system.getTimedAutomata().stream().map(ta ->
					this.getPhi2(ta)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		this.phi3 =  system.getTimedAutomata().stream().map(ta ->
					this.getPhi3(ta)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		this.phi4 = system.getTimedAutomata().stream().map(ta ->
						this.getPhi4(system, ta)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		this.phi5 = system.getTimedAutomata().stream().map(ta ->
					this.getPhi5(ta, propositionsOfInterest,atomicpropositionsVariable)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		this.phi6 = system.getTimedAutomata().stream().map(ta ->
						this.getPhi6(ta, propositionsOfInterest, atomicpropositionsVariable)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		this.phi7 = system.getTimedAutomata().stream().map(ta ->
						this.getPhi7(ta, propositionsOfInterest, atomicpropositionsVariable)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula taFormula = CLTLocFormula.getAnd(this.phi1, this.phi2, this.phi3, this.phi4, this.phi5, this.phi6, this.phi7);


		
		this.network1=this.getNetwork1(system);
		this.network2=this.getNetwork2(system);
		this.network3=this.getNetwork3(system);

		
		CLTLocFormula network = 
				CLTLocFormula.getAnd( this.network1,this.network2, this.network3);
		
		
		return Y.apply(CLTLocFormula.getAnd(variableconst, clockconst, taFormula, network));
		

	}
	
	
	protected CLTLocFormula getVariable1(SystemDecl system) {

		Set<Variable> variables=system.getVariableDeclaration().stream().map(c -> (Variable) new Variable(c.getId())).collect(Collectors.toSet());

		CLTLocFormula f1 = 
				variables.stream().map( 
				v ->{
				return (CLTLocFormula) 
						CLTLocFormula.getAnd(
						new CLTLocRelation(new formulae.cltloc.atoms.Variable( v.getName() + "0"), new Constant(0), Relation.EQ),
						new CLTLocRelation(new formulae.cltloc.atoms.Variable( v.getName() + "1"), new Constant(0), Relation.GE),					
						new CLTLocRelation(new formulae.cltloc.atoms.Variable( v.getName() + "_v"), new Constant(0), Relation.EQ)
						);
				}
			).reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return f1;
	}
	
	protected CLTLocFormula getClock1(SystemDecl system) {

		Set<Clock> clocks = system.getClockDeclarations().stream().map(c -> (Clock) new Clock(c.getId())).collect(Collectors.toSet());

		CLTLocFormula f0 = clocks.stream().map(c -> {
			return (CLTLocFormula) 
					CLTLocFormula.getAnd(
					new CLTLocRelation(new CLTLocClock( c.getName() + "0"), new Constant(0), Relation.EQ),
					new CLTLocRelation(new CLTLocClock( c.getName() + "1"), new Constant(0), Relation.GE),					
					new CLTLocRelation(new formulae.cltloc.atoms.Variable( c.getName() + "_v"), new Constant(0), Relation.EQ)
					);
					
		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		return f0;
	}

	
	protected CLTLocFormula getClock2(SystemDecl system) {

		Set<Clock> clocks = system.getClockDeclarations().stream().map(c -> (Clock) new Clock(c.getId())).collect(Collectors.toSet());


		CLTLocFormula f1 = clocks.stream().map(c -> {
			String prefix = "";
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

	protected CLTLocFormula getClock3(SystemDecl system) {

		Set<Clock> clocks = system.getClockDeclarations().stream().map(c -> (Clock) new Clock(c.getId())).collect(Collectors.toSet());


		CLTLocFormula f1 = clocks.stream().map(c -> {
			String prefix ="";
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
	
	private CLTLocFormula getNetwork1(SystemDecl system){
	
		Set<TA> tas=system.getTimedAutomata();
		
		CLTLocFormula ret=
				
				CLTLocFormula.getOr(
				// only one send
				tas.stream().map(ta -> 
						(CLTLocFormula) ta.getActions().stream().map(
								event -> sendEvent2Ap.apply(
											new AbstractMap.SimpleEntry<>(ta, event)
										)
								).reduce(CLTLocFormula.FALSE, xorOperator)
						).reduce(CLTLocFormula.FALSE, xorOperator),
				// or no sends
				tas.stream().map(ta ->  
					(CLTLocFormula) ta.getActions().stream().map(
							event -> sendEvent2Ap.apply(
										new AbstractMap.SimpleEntry<>(ta, event)
									)
							).reduce(CLTLocFormula.FALSE, conjunctionOperator)
					).reduce(CLTLocFormula.FALSE, xorOperator)
				);
		
		return ret.equals(CLTLocFormula.FALSE) ? CLTLocFormula.TRUE : ret;
	}
	
	private CLTLocFormula getNetwork2(SystemDecl system){
		
		Set<TA> tas=system.getTimedAutomata();
		
		CLTLocFormula ret=
				
				CLTLocFormula.getOr(
				tas.stream().map(ta -> 
						(CLTLocFormula) ta.getActions().stream().map(
								event -> receiveEvent2Ap.apply(
											new AbstractMap.SimpleEntry<>(ta, event)
										)
								).reduce(CLTLocFormula.FALSE, xorOperator)
						).reduce(CLTLocFormula.FALSE, xorOperator),
				tas.stream().map(ta ->  
					(CLTLocFormula) ta.getActions().stream().map(
							event -> receiveEvent2Ap.apply(
										new AbstractMap.SimpleEntry<>(ta, event)
									)
							).reduce(CLTLocFormula.FALSE, conjunctionOperator)
					).reduce(CLTLocFormula.FALSE, xorOperator)
				);
		
		return ret.equals(CLTLocFormula.FALSE) ? CLTLocFormula.TRUE : ret;
	}

private CLTLocFormula getNetwork3(SystemDecl system){
		
		Set<TA> tas=system.getTimedAutomata();
		
		final Set<Entry<TA, TA>> couplesOfTa=new HashSet<>();
		
		tas.stream().forEach(
				ta1 ->
				tas.stream().forEach(
						ta2-> {
								if(!ta2.getIdentifier().equals(ta1.getIdentifier())){
									couplesOfTa.add(new AbstractMap.SimpleEntry<>(ta1,ta2));
								}
							}
						)
				);
		
		CLTLocFormula ret=couplesOfTa.stream().map(
				tacouple -> {
						Set<String> commonEvents=new HashSet<>(tacouple.getKey().getActions());
						commonEvents.removeAll(tacouple.getValue().getActions());
						
						return commonEvents.stream().map( event ->
									{
										return CLTLocDisjunction.getAnd(
											sendEvent2Ap.apply(new AbstractMap.SimpleEntry<>(tacouple.getKey(), event)),
											receiveEvent2Ap.apply(new AbstractMap.SimpleEntry<>(tacouple.getValue(), event))
										);
									}
								).reduce(CLTLocFormula.FALSE, disjunctionOperator);
					}
				).reduce(CLTLocFormula.FALSE, disjunctionOperator);
	
		CLTLocFormula ret2=tas.stream().map(ta -> 
							{
								Set<String> events=new HashSet<>(ta.getActions());
								return (CLTLocFormula) 
										events.stream().map(event -> 
											(CLTLocFormula) negationOperator.apply(receiveEvent2Ap.apply(
													new AbstractMap.SimpleEntry<>(ta, event)))
											).reduce(CLTLocFormula.TRUE, conjunctionOperator);
							}
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
				
		return disjunctionOperator.apply(ret, ret2);
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
