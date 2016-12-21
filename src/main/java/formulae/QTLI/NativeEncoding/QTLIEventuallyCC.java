package formulae.QTLI.NativeEncoding;

import java.util.ArrayList;
import java.util.List;

import delegateTranslator.CLTLTranslator;
import formulae.Formula;
import formulae.Temporized;
import formulae.QTLI.QTLIFormula;

public class QTLIEventuallyCC extends QTLIFormula implements Temporized {

	private QTLIFormula subformula;
	private final int b;  
	
	public QTLIEventuallyCC(QTLIFormula subformula, int b){
		super(new String("(Fcc " + String.valueOf(b) + " " + subformula.strFormula() + ")"));
		this.subformula = subformula;
		this.b = b;
		
		subformula.maxIntComparedto(b);
		maxIntComparedto(b);
	}
	
	
	@Override
	public String translate(CLTLTranslator t) {
		
		return null;
	}
	
	
	
	
	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		r.add(subformula);
		
		return r;
	}
	
	
	public int upperbound(){
		return b; 
	}
	
	public int lowerbound(){
		return 0; 
	}
	
	
	@Override
	public QTLIFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		
		int m = subformula.maxIntComparedto();
		subformula = (QTLIFormula)l.get(0);	
		subformula.maxIntComparedto(m);
		return this;
	}
	
	
	@Override
	public Formula simplify() {
		return new QTLIEventuallyCC((QTLIFormula)subformula.simplify(), b);
	}

	
}
