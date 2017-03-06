package ta.transition.assignments;

import ta.expressions.Value;

public class ClockAssignement extends Assignment{
	private final String id;
	private final Value value;

	public ClockAssignement(String id, Value value) {
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
