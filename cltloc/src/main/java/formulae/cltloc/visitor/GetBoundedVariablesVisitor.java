package formulae.cltloc.visitor;

import java.util.HashSet;
import java.util.Set;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.AssignNextVariable;
import formulae.cltloc.atoms.AssignVariable;
import formulae.cltloc.atoms.CLTLocArithmeticExpression;
import formulae.cltloc.atoms.BoundedVariable;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocSelector;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.KeepBoundedVariableConstant;
import formulae.cltloc.atoms.KeepVariableConstant;
import formulae.cltloc.atoms.Signal;
import formulae.cltloc.atoms.Variable;
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

public class GetBoundedVariablesVisitor implements CLTLocVisitor<Set<BoundedVariable>> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocDisjunction formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocConjunction formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocNegation formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocUntil formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocImplies formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocIff formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocSince formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocRelease formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocNext formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocGlobally formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocEventually formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocYesterday formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocRelation formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocClock formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(CLTLocAP formula) {
		return new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(Constant cltlConstantAtom) {
		return new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(Signal formula) {
		return new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(Variable formula) {
		Set<BoundedVariable> formulae = new HashSet<>();
		if ((formula instanceof BoundedVariable))
			formulae.add((BoundedVariable) formula);

		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BoundedVariable> visit(KeepVariableConstant keepVariableConstant) {
		return new HashSet<>();
	}

	@Override
	public Set<BoundedVariable> visit(CLTLocSelector formula) {
		return new HashSet<>();
	}

	@Override
	public Set<BoundedVariable> visit(AssignNextVariable formula) {
		return new HashSet<>();
	}

	@Override
	public Set<BoundedVariable> visit(BoundedVariable variable) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.add(variable);
		return formulae;
	}

	@Override
	public Set<BoundedVariable> visit(KeepBoundedVariableConstant variable) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.add((BoundedVariable) variable.getVariable());
		return formulae;
	}

	@Override
	public Set<BoundedVariable> visit(CLTLocNaryConjunction cltLocNaryConjunction) {
		Set<BoundedVariable> formulae = new HashSet<>();
		for (CLTLocFormula f : cltLocNaryConjunction.getChildren()) {
			formulae.addAll(f.accept(this));
		}
		return formulae;
	}

	@Override
	public Set<BoundedVariable> visit(CLTLocNaryDisjunction cltLocNaryDisjunction) {
		Set<BoundedVariable> formulae = new HashSet<>();
		for (CLTLocFormula f : cltLocNaryDisjunction.getChildren()) {
			formulae.addAll(f.accept(this));
		}
		return formulae;
	}

	@Override
	public Set<BoundedVariable> visit(CLTLocArithmeticExpression binaryArithmeticExpression) {
		Set<BoundedVariable> formulae = new HashSet<>();
		formulae.addAll(binaryArithmeticExpression.getLeftChild().accept(this));
		formulae.addAll(binaryArithmeticExpression.getRightChild().accept(this));
		return formulae;
	}

	@Override
	public Set<BoundedVariable> visit(AssignVariable assignVariable) {
		Set<BoundedVariable> formulae = new HashSet<>();
		if ((assignVariable.getVariable() instanceof BoundedVariable))
			formulae.add((BoundedVariable) assignVariable.getVariable() );

		formulae.addAll(assignVariable.getExpression().accept(this));
		return formulae;
		
	}
}
