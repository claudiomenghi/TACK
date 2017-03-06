package formulae.cltloc.relations;

import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.Signal;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.atoms.CLTLocClock;

public class CLTLocGEQRelation extends CLTLocRelation{
	public CLTLocGEQRelation(CLTLocClock subformula1, Constant subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(Constant subformula1, Constant subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(CLTLocClock subformula1, CLTLocClock subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(Signal subformula1, Constant subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(Constant subformula1, Signal subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(Signal subformula1, Signal subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(Variable subformula1, Constant subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(Constant subformula1, Variable subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(Variable subformula1, Variable subformula2) {
		super(subformula1, subformula2, ">=");
	}
}
