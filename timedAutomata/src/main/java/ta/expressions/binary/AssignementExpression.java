package ta.expressions.binary;

import ta.expressions.Expression;

public class AssignementExpression extends BinaryArithmeticExpression<Expression, Expression>{
	
	
	public AssignementExpression(Expression exp1,  String operator, Expression exp2){
		super(exp1, operator, exp2);
	}
	


	//| '+=' | '-=' | '*=' | '/=' | '%=' | '|=' | '&=' | '^=' | '<<=' | '>>='
	public enum AssignementOperator{
		
		PLUSEQUAL("+="),
		MINUSEQUAL("-="),
		MULTEQUAL("*="),
		FRACTEQUAL("/="),
		MODEQUAL("%="),
		PIPEEQ("|="),
		ANDQEUAL("&="),
		APQEUAL("^="),
		LLEQ("<<="),
		GGEQ(">>="),
		COMEQ(":="),
		EQ("=");
		
		private final String stringRep;
		
		private AssignementOperator(String rep){
			this.stringRep=rep;
		}

		public String getStringRep() {
			return stringRep;
		}

	}
}
