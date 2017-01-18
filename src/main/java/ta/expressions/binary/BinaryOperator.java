package ta.expressions.binary;

import ta.expressions.Expression;

public abstract class BinaryOperator<T extends Expression, S extends Expression> {
	
	private final T leftChild;
	private final S rightChild;
	
	public BinaryOperator(T leftChild, S rightChild){
		this.leftChild=leftChild;
		this.rightChild=rightChild;
	}
	
	public T getLeftChild(){
		return this.leftChild;
	}
	public S getRightChild(){
		return this.rightChild;
	}
}
