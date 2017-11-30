package formulae.cltloc.visitor;

import java.util.HashSet;
import java.util.Set;

import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocSelector;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.KeepBoundedVariableConstant;
import formulae.cltloc.atoms.KeepVariableConstant;
import formulae.cltloc.atoms.Signal;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.AssignNextVariable;
import formulae.cltloc.atoms.AssignVariable;
import formulae.cltloc.atoms.CLTLocArithmeticExpression;
import formulae.cltloc.atoms.BoundedVariable;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.binary.CLTLocNaryConjunction;
import formulae.cltloc.operators.binary.CLTLocNaryDisjunction;
import formulae.cltloc.operators.binary.CLTLocRelease;
import formulae.cltloc.operators.binary.CLTLocSince;
import formulae.cltloc.operators.binary.CLTLocUntil;
import formulae.cltloc.operators.unary.CLTLocEventually;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.relations.CLTLocRelation;

public class GetSignalVisitor implements CLTLocVisitor<Set<Signal>> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocDisjunction formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocConjunction formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocNegation formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocUntil formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocImplies formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocIff formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocSince formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocRelease formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocNext formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocGlobally formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocEventually formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocYesterday formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocRelation formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocAP formula) {
		return  new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(CLTLocClock cltlClock) {
		return  new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(Constant cltlConstantAtom) {
		return  new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(Signal formula) {
		Set<Signal> formulae = new HashSet<>();
		formulae.add(formula);
		return formulae;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Signal> visit(Variable cltLocVariable) {
		return new HashSet<>();
	}

	@Override
	public Set<Signal> visit(KeepVariableConstant keepVariableConstant) {
		return new HashSet<>();
	}

	@Override
	public Set<Signal> visit(CLTLocSelector formula) {
		return new HashSet<>();
	}

	@Override
	public Set<Signal> visit(AssignNextVariable formula) {
		return new HashSet<>();
	}

	@Override
	public Set<Signal> visit(BoundedVariable variable) {
		return new HashSet<>();
	}

	@Override
	public Set<Signal> visit(KeepBoundedVariableConstant variable) {
		return new HashSet<>();
	}

	@Override
	public Set<Signal> visit(CLTLocNaryConjunction cltLocNaryConjunction) {
		Set<Signal> formulae = new HashSet<>();
		for(CLTLocFormula f: cltLocNaryConjunction.getChildren()){
			formulae.addAll(f.accept(this));
		}
		return formulae;
	}

	@Override
	public Set<Signal> visit(CLTLocNaryDisjunction cltLocNaryDisjunction) {
		Set<Signal> formulae = new HashSet<>();
		for(CLTLocFormula f: cltLocNaryDisjunction.getChildren()){
			formulae.addAll(f.accept(this));
		}
		return formulae;
	}
	
	@Override
	public Set<Signal> visit(CLTLocArithmeticExpression binaryArithmeticExpression) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(binaryArithmeticExpression.getLeftChild().accept(this));
		formulae.addAll(binaryArithmeticExpression.getRightChild().accept(this));
		return formulae;
	}
	
	@Override
	public Set<Signal> visit(AssignVariable assignVariable) {
		Set<Signal> formulae = new HashSet<>();
		formulae.addAll(assignVariable.getExpression().accept(this));

		return formulae;
	}
}