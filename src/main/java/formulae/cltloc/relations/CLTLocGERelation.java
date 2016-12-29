package formulae.cltloc.relations;

import formulae.cltloc.atoms.CLTLConstantAtom;
import formulae.cltloc.atoms.CLTLClock;

public class CLTLocGERelation extends CLTLocRelation{
	public CLTLocGERelation(CLTLClock subformula1, CLTLConstantAtom subformula2) {
		super(subformula1, subformula2, ">");
	}
	
	public CLTLocGERelation(CLTLConstantAtom subformula1, CLTLConstantAtom subformula2) {
		super(subformula1, subformula2, ">");
	}
	
	public CLTLocGERelation(CLTLClock subformula1, CLTLClock subformula2) {
		super(subformula1, subformula2, ">");
	}
}
