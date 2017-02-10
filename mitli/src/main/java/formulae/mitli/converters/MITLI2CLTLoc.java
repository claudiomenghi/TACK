package formulae.mitli.converters;

import java.util.function.BiFunction;

import formulae.cltloc.CLTLocFormula;
import formulae.mitli.MITLIFormula;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;

public interface MITLI2CLTLoc extends BiFunction<MITLIFormula, CLTLocFormula, Integer> {

	public default CLTLocFormula apply(MITLIFormula t, Integer i){
		
		MITLI2CLTLocVisitor visitor= new MITLI2CLTLocVisitor(t, i);
		
		CLTLocFormula init=MITLI2CLTLocVisitor.first.apply(visitor.formulaIdMap.get(t));
		
		CLTLocFormula formula=t.accept(new MITLI2CLTLocVisitor(t,1000));
		
		return formula;
				
				
				
	}
}
