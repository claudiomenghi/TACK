package ta;

import java.util.Set;

public class FiniteVariable extends Variable {

	private Set<Integer> values;
	
	public FiniteVariable(String name, Set<Integer> values) {
		super(name);
		this.values = values;
	}

	/**
	 * returns the set of values that can be assigned to the final values
	 * @return the set of values that can be assigned to the final values
	 */
	public Set<Integer> getValues() {
		return values;
	}

	@Override
	public String toString() {
		return this.getName()+"{" + values + "}";
	}


}
