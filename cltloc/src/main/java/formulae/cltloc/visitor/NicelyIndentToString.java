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

public class NicelyIndentToString implements CLTLocVisitor<String> {

	int indentValue=0;
	
	public String computegetIndet(){
		StringBuilder finalFormula=new StringBuilder();
		for(int i=0;i<indentValue; i++){
			finalFormula.append(" ");
		}
		return finalFormula.toString();
	}
	
	@Override
	public String visit(CLTLocConjunction formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+"\n");
		finalFormula.append(formula.getLeftChild().accept(this));
		finalFormula.append(indent+formula.operator+"\n");
		finalFormula.append(formula.getRightChild().accept(this));
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocNegation formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+formula.operator+"\n");
		finalFormula.append(formula.getChild().accept(this));
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocUntil formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+"\n");
		finalFormula.append(formula.getLeftChild().accept(this));
		finalFormula.append(indent+formula.operator+"\n");
		finalFormula.append(formula.getRightChild().accept(this));
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocImplies formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+"\n");
		finalFormula.append(formula.getLeftChild().accept(this));
		finalFormula.append(indent+formula.operator+"\n");
		finalFormula.append(formula.getRightChild().accept(this));
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocIff formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+"\n");
		finalFormula.append(formula.getLeftChild().accept(this));
		finalFormula.append(indent+formula.operator+"\n");
		finalFormula.append(formula.getRightChild().accept(this));
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocNext formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+formula.operator+"\n");
		finalFormula.append(formula.getChild().accept(this));
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocGlobally formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+formula.operator+"\n");
		finalFormula.append(formula.getChild().accept(this));
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocEventually formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+formula.operator+"\n");
		finalFormula.append(formula.getChild().accept(this));
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocSince formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+"\n");
		finalFormula.append(formula.getLeftChild().accept(this));
		finalFormula.append(indent+formula.operator+"\n");
		finalFormula.append(formula.getRightChild().accept(this));
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocYesterday formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+formula.operator+"\n");
		finalFormula.append(formula.getChild().accept(this));
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocRelease formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+"\n");
		finalFormula.append(formula.getLeftChild().accept(this));
		finalFormula.append(indent+formula.operator+"\n");
		finalFormula.append(formula.getRightChild().accept(this));
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocRelation formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+formula.getLeftChild().accept(this)+formula.getRelation()+formula.getRightChild().accept(this)+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocDisjunction formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+"\n");
		finalFormula.append(formula.getLeftChild().accept(this));
		finalFormula.append(indent+formula.operator+"\n");
		finalFormula.append(formula.getRightChild().accept(this));
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocAP formula) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+formula.toString()+"\n");
		
		indentValue--;
		return finalFormula.toString();
		
	}

	@Override
	public String visit(CLTLocClock cltlClock) {
		StringBuilder finalFormula=new StringBuilder();
		finalFormula.append(cltlClock.toString());
		
		return finalFormula.toString();
	}

	@Override
	public String visit(Constant cltlConstantAtom) {
		StringBuilder finalFormula=new StringBuilder();
		finalFormula.append(cltlConstantAtom.toString());
		
		return finalFormula.toString();
	}

	@Override
	public String visit(Signal formula) {
		StringBuilder finalFormula=new StringBuilder();
		finalFormula.append(formula.toString());
		return finalFormula.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(Variable formula) {
		StringBuilder finalFormula=new StringBuilder();
		finalFormula.append(formula.toString());
		return finalFormula.toString();
	}

	@Override
	public String visit(KeepVariableConstant keepVariableConstant) {
		StringBuilder finalFormula=new StringBuilder();
		finalFormula.append(keepVariableConstant.toString());
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocSelector formula) {
		StringBuilder finalFormula=new StringBuilder();
		finalFormula.append(formula.toString());
		return finalFormula.toString();
	}

	@Override
	public String visit(AssignNextVariable formula) {
		StringBuilder finalFormula=new StringBuilder();
		finalFormula.append(formula.toString());
		return finalFormula.toString();
	}

	@Override
	public String visit(BoundedVariable variable) {
		StringBuilder finalFormula=new StringBuilder();
		finalFormula.append(variable.toString());
		return finalFormula.toString();
	}

	@Override
	public String visit(KeepBoundedVariableConstant variable) {
		StringBuilder finalFormula=new StringBuilder();
		finalFormula.append(variable.toString());
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocNaryConjunction cltLocNaryConjunction) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+"\n");
		for(CLTLocFormula f: cltLocNaryConjunction.getChildren()){
			finalFormula.append(f.accept(this));
			finalFormula.append(indent+cltLocNaryConjunction.operator+"\n");
		}
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocNaryDisjunction cltLocNaryDisjunction) {
		indentValue++;
		StringBuilder finalFormula=new StringBuilder();
		String indent=this.computegetIndet();
		finalFormula.append(indent+"("+"\n");
		for(CLTLocFormula f: cltLocNaryDisjunction.getChildren()){
			finalFormula.append(f.accept(this));
			finalFormula.append(indent+cltLocNaryDisjunction.operator+"\n");
		}
		finalFormula.append(indent+")"+"\n");
		indentValue--;
		
		return finalFormula.toString();
	}
	
	@Override
	public String visit(CLTLocArithmeticExpression binaryArithmeticExpression) {
		return "([" + binaryArithmeticExpression.getOperator() + "] "
				+ binaryArithmeticExpression.getLeftChild().accept(this) + " "
				+ binaryArithmeticExpression.getRightChild().accept(this) + " )";
	}
	
	@Override
	public String visit(AssignVariable assignVariable) {
		return "([=] (-V- " + assignVariable.getVariable() + ")  " + assignVariable.getExpression().accept(this) + " )";
	}
}
