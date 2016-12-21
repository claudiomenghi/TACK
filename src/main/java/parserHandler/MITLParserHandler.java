package parserHandler;

import java.util.Iterator;

import delegateTranslator.*;
import formulae.*;
import formulae.MITL.MITLEventually_AtoB;
import formulae.MITL.MITLFormula;

public class MITLParserHandler extends TLParserHandler {

	@Override
	public String getHeader(CLTLTranslatorEnum t) {
	
		String result = new String();
		switch(t){
			case AE2ZOT : {
				result = result + new String("(asdf:operate 'asdf:load-op 'ae2zot) (use-package :trio-utils)\n");
				
				Iterator<Formula> f = super.iteratorOf();
				
				while (f.hasNext()){
					MITLFormula mitlf = (MITLFormula) f.next();
					result = result + new String("(define-tvar " + mitlf.zH() + " *real*)\n(define-tvar " + mitlf.zL() + " *real*)\n");
					if (mitlf instanceof MITLEventually_AtoB){
						MITLEventually_AtoB fm = (MITLEventually_AtoB) mitlf;
						int b = fm.upperbound();
						int a = fm.lowerbound();
						
						int d = (int)Math.floor(b/(b-a)+1) + 1;  
					
						for (int i=0; i<d; i++)
							result = result + new String("(define-tvar " + fm.x(i) + " *real*)\n(define-tvar " + fm.y(i) + " *real*)\n");;
					}
				}				
			};
			case NUZOT: ;		
		}
		return result;
	}

}
