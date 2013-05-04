package formulae.MITLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class MITLIDisjunction extends MITLIFormula {
	
		
	private List<MITLIFormula> subformulae;
	
	public MITLIDisjunction(MITLIFormula... args){
			
		super(new String("(OR " + toStringForm(args) + ")"));
		this.subformulae = Arrays.asList(args);		
	}
		
		
	private static String toStringForm(MITLIFormula... args){
		String result = new String("");
		
		for(MITLIFormula f: args)
			result = result + " " + f.strFormula();
		
		return result;
	}
	

	@Override
	public String translate(CLTLTranslator t) {
		// TODO Auto-generated method stub
		
		String[] or_interval = new String[subformulae.size()];
		
		int i = 0;
		for(MITLIFormula f: subformulae){
			or_interval[i] =  f.interval(t);
			i++;
		}
		
		String f1 = t.iff(interval(t), t.or(or_interval));
		
		return t.and(super.clocksEventsConstraints(t), t.G(f1));
	}



	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>(subformulae);
	
		return r;
	}



	@Override
	public MITLIFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		//TODO: method can be simplified
		
		
		for(MITLIFormula f: subformulae){	
			
			int p = l.indexOf(f);			
			
			//if subformulae contains a subformula in list l and the the two subformulae are different (different instances)
			if (l.contains(f) && (l.get(p) != f)){
				
				//get the index of f in subformulae
				int q = subformulae.indexOf(f);
				
				//replace f with l
				subformulae.set(q, (MITLIFormula)l.get(p)); 
				l.indexOf(f);
			}
		}
				
		return this;
		
	}



	@Override
	public Formula simplify() {		
		
		MITLIFormula[] formulae = new MITLIFormula[subformulae.size()];
		
		int i = 0;
		for(MITLIFormula f: subformulae){
			formulae[i] = (MITLIFormula) f.simplify();
			i++;
		}
		
		return new MITLIDisjunction(formulae);
	}

}
