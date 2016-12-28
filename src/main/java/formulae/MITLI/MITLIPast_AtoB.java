package formulae.mitli;

import java.util.List;

import formulae.Formula;
import formulae.TemporizedFormula;

public class MITLIPast_AtoB extends MITLIPast implements TemporizedFormula {

	private final int a, b;

	public MITLIPast_AtoB(MITLIFormula subformula, int a, int b) {
		super(new String("(P " + String.valueOf(a) + " " + String.valueOf(b) + " " + subformula.strFormula() + ")"));
		this.subformula = subformula;
		this.a = a;
		this.b = b;

		subformula.maxIntComparedto(b - a);
	}

	@Override
	public MITLIFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them

		int m = subformula.maxIntComparedto();
		subformula = (MITLIFormula) l.get(0);
		subformula.maxIntComparedto(m);
		return this;
	}

	@Override
	public Formula simplify() {
		return new MITLIPast_AtoB((MITLIFormula) subformula.simplify(), a, b);
	}

	public String x(int i) {
		return "x" + i + "_" + super.idFormula();
	}

	public String x(int i, CLTLTranslator t) {
		return t.var(x(i));
	}

	@Override
	public String translate(CLTLTranslator t) {

		return t.and(super.clocksEventsConstraints(t) + auxiliaryClocksConstraints(t));

	}

	private String auxiliaryClocksConstraints(CLTLTranslator t) {

		int d = 2 * (int) Math.ceil((float) b / (b - a));
		int p = 0;

		String[] _f1 = new String[d];
		String[] _f2 = new String[((d * d) - d) / 2];
		String[] _f3 = new String[d];
		String[] _f5 = new String[d];
		String[] _f6 = new String[d];
		String[] _f7 = new String[d];
		String[][] __f7 = new String[d][d];
		String[] _f8 = new String[d];

		for (int i = 0; i < d; i++) {
			_f1[i] = t.rel("=", x(i, t), "0");
			_f5[i] = t.rel(">=", x(i, t), "0");
			for (int j = i + 1; j < d; j++)
				_f2[p++] = t.neg(t.and(t.rel("=", x(i, t), "0"), t.rel("=", x(j, t), "0")));
			_f3[i] = t.implies(t.rel("=", x(i, t), "0"),
					t.X(t.R(t.rel("=", x((i + d - 1) % d, t), "0"), t.rel(">", x(i, t), "0"))));

			for (int j = 0; j < d; j++)
				if (j != (i + 1) % d)
					__f7[i][j] = t.rel(">", x(j, t), "0");

			_f7[i] = t.implies(t.rel("=", x(i, t), "0"), t.X(t.R(t.rel("=", x((i + 1) % d, t), "0"), t.and(__f7[i]))));
			_f6[i] = t.and(t.G(t.or(t.rel("=", t.X(x(i, t)), "0"), t.rel(">", t.X(x(i, t)), x(i, t)))), t.or(
					t.G(t.F(t.rel("=", x(i, t), "0"))), t.F(t.G(t.rel(">", x(i, t), String.valueOf(upperbound()))))));

			if (i < d - 1)
				_f8[i] = t.rel("<", x((d - i) % d, t), x(d - (i + 1), t));

		}

		// Formula (4)
		String f1 = t.iff(t.or(high(t), low(t)), t.or(_f1));

		// Formuala (5)
		String f2 = t.and(_f2);

		// Formula (6)
		String f3 = t.and(_f3);

		String f4 = t.rel("=", x(0, t), "0");

		// Positiveness of all clocks in the origin
		String f5 = t.and(_f5);

		String f6 = t.and(_f6);

		// strict sequence among clocks
		String f7 = t.and(_f7);

		// order of clocks at the origin
		String f8 = t.and(_f8);

		return t.and(f4, f6, f8, t.G(t.and(f1, f2, f7)));

	}

	@Override
	public int upperbound() {
		return b;
	}

	@Override
	public int lowerbound() {
		return a;
	}

}
