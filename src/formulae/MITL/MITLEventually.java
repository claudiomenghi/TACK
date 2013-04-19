package formulae.MITL;

import java.util.ArrayList;
import java.util.List;
import formulae.Formula;
import formulae.Temporized;

public abstract class MITLEventually extends MITLFormula implements Temporized{


	protected MITLFormula subformula;
	
	
	public MITLEventually(String subformula) {
		super(subformula);
	}



	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		r.add(subformula);
		
		return r;
	}
	
	

	@Override
	public MITLFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		if (l.get(0).equals(subformula)){
			subformula = (MITLFormula)l.get(0);					
			return this;
		}
		//else rise an error. TODO: implement WrongUpdateException
		else
			return null;
	}



	
}

