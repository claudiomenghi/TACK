package ta.expressions.binary;

import ta.expressions.Expression;

public class BinaryExpression<T extends Expression, S extends Expression> extends Expression {
	
	private final T leftChild;
	private final S rightChild;
	private final String operator;
	
	public BinaryExpression(T leftChild, String operator, S rightChild){
		this.leftChild=leftChild;
		this.rightChild=rightChild;
		this.operator=operator;
	}
	
	public T getLeftChild(){
		return this.leftChild;
	}
	
	public S getRightChild(){
		return this.rightChild;
	}

	public String getOperator() {
		return operator;
	}
}
