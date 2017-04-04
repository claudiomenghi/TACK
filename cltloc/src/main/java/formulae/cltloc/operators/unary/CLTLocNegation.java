package formulae.cltloc.operators.unary;

import com.google.common.base.Preconditions;

import formulae.UnaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocNegation extends CLTLocFormula implements UnaryFormula<CLTLocFormula> {

	// Formula f1 which is argument of the negation (\neg f1)
	private CLTLocFormula child;

	public final String operator = "!";

	private final int hash;

	public CLTLocNegation(CLTLocFormula subformula) {
		
		super();
		Preconditions.checkNotNull(subformula, "The subformula cannot be null");
		this.child = subformula;
		this.hash = this.hashComputation();
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula getChild() {
		return this.child;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return this.hash;
	}

	private int hashComputation() {
		final int prime = 31;
		int result = 1;
		result = prime * result + child.hashCode();
		result = prime * result +  operator.hashCode();
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
		CLTLocNegation other = (CLTLocNegation) obj;
		if (child == null) {
			if (other.child != null)
				return false;
		} else if (!child.equals(other.child))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.operator+"(" + child + ")";
	}
}
