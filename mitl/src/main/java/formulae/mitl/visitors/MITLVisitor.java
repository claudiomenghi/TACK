package formulae.mitl.visitors;

import formulae.mitl.MITLAtom;
import formulae.mitl.MITLConjunction;
import formulae.mitl.MITLEventually;
import formulae.mitl.MITLEventually_AtoB;
import formulae.mitl.MITLEventually_AtoInf;
import formulae.mitl.MITLEventually_ZerotoB;
import formulae.mitl.MITLFalse;
import formulae.mitl.MITLNegation;
import formulae.mitl.MITLTrue;
import formulae.mitl.MITLUntil;

/**
 * Visits the MITL formula and returns a result of type T
 * 
 * @author Claudio Menghi
 *
 */
public interface MITLVisitor<T> {

	public T visit(MITLAtom formula);

	public T visit(MITLConjunction formula);

	public T visit(MITLEventually_AtoB formula);

	public T visit(MITLEventually_AtoInf formula);

	public T visit(MITLEventually_ZerotoB formula);

	public T visit(MITLEventually formula);

	public T visit(MITLFalse formula);

	public T visit(MITLNegation formula);

	public T visit(MITLTrue formula);

	public T visit(MITLUntil mitlUntil);

}
