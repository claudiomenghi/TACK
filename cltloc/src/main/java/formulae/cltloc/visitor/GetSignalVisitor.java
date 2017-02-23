package formulae.cltloc.visitor;

import java.util.HashSet;
import java.util.Set;

import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocConstantAtom;
import formulae.cltloc.atoms.CLTLocSignal;
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

public class GetSignalVisitor implements CLTLocVisitor<Set<CLTLocSignal>> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocDisjunction formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocConjunction formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocNegation formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocUntil formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocImplies formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocIff formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocSince formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocRelease formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocNext formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocGlobally formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocEventually formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocYesterday formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocRelation formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocAP formula) {
		return  new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocClock cltlClock) {
		return  new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocConstantAtom cltlConstantAtom) {
		return  new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocSignal> visit(CLTLocSignal formula) {
		Set<CLTLocSignal> formulae = new HashSet<>();
		formulae.add(formula);
		return formulae;
	}

}