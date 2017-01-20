package formulae.cltloc.relations;

import formulae.cltloc.atoms.CLTLConstantAtom;
import formulae.cltloc.atoms.CLTLClock;

public class CLTLocGEQRelation extends CLTLocRelation{
	public CLTLocGEQRelation(CLTLClock subformula1, CLTLConstantAtom subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(CLTLConstantAtom subformula1, CLTLConstantAtom subformula2) {
		super(subformula1, subformula2, ">=");
	}
	
	public CLTLocGEQRelation(CLTLClock subformula1, CLTLClock subformula2) {
		super(subformula1, subformula2, ">=");
	}
}
