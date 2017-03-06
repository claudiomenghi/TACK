package ta.state;

import formulae.cltloc.CLTLocFormula;
import ta.visitors.TA2CLTLoc;

public abstract class Invariant {

	abstract public CLTLocFormula accept(TA2CLTLoc ta2cltLoc);

}
