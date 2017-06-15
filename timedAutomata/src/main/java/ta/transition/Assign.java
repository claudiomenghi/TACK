package ta.transition;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;

import ta.Clock;
import ta.Variable;
import ta.transition.assignments.ClockAssignement;
import ta.transition.assignments.VariableAssignement;

public class Assign {
	private final Set<ClockAssignement> clockassigments;
	private final Set<VariableAssignement> variableassigments;

	public Assign(Set<ClockAssignement> clockassigments, Set<VariableAssignement> variableassigments) {
		Preconditions.checkNotNull(clockassigments, "The set of clock assignement cannot be null");
		Preconditions.checkNotNull(variableassigments, "The set of variable assignement cannot be null");
		this.clockassigments = clockassigments;
		this.variableassigments = variableassigments;
	}
	
	public boolean assign(Clock x){
		return this.clockassigments.stream().map(c -> c.getClock()).collect(Collectors.toSet()).contains(x);
	}

	public boolean assignedVariable(Variable x){
		return this.variableassigments.stream().map(v-> v.getVariable()).collect(Collectors.toSet()).contains(x);
	}
	public Set<ClockAssignement> getClockassigments() {
		return clockassigments;
	}

	public Set<VariableAssignement> getVariableassigments() {
		return variableassigments;
	}

	public Set<Variable> assignedVariables(){
		return this.variableassigments.stream().map(v -> v.getVariable()).collect(Collectors.toSet());
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clockassigments == null) ? 0 : clockassigments.hashCode());
		result = prime * result + ((variableassigments == null) ? 0 : variableassigments.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assign other = (Assign) obj;
		if (clockassigments == null) {
			if (other.clockassigments != null)
				return false;
		} else if (!clockassigments.equals(other.clockassigments))
			return false;
		if (variableassigments == null) {
			if (other.variableassigments != null)
				return false;
		} else if (!variableassigments.equals(other.variableassigments))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "clockassigments=" + clockassigments + ", variableassigments=" + variableassigments + "";
	}

}
