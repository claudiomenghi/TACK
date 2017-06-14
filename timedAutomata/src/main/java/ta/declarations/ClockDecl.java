package ta.declarations;

import ta.expressions.Value;

public class ClockDecl {

	/**
	 * The identifier
	 */
	private String id;
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * The initializer
	 */
	private final Value value;

	/**
	 * The type of the variable
	 */
	private final String type;

	public ClockDecl(String type, String id, Value value) {
		this.type = type;
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public Value getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return type + " " + id + "=" + value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClockDecl other = (ClockDecl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}


}
