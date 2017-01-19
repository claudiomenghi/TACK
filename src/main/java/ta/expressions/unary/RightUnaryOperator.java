package ta.expressions.unary;

import ta.expressions.Expression;

public class RightUnaryOperator  extends  UnaryExpression {

	private final String operator;

	public RightUnaryOperator( Expression expression, String operator) {
		super(expression);
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}
}
