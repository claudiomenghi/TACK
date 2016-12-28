package formulae.mitl;

import formulae.TemporizedFormula;
import formulae.mitl.visitors.MITLVisitor;

public class MITLEventually_AtoB extends MITLEventually implements TemporizedFormula {

	private final int a;
	private final int b;

	public MITLEventually_AtoB(MITLFormula subformula, int lowerBound, int upperBound) {
		super(subformula,
				new String("(F " + String.valueOf(lowerBound) + " " + String.valueOf(upperBound) + " " + subformula.strFormula() + ")"));
		this.a = lowerBound;
		this.b = upperBound;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public int upperbound() {
		return b;
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
	public <T> T accept(MITLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
