package formulae.cltloc.visitor;

import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocConstantAtom;
import formulae.cltloc.atoms.CLTLocVariable;
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
	public String visit(CLTLocConstantAtom cltlConstantAtom) {
		StringBuilder finalFormula=new StringBuilder();
		finalFormula.append(cltlConstantAtom.toString());
		
		return finalFormula.toString();
	}

	@Override
	public String visit(CLTLocVariable formula) {
		StringBuilder finalFormula=new StringBuilder();
		finalFormula.append(formula.toString());
		
		return finalFormula.toString();
	}

}
