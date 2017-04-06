package ta.visitors;

import java.util.function.Function;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.relations.CLTLocRelation;
import formulae.cltloc.relations.Relation;
import operators.PropositionalLogicOperator;
import ta.AP;
import ta.Clock;
import ta.TA;
import ta.VariableAssignementAP;
import ta.expressions.EmptyExpression;
import ta.state.EmptyInvariant;
import ta.state.ExpInvariant;
import ta.state.State;
import ta.transition.assignments.ClockAssignement;
import ta.transition.guard.BinaryClockConstraint;
import ta.transition.guard.BinaryVariableConstraint;
import ta.transition.guard.ClockConstraintAtom;
import ta.transition.guard.ClockConstraintAtom.ClockConstraintAtomOperator;
import ta.transition.guard.VariableConstraintAtom;

public class TA2CLTLocVisitor implements TAVisitor<CLTLocFormula> {

	private static final Function<AP, CLTLocFormula> ap2CLTLocRESTAp = ap -> new CLTLocAP("H_" + ap.getName());
	private static final Function<AP, CLTLocFormula> ap2CLTLocFIRSTAp = ap -> new CLTLocAP("P_" + ap.getName());

	private TA ta;

	public TA2CLTLocVisitor(TA ta) {
		this.ta = ta;
	}

	@Override
	public CLTLocFormula visit(TA ta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLTLocFormula visit(AP ap) {
		return TA2CLTLoc.implicationOperator.apply(ap2CLTLocRESTAp.apply(ap),
				TA2CLTLoc.nextOperator.apply(ap2CLTLocFIRSTAp.apply(ap)));
	}

	@Override
	public CLTLocFormula visit(VariableAssignementAP ap) {
		return this.visit(new AP(ap.getEncodingSymbol()));
	}

	@Override
	public CLTLocFormula visit(State state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CLTLocFormula visit(EmptyExpression emptyExpression) {
		return CLTLocFormula.TRUE;
	}

	public CLTLocFormula visit(ExpInvariant expInvariant) {
		
		String prefix=(ta.getClocks().contains(new Clock(expInvariant.getId().getId())))? ta.getIdentifier() + "_": "";
		
		formulae.cltloc.relations.Relation relation;
		
		switch (expInvariant.getOperator()) {
		case ">":
			 relation=Relation.GE;
			 break;
		case ">=":
			 relation=Relation.GEQ;
			 break;
		case "<":
			 relation= Relation.LE;
			 break;
		case "<=":
			 relation= Relation.LEQ;
			 break;
		default:
			throw new IllegalArgumentException("Operator: " + expInvariant.getOperator() + " not supported");
		}
		return new CLTLocRelation(
				new CLTLocClock(prefix+ expInvariant.getId().getId()),
				new Constant(expInvariant.getExp().evaluate()), relation);
	
	}
	
public CLTLocFormula visit(ExpInvariant expInvariant,  State state) {
		
		String prefix=(ta.getClocks().contains(new Clock(expInvariant.getId().getId())))? ta.getIdentifier() + "_": "";
		
		formulae.cltloc.relations.Relation relation;
		
		switch (expInvariant.getOperator()) {
		case ">":
			 relation=Relation.GE;
			 break;
		case ">=":
			 relation=Relation.GEQ;
			 break;
		case "<":
			 relation= Relation.LE;
			 break;
		case "<=":
			 relation= Relation.LEQ;
			 break;
		default:
			throw new IllegalArgumentException("Operator: " + expInvariant.getOperator() + " not supported");
		}
		
		CLTLocFormula tmp= new CLTLocDisjunction(
		TA2CLTLoc.conjunctionOperator.apply(
				TA2CLTLoc.conjunctionOperator.apply(
				new CLTLocRelation(
								new Variable(prefix+ expInvariant.getId().getId()+"_v"),
								new Constant(0), Relation.EQ)
						,
				new CLTLocRelation(
						new CLTLocClock(prefix+ expInvariant.getId().getId()+"0"),
						new Constant(expInvariant.getExp().evaluate()), relation)
				)
				,
				TA2CLTLoc.nextOperator.apply(
						
						new CLTLocRelation(
								new CLTLocClock(prefix+ expInvariant.getId().getId()+"0"),
								new Constant(expInvariant.getExp().evaluate()), relation)
						)),
		TA2CLTLoc.conjunctionOperator.apply(
				TA2CLTLoc.conjunctionOperator.apply(
				new CLTLocRelation(
								new Variable(prefix+ expInvariant.getId().getId()+"_v"),
								new Constant(1), Relation.EQ)
						,
				new CLTLocRelation(
						new CLTLocClock(prefix+ expInvariant.getId().getId()+"1"),
						new Constant(expInvariant.getExp().evaluate()), relation)
				)
				,
				TA2CLTLoc.nextOperator.apply(
						new CLTLocRelation(
								new CLTLocClock(prefix+ expInvariant.getId().getId()+"1"),
								new Constant(expInvariant.getExp().evaluate()), relation)
						))
		);


	return tmp;
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

		Relation rel = Relation.parse(clockConstraintAtom.getOperator().toString());

		if (ta.getClocks().contains(clockConstraintAtom.getClock())) {
			return new CLTLocDisjunction(
					new CLTLocConjunction(
							new CLTLocRelation(
									new Variable(
											ta.getIdentifier() + "_" + clockConstraintAtom.getClock().getName() + "_v"),
									new Constant("0"), Relation.EQ),
							new CLTLocRelation(
									new CLTLocClock(ta.getIdentifier() + "_" + clockConstraintAtom.getClock().getName()
											+ "0"),
									new Constant(clockConstraintAtom.getValue()), rel)),
					new CLTLocConjunction(
							new CLTLocRelation(
									new Variable(
											ta.getIdentifier() + "_" + clockConstraintAtom.getClock().getName() + "_v"),
									new Constant("1"), Relation.EQ),
							new CLTLocRelation(
									new CLTLocClock(
											ta.getIdentifier() + "_" + clockConstraintAtom.getClock().getName() + "1"),
									new Constant(clockConstraintAtom.getValue()), rel)));
		} else {
			String prefix = "";
			return new CLTLocDisjunction(
					new CLTLocConjunction(
							new CLTLocRelation(
									new Variable(prefix  
											+ clockConstraintAtom.getClock().getName() + "_v"),
									new Constant("0"), Relation.EQ),
							new CLTLocRelation(
									new CLTLocClock(prefix  
											+ clockConstraintAtom.getClock().getName() + "0"),
									new Constant(clockConstraintAtom.getValue()), rel)),
					new CLTLocConjunction(
							new CLTLocRelation(
									new Variable(prefix 
											+ clockConstraintAtom.getClock().getName() + "_v"),
									new Constant("1"), Relation.EQ),
							new CLTLocRelation(
									new CLTLocClock(prefix  
											+ clockConstraintAtom.getClock().getName() + "1"),
									new Constant(clockConstraintAtom.getValue()), rel)));
		}
	}

	@Override
	public CLTLocFormula visit(VariableConstraintAtom variableConstraintAtom) {
		Relation rel = Relation.parse(ClockConstraintAtomOperator.EQ.toString());

		if (ta.getVariables().contains(variableConstraintAtom.getVariable())) {
			return new CLTLocDisjunction(
					new CLTLocConjunction(
							new CLTLocRelation(
									new Variable(ta.getIdentifier() + "_"
											+ variableConstraintAtom.getVariable().getName() + "_v"),
									new Constant("1"), Relation.EQ),
							new CLTLocRelation(new Variable(
									ta.getIdentifier() + "_" + variableConstraintAtom.getVariable().getName() + "1"),
									new Constant(
											variableConstraintAtom.getValue()),
									rel)),
					new CLTLocConjunction(
							new CLTLocRelation(
									new Variable(ta.getIdentifier() + "_"
											+ variableConstraintAtom.getVariable().getName() + "_v"),
									new Constant("0"), Relation.EQ),
							new CLTLocRelation(
									new Variable(ta.getIdentifier() + "_"
											+ variableConstraintAtom.getVariable().getName() + "0"),
									new Constant(variableConstraintAtom.getValue()), rel)));
		}
		else{
			String prefix = "";
			return new CLTLocDisjunction(
					new CLTLocConjunction(
							new CLTLocRelation(
									new Variable(prefix 
											+ variableConstraintAtom.getVariable().getName() + "_v"),
									new Constant("1"), Relation.EQ),
							new CLTLocRelation(new Variable(
									prefix + variableConstraintAtom.getVariable().getName() + "1"),
									new Constant(
											variableConstraintAtom.getValue()),
									rel)),
					new CLTLocConjunction(
							new CLTLocRelation(
									new Variable( variableConstraintAtom.getVariable().getName() + "_v"),
									new Constant("0"), Relation.EQ),
							new CLTLocRelation(
									new Variable( variableConstraintAtom.getVariable().getName() + "0"),
									new Constant(variableConstraintAtom.getValue()), rel)));
		}
	}

	@Override
	public CLTLocFormula visit(BinaryVariableConstraint binaryVariableConstraint) {
		if (binaryVariableConstraint.getOperator() == PropositionalLogicOperator.AND) {
			return new CLTLocConjunction(binaryVariableConstraint.getLeftChild().accept(this),
					binaryVariableConstraint.getRightChild().accept(this));
		}
		if (binaryVariableConstraint.getOperator() == PropositionalLogicOperator.OR) {
			return new CLTLocDisjunction(binaryVariableConstraint.getLeftChild().accept(this),
					binaryVariableConstraint.getRightChild().accept(this));
		}

		throw new IllegalArgumentException("Operator: " + binaryVariableConstraint.getOperator() + " not supported");
	}

	@Override
	public CLTLocFormula visit(ClockAssignement clockAssignement) {
		return new CLTLocRelation(new CLTLocClock(clockAssignement.getClock().getName()),
				new Constant(clockAssignement.getValue().value), Relation.GE);

	}

}
