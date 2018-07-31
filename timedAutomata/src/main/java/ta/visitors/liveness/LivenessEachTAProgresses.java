package ta.visitors.liveness;

import java.util.Set;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.relations.CLTLocEQRelation;
import ta.SystemDecl;
import ta.TA;
import ta.visitors.TANetwork2CLTLoc;

public class LivenessEachTAProgresses implements Liveness2CLTLoc {

	/**
	 * encodes the liveness condition phisem1
	 * 
	 * @param system
	 *            the system to be considered
	 * @return the liveness condition phisem1
	 */
	public CLTLocFormula getLivenessConstraint(SystemDecl system) {

		CLTLocFormula f = CLTLocFormula.TRUE;
		for (TA ta : system.getTimedAutomata()) {
			CLTLocFormula taf = CLTLocFormula.FALSE;
			Set<Integer> values = ta.getPossibleTransitionVariableValues();

			taf = TANetwork2CLTLoc.eventuallyOperator.apply(ta.getTransitions().stream()
					.map(t -> (CLTLocFormula) new CLTLocEQRelation(
							formulae.cltloc.atoms.BoundedVariable.getBoundedVariable("t" + ta.getId(), values),
							new Constant(t.getId())))
					.reduce(CLTLocFormula.FALSE, TANetwork2CLTLoc.disjunctionOperator));

			f = TANetwork2CLTLoc.conjunctionOperator.apply(f, taf);
		}

		return f;
	}



}
