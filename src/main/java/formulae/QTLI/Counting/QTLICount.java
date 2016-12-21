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
		super(new String("(C " + String.valueOf(n) + " " + String.valueOf(b) + " " + subformula.strFormula() + ")"));
		this.subformula = subformula;
		this.b = b;
		this.nClocks = n + 1;
		
		subformula.maxIntComparedto(b);
		maxIntComparedto(b);
		
		
		setCountingClocks(nClocks);
		subformula.setCountingClocks(nClocks);
	}
	
	
	@Override
	public String translate(CLTLTranslator t) {
		
		// Some alias...
		QTLIFormula subf = subformula;
	
		String orig = t.atom("O");
				
		int n = nClocks-1;
		
		
		String f0 = t.implies(point(t), t.and(interval(t), t.or( t.Y(interval(t)), orig) ) );
		
		String[] f1a = new String[nClocks];
		for (int i = 0; i < nClocks; i++)
			f1a[i] = t.and(
							t.neg(point(t)),
							t.rel("=", z(i,t), "0"),
							t.or(
									t.and(
											up(n,n,i,"=",b, subf.singU(t),t),
											t.neg(subformula.singU(t))
									),
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
		
		String[] __f2b = new String[n+1];
		for (int i = 0; i <= nClocks-1; i++) 
			__f2b[i] = t.rel("=", z(i,t), String.valueOf(b));
		String _f2b = t.or(__f2b);	
		
		
		String f2;
		f2 = t.implies(	
				t.or(
						pastup(n-1,n,"=",b, subf.singU(t),t),
						_f2						
				), 
				_f2b
		);
		


		
		String[] _f3a = new String[subf.getCountingClocks()];
		for (int i = 0; i < subf.getCountingClocks(); i++)
			_f3a[i] = t.implies(t.rel("=", subf.z(i,t), "0"), _f3a(i,t));
		String f3a = t.and(_f3a);
		
		String[] _f3b = new String[subf.getCountingClocks()];
		for (int i = 0; i < subf.getCountingClocks(); i++)
			_f3b[i] = t.implies(t.rel("=", subf.z(i,t), "0"), upSub(n-1,i,"<",b,"",t));
		String f3b = t.and(_f3b);
		
		String f3;
		f3 = t.iff(
					low(t),
					t.or(
							t.and(subf.low(t), f3a),
							t.and(subf.singU(t), f3b)
					)
			);
				
		
		
		String[] _f4a = new String[subf.getCountingClocks()];
		for (int i = 0; i < subf.getCountingClocks(); i++)
			_f4a[i] = t.implies(t.rel("=", subf.z(i,t), "0"), t.or(upSub(n,i,"=",b,subf.befDnowU(t),t), _f4a(i,t)));
		String f4a = t.and(_f4a);
		
		String[] _f4b = new String[subf.getCountingClocks()];
		for (int i = 0; i < subf.getCountingClocks(); i++)
			_f4b[i] = t.implies(t.rel("=", subf.z(i,t), "0"), upSub(n,i,"=",b,subf.befDnowU(t),t));
		String f4b = t.and(_f4b);
		
		String f4;
		f4 = t.iff(
				singD(t),
				t.and(t.neg(orig),
					t.or(
							t.and(subf.low(t), f4a),
							t.and(subf.singU(t), f4b)
					)
				)
			);
		
		
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f0,f1,f2,f3,f4)));
	}
	



	private String _f3a(int i, CLTLTranslator t) {
		
		int n = nClocks - 1;
		
		String[] s = new String[n];
		for (int k = 0; k < n; k++)
			s[k] = upSub(k,i,"<=",b,"",t);
		return t.or(s);
	}
	
	private String _f4a(int i, CLTLTranslator t) {
		
		int n = nClocks - 1;
		
		String[] s = new String[n];
		for (int k = 1; k < n; k++)
			s[k-1] = upSub(k,i,"=",b,subformula.high(t),t);
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
		
		if (n == 1)
			return t.Y(t.S(t.neg(subformula.nowOnD(t)), t.and(t.or(subformula.singU(t), t.and(orig, subformula.point(t), t.neg(subformula.interval(t)))))));
		else
			return t.and(t.Y(t.S(t.neg(subformula.nowOnD(t)), t.and(subformula.singU(t), pastnspikes(n-1,t)))));
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
			return t.X(t.U(zetagamma(j,">",t), t.and(e, t.rel("=", z(j,t), String.valueOf(d)), zetahatp(o,d,p,t))));
		else
			return t.X(t.U(zetagamma(j,">",t), t.and(subformula.singU(t), t.rel("<", "0", z(j,t)), t.rel("<", z(j,t), String.valueOf(d)), up(n-1,p,j,o,d,e,t))));
	}


	private String zetagamma(int j, String o, CLTLTranslator t) {
		
		String[] f = new String[subformula.getCountingClocks()+1];
		
		int i = 0;		
		for (; i < subformula.getCountingClocks(); i++)
			f[i] = t.rel(o, subformula.z(i,t), "0");
		
		f[i] = t.rel(">", z(j,t), "0");
		
		return t.and(f);
	}


	private String zetahatp(String o, int d, int p, CLTLTranslator t) {
		
		
		String[] s = new String[subformula.getCountingClocks()];
		for (int i = 0; i<subformula.getCountingClocks(); i++)
			s[i] = t.and(zetahatp1(true,i,o,p,d,t), zetahatp1(false,i,o,p,d,t));
		
		return t.or(s);
	}




	private String zetahatp1(boolean c, int i, String o, int p, int d, CLTLTranslator t) {
		
		if (c){
			String[] s = new String[p];
			for (int h = 0, j; h<p; h++){
				j = ( i + (h + 1) ) % subformula.getCountingClocks();
				s[h] = t.rel(o, subformula.z(j, t), String.valueOf(d));
			}
			
			return t.and(s);
		}
		else{
			String[] s = new String[subformula.getCountingClocks() - p];
			for (int h = 0, j; h<(subformula.getCountingClocks() - p); h++){
				j = ( i + (h + p + 1) ) % subformula.getCountingClocks();
				s[h] = t.neg(t.rel(o, subformula.z(j, t), String.valueOf(d)));
			}
			
			return t.and(s);
		}
	}


	private String uporig(int n, String o, int d, String e, CLTLTranslator t) {
		if (n == 1)
			return t.X(t.U(zetagamma(0,">",t), t.and(e, t.rel("<", "0", z(0,t)), t.rel(o, z(0,t), String.valueOf(d)))));
		else
			return t.X(t.U(zetagamma(0,">",t), t.and(subformula.singU(t), t.rel("<", "0", z(0,t)), t.rel("<", z(0,t), String.valueOf(d)), uporig(n-1,o,d,e,t))));	
	}

	
	private String upSub(int n, int j, String o, int d, String e, CLTLTranslator t){
		if (o.compareTo("=") == 0){
			if (n == 1){
				return t.X(t.U(t.neg(subformula.befDnowU(t)), t.and(e, t.rel("=", String.valueOf(d), subformula.z(j,t)))));			
			}
			else{
				return t.X(
							t.U(
								t.neg(subformula.befDnowU(t)),
								t.and(subformula.singU(t), t.rel("<", "0", subformula.z(j,t)), t.rel("<", subformula.z(j,t), String.valueOf(d)), upSub(n-1,j,o,d,e,t))
							)
						);
			}
		}
		else{
			if (n == 0){
				return t.neg(t.X(t.U(t.neg(subformula.befDnowU(t)), t.and(subformula.befDnowU(t), t.rel("<", "0", subformula.z(j,t)), t.rel("<=", subformula.z(j,t), String.valueOf(d))))));			
			}
			else{
				return t.X(
							t.U(
								t.neg(subformula.befDnowU(t)),
								t.and(subformula.singU(t), t.rel("<", "0", subformula.z(j,t)), t.rel(o, subformula.z(j,t), String.valueOf(d)), upSub(n-1,j,o,d,e,t))
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

