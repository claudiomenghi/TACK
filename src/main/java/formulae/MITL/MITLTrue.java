package formulae.mitl;

import formulae.mitl.visitors.MITLVisitor;

public class MITLTrue extends MITLFormula {

	public MITLTrue() {
		super(new String("TRUE"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
