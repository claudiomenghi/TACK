package formulae.mitli;

import formulae.UnaryFormula;
import formulae.mitli.TemporizedFormula;


public abstract class MITLIEventually extends MITLIFormula implements TemporizedFormula, UnaryFormula<MITLIFormula> {

	private final MITLIFormula subformula;

	public MITLIEventually(MITLIFormula subformula, String subformulaDescription) {
		super(subformulaDescription);
		this.subformula = subformula;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLIFormula getChild() {
		return this.subformula;
	}

}
