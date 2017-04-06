package ta;

public class StateAP extends AP{

	private final String state;
	private final String automata;
	public StateAP( String automata, String state) {
		super(automata+"_"+state);
		this.state=state;
		this.automata=automata;
	}
	public String getState() {
		return state;
	}
	public String getAutomata() {
		return automata;
	}

		
}
