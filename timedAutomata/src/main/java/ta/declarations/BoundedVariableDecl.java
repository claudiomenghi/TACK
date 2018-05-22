package ta.declarations;

import java.util.Set;

import ta.expressions.Expression;

public class BoundedVariableDecl extends VariableDecl {

	private Set<Integer> values;
	
	
	public BoundedVariableDecl(String type, String id, Expression exp, Set<Integer> values) {
		super(type, id, exp);
		this.values=values;
	}
	
	/**
	 * returns the set of values that can be assigned to the final values
	 * @return the set of values that can be assigned to the final values
	 */
	public Set<Integer> getValues() {
		return values;
	}

	@Override
	public String toString() {
		return this.getType() + " " + this.getId() + "{"+this.values+"}=" + this.getExp();
	}
}
