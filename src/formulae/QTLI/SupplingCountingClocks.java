package formulae.QTLI;

import delegateTranslator.CLTLTranslator;

public interface SupplingCountingClocks {

	//return the string representing z^i 
	public String z(int i);
	
	//returns the number of counting clocks needed by the formula implementing the interface
	public int getCountingClocks();
	
	
	//returns the CLTL formula constraining clocks
	//public String countingClocksConstraints(CLTLTranslator t);
	
	//returns the number of counting clocks needed by the formula implementing the interface
	public void setCountingClocks(int nCountingClocks);
}