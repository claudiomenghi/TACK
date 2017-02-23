package formulae.cltloc.relations;

import formulae.cltloc.atoms.CLTLocConstantAtom;
import formulae.cltloc.atoms.CLTLocSignal;
import formulae.cltloc.atoms.CLTLocClock;

public class CLTLocLERelation extends CLTLocRelation{

	public CLTLocLERelation(CLTLocClock subformula1, CLTLocConstantAtom subformula2) {
		super(subformula1, subformula2, "<");
	}
	
	public CLTLocLERelation(CLTLocConstantAtom subformula1, CLTLocConstantAtom subformula2) {
		super(subformula1, subformula2, "<");
	}
	
	public CLTLocLERelation(CLTLocClock subformula1, CLTLocClock subformula2) {
		super(subformula1, subformula2, "<");
	}

	
	public CLTLocLERelation(CLTLocSignal subformula1, CLTLocConstantAtom subformula2) {
		super(subformula1, subformula2, "<");
	}
	
	public CLTLocLERelation(CLTLocConstantAtom subformula1, CLTLocSignal subformula2) {
		super(subformula1, subformula2, "<");
	}
	
	public CLTLocLERelation(CLTLocSignal subformula1, CLTLocSignal subformula2) {
		super(subformula1, subformula2, "<");
	}
}
