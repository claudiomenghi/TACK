package formulae.MITLI;

import java.util.ArrayList;
import java.util.List;
import delegateTranslator.CLTLTranslator;
import formulae.Formula;
import formulae.Temporized;

public class MITLIEventually_AtoInf extends MITLIFormula implements Temporized{


	private MITLIFormula subformula;
	private final int a;	
	
	
	public MITLIEventually_AtoInf(MITLIFormula subformula, int a) {
		super(new String("(F " + String.valueOf(a) + " +oo" + subformula.strFormula() + ")"));
		this.subformula = subformula;
		this.a = a;
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


	@Override
	public Formula simplify() {
		return new MITLIEventually_AtoInf((MITLIFormula)subformula.simplify(), a);
	}




	@Override
	public String translate(CLTLTranslator t) {
		
		
		String orig = new String("O");
		
		List<Formula> subfs = this.subformulae();
		MITLIFormula subf = (MITLIFormula)subfs.get(0);
		
		String f1 = null;
		
		
		String f2 = null;
		
		
		String f3 = null;
		
					
		
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f1,f2,f3)));
		
	}
	




	@Override
	public int upperbound() {		
		return -1;
	}



	@Override
	public int lowerbound() {
		return a;
	}
	
}
	


