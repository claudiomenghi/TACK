package checkers.ta.examples.atva;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;

public class ATVAExample1Test {

	@Test
	public void test() throws IOException {
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		system.getTimedAutomata().iterator().next();

		System.out.println(system);

	}

}
