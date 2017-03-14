package operators;

public enum PropositionalLogicOperator {
	AND("&&"), OR("||"), NOT("!");

	private final String operaor;

	private PropositionalLogicOperator(String operator) {
		this.operaor = operator;
	}

	public String toString() {
		return this.operaor;
	}
	
	public static PropositionalLogicOperator parse(String value){
		switch(value){
			case "&&": return PropositionalLogicOperator.AND;
			case "||": return PropositionalLogicOperator.OR;
			case "!": return PropositionalLogicOperator.NOT;
			default:
				throw new IllegalArgumentException("Operator "+value+" not present");
		}
	}
}