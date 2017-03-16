package formulae.cltloc.relations;

public enum Relation {

	EQ("="), LEQ("<="), LE("<"), GEQ(">="), GE(">");

	private final String relationSymbol;

	private Relation(String relationSymbol) {
		this.relationSymbol = relationSymbol;
	}

	public String toString() {
		return this.relationSymbol;
	}

	public static Relation parse(String value) {
		switch (value) {
		case "=":
			return Relation.EQ;
		case "==":
			return Relation.EQ;
		case "<=":
			return Relation.LEQ;
		case "<":
			return Relation.LE;
		case ">=":
			return Relation.GEQ;
		case ">":
			return Relation.GE;

		default:
			throw new IllegalArgumentException("Operator " + value + " not present");
		}
	}
	
	
}
