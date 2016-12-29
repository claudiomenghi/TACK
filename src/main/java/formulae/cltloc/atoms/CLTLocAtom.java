package formulae.cltloc.atoms;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

/**
 * Contains an atom of a CLTLoc formula
 * 
 * @author Claudio Menghi
 *
 */
public class CLTLocAtom extends CLTLocFormula {

	public CLTLocAtom(String atom) {
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
