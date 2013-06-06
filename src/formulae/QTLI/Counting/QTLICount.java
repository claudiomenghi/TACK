package formulae.QTLI.Counting;

import java.util.ArrayList;
import java.util.List;
import delegateTranslator.CLTLTranslator;
import formulae.Formula;
import formulae.Temporized;
import formulae.QTLI.QTLIFormula;

public class QTLICount extends QTLIFormula implements Temporized{

	private QTLIFormula subformula;
	private final int b;
	private int nClocks;  
	
	public QTLICount(QTLIFormula subformula, int b, int n){
		super(new String("(C " + String.valueOf(n) + String.valueOf(b) + " " + subformula.strFormula() + ")"));
		this.subformula = subformula;
		this.b = b;
		this.nClocks = n + 1;
		
		subformula.maxIntComparedto(b);
		maxIntComparedto(b);
		
		subformula.setCountingClocks(nClocks);
	}
	
	
	@Override
	public String translate(CLTLTranslator t) {
		
		// Some alias...
		QTLIFormula subf = subformula;
	
		String orig = t.atom("O");
				
		int n = nClocks-1;
		
		
		String[] f1a = new String[nClocks];
		for (int i = 0; i < nClocks; i++)
			f1a[i] = t.and(
							t.neg(point(t)),
							t.rel("=", z(i,t), "0"),
							t.or(
									up(n,n,i,"=",b, subf.singU(t),t),
									_f1a(i,t)
							)
					 );
		String _f1a = t.or(f1a);
		
		String[] __f1b = new String[n];
		for (int i = 0; i < n; i++)
			__f1b[i] = uporig(i+1,"<",b, subf.high(t),t);
		String _f1b = t.or(__f1b);
		
		String[] __f1c = new String[n];
		for (int i = 0; i < n; i++)
			__f1c[i] = uporig(i+1,"=",b, subf.high(t),t);
		String _f1c = t.or(__f1c);
		
		
		String f1;
		f1 = t.iff(
					high(t), 
					t.or(
							t.and(
									orig,
									t.or(
											t.and(
													point(t),
													t.or(
															subf.high(t),
															uporig(n, "<", upperbound(), subf.singU(t),t),
															_f1b
													)
											),
											t.and(
													t.neg(point(t)),
													t.or(
															subf.high(t),
															uporig(n, "=", upperbound(), subf.singU(t),t),
															_f1c
													)
											)
									)
							),
							t.and(
									t.neg(orig),
									_f1a
							)
					)
			);
		
		
		String[] __f2 = new String[n];
		for (int i = 0; i<n; i++) 
			__f2[i] = pastup(i,i+1,"=",b, subf.high(t),t);
		String _f2 = t.or(__f2);	
		
		
		String f2;
		f2 = t.implies(	
				t.or(
						pastup(n-1,n,"=",b, subf.singU(t),t),
						_f2						
				), 
				t.or(t.rel("=", z0(t), String.valueOf(b)), t.rel("=", z1(t), String.valueOf(b)))
		);
		


		
		String[] _f3a = new String[nClocks];
		for (int i = 0; i < nClocks; i++)
			_f3a[i] = t.implies(t.rel("=", subf.z(i,t), "0"), _f3a(i,t));
		String f3a = t.and(_f3a);
		
		String[] _f3b = new String[nClocks];
		for (int i = 0; i < nClocks; i++)
			_f3b[i] = t.implies(t.rel("=", subf.z(i,t), "0"), upSub(n-1,i,"<",b,"",t));
		String f3b = t.and(_f3b);
		
		String f3;
		f3 = t.or(
					t.and(subf.low(t), f3a),
					t.and(subf.singU(t), f3b)
			);
				
		
		
		String[] _f4a = new String[nClocks];
		for (int i = 0; i < nClocks; i++)
			_f4a[i] = t.or(t.implies(t.rel("=", subf.z(i,t), "0"), upSub(n,i,"=",b,subf.nowOnU(t),t)), _f4a(i,t));
		String f4a = t.and(_f4a);
		
		String[] _f4b = new String[nClocks];
		for (int i = 0; i < nClocks; i++)
			_f4b[i] = t.implies(t.rel("=", subf.z(i,t), "0"), upSub(n,i,"=",b,subf.nowOnU(t),t));
		String f4b = t.and(_f4b);
		
		String f4;
		f4 = t.or(
					t.and(subf.low(t), f4a),
					t.and(subf.singU(t), f4b)
			);
		
		
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f1,f2,f3,f4)));
	}
	



	private String _f3a(int i, CLTLTranslator t) {
		String[] s = new String[nClocks - 1];
		for (int k = 0; k < nClocks-2 ; k++)
			s[i] = upSub(k,i,"<=",b,"",t);
		return t.or(s);
	}
	
	private String _f4a(int i, CLTLTranslator t) {
		String[] s = new String[nClocks - 1];
		for (int k = 0; k < nClocks-2 ; k++)
			s[i] = upSub(k+1,i,"=",b,subformula.high(t),t);
		return t.or(s);
	}


	private String pastup(int n, int p, String string, int d, String e, CLTLTranslator t) {
		if(n == 0)
			return t.and(e, zetahatp("<", d, p,t));
		else
			return t.and(e, pastnspikes(n,t),zetahatp("<", d, p,t));
	}


	private String pastnspikes(int n, CLTLTranslator t) {
		
		String orig = t.atom("O");
		
		if (n == 0)
			return new String("");
		else
			return t.and(t.neg(orig), t.Y(t.S(t.neg(subformula.nowOnD(t)), t.and(subformula.singU(t), pastnspikes(n-1,t)))));
	}


	private String _f1a(int i, CLTLTranslator t) {
		
		int n = nClocks - 1;
		
		String[] s = new String[n];
		for (int j = 0; j < n; j++)
			s[j] = uporig(j+1,"=",b, subformula.high(t),t);
		return t.or(s);	
	}


	private String up(int n, int p, int j, String o, int d, String e, CLTLTranslator t) {
		
		if (n == 1)
			return t.U(zetagamma(j,">",t), t.and(e, t.rel("=", z(j,t), String.valueOf(d)), zetahatp(o,d,p,t)));
		else
			return t.U(zetagamma(j,">",t), t.and(subformula.singU(t), t.rel("<", "0", z(j,t)), t.rel("<", z(j,t), String.valueOf(d)), up(n-1,p,j,o,d,e,t)));
	}


	private String zetagamma(int j, String o, CLTLTranslator t) {
		
		String[] f = new String[nClocks+1];
		
		int i = 0;		
		for (; i < nClocks; i++)
			f[i] = t.rel(o, subformula.z(i,t), "0");
		
		f[i] = t.rel(">", z(j,t), "0");
		
		return t.and(f);
	}


	private String zetahatp(String o, int d, int p, CLTLTranslator t) {
		
		
		String[] s = new String[nClocks];
		for (int i = 0; i<nClocks; i++)
			s[i] = t.and(zetahatp1(true,i,o,p,d,t), zetahatp1(false,i,o,p,d,t));
		
		return t.or(s);
	}




	private String zetahatp1(boolean c, int i, String o, int p, int d, CLTLTranslator t) {
		
		if (c){
			String[] s = new String[p];
			for (int h = 0, j; h<p; h++){
				j = ( i + (h + 1) ) % nClocks;
				s[h] = t.rel(o, subformula.z(j, t), String.valueOf(d));
			}
			
			return t.and(s);
		}
		else{
			String[] s = new String[nClocks - p];
			for (int h = 0, j; h<(nClocks - p); h++){
				j = ( i + (h + p + 1) ) % nClocks;
				s[h] = t.neg(t.rel(o, subformula.z(j, t), String.valueOf(d)));
			}
			
			return t.and(s);
		}
	}


	private String uporig(int n, String o, int d, String e, CLTLTranslator t) {
		if (n == 1)
			return t.U(zetagamma(0,">",t), t.and(e, t.rel(o, z(0,t), String.valueOf(d))));
		else
			return t.U(zetagamma(0,">",t), t.and(subformula.singU(t), t.rel("<", "0", z(0,t)), t.rel("<", z(0,t), String.valueOf(d)), uporig(n-1,o,d,e,t)));	
	}

	
	private String upSub(int n, int j, String o, int d, String e, CLTLTranslator t){
		if (o.compareTo("=") != 0){
			if (n == 1){
				return t.X(t.U(t.neg(befDnowU(t)), t.and(e, t.rel("=", String.valueOf(d), z(j,t)))));			
			}
			else{
				return t.X(
							t.U(
								t.neg(befDnowU(t)),
								t.and(subformula.singU(t), t.rel("<", "0", z(j,t)), t.rel("<", z(j,t), String.valueOf(d)), upSub(n-1,j,o,d,e,t))
							)
						);
			}
		}
		else{
			if (n == 0){
				return t.neg(t.X(t.U(t.neg(befDnowU(t)), t.and(subformula.befDnowU(t), t.rel("<", "0", z(j,t)), t.rel("<=", z(j,t), String.valueOf(d))))));			
			}
			else{
				return t.X(
							t.U(
								t.neg(befDnowU(t)),
								t.and(subformula.singU(t), t.rel("<", "0", z(j,t)), t.rel(o, z(j,t), String.valueOf(d)), upSub(n-1,j,o,d,e,t))
							)
						);
			}
		}
			
	}
	
	
	

	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		r.add(subformula);
		
		return r;
	}
	
	
	public int upperbound(){
		return b; 
	}
	
	public int lowerbound(){
		return 0; 
	}


	@Override
	public QTLIFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		
		int m = subformula.maxIntComparedto();
		subformula = (QTLIFormula)l.get(0);	
		subformula.maxIntComparedto(m);
		return this;
	}


	@Override
	public Formula simplify() {
		return new QTLICount((QTLIFormula)subformula.simplify(), b, nClocks-1);
	}
	
}

