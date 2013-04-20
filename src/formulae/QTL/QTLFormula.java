package formulae.QTL;

import delegateTranslator.CLTLTranslator;
import formulae.Bounds;
import formulae.Formula;

public abstract class QTLFormula extends Formula {

	/* Moved in the class Formula
	 * 
	public static final QTLFormula qtlTrue = new QTLTrue();
	public static final QTLFormula qtlFalse = new QTLTrue();
	*/
	
	public QTLFormula(String formula_p){
		super(formula_p);
		if (this.getClass() != QTLTrue.class && True == null)
			True = new QTLTrue();
		if (this.getClass() != QTLFalse.class && False == null && True != null)
			False = new QTLFalse();
	}

		

	@Override
	public String clocksEventsConstraints(CLTLTranslator t) {
	
		//Formula (1) and initialization		
		String f1;
		if (idFormula() != isTheFormula)
			f1 = t.and(t.or(high(t), low(t)), t.rel("=", z0(t), "0"));
		else 
			f1 = t.or(
						t.and(high(t), lC(t), t.rel("=", z0(t), "0")),
						t.and(low(t), lO(t), t.rel("=", z0(t), "0"))
				 );	
		
		
		//Formula (2)
		String f2 = t.and(
							t.neg(t.and(high(t), low(t))),
							t.neg(t.and(singU(t), singD(t))),
							t.neg(t.and(t.or(singU(t),singD(t)),
									 	t.or(high(t),low(t)))),
							t.neg(t.and(lC(t),lO(t))));
							
		
		//Formula (3)
		String f3 = t.iff(t.or(high(t),low(t)),
						  t.or(lC(t),lO(t))); 
		
		String nowOnU = t.or(high(t), singD(t));
		String befDnowU = t.or(high(t), singU(t));
		String nowOnD = t.or(low(t), singU(t));
		String befUnowD = t.or(low(t), singD(t));
		
		//Formula (4)
		String f4 = t.and(
							t.implies(nowOnU, t.X(t.R(low(t), t.neg(befDnowU)))),
							t.implies(nowOnD, t.X(t.R(high(t), t.neg(befUnowD)))));
		
		//Formula (5)
		String f5 = t.iff(
							t.or(befDnowU, befUnowD), 
							t.or(t.rel("=", z0(t), "0"), t.rel("=", z1(t), "0")));
		
		//formula (6)
		String f6a = t.implies(
								t.rel("=", z0(t), "0"),
								t.X(t.R(t.rel("=", z1(t), "0"), t.rel(">", z0(t), "0"))));
		
		String f6b = t.implies(
								t.rel("=", z1(t), "0"),
								t.X(t.R(t.rel("=", z0(t), "0"), t.rel(">", z1(t), "0"))));
	
		
		// Clocks progression
		String f7a = t.and(
							t.G(
									t.or(
											t.rel("=", t.X(z0(t)), "0"),
											t.rel(">", t.X(z0(t)), z0(t)))),
							t.or(
									t.G(t.F(t.rel("=", z0(t), "0"))), 
									t.F(t.G(t.rel(">", z0(t), String.valueOf(Formula.maxbound))))));
											

		String f7b = t.and(
				t.G(
						t.or(
								t.rel("=", t.X(z1(t)), "0"),
								t.rel(">", t.X(z1(t)), z1(t)))),
				t.or(
						t.G(t.F(t.rel("=", z1(t), "0"))), 
						t.F(t.G(t.rel(">", z1(t), String.valueOf(Formula.maxbound))))));		
		
		// Clocks non negativeness in the origin
		String f8 = t.and(
							t.rel(">=", z0(t), "0"),
							t.rel(">=", z1(t), "0"));
		
	
		
		String result = t.and(f1, t.G(t.and(f2, f3, f4, f5, f6a, f6b)), f7a, f7b, f8);
		
		return result;
	}
	
	public String high(CLTLTranslator t){
		return t.atom("H_" + String.valueOf(idFormula()));	
	}
	
	public String low(CLTLTranslator t){
		return t.atom("L_" + String.valueOf(idFormula()));	
	}
	
	public String singU(CLTLTranslator t){
		return t.atom("sup_" + String.valueOf(idFormula()));	
	}
	
	public String singD(CLTLTranslator t){
		return t.atom("sdw_" + String.valueOf(idFormula()));	
	}
	
	public String lO(CLTLTranslator t){
		return t.atom("lO_" + String.valueOf(idFormula()));	
	}
	
	public String lC(CLTLTranslator t){
		return t.atom("lC_" + String.valueOf(idFormula()));	
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
	
	public static QTLFormula atom(String s){
		return new QTLAtom(s);
	}
	
	public static QTLFormula not(QTLFormula f){
		return new QTLNegation(f);
	}
	
	public static QTLFormula and(QTLFormula f1, QTLFormula f2){
		return new QTLConjunction(f1, f2);
	}
		
	
	public static QTLFormula U(QTLFormula f1, QTLFormula f2){
		return new QTLUntil(f1, f2);
	}
	
	public static QTLFormula S(QTLFormula f1, QTLFormula f2){
		return new QTLSince(f1, f2);
	}
	
	private static QTLFormula first(QTLFormula f){
		return U(not(f), f);
	}
	
	private static QTLFormula last(QTLFormula f){
		return S(not(f), f);
	}
	

	
	// Eventually: F_<0,b>
	public static QTLFormula F(QTLFormula f, Bounds aB, int b, Bounds bB){
		if (aB==Bounds.OPEN && bB==Bounds.OPEN)					//F_(0,b)
			return new QTLEventually(f, b);
		
		else if (aB==Bounds.CLOSED && bB==Bounds.OPEN)			//F_[0,b)
			return or(f, F(f, Bounds.OPEN, b, bB));
		
		else if (aB==Bounds.OPEN && bB==Bounds.CLOSED)			//F_(0,b]
			return or(
						F(f,Bounds.OPEN,b,Bounds.OPEN), 
						and(first(f), G(F(f, Bounds.OPEN, b, Bounds.OPEN), Bounds.OPEN, b, Bounds.OPEN))
					);
		
		else return or(f, F(f, Bounds.OPEN, b, Bounds.CLOSED));	//F_[0,b]
			
	}
	
	
	// Past: P_<0,b>
	public static QTLFormula P(QTLFormula f, Bounds aB, int b, Bounds bB){
		if (aB==Bounds.OPEN && bB==Bounds.OPEN)					//F_(0,b)
			return new QTLPast(f, b);
		
		else if (aB==Bounds.CLOSED && bB==Bounds.OPEN)			//F_[0,b)
			return or(f, F(f, Bounds.OPEN, b, bB));
		
		else if (aB==Bounds.OPEN && bB==Bounds.CLOSED)			//F_(0,b]
			return or(
						P(f,Bounds.OPEN,b,Bounds.OPEN), 
						and(last(f), G(P(f, Bounds.OPEN, b, Bounds.OPEN), Bounds.OPEN, b, Bounds.OPEN))
					);
		
		else return or(f, P(f, Bounds.OPEN, b, Bounds.CLOSED));	//F_[0,b]
			
	}
	
	
	// Producers method to build derived boolean CLTL formulae
	
	
	public static QTLFormula or(QTLFormula f1, QTLFormula f2){
		//return not(and(not(f1), not(f2)));
		
		return new QTLDisjunction(f1,f2);		
	}
	
	public static QTLFormula implies(QTLFormula f1, QTLFormula f2){
		return or(not(f1), f2);
	}
	
	public static QTLFormula iff(QTLFormula f1, QTLFormula f2){
		return and(or(not(f1), f2), or(not(f2), f1));
	}
	
	// Producers method to build derived temporal CLTL formulae

	public static QTLFormula R(QTLFormula f1, QTLFormula f2){
		return not(U(not(f1), not(f2)));
	}
	
	public static QTLFormula T(QTLFormula f1, QTLFormula f2){
		return not(S(not(f1), not(f2)));
	}		
	
	
	/*
	// Globally: G_(0,b>
	public static QTLFormula G(QTLFormula f, Bounds aB, int b, Bounds bB){
		if (aB==Bounds.OPEN)					//G_(0,b) or G_(0,b]
			return not(F(not(f), aB, b, bB));
		
		else 									//G_[0,b) or G_[0,b]
			return or(f, G(f, Bounds.OPEN, b, bB));
		
	}
	*/
	
	// Globally: G_<0,b> NATIVE IMPLMENTATION
	public static QTLFormula G(QTLFormula f, Bounds aB, int b, Bounds bB){
		if (aB==Bounds.OPEN && bB==Bounds.OPEN)					//G_(0,b)
			return new QTLGlobally(f, b);
		
		else if (aB==Bounds.CLOSED && bB==Bounds.OPEN)			//G_[0,b)
			return and(f, G(f, Bounds.OPEN, b, bB));
		
		else if (aB==Bounds.OPEN && bB==Bounds.CLOSED)			//G_(0,b]
			return and (
						G(f,Bounds.OPEN,b,Bounds.OPEN), 
						G(F(f, Bounds.OPEN, b, Bounds.OPEN), Bounds.OPEN, b, Bounds.OPEN)
					);
		
		else return and(f, G(f, Bounds.OPEN, b, Bounds.CLOSED));	//G_[0,b]
			
	}
	
	
	
	// Historically: H_(0,b>
	public static QTLFormula H(QTLFormula f, Bounds aB, int b, Bounds bB){
		if (aB==Bounds.OPEN)					//G_(0,b) or G_(0,b]
			return not(P(not(f), aB, b, bB));
		
		else 									//G_[0,b) or G_[0,b]
			return or(f, H(f, Bounds.OPEN, b, bB));
		
	}	
	
	// Eventually: F_<a,+oo)
	public static QTLFormula F(QTLFormula f, int a, Bounds aB){
		
		QTLFormula qtlTrue = (QTLFormula)True();
		
		if (a==0 && aB==Bounds.OPEN)				//F_(0,+oo)
			return U(qtlTrue, f);
		
		else if (a==0 && aB==Bounds.CLOSED)			//F_[0,+oo)
			return or(f, F(f, 0, Bounds.OPEN));
		
		else if (a>0 && aB==Bounds.OPEN)			//F_(a,+oo)
			return G(F(f, 0, Bounds.OPEN), Bounds.OPEN, a, Bounds.CLOSED);
		
		else										//F_[a,+oo)
			return G(F(f, 0, Bounds.CLOSED), Bounds.OPEN, a, Bounds.CLOSED);
	}
	
	
	// Globally: G_<a,+oo)
	public static QTLFormula G(QTLFormula f, int a, Bounds aB){
		return not(F(not(f), a, aB));

	}
		
	// Past: P_<a,+oo)
	public static QTLFormula P(QTLFormula f, int a, Bounds aB){
		
		QTLFormula qtlTrue = (QTLFormula)True();
		
		if (a==0 && aB==Bounds.OPEN)				//P_(0,+oo)
			return S(qtlTrue, f);
		
		else if (a==0 && aB==Bounds.CLOSED)			//P_[0,+oo)
			return or(f, P(f, 0, Bounds.OPEN));
		
		else if (a>0 && aB==Bounds.OPEN)			//P_(a,+oo)
			return G(P(f, 0, Bounds.OPEN), Bounds.OPEN, a, Bounds.CLOSED);
		
		else										//P_[a,+oo)
			return G(P(f, 0, Bounds.CLOSED), Bounds.OPEN, a, Bounds.CLOSED);
	}
	
	// Historically: H_<a,+oo)
	public static QTLFormula H(QTLFormula f, int a, Bounds aB){
		return not(P(not(f), a, aB));

	}
	
	
	public static QTLFormula F(QTLFormula f, int a, Bounds aB, int b, Bounds bB){
		if (a == 0)
			return F(f, aB, b, bB);
		else{
			QTLFormula result = F(G(F(f,0,Bounds.OPEN,a,Bounds.OPEN),0,Bounds.OPEN,a,Bounds.OPEN),0,aB,1,Bounds.OPEN);
			for (int i=a+1; i<b-1; i++)
				result = or(result, F(G(F(f,0,Bounds.OPEN,i,Bounds.OPEN),0,Bounds.OPEN,i,Bounds.OPEN),0,Bounds.CLOSED,1,Bounds.OPEN));
			if (a < b-1)
				result = or(result, F(G(F(f,0,Bounds.OPEN,b-1,Bounds.OPEN),0,Bounds.OPEN,b-1,Bounds.OPEN),0,Bounds.CLOSED,1,bB));
			
			return result;
		}
	}
	

	public static QTLFormula G(QTLFormula f, int a, Bounds aB, int b, Bounds bB){
		//return not(F(not(f), a, aB, b, bB));
		
		/* Following implementation uses native encoding for Globally*/
		
		if (a == 0)
			return G(f, aB, b, bB);
		else{
			QTLFormula result = G(F(G(f,0,Bounds.OPEN,a,Bounds.OPEN),0,Bounds.OPEN,a,Bounds.OPEN),0,aB,1,Bounds.OPEN);
			for (int i=a+1; i<b-1; i++)
				result = and(result, G(F(G(f,0,Bounds.OPEN,i,Bounds.OPEN),0,Bounds.OPEN,i,Bounds.OPEN),0,Bounds.CLOSED,1,Bounds.OPEN));
			if (a < b-1)
				result = and(result, G(F(G(f,0,Bounds.OPEN,b-1,Bounds.OPEN),0,Bounds.OPEN,b-1,Bounds.OPEN),0,Bounds.CLOSED,1,bB));
			
			return result;
		}
		
	}
}
