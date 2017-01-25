package formulae.mitl;

import formulae.UnaryFormula;
import formulae.mitl.visitors.MITLVisitor;

public class MITLNegation extends MITLFormula implements UnaryFormula<MITLFormula> {

	// Formula f1 which is argument of the negation (\neg f1)
	private MITLFormula child;

	public MITLNegation(MITLFormula subformula) {
		super(new String("(NEG " + subformula.strFormula()) + ")");
		this.child = subformula;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLFormula getChild() {
		return this.child;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
