package ta.visitors;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocSelector;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.relations.CLTLocRelation;
import formulae.cltloc.relations.Relation;
import ta.Clock;
import ta.TA;
import ta.state.EmptyInvariant;
import ta.state.ExpInvariant;

public class ReverseInvariantVisitor implements InvariantVisitor{

	public CLTLocFormula visit(TA ta, EmptyInvariant emptyInvariant) {
		return CLTLocFormula.TRUE;
		
	}
	
	public CLTLocFormula visit(TA ta, ExpInvariant inv) {
		String variableName=inv.getId().getId();
		String prefix = ta.getLocalClocks().contains(new Clock(variableName)) ? ta.getIdentifier() + "_" : "";
		return (CLTLocFormula) //CLTLocDisjunction.getCLTLocDisjunction(
				//CLTLocFormula.getAnd(
					//	new CLTLocSelector(prefix + variableName + "_v"),
						new CLTLocRelation(new CLTLocClock(prefix +variableName+ "_0"),
								new Constant(inv.getExp().evaluate()), Relation.parse(inv.getOperator())
								); //),
				//CLTLocFormula.getAnd(
					//	new CLTLocNegation(new CLTLocSelector(prefix + variableName + "_v")),
						//new CLTLocRelation(new CLTLocClock(prefix + variableName + "_1"),
							//	new Constant(inv.getExp().evaluate()), Relation.parse(inv.getOperator()))));
	}
	
}

