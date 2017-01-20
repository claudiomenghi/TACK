package ta;

import com.google.common.base.Preconditions;

public class AP {

	private final String name;
	
	public AP(String name){
		Preconditions.checkNotNull(name, "The name of the proposition cannot be null");
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
}
