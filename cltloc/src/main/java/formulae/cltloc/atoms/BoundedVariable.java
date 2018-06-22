package formulae.cltloc.atoms;

import java.util.Set;

public class BoundedVariable extends Variable {

	private final Set<Integer> values;

	private BoundedVariable(String name, Set<Integer> values) {
		super(name);
		if (values == null) {
			throw new NullPointerException("The values cannot be null");
		}
		if (values.isEmpty()) {
			throw new IllegalArgumentException("The set of values cannot be null");
		}
		this.values = values;
	}

	public Set<Integer> getValues() {
		return values;
	}

	public static BoundedVariable getBoundedVariable(String name, Set<Integer> values) {
		return new BoundedVariable(name, values);

	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((values == null) ? 0 : values.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoundedVariable other = (BoundedVariable) obj;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}

}
