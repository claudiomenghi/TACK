package ta.transition;

import com.google.common.base.Preconditions;

import ta.state.State;
import ta.transition.sync.SyncExpression;

public class Transition {

	private static int IDCOUNTER=0;
	private final State source;
	private final State destination;
	private final Guard guard;
	private final SyncExpression sync;
	private final Assign assignement;
	private final int id;
	
	public Transition(State source, State destination, Guard guard, SyncExpression sync, Assign assignement) {
		Preconditions.checkNotNull(source, "The source of the transition cannot be null");
		Preconditions.checkNotNull(destination, "The destination of the transition cannot be null");
		Preconditions.checkNotNull(guard, "The guard cannot be null");
	//	Preconditions.checkNotNull(sync, "The sync cannot be null");
		Preconditions.checkNotNull(assignement, "The assign cannot be null");
		this.source = source;
		this.destination = destination;
		this.guard = guard;
		this.sync = sync;
		this.assignement = assignement;
		id=IDCOUNTER+1;
		IDCOUNTER++;
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
		result = prime * result + ((assignement == null) ? 0 : assignement.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((guard == null) ? 0 : guard.hashCode());
		result = prime * result + id;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((sync == null) ? 0 : sync.hashCode());
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
		if (assignement == null) {
			if (other.assignement != null)
				return false;
		} else if (!assignement.equals(other.assignement))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (guard == null) {
			if (other.guard != null)
				return false;
		} else if (!guard.equals(other.guard))
			return false;
		if (id != other.id)
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (sync == null) {
			if (other.sync != null)
				return false;
		} else if (!sync.equals(other.sync))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return  source.getStringId() + " -> " + destination.getStringId() + "{guard: "+guard.toString()+"; sync: "+this.sync+", assign: "+this.assignement+";}";
	}

	public Guard getGuard() {
		return guard;
	}

	public SyncExpression getSync() {
		return sync;
	}

	public Assign getAssignement() {
		return assignement;
	}

	public int getId() {
		return id;
	}

}
