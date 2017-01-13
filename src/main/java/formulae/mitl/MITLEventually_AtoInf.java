package formulae.mitl;

import formulae.TemporizedFormula;
import formulae.UnaryFormula;
import formulae.mitl.visitors.MITLVisitor;

public class MITLEventually_AtoInf extends MITLFormula implements TemporizedFormula, UnaryFormula<MITLFormula> {

	private final MITLFormula subformula;
	private final int a;

	public MITLEventually_AtoInf(MITLFormula subformula, int lowerBound) {
		super(new String("(F " + String.valueOf(lowerBound) + " +oo" + subformula.strFormula() + ")"));
		this.subformula = subformula;
		this.a = lowerBound;
	}

	@Override
	public int upperbound() {
		return -1;
	}

	@Override
	public int lowerbound() {
		return a;
	}

	@Override
	public <T> T accept(MITLVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public MITLFormula getChild() {
		return this.subformula;
	}
}
