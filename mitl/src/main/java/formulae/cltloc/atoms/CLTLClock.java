package formulae.cltloc.atoms;

import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLClock extends CLTLocAtom {

	public CLTLClock(String name) {
		super(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}
}
