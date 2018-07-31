package ta.visitors.liveness;

import formulae.cltloc.CLTLocFormula;
import ta.SystemDecl;

public class NoProgressesRequired implements Liveness2CLTLoc {

	/**
	 * encodes the liveness condition phisem1
	 * 
	 * @param system
	 *            the system to be considered
	 * @return the liveness condition phisem1
	 */
	public CLTLocFormula getLivenessConstraint(SystemDecl system) {

		CLTLocFormula f = CLTLocFormula.TRUE;
		
		return f;
	}


}
