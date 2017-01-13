package formulae.mitli.visitors;

import formulae.mitli.MITLIAtom;
import formulae.mitli.MITLIConjunction;
import formulae.mitli.MITLIDisjunction;
import formulae.mitli.MITLIEventually_AtoB;
import formulae.mitli.MITLIEventually_AtoInf;
import formulae.mitli.MITLIEventually_ZerotoB;
import formulae.mitli.MITLIFalse;
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

public interface MITLIVisitor<T> {

	public T visit(MITLIDisjunction formula);

	public T visit(MITLIFalse formula);

	public T visit(MITLITrue formula);

	public T visit(MITLIConjunction formula);

	public T visit(MITLIAtom formula);

	public T visit(MITLINegation formula);

	public T visit(MITLIUntil formula);

	public T visit(MITLIImplies formula);

	public T visit(MITLIIff formula);

	public T visit(MITLISince formula);

	public T visit(MITLIGlobally_AtoInf mitliGlobally_AtoInf);

	public T visit(MITLIGlobally_AtoB mitliGlobally_AtoB);

	public T visit(MITLIGlobally_ZerotoB formula);

	public T visit(MITLIEventually_AtoB mitliEventually_AtoB);

	public T visit(MITLIEventually_AtoInf mitliEventually_AtoInf);

	public T visit(MITLIEventually_ZerotoB formula);

	public T visit(MITLIPast_AtoB formula);

	public T visit(MITLIPast_ZerotoB formula);

	public T visit(MITLIRelease mitliRelease);

}
