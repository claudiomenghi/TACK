package formulae.mitli;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import formulae.BinaryFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLIDisjunction extends MITLIFormula implements BinaryFormula<MITLIFormula> {

	private final MITLIFormula leftChild;
	private final MITLIFormula rightChild;
	private final String operator = "OR";
	
	private final int hash;

	public MITLIDisjunction(MITLIFormula leftChild, MITLIFormula rightChild) {
		super();
		Preconditions.checkNotNull(leftChild, "The first subformula cannot be null");
		Preconditions.checkNotNull(rightChild, "The second subformula cannot be null");
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.hash=computeHash();

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
	public MITLIFormula getLeftChild() {
		return this.leftChild;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLIFormula getRightChild() {
		return this.rightChild;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return hash;
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MITLIDisjunction other = (MITLIDisjunction) obj;
		if (leftChild == null) {
			if (other.leftChild != null)
				return false;
		} else if (!leftChild.equals(other.leftChild))
			return false;
		if (rightChild == null) {
			if (other.rightChild != null)
				return false;
		} else if (!rightChild.equals(other.rightChild))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + this.leftChild + " " + operator + " " + this.rightChild + ")";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> getChildren() {
		Set<MITLIFormula> formulae=new HashSet<>();
		formulae.add(leftChild);
		formulae.add(rightChild);
		return formulae;
	}

	private int computeHash() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((leftChild == null) ? 0 : leftChild.hashCode());
		result = prime * result + ((rightChild == null) ? 0 : rightChild.hashCode());
		return result;
	}
}
