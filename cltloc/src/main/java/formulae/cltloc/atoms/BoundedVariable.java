package formulae.cltloc.atoms;

import java.util.Set;

public class BoundedVariable extends Variable {

	private final Set<Integer> values;
	
	public BoundedVariable(String name, Set<Integer> values) {
		super(name);
		this.values=values;
	}

	public Set<Integer> getValues() {
		return values;
	}

}
