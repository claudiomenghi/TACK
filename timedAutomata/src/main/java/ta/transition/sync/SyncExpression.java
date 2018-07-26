package ta.transition.sync;

import com.google.common.base.Preconditions;

public class SyncExpression {

	private final String event;
	private final Operator operator;

	public SyncExpression(String event, String operator) {
		Preconditions.checkNotNull(event, "The event cannot be null");
		Preconditions.checkNotNull(operator, "The operator cannot be null");
		this.event = event;
		this.operator = Operator.parse(operator);

	}

	public String getEvent() {
		return this.event;
	}

	public Operator getOperator() {
		return operator;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return event + operator;
	}

	public enum Operator {
		BROADCAST_SEND("#"), BROADCAST_RECEIVE("@"), TAU("TAU"), CHANNEL_SEND("!"), CHANNEL_RECEIVED("?");

		private final String operaor;

		private Operator(String operator) {
			this.operaor = operator;
		}

		public static Operator parse(String value) {
			switch (value) {
			case "#":
				return Operator.BROADCAST_SEND;
			case "@":
				return Operator.BROADCAST_RECEIVE;
			case "!":
				return Operator.CHANNEL_SEND;
			case "?":
				return Operator.CHANNEL_RECEIVED;

			default:
				return Operator.TAU;
			}
		}

		public String toString() {
			return this.operaor;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SyncExpression other = (SyncExpression) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		return true;
	}
}
