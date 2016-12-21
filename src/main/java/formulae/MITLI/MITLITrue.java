package formulae.MITLI;

import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class MITLITrue extends MITLIFormula {
	
	
	public MITLITrue() {
		super(new String("TRUE"));
	}

	@Override
	public String translate(CLTLTranslator t) {
		
		return t.and(super.clocksEventsConstraints(t), t.G(interval(t)));
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
