package ta.expressions;

import ta.visitors.ExpressionVisitor;
import ta.visitors.TAVisitor;

public class EmptyExpression extends Expression {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(TAVisitor<T> visitor) {
		return visitor.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
		
	}

}
