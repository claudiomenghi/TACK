package formulae.mitl.visitors;

import formulae.mitl.MITLAtom;
import formulae.mitl.MITLConjunction;
import formulae.mitl.MITLEventually;
import formulae.mitl.MITLEventually_AtoB;
import formulae.mitl.MITLEventually_AtoInf;
import formulae.mitl.MITLEventually_ZerotoB;
import formulae.mitl.MITLFalse;
import formulae.mitl.MITLNegation;
import formulae.mitl.MITLTrue;
import formulae.mitl.MITLUntil;

public class MITL2ZotHeader implements MITLVisitor<String> {

	@Override
	public String visit(MITLAtom formula) {
		return new String("(define-tvar " + "zH_" + formula.idFormula() + " *real*)\n(define-tvar " + "zL_"
				+ formula.idFormula() + " *real*)\n");
	}

	@Override
	public String visit(MITLConjunction formula) {
		String res = new String("(define-tvar " + "zH_" + formula.idFormula() + " *real*)\n(define-tvar " + "zL_"
				+ formula.idFormula() + " *real*)\n");
		return res + formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	@Override
	public String visit(MITLEventually_AtoB formula) {
		String result = "";
		int b = formula.upperbound();
		int a = formula.lowerbound();

		int d = (int) Math.floor(b / (b - a) + 1) + 1;

		for (int i = 0; i < d; i++) {
			result = result + new String("(define-tvar " + "x" + i + "_" + formula.idFormula()
					+ " *real*)\n(define-tvar " + "y" + i + "_" + formula.idFormula() + " *real*)\n");
		}
		return result + formula.getChild().accept(this);
	}

	@Override
	public String visit(MITLEventually_AtoInf formula) {
		String res = new String("(define-tvar " + "zH_" + formula.idFormula() + " *real*)\n(define-tvar " + "zL_"
				+ formula.idFormula() + " *real*)\n");
		return res + formula.getChild().accept(this);
	}

	@Override
	public String visit(MITLEventually_ZerotoB formula) {
		String res = new String("(define-tvar " + "zH_" + formula.idFormula() + " *real*)\n(define-tvar " + "zL_"
				+ formula.idFormula() + " *real*)\n");
		return res + formula.getChild().accept(this);
	}

	@Override
	public String visit(MITLEventually formula) {
		String res = new String("(define-tvar " + "zH_" + formula.idFormula() + " *real*)\n(define-tvar " + "zL_"
				+ formula.idFormula() + " *real*)\n");
		return res + formula.getChild().accept(this);
	}

	@Override
	public String visit(MITLFalse formula) {
		return new String("(define-tvar " + "zH_" + formula.idFormula() + " *real*)\n(define-tvar " + "zL_"
				+ formula.idFormula() + " *real*)\n");
	}

	@Override
	public String visit(MITLNegation formula) {
		String res = new String("(define-tvar " + "zH_" + formula.idFormula() + " *real*)\n(define-tvar " + "zL_"
				+ formula.idFormula() + " *real*)\n");
		return res + formula.getChild().accept(this);
	}

	@Override
	public String visit(MITLTrue formula) {
		return new String("(define-tvar " + "zH_" + formula.idFormula() + " *real*)\n(define-tvar " + "zL_"
				+ formula.idFormula() + " *real*)\n");
	}

	@Override
	public String visit(MITLUntil formula) {
		String res = new String("(define-tvar " + "zH_" + formula.idFormula() + " *real*)\n(define-tvar " + "zL_"
				+ formula.idFormula() + " *real*)\n");
		return res + formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

}
