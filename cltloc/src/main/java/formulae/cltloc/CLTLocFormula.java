package formulae.cltloc;

import java.util.Arrays;

import com.google.common.base.Preconditions;

import formulae.Formula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.visitor.CLTLocVisitor;

public abstract class CLTLocFormula extends Formula {

	public static final CLTLocFormula TRUE = new CLTLocAP("True");
	public static final CLTLocFormula FALSE = new CLTLocAP("False");

	public CLTLocFormula() {
		super();

	}

	public abstract <T> T accept(CLTLocVisitor<T> t);

	
	public static CLTLocFormula getAnd(CLTLocFormula f1, CLTLocFormula f2) {
		Preconditions.checkNotNull(f1, "The first subformula cannot be null");
		Preconditions.checkNotNull(f2, "The second subformula cannot be null");

		if (f1.equals(CLTLocFormula.TRUE)) {
			return f2;
		}
		if (f2.equals(CLTLocFormula.TRUE)) {
			return f1;
		}
		if (f1.equals(CLTLocFormula.FALSE)) {
			return CLTLocFormula.FALSE;
		}
		if (f2.equals(CLTLocFormula.FALSE)) {
			return CLTLocFormula.FALSE;
		}
		return CLTLocConjunction.getCLTLocConjunction(f1, f2);
	}
	
	public static CLTLocFormula getOr(CLTLocFormula f1, CLTLocFormula f2) {
		Preconditions.checkNotNull(f1, "The first subformula cannot be null");
		Preconditions.checkNotNull(f2, "The second subformula cannot be null");

		if (f1.equals(CLTLocFormula.FALSE)) {
			return f2;
		}
		if (f2.equals(CLTLocFormula.FALSE)) {
			return f1;
		}
		if (f1.equals(CLTLocFormula.TRUE)) {
			return CLTLocFormula.TRUE;
		}
		if (f2.equals(CLTLocFormula.TRUE)) {
			return CLTLocFormula.TRUE;
		}
		return CLTLocDisjunction.getCLTLocDisjunction(f1, f2);
	}

	public static CLTLocFormula getIff(CLTLocFormula f1, CLTLocFormula f2) {
		Preconditions.checkNotNull(f1, "The first subformula cannot be null");
		Preconditions.checkNotNull(f2, "The second subformula cannot be null");

		if (f1.equals(CLTLocFormula.TRUE)) {
			return f2;
		}
		if (f2.equals(CLTLocFormula.TRUE)) {
			return f1;
		}
		return new CLTLocIff(f1, f2);
	}

	public static CLTLocFormula getAnd(CLTLocFormula subformula1, CLTLocFormula... formulae) {
		
	
		Preconditions.checkNotNull(subformula1, "No CLTLoc formula specified");
		CLTLocFormula tmpsubformula1 = subformula1;
		if(formulae==null){
			return subformula1;
		}
		if(formulae.length==0){
			return subformula1;
		}
		CLTLocFormula tmpsubformula2;
				
		if (formulae.length == 1) {
			tmpsubformula2 = formulae[0];
		} else {
			tmpsubformula2 =getAnd(formulae[0], Arrays.copyOfRange(formulae, 1, formulae.length));		
		}
		return getAnd(tmpsubformula1, tmpsubformula2);
	}

	
	public static CLTLocFormula getOr(CLTLocFormula subformula1, CLTLocFormula... formulae) {
		Preconditions.checkNotNull(subformula1, "No CLTLoc formula specified");
		CLTLocFormula tmpsubformula1 = subformula1;
		if(formulae==null){
			return subformula1;
		}
		if(formulae.length==0){
			return subformula1;
		}
		CLTLocFormula tmpsubformula2;
		if (formulae.length > 1) {
			tmpsubformula2 = getOr(formulae[0], Arrays.copyOfRange(formulae, 1, formulae.length));
		} else {
			tmpsubformula2 = formulae[0];
		}
		return getOr(tmpsubformula1, tmpsubformula2);
	}
	
	public static CLTLocFormula Y(CLTLocFormula subformula) {
		Preconditions.checkNotNull(subformula, "No CLTLoc formula specified");
		
		return new CLTLocYesterday(subformula);
	}
	public static CLTLocFormula getNeg(CLTLocFormula f1) {
		
		if (f1 instanceof CLTLocNegation) {
			return ((CLTLocNegation) f1).getChild();
		} else {
			return new CLTLocNegation(f1);
		}
	}

}
