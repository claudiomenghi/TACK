package formulae;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;

public class QTLNegation extends QTLFormula {

	//Formula f1 which is argument of the negation (\neg f1) 
	private QTLFormula subformula;
	
	public QTLNegation(QTLFormula subformula){
		super(new String("(NEG " + subformula.strFormula()) + ")");
		this.subformula = subformula;
	}


	
	@Override
	public String translate(CLTLTranslator t) {
		
		QTLFormula subf = subformula;
		
		String[] conj = new String[6];
		
		conj[0] = t.iff(high(t), subf.low(t));
		conj[1] = t.iff(low(t), subf.high(t));		
		conj[2] = t.iff(singU(t), subf.singD(t));		
		conj[3] = t.iff(singD(t), subf.singU(t));
		conj[4] = t.iff(lO(t), subf.lO(t));
		conj[5] = t.iff(lC(t), subf.lC(t));
		
		return  t.and(super.clocksEventsConstraints(t), t.G(t.and(conj)));
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
			return null; //return new QTLNegation((QTLFormula)l.get(0));
	}

	@Override
	public Formula simplify() {
		if (subformula.getClass() == QTLNegation.class){
			List<Formula> l = subformula.subformulae();
			return l.get(0).simplify();
		}
		else return new QTLNegation((QTLFormula)subformula.simplify());
	}
	
	
}
