package ta.visitors;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocConstantAtom;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.relations.CLTLocEQRelation;
import formulae.cltloc.relations.CLTLocGERelation;
import ta.AP;
import ta.Clock;
import ta.State;
import ta.TA;
import ta.transition.EQAssignement;
import ta.transition.EQCondition;
import ta.transition.Transition;

public class TA2CLTLoc {

	private static final BinaryOperator<CLTLocFormula> conjunctionOperator = (left, right) -> {
		if (left.equals(CLTLocFormula.TRUE)) {
			return right;
		}
		if (right.equals(CLTLocFormula.TRUE)) {
			return left;
		}
		return new CLTLocConjunction(left, right);
	};

	private static final BinaryOperator<CLTLocFormula> disjunctionOperator = (left, right) -> {
		if (left.equals(CLTLocFormula.FALSE)) {
			return right;
		}
		if (right.equals(CLTLocFormula.FALSE)) {
			return left;
		}
		return new CLTLocDisjunction(left, right);
	};

	private static final BinaryOperator<CLTLocFormula> implicationOperator = (left, right) -> {
		if (right.equals(CLTLocFormula.TRUE)) {
			return left;
		}
		return new CLTLocImplies(left, right);
	};

	private static final UnaryOperator<CLTLocFormula> negationOperator = CLTLocNegation::new;
	private static final UnaryOperator<CLTLocFormula> globallyOperator = CLTLocGlobally::new;
	private static final UnaryOperator<CLTLocFormula> nextOperator = CLTLocGlobally::new;

	private static final Function<AP, CLTLocFormula> ap2CLTLocRESTAp = ap -> new CLTLocAP("r_" + ap.getName());
	private static final Function<AP, CLTLocFormula> ap2CLTLocFIRSTAp = ap -> new CLTLocAP("f_" + ap.getName());

	private static final Function<State, CLTLocFormula> state2Ap = (s) -> new CLTLocAP("s_" + s.getId());

	public CLTLocFormula convert(TA ta, Set<AP> propositionsOfInterest) {

		CLTLocFormula phi1 = this.getPhi1(ta);
		CLTLocFormula phi2 = this.getPhi2(ta);
		CLTLocFormula phi3 = this.getPhi3(ta);
		CLTLocFormula phi4 = this.getPhi4(ta);
		CLTLocFormula phi5 = this.getPhi5(ta, propositionsOfInterest);
		CLTLocFormula phi6 = this.getPhi6(ta);
		CLTLocFormula phi7 = this.getPhi7(ta);

		return conjunctionOperator.apply(phi2,
				conjunctionOperator.apply(phi7,
						globallyOperator.apply(conjunctionOperator.apply(phi1, conjunctionOperator.apply(phi3,
								conjunctionOperator.apply(phi4, conjunctionOperator.apply(phi5, phi6)))))));
	}

	private CLTLocFormula getPhi1(TA ta) {

		return ta.getStates().stream()
				.map(s -> implicationOperator.apply(state2Ap.apply(s),
						ta.getStates().stream().filter(s1 -> !s1.equals(s))
								.map(s1 -> negationOperator.apply(state2Ap.apply(s1))).reduce(conjunctionOperator)
								.orElse(state2Ap.apply(s))))
				.reduce(disjunctionOperator).orElse(CLTLocFormula.FALSE);

	}

	private CLTLocFormula getPhi2(TA ta) {
		return state2Ap.apply(ta.getInitialState());
	}

	private CLTLocFormula getPhi3(TA ta) {
		CLTLocFormula subFormulaPhi3 = ta.getStates().stream()
				.map(s -> implicationOperator.apply(state2Ap.apply(s),
						conjunctionOperator.apply(s.getInvariant().accept(new Expression2CLTLoc()),
								nextOperator.apply(s.getInvariant().accept(new Expression2CLTLoc())))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return globallyOperator.apply(subFormulaPhi3);
	}

	private CLTLocFormula getPhi5(TA ta, Set<AP> propositionsOfInterest) {

		CLTLocFormula phi5StatesSubformula = ta.getStates().stream()
				.map((s) -> implicationOperator.apply(state2Ap.apply(s),
						conjunctionOperator.apply(
								s.getValid(propositionsOfInterest).stream().map(ap2CLTLocRESTAp)
										.reduce(conjunctionOperator).orElse(CLTLocFormula.TRUE),
								s.getValid(propositionsOfInterest).stream()
										.map((ap) -> negationOperator.apply(ap2CLTLocRESTAp.apply(ap)))
										.reduce(conjunctionOperator).orElse(CLTLocFormula.TRUE))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return globallyOperator.apply(phi5StatesSubformula);

	}

	private CLTLocFormula getPhi4(TA ta) {

		Set<Clock> clocks = ta.getClocks();
		Set<CLTLocFormula> clockFormulae = clocks.stream()
				.map(c -> new CLTLocGERelation(new CLTLocClock(c.getName()), new CLTLocConstantAtom(0)))
				.collect(Collectors.toSet());

		CLTLocFormula clocksGeZero = clockFormulae.stream().reduce(CLTLocFormula.TRUE, conjunctionOperator);

		CLTLocFormula ret = ta.getStates().stream().map(state ->

		implicationOperator.apply(state2Ap.apply(state),
				nextOperator
						.apply(disjunctionOperator.apply(conjunctionOperator.apply(state2Ap.apply(state), clocksGeZero),
								ta.getOutgoingTransitions(state).stream()
										.map(t -> conjunctionOperator.apply(
												this.getClockGuardConditions(t, clocks) 
												, state2Ap.apply(t.getDestination())))
										.reduce(CLTLocFormula.FALSE, disjunctionOperator)))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);
		return globallyOperator.apply(ret);
	}

	private CLTLocFormula getClockGuardConditions(Transition t, Set<Clock> clocks) {
		Set<String> clocksId=clocks.stream().map(c -> c.getName()).collect(Collectors.toSet());
		
		
		CLTLocFormula formula1= CLTLocFormula.TRUE;
		for (EQCondition c : t.getGuard().getConditions()) {
				if(clocksId.contains(c.getId())){
					formula1=conjunctionOperator.apply(formula1, new CLTLocEQRelation(new CLTLocClock(c.getId()), new CLTLocConstantAtom(Integer.parseInt(c.getValue().value))));
				}
		}
		
		CLTLocFormula formula2= CLTLocFormula.TRUE;
		Set<String> s=t.getAssignement().getConditions().stream().map(c -> c.getId()).collect(Collectors.toSet());
		for (EQAssignement c : t.getAssignement().getConditions()) {
				if(clocksId.contains(c.getId())){
					formula2=conjunctionOperator.apply(formula2, new CLTLocEQRelation(new CLTLocClock(c.getId()), new CLTLocConstantAtom(0)));
				}
		}
		Set<String> diff=new HashSet<>(clocksId);
		diff.removeAll(s);
		
		CLTLocFormula formula3= CLTLocFormula.TRUE;
		for(String s2Id: diff){
			formula3=conjunctionOperator.apply(formula2, new CLTLocGERelation(new CLTLocClock(s2Id), new CLTLocConstantAtom(0)));
		}
		return conjunctionOperator.apply(formula1, conjunctionOperator.apply(formula2, formula3));
	}

	private CLTLocFormula getPhi6(TA ta) {
		Function<AP, CLTLocFormula> phi6Subformula = (a) -> implicationOperator.apply(ap2CLTLocRESTAp.apply(a),
				negationOperator.apply(ap2CLTLocFIRSTAp.apply(a)));
		CLTLocFormula andSubformula = ta.getAtomicPropositions().stream().map(phi6Subformula).reduce(CLTLocFormula.TRUE,
				conjunctionOperator);
		return globallyOperator.apply(andSubformula);
	}

	private CLTLocFormula getPhi7(TA ta) {
		return ta.getAtomicPropositions().stream().map(ap2CLTLocFIRSTAp).reduce(CLTLocFormula.TRUE,
				conjunctionOperator);
	}

}
