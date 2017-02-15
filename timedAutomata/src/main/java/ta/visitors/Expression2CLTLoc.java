package ta.visitors;

import formulae.cltloc.CLTLocFormula;
import ta.expressions.EmptyExpression;

public class Expression2CLTLoc implements ExpressionVisitor<CLTLocFormula>{

	@Override
	public CLTLocFormula visit(EmptyExpression emptyExpression) {
		return CLTLocFormula.TRUE;
	}

}
