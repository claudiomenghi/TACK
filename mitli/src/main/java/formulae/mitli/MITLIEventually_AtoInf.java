package formulae.mitli;

import formulae.mitli.TemporizedFormula;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLIEventually_AtoInf extends MITLIEventually implements TemporizedFormula {

	
	private final int a;
	
	private final String operator = "F";

	private final int hash;

	public MITLIEventually_AtoInf(MITLIFormula subformula, int a) {
		super(subformula);
		this.a = a;

		this.maxIntComparedto(a);
		this.hash=this.computeHash();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int upperbound() {
		return -1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int lowerbound() {
		return a;
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
		return "(" + this.operator + "(" + String.valueOf(a) + ",+oo]" + this.getChild() + ")";
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
	return this.hash;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MITLIEventually_AtoInf other = (MITLIEventually_AtoInf) obj;
		if (a != other.a)
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		return true;
	}

	private int computeHash() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + a;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		return result;
	}

}
