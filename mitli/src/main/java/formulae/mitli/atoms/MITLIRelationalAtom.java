package formulae.mitli.atoms;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import formulae.mitli.MITLIFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLIRelationalAtom extends MITLIAtom {

	

	private final String identifier;
	private final String operator;
	private final int value;
	private final int hash;

	public MITLIRelationalAtom(String identifier, String operator, int value) {
		Preconditions.checkNotNull(identifier, "The identifier cannot be nulll");
		Preconditions.checkNotNull(operator, "The operator cannot be nulll");
		Preconditions.checkArgument(value >= 0, "The value must be grather than or equal to zero");
		this.identifier = identifier;
		this.operator = operator;
		this.value = value;
		this.hash = this.privateHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return this.hash;
	}

	public String getOperator() {
		return operator;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	public int getValue() {
		return value;
	}
	
	private int privateHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + value;
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
		MITLIRelationalAtom other = (MITLIRelationalAtom) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "("+identifier+" "+operator+" "+ value+")";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> getChildren() {
		Set<MITLIFormula> formulae=new HashSet<>();
		return formulae;
	}

}
