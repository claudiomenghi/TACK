package formulae.cltloc.visitor;

import formulae.cltloc.atoms.CLTLClock;
import formulae.cltloc.atoms.CLTLConstantAtom;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.binary.CLTLocRelease;
import formulae.cltloc.operators.binary.CLTLocSince;
import formulae.cltloc.operators.binary.CLTLocUntil;
import formulae.cltloc.operators.unary.CLTLocEventually;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.relations.CLTLocRelation;

/**
 * This visitor explores a CLTLoc formula and creates the Header for the Zot
 * solver. Each method specifies how a specific type of formula must be
 * converted.
 * 
 * @author Claudio Menghi
 *
 */
public class CLTL2ZotHeaderVisitor implements CLTLocVisitor<String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocConjunction formula) {
		return formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocNegation formula) {
		return formula.getChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocUntil formula) {
		return formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocImplies formula) {
		return formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocIff formula) {
		return formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocNext formula) {
		return formula.getChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocGlobally formula) {
		return formula.getChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocEventually formula) {
		return formula.getChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocSince formula) {
		return formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocYesterday formula) {
		return formula.getChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocRelease formula) {
		return formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocRelation formula) {
		return formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocDisjunction formula) {
		return formula.getLeftChild().accept(this) + formula.getRightChild().accept(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLClock formula) {
		return "(define-tvar " + formula.strFormula() + " *real*)\n";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocAP cltLocAP) {
		return "(define-tvar " + cltLocAP.strFormula() + " *real*)\n";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLConstantAtom cltlConstantAtom) {
		return "";
	}

}
