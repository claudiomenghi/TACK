package parserHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import java.util.List;



import delegateTranslator.*;
import formulae.*;
import formulae.MITLI.MITLIEventually_ZerotoB;


public abstract class TLParserHandler {
	
	

	private Set<Formula> formulae;
	
	private ArrayList<Formula> formulaeOf;

	private CLTLTranslator translator;
	
	private int historyLength;
	
	private int maxbound;
	
	public boolean dict, verbose;
	
	private FileOutputStream f0 = null;
	private PrintStream prn = null;
	
	TLParserHandler(){
		formulae = new LinkedHashSet<Formula>();
		formulaeOf = new ArrayList<Formula>();
		dict = verbose = true;
	}
	
	
	public void setCLTLTranslator(CLTLTranslatorEnum e_transl){
		switch(e_transl){
			case AE2ZOT : this.translator = new ae2zotTranslator();
			case NUZOT: ;
			default: this.translator = new ae2zotTranslator();
		}
	}
	
	
	public void setHistoryLength(int historyLength){
		this.historyLength = historyLength;
	}
	
	
	private int getHistoryLength(){
		return this.historyLength;
	}
	
	
	
	public Formula addFormula(Formula f){
		
		// simplify f before inserting it
		Formula simple_f = f.simplify();
		
		// then insert the simplified formula   
		return addToformulae(simple_f);
	}
	

	private Formula addToformulae(Formula f){
		
		// if formula f is in the set 
		if (formulae.contains(f)){
		// get it from the set and return it to the caller
			for (Formula fmla: formulae){
				if (fmla.equals(f))					
					return fmla;		
			}
		}
		
		List<Formula> subf = f.subformulae();
		List<Formula> newsubf = new ArrayList<Formula>();
		
		Formula newf;
		
		// if formula f has subformulae
		if (subf != null){ 
			for (Formula fmla: subf){
				newsubf.add(addToformulae(fmla));	
			}
			
			// update the structure of f
			newf = f.update(newsubf);
			
			// 
			formulae.add(newf);
			// then return it		
			return newf;	
			
		}
		// otherwise it is an atom
		formulae.add(f);
		// then return it		
		return f;
	}
	
	
	public String getCLTLformulaOf(CLTLTranslatorEnum e_transl){
		String result = new String();
			
		
		
		
		for(Formula subf: formulaeOf){
			switch(e_transl){
				case AE2ZOT : {	
						String s = subf.translate(translator);
						if (s.length() > 0)
							result = result + "(defconstant f" + subf.idFormula() + " " + s + ")\n";			
				};
				case NUZOT: ;	
			}
		}
		
		
		return result;
	}
	
	public abstract String getHeader(CLTLTranslatorEnum e_transl);
	
	
	
	
	public String getEpilogue(CLTLTranslatorEnum e_transl){
		String result = new String();
		
		
		switch(e_transl){
			case AE2ZOT : {
				
				String[] axioms = new String[formulaeOf.size()+1];
				int i = 0;
				for (Formula fmla : formulaeOf){
					if ((fmla.translate(translator)).length() > 0)
						axioms[i++] = "f" + fmla.idFormula(); 
				}
					
				axioms[i] = translator.and(translator.Y(translator.neg(translator.atom("O"))), translator.atom("O"), translator.X(translator.G(translator.neg(translator.atom("O")))));
				
				result = this.getCLTLformulaOf(e_transl) + "(ae2zot:zot " + getHistoryLength() + " " + translator.and(axioms) + ":logic :QF_UFLRA :gen-symbolic-val 't :over-clocks " + Formula.maxbound + ")\n";				
			};
			case NUZOT: ;		
		}
		return result;
	}
	
	

	public Iterator<Formula> iterator(){
        return formulae.iterator();           
    }
		
	public Iterator<Formula> iteratorOf(){
        return formulaeOf.iterator();           
    }
	
	
	public String translate(Formula f, CLTLTranslatorEnum e_transl){
	
		//set the main formula
		f.isTheFormula = f.idFormula();
		
		
		System.out.println("Starting visiting formula (" + f.isTheFormula + ") tree...\n");	
		
		if (dict){
			try {
				f0 = new FileOutputStream("dict.txt");
				prn = new PrintStream(f0);	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		visit(f);
		
		System.out.println("\ndone!");
		
		if (dict && f0 != null){
			System.out.println("Dictionary file written.");
		}
		

		return getHeader(e_transl) + getEpilogue(e_transl);
	}
	
	
	private void visit(Formula f){
	
		if (!formulaeOf.contains(f)){
			
			formulaeOf.add(f);
			
			if (verbose)
				System.out.println(f.idFormula() + " -> " + f.strFormula());

			if (dict && f0 != null){					
				prn.println(f.idFormula() + " -> " + f.strFormula());	
			}
			
			
			if (f instanceof Temporized){
				Temporized f1 = ((Temporized)f);
				
				if (f1.upperbound() > Formula.maxbound) 
					Formula.maxbound = f1.upperbound();
			}
			
		
			List<Formula> subf = f.subformulae();
		
			if (subf != null)
				for (Formula fmla : subf)
					visit(fmla);
		}
	}
	
/*	public static void main(String args[]){
		
		ParserQTL p = new ParserQTL();
		
		switch(Integer.valueOf(args[0])){
			case 0: p.setCLTLTranslator(CLTLTranslatorEnum.AE2ZOT);
			default: ;
		}
		
		QTLFormula f, a1, f1, a3;
		
		a1 = new QTLAtom(p.getProgNum(), new String("P1"));
		p.addFormula(a1);
		f1 = new QTLNegation(p.getProgNum(),a1);
		p.addFormula(f1);
		/*a3 = new QTLAtom(p.getProgNum(),"P3");
		p.addFormula(a3);*/
		
//		f = new QTLConjunction(p.getProgNum(),a1,f1);
//		p.addFormula(f);
		
		//p.addFormula(new QTLConjunction(p.getProgNum(),f,new QTLNegation(p.getProgNum(), a2)));
		
//		System.out.println(p.getCLTLformula());
//	}*/
	
}
