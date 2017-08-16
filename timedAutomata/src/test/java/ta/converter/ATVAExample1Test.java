package ta.converter;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocSelector;
import formulae.cltloc.atoms.Constant;
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
import ta.parser.TALexer;
import ta.parser.TAParser;

public class ATVAExample1Test {

	private final String filename = "ta/converter/atvaexample1.ta";

	private TA ta;
	private SystemDecl system;

	private final static CLTLocClock clock0 = new CLTLocClock("Example1_x_0");
	private final static CLTLocClock clock1 = new CLTLocClock("Example1_x_1");
	private final static CLTLocSelector xv = new CLTLocSelector("Example1_x_v");

	private final CLTLocFormula expectedclock1 = CLTLocFormula.getAnd(
			new CLTLocRelation(clock0, new Constant(0), Relation.EQ),
			CLTLocFormula.getAnd(
					new CLTLocRelation(clock1, new Constant(0), Relation.GE),
					new CLTLocNegation(xv)
					));

	private final CLTLocFormula expectedclock2 =  CLTLocGlobally.create(CLTLocImplies.create(new CLTLocRelation(clock0, new Constant(0), Relation.EQ),
					new CLTLocNext(new CLTLocRelease(new CLTLocRelation(clock1, new Constant(0), Relation.EQ),
							CLTLocFormula.getAnd(new CLTLocNegation(xv),
									new CLTLocRelation(clock0, new Constant(0), Relation.GE))))));

	private final CLTLocFormula expectedclock3 =  CLTLocGlobally.create(CLTLocImplies.create(new CLTLocRelation(clock1, new Constant(0), Relation.EQ),
					new CLTLocNext(new CLTLocRelease(new CLTLocRelation(clock0, new Constant(0), Relation.EQ),
							CLTLocFormula.getAnd(xv,
									new CLTLocRelation(clock1, new Constant(0), Relation.GE))))));

	private final CLTLocFormula expectedphi1 = 
			
			 CLTLocGlobally.create(
					CLTLocFormula.getAnd(
					CLTLocFormula.getAnd(CLTLocFormula.getAnd(CLTLocImplies.create(new CLTLocAP("Example1_l0"),
					CLTLocFormula.getAnd(CLTLocFormula.getNeg(new CLTLocAP("Example1_l1")),
							CLTLocFormula.getNeg(new CLTLocAP("Example1_l2")))),

					CLTLocImplies.create(new CLTLocAP("Example1_l1"),
							CLTLocFormula.getAnd(CLTLocFormula.getNeg(new CLTLocAP("Example1_l0")),
									CLTLocFormula.getNeg(new CLTLocAP("Example1_l2"))))),
					CLTLocImplies.create(new CLTLocAP("Example1_l2"),
							CLTLocFormula.getAnd(CLTLocFormula.getNeg(new CLTLocAP("Example1_l0")),
									CLTLocFormula.getNeg(new CLTLocAP("Example1_l1"))))),
					CLTLocDisjunction.getCLTLocDisjunction(
					CLTLocDisjunction.getCLTLocDisjunction(new CLTLocAP("Example1_l0"), new CLTLocAP("Example1_l1"))
						, new CLTLocAP("Example1_l2"))
							)
					);

	private final CLTLocFormula expectedphi2 = new CLTLocAP("Example1_l0");

	private final CLTLocFormula expectedphi3 =  CLTLocGlobally.create(
			CLTLocImplies.create(new CLTLocAP("Example1_l1"), CLTLocDisjunction.getCLTLocDisjunction(
					CLTLocFormula.getAnd(CLTLocFormula.getAnd(new CLTLocNegation(xv),
							new CLTLocRelation(clock0, new Constant(5), Relation.LEQ))),
					CLTLocFormula.getAnd(CLTLocFormula.getAnd(xv,
							new CLTLocRelation(clock1, new Constant(5), Relation.LEQ))))));

	
	private final CLTLocFormula transLocation0=
			CLTLocImplies.create(new CLTLocAP("Example1_l0"), 
					
							CLTLocDisjunction.getCLTLocDisjunction(
										CLTLocFormula.getAnd(
												new CLTLocNext(new CLTLocAP("Example1_l0"))
												,
												CLTLocDisjunction.getCLTLocDisjunction(
														CLTLocFormula.getAnd(
																new CLTLocNegation(new CLTLocSelector("Example1_x_v")), 
																new CLTLocNext(
																		CLTLocFormula.getAnd(
																				new CLTLocNegation(new CLTLocSelector("Example1_x_v")),
																				new CLTLocRelation(new CLTLocClock("Example1_x_0"), new Constant(0), Relation.GE)
																		)
																	)
																)
														,
														CLTLocFormula.getAnd(
																new CLTLocSelector("Example1_x_v"), 
																new CLTLocNext(
																		CLTLocFormula.getAnd(
																				new CLTLocSelector("Example1_x_v"),
																				new CLTLocRelation(new CLTLocClock("Example1_x_1"), new Constant(0), Relation.GE)
																		)
																	)
																)
												)
												)
										,
										CLTLocConjunction.getAnd(
												new CLTLocNext(new CLTLocAP("Example1_l1"))
												,
												CLTLocConjunction.getAnd(
												
														CLTLocDisjunction.getCLTLocDisjunction(
														CLTLocConjunction.getAnd(
															new CLTLocNegation(new CLTLocSelector("Example1_x_v"))
															, 
															new CLTLocRelation(new CLTLocClock("Example1_x_0"), new Constant(5), Relation.LEQ)
																	
															
														)
														,
														CLTLocConjunction.getAnd(
																new CLTLocSelector("Example1_x_v")
																, 
																new CLTLocRelation(new CLTLocClock("Example1_x_1"), new Constant(5), Relation.LEQ)
														)
												)
												,
												CLTLocDisjunction.getCLTLocDisjunction(
														CLTLocConjunction.getAnd(
															new CLTLocNegation(new CLTLocSelector("Example1_x_v"))
															, 
															new CLTLocNext(
																	CLTLocConjunction.getAnd(
																			new CLTLocNegation(new CLTLocSelector("Example1_x_v")),
																			new CLTLocRelation(new CLTLocClock("Example1_x_0"), new Constant(0), Relation.GE)
																			)
																	)
															)
														,
														CLTLocConjunction.getAnd(
																new CLTLocSelector("Example1_x_v")
																, 
																new CLTLocNext(
																		CLTLocConjunction.getAnd(
																				new CLTLocSelector("Example1_x_v"),
																				new CLTLocRelation(new CLTLocClock("Example1_x_1"), new Constant(0), Relation.GE)
																		)
																)
														)
												)
												)
										)
						)
					);
			
	private final CLTLocFormula transLocation1=
			CLTLocImplies.create(new CLTLocAP("Example1_l1"), 
					
							CLTLocDisjunction.getCLTLocDisjunction(
										CLTLocConjunction.getAnd(
												new CLTLocNext(new CLTLocAP("Example1_l1"))
												,
												CLTLocDisjunction.getCLTLocDisjunction(
														CLTLocFormula.getAnd(
																new CLTLocNegation(new CLTLocSelector("Example1_x_v")), 
																new CLTLocNext(
																		CLTLocFormula.getAnd(
																				new CLTLocNegation(new CLTLocSelector("Example1_x_v")),
																				new CLTLocRelation(new CLTLocClock("Example1_x_0"), new Constant(0), Relation.GE)
																		)
																	)
																)
														,
														CLTLocFormula.getAnd(
																new CLTLocSelector("Example1_x_v"), 
																new CLTLocNext(
																		CLTLocFormula.getAnd(
																				new CLTLocSelector("Example1_x_v"),
																				new CLTLocRelation(new CLTLocClock("Example1_x_1"), new Constant(0), Relation.GE)
																		)
																	)
																)
												)
												)
										,
										CLTLocConjunction.getAnd(
												new CLTLocNext(new CLTLocAP("Example1_l2"))
												,
												
													CLTLocDisjunction.getCLTLocDisjunction(
															CLTLocConjunction.getAnd(
																new CLTLocNegation(new CLTLocSelector("Example1_x_v"))
																, 
																new CLTLocNext(
																		CLTLocConjunction.getAnd(
																				new CLTLocNegation(new CLTLocSelector("Example1_x_v")),
																				new CLTLocRelation(new CLTLocClock("Example1_x_0"), new Constant(0), Relation.GE)
																		)
																)
															)
															,
															CLTLocConjunction.getAnd(
																	new CLTLocSelector("Example1_x_v")
																	, 
																	new CLTLocNext(
																			CLTLocConjunction.getAnd(
																					new CLTLocSelector("Example1_x_v"),
																					new CLTLocRelation(new CLTLocClock("Example1_x_1"), new Constant(0), Relation.GE)
																			)
																	)
															)
													
													)
												
										)
									)
							
					);
	
	private final CLTLocFormula transLocation2=
			CLTLocImplies.create(new CLTLocAP("Example1_l2"), 
					
							CLTLocDisjunction.getCLTLocDisjunction(
										CLTLocConjunction.getAnd(
												new CLTLocNext(new CLTLocAP("Example1_l2"))
												,
												CLTLocDisjunction.getCLTLocDisjunction(
														CLTLocFormula.getAnd(
																new CLTLocNegation(new CLTLocSelector("Example1_x_v")), 
																new CLTLocNext(
																		CLTLocFormula.getAnd(
																				new CLTLocNegation(new CLTLocSelector("Example1_x_v")),
																				new CLTLocRelation(new CLTLocClock("Example1_x_0"), new Constant(0), Relation.GE)
																		)
																	)
																)
														,
														CLTLocFormula.getAnd(
																new CLTLocSelector("Example1_x_v"), 
																new CLTLocNext(
																		CLTLocFormula.getAnd(
																				new CLTLocSelector("Example1_x_v"),
																				new CLTLocRelation(new CLTLocClock("Example1_x_1"), new Constant(0), Relation.GE)
																		)
																	)
																)
												)
												)
										,
										CLTLocConjunction.getAnd(
												new CLTLocNext(new CLTLocAP("Example1_l0"))
												,
												CLTLocConjunction.getAnd(
												CLTLocDisjunction.getCLTLocDisjunction(
														CLTLocConjunction.getAnd(
															new CLTLocNegation(new CLTLocSelector("Example1_x_v"))
															, 
															new CLTLocRelation(new CLTLocClock("Example1_x_0"), new Constant(10), Relation.EQ)
														)
														,
														CLTLocConjunction.getAnd(
																new CLTLocSelector("Example1_x_v")
																, 
																new CLTLocRelation(new CLTLocClock("Example1_x_1"), new Constant(10), Relation.EQ)
														)
												),
												CLTLocDisjunction.getCLTLocDisjunction(
														CLTLocConjunction.getAnd(
															new CLTLocNegation(new CLTLocSelector("Example1_x_v"))
															, 
															new CLTLocNext(
																	CLTLocConjunction.getAnd(
																				new CLTLocSelector("Example1_x_v"),
																				new CLTLocRelation(new CLTLocClock("Example1_x_1"), new Constant(0), Relation.EQ)
																			)
															)
														)
														,
														CLTLocConjunction.getAnd(
																new CLTLocSelector("Example1_x_v")
																, 
																new CLTLocNext(
																		CLTLocConjunction.getAnd(
																					new CLTLocNegation(new CLTLocSelector("Example1_x_v")),
																					new CLTLocRelation(new CLTLocClock("Example1_x_0"), new Constant(0), Relation.EQ)
																				)
																)
														)
												)
												)
										)
									
							)
					);
	
	private final CLTLocFormula expectedphi4= CLTLocGlobally.create(
			CLTLocFormula.getAnd(CLTLocFormula.getAnd(transLocation0, transLocation1),transLocation2));
	private final CLTLocFormula expectedphi5 =  CLTLocGlobally.create(
			new CLTLocIff(new CLTLocAP("Example1_l0"), new CLTLocAP("H_Example1_l0")));
	
	private final CLTLocFormula expectedphi6 =  CLTLocGlobally.create(
			CLTLocImplies.create(new CLTLocAP("H_Example1_l0"), 
					new CLTLocNext(
					new CLTLocAP("P_Example1_l0"))));
	
	private final CLTLocFormula expectedphi7 = new CLTLocAP("P_Example1_l0");

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



	
}
