package formulae.mitli;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import formulae.UnaryFormula;
import formulae.mitli.visitors.MITLIVisitor;

public class MITLINegation extends MITLIFormula implements UnaryFormula<MITLIFormula> {

	// Formula f1 which is argument of the negation (\neg f1)
	private MITLIFormula subformula;

	private final String operator = "NEG";

	private final int hash;

	public MITLINegation(MITLIFormula subformula) {

		Preconditions.checkNotNull(subformula, "The subformula cannot be null");
		this.subformula = subformula;
		this.hash = computeHash();
	}

	@Override
	public <T> T accept(MITLIVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public MITLIFormula getChild() {
		return this.subformula;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + this.operator + this.getChild() + ")";
	}

	private int computeHash() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((subformula == null) ? 0 : subformula.hashCode());
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
		MITLINegation other = (MITLINegation) obj;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (subformula == null) {
			if (other.subformula != null)
				return false;
		} else if (!subformula.equals(other.subformula))
			return false;
		return true;
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
}
