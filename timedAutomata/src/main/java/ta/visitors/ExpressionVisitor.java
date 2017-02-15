package ta.visitors;

import ta.expressions.EmptyExpression;

//TODO implement the transformation between an expression 2 CLTLoc
public interface ExpressionVisitor<T> {

	T visit(EmptyExpression emptyExpression);

}
