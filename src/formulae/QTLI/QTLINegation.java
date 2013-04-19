package formulae.QTLI;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class QTLINegation extends QTLIFormula {

	//Formula f1 which is argument of the negation (\neg f1) 
	private QTLIFormula subformula;
	
	public QTLINegation(QTLIFormula subformula){
		super(new String("(NEG " + subformula.strFormula()) + ")");
		this.subformula = subformula;
	}


	
	@Override
	public String translate(CLTLTranslator t) {
		
		QTLIFormula subf = subformula;
		
		String f1;
		f1 = t.and(
					t.iff(point(t), t.neg(subf.point(t))),
					t.iff(interval(t), t.neg(subf.interval(t)))
			);
		
		return  t.and(super.clocksEventsConstraints(t), t.G(f1));
	}

	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		r.add(subformula);
		
		return r;
	}

	@Override
	public QTLIFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		if (l.get(0).equals(subformula)){
			subformula = (QTLIFormula)l.get(0);					
			return this;
		}
		//else rise an error. TODO: implement WrongUpdateException
		else
			return null; //return new QTLNegation((QTLFormula)l.get(0));
	}

	@Override
	public Formula simplify() {
		if (subformula.getClass() == QTLINegation.class){
			List<Formula> l = subformula.subformulae();
			return l.get(0).simplify();
		}
		else return new QTLINegation((QTLIFormula)subformula.simplify());
	}
	
	
}
