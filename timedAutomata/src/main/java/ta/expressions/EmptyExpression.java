package ta.expressions;

import ta.visitors.Expression2CLTLocExpression;
import ta.visitors.ExpressionVisitor;

public class EmptyExpression extends Expression {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public formulae.cltloc.atoms.CLTLocArithmeticExpression accept(Expression2CLTLocExpression visitor) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "";
	}

	@Override
	public int evaluate() {
		return 0;
	}

}
