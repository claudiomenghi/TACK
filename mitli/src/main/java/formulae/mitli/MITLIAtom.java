package formulae.mitli;

import formulae.mitli.visitors.MITLIVisitor;

public class MITLIAtom extends MITLIFormula {

	private final String atomName;
	private final int hash;

	public MITLIAtom(String atom) {
		this.atomName = atom;
		this.hash = this.generateHash();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}

	private int generateHash() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atomName == null) ? 0 : atomName.hashCode());
		return result;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MITLIAtom other = (MITLIAtom) obj;
		if (atomName == null) {
			if (other.atomName != null)
				return false;
		} else if (!atomName.equals(other.atomName))
			return false;
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString(){
		return this.atomName;
	}

}
