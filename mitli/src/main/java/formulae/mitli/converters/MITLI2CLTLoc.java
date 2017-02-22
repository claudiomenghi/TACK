package formulae.mitli.converters;

import java.util.HashMap;
import java.util.Map;

import formulae.cltloc.CLTLocFormula;
import formulae.mitli.MITLIFormula;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;
import formulae.mitli.visitors.SubformulaeVisitor;

public class MITLI2CLTLoc {

	private final MITLI2CLTLocVisitor visitor;
	private final MITLIFormula t;

	public MITLI2CLTLoc(MITLIFormula t, Integer i) {
		this.t = t;
		this.visitor = new MITLI2CLTLocVisitor(t, i);

	}

	public CLTLocFormula apply() {

		CLTLocFormula init = MITLI2CLTLocVisitor.first.apply(visitor.formulaIdMap.get(t));

		CLTLocFormula conjunction = CLTLocFormula.TRUE;
		for (MITLIFormula f : t.accept(new SubformulaeVisitor())) {
			conjunction=MITLI2CLTLocVisitor.AND.apply(conjunction,
					MITLI2CLTLocVisitor.AND.apply(visitor.getckTheta(f), f.accept(visitor)));
		}

		CLTLocFormula formula = MITLI2CLTLocVisitor.AND.apply(init, conjunction);

		return formula;

	}

	public Map<Integer, MITLIFormula> getVocabulary() {
		return this.visitor.formulaIdMap.inverse();
	}

}
