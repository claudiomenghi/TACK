package ta.transition.guard;

import java.util.HashSet;
import java.util.Set;

import operators.PropositionalLogicOperator;
import ta.Clock;
import ta.expressions.binary.BinaryExpression;
import ta.visitors.Expression2CLTLocExpression;
import ta.visitors.ExpressionVisitor;
import ta.visitors.TAVisitor;

public class BinaryClockConstraint extends BinaryExpression<ClockConstraint, PropositionalLogicOperator>
		implements ClockConstraint {

	public BinaryClockConstraint(ClockConstraint leftChild, PropositionalLogicOperator operator,
			ClockConstraint rightChild) {
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
	public Set<Clock> getClocks() {
		Set<Clock> clocks = new HashSet<>();
		clocks.addAll(this.getLeftChild().getClocks());
		clocks.addAll(this.getRightChild().getClocks());
		return clocks;
	}

}
