package ta.expressions;

import ta.visitors.ExpressionVisitor;
import ta.visitors.TAVisitor;

public class Identifier extends Expression {

	private final String id;

	public Identifier(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public <T> T accept(TAVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
