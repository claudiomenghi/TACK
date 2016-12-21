package formulae.QTL;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class QTLSince extends QTLFormula {

	private QTLFormula subformula1, subformula2;
	
	public QTLSince(QTLFormula subformula1, QTLFormula subformula2){
		super(new String("(S " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}
	
	
	
	@Override
	public String translate(CLTLTranslator t) {
		
		// Some alias...
		QTLFormula subf1 = subformula1;
		QTLFormula subf2 = subformula2;
			
		//p1 is \gamma
		String nowOnU_f1 = t.or(subf1.high(t), subf1.singD(t));		
		
		//p2 is \psi
		String nowOnU_f2 = t.or(subf2.high(t), subf2.singD(t));		
		String nowOnD_O_f2 = t.or(t.and(subf2.low(t), subf2.lO(t)), subf2.singU(t)); 
		String befDnowU_f2 = t.or(subf2.high(t), subf2.singU(t)); 
		
		String orig = t.atom("O");
		
		String down = t.or(
							t.and(
									subf2.low(t), 
									t.or(subf2.lO(t), t.and(subf2.lC(t), t.neg(subf1.high(t)), t.neg(orig)))), 
									subf2.singU(t)); 
		
		
		
				
		
		// Formula (41)
		
		String f1 = t.and(
							t.G(t.and(t.neg(singU(t)), t.neg(singD(t)))), 
							t.X(t.G(t.neg(lC(t)))),
							t.implies(low(t), lC(t)),
							t.implies(high(t), lO(t))
					);
		
		// Formula (44)
		
		String f2 = t.iff(
							low(t),
							t.or(
									t.and(
											subf1.low(t),
											t.or(
													t.and(down, t.neg(subf2.singU(t))),
													t.Y(t.S(t.neg(nowOnU_f1), down)),
													orig
												)
									    ),
									t.and(
											subf1.singD(t),
											t.neg(t.or(nowOnU_f2, subf2.singU(t))),
											t.or(
													t.and(subf2.low(t), subf2.lC(t)),
													t.Y(t.S(t.and(t.neg(nowOnU_f2), t.neg(nowOnU_f1)), down))
												)
										)
								)
						);
		
		
		// Formula (45)
		
		String f3 = t.iff(
							high(t),
							t.or(
									t.and(
											subf1.high(t),
											t.or(t.S(t.neg(subf2.low(t)), nowOnU_f2), nowOnD_O_f2)),
									t.and(
											befDnowU_f2,
											t.S(t.neg(subf1.low(t)), nowOnU_f1),
											t.or(
													subf1.high(t),
													t.neg(t.Y(t.S(t.and(t.neg(nowOnU_f2), t.neg(nowOnU_f1)), down)))
												)
										)
								)
						);
											
											
				
		
		return t.and(super.clocksEventsConstraints(t) + f1 + t.G(t.and(f2,f3)));
		
	}



	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		r.add(subformula1);
		r.add(subformula2);
		
		return r;
	}
	
	
	@Override
	public QTLFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		if (l.get(0).equals(subformula1) && l.get(1).equals(subformula2)){
			subformula1 = (QTLFormula)l.get(0);
			subformula2 = (QTLFormula)l.get(1);
			return this;
		}
		//else rise an error. TODO: implement WrongUpdateException
		else
			return null; //return new QTLSince((QTLFormula)l.get(0),(QTLFormula)l.get(1));
	}



	@Override
	public Formula simplify() {
		return new QTLSince((QTLFormula)subformula1.simplify(),(QTLFormula)subformula2.simplify());
	}
}
