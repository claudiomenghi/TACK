package formulae.MITL;

import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class MITLAtom extends MITLFormula {

		
	public MITLAtom(String atom){
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
	public MITLFormula update(List<Formula> l) {
		return this;
	}

	@Override
	public Formula simplify() {
		return this;
	}

}
