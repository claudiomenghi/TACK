package ta.expressions;

import ta.visitors.ExpressionVisitor;
import ta.visitors.TAVisitor;

public class Value extends Expression {

	public String value;

	public Value(String value) {
		this.value = value;
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
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int evaluate() {
		return Integer.parseInt(value);
	}
}
