package ta.visitors;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.AssignVariable;
import formulae.cltloc.atoms.CLTLocArithmeticExpression;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.relations.CLTLocRelation;
import formulae.cltloc.relations.Relation;
import ta.expressions.EmptyExpression;
import ta.expressions.Expression;
import ta.expressions.Identifier;
import ta.expressions.Value;
import ta.expressions.binary.BinaryArithmeticExpression;
import ta.transition.assignments.VariableAssignement;

public class Expression2CLTLoc implements ExpressionVisitor<CLTLocFormula> {

	@Override
	public CLTLocFormula visit(EmptyExpression emptyExpression) {
		return CLTLocFormula.TRUE;
	}

	@Override
	public <R extends Expression, S extends Expression> CLTLocFormula visit(
			BinaryArithmeticExpression<R, S> binaryExpression) {

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

	public CLTLocFormula visit(VariableAssignement variableAssignement) {
		return new AssignVariable(new Variable(variableAssignement.getVariable().getName()),
				variableAssignement.getValue().accept(new Expression2CLTLocExpression())

		);
	
	}
}
