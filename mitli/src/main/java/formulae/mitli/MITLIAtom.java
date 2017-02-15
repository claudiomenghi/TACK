package formulae.mitli;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLIAtom extends MITLIFormula {

	private final String atomName;

	public MITLIAtom(String atom) {
		this.atomName = atom;
	}

	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
