package formulae.mitli.visitors;

import java.util.HashSet;
import java.util.Set;

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

public class GetRelationalAtomsVisitor implements MITLIVisitor<Set<MITLIRelationalAtom>> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIDisjunction formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLITrue formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		return formulae;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIFalse formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIConjunction formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLINegation formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIUntil formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIRelease formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIImplies formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIIff formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLISince formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIGlobally_AtoInf formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIGlobally_AtoB formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIGlobally_ZerotoB formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIEventually_AtoB formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIEventually_AtoInf formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIEventually_ZerotoB formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIPast_AtoB formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIRelationalAtom> visit(MITLIPast_ZerotoB formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}


	@Override
	public Set<MITLIRelationalAtom> visit(MITLIPropositionalAtom formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		return formulae;
	}

	@Override
	public Set<MITLIRelationalAtom> visit(MITLIRelationalAtom formula) {
		Set<MITLIRelationalAtom> formulae = new HashSet<>();
		formulae.add(formula);
		return formulae;
	}

}
