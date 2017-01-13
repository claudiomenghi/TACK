package formulae.mitli;

import formulae.TemporizedFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLIEventually_AtoInf extends MITLIEventually implements TemporizedFormula {

	private final int a;

	public MITLIEventually_AtoInf(MITLIFormula subformula, int a) {
		super(subformula, new String("(F " + String.valueOf(a) + " +oo" + subformula.strFormula() + ")"));
		this.a = a;

		this.maxIntComparedto(a);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int upperbound() {
		return -1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int lowerbound() {
		return a;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
