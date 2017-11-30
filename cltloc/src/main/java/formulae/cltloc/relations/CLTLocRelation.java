package formulae.cltloc.relations;

import com.google.common.base.Preconditions;

import formulae.BinaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.Atom;
import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocRelation extends CLTLocFormula implements BinaryFormula<formulae.cltloc.atoms.Expression> {

	private final Atom subformula1;
	private final formulae.cltloc.atoms.Expression subformula2;
	private final Relation relation;
	

	private final int hash;
	

	public CLTLocRelation(Atom subformula1, formulae.cltloc.atoms.Expression subformula2, Relation relation) {
		super();
		Preconditions.checkNotNull(subformula1, "The first subformula cannot be null");
		Preconditions.checkNotNull(subformula2, "The second subformula cannot be null");
		Preconditions.checkNotNull(relation, "The relation cannot be null");
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
		this.relation = relation;
		this.hash=hashComputation();
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Atom getLeftChild() {
		return subformula1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public formulae.cltloc.atoms.Expression getRightChild() {
		return subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}

	public Relation getRelation() {
		return relation;
	}

	@Override
	public int hashCode() {
		return this.hash;
	}
	
	private int hashComputation() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((relation == null) ? 0 : relation.hashCode());
		result = prime * result + ((subformula1 == null) ? 0 : subformula1.hashCode());
		result = prime * result + ((subformula2 == null) ? 0 : subformula2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CLTLocRelation other = (CLTLocRelation) obj;
		if (relation == null) {
			if (other.relation != null)
				return false;
		} else if (!relation.equals(other.relation))
			return false;
		if (subformula1 == null) {
			if (other.subformula1 != null)
				return false;
		} else if (!subformula1.equals(other.subformula1))
			return false;
		if (subformula2 == null) {
			if (other.subformula2 != null)
				return false;
		} else if (!subformula2.equals(other.subformula2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return subformula1.toString() + this.relation + subformula2.toString();
	}
}
