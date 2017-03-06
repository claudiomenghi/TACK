package ta.transition.assignments;

import ta.expressions.Expression;

public class VariableAssignment extends Assignment {
	private final String id;
	private final Expression value;

	public VariableAssignment(String id, Expression value) {
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public Expression getValue() {
		return value;
	}
}
