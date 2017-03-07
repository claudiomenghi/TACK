package ta.visitors;

import ta.AP;
import ta.TA;
import ta.expressions.EmptyExpression;
import ta.state.State;
import ta.transition.guard.BinaryClockConstraint;
import ta.transition.guard.ClockConstraintAtom;

public interface TAVisitor<T> {

	public T visit(TA ta);

	public T visit(AP ap);

	public T visit(State state);

	public T visit(EmptyExpression emptyExpression);

	public T visit(BinaryClockConstraint binaryClockConstraint);

	public T visit(ClockConstraintAtom clockConstraintAtom);
	
	

}
