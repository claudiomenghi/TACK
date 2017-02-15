package ta.declarations;

public class Variable<T> extends Atom {

	/**
	 * The identifier
	 */
	private final String id;
	/**
	 * The initializer
	 */
	private final Initializer exp;

	/**
	 * The type of the variable
	 */
	private final T type;

	public Variable(T type, String id, Initializer exp) {
		this.type = type;
		this.id = id;
		this.exp = exp;
	}

	public String getId() {
		return id;
	}

	public Initializer getExp() {
		return exp;
	}

	public T getType() {
		return type;
	}

	@Override
	public String toString() {
		return type + " " + id + "=" + exp;
	}

}
