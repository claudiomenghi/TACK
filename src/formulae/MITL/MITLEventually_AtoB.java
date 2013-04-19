package formulae.MITL;

import java.util.ArrayList;
import java.util.List;
import delegateTranslator.CLTLTranslator;
import formulae.Formula;
import formulae.Temporized;

public class MITLEventually_AtoB extends MITLEventually implements Temporized{


	
	private final int a, b;	
	
	
	public MITLEventually_AtoB(MITLFormula subformula, int a, int b) {
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
		return new MITLEventually_AtoB((MITLFormula)subformula.simplify(), a, b);
	}






	public String x(int i){
		return "x" + i + "_" + super.idFormula();
	}
	
	public String y(int i){
		return "y" + i + "_" + super.idFormula();
	}
	
	public String x(int i, CLTLTranslator t){
		return t.var(x(i));
	}
	
	public String y(int i, CLTLTranslator t){
		return t.var(y(i));
	}

	@Override
	public String translate(CLTLTranslator t) {
		
		int l = b - a;
		
		MITLFormula subf = subformula;
		
		String orig = t.atom("O");
		
		String f1;
		f1 = t.iff(
					t.rel("=", x(0,t), "0"),
					t.or(
							t.and(
									t.neg(orig),
									t.X(
											t.U(
													t.rel(">", x(0,t), "0"),
													t.and(
															subf.high(t),
															t.rel("=", x(0,t), String.valueOf(b)),
															t.rel(">", subf.zH(t), String.valueOf(l))
													)
											)
									)
							),
							t.and(
									orig,
									t.X(
											t.U(
													t.rel(">", x(0,t), "0"),
													t.or(
															t.and(
																	t.or(subf.high(t),subf.low(t)),
																	t.and(
																			t.rel(">", x(0,t), String.valueOf(a)),
																			t.rel("<=", x(0,t), String.valueOf(b))
																	)
															),
															t.and(
																	t.S(t.neg(subf.low(t)), subf.high(t)),
																	t.rel("=", x(0,t), String.valueOf(a))
															)
													)
											)
									)
							)
							
					)
			);
		
		int d = (int)Math.floor(b/(b-a)+1) + 1;  
		String[] _f2 = new String[d-1];
		
		for (int i=1; i<d; i++){
			_f2[i-1] = t.iff(
						t.rel("=", x(i,t), "0"),
						t.X(
								t.U(
										t.rel(">", x(i,t), "0"),
										t.and(
												subf.high(t),
												t.rel("=", x(i,t), String.valueOf(b)),
												t.rel(">", subf.zL(t), String.valueOf(l))
										)
								)
						)
					);
		}
		
		String f2 = t.and(_f2);
		
		
		
		String[] _f3 = new String[d];
		
		for (int i=0; i<d; i++){
			_f3[i] = t.rel("=", x(i,t), String.valueOf(b));
		}
		
		
		String f3 = t.implies(
								t.and(subf.high(t), t.rel(">", subf.zL(t), String.valueOf(l))),
								t.or(_f3)
					);
		
		
	
		String[] _f4 = new String[d];
		
		for (int i=0; i<d; i++){
			_f4[i] = t.iff(
						t.rel("=", y(i,t), "0"),
						t.X(
								t.U(
										t.rel(">", y(i,t), "0"),
										t.and(
												subf.low(t),
												t.rel("=", y(i,t), String.valueOf(a)),
												t.neg(
														t.U(
																t.neg(subf.high(t)),
																t.and(subf.high(t), t.rel("<=", subf.zL(t), String.valueOf(l)))
														)
												)
										)
								)
						)
					);
		}
		
		String f4 = t.and(_f4);
		
		
		String[] _f5 = new String[d];
		
		for (int i=0; i<d; i++){
			_f5[i] = t.rel("=", y(i,t), String.valueOf(a));
		}
		
		
		String f5 = t.implies(
								t.and(
										subf.low(t), 
										t.neg(
												t.U(
														t.neg(subf.high(t)),
														t.and(subf.high(t), t.rel("<=", subf.zL(t), String.valueOf(l)))
												)
										)
								),
								t.or(_f5)
					);
		
		
		
		return t.and(super.clocksEventsConstraints(t) + auxiliaryClocksConstraints(t) + t.G(t.and(f1, f2, f3, f4, f5)));

	}
	
	private String auxiliaryClocksConstraints(CLTLTranslator t){
		
		int d = (int)Math.floor(b/(b-a)+1) + 1;  
		
		
		String[] _f1 = new String[d];		
		for (int i=0; i<d; i++){
			_f1[i] = t.rel("=", x(i,t), "0");
		}
		
		String f1 = t.implies(high(t), t.or(_f1));
		
		
		String[] _f2 = new String[d];		
		for (int i=0; i<d; i++){
			_f2[i] = t.rel("=", y(i,t), "0");
		}
		
		String f2 = t.implies(low(t), t.or(_f2));	
		
		
		String[] _f3 = new String[d*d];		
		for (int i=0; i<d; i++)
			for (int j=0; j<d; j++)
				if (i != j)
					_f3[i*d+j] = t.and(
									t.neg( t.and( t.rel("=", x(i,t), "0"), t.rel("=", x(j,t), "0") ) ),
									t.neg( t.and( t.rel("=", y(i,t), "0"), t.rel("=", y(j,t), "0") ) )
							);
		String f3 = t.and(_f3);
		
		
		String[] _f4 = new String[d];		
		for (int i=0; i<d; i++){
			
			String[] _f4_x =  new String[d];
			String[] _f4_y =  new String[d];
			
			for (int j=0; j<d; j++){
				if (j != i)
					_f4_x[j] = t.rel("=", y(j,t), "0");
			}
			String f4_x = t.and(_f4_x);
			
			for (int j=0; j<d; j++){
				if (j != (i+1) % d)
					_f4_y[j] = t.rel("=", x(j,t), "0");

			}
			String f4_y = t.and(_f4_y);
			
			
			_f4[i] = t.and(
								t.implies(
										t.rel("=", x(i,t), "0"),
										t.R(
												t.rel("=", y(i,t), "0"),
												f4_x
										)
								),
								t.implies(
										t.rel("=", y(i,t), "0"),
										t.R(
												t.rel("=", x((i+1) % d,t), "0"),
												f4_y
										)
								)
					);
										
		}
		
		String f4 = t.and(_f4);
		
		
		String[] _f5 = new String[d];		
		for (int i=0; i<d; i++){
			
			_f5[i] = t.and(
								t.implies(
										t.rel("=", x(i,t), "0"),
										t.X(
												t.R(
														t.rel("=", y((i+d-1)%d,t), "0"),
														t.rel(">", x(i,t), "0")
												)
										)
								),
								t.implies(
										t.rel("=", y(i,t), "0"),
										t.X(
												t.R(
														t.rel("=", x((i)%d,t), "0"),
														t.rel(">", y(i,t), "0")
												)
										)
								)
								
					);
										
		}
		
		String f5 = t.and(_f5);
		
		
		String f6 = t.iff( t.rel("=", y(0,t), "0"), t.neg(t.rel("=", x(0,t), "0")) );
		
		return t.and(f6, t.G(t.and(f1,f2,f3,f4,f5)));
					
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
	


