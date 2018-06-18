package formulae.mitli;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import formulae.UnaryFormula;
import formulae.mitli.TemporizedFormula;

public abstract class MITLIEventually extends MITLIFormula implements TemporizedFormula, UnaryFormula<MITLIFormula> {

	private final MITLIFormula subformula;

	private final int hash;

	public MITLIEventually(MITLIFormula subformula) {
		super();
		Preconditions.checkNotNull(subformula, "The subFormula cannot be null");
		this.subformula = subformula;

		final int prime = 31;
		int result = 1;
		this.hash = prime * result + ((subformula == null) ? 0 : subformula.hashCode());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLIFormula getChild() {
		return this.subformula;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> getChildren() {
		Set<MITLIFormula> formulae = new HashSet<>();
		formulae.add(subformula);
		return formulae;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MITLIEventually other = (MITLIEventually) obj;
		if (subformula == null) {
			if (other.subformula != null)
				return false;
		} else if (!subformula.equals(other.subformula))
			return false;
		return true;
	}

}
