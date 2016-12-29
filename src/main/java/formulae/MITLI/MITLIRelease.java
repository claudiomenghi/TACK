package formulae.mitli;

import formulae.BinaryFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLIRelease extends MITLIFormula implements BinaryFormula<MITLIFormula> {

	private MITLIFormula subformula1, subformula2;

	public MITLIRelease(MITLIFormula subformula1, MITLIFormula subformula2) {
		super(new String("(R " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLIFormula getLeftChild() {
		return this.subformula1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLIFormula getRightChild() {
		return this.subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
