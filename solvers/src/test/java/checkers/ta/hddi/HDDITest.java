package checkers.ta.hddi;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import checkers.SystemChecker;
import formulae.cltloc.CLTLocFormula;
import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import solvers.CLTLocsolver;
import solvers.MITLIsolver;
import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TA2CLTLoc;
import ta.visitors.TANetwork2CLTLoc;
import zotrunner.ZotException;

public class HDDITest {

	
	@Test
	public void testFormulaSatisfiable() throws IOException, ZotException {
	
		String path = ClassLoader.getSystemResource("checkers/ta/hddi/hddi_input_02.q").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver solver=new MITLIsolver(formula, System.out, 20);


		assertTrue(solver.solve());

	}
	
	@Test
	public void testModelSatisfiable() throws IOException, ZotException {


		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/hddi/hddi_input_02.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TANetwork2CLTLoc converter=new TANetwork2CLTLoc();
		CLTLocFormula res=converter.convert(system, new HashSet<>(), new HashSet<>());
		
		CLTLocsolver solver=new CLTLocsolver(res, System.out , 20);

		assertTrue(solver.solve());

	}
	
	
	@Test
	public void test() throws IOException, ZotException {
	
		String path = ClassLoader.getSystemResource("checkers/ta/hddi/hddi_input_02.q").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/hddi/hddi_input_02.ta").getPath());
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
