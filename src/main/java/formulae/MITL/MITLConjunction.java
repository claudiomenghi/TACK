package formulae.mitl;

import formulae.BinaryFormula;
import formulae.mitl.visitors.MITLVisitor;

public class MITLConjunction extends MITLFormula implements BinaryFormula<MITLFormula> {

	private final MITLFormula subformula1;
	private final MITLFormula subformula2;

	public MITLConjunction(MITLFormula subformula1, MITLFormula subformula2) {
		super(new String("(AND " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLVisitor<T> visitor) {
		return visitor.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLFormula getLeftChild() {
		return subformula1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLFormula getRightChild() {
		return subformula2;
	}

}
