package formulae.cltloc.atoms;

import formulae.cltloc.visitor.CLTLocVisitor;

public class Constant extends Atom{

	private final int value;
	private final int hash;

	public Constant(int value) {
		super();
		this.value = value;

		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		hash = result;
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
		Constant other = (Constant) obj;
		if (value != other.value)
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return Integer.toString(value);
	}

	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}
}
