package formulae.cltloc.atoms;

import java.util.Set;

public class BoundedVariable extends Variable {

	private final Set<Integer> values;
	
	public BoundedVariable(String name, Set<Integer> values) {
		super(name);
		if(values==null){
			throw new NullPointerException("The values cannot be null");
		}
		if(values.isEmpty()){
			throw new IllegalArgumentException("The set of values cannot be null");
		}
		this.values=values;
	}

	public Set<Integer> getValues() {
		return values;
	}

}
