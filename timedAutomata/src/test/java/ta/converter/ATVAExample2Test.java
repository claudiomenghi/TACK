package ta.converter;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocSelector;
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
import ta.SystemDecl;
import ta.TA;
import ta.VariableAssignementAP;
import ta.expressions.Value;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TA2CLTLoc;

public class ATVAExample2Test {

	private final String filename = "ta/converter/atvaexample2.ta";

	private TA ta;
	private SystemDecl system;

	private final static CLTLocClock clock0 = new CLTLocClock("Example2_x_0");
	private final static CLTLocClock clock1 = new CLTLocClock("Example2_x_1");
	private final static CLTLocSelector xv = new CLTLocSelector("Example2_x_v");

	private final CLTLocFormula expectedclock1 = CLTLocFormula.getAnd(
			new CLTLocRelation(clock0, new Constant(0), Relation.EQ),
			CLTLocFormula.getAnd(
					new CLTLocRelation(clock1, new Constant(0), Relation.GE)),
			new CLTLocNegation(xv));

	private final CLTLocFormula expectedclock2 = CLTLocFormula
			.G(new CLTLocImplies(new CLTLocRelation(clock0, new Constant(0), Relation.EQ),
					new CLTLocNext(new CLTLocRelease(new CLTLocRelation(clock1, new Constant(0), Relation.EQ),
							CLTLocFormula.getAnd(new CLTLocNegation(xv),
									new CLTLocRelation(clock0, new Constant(0), Relation.GE))))));

	private final CLTLocFormula expectedclock3 = CLTLocFormula
			.G(new CLTLocImplies(new CLTLocRelation(clock1, new Constant(0), Relation.EQ),
					new CLTLocNext(new CLTLocRelease(new CLTLocRelation(clock0, new Constant(0), Relation.EQ),
							CLTLocFormula.getAnd(xv,
									new CLTLocRelation(clock1, new Constant(0), Relation.GE))))));

	private final CLTLocFormula expectedVariable1 = CLTLocFormula.getAnd(
			new CLTLocRelation(new Variable("Example2_i_0"), new Constant(0), Relation.EQ),
			
			CLTLocFormula.getAnd(
					new CLTLocRelation(new Variable("Example2_i_1"), new Constant(0), Relation.GE),
					new CLTLocNegation(new CLTLocSelector("Example2_i_v"))
					));
	
	private final CLTLocFormula expectedphi1 = CLTLocFormula
			.G(
					CLTLocFormula.getAnd(
					CLTLocFormula.getAnd(CLTLocFormula.getAnd(new CLTLocImplies(new CLTLocAP("Example2_l0"),
					CLTLocFormula.getAnd(CLTLocFormula.getNeg(new CLTLocAP("Example2_l1")),
							CLTLocFormula.getNeg(new CLTLocAP("Example2_l2")))),

					new CLTLocImplies(new CLTLocAP("Example2_l1"),
							CLTLocFormula.getAnd(CLTLocFormula.getNeg(new CLTLocAP("Example2_l0")),
									CLTLocFormula.getNeg(new CLTLocAP("Example2_l2"))))),
					new CLTLocImplies(new CLTLocAP("Example2_l2"),
							CLTLocFormula.getAnd(CLTLocFormula.getNeg(new CLTLocAP("Example2_l0")),
									CLTLocFormula.getNeg(new CLTLocAP("Example2_l1"))))),
					CLTLocFormula.getOr(
							CLTLocFormula.getOr(new CLTLocAP("Example2_l0"), new CLTLocAP("Example2_l1")),
							new CLTLocAP("Example2_l2"))
							)
					);

	private final CLTLocFormula expectedphi2 = new CLTLocAP("Example2_l0");

	private final CLTLocFormula expectedphi3 = new CLTLocGlobally(
			new CLTLocImplies(new CLTLocAP("Example2_l1"), new CLTLocDisjunction(
					CLTLocFormula.getAnd(CLTLocFormula.getAnd(new CLTLocNegation(xv),

							new CLTLocRelation(clock0, new Constant(5), Relation.LEQ))),
					CLTLocFormula.getAnd(CLTLocFormula.getAnd(xv,

							new CLTLocRelation(clock1, new Constant(5), Relation.LEQ))
							))));

	
	private final CLTLocFormula transLocation0=
			new CLTLocImplies(new CLTLocAP("Example2_l0"), 
					
							new CLTLocDisjunction(
										CLTLocFormula.getAnd(
												new CLTLocNext(new CLTLocAP("Example2_l0"))
												,
												new CLTLocDisjunction(
														new CLTLocConjunction(
															new CLTLocNegation(new CLTLocSelector("Example2_x_v")),
															new CLTLocNext(
																new CLTLocConjunction(
																		new CLTLocNegation(new CLTLocSelector("Example2_x_v"))
																		, 
																		new CLTLocRelation(new CLTLocClock("Example2_x_0"), new Constant(0), Relation.GE)																
																		)
															)
														)
														,
														new CLTLocConjunction(
																new CLTLocSelector("Example2_x_v"),
																new CLTLocNext(
																	new CLTLocConjunction(
																			new CLTLocSelector("Example2_x_v")
																			, 
																			new CLTLocRelation(new CLTLocClock("Example2_x_1"), new Constant(0), Relation.GE)																
																			)
																	)
																)
														)
													,
													new CLTLocDisjunction(
															CLTLocFormula.getAnd(
																	new CLTLocNegation(new  CLTLocSelector("Example2_i_v")),
																	new CLTLocNext(new CLTLocNegation(new  CLTLocSelector("Example2_i_v"))), 
																	new KeepVariableConstant(new formulae.cltloc.atoms.Variable("Example2_i_0"))																
																	)
															,
															CLTLocFormula.getAnd(
																	new CLTLocSelector("Example2_i_v"),
																	new CLTLocNext(new CLTLocSelector("Example2_i_v")), 
																	new KeepVariableConstant(new formulae.cltloc.atoms.Variable("Example2_i_1"))																
																	)
															)
													
										),
										new CLTLocConjunction(
												new CLTLocNext(new CLTLocAP("Example2_l1"))
												,
												new CLTLocConjunction(
															new CLTLocDisjunction(
																	new CLTLocConjunction(
																			new CLTLocNegation(new CLTLocSelector("Example2_x_v"))
																			, 
																			new CLTLocRelation(new CLTLocClock("Example2_x_0"), new Constant(5), Relation.LEQ)
																	)
																	,
																	new CLTLocConjunction(
																			new CLTLocSelector("Example2_x_v")
																			, 
																			new CLTLocRelation(new CLTLocClock("Example2_x_1"), new Constant(5), Relation.LEQ)
																	)
															)
															,
															new CLTLocConjunction(
															new CLTLocDisjunction(
																	new CLTLocConjunction(
																			new CLTLocNegation(new CLTLocSelector("Example2_x_v")),
																			new CLTLocNext(
																					new CLTLocConjunction(
																								new CLTLocNegation(new CLTLocSelector("Example2_x_v"))
																								, 
																								new CLTLocRelation(new CLTLocClock("Example2_x_0"), new Constant(0), Relation.GE)
																						)
																				)
																	)
																	,
																	new CLTLocConjunction(
																			new CLTLocSelector("Example2_x_v"),
																			new CLTLocNext(
																					new CLTLocConjunction(
																							new CLTLocSelector("Example2_x_v")
																							, 
																							new CLTLocRelation(new CLTLocClock("Example2_x_1"), new Constant(0), Relation.GE)
																					)
																		    )
																	)
															),
														new CLTLocDisjunction(
																CLTLocFormula.getAnd(
																		new CLTLocNegation(new CLTLocSelector("Example2_i_v")),
																		new CLTLocNext(new CLTLocNegation(new CLTLocSelector("Example2_i_v"))), 
																		new KeepVariableConstant(new formulae.cltloc.atoms.Variable("Example2_i_0"))																
																		)
																,
																CLTLocFormula.getAnd(
																		new CLTLocSelector("Example2_i_v"),
																		new CLTLocNext(new CLTLocSelector("Example2_i_v")), 
																		new KeepVariableConstant(new formulae.cltloc.atoms.Variable("Example2_i_1"))																
																		)
																)
														)
													)
										)
									
							)
					
					);
			
	private final CLTLocFormula transLocation1=
			new CLTLocImplies(new CLTLocAP("Example2_l1"), 
					
							new CLTLocDisjunction(
										CLTLocFormula.getAnd(
												new CLTLocNext(new CLTLocAP("Example2_l1"))
												,
												new CLTLocDisjunction(
														new CLTLocConjunction(
																new CLTLocNegation(new CLTLocSelector("Example2_x_v")),
																new CLTLocNext(
																	new CLTLocConjunction(
																			new CLTLocNegation(new CLTLocSelector("Example2_x_v"))
																			, 
																			new CLTLocRelation(new CLTLocClock("Example2_x_0"), new Constant(0), Relation.GE)																
																			)
																)
														)
														,
														new CLTLocConjunction(
																new CLTLocSelector("Example2_x_v"),
																new CLTLocNext(
																		new CLTLocConjunction(
																					new CLTLocSelector("Example2_x_v")
																					, 
																					new CLTLocRelation(new CLTLocClock("Example2_x_1"), new Constant(0), Relation.GE)																
																		)
																)
														)
												)
												,
												new CLTLocDisjunction(
														CLTLocFormula.getAnd(
																new CLTLocNegation(new CLTLocSelector("Example2_i_v")),
																new CLTLocNext(new CLTLocNegation(new CLTLocSelector("Example2_i_v"))), 
																new KeepVariableConstant(new formulae.cltloc.atoms.Variable("Example2_i_0"))																
																)
														,
														CLTLocFormula.getAnd(
																new CLTLocSelector("Example2_i_v"),
																new CLTLocNext(new CLTLocSelector("Example2_i_v")),
																new KeepVariableConstant(new formulae.cltloc.atoms.Variable("Example2_i_1"))																
																)
														)
											)
										,
										new CLTLocConjunction(
												new CLTLocNext(new CLTLocAP("Example2_l2"))
												,
												new CLTLocConjunction(
												new CLTLocDisjunction(
														new CLTLocConjunction(
														new CLTLocNegation(new CLTLocSelector("Example2_x_v")),
														new CLTLocNext(
														new CLTLocConjunction(
															new CLTLocNegation(new CLTLocSelector("Example2_x_v"))
															, 
															new CLTLocRelation(new CLTLocClock("Example2_x_0"), new Constant(0), Relation.GE)
														)
														)
														)
														,
														new CLTLocConjunction(
																new CLTLocSelector("Example2_x_v"),
																new CLTLocNext(
																new CLTLocConjunction(
																	new CLTLocSelector("Example2_x_v")
																	, 
																	new CLTLocRelation(new CLTLocClock("Example2_x_1"), new Constant(0), Relation.GE)
																)
																)
																)
												),
												new CLTLocDisjunction(
														new CLTLocConjunction(
																new CLTLocNegation(new CLTLocSelector("Example2_i_v")),
														new CLTLocNext(
														new CLTLocConjunction(
																new CLTLocSelector("Example2_i_v")
																, 
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example2_i_1"), new Constant(1), Relation.EQ)
																)
														)
														),
														new CLTLocConjunction(
																new CLTLocSelector("Example2_i_v"),
														new CLTLocNext(
														new CLTLocConjunction(
																new CLTLocNegation(new CLTLocSelector("Example2_i_v"))
																, 
																new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example2_i_0"), new Constant(1), Relation.EQ)
																)
														)
														)
														
														)
												)
										)
									)
							
					);
	
	private final CLTLocFormula transLocation2=
			new CLTLocImplies(new CLTLocAP("Example2_l2"), 
					
							new CLTLocDisjunction(
										new CLTLocConjunction(
												new CLTLocNext(new CLTLocAP("Example2_l2"))
												,
												new CLTLocConjunction(
												new CLTLocDisjunction(
														new CLTLocConjunction(
																new CLTLocNegation(new CLTLocSelector("Example2_x_v")),
																new CLTLocNext(
																		new CLTLocConjunction(
																				new CLTLocNegation(new CLTLocSelector("Example2_x_v"))
																				, 
																				new CLTLocRelation(new CLTLocClock("Example2_x_0"), new Constant(0), Relation.GE)		
																				)
																		)
																)
														,
														new CLTLocConjunction(
																new  CLTLocSelector("Example2_x_v"),
																new CLTLocNext(
																		new CLTLocConjunction(
																				new CLTLocSelector("Example2_x_v")
																				, 
																				new CLTLocRelation(new CLTLocClock("Example2_x_1"), new Constant(0), Relation.GE)		
																				)
																		)
																)
														),
												new CLTLocDisjunction(
														CLTLocFormula.getAnd(
																new CLTLocNegation(new CLTLocSelector("Example2_i_v")),
																new CLTLocNext(new CLTLocNegation(new CLTLocSelector("Example2_i_v"))), 
																new KeepVariableConstant(new formulae.cltloc.atoms.Variable("Example2_i_0"))																
																)
														,
														CLTLocFormula.getAnd(
																new CLTLocSelector("Example2_i_v"),
																new CLTLocNext(new CLTLocSelector("Example2_i_v")), 
																new KeepVariableConstant(new formulae.cltloc.atoms.Variable("Example2_i_1"))																
																)
														)
												
												)
												)
										,
										new CLTLocConjunction(
												new CLTLocNext(new CLTLocAP("Example2_l0"))
												,
												new CLTLocConjunction(
												
												new CLTLocDisjunction(
														new CLTLocConjunction(
																new CLTLocNegation(new CLTLocSelector("Example2_x_v")), 
																new CLTLocRelation(new CLTLocClock("Example2_x_0"), new Constant(10), Relation.EQ)
														
													),
														new CLTLocConjunction(
																new CLTLocSelector("Example2_x_v"), 
																new CLTLocRelation(new CLTLocClock("Example2_x_1"), new Constant(10), Relation.EQ)
														)
														
													
												),
												new CLTLocConjunction(
													new CLTLocDisjunction(
															new CLTLocConjunction(
																	new CLTLocNegation(new CLTLocSelector("Example2_x_v")), 
																	new CLTLocNext( 
																			new CLTLocConjunction(
																	new CLTLocSelector("Example2_x_v"), 
																	new CLTLocRelation(new CLTLocClock("Example2_x_1"), new Constant(0), Relation.EQ)
																	)
																)
															),
															new CLTLocConjunction(
																	new CLTLocSelector("Example2_x_v"),
																	new CLTLocNext( 
																			new CLTLocConjunction(
																new CLTLocNegation(new CLTLocSelector("Example2_x_v")), 
																new CLTLocRelation(new CLTLocClock("Example2_x_0"), new Constant(0), Relation.EQ)
																)
															 )
																		
															)
															
															
													)
												,
												new CLTLocDisjunction(
														new CLTLocConjunction(
																new CLTLocNegation(new CLTLocSelector("Example2_i_v")),
																new CLTLocNext(
																		new CLTLocConjunction(
																				new CLTLocSelector("Example2_i_v"), 
																				new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example2_i_1"), new Constant(1), Relation.EQ)
																				)
																		)															)
														,
														new CLTLocConjunction(
																new CLTLocSelector("Example2_i_v"),
																new CLTLocNext(
																		new CLTLocConjunction(
																				new CLTLocNegation(new CLTLocSelector("Example2_i_v"))
																				, 
																				new CLTLocRelation(new formulae.cltloc.atoms.Variable("Example2_i_0"), new Constant(1), Relation.EQ)
																				)
																		)
																
														)
												)
												)
											)
										)
									)
							
					);
	
	
	private final CLTLocFormula expectedphi4=CLTLocFormula.G(
			CLTLocFormula.getAnd(CLTLocFormula.getAnd(transLocation0, transLocation1),transLocation2));

	
	private final CLTLocFormula expectedphi5 = 
			new CLTLocGlobally(
					
					new CLTLocIff(
							new CLTLocAP("H_0")
							,
							new CLTLocDisjunction(
									new CLTLocConjunction(
											new CLTLocNegation(new CLTLocSelector("Example2_i_v"))
											, 
											new CLTLocRelation(new Variable("Example2_i_0"), new Constant(0), Relation.EQ)
											),
									new CLTLocConjunction(
											new CLTLocSelector("Example2_i_v")
											, 
											new CLTLocRelation(new Variable("Example2_i_1"), new Constant(0), Relation.EQ)
											)
									)
							)
					)
			;

	
	private final CLTLocFormula expectedphi6 = new CLTLocGlobally(
			new CLTLocImplies(new CLTLocAP("H_0"),
					new CLTLocNext(
					new CLTLocAP("P_0"))
				));
	
	private final CLTLocFormula expectedphi7 = new CLTLocAP("P_0");


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
		ta2cltloc.convert(system, ta, new HashSet<>(), new HashSet<>());

		assertEquals("Variable 1 formula generated correctly", expectedVariable1, ta2cltloc.getVariable1());

	}

	

	@Test
	public void testClock1() throws IOException {
		TA2CLTLoc ta2cltloc = new TA2CLTLoc();
		ta2cltloc.convert(system, ta, new HashSet<>(), new HashSet<>());
		assertEquals(expectedclock1, ta2cltloc.getClock1());
	}

	@Test
	public void testClock2() throws IOException {
		TA2CLTLoc ta2cltloc = new TA2CLTLoc();
		ta2cltloc.convert(system, ta, new HashSet<>(), new HashSet<>());
		assertEquals(expectedclock2, ta2cltloc.getClock2());
	}

	@Test
	public void testClock3() throws IOException {
		TA2CLTLoc ta2cltloc = new TA2CLTLoc();
		ta2cltloc.convert(system, ta, new HashSet<>(), new HashSet<>());
		assertEquals(expectedclock3, ta2cltloc.getClock3());
	}

	@Test
	public void testPhi1() throws IOException {
		TA2CLTLoc ta2cltloc = new TA2CLTLoc();
		ta2cltloc.convert(system, ta, new HashSet<>(), new HashSet<>());
		
		assertEquals("Variable 1 formula generated correctly", expectedphi1, ta2cltloc.getPhi1());
	}

	@Test
	public void testPhi2() throws IOException {
		TA2CLTLoc ta2cltloc = new TA2CLTLoc();
		ta2cltloc.convert(system, ta, new HashSet<>(), new HashSet<>());
		assertEquals("Variable 1 formula generated correctly", expectedphi2, ta2cltloc.getPhi2());
	}

	@Test
	public void testPhi3() throws IOException {
		TA2CLTLoc ta2cltloc = new TA2CLTLoc();
		ta2cltloc.convert(system, ta, new HashSet<>(), new HashSet<>());
		assertEquals("Variable 1 formula generated correctly", expectedphi3, ta2cltloc.getPhi3());
	}

	
	@Test
	public void testPhi4() throws IOException {
		
		Set<VariableAssignementAP> ap = new HashSet<>();
		ap.add(
				new VariableAssignementAP("0", new ta.Variable("i"), new Value("0")));
		
		TA2CLTLoc ta2cltloc = new TA2CLTLoc();
		ta2cltloc.convert(system, ta, new HashSet<>(),ap);

		assertEquals("Variable 1 formula generated correctly", expectedphi4, ta2cltloc.getPhi4());

	}
	
	@Test
	public void testPhi5() throws IOException {
		Set<VariableAssignementAP> ap = new HashSet<>();
		ap.add(
				new VariableAssignementAP("0", new ta.Variable("i"), new Value("0")));
		TA2CLTLoc ta2cltloc = new TA2CLTLoc();
		ta2cltloc.convert(system, ta, new HashSet<>(),ap);
		
		assertEquals("Variable 1 formula generated correctly", expectedphi5, ta2cltloc.getPhi5());
	}
	
	@Test
	public void testPhi6() throws IOException {
		Set<VariableAssignementAP> ap = new HashSet<>();
		ap.add(
				new VariableAssignementAP("0", new ta.Variable("i"), new Value("0")));
		TA2CLTLoc ta2cltloc = new TA2CLTLoc();
		ta2cltloc.convert(system, ta, new HashSet<>(),ap);
		assertEquals("Variable 1 formula generated correctly", expectedphi6, ta2cltloc.getPhi6());
	}
	
	@Test
	public void testPhi7() throws IOException {
		Set<VariableAssignementAP> ap = new HashSet<>();
		ap.add(
				new VariableAssignementAP("0", new ta.Variable("i"), new Value("0")));
		TA2CLTLoc ta2cltloc = new TA2CLTLoc();
		ta2cltloc.convert(system, ta, new HashSet<>(),ap);
		assertEquals("Variable 1 formula generated correctly", expectedphi7, ta2cltloc.getPhi7());

	}
}
