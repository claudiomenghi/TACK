package ta;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import ta.declarations.Variable;

public class SystemDecl {

	/**
	 * contains the variable declaration
	 */
	private Variable<?> declarations;
	private Set<TA> timedAutomata;

	public SystemDecl() {
		timedAutomata = new HashSet<>();
	}

	public void addTA(TA ta) {
		Preconditions.checkNotNull(ta, "The timed automaton cannot be null");
		this.timedAutomata.add(ta);
	}

	public Set<TA> getTimedAutomata() {
		return this.timedAutomata;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		
		builder.append("------ TA ------");
		timedAutomata.forEach(ta -> builder.append(ta));
		
		return builder.toString();
	}
}
