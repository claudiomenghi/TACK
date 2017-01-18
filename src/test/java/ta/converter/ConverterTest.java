package ta.converter;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;
import org.junit.Test;

import ta.State;
import ta.TA;
import ta.Transition;
import ta.parser.TALexer;
import ta.parser.TAParser;

public class ConverterTest {

	Set<State> states;
	
	Set<Transition> transitions;
	
	@Before
	public void setup(){
		states=new HashSet<>();
		states.add(new State("call_check"));
		states.add(new State("call_observe"));
		states.add(new State("check_eof"));
		states.add(new State("ex_jam"));
		states.add(new State("end_jam"));
		states.add(new State("ex_silence1"));
		states.add(new State("ex_silence2"));
		states.add(new State("ex_start"));
		states.add(new State("goto_idle"));
		states.add(new State("hold"));
		states.add(new State("idle"));
		states.add(new State("jam"));
		states.add(new State("nPf"));
		states.add(new State("newPn"));
		states.add(new State("other_started"));
		states.add(new State("sample"));
		states.add(new State("start"));
		states.add(new State("stop"));
		states.add(new State("transmit"));
		states.add(new State("until_silence"));
		
		this.transitions=new HashSet<>();
		this.transitions.add(new Transition(new State("call_check"), new State("ex_jam"), null));
		this.transitions.add(new Transition(new State("ex_start"), new State("ex_silence1"), null));
		this.transitions.add(new Transition(new State("ex_start"), new State("other_started"), null));
		this.transitions.add(new Transition(new State("goto_idle"), new State("idle"), null));
		this.transitions.add(new Transition(new State("hold"), new State("end_jam"), null));
		this.transitions.add(new Transition(new State("idle"), new State("ex_start"), null));
		this.transitions.add(new Transition(new State("jam"), new State("end_jam"), null));
		this.transitions.add(new Transition(new State("newPn"), new State("sample"), null));
		this.transitions.add(new Transition(new State("newPn"), new State("sample"), null));
		this.transitions.add(new Transition(new State("other_started"), new State("ex_silence1"), null));
		this.transitions.add(new Transition(new State("sample"), new State("call_observe"), null));
		this.transitions.add(new Transition(new State("start"), new State("idle"), null));
		this.transitions.add(new Transition(new State("transmit"), new State("check_eof"), null));
		this.transitions.add(new Transition(new State("until_silence"), new State("hold"), null));
		this.transitions.add(new Transition(new State("until_silence"), new State("until_silence"), null));
		
		
	}
	
	@Test
	public void testInitialState() throws IOException{
		ANTLRInputStream input = new ANTLRFileStream(ClassLoader
				.getSystemResource("ta/converter/WSAT_UPPAAL_MODEL.ta").getPath());
	    TALexer lexer = new TALexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TAParser parser = new TAParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.ta();
        TAConverter converter=new TAConverter();
        ParseTreeWalker.DEFAULT.walk(converter, tree);  
        
        TA ta=converter.getTA();
        assertEquals("The initial state is correct", new State("start"), ta.getInitialState());
	}
	
	@Test
	public void testObtainedTAContainsAllTheTransitions() throws IOException{
		ANTLRInputStream input = new ANTLRFileStream(ClassLoader
				.getSystemResource("ta/converter/WSAT_UPPAAL_MODEL.ta").getPath());
	    TALexer lexer = new TALexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TAParser parser = new TAParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.ta();
        TAConverter converter=new TAConverter();
        ParseTreeWalker.DEFAULT.walk(converter, tree);  
        
        TA ta=converter.getTA();
        
        assertEquals("The TA does not contains all the transitions of the automaton", transitions, ta.getTransitions());
	}
	@Test
	public void testObtainedTAContainsAllTheStates() throws IOException {
	
		ANTLRInputStream input = new ANTLRFileStream(ClassLoader
				.getSystemResource("ta/converter/WSAT_UPPAAL_MODEL.ta").getPath());
	    TALexer lexer = new TALexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TAParser parser = new TAParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.ta();
        TAConverter converter=new TAConverter();
        ParseTreeWalker.DEFAULT.walk(converter, tree);  
        
        TA ta=converter.getTA();
      
        assertEquals("The TA does not contains all the states of the automaton", states, ta.getStates());
    }
}
