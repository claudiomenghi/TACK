package ta.expressions.unary;

import ta.expressions.Expression;
import ta.visitors.ExpressionVisitor;
import ta.visitors.TAVisitor;

public class UnaryExpression extends Expression {

	Expression e;
	
	public UnaryExpression(Expression e){
		this.e=e;
	}
	public Expression getChild(){
		return e;
	}
	@Override
	public <T> T accept(TAVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}
}
