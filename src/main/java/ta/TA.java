package ta;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

public class TA {

	private final String name;
	private final State initialState;
	private final Set<AP> atomicPropositions;
	private final Set<State> states;

	private final Set<Transition> transitions;

	public TA(String name, Set<AP> atomicPropositions, Set<State> states, Set<Transition> transitions,
			State initialState) {
		Preconditions.checkNotNull(states, "The set of the states cannot be null");

		this.name = name;
		if (atomicPropositions != null) {
			this.atomicPropositions = new HashSet<>(atomicPropositions);
		}
		else{
			this.atomicPropositions = new HashSet<>();
		}
		this.states = new HashSet<>(states);
		this.transitions = new HashSet<>(transitions);
		this.initialState = initialState;
	}

	public Set<AP> getAtomicPropositions() {
		return atomicPropositions;
	}

	public Set<State> getStates() {
		return states;
	}

	public Set<Transition> getTransitions() {
		return transitions;
	}

	@Override
	public String toString() {
		return "TA [atomicPropositions=" + atomicPropositions + ", states=" + states + ", transitions=" + transitions
				+ "]";
	}

	public State getInitialState() {
		return initialState;
	}

	public String getName() {
		return name;
	}

}
