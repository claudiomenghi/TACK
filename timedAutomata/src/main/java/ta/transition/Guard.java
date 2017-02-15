package ta.transition;

import java.util.Collections;
import java.util.Set;

import com.google.common.base.Preconditions;

public class Guard {

	private final Set<EQCondition> conditions;

	public Guard(Set<EQCondition> conditions) {
		Preconditions.checkNotNull(conditions, "The set of conditions cannot be null");
		this.conditions = conditions;
	}

	public Set<EQCondition> getConditions() {
		return Collections.unmodifiableSet(conditions);
	}
}
