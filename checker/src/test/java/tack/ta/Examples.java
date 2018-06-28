package tack.ta;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.cltloc.CLTLocFormula;
import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import solvers.CLTLocsolver;
import solvers.MITLIsolver;
import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TANetwork2CLTLocRC;
import tack.checker.SystemChecker;
import zotrunner.ZotException;


public class Examples {

	
	@Test
	public void testExample1ModelSat() throws IOException, ZotException {

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/examples/example1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		System.out.println(system);

		TANetwork2CLTLocRC converter = new TANetwork2CLTLocRC();
		CLTLocFormula res = converter.convert(system, new HashSet<>(), new HashSet<>());

		CLTLocsolver solver = new CLTLocsolver(res, System.out, 20);

		assertTrue(solver.solve());

	}
	@Test
	public void test1() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/example2.q").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/example2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		SystemChecker checker = new SystemChecker(system, formula, 10, new TANetwork2CLTLocRC(), System.out);
		boolean result = checker.check(null);

		assertFalse(result);
	}
	
	
	@Test
	public void testp() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/fischer/fischer_input_p.q").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/fischer/fischer_input_02.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		SystemChecker checker = new SystemChecker(system, formula, 10, new TANetwork2CLTLocRC(), System.out);
		boolean result = checker.check(null);

		assertFalse(result);
	}
	
//
//	@Test
//	public void test2() throws IOException, ZotException {
//
//		String path = ClassLoader.getSystemResource("tackta/example1.q").getPath();
//
//		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
//		MITLILexer lexer = new MITLILexer(input);
//		CommonTokenStream tokens = new CommonTokenStream(lexer);
//		MITLIParser parser = new MITLIParser(tokens);
//		parser.setBuildParseTree(true);
//		MITLIFormula formula = parser.mitli().formula;
//
//		ANTLRInputStream tainput = new ANTLRFileStream(
//				ClassLoader.getSystemResource("tackta/example1.ta").getPath());
//		TALexer talexer = new TALexer(tainput);
//		CommonTokenStream tatokens = new CommonTokenStream(talexer);
//		TAParser taparser = new TAParser(tatokens);
//		taparser.setBuildParseTree(true);
//		SystemDecl system = taparser.ta().systemret;
//
//		SystemChecker checker = new SystemChecker(system, formula, 10, System.out);
//		boolean result = checker.check(null);
//
//		assertFalse(result);
//	}
	
	@Test
	public void test3() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/example1.q").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/example2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		SystemChecker checker = new SystemChecker(system, formula, 10, new TANetwork2CLTLocRC(), System.out);
		boolean result = checker.check(null);

		assertFalse(result);
	}
	
	

	
	@Test
	public void test4modelUnsat() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/example1.q").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/example3.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		System.out.println(system);
		SystemChecker checker = new SystemChecker(system, formula, 10, new TANetwork2CLTLocRC(), System.out);
		boolean result = checker.check(null);

		CLTLocFormula taEncoding = checker.getTAEncoding();

		CLTLocsolver solver = new CLTLocsolver(taEncoding, System.out, 5);


		assertFalse(solver.solve());
	}
	
	@Test
	public void modelSat() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/example1.q").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/example2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		SystemChecker checker = new SystemChecker(system, formula, 10, new TANetwork2CLTLocRC(), System.out);
		boolean result = checker.check(null);

		CLTLocFormula taEncoding = checker.getTAEncoding();

		CLTLocsolver solver = new CLTLocsolver(taEncoding, System.out, 5);

		assertTrue(solver.solve());
	}
	
	@Test
	public void propertySat() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/example1.q").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		

		MITLIsolver solver = new MITLIsolver(formula,  System.out, 20);

		assertTrue(solver.solve());
	}
}
