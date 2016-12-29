package formulae.cltloc.operators.unary;

import formulae.UnaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocEventually  extends CLTLocFormula implements UnaryFormula<CLTLocFormula> {

	// Formula f1 which is argument of the negation (\neg f1)
	private CLTLocFormula child;

	public CLTLocEventually(CLTLocFormula subformula) {
		super(new String("(F " + subformula.strFormula()) + ")");
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
