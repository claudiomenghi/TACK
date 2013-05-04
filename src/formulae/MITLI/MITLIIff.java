package formulae.MITLI;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class MITLIIff extends MITLIFormula {

	//Formula f1 which is argument of the negation (\neg f1) 
	private MITLIFormula subformula1;
	private MITLIFormula subformula2;
	
	public MITLIIff(MITLIFormula subformula1, MITLIFormula subformula2){
		super(new String("(IFF " + subformula1.strFormula() + " " + subformula2.strFormula()) + ")");
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}


	
	@Override
	public String translate(CLTLTranslator t) {
		
		MITLIFormula subf1 = subformula1;
		MITLIFormula subf2 = subformula2;
		
		String f1;
		f1 = t.iff(interval(t), t.iff(subf1.interval(t), subf2.interval(t)));
		
		return  t.and(super.clocksEventsConstraints(t), t.G(f1));
	}

	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		r.add(subformula1);
		r.add(subformula2);
		
		return r;
	}

	@Override
	public MITLIFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them

		subformula1 = (MITLIFormula)l.get(0);
		subformula2 = (MITLIFormula)l.get(1);
		return this;
	
	}

	@Override
	public Formula simplify() {
		return new MITLIIff((MITLIFormula)subformula1.simplify(),(MITLIFormula)subformula2.simplify());
	}
	
	
}
