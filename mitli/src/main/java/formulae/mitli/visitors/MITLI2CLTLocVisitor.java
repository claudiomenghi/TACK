package formulae.mitli.visitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import org.apache.log4j.Logger;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import formulae.BinaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocConstantAtom;
import formulae.cltloc.atoms.CLTLocSignal;
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
import formulae.mitli.MITLIConjunction;
import formulae.mitli.MITLIDisjunction;
import formulae.mitli.MITLIEventually_AtoB;
import formulae.mitli.MITLIEventually_AtoInf;
import formulae.mitli.MITLIEventually_ZerotoB;
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
import formulae.mitli.MITLIUntil;
import formulae.mitli.atoms.MITLIFalse;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.atoms.MITLITrue;

public class MITLI2CLTLocVisitor implements MITLIVisitor<CLTLocFormula> {

	private final static Logger LOGGER = Logger.getLogger(MITLI2CLTLocVisitor.class);

	public final BiMap<MITLIFormula, Integer> formulaIdMap = HashBiMap.create();

	/**
	 * is true in the origin of the time
	 */
	private static final CLTLocFormula ORIGIN = new CLTLocNegation(new CLTLocYesterday(CLTLocFormula.TRUE));

	private static final CLTLocConstantAtom ZERO = new CLTLocConstantAtom(0);

	private static final CLTLocClock NOW = new CLTLocClock("Now");

	private final int maxIntComparedto;

	public static final BinaryOperator<CLTLocFormula> AND = CLTLocConjunction::new;
	public static final BinaryOperator<CLTLocFormula> OR = CLTLocDisjunction::new;
	public static final BinaryOperator<CLTLocFormula> IMPL = CLTLocImplies::new;
	public static final BinaryOperator<CLTLocFormula> U = CLTLocUntil::new;
	public static final BinaryOperator<CLTLocFormula> S = CLTLocSince::new;
	public static final BinaryOperator<CLTLocFormula> R = CLTLocRelease::new;
	public static final BinaryOperator<CLTLocFormula> IFF = CLTLocIff::new;

	public static final BiFunction<CLTLocClock, CLTLocConstantAtom, CLTLocFormula> EQ = CLTLocEQRelation::new;

	public static final BiFunction<CLTLocClock, CLTLocConstantAtom, CLTLocFormula> GE = CLTLocGERelation::new;
	public static final BiFunction<CLTLocClock, CLTLocConstantAtom, CLTLocFormula> GEQ = CLTLocGEQRelation::new;
	public static final BiFunction<CLTLocClock, CLTLocConstantAtom, CLTLocFormula> LE = CLTLocLERelation::new;
	public static final BiFunction<CLTLocClock, CLTLocConstantAtom, CLTLocFormula> LEQ = CLTLocLEQRelation::new;

	public static final UnaryOperator<CLTLocFormula> NEG = CLTLocNegation::new;
	public static final UnaryOperator<CLTLocFormula> F = CLTLocEventually::new;
	public static final UnaryOperator<CLTLocFormula> G = CLTLocGlobally::new;
	public static final UnaryOperator<CLTLocFormula> X = CLTLocNext::new;
	public static final UnaryOperator<CLTLocFormula> Y = CLTLocYesterday::new;

	public static final Function<Integer, CLTLocFormula> rest = (s) -> new CLTLocAP("H_" + s);

	public static final Function<Integer, CLTLocFormula> first = (s) -> new CLTLocAP("P_" + s);

	/**
	 * step up (fist shortcut in table 3)
	 */
	public static final Function<Integer, CLTLocFormula> high = (s) -> new CLTLocConjunction(
			new CLTLocNegation(new CLTLocYesterday(rest.apply(s))), rest.apply(s));

	/**
	 * step down (Third shortcut in table 3)
	 */
	public static final Function<Integer, CLTLocFormula> low = (s) -> new CLTLocConjunction(
			new CLTLocNegation(new CLTLocYesterday(new CLTLocNegation(rest.apply(s)))),
			new CLTLocNegation(rest.apply(s)));

	/**
	 * step up (second shortcut in table 3)
	 */
	public static final Function<Integer, CLTLocFormula> upSingularity = (s) -> new CLTLocConjunction(
			new CLTLocYesterday(new CLTLocNegation(rest.apply(s))),
			new CLTLocConjunction(first.apply(s), new CLTLocNegation(rest.apply(s))));

	/**
	 * step down (fourth shortcut in table 3)
	 */
	public static final Function<Integer, CLTLocFormula> downSingularity = (s) -> new CLTLocConjunction(
			new CLTLocYesterday(rest.apply(s)),
			new CLTLocConjunction(new CLTLocNegation(first.apply(s)), rest.apply(s)));

	public static final Function<Integer, CLTLocFormula> beforeDownNowUp = (s) -> new CLTLocDisjunction(high.apply(s),
			new CLTLocDisjunction(upSingularity.apply(s), new CLTLocConjunction(ORIGIN, first.apply(s))));

	public static final Function<Integer, CLTLocFormula> beforeUpNoNowUp = (s) -> new CLTLocDisjunction(low.apply(s),
			new CLTLocDisjunction(downSingularity.apply(s),
					new CLTLocConjunction(ORIGIN, new CLTLocNegation(first.apply(s)))));

	public static final Function<Integer, CLTLocFormula> fromNowOnUp = (s) -> new CLTLocConjunction(high.apply(s),
			downSingularity.apply(s));

	public static final Function<Integer, CLTLocFormula> fromNowOnDown = (s) -> new CLTLocConjunction(low.apply(s),
			upSingularity.apply(s));

	public static final Function<Integer, CLTLocFormula> up = (s) -> new CLTLocConjunction(first.apply(s),
			rest.apply(s));

	public static final Function<Integer, CLTLocFormula> down = (s) -> new CLTLocConjunction(
			new CLTLocNegation(first.apply(s)), new CLTLocNegation(rest.apply(s)));

	public final Function<MITLIFormula, CLTLocClock> newz0clock = formula -> new CLTLocClock(
			"Z0_" + formulaIdMap.get(formula));
	public final Function<MITLIFormula, CLTLocClock> newz1clock = formula -> new CLTLocClock(
			"Z1_" + formulaIdMap.get(formula));

	public MITLI2CLTLocVisitor(MITLIFormula formula, int maxIntComparedto) {

		Preconditions.checkNotNull(formula, "The formula to be considered cannot be null");

		LOGGER.info("Converting the formula " + formula.toString() + " to CLTLoc");
		Set<MITLIFormula> subformulae = formula.accept(new SubformulaeVisitor());
		List<MITLIFormula> listSubFormula = new ArrayList<>(subformulae);

		for (int i = 0; i < listSubFormula.size(); i++) {
			this.formulaIdMap.put(listSubFormula.get(i), i);
		}

		this.maxIntComparedto = maxIntComparedto;

	}

	public CLTLocFormula combineBinaryFormulaWithBinaryOperator(BinaryFormula<MITLIFormula> formula,
			MITLIFormula formulaTmp, BinaryOperator<CLTLocFormula> operator) {

		CLTLocFormula f1 = new CLTLocIff(first.apply(formulaIdMap.get(formula)),
				operator.apply(first.apply(formulaIdMap.get(formula.getLeftChild())),
						first.apply(formulaIdMap.get(formula.getLeftChild()))));

		CLTLocFormula f2 = new CLTLocIff(rest.apply(formulaIdMap.get(formula)),
				operator.apply(rest.apply(formulaIdMap.get(formula.getLeftChild())),
						rest.apply(formulaIdMap.get(formula.getLeftChild()))));
		return AND.apply(this.clocksEventsConstraints(formulaTmp), G.apply(AND.apply(f1, f2)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIConjunction formula) {
		return this.combineBinaryFormulaWithBinaryOperator(formula, formula, AND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIDisjunction formula) {
		return this.combineBinaryFormulaWithBinaryOperator(formula, formula, OR);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIIff formula) {
		return this.combineBinaryFormulaWithBinaryOperator(formula, formula, IFF);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIImplies formula) {
		return this.combineBinaryFormulaWithBinaryOperator(formula, formula, IMPL);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLINegation formula) {
		MITLIFormula subf = formula.getChild();

		CLTLocFormula f1 = IFF.apply(first.apply(formulaIdMap.get(formula)),
				NEG.apply(first.apply(formulaIdMap.get(subf))));

		CLTLocFormula f2 = IFF.apply(rest.apply(formulaIdMap.get(formula)),
				NEG.apply(rest.apply(formulaIdMap.get(subf))));
		return AND.apply(this.clocksEventsConstraints(formula), G.apply(AND.apply(f1, f2)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIUntil formula) {

		int formulaId = formulaIdMap.get(formula);
		int leftChildId = formulaIdMap.get(formula.getLeftChild());
		int rightChildId = formulaIdMap.get(formula.getRightChild());

		CLTLocFormula formulaRESTHIGH = rest.apply(formulaId);
		CLTLocFormula leftRESTHIGH = rest.apply(leftChildId);
		CLTLocFormula rightRESTHIGH = rest.apply(rightChildId);

		CLTLocFormula f1 = IFF.apply(first.apply(formulaId), formulaRESTHIGH);

		CLTLocFormula f2 = AND.apply(IFF.apply(formulaRESTHIGH, leftRESTHIGH),
				OR.apply(rightRESTHIGH, X.apply(U.apply(up.apply(leftChildId),
						OR.apply(AND.apply(up.apply(leftChildId), rightRESTHIGH), first.apply(rightChildId))))

				));

		return AND.apply(this.clocksEventsConstraints(formula), G.apply(AND.apply(f1, f2)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIFalse formula) {
		int formulaId = formulaIdMap.get(formula);
		return AND.apply(this.clocksEventsConstraints(formula),
				G.apply(AND.apply(NEG.apply(first.apply(formulaId)), NEG.apply(rest.apply(formulaId)))));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLITrue formula) {
		int formulaId = formulaIdMap.get(formula);

		return AND.apply(this.clocksEventsConstraints(formula),
				G.apply(AND.apply(first.apply(formulaId), rest.apply(formulaId))));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIPropositionalAtom formula) {
		return this.clocksEventsConstraints(formula);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIEventually_ZerotoB formula) {

		int formulaId = formulaIdMap.get(formula);
		int childId = formulaIdMap.get(formula.getChild());

		CLTLocClock z0 = newz0clock.apply(formula);
		CLTLocClock z1 = newz1clock.apply(formula);

		CLTLocClock z0child = newz0clock.apply(formula.getChild());
		CLTLocClock z1child = newz1clock.apply(formula.getChild());

		int b = formula.upperbound();
		// contains the formula with id7 of the paper
		CLTLocFormula f7 = IMPL.apply(first.apply(formulaId),
				AND.apply(rest.apply(formulaId), OR.apply(Y.apply(rest.apply(formulaId)), ORIGIN)));

		CLTLocFormula f8 = IFF.apply(high.apply(formulaId),
				OR.apply(AND.apply(ORIGIN,
						OR.apply(AND.apply(upSingularity.apply(formulaId), U.apply(OR.apply(ORIGIN, GE.apply(z0, ZERO)),
								AND.apply(OR.apply(AND.apply(beforeDownNowUp.apply(childId),

										AND.apply(GE.apply(z0, ZERO), LEQ.apply(z0, new CLTLocConstantAtom(b)))),
										rest.apply(childId)), ORIGIN))),
								AND.apply(NEG.apply(upSingularity.apply(formulaId)),
										X.apply(U.apply(GE.apply(z0, ZERO),
												AND.apply(beforeDownNowUp.apply(childId), AND.apply(GE.apply(z0, ZERO),
														OR.apply(GEQ.apply(z0child, new CLTLocConstantAtom(b)),
																GEQ.apply(z1child, new CLTLocConstantAtom(b)))))))))),
						AND.apply(NEG.apply(ORIGIN),
								AND.apply(NEG.apply(first.apply(formulaId)),
										OR.apply(AND.apply(EQ.apply(z0, ZERO), X.apply(U.apply(GE.apply(z0, ZERO),
												AND.apply(beforeDownNowUp.apply(childId),
														AND.apply(EQ.apply(z0, new CLTLocConstantAtom(b)),
																AND.apply(GE.apply(z0child, new CLTLocConstantAtom(b)),
																		GE.apply(z1child, new CLTLocConstantAtom(b)))

														))))), AND.apply(EQ.apply(z1, ZERO), X.apply(U.apply(GE.apply(z1, ZERO), AND.apply(beforeDownNowUp.apply(childId), AND.apply(EQ.apply(z1, new CLTLocConstantAtom(b)), AND.apply(GE.apply(z0child, new CLTLocConstantAtom(b)), GE.apply(z1child, new CLTLocConstantAtom(b)))

										))))))))

				));

		CLTLocFormula f9 = IMPL.apply(
				AND.apply(GE.apply(NOW, new CLTLocConstantAtom(b)),
						AND.apply(beforeDownNowUp.apply(childId),
								OR.apply(GEQ.apply(z0child, new CLTLocConstantAtom(b)),
										GEQ.apply(z1child, new CLTLocConstantAtom(b))))),
				OR.apply(EQ.apply(z0child, new CLTLocConstantAtom(b)), EQ.apply(z1child, new CLTLocConstantAtom(b))));

		CLTLocFormula f10 = IFF
				.apply(low.apply(formulaId),
						AND.apply(fromNowOnDown.apply(childId),
								U.apply(NEG.apply(beforeDownNowUp.apply(childId)),
										AND.apply(beforeDownNowUp.apply(
												childId), OR.apply(
														new CLTLocConjunction(new CLTLocGERelation(z0, ZERO),
																new CLTLocLEQRelation(z0,
																		new CLTLocConstantAtom(formula.upperbound()))),
														new CLTLocConjunction(new CLTLocGERelation(z1, ZERO),
																new CLTLocLEQRelation(z1, new CLTLocConstantAtom(
																		formula.upperbound()))))))));

		CLTLocFormula f11 = IFF
				.apply(downSingularity.apply(formulaId),
						AND.apply(NEG.apply(ORIGIN),
								AND.apply(fromNowOnDown.apply(childId),
										X.apply(U.apply(NEG.apply(beforeDownNowUp.apply(childId)), OR.apply(
												new CLTLocEQRelation(z0,
														new CLTLocConstantAtom(
																formula.upperbound())),
												new CLTLocEQRelation(z1, new CLTLocConstantAtom(formula.upperbound()))

										)))

								)));

		return AND.apply(this.clocksEventsConstraints(formula),
				G.apply(AND.apply(f7, AND.apply(f8, AND.apply(f9, AND.apply(f10, f11))))));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLISince formula) {
		// Some alias...

		int formulaId = formulaIdMap.get(formula);
		int leftChildId = formulaIdMap.get(formula.getLeftChild());
		int rightChildId = formulaIdMap.get(formula.getRightChild());

		CLTLocFormula f1 = IFF.apply(rest.apply(formulaId), Y.apply(rest.apply(formulaId)));

		CLTLocFormula f2 = IFF.apply(rest.apply(formulaId), AND.apply(rest.apply(leftChildId),
				S.apply(up.apply(leftChildId), OR.apply(first.apply(rightChildId), rest.apply(rightChildId)))));

		return AND.apply(this.clocksEventsConstraints(formula), G.apply(AND.apply(f1, f2)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIGlobally_AtoInf formula) {

		int formulaId = formulaIdMap.get(formula);
		int childId = formulaIdMap.get(formula.getChild());

		CLTLocConstantAtom a = new CLTLocConstantAtom(formula.lowerbound());

		CLTLocClock z0 = newz0clock.apply(formula);
		CLTLocClock z1 = newz1clock.apply(formula);

		CLTLocFormula f1 = IFF.apply(high.apply(formulaId),
				AND.apply(ORIGIN, U.apply(OR.apply(GE.apply(z0, ZERO), ORIGIN), AND.apply(high.apply(childId),
						OR.apply(LEQ.apply(z0, a), AND.apply(LEQ.apply(z0, a), X.apply(GE.apply(z0, a))))))));

		// Formula (16)
		CLTLocFormula f2 = IFF
				.apply(low.apply(formulaId),
						OR.apply(
								AND.apply(EQ.apply(z1, ZERO),
										X.apply(U.apply(GE.apply(z1, ZERO),
												AND.apply(low.apply(childId),
														AND.apply(EQ.apply(z1, a),
																G.apply(NEG.apply(high.apply(formulaId)))))))),
								AND.apply(ORIGIN, NEG.apply(high.apply(formulaId)))));

		CLTLocFormula f3;
		f3 = IMPL.apply(AND.apply(low.apply(childId), G.apply(NEG.apply(high.apply(childId)))), EQ.apply(z1, a));

		return AND.apply(this.clocksEventsConstraints(formula), G.apply(AND.apply(f1, AND.apply(f2, f3))));

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIRelease mitliRelease) {
		// Some alias...
		int idFormula = formulaIdMap.get(mitliRelease);
		int subf1 = formulaIdMap.get(mitliRelease.getLeftChild());
		int subf2 = formulaIdMap.get(mitliRelease.getRightChild());

		CLTLocFormula f1 = IFF.apply(rest.apply(idFormula), R.apply(rest.apply(subf1), rest.apply(subf2)));

		return AND.apply(this.clocksEventsConstraints(mitliRelease), G.apply(f1));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIGlobally_ZerotoB formula) {

		int idFormula = formulaIdMap.get(formula);
		int subf = formulaIdMap.get(formula.getChild());

		CLTLocConstantAtom upperbound = new CLTLocConstantAtom(formula.upperbound());

		CLTLocClock z0 = newz0clock.apply(formula);
		CLTLocClock z1 = newz1clock.apply(formula);

		CLTLocClock subfz0 = newz0clock.apply(formula.getChild());
		CLTLocClock subfz1 = newz1clock.apply(formula.getChild());

		CLTLocFormula f1 = IFF
				.apply(low
						.apply(idFormula), AND
								.apply(NEG.apply(ORIGIN),
										AND.apply(
												AND.apply(
														rest.apply(subf),
														OR.apply(
																AND.apply(EQ.apply(z0, ZERO), X.apply(U.apply(GE
																		.apply(z0, ZERO),
																		AND.apply(low.apply(subf), AND.apply(
																				EQ.apply(z0, upperbound), OR.apply(
																						GE.apply(subfz0, upperbound),
																						GE.apply(subfz1,
																								upperbound))))))),
																AND.apply(
																		EQ.apply(z1, ZERO), X.apply(
																				U.apply(GE.apply(z1, ZERO), AND.apply(
																						low.apply(idFormula), AND.apply(
																								EQ.apply(z1,
																										upperbound),
																								OR.apply(
																										EQ.apply(z1,
																												upperbound),
																										OR.apply(
																												GE.apply(
																														subfz0,
																														upperbound),
																												GE.apply(
																														subfz1,
																														upperbound)))))))))),
												AND.apply(ORIGIN,
														U.apply(OR.apply(ORIGIN, GE.apply(z0, ZERO)),
																AND.apply(NEG.apply(low.apply(subf)),
																		LEQ.apply(z0, upperbound)))))));

		CLTLocFormula f2 = IMPL.apply(
				AND.apply(low.apply(subf), OR.apply(GE.apply(subfz0, upperbound), GE.apply(subfz1, upperbound))),
				OR.apply(EQ.apply(z0, upperbound), EQ.apply(z1, upperbound)));

		CLTLocFormula f3 = IFF.apply(high.apply(idFormula),
				AND.apply(high.apply(subf), R.apply(low.apply(subf), NEG.apply(AND.apply(low.apply(subf),
						AND.apply(LEQ.apply(subfz0, upperbound), LEQ.apply(subfz1, upperbound)))))));

		return AND.apply(this.clocksEventsConstraints(formula), G.apply(AND.apply(f1, AND.apply(f2, f3))));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIGlobally_AtoB mitliGlobally_AtoB) {

		int idFormula = formulaIdMap.get(mitliGlobally_AtoB);
		int childId = formulaIdMap.get(mitliGlobally_AtoB.getChild());
		CLTLocConstantAtom b = new CLTLocConstantAtom(mitliGlobally_AtoB.upperbound());
		CLTLocConstantAtom a = new CLTLocConstantAtom(mitliGlobally_AtoB.lowerbound());
		CLTLocConstantAtom l = new CLTLocConstantAtom(
				mitliGlobally_AtoB.upperbound() - mitliGlobally_AtoB.lowerbound());

		int d = 2 * (int) Math.ceil((float) mitliGlobally_AtoB.upperbound()
				/ (mitliGlobally_AtoB.upperbound() - mitliGlobally_AtoB.lowerbound()));

		CLTLocClock subfz0 = new CLTLocClock("z0_" + formulaIdMap.get(mitliGlobally_AtoB.getChild()));
		CLTLocClock subfz1 = new CLTLocClock("z1_" + formulaIdMap.get(mitliGlobally_AtoB.getChild()));

		CLTLocClock z0 = new CLTLocClock("z0_" + formulaIdMap.get(mitliGlobally_AtoB));

		CLTLocFormula[] _f1 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			_f1[i] = AND
					.apply(EQ
							.apply(new CLTLocClock("x" + i + "_" + idFormula),
									ZERO),
							X.apply(U
									.apply(GE
											.apply(new CLTLocClock(
													"x" + i + "_"
															+ idFormula),
													ZERO),
											AND.apply(low.apply(childId),
													AND.apply(EQ.apply(new CLTLocClock("x" + i + "_" + idFormula), b),
															OR.apply(GE.apply(subfz0, l), GE.apply(subfz1, l)))))));
		}

		// Formula (8)

		CLTLocFormula f1OR = _f1[0];
		for (int i = 1; i < _f1.length; i++) {
			f1OR = OR.apply(f1OR, _f1[i]);
		}

		CLTLocFormula f1;
		f1 = IFF.apply(low.apply(idFormula),
				OR.apply(AND.apply(NEG.apply(ORIGIN), f1OR),
						AND.apply(ORIGIN,
								U.apply(OR.apply(GE.apply(z0, ZERO), ORIGIN),
										AND.apply(NEG.apply(rest.apply(idFormula)),
												OR.apply(AND.apply(GEQ.apply(z0, a), LEQ.apply(z0, b)),
														AND.apply(LE.apply(z0, a), X.apply(GE.apply(z0, a)))))

								))));

		CLTLocFormula[] _f3 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			_f3[i] = EQ.apply(new CLTLocClock("x" + i + "_" + idFormula), b);
		}

		// Formula (9)
		CLTLocFormula f3 = IMPL.apply(
				AND.apply(low.apply(childId), new CLTLocDisjunction(GE.apply(subfz0, l), GE.apply(subfz1, l))),
				new CLTLocDisjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length)));

		CLTLocFormula[] _f4 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLocClock xi = new CLTLocClock("x" + i + "_" + idFormula);

			_f4[i] = AND.apply(EQ.apply(xi, ZERO),
					X.apply(U.apply(GEQ.apply(xi, ZERO), AND.apply(high.apply(childId), AND.apply(EQ.apply(xi, ZERO),
							R.apply(low.apply(childId), NEG.apply(AND.apply(low.apply(childId), LEQ.apply(xi, b)))

							))))));
		}

		CLTLocFormula f4;
		f4 = IFF.apply(high.apply(idFormula),
				OR.apply(
						AND.apply(NEG.apply(ORIGIN),
								new CLTLocDisjunction(_f4[0], Arrays.copyOfRange(_f4, 1, _f4.length))),
						AND.apply(ORIGIN, NEG.apply(low.apply(idFormula)))));

		CLTLocFormula[] _f5 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLocClock xi = new CLTLocClock("x" + i + "_" + idFormula);

			_f5[i] = EQ.apply(xi, a);
		}

		CLTLocFormula f5 = new CLTLocImplies(AND.apply(high.apply(childId), R.apply(low.apply(childId),
				NEG.apply(AND.apply(low.apply(childId), AND.apply(LEQ.apply(subfz0, l), LEQ.apply(subfz1, l))))

		)), new CLTLocDisjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length)));

		return AND.apply(this.clocksEventsConstraints(mitliGlobally_AtoB), AND.apply(
				this.auxiliaryClocksConstraints(mitliGlobally_AtoB), G.apply(new CLTLocConjunction(f1, f3, f4, f5))));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIEventually_AtoB formula) {

		int idFormula = formulaIdMap.get(formula);
		int childId = formulaIdMap.get(formula.getChild());
		CLTLocConstantAtom b = new CLTLocConstantAtom(formula.upperbound());
		CLTLocConstantAtom a = new CLTLocConstantAtom(formula.lowerbound());
		CLTLocConstantAtom l = new CLTLocConstantAtom(formula.upperbound() - formula.lowerbound());

		CLTLocClock subfz0 = newz0clock.apply(formula.getChild());
		CLTLocClock subfz1 = newz1clock.apply(formula.getChild());

		int d = (int) Math.ceil((float) formula.upperbound() / (formula.upperbound() - formula.lowerbound()));

		CLTLocFormula[] _f1 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLocClock xi = new CLTLocClock("x" + i + "_" + idFormula);
			_f1[i] = AND.apply(EQ.apply(xi, ZERO), X.apply(U.apply(GE.apply(xi, ZERO), AND.apply(high.apply(childId),
					AND.apply(EQ.apply(xi, b), OR.apply(GE.apply(subfz0, l), GE.apply(subfz1, l)))))));
		}

		CLTLocClock x0 = new CLTLocClock("x" + 0 + "_" + idFormula);
		// Formula (8)
		CLTLocFormula f1;
		f1 = IFF.apply(high.apply(idFormula), OR.apply(
				AND.apply(NEG.apply(ORIGIN), new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length))),
				AND.apply(ORIGIN,
						U.apply(OR.apply(GE.apply(x0, ZERO), ORIGIN),
								AND.apply(rest.apply(childId), OR.apply(AND.apply(GEQ.apply(x0, a), LEQ.apply(x0, b)),
										AND.apply(LE.apply(x0, a), X.apply(GE.apply(x0, a)))))))));

		CLTLocFormula[] _f3 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLocClock xi = new CLTLocClock("x" + i + "_" + idFormula);
			_f3[i] = EQ.apply(xi, b);
		}

		// Formula (9)
		CLTLocFormula f3 = new CLTLocImplies(
				AND.apply(high.apply(childId), OR.apply(GE.apply(subfz0, l), GE.apply(subfz1, l))),
				new CLTLocDisjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length)));

		CLTLocFormula[] _f4 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLocClock xi = new CLTLocClock("x" + i + "_" + idFormula);
			_f4[i] = AND.apply(EQ.apply(xi, ZERO),
					X.apply(U.apply(GE.apply(xi, ZERO),
							AND.apply(low.apply(childId), AND.apply(EQ.apply(xi, a), R.apply(high.apply(childId),
									NEG.apply(AND.apply(high.apply(childId), new CLTLocLEQRelation(xi, b)))

							))))));
		}

		CLTLocFormula f4;
		f4 = IFF.apply(low.apply(idFormula),
				OR.apply(
						AND.apply(NEG.apply(ORIGIN),
								new CLTLocDisjunction(_f4[0], Arrays.copyOfRange(_f4, 1, _f4.length))),
						AND.apply(ORIGIN, NEG.apply(high.apply(idFormula)))));

		CLTLocFormula[] _f5 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			CLTLocClock xi = new CLTLocClock("x" + i + "_" + idFormula);

			_f5[i] = new CLTLocEQRelation(xi, a);
		}

		CLTLocFormula f5 = IMPL.apply(AND.apply(low.apply(childId), new CLTLocRelease(high.apply(childId),
				NEG.apply(AND.apply(high.apply(childId), AND.apply(LEQ.apply(subfz0, l), LEQ.apply(subfz1, l))))

		)), new CLTLocDisjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length)));

		return AND.apply(this.clocksEventsConstraints(formula),
				AND.apply(this.auxiliaryClocksConstraints(formula), G.apply(new CLTLocConjunction(f1, f3, f4, f5))));

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIEventually_AtoInf formula) {

		int idFormula = formulaIdMap.get(formula);
		int childId = formulaIdMap.get(formula.getChild());
		CLTLocConstantAtom a = new CLTLocConstantAtom(formula.lowerbound());

		CLTLocClock z0 = newz0clock.apply(formula);
		CLTLocClock z1 = newz1clock.apply(formula);

		// Formula (15)
		CLTLocFormula f1;
		f1 = IFF.apply(high.apply(idFormula),
				AND.apply(ORIGIN, U.apply(OR.apply(GE.apply(z0, ZERO), ORIGIN), AND.apply(rest.apply(childId),
						OR.apply(LEQ.apply(z0, a), AND.apply(LEQ.apply(z0, a), X.apply(GE.apply(z0, a))))))));

		// Formula (16)

		CLTLocFormula f2;
		f2 = IFF.apply(low.apply(idFormula),
				OR.apply(
						AND.apply(EQ.apply(z1, ZERO),
								X.apply(U.apply(GE.apply(z1, ZERO),
										AND.apply(low.apply(childId),
												AND.apply(EQ.apply(z1, a), G.apply(NEG.apply(high.apply(childId)))))))),
						AND.apply(ORIGIN, NEG.apply(high.apply(idFormula)))));

		CLTLocFormula f3;
		f3 = IMPL.apply(AND.apply(low.apply(childId), G.apply(NEG.apply(high.apply(childId)))), EQ.apply(z1, a));

		return AND.apply(this.clocksEventsConstraints(formula), G.apply(AND.apply(f1, AND.apply(f2, f3))));

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIPast_ZerotoB formula) {
		int idFormula = formulaIdMap.get(formula);
		int childId = formulaIdMap.get(formula.getChild());
		CLTLocConstantAtom b = new CLTLocConstantAtom(formula.upperbound());

		CLTLocClock subfz0 = newz0clock.apply(formula.getChild());
		CLTLocClock subfz1 = newz1clock.apply(formula.getChild());

		CLTLocFormula f1;
		f1 = IFF.apply(
				high.apply(
						idFormula),
				AND.apply(high.apply(childId),
						OR.apply(ORIGIN,
								OR.apply(
										Y.apply(S.apply(NEG.apply(high.apply(childId)),
												AND.apply(ORIGIN, NEG.apply(rest.apply(childId))))),
										OR.apply(GE.apply(subfz0, b), GE.apply(subfz1, b))))));

		CLTLocFormula f2;
		f2 = IFF.apply(low.apply(idFormula),
				new CLTLocDisjunction(AND.apply(ORIGIN, NEG.apply(rest.apply(childId))),
						AND.apply(EQ.apply(subfz0, b),
								new CLTLocSince(NEG.apply(high.apply(childId)),
										AND.apply(low.apply(childId), EQ.apply(subfz0, ZERO)))),
						AND.apply(EQ.apply(subfz1, b), new CLTLocSince(NEG.apply(high.apply(childId)),
								AND.apply(low.apply(childId), EQ.apply(subfz1, ZERO))))));

		CLTLocFormula f5;
		f5 = AND.apply(
				IMPL.apply(AND.apply(low.apply(childId), EQ.apply(subfz0, ZERO)),
						U.apply(LE.apply(subfz0, b),
								new CLTLocDisjunction(new CLTLocConjunction(high.apply(childId),
										new CLTLocGERelation(subfz0, ZERO), new CLTLocLERelation(subfz0, b)),
										new CLTLocEQRelation(subfz0, b)))),
				IMPL.apply(AND.apply(low.apply(childId), EQ.apply(subfz1, ZERO)),
						new CLTLocUntil(new CLTLocLERelation(subfz1, b),
								new CLTLocDisjunction(new CLTLocConjunction(high.apply(childId),
										new CLTLocGERelation(subfz1, ZERO), LE.apply(subfz1, b)),
										new CLTLocEQRelation(subfz0, b)))));

		return AND.apply(this.clocksEventsConstraints(formula), G.apply(new CLTLocConjunction(f1, f2, f5)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula visit(MITLIPast_AtoB formula) {
		return AND.apply(this.clocksEventsConstraints(formula), this.auxiliaryClocksConstraints(formula));

	}

	private CLTLocFormula auxiliaryClocksConstraints(MITLIGlobally_AtoB formula) {

		int idFormula = formulaIdMap.get(formula);
		int childId = formulaIdMap.get(formula.getChild());
		CLTLocConstantAtom b = new CLTLocConstantAtom(formula.upperbound());
		CLTLocConstantAtom a = new CLTLocConstantAtom(formula.lowerbound());
		CLTLocConstantAtom l = new CLTLocConstantAtom(formula.upperbound() - formula.lowerbound());

		int upperbound = formula.upperbound();
		int lowerbound = formula.lowerbound();
		int d = 2 * (int) Math.ceil((float) upperbound / (upperbound - lowerbound));
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
			CLTLocClock xi = new CLTLocClock("x" + i + "_" + idFormula);

			_f1[i] = EQ.apply(xi, ZERO);
			_f5[i] = GEQ.apply(xi, ZERO);
			for (int j = i + 1; j < d; j++) {
				CLTLocClock xj = new CLTLocClock("x" + j + "_" + idFormula);

				_f2[p++] = NEG.apply(AND.apply(EQ.apply(xi, ZERO), EQ.apply(xj, ZERO)));
			}

			CLTLocClock xiplusdminus1 = new CLTLocClock("x" + ((i + d - 1) % d) + "_" + idFormula);
			CLTLocClock xiplusdplus1 = new CLTLocClock("x" + (i + d + 1) + "_" + idFormula);
			CLTLocClock xiplus1modd = new CLTLocClock("x" + ((i + 1) % d) + "_" + idFormula);

			_f3[i] = IMPL.apply(EQ.apply(xi, ZERO),
					X.apply(R.apply(EQ.apply(xiplusdminus1, ZERO), EQ.apply(xi, ZERO))));

			for (int j = 0; j < d; j++) {
				if (j != (i + 1) % d) {
					CLTLocClock xj = new CLTLocClock("x" + j + "_" + idFormula);

					__f7[i][j] = GE.apply(xj, ZERO);
				}
			}
			_f7[i] = IMPL.apply(EQ.apply(xi, ZERO), X.apply(R.apply(EQ.apply(xiplus1modd, ZERO),
					new CLTLocConjunction(__f7[i][0], Arrays.copyOfRange(__f7[i], 1, __f7[i].length)))));

			_f6[i] = AND.apply(G.apply(OR.apply(X.apply(EQ.apply(xi, ZERO)), X.apply(GE.apply(xi, ZERO)))),
					OR.apply(G.apply(F.apply(EQ.apply(xi, ZERO))), F.apply(G.apply(GE.apply(xi, b)))));

			if (i < d - 1)
				_f8[i] = new CLTLocLEQRelation(xiplusdminus1, xiplusdplus1);

		}

		// Formula (4)
		CLTLocFormula f1 = IFF.apply(OR.apply(high.apply(idFormula), low.apply(idFormula)),
				new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length)));

		// Formuala (5)
		CLTLocFormula f2 = new CLTLocConjunction(_f2[0], Arrays.copyOfRange(_f2, 1, _f2.length));

		// Formula (6)
		CLTLocFormula f3 = new CLTLocConjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length)); // TODO:
																									// why
																									// not
																									// used?

		// String f4 = new CLTLocEQRelation( x(0,t), orig);
		CLTLocFormula f4 = new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length));

		// Positiveness of all clocks in the origin
		CLTLocFormula f5 = new CLTLocConjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length)); //
		// TODO: why not used?

		CLTLocFormula f6 = new CLTLocConjunction(_f6[0], Arrays.copyOfRange(_f6, 1, _f6.length)); // TODO:
																									// why
																									// not
																									// used?

		// strict sequence among clocks
		CLTLocFormula f7 = new CLTLocConjunction(_f7[0], Arrays.copyOfRange(_f7, 1, _f7.length));

		// order of clocks at the origin
		CLTLocFormula f8 = new CLTLocConjunction(_f8[0], Arrays.copyOfRange(_f8, 1, _f8.length));

		return new CLTLocConjunction(f4, f6, f8, G.apply(new CLTLocConjunction(f1, f2, f7)));

	}

	private CLTLocFormula auxiliaryClocksConstraints(MITLIEventually_AtoB formula) {

		int idFormula = formulaIdMap.get(formula);
		CLTLocConstantAtom b = new CLTLocConstantAtom(formula.upperbound());
		CLTLocConstantAtom a = new CLTLocConstantAtom(formula.lowerbound());
		CLTLocConstantAtom l = new CLTLocConstantAtom(formula.upperbound() - formula.lowerbound());

		int d = 2 * (int) Math.ceil((float) formula.upperbound() / (formula.upperbound() - formula.lowerbound()));
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
			CLTLocClock xi = new CLTLocClock("x" + i + "_" + idFormula);
			_f1[i] = EQ.apply(xi, ZERO);
			_f5[i] = GE.apply(xi, ZERO);

			for (int j = i + 1; j < d; j++) {
				CLTLocClock xj = new CLTLocClock("x" + j + "_" + idFormula);
				_f2[p++] = NEG.apply(AND.apply(EQ.apply(xi, ZERO), EQ.apply(xj, ZERO)));
			}
			CLTLocClock xiplusdminus1modd = new CLTLocClock("x" + ((i + d - 1) % d) + "_" + idFormula);

			_f3[i] = IMPL.apply(EQ.apply(xi, ZERO),
					X.apply(R.apply(EQ.apply(xiplusdminus1modd, ZERO), GE.apply(xi, ZERO))));

			for (int j = 0; j < d; j++) {
				if (j != (i + 1) % d) {
					CLTLocClock xj = new CLTLocClock("x" + j + "_" + idFormula);
					__f7[i][j] = GE.apply(xj, ZERO);
				}
			}

			CLTLocClock xiplus1modd = new CLTLocClock("x" + ((i + 1) % d) + "_" + idFormula);

			_f7[i] = IMPL.apply(EQ.apply(xi, ZERO), X.apply(R.apply(EQ.apply(xiplus1modd, ZERO),
					new CLTLocConjunction(__f7[i][0], Arrays.copyOfRange(__f7[i], 1, __f7[i].length)))));

			_f6[i] = AND.apply(G.apply(OR.apply(X.apply(EQ.apply(xi, ZERO)), X.apply(GE.apply(xi, ZERO)))),
					OR.apply(G.apply(F.apply(EQ.apply(xi, ZERO))), F.apply(G.apply(GE.apply(xi, b)))));

			if (i < d - 1) {
				CLTLocClock xdminusimodd = new CLTLocClock("x" + ((d - i) % d) + "_" + idFormula);
				CLTLocClock xdminusiplusone = new CLTLocClock("x" + (d - (i + 1)) + "_" + idFormula);

				// TODO you cannot do this
				// _f8[i] = LE.apply(xdminusimodd, xdminusiplusone);
			}

		}

		CLTLocClock x0 = new CLTLocClock("x" + 0 + "_" + idFormula);

		// Formula (4)
		CLTLocFormula f1 = IFF.apply(OR.apply(high.apply(idFormula), low.apply(idFormula)),
				new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length)));

		// Formuala (5)
		CLTLocFormula f2 = new CLTLocConjunction(_f2[0], Arrays.copyOfRange(_f2, 1, _f2.length));

		// Formula (6)
		CLTLocFormula f3 = new CLTLocConjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length));

		CLTLocFormula f4 = new CLTLocEQRelation(x0, ZERO);

		// Positiveness of all clocks in the origin
		CLTLocFormula f5 = new CLTLocConjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length));

		CLTLocFormula f6 = new CLTLocConjunction(_f6[0], Arrays.copyOfRange(_f6, 1, _f6.length));

		// strict sequence among clocks
		CLTLocFormula f7 = new CLTLocConjunction(_f7[0], Arrays.copyOfRange(_f7, 1, _f7.length));

		// order of clocks at the origin
		CLTLocFormula f8 = new CLTLocConjunction(_f8[0], Arrays.copyOfRange(_f8, 1, _f8.length));

		return new CLTLocConjunction(f4, f6, f8, G.apply(new CLTLocConjunction(f1, f2, f7)));
	}

	private CLTLocFormula auxiliaryClocksConstraints(MITLIPast_AtoB formula) {

		int d = 2 * (int) Math.ceil((float) formula.upperbound() / (formula.upperbound() - formula.lowerbound()));
		int p = 0;

		int idFormula = formulaIdMap.get(formula);
		int childId = formulaIdMap.get(formula.getChild());
		CLTLocConstantAtom b = new CLTLocConstantAtom(formula.upperbound());
		CLTLocConstantAtom a = new CLTLocConstantAtom(formula.lowerbound());
		CLTLocConstantAtom l = new CLTLocConstantAtom(formula.upperbound() - formula.lowerbound());

		CLTLocClock x0 = new CLTLocClock("x" + 0 + "_" + idFormula);

		CLTLocFormula[] _f1 = new CLTLocFormula[d];
		CLTLocFormula[] _f2 = new CLTLocFormula[((d * d) - d) / 2];
		CLTLocFormula[] _f3 = new CLTLocFormula[d];
		CLTLocFormula[] _f5 = new CLTLocFormula[d];
		CLTLocFormula[] _f6 = new CLTLocFormula[d];
		CLTLocFormula[] _f7 = new CLTLocFormula[d];
		CLTLocFormula[][] __f7 = new CLTLocFormula[d][d];
		CLTLocFormula[] _f8 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {

			CLTLocClock xi = new CLTLocClock("x" + i + "_" + idFormula);
			_f1[i] = EQ.apply(xi, ZERO);
			_f5[i] = GEQ.apply(xi, ZERO);
			for (int j = i + 1; j < d; j++) {
				CLTLocClock xj = new CLTLocClock("x" + j + "_" + idFormula);
				_f2[p++] = NEG.apply(AND.apply(EQ.apply(xi, ZERO), EQ.apply(xj, ZERO)));
			}

			CLTLocClock xiplusdminusonemodd = new CLTLocClock("x" + ((i + d - 1) % d) + "_" + idFormula);
			_f3[i] = IMPL.apply(EQ.apply(xi, ZERO),
					X.apply(R.apply(EQ.apply(xiplusdminusonemodd, ZERO), GE.apply(xi, ZERO))));

			for (int j = 0; j < d; j++) {
				if (j != (i + 1) % d) {
					CLTLocClock xj = new CLTLocClock("x" + j + "_" + idFormula);
					__f7[i][j] = GE.apply(xj, ZERO);
				}
			}

			CLTLocClock xiplusonemodd = new CLTLocClock("x" + ((i + 1) % d) + "_" + idFormula);
			_f7[i] = IMPL.apply(EQ.apply(xi, ZERO), X.apply(R.apply(EQ.apply(xiplusonemodd, ZERO),
					new CLTLocConjunction(__f7[i][0], Arrays.copyOfRange(__f7[i], 1, __f7[i].length)))));

			_f6[i] = AND.apply(G.apply(OR.apply(X.apply(EQ.apply(xi, ZERO)), X.apply(GE.apply(xi, ZERO)))),
					OR.apply(G.apply(F.apply(EQ.apply(xi, ZERO))), F.apply(G.apply(GE.apply(xi, b)))));

			if (i < d - 1) {
				CLTLocClock xdminusimodd = new CLTLocClock("x" + ((d - i) % d) + "_" + idFormula);
				CLTLocClock xdminusiplusone = new CLTLocClock("x" + (d - (i + 1)) + "_" + idFormula);
				// TODO cannot do this
				_f8[i] = // LE.apply(xdminusimodd, xdminusiplusone);
						LE.apply(xdminusimodd, ZERO);
			}

		}

		// Formula (4)
		CLTLocFormula f1 = new CLTLocIff(new CLTLocDisjunction(high.apply(idFormula), low.apply(idFormula)),
				new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length)));

		// Formuala (5)
		CLTLocFormula f2 = new CLTLocConjunction(_f2[0], Arrays.copyOfRange(_f2, 1, _f2.length));

		// TODO: not user
		// Formula (6)
		CLTLocFormula f3 = new CLTLocConjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length));

		CLTLocFormula f4 = new CLTLocEQRelation(x0, ZERO);

		// TODO: not user
		// Positiveness of all clocks in the origin
		CLTLocFormula f5 = new CLTLocConjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length));

		CLTLocFormula f6 = new CLTLocConjunction(_f6[0], Arrays.copyOfRange(_f6, 1, _f6.length));

		// strict sequence among clocks
		CLTLocFormula f7 = new CLTLocConjunction(_f7[0], Arrays.copyOfRange(_f7, 1, _f7.length));

		// order of clocks at the origin
		CLTLocFormula f8 = new CLTLocConjunction(_f8[0], Arrays.copyOfRange(_f8, 1, _f8.length));

		return new CLTLocDisjunction(f4, f6, f8, G.apply(new CLTLocDisjunction(f1, f2, f7)));

	}

	public CLTLocFormula getckTheta(MITLIFormula formula) {
		CLTLocFormula result = CLTLocFormula.TRUE;

		int idFormula = formulaIdMap.get(formula);

		CLTLocClock z0 = newz0clock.apply(formula);
		CLTLocClock z1 = newz1clock.apply(formula);

		CLTLocFormula f1 = EQ.apply(z0, ZERO);

		result = f1;
		// Formula (2)

		CLTLocFormula f2 = IFF.apply(OR.apply(beforeDownNowUp.apply(idFormula), beforeUpNoNowUp.apply(idFormula)),
				OR.apply(EQ.apply(z0, ZERO), EQ.apply(z1, ZERO)));

		// formula (3)
		CLTLocFormula f3a = IMPL.apply(EQ.apply(z0, ZERO), X.apply(R.apply(EQ.apply(z1, ZERO), GE.apply(z0, ZERO))));

		CLTLocFormula f3b = IMPL.apply(EQ.apply(z1, ZERO), X.apply(R.apply(EQ.apply(z0, ZERO), GE.apply(z1, ZERO))));

		CLTLocFormula f3 = AND.apply(f3a, f3b);
		result = AND.apply(result, G.apply(AND.apply(f2, f3)));

		return result;
	}

	private CLTLocFormula clocksEventsConstraints(MITLIFormula formula) {

		CLTLocFormula result;

		int idFormula = formulaIdMap.get(formula);

		CLTLocClock z0 = newz0clock.apply(formula);
		CLTLocClock z1 = newz1clock.apply(formula);

		if (maxIntComparedto > 0) {

			CLTLocFormula f1 = EQ.apply(z0, ZERO);

			// Formula (2)
			CLTLocFormula f2 = IFF.apply(OR.apply(high.apply(idFormula), low.apply(idFormula)),
					OR.apply(EQ.apply(z0, ZERO), EQ.apply(z1, ZERO)));

			// formula (3)
			CLTLocFormula f3a = IMPL.apply(EQ.apply(z0, ZERO),
					X.apply(R.apply(EQ.apply(z1, ZERO), GE.apply(z0, ZERO))));

			CLTLocFormula f3b = IMPL.apply(EQ.apply(z1, ZERO),
					X.apply(R.apply(EQ.apply(z0, ZERO), GE.apply(z1, ZERO))));

			// Clocks progression
			CLTLocFormula f4a = AND.apply(G.apply(OR.apply(X.apply(EQ.apply(z0, ZERO)), X.apply(GE.apply(z0, ZERO)))),
					OR.apply(G.apply(F.apply(EQ.apply(z0, ZERO))),
							F.apply(G.apply(GE.apply(z0, new CLTLocConstantAtom(maxIntComparedto))))));

			CLTLocFormula f4b = AND.apply(G.apply(OR.apply(X.apply(EQ.apply(z1, ZERO)), X.apply(GE.apply(z1, ZERO)))),
					OR.apply(G.apply(F.apply(EQ.apply(z1, ZERO))),
							F.apply(G.apply(GE.apply(z1, new CLTLocConstantAtom(maxIntComparedto))))));

			// Clocks non negativeness in the origin
			CLTLocFormula f5 = AND.apply(GEQ.apply(z0, ZERO), GEQ.apply(z1, ZERO));

			result = new CLTLocConjunction(f1, G.apply(new CLTLocConjunction(f2, f3a, f3b)), f4a, f4b, f5);

			return result;
		} else {
			return null;
		}

	}

	@Override
	public CLTLocFormula visit(MITLIRelationalAtom formula) {

		CLTLocFormula f;
		switch (formula.getOperator()) {
		case "=":
			f = new CLTLocEQRelation(new CLTLocSignal(formula.getIdentifier()),
					new CLTLocConstantAtom(formula.getValue()));
			break;

		case "<":
			f = new CLTLocLERelation(new CLTLocSignal(formula.getIdentifier()),
					new CLTLocConstantAtom(formula.getValue()));
			break;
		case "<=":
			f = new CLTLocLEQRelation(new CLTLocSignal(formula.getIdentifier()),
					new CLTLocConstantAtom(formula.getValue()));
			break;

		case ">":
			f = new CLTLocGERelation(new CLTLocSignal(formula.getIdentifier()),
					new CLTLocConstantAtom(formula.getValue()));
			break;
		case ">=":
			f = new CLTLocGEQRelation(new CLTLocSignal(formula.getIdentifier()),
					new CLTLocConstantAtom(formula.getValue()));
			break;
		default:
			f = CLTLocFormula.TRUE;
		}

		return IFF.apply(first.apply(this.formulaIdMap.get(formula)), f);
	}

}
