package ta.parser;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ta.SystemDecl;
import ta.TA;

public class APTest {

	@Test(expected = IllegalStateException.class)
	public void apTest1() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		system.getTimedAutomata().iterator().next();

	}

	@Test
	public void apTest2() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/Test2.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		assertNotNull(ta);

	}
}
