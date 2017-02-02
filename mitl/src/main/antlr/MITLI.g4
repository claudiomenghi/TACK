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
			Formula f = new MITLITrue();
				
			$fmla.r = p.addFormula(f);
		}
	|	FALSE
		{
			Formula f = new MITLIFalse();
				
			$fmla.r = p.addFormula(f);
		}
	|   ID  
		{	
			if (memory.containsKey($ID.text)){
				$fmla.r = memory.get($ID.text);					
			}
			else{
				Formula f = new MITLIAtom($ID.text);
				
				$fmla.r = p.addFormula(f);
			}
		}
	|	LPAR NEG_OP f1=fmla RPAR 
		{	
			Formula f = new MITLINegation((MITLIFormula) $f1.r);
				
			$fmla.r = p.addFormula(f);
		}
	|   LPAR AND_OP clist=conjuncts_list RPAR
		{	
			Formula f = null;
			Formula[] arr = null;
			
			
				arr = new MITLIFormula[clist.size()];

				int i = 0;
				for (Formula fm: clist)
					arr[i++] = fm;
			
				f = MITLIFormula.and((MITLIFormula[]) arr);
			
					
			$fmla.r = p.addFormula(f);
		}
	|   LPAR OR_OP clist=conjuncts_list RPAR
		{	
			Formula f = null;
			Formula[] arr = null;
			
				arr = new MITLIFormula[clist.size()];

				int i = 0;
				for (Formula fm: clist)
					arr[i++] = fm;
			
				f = MITLIFormula.or((MITLIFormula[]) arr);
			
				
			$fmla.r = p.addFormula(f);	
		}
	|   LPAR IMPL_OP f1=fmla f2=fmla RPAR
		{	
			Formula f = MITLIFormula.implies((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);	
				
			$fmla.r = p.addFormula(f);	
		}
	|   LPAR IFF_OP f1=fmla f2=fmla RPAR
		{	
			Formula f = MITLIFormula.iff((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
				
			$fmla.r = p.addFormula(f);		
		}	
	|   LPAR F_OP a=INT b=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($F_OP.text);
			
				if (s.compareTo("F_ei") == 0 || s.compareTo("F_ii") == 0)
					f = MITLIFormula.F((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text));  
			
				 
			$fmla.r = p.addFormula(f);
		}
	|   LPAR F_inf_OP a=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($F_inf_OP.text);
			
			
				if (s.compareTo("F_e+") == 0 || s.compareTo("F_i+") == 0)
					f = MITLIFormula.F_inf((MITLIFormula)$f1.r, Integer.valueOf($a.text));  
			
				 
			$fmla.r = p.addFormula(f);
		}		
	|   LPAR op=G_OP a=INT b=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($G_OP.text);
			
			
				if (s.compareTo("G_ei") == 0 || s.compareTo("G_ii") == 0)
					f = MITLIFormula.G((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text)); 
			
				 
			$fmla.r = p.addFormula(f);
		}
	|   LPAR op=G_inf_OP a=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($G_inf_OP.text);
			
			if (s.compareTo("G_e+") == 0 || s.compareTo("G_i+") == 0)
					f = MITLIFormula.G_inf((MITLIFormula)$f1.r, Integer.valueOf($a.text)); 
			
			
				 
			$fmla.r = p.addFormula(f);
		}	
	|   LPAR P_OP a=INT b=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($P_OP.text);
			
			
			if (s.compareTo("P_ie") == 0 || s.compareTo("P_ii") == 0)
					f = MITLIFormula.P((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text)); 
			
				 
			$fmla.r = p.addFormula(f);
		}	
	|   LPAR H_OP a=INT b=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($H_OP.text);
				if (s.compareTo("H_ei") == 0 || s.compareTo("H_ii") == 0)
					f = MITLIFormula.H((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text)); 
			
				 
			$fmla.r = p.addFormula(f);
		}								
	|   LPAR UNTIL_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
				f = MITLIFormula.U((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
				
				
			$fmla.r = p.addFormula(f);
		}
	|   LPAR SINCE_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
				f = MITLIFormula.S((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
			 	
			$fmla.r = p.addFormula(f); 	
		}		
	|   LPAR RELEASE_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
			 	f = MITLIFormula.R((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
			 	
			$fmla.r = p.addFormula(f);
		}
	|   LPAR TRIGGER_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
			 	f = QTLIFormula.T((QTLIFormula)$f1.r,(QTLIFormula)$f2.r);
			 		
			$fmla.r = p.addFormula(f);
		}
		
	| LPAR COUNT_OP n=INT b=INT f1=fmla RPAR
	  {
	      Formula f;
	      f = QTLIFormula.count((QTLIFormula)$f1.r,Integer.valueOf($b.text),Integer.valueOf($n.text));
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
