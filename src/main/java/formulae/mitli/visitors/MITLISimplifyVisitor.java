package formulae.mitli.visitors;

import java.util.List;

import formulae.Formula;
import formulae.mitl.MITLFormula;
import formulae.mitli.MITLIAtom;
import formulae.mitli.MITLIConjunction;
import formulae.mitli.MITLIDisjunction;
import formulae.mitli.MITLIFalse;
import formulae.mitli.MITLIFormula;
import formulae.mitli.MITLIGlobally_AtoB;
import formulae.mitli.MITLIGlobally_AtoInf;
import formulae.mitli.MITLIIff;
import formulae.mitli.MITLIImplies;
import formulae.mitli.MITLINegation;
import formulae.mitli.MITLISince;
import formulae.mitli.MITLITrue;
import formulae.mitli.MITLIUntil;

public class MITLISimplifyVisitor<T> implements MITLIVisitor<T> {

	@Override
	public T visit(MITLITrue mitliTrue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(MITLIFalse formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(MITLIAtom formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(MITLIConjunction formula) {
		MITLIFormula[] formulae = new MITLIFormula[subformulae.size()];

		int i = 0;
		for (MITLIFormula f : subformulae) {
			formulae[i] = (MITLIFormula) f.simplify();
			i++;
		}

		return new MITLIConjunction(formulae);
	}

	@Override
	public T visit(MITLIDisjunction formula) {

		MITLIFormula[] formulae = new MITLIFormula[subformulae.size()];

		int i = 0;
		for (MITLIFormula f : subformulae) {
			formulae[i] = (MITLIFormula) f.simplify();
			i++;
		}

		return new MITLIDisjunction(formulae);
	}

	@Override
	public T visit(MITLINegation mitliNegation) {
		if (subformula.getClass() == MITLINegation.class) {
			List<Formula> l = subformula.subformulae();
			return ((MITLFormula) l.get(0)).simplify();
		} else
			return new MITLINegation((MITLIFormula) subformula.simplify());
	}

	@Override
	public T visit(MITLIUntil formula) {
		return new MITLIUntil((MITLIFormula) subformula1.simplify(), (MITLIFormula) subformula2.simplify());
	}

	@Override
	public T visit(MITLIImplies mitliImplies) {
		return new MITLIImplies((MITLIFormula) subformula1.simplify(), (MITLIFormula) subformula2.simplify());
	}

	@Override
	public T visit(MITLIIff formula) {
		return new MITLIIff((MITLIFormula) subformula1.simplify(), (MITLIFormula) subformula2.simplify());
	}

	@Override
	public T visit(MITLISince formula) {
		return new MITLISince((MITLIFormula) subformula1.simplify(), (MITLIFormula) subformula2.simplify());
	}

	@Override
	public T visit(MITLIGlobally_AtoInf mitliGlobally_AtoInf) {
		return new MITLIGlobally_AtoInf((MITLIFormula) subformula.simplify(), a);
	}

	@Override
	public T visit(MITLIGlobally_AtoB mitliGlobally_AtoB) {
		return new MITLIGlobally_AtoB((MITLIFormula) subformula.simplify(), a, b);
	}

}
