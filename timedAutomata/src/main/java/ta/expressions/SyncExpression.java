package ta.expressions;

public class SyncExpression {

	private final Expression e;
	private final String operator;
	
	public SyncExpression(Expression e, String operator){
		this.e=e;
		this.operator=operator;
		
	}
	public Expression getE() {
		return e;
	}
	public String getOperator() {
		return operator;
	}
	
}
