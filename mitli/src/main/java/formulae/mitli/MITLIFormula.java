package formulae.mitli;

import com.google.common.base.Preconditions;

import formulae.Formula;
import formulae.mitli.visitors.MITLIVisitor;

public abstract class MITLIFormula extends Formula {

	private int maxIntComparedto = 0;

	public static final MITLIFormula TRUE = new MITLIAtom("True");
	public static final MITLIFormula FALSE = new MITLIAtom("True");

	public MITLIFormula() {
		super();

	}

	public abstract <T> T accept(MITLIVisitor<T> visitor);

	public int maxIntComparedto() {
		return maxIntComparedto;
	}

	public int maxIntComparedto(int c) {
		if (maxIntComparedto < c)
			maxIntComparedto = c;

		return maxIntComparedto;
	}

	// Producers method to build CLTL formulae of the argument formula

	public static MITLIFormula atom(String s) {
		return new MITLIAtom(s);
	}

	public static MITLIFormula not(MITLIFormula f) {
		return new MITLINegation(f);
	}

	public static MITLIFormula and(MITLIFormula... formulae) {

		MITLIFormula f = formulae[0];
		for (int i = 1; i < formulae.length; i++) {
			f = new MITLIConjunction(f, formulae[i]);
		}
		return f;
	}

	public static MITLIFormula U(MITLIFormula f1, MITLIFormula f2) {
		return new MITLIUntil(f1, f2);
	}

	public static MITLIFormula S(MITLIFormula f1, MITLIFormula f2) {
		return new MITLISince(f1, f2);
	}

	// Eventually: F_<0,b]
	public static MITLIFormula F(MITLIFormula f, int b) {
		return new MITLIEventually_ZerotoB(f, b);

	}

	// Eventually: F_<a,b]
	public static MITLIFormula F(MITLIFormula f, int a, int b) {
		if (a == 0)
			return F(f, b);
		else
			return new MITLIEventually_AtoB(f, a, b);
	}

	// Eventually: F_<a,+oo]
	public static MITLIFormula F_inf(MITLIFormula f, int a) {
		if (a == 0)
			return U(new MITLITrue(), f);
		else
			return new MITLIEventually_AtoInf(f, a);
	}

	// Globally: G_<0,b]
	public static MITLIFormula G(MITLIFormula f, int b) {
		return new MITLIGlobally_ZerotoB(f, b);
	}

	// Globally: G_<a,b]
	public static MITLIFormula G(MITLIFormula f, int a, int b) {
		if (a == 0)
			return G(f, b);
		else
			return new MITLIGlobally_AtoB(f, a, b);
	}

	// Globally: F_<a,+oo]
	public static MITLIFormula G_inf(MITLIFormula f, int a) {
		Preconditions.checkNotNull(f, "The formula cannot be null");
		if (a == 0) {
			return R(new MITLIFalse(), f);
		} else {
			return new MITLIGlobally_AtoInf(f, a);
		}
	}

	// Past: P_<0,b]
	public static MITLIFormula P(MITLIFormula f, int b) {
		return new MITLIPast_ZerotoB(f, b);

	}

	// Past: P_<a,b]
	public static MITLIFormula P(MITLIFormula f, int a, int b) {
		if (a == 0)
			return P(f, b);
		else
			return new MITLIPast_AtoB(f, a, b);
	}

	// Historically: H_<0,b]
	public static MITLIFormula H(MITLIFormula f, int b) {
		return not(P(not(f), b));
	}

	// Historically: H_<a,b]
	public static MITLIFormula H(MITLIFormula f, int a, int b) {
		if (a == 0)
			return H(f, b);
		else
			return not(P(not(f), a, b));
	}

	// Producers method to build derived boolean CLTL formulae
	public static MITLIFormula or(MITLIFormula... formulae) {
		MITLIFormula f = formulae[0];
		for (int i = 1; i < formulae.length; i++) {
			f = new MITLIDisjunction(f, formulae[i]);
		}
		return f;
	}

	public static MITLIFormula implies(MITLIFormula f1, MITLIFormula f2) {
		return new MITLIImplies(f1, f2);
	}

	public static MITLIFormula iff(MITLIFormula f1, MITLIFormula f2) {
		return new MITLIIff(f1, f2);
	}

	// Producers method to build derived temporal CLTL formulae
	public static MITLIFormula R(MITLIFormula f1, MITLIFormula f2) {
		return new MITLIRelease(f1, f2);
	}
}
