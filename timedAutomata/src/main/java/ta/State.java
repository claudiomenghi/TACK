package ta;

import com.google.common.base.Preconditions;

import ta.expressions.Expression;

public class State {

	private final String stateId;
	private final Expression invariant;

	public State(String stateId, Expression invariant) {
		Preconditions.checkNotNull(stateId, "The id of the state cannot be null");
		this.stateId = stateId;
		this.invariant = invariant;
	}

	public State(String stateId) {
		Preconditions.checkNotNull(stateId, "The id of the state cannot be null");
		this.stateId = stateId;
		this.invariant = null;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		return true;
	}

	public Expression getInvariant() {
		return invariant;
	}
}
