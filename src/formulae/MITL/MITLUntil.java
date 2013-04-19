package formulae.MITL;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class MITLUntil extends MITLFormula {

	
	private MITLFormula subformula1, subformula2;
	
	public MITLUntil(MITLFormula subformula1, MITLFormula subformula2){
		super(new String("(U " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}
	
	
	
	@Override
	public String translate(CLTLTranslator t) {
		
		// Some alias...
		MITLFormula subf1 = subformula1;
		MITLFormula subf2 = subformula2;
			
	 
		
		String orig = t.atom("O");
		

		
		// Formula (33)
		
		String f1 = t.and(
							subf1.high(t),
							t.or(
									t.U(t.neg(subf1.low(t)), subf2.high(t)),
									t.S(t.neg(subf2.low(t)), subf2.high(t))
								)
					);
		
		
		// Formula (34)
		
		String f2 = t.iff(
							low(t),
							t.or(
									t.and(
											subf1.low(t),
											t.or(
													orig,													
													t.and(t.S(t.neg(subf2.low(t)), subf2.high(t)), t.neg(subf2.high(t)))
												)
									    ),
									t.and(
											subf2.low(t),											
											t.or(
													orig,
													t.and(
															t.R(
																	t.and(subf1.low(t), t.neg(subf2.high(t))), 
																	t.neg(subf2.high(t))
															),
															t.and(t.S(t.neg(subf1.low(t)), subf1.high(t)), t.neg(subf1.high(t)))
													)
											)
									)
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
			return null; //return new MITLUntil((MITLFormula)l.get(0),(MITLFormula)l.get(1));
	}



	@Override
	public Formula simplify() {
		return new MITLUntil((MITLFormula)subformula1.simplify(),(MITLFormula)subformula2.simplify());
	}

	
}
