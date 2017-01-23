package formulae;

import com.google.common.base.Preconditions;

/**
 * Contains a generic formula
 * 
 * @author Claudio Menghi
 */
public abstract class Formula {

	/**
	 * the textual version of the formula
	 */
	private final String formulaText;

	/**
	 * creates a formula specified by the given string
	 * 
	 * @param formula
	 *            the string representation of the formula to be creates
	 * @throws NullPointerException
	 *             if the string representation of the formula to be created is
	 *             null
	 */
	public Formula(String formula) {
		Preconditions.checkNotNull(formula, "The string representation of the formula cannot be null");
		this.formulaText = formula;
	}

	/**
	 * returns the textual description of the formula
	 * 
	 * @return the textual description of the formula
	 */
	public String strFormula() {
		return formulaText;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formulaText == null) ? 0 : formulaText.hashCode());
		return result;
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
		Formula other = (Formula) obj;
		if (formulaText == null) {
			if (other.formulaText != null)
				return false;
		} else if (!formulaText.equals(other.formulaText))
			return false;
		return true;
	}
}
