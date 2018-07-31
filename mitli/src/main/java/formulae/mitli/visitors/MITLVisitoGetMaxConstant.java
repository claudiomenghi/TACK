package formulae.mitli.visitors;

import formulae.mitli.MITLIConjunction;
import formulae.mitli.MITLIDisjunction;
import formulae.mitli.MITLIEventually_AtoB;
import formulae.mitli.MITLIEventually_AtoInf;
import formulae.mitli.MITLIEventually_ZerotoB;
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
import formulae.mitli.MITLIUntil;
import formulae.mitli.atoms.MITLIFalse;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.atoms.MITLITrue;

public class MITLVisitoGetMaxConstant implements MITLIVisitor<Integer> {

	@Override
	public Integer visit(MITLIDisjunction formula) {
		return Math.max(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));
	}

	@Override
	public Integer visit(MITLITrue formula) {
		return 0;
	}

	@Override
	public Integer visit(MITLIFalse formula) {
		return 0;
	}

	@Override
	public Integer visit(MITLIConjunction formula) {
			return Math.max(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));
	}

	@Override
	public Integer visit(MITLINegation formula) {
		return formula.getChild().accept(this);
	}

	@Override
	public Integer visit(MITLIUntil formula) {
		return Math.max(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));
	}

	@Override
	public Integer visit(MITLIRelease formula) {
		return Math.max(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));

	}

	@Override
	public Integer visit(MITLIImplies formula) {
		return Math.max(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));

	}

	@Override
	public Integer visit(MITLIIff formula) {
		return Math.max(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));

	}

	@Override
	public Integer visit(MITLISince formula) {
		return Math.max(formula.getLeftChild().accept(this), formula.getRightChild().accept(this));

	}

	@Override
	public Integer visit(MITLIGlobally_AtoInf formula) {
		return Math.max(formula.lowerbound(), Math.max(formula.upperbound(), formula.getChild().accept(this)));
	}

	@Override
	public Integer visit(MITLIGlobally_AtoB formula) {
		return Math.max(formula.lowerbound(), Math.max(formula.upperbound(), formula.getChild().accept(this)));
	}

	@Override
	public Integer visit(MITLIGlobally_ZerotoB formula) {
		return Math.max(formula.lowerbound(), Math.max(formula.upperbound(), formula.getChild().accept(this)));
	}

	@Override
	public Integer visit(MITLIEventually_AtoB formula) {
		return Math.max(formula.lowerbound(), Math.max(formula.upperbound(), formula.getChild().accept(this)));
	}

	@Override
	public Integer visit(MITLIEventually_AtoInf formula) {
		return Math.max(formula.lowerbound(), Math.max(formula.upperbound(), formula.getChild().accept(this)));
	}

	@Override
	public Integer visit(MITLIEventually_ZerotoB formula) {
		return Math.max(formula.lowerbound(), Math.max(formula.upperbound(), formula.getChild().accept(this)));
	}

	@Override
	public Integer visit(MITLIPast_AtoB formula) {
		return Math.max(formula.lowerbound(), Math.max(formula.upperbound(), formula.getChild().accept(this)));
	}

	@Override
	public Integer visit(MITLIPast_ZerotoB formula) {
		return Math.max(formula.lowerbound(), Math.max(formula.upperbound(), formula.getChild().accept(this)));
	}

	@Override
	public Integer visit(MITLIPropositionalAtom formula) {
		return 0;
	}

	@Override
	public Integer visit(MITLIRelationalAtom formula) {
		return 0;
	}

}
