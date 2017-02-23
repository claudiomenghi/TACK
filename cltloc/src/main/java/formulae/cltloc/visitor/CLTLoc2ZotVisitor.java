package formulae.cltloc.visitor;

import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocConstantAtom;
import formulae.cltloc.atoms.CLTLocVariable;
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
 * Translates a CLTLoc formula into a Zot formula. Each method specifies how a
 * specific type of formula must be converted.
 * 
 * @author Claudio Menghi
 */
public class CLTLoc2ZotVisitor implements CLTLocVisitor<String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocConjunction formula) {
		return "(&&" + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocNegation formula) {
		return "(!! " + formula.getChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocUntil formula) {
		return "(until " + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocImplies formula) {
		return "(-> " + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocIff formula) {
		return "(<-> " + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocNext formula) {
		return "(next " + formula.getChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocGlobally formula) {
		return "(alwf " + formula.getChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocEventually eventually) {
		return "(somf " + eventually.getChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocSince formula) {
		return "(since " + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocYesterday formula) {
		return "(yesterday " + formula.getChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocRelease formula) {
		return "(release " + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocRelation formula) {
		return "([" + formula.getRelation() + "] " + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocDisjunction formula) {
		return "(||" + formula.getLeftChild().accept(this) + " " + formula.getRightChild().accept(this) + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocAP cltLocAP) {
		if(cltLocAP.equals(CLTLocAP.TRUE)){
			return "(||  (-P- a) (!!(-P- a)))";
		}
		if(cltLocAP.equals(CLTLocAP.FALSE)){
			return "(&&  (-P- a) (!!(-P- a)))";
		}
		return "(-P- " + cltLocAP.toString() + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocClock cltlClock) {
		return "(-V- "+cltlClock.toString()+")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocConstantAtom cltlConstantAtom) {
		return cltlConstantAtom.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocVariable formula) {
		return "(-V- "+formula.toString()+")";
	}
}