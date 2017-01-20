package formulae.mitli.visitors;

import formulae.mitli.MITLIAtom;
import formulae.mitli.MITLIConjunction;
import formulae.mitli.MITLIDisjunction;
import formulae.mitli.MITLIEventually_AtoB;
import formulae.mitli.MITLIEventually_AtoInf;
import formulae.mitli.MITLIEventually_ZerotoB;
import formulae.mitli.MITLIFalse;
import formulae.mitli.MITLIFormula;
import formulae.mitli.MITLIGlobally_AtoB;
import formulae.mitli.MITLIGlobally_AtoInf;
import formulae.mitli.MITLIGlobally_ZerotoB;
import formulae.mitli.MITLIIff;
import formulae.mitli.MITLIImplies;
import formulae.mitli.MITLINegation;
import formulae.mitli.MITLIPast_AtoB;
import formulae.mitli.MITLIPast_ZerotoB;
import formulae.mitli.MITLIRelease;
import formulae.mitli.MITLISince;
import formulae.mitli.MITLITrue;
import formulae.mitli.MITLIUntil;

public class MITLI2ZotHeader implements MITLIVisitor<String> {

	public String defaultBehavior(MITLIFormula formula) {
		if ((formula.idFormula() != formula.isTheFormula) && (formula.maxIntComparedto() > 0)) {
			return new String("(define-tvar " + "z0_" + formula.idFormula() + " *real*)\n(define-tvar " + "z1_"
					+ formula.idFormula() + " *real*)\n");
		}
		return "";
	}

	@Override
	public String visit(MITLIDisjunction formula) {

		StringBuilder builder = new StringBuilder();
		formula.subformulae().forEach(f -> builder.append(f.accept(this)));
		return defaultBehavior(formula) + builder.toString();
	}

	@Override
	public String visit(MITLIFalse formula) {
		return defaultBehavior(formula) + "";
	}

	@Override
	public String visit(MITLITrue formula) {
		return defaultBehavior(formula) + "";
	}

	@Override
	public String visit(MITLIConjunction formula) {

		StringBuilder builder = new StringBuilder();
		formula.subformulae().forEach(f -> builder.append(f.accept(this)));
		return defaultBehavior(formula) + builder.toString();
	}

	@Override
	public String visit(MITLIAtom formula) {
		return defaultBehavior(formula) + "";
	}

	@Override
	public String visit(MITLINegation formula) {
		return defaultBehavior(formula) + formula.getChild().accept(this);
	}

	@Override
	public String visit(MITLIUntil formula) {
		return defaultBehavior(formula) + formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	@Override
	public String visit(MITLIImplies formula) {
		return defaultBehavior(formula) + formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	@Override
	public String visit(MITLIIff formula) {
		return defaultBehavior(formula) + formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	@Override
	public String visit(MITLISince formula) {
		return defaultBehavior(formula) + formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	@Override
	public String visit(MITLIGlobally_AtoInf formula) {
		return new String("(define-tvar " + "z0_" + formula.idFormula() + " *real*)\n(define-tvar " + "z1_"
				+ formula.idFormula() + " *real*)\n");
	}

	@Override
	public String visit(MITLIGlobally_AtoB mitliGlobally_AtoB) {

		int b = mitliGlobally_AtoB.upperbound();
		int a = mitliGlobally_AtoB.lowerbound();

		int d = 2 * (int) Math.ceil((float) b / (b - a));

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < d; i++) {
			builder.append("(define-tvar " + "x" + i + "_" + mitliGlobally_AtoB.idFormula() + " *real*)\n");
		}
		return builder.toString();
	}

	@Override
	public String visit(MITLIGlobally_ZerotoB formula) {
		return new String("(define-tvar " + "z0_" + formula.idFormula() + " *real*)\n(define-tvar " + "z1_"
				+ formula.idFormula() + " *real*)\n");
	}

	@Override
	public String visit(MITLIEventually_AtoB mitliEventually_AtoB) {

		int b = mitliEventually_AtoB.upperbound();
		int a = mitliEventually_AtoB.lowerbound();

		int d = 2 * (int) Math.ceil((float) b / (b - a));

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < d; i++) {
			builder.append("(define-tvar " + "x" + i + "_" + mitliEventually_AtoB.idFormula() + " *real*)\n");
		}
		return builder.toString();
	}

	@Override
	public String visit(MITLIEventually_AtoInf formula) {
		return new String("(define-tvar " + "z0_" + formula.idFormula() + " *real*)\n(define-tvar " + "z1_"
				+ formula.idFormula() + " *real*)\n");
	}

	@Override
	public String visit(MITLIEventually_ZerotoB formula) {

		return new String("(define-tvar " + "z0_" + formula.idFormula() + " *real*)\n(define-tvar " + "z1_"
				+ formula.idFormula() + " *real*)\n");

	}

	@Override
	public String visit(MITLIPast_AtoB formula) {
		return defaultBehavior(formula)+formula.getChild().accept(this);
	}

	@Override
	public String visit(MITLIPast_ZerotoB formula) {
		return defaultBehavior(formula)+formula.getChild().accept(this);
	}

	@Override
	public String visit(MITLIRelease formula) {
		return defaultBehavior(formula)+formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}
}
