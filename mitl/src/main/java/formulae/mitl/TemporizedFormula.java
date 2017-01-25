package formulae.mitl;

/**
 * contains a Temporized formula
 *
 */
public interface TemporizedFormula {

	/**
	 * returns the upper time bound
	 * @return the upper time bound
	 */
	public int upperbound();
	
	/**
	 * returns the lower time bound
	 * @return the lower time bound
	 */
	public int lowerbound();
	
}
