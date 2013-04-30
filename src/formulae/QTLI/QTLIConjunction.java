package formulae.QTLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;

public class QTLIConjunction extends QTLIFormula {
	
		
	private List<QTLIFormula> subformulae;
	
	public QTLIConjunction(QTLIFormula... args){
			
		super(new String("(AND " + toStringForm(args) + ")"));
		this.subformulae = Arrays.asList(args);		
	}
		
		
	private static String toStringForm(QTLIFormula... args){
		String result = new String("");
		
		for(QTLIFormula f: args)
			result = result + " " + f.strFormula();
		
		return result;
	}
	

	@Override
	public String translate(CLTLTranslator t) {
		// TODO Auto-generated method stub
		
		String[] and_point = new String[subformulae.size()];
		String[] and_interval = new String[subformulae.size()];
		
		int i = 0;
		for(QTLIFormula f: subformulae){
			and_point[i] = f.point(t); 
			and_interval[i] =  f.interval(t);
			i++;
		}
		
		String f1 = t.and(
							t.iff(point(t), t.and(and_point)),
							t.iff(interval(t), t.and(and_interval))
					);
		
		return t.and(super.clocksEventsConstraints(t), t.G(f1));
	}



	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>(subformulae);
	
		return r;
	}



	@Override
	public QTLIFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		
		for(QTLIFormula f: subformulae){	
			
			int p = l.indexOf(f);			
			
			//if subformulae contains a subformula in list l and the the two subformulae are different (different instances)
			if (l.contains(f) && (l.get(p) != f)){
				
				//get the index of f in subformulae
				int q = subformulae.indexOf(f);
				
				//replace f with l
				subformulae.set(q, (QTLIFormula)l.get(p)); 
				l.indexOf(f);
			}
		}
				
		return this;
		
	}



	@Override
	public Formula simplify() {		
		
		QTLIFormula[] formulae = new QTLIFormula[subformulae.size()];
		
		int i = 0;
		for(QTLIFormula f: subformulae){
			formulae[i] = (QTLIFormula) f.simplify();
			i++;
		}
		
		return new QTLIConjunction(formulae);
	}

}
