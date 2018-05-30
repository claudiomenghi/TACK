package formulae.mitli.visitors;

import java.util.ArrayList;
import java.util.List;

import formulae.mitli.MITLIConjunction;
import formulae.mitli.MITLIDisjunction;
import formulae.mitli.MITLIEventually_AtoB;
import formulae.mitli.MITLIEventually_AtoInf;
import formulae.mitli.MITLIEventually_ZerotoB;
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
import formulae.mitli.MITLIUntil;
import formulae.mitli.atoms.MITLIFalse;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.atoms.MITLITrue;

public class SubformulaeVisitor implements MITLIVisitor<List<MITLIFormula>> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIDisjunction formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLITrue formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIFalse formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.add(formula);
		return formulae;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIConjunction formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLINegation formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIUntil formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIRelease formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIImplies formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIIff formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLISince formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIGlobally_AtoInf formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIGlobally_AtoB formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIGlobally_ZerotoB formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIEventually_AtoB formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIEventually_AtoInf formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIEventually_ZerotoB formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIPast_AtoB formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MITLIFormula> visit(MITLIPast_ZerotoB formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	

	@Override
	public List<MITLIFormula> visit(MITLIPropositionalAtom formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.add(formula);
		return formulae;
	}

	@Override
	public List<MITLIFormula> visit(MITLIRelationalAtom formula) {
		List<MITLIFormula> formulae = new ArrayList<>();
		formulae.add(formula);
		return formulae;
	}

}
