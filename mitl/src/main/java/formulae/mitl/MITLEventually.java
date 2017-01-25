package formulae.mitl;

import formulae.UnaryFormula;

public abstract class MITLEventually extends MITLFormula implements TemporizedFormula,UnaryFormula<MITLFormula> {

	private final MITLFormula subformula;

	public MITLEventually(MITLFormula subformula, String representation) {
		super(representation);
		this.subformula=subformula;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLFormula getChild() {
		return this.subformula;
	} 
}
