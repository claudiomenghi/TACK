grammar MITLI;

@header {
package formulae.mitli.parser;

import java.util.HashMap;
import formulae.*;
import formulae.mitli.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Collections;
}

mitli:	l=logic NEWLINE
			{ 
		 	}
		 	':bound' INT NEWLINE
			{
				System.out.println("Starting parsing formulae...");
			}
			declaration*
			':formula' fmla
			{				
			
					
			} NEWLINE;
	

logic returns [String s]
	: COLON LOGIC	{ $s = new String($LOGIC.text); };
	
			
declaration: ':def' s=ID
			 fmla 
			 {
			
			 }
			 NEWLINE
		| NEWLINE;

        
fmla returns [Formula r]
	:   LPAR fmla{
		$r=$fmla.r;
	} RPAR
		
	|	TRUE
		{
			Formula f = new MITLITrue();
				
			$r = f;
		}
	|	FALSE
		{
			Formula f = new MITLIFalse();
				
			$r = f;
		}
	|   ID  
		{	
			
				Formula f = new MITLIAtom($ID.text);
				
				$r = f;
			
		}
	|	LPAR NEG_OP f1=fmla RPAR 
		{	
			Formula f = new MITLINegation((MITLIFormula) $f1.r);
				
			$r = f;
		}
	|   LPAR AND_OP conjuncts_list RPAR
		{	
			Formula f = null;
			Formula[] arr = null;
			
			
				arr = new MITLIFormula[$conjuncts_list.l.size()];

				int i = 0;
				for (Formula fm: $conjuncts_list.l)
					arr[i++] = fm;
			
				f = MITLIFormula.and((MITLIFormula[]) arr);
			
					
			$r = f;
		}
	|   LPAR OR_OP conjuncts_list RPAR
		{	
			Formula f = null;
			Formula[] arr = null;
			
				arr = new MITLIFormula[$conjuncts_list.l.size()];

				int i = 0;
				for (Formula fm: $conjuncts_list.l)
					arr[i++] = fm;
			
				f = MITLIFormula.or((MITLIFormula[]) arr);
			
				
			$r = f;	
		}
	|   LPAR IMPL_OP f1=fmla f2=fmla RPAR
		{	
			Formula f = MITLIFormula.implies((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);	
				
			$r = f;	
		}
	|   LPAR IFF_OP f1=fmla f2=fmla RPAR
		{	
			Formula f = MITLIFormula.iff((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
				
			$r = f;		
		}	
	|   LPAR F_OP a=INT b=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($F_OP.text);
			
				if (s.compareTo("F_ei") == 0 || s.compareTo("F_ii") == 0)
					f = MITLIFormula.F((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text));  
			
				 
			$r = f;
		}
	|   LPAR F_inf_OP a=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($F_inf_OP.text);
			
			
				if (s.compareTo("F_e+") == 0 || s.compareTo("F_i+") == 0)
					f = MITLIFormula.F_inf((MITLIFormula)$f1.r, Integer.valueOf($a.text));  
			
				 
			$r = f;
		}		
	|   LPAR G_OP a=INT b=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($G_OP.text);
			
			
				if (s.compareTo("G_ei") == 0 || s.compareTo("G_ii") == 0)
					f = MITLIFormula.G((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text)); 
			
				 
			$r = f;
		}
	|   LPAR G_inf_OP a=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($G_inf_OP.text);
			
			if (s.compareTo("G_e+") == 0 || s.compareTo("G_i+") == 0)
					f = MITLIFormula.G_inf((MITLIFormula)$f1.r, Integer.valueOf($a.text)); 
			
			
				 
			$r = f;
		}	
	|   LPAR P_OP a=INT b=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($P_OP.text);
			
			
			if (s.compareTo("P_ie") == 0 || s.compareTo("P_ii") == 0)
					f = MITLIFormula.P((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text)); 
			
				 
			$r = f;
		}	
	|   LPAR H_OP a=INT b=INT f1=fmla RPAR 
		{	
			Formula f = null;
			String s = String.valueOf($H_OP.text);
				if (s.compareTo("H_ei") == 0 || s.compareTo("H_ii") == 0)
					f = MITLIFormula.H((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text)); 
			
				 
			$r = f;
		}								
	|   LPAR UNTIL_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
				f = MITLIFormula.U((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
				
				
			$r = f;
		}
	|   LPAR SINCE_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
				f = MITLIFormula.S((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
			 	
			$r = f; 	
		}		
	|   LPAR RELEASE_OP f1=fmla f2=fmla RPAR 
		{
			Formula f = null;
			 	f = MITLIFormula.R((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
			 	
			$r = f;
		}
	
		
    ;


conjuncts_list returns [List<Formula> l]
	@init{$l = new ArrayList<Formula>();}:
	
	 fmla (conjuncts_list | )
		{
			if ($conjuncts_list.l == null)
				$l.add($fmla.r);
			else{
				($conjuncts_list.l).add($fmla.r);
				$l.addAll($conjuncts_list.l);
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
