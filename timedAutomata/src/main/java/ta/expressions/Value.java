package ta.expressions;

import ta.visitors.Expression2CLTLocExpression;
import ta.visitors.ExpressionVisitor;

public class Value extends Expression {

	
	public String value;

	public Value(String value) {
		this.value = value;
	}

	@Override
	public formulae.cltloc.atoms.Expression accept(Expression2CLTLocExpression visitor) {
		return visitor.visit(this);
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Value other = (Value) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
