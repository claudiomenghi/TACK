package formulae.MITL;

import java.util.ArrayList;
import java.util.List;
import delegateTranslator.CLTLTranslator;
import formulae.Formula;
import formulae.Temporized;

public class MITLEventually_AtoInf extends MITLFormula implements Temporized{


	private MITLFormula subformula;
	private final int a;	
	
	
	public MITLEventually_AtoInf(MITLFormula subformula, int a) {
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


	@Override
	public Formula simplify() {
		return new MITLEventually_AtoInf((MITLFormula)subformula.simplify(), a);
	}




	@Override
	public String translate(CLTLTranslator t) {
		
		
String orig = new String("O");
		
		List<Formula> subfs = this.subformulae();
		MITLFormula subf = (MITLFormula)subfs.get(0);
		
		String f1;
		f1 = t.iff(
					high(t),
					t.and(
							orig,
							t.or(
									t.and(subf.high(t), t.G(t.neg(subf.low(t)))),
									t.X(
											t.U(
													t.rel(">", zH(t), "0"),
													t.or(
															t.and(subf.high(t), t.rel(">=", zH(t), String.valueOf(lowerbound()))),
															t.and(subf.low(t), t.rel(">", zH(t), String.valueOf(lowerbound()))),
															t.and(subf.high(t), t.rel("<", zH(t), String.valueOf(lowerbound())), t.G(t.neg(subf.low(t))))
													)
											)
									)
							)
					)
			);
		
		String f2;
		f2 = t.implies(
						low(t),
						t.G(t.neg(high(t)))
			);
		
		String f3;
		f3 = t.implies(
						high(t),
						t.G(t.neg(high(t)))
			);
		
		String f4;
		f4 = t.iff(
					low(t),
					t.or(
							t.and(orig, t.neg(high(t))),
							t.and(
									t.neg(orig),
									t.or(
											t.X(
													t.U(
															t.rel(">", zL(t), "0"),
															t.and(
																	subf.low(t), 
																	t.rel("=", zH(t), String.valueOf(lowerbound())),
																	t.G(t.neg(subf.high(t)))
															)
													)
											),
											t.and(
													subf.low(t), 
													t.rel("=", zL(t), String.valueOf(lowerbound())),
													t.G(t.neg(subf.high(t)))
											)
									)											
							)
					)
			);
		
		
		
		return t.and(super.clocksEventsConstraints(t), f3, t.G(t.and(f1, f2, f4)));
		
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
	


