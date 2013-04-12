package formulae;

import java.util.ArrayList;
import java.util.List;
import delegateTranslator.CLTLTranslator;

public class QTLGlobally extends QTLFormula {

	private QTLFormula subformula;
	private final int b;  
	
	public QTLGlobally(QTLFormula subformula, int b){
		super(new String("(G " + String.valueOf(b) + " " + subformula.strFormula() + ")"));
		this.subformula = subformula;
		this.b = b;
	}
	
	
	@Override
	public String translate(CLTLTranslator t) {
		
		// Some alias...
		QTLFormula subf = subformula;
			
		//p1 is \gamma
		String nowOnU_f1 = t.or(subf.high(t), subf.singD(t));
				
		String befUnowD_f1 = t.or(subf.low(t), subf.singD(t)); 

		
		String orig = t.atom("O");
				
		
		// Formula (14) - (37) 
		
		String f1 = t.and(
							t.neg(singD(t)), 
							t.implies(high(t), lC(t)),
							t.implies(t.and(t.neg(orig), low(t)), lO(t))
					);
		
		
		// formula (15) - (38)
		
		String f2 = t.iff(
							low(t),
							t.or(
								t.and(
									t.neg(orig),
									t.or(
											t.and(
												lO(t), t.rel("=", z0(t), "0"),
												t.X(
														t.U(
																t.and(t.rel(">", z0(t), "0"), t.neg(befUnowD_f1)), 
																t.and(
																		befUnowD_f1,
																		t.rel("=", z0(t), String.valueOf(b)),
																		t.or(t.rel(">", subf.z0(t), String.valueOf(b)), t.rel(">", subf.z1(t), String.valueOf(b)))
																	)
															)
													)
											),
											t.and(
													lO(t), t.rel("=", z1(t), "0"),
													t.X(
															t.U(
																	t.and(t.rel(">", z1(t), "0"), t.neg(befUnowD_f1)), 
																	t.and(
																			befUnowD_f1,
																			t.rel("=", z1(t), String.valueOf(b)),
																			t.or(t.rel(">", subf.z0(t), String.valueOf(b)), t.rel(">", subf.z1(t), String.valueOf(b)))
																		)
																)
														)
											)
										)
									),
									t.and(
										orig,
										t.or(
											t.and(
												lC(t),
												t.or(
														subf.low(t),
														t.X(
																t.U(
																		t.rel(">", z0(t), "0"),
																		t.and(
																				befUnowD_f1,
																				t.rel(">", z0(t), "0"),
																				t.rel("<", z0(t), String.valueOf(b))
																		)
																)
														)
												)
											),
											t.and(
												lO(t),
												nowOnU_f1,
												t.X(
														t.U(
																t.and(t.rel(">", z0(t), "0"), t.neg(befUnowD_f1)),
																t.and(
																		befUnowD_f1,
																		t.rel("=", z0(t), String.valueOf(b))													
																)
														)
												)
											)
										)
								)
						)
				);
				
		
		// formula (16) - (38a)
		
		String f5 = t.implies(	
								t.and(
										befUnowD_f1,
										t.or(t.rel(">=", subf.z0(t), String.valueOf(b)), t.rel(">=", subf.z1(t), String.valueOf(b)))
								), 
								t.or(t.rel("=", z0(t), String.valueOf(b)), t.rel("=", z1(t), String.valueOf(b)))
					);
											
		// Formula (39)
		
		String f3 = t.iff(
							high(t),
							t.and(
									nowOnU_f1,
									t.neg(
											t.X(
													t.U(
															t.neg(befUnowD_f1),
															t.and(
																	befUnowD_f1,
																	t.or(
																			t.and(
																					t.rel(">", subf.z0(t), "0"),
																					t.rel("<=", subf.z0(t), String.valueOf(b))
																			),
																			t.and(
																					t.rel(">", subf.z1(t), "0"),
																					t.rel("<=", subf.z1(t), String.valueOf(b))
																			)
																	)
															)
													)
											)
									)
							)
						);
		
		
		// Formula (40)
		
		String f4 = t.iff(
							singU(t),
							t.and(
									nowOnU_f1,
									t.X(
											t.U(
													t.neg(befUnowD_f1),
													t.and(
															befUnowD_f1,
															t.or(
																	t.rel("=", subf.z0(t), String.valueOf(b)),
																	t.rel("=", subf.z1(t), String.valueOf(b))	
															)
													)
											)
									),
									t.neg(orig)
							)
						);
											
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f1,f2,f3,f4,f5)));
	}
	



	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		r.add(subformula);
		
		return r;
	}
	
	
	public int getBound(){
		return b; 
	}


	@Override
	public QTLFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		if (l.get(0).equals(subformula)){
			subformula = (QTLFormula)l.get(0);					
			return this;
		}
		//else rise an error. TODO: implement WrongUpdateException
		else
			return null;
	}


	@Override
	public Formula simplify() {
		return new QTLGlobally((QTLFormula)subformula.simplify(), b);
	}
	
}

