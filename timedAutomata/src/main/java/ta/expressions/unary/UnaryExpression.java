package ta.expressions.unary;

import ta.expressions.Expression;

public class UnaryExpression extends Expression {

	Expression e;
	
	public UnaryExpression(Expression e){
		this.e=e;
	}
	public Expression getChild(){
		return e;
	}
}
