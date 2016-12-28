package formulae.cltloc.relations;

import formulae.cltloc.atoms.CLTLValueAtom;
import formulae.cltloc.atoms.CLTLVariable;

public class CLTLocGERelation extends CLTLocRelation{
	public CLTLocGERelation(CLTLVariable subformula1, CLTLValueAtom subformula2) {
		super(subformula1, subformula2, ">");
	}
}
