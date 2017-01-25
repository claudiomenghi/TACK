package formulae.mitl;

import formulae.Formula;
import formulae.mitl.visitors.MITLVisitor;

public abstract class MITLFormula extends Formula {

	public MITLFormula(String formula_p) {
		super(formula_p);

	}

	public abstract <T> T accept(MITLVisitor<T> visitor);

	// Producers method to build CLTL formulae of the argument formula

	public static MITLFormula atom(String s) {
		return new MITLAtom(s);
	}

	public static MITLFormula not(MITLFormula f) {
		return new MITLNegation(f);
	}

	public static MITLFormula and(MITLFormula f1, MITLFormula f2) {
		return new MITLConjunction(f1, f2);
	}

	public static MITLFormula U(MITLFormula f1, MITLFormula f2) {
		return new MITLUntil(f1, f2);
	}

	// Eventually: F_<0,b]
	public static MITLFormula F(MITLFormula f, int b) {
		return new MITLEventually_ZerotoB(f, b);

	}

	// Eventually: F_<a,b]
	public static MITLFormula F(MITLFormula f, int a, int b) {
		return new MITLEventually_AtoB(f, a, b);
	}

	// Eventually: F_<a,+oo]
	public static MITLFormula F_inf(MITLFormula f, int a) {
		return new MITLEventually_AtoInf(f, a);
	}

	// Globally: G_<0,b]
	public static MITLFormula G(MITLFormula f, int b) {
		return not(F(not(f), b));

	}

	// Globally: F_<a,b]
	public static MITLFormula G(MITLFormula f, int a, int b) {
		return not(F(not(f), a, b));
	}

	// Globally: F_<a,+oo]
	public static MITLFormula G_inf(MITLFormula f, int a) {
		if (a > 0)
			return not(F_inf(not(f), a));
		else
			return not(U((MITLFormula) new MITLFalse(), not(f)));
	}

	// Producers method to build derived boolean CLTL formulae

	public static MITLFormula or(MITLFormula f1, MITLFormula f2) {
		return not(and(not(f1), not(f2)));

		// return new MITLDisjunction(f1,f2);
	}

	public static MITLFormula implies(MITLFormula f1, MITLFormula f2) {
		return or(not(f1), f2);
	}

	public static MITLFormula iff(MITLFormula f1, MITLFormula f2) {
		return and(or(not(f1), f2), or(not(f2), f1));
	}

	// Producers method to build derived temporal CLTL formulae

	public static MITLFormula R(MITLFormula f1, MITLFormula f2) {
		return not(U(not(f1), not(f2)));
	}
}
