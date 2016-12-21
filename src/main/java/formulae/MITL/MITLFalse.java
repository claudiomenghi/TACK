package formulae.MITL;

import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class MITLFalse extends MITLFormula {

	public MITLFalse() {
		super(new String("FALSE"));
	}

	@Override
	public String translate(CLTLTranslator t) {
		
		return t.and(super.clocksEventsConstraints(t), t.and(
																low(t),
																t.neg(t.F(high(t)))));
	}

	@Override
	public List<Formula> subformulae() {
		return null;
	}

	@Override
	public MITLFormula update(List<Formula> l) {
		return this;
	}

	@Override
	public Formula simplify() {
		return this;
	}

}
