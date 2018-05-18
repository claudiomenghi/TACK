package tack.checker;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.AbstractMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.BiMap;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Signal;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.operators.unary.CLTLocYesterday;
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
	protected  int bound;

	/**
	 * The stream to be used to write output messages
	 */
	protected final PrintStream out;

	protected CLTLocFormula taFormula;

	protected CLTLocFormula formula;

	protected final SystemDecl system;
	
	private float checkingtime;
	
	private double checkingspace;
	
	private long mitli2cltlocTime=0;
	
	private long ta2clclocTime=0;
	
	
	private long cltloc2zotTime=0;
	
	private long sattime=0;
	
	
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
	public SystemChecker( SystemDecl system, MITLIFormula mitliformula, int bound, PrintStream out) {
		Preconditions.checkNotNull(mitliformula, "The formula of interest cannot be null");
		Preconditions.checkArgument(bound > 0, "The bound should be grater than of zero");

		this.system=system;
		this.mitliformula = mitliformula;
		this.bound = bound;
		this.out = out;

		System.out.println(mitliformula.toString());
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

		if(additionalConstraints==null){
			additionalConstraints=CLTLocFormula.TRUE;
		}
		
		Stopwatch timer = Stopwatch.createUnstarted();
		timer.start();
		out.println("************************************************");
		//out.println("MITLI formula:  " + mitliformula);
		MITLIFormula negatedFormula = MITLIFormula.not(mitliformula);
		out.println("Converting the MITLI formula in CLTLoc");
		MITLI2CLTLoc translator = new MITLI2CLTLoc(negatedFormula);
		formula = translator.apply();
		out.println("MITLI formula converted in CLTLoc");
		//out.println("************************************************");
		//	out.println("**  MITLI FORMULA CLTLoc ENCODING                **");
		//translator.printFancy(out);
		//out.println("************************************************");
		timer.stop();
		mitli2cltlocTime=timer.elapsed(TimeUnit.MILLISECONDS);
		
		BiMap<MITLIFormula, Integer> vocabular = translator.getVocabulary().inverse();
		Set<MITLIRelationalAtom> atoms = mitliformula.accept(new GetRelationalAtomsVisitor());
		Set<VariableAssignementAP> atomicpropositionsVariable = atoms.stream()
				.map(a -> new VariableAssignementAP(
						(a.getIdentifier().contains("_") ?  a.getIdentifier().substring(0, a.getIdentifier().indexOf("_")) : ""),
						vocabular.get(a),
						new ta.Variable(a.getIdentifier().contains("_") ?  a.getIdentifier().substring( a.getIdentifier().indexOf("_")+1, a.getIdentifier().length()) :  a.getIdentifier()), new Value(Integer.toString(a.getValue()))))
				.collect(Collectors.toSet());
		
		
		Set<MITLIPropositionalAtom> propositionalAtoms = mitliformula.accept(new GetPropositionalAtomsVisitor());
		Set<StateAP> atomicpropositions=
				propositionalAtoms.stream().map(a ->  {
				if(!vocabular.containsKey(a)){
					throw new IllegalArgumentException("The proposition "+a+ "is not contained in the alphabet of the vocabulary");
				}
				if( a.getAtomName().indexOf("_")==-1){
					throw new IllegalArgumentException("Error in the proposition: "+a.getAtomName()+"A state proposition  must have the form state_ap");
							
				}
				return new StateAP(vocabular.get(a),a.getAtomName().substring(0, a.getAtomName().indexOf("_")), a.getAtomName().substring(a.getAtomName().indexOf("_")+1, a.getAtomName().length()));
				}		
				).collect(Collectors.toSet());
				
		//out.println("------------------");
		//out.println("CLTLoc encoding");
		//out.println(formula);
		

		
		//out.println("\n");
		//out.println("\n");
		//out.println("\n");
		//out.println("************************************************");
		//out.println("**************     VOCABULARY     ***************");

		StringBuilder vocabularyBuilder = new StringBuilder();
		vocabular.entrySet().forEach(e -> vocabularyBuilder.append(e.getValue() + "\t" + e.getKey() + "\n"));
		System.out.print(vocabularyBuilder.toString());

		out.println("************************************************");
		out.println("************************************************");
		out.println("Converting the TA in CLTLoc");
		
		timer.reset();
		timer.start();
		TANetwork2CLTLoc converter = new TANetwork2CLTLoc();
		
		
		taFormula = converter.convert(system,  atomicpropositions, atomicpropositionsVariable);
		
		
		out.println("TA converted in CLTLoc");

		//out.println("------------------");
		timer.stop();
		this.ta2clclocTime=timer.elapsed(TimeUnit.MILLISECONDS);
		
		out.println("-------------INFO--------");
		//out.println(system.getGlobalClocks());
		//out.println("TA encoding");
		//out.println(taFormula);
		//out.println("************************************************");
		
	
		
		out.println(system.toString());
		out.println("************************************************");
		
		
		//out.println(converter.getMapStateId());
		StringBuilder stateIdMappingBuilder=new StringBuilder();
		system.getTimedAutomata().stream().forEach(ta -> ta.getStates().stream().forEach(s-> stateIdMappingBuilder.append(ta.getIdentifier()+"\t"+s.getStringId()+":\t"+
		converter.getMapStateId().get(
				new AbstractMap.SimpleEntry<>(ta, s.getStringId())
				)+"\n")));
		File stateIdStringMappingfile=new File("elementsIDmap.txt");
		
		FileUtils.writeStringToFile(stateIdStringMappingfile, stateIdMappingBuilder.toString());
		
		StringBuilder transitionsIdMappingBuilder=new StringBuilder();
		system.getTimedAutomata().stream().forEach(ta-> ta.getTransitions().stream().forEach(
				s-> 
					transitionsIdMappingBuilder.append(ta.getIdentifier()+"\t"+s.getSource().getStringId()+"\t"+s.getDestination().getStringId()+"\t"+s.getId()+"\n")
				));
		FileUtils.writeStringToFile(stateIdStringMappingfile, transitionsIdMappingBuilder.toString(), true);
		
		// out.println(formula);
		// out.println(translator.getVocabulary());

		out.println("Creating the of the CLTLoc formulae of the model and the property");
		CLTLocFormula conjunctionFormula = 
				new CLTLocYesterday(
						CLTLocFormula.getAnd(taFormula, formula,additionalConstraints));
		out.println("Conjunction of the formulae created");

		
		CLTLocsolver cltlocSolver=new CLTLocsolver(conjunctionFormula, out, bound);
		boolean sat = cltlocSolver.solve();
		this.sattime=cltlocSolver.getSattime();
		this.checkingspace=cltlocSolver.getCheckingspace();

		this.cltloc2zotTime=cltlocSolver.getCltloc2zottime();
		this.checkingtime=cltlocSolver.getCheckingtime();
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

	public float getCheckingTime() {
		return checkingtime;
	}

	public long getSattime() {
		return sattime;
	}



	public double getCheckingspace() {
		return checkingspace;
	}
	
	public void printCheckingStatistics(){
		out.println("********* CHECHER STATISTICS ********* ");
		out.println("mitli2cltloc: "+this.mitli2cltlocTime);
		out.println("ta2cltloc: "+this.ta2clclocTime);
		out.println("sat: "+this.checkingtime);
		
	}
}
