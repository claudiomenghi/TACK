package ta.declarations;

import ta.expressions.Expression;

public class VariableDecl {

	/**
	 * The identifier
	 */
	private  String id;
	
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * The initializer
	 */
	private final Expression exp;

	/**
	 * The type of the variable
	 */
	private final String type;

	public VariableDecl(String type, String id, Expression exp) {
		
		this.type = type;
		this.id = id;
		this.exp = exp;
	}

	public String getId() {
		return id;
	}

	public Expression getExp() {
		return exp;
	}

	public String getType() {
		return type;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return type + " " + id + "=" + exp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exp == null) ? 0 : exp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		VariableDecl other = (VariableDecl) obj;
		if (exp == null) {
			if (other.exp != null)
				return false;
		} else if (!exp.equals(other.exp))
			return false;
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
		return true;
	}
}
