package ta;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

public class SystemDecl {

	private Set<TA> timedAutomata;
	
	public SystemDecl(){
		timedAutomata=new HashSet<>();
	}
	
	public void addTA(TA ta){
		Preconditions.checkNotNull(ta, "The timed automaton cannot be null");
		System.out.println("Adding a timed automaton:"+ta.getName());
		this.timedAutomata.add(ta);
	}
	
	public Set<TA> getTimedAutomata(){
		return this.timedAutomata;
	}
}
