package ta.state;

import formulae.cltloc.CLTLocFormula;
import ta.expressions.Expression;
import ta.expressions.Identifier;
import ta.visitors.TA2CLTLocVisitor;

public class ExpInvariant extends Invariant {

	private final Identifier id;
	private final Expression exp;
	private final String operator;

	public ExpInvariant(Identifier id, String operator, Expression exp) {
		this.id = id;
		this.exp = exp;
		this.operator = operator;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula accept(TA2CLTLocVisitor ta2cltLoc) {

		return ta2cltLoc.visit(this);		
		
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
}
