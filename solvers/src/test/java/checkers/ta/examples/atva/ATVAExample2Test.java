package checkers.ta.examples.atva;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.google.common.collect.BiMap;

import checkers.TAChecker;
import formulae.cltloc.CLTLocFormula;
import formulae.mitli.MITLIFormula;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.converters.MITLI2CLTLoc;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import formulae.mitli.visitors.GetRelationalAtomsVisitor;
import solvers.CLTLocsolver;
import ta.AP;
import ta.SystemDecl;
import ta.TA;
import ta.VariableAssignementAP;
import ta.expressions.Value;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TA2CLTLoc;
import zotrunner.ZotException;

public class ATVAExample2Test {

	@Test
	public void testProperty1() throws IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaformula1.mitli").getPath();

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		TAChecker checker = new TAChecker(system,ta, formula, 20, System.out);
		boolean result = checker.check();

		assertTrue(result);

	}

	@Test
	public void testProperty2() throws IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaformula2.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		System.out.println("FORMULA OF INTEREST:"+formula);
		
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		System.out.println(system);


		
		TAChecker checker = new TAChecker(system,ta, formula, 20, System.out);
		boolean result = checker.check();

		assertFalse(result);

	}
	
	
	@Test
	public void testGee01() throws IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/gee01.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		
		TAChecker checker = new TAChecker(system,ta, formula, 20, System.out);
		boolean result = checker.check();

		assertFalse(result);

	}
	
	@Test
	public void testGee12() throws IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/gee12.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		System.out.println("FORMULA OF INTEREST:"+formula);
		
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		System.out.println(system);


		
		TAChecker checker = new TAChecker(system,ta, formula, 20, System.out);
		boolean result = checker.check();

		assertFalse(result);

	}
	
	
	@Test
	public void testProperty4() throws IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaformula4.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		System.out.println("FORMULA OF INTEREST:"+formula);
		
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		System.out.println(system);


		
		TAChecker checker = new TAChecker(system,ta, formula, 20, System.out);
		boolean result = checker.check();

		assertFalse(result);

	}
	
	
	@Test
	public void testProperty5() throws IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaformula5.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		System.out.println("FORMULA OF INTEREST:"+formula);
		
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		System.out.println(system);


		
		TAChecker checker = new TAChecker(system,ta, formula, 20, System.out);
		boolean result = checker.check();

		assertFalse(result);

	}
	
	
	@Test
	public void testProperty6() throws IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaformula6.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		System.out.println("FORMULA OF INTEREST:"+formula);
		
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		System.out.println(system);


		
		TAChecker checker = new TAChecker(system,ta, formula, 20, System.out);
		boolean result = checker.check();

		assertTrue(result);

	}
	
	@Test
	public void testProperty7() throws IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaformula7.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		System.out.println("FORMULA OF INTEREST:"+formula);
		
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		System.out.println(system);


		
		TAChecker checker = new TAChecker(system,ta, formula, 20, System.out);
		boolean result = checker.check();

		assertFalse(result);

	}
	
	@Test
	public void testProperty8() throws IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaformula8.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		System.out.println("FORMULA OF INTEREST:"+formula);
		
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		System.out.println(system);


		
		TAChecker checker = new TAChecker(system,ta, formula, 20, System.out);
		boolean result = checker.check();

		assertFalse(result);

	}
	
	@Test
	public void testProperty9() throws IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaformula9.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		System.out.println("FORMULA OF INTEREST:"+formula);
		
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		System.out.println(system);


		
		TAChecker checker = new TAChecker(system,ta, formula, 20, System.out);
		boolean result = checker.check();

		assertTrue(result);

	}
	
	@Test
	public void testPropertySatAut() throws IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaformula7.mitli").getPath();

		
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		System.out.println(system);

		
		MITLI2CLTLoc translator = new MITLI2CLTLoc(formula, 10);
	CLTLocFormula	formulacltloc = translator.apply();

		BiMap<MITLIFormula, Integer> vocabular = translator.getVocabulary().inverse();
		Set<MITLIRelationalAtom> atoms = formula.accept(new GetRelationalAtomsVisitor());
		Set<AP> atomicpropositions = atoms.stream()
				.map(a -> new VariableAssignementAP(Integer.toString(vocabular.get(a)),
						new ta.Variable(a.getIdentifier()), new Value(Integer.toString(a.getValue()))))
				.collect(Collectors.toSet());
		
		TA2CLTLoc taConverter=new TA2CLTLoc();
		CLTLocFormula f=taConverter.convert(system, ta,atomicpropositions , true);
		
		taConverter.printFancy(System.out);
		CLTLocsolver solver=new CLTLocsolver(f, System.out, 10);
		boolean result=solver.solve();
	
		assertTrue(result);

	}
}
