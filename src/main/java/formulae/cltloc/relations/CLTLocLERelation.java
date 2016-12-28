package formulae.cltloc.relations;

import formulae.cltloc.atoms.CLTLValueAtom;
import formulae.cltloc.atoms.CLTLVariable;

public class CLTLocLERelation extends CLTLocRelation{

	public CLTLocLERelation(CLTLVariable subformula1, CLTLValueAtom subformula2) {
		super(subformula1, subformula2, "<");
	}

}
