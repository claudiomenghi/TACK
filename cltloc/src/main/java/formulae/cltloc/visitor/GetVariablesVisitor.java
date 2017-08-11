package formulae.cltloc.visitor;

import java.util.HashSet;
import java.util.Set;

import formulae.cltloc.atoms.AssignNextVariable;
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
import formulae.cltloc.operators.binary.CLTLocRelease;
import formulae.cltloc.operators.binary.CLTLocSince;
import formulae.cltloc.operators.binary.CLTLocUntil;
import formulae.cltloc.operators.unary.CLTLocEventually;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.relations.CLTLocRelation;

public class GetVariablesVisitor implements CLTLocVisitor<Set<Variable>> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocDisjunction formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocConjunction formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocNegation formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocUntil formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocImplies formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocIff formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocSince formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocRelease formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocNext formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocGlobally formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocEventually formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocYesterday formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocRelation formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.addAll(formula.getLeftChild().accept(this));
		formulae.addAll(formula.getRightChild().accept(this));
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocClock formula) {
		Set<Variable> formulae = new HashSet<>();
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(CLTLocAP formula) {
		return new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(Constant cltlConstantAtom) {
		return new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(Signal formula) {
		return new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(Variable formula) {
		Set<Variable> formulae = new HashSet<>();
		if(!(formula instanceof BoundedVariable))
			formulae.add(formula);
		
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> visit(KeepVariableConstant keepVariableConstant) {
		Set<Variable> formulae = new HashSet<>();
		if (keepVariableConstant instanceof KeepBoundedVariableConstant) {
			return formulae;
		}
		formulae.add(keepVariableConstant.getVariable());
		return formulae;
	}

	@Override
	public Set<Variable> visit(CLTLocSelector formula) {
		return new HashSet<>();
	}

	@Override
	public Set<Variable> visit(AssignNextVariable formula) {
		Set<Variable> formulae = new HashSet<>();
		formulae.add(formula.getVariable());
		formulae.add(formula.getNextVariable());
		return formulae;
	}

	@Override
	public Set<Variable> visit(BoundedVariable variable) {
		return new HashSet<>();
	}

	@Override
	public Set<Variable> visit(KeepBoundedVariableConstant variable) {
		return new HashSet<>();
	}
}
