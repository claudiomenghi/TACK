package formulae.mitl;


import formulae.BinaryFormula;
import formulae.mitl.visitors.MITLVisitor;

public class MITLUntil extends MITLFormula implements BinaryFormula<MITLFormula>{

	
	private MITLFormula subformula1, subformula2;
	
	public MITLUntil(MITLFormula subformula1, MITLFormula subformula2){
		super(new String("(U " + subformula1.strFormula() + " " + subformula2.strFormula() + ")"));
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(MITLVisitor<T> visitor) {
		return visitor.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLFormula getLeftChild() {
		return subformula1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MITLFormula getRightChild() {
		return subformula2;
	}
}
