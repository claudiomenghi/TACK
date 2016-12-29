package formulae.mitl;

import formulae.mitl.visitors.MITLVisitor;

public class MITLFalse extends MITLFormula {

	public MITLFalse() {
		super(new String("FALSE"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
