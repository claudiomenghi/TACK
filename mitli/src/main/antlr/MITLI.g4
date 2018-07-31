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
import formulae.mitli.atoms.*;
}

mitli returns [MITLIFormula formula]:	
			 fmla{
			 	$formula=$fmla.r;
			 } ;
			
logic returns [String s]
	: COLON LOGIC	{ $s = new String($LOGIC.text); };
	
			
declaration: ':def' s=ID
			 fmla 
			 {
			
			 }
			 NEWLINE
		| NEWLINE;

        
fmla returns [MITLIFormula r]
	:   LPAR fmla{
		$r=$fmla.r;
	} RPAR
		
	|	TRUE
		{
			MITLIFormula f = new MITLITrue();
				
			$r = f;
		}
	|	FALSE
		{
			MITLIFormula f = new MITLINegation(new MITLITrue());
				
			$r = f;
		}
	|   ID  
		{	
			
				MITLIFormula f = new MITLIPropositionalAtom($ID.text);
				
				$r = f;
			
		}
	|   ID  OP INT
		{
			MITLIFormula f = new MITLIRelationalAtom($ID.text, $OP.text, Integer.parseInt($INT.text));
				
				$r = f;
		}
	|	 NEG_OP LPAR f1=fmla RPAR 
		{	
			MITLIFormula f = MITLIFormula.not((MITLIFormula) $f1.r);
				
			$r = f;
		}
	|    AND_OP  conjuncts_list 
		{	
			MITLIFormula f = null;
			MITLIFormula[] arr = null;
			
			
				arr = new MITLIFormula[$conjuncts_list.l.size()];

				int i = 0;
				for (MITLIFormula fm: $conjuncts_list.l)
					arr[i++] = fm;
			
				f = MITLIFormula.and((MITLIFormula[]) arr);
			
					
			$r = f;
		}
	|   OR_OP  conjuncts_list 
		{	
			MITLIFormula f = null;
			MITLIFormula[] arr = null;
			
				arr = new MITLIFormula[$conjuncts_list.l.size()];

				int i = 0;
				for (MITLIFormula fm: $conjuncts_list.l)
					arr[i++] = fm;
			
				f = MITLIFormula.or((MITLIFormula[]) arr);
			
				
			$r = f;	
		}
	|    IMPL_OP LPAR f1=fmla RPAR LPAR f2=fmla RPAR
		{	
			MITLIFormula f = MITLIFormula.implies((MITLIFormula) $f1.r, (MITLIFormula)$f2.r);	
				
			$r = f;	
		}
	|    IFF_OP LPAR f1=fmla RPAR LPAR f2=fmla RPAR
		{	
			MITLIFormula f = MITLIFormula.iff((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
				
			$r = f;		
		}	
	|    F_OP a=INT b=INT LPAR f1=fmla RPAR 
		{	
			MITLIFormula f = null;
			String s = String.valueOf($F_OP.text);
			
				if (s.compareTo("F_ei") == 0){
					f = MITLIFormula.F((MITLIFormula)$f1.r, Integer.valueOf($a.text), true, Integer.valueOf($b.text), false); 
				}
				if( s.compareTo("F_ii") == 0){
					f = MITLIFormula.F((MITLIFormula)$f1.r, Integer.valueOf($a.text), false,Integer.valueOf($b.text), false); 
				}
				if(s.compareTo("F_ee")==0){
					f = MITLIFormula.F((MITLIFormula)$f1.r, Integer.valueOf($a.text), true, Integer.valueOf($b.text), true); 
				}
				if(s.compareTo("F_ie")==0){
					f = MITLIFormula.F((MITLIFormula)$f1.r, Integer.valueOf($a.text), false, Integer.valueOf($b.text), true);
				}
			$r = f;
		}
	|    F_inf_OP a=INT LPAR f1=fmla RPAR 
		{	
			MITLIFormula f = null;
			String s = String.valueOf($F_inf_OP.text);
			
			
				if (s.compareTo("F_e+") == 0){
					f = MITLIFormula.F_inf((MITLIFormula)$f1.r, Integer.valueOf($a.text));  
				}
				if(s.compareTo("F_i+") == 0){
					f = 
						MITLIFormula.or($f1.r,
						MITLIFormula.F_inf((MITLIFormula)$f1.r, Integer.valueOf($a.text)));  	
				}
			
				 
			$r = f;
		}		
	|    G_OP a=INT b=INT LPAR f1=fmla RPAR 
		{	
			MITLIFormula f = null;
			String s = String.valueOf($G_OP.text);
			
			
				if (s.compareTo("G_ei") == 0){
					f = MITLIFormula.G((MITLIFormula)$f1.r, Integer.valueOf($a.text), true, Integer.valueOf($b.text), false); 
				}
				if( s.compareTo("G_ii") == 0){
					f = MITLIFormula.G((MITLIFormula)$f1.r, Integer.valueOf($a.text), false,Integer.valueOf($b.text), false); 
				}
				if(s.compareTo("G_ee")==0){
					f = MITLIFormula.G((MITLIFormula)$f1.r, Integer.valueOf($a.text), true, Integer.valueOf($b.text), true); 
				}
				if(s.compareTo("G_ie")==0){
					f = MITLIFormula.G((MITLIFormula)$f1.r, Integer.valueOf($a.text), false, Integer.valueOf($b.text), true);
				}
				
				 
			$r = f;
		}
	|    G_inf_OP a=INT LPAR f1=fmla RPAR 
		{	
			MITLIFormula f = null;
			String s = String.valueOf($G_inf_OP.text);
			
			if (s.compareTo("G_e+") == 0){
				f = MITLIFormula.G_inf((MITLIFormula)$f1.r, Integer.valueOf($a.text));  
			}
			if(s.compareTo("G_i+") == 0){
				f = 
					MITLIFormula.and($f1.r,
					MITLIFormula.G_inf((MITLIFormula)$f1.r, Integer.valueOf($a.text)));  	
			}
			$r = f;
		}	
	|    P_OP a=INT b=INT LPAR f1=fmla RPAR 
		{	
			MITLIFormula f = null;
			String s = String.valueOf($P_OP.text);
			
			
			if (s.compareTo("P_ie") == 0 || s.compareTo("P_ii") == 0)
					f = MITLIFormula.P((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text)); 
			
				 
			$r = f;
		}	
	|    H_OP a=INT b=INT LPAR f1=fmla RPAR 
		{	
			MITLIFormula f = null;
			String s = String.valueOf($H_OP.text);
				if (s.compareTo("H_ei") == 0 || s.compareTo("H_ii") == 0)
					f = MITLIFormula.H((MITLIFormula)$f1.r, Integer.valueOf($a.text), Integer.valueOf($b.text)); 
			
				 
			$r = f;
		}								
	|    UNTIL_OP LPAR f1=fmla RPAR  LPAR f2=fmla  RPAR
		{
			MITLIFormula f = null;
				f = MITLIFormula.U((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
				
				
			$r = f;
		}
	|    SINCE_OP LPAR f1=fmla f2=fmla RPAR 
		{
			MITLIFormula f = null;
				f = MITLIFormula.S((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
			 	
			$r = f; 	
		}		
	|    RELEASE_OP LPAR f1=fmla f2=fmla RPAR 
		{
			MITLIFormula f = null;
			 	f = MITLIFormula.R((MITLIFormula)$f1.r,(MITLIFormula)$f2.r);
			 	
			$r = f;
		}
	
		
    ;


conjuncts_list returns [List<MITLIFormula> l]
	@init{$l = new ArrayList<MITLIFormula>();}:
	
	 LPAR fmla{
	 	$l.add($fmla.r);
	 } RPAR 
	 (conjuncts_list{
			$l.addAll($conjuncts_list.l);
			}
	 	
	 	|
	 );
	 


OP: '<' | '>' | '==' | '<=' | '>=';


/* Parenthsis */
LPAR:   '(';
RPAR:	')';
LBRA:	'[';
RBRA:	']';

TRUE: 'true';
FALSE: 'false';

/* Boolean connectives*/
NEG_OP:	'!';
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

fragment ATOMInit: 'a'..'z' | 'A'..'Z';

ID:  ATOMInit (ATOMInit | INT | '_' | '.')*;

NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t' | '\n')+ {skip();} ;
COMMENT: '#'~('\r' | '\n')* {skip();} ;
