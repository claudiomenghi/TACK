package formulae.cltloc.atoms;

import com.google.common.base.Preconditions;

import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocArithmeticExpression extends Atom implements Expression {

	private final Expression leftChild;
	private final Expression rightChild;
	private final String operator;

	public CLTLocArithmeticExpression(Expression leftChild, String operator, Expression rightChild) {
		Preconditions.checkNotNull(leftChild, "The left child cannot be null");
		Preconditions.checkNotNull(rightChild, "The right child cannot be null");
		Preconditions.checkNotNull(operator, "The operator  cannot be null");
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.operator = operator;
	}

	public Expression getLeftChild() {
		return this.leftChild;
	}

	public Expression getRightChild() {
		return this.rightChild;
	}

	public String getOperator() {
		return operator;
	}

	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + leftChild + ")" + operator + "(" + rightChild + ")";
	}

}
