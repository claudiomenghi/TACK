package formulae.QTLI;

import java.util.ArrayList;
import java.util.List;
import delegateTranslator.CLTLTranslator;
import formulae.Formula;
import formulae.Temporized;

public class QTLIPast extends QTLIFormula implements Temporized{

	private QTLIFormula subformula;
	private final int b;  
	
	public QTLIPast(QTLIFormula subformula, int b){
		super(new String("(P " + String.valueOf(b) + " " + subformula.strFormula() + ")"));
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
		f1 = t.implies(point(t), t.and(interval(t), t.Y(interval(t)), t.neg(orig)));
	
		String f2 = t.iff(
							high(t),
							t.and(
									subf.befDnowU(t),
									t.or(
											orig,
											t.Y(
													t.S(
															t.neg(subf.befDnowU(t)),
															t.and(
																	orig,
																	t.neg(t.and(subf.point(t), subf.interval(t)))
															)
													)
											),
											t.or(t.rel(">", subf.z0(t), String.valueOf(b)), t.rel(">", subf.z1(t), String.valueOf(b)))
									)
							)
					);
						
							
		
		String f3;
		f3 = t.iff(
				low(t),	
				t.or(
						t.and(orig, t.neg(t.and(subf.point(t), subf.interval(t)))),
						t.and(
								t.rel("=", subf.z0(t), String.valueOf(b)),
								t.S(
										t.neg(subf.befDnowU(t)),
										t.and(											
												subf.nowOnD(t),
												t.rel("=", subf.z0(t), "0")
										)
								)
						),
						t.and(
								t.rel("=", subf.z1(t), String.valueOf(b)),
								t.S(
										t.neg(subf.befDnowU(t)),
										t.and(
												subf.nowOnD(t),
												t.rel("=", subf.z1(t), "0")
										)
								)
						)
				)	
		);


		String f4;
		f4 = t.iff(
				singD(t),
				t.and(
						t.neg(orig),
						subf.befDnowU(t),
						t.or(					
							t.and(
									t.rel("=", subf.z0(t), String.valueOf(b)),
									t.Y(
										t.S(
											t.neg(subf.befDnowU(t)),
											t.and(
													subf.nowOnD(t),
													t.rel("=", subf.z0(t), "0")
											)
										)
									)
							),
							t.and(
									t.rel("=", subf.z1(t), String.valueOf(b)),
									t.Y(
										t.S(
											t.neg(subf.befDnowU(t)),
											t.and(
													subf.nowOnD(t),
													t.rel("=", subf.z1(t), "0")
											)
										)
									)
							)
					)
				)	
		);

		
		String f5;
		f5 = t.and(
					t.implies(
								t.and(subf.nowOnD(t), t.rel("=", subf.z0(t), "0")),
								t.U(
										t.rel("<", subf.z0(t), String.valueOf(upperbound())),
										t.or(
												t.and(subf.befDnowU(t), t.rel(">", subf.z0(t), "0"), t.rel("<", subf.z0(t), String.valueOf(upperbound()))), 
												t.rel("=", subf.z0(t), String.valueOf(upperbound())))											
								)				
					),
					t.implies(
							t.and(subf.nowOnD(t), t.rel("=", subf.z1(t), "0")),
							t.U(
									t.rel("<", subf.z1(t), String.valueOf(upperbound())),
									t.or(
											t.and(subf.befDnowU(t), t.rel(">", subf.z1(t), "0"), t.rel("<", subf.z1(t), String.valueOf(upperbound()))), 
											t.rel("=", subf.z1(t), String.valueOf(upperbound())))			
							)
					)
			);
		
		
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f1,f2,f3,f4,f5)));
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
		return new QTLIPast((QTLIFormula)subformula.simplify(), b);
	}
	
}

