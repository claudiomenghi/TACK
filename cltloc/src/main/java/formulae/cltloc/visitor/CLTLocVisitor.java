package formulae.cltloc.visitor;

import formulae.cltloc.atoms.AssignNextVariable;
import formulae.cltloc.atoms.AssignVariable;
import formulae.cltloc.atoms.CLTLocArithmeticExpression;
import formulae.cltloc.atoms.BoundedVariable;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocSelector;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.KeepBoundedVariableConstant;
import formulae.cltloc.atoms.KeepVariableConstant;
import formulae.cltloc.atoms.Signal;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.binary.CLTLocNaryConjunction;
import formulae.cltloc.operators.binary.CLTLocNaryDisjunction;
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
 * This visitor explores a CLTLoc formula. To implement a custom visitor
 * implement the CLTLocVisitor interface. Change the generic type T to the
 * desired return type.
 * 
 * @author Claudio Menghi
 *
 * @param <T>
 */
public interface CLTLocVisitor<T> {

	/**
	 * Visits a CLTLoc conjunction formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocConjunction formula);

	/**
	 * Visits a CLTLoc negation formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocNegation formula);

	/**
	 * Visits a CLTLoc until formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocUntil formula);

	/**
	 * Visits a CLTLoc implication formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocImplies formula);

	/**
	 * Visits a CLTLoc if and only if formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocIff formula);

	/**
	 * Visits a CLTLoc next formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocNext formula);

	/**
	 * Visits a CLTLoc globally formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocGlobally formula);

	/**
	 * Visits a CLTLoc eventually formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocEventually formula);

	/**
	 * Visits a CLTLoc since formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocSince formula);

	/**
	 * Visits a CLTLoc yesterday formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocYesterday formula);

	/**
	 * Visits a CLTLoc release formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocRelease formula);

	/**
	 * Visits a CLTLoc relation formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocRelation formula);

	/**
	 * Visits a CLTLoc disjunction formula
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocDisjunction formula);

	/**
	 * Visits a CLTLoc atomic proposition atom
	 * 
	 * @param formula
	 *            the formula to be visited
	 * @return an object of type T
	 */
	public T visit(CLTLocAP formula);

	public T visit(CLTLocClock cltlClock);

	public T visit(Constant cltlConstantAtom);

	public T visit(Signal formula);

	public T visit(Variable cltLocVariable);

	public T visit(KeepVariableConstant keepVariableConstant);

	public T visit(CLTLocSelector formula);

	public T visit(AssignNextVariable formula);

	public T visit(BoundedVariable variable);

	public T visit(KeepBoundedVariableConstant variable);

	public T visit(CLTLocNaryConjunction cltLocNaryConjunction);

	public T visit(CLTLocNaryDisjunction cltLocNaryDisjunction);

	public T visit(CLTLocArithmeticExpression binaryArithmeticExpression);

	public T visit(AssignVariable assignVariable);

}
