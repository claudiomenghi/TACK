package formulae.MITL;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class MITLConjunction extends MITLFormula {
	
		
	private MITLFormula subformula1, subformula2;
	
	public MITLConjunction(MITLFormula subformula1, MITLFormula subformula2){
		super(new String("(AND " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}
		
	
	private String dw_bf(MITLFormula xi, MITLFormula upsilon, CLTLTranslator t){
		
		String orig = t.atom("O");
		
		return t.and(
						xi.low(t),
						t.or(
								orig,
								upsilon.low(t),
								t.and(t.S(t.neg(xi.low(t)),upsilon.high(t)), t.neg(upsilon.high(t)))
						)
				);
	}
	

private String up_af(MITLFormula xi, MITLFormula upsilon, CLTLTranslator t){
		
		return t.and(
						xi.high(t),
						t.and(t.S(t.neg(xi.low(t)),upsilon.high(t)))
				);
	}
	
	
	@Override
	public String translate(CLTLTranslator t) {
		// TODO Auto-generated method stub
		
		
		// Some alias...
		MITLFormula subf1 = subformula1;
		MITLFormula subf2 = subformula2;
			
	

		
		String f1 = t.iff(
							high(t),
							t.or(
									up_af(subf1,subf2,t),
									up_af(subf2,subf1,t)	 
								)
						);
		

		
		String f2 = t.iff(
							low(t),
							t.or(
									dw_bf(subf1,subf2,t),
									dw_bf(subf2,subf1,t)	 
								)
									
						 );
		
	
		
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f1,f2)));
	}



	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		r.add(subformula1);
		r.add(subformula2);
		
		return r;
	}



	@Override
	public MITLFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		if (l.get(0).equals(subformula1) && l.get(1).equals(subformula2)){
			subformula1 = (MITLFormula)l.get(0);
			subformula2 = (MITLFormula)l.get(1);
			return this;
		}
		//else rise an error. TODO: implement WrongUpdateException
		else
			return null; //new MITLConjunction((MITLFormula)l.get(0), (MITLFormula)l.get(1));
	}



	@Override
	public Formula simplify() {		
		return new MITLConjunction((MITLFormula)subformula1.simplify(), (MITLFormula)subformula2.simplify());
	}

}
