package ta.visitors.liveness;

import formulae.cltloc.CLTLocFormula;
import ta.SystemDecl;

public interface Liveness2CLTLoc {

	public CLTLocFormula getLivenessConstraint(SystemDecl system);

}
