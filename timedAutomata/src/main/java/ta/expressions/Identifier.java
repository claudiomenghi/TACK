package ta.expressions;

import com.google.common.base.Preconditions;

import ta.visitors.ExpressionVisitor;
import ta.visitors.TAVisitor;

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
	public <T> T accept(TAVisitor<T> visitor) {
		// TODO Auto-generated method stub
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
