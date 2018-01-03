package formulae.cltloc.visitor;

import java.util.AbstractMap;
import java.util.Map.Entry;

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

public class CLTLoc2StringVisitor implements CLTLocVisitor<Entry<String, Class<? extends CLTLocFormula>>> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocDisjunction formula) {
		Entry<String, Class<? extends CLTLocFormula>> retleft = formula.getLeftChild().accept(this);
		String retString = "";
		if (formula.getClass().equals(retleft.getValue()) || CLTLocAP.class.isAssignableFrom(retleft.getValue())) {
			retString = retleft.getKey() +" "+formula.operator;
		} else {
			retString = "(" + retleft.getKey() + ")" + formula.operator;
		}
		Entry<String, Class<? extends CLTLocFormula>> retright = formula.getRightChild().accept(this);
		if (formula.getClass().equals(retright.getValue()) ||  CLTLocAP.class.isAssignableFrom(retright.getValue())) {
			retString = retString +" "+ retright.getKey();
		} else {
			retString = retString + "(" + retright.getKey() + ")";
		}

		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, formula.getClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocConjunction formula) {
		Entry<String, Class<? extends CLTLocFormula>> retleft = formula.getLeftChild().accept(this);
		String retString = "";
		if (formula.getClass().equals(retleft.getValue())  || CLTLocAP.class.isAssignableFrom(retleft.getValue())) {
			retString = retleft.getKey() +" "+ formula.operator;
		} else {
			retString = "(" + retleft.getKey() + ")" + formula.operator;
		}
		Entry<String, Class<? extends CLTLocFormula>> retright = formula.getRightChild().accept(this);
		if (formula.getClass().equals(retright.getValue()) || CLTLocAP.class.isAssignableFrom(retright.getValue())) {
			retString = retString +" "+ retright.getKey();
		} else {
			retString = retString + "(" + retright.getKey() + ")";
		}

		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, formula.getClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocNegation formula) {

		String retString = formula.operator + "(" + formula.getChild().accept(this).getKey() + ")";

		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, formula.getClass());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocUntil formula) {
		
		Entry<String, Class<? extends CLTLocFormula>> retleft = formula.getLeftChild().accept(this);
		Entry<String, Class<? extends CLTLocFormula>> retright = formula.getRightChild().accept(this);
		String retString = "";
		retString = "(" + retleft.getKey() + ")" + formula.operator;
		retString = retString + "(" + retright.getKey() + ")";

		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, formula.getClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocImplies formula) {
		Entry<String, Class<? extends CLTLocFormula>> retleft = formula.getLeftChild().accept(this);
		Entry<String, Class<? extends CLTLocFormula>> retright = formula.getRightChild().accept(this);
		String retString = "";
		retString = "(" + retleft.getKey() + ")" + formula.operator;
		retString = retString + "(" + retright.getKey() + ")";

		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, formula.getClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocIff formula) {
		Entry<String, Class<? extends CLTLocFormula>> retleft = formula.getLeftChild().accept(this);
		Entry<String, Class<? extends CLTLocFormula>> retright = formula.getRightChild().accept(this);
		String retString = "";
		retString = "(" + retleft.getKey() + ")" + formula.operator;
		retString = retString + "(" + retright.getKey() + ")";

		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, formula.getClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocSince formula) {
		Entry<String, Class<? extends CLTLocFormula>> retleft = formula.getLeftChild().accept(this);
		Entry<String, Class<? extends CLTLocFormula>> retright = formula.getRightChild().accept(this);
		String retString = "";
		retString = "(" + retleft.getKey() + ")" + formula.operator;
		retString = retString + "(" + retright.getKey() + ")";

		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, formula.getClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocRelease formula) {
		Entry<String, Class<? extends CLTLocFormula>> retleft = formula.getLeftChild().accept(this);
		Entry<String, Class<? extends CLTLocFormula>> retright = formula.getRightChild().accept(this);
		String retString = "";
		retString = "(" + retleft.getKey() + ")" + formula.operator;
		retString = retString + "(" + retright.getKey() + ")";

		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, formula.getClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocNext formula) {
		
		String retString = formula.operator + "(" + formula.getChild().accept(this).getKey() + ")";
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, formula.getClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocGlobally formula) {
		String retString = formula.operator + "(" + formula.getChild().accept(this).getKey() + ")";
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, formula.getClass());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocEventually formula) {
		String retString = formula.operator + "(" + formula.getChild().accept(this).getKey() + ")";
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, formula.getClass());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocYesterday formula) {
		String retString = formula.operator + "(" + formula.getChild().accept(this).getKey() + ")";
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, formula.getClass());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocRelation formula) {

		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(formula.toString(), formula.getClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocAP formula) {
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(formula.toString(), formula.getClass());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocClock formula) {
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(formula.toString(), CLTLocAP.class);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(Constant formula) {
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(formula.toString(), CLTLocAP.class);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(Signal formula) {
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(formula.toString(), CLTLocAP.class);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(Variable formula) {
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(formula.toString(), CLTLocAP.class);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(KeepVariableConstant formula) {
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(formula.toString(), CLTLocAP.class);
	}

	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocSelector formula) {
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(formula.toString(), CLTLocAP.class);

	}

	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(AssignNextVariable formula) {
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(formula.toString(), CLTLocAP.class);
	}

	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(BoundedVariable variable) {
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(variable.toString(), CLTLocAP.class);
	}

	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(KeepBoundedVariableConstant variable) {
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(variable.toString(), CLTLocAP.class);
	}

	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocNaryConjunction cltLocNaryConjunction) {
		String retString = "";
		
		for(CLTLocFormula f: cltLocNaryConjunction.getChildren()){
			Entry<String, Class<? extends CLTLocFormula>> retleft =f.accept(this);
			if (f.getClass().equals(retleft.getValue())  || CLTLocAP.class.isAssignableFrom(retleft.getValue())) {
				retString = retleft.getKey() +" "+ cltLocNaryConjunction.operator;
			} else {
				retString = "(" + retleft.getKey() + ")" + cltLocNaryConjunction.operator;
			}
		}
		
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, cltLocNaryConjunction.getClass());
	}

	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocNaryDisjunction cltLocNaryDisjunction) {
	String retString = "";
		
		for(CLTLocFormula f: cltLocNaryDisjunction.getChildren()){
			Entry<String, Class<? extends CLTLocFormula>> retleft =f.accept(this);
			if (f.getClass().equals(retleft.getValue())  || CLTLocAP.class.isAssignableFrom(retleft.getValue())) {
				retString = retleft.getKey() +" "+ cltLocNaryDisjunction.operator;
			} else {
				retString = "(" + retleft.getKey() + ")" + cltLocNaryDisjunction.operator;
			}
		}
		
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, cltLocNaryDisjunction.getClass());

	}
	

	@Override
	public Entry<String, Class<? extends CLTLocFormula>> visit(CLTLocArithmeticExpression binaryArithmeticExpression) {
		return null;
	}
	
	@Override
	public  Entry<String, Class<? extends CLTLocFormula>>  visit(AssignVariable assignVariable) {
		String retString= "([=] (-V- " + assignVariable.getVariable() + ")  " + assignVariable.getExpression().accept(this) + " )";
		return new AbstractMap.SimpleEntry<String, Class<? extends CLTLocFormula>>(retString, assignVariable.getClass());
		
	}
}