package planner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;
import tack.checker.Planner;
import zotrunner.ZotException;

public class TACheckerExample2Test {

	/**
	 * The property is not related to the model and thus it is not satisfied
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ZotException
	 */
	@Test
	public void testFormula2() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("planner/test1.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula2 = parser.mitli().formula;
		
	
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("planner/RoomOptimized1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		
		Planner checker = new Planner(system, formula2, 15, System.out);
		
		boolean result = checker.plan(null);

	}

}
