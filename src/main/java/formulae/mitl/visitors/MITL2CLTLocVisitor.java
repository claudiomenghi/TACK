package formulae.mitl.visitors;

import java.util.Arrays;

import formulae.Formula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLHighAtom;
import formulae.cltloc.atoms.CLTLLowAtom;
import formulae.cltloc.atoms.CLTLValueAtom;
import formulae.cltloc.atoms.CLTLVariable;
import formulae.cltloc.atoms.CLTLocAtom;
import formulae.cltloc.atoms.CLTLzHAtom;
import formulae.cltloc.atoms.CLTLzLAtom;
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
import formulae.cltloc.relations.CLTLocEQRelation;
import formulae.cltloc.relations.CLTLocGEQRelation;
import formulae.cltloc.relations.CLTLocGERelation;
import formulae.cltloc.relations.CLTLocLEQRelation;
import formulae.cltloc.relations.CLTLocLERelation;
import formulae.mitl.MITLAtom;
import formulae.mitl.MITLConjunction;
import formulae.mitl.MITLEventually;
import formulae.mitl.MITLEventually_AtoB;
import formulae.mitl.MITLEventually_AtoInf;
import formulae.mitl.MITLEventually_ZerotoB;
import formulae.mitl.MITLFalse;
import formulae.mitl.MITLFormula;
import formulae.mitl.MITLNegation;
import formulae.mitl.MITLTrue;
import formulae.mitl.MITLUntil;

public class MITL2CLTLocVisitor implements MITLVisitor<CLTLocFormula> {

	public CLTLocFormula createXVariable(int i, int formulaId) {
		return new CLTLVariable("x" + i + "_" + formulaId);
	}

	public CLTLocFormula createYVariable(int i, int formulaId) {
		return new CLTLVariable("y" + i + "_" + formulaId);
	}

	public CLTLocFormula getDwBf(MITLFormula xi, MITLFormula upsilon) {

		CLTLocFormula orig = new CLTLocAtom("0");

		return new CLTLocConjunction(new CLTLLowAtom(xi.idFormula()),
				new CLTLocDisjunction(orig,
						new CLTLocDisjunction(new CLTLLowAtom(upsilon.idFormula()),
								new CLTLocConjunction(
										new CLTLocSince(new CLTLocNegation(new CLTLLowAtom(xi.idFormula())),
												new CLTLHighAtom(upsilon.idFormula())),
										new CLTLocNegation(new CLTLHighAtom(upsilon.idFormula()))))));
	}

	public CLTLocFormula getUpAf(MITLFormula xi, MITLFormula upsilon) {

		return new CLTLocConjunction(new CLTLHighAtom(xi.idFormula()),
				new CLTLocSince(new CLTLocNegation(new CLTLLowAtom(xi.idFormula())),
						new CLTLocNegation(new CLTLHighAtom(upsilon.idFormula()))));

	}

	public CLTLocFormula clockEventsConstraint(MITLFormula formula) {
		CLTLocFormula lowAtom = new CLTLLowAtom(formula.idFormula());
		CLTLocFormula highAtom = new CLTLHighAtom(formula.idFormula());

		// Formula (1) and initialization
		CLTLocFormula f1;
		if (formula.idFormula() != formula.isTheFormula) {
			f1 = highAtom;
		} else {
			f1 = new CLTLocDisjunction(highAtom, lowAtom);
		}

		CLTLValueAtom zero = new CLTLValueAtom(0);
		int formulaId = formula.idFormula();

		CLTLocFormula and0 = new CLTLocNegation(
				new CLTLocConjunction(new CLTLHighAtom(formulaId), new CLTLLowAtom(formulaId)));

		CLTLocFormula and1 = new CLTLocIff(new CLTLHighAtom(formulaId),
				new CLTLocEQRelation(new CLTLzHAtom(formulaId), zero));

		CLTLocFormula and2 = new CLTLocIff(new CLTLLowAtom(formulaId),
				new CLTLocEQRelation(new CLTLzLAtom(formulaId), zero));

		CLTLocFormula and3 = new CLTLocImplies(highAtom,
				new CLTLocNext(new CLTLocRelease(lowAtom, new CLTLocNegation(highAtom))));

		CLTLocFormula and4 = new CLTLocImplies(lowAtom,
				new CLTLocNext(new CLTLocRelease(highAtom, new CLTLocNegation(lowAtom))));

		CLTLocFormula f2 = new CLTLocGlobally(new CLTLocConjunction(and0,
				new CLTLocConjunction(and1, new CLTLocConjunction(and2, new CLTLocConjunction(and3, and4)))));

		return new CLTLocConjunction(f1, f2);
	}

	@Override
	public CLTLocFormula visit(MITLAtom formula) {
		return this.clockEventsConstraint(formula);

	}

	@Override
	public CLTLocFormula visit(MITLConjunction formula) {
		MITLFormula subf1 = formula.getLeftChild();
		MITLFormula subf2 = formula.getRightChild();

		CLTLocFormula f1 = new CLTLocIff(new CLTLHighAtom(subf1.idFormula()),
				new CLTLocDisjunction(this.getUpAf(subf1, subf2), this.getUpAf(subf2, subf1)));

		CLTLocFormula f2 = new CLTLocIff(new CLTLLowAtom(formula.idFormula()),
				new CLTLocDisjunction(this.getDwBf(subf1, subf2), this.getDwBf(subf2, subf1)));

		return new CLTLocConjunction(this.clockEventsConstraint(formula),
				new CLTLocGlobally(new CLTLocConjunction(f1, f2)));
	}

	@Override
	public CLTLocFormula visit(MITLEventually_AtoB formula) {

		int b = formula.upperbound();
		int a = formula.lowerbound();
		int l = b - a;

		MITLFormula subf = formula.getChild();

		CLTLocFormula orig = new CLTLocAtom("0");

		CLTLocFormula subflow = new CLTLLowAtom(subf.idFormula());
		CLTLocFormula subfhigh = new CLTLHighAtom(subf.idFormula());

		CLTLValueAtom c0 = new CLTLValueAtom(0);

		CLTLValueAtom aAtom = new CLTLValueAtom(a);
		CLTLValueAtom bAtom = new CLTLValueAtom(b);
		CLTLValueAtom lAtom = new CLTLValueAtom(l);
		CLTLzLAtom zlT = new CLTLzLAtom(formula.idFormula());
		CLTLzLAtom subfZl = new CLTLzLAtom(formula.getChild().idFormula());

		CLTLVariable x0Fid = new CLTLVariable("x" + 0 + "_" + formula.idFormula());
		CLTLVariable y0Fid = new CLTLVariable("y" + 0 + "_" + formula.idFormula());

		CLTLocFormula f1;
		f1 = new CLTLocIff(new CLTLocEQRelation(x0Fid, c0),
				new CLTLocDisjunction(new CLTLocConjunction(new CLTLocNegation(orig),
						new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(x0Fid, c0),
								new CLTLocConjunction(new CLTLHighAtom(subf.idFormula()),
										new CLTLocEQRelation(x0Fid, bAtom), new CLTLocGERelation(
												new CLTLzHAtom(formula.idFormula()), lAtom))))),

						new CLTLocConjunction(orig,
								new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(x0Fid, c0), new CLTLocDisjunction(
										new CLTLocConjunction(new CLTLocDisjunction(subfhigh, subflow),
												new CLTLocConjunction(new CLTLocGERelation(x0Fid, aAtom),
														new CLTLocLEQRelation(x0Fid, bAtom))),
										new CLTLocConjunction(new CLTLocSince(new CLTLocNegation(subflow), subfhigh),
												new CLTLocEQRelation(x0Fid, aAtom))))))

				));

		int d = (int) Math.floor(b / (b - a) + 1) + 1;
		CLTLocFormula[] _f2 = new CLTLocFormula[d - 1];

		for (int i = 1; i < d; i++) {
			_f2[i - 1] = new CLTLocIff(new CLTLocEQRelation(x0Fid, c0),
					new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(x0Fid, c0), new CLTLocConjunction(subfhigh,
							new CLTLocEQRelation(x0Fid, bAtom), new CLTLocGERelation(zlT, lAtom)))));
		}

		CLTLocFormula f2 = _f2.length > 1 ? new CLTLocConjunction(_f2[0], Arrays.copyOfRange(_f2, 1, _f2.length))
				: _f2[0];

		CLTLocFormula[] _f3 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			_f3[i] = new CLTLocEQRelation(new CLTLVariable("x" + i + "_" + formula.idFormula()), new CLTLValueAtom(b));
		}

		CLTLocFormula f3 = new CLTLocImplies(
				new CLTLocConjunction(new CLTLHighAtom(subf.idFormula()),
						new CLTLocGERelation(new CLTLzLAtom(subf.idFormula()), new CLTLValueAtom(l))),
				_f3.length > 1 ? new CLTLocDisjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length)) : _f3[0]);

		CLTLocFormula[] _f4 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			_f4[i] = new CLTLocIff(new CLTLocEQRelation(y0Fid, c0),
					new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(y0Fid, c0),
							new CLTLocConjunction(subflow, new CLTLocEQRelation(y0Fid, aAtom),
									new CLTLocNegation(new CLTLocUntil(new CLTLocNegation(subfhigh),
											new CLTLocConjunction(subfhigh, new CLTLocLEQRelation(subfZl, lAtom))))

							))));
		}

		CLTLocFormula f4 = _f4.length > 1 ? new CLTLocConjunction(_f4[0], Arrays.copyOfRange(_f4, 1, _f4.length))
				: _f4[0];

		CLTLocFormula[] _f5 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			_f5[i] = new CLTLocEQRelation(new CLTLVariable("y" + i + "_" + formula.idFormula()), new CLTLValueAtom(a));
		}

		CLTLocFormula orF5 = _f5.length > 1 ? new CLTLocDisjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length))
				: _f5[0];

		CLTLocFormula f5 = new CLTLocImplies(
				new CLTLocConjunction(subflow, new CLTLocNegation(new CLTLocUntil(new CLTLocNegation(subfhigh),
						new CLTLocConjunction(subfhigh, new CLTLocLEQRelation(subfZl, lAtom))))),
				orF5);

		CLTLocFormula globallyAndf1f2f3f4f5 = new CLTLocGlobally(new CLTLocConjunction(f1, f2, f3, f4, f5));
		return new CLTLocConjunction(this.clockEventsConstraint(formula),
				this.auxiliaryClocksConstraints(b, a, formula), globallyAndf1f2f3f4f5);

	}

	/**
	 * visits an MITLEventually_AtoInf and returns the corresponding
	 * CLTLocFormula
	 * 
	 * @param formula
	 *            the formula to be converted
	 * @return the corresponding CLTLocFormula
	 * @throws NullPointerException
	 *             if the formula to be converted is null
	 */
	@Override
	public CLTLocFormula visit(MITLEventually_AtoInf formula) {
		CLTLValueAtom orig = new CLTLValueAtom(0);

		CLTLValueAtom lowerBound = new CLTLValueAtom(formula.lowerbound());

		MITLFormula subf = formula.getChild();

		CLTLVariable zht = new CLTLzHAtom(formula.idFormula());
		CLTLVariable zlt = new CLTLzLAtom(formula.idFormula());

		CLTLLowAtom subflow = new CLTLLowAtom(subf.idFormula());
		CLTLHighAtom subfhigh = new CLTLHighAtom(subf.idFormula());

		CLTLHighAtom high = new CLTLHighAtom(formula.idFormula());
		CLTLLowAtom low = new CLTLLowAtom(formula.idFormula());

		CLTLocFormula f1;
		f1 = new CLTLocIff(high, new CLTLocConjunction(orig, new CLTLocDisjunction(
				new CLTLocConjunction(subfhigh, new CLTLocGlobally(new CLTLocNegation(subflow))),
				new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(zht, orig),
						new CLTLocDisjunction(new CLTLocConjunction(subfhigh, new CLTLocGEQRelation(zht, lowerBound)),
								new CLTLocConjunction(subflow, new CLTLocGERelation(zht, lowerBound)),
								new CLTLocConjunction(subfhigh, new CLTLocLERelation(zht, lowerBound),
										new CLTLocGlobally(new CLTLocNegation(subflow)))))))));

		CLTLocFormula f2 = new CLTLocImplies(low, new CLTLocGlobally(new CLTLocNegation(high)));

		CLTLocFormula f3 = new CLTLocImplies(high, new CLTLocGlobally(new CLTLocNegation(high)));

		CLTLocFormula f4;
		f4 = new CLTLocIff(low,
				new CLTLocDisjunction(
						new CLTLocConjunction(orig,
								new CLTLocNegation(
										high)),
						new CLTLocConjunction(
								new CLTLocNegation(
										orig),
								new CLTLocDisjunction(
										new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(zlt, orig),
												new CLTLocConjunction(subflow, new CLTLocEQRelation(zht, lowerBound),
														new CLTLocGlobally(new CLTLocNegation(subfhigh))))),
										new CLTLocConjunction(subflow, new CLTLocEQRelation(zlt, lowerBound),
												new CLTLocGlobally(new CLTLocNegation(subfhigh)))))));

		return new CLTLocConjunction(this.clockEventsConstraint(formula), f3,
				new CLTLocGlobally(new CLTLocConjunction(f1, f2, f4)));
	}

	@Override
	public CLTLocFormula visit(MITLEventually_ZerotoB formula) {
		CLTLValueAtom orig = new CLTLValueAtom(0);

		MITLFormula subf = formula.getChild();

		CLTLLowAtom low = new CLTLLowAtom(formula.idFormula());
		CLTLHighAtom high = new CLTLHighAtom(formula.idFormula());

		CLTLValueAtom upperBound = new CLTLValueAtom(formula.upperbound());

		CLTLVariable zht = new CLTLzHAtom(formula.idFormula());

		CLTLLowAtom subflow = new CLTLLowAtom(subf.idFormula());
		CLTLHighAtom subfhigh = new CLTLHighAtom(subf.idFormula());

		CLTLVariable subfzl = new CLTLzLAtom(formula.getChild().idFormula());

		CLTLocFormula f1;
		f1 = new CLTLocIff(high, new CLTLocDisjunction(
				new CLTLocConjunction(new CLTLocNegation(orig),
						new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(zht, orig),
								new CLTLocConjunction(subfhigh, new CLTLocEQRelation(zht, upperBound),
										new CLTLocGERelation(subfzl, upperBound))))),
				new CLTLocConjunction(orig,
						new CLTLocDisjunction(subfhigh,
								new CLTLocNext(new CLTLocUntil(new CLTLocGERelation(zht, orig), new CLTLocDisjunction(
										new CLTLocConjunction(subfhigh,
												new CLTLocLEQRelation(zht, upperBound)),
										new CLTLocConjunction(subflow, new CLTLocLERelation(zht, upperBound)))))))));

		CLTLocFormula f2;
		f2 = new CLTLocImplies(new CLTLocConjunction(subfhigh, new CLTLocGERelation(subfzl, upperBound)),
				new CLTLocEQRelation(zht, upperBound));

		CLTLocFormula f3;
		f3 = new CLTLocIff(low,
				new CLTLocConjunction(subflow, new CLTLocNegation(new CLTLocUntil(new CLTLocNegation(subfhigh),
						new CLTLocConjunction(subfhigh, new CLTLocGEQRelation(subfzl, upperBound))))));

		return new CLTLocConjunction(this.clockEventsConstraint(formula),
				new CLTLocGlobally(new CLTLocConjunction(f1, f2, f3)));
	}

	@Override
	public CLTLocFormula visit(MITLFalse formula) {
		return new CLTLocConjunction(this.clockEventsConstraint(formula),
				new CLTLocConjunction(new CLTLLowAtom(formula.idFormula()),
						new CLTLocNegation(new CLTLocEventually(new CLTLHighAtom(formula.idFormula())))));

	}

	@Override
	public CLTLocFormula visit(MITLNegation formula) {

		int formulaId = formula.idFormula();

		int subFormulaId = formula.getChild().idFormula();

		CLTLocFormula f1 = new CLTLocIff(new CLTLHighAtom(formulaId), new CLTLLowAtom(subFormulaId));
		CLTLocFormula f2 = new CLTLocIff(new CLTLLowAtom(formulaId), new CLTLHighAtom(subFormulaId));

		return new CLTLocConjunction(this.clockEventsConstraint(formula),
				new CLTLocGlobally(new CLTLocConjunction(f1, f2)));
	}

	@Override
	public CLTLocFormula visit(MITLTrue formula) {

		return new CLTLocConjunction(this.clockEventsConstraint(formula),
				new CLTLocConjunction(new CLTLHighAtom(formula.idFormula()),
						new CLTLocNegation(new CLTLocEventually(new CLTLLowAtom(formula.idFormula())))));

	}

	private CLTLocFormula auxiliaryClocksConstraints(int b, int a, Formula formula) {

		int d = (int) Math.floor(b / (b - a) + 1) + 1;

		CLTLValueAtom zeroValue = new CLTLValueAtom(0);

		CLTLocFormula fHighAtom = new CLTLHighAtom(formula.idFormula());

		CLTLocFormula fLowAtom = new CLTLHighAtom(formula.idFormula());

		CLTLocFormula[] _f1 = new CLTLocFormula[d];

		for (int i = 0; i < d; i++) {
			_f1[i] = new CLTLocEQRelation(new CLTLVariable("x" + i + "_" + formula.idFormula()), zeroValue);
		}

		CLTLocFormula f1OR = _f1.length > 1 ? new CLTLocDisjunction(_f1[0], Arrays.copyOfRange(_f1, 1, _f1.length))
				: _f1[0];

		CLTLocFormula f1 = new CLTLocImplies(fHighAtom, f1OR);

		CLTLocFormula[] _f2 = new CLTLocFormula[d];
		for (int i = 0; i < d; i++) {
			_f2[i] = new CLTLocEQRelation(new CLTLVariable("y" + i + "_" + formula.idFormula()), zeroValue);
		}

		CLTLocFormula f2OR = _f2.length > 1 ? new CLTLocDisjunction(_f2[0], Arrays.copyOfRange(_f2, 1, _f2.length))
				: _f2[0];

		CLTLocFormula f2 = new CLTLocImplies(fLowAtom, f2OR);

		CLTLocFormula[] _f3 = new CLTLocFormula[d * d];
		for (int i = 0; i < d; i++)
			for (int j = 0; j < d; j++)
				if (i != j)
					_f3[i * d + j] = new CLTLocConjunction(
							new CLTLocNegation(
									new CLTLocConjunction(
											new CLTLocEQRelation(new CLTLVariable("x" + i + "_" + formula.idFormula()),
													zeroValue),
											new CLTLocEQRelation(
													new CLTLVariable("x" + j + "_"
															+ formula
																	.idFormula()),
													zeroValue))),
							new CLTLocNegation(new CLTLocConjunction(
									new CLTLocEQRelation(new CLTLVariable("y" + i + "_" + formula.idFormula()),
											zeroValue),
									new CLTLocEQRelation(new CLTLVariable("y" + j + "_" + formula.idFormula()),
											zeroValue))));

		CLTLocFormula f3 = _f2.length > 1 ? new CLTLocConjunction(_f3[0], Arrays.copyOfRange(_f3, 1, _f3.length))
				: _f3[0];

		CLTLocFormula[] _f4 = new CLTLocFormula[d];
		for (int i = 0; i < d; i++) {

			CLTLocFormula[] _f4_x = new CLTLocFormula[d];
			CLTLocFormula[] _f4_y = new CLTLocFormula[d];

			for (int j = 0; j < d; j++) {
				if (j != i)
					_f4_x[j] = new CLTLocEQRelation(new CLTLVariable("y" + j + "_" + formula.idFormula()), zeroValue);
			}
			CLTLocFormula f4_x = _f4_x.length > 1
					? new CLTLocConjunction(_f4_x[0], Arrays.copyOfRange(_f4_x, 1, _f4_x.length)) : _f4_x[0];

			for (int j = 0; j < d; j++) {
				if (j != (i + 1) % d)
					_f4_y[j] = new CLTLocEQRelation(new CLTLVariable("x" + j + "_" + formula.idFormula()), zeroValue);

			}
			CLTLocFormula f4_y = _f4_y.length > 1
					? new CLTLocConjunction(_f4_y[0], Arrays.copyOfRange(_f4_y, 1, _f4_y.length)) : _f4_y[0];

			_f4[i] = new CLTLocConjunction(
					new CLTLocImplies(
							new CLTLocEQRelation(
									new CLTLVariable("x" + i + "_"
											+ formula
													.idFormula()),
									zeroValue),
							new CLTLocRelease(
									new CLTLocEQRelation(
											new CLTLVariable("y" + i + "_"
													+ formula.idFormula()),
											zeroValue),
									f4_x)),
					new CLTLocImplies(
							new CLTLocEQRelation(new CLTLVariable("y" + i + "_" + formula.idFormula()), zeroValue),
							new CLTLocRelease(new CLTLocEQRelation(
									new CLTLVariable("x" + ((i + 1) % d) + "_" + formula.idFormula()), zeroValue),
									f4_y)));

		}

		CLTLocFormula f4 = _f4.length > 1 ? new CLTLocConjunction(_f4[0], Arrays.copyOfRange(_f4, 1, _f4.length))
				: _f4[0];

		CLTLocFormula[] _f5 = new CLTLocFormula[d];
		for (int i = 0; i < d; i++) {

			_f5[i] = new CLTLocConjunction(
					new CLTLocImplies(
							new CLTLocEQRelation(
									new CLTLVariable("x" + i + "_"
											+ formula
													.idFormula()),
									zeroValue),
							new CLTLocNext(
									new CLTLocRelease(
											new CLTLocEQRelation(
													new CLTLVariable(
															"y" + ((i + d - 1) % d) + "_" + formula.idFormula()),
													zeroValue),
											new CLTLocGERelation(new CLTLVariable("x" + i + "_" + formula.idFormula()),
													zeroValue)))),
					new CLTLocImplies(
							new CLTLocEQRelation(
									new CLTLVariable(
											"y" + i + "_"
													+ formula
															.idFormula()),
									zeroValue),
							new CLTLocNext(new CLTLocRelease(
									new CLTLocEQRelation(new CLTLVariable("x" + ((i) % d) + "_" + formula.idFormula()),
											zeroValue),
									new CLTLocGERelation(new CLTLVariable("y" + i + "_" + formula.idFormula()),
											zeroValue)))));

		}

		CLTLocFormula f5 = _f5.length > 1 ? new CLTLocConjunction(_f5[0], Arrays.copyOfRange(_f5, 1, _f5.length))
				: _f5[0];

		CLTLocFormula f6 = new CLTLocIff(
				new CLTLocEQRelation(new CLTLVariable("y" + 0 + "_" + formula.idFormula()), zeroValue),
				new CLTLocNegation(
						new CLTLocEQRelation(new CLTLVariable("x" + 0 + "_" + formula.idFormula()), zeroValue)));

		CLTLocFormula f1f2f3f4f5 = new CLTLocConjunction(f1, f2, f3, f4, f5);
		CLTLocFormula globallyf1f2f3f4f5 = new CLTLocGlobally(f1f2f3f4f5);
		return new CLTLocConjunction(f6, globallyf1f2f3f4f5);

	}

	@Override
	public CLTLocFormula visit(MITLEventually formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLTLocFormula visit(MITLUntil formula) {
		MITLFormula subf1 = formula.getLeftChild();
		MITLFormula subf2 = formula.getRightChild();

		CLTLValueAtom orig = new CLTLValueAtom(0);

		CLTLocFormula lowAtom = new CLTLLowAtom(formula.idFormula());

		CLTLocFormula subf1HighAtom = new CLTLHighAtom(subf1.idFormula());
		CLTLocFormula subf1LowAtom = new CLTLLowAtom(subf1.idFormula());

		CLTLocFormula subf2HighAtom = new CLTLHighAtom(subf2.idFormula());
		CLTLocFormula subf2LowAtom = new CLTLLowAtom(subf2.idFormula());

		// Formula (33)
		CLTLocFormula f1 = new CLTLocConjunction(subf1HighAtom,
				new CLTLocDisjunction(new CLTLocUntil(new CLTLocNegation(subf1LowAtom), subf2HighAtom),
						new CLTLocSince(new CLTLocNegation(subf2LowAtom), subf2HighAtom)));

		// Formula (34)
		CLTLocFormula f2 = new CLTLocIff(lowAtom,
				new CLTLocDisjunction(new CLTLocConjunction(subf1LowAtom,
						new CLTLocDisjunction(orig,
								new CLTLocConjunction(new CLTLocSince(new CLTLocNegation(subf2LowAtom), subf2HighAtom),
										new CLTLocNegation(
												subf2HighAtom)))),
						new CLTLocConjunction(subf2LowAtom, new CLTLocDisjunction(orig,
								new CLTLocConjunction(new CLTLocRelease(
										new CLTLocConjunction(subf1LowAtom, new CLTLocNegation(subf2HighAtom)),
										new CLTLocNegation(subf2HighAtom)),
										new CLTLocConjunction(
												new CLTLocSince(new CLTLocNegation(subf1LowAtom), subf1HighAtom),
												new CLTLocNegation(subf1HighAtom)))))));

		return new CLTLocConjunction(this.clockEventsConstraint(formula),
				new CLTLocGlobally(new CLTLocConjunction(f1, f2)));
	}
}
