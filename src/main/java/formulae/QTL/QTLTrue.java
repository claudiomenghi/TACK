package formulae.QTL;

import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class QTLTrue extends QTLFormula {
	
	
	public QTLTrue() {
		super(new String("TRUE"));
	}

	@Override
	public String translate(CLTLTranslator t) {
		
		return t.and(super.clocksEventsConstraints(t) + t.and(
															high(t), 
															lC(t),
															t.neg(t.F(t.or(low(t), singU(t), singD(t))))));
	}

	@Override
	public List<Formula> subformulae() {
		return null;
	}


	@Override
	public QTLFormula update(List<Formula> l) {
		return this;
	}

	@Override
	public Formula simplify() {
		return this;
	}
}
