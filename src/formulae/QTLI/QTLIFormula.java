package formulae.QTLI;

import delegateTranslator.CLTLTranslator;
import formulae.Bounds;
import formulae.Formula;
import formulae.QTLI.Counting.QTLICount;

public abstract class QTLIFormula extends Formula implements SupplingCountingClocks{

	/* Moved in the class Formula
	 * 
	public static final QTLFormula qtlTrue = new QTLTrue();
	public static final QTLFormula qtlFalse = new QTLTrue();
	*/
	
	private int maxIntComparedto = 0;
	private int nCountingClocks = 0;
	
	public QTLIFormula(String formula_p){
		super(formula_p);
		if (this.getClass() != QTLITrue.class && True == null)
			True = new QTLITrue();
		else if (this.getClass() == QTLITrue.class && True == null)
			True = this;
		if (this.getClass() != QTLIFalse.class && False == null && True != null)
			False = new QTLIFalse();
		else if (this.getClass() == QTLIFalse.class && False == null)
			False = this;
	}

		

	@Override
	public String clocksEventsConstraints(CLTLTranslator t) {
	
		String result;
		
		
		
		if ( idFormula() != isTheFormula ){
			
			if (maxIntComparedto() > 0) {
				String f1;
				f1 = t.rel("=", z0(t), "0");
				
				
				//Formula (2)
				String f2 = t.iff(
									t.or(befDnowU(t), befUnowD(t)),
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
				result = new String("");
			
		}
		else 
			result = point(t); // t.and(point(t), t.rel("=", z0(t), "0"));
					
			
		
		if (nCountingClocks == 0)
			return result;
		else
			return t.and(result, countingClocksConstraints(t));
	}
	
	

	@Override
	public void setCountingClocks(int nCountingClocks) {
		if (this.nCountingClocks < nCountingClocks)
			this.nCountingClocks = nCountingClocks;
	}


	@Override
	public int getCountingClocks() {
		return nCountingClocks ;
	}



	private String countingClocksConstraints(CLTLTranslator t) {

		// when no counting clocks are needed then simply return empty string
		if (nCountingClocks == 0)
			return new String("");
		
		//else
		int p = 0;
		
		String[] _f1 = new String[nCountingClocks];
		String[] _f2 = new String[((nCountingClocks*nCountingClocks) - nCountingClocks)/2];	
		String[] _f3 = new String[nCountingClocks];		
		String[] _f5 = new String[nCountingClocks];
		String[] _f6 = new String[nCountingClocks];
		String[] _f7 = new String[nCountingClocks];
		String[][] __f7 = new String[nCountingClocks][nCountingClocks];
		String[] _f8 = new String[nCountingClocks];
		
		for (int i=0; i<nCountingClocks; i++){
			_f1[i] = t.rel("=", z(i,t), "0");
			_f5[i] = t.rel(">=", z(i,t), "0");
			for (int j=i+1; j<nCountingClocks; j++)
					_f2[p++] = t.neg( t.and( t.rel("=", z(i,t), "0"), t.rel("=", z(j,t), "0") ) );
			_f3[i] = t.implies(
								t.rel("=", z(i,t), "0"),
								t.X(
										t.R(
												t.rel("=", z((i+nCountingClocks-1)%nCountingClocks,t), "0"),
												t.rel(">", z(i,t), "0")
										)
								)
					);
			
			for (int j=0; j<nCountingClocks; j++)
				if (j != (i+1)%nCountingClocks)
					__f7[i][j] = t.rel(">", z(j,t), "0");
			
			_f7[i] = t.implies(
					t.rel("=", z(i,t), "0"),
					t.X(
							t.R(
									t.rel("=", z((i+1)%nCountingClocks,t), "0"),
									t.and(__f7[i])									
							)
					)
			);
			_f6[i] = t.and(
							t.G(
									t.or(
											t.rel("=", t.X(z(i,t)), "0"),
											t.rel(">", t.X(z(i,t)), z(i,t)))),
							t.or(
									t.G(t.F(t.rel("=", z(i,t), "0"))), 
									t.F(t.G(t.rel(">", z(i,t), String.valueOf(maxIntComparedto()))))));
			
			if (i < nCountingClocks-1)
				_f8[i] = t.rel("<", z((nCountingClocks-i)%nCountingClocks,t), z(nCountingClocks-(i+1),t));
			
		}
		
		//Formula (4)		
		String f1 = t.iff(
								t.or(befUnowD(t), befDnowU(t)), 
								t.or(_f1)
					);

			
		// Formuala (5)
		String f2 = t.and(_f2);
		
		
		
		// Formula (6)
		String f3 = t.and(_f3);
			
		
		String f4 = t.rel("=", z(0,t), "0");
		
		
		// Positiveness of all clocks in the origin
		String f5 = t.and(_f5);
		
		String f6 = t.and(_f6);
		
		// strict sequence among clocks
		String f7 = t.and(_f7);
		
		// order of clocks at the origin
		String f8 = t.and(_f8);
		
		return t.and(f4,f6,f8,t.G(t.and(f1,f2,f7)));
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
	
	public String point(CLTLTranslator t){
		return t.atom("P_" + String.valueOf(idFormula()));	
	}
	
	public String high(CLTLTranslator t){
		return t.and( t.or(t.atom("O"), t.neg(t.Y(interval(t)))), interval(t) );	
	}
	
	public String low(CLTLTranslator t){
		//return t.and( t.or(t.atom("O"), t.neg(t.Y(t.neg(interval(t))))), t.neg(interval(t)) );
		/* Modified because of explicit origin */
		return t.and( t.or(t.atom("O"), t.Y(interval(t))), t.neg(interval(t)) );
	}
	
	public String singU(CLTLTranslator t){
		return t.and( t.Y(t.neg(interval(t))), point(t), t.neg(interval(t)), t.neg(t.atom("O")) );
	}
	
	public String singD(CLTLTranslator t){
		//return t.and( t.neg(t.Y(t.neg(interval(t)))), t.neg(point(t)), interval(t), t.neg(t.atom("O")) );
		/* Modified because of explicit origin */
		return t.and( t.Y(interval(t)), t.neg(point(t)), interval(t), t.neg(t.atom("O")) );
	}
	
	public String befUnowD(CLTLTranslator t){
		return t.or( low(t), singD(t), t.and(t.atom("O"), t.neg(point(t))) );
	}
	
	public String befDnowU(CLTLTranslator t){
		return t.or( high(t), singU(t), t.and(t.atom("O"), point(t)) );		
	}
	
	public String nowOnD(CLTLTranslator t){		
		/* Modified because of explicit origin */
		return t.and( t.or(t.Y(interval(t)), t.atom("O"), point(t)), t.neg(interval(t)) );
		
		//return t.or( low(t), singU(t) );
	}
	
	public String nowOnU(CLTLTranslator t){
		/* Modified because of explicit origin */
		return t.and( t.or(t.neg(t.Y(interval(t))), t.atom("O"), t.neg(point(t))), interval(t) );
		
		//return t.or( high(t), singU(t) );
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
	
	
	@Override
	public String z(int i) {
		return "x" + String.valueOf(i)+ "_" + String.valueOf(idFormula());	
	}

	
	public String z(int i, CLTLTranslator t){
		return t.var(z(i));	
	}
	

	// Producers method to build CLTL formulae of the argument formula 
	
	public static QTLIFormula atom(String s){
		return new QTLIAtom(s);
	}
	
	public static QTLIFormula not(QTLIFormula f){
		return new QTLINegation(f);
	}
	
	public static QTLIFormula and(QTLIFormula... formulae){
		return new QTLIConjunction(formulae);
	}
		
	
	public static QTLIFormula U(QTLIFormula f1, QTLIFormula f2){
		return new QTLIUntil(f1, f2);
	}
	
	public static QTLIFormula S(QTLIFormula f1, QTLIFormula f2){
		return new QTLISince(f1, f2);
	}
	
	private static QTLIFormula first(QTLIFormula f){
		return U(not(f), f);
	}
	
	private static QTLIFormula last(QTLIFormula f){
		return S(not(f), f);
	}
	
	// Producers method to build derived boolean CLTL formulae
	
	
	public static QTLIFormula or(QTLIFormula... formulae){
		return new QTLIDisjunction(formulae);		
	}
	
	public static QTLIFormula implies(QTLIFormula f1, QTLIFormula f2){
		return new QTLIImplies(f1, f2);
	}
	
	public static QTLIFormula iff(QTLIFormula f1, QTLIFormula f2){
		return new QTLIIff(f1, f2);
	}
	
	// Producers method to build derived temporal CLTL formulae

	public static QTLIFormula R(QTLIFormula f1, QTLIFormula f2){
		return not(U(not(f1), not(f2)));
	}
	
	public static QTLIFormula T(QTLIFormula f1, QTLIFormula f2){
		return not(S(not(f1), not(f2)));
	}	
	
	
	//Count C_n_b
	
	public static QTLIFormula count(QTLIFormula f, int b, int n){
		return new QTLICount(f, b, n);
	}
	
	
	// Eventually: F_<0,b>
	public static QTLIFormula F(QTLIFormula f, Bounds aB, int b, Bounds bB){
		if (aB==Bounds.OPEN && bB==Bounds.OPEN)					//F_(0,b)
			return new QTLIEventually(f, b);
		
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
	public static QTLIFormula P(QTLIFormula f, Bounds aB, int b, Bounds bB){
		if (aB==Bounds.OPEN && bB==Bounds.OPEN)					//F_(0,b)
			return new QTLIPast(f, b);
		
		else if (aB==Bounds.CLOSED && bB==Bounds.OPEN)			//F_[0,b)
			return or(f, P(f, Bounds.OPEN, b, bB));
		
		else if (aB==Bounds.OPEN && bB==Bounds.CLOSED)			//F_(0,b]
			return or(
						P(f,Bounds.OPEN,b,Bounds.OPEN), 
						and(last(f), G(P(f, Bounds.OPEN, b, Bounds.OPEN), Bounds.OPEN, b, Bounds.OPEN))
					);
		
		else return or(f, P(f, Bounds.OPEN, b, Bounds.CLOSED));	//F_[0,b]
			
	}
	
	// Globally: G_<0,b> NATIVE IMPLMENTATION
	public static QTLIFormula G(QTLIFormula f, Bounds aB, int b, Bounds bB){
		if (aB==Bounds.OPEN && bB==Bounds.OPEN)					//G_(0,b)
			return new QTLIGlobally(f, b);
		
		else if (aB==Bounds.CLOSED && bB==Bounds.OPEN)			//G_[0,b)
			return and(f, G(f, Bounds.OPEN, b, bB));
		
		else if (aB==Bounds.OPEN && bB==Bounds.CLOSED)			//G_(0,b]
			return and (
						G(f,Bounds.OPEN,b,Bounds.OPEN), 
						or(not(first(not(f))), F(G(f, Bounds.OPEN, b, Bounds.OPEN), Bounds.OPEN, b, Bounds.OPEN))
					);
		
		else return and(f, G(f, Bounds.OPEN, b, Bounds.CLOSED));	//G_[0,b]
			
	}
	
	// Historically: H_<0,b>
	public static QTLIFormula H(QTLIFormula f, Bounds aB, int b, Bounds bB){		
		if (aB==Bounds.OPEN && bB==Bounds.OPEN)					//H_(0,b)
			return new QTLIHistorically(f, b);
		
		else if (aB==Bounds.CLOSED && bB==Bounds.OPEN)			//H_[0,b)
			return and(f, H(f, Bounds.OPEN, b, bB));
		
		else if (aB==Bounds.OPEN && bB==Bounds.CLOSED)			//H_(0,b]
			return and (
						H(f,Bounds.OPEN,b,Bounds.OPEN), 
						or(not(last(not(f))), P(H(f, Bounds.OPEN, b, Bounds.OPEN), Bounds.OPEN, b, Bounds.OPEN))
					);
		
		else return and(f, H(f, Bounds.OPEN, b, Bounds.CLOSED));	//H_[0,b]	
	}	
	
	// Eventually: F_<a,+oo)
	public static QTLIFormula F(QTLIFormula f, int a, Bounds aB){
		
		QTLIFormula qtlTrue = (QTLIFormula)True();
		
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
	public static QTLIFormula G(QTLIFormula f, int a, Bounds aB){
		return not(F(not(f), a, aB));

	}
		
	// Past: P_<a,+oo)
	public static QTLIFormula P(QTLIFormula f, int a, Bounds aB){
		
		QTLIFormula qtlTrue = (QTLIFormula)True();
		
		if (a==0 && aB==Bounds.OPEN)				//P_(0,+oo)
			return S(qtlTrue, f);
		
		else if (a==0 && aB==Bounds.CLOSED)			//P_[0,+oo)
			return or(f, P(f, 0, Bounds.OPEN));
		
		else if (a>0 && aB==Bounds.OPEN)			//P_(a,+oo)
			return H(P(f, 0, Bounds.OPEN), Bounds.OPEN, a, Bounds.CLOSED);
		
		else										//P_[a,+oo)
			return H(P(f, 0, Bounds.CLOSED), Bounds.OPEN, a, Bounds.CLOSED);
	}
	
	// Historically: H_<a,+oo)
	public static QTLIFormula H(QTLIFormula f, int a, Bounds aB){
		return not(P(not(f), a, aB));

	}
	
	
	public static QTLIFormula F(QTLIFormula f, int a, Bounds aB, int b, Bounds bB){
		if (a == 0)
			return F(f, aB, b, bB);
		else
			return not(G(not(f), aB, b, bB));
	}
	

	public static QTLIFormula G(QTLIFormula f, int a, Bounds aB, int b, Bounds bB){
		if (a == 0)
			return G(f, aB, b, bB);
		else{		
			int d = b-a;
			QTLIFormula fm = G(f,0,aB,d,bB);
			
			int low = a;
			int upp = b;
			for (; low >= d; low = low - d, upp = upp - d)
				fm = G(F(fm,0,bB,d,aB),0,aB,d,bB);
								
			if (low > 0){
				for (int h=low; h>0; h--)
					fm = G(F(fm, 0, bB, 1, aB), 0, aB, 1, bB);			
			}
			
			return fm;		
		}
	}
	
	
	public static QTLIFormula H(QTLIFormula f, int a, Bounds aB, int b, Bounds bB){
		if (a == 0)
			return H(f, aB, b, bB);
		else{
			int d = b-a;
			QTLIFormula fm = H(f,0,aB,d,bB);
			
			int low = a;
			int upp = b;
			for (; low >= d; low = low - d, upp = upp - d)
				fm = H(P(fm,0,bB,d,aB),0,aB,d,bB);
								
			if (low > 0){
				for (int h=low; h>0; h--)
					fm = H(P(fm, 0, bB, 1, aB), 0, aB, 1, bB);			
			}
			
			return fm;
		}
	}
	
	
	public static QTLIFormula P(QTLIFormula f, int a, Bounds aB, int b, Bounds bB){
		if (a == 0)
			return P(f, aB, b, bB);
		else
			return not(H(not(f), aB, b, bB));	
	}




	
}
