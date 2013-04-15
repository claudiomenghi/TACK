package formulae;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;

public class QTLDisjunction extends QTLFormula {
	
		
	private QTLFormula subformula1, subformula2;
	
	public QTLDisjunction(QTLFormula subformula1, QTLFormula subformula2){
		super(new String("(OR " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}
		
		

	@Override
	public String translate(CLTLTranslator t) {
		// TODO Auto-generated method stub
		
		
		// Some alias...
		QTLFormula subf1 = subformula1;
		QTLFormula subf2 = subformula2;
			
		//p1 is \gamma
		String nowOnU_p1 = t.or(subf1.high(t), subf1.singD(t));		
		String nowOnD_p1 = t.or(subf1.low(t), subf1.singU(t));
		
		//p2 is \psi
		String nowOnU_p2 = t.or(subf2.high(t), subf2.singD(t));		
		String nowOnD_p2 = t.or(subf2.low(t), subf2.singU(t));
		
		String befUnowD_C_p1 = t.or(t.and(subf1.low(t), subf1.lC(t)), subf1.singD(t)); 
		String befUnowD_C_p2 = t.or(t.and(subf2.low(t), subf2.lC(t)), subf2.singD(t)); 
		
		String orig = t.atom("O");
		
		
		
		//Formula (27)
		
		String f1 = t.iff(
							t.and(low(t), lO(t)),
							t.or(
									t.and(
											subf1.low(t),
											t.S(t.neg(nowOnU_p2), nowOnD_p2),
											t.or(subf1.lO(t), subf2.singU(t))
									),
									t.and(
											subf2.low(t),
											t.S(t.neg(nowOnU_p1), nowOnD_p1),
											t.or(subf2.lO(t), subf1.singU(t))
									)	 
								)
						);
		
		
		// Formula (28)
		
		String f2 = t.iff(
							t.and(high(t), lC(t)),
							t.or(
									t.and(subf1.high(t), t.Y(t.S(t.neg(nowOnU_p2), nowOnD_p2)), t.or(subf1.lC(t), subf2.singU(t))),
									t.and(subf2.high(t), t.Y(t.S(t.neg(nowOnU_p1), nowOnD_p1)), t.or(subf2.lC(t), subf1.singU(t))),
									t.and(orig, 
											t.or(
													t.and(subf1.high(t), t.or(subf1.lC(t), t.and(subf2.low(t), subf2.lO(t)))),
													t.and(subf2.high(t), t.or(subf2.lC(t), t.and(subf1.low(t), subf1.lO(t))))
												)
										 )									
								)
						 );
		
		// Formula (29)
		
		String f3 = t.iff(
							t.and(low(t), lC(t)),
							t.or(
									t.and(subf1.low(t), subf1.lC(t), t.neg(nowOnD_p2), t.S(t.neg(nowOnU_p2), nowOnD_p2)),
									t.and(subf2.low(t), subf2.lC(t), t.neg(nowOnD_p1), t.S(t.neg(nowOnU_p1), nowOnD_p1)),
									t.and(subf1.low(t), subf1.lC(t),subf2.low(t), subf2.lC(t))));
		
		
		// Formula (30)
		
		String f4 = t.iff(
							t.and(high(t), lO(t)),
							t.or(
									t.and(subf1.high(t), subf1.lO(t), t.or(
											 t.and(t.neg(nowOnD_p2), t.S(t.neg(nowOnU_p2), nowOnD_p2)),
											 t.and(orig, subf2.low(t), subf2.lC(t)))),
									t.and(subf2.high(t), subf2.lO(t), t.or(
											t.and(t.neg(nowOnD_p1), t.S(t.neg(nowOnU_p1), nowOnD_p1)),
											t.and(orig, subf1.low(t), subf1.lC(t)))),
									t.and(subf1.high(t), subf1.lO(t),subf2.high(t), subf2.lO(t))));
		
		// Formula (31)
		
		String f5 = t.iff(
							singD(t),
							t.and(
									t.neg(orig),
									t.or(
											t.and(subf1.singD(t), t.neg(nowOnD_p2), t.S(t.neg(nowOnU_p2), nowOnD_p2)),
											t.and(t.or(subf1.singD(t), t.and(subf1.high(t), subf1.lO(t))), befUnowD_C_p2),
											t.and(subf2.singD(t), t.neg(nowOnD_p1), t.S(t.neg(nowOnU_p1), nowOnD_p1)),
											t.and(t.or(subf2.singD(t), t.and(subf2.high(t), subf2.lO(t))), befUnowD_C_p1)
									)
								)
							);
							
		// Formula (32)
		
		String f6 = t.iff(
							singU(t),
							t.and(
									t.neg(orig),
									t.or(
											t.and(subf1.singU(t), t.neg(nowOnD_p2), t.S(t.neg(nowOnU_p2), nowOnD_p2)),
											t.and(subf2.singU(t), t.neg(nowOnD_p1), t.S(t.neg(nowOnU_p1), nowOnD_p1)),
											t.and(subf1.singU(t), subf2.singU(t))
									)
								)
							);
		
		
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f1,f2,f3,f4,f5,f6)));
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
			return null; //new QTLConjunction((QTLFormula)l.get(0), (QTLFormula)l.get(1));
	}



	@Override
	public Formula simplify() {		
		return new QTLDisjunction((QTLFormula)subformula1.simplify(), (QTLFormula)subformula2.simplify());
	}

}
