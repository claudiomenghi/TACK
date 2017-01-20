package formulae.cltloc.operators.unary;

import formulae.UnaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocGlobally  extends CLTLocFormula implements UnaryFormula<CLTLocFormula> {

	// Formula f1 which is argument of the negation (\neg f1)
	private CLTLocFormula child;

	public CLTLocGlobally(CLTLocFormula subformula) {
		super(new String("(G " + subformula.strFormula()) + ")");
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
