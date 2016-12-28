package formulae.cltloc.operators.binary;

import formulae.BinaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocSince extends CLTLocFormula implements BinaryFormula<CLTLocFormula> {

	private final CLTLocFormula subformula1;
	private final CLTLocFormula subformula2;

	public CLTLocSince(CLTLocFormula subformula1, CLTLocFormula subformula2) {
		super(new String("(S " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula getLeftChild() {
		return subformula1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula getRightChild() {
		return subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}
}
