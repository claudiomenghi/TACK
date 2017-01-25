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

public class SimplifierVisitor implements MITLVisitor<MITLFormula> {

	@Override
	public MITLFormula visit(MITLAtom formula) {
		return formula;
	}

	@Override
	public MITLFormula visit(MITLConjunction formula) {
		return new MITLConjunction(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));
	}

	@Override
	public MITLFormula visit(MITLEventually_AtoB formula) {
		return new MITLEventually_AtoB(formula.getChild().accept(this), formula.lowerbound(), formula.upperbound());
	}

	@Override
	public MITLFormula visit(MITLEventually_AtoInf formula) {
		return new MITLEventually_AtoInf(formula.getChild().accept(this), formula.lowerbound());
	}

	@Override
	public MITLFormula visit(MITLEventually_ZerotoB formula) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MITLFormula visit(MITLFalse formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MITLFormula visit(MITLNegation formula) {
		return new MITLNegation(formula.getChild().accept(this));
	}

	@Override
	public MITLFormula visit(MITLTrue formula) {
		return formula;
	}

	@Override
	public MITLFormula visit(MITLUntil formula) {
		return new MITLUntil(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));

	}

	@Override
	public MITLFormula visit(MITLEventually formula) {
		// TODO Auto-generated method stub
		return null;
	}
}
