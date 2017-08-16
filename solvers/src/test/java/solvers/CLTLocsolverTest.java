package solvers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import com.google.common.io.ByteStreams;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.binary.CLTLocUntil;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.relations.CLTLocRelation;
import formulae.cltloc.relations.Relation;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;
import zotrunner.ZotException;

public class CLTLocsolverTest {

	private final PrintStream out = new PrintStream(ByteStreams.nullOutputStream());

	@Test
	public void testContadictionShouldBeUnsat() throws IOException, ZotException {

		CLTLocFormula ap = new CLTLocAP("a");
		CLTLocFormula f = CLTLocFormula.getAnd(ap, CLTLocFormula.getNeg(ap));

		assertFalse("a contradiction should return unsat",
				new CLTLocsolver(f, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}

	@Test
	public void test2() throws IOException, ZotException {

		CLTLocFormula assignment = new CLTLocRelation(new Variable("x"), new Constant(0), Relation.EQ);

		assertTrue("a contradiction should return unsat", new CLTLocsolver(assignment, out, 5).solve());
	}

	@Test
	public void test5() throws IOException, ZotException {

		CLTLocFormula assignment = 
				
				new CLTLocNegation(
						
						new CLTLocUntil(CLTLocFormula.TRUE, 
								CLTLocConjunction.getAnd(new CLTLocAP("p2_cs"), new CLTLocAP("p1_cs"))
								)
						);
				

		assertTrue("a contradiction should return unsat", new CLTLocsolver(assignment, System.out, 5).solve());
	}
	
	
	@Test
	public void testOrigin() throws IOException, ZotException {


		CLTLocFormula f = new CLTLocYesterday(MITLI2CLTLocVisitor.ORIGIN);

		assertTrue("a contradiction should return unsat",
				new CLTLocsolver(f, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}

	@Test
	public void testFalseOrigin() throws IOException, ZotException {


		CLTLocFormula f = new CLTLocYesterday(new CLTLocNext(MITLI2CLTLocVisitor.ORIGIN));
		
		assertFalse("a contradiction should return unsat",
				new CLTLocsolver(f, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}
	
	@Test
	public void testFalseFalseOrigin() throws IOException, ZotException {


		CLTLocFormula f = new CLTLocYesterday(new CLTLocNext(new CLTLocNext(MITLI2CLTLocVisitor.ORIGIN)));
		
		assertFalse("a contradiction should return unsat",
				new CLTLocsolver(f, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}
	
	
	@Test
	public void testNotYesterdaySomethingOrigin() throws IOException, ZotException {


		CLTLocFormula f = new CLTLocYesterday(
				new CLTLocYesterday(new CLTLocAP("tmp")));
		
		assertFalse("a contradiction should return unsat",
				new CLTLocsolver(f, new PrintStream(System.out), 5).solve());
	}
	
	@Test
	public void testFalseOrigin2() throws IOException, ZotException {


		CLTLocFormula f = MITLI2CLTLocVisitor.ORIGIN;
		
		assertFalse("a contradiction should return unsat",
				new CLTLocsolver(f, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}
	
	@Test
	public void testFalseOrigin3() throws IOException, ZotException {


		CLTLocFormula f = new CLTLocYesterday(
				new CLTLocNegation(
				(MITLI2CLTLocVisitor.ORIGIN)));
		
		assertFalse("a contradiction should return unsat",
				new CLTLocsolver(f, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}
	
	@Test
	public void test3() throws IOException, ZotException {

		CLTLocFormula ap = new CLTLocAP("a");
		CLTLocFormula assignment = new CLTLocRelation(new Variable("x"), new Constant(0), Relation.EQ);
		CLTLocFormula f = CLTLocFormula.getAnd(ap, assignment);

		assertTrue("a contradiction should return unsat",
				new CLTLocsolver(f, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}
	
	

	@Test
	public void test4() throws IOException, ZotException {

		CLTLocFormula h1 = new CLTLocAP("H_1");
		CLTLocFormula h0 = new CLTLocAP("H_0");
		CLTLocFormula init = CLTLocFormula.getAnd( new CLTLocRelation(new Variable("A_stop_v"), new Constant(0), Relation.EQ), 
				 new CLTLocRelation(new Variable("A_stop0"), new Constant(0), Relation.EQ)
				);
		CLTLocFormula rel1=CLTLocGlobally.create(new CLTLocIff(init, h1));
		
		CLTLocFormula rel2= CLTLocGlobally.create(new CLTLocIff(h1, new CLTLocNegation(h0)));
		
		CLTLocFormula checked=CLTLocFormula.getAnd(h0, init, rel1,rel2);
		assertFalse("a contradiction should return unsat",
				new CLTLocsolver(checked, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}
	
	
	@Test
	public void test6() throws IOException, ZotException {

		CLTLocFormula h1 = new CLTLocAP("H_1");
		CLTLocFormula h0 = new CLTLocAP("H_0");
		
		CLTLocFormula checked=new CLTLocIff(new CLTLocNext(h1), h0);
		assertTrue(
				new CLTLocsolver(checked, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}
	
	@Test
	public void test7() throws IOException, ZotException {

		CLTLocFormula h1 = new CLTLocAP("H_1");
		CLTLocFormula h0 = new CLTLocAP("H_0");
		
		CLTLocFormula checked=
				new CLTLocYesterday(
				new CLTLocIff(new CLTLocNext(h1), h0));
		assertTrue(
				new CLTLocsolver(checked, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}
	
	@Test
	public void test8() throws IOException, ZotException {

		CLTLocFormula h1 = new CLTLocAP("H_1");
		CLTLocFormula h0 = new CLTLocAP("H_0");
		
		CLTLocFormula checked=
				new CLTLocYesterday(
						CLTLocFormula.getAnd(
				new CLTLocNegation(h1),
				new CLTLocIff(new CLTLocNext(h1), h0)));
		assertTrue(
				new CLTLocsolver(checked, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}
	@Test
	public void yesterday() throws IOException, ZotException {

		CLTLocFormula h0 = new CLTLocAP("H_0");
		CLTLocFormula checked=MITLI2CLTLocVisitor.Y.apply(h0);
		assertTrue("Y(H_0) should be sat",
				new CLTLocsolver(checked, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}
	
	@Test
	public void yesterdayAndCurrently() throws IOException, ZotException {

		CLTLocFormula h0 = new CLTLocAP("H_0");
		CLTLocFormula checked= CLTLocFormula.getAnd(h0, MITLI2CLTLocVisitor.Y.apply(h0));
		assertTrue("Y(H_0) should be sat",
				new CLTLocsolver(checked, new PrintStream(ByteStreams.nullOutputStream()), 5).solve());
	}
	
	
	@Test
	public void origin() throws IOException, ZotException {
		CLTLocFormula checked=MITLI2CLTLocVisitor.ORIGIN;
		
		CLTLocsolver solver=new CLTLocsolver(checked, new PrintStream(System.out), 15);
		
		boolean result=solver.solve();
		
		
		assertFalse("ORIGIN should be sat", result);
	}

	
	
}
