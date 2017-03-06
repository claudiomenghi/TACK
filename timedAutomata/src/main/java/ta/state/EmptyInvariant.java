package ta.state;

import formulae.cltloc.CLTLocFormula;
import ta.visitors.TA2CLTLoc;

public class EmptyInvariant extends Invariant {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula accept(TA2CLTLoc ta2cltLoc) {
		return CLTLocFormula.TRUE;
	}

}
