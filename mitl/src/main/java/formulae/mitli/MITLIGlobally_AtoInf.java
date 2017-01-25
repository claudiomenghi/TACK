package formulae.mitli;

import formulae.mitl.TemporizedFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLIGlobally_AtoInf extends MITLIGlobally implements TemporizedFormula {

	private final int a;

	public MITLIGlobally_AtoInf(MITLIFormula subformula, int a) {
		super(subformula, new String("(G " + a + " +oo" + subformula.strFormula() + ")"));
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
