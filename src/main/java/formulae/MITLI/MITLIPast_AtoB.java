package formulae.mitli;

import formulae.TemporizedFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLIPast_AtoB extends MITLIPast implements TemporizedFormula {

	private final int a, b;

	public MITLIPast_AtoB(MITLIFormula subformula, int a, int b) {
		super(subformula,
				new String("(P " + String.valueOf(a) + " " + String.valueOf(b) + " " + subformula.strFormula() + ")"));
		this.a = a;
		this.b = b;

		subformula.maxIntComparedto(b - a);
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
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
