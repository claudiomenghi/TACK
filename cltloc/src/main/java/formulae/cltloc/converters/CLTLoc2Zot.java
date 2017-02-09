package formulae.cltloc.converters;

import java.util.function.Function;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTL2ZotHeaderVisitor;
import formulae.cltloc.visitor.CLTLoc2ZotVisitor;

public class CLTLoc2Zot implements Function<CLTLocFormula, String> {

	public  String apply(CLTLocFormula formula){
		StringBuilder builder=new StringBuilder();
		builder.append("(asdf:operate 'asdf:load-op 'ae2zot) (use-package :trio-utils)\n");
		builder.append(formula.accept(new CLTL2ZotHeaderVisitor()));
		builder.append("(defvar trio-spec ("+formula.accept(new CLTLoc2ZotVisitor())+"))\n");
		
		builder.append("\n");
		builder.append("(e2zot:zot 10 trio-spec)");
		return builder.toString();
	}
}
