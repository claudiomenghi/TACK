package ta.expressions.ternary;

import ta.expressions.Expression;
import ta.visitors.Expression2CLTLocExpression;
import ta.visitors.ExpressionVisitor;

public class TernaryExpression extends Expression {

	public TernaryExpression(Expression condition, Expression  ifholds, Expression doesnothold){
		
	}

	@Override
	public formulae.cltloc.atoms.CLTLocArithmeticExpression accept(Expression2CLTLocExpression visitor) {
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
