package formulae.mitli;

import formulae.UnaryFormula;
import formulae.mitl.TemporizedFormula;

public abstract class MITLIPast extends MITLIFormula implements TemporizedFormula, UnaryFormula<MITLIFormula> {

	private MITLIFormula subformula;

	public MITLIPast(MITLIFormula subformula, String subformulaString) {
		super(subformulaString);
		this.subformula = subformula;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public MITLIFormula getChild() {
		return this.subformula;
	}
}
