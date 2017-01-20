package formulae.mitl;

import formulae.mitl.visitors.MITLVisitor;

public class MITLEventually_ZerotoB extends MITLEventually_AtoB{
	
	public MITLEventually_ZerotoB(MITLFormula subformula, int b) {
		super(subformula, 0, b);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
	


