package parserHandler;

import java.util.Iterator;

import delegateTranslator.*;
import formulae.*;
import formulae.MITLI.MITLIEventually_AtoInf;
import formulae.MITLI.MITLIEventually_ZerotoB;
import formulae.MITLI.MITLIGlobally_AtoInf;
import formulae.MITLI.MITLIGlobally_ZerotoB;
import formulae.QTLI.QTLIEventually;
import formulae.QTLI.QTLIFormula;
import formulae.QTLI.QTLIGlobally;
import formulae.QTLI.QTLIHistorically;
import formulae.QTLI.QTLIPast;

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
						   (qtlf instanceof QTLIPast) || 
						   (qtlf instanceof QTLIHistorically) ||
						   ( (qtlf.idFormula() != qtlf.isTheFormula) && 
							 (qtlf.maxIntComparedto() > 0) ) ) )
						result = result + new String("(define-tvar " + qtlf.z0() + " *real*)\n(define-tvar " + qtlf.z1() + " *real*)\n");	
				}				
			};
			case NUZOT: ;		
		}
		return result;
	}

}
