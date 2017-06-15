package ta.state;

import formulae.cltloc.CLTLocFormula;
import ta.TA;
import ta.visitors.InvariantVisitor;

public abstract class Invariant {

		abstract public CLTLocFormula accept(TA ta, InvariantVisitor v);
}
