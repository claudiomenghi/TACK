package formulae.mitl.visitors;

import formulae.mitl.MITLAtom;
import formulae.mitl.MITLConjunction;
import formulae.mitl.MITLEventually;
import formulae.mitl.MITLEventually_AtoB;
import formulae.mitl.MITLEventually_AtoInf;
import formulae.mitl.MITLEventually_ZerotoB;
import formulae.mitl.MITLFalse;
import formulae.mitl.MITLFormula;
import formulae.mitl.MITLNegation;
import formulae.mitl.MITLTrue;
import formulae.mitl.MITLUntil;

public class MITLUpdateVisitor implements MITLVisitor<MITLFormula> {

	@Override
	public MITLFormula visit(MITLAtom formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MITLFormula visit(MITLConjunction formula) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them
		if (formula.getLeftChild().equals(formula.getRightChild())) {
			return formula.getLeftChild();
		} else {
			return formula;
		}
	}

	@Override
	public MITLFormula visit(MITLEventually_AtoB formula) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them
		if (formula.equals(formula.getChild())) {
			return formula.getChild();
		} else {
			return formula;
		}
	}

	@Override
	public MITLFormula visit(MITLEventually_AtoInf formula) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them
		if (formula.equals(formula.getChild())) {
			return formula.getChild();
		} else {
			return formula;
		}
	}

	@Override
	public MITLFormula visit(MITLEventually_ZerotoB formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MITLFormula visit(MITLEventually formula) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them
		if (formula.equals(formula.getChild())) {
			return formula.getChild();
		} else {
			return formula;
		}
	}

	@Override
	public MITLFormula visit(MITLFalse formula) {
		return formula;
	}

	@Override
	public MITLFormula visit(MITLNegation formula) {
		return formula;
	}

	@Override
	public MITLFormula visit(MITLTrue formula) {
		return formula;
	}

	@Override
	public MITLFormula visit(MITLUntil formula) {
		return formula;
	}
}
