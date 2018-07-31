package tack.checker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.BiMap;
import com.google.common.io.ByteStreams;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Signal;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.visitor.GetClocksVisitor;
import formulae.cltloc.visitor.GetSignalVisitor;
import formulae.cltloc.visitor.GetVariablesVisitor;
import formulae.cltloc.visitor.ZotPlugin;
import formulae.mitli.MITLIFormula;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.converters.MITLI2CLTLoc;
import formulae.mitli.visitors.GetPropositionalAtomsVisitor;
import formulae.mitli.visitors.GetRelationalAtomsVisitor;
import solvers.CLTLocsolver;
import ta.StateAP;
import ta.SystemDecl;
import ta.TA;
import ta.VariableAssignementAP;
import ta.expressions.Value;
import ta.visitors.TANetwork2CLTLoc;
import ta.visitors.TANetwork2CLTLocO;
import ta.visitors.TANetwork2CLTLocRC;
import ta.visitors.liveness.Liveness2CLTLoc;
import zotrunner.ZotException;

public class SystemChecker {

	/**
	 * The MITLI formula to be considered
	 */
	protected final MITLIFormula mitliformula;

	/**
	 * The bound to be considered in the verification
	 */
	protected int bound;

	/**
	 * The stream to be used to write output messages
	 */
	protected final PrintStream out;

	protected CLTLocFormula taFormula;

	protected CLTLocFormula formula;

	protected final SystemDecl system;

	private float checkingtime;

	private double checkingspace;

	private long mitli2cltlocTime = 0;

	private long ta2clclocTime = 0;

	private long cltloc2zotTime = 0;

	private long sattime = 0;

	private final TANetwork2CLTLoc converter;
	public long getCltloc2zotTime() {
		return cltloc2zotTime;
	}

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
	public SystemChecker(SystemDecl system, MITLIFormula mitliformula, int bound, TANetwork2CLTLoc converter, PrintStream out
			) {
		Preconditions.checkNotNull(mitliformula, "The formula of interest cannot be null");
		Preconditions.checkArgument(bound > 0, "The bound should be grater than of zero");

		this.system = system;
		this.mitliformula = mitliformula;
		this.bound = bound;
		this.out = out;
		this.converter=converter;

	}

	public long getMitli2cltlocTime() {
		return mitli2cltlocTime;
	}

	public long getTa2clclocTime() {
		return ta2clclocTime;
	}

	/**
	 * checks the timed automaton with respect to the property of interest
	 * 
	 * @return true iff the property of interest is satisfied
	 * 
	 * @throws IOException
	 * @throws ZotException
	 */
	public boolean check(CLTLocFormula additionalConstraints) throws IOException, ZotException {

		if (additionalConstraints == null) {
			additionalConstraints = CLTLocFormula.TRUE;
		}

		Stopwatch timer = Stopwatch.createUnstarted();
		timer.start();
		out.println("************************************************");
		out.println(mitliformula);
		// out.println("MITLI formula: " + mitliformula);
		MITLIFormula negatedFormula = MITLIFormula.not(mitliformula);
		out.println(negatedFormula);
		out.println("Converting the MITLI formula in CLTLoc");
		MITLI2CLTLoc translator = new MITLI2CLTLoc(negatedFormula);
		formula = translator.apply();
		out.println("MITLI formula converted in CLTLoc");
		// out.println("************************************************");
		// out.println("** MITLI FORMULA CLTLoc ENCODING **");
		// translator.printFancy(out);
		// out.println("************************************************");
		timer.stop();
		mitli2cltlocTime = timer.elapsed(TimeUnit.MILLISECONDS);

		BiMap<MITLIFormula, Integer> vocabular = translator.getVocabulary().inverse();
		Set<MITLIRelationalAtom> atoms = mitliformula.accept(new GetRelationalAtomsVisitor());
		Set<VariableAssignementAP> atomicpropositionsVariable = atoms
				.stream().map(
						a -> new VariableAssignementAP(
								(a.getIdentifier().contains("_") ? a
										.getIdentifier().substring(0, a.getIdentifier().indexOf("_")) : ""),
								vocabular.get(a),
								new ta.Variable(a.getIdentifier().contains("_") ? a.getIdentifier()
										.substring(a.getIdentifier().indexOf("_") + 1, a.getIdentifier().length())
										: a.getIdentifier()),
								new Value(Integer.toString(a.getValue()))))
				.collect(Collectors.toSet());

		Set<MITLIPropositionalAtom> propositionalAtoms = mitliformula.accept(new GetPropositionalAtomsVisitor());
		Set<StateAP> atomicpropositions = propositionalAtoms.stream().map(a -> {
			if (!vocabular.containsKey(a)) {
				throw new IllegalArgumentException(
						"The proposition " + a + "is not contained in the alphabet of the vocabulary");
			}
			if (a.getAtomName().indexOf("_") == -1) {
				throw new IllegalArgumentException("Error in the proposition: " + a.getAtomName()
						+ "A state proposition  must have the form state_ap");

			}
			return new StateAP(vocabular.get(a), a.getAtomName().substring(0, a.getAtomName().indexOf("_")),
					a.getAtomName().substring(a.getAtomName().indexOf("_") + 1, a.getAtomName().length()));
		}).collect(Collectors.toSet());

		

		StringBuilder vocabularyBuilder = new StringBuilder();
		vocabular.entrySet().forEach(e -> vocabularyBuilder.append(e.getValue() + "\t" + e.getKey() + "\n"));
	
		
		File binding = new File("binding.txt");
		FileUtils.writeStringToFile(binding, vocabularyBuilder.toString());

		
		out.println("************************************************");
		out.println("************************************************");
		out.println("Converting the TA in CLTLoc");

		timer.reset();
		timer.start();
		
		
	
		

		final TANetwork2CLTLoc conv=converter;

		taFormula = converter.convert(system, atomicpropositions, atomicpropositionsVariable);

		out.println("TA converted in CLTLoc");

		timer.stop();
		this.ta2clclocTime = timer.elapsed(TimeUnit.MILLISECONDS);

		out.println("************************************************");

		// out.println(converter.getMapStateId());
		StringBuilder stateIdMappingBuilder = new StringBuilder();
		system.getTimedAutomata().stream()
				.forEach(ta -> ta.getStates().stream()
						.forEach(s -> stateIdMappingBuilder.append(ta.getIdentifier() + "\t" + s.getStringId() + ":\t"
								+ conv.getMapStateId().get(new AbstractMap.SimpleEntry<>(ta, s.getStringId()))
								+ "\n")));
		File stateIdStringMappingfile = new File("elementsIDmap.txt");

		FileUtils.writeStringToFile(stateIdStringMappingfile, stateIdMappingBuilder.toString());

		StringBuilder transitionsIdMappingBuilder = new StringBuilder();
		system.getTimedAutomata().stream()
				.forEach(ta -> ta.getTransitions().stream().forEach(
						s -> transitionsIdMappingBuilder.append(ta.getIdentifier() + "\t" + s.getSource().getStringId()
								+ "\t" + s.getDestination().getStringId() + "\t" + s.getId() + "\n")));
		FileUtils.writeStringToFile(stateIdStringMappingfile, transitionsIdMappingBuilder.toString(), true);


		out.println("Creating the CLTLoc formulae of the model and the property");
		CLTLocFormula conjunctionFormula = new CLTLocYesterday(
				CLTLocFormula.getAnd(taFormula, formula, additionalConstraints));
		out.println("Conjunction of the formulae created");

		out.println("Running ZOT... This might take a while");
		CLTLocsolver cltlocSolver = new CLTLocsolver(conjunctionFormula, new PrintStream( ByteStreams.nullOutputStream()), bound);
		boolean sat = cltlocSolver.solve();
		this.sattime = cltlocSolver.getSattime();
		this.checkingspace = cltlocSolver.getCheckingspace();

		this.cltloc2zotTime = cltlocSolver.getCltloc2zottime();
		this.checkingtime = cltlocSolver.getCheckingtime();

		if (sat == true) {
			this.generateTACKHistory("./output.hist.txt", "counterexample.txt", converter, system);
		}
		return sat ? false : true;
	}

	private void generateTACKHistory(String zotHistoryFile, String tackHistoryFile, TANetwork2CLTLoc converter,SystemDecl system) {

		System.out.println("\n Back parsing the history");
		File zotHistory = new File(zotHistoryFile);
		File tackHistory = new File(tackHistoryFile);

		Set<String> variables = new HashSet<>();
		Set<String> clocks = new HashSet<>();


		for (TA ta : converter.getMapIdTA().values()) {
			variables.addAll(ta.getAllVariables().stream().map(v -> (ta.getIdentifier()+"_"+v.getName()).toUpperCase()).collect(Collectors.toSet()));
		}
		
		variables.addAll(	system.getVariableDeclaration().stream().map(v -> v.getId().toUpperCase()).collect(Collectors.toSet()));
		clocks.addAll(system.getClockDeclarations().stream().map(v -> v.getId().toUpperCase()+"_0").collect(Collectors.toSet()));
		
		try {
			BufferedWriter wr = new BufferedWriter(new FileWriter(tackHistory));
			BufferedReader br = new BufferedReader(new FileReader(zotHistory));
			String line;

			while ((line = br.readLine()) != null) {
				line=line.replace(" ", "");
				if (line.startsWith("------time")) {
					wr.write(line + "\n");
				}
				if (line.toUpperCase().startsWith(converter.STATE_PREFIX)) {
					
					String taID = line.toUpperCase().substring(converter.STATE_PREFIX.length(), line.indexOf("="));
					TA ta = converter.getMapIdTA().get(Integer.parseInt(taID));
					String taName = ta.getIdentifier();
					String stateID = line.toUpperCase().substring(line.indexOf("=") + 1, line.length());

					String stateName = converter.getMapIdStateName().get(Integer.parseInt(stateID));
					wr.write(taName + "." + stateName + "\n");
				}
				
				if (line.contains("=")) {
					if (variables.contains(line.substring(0, line.indexOf("=")).toUpperCase())) {
						wr.write(line+"\n");
					}
				}
				if (line.contains("=")) {
					if (clocks.contains(line.substring(0, line.indexOf("=")).toUpperCase())) {
						wr.write(line.replace("_0", "")+"\n");
					}
				}

				if (line.toUpperCase().contains("NOW")) {
					wr.write(line + "\n");
				}
				if(line.toUpperCase().contains("LOOP")) {
					wr.write(line + "\n");
				}
			}
			br.close();
			wr.close();
		} catch (Exception e) {
			System.out.println("Error! No file " + zotHistoryFile + " detected");
			e.printStackTrace();
		}

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

	public float getCheckingTime() {
		return checkingtime;
	}

	public long getSattime() {
		return sattime;
	}

	public double getCheckingspace() {
		return checkingspace;
	}

	public void printCheckingStatistics() {
		out.println("********* CHECHER STATISTICS ********* ");
		out.println("mitli2cltloc: " + this.mitli2cltlocTime);
		out.println("ta2cltloc: " + this.ta2clclocTime);
		out.println("sat: " + this.checkingtime);

	}
}
