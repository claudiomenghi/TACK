package formulae.QTLI;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class QTLIConjunction extends QTLIFormula {
	
		
	private QTLIFormula subformula1, subformula2;
	
	public QTLIConjunction(QTLIFormula subformula1, QTLIFormula subformula2){
		super(new String("(AND " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}
		
		

	@Override
	public String translate(CLTLTranslator t) {
		// TODO Auto-generated method stub
		
		
		// Some alias...
		QTLIFormula subf1 = subformula1;
		QTLIFormula subf2 = subformula2;
			

		String f1 = t.and(
							t.iff(point(t), t.and(subf1.point(t), subf2.point(t))),
							t.iff(interval(t), t.and(subf1.interval(t), subf2.interval(t)))
					);
		
		return t.and(super.clocksEventsConstraints(t), t.G(f1));
	}



	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		r.add(subformula1);
		r.add(subformula2);
		
		return r;
	}



	@Override
	public QTLIFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		if (l.get(0).equals(subformula1) && l.get(1).equals(subformula2)){
			subformula1 = (QTLIFormula)l.get(0);
			subformula2 = (QTLIFormula)l.get(1);
			return this;
		}
		//else rise an error. TODO: implement WrongUpdateException
		else
			return null; //new QTLConjunction((QTLFormula)l.get(0), (QTLFormula)l.get(1));
	}



	@Override
	public Formula simplify() {		
		return new QTLIConjunction((QTLIFormula)subformula1.simplify(), (QTLIFormula)subformula2.simplify());
	}

}
