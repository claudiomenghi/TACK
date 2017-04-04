package formulae.mitli;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLIPast_ZerotoB extends MITLIPast_AtoB {

	public MITLIPast_ZerotoB(MITLIFormula subformula, int b) {
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
