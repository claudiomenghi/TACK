package ta.transition.assignments;

import com.google.common.base.Preconditions;

import ta.Clock;
import ta.expressions.Value;
import ta.visitors.TAVisitor;

public class ClockAssignement extends Assignment {
	private final Clock clock;
	private final Value value;

	public ClockAssignement(Clock clock, Value value) {
		Preconditions.checkNotNull(clock, "The clock cannot be null");
		Preconditions.checkNotNull(value, "The value assigned to the clock  cannot be null");
		this.clock = clock;
		this.value = value;
	}

	public Clock getClock() {
		return clock;
	}

	public Value getValue() {
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clock == null) ? 0 : clock.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClockAssignement other = (ClockAssignement) obj;
		if (clock == null) {
			if (other.clock != null)
				return false;
		} else if (!clock.equals(other.clock))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return clock + "=" + value;
	}

	 public  <R> R accept(TAVisitor<R> visitor){
		return visitor.visit(this);
	}
}
