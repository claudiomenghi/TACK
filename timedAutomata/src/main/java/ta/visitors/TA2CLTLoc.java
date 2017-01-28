package ta.visitors;

import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocNext;
import ta.AP;
import ta.State;
import ta.TA;

public class TA2CLTLoc {

	private static final BinaryOperator<CLTLocFormula> conjunctionOperator = CLTLocConjunction::new;
	private static final BinaryOperator<CLTLocFormula> disjunctionOperator = CLTLocDisjunction::new;
	private static final BinaryOperator<CLTLocFormula> implicationOperator = CLTLocImplies::new;
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
		CLTLocFormula phi4 = null;
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

		CLTLocFormula phi5StatesSubformula = ta.getStates()
				.stream().map(
						(s) -> implicationOperator
								.apply(state2Ap.apply(s),
										conjunctionOperator.apply(s.getValid(propositionsOfInterest).stream()
												.map(ap2CLTLocRESTAp).reduce(conjunctionOperator).orElse(
														CLTLocFormula.TRUE),
												s.getValid(propositionsOfInterest).stream()
														.map((ap) -> negationOperator.apply(ap2CLTLocRESTAp.apply(ap)))
														.reduce(conjunctionOperator).orElse(CLTLocFormula.TRUE))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);

		return globallyOperator.apply(phi5StatesSubformula);

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
