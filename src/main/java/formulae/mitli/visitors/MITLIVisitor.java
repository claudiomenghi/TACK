package formulae.mitli.visitors;

import formulae.mitli.MITLIAtom;
import formulae.mitli.MITLIConjunction;
import formulae.mitli.MITLIDisjunction;
import formulae.mitli.MITLIFalse;
import formulae.mitli.MITLIGlobally_AtoB;
import formulae.mitli.MITLIGlobally_AtoInf;
import formulae.mitli.MITLIIff;
import formulae.mitli.MITLIImplies;
import formulae.mitli.MITLINegation;
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
}
