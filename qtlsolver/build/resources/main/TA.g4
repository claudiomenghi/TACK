/**
 * Define a grammar called TA
 */
grammar TA;

@header {
package ta.parser;
}

ta: declaration* instantiation* system  ;
declaration : functionDecl | variableDecl | typeDecl | procDecl ;
instantiation : ID assignment ID '(' argList ')' ';' ;
system : 'system' ID (',' ID)* ';' ;  

 parameterList : ('('  parameter ( ',' parameter )*  ')')?;
 parameter : type  ('&')?  ID arrayDecl*;
 
 functionDecl : type ID parameterList block ;

procDecl : 'process' ID parameterList '{' procBody '}' ;
procBody : (functionDecl | variableDecl | typeDecl )*
                    states (commit)? (urgent)? init (transitions)?; 
 
states : 'state' stateDecl (',' stateDecl)* ';';
stateDecl : ID  ('{' expression '}')?;

commit : 'commit' stateList ';' ;
urgent : 'urgent' stateList ';';
stateList : ID (',' ID)*;
init : 'init' ID  ';' ;

transitions : 'trans' transition (',' transitionOpt )* ';';
transition : ID '->' ID transitionBody;

transitionOpt : transition | '->' ID transitionBody;

transitionBody : '{' (guard)? (sync)? (assign)? '}';
 
guard : 'guard' expression ';' ;
sync : 'sync' expression ('!' | '?') ';' ;
assign : 'assign' exprList ';' ;

typeDecl : 'typedef' type typeIdList (',' typeIdList)* ';' ;
typeIdList : ID (arrayDecl)* ;


// BNF for variable declaration
 variableDecl : type declId (',' declId)* ';' ;
declId : ID arrayDecl* (assignment initialiser )? ;
 
initialiser : expression
                 |  '{' fieldInit ( ',' fieldInit )* '}' ;

fieldInit : ( ID ':' )? initialiser;

arrayDecl : '[' expression ']';

type : prefix ID ( range )?
                 |  prefix 'struct' '{' fieldDecl+ '}';

fieldDecl : type fieldDeclId (',' fieldDeclId)* ';' ;

fieldDeclId : ID arrayDecl*;

prefix : ( ( 'urgent' )?( 'broadcast' )? | ('const')? );

range : '[' expression ',' expression ']' ;
      
      
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



// BNF for expressions

exprList : expression  ( ',' expression  )* ;


expression : ID binexpression
            |   NAT  binexpression
            |   'true' | 'false' binexpression
            |   ID '('  argList  ')' binexpression
            |   '(' expression  ')' 
           | '++'  expression binexpression
            | '--'  expression binexpression
            |    unaryOp expression 
       		  |  ID ternaryexpression
            |   NAT  ternaryexpression
            |   'true' | 'false' ternaryexpression
            |   ID '('  argList  ')' ternaryexpression
           | '++'  expression ternaryexpression
            | '--'  expression ternaryexpression
              |  ID idexpression
            |   NAT  idexpression
            |   'true' | 'false' idexpression
            |   ID '('  argList  ')' idexpression
           | '++'  expression idexpression
            | '--'  expression idexpression
            |   ternaryexpression
         ;

         
idexpression: '.'  ID idexpression 	 |  /* epsilon */ ;        
ternaryexpression:   '?'  ternaryexpressionPrime	;
		
ternaryexpressionPrime: expression  ':'  expression ;

binexpression : binIntOp expression binexpression 
							| assignOp  expression binexpression 
							| rel expression binexpression 
							| binBoolOp expression binexpression 
							| '++' expression
							| '--' expression
							|  '[' expression  ']'
							 |  /* epsilon */ ;

 assignOp : assignment | '+=' | '-=' | '*=' | '/=' | '%=' 
            | '|=' | '&=' | '^=' | '<<=' | '>>=' | ':=' ;
            
 assignment: (ID '=' expression) | (ID ':=' expression);
 
unaryOp :  '-' | '!'  ;
rel : '<' | '<=' | '==' | '!=' | '>=' | '>' ;
binIntOp : '+' | '-' | '*' | '/' | '%' | '&' | '|' | '^' | '<<' | '>>' ;
binBoolOp :  '&&' | '||' ;
argList : ( expression  ( ',' expression  )* )? ;



WS: [ \n\t\r]+ -> skip;
    
ID : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
NAT: ('0'..'9')('0'..'9')*;



