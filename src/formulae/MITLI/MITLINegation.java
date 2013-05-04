package formulae.MITLI;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class MITLINegation extends MITLIFormula {

	//Formula f1 which is argument of the negation (\neg f1) 
	private MITLIFormula subformula;
	
	public MITLINegation(MITLIFormula subformula){
		super(new String("(NEG " + subformula.strFormula()) + ")");
		this.subformula = subformula;
	}


	
	@Override
	public String translate(CLTLTranslator t) {
		
		MITLIFormula subf = subformula;
		
		String f1;
		f1 = t.iff(interval(t), t.neg(subf.interval(t)));
		
		return  t.and(super.clocksEventsConstraints(t), t.G(f1));
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
		
		subformula = (MITLIFormula)l.get(0);					
		return this;
	}

	@Override
	public Formula simplify() {
		if (subformula.getClass() == MITLINegation.class){
			List<Formula> l = subformula.subformulae();
			return l.get(0).simplify();
		}
		else return new MITLINegation((MITLIFormula)subformula.simplify());
	}
	
	
}
