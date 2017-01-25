package formulae.mitl;

import formulae.mitl.visitors.MITLVisitor;

public class MITLAtom extends MITLFormula {

	public MITLAtom(String atom) {
		super(atom);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
