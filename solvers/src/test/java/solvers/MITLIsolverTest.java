package solvers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Ignore;
import org.junit.Test;

import formulae.cltloc.CLTLocFormula;
import formulae.mitli.MITLIFormula;
import formulae.mitli.MITLINegation;
import formulae.mitli.atoms.MITLIAtom;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.atoms.MITLITrue;
import formulae.mitli.converters.MITLI2CLTLoc;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import zotrunner.ZotException;

public class MITLIsolverTest {

	private final PrintStream out = System.out;

	@Test
	public void test1() throws IOException, ZotException {

		MITLIAtom a = new MITLIPropositionalAtom("a");

		MITLI2CLTLoc converter = new MITLI2CLTLoc(a);

		converter.apply();

		CLTLocFormula clockconstraint = converter.getTheta(a);

		assertTrue("The clock constraint sould be satisfiable", new CLTLocsolver(clockconstraint, out, 5).solve());
	}

	@Test
	public void test2() throws IOException, ZotException {

		MITLIFormula f = new MITLIRelationalAtom("X", "=", 5);

		MITLIsolver sover = new MITLIsolver(f, out, 5);

		assertTrue(sover.solve());
	}

	@Test
	public void test3() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/ta/examples/formula2.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertTrue(sover.solve());
	}

	@Test
	public void test4() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/ta/examples/formula2.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = MITLIFormula.not(parser.mitli().formula);

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertTrue(sover.solve());
	}

	@Test
	public void test5() throws IOException, ZotException {

		MITLIFormula formula = new MITLINegation(new MITLITrue());

		MITLIsolver sover = new MITLIsolver(formula, out, 10);

		assertFalse(sover.solve());
	}

	@Test
	public void test6() throws IOException, ZotException {

		MITLIFormula formula1 = new MITLINegation(new MITLITrue());

		MITLIFormula formula2 = MITLIFormula.not(new MITLITrue());
		MITLIsolver sover = new MITLIsolver(MITLIFormula.and(formula1, formula2), out, 5);

		assertFalse(sover.solve());
	}


	
	@Test
	public void testAtomicProposition() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/formula1.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertTrue(sover.solve());

	}

	@Test
	public void testAtomicPropositionNegation() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/formula2.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertTrue(sover.solve());

	}

	@Test
	public void testGee01() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/gee01.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertTrue(sover.solve());

	}

	@Test
	public void testFee01Gee01() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/fee01gee01.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		
		MITLIsolver sover = new MITLIsolver(formula, out, 15);

		assertTrue(sover.solve());

	}

	@Test
	public void testGee12() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/gee12.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 15);

		assertTrue(sover.solve());

	}

	@Test
	public void testGee12prop() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/gee12prop.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 15);

		assertTrue(sover.solve());

	}

	
	@Test
	public void testFee01() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/fee01.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 15);

		assertTrue(sover.solve());

	}
	
	
	@Test
	public void testFinally() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/formula4.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertTrue(sover.solve());

	}

	
	@Test
	public void testFinallyEx() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/formula5.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertTrue(sover.solve());

	}

	@Test
	public void testGee() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/formula6.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertTrue(sover.solve());

	}
	
	@Test
	public void testF0infIffG01phiGnotphi01() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/F0infIffG01phiGnotphi01.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 15);

		assertTrue(sover.solve());
	}
	
	@Test
	public void testIffG01phiGnotphi01() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/IffG01phiGnotphi01.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertTrue(sover.solve());
	}
	
	@Test
	public void testAnd01phiGnotphi01() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/AndG01phiGnotphi2.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertFalse(sover.solve());
	}
	
	
	@Test
	public void testIffF01phiFnotphi01() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/IffF01phiF01notphi.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertTrue(sover.solve());
	}
	
	@Test
	public void testIffAandNotA() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/IffAandNotA.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertFalse(sover.solve());
	}
	

	@Test
	public void testFormula1() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB1.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 15);

		assertFalse(sover.solve());
	}
	
	@Test
	public void testFormula2() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB2.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		MITLIsolver sover = new MITLIsolver(formula, out, 5);
		assertFalse(sover.solve());
	}
	
	
	@Test
	public void testFormula3() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB3.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		MITLIsolver sover = new MITLIsolver(formula, out, 5);
		assertFalse(sover.solve());
	}
	

	@Test
	public void testFormula4() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB4.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		MITLIsolver sover = new MITLIsolver(formula, out, 5);
		assertFalse(sover.solve());
	}
	
	@Test
	public void testFormula5() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB5.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		MITLIsolver sover = new MITLIsolver(formula, out, 5);
		assertFalse(sover.solve());
	}
	
	@Test
	public void testFormula6() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB6.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		MITLIsolver sover = new MITLIsolver(formula, out, 5);
		assertFalse(sover.solve());
	}
	

	
	

	
	@Test
	public void testFormula1a() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB1a.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		
		System.out.println(formula);

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertFalse(sover.solve());
	}
	
	@Test
	public void testFormula1b() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB1b.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		
		System.out.println(formula);

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertTrue(sover.solve());
	}
	
	
	
	@Test
	public void testFormula1aa() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB1aa.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver sover = new MITLIsolver(formula, out, 5);

		assertTrue(sover.solve());
	}
	
	@Test
	public void testFormula2a() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB2a.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		MITLIsolver sover = new MITLIsolver(formula, out, 5);
		assertFalse(sover.solve());
	}
	
	
	@Test
	public void testFormula3a() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB3a.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		MITLIsolver sover = new MITLIsolver(formula, out, 5);
		assertFalse(sover.solve());
	}
	

	@Test
	public void testFormula4a() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB4a.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		MITLIsolver sover = new MITLIsolver(formula, out, 5);
		assertFalse(sover.solve());
	}
	
	@Test
	public void testFormula5a() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB5a.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		MITLIsolver sover = new MITLIsolver(formula, out, 5);
		assertFalse(sover.solve());
	}
	
	@Test
	public void testFormula6a() throws IOException, ZotException {
		String path = ClassLoader.getSystemResource("solvers/FormulaB6a.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		MITLIsolver sover = new MITLIsolver(formula, out, 5);
		assertFalse(sover.solve());
	}
	
	
	
	
}
