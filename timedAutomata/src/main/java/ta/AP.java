package ta;

import com.google.common.base.Preconditions;

import ta.visitors.TAVisitor;

public class AP extends ModelElement{

	

	private final String name;
	
	public AP(String name){
		Preconditions.checkNotNull(name, "The name of the proposition cannot be null");
		this.name=name;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public <T> T accept(TAVisitor<T> t) {
		return t.visit(this);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return name;
	}
}
