package formulae.cltloc.relations;

import formulae.cltloc.atoms.CLTLocConstantAtom;
import formulae.cltloc.atoms.CLTLocSignal;
import formulae.cltloc.atoms.CLTLocClock;

public class CLTLocGEQRelation extends CLTLocRelation{
	public CLTLocGEQRelation(CLTLocClock subformula1, CLTLocConstantAtom subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(CLTLocConstantAtom subformula1, CLTLocConstantAtom subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(CLTLocClock subformula1, CLTLocClock subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(CLTLocSignal subformula1, CLTLocConstantAtom subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(CLTLocConstantAtom subformula1, CLTLocSignal subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(CLTLocSignal subformula1, CLTLocSignal subformula2) {
		super(subformula1, subformula2, ">=");
	}
}
