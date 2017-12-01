package formulae.cltloc.operators.binary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Preconditions;

import formulae.BinaryFormula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocConjunction extends CLTLocFormula implements BinaryFormula<CLTLocFormula> {

	private final CLTLocFormula subformula1;
	private final CLTLocFormula subformula2;
	public final String operator = "&&";
	private final int hash;

	private CLTLocConjunction(CLTLocFormula subformula1, CLTLocFormula subformula2) {

		Preconditions.checkNotNull(subformula1, "The first subformula cannot be null");
		Preconditions.checkNotNull(subformula2, "The second subformula cannot be null");
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
		this.hash = this.hashComputation();
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

	

	@Override
	public int hashCode() {
		return hash;
	}

	private int hashComputation() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
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
		CLTLocConjunction other = (CLTLocConjunction) obj;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
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
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + subformula1+ ") " + operator + " (" + subformula2 + ")";
	}
	
	public static CLTLocFormula getCLTLocConjunction(CLTLocFormula subformula1, CLTLocFormula subformula2){
		if(subformula1 instanceof CLTLocConjunction && subformula2 instanceof CLTLocConjunction){
			CLTLocConjunction f1=(CLTLocConjunction) subformula1;
			CLTLocConjunction f2=(CLTLocConjunction) subformula2;
			List<CLTLocFormula> formulae=new ArrayList<>();
			formulae.add(f1.getLeftChild());
			formulae.add(f1.getRightChild());
			formulae.add(f2.getLeftChild());
			formulae.add(f2.getRightChild());
			return new CLTLocNaryConjunction(formulae);
		}
		if(subformula1 instanceof CLTLocNaryConjunction && subformula2 instanceof CLTLocNaryConjunction){
			CLTLocNaryConjunction f1=(CLTLocNaryConjunction) subformula1;
			CLTLocNaryConjunction f2=(CLTLocNaryConjunction) subformula2;
			List<CLTLocFormula> formulae=new ArrayList<>();
			formulae.addAll(f1.getChildren());
			formulae.addAll(f2.getChildren());
			return new CLTLocNaryConjunction(formulae);
		}
		if(subformula1 instanceof CLTLocConjunction && subformula2 instanceof CLTLocNaryConjunction){
			CLTLocConjunction f1=(CLTLocConjunction) subformula1;
			CLTLocNaryConjunction f2=(CLTLocNaryConjunction) subformula2;
			List<CLTLocFormula> formulae=new ArrayList<>();
			formulae.add(f1.getLeftChild());
			formulae.add(f1.getRightChild());
			formulae.addAll(f2.getChildren());
			return new CLTLocNaryConjunction(formulae);
		}
		if(subformula1 instanceof CLTLocNaryConjunction && subformula2 instanceof CLTLocConjunction){
			CLTLocNaryConjunction f1=(CLTLocNaryConjunction) subformula1;
			CLTLocConjunction f2=(CLTLocConjunction) subformula2;
			List<CLTLocFormula> formulae=new ArrayList<>();
			formulae.add(f2.getLeftChild());
			formulae.add(f2.getRightChild());
			formulae.addAll(f1.getChildren());
			return new CLTLocNaryConjunction(formulae);
		}
		
		if(subformula1 instanceof CLTLocConjunction){
			CLTLocConjunction f1=(CLTLocConjunction) subformula1;
			List<CLTLocFormula> formulae=new ArrayList<>();
			formulae.add(f1.getLeftChild());
			formulae.add(f1.getRightChild());
			formulae.add(subformula2);
			return new CLTLocNaryConjunction(formulae);			
		}
		if(subformula2 instanceof CLTLocConjunction){
			CLTLocConjunction f2=(CLTLocConjunction) subformula2;
			List<CLTLocFormula> formulae=new ArrayList<>();
			formulae.add(f2.getLeftChild());
			formulae.add(f2.getRightChild());
			formulae.add(subformula1);
			return new CLTLocNaryConjunction(formulae);			
		}

		if(subformula1 instanceof CLTLocNaryConjunction ){
			CLTLocNaryConjunction f1=(CLTLocNaryConjunction) subformula1;
			List<CLTLocFormula> formulae=new ArrayList<>();
			formulae.addAll(f1.getChildren());
			formulae.add(subformula2);
			return new CLTLocNaryConjunction(formulae);
		}
		if(subformula2 instanceof CLTLocNaryConjunction ){
			CLTLocNaryConjunction f2=(CLTLocNaryConjunction) subformula2;
			List<CLTLocFormula> formulae=new ArrayList<>();
			formulae.addAll(f2.getChildren());
			formulae.add(subformula1);
			return new CLTLocNaryConjunction(formulae);
		}
		
			
		return new CLTLocConjunction(subformula1, subformula2);
	}
	
}
