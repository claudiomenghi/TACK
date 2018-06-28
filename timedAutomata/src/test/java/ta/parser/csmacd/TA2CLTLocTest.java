package ta.parser.csmacd;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ta.StateAP;
import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TANetwork2CLTLocRC;

public class TA2CLTLocTest {

	@Test
	public void testTheParsedSystemShouldContainTheRightAutomata() throws IOException {
		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/parser/csmacd/2.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		assertEquals("The system must contain the right number of automata", 3, system.getTimedAutomata().size());

		
		TANetwork2CLTLocRC ta2cltloc=new TANetwork2CLTLocRC();
		Set<StateAP> ap=new HashSet<>();
		
		ta2cltloc.convert(system, ap, new HashSet<>());
		
	}

}
