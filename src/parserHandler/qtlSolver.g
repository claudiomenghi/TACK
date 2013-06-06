grammar qtlSolver;

@header {
package parserHandler;

import java.util.HashMap;
import delegateTranslator.*;
import formulae.*;
import formulae.QTL.*;
import formulae.QTLI.*;
import formulae.QTLI.Counting.*;
import formulae.MITL.*;
import formulae.MITLI.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Collections;
}

@lexer::header { package parserHandler; }

@members {
/** Map variable name to Integer object holding value */
HashMap<String, Formula> memory = new HashMap<String,Formula>();

TLParserHandler p;
String tlogic;
}




tlparser:	l=logic NEWLINE
			{ 
				tlogic = $l.s;
				if (tlogic.equals("qtl"))
					p = new QTLParserHandler();
				else if (tlogic.equals("qtl-i"))
					p = new QTLIParserHandler();
				else if (tlogic.equals("mitl"))
					p = new MITLParserHandler();
				else if (tlogic.equals("mitl-i"))
					p = new MITLIParserHandler();				 
		 	}
		 	':bound' INT NEWLINE
			{
				p.setHistoryLength(Integer.valueOf($INT.text));
				System.out.println("Starting parsing formulae...");
			}
			declaration*
			':formula' fmla
			{				
			
					
				p.setCLTLTranslator(CLTLTranslatorEnum.AE2ZOT);
				
				
				FileOutputStream f0 = null;
				
				try {
					f0 = new FileOutputStream("output.cltl");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				if (f0 != null){
					PrintStream prn = new PrintStream(f0);		
					prn.println(p.translate($fmla.r, CLTLTranslatorEnum.AE2ZOT));
				}
				else
					System.out.println("Opps...some errors occurred!");					
			} NEWLINE;
	

logic returns [String s]
	: COLON LOGIC	{ $logic.s = new String($LOGIC.text); };
	
			
declaration: ':def' s=ID
			 fmla 
			 {
			 	if (memory.containsKey($ID.text))
					emitErrorMessage("warning: duplicate name formula! " + $ID.text + " was already defined.");		
				else
			 		memory.put($s.text, $fmla.r);
			 }
			 NEWLINE
		| NEWLINE;

        
fmla returns [Formula r]
	:   LPAR in_fmla=fmla RPAR
		{
			$fmla.r = in_fmla;
		}
	|	TRUE
		{
			Formula f = null;
			if (tlogic.equals("qtl"))	
				f = new QTLTrue();
			else if (tlogic.equals("qtl-i"))
				f = new QTLITrue();
			else if (tlogic.equals("mitl"))
				f = new MITLTrue();
			else if (tlogic.equals("mitl-i"))
				f = new MITLITrue();
				
			$fmla.r = p.addFormula(f);
		}
	|	FALSE
		{
			Formula f = null;
			if (tlogic.equals("qtl"))	
				f = new QTLFalse();
			else if (tlogic.equals("qtl-i"))
				f = new QTLIFalse();
			else if (tlogic.equals("mitl"))
				f = new MITLFalse();
			else if (tlogic.equals("mitl-i"))
				f = new MITLIFalse();
				
			$fmla.r = p.addFormula(f);
		}
	|   ID  
		{	
			if (memory.containsKey($ID.text)){
				$fmla.r = memory.get($ID.text);					
			}
			else{
				Formula f = null;
				if (tlogic.equals("qtl"))	
					f = new QTLAtom($ID.text);
				else if (tlogic.equals("qtl-i"))
					f = new QTLIAtom($ID.text);
				else if (tlogic.equals("mitl"))
					f = new MITLAtom($ID.text);
				else if (tlogic.equals("mitl-i"))
					f = new MITLIAtom($ID.text);
				
				$fmla.r = p.addFormula(f);
			}
		}
	|	LPAR NEG_OP f1=fmla RPAR 
		{	
			Formula f = null;
			if (tlogic.equals("qtl")) 
				f = new QTLNegation((QTLFormula) $f1.r);
			else if (tlogic.equals("qtl-i")) 
				f = new QTLINegation((QTLIFormula) $f1.r);
			else if (tlogic.equals("mitl"))
				f = new MITLNegation((MITLFormula) $f1.r);
			else if (tlogic.equals("mitl-i"))
				f = new MITLINegation((MITLIFormula) $f1.r);
				
			$fmla.r = p.addFormula(f);
		}
	|   LPAR AND_OP clist=conjuncts_list RPAR
		{	
			Formula f = null;
			Formula[] arr = null;
			
			if (tlogic.equals("qtl")) 
				f = new QTLConjunction((QTLFormula)($clist.l).get(0),(QTLFormula)($clist.l).get(1));
			else if (tlogic.equals("qtl-i")){ 
			
				arr = new QTLIFormula[clist.size()];

				int i = 0;
				for (Formula fm: clist)
					arr[i++] = fm;
			
				f = QTLIFormula.and((QTLIFormula[]) arr);
			}	
			else if (tlogic.equals("mitl"))
				f = new MITLConjunction((MITLFormula)($clist.l).get(0),(MITLFormula)($clist.l).get(1));
			else if (tlogic.equals("mitl-i")){ 
			
				arr = new MITLIFormula[clist.size()];

				int i = 0;
				for (Formula fm: clist)
					arr[i++] = fm;
			
				f = MITLIFormula.and((MITLIFormula[]) arr);
			}	
					
			$fmla.r = p.addFormula(f);
		}
	|   LPAR OR_OP clist=conjuncts_list RPAR
		{	
			Formula f = null;
			Formula[] arr = null;
			
			if (tlogic.equals("qtl")) 
				f = new QTLDisjunction((QTLFormula)($clist.l).get(0),(QTLFormula)($clist.l).get(1));
			else if (tlogic.equals("qtl-i")){ 
			
				arr = new QTLIFormula[clist.size()];

				int i = 0;
				for (Formula fm: clist)
					arr[i++] = fm;
			
				f = QTLIFormula.or((QTLIFormula[]) arr);
			}	
			else if (tlogic.equals("mitl"))
				f = MITLFormula.or((MITLFormula)($clist.l).get(0),(MITLFormula)($clist.l).get(1));
			else if (tlogic.equals("mitl-i")){ 
			
				arr = new MITLIFormula[clist.size()];

				int i = 0;
				for (Formula fm: clist)
					arr[i++] = fm;
			
				f = MITLIFormula.or((MITLIFormula[]) arr);
			}
				
			$fmla.r = p.addFormula(f);	
		}
	|   LPAR IMPL_OP f1=fmla f2=fmla RPAR
		{	
			Formula f = null; 
			if (tlogic.equals("qtl")) 
				f = QTLFormula.implies((QTLFormula)$f1.r, (QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-i")) 
				f = QTLIFormula.implies((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);		
			else if (tlogic.equals("mitl"))
				f = MITLFormula.implies((MITLFormula)$f1.r, (MITLFormula)$f2.r);
			else if (tlogic.equals("mitl-i")) 
				f = MITLIFormula.implies((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);	
				
			$fmla.r = p.addFormula(f);	
		}
	|   LPAR IFF_OP f1=fmla f2=fmla RPAR
		{	
			Formula f = null; 
			if (tlogic.equals("qtl")) 
				f = QTLFormula.iff((QTLFormula)$f1.r, (QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-i")) 
				f = QTLIFormula.iff((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);		
			else if (tlogic.equals("mitl"))
				f = MITLFormula.iff((MITLFormula)$f1.r, (MITLFormula)$f2.r);
			else if (tlogic.equals("mitl-i")) 
				f = MITLIFormula.iff((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
				
			$fmla.r = p.addFormula(f);		
		}	
	|   LPAR F_OP a=INT b=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($F_OP.text);
			
			
			if (tlogic.equals("qtl")){
				if (s.compareTo("F_ee") == 0)
					f = QTLFormula.F((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.OPEN); 
				else if (s.compareTo("F_ei") == 0)
					f = QTLFormula.F((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.CLOSED); 
				else if (s.compareTo("F_ie") == 0)	
					f = QTLFormula.F((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.OPEN); 
				else
					f = QTLFormula.F((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.CLOSED);
			} else if (tlogic.equals("qtl-i")){
				if (s.compareTo("F_ee") == 0)
					f = QTLIFormula.F((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.OPEN); 
				else if (s.compareTo("F_ei") == 0)
					f = QTLIFormula.F((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.CLOSED); 
				else if (s.compareTo("F_ie") == 0)	
					f = QTLIFormula.F((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.OPEN); 
				else
					f = QTLIFormula.F((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.CLOSED);
			} else if (tlogic.equals("mitl")){
				if (s.compareTo("F_ei") == 0 || s.compareTo("F_ii") == 0)
					f = MITLFormula.F((MITLFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text));  
			} else if (tlogic.equals("mitl-i")){
				if (s.compareTo("F_ei") == 0 || s.compareTo("F_ii") == 0)
					f = MITLIFormula.F((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text));  
			}
				 
			$fmla.r = p.addFormula(f);
		}
	|   LPAR F_inf_OP a=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($F_inf_OP.text);
			
			if (tlogic.equals("qtl")){
				if (s.compareTo("F_e+") == 0)
					f = QTLFormula.F((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN); 
				else
					f = QTLFormula.F((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED); 
			} else if (tlogic.equals("qtl-i")){
				if (s.compareTo("F_e+") == 0)
					f = QTLIFormula.F((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN); 
				else
					f = QTLIFormula.F((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED); 
			} else if (tlogic.equals("mitl")){
				if (s.compareTo("F_e+") == 0 || s.compareTo("F_i+") == 0)
					f = MITLFormula.F_inf((MITLFormula)$f1.r, Integer.valueOf($a.text));  
			} else if (tlogic.equals("mitl-i")){
				if (s.compareTo("F_e+") == 0 || s.compareTo("F_i+") == 0)
					f = MITLIFormula.F_inf((MITLIFormula)$f1.r, Integer.valueOf($a.text));  
			}
				 
			$fmla.r = p.addFormula(f);
		}		
	|   LPAR op=G_OP a=INT b=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($G_OP.text);
			
			if (tlogic.equals("qtl")){
				if (s.compareTo("G_ee") == 0)
					f = QTLFormula.G((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.OPEN); 
				else if (s.compareTo("G_ei") == 0)
					f = QTLFormula.G((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.CLOSED); 
				else if (s.compareTo("G_ie") == 0)	
					f = QTLFormula.G((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.OPEN); 
				else
					f = QTLFormula.G((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.CLOSED);
			} else if (tlogic.equals("qtl-i")){
				if (s.compareTo("G_ee") == 0)
					f = QTLIFormula.G((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.OPEN); 
				else if (s.compareTo("G_ei") == 0)
					f = QTLIFormula.G((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.CLOSED); 
				else if (s.compareTo("G_ie") == 0)	
					f = QTLIFormula.G((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.OPEN); 
				else
					f = QTLIFormula.G((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.CLOSED);
			} else if (tlogic.equals("mitl")){
				if (s.compareTo("G_ei") == 0 || s.compareTo("G_ii") == 0)
					f = MITLFormula.G((MITLFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text)); 
			} else if (tlogic.equals("mitl-i")){
				if (s.compareTo("G_ei") == 0 || s.compareTo("G_ii") == 0)
					f = MITLIFormula.G((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text)); 
			}
				 
			$fmla.r = p.addFormula(f);
		}
	|   LPAR op=G_inf_OP a=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($G_inf_OP.text);
			
			if (tlogic.equals("qtl")){
				if (s.compareTo("G_e+") == 0)
					f = QTLFormula.G((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN); 
				else
					f = QTLFormula.G((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED); 
			} else if (tlogic.equals("qtl-i")){
				if (s.compareTo("G_e+") == 0)
					f = QTLIFormula.G((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN); 
				else
					f = QTLIFormula.G((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED); 
			} else if (tlogic.equals("mitl")){
				if (s.compareTo("G_e+") == 0 || s.compareTo("G_i+") == 0)
					f = MITLFormula.G_inf((MITLFormula)$f1.r, Integer.valueOf($a.text)); 
			} else if (tlogic.equals("mitl-i")){
				if (s.compareTo("G_e+") == 0 || s.compareTo("G_i+") == 0)
					f = MITLIFormula.G_inf((MITLIFormula)$f1.r, Integer.valueOf($a.text)); 
			}
			
				 
			$fmla.r = p.addFormula(f);
		}	
	|   LPAR P_OP a=INT b=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($P_OP.text);
			
			
			if (tlogic.equals("qtl")){
				if (s.compareTo("P_ee") == 0)
					f = QTLFormula.P((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.OPEN); 
				else if (s.compareTo("P_ei") == 0)
					f = QTLFormula.P((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.CLOSED); 
				else if (s.compareTo("P_ie") == 0)	
					f = QTLFormula.P((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.OPEN); 
				else
					f = QTLFormula.P((QTLFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.CLOSED);
			} else if (tlogic.equals("qtl-i")){
				if (s.compareTo("P_ee") == 0)
					f = QTLIFormula.P((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.OPEN); 
				else if (s.compareTo("P_ei") == 0)
					f = QTLIFormula.P((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.CLOSED); 
				else if (s.compareTo("P_ie") == 0)	
					f = QTLIFormula.P((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.OPEN); 
				else
					f = QTLIFormula.P((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.CLOSED);
			} else if (tlogic.equals("mitl")){
					f = null;
			} else if (tlogic.equals("mitl-i")){
					if (s.compareTo("P_ie") == 0 || s.compareTo("P_ii") == 0)
					f = MITLIFormula.P((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text)); 
			}
				 
			$fmla.r = p.addFormula(f);
		}	
	|   LPAR H_OP a=INT b=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($H_OP.text);
			
			
			if (tlogic.equals("qtl")){
				f = null;
			} else if (tlogic.equals("qtl-i")){
				if (s.compareTo("H_ee") == 0)
					f = QTLIFormula.H((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.OPEN); 
				else if (s.compareTo("H_ei") == 0)
					f = QTLIFormula.H((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN, Integer.valueOf($b.text), Bounds.CLOSED); 
				else if (s.compareTo("H_ie") == 0)	
					f = QTLIFormula.H((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.OPEN); 
				else
					f = QTLIFormula.H((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED, Integer.valueOf($b.text), Bounds.CLOSED);
			} else if (tlogic.equals("mitl")){
					f = null;
			} else if (tlogic.equals("mitl-i")){
					if (s.compareTo("H_ei") == 0 || s.compareTo("H_ii") == 0)
					f = MITLIFormula.H((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text)); 
			}
				 
			$fmla.r = p.addFormula(f);
		}								
	|   LPAR UNTIL_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
			if (tlogic.equals("qtl"))
			 	f = QTLFormula.U((QTLFormula)$f1.r,(QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-i"))
			 	f = QTLIFormula.U((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);
			else if (tlogic.equals("mitl"))
				f = MITLFormula.U((MITLFormula)$f1.r,(MITLFormula)$f2.r);
			else if (tlogic.equals("mitl-i"))
				f = MITLIFormula.U((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
				
				
			$fmla.r = p.addFormula(f);
		}
	|   LPAR SINCE_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
			if (tlogic.equals("qtl"))
			 	f = QTLFormula.S((QTLFormula)$f1.r,(QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-i"))
			 	f = QTLIFormula.S((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);
			else if (tlogic.equals("mitl"))
				f = null;
			else if (tlogic.equals("mitl-i"))
				f = MITLIFormula.S((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
			 	
			$fmla.r = p.addFormula(f); 	
		}		
	|   LPAR RELEASE_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
			if (tlogic.equals("qtl"))
			 	f = QTLFormula.R((QTLFormula)$f1.r,(QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-i"))
			 	f = QTLIFormula.R((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);	
			else if (tlogic.equals("mitl"))
			 	f = MITLFormula.R((MITLFormula)$f1.r,(MITLFormula)$f2.r);
			else if (tlogic.equals("mitl-i"))
			 	f = MITLIFormula.R((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
			 	
			$fmla.r = p.addFormula(f);
		}
	|   LPAR TRIGGER_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
			if (tlogic.equals("qtl"))
			 	f = QTLFormula.T((QTLFormula)$f1.r,(QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-i"))
			 	f = QTLIFormula.T((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);
			 		
			$fmla.r = p.addFormula(f);
		}
		
	| LPAR COUNT_OP n=INT d=INT f1=fmla RPAR
	  {
	      Formula f;
	      f = QTLIFormula.count((QTLIFormula)$f1.r,Integer.valueOf($d.text),Integer.valueOf($n.text));
	  	  $fmla.r = p.addFormula(f);
	  }
		
    ;


conjuncts_list returns [List<Formula> l]
	@init{l = new ArrayList<Formula>();}:
	
	f1=fmla (clist=conjuncts_list | )
		{
			if ($clist.l == null)
				$l.add(f1);
			else{
				($clist.l).add(f1);
				l = new ArrayList<Formula>($clist.l);
			}
				
		}
	;
	 




/* Parenthsis */
LPAR:   '(';
RPAR:	')';
LBRA:	'[';
RBRA:	']';

TRUE: 'true';
FALSE: 'false';

/* Boolean connectives*/
NEG_OP:	'!!';
AND_OP:	'&&';
OR_OP:	'||';
IMPL_OP: '->';
IFF_OP: '<->';


/* Temporal connectives*/
F_OP: 		'F_ee' | 'F_ei' | 'F_ii' | 'F_ie';
F_inf_OP: 	'F_e+' | 'F_i+';

G_OP: 		'G_ee' | 'G_ei' | 'G_ii' | 'G_ie';
G_inf_OP: 	'G_e+' | 'G_i+';


P_OP:   'P_ee' | 'P_ei' | 'P_ii' | 'P_ie';
H_OP:   'H_ee' | 'H_ei' | 'H_ii' | 'H_ie';


UNTIL_OP:	'U';
SINCE_OP:	'S';
RELEASE_OP:	'R';
TRIGGER_OP: 'T';

COUNT_OP: 'C';


LOGIC  :   'qtl'|'mitl'|'qtl-i'|'mitl-i';

COLON: ':';
SEMI: ';';
INT : ('0'..'9')+ ;
fragment ATOM: 'a'..'z';

ID:  ATOM(ATOM | INT | '_')*;

NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t')+ {skip();} ;
COMMENT: '#'~('\r' | '\n')* {skip();} ;
