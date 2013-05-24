package formulae.QTLI.NativeEncoding;

import formulae.Bounds;
import formulae.QTLI.QTLIEventually;
import formulae.QTLI.QTLIFormula;

public abstract class QTLIFormulaNE extends QTLIFormula {

	public QTLIFormulaNE(String formula_p){
		super(formula_p);
	}

	
	// Eventually: F_<0,b>
	public static QTLIFormula F(QTLIFormula f, Bounds aB, int b, Bounds bB){
		if (aB==Bounds.OPEN && bB==Bounds.OPEN)					//F_(0,b)
			return new QTLIEventually(f, b);
		
		else if (aB==Bounds.CLOSED && bB==Bounds.OPEN)			//F_[0,b)
			return new QTLIEventuallyCO(f, b);
		
		else if (aB==Bounds.OPEN && bB==Bounds.CLOSED)			//F_(0,b]
			return new QTLIEventuallyOC(f, b);
		
		else return new QTLIEventuallyCC(f, b);					//F_[0,b]
			
	}
	
}
