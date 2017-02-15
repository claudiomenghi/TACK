package formulae.mitli;

import formulae.mitli.TemporizedFormula;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLIGlobally_AtoInf extends MITLIGlobally implements TemporizedFormula {

	private final int a;

	private final String operator = "G";

	public MITLIGlobally_AtoInf(MITLIFormula subformula, int a) {
		super(subformula);
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + this.operator + "[" + String.valueOf(a) + ",+oo]" + this.getChild() + ")";
	}
}
