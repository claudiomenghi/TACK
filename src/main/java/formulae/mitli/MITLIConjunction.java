package formulae.mitli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLIConjunction extends MITLIFormula {

	private List<MITLIFormula> subformulae;

	public MITLIConjunction(MITLIFormula... args) {

		super(new String("(AND " + toStringForm(args) + ")"));
		this.subformulae = Arrays.asList(args);
	}

	public List<MITLIFormula> subformulae(){
		return new ArrayList<>(subformulae);
	}
	
	private static String toStringForm(MITLIFormula... args) {
		String result = new String("");

		for (MITLIFormula f : args)
			result = result + " " + f.strFormula();

		return result;
	}

	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
