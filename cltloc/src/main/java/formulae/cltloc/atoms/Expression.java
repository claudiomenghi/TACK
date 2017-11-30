package formulae.cltloc.atoms;

import formulae.cltloc.visitor.CLTLocVisitor;

public interface Expression {

	 public abstract <T> T accept(CLTLocVisitor<T> t);

}
