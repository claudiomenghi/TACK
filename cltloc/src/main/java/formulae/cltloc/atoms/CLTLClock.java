package formulae.cltloc.atoms;

import com.google.common.base.Preconditions;

import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLClock extends CLTLocAtom {

	private final int hash;
	private final String clockName;

	public CLTLClock(String name) {
		super();
		Preconditions.checkNotNull(name, "The clock name cannot be null");
		this.clockName = name;
		this.hash = clockName.hashCode();
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
		return true;
	}
}
