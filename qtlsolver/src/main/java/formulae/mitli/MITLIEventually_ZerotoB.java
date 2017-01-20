package formulae.mitli;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLIEventually_ZerotoB extends MITLIEventually_AtoB {

	public MITLIEventually_ZerotoB(MITLIFormula subformula, int b) {
		super(subformula, 0, b);

		this.maxIntComparedto(b);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
