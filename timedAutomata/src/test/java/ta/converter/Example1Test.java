package ta.converter;

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
import org.junit.Ignore;
import org.junit.Test;

import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.state.State;
import ta.transition.Transition;

@Ignore
public class Example1Test {

	Set<State> states;

	Set<Transition> transitions;

	@Before
	public void setup() {
		states = new HashSet<>();
		states.add(new State("call_check"));
		states.add(new State("call_observe"));
		states.add(new State("check_eof"));
		states.add(new State("end_jam"));

		this.transitions = new HashSet<>();
		this.transitions.add(new Transition(new State("call_check"), new State("ex_jam"), null, null, null));
		this.transitions.add(new Transition(new State("call_observe"), new State("check_eof"), null, null, null));
		this.transitions.add(new Transition(new State("call_observe"), new State("other_started"), null, null, null));
		this.transitions.add(new Transition(new State("goto_idle"), new State("end_jam"), null, null, null));

	}

	@Test
	public void testInitialState() throws IOException {
		ANTLRInputStream input = new ANTLRFileStream(
				ClassLoader.getSystemResource("ta/converter/Example1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setErrorHandler(new BailErrorStrategy());
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		assertNotNull("The timed automaton cannot be null ", ta);
		assertEquals("The initial state is correct", new State("start"), ta.getInitialState());
	}

	@Test
	public void testObtainedTAContainsAllTheTransitions() throws IOException {
		ANTLRInputStream input = new ANTLRFileStream(
				ClassLoader.getSystemResource("ta/converter/Example1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		parser.setErrorHandler(new BailErrorStrategy());
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		assertNotNull("The timed automaton cannot be null ", ta);
		assertEquals("The TA does not contains all the transitions of the automaton", transitions, ta.getTransitions());
	}

	@Test
	public void testObtainedTAContainsAllTheStates() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(
				ClassLoader.getSystemResource("ta/converter/Example1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		parser.setErrorHandler(new BailErrorStrategy());
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		assertNotNull("The timed automaton cannot be null ", ta);
		assertEquals("The TA does not contains all the states of the automaton", states, ta.getStates());
	}
}
