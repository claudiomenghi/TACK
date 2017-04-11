package checkers.ta.examples.atva;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.google.common.collect.BiMap;

import checkers.TAChecker;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Signal;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.visitor.GetClocksVisitor;
import formulae.cltloc.visitor.GetSignalVisitor;
import formulae.cltloc.visitor.GetVariablesVisitor;
import formulae.mitli.MITLIFormula;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.converters.MITLI2CLTLoc;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import formulae.mitli.visitors.GetRelationalAtomsVisitor;
import solvers.CLTLocsolver;
import ta.SystemDecl;
import ta.TA;
import ta.VariableAssignementAP;
import ta.expressions.Value;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TA2CLTLoc;
import zotrunner.ZotException;

public class ATVAExample2Test {

	private final PrintStream out = System.out;

	@Test
	public void testATVA_TA() throws IOException, ZotException {

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

		MITLI2CLTLoc translator = new MITLI2CLTLoc(formula, 5);
		translator.apply();
		BiMap<MITLIFormula, Integer> vocabular = translator.getVocabulary().inverse();
		Set<MITLIRelationalAtom> atoms = formula.accept(new GetRelationalAtomsVisitor());
		Set<VariableAssignementAP> atomicpropositions = atoms.stream()
				.map(a -> new VariableAssignementAP(Integer.toString(vocabular.get(a)),
						new ta.Variable(a.getIdentifier()), new Value(Integer.toString(a.getValue()))))
				.collect(Collectors.toSet());

		out.println("------------------");
		out.println("CLTLoc encoding");
		out.println(formula);

		out.println("************************************************************************");
		out.println("***ADDING THE CONTRAINT THAT THE FORMULA INITIALLY HOLDS ******");
		CLTLocFormula initFormula = new CLTLocAP("H_" + vocabular.get(formula));
		out.println("Contstraint: ");
		out.println(initFormula);

		out.println("\n");
		out.println("\n");
		out.println("\n");
		out.println("************************************************");
		out.println("**************     VOCABULARY     ***************");

		StringBuilder vocabularyBuilder = new StringBuilder();
		vocabular.entrySet().forEach(e -> vocabularyBuilder.append(e.getValue() + "\t" + e.getKey() + "\n"));
		out.print(vocabularyBuilder.toString());

		out.println("************************************************");
		out.println("************************************************");
		out.println("Converting the TA in CLTLoc");
		TA2CLTLoc converter = new TA2CLTLoc();
		CLTLocFormula taFormula = converter.convert(system, ta, new HashSet<>(), atomicpropositions);
		out.println("TA converted in CLTLoc");

		converter.printFancy(out);

		out.println("-------------INFO");

		final StringBuilder builder = new StringBuilder();

		builder.append("clock: \t");
		Set<CLTLocClock> clocks = taFormula.accept(new GetClocksVisitor());
		clocks.forEach(clock -> builder.append(clock.toString() + "\t"));
		builder.append("\n");
		builder.append("signals: \t");
		Set<Signal> signals = taFormula.accept(new GetSignalVisitor());
		signals.forEach(signal -> builder.append(signal.toString() + "\t"));
		builder.append("\n");
		builder.append("variables: \t");
		Set<Variable> variables = taFormula.accept(new GetVariablesVisitor());
		variables.forEach(variable -> builder.append(variable.toString() + "\t"));
		builder.append("\n");

		out.println(builder.toString());
		out.println("************************************************");

		// out.println(formula);
		// out.println(translator.getVocabulary());

		out.println("Creating the conjunction of the formulae");
		out.println("Conjunction of the formulae created");

		boolean sat = new CLTLocsolver(taFormula, out, 5).solve();

		assertTrue(sat);

	}

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

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
		boolean result = checker.check();

		assertTrue(result);

	}

	@Test
	public void testProperty1b() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaformula1b.mitli").getPath();

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

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
		boolean result = checker.check();

		assertFalse(result);

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

		System.out.println("FORMULA OF INTEREST:" + formula);

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		System.out.println(system);

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
		boolean result = checker.check();

		assertFalse(result);

	}

	@Test
	public void testGee01simpler0() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/gee01.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2simpler0.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
		boolean result = checker.check();

		assertFalse(result);

	}

	@Test
	public void testGee01simpler1() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("checkers/ta/examples/atva/gee01.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2simpler1.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
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

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
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

		System.out.println("FORMULA OF INTEREST:" + formula);

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		System.out.println(system);

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
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

		System.out.println("FORMULA OF INTEREST:" + formula);

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		System.out.println(system);

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
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

		System.out.println("FORMULA OF INTEREST:" + formula);

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		System.out.println(system);

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
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

		System.out.println("FORMULA OF INTEREST:" + formula);

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		System.out.println(system);

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
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

		System.out.println("FORMULA OF INTEREST:" + formula);

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		System.out.println(system);

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
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

		System.out.println("FORMULA OF INTEREST:" + formula);

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		System.out.println(system);

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
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

		System.out.println("FORMULA OF INTEREST:" + formula);

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("checkers/ta/examples/atva/atvaexample2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		System.out.println(system);

		TAChecker checker = new TAChecker(system, ta, formula, 20, System.out);
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
		translator.apply();

		BiMap<MITLIFormula, Integer> vocabular = translator.getVocabulary().inverse();
		Set<MITLIRelationalAtom> atoms = formula.accept(new GetRelationalAtomsVisitor());
		Set<VariableAssignementAP> atomicpropositions = atoms.stream()
				.map(a -> new VariableAssignementAP(Integer.toString(vocabular.get(a)),
						new ta.Variable(a.getIdentifier()), new Value(Integer.toString(a.getValue()))))
				.collect(Collectors.toSet());

		TA2CLTLoc taConverter = new TA2CLTLoc();
		CLTLocFormula f = taConverter.convert(system, ta, new HashSet<>(), atomicpropositions);

		taConverter.printFancy(System.out);
		CLTLocsolver solver = new CLTLocsolver(f, System.out, 10);
		boolean result = solver.solve();

		assertTrue(result);

	}
}
