package ta.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;
import org.junit.Test;

import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.state.State;
import ta.transition.Assign;
import ta.transition.Guard;
import ta.transition.Transition;

public class ATVAExample1Test {

	Set<State> states;

	Set<Transition> transitions;

	private final String filename = "ta/parser/atvaexample1.ta";

	@Before
	public void setup() {
		states = new HashSet<>();
		states.add(new State("l0"));
		states.add(new State("l1"));
		states.add(new State("l2"));

		this.transitions = new HashSet<>();

		this.transitions.add(new Transition(new State("l0"), new State("l1"),
				new Guard(new HashSet<>(), new HashSet<>()), null, new Assign(new HashSet<>(), new HashSet<>())));
		this.transitions.add(new Transition(new State("l1"), new State("l2"),
				new Guard(new HashSet<>(), new HashSet<>()), null, new Assign(new HashSet<>(), new HashSet<>())));
		this.transitions.add(new Transition(new State("l2"), new State("l0"),
				new Guard(new HashSet<>(), new HashSet<>()), null, new Assign(new HashSet<>(), new HashSet<>())));
	
	}

	@Test
	public void testInitialState() throws IOException {
		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource(filename).getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setErrorHandler(new BailErrorStrategy());
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		assertNotNull("The timed automaton cannot be null ", ta);
		assertEquals("The initial state is correct", new State("l0"), ta.getInitialState());
	}

	@Test
	public void testObtainedTAContainsAllTheTransitions() throws IOException {
		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource(filename).getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		parser.setErrorHandler(new BailErrorStrategy());
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		assertNotNull("The timed automaton cannot be null ", ta);
		assertEquals("The TA does not contains all the transitions of the automaton", transitions.size(), ta.getTransitions().size());
	}

	@Test
	public void testObtainedTAContainsAllTheStates() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource(filename).getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		parser.setErrorHandler(new BailErrorStrategy());
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		System.out.println(states);
		System.out.println(ta.getStates());
		assertNotNull("The timed automaton cannot be null ", ta);
		assertEquals("The TA does not contains all the states of the automaton", states, ta.getStates());
	}
}
