package formulae.mitli;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLITrue extends MITLIFormula {
	
	
	public MITLITrue() {
		super(new String("TRUE"));
	}

	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}


}
