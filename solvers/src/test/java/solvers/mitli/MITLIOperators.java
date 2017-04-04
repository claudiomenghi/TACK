package solvers.mitli;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import formulae.cltloc.CLTLocFormula;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;
import solvers.CLTLocsolver;
import zotrunner.ZotException;

public class MITLIOperators {

	private final PrintStream out = System.out;

	

	@Test
	public void testDown() throws IOException, ZotException {
		CLTLocFormula f = MITLI2CLTLocVisitor.down.apply(1);
		CLTLocsolver sover = new CLTLocsolver(f, out, 5);
		assertTrue(sover.solve());
	}

	@Test
	public void testDownSingularity() throws IOException, ZotException {
		CLTLocFormula f = MITLI2CLTLocVisitor.downSingularity.apply(1);
		CLTLocsolver sover = new CLTLocsolver(f, out, 5);
		assertTrue(sover.solve());
	}

	@Test
	public void testFirst() throws IOException, ZotException {
		CLTLocFormula f = MITLI2CLTLocVisitor.first.apply(1);
		CLTLocsolver sover = new CLTLocsolver(f, out, 5);
		assertTrue(sover.solve());
	}

	@Test
	public void testUp() throws IOException, ZotException {
		CLTLocFormula f = MITLI2CLTLocVisitor.up.apply(1);
		CLTLocsolver sover = new CLTLocsolver(f, out, 5);
		assertTrue(sover.solve());
	}

	@Test
	public void testUpSingularity() throws IOException, ZotException {
		CLTLocFormula f = MITLI2CLTLocVisitor.upSingularity.apply(1);
		CLTLocsolver sover = new CLTLocsolver(f, out, 5);
		assertTrue(sover.solve());
	}

	@Test
	public void testFromNowOnDown() throws IOException, ZotException {
		CLTLocFormula f = MITLI2CLTLocVisitor.fromNowOnDown.apply(1);
		CLTLocsolver sover = new CLTLocsolver(f, out, 5);
		assertTrue(sover.solve());
	}

	@Test
	public void testFromNowOnUp() throws IOException, ZotException {
		CLTLocFormula f = MITLI2CLTLocVisitor.fromNowOnUp.apply(1);
		CLTLocsolver sover = new CLTLocsolver(f, out, 5);
		assertTrue(sover.solve());
	}
	
	@Test
	public void testBeforeDownNowUp() throws IOException, ZotException {
		CLTLocFormula f = MITLI2CLTLocVisitor.beforeDownNowUp.apply(1);
		CLTLocsolver sover = new CLTLocsolver(f, out, 5);
		assertTrue(sover.solve());
	}

	@Test
	public void testBeforeUpNoNowUp() throws IOException, ZotException {
		CLTLocFormula f = MITLI2CLTLocVisitor.beforeUpNowDown.apply(1);
		CLTLocsolver sover = new CLTLocsolver(f, out, 5);
		assertTrue(sover.solve());
	}
}
