package formulae.MITLI;

import java.util.List;
import delegateTranslator.CLTLTranslator;
import formulae.Formula;


public class MITLIEventually_ZerotoB extends MITLIEventually_AtoB{
	
	
	public MITLIEventually_ZerotoB(MITLIFormula subformula, int b) {
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
					t.or(
						t.and(
								t.neg(orig),
								t.neg(subf.interval(t)),
								t.or(
										t.and(	
												t.rel("=", z0(t), "0"),
												t.X(
														t.U(
																t.rel(">", z0(t), "0"),
																t.and(
																		subf.high(t),
																		t.rel("=", z0(t), String.valueOf(upperbound())),
																		t.or(t.rel(">", subf.z0(t), String.valueOf(upperbound())), t.rel(">", subf.z1(t), String.valueOf(upperbound())))
																)
														)
												)
										),
										t.and(	
												t.rel("=", z1(t), "0"),
												t.X(
														t.U(
																t.rel(">", z1(t), "0"),
																t.and(
																		subf.high(t),
																		t.rel("=", z1(t), String.valueOf(upperbound())),
																		t.or(t.rel(">", subf.z0(t), String.valueOf(upperbound())), t.rel(">", subf.z1(t), String.valueOf(upperbound())))
																)
														)
												)
										)
								)	
							),
							t.and(
									orig,
									t.U(
											t.or(orig, t.rel(">", z0(t), "0")),
											t.and(
													subf.interval(t),
													t.rel("<=", z0(t), String.valueOf(upperbound()))												
											)
									)
							)
					)
			);
		
		String f2;
		f2 = t.implies(
						t.and(
								subf.high(t), 
								t.or(t.rel(">", subf.z0(t), String.valueOf(upperbound())), t.rel(">", subf.z1(t), String.valueOf(upperbound())))),
						t.or(t.rel("=", z0(t), String.valueOf(upperbound())), t.rel("=", z1(t), String.valueOf(upperbound())))
			);
		
		String f3;
		f3 = t.iff(
					low(t),
					t.and(
							subf.low(t),
							t.R(
									subf.high(t),
									t.neg(
											t.and(
													subf.high(t), 
													t.and(t.rel("<=", subf.z0(t), String.valueOf(upperbound())), t.rel("<=", subf.z1(t), String.valueOf(upperbound()))))
									)
							)
					)			
			);
		
		
		
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f1, f2, f3)));
	
	}



	@Override
	public Formula simplify() {
		return new MITLIEventually_ZerotoB((MITLIFormula)subformula.simplify(), upperbound());
	}

	
	

	
}
	


