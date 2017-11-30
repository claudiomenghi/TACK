package formulae.cltloc.visitor;

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

public class CLTLocGetMaxBound implements CLTLocVisitor<Integer>{

	@Override
	public Integer visit(CLTLocConjunction formula) {
		
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Integer visit(CLTLocNegation formula) {
		return formula.getChild().accept(this);
	}

	@Override
	public Integer visit(CLTLocUntil formula) {
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Integer visit(CLTLocImplies formula) {
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Integer visit(CLTLocIff formula) {
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Integer visit(CLTLocNext formula) {
		return formula.getChild().accept(this);
	}

	@Override
	public Integer visit(CLTLocGlobally formula) {
		return formula.getChild().accept(this);
	}

	@Override
	public Integer visit(CLTLocEventually formula) {
		return formula.getChild().accept(this);
	}

	@Override
	public Integer visit(CLTLocSince formula) {
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Integer visit(CLTLocYesterday formula) {
		return formula.getChild().accept(this);
	}

	@Override
	public Integer visit(CLTLocRelease formula) {
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Integer visit(CLTLocRelation formula) {
		if(formula.getLeftChild() instanceof CLTLocClock && formula.getRightChild() instanceof Constant){
			return Integer.parseInt(((Constant) formula.getRightChild()).getValue());
		}
		if(formula.getRightChild() instanceof CLTLocClock && formula.getLeftChild() instanceof Constant){
			return Integer.parseInt(((Constant) formula.getLeftChild()).getValue());
		}
		return 0;
	}

	@Override
	public Integer visit(CLTLocDisjunction formula) {
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Integer visit(CLTLocAP formula) {
		return 0;
	}

	@Override
	public Integer visit(CLTLocClock cltlClock) {
		return 0;

	}

	@Override
	public Integer visit(Constant cltlConstantAtom) {
		return 0;
	}

	@Override
	public Integer visit(Signal formula) {
return 0;
	}

	@Override
	public Integer visit(Variable cltLocVariable) {
return 0;
	}

	@Override
	public Integer visit(KeepVariableConstant keepVariableConstant) {
		return 0;
	}

	@Override
	public Integer visit(CLTLocSelector formula) {
		return 0;
	}

	@Override
	public Integer visit(AssignNextVariable formula) {
		return 0;
	}

	@Override
	public Integer visit(BoundedVariable variable) {
		return 0;
	}

	@Override
	public Integer visit(KeepBoundedVariableConstant variable) {
		return 0;
	}

	@Override
	public Integer visit(CLTLocNaryConjunction cltLocNaryConjunction) {
		
		int max=cltLocNaryConjunction.getChildren().iterator().next().accept(this);
		
		for(CLTLocFormula f:cltLocNaryConjunction.getChildren() ){
			max=Math.max(max, f.accept(this));
		}
		return max;
	}

	@Override
	public Integer visit(CLTLocNaryDisjunction cltLocNaryDisjunction) {
		int max=cltLocNaryDisjunction.getChildren().iterator().next().accept(this);
		
		for(CLTLocFormula f:cltLocNaryDisjunction.getChildren() ){
			max=Math.max(max, f.accept(this));
		}
		return max;
	}
	
	@Override
	public Integer visit(CLTLocArithmeticExpression binaryArithmeticExpression) {
		return 0;
	}
	
	@Override
	public Integer visit(AssignVariable assignVariable) {
		return 0;
	}
}


