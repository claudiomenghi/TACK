package ta.transition;

import java.util.Collections;
import java.util.Set;

import com.google.common.base.Preconditions;

import ta.transition.guard.ClockConstraint;
import ta.transition.guard.VariableConstraint;

public class Guard {

	/**
	 * contains the constraint of the guard that are relative to clocks
	 */
	private final Set<ClockConstraint> clockConstraints;

	private final Set<VariableConstraint> conditions;

	public Guard(Set<VariableConstraint> conditions, Set<ClockConstraint> clockConstraints) {
		Preconditions.checkNotNull(conditions, "The set of conditions cannot be null");
		Preconditions.checkNotNull(clockConstraints, "The set of clock constraints be null");
		this.conditions = conditions;
		this.clockConstraints = clockConstraints;
	}

	public Set<VariableConstraint> getConditions() {
		return Collections.unmodifiableSet(conditions);
	}

	public Set<ClockConstraint> getClockConstraints() {
		return Collections.unmodifiableSet(clockConstraints);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "clockConstraints=" + clockConstraints + ", variableConstraints=" + conditions + "]";
	}
}
