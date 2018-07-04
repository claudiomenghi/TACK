package ta.visitors;

import formulae.cltloc.atoms.CLTLocArithmeticExpression;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.Variable;
import ta.expressions.Expression;
import ta.expressions.Identifier;
import ta.expressions.Value;
import ta.expressions.binary.BinaryArithmeticExpression;

public class Expression2CLTLocExpression {

	public <T extends Expression, S extends Expression> CLTLocArithmeticExpression visit(
			BinaryArithmeticExpression<T, S> binaryArithmeticExpression) {

		formulae.cltloc.atoms.Expression left;
		if (binaryArithmeticExpression.getLeftChild() instanceof Identifier) {
			left = new Variable(((Identifier) binaryArithmeticExpression.getLeftChild()).getId());
		} else {
			if (binaryArithmeticExpression.getLeftChild() instanceof Value) {
				left = new Constant(((Value) binaryArithmeticExpression.getLeftChild()).value);
			} else {
				left = binaryArithmeticExpression.getLeftChild().accept(this);
			}
		}
		
		
		formulae.cltloc.atoms.Expression right;
		if (binaryArithmeticExpression.getRightChild() instanceof Identifier) {
			right = new Variable(((Identifier) binaryArithmeticExpression.getRightChild()).getId());
		} else {
			if (binaryArithmeticExpression.getRightChild() instanceof Value) {
				right = new Constant(((Value) binaryArithmeticExpression.getRightChild()).value);
			} else {
				right = binaryArithmeticExpression.getRightChild().accept(this);
			}
		}
		
		return new CLTLocArithmeticExpression(left, binaryArithmeticExpression.getOperator(), right);
	}

	public Constant visit(Value value) {
		return new Constant(value.value);
	}

}
