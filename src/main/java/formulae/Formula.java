package formulae;


import java.util.List;

import delegateTranslator.*;


public abstract class Formula implements Comparable<Formula>{
	// progressive number assigned
	private static int absoluteCounter = 0;
	
	// maximum of the constant that clocks are compared with
	public static int maxbound = 0;
	
	public static int isTheFormula = 0;
	
	// a formula
	private final String formula; 
	
	private final int progNumber;

	
	protected static Formula True = null;
	protected static Formula False = null;	
	
	
	public Formula (String QTLformula){		
		this.progNumber = absoluteCounter++;
		this.formula = QTLformula;
	}
	

	public int idFormula(){
		return progNumber;
	}
	
	
	public String strFormula(){
		return formula;
	}
	
	
	public static Formula True(){
		return True;
	}

	
	public static Formula False(){
		return False;
	}	
	
		
	public abstract String translate(CLTLTranslator t);
		
	public abstract String clocksEventsConstraints(CLTLTranslator t);
	
	public abstract List<Formula> subformulae();

	public abstract Formula update(List<Formula> l);
	
	public abstract Formula simplify(); 
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formula == null) ? 0 : formula.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formula other = (Formula) obj;
		if (formula == null) {
			if (other.formula != null)
				return false;
		} else if (!formula.equals(other.formula))
			return false;
		return true;
	}


	@Override
	public int compareTo(Formula f) {
		if (this.equals(f))
			return 0;
		else{
			if (this.progNumber < f.progNumber)
				return -1;
			else return 1;
		}
	}	
}
