package formulae.mitli;

import formulae.BinaryFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLISince extends MITLIFormula implements BinaryFormula<MITLIFormula> {

	private final MITLIFormula subformula1;
	private final MITLIFormula subformula2;

	public MITLISince(MITLIFormula subformula1, MITLIFormula subformula2) {
		super(new String("(S " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
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
	public MITLIFormula getLeftChild() {
		return subformula1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLIFormula getRightChild() {
		return subformula2;
	}
}
