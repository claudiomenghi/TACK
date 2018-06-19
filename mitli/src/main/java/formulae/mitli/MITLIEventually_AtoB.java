package formulae.mitli;

import formulae.mitli.TemporizedFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLIEventually_AtoB extends MITLIEventually implements TemporizedFormula {

	private final int a, b;

	private final String operator = "F";

	private final int hash;

	public MITLIEventually_AtoB(MITLIFormula subformula, int a, int b) {
		super(subformula);
		this.a = a;
		this.b = b;

		subformula.maxIntComparedto(b - a);
		this.maxIntComparedto(b);
		this.hash = this.computeHash();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int upperbound() {
		return b;
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
		return "(" + this.operator + "(" + String.valueOf(a) + "," + String.valueOf(b) + ")" + this.getChild() + ")";
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return hash;
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
		MITLIEventually_AtoB other = (MITLIEventually_AtoB) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
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
		result = prime * result + b;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		return result;
	}
}
