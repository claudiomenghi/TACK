package formulae.cltloc.visitor;

import java.util.HashSet;
import java.util.Set;

import formulae.cltloc.atoms.CLTLClock;
import formulae.cltloc.atoms.CLTLConstantAtom;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.binary.CLTLocRelease;
import formulae.cltloc.operators.binary.CLTLocSince;
import formulae.cltloc.operators.binary.CLTLocUntil;
import formulae.cltloc.operators.unary.CLTLocEventually;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.relations.CLTLocRelation;

public class GetAPVisitor implements CLTLocVisitor<Set<CLTLocAP>> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocDisjunction formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocConjunction formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocNegation formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocUntil formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocImplies formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocIff formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocSince formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocRelease formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocNext formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocGlobally formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocEventually formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocYesterday formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocRelation formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLClock formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLocAP formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(CLTLConstantAtom formula) {
		Set<CLTLocAP> formulae = new HashSet<>();
		return formulae;
	}
}