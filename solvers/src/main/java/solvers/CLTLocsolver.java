package solvers;

import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.converters.CLTLoc2Ae2zot;
import formulae.cltloc.visitor.CLTLoc2StringVisitor;
import formulae.cltloc.visitor.CLTLocGetMaxBound;
import zotrunner.ZotException;
import zotrunner.ZotRunner;

public class CLTLocsolver {
	private final CLTLocFormula formula;
	private final PrintStream out;
	private final int bound;


	private float checkingtime;
	
	private double checkingspace;
	
	private long cltloc2zottime;
	
	private long sattime;
	
	
	public CLTLocsolver(CLTLocFormula formula, PrintStream out, int bound) {

		this.formula = formula;
		this.out = out;
		this.bound = bound;

	}

	public boolean solve() throws IOException, ZotException {
		Stopwatch timer = Stopwatch.createUnstarted();
		timer.start();
		out.println("Converting the following CLTLoc formula in zot");
		out.println(formula.accept(new CLTLoc2StringVisitor()).getKey());
		
		//String zotEncoding = new CLTLoc2Ae2sbvzot(bound).apply(formula);
		
		
		String zotEncoding = new CLTLoc2Ae2zot(bound, formula.accept(new CLTLocGetMaxBound())).apply(formula);
		timer.stop();
		cltloc2zottime=timer.elapsed(TimeUnit.MILLISECONDS);
	
		
		out.println("************************************************");
		out.println("ZOT ENCODING");
		out.println(zotEncoding);
		out.println("************************************************");

		out.println("Formula converted in zot");
		timer.reset();
		timer.start();
		
		ZotRunner zotRunner=new ZotRunner(zotEncoding, out);
		boolean sat = zotRunner.run();
		
		
		timer.stop();
		this.sattime=zotRunner.getSatTime();
		this.checkingspace=zotRunner.getCheckingspace();
		this.checkingtime=zotRunner.getCheckingtime();
	
		return sat;
	}

	public long getSattime() {
		return sattime;
	}

	public long getCltloc2zottime() {
		return cltloc2zottime;
	}

	public float getCheckingtime() {
		return checkingtime;
	}

	public double getCheckingspace() {
		return checkingspace;
	}
}
