package formulae.cltloc.operators.binary;

import java.util.Arrays;

import formulae.BinaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocConjunction extends CLTLocFormula implements BinaryFormula<CLTLocFormula> {

	private final CLTLocFormula subformula1;
	private final CLTLocFormula subformula2;

	public CLTLocConjunction(CLTLocFormula subformula1, CLTLocFormula subformula2) {
		super(new String("(AND " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}

	public CLTLocConjunction(CLTLocFormula subformula1, CLTLocFormula... formulae) {
		super(new String(
				"(AND " + subformula1.strFormula() + " " + getString(formulae) + ")"));
		this.subformula1 = subformula1;
		if (formulae.length > 1) {
			this.subformula2 = new CLTLocConjunction(formulae[0], Arrays.copyOfRange(formulae, 1, formulae.length));
		} else {
			this.subformula2 = formulae[0];
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula getLeftChild() {
		return subformula1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula getRightChild() {
		return subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}

	private static String getString(CLTLocFormula[] formulae) {
		String returnString = formulae[formulae.length - 1].strFormula();
		for (int i = formulae.length - 2; i >= 0; i--) {
			returnString = "(AND " + formulae[i] + "" + returnString + ")";
		}
		return returnString;
	}
}
