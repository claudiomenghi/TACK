package ta;

import com.google.common.base.Preconditions;


/**
 * Class that describes a clock
 * 
 * @author Claudio Menghi
 *
 */
public class Variable {

	/**
	 * The name of the class
	 */
	private final String name;

	

	private final int hash;

	/**
	 * creates a new clock
	 * 
	 * @param name
	 *            the name of the clock
	 * @throws NullPointerException
	 *             if the name is null
	 */
	public Variable(String name) {
		Preconditions.checkNotNull(name, "The name of the clock cannot be null");
		
		this.name = name;
		this.hash = name.hashCode();
	}

	/**
	 * returns the name of the clock
	 * 
	 * @return the name of the clock
	 */
	public String getName() {
		return name;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variable other = (Variable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return name;
	}
}
