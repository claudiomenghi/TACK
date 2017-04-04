package formulae.mitli.converters;

import java.util.function.BiFunction;

import org.apache.log4j.Logger;

import formulae.cltloc.converters.CLTLoc2ZotBvzot;
import formulae.mitli.MITLIFormula;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;

public class MITLI2zot implements BiFunction<MITLIFormula, Integer, String> {

	private final static Logger LOGGER =Logger.getLogger(MITLI2zot.class);
	
	
	public String apply(MITLIFormula t, Integer i){
		
		String zotencoding=new CLTLoc2ZotBvzot(i).apply(
				(t.accept(new MITLI2CLTLocVisitor(t, i))));
		LOGGER.info("Formula converted in zot");

		return zotencoding
				;
	}

}
