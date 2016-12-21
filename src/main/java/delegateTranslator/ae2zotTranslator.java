package delegateTranslator;

public class ae2zotTranslator implements CLTLTranslator {

	@Override
	public String atom(String s) {
		return "(-P- " + s + ")";
	}

	
	@Override
	public String var(String s) {
		return "(-V- " + s + ")";
	}
	
	
	@Override
	public String neg(String s) {
		return "(!! " + s + ")";
	}

	@Override
	public String and(String... args) {
		
		String str = new String();
		for (String s : args){
			if (s != null)
				str = str + " " + s;
		}
		
		return "(&&" + str + ")";
	}
	
	@Override
	public String or(String... args) {
		
		String str = new String();
		for (String s : args){
			if (s != null)
				str = str + " " + s;
		}
		
		return "(||" + str + ")";
	}
	

	@Override
	public String U(String s1, String s2) {
		return "(until " + s1 + " " + s2 + ")";
	}

	@Override
	public String R(String s1, String s2) {
		return "(release " + s1 + " " + s2 + ")";
	}

	@Override
	public String S(String s1, String s2) {
		return "(since " + s1 + " " + s2 + ")";
	}

	@Override
	public String T(String s1, String s2) {
		return "(trigger " + s1 + " " + s2 + ")";
	}

	@Override
	public String implies(String s1, String s2) {
		return "(-> " + s1 + " " + s2 + ")";
	}

	@Override
	public String iff(String s1, String s2) {
		return "(<-> " + s1 + " " + s2 + ")";
	}
	
	@Override
	public String rel(String r, String[] args) {
		String rel = "[" + r + "]";
		String str = "(" + rel;
		for (String s : args){
			str = str + s;
		}
		str = str + ")";
		return str;
	}

	@Override
	public String rel(String r, String s1, String s2) {
		return "([" + r + "] " + s1 + " " + s2 + ")";
	}

	@Override
	public String X(String s1) {
		return "(next " + s1 + ")";
	}

	@Override
	public String Y(String s1) {
		return "(yesterday " + s1 + ")";
	}


	@Override
	public String G(String s1) {
		return "(alwf " + s1 + ")";
	}

	@Override
	public String F(String s1) {
		return "(somf " + s1 + ")";
	}
}
