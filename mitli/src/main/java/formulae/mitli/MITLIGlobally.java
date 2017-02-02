package formulae.mitli;

import formulae.UnaryFormula;
import formulae.mitli.TemporizedFormula;


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
