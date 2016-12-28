package formulae.cltloc.atoms;

import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLVariable extends CLTLocAtom {

	public CLTLVariable(String name) {
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
