package formulae.cltloc.atoms;

import formulae.cltloc.visitor.CLTLocVisitor;

/**
 * Contains an atom of a CLTLoc formula
 * 
 * @author Claudio Menghi
 *
 */
public abstract class CLTLocAtom  {

	public CLTLocAtom() {
		super();
	}
	
	 public abstract <T> T accept(CLTLocVisitor<T> t);

}
