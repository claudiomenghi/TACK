package formulae.cltloc.atoms;

import formulae.cltloc.visitor.CLTLocVisitor;

/**
 * Contains an atom of a CLTLoc formula
 * 
 * @author Claudio Menghi
 *
 */
public abstract class Atom implements  formulae.cltloc.atoms.Expression{

	public Atom() {
		super();
	}
	
	 public abstract <T> T accept(CLTLocVisitor<T> t);

}
