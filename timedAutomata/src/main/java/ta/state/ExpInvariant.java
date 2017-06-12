package ta.state;

import ta.expressions.Expression;
import ta.expressions.Identifier;

public class ExpInvariant extends Invariant {

	private final Identifier id;
	private final Expression exp;
	private final String operator;

	public ExpInvariant(Identifier id, String operator, Expression exp) {
		this.id = id;
		this.exp = exp;
		this.operator = operator;
	}

	public Identifier getId() {
		return id;
	}

	public String getOperator() {
		return operator;
	}

	public Expression getExp() {
		return exp;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "invariant="+id + operator + exp;
	}

}
