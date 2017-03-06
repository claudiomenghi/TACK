package ta.expressions;

import ta.visitors.ExpressionVisitor;
import ta.visitors.TAVisitor;

public abstract class Expression {

	
	abstract public  <T> T accept(TAVisitor<T> visitor);
	
	abstract public  <T> T accept(ExpressionVisitor<T> visitor);
	
	abstract public int evaluate();
}
