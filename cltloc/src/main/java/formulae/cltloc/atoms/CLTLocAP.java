package formulae.cltloc.atoms;

import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocAP extends CLTLocAtom {

	public CLTLocAP(String atom) {
		super(atom);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}
}
