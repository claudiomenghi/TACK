package formulae.cltloc.relations;

import formulae.cltloc.atoms.CLTLConstantAtom;
import formulae.cltloc.atoms.CLTLClock;

public class CLTLocLEQRelation extends CLTLocRelation{
	public CLTLocLEQRelation(CLTLClock subformula1, CLTLConstantAtom subformula2) {
		super(subformula1, subformula2, "<=");
	}
	
	public CLTLocLEQRelation(CLTLConstantAtom subformula1, CLTLConstantAtom subformula2) {
		super(subformula1, subformula2, "<=");
	}
	
	public CLTLocLEQRelation(CLTLClock subformula1, CLTLClock subformula2) {
		super(subformula1, subformula2, "<=");
	}
}
