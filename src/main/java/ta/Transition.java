package ta;

import com.google.common.base.Preconditions;

import ta.expressions.Assignement;
import ta.expressions.Expression;
import ta.expressions.SyncExpression;

public class Transition {

	private final State source;
	private final State destination;
	private final Expression guard;
	private final SyncExpression sync;
	private final Assignement assignement;

	public Transition(State source, State destination, Expression guard, SyncExpression sync, Assignement assignement) {
		Preconditions.checkNotNull(source, "The source of the transition cannot be null");
		Preconditions.checkNotNull(destination, "The destination of the transition cannot be null");

		this.source = source;
		this.destination = destination;
		this.guard = guard;
		this.sync = sync;
		this.assignement = assignement;
	}

	public State getSource() {
		return source;
	}

	public State getDestination() {
		return destination;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
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
		Transition other = (Transition) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transition [source=" + source + ", destination=" + destination + "]";
	}

	public Expression getGuard() {
		return guard;
	}

	public SyncExpression getSync() {
		return sync;
	}

}
