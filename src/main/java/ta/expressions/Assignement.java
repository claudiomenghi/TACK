package ta.expressions;

import java.util.ArrayList;
import java.util.List;

public class Assignement {

	List<Expression> assigmenents;
	
	public Assignement(List<Expression> assigmenents){
		assigmenents=new ArrayList<>(assigmenents);
	}
	
	public void addExpression(Expression e){
		this.assigmenents.add(e);
	}
}
