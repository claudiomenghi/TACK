package formulae.mitli.converters;

import java.util.function.BiFunction;

import formulae.cltloc.CLTLocFormula;
import formulae.mitli.MITLIFormula;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;
import formulae.mitli.visitors.SubformulaeVisitor;

public interface MITLI2CLTLoc extends BiFunction<MITLIFormula, CLTLocFormula, Integer> {

	public default CLTLocFormula apply(MITLIFormula t, Integer i){
		
		MITLI2CLTLocVisitor visitor= new MITLI2CLTLocVisitor(t, i);
		
		CLTLocFormula init=MITLI2CLTLocVisitor.first.apply(visitor.formulaIdMap.get(t));
		
		
		CLTLocFormula conjunction=CLTLocFormula.TRUE;
		for(MITLIFormula f: t.accept(new SubformulaeVisitor())){
			MITLI2CLTLocVisitor.AND.apply(conjunction, MITLI2CLTLocVisitor.AND.apply(visitor.getckTheta(f),f.accept(visitor)));
		}
		
		
		CLTLocFormula formula=MITLI2CLTLocVisitor.AND.apply(init, conjunction);
		
		return formula;
				
				
		
	}
}
