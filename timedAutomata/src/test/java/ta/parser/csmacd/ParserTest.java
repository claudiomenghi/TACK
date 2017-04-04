package ta.parser.csmacd;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.state.State;

public class ParserTest {

	@Test
	public void testTheParsedSystemShouldContainTheRightAutomata() throws IOException {
		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/parser/csmacd/2.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		assertEquals("The system must contain the right number of automata", 3, system.getTimedAutomata().size());

		Set<TA> automata = system.getTimedAutomata();

		for (TA ta : automata) {
			assertTrue(ta.getIdentifier().equals("P0") || ta.getIdentifier().equals("P1")
					|| ta.getIdentifier().equals("P2"));
		}
		
		System.out.println(system);
	}

}
