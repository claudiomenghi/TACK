package parserHandler;

import java.util.Iterator;

import delegateTranslator.CLTLTranslatorEnum;
import formulae.Formula;
import formulae.QTLI.QTLIEventually;
import formulae.QTLI.QTLIFormula;
import formulae.QTLI.QTLIGlobally;

public class QTLIParserHandler extends TLParserHandler {

	@Override
	public String getHeader(CLTLTranslatorEnum e_transl) {
	
		String result = new String();
		switch(e_transl){
			case AE2ZOT : {
				result = result + new String("(asdf:operate 'asdf:load-op 'ae2zot) (use-package :trio-utils)\n");
				
				Iterator<Formula> f = super.iteratorOf();
				
				while (f.hasNext()){
					QTLIFormula qtlf = (QTLIFormula) f.next();
					if ( ( (qtlf instanceof QTLIEventually) || 
						   (qtlf instanceof QTLIGlobally) || 						   
						   ( (qtlf.idFormula() != qtlf.isTheFormula) && 
							 (qtlf.maxIntComparedto() > 0) ) ) )
						result = result + new String("(define-tvar " + qtlf.z0() + " *real*)\n(define-tvar " + qtlf.z1() + " *real*)\n");
					if (qtlf.getCountingClocks() > 0){
						
						String s = new String();
						for (int i = 0; i < qtlf.getCountingClocks(); i++)
							s = s + new String("(define-tvar " + qtlf.z(i) + " *real*)\n");
						
						result = result + s;
					}
						 
				}				
			};
			case NUZOT: ;		
		}
		return result;
	}

}
