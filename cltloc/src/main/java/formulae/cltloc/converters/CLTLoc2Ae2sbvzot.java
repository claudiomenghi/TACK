package formulae.cltloc.converters;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

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

public class CLTLoc2Ae2sbvzot implements Function<CLTLocFormula, String> {

	private final int bound;

	public CLTLoc2Ae2sbvzot(int bound) {
		Preconditions.checkArgument(bound > 0, "The bound must be grather than zero");
		this.bound = bound;
	}

	public String apply(CLTLocFormula formula) {
		final StringBuilder builder = new StringBuilder();
		builder.append("(asdf:operate 'asdf:load-op 'ae2sbvzot)\n");
		
		builder.append("(use-package :trio-utils)\n");

		Set<CLTLocClock> clocks = formula.accept(new GetClocksVisitor());
		clocks.forEach(clock -> builder.append("(define-tvar " + clock.toString() + " *real*)\n"));

		Set<Signal> signals = formula.accept(new GetSignalVisitor());
		signals.forEach(signal -> builder.append("(define-tvar " + signal.toString() + " *real*)\n"));

		Set<Variable> variables = formula.accept(new GetVariablesVisitor());
		variables.forEach(variable -> builder.append("(define-tvar " + variable.toString() + " *real*)\n"));

		
		
		final StringBuilder footerBuilder = new StringBuilder();
		//footerBuilder.append(":signals '(" + StringUtils.join(signals, ' ') + ")\n");
		
		footerBuilder.append(":discrete-counters '(" + StringUtils.join(variables, ' ') + ")");

		Set<String> clockNames=new HashSet<>();
		clockNames=clocks.stream()
				.filter(c ->  c.getClockName().contains("_")).map(c ->{
			return c.getClockName().substring(0, c.getClockName().lastIndexOf("_")+1);
		}).collect(Collectors.toSet());
		
		
		Set<String> pairedClocks=new HashSet<>();
		pairedClocks=clockNames.stream().map(name -> "("+name+"0 "+name+"1)").collect(Collectors.toSet());
		
		builder.append("(ae2sbvzot:zot " + bound + " (&&" + formula.accept(new CLTLoc2ZotVisitor()) + ")\n\n"
				+ ":smt-lib :smt2 \n" 
				+ ":logic :QF_UFRDL \n" 
				+ ":over-clocks 3 \n"
				+ ":gen-symbolic-val nil\n"
				+":parametric-regions t\n"
				+ ":paired-clocks '("+StringUtils.join(pairedClocks, ' ') +")\n"
				+ footerBuilder.toString()
				 + ")\n");

		builder.append("\n");
		
		

		return builder.toString();
	}
}
