package formulae.mitli.converters;

import java.util.function.BiFunction;

import org.apache.log4j.Logger;

import formulae.cltloc.converters.CLTLoc2Ae2zot;
import formulae.mitli.MITLIFormula;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;

public class MITLI2zot implements BiFunction<MITLIFormula, Integer, String> {

	private final static Logger LOGGER =Logger.getLogger(MITLI2zot.class);
	
	
	public String apply(MITLIFormula t, Integer i){
		
		String zotencoding=new CLTLoc2Ae2zot(i).apply(
				(t.accept(new MITLI2CLTLocVisitor(t))));
		LOGGER.info("Formula converted in zot");

		return zotencoding
				;
	}

}
