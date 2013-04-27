package formulae.MITLI;

import java.util.List;
import delegateTranslator.CLTLTranslator;
import formulae.Formula;


public class MITLIGlobally_ZerotoB extends MITLIGlobally_AtoB{
	
	
	public MITLIGlobally_ZerotoB(MITLIFormula subformula, int b) {
		super(subformula, 0, b);
	}



	@Override
	public String translate(CLTLTranslator t) {
		
		String orig = new String("O");
		
		List<Formula> subfs = this.subformulae();
		MITLIFormula subf = (MITLIFormula)subfs.get(0);
		
		String f1;
		f1 = t.iff(
					low(t),
					t.or(
						t.and(
								t.neg(orig),
								subf.interval(t),
								t.or(
										t.and(	
												t.rel("=", z0(t), "0"),
												t.X(
														t.U(
																t.rel(">", z0(t), "0"),
																t.and(
																		subf.low(t),
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
																		subf.low(t),
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
													t.neg(subf.interval(t)),
													t.rel("<=", z0(t), String.valueOf(upperbound()))												
											)
									)
							)
					)
			);
		
		String f2;
		f2 = t.implies(
						t.and(
								subf.low(t), 
								t.or(t.rel(">", subf.z0(t), String.valueOf(upperbound())), t.rel(">", subf.z1(t), String.valueOf(upperbound())))),
						t.or(t.rel("=", z0(t), String.valueOf(upperbound())), t.rel("=", z1(t), String.valueOf(upperbound())))
			);
		
		String f3;
		f3 = t.iff(
					high(t),
					t.and(
							subf.high(t),
							t.R(
									subf.low(t),
									t.neg(
											t.and(
													subf.low(t), 
													t.and(t.rel("<=", subf.z0(t), String.valueOf(upperbound())), t.rel("<=", subf.z1(t), String.valueOf(upperbound()))))
									)
							)
					)			
			);
		
		
		
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f1, f2, f3)));
	
	}



	
	
	

	
}
	


