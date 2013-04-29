package formulae.MITLI;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public abstract class MITLIFormula extends Formula {

	/* Moved in the class Formula
	 * 
	public static final MITLFormula qtlTrue = new MITLTrue();
	public static final MITLFormula qtlFalse = new MITLTrue();
	*/
	
	private int maxIntComparedto = 0;
	
	
	public MITLIFormula(String formula_p){
		super(formula_p);
		if (this.getClass() != MITLITrue.class && True == null)
			True = new MITLITrue();
		if (this.getClass() != MITLIFalse.class && False == null && True != null)
			False = new MITLIFalse();
	}

		

	@Override
	public String clocksEventsConstraints(CLTLTranslator t) {
	
		String result;
		
		
		
		if ( (idFormula() != isTheFormula) && (maxIntComparedto() > 0) ){
			
			String f1;
			f1 = t.rel("=", z0(t), "0");
			
			
			//Formula (2)
			String f2 = t.iff(
								t.or(high(t), low(t)),
								t.or(t.rel("=", z0(t), "0"), t.rel("=", z1(t), "0"))
						);
								
			
			
			
			//formula (3)
			String f3a = t.implies(
									t.rel("=", z0(t), "0"),
									t.X(t.R(t.rel("=", z1(t), "0"), t.rel(">", z0(t), "0"))));
			
			String f3b = t.implies(
									t.rel("=", z1(t), "0"),
									t.X(t.R(t.rel("=", z0(t), "0"), t.rel(">", z1(t), "0"))));
		
			
			// Clocks progression
			String f4a = t.and(
								t.G(
										t.or(
												t.rel("=", t.X(z0(t)), "0"),
												t.rel(">", t.X(z0(t)), z0(t)))),
								t.or(
										t.G(t.F(t.rel("=", z0(t), "0"))), 
										t.F(t.G(t.rel(">", z0(t), String.valueOf(maxIntComparedto()))))));
												

			String f4b = t.and(
					t.G(
							t.or(
									t.rel("=", t.X(z1(t)), "0"),
									t.rel(">", t.X(z1(t)), z1(t)))),
					t.or(
							t.G(t.F(t.rel("=", z1(t), "0"))), 
							t.F(t.G(t.rel(">", z1(t), String.valueOf(maxIntComparedto()))))));		
			
			// Clocks non negativeness in the origin
			String f5 = t.and(
								t.rel(">=", z0(t), "0"),
								t.rel(">=", z1(t), "0"));
			
		
			
			result = t.and(f1, t.G(t.and(f2, f3a, f3b)), f4a, f4b, f5);			
			
		}
		else 
			result = high(t); // t.and(point(t), t.rel("=", z0(t), "0"));
		
		return result;
	}
	
	
	public int maxIntComparedto(){
		return maxIntComparedto;
	}
	
	public int maxIntComparedto(int c){
		if (maxIntComparedto < c)
			maxIntComparedto = c;
		
		return maxIntComparedto;
	}
	
	
	public String interval(CLTLTranslator t){
		return t.atom("H_" + String.valueOf(idFormula()));	
	}
	
	
	public String high(CLTLTranslator t){
		return t.and( t.or(t.atom("O"), t.neg(t.Y(interval(t)))), interval(t) );	
	}
	
	public String low(CLTLTranslator t){
		return t.and( t.or(t.atom("O"), t.neg(t.Y(t.neg(interval(t))))), t.neg(interval(t)) );	
	}
	
	
	public String z0(){
		return "z0_" + String.valueOf(idFormula());	
	}	
	
	public String z1(){
		return "z1_" + String.valueOf(idFormula());	
	}
	
	public String z0(CLTLTranslator t){
		return t.var(z0());	
	}	
	
	public String z1(CLTLTranslator t){
		return t.var(z1());	
	}
	

	// Producers method to build CLTL formulae of the argument formula 
	
	public static MITLIFormula atom(String s){
		return new MITLIAtom(s);
	}
	
	public static MITLIFormula not(MITLIFormula f){
		return new MITLINegation(f);
	}
	
	public static MITLIFormula and(MITLIFormula... formulae){
		return new MITLIConjunction(formulae);
	}
		
	
	public static MITLIFormula U(MITLIFormula f1, MITLIFormula f2){
		return new MITLIUntil(f1, f2);
	}
	
	
	
	

	
	// Eventually: F_<0,b]
	public static MITLIFormula F(MITLIFormula f, int b){
		return new MITLIEventually_ZerotoB(f, b);
			
	}			

	// Eventually: F_<a,b]
	public static MITLIFormula F(MITLIFormula f, int a, int b){
		if (a == 0)
			return F(f, b);
		else
			return new MITLIEventually_AtoB(f, a, b);
	}
	
	// Eventually: F_<a,+oo]
	public static MITLIFormula F_inf(MITLIFormula f, int a){
		return new MITLIEventually_AtoInf(f, a);
	}
	
	// Globally: G_<0,b]
	public static MITLIFormula G(MITLIFormula f, int b){
		return new MITLIGlobally_ZerotoB(f, b);		
	}
	
	// Globally: G_<a,b]
	public static MITLIFormula G(MITLIFormula f, int a, int b){
		if (a == 0)
			return G(f, b);
		else
			return new MITLIGlobally_AtoB(f, a, b);
	}
	
	// Globally: G_<a,+oo]
	public static MITLIFormula G_inf(MITLIFormula f, int a){
		if (a > 0)
			return not(F_inf(not(f),a));
		else
			return not(U((MITLIFormula)False, not(f)));
	}
	
	
	
	// Producers method to build derived boolean CLTL formulae
	
	
	public static MITLIFormula or(MITLIFormula... formulae){
		return new MITLIDisjunction(formulae);		
	}
	
	public static MITLIFormula implies(MITLIFormula f1, MITLIFormula f2){
		return new MITLIImplies(f1,f2);
	}
	
	public static MITLIFormula iff(MITLIFormula f1, MITLIFormula f2){
		return new MITLIIff(f1,f2);
	}
	
	// Producers method to build derived temporal CLTL formulae

	public static MITLIFormula R(MITLIFormula f1, MITLIFormula f2){
		return not(U(not(f1), not(f2)));
	}
	
	
	

	
	
}
