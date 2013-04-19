grammar QTL;

@header {
package parserHandler;

import java.util.HashMap;
import delegateTranslator.*;
import formulae.*;
import formulae.QTL.*;
import formulae.QTLI.*;
import formulae.MITL.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
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
				else if (tlogic.equals("qtl-opt"))
					p = new QTLIParserHandler();
				else if (tlogic.equals("mitl"))
					p = new MITLParserHandler();				 
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
			 	memory.put($s.text, $fmla.r);
			 }
			 NEWLINE
		| NEWLINE;

        
fmla returns [Formula r]
	:   ID
		{			
			if (memory.containsKey($ID.text)){
				$fmla.r = memory.get($ID.text);					
			}
			
		}
	|   ATOM  
		{	
			Formula f = null;
			if (tlogic.equals("qtl"))	
				f = new QTLAtom($ATOM.text);
			else if (tlogic.equals("qtl-opt"))
				f = new QTLIAtom($ATOM.text);
			else if (tlogic.equals("mitl"))
				f = new MITLAtom($ATOM.text);
				
			$fmla.r = p.addFormula(f);
			
		}
	|	LPAR NEG_OP f1=fmla RPAR 
		{	
			Formula f = null;
			if (tlogic.equals("qtl")) 
				f = new QTLNegation((QTLFormula) $f1.r);
			else if (tlogic.equals("qtl-opt")) 
				f = new QTLINegation((QTLIFormula) $f1.r);
			else if (tlogic.equals("mitl"))
				f = new MITLNegation((MITLFormula) $f1.r);
				
			$fmla.r = p.addFormula(f);
		}
	|   LPAR AND_OP f1=fmla f2=fmla RPAR
		{	
			Formula f = null;
			if (tlogic.equals("qtl")) 
				f = new QTLConjunction((QTLFormula)$f1.r,(QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-opt")) 
				f = new QTLIConjunction((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);	
			else if (tlogic.equals("mitl"))
				f = new MITLConjunction((MITLFormula)$f1.r,(MITLFormula)$f2.r);
					
			$fmla.r = p.addFormula(f);
		}
	|   LPAR OR_OP f1=fmla f2=fmla RPAR
		{	
			Formula f = null;
			if (tlogic.equals("qtl")) 
				f = QTLFormula.or((QTLFormula)$f1.r, (QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-opt")) 
				f = new QTLIDisjunction((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);		
			else if (tlogic.equals("mitl"))
				f = MITLFormula.or((MITLFormula)$f1.r, (MITLFormula)$f2.r);
				
			$fmla.r = p.addFormula(f);	
		}
	|   LPAR IMPL_OP f1=fmla f2=fmla RPAR
		{	
			Formula f = null; 
			if (tlogic.equals("qtl")) 
				f = QTLFormula.implies((QTLFormula)$f1.r, (QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-opt")) 
				f = QTLIFormula.implies((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);		
			else if (tlogic.equals("mitl"))
				f = MITLFormula.implies((MITLFormula)$f1.r, (MITLFormula)$f2.r);	
				
			$fmla.r = p.addFormula(f);	
		}
	|   LPAR IFF_OP f1=fmla f2=fmla RPAR
		{	
			Formula f = null; 
			if (tlogic.equals("qtl")) 
				f = QTLFormula.iff((QTLFormula)$f1.r, (QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-opt")) 
				f = QTLIFormula.iff((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);		
			else if (tlogic.equals("mitl"))
				f = MITLFormula.iff((MITLFormula)$f1.r, (MITLFormula)$f2.r);
				
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
			} else if (tlogic.equals("qtl-opt")){
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
			} else if (tlogic.equals("qtl-opt")){
				if (s.compareTo("F_e+") == 0)
					f = QTLIFormula.F((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN); 
				else
					f = QTLIFormula.F((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED); 
			} else if (tlogic.equals("mitl")){
				if (s.compareTo("F_e+") == 0 || s.compareTo("F_i+") == 0)
					f = MITLFormula.F_inf((MITLFormula)$f1.r, Integer.valueOf($a.text));  
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
			} else if (tlogic.equals("qtl-opt")){
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
			} else if (tlogic.equals("qtl-opt")){
				if (s.compareTo("G_e+") == 0)
					f = QTLIFormula.G((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.OPEN); 
				else
					f = QTLIFormula.G((QTLIFormula)$f1.r, Integer.valueOf($a.text), Bounds.CLOSED); 
			} else if (tlogic.equals("mitl")){
				if (s.compareTo("G_e+") == 0 || s.compareTo("G_i+") == 0)
					f = MITLFormula.G_inf((MITLFormula)$f1.r, Integer.valueOf($a.text)); 
			}
			
				 
			$fmla.r = p.addFormula(f);
		}				
	|   LPAR UNTIL_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
			if (tlogic.equals("qtl"))
			 	f = new QTLUntil((QTLFormula)$f1.r,(QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-opt"))
			 	f = new QTLIUntil((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);
			else if (tlogic.equals("mitl"))
				f = new MITLUntil((MITLFormula)$f1.r,(MITLFormula)$f2.r);
				
			$fmla.r = p.addFormula(f);
		}
	|   LPAR SINCE_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
			if (tlogic.equals("qtl"))
			 	f = new QTLSince((QTLFormula)$f1.r,(QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-opt"))
			 	f = new QTLISince((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);
		}		
	|   LPAR RELEASE_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
			if (tlogic.equals("qtl"))
			 	f = QTLFormula.R((QTLFormula)$f1.r,(QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-opt"))
			 	f = QTLIFormula.R((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);	
			else if (tlogic.equals("mitl"))
			 	f = MITLFormula.R((MITLFormula)$f1.r,(MITLFormula)$f2.r);
			 	
			$fmla.r = p.addFormula(f);
		}
	|   LPAR TRIGGER_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
			if (tlogic.equals("qtl"))
			 	f = QTLFormula.T((QTLFormula)$f1.r,(QTLFormula)$f2.r);
			else if (tlogic.equals("qtl-opt"))
			 	f = QTLIFormula.T((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);
			 		
			$fmla.r = p.addFormula(f);
		}
		
    ;





/* Parenthsis */
LPAR:   '(';
RPAR:	')';
LBRA:	'[';
RBRA:	']';



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


P_OP:   'P';
H_OP:   'H';
UNTIL_OP:	'U';
SINCE_OP:	'S';
RELEASE_OP:	'R';
TRIGGER_OP: 'T';


LOGIC  :   'qtl'|'mitl'|'qtl-opt';

COLON: ':';
SEMI: ';';
ATOM  :   ('a'..'z')+ ;
INT :   '0'..'9'+ ;
ID:  ATOM(ATOM | INT)*;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t')+ {skip();} ;
