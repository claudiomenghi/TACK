package ta;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.google.common.base.Preconditions;

import ta.declarations.BoundedVariableDecl;
import ta.declarations.ClockDecl;
import ta.declarations.VariableDecl;
import ta.expressions.Value;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.state.State;
import ta.transition.Transition;
import ta.transition.sync.SyncExpression.Operator;
import ta.visitors.TAVisitor;

public class TA {

	public static int IDCOUNTER = 0;
	private final int id;
	private final Set<VariableDecl> variableDeclaration;

	private final Set<ClockDecl> clockDeclarations;

	private List<String> actions;
	private List<String> sendActions;
	private List<String> receiveActions;

	/**
	 * The name of the timed automaton
	 */
	private final String identifier;

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
	private final Set<Clock> allclocks;

	private final Set<Variable> variables;
	private final Set<Variable> allVariables;
	/**
	 * The transitions of the timed automaton
	 */
	private final Set<Transition> transitions;

	/**
	 * keeps the outgoing transitions for each state
	 */
	private final Map<State, Set<Transition>> outTransitions;

	private final Map<Entry<State, State>, Set<Transition>> mapSourceDestinationTransitions;

	private final Map<State, Set<State>> successors;

	public boolean containsVariable(String variableId) {
		return this.variableDeclaration.stream().map(d -> d.getId()).collect(Collectors.toSet()).contains(variableId);
	}

	public boolean isBounded(String variableId) {
		return this.variableDeclaration.stream().filter(d -> d instanceof BoundedVariableDecl).map(d -> d.getId())
				.collect(Collectors.toSet()).contains(variableId);
	}

	public Set<Integer> getBound(String variableId) {
		Set<Integer> retSet = new HashSet<>();
		this.variableDeclaration.stream().filter(d -> d instanceof BoundedVariableDecl)
				.map(d -> ((BoundedVariableDecl) d).getValues()).forEach(c -> retSet.addAll(c));
		return retSet;
	}

	public int getNumberStates() {
		return this.states.size();
	}

	public TA(String identifier, Set<AP> atomicPropositions, Set<State> states, Set<Transition> transitions,
			State initialState, Set<Clock> clocks, Set<Variable> variables, Set<VariableDecl> variableDeclaration,
			Set<ClockDecl> clockDeclarations) {
		Preconditions.checkNotNull(states, "The set of the states cannot be null");
		Preconditions.checkNotNull(clocks, "The set of the clocks cannot be null");
		Preconditions.checkNotNull(variables, "The set of the variables cannot be null");
		this.id = IDCOUNTER;
		IDCOUNTER++;
		this.identifier = identifier;
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
		this.variables = variables;
		this.allclocks = new HashSet<>(clocks);
		this.allVariables = new HashSet<>(variables);

		this.actions = new ArrayList<>();
		this.sendActions = new ArrayList<>();
		this.receiveActions = new ArrayList<>();
		this.states.forEach(s -> this.outTransitions.put(s, new HashSet<>()));
		this.transitions.forEach(t -> {
			Preconditions.checkArgument(this.outTransitions.containsKey(t.getSource()),
					"The state " + t.getSource() + "is not contained in the states of the TA");

			this.outTransitions.get(t.getSource()).add(t);
			t.getGuard().getClockConstraints().forEach(c -> allclocks.addAll(c.getClocks()));
			t.getAssignement().getClockassigments().forEach(c -> allclocks.add(c.getClock()));
			t.getGuard().getConditions().forEach(g -> allVariables.addAll(g.getVariables()));
			t.getAssignement().getVariableassigments().forEach(v -> allVariables.add(v.getVariable()));
			if (t.getSync() != null && t.getSync().getEvent() != null) {
				if (t.getSync().getOperator() != Operator.TAU) {
					if (!this.actions.contains(t.getSync().getEvent())) {
						this.actions.add(t.getSync().getEvent());
					}
					if (!this.sendActions.contains(t.getSync().getEvent())
							&& t.getSync().getOperator().equals(Operator.BROADCAST_SEND)) {
						this.sendActions.add(t.getSync().getEvent());
					}
					if (!this.receiveActions.contains(t.getSync().getEvent())
							&& t.getSync().getOperator().equals(Operator.BROADCAST_RECEIVE)) {
						this.receiveActions.add(t.getSync().getEvent());
					}
				}
			}
		});

		this.variableDeclaration = variableDeclaration;
		this.clockDeclarations = clockDeclarations;

		this.mapSourceDestinationTransitions = new HashMap<>();

		for (Transition t : this.transitions) {
			if (!this.mapSourceDestinationTransitions
					.containsKey(new AbstractMap.SimpleEntry<>(t.getSource(), t.getDestination()))) {
				Set<Transition> associatedtransitions = new HashSet<>();
				associatedtransitions.add(t);
				this.mapSourceDestinationTransitions
						.put(new AbstractMap.SimpleEntry<>(t.getSource(), t.getDestination()), associatedtransitions);
			} else {
				this.mapSourceDestinationTransitions
						.get(new AbstractMap.SimpleEntry<>(t.getSource(), t.getDestination())).add(t);
			}
		}

		this.successors = new HashMap<>();

		for (State s : this.states) {
			this.successors.put(s, new HashSet<>());
		}
		for (Transition t : this.transitions) {
			this.successors.get(t.getSource()).add(t.getDestination());
		}

		
	}

	public Set<State> successors(State s) {
		return this.successors.get(s);
	}

	public Set<Transition> getTransitions(State source, State destination) {
		if (this.mapSourceDestinationTransitions.containsKey(new AbstractMap.SimpleEntry<>(source, destination))) {
			return this.mapSourceDestinationTransitions.get(new AbstractMap.SimpleEntry<>(source, destination));
		} else {
			return new HashSet<>();
		}
	}

	public Set<Variable> getAllVariables() {
		return allVariables;
	}

	public Set<Clock> getAllclocks() {
		return allclocks;
	}

	public Set<Variable> getVariables() {
		return variables;

	}

	public Value getInitialValue(Variable v) {

		for (VariableDecl i : this.variableDeclaration) {
			if (i.getId().equals(v.getName())) {
				return new Value(Integer.toString(i.getExp().evaluate()));
			}
		}
		return new Value(Integer.toString(0));
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

	public String getIdentifier() {
		return identifier;
	}

	/**
	 * returns the set of the clocks of the TA
	 * 
	 * @return the set of the clocks of the TA
	 */
	public Set<Clock> getClocks() {

		return Collections.unmodifiableSet(clocks);
	}

	public Set<VariableDecl> getDeclarations() {
		return this.variableDeclaration;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("-----------------------------TIMED AUTOMATON----------------------------- \n");

		builder.append("TA \n");
		builder.append("id: " + this.id + "\n");
		builder.append("\t" + this.identifier + "\n");
		builder.append("clocks: \n");
		builder.append("\t");
		this.clocks.forEach(c -> builder.append(c + ",\t"));
		builder.append("\n");
		builder.append("variables: \n");
		builder.append("\t");
		this.variables.forEach(c -> builder.append(c + ",\t"));
		builder.append("\n");
		builder.append("initialstate \n");
		builder.append("\t" + this.getInitialState() + "\n");
		builder.append("states \n");
		this.states.forEach(s -> builder.append("\t" + s + ",\n"));
		builder.append("transitions \n");
		this.transitions.forEach(t -> builder.append("\t" + t + ",\n"));
		builder.append("--------------------------\n");
		builder.append("DECLARATION \n");
		builder.append("variables \n");
		this.variableDeclaration.forEach(v -> builder.append("\t" + v + ",\n"));
		builder.append("clocks \n");

		this.clockDeclarations.forEach(v -> builder.append("\t" + v + ",\n"));

		builder.append("-------------------------------------------------------------------------------- \n");
		return builder.toString();
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

	public Set<Variable> getLocalVariables() {
		return this.variableDeclaration.stream().map(v -> new Variable(v.getId())).collect(Collectors.toSet());
	}

	public Set<Clock> getLocalClocks() {
		return this.clockDeclarations.stream().map(cdc -> new Clock(cdc.getId())).collect(Collectors.toSet());
	}

	public List<String> getActions() {
		return Collections.unmodifiableList(actions);
	}

	public List<String> sendActions() {
		return Collections.unmodifiableList(this.sendActions);
	}

	public List<String> reveiveActions() {
		return Collections.unmodifiableList(this.receiveActions);
	}

	public int getId() {
		return id;
	}

	public Set<Integer> getPossibleTransitionVariableValues() {
		Set<Integer> values = new HashSet<>();
		this.getTransitions().stream().forEach(t -> values.add(t.getId()));
		values.add(-1);
		return values;
	}
}
