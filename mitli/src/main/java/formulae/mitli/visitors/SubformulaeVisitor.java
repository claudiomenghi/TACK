package formulae.mitli.visitors;

import java.util.Set;

import formulae.mitli.MITLIAtom;
import formulae.mitli.MITLIConjunction;
import formulae.mitli.MITLIDisjunction;
import formulae.mitli.MITLIEventually_AtoB;
import formulae.mitli.MITLIEventually_AtoInf;
import formulae.mitli.MITLIEventually_ZerotoB;
import formulae.mitli.MITLIFalse;
import formulae.mitli.MITLIFormula;
import formulae.mitli.MITLIGlobally_AtoB;
import formulae.mitli.MITLIGlobally_AtoInf;
import formulae.mitli.MITLIGlobally_ZerotoB;
import formulae.mitli.MITLIIff;
import formulae.mitli.MITLIImplies;
import formulae.mitli.MITLINegation;
import formulae.mitli.MITLIPast_AtoB;
import formulae.mitli.MITLIPast_ZerotoB;
import formulae.mitli.MITLIRelease;
import formulae.mitli.MITLISince;
import formulae.mitli.MITLITrue;
import formulae.mitli.MITLIUntil;

public class SubformulaeVisitor implements MITLIVisitor<Set<MITLIFormula>> {

	@Override
	public Set<MITLIFormula> visit(MITLIDisjunction formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIFalse formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLITrue formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIConjunction formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIAtom formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLINegation formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIUntil formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIImplies formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIIff formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLISince formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIGlobally_AtoInf mitliGlobally_AtoInf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIGlobally_AtoB mitliGlobally_AtoB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIGlobally_ZerotoB formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIEventually_AtoB mitliEventually_AtoB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIEventually_AtoInf mitliEventually_AtoInf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIEventually_ZerotoB formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIPast_AtoB formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIPast_ZerotoB formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<MITLIFormula> visit(MITLIRelease mitliRelease) {
		// TODO Auto-generated method stub
		return null;
	}

}
