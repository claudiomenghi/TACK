package formulae.mitli;

import formulae.mitli.TemporizedFormula;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLIGlobally_AtoInf extends MITLIGlobally implements TemporizedFormula {

	
	private final int a;

	private final String operator = "G";
	
	private final int hash;

	public MITLIGlobally_AtoInf(MITLIFormula subformula, int a) {
		super(subformula);
		this.a = a;

		this.maxIntComparedto(a);
		this.hash=computeHash();
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
		return "(" + this.operator + "(" + String.valueOf(a) + ",+oo)" + this.getChild() + ")";
	}
	
	

	private int computeHash() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		return result;
	}
	@Override
	public int hashCode() {
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MITLIGlobally_AtoInf other = (MITLIGlobally_AtoInf) obj;
		if (a != other.a)
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		return true;
	}

}
