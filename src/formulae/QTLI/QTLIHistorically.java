package formulae.QTLI;

import java.util.ArrayList;
import java.util.List;
import delegateTranslator.CLTLTranslator;
import formulae.Formula;
import formulae.Temporized;

public class QTLIHistorically extends QTLIFormula implements Temporized{

	private QTLIFormula subformula;
	private final int b;  
	
	public QTLIHistorically(QTLIFormula subformula, int b){
		super(new String("(H " + String.valueOf(b) + " " + subformula.strFormula() + ")"));
		this.subformula = subformula;
		this.b = b;
		
		subformula.maxIntComparedto(b);
	}
	
	
	@Override
	public String translate(CLTLTranslator t) {
		
		// Some alias...
		QTLIFormula subf = subformula;
	
		String orig = t.atom("O");
				
		String f1;
		f1 = t.implies(t.neg(point(t)), t.or(orig, t.and(t.neg(interval(t)), t.Y(t.neg(interval(t))))));
		
		String f5 = t.neg(point(t));
	
		String f2 = t.iff(
							high(t),
							t.and(
									subf.befUnowD(t),
									t.or(
											orig, 
											t.and(
													t.rel(">", subf.z0(t), String.valueOf(b)),
													t.S(
															t.neg(subf.befUnowD(t)),
															t.and(											
																	subf.nowOnU(t),
																	t.rel("=", subf.z0(t), "0")
															)
													)
											),
											t.and(
													t.rel(">", subf.z1(t), String.valueOf(b)),
													t.S(
															t.neg(subf.befUnowD(t)),
															t.and(
																	subf.nowOnU(t),
																	t.rel("=", subf.z1(t), "0")
															)
													)
											)
									)	
								)
					);
				
							
		
		String f3;
		f3 = t.iff(
				high(t),	
				t.or(
						t.and(
								t.rel("=", subf.z0(t), String.valueOf(b)),
								t.S(
										t.neg(subf.befUnowD(t)),
										t.and(											
												subf.nowOnU(t),
												t.rel("=", subf.z0(t), "0")
										)
								)
						),
						t.and(
								t.rel("=", subf.z1(t), String.valueOf(b)),
								t.S(
										t.neg(subf.befUnowD(t)),
										t.and(
												subf.nowOnU(t),
												t.rel("=", subf.z1(t), "0")
										)
								)
						)
				)	
		);


		String f4;
		f4 = t.iff(
				singU(t),
				t.and(
						t.neg(orig),
						subf.befUnowD(t),
						t.or(					
							t.and(
									t.rel("=", subf.z0(t), String.valueOf(b)),
									t.Y(
										t.S(
											t.neg(subf.befUnowD(t)),
											t.and(
													subf.nowOnU(t),
													t.rel("=", subf.z0(t), "0")
											)
										)
									)
							),
							t.and(
									t.rel("=", subf.z1(t), String.valueOf(b)),
									t.Y(
										t.S(
											t.neg(subf.befUnowD(t)),
											t.and(
													subf.nowOnU(t),
													t.rel("=", subf.z1(t), "0")
											)
										)
									)
							)
					)
				)	
		);

		
		
		
		
		return t.and(super.clocksEventsConstraints(t), f5, t.G(t.and(f1,f2,f3,f4)));
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

		subformula = (QTLIFormula)l.get(0);					
		return this;
	}


	@Override
	public Formula simplify() {
		return new QTLIHistorically((QTLIFormula)subformula.simplify(), b);
	}
	
}

