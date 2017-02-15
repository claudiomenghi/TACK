package formulae.mitli;

import formulae.mitli.visitors.MITLIVisitor;
public class MITLIFalse extends MITLIAtom {

	public MITLIFalse() {
		super(new String("FALSE"));
	}

	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
