package ta;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import ta.declarations.ClockDecl;
import ta.declarations.VariableDecl;

public class SystemDecl {

	private final Set<VariableDecl> variableDeclaration;

	private final Set<ClockDecl> clockDeclarations;

	private Set<TA> timedAutomata;

	private final Set<Variable> variables;
	public SystemDecl(Set<TA> timedAutomata, Set<ClockDecl> clockDeclarations, Set<VariableDecl> variableDeclaration) {

		Preconditions.checkNotNull(timedAutomata, "The timed automaton cannot be null");
		Preconditions.checkNotNull(clockDeclarations, "The set of clocks cannot be null");
		Preconditions.checkNotNull(variableDeclaration, "The set of variables cannot be null");

		this.variables=new HashSet<>();
		this.timedAutomata = timedAutomata;
		this.clockDeclarations = clockDeclarations;
		this.variableDeclaration = variableDeclaration;

		this.variableDeclaration.forEach(v -> variables.add(new Variable(v.getId())));
	}

	public Set<Variable> getGlobalVariables(){
		Set<Variable> allVariables=new HashSet<>(variables);
		timedAutomata.forEach(t -> allVariables.removeAll(t.getVariables()));
		return allVariables;
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

		builder.append("------ TA ------");
		timedAutomata.forEach(ta -> builder.append(ta));

		builder.append("------ GLOBAL VARIABLES AND CLOCKS ------\n");
		variableDeclaration.forEach(v -> builder.append(v+"\n"));
		clockDeclarations.forEach(v -> builder.append(v+"\n"));
		
		builder.append("------ GLOBAL VARIABLES AND CLOCKS ------\n");
		variables.forEach(v -> builder.append(v+"\n"));
		
		
		return builder.toString();
	}

	public Set<VariableDecl> getVariableDeclaration() {
		return variableDeclaration;
	}

	public Set<ClockDecl> getClockDeclarations() {
		return clockDeclarations;
	}
}
