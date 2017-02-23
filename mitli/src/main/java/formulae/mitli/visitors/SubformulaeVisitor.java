package formulae.mitli.visitors;

import java.util.HashSet;
import java.util.Set;

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

public class SubformulaeVisitor implements MITLIVisitor<Set<MITLIFormula>> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIDisjunction formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIFalse formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLITrue formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIConjunction formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLINegation formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIUntil formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIImplies formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIIff formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLISince formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIGlobally_AtoInf formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIGlobally_AtoB formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIGlobally_ZerotoB formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIEventually_AtoB formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIEventually_AtoInf formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIEventually_ZerotoB formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIPast_AtoB formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIPast_ZerotoB formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> visit(MITLIRelease formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		formulae.add(formula);
		return formulae;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIPropositionalAtom formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.add(formula);
		return formulae;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIRelationalAtom formula) {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.add(formula);
		return formulae;
	}

}
