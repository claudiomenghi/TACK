package formulae.mitli;

import formulae.UnaryFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLINegation extends MITLIFormula implements UnaryFormula<MITLIFormula> {

	// Formula f1 which is argument of the negation (\neg f1)
	private MITLIFormula subformula;

	public MITLINegation(MITLIFormula subformula) {
		super(new String("(NEG " + subformula.strFormula()) + ")");
		this.subformula = subformula;
	}

	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public MITLIFormula getChild() {
		return this.subformula;
	}

}
