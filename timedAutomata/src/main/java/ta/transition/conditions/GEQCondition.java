package ta.transition.conditions;

import ta.expressions.Expression;

public class GEQCondition extends Condition{
	private final String id;
	private final Expression value;

	public GEQCondition(String id, Expression value) {
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
