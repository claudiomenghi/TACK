package formulae;

/**
 * Contains a binary formula
 * 
 * @author Claudio Menghi
 *
 * @param <T>
 *            the type of the sub-formulae
 */
public interface BinaryFormula<T> {

	/**
	 * returns the left child of the formula
	 * 
	 * @return the left child of the formula
	 */
	public T getLeftChild();

	/**
	 * returns the right child of the formula
	 * 
	 * @return the right child of the formula
	 */
	public T getRightChild();
}
