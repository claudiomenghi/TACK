package formulae.QTL;

import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class QTLAtom extends QTLFormula {

		
	public QTLAtom(String atom){
		super(atom);
	}

	@Override
	public String translate(CLTLTranslator t) {
		return super.clocksEventsConstraints(t);
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
