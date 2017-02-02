package formulae.mitli.converters;

import java.util.function.BiFunction;

import formulae.cltloc.converters.CLTLoc2Zot;
import formulae.mitli.MITLIFormula;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;

public class MITLI2zot implements BiFunction<MITLIFormula, Integer, String> {

	public String apply(MITLIFormula t, Integer i){
		return 
				new CLTLoc2Zot().apply(
				(t.accept(new MITLI2CLTLocVisitor(t, i))));
	}

}
