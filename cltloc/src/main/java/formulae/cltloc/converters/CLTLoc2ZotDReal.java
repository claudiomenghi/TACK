package formulae.cltloc.converters;

import java.util.Set;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Signal;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.visitor.CLTLoc2ZotVisitor;
import formulae.cltloc.visitor.GetClocksVisitor;
import formulae.cltloc.visitor.GetSignalVisitor;
import formulae.cltloc.visitor.GetVariablesVisitor;
import formulae.cltloc.visitor.ZotPlugin;

public class CLTLoc2ZotDReal implements Function<CLTLocFormula, String> {

	private final int bound;

	public CLTLoc2ZotDReal(int bound) {
		Preconditions.checkArgument(bound > 0, "The bound must be grather than zero");
		this.bound = bound;
	}

	public String apply(CLTLocFormula formula) {
		final StringBuilder builder = new StringBuilder();
		builder.append("(asdf:operate 'asdf:load-op 'ae2zotdreal)");
		builder.append("(use-package :trio-utils)\n");

		Set<CLTLocClock> clocks = formula.accept(new GetClocksVisitor());
		clocks.forEach(clock -> builder.append("(define-tvar " + clock.toString() + " *real*)\n"));

		Set<Signal> signals = formula.accept(new GetSignalVisitor());
		signals.forEach(signal -> builder.append("(define-tvar " + signal.toString() + " *real*)\n"));

		Set<Variable> variables = formula.accept(new GetVariablesVisitor());
		variables.forEach(variable -> builder.append("(define-tvar " + variable.toString() + " *real*)\n"));

		
		final StringBuilder footerBuilder = new StringBuilder();
		footerBuilder.append(":signals '(" + StringUtils.join(signals, ' ') + ")");
		
		footerBuilder.append(":discrete-counters '(" + StringUtils.join(variables, ' ') + ")");

		
		builder.append("(ae2zotdreal:zot " + bound + " (&&" + formula.accept(new CLTLoc2ZotVisitor(ZotPlugin.AE2SBVZOTB1)) + ")\n\n"
				+ ":smt-lib :smt2 \n" + ":logic :QF_UFRDL \n" + ":over-clocks 3 \n" + footerBuilder.toString() + " \n"
				+ ":parametric-regions t \n" + ":gen-symbolic-val nil\n" + ")\n");

		builder.append("\n");
		
		

		return builder.toString();
	}
}
