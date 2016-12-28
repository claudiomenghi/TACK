package formulae.mitli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLIDisjunction extends MITLIFormula {

	private List<MITLIFormula> subformulae;

	public MITLIDisjunction(MITLIFormula... args) {
		super(new String("(OR " + toStringForm(args) + ")"));
		this.subformulae = Arrays.asList(args);
	}

	private static String toStringForm(MITLIFormula... args) {
		String result = new String("");

		for (MITLIFormula f : args)
			result = result + " " + f.strFormula();

		return result;
	}

	public List<MITLIFormula> subformulae() {
		return new ArrayList<>(subformulae);
	}

	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
