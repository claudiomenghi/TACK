package ta;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import ta.visitors.TAVisitor;

public class TA {

	/**
	 * The name of the timed automaton
	 */
	private final String name;

	/**
	 * The initial state of the timed automaton
	 */
	private final State initialState;

	/**
	 * The atomic propositions of the timed automaton
	 */
	private final Set<AP> atomicPropositions;

	/**
	 * The states of the timed automaton
	 */
	private final Set<State> states;

	private final Set<Clock> clocks;
	/**
	 * The transitions of the timed automaton
	 */
	private final Set<Transition> transitions;

	public TA(String name, Set<AP> atomicPropositions, Set<State> states, Set<Transition> transitions,
			State initialState, Set<Clock> clocks) {
		Preconditions.checkNotNull(states, "The set of the states cannot be null");
		Preconditions.checkNotNull(clocks, "The set of the clocks cannot be null");

		this.name = name;
		if (atomicPropositions != null) {
			this.atomicPropositions = new HashSet<>(atomicPropositions);
		} else {
			this.atomicPropositions = new HashSet<>();
		}
		this.states = new HashSet<>(states);
		this.transitions = new HashSet<>(transitions);
		this.initialState = initialState;
		this.clocks = clocks;
	}

	public <T> T accept(TAVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Set<AP> getAtomicPropositions() {
		return Collections.unmodifiableSet(atomicPropositions);
	}

	public Set<State> getStates() {
		return Collections.unmodifiableSet(states);
	}

	public Set<Transition> getTransitions() {
		return Collections.unmodifiableSet(transitions);
	}

	public State getInitialState() {
		return initialState;
	}

	public String getName() {
		return name;
	}

	/**
	 * returns the set of the clocks of the TA
	 * 
	 * @return the set of the clocks of the TA
	 */
	public Set<Clock> getClocks() {
		
		return Collections.unmodifiableSet(clocks);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "TA [atomicPropositions=" + atomicPropositions + ", states=" + states + ", transitions=" + transitions
				+ ", clocks="+this.clocks+"]";
	}

}
