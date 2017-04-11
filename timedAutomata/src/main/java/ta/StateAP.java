package ta;

public class StateAP extends AP{

	private final String encodingSymbol;
	private final String state;
	private final String automata;
	public StateAP(String encodingSymbol, String automata, String state) {
		super(automata+"_"+state);
		this.encodingSymbol=encodingSymbol;
		this.state=state;
		this.automata=automata;
	}
	public String getState() {
		return state;
	}
	public String getAutomata() {
		return automata;
	}
	
	public String getEncodingSymbol(){
		return this.encodingSymbol;
	}

		
}
