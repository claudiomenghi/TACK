package formulae.cltloc.visitor;

import com.google.common.base.Preconditions;

import formulae.cltloc.CLTLocFormula;
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
 * Translates a CLTLoc formula into a Zot formula. Each method specifies how a
 * specific type of formula must be converted.
 * 
 * @author Claudio Menghi
 */
public class CLTLoc2ZotVisitor implements CLTLocVisitor<String> {

	private ZotPlugin plugin;

	public CLTLoc2ZotVisitor(ZotPlugin plugin) {
		Preconditions.checkNotNull(plugin, "The plugin cannot be null");
		this.plugin = plugin;

	}

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
		if (plugin.equals(ZotPlugin.AE2SBVZOTB1)) {
			return "([" + formula.getRelation() + "] " + formula.getLeftChild().accept(this) + " "
					+ formula.getRightChild().accept(this) + ")";
		}
		
		if (formula.getLeftChild() instanceof BoundedVariable) {
			return "(" + ((BoundedVariable) formula.getLeftChild()).toString() + "= '"
					+ formula.getRightChild().accept(this) + ")";
		}
		return "([" + formula.getRelation() + "] " + formula.getLeftChild().accept(this) + " "
				+ formula.getRightChild().accept(this) + ")";
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
		if (cltLocAP.equals(CLTLocAP.TRUE)) {
			//return "(||  (-P- a) (!!(-P- a)))";
			return "(-P- true)";
		}
		if (cltLocAP.equals(CLTLocAP.FALSE)) {
			//return "(&&  (-P- a) (!!(-P- a)))";
			return "(!! (-P- true))";
		}
		return "(-P- " + cltLocAP.toString() + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(CLTLocClock cltlClock) {
		return "(-V- " + cltlClock.toString() + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(Constant cltlConstantAtom) {
		return cltlConstantAtom.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(Signal formula) {
		return "(-V- " + formula.toString() + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visit(Variable formula) {
		return "(-V- " + formula.toString() + ")";
	}

	@Override
	public String visit(KeepVariableConstant keepVariableConstant) {
		if (plugin.equals(ZotPlugin.AE2SBVZOTB1)) {
			return "([=] (next (-V- " + keepVariableConstant.getVariable() + "))  (-V- "
					+ keepVariableConstant.getVariable() + ") )";
		}

		if (keepVariableConstant instanceof KeepBoundedVariableConstant) {
			return "(<" + keepVariableConstant.getVariable() + ">)";
		}
		return "([=] (next (-V- " + keepVariableConstant.getVariable() + "))  (-V- "
				+ keepVariableConstant.getVariable() + ") )";
	}

	@Override
	public String visit(CLTLocSelector formula) {
		
		return "(-P- " + formula.toString() + ")";
	}

	@Override
	public String visit(AssignNextVariable formula) {
		if (plugin.equals(ZotPlugin.AE2SBVZOTB1)) {
			return "(next ([=]  (-V-  " + formula.getVariable() + ") " + formula.getNextExpression().accept(this) + " ))";
		}

		if (formula.getVariable() instanceof BoundedVariable) {
			return " (next  (" + formula.getVariable() + "='" + formula.getNextExpression().accept(this) + " ))";
		} else {
			return "(next ([=]  (-V- " + formula.getVariable() + ")  " + formula.getNextExpression().accept(this)
					+ " ))";
		}
	}

	@Override
	public String visit(BoundedVariable variable) {
		if (plugin.equals(ZotPlugin.AE2SBVZOTB1)) {
			return "(-V- " + variable.toString() + " )";
		}

		return "(-P- " + variable.toString() + ")";
	}

	@Override
	public String visit(KeepBoundedVariableConstant variable) {
		if (plugin.equals(ZotPlugin.AE2SBVZOTB1)) {
			return "([=] (next (-V- " + variable.getVariable() + "))  (-V- "
					+ variable.getVariable() + ") )";
		}
		return "(<" + variable.toString() + ">)";
	}

	@Override
	public String visit(CLTLocNaryConjunction cltLocNaryConjunction) {
		String ret = "(&& ";
		for (CLTLocFormula f : cltLocNaryConjunction.getChildren()) {
			ret = ret + f.accept(this) + " ";
		}
		ret = ret + ")";
		return ret;
	}

	@Override
	public String visit(CLTLocNaryDisjunction cltLocNaryDisjunction) {
		String ret = "(|| ";
		for (CLTLocFormula f : cltLocNaryDisjunction.getChildren()) {
			ret = ret + f.accept(this) + " ";
		}
		ret = ret + ")";
		return ret;
	}

	@Override
	public String visit(CLTLocArithmeticExpression binaryArithmeticExpression) {
		return "([" + binaryArithmeticExpression.getOperator() + "] "
				+ binaryArithmeticExpression.getLeftChild().accept(this) + " "
				+ binaryArithmeticExpression.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(AssignVariable assignVariable) {
		return "([=] (-V- " + assignVariable.getVariable() + ")  " + assignVariable.getExpression().accept(this) + " )";
	}
}
