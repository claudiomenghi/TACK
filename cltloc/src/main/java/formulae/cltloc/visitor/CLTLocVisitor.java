package formulae.cltloc.visitor;

import formulae.cltloc.atoms.CLTLClock;
import formulae.cltloc.atoms.CLTLConstantAtom;
import formulae.cltloc.atoms.CLTLocAP;
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

public interface CLTLocVisitor<T> {

	
	
	public T visit(CLTLocConjunction atom);
	
	public T visit(CLTLocNegation formula);
	
	public T visit(CLTLocUntil formula);
	
	public T visit(CLTLocImplies formula);
	
	public T visit(CLTLocIff formula);
	
	public T visit(CLTLocNext formula);
	
	public T visit(CLTLocGlobally formula);
	
	public T visit(CLTLocEventually formula);
	
	public T visit(CLTLocSince formula);
	
	public T visit(CLTLocYesterday formula);
	
	public T visit(CLTLocRelease formula);
	
	public T visit(CLTLocRelation formula);
	
	public T visit(CLTLocDisjunction formula);
	
	public T visit(CLTLClock formula);

	public T visit(CLTLocAP cltLocAP);

	public T visit(CLTLConstantAtom cltlConstantAtom);
	
	
	
	
}

