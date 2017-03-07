package ta.visitors;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.relations.CLTLocEQRelation;
import formulae.cltloc.relations.CLTLocGEQRelation;
import formulae.cltloc.relations.CLTLocGERelation;
import formulae.cltloc.relations.CLTLocLEQRelation;
import formulae.cltloc.relations.CLTLocLERelation;
import ta.AP;
import ta.Clock;
import ta.TA;
import ta.expressions.EmptyExpression;
import ta.state.EmptyInvariant;
import ta.state.ExpInvariant;
import ta.state.State;
import ta.transition.guard.BinaryClockConstraint;
import ta.transition.guard.ClockConstraintAtom;
import ta.transition.guard.ClockConstraintAtom.ClockConstraintAtomOperator;
import ta.transition.guard.PropositionalLogicOperator;

public class TA2CLTLocVisitor implements TAVisitor<CLTLocFormula> {

	@Override
	public CLTLocFormula visit(TA ta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLTLocFormula visit(AP ap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLTLocFormula visit(State state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLTLocFormula visit(EmptyExpression emptyExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	public CLTLocFormula visit(ExpInvariant expInvariant) {
		switch (expInvariant.getOperator()) {
		case ">":
			return new CLTLocGERelation(new Variable(expInvariant.getId().getId()),
					new Constant(expInvariant.getExp().evaluate()));
		case ">=":
			return new CLTLocGEQRelation(new Variable(expInvariant.getId().getId()),
					new Constant(expInvariant.getExp().evaluate()));
		case "<":
			return new CLTLocLERelation(new Variable(expInvariant.getId().getId()),
					new Constant(expInvariant.getExp().evaluate()));
		case "<=":
			return new CLTLocLEQRelation(new Variable(expInvariant.getId().getId()),
					new Constant(expInvariant.getExp().evaluate()));

		default:
			throw new IllegalArgumentException("Operator: " + expInvariant.getOperator() + " not supported");
		}
	}

	public CLTLocFormula visit(EmptyInvariant emptyInvariant) {
		return CLTLocFormula.TRUE;

	}

	@Override
	public CLTLocFormula visit(BinaryClockConstraint binaryClockConstraint) {

		if (binaryClockConstraint.getOperator() == PropositionalLogicOperator.AND) {
			return new CLTLocConjunction(binaryClockConstraint.getLeftChild().accept(this),
					binaryClockConstraint.getRightChild().accept(this));
		}
		if (binaryClockConstraint.getOperator() == PropositionalLogicOperator.OR) {
			return new CLTLocDisjunction(binaryClockConstraint.getLeftChild().accept(this),
					binaryClockConstraint.getRightChild().accept(this));
		}

		throw new IllegalArgumentException("Operator: " + binaryClockConstraint.getOperator() + " not supported");

	}

	@Override
	public CLTLocFormula visit(ClockConstraintAtom clockConstraintAtom) {

		if (clockConstraintAtom.getOperator() == ClockConstraintAtomOperator.EQ) {
			return new CLTLocEQRelation(new CLTLocClock(clockConstraintAtom.getClock().getName()),
					new Constant(clockConstraintAtom.getValue()));
		}
		if (clockConstraintAtom.getOperator() == ClockConstraintAtomOperator.LEQ) {
			return new CLTLocLEQRelation(new CLTLocClock(clockConstraintAtom.getClock().getName()),
					new Constant(clockConstraintAtom.getValue()));
		}
		if (clockConstraintAtom.getOperator() == ClockConstraintAtomOperator.GEQ) {
			return new CLTLocGEQRelation(new CLTLocClock(clockConstraintAtom.getClock().getName()),
					new Constant(clockConstraintAtom.getValue()));
		}
		if (clockConstraintAtom.getOperator() == ClockConstraintAtomOperator.GE) {
			return new CLTLocGERelation(new CLTLocClock(clockConstraintAtom.getClock().getName()),
					new Constant(clockConstraintAtom.getValue()));
		}
		if (clockConstraintAtom.getOperator() == ClockConstraintAtomOperator.EQ) {
			return new CLTLocEQRelation(new CLTLocClock(clockConstraintAtom.getClock().getName()),
					new Constant(clockConstraintAtom.getValue()));
		}
		throw new IllegalArgumentException("Operator: " + clockConstraintAtom.getOperator() + " not supported");
	}

}
