package ta.transition;

import java.util.Collections;
import java.util.Set;

public class Assign {
	private final Set<EQAssignement> assigments;

	public Assign(Set<EQAssignement> assigments) {
		this.assigments = assigments;
	}

	public Set<EQAssignement> getConditions() {
		return Collections.unmodifiableSet(assigments);
	}
}
