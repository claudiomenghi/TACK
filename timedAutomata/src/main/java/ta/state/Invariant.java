package ta.state;

import formulae.cltloc.CLTLocFormula;
import ta.visitors.TA2CLTLoc;
import ta.visitors.TA2CLTLocVisitor;

public abstract class Invariant {

	abstract public CLTLocFormula accept(TA2CLTLocVisitor ta2cltLoc);

}
