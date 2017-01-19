package ta.expressions.unary;

import ta.expressions.Expression;

public class LeftUnaryOperator extends  UnaryExpression {

	
	private final String operator;
	
	public LeftUnaryOperator(String operator, Expression expression){
		super(expression);
		this.operator=operator;
	}

	public String getOperator() {
		return operator;
	}


}
