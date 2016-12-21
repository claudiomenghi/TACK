package formulae.MITL;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public abstract class MITLFormula extends Formula {

	/* Moved in the class Formula
	 * 
	public static final MITLFormula qtlTrue = new MITLTrue();
	public static final MITLFormula qtlFalse = new MITLTrue();
	*/
	
	public MITLFormula(String formula_p){
		super(formula_p);
		if (this.getClass() != MITLTrue.class && True == null)
			True = new MITLTrue();
		if (this.getClass() != MITLFalse.class && False == null && True != null)
			False = new MITLFalse();
	}

		

	@Override
	public String clocksEventsConstraints(CLTLTranslator t) {
	
		//Formula (1) and initialization		
		String f1;
		if (idFormula() != isTheFormula)
			f1 = high(t);
		else 
			f1 = t.or(high(t),low(t));
		
		
		String f2;
		f2 = t.G(t.and(
						t.neg(t.and(high(t),low(t))),
						t.iff(high(t), t.rel("=",zH(t),"0")),
						t.iff(low(t), t.rel("=",zL(t),"0")),
						t.implies(high(t), t.X(t.R(low(t),t.neg(high(t))))),
						t.implies(low(t), t.X(t.R(high(t),t.neg(low(t)))))
					)
				);
		
		
	
		
		String result = t.and(f1,f2);
		
		return result;
	}
	
	public String high(CLTLTranslator t){
		return t.atom("H_" + String.valueOf(idFormula()));	
	}
	
	public String low(CLTLTranslator t){
		return t.atom("L_" + String.valueOf(idFormula()));	
	}
	
	
	public String zH(){
		return "zH_" + String.valueOf(idFormula());	
	}	
	
	public String zL(){
		return "zL_" + String.valueOf(idFormula());	
	}
	
	public String zH(CLTLTranslator t){
		return t.var(zH());	
	}	
	
	public String zL(CLTLTranslator t){
		return t.var(zL());	
	}
	

	// Producers method to build CLTL formulae of the argument formula 
	
	public static MITLFormula atom(String s){
		return new MITLAtom(s);
	}
	
	public static MITLFormula not(MITLFormula f){
		return new MITLNegation(f);
	}
	
	public static MITLFormula and(MITLFormula f1, MITLFormula f2){
		return new MITLConjunction(f1, f2);
	}
		
	
	public static MITLFormula U(MITLFormula f1, MITLFormula f2){
		return new MITLUntil(f1, f2);
	}
	
	
	
	

	
	// Eventually: F_<0,b]
	public static MITLFormula F(MITLFormula f, int b){
		return new MITLEventually_ZerotoB(f, b);
			
	}			

	// Eventually: F_<a,b]
	public static MITLFormula F(MITLFormula f, int a, int b){
		return new MITLEventually_AtoB(f, a, b);
	}
	
	// Eventually: F_<a,+oo]
	public static MITLFormula F_inf(MITLFormula f, int a){
		return new MITLEventually_AtoInf(f, a);
	}
	
	// Globally: G_<0,b]
	public static MITLFormula G(MITLFormula f, int b){
		return not(F(not(f),b));
		
	}
	
	// Globally: F_<a,b]
	public static MITLFormula G(MITLFormula f, int a, int b){
		return  not(F(not(f),a,b));
	}
	
	// Globally: F_<a,+oo]
	public static MITLFormula G_inf(MITLFormula f, int a){
		if (a > 0)
			return not(F_inf(not(f),a));
		else
			return not(U((MITLFormula)False, not(f)));
	}
	
	
	
	// Producers method to build derived boolean CLTL formulae
	
	
	public static MITLFormula or(MITLFormula f1, MITLFormula f2){
		return not(and(not(f1), not(f2)));
		
		//return new MITLDisjunction(f1,f2);		
	}
	
	public static MITLFormula implies(MITLFormula f1, MITLFormula f2){
		return or(not(f1), f2);
	}
	
	public static MITLFormula iff(MITLFormula f1, MITLFormula f2){
		return and(or(not(f1), f2), or(not(f2), f1));
	}
	
	// Producers method to build derived temporal CLTL formulae

	public static MITLFormula R(MITLFormula f1, MITLFormula f2){
		return not(U(not(f1), not(f2)));
	}
	
	
	

	
	
}
