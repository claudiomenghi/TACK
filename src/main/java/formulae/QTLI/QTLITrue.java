package formulae.QTLI;

import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class QTLITrue extends QTLIFormula {
	
	
	public QTLITrue() {
		super(new String("TRUE"));
	}

	@Override
	public String translate(CLTLTranslator t) {
		
		return t.and(super.clocksEventsConstraints(t) + t.G(t.and(point(t), interval(t))));
	}

	@Override
	public List<Formula> subformulae() {
		return null;
	}


	@Override
	public QTLIFormula update(List<Formula> l) {
		return this;
	}

	@Override
	public Formula simplify() {
		return this;
	}
}
