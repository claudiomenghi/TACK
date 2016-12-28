package formulae.cltloc.visitor;

import formulae.cltloc.atoms.CLTLVariable;
import formulae.cltloc.atoms.CLTLocAtom;
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

public class CLTLocToStringVisitor implements CLTLocVisitor<String> {

	@Override
	public String visit(CLTLocAtom atom) {
		return "(-P- " + atom.strFormula() + ")";
	}

	@Override
	public String visit(CLTLocConjunction formula) {
		return "(&&" + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	@Override
	public String visit(CLTLocNegation formula) {
		return "(!! " + formula.getChild().accept(this) + ")";
	}

	@Override
	public String visit(CLTLocUntil formula) {
		return "(until " + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	@Override
	public String visit(CLTLocImplies formula) {
		return "(-> " + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	@Override
	public String visit(CLTLocIff formula) {
		return "(<-> " + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	@Override
	public String visit(CLTLocNext formula) {
		return "(next " + formula.getChild().accept(this) + ")";
	}

	@Override
	public String visit(CLTLocGlobally formula) {
		return "(alwf " + formula.getChild().accept(this) + ")";
	}

	@Override
	public String visit(CLTLocEventually eventually) {
		return "(somf " + eventually.getChild().accept(this) + ")";
	}

	@Override
	public String visit(CLTLocSince formula) {
		return "(since " + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	@Override
	public String visit(CLTLocYesterday formula) {
		return "(yesterday " + formula.getChild().accept(this) + ")";
	}

	@Override
	public String visit(CLTLocRelease formula) {
		return "(release " + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	@Override
	public String visit(CLTLocRelation formula) {
		return "([" + formula.getRelation() + "] " + formula.getLeftChild().accept(this) + " "
				+ formula.getRightChild().accept(this) + ")";
	}

	@Override
	public String visit(CLTLocDisjunction formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLVariable formula){
		return "(-V- "+formula.strFormula() + ")";
	}

	
	
	
	/*
	 * 
	 * 
	 * @Override public String T(String s1, String s2) { return "(trigger " + s1
	 * + " " + s2 + ")"; }
	 * 
	 * @Override public String rel(String r, String[] args) { String rel = "[" +
	 * r + "]"; String str = "(" + rel; for (String s : args) { str = str + s; }
	 * str = str + ")"; return str; }
	 * 
	 * @Override public String rel(String r, String s1, String s2) {
	 * 
	 * }
	 */
}
