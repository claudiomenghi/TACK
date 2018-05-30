package formulae.mitli.visitors;

import formulae.mitli.MITLIConjunction;
import formulae.mitli.MITLIDisjunction;
import formulae.mitli.MITLIEventually_AtoB;
import formulae.mitli.MITLIEventually_AtoInf;
import formulae.mitli.MITLIEventually_ZerotoB;
import formulae.mitli.MITLIGlobally_AtoB;
import formulae.mitli.MITLIGlobally_AtoInf;
import formulae.mitli.MITLIGlobally_ZerotoB;
import formulae.mitli.MITLIIff;
import formulae.mitli.MITLIImplies;
import formulae.mitli.MITLINegation;
import formulae.mitli.MITLIPast_AtoB;
import formulae.mitli.MITLIPast_ZerotoB;
import formulae.mitli.MITLISince;
import formulae.mitli.MITLIUntil;
import formulae.mitli.MITLIRelease;
import formulae.mitli.atoms.MITLIFalse;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.atoms.MITLITrue;

public interface MITLIVisitor<T> {

	public T visit(MITLIDisjunction formula);


	public T visit(MITLITrue formula);
	
	public T visit(MITLIFalse formula);

	public T visit(MITLIConjunction formula);

	public T visit(MITLINegation formula);

	public T visit(MITLIUntil formula);

	public T visit(MITLIRelease formula);

	public T visit(MITLIImplies formula);

	public T visit(MITLIIff formula);

	public T visit(MITLISince formula);

	public T visit(MITLIGlobally_AtoInf formula);

	public T visit(MITLIGlobally_AtoB formula);

	public T visit(MITLIGlobally_ZerotoB formula);

	public T visit(MITLIEventually_AtoB formula);

	public T visit(MITLIEventually_AtoInf formula);

	public T visit(MITLIEventually_ZerotoB formula);

	public T visit(MITLIPast_AtoB formula);

	public T visit(MITLIPast_ZerotoB formula);

	public T visit(MITLIPropositionalAtom formula);

	public T visit(MITLIRelationalAtom formula);

}
