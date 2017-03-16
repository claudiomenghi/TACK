package ta.visitors;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.relations.CLTLocRelation;
import formulae.cltloc.relations.Relation;
import ta.expressions.EmptyExpression;
import ta.expressions.Expression;
import ta.expressions.binary.BinaryArithmeticExpression;

public class Expression2CLTLoc implements ExpressionVisitor<CLTLocFormula> {

	@Override
	public CLTLocFormula visit(EmptyExpression emptyExpression) {
		return CLTLocFormula.TRUE;
	}

	@Override
	public <R extends Expression, S extends Expression> CLTLocFormula visit(BinaryArithmeticExpression<R, S> binaryExpression) {

		switch (binaryExpression.getOperator()) {
		case ">":
			return new CLTLocRelation(new Variable(binaryExpression.getLeftChild().toString()),
					new Constant(binaryExpression.getRightChild().evaluate()), Relation.GE);
		case ">=":
			return new CLTLocRelation(new Variable(binaryExpression.getLeftChild().toString()),
					new Constant(binaryExpression.getRightChild().evaluate()), Relation.GEQ);
		default:
			throw new IllegalArgumentException("operator: " + binaryExpression.getOperator() + " undefined");
		}
	}

}
