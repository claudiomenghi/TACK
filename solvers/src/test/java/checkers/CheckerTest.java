package checkers;

import static org.junit.Assert.*;

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

public class CheckerTest {

	@Test
	public void test1() throws FileNotFoundException, IOException {
		String path = ClassLoader.getSystemResource("checkers/ta/formula.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

	
		ANTLRInputStream tainput = new ANTLRFileStream(ClassLoader.getSystemResource("checkers/ta/examples/example1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		TAChecker checker=new TAChecker(ta, formula, 5, System.out);
		boolean result=checker.check();
		
		assertTrue(result);
	}
	
	@Test
	public void test2() throws FileNotFoundException, IOException {
		String path = ClassLoader.getSystemResource("checkers/ta/formula2.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

	
		ANTLRInputStream tainput = new ANTLRFileStream(ClassLoader.getSystemResource("checkers/ta/examples/example1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		TAChecker checker=new TAChecker(ta, formula, 5, System.out);
		boolean result=checker.check();
		
		assertFalse(result);
	}
	
	/*
	@Test
	public void test() throws FileNotFoundException, IOException {
		String path = ClassLoader.getSystemResource("checkers/ta/formula.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

	
		ANTLRInputStream tainput = new ANTLRFileStream(ClassLoader.getSystemResource("checkers/ta/bocdp.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		TAChecker checker=new TAChecker(ta, formula, 5, System.out);
		boolean result=checker.check();
		
		assertFalse(result);
	}*/
	

}
