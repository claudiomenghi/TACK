package formulae.mitli;

import java.util.ArrayList;
import java.util.List;
import formulae.Formula;
import formulae.TemporizedFormula;

public abstract class MITLIPast extends MITLIFormula implements TemporizedFormula {

	protected MITLIFormula subformula;

	public MITLIPast(String subformula) {
		super(subformula);
	}

	@Override
	public MITLIFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them
		if (l.get(0).equals(subformula)) {
			subformula = (MITLIFormula) l.get(0);
			return this;
		}
		// else rise an error. TODO: implement WrongUpdateException
		else
			return null;
	}

}
