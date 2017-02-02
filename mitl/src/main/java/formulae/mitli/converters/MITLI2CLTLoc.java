package formulae.mitli.converters;

import java.util.function.BiFunction;

import formulae.cltloc.CLTLocFormula;
import formulae.mitli.MITLIFormula;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;

public interface MITLI2CLTLoc extends BiFunction<MITLIFormula, CLTLocFormula, Integer> {

	public default CLTLocFormula apply(MITLIFormula t, Integer i){
		return t.accept(new MITLI2CLTLocVisitor(t, i));
	}
}
