package formulae.mitli.visitors;

import java.util.ArrayList;
import java.util.List;

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

public class MITLISimplifyVisitor implements MITLIVisitor<MITLIFormula> {

	@Override
	public MITLIFormula visit(MITLITrue mitliTrue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MITLIFormula visit(MITLIFalse formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MITLIFormula visit(MITLIAtom formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MITLIFormula visit(MITLIConjunction formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formula.subformulae().forEach(f -> formulae.add(f.accept(this)));
		return new MITLIConjunction(formulae.toArray(new MITLIFormula[formulae.size()]));
	}

	@Override
	public MITLIFormula visit(MITLIDisjunction formula) {

		List<MITLIFormula> formulae = new ArrayList<>();
		formula.subformulae().forEach(f -> formulae.add(f.accept(this)));
		return new MITLIDisjunction(formulae.toArray(new MITLIFormula[formulae.size()]));
	}

	@Override
	public MITLIFormula visit(MITLINegation mitliNegation) {
		if (mitliNegation.getChild().getClass() == MITLINegation.class) {
			MITLINegation child = (MITLINegation) mitliNegation.getChild();
			return child.getChild().accept(this);
		} else {
			return new MITLINegation(mitliNegation.getChild().accept(this));
		}
	}

	@Override
	public MITLIFormula visit(MITLIUntil formula) {
		return new MITLIUntil(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));
	}

	@Override
	public MITLIFormula visit(MITLIImplies mitliImplies) {
		return new MITLIImplies(mitliImplies.getLeftChild().accept(this), mitliImplies.getRightChild().accept(this));
	}

	@Override
	public MITLIFormula visit(MITLIIff formula) {
		return new MITLIIff(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));
	}

	@Override
	public MITLIFormula visit(MITLISince formula) {
		return new MITLISince(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));
	}

	@Override
	public MITLIFormula visit(MITLIGlobally_AtoInf formula) {
		return new MITLIGlobally_AtoInf(formula.getChild().accept(this), formula.lowerbound());
	}

	@Override
	public MITLIFormula visit(MITLIGlobally_AtoB formula) {
		return new MITLIGlobally_AtoB(formula.getChild().accept(this), formula.lowerbound(), formula.upperbound());
	}

	@Override
	public MITLIFormula visit(MITLIGlobally_ZerotoB formula) {
		return new MITLIGlobally_ZerotoB(formula.getChild().accept(this), formula.upperbound());
	}

	@Override
	public MITLIFormula visit(MITLIEventually_AtoB formula) {
		return new MITLIEventually_AtoB(formula.getChild().accept(this), formula.lowerbound(), formula.upperbound());
	}

	@Override
	public MITLIFormula visit(MITLIEventually_AtoInf formula) {
		return new MITLIEventually_AtoInf(formula.getChild().accept(this), formula.lowerbound());
	}

	@Override
	public MITLIFormula visit(MITLIEventually_ZerotoB formula) {
		return new MITLIEventually_ZerotoB(formula.getChild().accept(this), formula.upperbound());
	}

	@Override
	public MITLIFormula visit(MITLIPast_AtoB formula) {
		return new MITLIPast_AtoB(formula.getChild().accept(this), formula.lowerbound(), formula.upperbound());
	}

	@Override
	public MITLIFormula visit(MITLIPast_ZerotoB formula) {
		return new MITLIPast_ZerotoB(formula.getChild().accept(this), formula.upperbound());
	}

	@Override
	public MITLIFormula visit(MITLIRelease formula) {
		return new MITLIRelease(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));
	}
}
