package formulae.mitli;

import formulae.mitli.TemporizedFormula;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLIPast_AtoB extends MITLIPast implements TemporizedFormula {

	
	private final int a, b;

	private final String operator = "P";
	
	private final int hash;
	
	public MITLIPast_AtoB(MITLIFormula subformula, int a, int b) {
		super(subformula);
		this.a = a;
		this.b = b;

		subformula.maxIntComparedto(b - a);
		this.hash=computeHash();
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
	
	@Override
	public int hashCode() {
		return this.hash;
	}
	
	private int computeHash() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
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
		MITLIPast_AtoB other = (MITLIPast_AtoB) obj;
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

}
