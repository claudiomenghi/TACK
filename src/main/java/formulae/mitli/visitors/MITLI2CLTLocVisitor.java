package formulae.mitli.visitors;

import java.util.Arrays;
import java.util.List;

import formulae.Formula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLHighAtom;
import formulae.cltloc.atoms.CLTLIntervalAtom;
import formulae.cltloc.atoms.CLTLLowAtom;
import formulae.cltloc.atoms.CLTLConstantAtom;
import formulae.cltloc.atoms.CLTLClock;
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
import formulae.cltloc.relations.CLTLocGEQRelation;
import formulae.cltloc.relations.CLTLocGERelation;
import formulae.cltloc.relations.CLTLocLEQRelation;
import formulae.cltloc.relations.CLTLocLERelation;
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

public class MITLI2CLTLocVisitor implements MITLIVisitor<CLTLocFormula> {

	public CLTLocFormula high(MITLIFormula formula) {
		return new CLTLocConjunction(
				new CLTLocDisjunction(new CLTLConstantAtom(0),
						new CLTLocNegation(new CLTLocYesterday(new CLTLIntervalAtom(formula.idFormula())))),
				new CLTLIntervalAtom(formula.idFormula()));
	}

	public CLTLocFormula low(MITLIFormula formula) {
		return new CLTLocConjunction(
				new CLTLocDisjunction(new CLTLConstantAtom(0),
						new CLTLocNegation(
								new CLTLocYesterday(new CLTLocNegation(new CLTLIntervalAtom(formula.idFormula()))))),
				new CLTLocNegation(new CLTLIntervalAtom(formula.idFormula())));
	}

	public CLTLocFormula clocksEventsConstraints(MITLIFormula formula) {

		CLTLocFormula result;

		CLTLHighAtom high = new CLTLHighAtom(formula.idFormula());
		CLTLLowAtom low = new CLTLLowAtom(formula.idFormula());
		CLTLClock z0 = new CLTLClock("z0_" + formula.idFormula());
		CLTLClock z1 = new CLTLClock("z1_" + formula.idFormula());

		CLTLConstantAtom zero = new CLTLConstantAtom(0);

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
										new CLTLocGERelation(z0, new CLTLConstantAtom(formula.maxIntComparedto()))))));

				CLTLocFormula f4b = new CLTLocConjunction(
						new CLTLocGlobally(new CLTLocNext(
								new CLTLocDisjunction(new CLTLocEQRelation(z1, zero), new CLTLocGERelation(z1, zero)))),
						new CLTLocDisjunction(new CLTLocGlobally(new CLTLocEventually(new CLTLocEQRelation(z1, zero))),
								new CLTLocEventually(new CLTLocGlobally(
										new CLTLocGERelation(z1, new CLTLConstantAtom(formula.maxIntComparedto()))))));

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
		CLTLConstantAtom orig = new CLTLConstantAtom(0);

		MITLIFormula subf = formula.getChild();

		CLTLConstantAtom lowerbound = new CLTLConstantAtom(formula.lowerbound());

		CLTLClock z0 = new CLTLClock("z0_" + formula.idFormula());
		CLTLClock z1 = new CLTLClock("z1_" + formula.idFormula());
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

		CLTLConstantAtom orig = new CLTLConstantAtom(0);
		CLTLConstantAtom bValue = new CLTLConstantAtom(b);
		CLTLConstantAtom aValue = new CLTLConstantAtom(a);
		CLTLConstantAtom lValue = new CLTLConstantAtom(l);

		CLTLConstantAtom upperbound = new CLTLConstantAtom(mitliGlobally_AtoB.upperbound());

		CLTLClock subfz0 = new CLTLClock("z0_" + mitliGlobally_AtoB.getChild().idFormula());
		CLTLClock subfz1 = new CLTLClock("z1_" + mitliGlobally_AtoB.getChild().idFormula());

		CLTLClock z0 = new CLTLClock("z0_" + mitliGlobally_AtoB.idFormula());
		CLTLClock z1 = new CLTLClock("z1_" + mitliGlobally_AtoB.idFormula());

		CLTLocFormula low = this.low(mitliGlobally_AtoB);
		CLTLocFormula high = this.high(mitliGlobally_AtoB);
		CLTLocFormula subflow = this.low(mitliGlobally_AtoB.getChild());
		CLTLocFormula subfhigh = this.high(mitliGlobally_AtoB.getChild());

		CLTLocFormula[] _f1 = new CLTLocFormula[d];

		CLTLIntervalAtom interval = new CLTLIntervalAtom(mitliGlobally_AtoB.idFormula());
		CLTLIntervalAtom subInterval = new CLTLIntervalAtom(mitliGlobally_AtoB.getChild().idFormula());

		for (int i = 0; i < d; i++) {
			_f1[i] = new CLTLocConjunction(
					new CLTLocEQRelation(
							new CLTLClock(
									"x" + i + "_"
											+ mitliGlobally_AtoB
													.idFormula()),
							orig),
					new CLTLocNext(
							new CLTLocUntil(
									new CLTLocGERelation(
											new CLTLClock(
													"x" + i + "_"
															+ mitliGlobally_AtoB
																	.idFormula()),
											orig),
									new CLTLocConjunction(subflow, new CLTLocEQRelation(
											new CLTLClock("x" + i + "_" + mitliGlobally_AtoB.idFormula()), bValue),
											new CLTLocDisjunction(new CLTLocGERelation(subfz0, lValue),
													new CLTLocGERelation(subfz1, lValue))))));
		}

		// Formula (8)
		CLTLocFormula f1;
		f1 = new CLTLocIff(low,
				new CLTLocDisjunction(
						new CLTLocConjunction(new CLTLocNegation(orig),
								new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length))),
						new CLTLocConjunction(orig,
								new CLTLocUntil(new CLTLocDisjunction(new CLTLocGERelation(z0, orig), orig),
										new CLTLocConjunction(new CLTLocNegation(subInterval),
												new CLTLocDisjunction(
														new CLTLocConjunction(new CLTLocGEQRelation(z0, aValue),
																new CLTLocLEQRelation(z0, bValue)),
														new CLTLocConjunction(new CLTLocLERelation(z0, aValue),
																new CLTLocNext(new CLTLocGERelation(z0, aValue)))))

								)

						)

				));

		CLTLocFormula[] _f3 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			_f3[i] = new CLTLocEQRelation(new CLTLClock("x" + i + "_" + mitliGlobally_AtoB.idFormula()), bValue);
		}

		// Formula (9)
		CLTLocFormula f3 = new CLTLocImplies(
				new CLTLocConjunction(subflow,
						new CLTLocDisjunction(new CLTLocGERelation(subfz0, lValue),
								new CLTLocGERelation(subfz1, lValue))),
				new CLTLocDisjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length)));

		CLTLocFormula[] _f4 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + mitliGlobally_AtoB.idFormula());

			_f4[i] = new CLTLocConjunction(new CLTLocEQRelation(xi, orig), new CLTLocNext(new CLTLocUntil(
					new CLTLocGEQRelation(xi, orig),
					new CLTLocConjunction(subfhigh, new CLTLocEQRelation(xi, aValue), new CLTLocRelease(subflow,
							new CLTLocNegation(new CLTLocConjunction(subflow, new CLTLocLEQRelation(xi, upperbound)))

					)))));
		}

		CLTLocFormula f4;
		f4 = new CLTLocIff(high,
				new CLTLocDisjunction(
						new CLTLocConjunction(new CLTLocNegation(orig),
								new CLTLocDisjunction(_f4[0], Arrays.copyOfRange(_f4, 1, _f4.length))),
						new CLTLocConjunction(orig, new CLTLocNegation(low))));

		CLTLocFormula[] _f5 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + mitliGlobally_AtoB.idFormula());

			_f5[i] = new CLTLocEQRelation(xi, aValue);
		}

		CLTLocFormula f5 = new CLTLocImplies(new CLTLocConjunction(subfhigh,
				new CLTLocRelease(subflow, new CLTLocNegation(new CLTLocConjunction(subflow, new CLTLocConjunction(
						new CLTLocLEQRelation(subfz0, lValue), new CLTLocLEQRelation(subfz1, lValue))))

				)), new CLTLocDisjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length)));

		return new CLTLocConjunction(this.clocksEventsConstraints(mitliGlobally_AtoB),
				auxiliaryClocksConstraints(mitliGlobally_AtoB),
				new CLTLocGlobally(new CLTLocConjunction(f1, f3, f4, f5)));
	}

	private CLTLocFormula auxiliaryClocksConstraints(MITLIGlobally_AtoB formula) {

		CLTLocFormula low = this.low(formula);
		CLTLocFormula high = this.high(formula);

		int upperbound = formula.upperbound();
		int lowerbound = formula.lowerbound();
		int d = 2 * (int) Math.ceil((float) upperbound / (upperbound - lowerbound));
		int p = 0;

		CLTLConstantAtom orig = new CLTLConstantAtom(0);
		CLTLConstantAtom bValue = new CLTLConstantAtom(upperbound);
		CLTLConstantAtom aValue = new CLTLConstantAtom(lowerbound);

		CLTLocFormula[] _f1 = new CLTLocFormula[d];
		CLTLocFormula[] _f2 = new CLTLocFormula[((d * d) - d) / 2];
		CLTLocFormula[] _f3 = new CLTLocFormula[d];
		CLTLocFormula[] _f5 = new CLTLocFormula[d];
		CLTLocFormula[] _f6 = new CLTLocFormula[d];
		CLTLocFormula[] _f7 = new CLTLocFormula[d];
		CLTLocFormula[][] __f7 = new CLTLocFormula[d][d];
		CLTLocFormula[] _f8 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + formula.idFormula());

			_f1[i] = new CLTLocEQRelation(xi, orig);
			_f5[i] = new CLTLocGEQRelation(xi, orig);
			for (int j = i + 1; j < d; j++) {
				CLTLClock xj = new CLTLClock("x" + j + "_" + formula.idFormula());

				_f2[p++] = new CLTLocNegation(
						new CLTLocConjunction(new CLTLocEQRelation(xi, orig), new CLTLocEQRelation(xj, orig)));
			}
			CLTLClock xiplusdminus1 = new CLTLClock("x" + ((i + d - 1) % d) + "_" + formula.idFormula());
			CLTLClock xiplusdplus1 = new CLTLClock("x" + (i + d + 1) + "_" + formula.idFormula());
			CLTLClock xiplus1modd = new CLTLClock("x" + ((i + 1) % d) + "_" + formula.idFormula());

			_f3[i] = new CLTLocImplies(new CLTLocEQRelation(xi, orig), new CLTLocNext(
					new CLTLocRelease(new CLTLocEQRelation(xiplusdminus1, orig), new CLTLocGERelation(xi, orig))));

			for (int j = 0; j < d; j++) {
				if (j != (i + 1) % d) {
					CLTLClock xj = new CLTLClock("x" + j + "_" + formula.idFormula());

					__f7[i][j] = new CLTLocGERelation(xj, orig);
				}
			}
			_f7[i] = new CLTLocImplies(new CLTLocEQRelation(xi, orig),
					new CLTLocNext(new CLTLocRelease(new CLTLocEQRelation(xiplus1modd, orig),
							new CLTLocConjunction(__f7[i][0], Arrays.copyOfRange(__f7[i], 1, __f7[i].length)))));

			_f6[i] = new CLTLocConjunction(
					new CLTLocGlobally(new CLTLocDisjunction(new CLTLocNext(new CLTLocEQRelation(xi, orig)))),
					new CLTLocDisjunction(new CLTLocGlobally(new CLTLocEventually(new CLTLocEQRelation(xi, orig))),
							new CLTLocEventually(new CLTLocGlobally(new CLTLocGERelation(xi, bValue)))));

			if (i < d - 1)
				_f8[i] = new CLTLocLEQRelation(xiplusdminus1, xiplusdplus1);

		}

		// Formula (4)
		CLTLocFormula f1 = new CLTLocIff(new CLTLocDisjunction(high, low),
				new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length)));

		// Formuala (5)
		CLTLocFormula f2 = new CLTLocConjunction(_f2[0], Arrays.copyOfRange(_f2, 1, _f2.length));

		// Formula (6)
		CLTLocFormula f3 = new CLTLocConjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length));

		// String f4 = new CLTLocEQRelation( x(0,t), orig);
		CLTLocFormula f4 = new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length));

		// Positiveness of all clocks in the origin
		CLTLocFormula f5 = new CLTLocConjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length));

		CLTLocFormula f6 = new CLTLocConjunction(_f6[0], Arrays.copyOfRange(_f6, 1, _f6.length));

		// strict sequence among clocks
		CLTLocFormula f7 = new CLTLocConjunction(_f7[0], Arrays.copyOfRange(_f7, 1, _f7.length));

		// order of clocks at the origin
		CLTLocFormula f8 = new CLTLocConjunction(_f8[0], Arrays.copyOfRange(_f8, 1, _f8.length));

		return new CLTLocConjunction(f4, f6, f8, new CLTLocGlobally(new CLTLocConjunction(f1, f2, f7)));

	}

	@Override
	public CLTLocFormula visit(MITLIGlobally_ZerotoB formula) {
		CLTLConstantAtom orig = new CLTLConstantAtom(0);

		CLTLocFormula low = this.low(formula);
		CLTLocFormula high = this.high(formula);

		CLTLocFormula subflow = this.low(formula.getChild());
		CLTLocFormula subfhigh = this.high(formula.getChild());

		CLTLConstantAtom upperbound = new CLTLConstantAtom(formula.upperbound());

		MITLIFormula subf = formula.getChild();

		CLTLClock z0 = new CLTLClock("z0_" + formula.idFormula());
		CLTLClock z1 = new CLTLClock("z1_" + formula.idFormula());

		CLTLClock subfz0 = new CLTLClock("z0_" + subf.idFormula());
		CLTLClock subfz1 = new CLTLClock("z1_" + subf.idFormula());

		CLTLIntervalAtom subfinterval = new CLTLIntervalAtom(subf.idFormula());

		CLTLocFormula f1;
		f1 = new CLTLocIff(low, new CLTLocDisjunction(
				new CLTLocConjunction(new CLTLocNegation(orig), subfinterval,
						new CLTLocDisjunction(
								new CLTLocConjunction(
										new CLTLocEQRelation(z0, orig),
										new CLTLocNext(new CLTLocUntil(
												new CLTLocGERelation(z0, orig),
												new CLTLocConjunction(
														subflow, new CLTLocEQRelation(z0, upperbound),
														new CLTLocDisjunction(new CLTLocGERelation(subfz0, upperbound),
																new CLTLocGERelation(subfz1, upperbound)))))),
								new CLTLocConjunction(new CLTLocEQRelation(z1, orig),
										new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(z1, orig),
												new CLTLocConjunction(subflow, new CLTLocEQRelation(z1, upperbound),
														new CLTLocDisjunction(new CLTLocGERelation(subfz0, upperbound),
																new CLTLocGERelation(subfz1, upperbound)))))))),
				new CLTLocConjunction(orig,
						new CLTLocUntil(new CLTLocDisjunction(orig, new CLTLocGERelation(z0, orig)),
								new CLTLocConjunction(new CLTLocNegation(subfinterval),
										new CLTLocLEQRelation(z0, upperbound))))));

		CLTLocFormula f2;
		f2 = new CLTLocImplies(
				new CLTLocConjunction(subflow,
						new CLTLocDisjunction(new CLTLocGERelation(subfz0, upperbound),
								new CLTLocGERelation(subfz1, upperbound))),
				new CLTLocDisjunction(new CLTLocEQRelation(z0, upperbound), new CLTLocEQRelation(z1, upperbound)));

		CLTLocFormula f3;
		f3 = new CLTLocIff(high,
				new CLTLocConjunction(subfhigh,
						new CLTLocRelease(subflow,
								new CLTLocNegation(new CLTLocConjunction(subflow,
										new CLTLocConjunction(new CLTLocLEQRelation(subfz0, upperbound),
												new CLTLocLEQRelation(subfz1, upperbound)))))));

		return new CLTLocConjunction(this.clocksEventsConstraints(formula),
				new CLTLocGlobally(new CLTLocConjunction(f1, f2, f3)));
	}

	@Override
	public CLTLocFormula visit(MITLIEventually_AtoB formula) {

		CLTLConstantAtom orig = new CLTLConstantAtom(0);

		CLTLocFormula low = this.low(formula);
		CLTLocFormula high = this.high(formula);

		CLTLocFormula subflow = this.low(formula.getChild());
		CLTLocFormula subfhigh = this.high(formula.getChild());

		CLTLConstantAtom upperbound = new CLTLConstantAtom(formula.upperbound());
		CLTLConstantAtom lowerbound = new CLTLConstantAtom(formula.lowerbound());

		MITLIFormula subf = formula.getChild();

		CLTLClock z0 = new CLTLClock("z0_" + formula.idFormula());
		CLTLClock z1 = new CLTLClock("z1_" + formula.idFormula());

		CLTLClock subfz0 = new CLTLClock("z0_" + subf.idFormula());
		CLTLClock subfz1 = new CLTLClock("z1_" + subf.idFormula());

		CLTLIntervalAtom subfinterval = new CLTLIntervalAtom(subf.idFormula());

		int a = formula.lowerbound();
		int b = formula.upperbound();
		int l = b - a;

		CLTLConstantAtom lValue = new CLTLConstantAtom(l);

		int d = 2 * (int) Math.ceil((float) b / (b - a));

		CLTLocFormula[] _f1 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + formula.idFormula());
			_f1[i] = new CLTLocConjunction(
					new CLTLocEQRelation(xi,
							orig),
					new CLTLocNext(
							new CLTLocUntil(new CLTLocGERelation(xi, orig),
									new CLTLocConjunction(subfhigh, new CLTLocEQRelation(xi, upperbound),
											new CLTLocDisjunction(new CLTLocGERelation(subfz0, lValue),
													new CLTLocGERelation(subfz1, lValue))))));
		}

		CLTLClock x0 = new CLTLClock("x" + 0 + "_" + formula.idFormula());
		// Formula (8)
		CLTLocFormula f1;
		f1 = new CLTLocIff(high,
				new CLTLocDisjunction(
						new CLTLocConjunction(new CLTLocNegation(orig),
								new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length))),
						new CLTLocConjunction(orig,
								new CLTLocUntil(new CLTLocDisjunction(new CLTLocGERelation(x0, orig), orig),
										new CLTLocConjunction(subfinterval,
												new CLTLocDisjunction(
														new CLTLocConjunction(new CLTLocGEQRelation(x0, lowerbound),
																new CLTLocLEQRelation(x0, upperbound)),
														new CLTLocConjunction(new CLTLocLERelation(x0, lowerbound),
																new CLTLocNext(new CLTLocGERelation(x0, lowerbound)))))

								)

						)

				));

		CLTLocFormula[] _f3 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + formula.idFormula());

			_f3[i] = new CLTLocEQRelation(xi, upperbound);
		}

		// Formula (9)
		CLTLocFormula f3 = new CLTLocImplies(
				new CLTLocConjunction(subfhigh,
						new CLTLocDisjunction(new CLTLocGERelation(subfz0, lValue),
								new CLTLocGERelation(subfz1, lValue))),
				new CLTLocDisjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length)));

		CLTLocFormula[] _f4 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + formula.idFormula());
			_f4[i] = new CLTLocConjunction(new CLTLocEQRelation(xi, orig), new CLTLocNext(new CLTLocUntil(
					new CLTLocGERelation(xi, orig),
					new CLTLocConjunction(subflow, new CLTLocEQRelation(xi, lowerbound), new CLTLocRelease(subfhigh,
							new CLTLocNegation(new CLTLocConjunction(subfhigh, new CLTLocLEQRelation(xi, upperbound)))

					)))));
		}

		CLTLocFormula f4;
		f4 = new CLTLocIff(low,
				new CLTLocDisjunction(
						new CLTLocConjunction(new CLTLocNegation(orig),
								new CLTLocDisjunction(_f4[0], Arrays.copyOfRange(_f4, 1, _f4.length))),
						new CLTLocConjunction(orig, new CLTLocNegation(high))));

		CLTLocFormula[] _f5 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + formula.idFormula());

			_f5[i] = new CLTLocEQRelation(xi, lowerbound);
		}

		CLTLocFormula f5 = new CLTLocImplies(new CLTLocConjunction(subflow,
				new CLTLocRelease(subfhigh, new CLTLocNegation(new CLTLocConjunction(subfhigh, new CLTLocConjunction(
						new CLTLocLEQRelation(subfz0, lValue), new CLTLocLEQRelation(subfz1, lValue))))

				)), new CLTLocDisjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length)));

		return new CLTLocConjunction(this.clocksEventsConstraints(formula),
				this.auxiliaryClocksConstraintsMITLIEventually_AtoB(formula),
				new CLTLocGlobally(new CLTLocConjunction(f1, f3, f4, f5)));

	}

	private CLTLocFormula auxiliaryClocksConstraintsMITLIEventually_AtoB(MITLIEventually_AtoB formula) {

		CLTLConstantAtom orig = new CLTLConstantAtom(0);
		int a = formula.lowerbound();
		int b = formula.upperbound();

		CLTLocFormula low = this.low(formula);
		CLTLocFormula high = this.high(formula);

		int d = 2 * (int) Math.ceil((float) b / (b - a));
		int p = 0;

		CLTLConstantAtom upperbound = new CLTLConstantAtom(formula.upperbound());

		CLTLocFormula[] _f1 = new CLTLocFormula[d];
		CLTLocFormula[] _f2 = new CLTLocFormula[((d * d) - d) / 2];
		CLTLocFormula[] _f3 = new CLTLocFormula[d];
		CLTLocFormula[] _f5 = new CLTLocFormula[d];
		CLTLocFormula[] _f6 = new CLTLocFormula[d];
		CLTLocFormula[] _f7 = new CLTLocFormula[d];
		CLTLocFormula[][] __f7 = new CLTLocFormula[d][d];
		CLTLocFormula[] _f8 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + formula.idFormula());
			_f1[i] = new CLTLocEQRelation(xi, orig);
			_f5[i] = new CLTLocGEQRelation(xi, orig);

			for (int j = i + 1; j < d; j++) {
				CLTLClock xj = new CLTLClock("x" + j + "_" + formula.idFormula());
				_f2[p++] = new CLTLocNegation(
						new CLTLocConjunction(new CLTLocEQRelation(xi, orig), new CLTLocEQRelation(xj, orig)));
			}
			CLTLClock xiplusdminus1modd = new CLTLClock("x" + ((i + d - 1) % d) + "_" + formula.idFormula());
			_f3[i] = new CLTLocImplies(new CLTLocEQRelation(xi, orig), new CLTLocNext(
					new CLTLocRelease(new CLTLocEQRelation(xiplusdminus1modd, orig), new CLTLocGERelation(xi, orig))));

			for (int j = 0; j < d; j++) {
				if (j != (i + 1) % d) {
					CLTLClock xj = new CLTLClock("x" + j + "_" + formula.idFormula());
					__f7[i][j] = new CLTLocGERelation(xj, orig);
				}
			}

			CLTLClock xiplus1modd = new CLTLClock("x" + ((i + 1) % d) + "_" + formula.idFormula());
			_f7[i] = new CLTLocImplies(new CLTLocEQRelation(xi, orig),
					new CLTLocNext(new CLTLocRelease(new CLTLocEQRelation(xiplus1modd, orig),
							new CLTLocConjunction(__f7[i][0], Arrays.copyOfRange(__f7[i], 1, __f7[i].length)))));
			_f6[i] = new CLTLocConjunction(
					new CLTLocGlobally(new CLTLocDisjunction(new CLTLocNext(new CLTLocEQRelation(xi, orig)),
							new CLTLocNext(new CLTLocGERelation(xi, xi)))),
					new CLTLocDisjunction(new CLTLocGlobally(new CLTLocEventually(new CLTLocEQRelation(xi, orig))),
							new CLTLocEventually(new CLTLocGlobally(new CLTLocGERelation(xi, upperbound)))));

			if (i < d - 1) {
				CLTLClock xdminusimodd = new CLTLClock("x" + ((d - i) % d) + "_" + formula.idFormula());
				CLTLClock xdminusiplusone = new CLTLClock("x" + (d - (i + 1)) + "_" + formula.idFormula());

				_f8[i] = new CLTLocLERelation(xdminusimodd, xdminusiplusone);
			}

		}

		CLTLClock x0 = new CLTLClock("x" + 0 + "_" + formula.idFormula());

		// Formula (4)
		CLTLocFormula f1 = new CLTLocIff(new CLTLocDisjunction(high, low),
				new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length)));

		// Formuala (5)
		CLTLocFormula f2 = new CLTLocConjunction(_f2[0], Arrays.copyOfRange(_f2, 1, _f2.length));

		// Formula (6)
		CLTLocFormula f3 = new CLTLocConjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length));

		CLTLocFormula f4 = new CLTLocEQRelation(x0, orig);

		// Positiveness of all clocks in the origin
		CLTLocFormula f5 = new CLTLocConjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length));

		CLTLocFormula f6 = new CLTLocConjunction(_f6[0], Arrays.copyOfRange(_f6, 1, _f6.length));

		// strict sequence among clocks
		CLTLocFormula f7 = new CLTLocConjunction(_f7[0], Arrays.copyOfRange(_f7, 1, _f7.length));

		// order of clocks at the origin
		CLTLocFormula f8 = new CLTLocConjunction(_f8[0], Arrays.copyOfRange(_f8, 1, _f8.length));

		return new CLTLocConjunction(f4, f6, f8, new CLTLocGlobally(new CLTLocConjunction(f1, f2, f7)));
	}

	@Override
	public CLTLocFormula visit(MITLIEventually_AtoInf formula) {
		CLTLConstantAtom orig = new CLTLConstantAtom(0);

		CLTLocFormula low = this.low(formula);
		CLTLocFormula high = this.high(formula);

		CLTLocFormula subflow = this.low(formula.getChild());
		CLTLocFormula subfhigh = this.high(formula.getChild());

		CLTLConstantAtom upperbound = new CLTLConstantAtom(formula.upperbound());
		CLTLConstantAtom lowerbound = new CLTLConstantAtom(formula.lowerbound());

		MITLIFormula subf = formula.getChild();

		CLTLClock z0 = new CLTLClock("z0_" + formula.idFormula());
		CLTLClock z1 = new CLTLClock("z1_" + formula.idFormula());

		CLTLClock subfz0 = new CLTLClock("z0_" + subf.idFormula());
		CLTLClock subfz1 = new CLTLClock("z1_" + subf.idFormula());

		CLTLIntervalAtom subfinterval = new CLTLIntervalAtom(subf.idFormula());

		int a = formula.lowerbound();
		int b = formula.upperbound();

		int d = 2 * (int) Math.ceil((float) b / (b - a));
		int p = 0;

		// Formula (15)

		CLTLocFormula f1;
		f1 = new CLTLocIff(high,
				new CLTLocConjunction(orig,
						new CLTLocUntil(new CLTLocDisjunction(new CLTLocGERelation(z0, orig), orig),
								new CLTLocConjunction(subfinterval,
										new CLTLocDisjunction(new CLTLocLEQRelation(z0, lowerbound),
												new CLTLocConjunction(new CLTLocLEQRelation(z0, lowerbound),
														new CLTLocNext(new CLTLocGERelation(z0, lowerbound))))))));

		// Formula (16)

		CLTLocFormula f2;
		f2 = new CLTLocIff(low,
				new CLTLocDisjunction(
						new CLTLocConjunction(new CLTLocEQRelation(z1, orig),
								new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(z1, orig),
										new CLTLocConjunction(subflow, new CLTLocEQRelation(z1, lowerbound),
												new CLTLocGlobally(new CLTLocNegation(subfhigh)))))),
						new CLTLocConjunction(orig, new CLTLocNegation(high))));

		CLTLocFormula f3;
		f3 = new CLTLocImplies(new CLTLocConjunction(subflow, new CLTLocGlobally(new CLTLocNegation(subfhigh))),
				new CLTLocEQRelation(z1, lowerbound));

		return new CLTLocConjunction(this.clocksEventsConstraints(formula),
				new CLTLocGlobally(new CLTLocConjunction(f1, f2, f3)));

	}

	@Override
	public CLTLocFormula visit(MITLIEventually_ZerotoB formula) {

		CLTLConstantAtom orig = new CLTLConstantAtom(0);

		CLTLocFormula low = this.low(formula);
		CLTLocFormula high = this.high(formula);

		CLTLocFormula subflow = this.low(formula.getChild());
		CLTLocFormula subfhigh = this.high(formula.getChild());

		CLTLConstantAtom upperbound = new CLTLConstantAtom(formula.upperbound());
		CLTLConstantAtom lowerbound = new CLTLConstantAtom(formula.lowerbound());

		MITLIFormula subf = formula.getChild();

		CLTLClock z0 = new CLTLClock("z0_" + formula.idFormula());
		CLTLClock z1 = new CLTLClock("z1_" + formula.idFormula());

		CLTLClock subfz0 = new CLTLClock("z0_" + subf.idFormula());
		CLTLClock subfz1 = new CLTLClock("z1_" + subf.idFormula());

		CLTLIntervalAtom subfinterval = new CLTLIntervalAtom(subf.idFormula());

		int a = formula.lowerbound();
		int b = formula.upperbound();

		CLTLocFormula f1;
		f1 = new CLTLocIff(high,
				new CLTLocDisjunction(
						new CLTLocConjunction(
								new CLTLocNegation(orig), new CLTLocNegation(subfinterval), new CLTLocDisjunction(
										new CLTLocConjunction(new CLTLocEQRelation(z0, orig), new CLTLocNext(
												new CLTLocUntil(new CLTLocGERelation(z0, orig), new CLTLocConjunction(
														subfhigh,
														new CLTLocEQRelation(z0, upperbound),
														new CLTLocDisjunction(new CLTLocGERelation(subfz0, upperbound),
																new CLTLocGERelation(subfz1, upperbound)))))),
										new CLTLocConjunction(new CLTLocEQRelation(z1, orig), new CLTLocNext(
												new CLTLocUntil(new CLTLocGERelation(z1, orig), new CLTLocConjunction(
														subfhigh, new CLTLocEQRelation(z1, upperbound),
														new CLTLocDisjunction(new CLTLocGERelation(subfz0, upperbound),
																new CLTLocGERelation(subfz1, upperbound)))))))),
						new CLTLocConjunction(orig,
								new CLTLocUntil(new CLTLocDisjunction(orig, new CLTLocGERelation(z0, orig)),
										new CLTLocConjunction(subfinterval, new CLTLocLEQRelation(z0, upperbound))))));

		CLTLocFormula f2;
		f2 = new CLTLocImplies(
				new CLTLocConjunction(subfhigh,
						new CLTLocDisjunction(new CLTLocGERelation(subfz0, upperbound),
								new CLTLocGERelation(subfz1, upperbound))),
				new CLTLocDisjunction(new CLTLocEQRelation(z0, upperbound), new CLTLocEQRelation(z1, upperbound)));

		CLTLocFormula f3;
		f3 = new CLTLocIff(low,
				new CLTLocConjunction(subflow,
						new CLTLocRelease(subfhigh,
								new CLTLocNegation(new CLTLocConjunction(subfhigh,
										new CLTLocConjunction(new CLTLocLEQRelation(subfz0, upperbound),
												new CLTLocLEQRelation(subfz1, upperbound)))))));

		return new CLTLocConjunction(this.clocksEventsConstraints(formula),
				new CLTLocGlobally(new CLTLocConjunction(f1, f2, f3)));
	}

	@Override
	public CLTLocFormula visit(MITLIPast_AtoB formula) {

		return new CLTLocConjunction(this.clocksEventsConstraints(formula),
				auxiliaryClocksConstraintsMITLIPast_AtoB(formula));

	}

	private CLTLocFormula auxiliaryClocksConstraintsMITLIPast_AtoB(MITLIPast_AtoB formula) {

		CLTLConstantAtom orig = new CLTLConstantAtom(0);

		CLTLocFormula low = this.low(formula);
		CLTLocFormula high = this.high(formula);

		CLTLocFormula subflow = this.low(formula.getChild());
		CLTLocFormula subfhigh = this.high(formula.getChild());

		CLTLConstantAtom upperbound = new CLTLConstantAtom(formula.upperbound());
		CLTLConstantAtom lowerbound = new CLTLConstantAtom(formula.lowerbound());

		MITLIFormula subf = formula.getChild();

		CLTLClock z0 = new CLTLClock("z0_" + formula.idFormula());
		CLTLClock z1 = new CLTLClock("z1_" + formula.idFormula());

		CLTLClock subfz0 = new CLTLClock("z0_" + subf.idFormula());
		CLTLClock subfz1 = new CLTLClock("z1_" + subf.idFormula());

		CLTLIntervalAtom subfinterval = new CLTLIntervalAtom(subf.idFormula());

		CLTLClock x0 = new CLTLClock("x" + 0 + "_" + formula.idFormula());

		int a = formula.lowerbound();
		int b = formula.upperbound();

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

			CLTLClock xi = new CLTLClock("x" + i + "_" + formula.idFormula());
			_f1[i] = new CLTLocEQRelation(xi, orig);
			_f5[i] = new CLTLocGEQRelation(xi, orig);
			for (int j = i + 1; j < d; j++) {
				CLTLClock xj = new CLTLClock("x" + j + "_" + formula.idFormula());
				_f2[p++] = new CLTLocNegation(
						new CLTLocConjunction(new CLTLocEQRelation(xi, orig), new CLTLocEQRelation(xj, orig)));
			}

			CLTLClock xiplusdminusonemodd = new CLTLClock("x" + ((i + d - 1) % d) + "_" + formula.idFormula());
			_f3[i] = new CLTLocImplies(new CLTLocEQRelation(xi, orig),
					new CLTLocNext(new CLTLocRelease(new CLTLocEQRelation(xiplusdminusonemodd, orig),
							new CLTLocGERelation(xi, orig))));

			for (int j = 0; j < d; j++) {
				if (j != (i + 1) % d) {
					CLTLClock xj = new CLTLClock("x" + j + "_" + formula.idFormula());
					__f7[i][j] = new CLTLocGERelation(xj, orig);
				}
			}

			CLTLClock xiplusonemodd = new CLTLClock("x" + ((i + 1) % d) + "_" + formula.idFormula());
			_f7[i] = new CLTLocImplies(new CLTLocEQRelation(xi, orig),
					new CLTLocNext(new CLTLocRelease(new CLTLocEQRelation(xiplusonemodd, orig),
							new CLTLocConjunction(__f7[i][0], Arrays.copyOfRange(__f7[i], 1, __f7[i].length)))));

			_f6[i] = new CLTLocConjunction(
					new CLTLocGlobally(new CLTLocDisjunction(new CLTLocNext(new CLTLocEQRelation(xi, orig)),
							new CLTLocNext(new CLTLocGERelation(xi, xi)))),
					new CLTLocDisjunction(new CLTLocGlobally(new CLTLocEventually(new CLTLocEQRelation(xi, orig))),
							new CLTLocEventually(new CLTLocGlobally(new CLTLocGERelation(xi, upperbound)))));

			if (i < d - 1) {
				CLTLClock xdminusimodd = new CLTLClock("x" + ((d - i) % d) + "_" + formula.idFormula());
				CLTLClock xdminusiplusone = new CLTLClock("x" + (d - (i + 1)) + "_" + formula.idFormula());
				_f8[i] = new CLTLocLERelation(xdminusimodd, xdminusiplusone);
			}

		}

		// Formula (4)
		CLTLocFormula f1 = new CLTLocIff(new CLTLocDisjunction(high, low),
				new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length)));

		// Formuala (5)
		CLTLocFormula f2 = new CLTLocConjunction(_f2[0], Arrays.copyOfRange(_f2, 1, _f2.length));

		// Formula (6)
		CLTLocFormula f3 = new CLTLocConjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length));

		CLTLocFormula f4 = new CLTLocEQRelation(x0, orig);

		// Positiveness of all clocks in the origin
		CLTLocFormula f5 = new CLTLocConjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length));

		CLTLocFormula f6 = new CLTLocConjunction(_f6[0], Arrays.copyOfRange(_f6, 1, _f6.length));

		// strict sequence among clocks
		CLTLocFormula f7 = new CLTLocConjunction(_f7[0], Arrays.copyOfRange(_f7, 1, _f7.length));

		// order of clocks at the origin
		CLTLocFormula f8 = new CLTLocConjunction(_f8[0], Arrays.copyOfRange(_f8, 1, _f8.length));

		return new CLTLocDisjunction(f4, f6, f8, new CLTLocGlobally(new CLTLocDisjunction(f1, f2, f7)));

	}

	@Override
	public CLTLocFormula visit(MITLIPast_ZerotoB formula) {
		CLTLConstantAtom orig = new CLTLConstantAtom(0);

		CLTLocFormula low = this.low(formula);
		CLTLocFormula high = this.high(formula);

		CLTLocFormula subflow = this.low(formula.getChild());
		CLTLocFormula subfhigh = this.high(formula.getChild());

		CLTLConstantAtom upperbound = new CLTLConstantAtom(formula.upperbound());
		CLTLConstantAtom lowerbound = new CLTLConstantAtom(formula.lowerbound());

		MITLIFormula subf = formula.getChild();

		CLTLClock z0 = new CLTLClock("z0_" + formula.idFormula());
		CLTLClock z1 = new CLTLClock("z1_" + formula.idFormula());

		CLTLClock subfz0 = new CLTLClock("z0_" + subf.idFormula());
		CLTLClock subfz1 = new CLTLClock("z1_" + subf.idFormula());

		CLTLIntervalAtom subfinterval = new CLTLIntervalAtom(subf.idFormula());

		int a = formula.lowerbound();
		int b = formula.upperbound();

		CLTLocFormula f1;
		f1 = new CLTLocIff(high,
				new CLTLocConjunction(subfhigh,
						new CLTLocDisjunction(orig,
								new CLTLocYesterday(new CLTLocSince(new CLTLocNegation(subfhigh),
										new CLTLocConjunction(orig, new CLTLocNegation(subfinterval)))),
								new CLTLocDisjunction(new CLTLocGERelation(subfz0, upperbound),
										new CLTLocGERelation(subfz1, upperbound)))));

		CLTLocFormula f2;
		f2 = new CLTLocIff(low,
				new CLTLocDisjunction(new CLTLocConjunction(orig, new CLTLocNegation(subfinterval)),
						new CLTLocConjunction(new CLTLocEQRelation(subfz0, upperbound),
								new CLTLocSince(new CLTLocNegation(subfhigh),
										new CLTLocConjunction(subflow, new CLTLocEQRelation(subfz0, orig)))),
						new CLTLocConjunction(new CLTLocEQRelation(subfz1, upperbound),
								new CLTLocSince(new CLTLocNegation(subfhigh),
										new CLTLocConjunction(subflow, new CLTLocEQRelation(subfz1, orig))))));

		CLTLocFormula f5;
		f5 = new CLTLocConjunction(
				new CLTLocImplies(new CLTLocConjunction(subflow, new CLTLocEQRelation(subfz0, orig)),
						new CLTLocUntil(new CLTLocLERelation(subfz0, upperbound),
								new CLTLocDisjunction(
										new CLTLocConjunction(subfhigh, new CLTLocGERelation(subfz0, orig),
												new CLTLocLERelation(subfz0, upperbound)),
										new CLTLocEQRelation(subfz0, upperbound)))),
				new CLTLocImplies(new CLTLocConjunction(subflow, new CLTLocEQRelation(subfz1, orig)),
						new CLTLocUntil(new CLTLocLERelation(subfz1, upperbound),
								new CLTLocDisjunction(
										new CLTLocConjunction(subfhigh, new CLTLocGERelation(subfz1, orig),
												new CLTLocLERelation(subfz1, upperbound)),
										new CLTLocEQRelation(subfz0, upperbound)))));

		return new CLTLocConjunction(this.auxiliaryClocksConstraintsMITLIPast_AtoB(formula),
				new CLTLocGlobally(new CLTLocConjunction(f1, f2, f5)));
	}

	@Override
	public CLTLocFormula visit(MITLIRelease mitliRelease) {
		// Some alias...
		MITLIFormula subf1 = mitliRelease.getLeftChild();
		MITLIFormula subf2 = mitliRelease.getRightChild();

		CLTLIntervalAtom interval = new CLTLIntervalAtom(mitliRelease.idFormula());

		CLTLIntervalAtom subf1interval = new CLTLIntervalAtom(mitliRelease.getLeftChild().idFormula());

		CLTLIntervalAtom subf2interval = new CLTLIntervalAtom(mitliRelease.getRightChild().idFormula());

		CLTLocFormula f1 = new CLTLocIff(interval, new CLTLocRelease(subf1interval, subf2interval));

		return new CLTLocConjunction(this.clocksEventsConstraints(mitliRelease), new CLTLocGlobally(f1));
	}
}
