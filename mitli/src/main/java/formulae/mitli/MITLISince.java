package formulae.mitli;

import com.google.common.base.Preconditions;

import formulae.BinaryFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLISince extends MITLIFormula implements BinaryFormula<MITLIFormula> {

	private final MITLIFormula subformula1;
	private final MITLIFormula subformula2;

	private final String operator = "S";

	public MITLISince(MITLIFormula subformula1, MITLIFormula subformula2) {
		super();
		Preconditions.checkNotNull(subformula1, "The first subformula cannot be null");
		Preconditions.checkNotNull(subformula2, "The second subformula cannot be null");
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + this.subformula1 + " " + operator + " " + this.subformula2 + ")";
	}
}
