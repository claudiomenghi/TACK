package ta.visitors;

import ta.AP;
import ta.StateAP;
import ta.TA;
import ta.VariableAssignementAP;
import ta.expressions.EmptyExpression;
import ta.state.State;
import ta.transition.assignments.ClockAssignement;
import ta.transition.guard.BinaryClockConstraint;
import ta.transition.guard.BinaryVariableConstraint;
import ta.transition.guard.ClockConstraintAtom;
import ta.transition.guard.VariableConstraintAtom;

public interface TAVisitor<T> {

	public T visit(TA ta);

	public T visit(AP ap);

	public T visit(State state);

	public T visit(EmptyExpression emptyExpression);

	public T visit(BinaryClockConstraint binaryClockConstraint);

	public T visit(ClockConstraintAtom clockConstraintAtom);

	public T visit(VariableConstraintAtom variableConstraintAtom);

	public T visit(BinaryVariableConstraint binaryVariableConstraint);

	public T visit(ClockAssignement clockAssignement);
	
	public T visit(VariableAssignementAP ap);

	public T visit(StateAP ap);
}
