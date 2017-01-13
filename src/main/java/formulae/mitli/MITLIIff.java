package formulae.mitli;

import formulae.BinaryFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLIIff extends MITLIFormula implements BinaryFormula<MITLIFormula> {

	// Formula f1 which is argument of the negation (\neg f1)
	private final MITLIFormula subformula1;
	private final MITLIFormula subformula2;

	public MITLIIff(MITLIFormula subformula1, MITLIFormula subformula2) {
		super(new String("(IFF " + subformula1.strFormula() + " " + subformula2.strFormula()) + ")");
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
