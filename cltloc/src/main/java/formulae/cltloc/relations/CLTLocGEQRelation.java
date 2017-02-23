package formulae.cltloc.relations;

import formulae.cltloc.atoms.CLTLocConstantAtom;
import formulae.cltloc.atoms.CLTLocVariable;
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
	
	public CLTLocGEQRelation(CLTLocVariable subformula1, CLTLocConstantAtom subformula2) {
		super(subformula1, subformula2, "<");
	}
	
	public CLTLocGEQRelation(CLTLocConstantAtom subformula1, CLTLocVariable subformula2) {
		super(subformula1, subformula2, "<");
	}
	
	public CLTLocGEQRelation(CLTLocVariable subformula1, CLTLocVariable subformula2) {
		super(subformula1, subformula2, "<");
	}
}
