package formulae.mitli.visitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import formulae.BinaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLClock;
import formulae.cltloc.atoms.CLTLConstantAtom;
import formulae.cltloc.atoms.CLTLHighAtom;
import formulae.cltloc.atoms.CLTLLowAtom;
import formulae.cltloc.atoms.CLTLocAP;
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

	private static final BinaryOperator<CLTLocFormula> conjunctionOperator = CLTLocConjunction::new;
	private static final BinaryOperator<CLTLocFormula> disjunctionOperator = CLTLocDisjunction::new;
	private static final BinaryOperator<CLTLocFormula> implicationOperator = CLTLocImplies::new;
	private static final BinaryOperator<CLTLocFormula> untilOperatior = CLTLocUntil::new;
	private static final BinaryOperator<CLTLocFormula> iffOperator = CLTLocIff::new;
	private static final BiFunction<CLTLClock, CLTLConstantAtom, CLTLocFormula> cltoEqOperator = CLTLocEQRelation::new;

	private static final UnaryOperator<CLTLocFormula> negationOperator = CLTLocNegation::new;
	private static final UnaryOperator<CLTLocFormula> globallyOperator = CLTLocGlobally::new;
	private static final UnaryOperator<CLTLocFormula> nextOperator = CLTLocNext::new;

	private static final Function<Integer, CLTLocFormula> restHIGHAtom = (s) -> new CLTLocAP("H_" + s);
	
	private static final Function<Integer, CLTLocFormula> firstHIGHAtom = (s) -> new CLTLocAP("z0_" + s);
	private static final Function<Integer, CLTLocFormula> firstLOWAtom = (s) -> new CLTLocAP("z1_" + s);

	/**
	 * step up (fist shortcut in table 3)
	 */
	private static final Function<Integer, CLTLocFormula> stepUp = (s) -> new CLTLocConjunction(
			new CLTLocNegation(new CLTLocYesterday(restHIGHAtom.apply(s))), restHIGHAtom.apply(s));

	/**
	 * step down (Third shortcut in table 3)
	 */
	private static final Function<Integer, CLTLocFormula> stepDown = (s) -> new CLTLocConjunction(
			new CLTLocYesterday(restHIGHAtom.apply(s)), new CLTLocNegation(restHIGHAtom.apply(s)));

	/**
	 * step up (second shortcut in table 3)
	 */
	private static final Function<Integer, CLTLocFormula> upSingularity = (s) -> new CLTLocConjunction(
			new CLTLocYesterday(new CLTLocNegation(restHIGHAtom.apply(s))),
			new CLTLocConjunction(firstHIGHAtom.apply(s), new CLTLocNegation(restHIGHAtom.apply(s))));

	/**
	 * step down (fourth shortcut in table 3)
	 */
	private static final Function<Integer, CLTLocFormula> downSingularity = (s) -> new CLTLocConjunction(
			new CLTLocYesterday(restHIGHAtom.apply(s)),
			new CLTLocConjunction(new CLTLocNegation(firstHIGHAtom.apply(s)), restHIGHAtom.apply(s)));

	/**
	 * stays up
	 */
	private static final Function<Integer, CLTLocFormula> staysUp = (s) -> new CLTLocConjunction(restHIGHAtom.apply(s),
			firstHIGHAtom.apply(s));

	private static final CLTLConstantAtom zero = new CLTLConstantAtom(0);

	private Map<MITLIFormula, Integer> formulaIdMap;

	private final Function<MITLIFormula, CLTLClock> newz0clock = formula -> new CLTLClock(
			"z0_" + formulaIdMap.get(formula));
	private final Function<MITLIFormula, CLTLClock> newz1clock = formula -> new CLTLClock(
			"z1_" + formulaIdMap.get(formula));

	public MITLI2CLTLocVisitor(MITLIFormula formula) {

		Set<MITLIFormula> subformulae = formula.accept(new SubformulaeVisitor());
		List<MITLIFormula> listSubFormula = new ArrayList<>(subformulae);
		formulaIdMap = IntStream.range(0, listSubFormula.size()).boxed()
				.collect(Collectors.toMap(listSubFormula::get, i -> i));

	}

	public CLTLocFormula combineBinaryFormulaWithBinaryOperator(BinaryFormula<MITLIFormula> formula,
			BinaryOperator<CLTLocFormula> operator) {

		CLTLocFormula f1 = new CLTLocIff(firstHIGHAtom.apply(formulaIdMap.get(formula)),
				operator.apply(firstHIGHAtom.apply(formulaIdMap.get(formula.getLeftChild())),
						firstHIGHAtom.apply(formulaIdMap.get(formula.getLeftChild()))));

		CLTLocFormula f2 = new CLTLocIff(restHIGHAtom.apply(formulaIdMap.get(formula)),
				operator.apply(restHIGHAtom.apply(formulaIdMap.get(formula.getLeftChild())),
						restHIGHAtom.apply(formulaIdMap.get(formula.getLeftChild()))));
		return conjunctionOperator.apply(f1, f2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIConjunction formula) {
		return this.combineBinaryFormulaWithBinaryOperator(formula, conjunctionOperator);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIDisjunction formula) {
		return this.combineBinaryFormulaWithBinaryOperator(formula, disjunctionOperator);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIIff formula) {
		return this.combineBinaryFormulaWithBinaryOperator(formula, iffOperator);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIImplies formula) {
		return this.combineBinaryFormulaWithBinaryOperator(formula, implicationOperator);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLINegation formula) {
		MITLIFormula subf = formula.getChild();

		CLTLocFormula f1 = iffOperator.apply(firstHIGHAtom.apply(formulaIdMap.get(formula)),
				negationOperator.apply(firstHIGHAtom.apply(formulaIdMap.get(subf))));

		CLTLocFormula f2 = iffOperator.apply(restHIGHAtom.apply(formulaIdMap.get(formula)),
				negationOperator.apply(restHIGHAtom.apply(formulaIdMap.get(subf))));
		return conjunctionOperator.apply(f1, f2);
	}

	@Override
	public CLTLocFormula visit(MITLIUntil formula) {

		int formulaId = formulaIdMap.get(formula);
		int leftChildId = formulaIdMap.get(formula.getLeftChild());
		int rightChildId = formulaIdMap.get(formula.getRightChild());

		CLTLocFormula formulaRESTHIGH = restHIGHAtom.apply(formulaId);
		CLTLocFormula leftRESTHIGH = restHIGHAtom.apply(leftChildId);
		CLTLocFormula rightRESTHIGH = restHIGHAtom.apply(rightChildId);

		CLTLocFormula f1 = iffOperator.apply(firstHIGHAtom.apply(formulaId), formulaRESTHIGH);

		CLTLocFormula f2 = conjunctionOperator
				.apply(iffOperator.apply(formulaRESTHIGH, leftRESTHIGH),
						disjunctionOperator
								.apply(rightRESTHIGH,
										nextOperator.apply(untilOperatior.apply(staysUp.apply(leftChildId),
												disjunctionOperator.apply(conjunctionOperator
														.apply(staysUp.apply(leftChildId), rightRESTHIGH),
														firstHIGHAtom.apply(rightChildId))))

						));

		return conjunctionOperator.apply(f1, f2);
	}

	@Override
	public CLTLocFormula visit(MITLIFalse formula) {
		int formulaId = formulaIdMap.get(formula);
		
		CLTLocFormula restLow = restLOWAtom.apply(formulaId);
		CLTLocFormula restHigh = restHIGHAtom.apply(formulaId);
		
		// TODO perche' il globally vale solo per il high e non per il low?
		return conjunctionOperator.apply(restLow,
				globallyOperator.apply(negationOperator.apply(restHigh)));
	}

	@Override
	public CLTLocFormula visit(MITLITrue formula) {
		int formulaId = formulaIdMap.get(formula);

		CLTLocFormula restLow = restLOWAtom.apply(formulaId);
		CLTLocFormula restHigh = restHIGHAtom.apply(formulaId);
		
		//TODO perche' non e' detto niente sul restLow
		return 
				globallyOperator.apply(restHigh);
	}

	@Override
	public CLTLocFormula visit(MITLIAtom formula) {
		return this.clocksEventsConstraints(formula);
	}

	@Override
	public CLTLocFormula visit(MITLISince formula) {
		// Some alias...
		MITLIFormula subf1 = formula.getLeftChild();
		MITLIFormula subf2 = formula.getRightChild();

		CLTLocFormula f1 = new CLTLocIff(restHighAtom.apply(formula.idFormula()),
				conjunctionOperator.apply(restHighAtom.apply(subf1.idFormula()),
						new CLTLocSince(restHighAtom.apply(subf1.idFormula()), restHighAtom.apply(subf2.idFormula()))));

		CLTLocFormula f2 = new CLTLocIff(restHighAtom.apply(formula.idFormula()), conjunctionOperator
				.apply(restHighAtom.apply(subf1.idFormula()), restHighAtom.apply(subf2.idFormula())));

		return conjunctionOperator.apply(this.clocksEventsConstraints(formula), f2, globallyOperator.apply(f1));
	}

	@Override
	public CLTLocFormula visit(MITLIGlobally_AtoInf formula) {
		CLTLConstantAtom orig = new CLTLConstantAtom(0);

		MITLIFormula subf = formula.getChild();

		CLTLConstantAtom lowerbound = new CLTLConstantAtom(formula.lowerbound());

		CLTLClock z0 = newz0clock.apply(formula);
		CLTLClock z1 = newz1clock.apply(formula);

		// Formula (15)

		CLTLocFormula low = this.low(formula);
		CLTLocFormula high = this.high(formula);
		CLTLocFormula subflow = this.low(formula.getChild());
		CLTLocFormula subfhigh = this.high(formula.getChild());

		CLTLocFormula f1;
		f1 = new CLTLocIff(low,
				conjunctionOperator.apply(orig,
						new CLTLocUntil(new CLTLocGERelation(z0, orig),
								conjunctionOperator.apply(negationOperator.apply(restHighAtom.apply(subf.idFormula())),
										new CLTLocDisjunction(new CLTLocLEQRelation(z0, lowerbound),
												conjunctionOperator.apply(new CLTLocLEQRelation(z0, lowerbound),
														new CLTLocNext(new CLTLocGERelation(z0, lowerbound))))))));

		// Formula (16)

		CLTLocFormula f2;
		f2 = new CLTLocIff(
				this.high(
						formula),
				new CLTLocDisjunction(
						conjunctionOperator.apply(new CLTLocEQRelation(z1, orig),
								new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(z1, orig),
										conjunctionOperator.apply(subfhigh, new CLTLocEQRelation(z1, lowerbound),
												globallyOperator.apply(negationOperator.apply(subflow)))))),
						conjunctionOperator.apply(orig, negationOperator.apply(low))));

		CLTLocFormula f3;
		f3 = new CLTLocImplies(
				conjunctionOperator.apply(subfhigh, globallyOperator.apply(negationOperator.apply(subflow))),
				new CLTLocEQRelation(z1, lowerbound));

		return conjunctionOperator.apply(this.clocksEventsConstraints(formula),
				globallyOperator.apply(conjunctionOperator.apply(f1, f2, f3)));

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

		CLTLIntervalAtom interval = restHighAtom.apply(mitliGlobally_AtoB.idFormula());
		CLTLIntervalAtom subInterval = restHighAtom.apply(mitliGlobally_AtoB.getChild().idFormula());

		for (int i = 0; i < d; i++) {
			_f1[i] = conjunctionOperator
					.apply(new CLTLocEQRelation(
							new CLTLClock(
									"x" + i + "_"
											+ mitliGlobally_AtoB
													.idFormula()),
							orig),
							new CLTLocNext(
									new CLTLocUntil(
											new CLTLocGERelation(new CLTLClock("x" + i + "_"
													+ mitliGlobally_AtoB
															.idFormula()),
													orig),
											conjunctionOperator.apply(subflow,
													new CLTLocEQRelation(
															new CLTLClock(
																	"x" + i + "_" + mitliGlobally_AtoB.idFormula()),
															bValue),
													new CLTLocDisjunction(new CLTLocGERelation(subfz0, lValue),
															new CLTLocGERelation(subfz1, lValue))))));
		}

		// Formula (8)
		CLTLocFormula f1;
		f1 = new CLTLocIff(low,
				new CLTLocDisjunction(
						conjunctionOperator.apply(negationOperator.apply(orig),
								new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length))),
						conjunctionOperator.apply(orig,
								new CLTLocUntil(new CLTLocDisjunction(new CLTLocGERelation(z0, orig), orig),
										conjunctionOperator.apply(negationOperator.apply(subInterval),
												new CLTLocDisjunction(
														conjunctionOperator.apply(
																new CLTLocGEQRelation(z0,
																		aValue),
																new CLTLocLEQRelation(z0, bValue)),
														conjunctionOperator.apply(new CLTLocLERelation(z0, aValue),
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
				conjunctionOperator.apply(subflow,
						new CLTLocDisjunction(new CLTLocGERelation(subfz0, lValue),
								new CLTLocGERelation(subfz1, lValue))),
				new CLTLocDisjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length)));

		CLTLocFormula[] _f4 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + mitliGlobally_AtoB.idFormula());

			_f4[i] = conjunctionOperator.apply(new CLTLocEQRelation(xi, orig),
					new CLTLocNext(new CLTLocUntil(new CLTLocGEQRelation(xi, orig), conjunctionOperator.apply(subfhigh,
							new CLTLocEQRelation(xi, aValue), new CLTLocRelease(subflow, negationOperator
									.apply(conjunctionOperator.apply(subflow, new CLTLocLEQRelation(xi, upperbound)))

							)))));
		}

		CLTLocFormula f4;
		f4 = new CLTLocIff(high,
				new CLTLocDisjunction(
						conjunctionOperator.apply(negationOperator.apply(orig),
								new CLTLocDisjunction(_f4[0], Arrays.copyOfRange(_f4, 1, _f4.length))),
						conjunctionOperator.apply(orig, negationOperator.apply(low))));

		CLTLocFormula[] _f5 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + mitliGlobally_AtoB.idFormula());

			_f5[i] = new CLTLocEQRelation(xi, aValue);
		}

		CLTLocFormula f5 = new CLTLocImplies(conjunctionOperator.apply(subfhigh,
				new CLTLocRelease(subflow, negationOperator.apply(conjunctionOperator.apply(subflow, conjunctionOperator
						.apply(new CLTLocLEQRelation(subfz0, lValue), new CLTLocLEQRelation(subfz1, lValue))))

				)), new CLTLocDisjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length)));

		return conjunctionOperator.apply(this.clocksEventsConstraints(mitliGlobally_AtoB),
				auxiliaryClocksConstraints(mitliGlobally_AtoB),
				globallyOperator.apply(conjunctionOperator.apply(f1, f3, f4, f5)));
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

				_f2[p++] = negationOperator.apply(
						conjunctionOperator.apply(new CLTLocEQRelation(xi, orig), new CLTLocEQRelation(xj, orig)));
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
							conjunctionOperator.apply(__f7[i][0], Arrays.copyOfRange(__f7[i], 1, __f7[i].length)))));

			_f6[i] = conjunctionOperator.apply(
					globallyOperator.apply(new CLTLocDisjunction(new CLTLocNext(new CLTLocEQRelation(xi, orig)))),
					new CLTLocDisjunction(globallyOperator.apply(new CLTLocEventually(new CLTLocEQRelation(xi, orig))),
							new CLTLocEventually(globallyOperator.apply(new CLTLocGERelation(xi, bValue)))));

			if (i < d - 1)
				_f8[i] = new CLTLocLEQRelation(xiplusdminus1, xiplusdplus1);

		}

		// Formula (4)
		CLTLocFormula f1 = new CLTLocIff(new CLTLocDisjunction(high, low),
				new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length)));

		// Formuala (5)
		CLTLocFormula f2 = conjunctionOperator.apply(_f2[0], Arrays.copyOfRange(_f2, 1, _f2.length));

		// Formula (6)
		CLTLocFormula f3 = conjunctionOperator.apply(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length));

		// String f4 = new CLTLocEQRelation( x(0,t), orig);
		CLTLocFormula f4 = new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length));

		// Positiveness of all clocks in the origin
		CLTLocFormula f5 = conjunctionOperator.apply(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length));

		CLTLocFormula f6 = conjunctionOperator.apply(_f6[0], Arrays.copyOfRange(_f6, 1, _f6.length));

		// strict sequence among clocks
		CLTLocFormula f7 = conjunctionOperator.apply(_f7[0], Arrays.copyOfRange(_f7, 1, _f7.length));

		// order of clocks at the origin
		CLTLocFormula f8 = conjunctionOperator.apply(_f8[0], Arrays.copyOfRange(_f8, 1, _f8.length));

		return conjunctionOperator.apply(f4, f6, f8, globallyOperator.apply(conjunctionOperator.apply(f1, f2, f7)));

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

		CLTLIntervalAtom subfinterval = restHighAtom.apply(subf.idFormula());

		CLTLocFormula f1;
		f1 = new CLTLocIff(low,
				new CLTLocDisjunction(
						conjunctionOperator
								.apply(negationOperator.apply(orig), subfinterval, new CLTLocDisjunction(
										conjunctionOperator.apply(new CLTLocEQRelation(z0, orig),
												new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(z0, orig),
														conjunctionOperator.apply(subflow,
																new CLTLocEQRelation(z0, upperbound),
																new CLTLocDisjunction(new CLTLocGERelation(subfz0,
																		upperbound),
																		new CLTLocGERelation(subfz1, upperbound)))))),
										conjunctionOperator.apply(new CLTLocEQRelation(z1, orig),
												new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(z1, orig),
														conjunctionOperator.apply(subflow,
																new CLTLocEQRelation(z1,
																		upperbound),
																new CLTLocDisjunction(
																		new CLTLocGERelation(subfz0, upperbound),
																		new CLTLocGERelation(subfz1, upperbound)))))))),
						conjunctionOperator.apply(orig,
								new CLTLocUntil(new CLTLocDisjunction(orig, new CLTLocGERelation(z0, orig)),
										conjunctionOperator.apply(negationOperator.apply(subfinterval),
												new CLTLocLEQRelation(z0, upperbound))))));

		CLTLocFormula f2;
		f2 = new CLTLocImplies(
				conjunctionOperator.apply(subflow,
						new CLTLocDisjunction(new CLTLocGERelation(subfz0, upperbound),
								new CLTLocGERelation(subfz1, upperbound))),
				new CLTLocDisjunction(new CLTLocEQRelation(z0, upperbound), new CLTLocEQRelation(z1, upperbound)));

		CLTLocFormula f3;
		f3 = new CLTLocIff(high,
				conjunctionOperator.apply(subfhigh,
						new CLTLocRelease(subflow,
								negationOperator.apply(conjunctionOperator.apply(subflow,
										conjunctionOperator.apply(new CLTLocLEQRelation(subfz0, upperbound),
												new CLTLocLEQRelation(subfz1, upperbound)))))));

		return conjunctionOperator.apply(this.clocksEventsConstraints(formula),
				globallyOperator.apply(conjunctionOperator.apply(f1, f2, f3)));
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

		CLTLClock z0 = newz0clock.apply(formula);
		CLTLClock z1 = newz1clock.apply(formula);

		CLTLClock subfz0 = newz0clock.apply(formula.getChild());
		CLTLClock subfz1 = newz1clock.apply(formula.getChild());

		CLTLIntervalAtom subfinterval = restHighAtom.apply(subf.idFormula());

		int a = formula.lowerbound();
		int b = formula.upperbound();
		int l = b - a;

		CLTLConstantAtom lValue = new CLTLConstantAtom(l);

		int d = 2 * (int) Math.ceil((float) b / (b - a));

		CLTLocFormula[] _f1 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + formula.idFormula());
			_f1[i] = conjunctionOperator.apply(new CLTLocEQRelation(xi, orig),
					new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(xi, orig),
							conjunctionOperator.apply(subfhigh, new CLTLocEQRelation(xi, upperbound),
									new CLTLocDisjunction(new CLTLocGERelation(subfz0, lValue),
											new CLTLocGERelation(subfz1, lValue))))));
		}

		CLTLClock x0 = new CLTLClock("x" + 0 + "_" + formula.idFormula());
		// Formula (8)
		CLTLocFormula f1;
		f1 = new CLTLocIff(high,
				new CLTLocDisjunction(
						conjunctionOperator.apply(negationOperator.apply(orig),
								new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length))),
						conjunctionOperator.apply(orig,
								new CLTLocUntil(new CLTLocDisjunction(new CLTLocGERelation(x0, orig), orig),
										conjunctionOperator.apply(subfinterval,
												new CLTLocDisjunction(
														conjunctionOperator.apply(new CLTLocGEQRelation(x0, lowerbound),
																new CLTLocLEQRelation(x0, upperbound)),
														conjunctionOperator.apply(new CLTLocLERelation(x0, lowerbound),
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
				conjunctionOperator.apply(subfhigh,
						new CLTLocDisjunction(new CLTLocGERelation(subfz0, lValue),
								new CLTLocGERelation(subfz1, lValue))),
				new CLTLocDisjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length)));

		CLTLocFormula[] _f4 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + formula.idFormula());
			_f4[i] = conjunctionOperator.apply(new CLTLocEQRelation(xi, orig),
					new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(xi, orig), conjunctionOperator.apply(subflow,
							new CLTLocEQRelation(xi, lowerbound), new CLTLocRelease(subfhigh, negationOperator
									.apply(conjunctionOperator.apply(subfhigh, new CLTLocLEQRelation(xi, upperbound)))

							)))));
		}

		CLTLocFormula f4;
		f4 = new CLTLocIff(low,
				new CLTLocDisjunction(
						conjunctionOperator.apply(negationOperator.apply(orig),
								new CLTLocDisjunction(_f4[0], Arrays.copyOfRange(_f4, 1, _f4.length))),
						conjunctionOperator.apply(orig, negationOperator.apply(high))));

		CLTLocFormula[] _f5 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLClock xi = new CLTLClock("x" + i + "_" + formula.idFormula());

			_f5[i] = new CLTLocEQRelation(xi, lowerbound);
		}

		CLTLocFormula f5 = new CLTLocImplies(conjunctionOperator.apply(subflow,
				new CLTLocRelease(subfhigh,
						negationOperator.apply(conjunctionOperator.apply(subfhigh, conjunctionOperator
								.apply(new CLTLocLEQRelation(subfz0, lValue), new CLTLocLEQRelation(subfz1, lValue))))

				)), new CLTLocDisjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length)));

		return conjunctionOperator.apply(this.clocksEventsConstraints(formula),
				this.auxiliaryClocksConstraintsMITLIEventually_AtoB(formula),
				globallyOperator.apply(conjunctionOperator.apply(f1, f3, f4, f5)));

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
				_f2[p++] = negationOperator.apply(
						conjunctionOperator.apply(new CLTLocEQRelation(xi, orig), new CLTLocEQRelation(xj, orig)));
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
							conjunctionOperator.apply(__f7[i][0], Arrays.copyOfRange(__f7[i], 1, __f7[i].length)))));
			_f6[i] = conjunctionOperator.apply(
					globallyOperator.apply(new CLTLocDisjunction(new CLTLocNext(new CLTLocEQRelation(xi, orig)),
							new CLTLocNext(new CLTLocGERelation(xi, xi)))),
					new CLTLocDisjunction(globallyOperator.apply(new CLTLocEventually(new CLTLocEQRelation(xi, orig))),
							new CLTLocEventually(globallyOperator.apply(new CLTLocGERelation(xi, upperbound)))));

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
		CLTLocFormula f2 = conjunctionOperator.apply(_f2[0], Arrays.copyOfRange(_f2, 1, _f2.length));

		// Formula (6)
		CLTLocFormula f3 = conjunctionOperator.apply(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length));

		CLTLocFormula f4 = new CLTLocEQRelation(x0, orig);

		// Positiveness of all clocks in the origin
		CLTLocFormula f5 = conjunctionOperator.apply(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length));

		CLTLocFormula f6 = conjunctionOperator.apply(_f6[0], Arrays.copyOfRange(_f6, 1, _f6.length));

		// strict sequence among clocks
		CLTLocFormula f7 = conjunctionOperator.apply(_f7[0], Arrays.copyOfRange(_f7, 1, _f7.length));

		// order of clocks at the origin
		CLTLocFormula f8 = conjunctionOperator.apply(_f8[0], Arrays.copyOfRange(_f8, 1, _f8.length));

		return conjunctionOperator.apply(f4, f6, f8, globallyOperator.apply(conjunctionOperator.apply(f1, f2, f7)));
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

		CLTLIntervalAtom subfinterval = restHighAtom.apply(subf.idFormula());

		int a = formula.lowerbound();
		int b = formula.upperbound();

		int d = 2 * (int) Math.ceil((float) b / (b - a));
		int p = 0;

		// Formula (15)

		CLTLocFormula f1;
		f1 = new CLTLocIff(high,
				conjunctionOperator.apply(orig,
						new CLTLocUntil(new CLTLocDisjunction(new CLTLocGERelation(z0, orig), orig),
								conjunctionOperator.apply(subfinterval,
										new CLTLocDisjunction(new CLTLocLEQRelation(z0, lowerbound),
												conjunctionOperator.apply(new CLTLocLEQRelation(z0, lowerbound),
														new CLTLocNext(new CLTLocGERelation(z0, lowerbound))))))));

		// Formula (16)

		CLTLocFormula f2;
		f2 = new CLTLocIff(low,
				new CLTLocDisjunction(
						conjunctionOperator.apply(new CLTLocEQRelation(z1, orig),
								new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(z1, orig),
										conjunctionOperator.apply(subflow, new CLTLocEQRelation(z1, lowerbound),
												globallyOperator.apply(negationOperator.apply(subfhigh)))))),
						conjunctionOperator.apply(orig, negationOperator.apply(high))));

		CLTLocFormula f3;
		f3 = new CLTLocImplies(
				conjunctionOperator.apply(subflow, globallyOperator.apply(negationOperator.apply(subfhigh))),
				new CLTLocEQRelation(z1, lowerbound));

		return conjunctionOperator.apply(this.clocksEventsConstraints(formula),
				globallyOperator.apply(conjunctionOperator.apply(f1, f2, f3)));

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

		CLTLIntervalAtom subfinterval = restHighAtom.apply(subf.idFormula());

		int a = formula.lowerbound();
		int b = formula.upperbound();

		CLTLocFormula f1;
		f1 = new CLTLocIff(high, new CLTLocDisjunction(
				conjunctionOperator.apply(negationOperator.apply(
						orig), negationOperator.apply(subfinterval), new CLTLocDisjunction(
								conjunctionOperator.apply(
										new CLTLocEQRelation(z0, orig),
										new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(z0, orig),
												conjunctionOperator.apply(subfhigh,
														new CLTLocEQRelation(z0, upperbound), new CLTLocDisjunction(
																new CLTLocGERelation(subfz0, upperbound),
																new CLTLocGERelation(subfz1, upperbound)))))),
								conjunctionOperator.apply(new CLTLocEQRelation(z1, orig),
										new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(z1, orig),
												conjunctionOperator.apply(subfhigh,
														new CLTLocEQRelation(z1, upperbound), new CLTLocDisjunction(
																new CLTLocGERelation(subfz0, upperbound),
																new CLTLocGERelation(subfz1, upperbound)))))))),
				conjunctionOperator.apply(orig,
						new CLTLocUntil(new CLTLocDisjunction(orig, new CLTLocGERelation(z0, orig)),
								conjunctionOperator.apply(subfinterval, new CLTLocLEQRelation(z0, upperbound))))));

		CLTLocFormula f2;
		f2 = new CLTLocImplies(
				conjunctionOperator.apply(subfhigh,
						new CLTLocDisjunction(new CLTLocGERelation(subfz0, upperbound),
								new CLTLocGERelation(subfz1, upperbound))),
				new CLTLocDisjunction(new CLTLocEQRelation(z0, upperbound), new CLTLocEQRelation(z1, upperbound)));

		CLTLocFormula f3;
		f3 = new CLTLocIff(low,
				conjunctionOperator.apply(subflow,
						new CLTLocRelease(subfhigh,
								negationOperator.apply(conjunctionOperator.apply(subfhigh,
										conjunctionOperator.apply(new CLTLocLEQRelation(subfz0, upperbound),
												new CLTLocLEQRelation(subfz1, upperbound)))))));

		return conjunctionOperator.apply(this.clocksEventsConstraints(formula),
				globallyOperator.apply(conjunctionOperator.apply(f1, f2, f3)));
	}

	@Override
	public CLTLocFormula visit(MITLIPast_AtoB formula) {

		return conjunctionOperator.apply(this.clocksEventsConstraints(formula),
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

		CLTLIntervalAtom subfinterval = restHighAtom.apply(subf.idFormula());

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
				_f2[p++] = negationOperator.apply(
						conjunctionOperator.apply(new CLTLocEQRelation(xi, orig), new CLTLocEQRelation(xj, orig)));
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
							conjunctionOperator.apply(__f7[i][0], Arrays.copyOfRange(__f7[i], 1, __f7[i].length)))));

			_f6[i] = conjunctionOperator.apply(
					globallyOperator.apply(new CLTLocDisjunction(new CLTLocNext(new CLTLocEQRelation(xi, orig)),
							new CLTLocNext(new CLTLocGERelation(xi, xi)))),
					new CLTLocDisjunction(globallyOperator.apply(new CLTLocEventually(new CLTLocEQRelation(xi, orig))),
							new CLTLocEventually(globallyOperator.apply(new CLTLocGERelation(xi, upperbound)))));

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
		CLTLocFormula f2 = conjunctionOperator.apply(_f2[0], Arrays.copyOfRange(_f2, 1, _f2.length));

		// Formula (6)
		CLTLocFormula f3 = conjunctionOperator.apply(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length));

		CLTLocFormula f4 = new CLTLocEQRelation(x0, orig);

		// Positiveness of all clocks in the origin
		CLTLocFormula f5 = conjunctionOperator.apply(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length));

		CLTLocFormula f6 = conjunctionOperator.apply(_f6[0], Arrays.copyOfRange(_f6, 1, _f6.length));

		// strict sequence among clocks
		CLTLocFormula f7 = conjunctionOperator.apply(_f7[0], Arrays.copyOfRange(_f7, 1, _f7.length));

		// order of clocks at the origin
		CLTLocFormula f8 = conjunctionOperator.apply(_f8[0], Arrays.copyOfRange(_f8, 1, _f8.length));

		return new CLTLocDisjunction(f4, f6, f8, globallyOperator.apply(new CLTLocDisjunction(f1, f2, f7)));

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

		CLTLIntervalAtom subfinterval = restHighAtom.apply(subf.idFormula());

		int a = formula.lowerbound();
		int b = formula.upperbound();

		CLTLocFormula f1;
		f1 = new CLTLocIff(high,
				conjunctionOperator.apply(subfhigh,
						new CLTLocDisjunction(orig,
								new CLTLocYesterday(new CLTLocSince(negationOperator.apply(subfhigh),
										conjunctionOperator.apply(orig, negationOperator.apply(subfinterval)))),
								new CLTLocDisjunction(new CLTLocGERelation(subfz0, upperbound),
										new CLTLocGERelation(subfz1, upperbound)))));

		CLTLocFormula f2;
		f2 = new CLTLocIff(low,
				new CLTLocDisjunction(conjunctionOperator.apply(orig, negationOperator.apply(subfinterval)),
						conjunctionOperator.apply(new CLTLocEQRelation(subfz0, upperbound),
								new CLTLocSince(negationOperator.apply(subfhigh),
										conjunctionOperator.apply(subflow, new CLTLocEQRelation(subfz0, orig)))),
						conjunctionOperator.apply(new CLTLocEQRelation(subfz1, upperbound),
								new CLTLocSince(negationOperator.apply(subfhigh),
										conjunctionOperator.apply(subflow, new CLTLocEQRelation(subfz1, orig))))));

		CLTLocFormula f5;
		f5 = conjunctionOperator.apply(
				new CLTLocImplies(
						conjunctionOperator
								.apply(subflow,
										new CLTLocEQRelation(subfz0,
												orig)),
						new CLTLocUntil(new CLTLocLERelation(subfz0, upperbound),
								new CLTLocDisjunction(
										conjunctionOperator.apply(subfhigh, new CLTLocGERelation(subfz0, orig),
												new CLTLocLERelation(subfz0, upperbound)),
										new CLTLocEQRelation(subfz0, upperbound)))),
				new CLTLocImplies(conjunctionOperator.apply(subflow, new CLTLocEQRelation(subfz1, orig)),
						new CLTLocUntil(new CLTLocLERelation(subfz1, upperbound),
								new CLTLocDisjunction(
										conjunctionOperator.apply(subfhigh, new CLTLocGERelation(subfz1, orig),
												new CLTLocLERelation(subfz1, upperbound)),
										new CLTLocEQRelation(subfz0, upperbound)))));

		return conjunctionOperator.apply(this.auxiliaryClocksConstraintsMITLIPast_AtoB(formula),
				globallyOperator.apply(conjunctionOperator.apply(f1, f2, f5)));
	}

	@Override
	public CLTLocFormula visit(MITLIRelease mitliRelease) {
		// Some alias...
		MITLIFormula subf1 = mitliRelease.getLeftChild();
		MITLIFormula subf2 = mitliRelease.getRightChild();

		CLTLIntervalAtom interval = restHighAtom.apply(mitliRelease.idFormula());

		CLTLIntervalAtom subf1interval = restHighAtom.apply(mitliRelease.getLeftChild().idFormula());

		CLTLIntervalAtom subf2interval = restHighAtom.apply(mitliRelease.getRightChild().idFormula());

		CLTLocFormula f1 = new CLTLocIff(interval, new CLTLocRelease(subf1interval, subf2interval));

		return conjunctionOperator.apply(this.clocksEventsConstraints(mitliRelease), globallyOperator.apply(f1));
	}
}
