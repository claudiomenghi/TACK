package tack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
import solvers.MITLIsolver;
import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;
import tack.checker.SystemChecker;
import zotrunner.ZotException;

public class TACheckerTest {

	@Test
	public void test1() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula1.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

	
		SystemChecker checker = new SystemChecker(system,  formula, 5, System.out);
		boolean result = checker.check(null);

		assertTrue(result);
	}

	@Test
	public void test2() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula2.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		SystemChecker checker = new SystemChecker(system, formula, 5, System.out);
		boolean result = checker.check(null);

		assertTrue(result);
	}

	@Test
	public void test3() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula1.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		SystemChecker checker = new SystemChecker(system, formula, 5, System.out);
		boolean result = checker.check(null);

		assertTrue(result);
	}

	

	/**
	 * The property is not related to the model and thus it is not satisfied
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ZotException
	 */
	@Test
	public void test4a() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula3a.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		SystemChecker checker = new SystemChecker(system, formula, 5, System.out);
		boolean result = checker.check(null);

		assertTrue(result);
	}

	@Test
	public void test5() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula5.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		SystemChecker checker = new SystemChecker(system,  formula, 5, System.out);
		boolean result = checker.check(null);

		assertTrue(result);
	}

	@Test
	public void test6() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula6.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		SystemChecker checker = new SystemChecker(system, formula, 5, System.out);
		boolean result = checker.check(null);

		assertFalse(result);
	}

	@Test
	public void test7() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula7.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		SystemChecker checker = new SystemChecker(system, formula, 5, System.out);
		boolean result = checker.check(null);

		assertFalse(result);
	}

	@Test
	public void test8() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula8.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		SystemChecker checker = new SystemChecker(system, formula, 5, System.out);
		boolean result = checker.check(null);

		assertTrue(result);
	}
	
	
	@Test
	public void test9() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula9.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		SystemChecker checker = new SystemChecker(system, formula, 5, System.out);
		boolean result = checker.check(null);

		assertFalse(result);
	}

	@Test
	public void test10() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula10.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		SystemChecker checker = new SystemChecker(system, formula, 5, System.out);
		boolean result = checker.check(null);

		assertTrue(result);
	}
	
	@Test
	public void test11() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula11.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		SystemChecker checker = new SystemChecker(system, formula, 5, System.out);
		boolean result = checker.check(null);

		assertFalse(result);
	}

	@Test
	public void test12() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula12.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		SystemChecker checker = new SystemChecker(system,  formula, 5, System.out);
		boolean result = checker.check(null);

		assertTrue(result);
	}
	
	@Test
	public void test13() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula12.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example4.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		SystemChecker checker = new SystemChecker(system,  formula, 5, System.out);
		boolean result = checker.check(null);

		assertTrue(result);
	}
	
	@Test
	public void test14() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula14.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example5.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		parser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		SystemChecker checker = new SystemChecker(system,  formula, 5, System.out);
		boolean result = checker.check(null);

		assertTrue(result);
	}
	
	@Test
	public void test13() throws IOException, ZotException {
	
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula13.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver solver=new MITLIsolver(formula, System.out, 20);


		assertTrue(solver.solve());

	}

}
