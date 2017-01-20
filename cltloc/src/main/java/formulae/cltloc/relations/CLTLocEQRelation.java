package formulae.cltloc.relations;

import formulae.cltloc.atoms.CLTLConstantAtom;
import formulae.cltloc.atoms.CLTLClock;

public class CLTLocEQRelation  extends CLTLocRelation{
	public CLTLocEQRelation(CLTLClock subformula1, CLTLConstantAtom subformula2) {
		super(subformula1, subformula2, "=");
	}
	
	public CLTLocEQRelation(CLTLConstantAtom subformula1, CLTLConstantAtom subformula2) {
		super(subformula1, subformula2, "=");
	}
	
	public CLTLocEQRelation(CLTLClock subformula1, CLTLClock subformula2) {
		super(subformula1, subformula2, "=");
	}
}
