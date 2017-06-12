package ta;

public class StateAP extends AP{

	private final int encodingSymbol;
	private final String state;
	private final String automata;
	public StateAP(int encodingInteger, String automata, String state) {
		super(automata+"_"+state);
		this.encodingSymbol=encodingInteger;
		this.state=state;
		this.automata=automata;
	}
	public String getState() {
		return state;
	}
	
	public String getAutomata() {
		return automata;
	}
	
	public int getEncodingSymbol(){
		return this.encodingSymbol;
	}

		
}
