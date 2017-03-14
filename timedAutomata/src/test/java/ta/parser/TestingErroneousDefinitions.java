package ta.parser;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ta.SystemDecl;

public class TestingErroneousDefinitions {
	
	@Test(expected = IllegalStateException.class)
	public void duplicateVariableDefinitionExceptionTest() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/Test3.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		system.getTimedAutomata().iterator().next();

	}

}
