package ta.transition.assignments;

import com.google.common.base.Preconditions;

import formulae.cltloc.CLTLocFormula;
import ta.Variable;
import ta.expressions.Expression;
import ta.visitors.Expression2CLTLoc;

public class VariableAssignement extends Assignment {
	private final Variable variable;
	private final Expression expression;

	public VariableAssignement(Variable variable, Expression expression) {
		Preconditions.checkNotNull(variable, "The variable cannot be null");
		Preconditions.checkNotNull(expression, "The expression assigned to the variable  cannot be null");
		this.variable = variable;
		this.expression = expression;
	}

	public Variable getVariable() {
		return this.variable;
	}

	public Expression getValue() {
		return this.expression;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expression == null) ? 0 : expression.hashCode());
		result = prime * result + ((variable == null) ? 0 : variable.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VariableAssignement other = (VariableAssignement) obj;
		if (expression == null) {
			if (other.expression != null)
				return false;
		} else if (!expression.equals(other.expression))
			return false;
		if (variable == null) {
			if (other.variable != null)
				return false;
		} else if (!variable.equals(other.variable))
			return false;
		return true;
	}

	public CLTLocFormula accept(Expression2CLTLoc visitor) {
		return visitor.visit(this);
	}

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return variable + "=" + expression;
	}
}
