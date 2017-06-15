package ta.visitors;

import formulae.cltloc.CLTLocFormula;
import ta.TA;
import ta.state.EmptyInvariant;
import ta.state.ExpInvariant;

public interface InvariantVisitor {

	public CLTLocFormula visit(TA ta, EmptyInvariant emptyInvariant);
	
	public CLTLocFormula visit(TA ta, ExpInvariant inv) ;
	
}

