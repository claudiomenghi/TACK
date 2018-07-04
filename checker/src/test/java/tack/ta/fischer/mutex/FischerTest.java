package tack.ta.fischer.mutex;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TANetwork2CLTLocRC;
import tack.checker.SystemChecker;
import zotrunner.ZotException;

public class FischerTest {

	@Test
	public void test2() throws IOException, ZotException {
			assertTrue(executeFisherTest(2));
		
	}
	
	@Test
	public void test3() throws IOException, ZotException {
			assertTrue(executeFisherTest(3));
		
	}
	@Test
	public void test4() throws IOException, ZotException {
			assertTrue(executeFisherTest(4));
		
	}
	@Test
	public void test5() throws IOException, ZotException {
			assertTrue(executeFisherTest(5));
		
	}
	@Test
	public void test6() throws IOException, ZotException {
			assertTrue(executeFisherTest(6));
		
	}
/*	
	@Test
	public void test7() throws IOException, ZotException {
			assertTrue(executeFisherTest(7));
		
	}
	
	
	@Test
	public void test8() throws IOException, ZotException {
			assertTrue(executeFisherTest(8));
		
	}
	
	@Test
	public void test9() throws IOException, ZotException {
			assertTrue(executeFisherTest(9));
		
	}
	
	@Test
	public void test10() throws IOException, ZotException {
			assertTrue(executeFisherTest(10));
		
	}*/
	
	private boolean executeFisherTest(int i) throws IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("tack/ta/fischer/mutex/fischer_input_P5_0"+i+".mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		ANTLRInputStream tainput;
		if(i==10) {
			 tainput = new ANTLRFileStream(
					ClassLoader.getSystemResource("tack/ta/fischer/mutex/fischer_input_10.ta").getPath());
		}
		else {
		 tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/fischer/mutex/fischer_input_0"+i+".ta").getPath());
		}
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		SystemChecker checker = new SystemChecker(system, formula, 20, new TANetwork2CLTLocRC(), System.out);
		boolean result;
		result = checker.check(null);
		return result;
	}

}
