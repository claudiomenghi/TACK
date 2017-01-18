package ta.expressions;

public class Identifier extends Expression {

	private final String id;

	public Identifier(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
