package formulae.cltloc.atoms;

import com.google.common.base.Preconditions;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

public class AssignNextVariable extends CLTLocFormula {

	

	public  formulae.cltloc.atoms.Expression getNextExpression() {
		return nextVariable;
	}

	private final Variable variable;
	private final  formulae.cltloc.atoms.Expression nextVariable;

	public AssignNextVariable(Variable variable,  formulae.cltloc.atoms.Expression nextVariable) {
		super();

		Preconditions.checkNotNull(variable, "The variable cannot be null");
		this.variable = variable;
		this.nextVariable=nextVariable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((variable == null) ? 0 : variable.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignNextVariable other = (AssignNextVariable) obj;
		if (variable == null) {
			if (other.variable != null)
				return false;
		} else if (!variable.equals(other.variable))
			return false;
		return true;
	}

	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}

	public Variable getVariable() {
		return variable;
	}
	
	@Override
	public String toString() {
		return "X("  + nextVariable + ") = "+ variable;
	}

}
