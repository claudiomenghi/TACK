package ta.visitors;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import com.google.common.base.Preconditions;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.unary.CLTLocEventually;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import ta.AP;
import ta.StateAP;
import ta.SystemDecl;
import ta.TA;
import ta.VariableAssignementAP;
import ta.state.State;
import ta.visitors.liveness.Liveness2CLTLoc;
import ta.visitors.liveness.LivenessEachTAProgresses;

public abstract class TANetwork2CLTLoc {

	public static final CLTLocFormula ORIGIN = CLTLocFormula.getNeg(new CLTLocYesterday(CLTLocFormula.TRUE));

	private Liveness2CLTLoc converter;

	public TANetwork2CLTLoc() {
		this.converter = new LivenessEachTAProgresses();
	}

	public TANetwork2CLTLoc(Liveness2CLTLoc converter) {
		if (converter == null) {
			this.converter = new LivenessEachTAProgresses();
		} else {
			this.converter = converter;
		}

	}

	public void setLivenessConverter(Liveness2CLTLoc converter) {
		Preconditions.checkNotNull(converter, "The converter cannot be null");
		this.converter = converter;
	}

	public Liveness2CLTLoc getLivenessConverter() {
		return this.converter;
	}

	public final static String STATE_PREFIX = "S_";

	public abstract CLTLocFormula convert(SystemDecl system, Set<StateAP> propositionsOfInterest,
			Set<VariableAssignementAP> atomicpropositionsVariable);

	public abstract Map<Entry<TA, String>, Integer> getMapStateId();

	public static final Constant zero = new Constant(0);

	public abstract Map<Integer, TA> getMapIdTA();

	public abstract Map<Integer, String> getMapIdStateName();

	public static final Function<Integer, CLTLocFormula> rest = (s) -> new CLTLocAP("H_" + s);

	public static final Function<Integer, CLTLocFormula> first = (s) -> new CLTLocAP("P_" + s);

	public static final BinaryOperator<CLTLocFormula> conjunctionOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		return CLTLocFormula.getAnd(left, right);
	};

	public static final BinaryOperator<CLTLocFormula> iffOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		if (left.equals(CLTLocFormula.TRUE)) {
			return right;
		}
		if (right.equals(CLTLocFormula.TRUE)) {
			return left;
		}
		return new CLTLocIff(left, right);
	};

	public static final BinaryOperator<CLTLocFormula> disjunctionOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		return CLTLocFormula.getOr(left, right);
	};

	public static final UnaryOperator<CLTLocFormula> eventuallyOperator = (formula) -> {

		return new CLTLocEventually(formula);
	};

	public static final BinaryOperator<CLTLocFormula> implicationOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");
		return CLTLocImplies.create(left, right);
	};

	public static final UnaryOperator<CLTLocFormula> negationOperator = CLTLocNegation::new;
	public static final UnaryOperator<CLTLocFormula> globallyOperator = (formula) -> {
		if (formula.equals(CLTLocFormula.TRUE)) {
			return formula;
		}
		return CLTLocGlobally.create(formula);
	};

	public static final UnaryOperator<CLTLocFormula> nextOperator = (formula) -> {
		Preconditions.checkNotNull(formula, "The formula cannot be null");

		if (formula.equals(CLTLocFormula.TRUE)) {
			return formula;
		}
		return new CLTLocNext(formula);
	};

	public static final UnaryOperator<CLTLocFormula> Y = CLTLocYesterday::new;

	public static final Function<AP, CLTLocFormula> ap2CLTLocFIRSTAp = ap -> new CLTLocAP("P_" + ap.getName());

	public static final Function<Entry<TA, State>, CLTLocFormula> state2Ap = (s) -> new CLTLocAP(
			s.getKey().getIdentifier() + "_" + s.getValue().getStringId());

	public static final Function<Entry<TA, String>, CLTLocFormula> sendEvent2Ap = (s) -> new CLTLocAP(
			s.getKey().getIdentifier() + "_?" + s.getValue());

	public static final Function<Entry<TA, String>, CLTLocFormula> tauEvent2Ap = (s) -> new CLTLocAP(
			s.getKey().getIdentifier() + "_" + s.getValue());

	public static final Function<Entry<TA, String>, CLTLocFormula> receiveEvent2Ap = (s) -> new CLTLocAP(
			s.getKey().getIdentifier() + "_!" + s.getValue());

	public static final BinaryOperator<CLTLocFormula> xorOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		if (left.equals(CLTLocFormula.FALSE)) {
			return right;
		}

		if (right.equals(CLTLocFormula.FALSE)) {
			return left;
		}

		return CLTLocFormula.getOr(CLTLocFormula.getAnd(left, negationOperator.apply(right)),
				CLTLocFormula.getAnd(negationOperator.apply(left), right));
	};

}
