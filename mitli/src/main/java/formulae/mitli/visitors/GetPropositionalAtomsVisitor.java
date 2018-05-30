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
import formulae.mitli.MITLISince;
import formulae.mitli.MITLIUntil;
import formulae.mitli.MITLIRelease;
import formulae.mitli.atoms.MITLIFalse;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.atoms.MITLITrue;

public class GetPropositionalAtomsVisitor implements MITLIVisitor<Set<MITLIPropositionalAtom>> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIDisjunction formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLITrue formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIFalse formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		return formulae;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIConjunction formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLINegation formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIUntil formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIRelease formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIImplies formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIIff formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLISince formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIGlobally_AtoInf formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIGlobally_AtoB formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIGlobally_ZerotoB formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIEventually_AtoB formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIEventually_AtoInf formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIEventually_ZerotoB formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIPast_AtoB formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIPast_ZerotoB formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	

	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIPropositionalAtom formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		formulae.add(formula);
		return formulae;
	}

	@Override
	public Set<MITLIPropositionalAtom> visit(MITLIRelationalAtom formula) {
		Set<MITLIPropositionalAtom> formulae = new HashSet<>();
		return formulae;
	}

}
