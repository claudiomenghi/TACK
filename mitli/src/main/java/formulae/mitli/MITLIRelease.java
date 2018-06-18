package formulae.mitli;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import formulae.BinaryFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLIRelease extends MITLIFormula implements BinaryFormula<MITLIFormula> {

	private final MITLIFormula subformula1;
	private final MITLIFormula subformula2;

	private final String operator = "R";

	private final int hash;

	public MITLIRelease(MITLIFormula subformula1, MITLIFormula subformula2) {
		super();
		Preconditions.checkNotNull(subformula1, "The first subformula cannot be null");
		Preconditions.checkNotNull(subformula2, "The second subformula cannot be null");
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
		this.hash = this.computeHash();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLIFormula getLeftChild() {
		return this.subformula1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLIFormula getRightChild() {
		return this.subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + this.subformula1 + " " + operator + " " + this.subformula2 + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> getChildren() {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.add(subformula1);
		formulae.add(subformula2);
		return formulae;
	}

	private int computeHash() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((subformula1 == null) ? 0 : subformula1.hashCode());
		result = prime * result + ((subformula2 == null) ? 0 : subformula2.hashCode());
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.hash;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MITLIRelease other = (MITLIRelease) obj;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (subformula1 == null) {
			if (other.subformula1 != null)
				return false;
		} else if (!subformula1.equals(other.subformula1))
			return false;
		if (subformula2 == null) {
			if (other.subformula2 != null)
				return false;
		} else if (!subformula2.equals(other.subformula2))
			return false;
		return true;
	}

}
