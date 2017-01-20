package formulae.cltloc.relations;

import formulae.cltloc.atoms.CLTLConstantAtom;
import formulae.cltloc.atoms.CLTLClock;

public class CLTLocLERelation extends CLTLocRelation{

	public CLTLocLERelation(CLTLClock subformula1, CLTLConstantAtom subformula2) {
		super(subformula1, subformula2, "<");
	}
	
	public CLTLocLERelation(CLTLConstantAtom subformula1, CLTLConstantAtom subformula2) {
		super(subformula1, subformula2, "<");
	}
	
	public CLTLocLERelation(CLTLClock subformula1, CLTLClock subformula2) {
		super(subformula1, subformula2, "<");
	}

}
