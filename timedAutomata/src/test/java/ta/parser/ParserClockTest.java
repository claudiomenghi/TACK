package ta.parser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;
import org.junit.Test;

import ta.State;
import ta.SystemDecl;
import ta.TA;
import ta.Transition;

public class ParserClockTest {

	
	@Test
	public void testObtainedTAContainsAllTheClocks() throws IOException{
		ANTLRInputStream input = new ANTLRFileStream(ClassLoader
				.getSystemResource("ta/Test1.ta").getPath());
	    TALexer lexer = new TALexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
       
        TAParser parser = new TAParser(tokens);
        parser.setBuildParseTree(true);
        SystemDecl system= parser.ta().systemret;
        
        TA ta=system.getTimedAutomata().iterator().next();
        
        System.out.println(ta.getClocks());
     //   assertEquals("The TA does not contains all the transitions of the automaton", transitions, ta.getTransitions());
	}

}
