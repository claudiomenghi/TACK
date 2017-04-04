package formulae.mitli;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import formulae.UnaryFormula;
import formulae.mitli.TemporizedFormula;


public abstract class MITLIPast extends MITLIFormula implements TemporizedFormula, UnaryFormula<MITLIFormula> {

	private MITLIFormula subformula;

	public MITLIPast(MITLIFormula subformula) {
		Preconditions.checkNotNull(subformula, "The subformula cannot be null");
		this.subformula = subformula;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public MITLIFormula getChild() {
		return this.subformula;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MITLIFormula> getChildren() {
		Set<MITLIFormula> formulae=new HashSet<>();
		formulae.add(subformula);
		return formulae;
	}
}
