package formulae.cltloc.converters;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.BoundedVariable;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.Signal;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.visitor.CLTLoc2ZotVisitor;
import formulae.cltloc.visitor.GetBoundedVariablesVisitor;
import formulae.cltloc.visitor.GetClocksVisitor;
import formulae.cltloc.visitor.GetSignalVisitor;
import formulae.cltloc.visitor.GetVariablesVisitor;
import formulae.cltloc.visitor.ZotPlugin;

public class CLTLoc2zot implements Function<CLTLocFormula, String> {

	private final int bound;
	private final int maxConstant;

	private final ZotPlugin plugin;

	public CLTLoc2zot(int bound, ZotPlugin pluginName) {
		Preconditions.checkArgument(bound > 0, "The bound must be grather than zero");
		this.bound = bound;
		this.maxConstant = bound;
		this.plugin = pluginName;
	}

	public CLTLoc2zot(int bound, int maxConstant, ZotPlugin plugin) {
		Preconditions.checkArgument(bound > 0, "The bound must be grather than zero");
		this.bound = bound;
		this.maxConstant = maxConstant;
		this.plugin = plugin;
	}

	public String apply(CLTLocFormula formula) {
		final StringBuilder builder = new StringBuilder();
		builder.append("(asdf:operate 'asdf:load-op '" + plugin + ")\n");

		builder.append("(use-package :trio-utils)\n");

		Set<CLTLocClock> clocks = formula.accept(new GetClocksVisitor());
		clocks.forEach(clock -> builder.append("(define-tvar " + clock.toString() + " *real*)\n"));

		Set<Signal> signals = formula.accept(new GetSignalVisitor());
		signals.forEach(signal -> builder.append("(define-tvar " + signal.toString() + " *real*)\n"));

		Set<Variable> variables = formula.accept(new GetVariablesVisitor());
		variables.forEach(variable -> builder.append("(define-tvar " + variable.toString() + " *int*)\n"));

		Set<BoundedVariable> boundedvariables=null;
		if (plugin.equals(ZotPlugin.AE2SBVZOT) || plugin.equals(ZotPlugin.AE2ZOT)) {
			boundedvariables = formula.accept(new GetBoundedVariablesVisitor());
			boundedvariables.forEach(variable -> {
				builder.append("(define-item " + variable.toString() + " '("
						+ StringUtils.join(variable.getValues(), ' ') + "))\n");
			});
		} else {
			Set<String> variablesString=variables.stream().map(v -> v.toString()).collect(Collectors.toSet());
			
			boundedvariables = formula.accept(new GetBoundedVariablesVisitor());
			boundedvariables.forEach(variable -> {
				if(!variablesString.contains(variable.toString())){
					builder.append("(define-tvar " + variable.toString() + " *int*)\n");
				}
			}
			);

		}

		// ae2sbvzot
		// ae2zot
		builder.append("(" + plugin + ":zot " + bound + " (&&" + formula.accept(new CLTLoc2ZotVisitor(plugin)) + ")\n\n"
				+ ":smt-lib :smt2 \n" + ":over-clocks " + maxConstant + "\n"
				+ ":logic :QF_UFLRA" + "\n" 
				+ ":gen-symbolic-val nil\n");

		if (plugin.equals(ZotPlugin.AE2SBVZOT) || plugin.equals(ZotPlugin.AE2ZOT)) {
			builder.append(":parametric-regions t\n");
			final StringBuilder footerBuilder = new StringBuilder();
			footerBuilder.append(":discrete-counters '(" + StringUtils.join(variables, ' ') + ")");
			builder.append(footerBuilder.toString() + "");
		}
		else{
			final StringBuilder footerBuilder = new StringBuilder();
			Set<String> variablesString=variables.stream().map(v -> v.toString()).collect(Collectors.toSet());
			variablesString.addAll(boundedvariables.stream().map(v -> v.toString()).collect(Collectors.toSet()));
			footerBuilder.append(":discrete-counters '(" + StringUtils.join(variablesString, ' ') + ")");
			builder.append(footerBuilder.toString() + "");
		}

		builder.append(")\n");

		return builder.toString();
	}
}
