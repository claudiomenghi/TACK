package formulae.mitli;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLIGlobally_ZerotoB extends MITLIGlobally_AtoB {

	public MITLIGlobally_ZerotoB(MITLIFormula subformula, int b) {
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
