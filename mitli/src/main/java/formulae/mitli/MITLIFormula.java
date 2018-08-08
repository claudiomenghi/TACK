package formulae.mitli;

import java.util.Set;

import com.google.common.base.Preconditions;

import formulae.Formula;
import formulae.mitli.atoms.MITLIFalse;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.atoms.MITLITrue;
import formulae.mitli.visitors.MITLIVisitor;

public abstract class MITLIFormula extends Formula {

	private int maxIntComparedto = 0;

	public static final MITLIFormula TRUE = new MITLITrue();

	public static final MITLIFormula FALSE = new MITLIFalse();

	public MITLIFormula() {
		super();

	}


	public abstract Set<MITLIFormula> getChildren();

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
		return new MITLIPropositionalAtom(s);
	}

	public static MITLIFormula not(MITLIFormula f) {
		if (f instanceof MITLINegation) {
			return ((MITLINegation) f).getChild();
		}

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
		Preconditions.checkNotNull(f1, "left child cannot be null");
		Preconditions.checkNotNull(f2, "left child cannot be null");
		return new MITLIUntil(f1, f2);
	}

	public static MITLIFormula S(MITLIFormula f1, MITLIFormula f2) {
		return new MITLISince(f1, f2);
	}

	// Eventually: F_(0,b)
	public static MITLIFormula F(MITLIFormula f, int b) {
		return new MITLIEventually_ZerotoB(f, b);

	}

	// Eventually: F_(a,b)
	public static MITLIFormula F(MITLIFormula f, int a, int b) {
		if (a == 0)
			return F(f, b);
		else
			return new MITLIEventually_AtoB(f, a, b);
	}

	// Eventually: F_(a,+oo)
	public static MITLIFormula F_inf(MITLIFormula f, int a) {
		if (a == 0)
			return U(new MITLITrue(), f);
		else
			return new MITLIEventually_AtoInf(f, a);
	}

	// Globally: G_(0,b)
	public static MITLIFormula G(MITLIFormula f, int b) {
		return new MITLIGlobally_ZerotoB(f, b);
	}

	// Globally: G_(a,b)
	public static MITLIFormula G(MITLIFormula f, int a, int b) {
		if (a == 0)
			return G(f, b);
		else
			return new MITLIGlobally_AtoB(f, a, b);
	}

	// Globally: G_(a,+oo)
	public static MITLIFormula G_inf(MITLIFormula f, int a) {
		Preconditions.checkNotNull(f, "The formula cannot be null");
		if (a == 0) {
			return R(new MITLIFalse(), f);
		} else {
			return new MITLIGlobally_AtoInf(f, a);
		}
	}

	// Globally: G_<0,b>
	public static MITLIFormula G(MITLIFormula f, boolean abopen, int b, boolean dbopen) {
		if (abopen && dbopen) { // G_(0,b)
			return new MITLIGlobally_ZerotoB(f, b);
		} else if (!abopen && dbopen) // G_[0,b)
			return and(f, G(f, true, b, dbopen));

		else if (abopen && !dbopen) // G_(0,b]
			return // and(
					//G(f, true, b, true), 
					//and(first(f), 
					G(U(f,f), true, b, true);
//					G(F(f, true, b, true), true, b, true));

		else
			return and(f, G(f, true, b, false)); // G_[0,b]

	}

	// Globally: G_<a,b>
	public static MITLIFormula G(MITLIFormula f, int a, boolean abopen, int b, boolean dbopen) {
		if (a == 0) {
			return G(f, abopen, b, dbopen);
		} else {

			/* Following implementation uses native encoding for Globally */

			// distance between the upper bound and the lower
			int distance = b - a;

			MITLIFormula fm = f;

			int low = a;
			int upp = b;
			// shifts the formula using the distance every time
			for (; low >= distance; low = low - distance, upp = upp - distance) {
				if (low == a) {
					fm = F(G(fm, 0, abopen, distance, dbopen), 0, true, distance, true);
				} else {
					fm = F(G(fm, 0, true, distance, true), 0, true, distance, true);
				}
			}

			if (low > 0) {
				MITLIFormula orf = fm;

				for (int h = low; h > 0; h--) {
					orf = F(G(orf, 0, true, 1, true), 0, true, 1, true);
				}

				return G(orf, 0, true, 1, true);
			} else {
				return G(fm, 0, true, 1, true);
			}
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
		Preconditions.checkNotNull(f1, "The first subformula cannot be null");
		Preconditions.checkNotNull(f2, "The second subformula cannot be null");

		return new MITLIImplies(f1, f2);
	}

	public static MITLIFormula iff(MITLIFormula f1, MITLIFormula f2) {
		return new MITLIIff(f1, f2);
	}

	// Producers method to build derived temporal CLTL formulae
	public static MITLIFormula R(MITLIFormula f1, MITLIFormula f2) {
		// return not(U(not(f1), not(f2)));
		return new MITLIRelease(f1, f2);
	}

	// Eventually: F_<a,+oo)
	public static MITLIFormula F(MITLIFormula f, int a, boolean aB) {

		MITLIFormula qtlTrue = MITLIFormula.TRUE;

		if (a == 0 && aB == true) // F_(0,+oo)
			return U(qtlTrue, f);

		else if (a == 0 && aB == true) // F_[0,+oo)
			return or(f, F(f, 0, true));

		else if (a > 0 && aB == true) // F_(a,+oo)
			return G(F(f, 0, true), true, a, true);

		else // F_[a,+oo)
			return G(F(f, 0, true), true, a, true);
	}

	private static MITLIFormula first(MITLIFormula f) {
		return U(not(f), f);
	}

	// Eventually: F_<0,b>
	public static MITLIFormula F(MITLIFormula f, boolean aB, int b, boolean bB) {
		if (aB == true && bB == true) { // F_(0,b)

			return new MITLIEventually_ZerotoB(f, b);

		} else if (aB == false && bB == true) // F_[0,b)
			return or(f, F(f, true, b, bB));

		else if (aB == true && bB == false) // F_(0,b]
			return or(F(f, true, b, true), 
					and(first(f), 
					G(F(f, true, b, true), true, b, true))
					);

		else
			return or(f, F(f, true, b, false)); // F_[0,b]

	}

	// Eventually: F_<a,b>
	public static MITLIFormula F(MITLIFormula f, int a, boolean aB, int b, boolean bB) {
		if (a == 0) {
			return F(f, aB, b, bB);
		} else {
			int d = b - a;
			MITLIFormula fm = f;

			int low = a;
			int upp = b;
			for (; low >= d; low = low - d, upp = upp - d)
				fm = G(F(fm, 0, true, d, true), 0, true, d, true);

			if (low > 0) {
				MITLIFormula[] _or = new MITLIFormula[d];
				int i = 0;
				for (int j = low; j < upp; j++) {
					if (j == d)
						_or[i++] = F(G(F(fm, 0, true, d, true), 0, true, d, true), 0, false, 1, bB);
					else {
						MITLIFormula orf = fm;
						for (int h = j; h > 0; h--)
							orf = G(F(orf, 0, true, 1, true), 0, true, 1, true);
						if (i == 0)
							orf = F(orf, 0, aB, 1, true);
						else
							orf = F(orf, 0, false, 1, true);

						_or[i++] = orf;
					}
				}
				MITLIFormula result = _or[0];
				for (int j = 1; j < d; j++)
					result = or(result, _or[j]);

				return result;
			} else
				return F(fm, 0, aB, d, true);

		}
	}
}
