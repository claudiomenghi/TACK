package formulae.cltloc.relations;

import formulae.BinaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

public abstract class CLTLocRelation extends CLTLocFormula implements BinaryFormula<CLTLocFormula> {

	private final CLTLocFormula subformula1;
	private final CLTLocFormula subformula2;
	private final String relation;

	public CLTLocRelation(CLTLocFormula subformula1, CLTLocFormula subformula2, String relation) {
		super(new String("(" + relation + " " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
		this.relation = relation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula getLeftChild() {
		return subformula1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CLTLocFormula getRightChild() {
		return subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}

	public String getRelation() {
		return relation;
	}
}
