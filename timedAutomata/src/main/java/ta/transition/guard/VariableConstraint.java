package ta.transition.guard;

import java.util.Set;

import ta.Variable;
import ta.visitors.TAVisitor;

public interface VariableConstraint {

	/**
	 * returns the set of the variables involved in the variable constraint
	 * 
	 * @return the set of the variables involved in the variable constraint
	 */
	public Set<Variable> getVariables();

	public <R> R accept(TAVisitor<R> visitor);
}
