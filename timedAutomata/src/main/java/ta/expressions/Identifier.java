package ta.expressions;

import com.google.common.base.Preconditions;

import ta.visitors.Expression2CLTLocExpression;
import ta.visitors.ExpressionVisitor;

public class Identifier extends Expression {

	/**
	 * The identifier
	 */
	private final String id;

	public Identifier(String id) {
		Preconditions.checkNotNull(id, "The identifier");
		this.id = id;
	}

	public String getId() {
		return id;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return id;
	}

	@Override
	public int evaluate() {
		return 1;
	}

}
