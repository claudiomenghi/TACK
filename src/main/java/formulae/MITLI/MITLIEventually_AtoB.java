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
		
		subformula.maxIntComparedto(b-a);
	}



	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<>();
		
		r.add(subformula);
		
		return r;
	}
	
	

	@Override
	public MITLIFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		
		int m = subformula.maxIntComparedto();
		subformula = (MITLIFormula)l.get(0);	
		subformula.maxIntComparedto(m);
		return this;
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
		
		int d = 2*(int)Math.ceil( (float)b/(b-a) );  
		
		
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
																	t.rel("<=", x(i,t), String.valueOf(upperbound()))			
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
		
		int d = 2*(int)Math.ceil( (float)b/(b-a) );  
		int p = 0;
		
		String[] _f1 = new String[d];
		String[] _f2 = new String[((d*d) - d)/2];	
		String[] _f3 = new String[d];		
		String[] _f5 = new String[d];
		String[] _f6 = new String[d];
		String[] _f7 = new String[d];
		String[][] __f7 = new String[d][d];
		String[] _f8 = new String[d];
		
		for (int i=0; i<d; i++){
			_f1[i] = t.rel("=", x(i,t), "0");
			_f5[i] = t.rel(">=", x(i,t), "0");
			for (int j=i+1; j<d; j++)
					_f2[p++] = t.neg( t.and( t.rel("=", x(i,t), "0"), t.rel("=", x(j,t), "0") ) );
			_f3[i] = t.implies(
								t.rel("=", x(i,t), "0"),
								t.X(
										t.R(
												t.rel("=", x((i+d-1)%d,t), "0"),
												t.rel(">", x(i,t), "0")
										)
								)
					);
			
			for (int j=0; j<d; j++)
				if (j != (i+1)%d)
					__f7[i][j] = t.rel(">", x(j,t), "0");
			
			_f7[i] = t.implies(
					t.rel("=", x(i,t), "0"),
					t.X(
							t.R(
									t.rel("=", x((i+1)%d,t), "0"),
									t.and(__f7[i])									
							)
					)
			);
			_f6[i] = t.and(
							t.G(
									t.or(
											t.rel("=", t.X(x(i,t)), "0"),
											t.rel(">", t.X(x(i,t)), x(i,t)))),
							t.or(
									t.G(t.F(t.rel("=", x(i,t), "0"))), 
									t.F(t.G(t.rel(">", x(i,t), String.valueOf(upperbound()))))));
			
			if (i < d-1)
				_f8[i] = t.rel("<", x((d-i)%d,t), x(d-(i+1),t));
			
		}
		
		//Formula (4)		
		String f1 = t.iff(
								t.or(high(t), low(t)), 
								t.or(_f1)
					);

			
		// Formuala (5)
		String f2 = t.and(_f2);
		
		
		
		// Formula (6)
		String f3 = t.and(_f3);
			
		
		String f4 = t.rel("=", x(0,t), "0");
		
		
		// Positiveness of all clocks in the origin
		String f5 = t.and(_f5);
		
		String f6 = t.and(_f6);
		
		// strict sequence among clocks
		String f7 = t.and(_f7);
		
		// order of clocks at the origin
		String f8 = t.and(_f8);
		
		return t.and(f4,f6,f8,t.G(t.and(f1,f2,f7)));
					
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
	


