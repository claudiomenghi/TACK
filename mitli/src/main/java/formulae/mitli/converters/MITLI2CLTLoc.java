package formulae.mitli.converters;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.relations.CLTLocEQRelation;
import formulae.cltloc.relations.CLTLocGEQRelation;
import formulae.cltloc.relations.CLTLocGERelation;
import formulae.cltloc.visitor.CLTLoc2StringVisitor;
import formulae.cltloc.visitor.GetClocksVisitor;
import formulae.mitli.MITLIFormula;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;
import formulae.mitli.visitors.SubformulaeVisitor;

public class MITLI2CLTLoc {

	private final MITLI2CLTLocVisitor visitor;
	private final MITLIFormula formula;

	private boolean converted = false;
	private final Map<MITLIFormula, CLTLocFormula> generatedFormulaMap;
	private final Map<MITLIFormula, CLTLocFormula> clockcontraintFormulaMap;

	private final Map<MITLIFormula, Set<MITLIFormula>> parentRelation;

	public MITLI2CLTLoc(MITLIFormula formula) {
		this.formula = formula;
		this.visitor = new MITLI2CLTLocVisitor(formula);
		this.generatedFormulaMap = new HashMap<>();
		this.clockcontraintFormulaMap = new HashMap<>();
		this.parentRelation = new HashMap<>();

	}

	private void populateParentRelation(MITLIFormula f) {
		Set<MITLIFormula> chidren = f.getChildren();
		chidren.forEach(c ->

		{
			if (!parentRelation.containsKey(c)) {
				parentRelation.put(c, new HashSet<>());
			}
			parentRelation.get(c).add(f);

		});

		chidren.forEach(c -> this.populateParentRelation(c));

	}

	public CLTLocFormula apply() {

		this.populateParentRelation(formula);

		// CLTLocFormula init =
		// (formula instanceof MITLINegation )?
		// CLTLocFormula.getNeg(MITLI2CLTLocVisitor.first.apply(visitor.formulaIdMap.get(formula)))
		CLTLocFormula init = MITLI2CLTLocVisitor.first.apply(visitor.formulaIdMap.get(formula));
		// init =CLTLocFormula.TRUE;

		CLTLocFormula conjunction = CLTLocFormula.TRUE;
		for (MITLIFormula f : formula.accept(new SubformulaeVisitor())) {

			CLTLocFormula f1 = visitor.getckTheta(f, parentRelation);
			
			CLTLocFormula f2 = f.accept(visitor);

			CLTLocFormula f3= CLTLocFormula.TRUE;
			f3 = visitor.getClockProgression(f, parentRelation);
			
			CLTLocFormula formula = CLTLocFormula.getAnd(f1, f2, f3);
			this.generatedFormulaMap.put(f, f1);
			this.clockcontraintFormulaMap.put(f, f2);

			conjunction = CLTLocFormula.getAnd(conjunction, formula);

		}

		CLTLocFormula nowConstraint = CLTLocFormula.getAnd(
				new CLTLocEQRelation(new CLTLocClock("Now"), new Constant(0)),
				new CLTLocNext(CLTLocGlobally.create(new CLTLocGERelation(new CLTLocClock("Now"), new Constant(0)))));

		Set<CLTLocClock> clocks = conjunction.accept(new GetClocksVisitor());

		CLTLocFormula clockConstraint = CLTLocFormula.TRUE;

		for (CLTLocClock clock : clocks) {
			clockConstraint = CLTLocFormula.getAnd(clockConstraint, 
					new CLTLocGEQRelation(clock, new Constant(0)));
		}

	
		
		
		CLTLocFormula formula = CLTLocFormula.getAnd(nowConstraint, clockConstraint, init, conjunction);

		converted = true;
		return formula;

	}

	public CLTLocFormula getTheta(MITLIFormula f) {

		Preconditions.checkArgument(converted, "Run the converter before getting the expression");
		Preconditions.checkArgument(this.clockcontraintFormulaMap.containsKey(f),
				"The formula must be a subformula of the original formula");
		return this.clockcontraintFormulaMap.get(f);
	}

	public BiMap<Integer, MITLIFormula> getVocabulary() {
		return this.visitor.formulaIdMap.inverse();
	}

	public void printFancy(PrintStream fancyprint) {
		generatedFormulaMap.entrySet().forEach(e -> {

			fancyprint.println("---");
			fancyprint.println("Subformula: " + this.visitor.formulaIdMap.get(e.getKey()) + "\t" + e.getKey());
			fancyprint.println("---Clock constraint");
			fancyprint.println(e.getValue().accept(new CLTLoc2StringVisitor()).getKey());
			fancyprint.println("---Subformula");
			fancyprint.println(
					clockcontraintFormulaMap.get(e.getKey()).accept(new CLTLoc2StringVisitor()).getKey() + "\n");

		}

		);
	}

}
