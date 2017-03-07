package ta.transition.guard;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import ta.Clock;
import ta.visitors.TAVisitor;

public class ClockConstraintAtom implements ClockConstraint {

	private final Clock clock;
	private final int value;
	private final ClockConstraintAtomOperator operator;

	public ClockConstraintAtom(Clock clock,ClockConstraintAtomOperator operator,  int value) {
		Preconditions.checkNotNull(clock, "The clock cannot be null");
		this.clock = clock;
		this.value = value;
		this.operator = operator;
	}

	public Clock getClock() {
		return clock;
	}

	public int getValue() {
		return value;
	}

	public ClockConstraintAtomOperator getOperator() {
		return operator;
	}

	public enum ClockConstraintAtomOperator {
		LE("<"), LEQ("<="), GE(">"), GEQ(">="), EQ("==");

		private final String operaor;

		private ClockConstraintAtomOperator(String operator) {
			this.operaor = operator;
		}

		public static ClockConstraintAtomOperator parse(String value){
			switch(value){
				case "<": return ClockConstraintAtomOperator.LE;
				case "<=": return ClockConstraintAtomOperator.LEQ;
				case ">": return ClockConstraintAtomOperator.GE;
				case ">=": return ClockConstraintAtomOperator.GEQ;
				case "==": return ClockConstraintAtomOperator.EQ;
				default:
					throw new IllegalArgumentException("Operator "+value+" not present");
			}
		}
		public String toString() {
			return this.operaor;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Clock> getClocks() {
		Set<Clock> clocks = new HashSet<>();
		clocks.add(clock);
		return clocks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <R> R accept(TAVisitor<R> visitor) {
		return visitor.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return  clock.toString() + operator +  value ;
	}
}
