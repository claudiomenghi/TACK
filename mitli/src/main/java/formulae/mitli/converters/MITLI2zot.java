package formulae.mitli.converters;

import java.util.function.BiFunction;
import java.util.logging.Level;
import java.util.logging.Logger;

import formulae.cltloc.converters.CLTLoc2Zot;
import formulae.mitli.MITLIFormula;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;

public class MITLI2zot implements BiFunction<MITLIFormula, Integer, String> {

	private final static Logger LOGGER = Logger.getLogger(MITLI2CLTLocVisitor.class.getName());
	
	
	public String apply(MITLIFormula t, Integer i){
		
		String zotencoding=new CLTLoc2Zot().apply(
				(t.accept(new MITLI2CLTLocVisitor(t, i))));
		LOGGER.log(Level.INFO, "Formula converted in zot");

		return zotencoding
				;
	}

}
