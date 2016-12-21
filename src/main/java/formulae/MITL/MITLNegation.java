package formulae.MITL;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class MITLNegation extends MITLFormula {

	//Formula f1 which is argument of the negation (\neg f1) 
	private MITLFormula subformula;
	
	public MITLNegation(MITLFormula subformula){
		super(new String("(NEG " + subformula.strFormula()) + ")");
		this.subformula = subformula;
	}


	
	@Override
	public String translate(CLTLTranslator t) {
		
		MITLFormula subf = subformula;
		
		String f1 = t.iff(high(t),subf.low(t));
		String f2 = t.iff(low(t),subf.high(t));
		
		return  t.and(super.clocksEventsConstraints(t), t.G(t.and(f1,f2)));
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
			return null; //return new MITLNegation((MITLFormula)l.get(0));
	}

	@Override
	public Formula simplify() {
		if (subformula.getClass() == MITLNegation.class){
			List<Formula> l = subformula.subformulae();
			return l.get(0).simplify();
		}
		else return new MITLNegation((MITLFormula)subformula.simplify());
	}
	
	
}
