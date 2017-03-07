package ta.expressions.binary;

import ta.expressions.Expression;

public abstract class BinaryExpression<T, O> extends Expression {

	private final T leftChild;
	private final T rightChild;
	private final O operator;

	public BinaryExpression(T leftChild, O operator, T rightChild) {
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.operator = operator;
	}

	public T getLeftChild() {
		return this.leftChild;
	}

	public T getRightChild() {
		return this.rightChild;
	}

	public O getOperator() {
		return operator;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + leftChild + ")" + operator + "(" + rightChild + ")";
	}

}
