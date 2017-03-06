package ta.transition;

import java.util.Collections;
import java.util.Set;

import ta.transition.assignments.Assignment;

public class Assign {
	private final Set<Assignment> assigments;

	public Assign(Set<Assignment> assigments) {
		this.assigments = assigments;
	}

	public Set<Assignment> getConditions() {
		return Collections.unmodifiableSet(assigments);
	}
}
