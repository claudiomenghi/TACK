package formulae.MITL;

import java.util.List;
import delegateTranslator.CLTLTranslator;
import formulae.Formula;


public class MITLEventually_ZerotoB extends MITLEventually_AtoB{
	
	
	public MITLEventually_ZerotoB(MITLFormula subformula, int b) {
		super(subformula, 0, b);
	}



	@Override
	public String translate(CLTLTranslator t) {
		
		String orig = new String("O");
		
		List<Formula> subfs = this.subformulae();
		MITLFormula subf = (MITLFormula)subfs.get(0);
		
		String f1;
		f1 = t.iff(
					high(t),
					t.or(
							t.and(
									t.neg(orig),
									t.X(
											t.U(
													t.rel(">", zH(t), "0"),
													t.and(
															subf.high(t),
															t.rel("=", zH(t), String.valueOf(upperbound())),
															t.rel(">", subf.zL(t), String.valueOf(upperbound()))
													)
											)
									)
							),
							t.and(
									orig,
									t.or(
											subf.high(t),
											t.X(
													t.U(
															t.rel(">", zH(t), "0"),
															t.or(
																	t.and(subf.high(t), t.rel("<=", zH(t), String.valueOf(upperbound()))),
																	t.and(subf.low(t), t.rel("<", zH(t), String.valueOf(upperbound())))		
															)
													)
											)
									)
							)
					)
			);
		
		String f2;
		f2 = t.implies(
						t.and(subf.high(t), t.rel(">", subf.zL(t), String.valueOf(upperbound()))),
						t.rel("=", zH(t), String.valueOf(upperbound()))
			);
		
		String f3;
		f3 = t.iff(
					low(t),
					t.and(
							subf.low(t),
							t.neg(
									t.U(
											t.neg(subf.high(t)),
											t.and(subf.high(t), t.rel("<=", subf.zL(t), String.valueOf(upperbound())))
									)
							)
					)			
			);
		
		
		
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f1, f2, f3)));
	
	}



	
	
	

	
}
	


