package ta.transition.sync;

import com.google.common.base.Preconditions;

import ta.transition.guard.VariableConstraintAtom.VariableConstraintAtomOperator;

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
	
	
	public enum Operator {
		SEND("?"), RECEIVED("!");

		private final String operaor;

		private Operator(String operator) {
			this.operaor = operator;
		}

		public static Operator parse(String value){
			switch(value){
				case "?": return Operator.SEND;
				case "!": return Operator.RECEIVED;
				default:
					throw new IllegalArgumentException("Operator "+value+" not present");
			}
		}
		public String toString() {
			return this.operaor;
		}
	}
}
