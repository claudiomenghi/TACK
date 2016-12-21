package formulae.MITL;

import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class MITLTrue extends MITLFormula {
	
	
	public MITLTrue() {
		super(new String("TRUE"));
	}

	@Override
	public String translate(CLTLTranslator t) {
		
		return t.and(super.clocksEventsConstraints(t) + t.and(
															high(t), 
															t.neg(t.F(low(t)))));
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
