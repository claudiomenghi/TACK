package formulae.cltloc.relations;

import formulae.cltloc.atoms.CLTLValueAtom;
import formulae.cltloc.atoms.CLTLVariable;

public class CLTLocEQRelation  extends CLTLocRelation{
	public CLTLocEQRelation(CLTLVariable subformula1, CLTLValueAtom subformula2) {
		super(subformula1, subformula2, "=");
	}
}
