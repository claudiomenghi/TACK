package ta.transition;

import ta.expressions.Value;

public class EQCondition {
	private final String id;
	private final Value value;

	public EQCondition(String id, Value value) {
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public Value getValue() {
		return value;
	}

}
