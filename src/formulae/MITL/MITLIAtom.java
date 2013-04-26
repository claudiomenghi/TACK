package formulae.MITLI;

import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class MITLIAtom extends MITLIFormula {

		
	public MITLIAtom(String atom){
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
	public MITLIFormula update(List<Formula> l) {
		return this;
	}

	@Override
	public Formula simplify() {
		return this;
	}

}
