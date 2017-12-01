package tack.ta.room;

import static org.junit.Assert.assertTrue;

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
import ta.visitors.TANetwork2CLTLoc;
import tack.checker.Planner;
import zotrunner.ZotException;

public class Room {

	@Test
	public void testRoom() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/room/test1.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/room/Room.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		Planner planner = new Planner(system, formula, 20, System.out);
		boolean result = planner.plan(null);

		assertTrue(result);

	}
	

	@Test
	public void testRoom2() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/room/test1.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/room/Room2.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		Planner planner = new Planner(system, formula, 20, System.out);
		boolean result = planner.plan(null);

		assertTrue(result);

	}
	
	@Test
	public void testRoom5() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/room/test1.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/room/Room5.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		Planner planner = new Planner(system, formula, 20, System.out);
		boolean result = planner.plan(null);

		assertTrue(result);

	}
	
	@Test
	public void testRoom6() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/room/test1.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/room/Room6.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		Planner planner = new Planner(system, formula, 20, System.out);
		boolean result = planner.plan(null);

		assertTrue(result);

	}
	@Test
	public void testRoom3() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/room/test1.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/room/Room3.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		Planner planner = new Planner(system, formula, 20, System.out);
		boolean result = planner.plan(null);

		assertTrue(result);

	}
	
	@Test
	public void testRoom7() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/room/test1.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/room/Room7.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		Planner planner = new Planner(system, formula, 20, System.out);
		boolean result = planner.plan(null);

		assertTrue(result);

	}

	@Test
	public void testFormulaSatisfiable() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/room/test1.mitli").getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLIsolver solver = new MITLIsolver(formula, System.out, 20);
		assertTrue(solver.solve());

	}

	@Test
	public void testRoom3ModelSatisfiable() throws IOException, ZotException {

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/room/Room3.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		System.out.println(system);

		TANetwork2CLTLoc converter = new TANetwork2CLTLoc();
		CLTLocFormula res = converter.convert(system, new HashSet<>(), new HashSet<>());

		CLTLocsolver solver = new CLTLocsolver(res, System.out, 20);

		assertTrue(solver.solve());

	}
	
	@Test
	public void testRoom0ModelSatisfiable() throws IOException, ZotException {

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/room/Room.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		System.out.println(system);

		TANetwork2CLTLoc converter = new TANetwork2CLTLoc();
		CLTLocFormula res = converter.convert(system, new HashSet<>(), new HashSet<>());

		CLTLocsolver solver = new CLTLocsolver(res, System.out, 20);

		assertTrue(solver.solve());

	}
	
	@Test
	public void testRoom4Satisfiable() throws IOException, ZotException {

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/room/Room4.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		System.out.println(system);

		TANetwork2CLTLoc converter = new TANetwork2CLTLoc();
		CLTLocFormula res = converter.convert(system, new HashSet<>(), new HashSet<>());

		CLTLocsolver solver = new CLTLocsolver(res, System.out, 20);

		assertTrue(solver.solve());

	}

	@Test
	public void testRoom5ModelSat() throws IOException, ZotException {

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/room/Room5.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		System.out.println(system);

		TANetwork2CLTLoc converter = new TANetwork2CLTLoc();
		CLTLocFormula res = converter.convert(system, new HashSet<>(), new HashSet<>());

		CLTLocsolver solver = new CLTLocsolver(res, System.out, 20);

		assertTrue(solver.solve());

	}
	
	@Test
	public void testRoom8() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("tack/ta/room/test1.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/room/Room8.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		Planner planner = new Planner(system, formula, 20, System.out);
		boolean result = planner.plan(null);

		assertTrue(result);

	}
}
