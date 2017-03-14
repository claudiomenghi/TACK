package ta.state;

import formulae.cltloc.CLTLocFormula;
import ta.visitors.TA2CLTLocVisitor;

public class EmptyInvariant extends Invariant {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula accept(TA2CLTLocVisitor ta2cltLoc) {
		return ta2cltLoc.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "";
	}
}
