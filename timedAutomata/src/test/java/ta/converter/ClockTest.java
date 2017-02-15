package ta.converter;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ta.Clock;
import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;

public class ClockTest {

	@Test
	public void apTest1() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<Clock> clocks = ta.getClocks();

		Set<Clock> expectedSet = new HashSet<>();
		expectedSet.add(new Clock("A_c"));
		expectedSet.add(new Clock("B_c"));
		expectedSet.add(new Clock("C_c"));

		assertEquals(expectedSet, clocks);

	}

}
