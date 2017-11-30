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
	public Set<CLTLocAP> visit(CLTLocClock cltlClock) {
		return  new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(Constant cltlConstantAtom) {
		return  new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(Signal formula) {
		return new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(Variable cltLocVariable) {
		return new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CLTLocAP> visit(KeepVariableConstant keepVariableConstant) {
		return new HashSet<>();
	}

	@Override
	public Set<CLTLocAP> visit(CLTLocSelector formula) {
		return new HashSet<>();
	}

	@Override
	public Set<CLTLocAP> visit(AssignNextVariable formula) {
		return new HashSet<>();
	}

	@Override
	public Set<CLTLocAP> visit(BoundedVariable variable) {
		return new HashSet<>();

	}

	@Override
	public Set<CLTLocAP> visit(KeepBoundedVariableConstant variable) {
		return new HashSet<>();

	}

	@Override
	public Set<CLTLocAP> visit(CLTLocNaryConjunction cltLocNaryConjunction) {
		Set<CLTLocAP> formulae = new HashSet<>();
		
		for(CLTLocFormula f : cltLocNaryConjunction.getChildren()){
			formulae.addAll(f.accept(this));
		}
		return formulae;		
	}

	@Override
	public Set<CLTLocAP> visit(CLTLocNaryDisjunction cltLocNaryDisjunction) {
		Set<CLTLocAP> formulae = new HashSet<>();
		
		for(CLTLocFormula f : cltLocNaryDisjunction.getChildren()){
			formulae.addAll(f.accept(this));
		}
		return formulae;	
	}
	
	@Override
	public  Set<CLTLocAP>  visit(CLTLocArithmeticExpression binaryArithmeticExpression) {
		return new HashSet<>();
	}
	
	@Override
	public Set<CLTLocAP> visit(AssignVariable assignVariable) {
		return new HashSet<>();
	}

}