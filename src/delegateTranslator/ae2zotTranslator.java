package delegateTranslator;

public class ae2zotTranslator implements CLTLTranslator {

	@Override
	public String atom(String s) {
		// TODO Auto-generated method stub
		return "(-P- " + s + ")";
	}

	
	@Override
	public String var(String s) {
		// TODO Auto-generated method stub
		return "(-V- " + s + ")";
	}
	
	
	@Override
	public String neg(String s) {
		// TODO Auto-generated method stub
		return "(!! " + s + ")";
	}

	@Override
	public String and(String... args) {
		// TODO Auto-generated method stub
		
		String str = new String();
		for (String s : args){
			str = str + " " + s;
		}
		
		return "(&&" + str + ")";
	}
	
	@Override
	public String or(String... args) {
		// TODO Auto-generated method stub
		
		String str = new String();
		for (String s : args){
			str = str + " " + s;
		}
		
		return "(||" + str + ")";
	}
	

	@Override
	public String U(String s1, String s2) {
		// TODO Auto-generated method stub
		return "(until " + s1 + " " + s2 + ")";
	}

	@Override
	public String R(String s1, String s2) {
		// TODO Auto-generated method stub
		return "(release " + s1 + " " + s2 + ")";
	}

	@Override
	public String S(String s1, String s2) {
		// TODO Auto-generated method stub
		return "(since " + s1 + " " + s2 + ")";
	}

	@Override
	public String T(String s1, String s2) {
		// TODO Auto-generated method stub
		return "(trigger " + s1 + " " + s2 + ")";
	}

	
	public String implies(String s1, String s2) {
		// TODO Auto-generated method stub
		return "(-> " + s1 + " " + s2 + ")";
	}


	public String iff(String s1, String s2) {
		// TODO Auto-generated method stub
		return "(<-> " + s1 + " " + s2 + ")";
	}
	
	
	@Override
	public String rel(String r, String[] args) {
		// TODO Auto-generated method stub
		String rel = "[" + r + "]";
		String str = "(" + rel;
		for (String s : args){
			str = str + s;
		}
		str = str + ")";
		return str;
	}



	public String rel(String r, String s1, String s2) {
		// TODO Auto-generated method stub
		return "([" + r + "] " + s1 + " " + s2 + ")";
	}




	@Override
	public String X(String s1) {
		// TODO Auto-generated method stub
		return "(next " + s1 + ")";
	}


	@Override
	public String Y(String s1) {
		// TODO Auto-generated method stub
		return "(yesterday " + s1 + ")";
	}


	@Override
	public String G(String s1) {
		// TODO Auto-generated method stub
		return "(alwf " + s1 + ")";
	}


	@Override
	public String F(String s1) {
		// TODO Auto-generated method stub
		return "(somf " + s1 + ")";
	}
	
	
}
