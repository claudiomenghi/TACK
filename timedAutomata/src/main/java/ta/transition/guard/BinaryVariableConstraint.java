package ta.transition.guard;

import java.util.HashSet;
import java.util.Set;

import operators.PropositionalLogicOperator;
import ta.Variable;
import ta.expressions.binary.BinaryExpression;
import ta.visitors.Expression2CLTLocExpression;
import ta.visitors.ExpressionVisitor;
import ta.visitors.TAVisitor;

public class BinaryVariableConstraint extends BinaryExpression<VariableConstraint, PropositionalLogicOperator>
		implements VariableConstraint {

	public BinaryVariableConstraint(VariableConstraint leftChild, PropositionalLogicOperator operator,
			VariableConstraint rightChild) {
		super(leftChild, operator, rightChild);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(TAVisitor<T> visitor) {
		return visitor.visit(this);
	}
	@Override
	public formulae.cltloc.atoms.CLTLocArithmeticExpression accept(Expression2CLTLocExpression visitor) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> getVariables() {
		Set<Variable> clocks = new HashSet<>();
		clocks.addAll(this.getLeftChild().getVariables());
		clocks.addAll(this.getRightChild().getVariables());
		return clocks;
	}

}
