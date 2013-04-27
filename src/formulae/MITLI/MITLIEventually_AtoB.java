package formulae.MITLI;

import java.util.ArrayList;
import java.util.List;
import delegateTranslator.CLTLTranslator;
import formulae.Formula;
import formulae.Temporized;

public class MITLIEventually_AtoB extends MITLIEventually implements Temporized{


	
	private final int a, b;	
	
	
	public MITLIEventually_AtoB(MITLIFormula subformula, int a, int b) {
		super(new String("(F " + String.valueOf(a) + " " + String.valueOf(b) + " " + subformula.strFormula() + ")"));
		this.subformula = subformula;
		this.a = a;
		this.b = b;
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
		if (l.get(0).equals(subformula)){
			subformula = (MITLIFormula)l.get(0);					
			return this;
		}
		//else rise an error. TODO: implement WrongUpdateException
		else
			return null;
	}


	@Override
	public Formula simplify() {
		return new MITLIEventually_AtoB((MITLIFormula)subformula.simplify(), a, b);
	}






	public String x(int i){
		return "x" + i + "_" + super.idFormula();
	}
	
	
	public String x(int i, CLTLTranslator t){
		return t.var(x(i));
	}


	@Override
	public String translate(CLTLTranslator t) {
		
		int l = b - a;
		
		int d = 2*(int)Math.floor(b/l + 1) + 1;  
		
		
		MITLIFormula subf = subformula;
		
		String orig = t.atom("O");
		
		
		 String[] _f1 = new String[d];
		 
    
         for (int i=0; i<d; i++){
                 _f1[i] = t.and(
                		 			t.rel("=", x(i,t), "0"),
                		 			t.X(
											t.U(
													t.rel(">", x(i,t), "0"),
													t.and(
															subf.high(t),
															t.rel("=", x(i,t), String.valueOf(b)),
															t.or(t.rel(">", subf.z0(t), String.valueOf(l)), t.rel(">", subf.z1(t), String.valueOf(l)))
													)
											)
									)
                		 	);		
         }

		
		// Formula (8)
		String f1;
		f1 = t.iff(
					high(t),
					t.or(
							t.and(
									t.neg(orig),
									t.or(_f1)								
							),
							t.and(
									orig,	
									t.U(
											t.or(t.rel(">", x(0,t), "0"), orig),
											t.and(
													subf.interval(t),
													t.or(
															t.and(t.rel(">=", x(0,t), String.valueOf(a)), t.rel("<=", x(0,t), String.valueOf(b))),
															t.and(t.rel("<", x(0,t), String.valueOf(a)), t.X(t.rel(">", x(0,t), String.valueOf(a))))
													)
											)
													
											
									)
									
							)
							
					)
			);
		

		
		
		
		String[] _f3 = new String[d];
		
		for (int i=0; i<d; i++){
			_f3[i] = t.rel("=", x(i,t), String.valueOf(b));
		}
		
		// Formula (9)
		String f3 = t.implies(
								t.and(
										subf.high(t), 
										t.or(t.rel(">", subf.z0(t), String.valueOf(l)), t.rel(">", subf.z1(t), String.valueOf(l)))
								),
								t.or(_f3)
					);
		
		
	
		String[] _f4 = new String[d];
		
		for (int i=0; i<d; i++){
			_f4[i] = t.and(
						t.rel("=", x(i,t), "0"),
						t.X(
								t.U(
										t.rel(">", x(i,t), "0"),
										t.and(
												subf.low(t),
												t.rel("=", x(i,t), String.valueOf(a)),
												t.R(
														subf.high(t),
														t.neg(t.and(
																	subf.high(t), 
																	t.and(
																		t.rel("<=", subf.z0(t), String.valueOf(l)),
																		t.rel("<=", subf.z1(t), String.valueOf(l))
																	)
																)
														)
													
												)
										)
								)
						)
					);
		}
		
		String f4;
		f4 = t.iff(
					low(t),
					t.or(
							t.and(t.neg(orig), t.or(_f4)),
							t.and(orig, t.neg(high(t)))
					)
			);
		
		
		String[] _f5 = new String[d];
		
		for (int i=0; i<d; i++){
			_f5[i] = t.rel("=", x(i,t), String.valueOf(a));
		}
		
		
		String f5 = t.implies(
								t.and(
										subf.low(t), 
										t.R(
												subf.high(t),
												t.neg(t.and(
															subf.high(t), 
															t.and(
																t.rel("<=", subf.z0(t), String.valueOf(l)),
																t.rel("<=", subf.z1(t), String.valueOf(l))
															)
														)
												)
											
										)
								),
								t.or(_f5)
					);
		
		
		
		return t.and(super.clocksEventsConstraints(t) + auxiliaryClocksConstraints(t) + t.G(t.and(f1, f3, f4, f5)));

	}
	
	private String auxiliaryClocksConstraints(CLTLTranslator t){
		
		int d = 2*(int)Math.floor(b/(b-a)+1) + 1;  
		
		
		String[] _f1 = new String[d];		
		for (int i=0; i<d; i++){
			_f1[i] = t.rel("=", x(i,t), "0");
		}
		
		//Formula (4)		
		String f1 = t.iff(
								t.or(high(t), low(t)), 
								t.or(_f1)
					);
		
	
		
		
		String[] _f2 = new String[d*d];		
		for (int i=0; i<d; i++)
			for (int j=0; j<d; j++)
				if (i != j)
					_f2[i*d+j] = t.neg( t.and( t.rel("=", x(i,t), "0"), t.rel("=", x(j,t), "0") ) );
			
		// Formuala (5)
		String f2 = t.and(_f2);
		
		
		String[] _f3 = new String[d];		
		for (int i=0; i<d; i++){	
			_f3[i] = t.implies(
								t.rel("=", x(i,t), "0"),
								t.X(
										t.R(
												t.rel("=", x((i+d-1)%d,t), "0"),
												t.rel(">", x(i,t), "0")
										)
								)
					);
										
		}
		
		// Formula (6)
		String f3 = t.and(_f3);

		
		String f4 = t.rel("=", x(0,t), "0");
		
		String[] _f5 = new String[d];		
		for (int i=0; i<d; i++){
			_f5[i] = t.rel(">=", x(i,t), "0");
		}
		
		// Positiveness of all clocks in the origin
		String f5 = t.and(_f5);
		
		return t.and(f4, f5, t.G(t.and(f1,f2,f3)));
					
	}



	@Override
	public int upperbound() {		
		return b;
	}



	@Override
	public int lowerbound() {
		return a;
	}
	
}
	


