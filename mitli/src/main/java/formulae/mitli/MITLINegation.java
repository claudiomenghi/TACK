package formulae.mitli;

import com.google.common.base.Preconditions;

import formulae.UnaryFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLINegation extends MITLIFormula implements UnaryFormula<MITLIFormula> {

	// Formula f1 which is argument of the negation (\neg f1)
	private MITLIFormula subformula;

	private final String operator = "NEG";

	public MITLINegation(MITLIFormula subformula) {

		Preconditions.checkNotNull(subformula, "The subformula cannot be null");
		this.subformula = subformula;
	}

	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public MITLIFormula getChild() {
		return this.subformula;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + this.operator + this.getChild() + ")";
	}
}
