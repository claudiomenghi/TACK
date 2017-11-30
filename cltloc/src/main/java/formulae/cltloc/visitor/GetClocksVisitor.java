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

public class GetClocksVisitor implements CLTLocVisitor<Set<CLTLocClock>> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocDisjunction formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocConjunction formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocNegation formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocUntil formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocImplies formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocIff formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocSince formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocRelease formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocNext formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocGlobally formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocEventually formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocYesterday formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocRelation formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocClock formula) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.add(formula);
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(CLTLocAP formula) {
		return new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(Constant cltlConstantAtom) {
		return new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(Signal formula) {
		return new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(Variable cltLocVariable) {
		return new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocClock> visit(KeepVariableConstant keepVariableConstant) {
		return new HashSet<>();
	}

	@Override
	public Set<CLTLocClock> visit(CLTLocSelector formula) {
		return new HashSet<>();
	}

	@Override
	public Set<CLTLocClock> visit(AssignNextVariable formula) {
		return new HashSet<>();
	}

	@Override
	public Set<CLTLocClock> visit(BoundedVariable variable) {
		return new HashSet<>();
	}

	@Override
	public Set<CLTLocClock> visit(KeepBoundedVariableConstant variable) {
		return new HashSet<>();
	}

	@Override
	public Set<CLTLocClock> visit(CLTLocNaryConjunction cltLocNaryConjunction) {
		Set<CLTLocClock> formulae = new HashSet<>();
		for (CLTLocFormula f : cltLocNaryConjunction.getChildren()) {
			formulae.addAll(f.accept(this));
		}
		return formulae;
	}

	@Override
	public Set<CLTLocClock> visit(CLTLocNaryDisjunction cltLocNaryDisjunction) {
		Set<CLTLocClock> formulae = new HashSet<>();
		for (CLTLocFormula f : cltLocNaryDisjunction.getChildren()) {
			formulae.addAll(f.accept(this));
		}
		return formulae;
	}

	@Override
	public Set<CLTLocClock> visit(CLTLocArithmeticExpression binaryArithmeticExpression) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(binaryArithmeticExpression.getLeftChild().accept(this));
		formulae.addAll(binaryArithmeticExpression.getRightChild().accept(this));
		return formulae;
	}

	@Override
	public Set<CLTLocClock> visit(AssignVariable assignVariable) {
		Set<CLTLocClock> formulae = new HashSet<>();
		formulae.addAll(assignVariable.getExpression().accept(this));

		return formulae;
	}
}
