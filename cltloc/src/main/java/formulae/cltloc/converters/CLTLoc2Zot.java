package formulae.cltloc.converters;

import java.util.Set;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocSignal;
import formulae.cltloc.visitor.CLTLoc2ZotVisitor;
import formulae.cltloc.visitor.GetClocksVisitor;
import formulae.cltloc.visitor.GetSignalVisitor;

public class CLTLoc2Zot implements Function<CLTLocFormula, String> {

	private final int bound;

	public CLTLoc2Zot(int bound) {
		Preconditions.checkArgument(bound > 0, "The bound must be grather than zero");
		this.bound = bound;
	}

	public String apply(CLTLocFormula formula) {
		final StringBuilder builder = new StringBuilder();
		builder.append("(asdf:operate 'asdf:load-op 'ae2zot)");
		builder.append("(use-package :trio-utils)\n");

		Set<CLTLocClock> clocks = formula.accept(new GetClocksVisitor());
		clocks.forEach(clock -> builder.append("(define-tvar " + clock.toString() + " *real*)\n"));

		Set<CLTLocSignal> variables = formula.accept(new GetSignalVisitor());
		variables.forEach(variable -> builder.append("(define-tvar " + variable.toString() + " *real*)\n"));

		final StringBuilder footerBuilder = new StringBuilder();
		footerBuilder.append(":signals '("+StringUtils.join(variables, ' ')+")");
		

		
		builder.append("(ae2zot:zot " + bound + " (&&" + formula.accept(new CLTLoc2ZotVisitor()) + ")\n\n"
				+ ":smt-lib :smt2 \n" + ":logic :QF_UFRDL \n" + ":over-clocks 3 \n" +
				footerBuilder.toString()+" \n"+
				")\n");

		builder.append("\n");
		

		return builder.toString();
	}
}
