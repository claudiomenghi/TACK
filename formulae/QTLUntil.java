package formulae;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;

public class QTLUntil extends QTLFormula {

	
	private QTLFormula subformula1, subformula2;
	
	public QTLUntil(QTLFormula subformula1, QTLFormula subformula2){
		super(new String("(U " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
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
		//String nowOnD_f1 = t.or(subf1.low(t), subf1.singU(t));
		
		//p2 is \psi
		String nowOnU_f2 = t.or(subf2.high(t), subf2.singD(t));		
		String nowOnD_f2 = t.or(subf2.low(t), subf2.singU(t));
		
		//String befDnowU_C_f1 = t.or(t.and(subf1.low(t), subf1.lC(t)), subf1.singD(t)); 
		String befDnowU_C_f2 = t.or(t.and(subf2.high(t), subf2.lC(t)), subf2.singU(t)); 
		
		String befUnowD_f1 = t.or(subf1.low(t), subf1.singD(t)); 
		String befUnowD_f2 = t.or(subf2.low(t), subf2.singD(t)); 
		
		String up = t.or(t.and(subf2.high(t), t.or(subf2.lC(t), t.and(subf2.lO(t), t.neg(subf1.low(t))))), subf2.singU(t)); 
		
		String orig = t.atom("O");
		
		
		
		
		// Formula (33)
		
		String f1 = t.and(t.neg(singU(t)), t.neg(singD(t)), t.neg(lO(t)));
		
		
		// Formula (34)
		
		String f2 = t.iff(
							high(t),
							t.or(
									t.and(
											subf1.high(t),
											t.or(
													t.and(up, t.neg(subf2.singU(t))),
													t.X(t.U(t.neg(befUnowD_f1), up)),
													t.S(t.neg(subf2.low(t)), nowOnU_f2)
												)
									    ),
									t.and(
											subf1.singD(t),
											t.neg(t.or(befUnowD_f2, subf2.singU(t))),
											t.or(
													t.and(subf2.high(t), subf2.lO(t)),
													t.X(t.U(t.and(t.neg(befUnowD_f2), t.neg(befUnowD_f1)), up))
												)
										)
								)
						);
		
		
		// Formula (35)
		
		String f3 = t.iff(
							low(t),
							t.or(
									t.and(
											subf1.low(t),
											t.or(orig, t.Y(t.S(t.neg(subf2.low(t)), nowOnU_f2)), befDnowU_C_f2)),
									t.and(
											nowOnD_f2,
											t.or(orig, t.Y(t.S(t.neg(subf1.low(t)), nowOnU_f1))),
											t.or(
													subf1.low(t),
													t.neg(t.X(t.U(t.and(t.neg(befUnowD_f2), t.neg(befUnowD_f1)), up)))
												)
										)
								)
						);
											
											
				
		
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f1,f2,f3)));
		
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
			return null; //return new QTLUntil((QTLFormula)l.get(0),(QTLFormula)l.get(1));
	}



	@Override
	public Formula simplify() {
		return new QTLUntil((QTLFormula)subformula1.simplify(),(QTLFormula)subformula2.simplify());
	}

	
}
