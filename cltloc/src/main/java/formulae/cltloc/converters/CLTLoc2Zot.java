package formulae.cltloc.converters;

import java.util.Set;
import java.util.function.Function;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLoc2ZotVisitor;
import formulae.cltloc.visitor.GetClocksVisitor;

public class CLTLoc2Zot implements Function<CLTLocFormula, String> {

	
	public  String apply(CLTLocFormula formula){
		StringBuilder builder=new StringBuilder();
		builder.append("(asdf:operate 'asdf:load-op 'ae2zot) (use-package :trio-utils)\n");
		
		Set<CLTLocFormula> clocks=formula.accept(new GetClocksVisitor());
		clocks.forEach(clock -> builder.append("(define-tvar " + clock.strFormula() + " *real*)\n"));


		Set<CLTLocFormula> aps=formula.accept(new GetClocksVisitor());
		aps.forEach(ap -> builder.append("(define-tvar " + ap.strFormula() + " *real*)\n"));
		
		builder.append("(defvar trio-spec (&&"+formula.accept(new CLTLoc2ZotVisitor())+"))\n");
		
		builder.append("\n");
		builder.append("(ae2zot:zot 10 trio-spec)");
		return builder.toString();
	}
}
