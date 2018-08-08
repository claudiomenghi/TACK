package ta;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;

import ta.declarations.BoundedVariableDecl;
import ta.declarations.ClockDecl;
import ta.declarations.VariableDecl;

public class SystemDecl {

	private final Set<VariableDecl> variableDeclaration;

	private final Set<ClockDecl> clockDeclarations;

	private final Set<Clock> allClocks;
	
	private Set<TA> timedAutomata;

	private final Set<Variable> variables;
	
	public boolean isBounded(String variableId){
		return this.variableDeclaration.stream().filter(d -> d instanceof BoundedVariableDecl).map(d -> d.getId()).collect(Collectors.toSet()).contains(variableId);
	}
	
	public boolean isGlobal(String variableId) {
		return (variableDeclaration.stream().map(v -> v.getId()).collect(Collectors.toSet())).contains(variableId);
	}
		
	public Set<Integer> getBound(String variableId){
		Set<Integer> retSet=new HashSet<>();
		this.variableDeclaration.stream().filter(d -> d instanceof BoundedVariableDecl).map(d -> ((BoundedVariableDecl) d).getValues()).forEach(c -> retSet.addAll(c));
		return  retSet;
	}
	
	public SystemDecl(Set<TA> timedAutomata, Set<ClockDecl> clockDeclarations, Set<VariableDecl> variableDeclaration) {

		Preconditions.checkNotNull(timedAutomata, "The timed automaton cannot be null");
		Preconditions.checkNotNull(clockDeclarations, "The set of clocks cannot be null");
		Preconditions.checkNotNull(variableDeclaration, "The set of variables cannot be null");

		this.variables=new HashSet<>();
		this.timedAutomata = timedAutomata;
		this.clockDeclarations = clockDeclarations;
		this.variableDeclaration = variableDeclaration.stream().filter(v -> !v.getType().equals("chan")).collect(Collectors.toSet());

		
		this.variableDeclaration.forEach(v -> 
		
		{	
			
			if(!v.getType().equals("chan")) {
			variables.add(new Variable(v.getId()));}});
		
		allClocks=new HashSet<>();
		this.allClocks.addAll(this.getGlobalClocks());
		for(TA ta: timedAutomata){
			this.allClocks.addAll(ta.getLocalClocks());
		}
	}

	public Set<Clock> getGlobalClocks(){
		return this.clockDeclarations.stream().map(c -> new Clock(c.getId())).collect(Collectors.toSet());
	}
	
	
	public Set<Variable> getGlobalVariables(){
		return this.variableDeclaration.stream().map(v-> new Variable(v.getId())).collect(Collectors.toSet());
	}
	

	public Set<TA> getTimedAutomata() {
		return this.timedAutomata;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("------ TA ------\n");
		timedAutomata.forEach(ta -> builder.append(ta));

		builder.append("------ GLOBAL CLOCKS ------\n");
		clockDeclarations.forEach(v -> builder.append(v+"\n"));
		
		builder.append("------ GLOBAL VARIABLES ------\n");
		variableDeclaration.forEach(v -> builder.append(v+"\n"));
		
		
		return builder.toString();
	}

	public Set<VariableDecl> getVariableDeclaration() {
		return variableDeclaration;
	}

	public Set<ClockDecl> getClockDeclarations() {
		return clockDeclarations;
	}
}
