package ta.converter;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.KeepVariableConstant;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.binary.CLTLocRelease;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.relations.CLTLocRelation;
import formulae.cltloc.relations.Relation;
import ta.AP;
import ta.SystemDecl;
import ta.TA;
import ta.VariableAssignementAP;
import ta.expressions.Value;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TA2CLTLoc;

public class ConverterTest {

	@Test
	public void getVariableFormula1Test() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi1 = converter.getVariable1();

		CLTLocFormula expectedphi1 = new CLTLocRelease(
				new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ),
				new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ),
						new CLTLocRelation(new Variable("i0"), new Constant(0), Relation.EQ)));

		assertTrue("The formula phi1 is such that the automaton can be only in one of its states",
				(expectedphi1.equals(phi1)));

	}

	@Test
	public void getVariableFormula2Test() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi2 = converter.getVariable2();

		CLTLocFormula expectedphi2 = new CLTLocGlobally(new CLTLocImplies(
				new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ),
				new CLTLocNext(new CLTLocRelease(new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ),
						new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ),
								new KeepVariableConstant(new Variable("i0")))))));

		assertTrue("The formula phi1 is such that the automaton can be only in one of its states",
				(expectedphi2.equals(phi2)));

	}

	@Test
	public void getVariableFormula3Test() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi2 = converter.getVariable3();

		CLTLocFormula expectedphi2 = new CLTLocGlobally(new CLTLocImplies(
				new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ),
				new CLTLocNext(new CLTLocRelease(new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ),
						new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ),
								new KeepVariableConstant(new Variable("i1")))))));

		assertTrue("The formula phi1 is such that the automaton can be only in one of its states",
				(expectedphi2.equals(phi2)));

	}

	@Test
	public void getClockFormula1Test() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi1 = converter.getClock1();

		CLTLocFormula expectedphi1 = new CLTLocRelease(
				new CLTLocRelation(new CLTLocClock("c1"), new Constant(0), Relation.EQ),
				new CLTLocConjunction(new CLTLocRelation(new Variable("c_v"), new Constant(0), Relation.EQ),
						new CLTLocRelation(new CLTLocClock("c0"), new Constant(0), Relation.GE)));
		assertTrue("The formula phi1 is such that the automaton can be only in one of its states",
				(expectedphi1.equals(phi1)));

	}

	@Test
	public void getClockFormula2Test() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi2 = converter.getClock2();

		CLTLocFormula expectedphi2 = new CLTLocGlobally(
				new CLTLocImplies(new CLTLocRelation(new CLTLocClock("c0"), new Constant(0), Relation.EQ),
						new CLTLocNext(new CLTLocRelease(
								new CLTLocRelation(new CLTLocClock("c1"), new Constant(0), Relation.EQ),
								new CLTLocConjunction(
										new CLTLocRelation(new Variable("c_v"), new Constant(0), Relation.EQ),
										new CLTLocRelation(new CLTLocClock("c0"), new Constant(0), Relation.GE))))));

		assertTrue("The formula phi1 is such that the automaton can be only in one of its states",
				(expectedphi2.equals(phi2)));

	}

	@Test
	public void getClockFormula3Test() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi3 = converter.getClock3();

		CLTLocFormula expectedphi3 = new CLTLocGlobally(
				new CLTLocImplies(new CLTLocRelation(new CLTLocClock("c1"), new Constant(0), Relation.EQ),
						new CLTLocNext(new CLTLocRelease(
								new CLTLocRelation(new CLTLocClock("c0"), new Constant(0), Relation.EQ),
								new CLTLocConjunction(
										new CLTLocRelation(new Variable("c_v"), new Constant(1), Relation.EQ),
										new CLTLocRelation(new CLTLocClock("c1"), new Constant(0), Relation.GE))))));

		assertTrue("The formula phi1 is such that the automaton can be only in one of its states",
				(expectedphi3.equals(phi3)));

	}

	@Test
	public void testTest1() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi1 = converter.getPhi1();

		CLTLocFormula expectedphi1 = new CLTLocGlobally(new CLTLocConjunction(
				new CLTLocImplies(new CLTLocAP("s_state_1"), new CLTLocNegation(new CLTLocAP("s_state_2"))),
				new CLTLocImplies(new CLTLocAP("s_state_2"), new CLTLocNegation(new CLTLocAP("s_state_1")))));

		CLTLocFormula expectedphi2 = new CLTLocGlobally(new CLTLocConjunction(
				new CLTLocImplies(new CLTLocAP("s_state_2"), new CLTLocNegation(new CLTLocAP("s_state_1"))),
				new CLTLocImplies(new CLTLocAP("s_state_1"), new CLTLocNegation(new CLTLocAP("s_state_2")))));

		assertTrue("The formula phi1 is such that the automaton can be only in one of its states",
				(expectedphi1.equals(phi1) || expectedphi2.equals(phi1)));

	}

	@Test
	public void testTest2() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi2 = converter.getPhi2();

		CLTLocFormula expectedphi2 = new CLTLocAP("s_state_1");

		assertTrue("The initial state should be correct", (expectedphi2.equals(phi2)));

	}

	@Test
	public void testTest3() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi3 = converter.getPhi3();

		CLTLocFormula expectedphi3 = new CLTLocGlobally(new CLTLocImplies(new CLTLocAP("s_state_1"),
				new CLTLocConjunction(new CLTLocRelation(new CLTLocClock("c"), new Constant("15"), Relation.LE),
						new CLTLocNext(new CLTLocRelation(new CLTLocClock("c"), new Constant("15"), Relation.LE)))));

		assertTrue("The invariant must be added as formulae", (expectedphi3.equals(phi3)));

	}

	@Test
	public void testTest4() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi4 = converter.getPhi4();

		CLTLocFormula expectedphi4 = new CLTLocGlobally(new CLTLocConjunction(new CLTLocImplies(
				new CLTLocAP("s_state_2"),
				new CLTLocNext(new CLTLocDisjunction(new CLTLocConjunction(new CLTLocAP("s_state_2"),
						new CLTLocConjunction(
								new CLTLocDisjunction(new CLTLocConjunction(
										new CLTLocRelation(new Variable("c_v"), new Constant(0), Relation.EQ),
										new CLTLocRelation(new CLTLocClock("c0"), new Constant(0), Relation.GE)),
										new CLTLocConjunction(
												new CLTLocRelation(new Variable("c_v"), new Constant(1), Relation.EQ),
												new CLTLocRelation(new CLTLocClock("c1"), new Constant(0),
														Relation.GE))),
								new CLTLocDisjunction(
										new CLTLocConjunction(
												new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ),
												new KeepVariableConstant(new Variable("i0"))),
										new CLTLocConjunction(
												new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ),
												new KeepVariableConstant(new Variable("i1"))

										)))), new CLTLocConjunction(new CLTLocAP("s_state_1"), new CLTLocConjunction(new CLTLocDisjunction(new CLTLocConjunction(new CLTLocRelation(new Variable("c_v"), new Constant(0), Relation.EQ), new CLTLocRelation(new CLTLocClock("c0"), new Constant(0), Relation.GE)), new CLTLocConjunction(new CLTLocRelation(new Variable("c_v"), new Constant(1), Relation.EQ), new CLTLocRelation(new CLTLocClock("c1"), new Constant(0), Relation.GE))), new CLTLocDisjunction(new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ), new CLTLocRelation(new Variable("i0"), new Constant(3), Relation.EQ)), new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ), new CLTLocRelation(new Variable("i1"), new Constant(3), Relation.EQ)))))))), new CLTLocImplies(new CLTLocAP("s_state_1"), new CLTLocNext(new CLTLocDisjunction(new CLTLocConjunction(new CLTLocAP("s_state_1"), new CLTLocConjunction(new CLTLocDisjunction(new CLTLocConjunction(new CLTLocRelation(new Variable("c_v"), new Constant(0), Relation.EQ), new CLTLocRelation(new CLTLocClock("c0"), new Constant(0), Relation.GE)), new CLTLocConjunction(new CLTLocRelation(new Variable("c_v"), new Constant(1), Relation.EQ), new CLTLocRelation(new CLTLocClock("c1"), new Constant(0), Relation.GE))), new CLTLocDisjunction(new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ), new KeepVariableConstant(new Variable("i0"))), new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ), new KeepVariableConstant(new Variable("i1"))

		)))), new CLTLocConjunction(new CLTLocAP("s_state_2"),
				new CLTLocConjunction(
						new CLTLocDisjunction(
								new CLTLocConjunction(
										new CLTLocRelation(new Variable("c_v"), new Constant(0), Relation.EQ),
										new CLTLocRelation(new CLTLocClock("c0"), new Constant(0), Relation.GE)),
								new CLTLocConjunction(new CLTLocRelation(new Variable("c_v"), new Constant(1),
										Relation.EQ),
										new CLTLocRelation(new CLTLocClock("c1"), new Constant(0), Relation.GE))),
						new CLTLocDisjunction(new CLTLocConjunction(
								new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ),
								new CLTLocRelation(new Variable("i0"), new Constant(2), Relation.EQ)),
								new CLTLocConjunction(
										new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ),
										new CLTLocRelation(new Variable("i1"), new Constant(2), Relation.EQ))))))))));

		assertTrue("The transition relation must be encored correclty", (expectedphi4.equals(phi4)));
	}

	@Test
	public void testTest5() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi5 = converter.getPhi5();

		CLTLocFormula expectedphi5 = new CLTLocGlobally(CLTLocFormula.TRUE);

		assertTrue("The transition relation must be encored correclty", (expectedphi5.equals(phi5)));

	}

	@Test
	public void testTest6() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		propositionsOfInterest.add(new VariableAssignementAP("0", new ta.Variable("i"), new Value("2")));
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi6 = converter.getPhi6();

		CLTLocFormula expectedphi6 = new CLTLocGlobally(
				new CLTLocImplies(new CLTLocAP("H_0"), new CLTLocNext(new CLTLocAP("P_0"))));

		assertTrue("The transition relation must be encored correclty", (expectedphi6.equals(phi6)));

	}

	@Test
	public void testTest7() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		propositionsOfInterest.add(new VariableAssignementAP("0", new ta.Variable("i"), new Value("2")));
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi7 = converter.getPhi7();

		CLTLocFormula expectedphi7 = new CLTLocAP("P_0");

		assertTrue("The transition relation must be encored correclty", (expectedphi7.equals(phi7)));

	}

	@Test
	public void testTest5b() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		propositionsOfInterest.add(new VariableAssignementAP("0", new ta.Variable("i"), new Value("2")));
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi5 = converter.getPhi5();

		CLTLocFormula expectedphi5 = new CLTLocGlobally(new CLTLocIff(new CLTLocAP("H_0"),
				new CLTLocDisjunction(
						new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ),
								new CLTLocRelation(new Variable("i0"), new Constant(2), Relation.EQ)),
						new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ),
								new CLTLocRelation(new Variable("i1"), new Constant(2), Relation.EQ)))));

		assertTrue("The transition relation must be encored correclty", (expectedphi5.equals(phi5)));

	}

	@Test
	public void testTest4ModelTest2() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/converter/Test2.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(ta, propositionsOfInterest, true);

		CLTLocFormula phi4 = converter.getPhi4();

		CLTLocFormula expectedphi4 = new CLTLocGlobally(new CLTLocConjunction(new CLTLocImplies(
				new CLTLocAP("s_state_2"),
				new CLTLocNext(new CLTLocDisjunction(new CLTLocConjunction(new CLTLocAP("s_state_2"),
						new CLTLocConjunction(
								new CLTLocDisjunction(new CLTLocConjunction(
										new CLTLocRelation(new Variable("c_v"), new Constant(0), Relation.EQ),
										new CLTLocRelation(new CLTLocClock("c0"), new Constant(0), Relation.GE)),
										new CLTLocConjunction(
												new CLTLocRelation(new Variable("c_v"), new Constant(1), Relation.EQ),
												new CLTLocRelation(new CLTLocClock("c1"), new Constant(0),
														Relation.GE))),
								new CLTLocDisjunction(
										new CLTLocConjunction(
												new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ),
												new KeepVariableConstant(new Variable("i0"))),
										new CLTLocConjunction(
												new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ),
												new KeepVariableConstant(new Variable("i1"))

										)))), new CLTLocConjunction(new CLTLocAP("s_state_1"), new CLTLocConjunction(new CLTLocDisjunction(new CLTLocConjunction(new CLTLocRelation(new Variable("c_v"), new Constant(0), Relation.EQ), new CLTLocRelation(new CLTLocClock("c0"), new Constant(0), Relation.GE)), new CLTLocConjunction(new CLTLocRelation(new Variable("c_v"), new Constant(1), Relation.EQ), new CLTLocRelation(new CLTLocClock("c1"), new Constant(0), Relation.GE))), new CLTLocDisjunction(new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ), new CLTLocRelation(new Variable("i0"), new Constant(3), Relation.EQ)), new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ), new CLTLocRelation(new Variable("i1"), new Constant(3), Relation.EQ)))

				))))), new CLTLocImplies(new CLTLocAP("s_state_1"), new CLTLocNext(new CLTLocDisjunction(new CLTLocConjunction(new CLTLocAP("s_state_1"), new CLTLocConjunction(new CLTLocDisjunction(new CLTLocConjunction(new CLTLocRelation(new Variable("c_v"), new Constant(0), Relation.EQ), new CLTLocRelation(new CLTLocClock("c0"), new Constant(0), Relation.GE)), new CLTLocConjunction(new CLTLocRelation(new Variable("c_v"), new Constant(1), Relation.EQ), new CLTLocRelation(new CLTLocClock("c1"), new Constant(0), Relation.GE))), new CLTLocDisjunction(new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ), new KeepVariableConstant(new Variable("i0"))), new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ), new KeepVariableConstant(new Variable("i1"))

		))

		)), new CLTLocConjunction(new CLTLocAP("s_state_2"),
				new CLTLocConjunction(
						new CLTLocDisjunction(
								new CLTLocConjunction(
										new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ),
										new CLTLocRelation(new Variable("i1"), new Constant(1), Relation.EQ)),
								new CLTLocConjunction(new CLTLocRelation(new Variable("i_v"), new Constant(0),
										Relation.EQ),
										new CLTLocRelation(new Variable("i0"), new Constant(1), Relation.EQ))),
						new CLTLocConjunction(
								new CLTLocDisjunction(
										new CLTLocConjunction(
												new CLTLocRelation(new Variable("c_v"), new Constant(0), Relation.EQ),
												new CLTLocRelation(new CLTLocClock("c0"), new Constant(0),
														Relation.GE)),
										new CLTLocConjunction(
												new CLTLocRelation(new Variable("c_v"), new Constant(1), Relation.EQ),
												new CLTLocRelation(new CLTLocClock("c1"), new Constant(0),
														Relation.GE))),
								new CLTLocDisjunction(new CLTLocConjunction(
										new CLTLocRelation(new Variable("i_v"), new Constant(0), Relation.EQ),
										new CLTLocRelation(new Variable("i0"), new Constant(2), Relation.EQ)),
										new CLTLocConjunction(
												new CLTLocRelation(new Variable("i_v"), new Constant(1), Relation.EQ),
												new CLTLocRelation(new Variable("i1"), new Constant(2),
														Relation.EQ)))))))))));

		assertTrue("The transition relation must be encored correclty", (expectedphi4.equals(phi4)));
	}
}
