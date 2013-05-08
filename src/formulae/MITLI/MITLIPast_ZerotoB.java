package formulae.MITLI;

import java.util.List;
import delegateTranslator.CLTLTranslator;
import formulae.Formula;


public class MITLIPast_ZerotoB extends MITLIPast_AtoB{
	
	
	public MITLIPast_ZerotoB(MITLIFormula subformula, int b) {
		super(subformula, 0, b);
		
		this.maxIntComparedto(b);		
	}



	
	public String translate(CLTLTranslator t) {
		
		String orig = t.atom("O");
		
		List<Formula> subfs = this.subformulae();
		MITLIFormula subf = (MITLIFormula)subfs.get(0);
		
		String f1;
		f1 = t.iff(
				high(t),
				t.and(
						subf.high(t),
						t.or(
								orig,
								t.Y(
										t.S(
												t.neg(subf.high(t)),
												t.and(
														orig,
														t.neg(subf.interval(t))
												)
										)
								),
								t.or(t.rel(">", subf.z0(t), String.valueOf(upperbound())), t.rel(">", subf.z1(t), String.valueOf(upperbound())))
						)
				)
		);
		
		String f2;
		f2 = t.iff(
				low(t),	
				t.or(
						t.and(orig, t.neg(subf.interval(t))),
						t.and(
								t.rel("=", subf.z0(t), String.valueOf(upperbound())),
								t.S(
										t.neg(subf.high(t)),
										t.and(											
												subf.low(t),
												t.rel("=", subf.z0(t), "0")
										)
								)
						),
						t.and(
								t.rel("=", subf.z1(t), String.valueOf(upperbound())),
								t.S(
										t.neg(subf.high(t)),
										t.and(
												subf.low(t),
												t.rel("=", subf.z1(t), "0")
										)
								)
						)
				)	
		);
		
		String f5;
		f5 = t.and(
					t.implies(
								t.and(subf.low(t), t.rel("=", subf.z0(t), "0")),
								t.U(
										t.rel("<", subf.z0(t), "1"),
										t.or(
												t.and(subf.high(t), t.rel("<", subf.z0(t), "1")), 
												t.rel("=", subf.z0(t), "1"))											
								)			
					),
					t.implies(
							t.and(subf.low(t), t.rel("=", subf.z1(t), "0")),
							t.U(
									t.rel("<", subf.z0(t), "1"),
									t.or(
											t.and(subf.high(t), t.rel("<", subf.z0(t), "1")), 
											t.rel("=", subf.z0(t), "1"))											
							)
					)
			);
		
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f1,f2,f5)));
	
	}



	@Override
	public Formula simplify() {
		return new MITLIPast_ZerotoB((MITLIFormula)subformula.simplify(), upperbound());
	}

	
	

	
}
	


