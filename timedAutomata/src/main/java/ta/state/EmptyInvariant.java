package ta.state;

import formulae.cltloc.CLTLocFormula;
import ta.TA;
import ta.visitors.InvariantVisitor;

public class EmptyInvariant extends Invariant {


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public CLTLocFormula accept(TA ta,InvariantVisitor v) {
		return v.visit(ta, this);
	}
}
