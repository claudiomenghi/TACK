package ta.state;

import formulae.cltloc.CLTLocFormula;
import ta.TA;
import ta.expressions.Expression;
import ta.expressions.Identifier;
import ta.visitors.InvariantVisitor;

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


	
	@Override
	public CLTLocFormula accept(TA ta, InvariantVisitor v) {
		return v.visit(ta, this);
	}
	
}
