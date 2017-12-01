package formulae.cltloc.operators.binary;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

import formulae.NaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocNaryDisjunction extends CLTLocFormula implements NaryFormula<CLTLocFormula> {

	private final List<CLTLocFormula> formulae;
	public final String operator = "||";
	private final int hash;

	public CLTLocNaryDisjunction(List<CLTLocFormula> formulae) {

		Preconditions.checkNotNull(formulae, "The set subformulae cannot be null");
		this.formulae = formulae;
		this.hash = this.hashComputation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}

	

	@Override
	public int hashCode() {
		return hash;
	}

	private int hashComputation() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((formulae == null) ? 0 : formulae.hashCode());
		result = prime * result + ((formulae == null) ? 0 : formulae.hashCode());
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
		CLTLocNaryDisjunction other = (CLTLocNaryDisjunction) obj;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (formulae == null) {
			if (other.formulae != null)
				return false;
		} else if (!formulae.equals(other.formulae))
			return false;
		if (formulae == null) {
			if (other.formulae != null)
				return false;
		} else if (!formulae.equals(other.formulae))
			return false;
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return StringUtils.join(formulae, operator);
	}

	@Override
	public List<CLTLocFormula> getChildren() {
		return formulae;
	}
}
