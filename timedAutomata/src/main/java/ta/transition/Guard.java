package ta.transition;

import java.util.Collections;
import java.util.Set;

import com.google.common.base.Preconditions;

import ta.transition.conditions.Condition;

public class Guard {

	private final Set<Condition> conditions;

	public Guard(Set<Condition> conditions) {
		Preconditions.checkNotNull(conditions, "The set of conditions cannot be null");
		this.conditions = conditions;
	}

	public Set<Condition> getConditions() {
		return Collections.unmodifiableSet(conditions);
	}
}
