package ta.transition.sync;

import com.google.common.base.Preconditions;

public class SyncExpression {

	private final String event;
	private final String operator;

	public SyncExpression(String event, String operator) {
		Preconditions.checkNotNull(event, "The event cannot be null");
		Preconditions.checkNotNull(operator, "The operator cannot be null");
		this.event = event;
		this.operator = operator;

	}

	public String getEvent() {
		return this.event;
	}

	public String getOperator() {
		return operator;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return event + operator;
	}
}
