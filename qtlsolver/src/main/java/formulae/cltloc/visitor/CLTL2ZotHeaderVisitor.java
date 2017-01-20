package formulae.cltloc.visitor;

import formulae.cltloc.atoms.CLTLClock;
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

public class CLTL2ZotHeaderVisitor  implements CLTLocVisitor<String> {

	
	
	@Override
	public String visit(CLTLocAtom atom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocConjunction atom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocNegation formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocUntil formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocImplies formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocIff formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocNext formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocGlobally formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocEventually formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocSince formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocYesterday formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocRelease formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocRelation formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLocDisjunction formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(CLTLClock formula) {
		// TODO Auto-generated method stub
		return null;
	}

}
