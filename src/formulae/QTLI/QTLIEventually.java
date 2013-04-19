package formulae.QTLI;

import java.util.ArrayList;
import java.util.List;
import delegateTranslator.CLTLTranslator;
import formulae.Formula;
import formulae.Temporized;

public class QTLIEventually extends QTLIFormula implements Temporized{

	private QTLIFormula subformula;
	private final int b;  
	
	public QTLIEventually(QTLIFormula subformula, int b){
		super(new String("(F " + String.valueOf(b) + " " + subformula.strFormula() + ")"));
		this.subformula = subformula;
		this.b = b;
	}
	
	
	@Override
	public String translate(CLTLTranslator t) {
		
		// Some alias...
		QTLIFormula subf = subformula;
	
		String orig = t.atom("O");
				
		String f1;
		f1 = t.and(interval(t), t.Y(interval(t)) );
	
		String f2 = t.iff(
							high(t),
							t.and(
									subf.befDnowU(t),
									t.or(
											orig,
											t.Y(
													t.S(
															t.neg(subf.befDnowU(t)), 
															t.and(
																	orig,
																	t.neg(subf.point(t)),
																	t.neg(subf.interval(t))														
																)
														)
											),
											t.or(t.rel(">", subf.z0(t), String.valueOf(b)), t.rel(">", subf.z1(t), String.valueOf(b)))
							)
					)
								
		);
		
		String f4 = null;




		String f5 = null;
		
		
		return t.and(super.clocksEventsConstraints(t), t.G(t.and(f1,f2,f4,f5)));
	}
	



	@Override
	public List<Formula> subformulae() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		r.add(subformula);
		
		return r;
	}
	
	
	public int upperbound(){
		return b; 
	}
	
	public int lowerbound(){
		return 0; 
	}


	@Override
	public QTLIFormula update(List<Formula> l) {
		// if the list of subformulae are logically equivalent to the subformulae then we can safely replace them
		if (l.get(0).equals(subformula)){
			subformula = (QTLIFormula)l.get(0);					
			return this;
		}
		//else rise an error. TODO: implement WrongUpdateException
		else
			return null;
	}


	@Override
	public Formula simplify() {
		return new QTLIEventually((QTLIFormula)subformula.simplify(), b);
	}
	
}

