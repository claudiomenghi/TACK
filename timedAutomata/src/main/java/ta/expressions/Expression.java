package ta.expressions;

import ta.visitors.Expression2CLTLocExpression;
import ta.visitors.ExpressionVisitor;

public abstract class Expression {

	
	abstract public  formulae.cltloc.atoms.Expression accept(Expression2CLTLocExpression visitor);
	
	abstract public  <T> T accept(ExpressionVisitor<T> visitor);
	
	abstract public int evaluate();
}
