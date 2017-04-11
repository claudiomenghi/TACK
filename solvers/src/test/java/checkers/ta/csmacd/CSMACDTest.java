package checkers.ta.csmacd;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import checkers.SystemChecker;
import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;
import zotrunner.ZotException;

public class CSMACDTest {

	@Test
	public void test() throws IOException, ZotException {
	
		String path = ClassLoader.getSystemResource("checkers/ta/csmacd/2.q").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/csmacd/2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		SystemChecker checker = new SystemChecker(system, formula, 20, System.out);
		boolean result = checker.check();

		assertTrue(result);

	}
}
