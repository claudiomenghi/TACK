package ta.visitors;

import java.io.PrintStream;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import ta.StateAP;
import ta.SystemDecl;
import ta.TA;
import ta.VariableAssignementAP;

public class TANetwork2CLTLoc extends TA2CLTLoc {


	
	public CLTLocFormula convert(SystemDecl system, Set<StateAP> propositionsOfInterest, Set<VariableAssignementAP> atomicpropositionsVariable) {

		this.variable1=system.getTimedAutomata().stream().map(ta ->
					(CLTLocFormula) this.getVariable1(ta)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		CLTLocFormula variableconst = this.variable1;

		
		this.clock1 =system.getTimedAutomata().stream().map(ta ->
						this.getClock1(system, ta)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		this.clock2 = system.getTimedAutomata().stream().map(ta ->
						this.getClock2(system, ta)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		this.clock3 = system.getTimedAutomata().stream().map(ta ->
						this.getClock3(system, ta)
				).reduce(CLTLocFormula.TRUE, conjunctionOperator);
		
		
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
				).reduce(CLTLocFormula.FALSE, conjunctionOperator);
		
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
	
	
	
	
	private CLTLocFormula getNetwork1(SystemDecl system){
	
		Set<TA> tas=system.getTimedAutomata();
		
		CLTLocFormula ret=
				
				CLTLocFormula.getOr(
				tas.stream().map(ta -> 
						(CLTLocFormula) ta.getActions().stream().map(
								event -> sendEvent2Ap.apply(
											new AbstractMap.SimpleEntry<>(ta, event)
										)
								).reduce(CLTLocFormula.FALSE, xorOperator)
						).reduce(CLTLocFormula.FALSE, xorOperator),
				tas.stream().map(ta ->  
					(CLTLocFormula) ta.getActions().stream().map(
							event -> sendEvent2Ap.apply(
										new AbstractMap.SimpleEntry<>(ta, event)
									)
							).reduce(CLTLocFormula.FALSE, conjunctionOperator)
					).reduce(CLTLocFormula.FALSE, xorOperator)
				);
		
		return ret;
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
		
		return ret;
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
