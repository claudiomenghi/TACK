package formulae.MITLI;

import java.util.ArrayList;
import java.util.List;
import formulae.Formula;
import formulae.Temporized;

public abstract class MITLIGlobally extends MITLIFormula implements Temporized{


	protected MITLIFormula subformula;
	
	
	public MITLIGlobally(String subformula) {
		super(subformula);
	}



	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		r.add(subformula);
		
		return r;
	}
	
	

	@Override
	public MITLIFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		if (l.get(0).equals(subformula)){
			subformula = (MITLIFormula)l.get(0);					
			return this;
		}
		//else rise an error. TODO: implement WrongUpdateException
		else
			return null;
	}



	
}

