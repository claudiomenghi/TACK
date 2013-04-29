package parserHandler;

import java.util.Iterator;

import delegateTranslator.*;
import formulae.*;
import formulae.MITLI.MITLIEventually;
import formulae.MITLI.MITLIEventually_AtoB;
import formulae.MITLI.MITLIEventually_AtoInf;
import formulae.MITLI.MITLIEventually_ZerotoB;
import formulae.MITLI.MITLIFormula;
import formulae.MITLI.MITLIGlobally;
import formulae.MITLI.MITLIGlobally_AtoB;
import formulae.MITLI.MITLIGlobally_ZerotoB;

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
					
					if ( (mitlf.idFormula() != mitlf.isTheFormula) && 
							( (mitlf instanceof MITLIEventually_ZerotoB) || 
							  (mitlf instanceof MITLIGlobally_ZerotoB) || 
							  (mitlf instanceof MITLIEventually_AtoInf) || 
							  //(mitlf instanceof MITLIGlobally_AtoInf) ||
							  (mitlf.maxIntComparedto() > 0)) )
						result = result + new String("(define-tvar " + mitlf.z0() + " *real*)\n(define-tvar " + mitlf.z1() + " *real*)\n");
					if ( (mitlf instanceof MITLIEventually_AtoB) && !(mitlf instanceof MITLIEventually_ZerotoB)){
						MITLIEventually_AtoB fm = (MITLIEventually_AtoB) mitlf;

						int b = fm.upperbound();
						int a = fm.lowerbound();
						
						int d = 2*(int)Math.floor(b/(b-a)+1) + 1;  
					
						for (int i=0; i<d; i++)
							result = result + new String("(define-tvar " + fm.x(i) + " *real*)\n");
					} else if ( (mitlf instanceof MITLIGlobally_AtoB) && !(mitlf instanceof MITLIGlobally_ZerotoB)){
						MITLIGlobally_AtoB fm = (MITLIGlobally_AtoB) mitlf;

						int b = fm.upperbound();
						int a = fm.lowerbound();
						
						int d = 2*(int)Math.floor(b/(b-a)+1) + 1;  
					
						for (int i=0; i<d; i++)
							result = result + new String("(define-tvar " + fm.x(i) + " *real*)\n");
					}
					//}
				}				
			};
			case NUZOT: ;		
		}
		return result;
	}

}
