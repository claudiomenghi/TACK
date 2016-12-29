package formulae.mitli;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLIAtom extends MITLIFormula {

	public MITLIAtom(String atom) {
		super(atom);
	}

	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
