package formulae.cltloc;

import formulae.Formula;
import formulae.cltloc.visitor.CLTLocVisitor;

public abstract class CLTLocFormula extends Formula {

	public CLTLocFormula(String formula) {
		super(formula);
		
	}
	
	abstract public <T> T accept(CLTLocVisitor<T> t);
}
