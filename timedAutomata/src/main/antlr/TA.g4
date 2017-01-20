/**
 * Define a grammar called TA
 */
grammar TA;

@header {
package ta.parser;

import java.util.*;
import ta.expressions.*;
import ta.expressions.binary.*;
import ta.expressions.unary.*;
import ta.expressions.ternary.*;
import ta.*;
import ta.Transition;
import ta.SystemDecl;
import ta.TA;
}

ta returns [SystemDecl systemret] @init{$systemret= new SystemDecl();}: 
		(dec=declaration{
			if($declaration.timedAutomaton!=null){
				$systemret.addTA($declaration.timedAutomaton);
			}			
		})* 
		instantiation* system  ;

declaration  returns [TA timedAutomaton]: functionDecl | variableDecl | typeDecl | procDecl{
	$timedAutomaton=$procDecl.timedAutomaton;
} ;
instantiation : ID assignment ID LPAR argList RPAR ';' ;

system : 'system' ID (',' ID)* ';' ;  

 parameterList : (LPAR  parameter ( ',' parameter )*  RPAR)?;
 parameter : type  ('&')?  ID arrayDecl*;
 
 
procDecl returns [TA timedAutomaton]: 'process' ID parameterList '{' procBody '}' {
	$timedAutomaton=new TA($ID.text, null, $procBody.stateset, $procBody.transitionsetret, $procBody.initstate);
};

procBody returns [State initstate, Set<State> stateset, Set<Transition> transitionsetret, Set<Variable> variabledeclret] : 
		(functionDecl 
			| variableDecl {
				$variabledeclret=$variableDecl.variabledeclret;
			}
			| typeDecl
		)*
                    states (commit)? (urgent)? init (transitions)?{
                    	$initstate=$init.initstate;
                    	$stateset=$states.stateset;
                    	$transitionsetret=$transitions.transitionsret;
                    }; 
 
 
 

 
//********************************************************************************
// VARIABLE DECLARATION
//********************************************************************************
 variableDecl returns [Set<Variable> variabledeclret] @init{
 	$variabledeclret=new HashSet<Variable>();
 	}: type arrayDecl* variableId{
 			$variabledeclret.add(new Variable($type.typeret, $variableId.id, $variableId.initializerret));
 	} (',' variableId{
 			$variabledeclret.add(new Variable($type.typeret, $variableId.id, $variableId.initializerret)); 		
 	})* ';' ;
 	
variableId returns [String id, Initializer initializerret] : ID{
		$id=$ID.text;
}  ('=' initialiser{
		$initializerret=$initialiser.initialiserret;
} )? ;


//TODO
arrayDecl : LBRA expression RBRA;
 
initialiser returns [Initializer initialiserret] : expression
                 |  '{' initialiser ( ',' initialiser )* '}' ;

type returns [Class typeret] : 
				//TODO
				prefix ID ( range )?{ $typeret=
				}
                 |  prefix 'struct' '{' fieldDecl+ '}'{ $typeret=$fieldDecl.typeret
                 }
                 | prefix (
                 		'int'{ $typeret=Integer.getClass();
                		 } 
                		 | 'clock' { $typeret=Clock.getClass();
                		 } 
                		 | 'char' { $typeret=Character.getClass();
                		 }
                		 | 'bool' { $typeret=Boolean.getClass();
                		 });     



//********************************************************************************
// TYPE DECLARATION
//********************************************************************************
fieldDeclId : ID arrayDecl*;

prefix : ( ( 'urgent' )?( 'broadcast' )? | ('const')? );

range : LBRA NAT ',' NAT RBRA ;
      
commit : 'commit' stateList ';' ;
urgent : 'urgent' stateList ';';
stateList : ID (',' ID)*;

typeDecl : 'typedef' type typeIdList (',' typeIdList)* ';' ;
typeIdList : ID (arrayDecl)* ;



fieldDecl returns [Class typeret]: type fieldDeclId (',' fieldDeclId)* ';' ;


//********************************************************************************
// METHOD DECLARATION
//********************************************************************************
     
  functionDecl : type ID parameterList block ;
 
 // BNF for statements
block : '{' ( variableDecl | typeDecl )* statement* '}' ;
statement : block
           |  ';'
           |  expression ';'
           |  'for' '(' exprList ';' exprList ';' 
                   exprList ')' statement
           |  'while' '(' exprList ')' statement
           |  'do' statement 'while' '(' exprList ')' ';'
           |  'if' '(' exprList ')' statement 
                   ( 'else' statement )?
           |  'break' ';'
           |  'continue' ';'
           |  'switch' '(' exprList ')' '{' caseocc+ '}'
           |  'return' ';'
           |  'return' expression ';' ;
           
caseocc      : 'case' expression ':' statement*
           |  'default' ':' statement* ;

     

           
           
 //********************************************************************************
 // TIMED AUTOMATON DEFINITION
 //********************************************************************************
states returns [Set<State> stateset] @init{
	$stateset=new HashSet<>();
}: 'state' s1=stateDecl {
	$stateset.add($s1.state);
} (',' s2=stateDecl{
	$stateset.add($s2.state);
})* ';';

stateDecl returns[State state] : ID  ('{' exp=expression '}')?{
	$state=new State($ID.text, $exp.exp);
};

init returns [State initstate]: 'init' ID  ';'{
	$initstate=new State($ID.text);
} ;

transitions returns [Set<Transition> transitionsret]
	@init{$transitionsret=new HashSet<>();}: 
	'trans' transitionset{
		$transitionsret.addAll($transitionset.transitionsret);
	} (transitionset{
		$transitionsret.addAll($transitionset.transitionsret);		
	})* ';'
	;


transitionset returns [Set<Transition> transitionsret]
	@init{$transitionsret=new HashSet<>();}:
	s1=ID '->' s2=ID transitionBody{
		$transitionsret.add(new Transition(new State($s1.getText()), new State($s2.getText()), $transitionBody.guardexp, $transitionBody.syncexp,  $transitionBody.assignexp));
	}
	(',' '->' s3=ID b2=transitionBody {
		$transitionsret.add(new Transition(new State($s1.getText()), new State($s3.getText()), $b2.guardexp, $b2.syncexp,  $b2.assignexp));
		
	}
	)*
	(','
		s1=ID '->' s2=ID transitionBody{
		$transitionsret.add(new Transition(new State($s1.getText()), new State($s2.getText()), $transitionBody.guardexp, $transitionBody.syncexp,  $transitionBody.assignexp));
	}
	(',' '->' s3=ID b2=transitionBody {
		$transitionsret.add(new Transition(new State($s1.getText()), new State($s3.getText()), $b2.guardexp, $b2.syncexp,  $b2.assignexp));
		
	})*
	)*
;


transitionBody returns [Expression guardexp, SyncExpression syncexp, Assignement assignexp]: 
'{' 	(guard{
		$guardexp=$guard.guardexp;
		})? 
		(sync{
		$syncexp=$sync.syncexp;
		})? 
		(assign{
		$assignexp=$assign.assignexp;
		})? 
'}';
 
guard returns [Expression guardexp]: 
'guard' exp1=expression ';'{
	$guardexp=$exp1.exp;
};

sync returns [SyncExpression syncexp]: 
'sync' exp2=expression op=('!' | '?') ';' {
	$syncexp=new SyncExpression($exp2.exp, $op.text);
} ;

assign returns [Assignement assignexp]: 
'assign' expl=exprList ';' {
	$assignexp=new Assignement($expl.exprListret);
};


 //********************************************************************************
 // EXPRESSIONS
 //********************************************************************************
exprList returns [List<Expression> exprListret]
@init{$exprListret=new ArrayList<>();}
: exp1=expression{
	$exprListret.add($exp1.exp);
}  ( ',' exp2=expression{
	$exprListret.add($exp2.exp);
	}
)* ;


expression returns [Expression exp]:

	 ID{
		$exp=new Identifier($ID.text);
	}
	| NAT{
		$exp=new Value($NAT.text);
	}
     |  exp1=expression op=('++' | '--'){
      $exp=new RightUnaryOperator($exp1.exp, $op.text);
    }
    |   op=('+'|'-'|'++'|'--') exp1=expression{
    	$exp=new LeftUnaryOperator($op.text, $exp1.exp);
    }
    |   op=('~'|'!') exp1=expression{
    	$exp=new LeftUnaryOperator($op.text, $exp1.exp);
    }
    |   exp1=expression op=('*'|'/'|'%') exp2=expression{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }
    |   exp1=expression op=('+'|'-') exp2=expression{
    		BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }
    |   exp1=expression op=('<=' | '>=' | '>' | LE) exp2=expression{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }
    |   exp1=expression op=('==' | '!=') exp2=expression{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }
    |   exp1=expression op='&' exp2=expression{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }
    |   exp1=expression op='^' exp2=expression{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }
    |   exp1=expression op='|' exp2=expression{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }
    |   exp1=expression op='&&' exp2=expression{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }
    |   exp1=expression op='||' exp2=expression{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }
    |   exp1=expression '?' exp2=expression ':' exp3=expression{
    	$exp=new TernaryExpression($exp1.exp, $exp2.exp, $exp3.exp);
    }
    |   exp1=expression
        op=(  COLUMEQ |  EQ |   '+=' |   '-='   |   '*=' |   '/='  |   '&=' |   '|='  |   '^=' |   '>>='  |   '>>>='  |   '<<=' |   '%=' )
        exp2=expression{
    	$exp=new BinaryExpression($exp1.exp, $op.text, $exp2.exp);
    } ;

 assignment returns [Expression exp]: (ID op='='  expr=expression) 
 					{$exp=new AssignementExpression(
 						new Identifier($ID.text),
 						$op.text, 
 						$expr.exp
 					);}
 					 | (ID op=':=' expr=expression)
 					 {$exp=new AssignementExpression(
 						 new Identifier($ID.text),
 						$op.text,
 						$expr.exp
 					);};
 
argList returns [List<Expression> args] @init {
				     $args = new ArrayList<Expression>();
			}: 
			( expression  ( ',' argList  )* ){
				$args.add($expression.exp);
				$args.addAll($argList.args);
			}
			|
			 ;

 ASSIGNOP : ( '+=' | '-=' | '*=' | '/=' | '%=' 
            | '|=' | '&=' | '^=' | '<<=' | '>>=' | ':=' );

REL : ('<' | '<=' | '==' | '!=' | '>=' | '>') ;

EQ: '=';
COLUMEQ: ':=';
UNARYOP : ( '-' | '!') ;
BININTOP : '+' | '-' | '*' | '/' | '%' | '&' | '|' | '^' | '<<' | '>>' ;


LE : '<';

BINBOOLOP :  ('&&' | '||') ;
WS: [ \n\t\r]+ -> skip;
    
ID : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
NAT: ('0'..'9')('0'..'9')*;


/* Parenthsis */
LPAR:   '(';
RPAR:	')';
LBRA:	'[';
RBRA:	']';

TRUE: 'true';
FALSE: 'false';



