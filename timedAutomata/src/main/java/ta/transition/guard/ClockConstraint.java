package ta.transition.guard;

import java.util.Set;

import ta.Clock;
import ta.visitors.TAVisitor;

public interface ClockConstraint {

	/**
	 * returns the set of the clocks involved in the clock constraint
	 * 
	 * @return the set of the clocks involved in the clock constraint
	 */
	public Set<Clock> getClocks();
	
	public <R> R accept(TAVisitor<R> visitor);
}
