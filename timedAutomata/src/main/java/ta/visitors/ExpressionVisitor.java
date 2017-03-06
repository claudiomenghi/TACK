package ta.visitors;

import ta.expressions.EmptyExpression;
import ta.expressions.Expression;
import ta.expressions.binary.BinaryExpression;

/**
 * Transformation between an expression and a CLTLoc formula
 * 
 * @author Claudio Menghi
 *
 * @param <T>
 *            the type to be returned
 */
public interface ExpressionVisitor<T> {

	T visit(EmptyExpression emptyExpression);

	<R extends Expression, S extends Expression> T visit(BinaryExpression<R, S> binaryExpression);

}
