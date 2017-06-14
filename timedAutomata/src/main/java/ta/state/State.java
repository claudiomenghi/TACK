package ta.state;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import ta.ModelElement;
import ta.StateAP;
import ta.visitors.TAVisitor;

public class State extends ModelElement {

	
	private final String stateId;
	private final Invariant invariant;

	public State(String stateId, Invariant invariant) {
		Preconditions.checkNotNull(stateId, "The id of the state cannot be null");
		Preconditions.checkNotNull(invariant, "The invariant cannto be null");
		this.stateId = stateId;
		this.invariant = invariant;
		
	}

	public State(String stateId) {
		Preconditions.checkNotNull(stateId, "The id of the state cannot be null");
		this.stateId = stateId;
		this.invariant = new EmptyInvariant();
	
	}

	public String getStringId() {
		return stateId;
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "State [id=" + stateId + (this.invariant instanceof EmptyInvariant ? "" : ", " + this.invariant) + "]";
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

	public Invariant getInvariant() {
		return invariant;
	}

	@Override
	public <T> T accept(TAVisitor<T> visitor) {
		return visitor.visit(this);
	}

	/**
	 * given a set of atomic propositions returns the propositions that are true
	 * in that state
	 * 
	 * @param ap
	 *            the set of atomic propositions to be evaluated
	 * @return the set of atomic propositions true in the state
	 */
	public Set<StateAP> getValid(Set<StateAP> ap) {
		Set<StateAP> apret=new HashSet<>();
		ap.forEach(a -> {
			if(a.getState().equals(this.stateId)){
				apret.add(a);
			}
			
		});
		return apret;
	}
}
