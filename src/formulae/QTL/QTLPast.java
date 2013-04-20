package formulae.QTL;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class QTLPast extends QTLFormula {

	private QTLFormula subformula;
	private final int b;  
	
	public QTLPast(QTLFormula subformula, int b){
		super(new String("(P " + String.valueOf(b) + " " + subformula.strFormula() + ")"));
		this.subformula = subformula;
		this.b = b;
	}

	
	
	@Override
	public String translate(CLTLTranslator t) {
		
		// Some alias...
		QTLFormula subf1 = subformula;
			
		//f1 is \gamma				
		String befDnowU_f1 = t.or(subf1.low(t), subf1.singU(t)); 

		
		String orig = t.atom("O");
		
		String nowOnD_f1 = t.or(subf1.low(t), subf1.singU(t)); 
		
		
		// Formula (45)
		
		String f1 = t.and(
							t.neg(singU(t)), 
							t.implies(high(t), lO(t)),
							t.implies(low(t),lC(t)));
		
		
		// formula (46)
		
		String f2 = t.iff(
							high(t),
							t.and(
									befDnowU_f1,
									t.or(
											orig,
											t.Y(
													t.S(
															t.neg(befDnowU_f1), 
															t.and(subf1.low(t), orig, subf1.lC(t))
													)
											),
											t.or(t.rel(">=", subf1.z0(t), String.valueOf(b)), t.rel(">=", subf1.z1(t), String.valueOf(b)))											
									)
							)
					);
		
		

		// Formula (47)
		
		String f3 = t.iff(
							low(t),
							t.or(
									t.and(
											t.rel("=", subf1.z0(t), String.valueOf(b)),
											t.S(
													t.neg(befDnowU_f1),
													t.and(
															nowOnD_f1,
															t.or(t.neg(orig), subf1.lO(t)),
															t.rel("=", subf1.z0(t), "0")
													)
											)
									),
									t.and(
											t.rel("=", subf1.z1(t), String.valueOf(b)),
											t.S(
													t.neg(befDnowU_f1),
													t.and(
															nowOnD_f1,
															t.or(t.neg(orig), subf1.lO(t)),
															t.rel("=", subf1.z1(t), "0")
													)
											)
									)
							)
					);
							
												
		
		
		// Formula (48)
		
		String f4 = t.iff(
							singD(t),
							t.and(befDnowU_f1,
									t.or(
											t.and(
													t.rel("=", subf1.z0(t), String.valueOf(b)),
													t.Y(
															t.S(	
																	t.neg(befDnowU_f1),
																	t.and(
																			nowOnD_f1,
																			t.or(t.neg(orig), subf1.lO(t)),
																			t.rel("=", subf1.z0(t), "0")
																	)
															)
													)
											),
											t.and(
													t.rel("=", subf1.z1(t), String.valueOf(b)),
													t.S(
															t.neg(befDnowU_f1),
															t.and(
																	nowOnD_f1,
																	t.or(t.neg(orig), subf1.lO(t)),
																	t.rel("=", subf1.z1(t), "0")
															)
													)
											)
									)
							)
					);
											
		return t.and(super.clocksEventsConstraints(t) + t.G(t.and(f1,f2,f3,f4)));
	}



	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		r.add(subformula);
		
		return r;
	}



	@Override
	public QTLFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		if (l.get(0).equals(subformula)){
			subformula = (QTLFormula)l.get(0);					
			return this;
		}
		//else rise an error. TODO: implement WrongUpdateException
		else
			return null;	//return new QTLPast((QTLFormula)l.get(0), b);
	}



	@Override
	public Formula simplify() {
		return new QTLPast((QTLFormula)subformula.simplify(), b);
	}

}
