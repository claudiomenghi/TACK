package solvers;

import java.io.IOException;
import java.io.PrintStream;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.converters.CLTLoc2ZotBvzot;
import formulae.cltloc.visitor.CLTLoc2StringVisitor;
import zotrunner.ZotException;
import zotrunner.ZotRunner;

public class CLTLocsolver {
	private final CLTLocFormula formula;
	private final PrintStream out;
	private final int bound;


	private float checkingtime;
	
	private long checkingspace;
	
	public CLTLocsolver(CLTLocFormula formula, PrintStream out, int bound) {

		this.formula = formula;
		this.out = out;
		this.bound = bound;

	}

	public boolean solve() throws IOException, ZotException {
		out.println("Converting the following CLTLoc formula in zot");
		out.println(formula.accept(new CLTLoc2StringVisitor()).getKey());
		String zotEncoding = new CLTLoc2ZotBvzot(bound).apply(formula);

		out.println("************************************************");
		out.println("ZOT ENCODING");
		out.println(zotEncoding);
		out.println("************************************************");

		out.println("Formula converted in zot");
		ZotRunner zotRunner=new ZotRunner(zotEncoding, out);
		boolean sat = zotRunner.run();
		this.checkingtime=zotRunner.getCheckingtime();
		this.checkingspace=zotRunner.getCheckingspace();
		return sat;
	}

	public float getCheckingtime() {
		return checkingtime;
	}

	public long getCheckingspace() {
		return checkingspace;
	}
}
