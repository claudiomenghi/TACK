package ta.expressions.binary;

import ta.expressions.Expression;

public class AssignementExpression extends BinaryOperator<Expression, Expression>{
	
	private final AssignementOperator operator;
	
	public AssignementExpression(AssignementOperator operator, Expression exp1,  Expression exp2){
		super(exp1, exp2);
		this.operator=operator;
	}
	
	public AssignementOperator getOperator() {
		return operator;
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
		COMEQ(":=");
		
		private final String stringRep;
		
		private AssignementOperator(String rep){
			this.stringRep=rep;
		}

		public String getStringRep() {
			return stringRep;
		}

	}
}
