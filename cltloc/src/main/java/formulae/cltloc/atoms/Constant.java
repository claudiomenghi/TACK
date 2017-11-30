package formulae.cltloc.atoms;

import java.util.HashMap;

import formulae.cltloc.visitor.CLTLocVisitor;

public class Constant extends Atom implements Expression {

	private final String value;
	private final int hash;

	private final static HashMap<Integer, Constant> map=new HashMap<>();
	
	public Constant(int value) {
		super();
		this.value = Integer.toString(value);

		final int prime = 31;
		int result = 1;
		result = prime * result + this.value.hashCode();
		hash = result;
	}
	
	public static Constant getConstant(int value){
		if(map.containsKey(value)){
			return map.get(value);
		}
		else{
			Constant c=new Constant(value);
			map.put(value, c);
			return c;
		}
	}

	public Constant(String value) {
		super();
		this.value = value;

		final int prime = 31;
		int result = 1;
		result = prime * result + value.hashCode();
		hash = result;
	}

	@Override
	public int hashCode() {
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Constant other = (Constant) obj;
		if (!value.equals(other.value))
			return false;
		return true;
	}

	public String getValue(){
		return this.value;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return value;
	}

	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}
}
