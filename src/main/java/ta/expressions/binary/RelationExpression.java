
package ta.expressions.binary;

import ta.expressions.Expression;

public class RelationExpression extends BinaryOperator<Expression, Expression> {

	private final RelOperator operator;
	
	public RelationExpression(RelOperator operator, Expression exp1,  Expression exp2){
		super(exp1, exp2);
		this.operator=operator;
	}
	
	public RelOperator getOperator() {
		return operator;
	}

	// '<' | '<=' | '==' | '!=' | '>=' | '>'
	public enum RelOperator{
		
		LE("<"),
		LEQ("<="),
		EQ("=="),
		NEQ("!="),
		GEQ(">="),
		GE(">");
		
		private final String stringRep;
		
		private RelOperator(String rep){
			this.stringRep=rep;
		}

		public String getStringRep() {
			return stringRep;
		}

	}
}
