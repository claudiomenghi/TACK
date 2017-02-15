package ta.transition;

import ta.expressions.Value;

public class EQAssignement {
	private final String id;
	private final Value value;

	public EQAssignement(String id, Value value) {
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
