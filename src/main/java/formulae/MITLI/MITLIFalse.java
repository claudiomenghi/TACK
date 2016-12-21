package formulae.MITLI;

import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class MITLIFalse extends MITLIFormula {

	public MITLIFalse() {
		super(new String("FALSE"));
	}

	@Override
	public String translate(CLTLTranslator t) {
		
		return t.and(super.clocksEventsConstraints(t), low(t), t.G(t.neg(interval(t))));
	}

	@Override
	public List<Formula> subformulae() {
		return null;
	}

	@Override
	public MITLIFormula update(List<Formula> l) {
		return this;
	}

	@Override
	public Formula simplify() {
		return this;
	}

}
