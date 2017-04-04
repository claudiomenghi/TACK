package formulae.mitli;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import formulae.UnaryFormula;
import formulae.mitli.TemporizedFormula;

public abstract class MITLIEventually extends MITLIFormula implements TemporizedFormula, UnaryFormula<MITLIFormula> {

	private final MITLIFormula subformula;

	public MITLIEventually(MITLIFormula subformula) {
		super();
		Preconditions.checkNotNull(subformula, "The subFormula cannot be null");
		this.subformula = subformula;
	}

	/**
	 * {@inheritDoc}
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
