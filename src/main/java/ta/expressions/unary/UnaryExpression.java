package ta.expressions.unary;

import ta.expressions.Expression;

public interface UnaryExpression<T extends Expression> {

	public T getChild();
}
