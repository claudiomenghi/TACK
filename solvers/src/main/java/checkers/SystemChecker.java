package checkers;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.BiMap;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Signal;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.visitor.GetClocksVisitor;
import formulae.cltloc.visitor.GetSignalVisitor;
import formulae.cltloc.visitor.GetVariablesVisitor;
import formulae.mitli.MITLIFormula;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.converters.MITLI2CLTLoc;
import formulae.mitli.visitors.GetPropositionalAtomsVisitor;
import formulae.mitli.visitors.GetRelationalAtomsVisitor;
import solvers.CLTLocsolver;
import ta.StateAP;
import ta.SystemDecl;
import ta.VariableAssignementAP;
import ta.expressions.Value;
import ta.visitors.TANetwork2CLTLoc;
import zotrunner.ZotException;

public class SystemChecker  {

	/**
	 * The MITLI formula to be considered
	 */
	protected final MITLIFormula mitliformula;

	/**
	 * The bound to be considered in the verification
	 */
	protected final int bound;

	/**
	 * The stream to be used to write output messages
	 */
	protected final PrintStream out;

	protected CLTLocFormula taFormula;

	protected CLTLocFormula formula;

	protected final SystemDecl system;
	
	private double checkingtime;
	
	private double checkingspace;
	
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
	public SystemChecker( SystemDecl system, MITLIFormula mitliformula, int bound, PrintStream out) {
		Preconditions.checkNotNull(mitliformula, "The formula of interest cannot be null");
		Preconditions.checkArgument(bound > 0, "The bound should be grater than of zero");

		this.system=system;
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
	 * @throws ZotException
	 */
	public boolean check() throws IOException, ZotException {

		
		Stopwatch timer = Stopwatch.createUnstarted();
		timer.start();
		out.println("************************************************");
		out.println("************************************************");
		out.println("MITLI formula:  " + mitliformula);
		MITLIFormula negatedFormula = MITLIFormula.not(mitliformula);
		out.println("Converting the MITLI formula in CLTLoc");
		MITLI2CLTLoc translator = new MITLI2CLTLoc(negatedFormula, this.bound);
		formula = translator.apply();
		out.println("MITLI formula converted in CLTLoc");
		out.println("************************************************");
		out.println("**  MITLI FORMULA CLTLoc ENCODING                **");
		translator.printFancy(out);
		out.println("************************************************");

		BiMap<MITLIFormula, Integer> vocabular = translator.getVocabulary().inverse();
		Set<MITLIRelationalAtom> atoms = mitliformula.accept(new GetRelationalAtomsVisitor());
		Set<VariableAssignementAP> atomicpropositionsVariable = atoms.stream()
				.map(a -> new VariableAssignementAP(Integer.toString(vocabular.get(a)),
						new ta.Variable(a.getIdentifier()), new Value(Integer.toString(a.getValue()))))
				.collect(Collectors.toSet());
		
		
		Set<MITLIPropositionalAtom> propositionalAtoms = mitliformula.accept(new GetPropositionalAtomsVisitor());
		Set<StateAP> atomicpropositions=
				propositionalAtoms.stream().map(a ->  
				new StateAP(Integer.toString(vocabular.get(a)),a.getAtomName().substring(0, a.getAtomName().indexOf("_")), a.getAtomName().substring(a.getAtomName().indexOf("_")+1, a.getAtomName().length()))).collect(Collectors.toSet());
				
		out.println("------------------");
		out.println("CLTLoc encoding");
		out.println(formula);
		
		out.println("************************************************************************");
		out.println("***ADDING THE CONTRAINT THAT THE FORMULA INITIALLY HOLDS ******");
		CLTLocFormula initFormula = new CLTLocAP("H_" + vocabular.get(negatedFormula));
		out.println("Contstraint: ");
		out.println(initFormula);
		formula = new CLTLocConjunction(formula, CLTLocFormula.Y(initFormula));

		out.println("\n");
		out.println("\n");
		out.println("\n");
		out.println("************************************************");
		out.println("**************     VOCABULARY     ***************");

		StringBuilder vocabularyBuilder = new StringBuilder();
		vocabular.entrySet().forEach(e -> vocabularyBuilder.append(e.getValue() + "\t" + e.getKey() + "\n"));
		out.print(vocabularyBuilder.toString());

		out.println("************************************************");
		out.println("************************************************");
		out.println("Converting the TA in CLTLoc");
		
		TANetwork2CLTLoc converter = new TANetwork2CLTLoc();
		taFormula = converter.convert(system,  atomicpropositions, atomicpropositionsVariable);
		out.println("TA converted in CLTLoc");

		converter.printFancy(out);

		out.println("-------------INFO");

		final StringBuilder builder = new StringBuilder();

		builder.append("clock: \t");
		Set<CLTLocClock> clocks = taFormula.accept(new GetClocksVisitor());
		clocks.forEach(clock -> builder.append(clock.toString() + "\t"));
		builder.append("\n");
		builder.append("signals: \t");
		Set<Signal> signals = taFormula.accept(new GetSignalVisitor());
		signals.forEach(signal -> builder.append(signal.toString() + "\t"));
		builder.append("\n");
		builder.append("variables: \t");
		Set<Variable> variables = taFormula.accept(new GetVariablesVisitor());
		variables.forEach(variable -> builder.append(variable.toString() + "\t"));
		builder.append("\n");

		out.println(builder.toString());
		out.println("************************************************");

		// out.println(formula);
		// out.println(translator.getVocabulary());

		out.println("Creating the conjunction of the formulae");
		CLTLocFormula conjunctionFormula = new CLTLocConjunction(taFormula, formula);
		out.println("Conjunction of the formulae created");

		CLTLocsolver cltlocSolver=new CLTLocsolver(conjunctionFormula, out, bound);
		boolean sat = cltlocSolver.solve();
		this.checkingtime=cltlocSolver.getCheckingtime();
		this.checkingspace=cltlocSolver.getCheckingspace();

		timer.stop();
		//checkingtime=timer.elapsed(TimeUnit.SECONDS);
		return sat ? false : true;
	}

	public CLTLocFormula getTAEncoding() {
		return taFormula;
	}

	public SystemDecl getSystem() {
		return system;
	}
	public CLTLocFormula getFormulaEncoding() {
		return formula;
	}

	public double getCheckingtime() {
		return checkingtime;
	}

	public double getCheckingspace() {
		return checkingspace;
	}
}
