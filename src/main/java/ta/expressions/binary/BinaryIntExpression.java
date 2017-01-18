package ta.expressions.binary;

import ta.expressions.Expression;

public class BinaryIntExpression extends BinaryOperator<Expression, Expression> {

private final BinaryIntOperator operator;
	
	public BinaryIntExpression(BinaryIntOperator operator, Expression exp1,  Expression exp2){
		super(exp1, exp2);
		this.operator=operator;
	}
	
	public BinaryIntOperator getOperator() {
		return operator;
	}

	// '+' | '-' | '*' | '/' | '%' | '&' | '|' | '^' | '<<' | '>>' 
	public enum BinaryIntOperator{
		
		PLUS("+"),
		MINUS("-"),
		MULT("*"),
		FRACT("/"),
		MOD("%"),
		AND("&"),
		OR("|"),
		POW("^"),
		LEFTSHIFT("<<"),
		RIGHTSHIFT(">>");
		
		private final String stringRep;
		
		private BinaryIntOperator(String rep){
			this.stringRep=rep;
		}

		public String getStringRep() {
			return stringRep;
		}

	}
}
