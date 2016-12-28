package formulae.mitli.visitors;

import java.util.Arrays;
import java.util.List;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLHighAtom;
import formulae.cltloc.atoms.CLTLIntervalAtom;
import formulae.cltloc.atoms.CLTLLowAtom;
import formulae.cltloc.atoms.CLTLValueAtom;
import formulae.cltloc.atoms.CLTLVariable;
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
import formulae.cltloc.relations.CLTLocEQRelation;
import formulae.cltloc.relations.CLTLocGERelation;
import formulae.cltloc.relations.CLTLocLEQRelation;
import formulae.mitli.CLTLTranslator;
import formulae.mitli.MITLIAtom;
import formulae.mitli.MITLIConjunction;
import formulae.mitli.MITLIDisjunction;
import formulae.mitli.MITLIFalse;
import formulae.mitli.MITLIFormula;
import formulae.mitli.MITLIGlobally_AtoB;
import formulae.mitli.MITLIGlobally_AtoInf;
import formulae.mitli.MITLIIff;
import formulae.mitli.MITLIImplies;
import formulae.mitli.MITLINegation;
import formulae.mitli.MITLISince;
import formulae.mitli.MITLITrue;
import formulae.mitli.MITLIUntil;

public class MITLI2CLTLocVisitor implements MITLIVisitor<CLTLocFormula> {

	public CLTLocFormula high(MITLIFormula formula) {
		return new CLTLocConjunction(
				new CLTLocDisjunction(new CLTLValueAtom(0),
						new CLTLocNegation(new CLTLocYesterday(new CLTLIntervalAtom(formula.idFormula())))),
				new CLTLIntervalAtom(formula.idFormula()));
	}

	public CLTLocFormula low(MITLIFormula formula) {
		return new CLTLocConjunction(
				new CLTLocDisjunction(new CLTLValueAtom(0),
						new CLTLocNegation(
								new CLTLocYesterday(new CLTLocNegation(new CLTLIntervalAtom(formula.idFormula()))))),
				new CLTLocNegation(new CLTLIntervalAtom(formula.idFormula())));
	}

	public CLTLocFormula clocksEventsConstraints(MITLIFormula formula) {

		CLTLocFormula result;

		CLTLHighAtom high = new CLTLHighAtom(formula.idFormula());
		CLTLLowAtom low = new CLTLLowAtom(formula.idFormula());
		CLTLVariable z0 = new CLTLVariable("z0_" + formula.idFormula());
		CLTLVariable z1 = new CLTLVariable("z1_" + formula.idFormula());

		CLTLValueAtom zero = new CLTLValueAtom(0);

		if (formula.idFormula() != formula.isTheFormula) {

			if (formula.maxIntComparedto() > 0) {
				CLTLocFormula f1;
				f1 = new CLTLocEQRelation(z0, zero);

				// Formula (2)
				CLTLocFormula f2 = new CLTLocIff(new CLTLocDisjunction(high, low),
						new CLTLocDisjunction(new CLTLocEQRelation(z0, zero), new CLTLocEQRelation(z1, zero)));

				// formula (3)
				CLTLocFormula f3a = new CLTLocImplies(new CLTLocEQRelation(z0, zero), new CLTLocNext(
						new CLTLocRelease(new CLTLocEQRelation(z1, zero), new CLTLocGERelation(z0, zero))));

				CLTLocFormula f3b = new CLTLocImplies(new CLTLocEQRelation(z1, zero), new CLTLocNext(
						new CLTLocRelease(new CLTLocEQRelation(z0, zero), new CLTLocGERelation(z1, zero))));

				// Clocks progression
				CLTLocFormula f4a = new CLTLocConjunction(
						new CLTLocGlobally(new CLTLocNext(
								new CLTLocDisjunction(new CLTLocEQRelation(z0, zero), new CLTLocGERelation(z0, zero)))),
						new CLTLocDisjunction(new CLTLocGlobally(new CLTLocEventually(new CLTLocEQRelation(z0, zero))),
								new CLTLocEventually(new CLTLocGlobally(
										new CLTLocGERelation(z0, new CLTLValueAtom(formula.maxIntComparedto()))))));

				CLTLocFormula f4b = new CLTLocConjunction(
						new CLTLocGlobally(new CLTLocNext(
								new CLTLocDisjunction(new CLTLocEQRelation(z1, zero), new CLTLocGERelation(z1, zero)))),
						new CLTLocDisjunction(new CLTLocGlobally(new CLTLocEventually(new CLTLocEQRelation(z1, zero))),
								new CLTLocEventually(new CLTLocGlobally(
										new CLTLocGERelation(z1, new CLTLValueAtom(formula.maxIntComparedto()))))));

				// Clocks non negativeness in the origin
				CLTLocFormula f5 = new CLTLocConjunction(new CLTLocGERelation(z0, zero),
						new CLTLocGERelation(z1, zero));

				result = new CLTLocConjunction(f1, new CLTLocGlobally(new CLTLocConjunction(f2, f3a, f3b)), f4a, f4b,
						f5);
			} else
				result = new CLTLocAtom("");

		} else {
			result = high;
		}
		return result;
	}

	@Override
	public CLTLocFormula visit(MITLIFalse formula) {
		CLTLLowAtom low = new CLTLLowAtom(formula.idFormula());
		return new CLTLocConjunction(this.clocksEventsConstraints(formula), low,
				new CLTLocGlobally(new CLTLocNegation(new CLTLIntervalAtom(formula.idFormula()))));
	}

	@Override
	public CLTLocFormula visit(MITLITrue formula) {
		return new CLTLocConjunction(this.clocksEventsConstraints(formula),
				new CLTLocGlobally(new CLTLIntervalAtom(formula.idFormula())));
	}

	@Override
	public CLTLocFormula visit(MITLIConjunction formula) {

		CLTLocFormula[] andInterval = new CLTLocFormula[formula.subformulae().size()];

		List<MITLIFormula> subformulae = formula.subformulae();
		int i = 0;
		for (MITLIFormula f : subformulae) {
			andInterval[i] = new CLTLIntervalAtom(f.idFormula());
			i++;
		}

		CLTLocFormula f1 = new CLTLocIff(new CLTLIntervalAtom(formula.idFormula()),
				new CLTLocConjunction(andInterval[0], Arrays.copyOfRange(andInterval, 1, andInterval.length)));

		return new CLTLocConjunction(this.clocksEventsConstraints(formula), new CLTLocGlobally(f1));
	}

	@Override
	public CLTLocFormula visit(MITLIAtom formula) {
		return this.clocksEventsConstraints(formula);
	}

	@Override
	public CLTLocFormula visit(MITLIDisjunction formula) {

		CLTLocFormula[] orInterval = new CLTLocFormula[formula.subformulae().size()];

		int i = 0;
		for (MITLIFormula f : formula.subformulae()) {
			orInterval[i] = new CLTLIntervalAtom(f.idFormula());
			i++;
		}

		CLTLocFormula f1 = new CLTLocIff(new CLTLIntervalAtom(formula.idFormula()),
				new CLTLocDisjunction(orInterval[0], Arrays.copyOfRange(orInterval, 1, orInterval.length)));

		return new CLTLocConjunction(this.clocksEventsConstraints(formula), new CLTLocGlobally(f1));
	}

	@Override
	public CLTLocFormula visit(MITLINegation formula) {
		MITLIFormula subf = formula.getChild();

		CLTLocFormula f1 = new CLTLocIff(new CLTLIntervalAtom(formula.idFormula()),
				new CLTLocNegation(new CLTLIntervalAtom(subf.idFormula())));

		return new CLTLocConjunction(this.clocksEventsConstraints(formula), new CLTLocGlobally(f1));
	}

	@Override
	public CLTLocFormula visit(MITLIUntil formula) {

		// Some alias...
		MITLIFormula subf1 = formula.getLeftChild();
		MITLIFormula subf2 = formula.getRightChild();

		CLTLocFormula f1 = new CLTLocIff(new CLTLIntervalAtom(formula.idFormula()), new CLTLocConjunction(
				new CLTLIntervalAtom(subf1.idFormula()),
				new CLTLocUntil(new CLTLIntervalAtom(subf1.idFormula()), new CLTLIntervalAtom(subf2.idFormula()))));

		return new CLTLocConjunction(this.clocksEventsConstraints(formula), new CLTLocGlobally(f1));
	}

	@Override
	public CLTLocFormula visit(MITLIImplies formula) {
		MITLIFormula subf1 = formula.getLeftChild();
		MITLIFormula subf2 = formula.getRightChild();

		CLTLocFormula f1 = new CLTLocIff(new CLTLIntervalAtom(formula.idFormula()),
				new CLTLocImplies(new CLTLIntervalAtom(subf1.idFormula()), new CLTLIntervalAtom(subf2.idFormula())));

		return new CLTLocConjunction(this.clocksEventsConstraints(formula), new CLTLocGlobally(f1));
	}

	@Override
	public CLTLocFormula visit(MITLIIff formula) {
		MITLIFormula subf1 = formula.getLeftChild();
		MITLIFormula subf2 = formula.getRightChild();

		CLTLocFormula f1 = new CLTLocIff(new CLTLIntervalAtom(formula.idFormula()),
				new CLTLocIff(new CLTLIntervalAtom(subf1.idFormula()), new CLTLIntervalAtom(subf2.idFormula())));

		return new CLTLocConjunction(this.clocksEventsConstraints(formula), new CLTLocGlobally(f1));
	}

	@Override
	public CLTLocFormula visit(MITLISince formula) {
		// Some alias...
		MITLIFormula subf1 = formula.getLeftChild();
		MITLIFormula subf2 = formula.getRightChild();

		CLTLocFormula f1 = new CLTLocIff(new CLTLIntervalAtom(formula.idFormula()), new CLTLocConjunction(
				new CLTLIntervalAtom(subf1.idFormula()),
				new CLTLocSince(new CLTLIntervalAtom(subf1.idFormula()), new CLTLIntervalAtom(subf2.idFormula()))));

		CLTLocFormula f2 = new CLTLocIff(new CLTLIntervalAtom(formula.idFormula()), new CLTLocConjunction(
				new CLTLIntervalAtom(subf1.idFormula()), new CLTLIntervalAtom(subf2.idFormula())));

		return new CLTLocConjunction(this.clocksEventsConstraints(formula), f2, new CLTLocGlobally(f1));
	}

	@Override
	public CLTLocFormula visit(MITLIGlobally_AtoInf formula) {
		CLTLValueAtom orig = new CLTLValueAtom(0);

		MITLIFormula subf = formula.getChild();

		CLTLValueAtom lowerbound = new CLTLValueAtom(formula.lowerbound());

		CLTLVariable z0 = new CLTLVariable("z0_" + formula.idFormula());
		CLTLVariable z1 = new CLTLVariable("z1_" + formula.idFormula());
		// Formula (15)

		CLTLocFormula low = this.low(formula);
		CLTLocFormula high = this.high(formula);
		CLTLocFormula subflow = this.low(formula.getChild());
		CLTLocFormula subfhigh = this.high(formula.getChild());

		CLTLocFormula f1;
		f1 = new CLTLocIff(low,
				new CLTLocConjunction(orig,
						new CLTLocUntil(new CLTLocGERelation(z0, orig),
								new CLTLocConjunction(new CLTLocNegation(new CLTLIntervalAtom(subf.idFormula())),
										new CLTLocDisjunction(new CLTLocLEQRelation(z0, lowerbound),
												new CLTLocConjunction(new CLTLocLEQRelation(z0, lowerbound),
														new CLTLocNext(new CLTLocGERelation(z0, lowerbound))))))));

		// Formula (16)

		CLTLocFormula f2;
		f2 = new CLTLocIff(this.high(formula),
				new CLTLocDisjunction(
						new CLTLocConjunction(new CLTLocEQRelation(z1, orig),
								new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(z1, orig),
										new CLTLocConjunction(subfhigh, new CLTLocEQRelation(z1, lowerbound),
												new CLTLocGlobally(new CLTLocNegation(subflow)))))),
						new CLTLocConjunction(orig, new CLTLocNegation(low))));

		CLTLocFormula f3;
		f3 = new CLTLocImplies(new CLTLocConjunction(subfhigh, new CLTLocGlobally(new CLTLocNegation(subflow))),
				new CLTLocEQRelation(z1, lowerbound));

		return new CLTLocConjunction(this.clocksEventsConstraints(formula),
				new CLTLocGlobally(new CLTLocConjunction(f1, f2, f3)));

	}

	@Override
	public CLTLocFormula visit(MITLIGlobally_AtoB mitliGlobally_AtoB) {

		int b = mitliGlobally_AtoB.upperbound();
		int a = mitliGlobally_AtoB.lowerbound();
		int l = b - a;

		int d = 2 * (int) Math.ceil((float) b / (b - a));

		MITLIFormula subf = mitliGlobally_AtoB.getChild();

		CLTLValueAtom orig = new CLTLValueAtom(0);
		CLTLValueAtom bValue = new CLTLValueAtom(b);
		CLTLValueAtom aValue = new CLTLValueAtom(a);

		String[] _f1 = new String[d];

		for (int i = 0; i < d; i++) {
			_f1[i] = t.and(t.rel("=", x(i, t), orig), t.X(t.U(t.rel(">", x(i, t), orig), t.and(subf.low(t),
					t.rel("=", x(i, t), String.valueOf(b)),
					t.or(t.rel(">", subf.z0(t), String.valueOf(l)), t.rel(">", subf.z1(t), String.valueOf(l)))))));
		}

		// Formula (8)
		String f1;
		f1 = t.iff(
				low(t), t
						.or(t.and(
								t.neg(orig), t
										.or(_f1)),
								t.and(orig,
										t.U(t.or(t.rel(">", z0(t), orig), orig),
												t.and(t.neg(subf.interval(t)),
														t.or(t.and(t.rel(">=", z0(t), String.valueOf(a)),
																t.rel("<=", z0(t), String.valueOf(b))),
																t.and(t.rel("<", z0(t), String.valueOf(a)),
																		t.X(t.rel(">", z0(t), String.valueOf(a))))))

										)

				)

				));

		String[] _f3 = new String[d];

		for (int i = 0; i < d; i++) {
			_f3[i] = t.rel("=", x(i, t), String.valueOf(b));
		}

		// Formula (9)
		String f3 = t.implies(
				t.and(subf.low(t),
						t.or(t.rel(">", subf.z0(t), String.valueOf(l)), t.rel(">", subf.z1(t), String.valueOf(l)))),
				t.or(_f3));

		String[] _f4 = new String[d];

		for (int i = 0; i < d; i++) {
			_f4[i] = t.and(t.rel("=", x(i, t), "0"), t.X(t.U(t.rel(">", x(i, t), "0"), t.and(subf.high(t),
					t.rel("=", x(i, t), String.valueOf(a)),
					t.R(subf.low(t), t.neg(t.and(subf.low(t), t.rel("<=", x(i, t), String.valueOf(upperbound()))))

					)))));
		}

		String f4;
		f4 = t.iff(high(t), t.or(t.and(t.neg(orig), t.or(_f4)), t.and(orig, t.neg(low(t)))));

		String[] _f5 = new String[d];

		for (int i = 0; i < d; i++) {
			_f5[i] = t.rel("=", x(i, t), String.valueOf(a));
		}

		String f5 = t.implies(t.and(subf.high(t), t.R(subf.low(t), t.neg(t.and(subf.low(t),
				t.and(t.rel("<=", subf.z0(t), String.valueOf(l)), t.rel("<=", subf.z1(t), String.valueOf(l)))))

		)), t.or(_f5));

		return t.and(super.clocksEventsConstraints(t) + auxiliaryClocksConstraints(t) + t.G(t.and(f1, f3, f4, f5)));
	}

	private CLTLocFormula auxiliaryClocksConstraints(MITLIGlobally_AtoB formula) {

		int d = 2 * (int) Math.ceil((float) b / (b - a));
		int p = 0;

		CLTLocFormula[] _f1 = new CLTLocFormula[d];
		CLTLocFormula[] _f2 = new CLTLocFormula[((d * d) - d) / 2];
		CLTLocFormula[] _f3 = new CLTLocFormula[d];
		CLTLocFormula[] _f5 = new CLTLocFormula[d];
		CLTLocFormula[] _f6 = new CLTLocFormula[d];
		CLTLocFormula[] _f7 = new CLTLocFormula[d];
		CLTLocFormula[][] __f7 = new CLTLocFormula[d][d];
		CLTLocFormula[] _f8 = new CLTLocFormula[d];

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
			_f6[i] = t.and(t.G(t.or(t.rel("=", t.X(x(i, t)), "0"), t.rel(">", t.X(x(i, t)), x(i, t)))),
					t.or(t.G(t.F(t.rel("=", x(i, t), "0"))), t.F(t.G(t.rel(">", x(i, t), String.valueOf(upperbound()))))
					// t.F(t.G(t.rel(">", x(i,t), t.X(x(i,t)))))
					));

			if (i < d - 1)
				_f8[i] = t.rel("<", x((d - i) % d, t), x(d - (i + 1), t));

		}

		// Formula (4)
		CLTLocFormula f1 = t.iff(t.or(high(t), low(t)), t.or(_f1));

		// Formuala (5)
		CLTLocFormula f2 = t.and(_f2);

		// Formula (6)
		CLTLocFormula f3 = t.and(_f3);

		// String f4 = t.rel("=", x(0,t), "0");
		CLTLocFormula f4 = t.or(_f1);

		// Positiveness of all clocks in the origin
		CLTLocFormula f5 = t.and(_f5);

		CLTLocFormula f6 = t.and(_f6);

		// strict sequence among clocks
		CLTLocFormula f7 = t.and(_f7);

		// order of clocks at the origin
		CLTLocFormula f8 = t.and(_f8);

		return t.and(f4, f6, f8, t.G(t.and(f1, f2, f7)));

	}

	public String x(int i) {
		return "x" + i + "_" + super.idFormula();
	}

	public String x(int i, CLTLTranslator t) {
		return t.var(x(i));
	}

}
