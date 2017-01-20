package formulae.cltloc.operators.unary;

import formulae.UnaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocYesterday extends CLTLocFormula implements UnaryFormula<CLTLocFormula> {

	private CLTLocFormula child;

	public CLTLocYesterday(CLTLocFormula subformula) {
		super(new String("(P " + subformula.strFormula()) + ")");
		this.child = subformula;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula getChild() {
		return this.child;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}
}
