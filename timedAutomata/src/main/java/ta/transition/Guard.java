package ta.transition;

import java.util.Collections;
import java.util.Set;

import com.google.common.base.Preconditions;

import ta.transition.conditions.Condition;
import ta.transition.guard.ClockConstraint;

public class Guard {

	/**
	 * contains the constraint of the guard that are relative to clocks
	 */
	private final Set<ClockConstraint> clockConstraints;

	private final Set<Condition> conditions;

	public Guard(Set<Condition> conditions, Set<ClockConstraint> clockConstraints) {
		Preconditions.checkNotNull(conditions, "The set of conditions cannot be null");
		this.conditions = conditions;
		this.clockConstraints = clockConstraints;
	}

	public Set<Condition> getConditions() {
		return Collections.unmodifiableSet(conditions);
	}

	public Set<ClockConstraint> getClockConstraints() {
		return Collections.unmodifiableSet(clockConstraints);
	}
}
