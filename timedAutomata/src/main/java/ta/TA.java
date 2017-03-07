package ta;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.google.common.base.Preconditions;

import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.state.State;
import ta.transition.Transition;
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

	/**
	 * keeps the outgoint transitions for each state
	 */
	private final Map<State, Set<Transition>> outTransitions;

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
		this.outTransitions = new HashMap<>();

		this.states.forEach(s -> this.outTransitions.put(s, new HashSet<>()));
		this.transitions.forEach(t -> {
			Preconditions.checkArgument(this.outTransitions.containsKey(t.getSource()),
					"The state " + t.getSource() + "is not contained in the states of the TA");
			
			this.outTransitions.get(t.getSource()).add(t);
		});
	}

	public Set<Transition> getOutgoingTransitions(State state) {
		Preconditions.checkNotNull(state, "The state cannot be null");
		return this.outTransitions.get(state);
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
				+ ", clocks=" + this.clocks + "]";
	}

	public static TA parse(String filePath) throws IOException {
		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource(filePath).getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		return ta;
	}
}
