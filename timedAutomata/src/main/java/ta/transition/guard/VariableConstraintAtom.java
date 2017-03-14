package ta.transition.guard;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import ta.Variable;
import ta.visitors.TAVisitor;

public class VariableConstraintAtom implements VariableConstraint{

	private final Variable variable;
	private final int value;
	private final VariableConstraintAtomOperator operator;

	public VariableConstraintAtom(Variable variable,VariableConstraintAtomOperator operator,  int value) {
		Preconditions.checkNotNull(variable, "The variable cannot be null");
		this.variable = variable;
		this.value = value;
		this.operator = operator;
	}

	public Variable getVariable() {
		return variable;
	}

	public int getValue() {
		return value;
	}

	public VariableConstraintAtomOperator getOperator() {
		return operator;
	}

	public enum VariableConstraintAtomOperator {
		LE("<"), LEQ("<="), GE(">"), GEQ(">="), EQ("==");

		private final String operaor;

		private VariableConstraintAtomOperator(String operator) {
			this.operaor = operator;
		}

		public static VariableConstraintAtomOperator parse(String value){
			switch(value){
				case "<": return VariableConstraintAtomOperator.LE;
				case "<=": return VariableConstraintAtomOperator.LEQ;
				case ">": return VariableConstraintAtomOperator.GE;
				case ">=": return VariableConstraintAtomOperator.GEQ;
				case "==": return VariableConstraintAtomOperator.EQ;
				default:
					throw new IllegalArgumentException("Operator "+value+" not present");
			}
		}
		public String toString() {
			return this.operaor;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Variable> getVariables() {
		Set<Variable> clocks = new HashSet<>();
		clocks.add(variable);
		return clocks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <R> R accept(TAVisitor<R> visitor) {
		return visitor.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return  variable.toString() + operator +  value ;
	}
}
