package ta.expressions.ternary;

import ta.expressions.Expression;
import ta.visitors.ExpressionVisitor;
import ta.visitors.TAVisitor;

public class TernaryExpression extends Expression {

	public TernaryExpression(Expression condition, Expression  ifholds, Expression doesnothold){
		
	}

	@Override
	public <T> T accept(TAVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}
}
