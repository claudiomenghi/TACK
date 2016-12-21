package formulae.QTLI;

import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class QTLIAtom extends QTLIFormula {

		
	public QTLIAtom(String atom){
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
	public QTLIFormula update(List<Formula> l) {
		return this;
	}

	@Override
	public Formula simplify() {
		return this;
	}

}
