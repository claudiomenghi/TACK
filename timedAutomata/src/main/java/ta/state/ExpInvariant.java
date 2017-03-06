package ta.state;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.relations.CLTLocGEQRelation;
import formulae.cltloc.relations.CLTLocGERelation;
import formulae.cltloc.relations.CLTLocLEQRelation;
import formulae.cltloc.relations.CLTLocLERelation;
import ta.expressions.Expression;
import ta.expressions.Identifier;
import ta.visitors.TA2CLTLoc;

public class ExpInvariant extends Invariant {

	private final Identifier id;
	private final Expression exp;
	private final String operator;

	public ExpInvariant(Identifier id, String operator, Expression exp) {
		this.id = id;
		this.exp = exp;
		this.operator = operator;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula accept(TA2CLTLoc ta2cltLoc) {

		switch (operator) {
		case ">":
			return new CLTLocGERelation(new Variable(id.getId()), new Constant(exp.evaluate()));
		case ">=":
			return new CLTLocGEQRelation(new Variable(id.getId()), new Constant(exp.evaluate()));
		case "<":
			return new CLTLocLERelation(new Variable(id.getId()), new Constant(exp.evaluate()));
		case "<=":
			return new CLTLocLEQRelation(new Variable(id.getId()), new Constant(exp.evaluate()));

		default:
			throw new IllegalArgumentException("Operator: " + operator + " not supported");
		}
	}
}
