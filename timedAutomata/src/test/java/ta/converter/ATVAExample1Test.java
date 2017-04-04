package ta.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;
import org.junit.Test;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.binary.CLTLocRelease;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.relations.CLTLocRelation;
import formulae.cltloc.relations.Relation;
import ta.AP;
import ta.StateAP;
import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TA2CLTLoc;

public class ATVAExample1Test {

	private final String filename = "ta/converter/atvaexample1.ta";

	private TA ta;
	private SystemDecl system;

	private final static CLTLocClock clock0 = new CLTLocClock("Example1.x0");
	private final static CLTLocClock clock1 = new CLTLocClock("Example1.x1");
	private final static formulae.cltloc.atoms.Variable xv = new formulae.cltloc.atoms.Variable("Example1.x_v");

	private final CLTLocFormula expectedclock1 = new CLTLocRelease(
			new CLTLocRelation(clock1, new Constant(0), Relation.EQ),
			CLTLocFormula.getAnd(new CLTLocRelation(xv, new Constant(0), Relation.EQ),
					new CLTLocRelation(clock0, new Constant(0), Relation.GE)));

	private final CLTLocFormula expectedclock2 = CLTLocFormula
			.G(new CLTLocImplies(new CLTLocRelation(clock0, new Constant(0), Relation.EQ),
					new CLTLocNext(new CLTLocRelease(new CLTLocRelation(clock1, new Constant(0), Relation.EQ),
							CLTLocFormula.getAnd(new CLTLocRelation(xv, new Constant(0), Relation.EQ),
									new CLTLocRelation(clock0, new Constant(0), Relation.GE))))));

	private final CLTLocFormula expectedclock3 = CLTLocFormula
			.G(new CLTLocImplies(new CLTLocRelation(clock1, new Constant(0), Relation.EQ),
					new CLTLocNext(new CLTLocRelease(new CLTLocRelation(clock0, new Constant(0), Relation.EQ),
							CLTLocFormula.getAnd(new CLTLocRelation(xv, new Constant(1), Relation.EQ),
									new CLTLocRelation(clock1, new Constant(0), Relation.GE))))));

	private final CLTLocFormula expectedphi1 = CLTLocFormula
			.G(CLTLocFormula.getAnd(CLTLocFormula.getAnd(new CLTLocImplies(new CLTLocAP("Example1.l0"),
					CLTLocFormula.getAnd(CLTLocFormula.getNeg(new CLTLocAP("Example1.l1")),
							CLTLocFormula.getNeg(new CLTLocAP("Example1.l2")))),

					new CLTLocImplies(new CLTLocAP("Example1.l1"),
							CLTLocFormula.getAnd(CLTLocFormula.getNeg(new CLTLocAP("Example1.l0")),
									CLTLocFormula.getNeg(new CLTLocAP("Example1.l2"))))),
					new CLTLocImplies(new CLTLocAP("Example1.l2"),
							CLTLocFormula.getAnd(CLTLocFormula.getNeg(new CLTLocAP("Example1.l0")),
									CLTLocFormula.getNeg(new CLTLocAP("Example1.l1"))))));

	private final CLTLocFormula expectedphi2 = new CLTLocAP("Example1.l0");

	private final CLTLocFormula expectedphi3 = new CLTLocGlobally(
			new CLTLocImplies(new CLTLocAP("Example1.l1"), new CLTLocDisjunction(
					CLTLocFormula.getAnd(CLTLocFormula.getAnd(new CLTLocRelation(xv, new Constant(0), Relation.EQ),

							new CLTLocRelation(clock0, new Constant(5), Relation.LEQ)),
							new CLTLocNext(new CLTLocRelation(clock0, new Constant(5), Relation.LEQ))),
					CLTLocFormula.getAnd(CLTLocFormula.getAnd(new CLTLocRelation(xv, new Constant(1), Relation.EQ),

							new CLTLocRelation(clock1, new Constant(5), Relation.LEQ)),
							new CLTLocNext(new CLTLocRelation(clock1, new Constant(5), Relation.LEQ))))));

	
	private final CLTLocFormula transLocation0=
			new CLTLocImplies(new CLTLocAP("Example1.l0"), 
					new CLTLocNext(
							new CLTLocDisjunction(
										new CLTLocConjunction(
												new CLTLocAP("Example1.l0")
												,
												new CLTLocDisjunction(
														new CLTLocConjunction(
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(0), Relation.EQ)
																, 
																new CLTLocRelation(new CLTLocClock("Example1.x0"), new Constant(0), Relation.GE)																
																)
														,
														new CLTLocConjunction(
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(1), Relation.EQ)
																, 
																new CLTLocRelation(new CLTLocClock("Example1.x1"), new Constant(0), Relation.GE)																
																)
														)
												)
										,
										new CLTLocConjunction(
												new CLTLocAP("Example1.l1")
												,
												new CLTLocConjunction(
												new CLTLocDisjunction(
														new CLTLocConjunction(
															new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(0), Relation.EQ)
															, 
															new CLTLocRelation(new CLTLocClock("Example1.x0"), new Constant(5), Relation.LEQ)
														)
														,
														new CLTLocConjunction(
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(1), Relation.EQ)
																, 
																new CLTLocRelation(new CLTLocClock("Example1.x1"), new Constant(5), Relation.LEQ)
														)
												)
												,
												new CLTLocDisjunction(
														new CLTLocConjunction(
															new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(0), Relation.EQ)
															, 
															new CLTLocRelation(new CLTLocClock("Example1.x0"), new Constant(0), Relation.GE)
														)
														,
														new CLTLocConjunction(
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(1), Relation.EQ)
																, 
																new CLTLocRelation(new CLTLocClock("Example1.x1"), new Constant(0), Relation.GE)
														)
												)
												)
										)
									)
							)
					
					);
			
	private final CLTLocFormula transLocation1=
			new CLTLocImplies(new CLTLocAP("Example1.l1"), 
					new CLTLocNext(
							new CLTLocDisjunction(
										new CLTLocConjunction(
												new CLTLocAP("Example1.l1")
												,
												new CLTLocDisjunction(
														new CLTLocConjunction(
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(0), Relation.EQ)
																, 
																new CLTLocRelation(new CLTLocClock("Example1.x0"), new Constant(0), Relation.GE)																
																)
														,
														new CLTLocConjunction(
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(1), Relation.EQ)
																, 
																new CLTLocRelation(new CLTLocClock("Example1.x1"), new Constant(0), Relation.GE)																
																)
														)
												)
										,
										new CLTLocConjunction(
												new CLTLocAP("Example1.l2")
												,
												new CLTLocDisjunction(
														new CLTLocConjunction(
															new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(0), Relation.EQ)
															, 
															new CLTLocRelation(new CLTLocClock("Example1.x0"), new Constant(0), Relation.GE)
														)
														,
														new CLTLocConjunction(
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(1), Relation.EQ)
																, 
																new CLTLocRelation(new CLTLocClock("Example1.x1"), new Constant(0), Relation.GE)
														)
												
												)
										)
									)
							)
					);
	
	private final CLTLocFormula transLocation2=
			new CLTLocImplies(new CLTLocAP("Example1.l2"), 
					new CLTLocNext(
							new CLTLocDisjunction(
										new CLTLocConjunction(
												new CLTLocAP("Example1.l2")
												,
												new CLTLocDisjunction(
														new CLTLocConjunction(
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(0), Relation.EQ)
																, 
																new CLTLocRelation(new CLTLocClock("Example1.x0"), new Constant(0), Relation.GE)																
																)
														,
														new CLTLocConjunction(
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(1), Relation.EQ)
																, 
																new CLTLocRelation(new CLTLocClock("Example1.x1"), new Constant(0), Relation.GE)																
																)
														)
												)
										,
										new CLTLocConjunction(
												new CLTLocAP("Example1.l0")
												,
												new CLTLocConjunction(
												new CLTLocDisjunction(
														new CLTLocConjunction(
															new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(0), Relation.EQ)
															, 
															new CLTLocRelation(new CLTLocClock("Example1.x0"), new Constant(10), Relation.EQ)
														)
														,
														new CLTLocConjunction(
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(1), Relation.EQ)
																, 
																new CLTLocRelation(new CLTLocClock("Example1.x1"), new Constant(10), Relation.EQ)
														)
												),
												new CLTLocDisjunction(
														new CLTLocConjunction(
															new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(0), Relation.EQ)
															, 
																	new CLTLocRelation(new CLTLocClock("Example1.x1"), new Constant(0), Relation.EQ)
																	
														)
														,
														new CLTLocConjunction(
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example1.x_v"), new Constant(1), Relation.EQ)
																, 
																		new CLTLocRelation(new CLTLocClock("Example1.x0"), new Constant(0), Relation.EQ)
																
														)
												)
												)
										)
									)
							)
					);
	
	private final CLTLocFormula expectedphi4=CLTLocFormula.G(
			CLTLocFormula.getAnd(CLTLocFormula.getAnd(transLocation0, transLocation1),transLocation2));
	private final CLTLocFormula expectedphi5 = new CLTLocGlobally(
			new CLTLocIff(new CLTLocAP("Example1.l0"), new CLTLocAP("H_Example1.l0")));
	
	private final CLTLocFormula expectedphi6 = new CLTLocGlobally(
			new CLTLocImplies(new CLTLocAP("H_Example1.l0"), 
					new CLTLocNext(
					new CLTLocAP("P_Example1.l0"))));
	
	private final CLTLocFormula expectedphi7 = new CLTLocAP("P_Example1.l0");

	@Before
	public void setup() throws IOException {
		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource(filename).getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setErrorHandler(new BailErrorStrategy());
		system = parser.ta().systemret;

		ta = system.getTimedAutomata().iterator().next();

	}

	@Test
	public void testVariable1() throws IOException {

		TA2CLTLoc ta2cltloc = new TA2CLTLoc();

		ta2cltloc.convert(system, ta, new HashSet<>(), true);

		assertTrue("No CLTLoc formula for variables", ta2cltloc.getVariable1().equals(CLTLocFormula.TRUE));

	}

	@Test
	public void testVariable2() throws IOException {

		TA2CLTLoc ta2cltloc = new TA2CLTLoc();

		ta2cltloc.convert(system, ta, new HashSet<>(), true);

		assertTrue("No CLTLoc formula for variables", ta2cltloc.getVariable2().equals(CLTLocFormula.TRUE));

	}

	@Test
	public void testVariable3() throws IOException {

		TA2CLTLoc ta2cltloc = new TA2CLTLoc();

		ta2cltloc.convert(system, ta, new HashSet<>(), true);

		assertTrue("No CLTLoc formula for variables", ta2cltloc.getVariable3().equals(CLTLocFormula.TRUE));
	}

	@Test
	public void testClock1() throws IOException {

		TA2CLTLoc ta2cltloc = new TA2CLTLoc();

		ta2cltloc.convert(system, ta, new HashSet<>(), true);

		assertEquals(expectedclock1, ta2cltloc.getClock1());

	}

	@Test
	public void testClock2() throws IOException {

		TA2CLTLoc ta2cltloc = new TA2CLTLoc();

		ta2cltloc.convert(system, ta, new HashSet<>(), true);

		assertEquals(expectedclock2, ta2cltloc.getClock2());

	}

	@Test
	public void testClock3() throws IOException {

		TA2CLTLoc ta2cltloc = new TA2CLTLoc();

		ta2cltloc.convert(system, ta, new HashSet<>(), true);

		assertEquals(expectedclock3, ta2cltloc.getClock3());

	}

	@Test
	public void testPhi1() throws IOException {
		TA2CLTLoc ta2cltloc = new TA2CLTLoc();
		ta2cltloc.convert(system, ta, new HashSet<>(), true);
		assertEquals("Relation between state of the automaton  encoded correctly", expectedphi1, ta2cltloc.getPhi1());
	}

	@Test
	public void testPhi2() throws IOException {

		TA2CLTLoc ta2cltloc = new TA2CLTLoc();

		 ta2cltloc.convert(system, ta, new HashSet<>(), true);
		assertEquals("The initial state is encoded correctly", expectedphi2, ta2cltloc.getPhi2());

	}

	@Test
	public void testPhi3() throws IOException {

		TA2CLTLoc ta2cltloc = new TA2CLTLoc();

		ta2cltloc.convert(system, ta, new HashSet<>(), true);

		assertEquals("The invariants are encoded correctly", expectedphi3, ta2cltloc.getPhi3());
	}

	@Test
	public void testPhi4() throws IOException {

		Set<AP> ap = new HashSet<>();
		ap.add(new StateAP("Example1","l0"));

		TA2CLTLoc ta2cltloc = new TA2CLTLoc();

		ta2cltloc.convert(system, ta, ap, true);

		assertEquals("The ap are associated to the states correctly", expectedphi4, ta2cltloc.getPhi4());
	}
	
	@Test
	public void testPhi5() throws IOException {

		Set<AP> ap = new HashSet<>();
		ap.add(new StateAP("Example1","l0"));

		TA2CLTLoc ta2cltloc = new TA2CLTLoc();

		ta2cltloc.convert(system, ta, ap, true);

		assertEquals("The ap are associated to the states correctly", expectedphi5, ta2cltloc.getPhi5());

	}
	
	
	@Test
	public void testPhi6() throws IOException {

		Set<AP> ap = new HashSet<>();
		ap.add(new StateAP("Example1","l0"));

		TA2CLTLoc ta2cltloc = new TA2CLTLoc();

		ta2cltloc.convert(system, ta, ap, true);

		assertEquals("The ap are associated to the states correctly", expectedphi6, ta2cltloc.getPhi6());
	}
	
	@Test
	public void testPhi7() throws IOException {

		Set<AP> ap = new HashSet<>();
		ap.add(new StateAP("Example1","l0"));

		TA2CLTLoc ta2cltloc = new TA2CLTLoc();

		ta2cltloc.convert(system, ta, ap, true);

		assertEquals("The ap are associated to the states correctly", expectedphi7, ta2cltloc.getPhi7());

	}

	
}
