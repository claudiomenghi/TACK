package formulae.mitli.visitors;

import formulae.mitli.MITLIAtom;
import formulae.mitli.MITLIConjunction;
import formulae.mitli.MITLIDisjunction;
import formulae.mitli.MITLIFalse;
import formulae.mitli.MITLIFormula;
import formulae.mitli.MITLIGlobally;
import formulae.mitli.MITLIGlobally_AtoB;
import formulae.mitli.MITLIGlobally_AtoInf;
import formulae.mitli.MITLIIff;
import formulae.mitli.MITLIImplies;
import formulae.mitli.MITLINegation;
import formulae.mitli.MITLISince;
import formulae.mitli.MITLITrue;
import formulae.mitli.MITLIUntil;

public class MITLIUpdateVisitor implements MITLIVisitor<MITLIFormula> {

	@Override
	public MITLIFormula visit(MITLITrue mitliTrue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MITLIFormula visit(MITLIFalse formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MITLIFormula visit(MITLIAtom formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MITLIFormula visit(MITLIConjunction formula) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them
		// method can be simplified

		for (MITLIFormula f : subformulae) {

			int p = l.indexOf(f);

			// if subformulae contains a subformula in list l and the the two
			// subformulae are different (different instances)
			if (l.contains(f) && (l.get(p) != f)) {

				// get the index of f in subformulae
				int q = subformulae.indexOf(f);

				// replace f with l
				subformulae.set(q, (MITLIFormula) l.get(p));
				l.indexOf(f);
			}
		}

		return this;
	}

	@Override
	public MITLIFormula visit(MITLIDisjunction formula) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them
		// TODO: method can be simplified

		for (MITLIFormula f : subformulae) {

			int p = l.indexOf(f);

			// if subformulae contains a subformula in list l and the the two
			// subformulae are different (different instances)
			if (l.contains(f) && (l.get(p) != f)) {

				// get the index of f in subformulae
				int q = subformulae.indexOf(f);

				// replace f with l
				subformulae.set(q, (MITLIFormula) l.get(p));
				l.indexOf(f);
			}
		}
	}

	@Override
	public MITLIFormula visit(MITLINegation mitliNegation) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them

		subformula = (MITLIFormula) l.get(0);
		return this;
	}

	@Override
	public MITLIFormula visit(MITLIUntil formula) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them

		subformula1 = (MITLIFormula) l.get(0);
		subformula2 = (MITLIFormula) l.get(1);
		return this;
	}

	@Override
	public MITLIFormula visit(MITLIImplies mitliImplies) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them

		subformula1 = (MITLIFormula) l.get(0);
		subformula2 = (MITLIFormula) l.get(1);
		return this;
	}

	@Override
	public MITLIFormula visit(MITLIIff formula) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them

		subformula1 = (MITLIFormula) l.get(0);
		subformula2 = (MITLIFormula) l.get(1);
		return this;
	}

	@Override
	public MITLIFormula visit(MITLISince formula) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them

		subformula1 = (MITLIFormula) l.get(0);
		subformula2 = (MITLIFormula) l.get(1);
		return this;
	}
	
	public MITLIFormula visit(MITLIEventually formula){
		// if the list of subformulae are logically equivalent to the
				// subformulae then we can safely replace them
				if (l.get(0).equals(subformula)) {
					subformula = (MITLIFormula) l.get(0);
					return this;
				}
				// else rise an error. TODO: implement WrongUpdateException
				else
					return null;
	}
	
	@Override
	public MITLIFormula visit(MITLIGlobally formula){
		// if the list of subformulae are logically equivalent to the
				// subformulae then we can safely replace them
				if (l.get(0).equals(subformula)) {
					subformula = (MITLIFormula) l.get(0);
					return this;
				}
				// else rise an error. TODO: implement WrongUpdateException
				else
					return null;
	}

	@Override
	public MITLIFormula visit(MITLIGlobally_AtoInf mitliGlobally_AtoInf) {
		// if the list of subformulae are logically equivalent to the
		// subformulae then we can safely replace them

		int m = subformula.maxIntComparedto();
		subformula = (MITLIFormula) l.get(0);
		subformula.maxIntComparedto(m);
		return this;
	}

	@Override
	public MITLIFormula visit(MITLIGlobally_AtoB mitliGlobally_AtoB) {
		// if the list of subformulae are logically equivalent to the
				// subformulae then we can safely replace them

				int m = subformula.maxIntComparedto();
				subformula = (MITLIFormula) l.get(0);
				subformula.maxIntComparedto(m);
				return this;
	}

}
