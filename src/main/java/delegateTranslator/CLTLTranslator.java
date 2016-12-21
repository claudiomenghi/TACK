package delegateTranslator;


public interface CLTLTranslator {

	
	//Boolean formulae translators
	public String atom(String s);
	
	public String var(String s);
	
	public String neg(String s);
	
	public String and(String... args);
	
	public String or(String... args);
	
	//Derived boolean formulae translators
	public String implies(String s1, String s2);
	
	public String iff(String s1, String s2);
	
	
	//Temporal formulae translators
	public String U(String s1, String s2);
	
	public String R(String s1, String s2);
	
	public String S(String s1, String s2);
	
	public String T(String s1, String s2);
	
	public String X(String s1);
	
	public String Y(String s1);
	
	
	//Derived temporal formulae translators
	public String G(String s1);
	
	public String F(String s1);
	
	
	//Arithmetic relations
	public String rel(String r, String[] args);
	
	public String rel(String r, String s1, String s2);
	
}
