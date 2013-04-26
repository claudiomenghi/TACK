package parserHandler;

import java.util.Iterator;

import delegateTranslator.*;
import formulae.*;
import formulae.MITLI.MITLIEventually_AtoB;
import formulae.MITLI.MITLIFormula;

public class MITLIParserHandler extends TLParserHandler {

	@Override
	public String getHeader(CLTLTranslatorEnum t) {
	
		String result = new String();
		switch(t){
			case AE2ZOT : {
				result = result + new String("(asdf:operate 'asdf:load-op 'ae2zot) (use-package :trio-utils)\n");
				
				Iterator<Formula> f = super.iteratorOf();
				
				while (f.hasNext()){
					MITLIFormula mitlf = (MITLIFormula) f.next();
					
					if (mitlf.idFormula() != mitlf.isTheFormula){
						result = result + new String("(define-tvar " + mitlf.z0() + " *real*)\n(define-tvar " + mitlf.z1() + " *real*)\n");
						if (mitlf instanceof MITLIEventually_AtoB){
							MITLIEventually_AtoB fm = (MITLIEventually_AtoB) mitlf;
							int b = fm.upperbound();
							int a = fm.lowerbound();
							
							int d = 2*(int)Math.floor(b/(b-a)+1) + 1;  
						
							for (int i=0; i<d; i++)
								result = result + new String("(define-tvar " + fm.x(i) + " *real*)\n");
						}
					}
				}				
			};
			case NUZOT: ;		
		}
		return result;
	}

}
