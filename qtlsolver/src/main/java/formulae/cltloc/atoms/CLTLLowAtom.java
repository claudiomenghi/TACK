package formulae.cltloc.atoms;

public class CLTLLowAtom extends CLTLocAtom {

	public CLTLLowAtom(String atom) {
		super("L_" + atom);
	}

	public CLTLLowAtom(int atom) {
		super("L_" +atom);
		
	}
}
