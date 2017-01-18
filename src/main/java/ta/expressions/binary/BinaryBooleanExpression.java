package ta.expressions.binary;

import ta.expressions.Expression;

public class BinaryBooleanExpression extends BinaryOperator<Expression, Expression>{

private final BooleanOperator operator;
	
	public BinaryBooleanExpression(BooleanOperator operator, Expression exp1,  Expression exp2){
		super(exp1, exp2);
		this.operator=operator;
	}
	
	public BooleanOperator getOperator() {
		return operator;
	}

	//| '+=' | '-=' | '*=' | '/=' | '%=' | '|=' | '&=' | '^=' | '<<=' | '>>='
	public enum BooleanOperator{
		
		AND("&&"),
		OR("||");
		
		private final String stringRep;
		
		private BooleanOperator(String rep){
			this.stringRep=rep;
		}

		public String getStringRep() {
			return stringRep;
		}

	}
	
}
