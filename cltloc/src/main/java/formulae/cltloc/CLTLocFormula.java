package formulae.cltloc;

import java.util.Set;

import formulae.Formula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.visitor.CLTLocVisitor;

public abstract class CLTLocFormula extends Formula {

	public static final CLTLocFormula TRUE=new CLTLocAP("True");
	public static final CLTLocFormula FALSE=new CLTLocAP("False");
	
	public CLTLocFormula(String formula) {
		super(formula);
		
	}
	
	
	 public abstract <T> T accept(CLTLocVisitor<T> t);
}
