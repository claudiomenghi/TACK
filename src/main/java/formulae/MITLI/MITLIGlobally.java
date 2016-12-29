package formulae.mitli;

import formulae.TemporizedFormula;
import formulae.UnaryFormula;

public abstract class MITLIGlobally extends MITLIFormula implements TemporizedFormula, UnaryFormula<MITLIFormula> {

	private final MITLIFormula subformula;

	public MITLIGlobally(MITLIFormula subformula, String formulaDescription) {
		super(formulaDescription);
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
