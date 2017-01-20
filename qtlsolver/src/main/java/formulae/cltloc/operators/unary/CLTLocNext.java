package formulae.cltloc.operators.unary;

import formulae.UnaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocNext extends CLTLocFormula implements UnaryFormula<CLTLocFormula> {

	// Formula f1 which is argument of the negation (\neg f1)
	private CLTLocFormula child;

	public CLTLocNext(CLTLocFormula subformula) {
		super(new String("(NEXT " + subformula.strFormula()) + ")");
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


