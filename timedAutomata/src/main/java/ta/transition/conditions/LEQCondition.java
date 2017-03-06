package ta.transition.conditions;

import ta.expressions.Expression;
import ta.expressions.Value;

public class LEQCondition extends Condition{
	private final String id;
	private final Expression value;

	public LEQCondition(String id, Expression value) {
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
