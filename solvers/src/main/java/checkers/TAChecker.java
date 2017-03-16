package checkers;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.converters.CLTLoc2Zot;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.mitli.MITLIFormula;
import formulae.mitli.converters.MITLI2CLTLoc;
import ta.AP;
import ta.TA;
import ta.visitors.TA2CLTLoc;
import zotrunner.ZotRunner;

public class TAChecker {

	/**
	 * The timed automaton to be verified
	 */
	private final TA ta;

	/**
	 * The MITLI formula to be considered
	 */
	private final MITLIFormula mitliformula;

	/**
	 * The bound to be considered in the verification
	 */
	private final int bound;

	/**
	 * The stream to be used to write output messages
	 */
	private final PrintStream out;
	
	private CLTLocFormula taFormula;
	
	private CLTLocFormula formula;

	/**
	 * 
	 * @param ta
	 *            the timed automaton to be verified
	 * @param mitliformula
	 *            the MITLI to be considered
	 * @param bound
	 *            the bound to be used
	 * @throws NullPointerException
	 *             if the timed automaton is null
	 * @throws NullPointerException
	 *             if the MITLI formula is null
	 * @throws IllegalArgumentException
	 *             if the bound is not grater than zero
	 */
	public TAChecker(TA ta, MITLIFormula mitliformula, int bound, PrintStream out) {
		Preconditions.checkNotNull(ta, "The timed automaton cannot be null");
		Preconditions.checkNotNull(mitliformula, "The formula of interest cannot be null");
		Preconditions.checkArgument(bound > 0, "The bound should be grater than of zero");

		this.ta = ta;
		this.mitliformula = mitliformula;
		this.bound = bound;
		this.out = out;

	}

	/**
	 * checks the timed automaton with respect to the property of interest
	 * 
	 * @return true iff the property of interest is satisfied
	 * 
	 * @throws IOException
	 */
	public boolean check() throws IOException {
		Set<AP> propositions = new HashSet<>();

		out.println("Converting the TA in CLTLoc");
		taFormula = new TA2CLTLoc().convert(ta, propositions, true);
		out.println("TA converted in CLTLoc");

		out.println(taFormula);
		
		out.println("Converting the MITLI formula in CLTLoc");
		MITLI2CLTLoc translator=new MITLI2CLTLoc(mitliformula, this.bound);
		formula = translator.apply();
		out.println("MITLI formula converted in CLTLoc");
		//out.println(formula);
		//out.println(translator.getVocabulary());
		
		out.println("Creating the conjunction of the formulae");
		CLTLocFormula conjunctionFormula = new CLTLocConjunction(taFormula, formula);
		out.println("Conjunction of the formulae created");

		out.println("Converting the conjunction in zot");
		String zotEncoding = new CLTLoc2Zot(bound).apply(conjunctionFormula);
		//out.println(zotEncoding);
		
		out.println("Conjunction converted in zot");

		boolean sat = new ZotRunner(zotEncoding, out).run();

		return sat;
	}
}
