package formulae.cltloc.relations;

import formulae.cltloc.atoms.CLTLocConstantAtom;
import formulae.cltloc.atoms.CLTLocSignal;
import formulae.cltloc.atoms.CLTLocClock;

public class CLTLocEQRelation  extends CLTLocRelation{
	public CLTLocEQRelation(CLTLocClock subformula1, CLTLocConstantAtom subformula2) {
		super(subformula1, subformula2, "=");
	}
	
	public CLTLocEQRelation(CLTLocConstantAtom subformula1, CLTLocConstantAtom subformula2) {
		super(subformula1, subformula2, "=");
	}
	
	public CLTLocEQRelation(CLTLocClock subformula1, CLTLocClock subformula2) {
		super(subformula1, subformula2, "=");
	}
	
	public CLTLocEQRelation(CLTLocSignal subformula1, CLTLocConstantAtom subformula2) {
		super(subformula1, subformula2, "=");
	}
	
	public CLTLocEQRelation(CLTLocConstantAtom subformula1, CLTLocSignal subformula2) {
		super(subformula1, subformula2, "=");
	}
	
	public CLTLocEQRelation(CLTLocSignal subformula1, CLTLocSignal subformula2) {
		super(subformula1, subformula2, "=");
	}
}
