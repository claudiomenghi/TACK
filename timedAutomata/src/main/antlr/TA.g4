/**
 * Define a grammar called TA
 */
 grammar TA;

 @members {  boolean matchedEOF=false;}

 @header {
package ta.parser;

import java.util.*;
import ta.expressions.*;
import ta.expressions.binary.*;
import ta.expressions.unary.*;
import ta.expressions.ternary.*;
import ta.*;
import ta.transition.Transition;
import ta.transition.Guard;
import ta.transition.EQCondition;
import ta.SystemDecl;
import ta.declarations.Initializer;
import ta.declarations.Variable;
import ta.declarations.Variable;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import ta.TA;
import ta.transition.Assign;
import ta.transition.EQAssignement;
}

 ta returns [SystemDecl systemret] @init {
	$systemret= new SystemDecl();
	
}
 :
 	(
 		dec = declaration
 		{
			if($declaration.timedAutomaton!=null){
				$systemret.addTA($declaration.timedAutomaton);
			}			
		}

 	)* instantiation* system+ EOF
 ;

 declaration returns [TA timedAutomaton]
 :
 	functionDecl
 	| variableDecl
 	| typeDecl
 	| procDecl
 	{
	$timedAutomaton=$procDecl.timedAutomaton;
}

 ;

 instantiation
 :
 	ID assignment ID LPAR argList RPAR ';'
 ;

 system
 :
 	'system' ID
 	(
 		',' ID
 	)* ';'
 ;

 parameterList
 :
 	(
 		LPAR parameter
 		(
 			',' parameter
 		)* RPAR
 	)?
 ;

 parameter
 :
 	type
 	(
 		BITAND
 	)? ID arrayDecl*
 ;

 procDecl returns [TA timedAutomaton]
 :
 	'process' ID parameterList '{' procBody '}'
 	{
	
	 
	 Set<Variable> variabledeclret=$procBody.variabledeclret;
	 
	  final Set<Clock> clocks=new HashSet<>();
				 if(variabledeclret!=null){
				 		variabledeclret.forEach(v -> {
				 		if(v.getType()==Clock.class){
				 			clocks.add(new Clock(v.getId()));
				 		}}
				 			);
				 }
	$timedAutomaton=new TA($ID.text, null, $procBody.stateset, $procBody.transitionsetret, $procBody.initstate, clocks);
}

 ;

 procBody returns
 [State initstate, Set<State> stateset, Set<Transition> transitionsetret, Set<Variable> variabledeclret]
 @init {
 	$variabledeclret=new HashSet<Variable>();
 	}
 :
 	(
 		functionDecl
 		| variableDecl
 		{
				$variabledeclret.addAll($variableDecl.variabledeclret);
			}

 		| typeDecl
 	)* states
 	(
 		commit
 	)?
 	(
 		urgent
 	)? init
 	(
 		transitions
 	)?
 	{
                    	$initstate=$init.initstate;
                    	$stateset=$states.stateset;
                    	$transitionsetret=$transitions.transitionsret;
                    }

 ;

 //********************************************************************************
 // VARIABLE DECLARATION
 //********************************************************************************

 variableDecl returns [Set<Variable> variabledeclret] @init {
 	$variabledeclret=new HashSet<Variable>();
 	}
 :
 	type arrayDecl* variableId
 	{
 			$variabledeclret.add(new Variable($type.typeret, $variableId.id, $variableId.initializerret));
 	}

 	(
 		',' variableId
 		{
 			$variabledeclret.add(new Variable($type.typeret, $variableId.id, $variableId.initializerret)); 		
 	}

 	)* ';'
 ;

 variableId returns [String id, Initializer initializerret]
 :
 	ID
 	{
		$id=$ID.text;
}

 	(
 		'=' initialiser
 		{
		$initializerret=$initialiser.initialiserret;
}

 	)?
 ;

 //TODO

 arrayDecl
 :
 	LBRA expression RBRA
 ;

 initialiser returns [Initializer initialiserret]
 :
 	expression
 	| '{' initialiser
 	(
 		',' initialiser
 	)* '}'
 ;

 type returns [Class typeret]
 :
 //TODO
 	prefix ID
 	(
 		range
 	)?
 	//TODO

 	| prefix 'struct' '{' fieldDecl+ '}'
 	//TODO

 	| prefix
 	(
 		'int'
 		{ $typeret=Integer.class;
                		 }

 		| 'clock'
 		{ $typeret=Clock.class;
                		 }

 		| 'char'
 		{ $typeret=Character.class;
                		 }

 		| 'bool'
 		{ $typeret=Boolean.class;
                		 }

 	)
 ;

 //********************************************************************************
 // TYPE DECLARATION
 //********************************************************************************

 fieldDeclId
 :
 	ID arrayDecl*
 ;

 prefix
 :
 	(
 		(
 			'urgent'
 		)?
 		(
 			'broadcast'
 		)?
 		|
 		(
 			'const'
 		)?
 	)
 ;

 range
 :
 	LBRA NAT ',' NAT RBRA
 ;

 commit
 :
 	'commit' stateList ';'
 ;

 urgent
 :
 	'urgent' stateList ';'
 ;

 stateList
 :
 	ID
 	(
 		',' ID
 	)*
 ;

 typeDecl
 :
 	'typedef' type typeIdList
 	(
 		',' typeIdList
 	)* ';'
 ;

 typeIdList
 :
 	ID
 	(
 		arrayDecl
 	)*
 ;

 fieldDecl returns [Class typeret]
 :
 	type fieldDeclId
 	(
 		',' fieldDeclId
 	)* ';'
 ;

 //********************************************************************************
 // METHOD DECLARATION
 //********************************************************************************

 functionDecl
 :
 	type ID parameterList block
 ;

 // BNF for statements

 block
 :
 	'{'
 	(
 		variableDecl
 		| typeDecl
 	)* statement* '}'
 ;

 statement
 :
 	block
 	| ';'
 	| expression ';'
 	| 'for' '(' exprList ';' exprList ';' exprList ')' statement
 	| 'while' '(' exprList ')' statement
 	| 'do' statement 'while' '(' exprList ')' ';'
 	| 'if' '(' exprList ')' statement
 	(
 		'else' statement
 	)?
 	| 'break' ';'
 	| 'continue' ';'
 	| 'switch' '(' exprList ')' '{' caseocc+ '}'
 	| 'return' ';'
 	| 'return' expression ';'
 ;

 caseocc
 :
 	'case' expression ':' statement*
 	| 'default' ':' statement*
 ;

 //********************************************************************************
 // TIMED AUTOMATON DEFINITION
 //********************************************************************************

 states returns [Set<State> stateset] @init {
	$stateset=new HashSet<>();
}
 :
 	'state' s1 = stateDecl
 	{
	$stateset.add($s1.state);
}

 	(
 		',' s2 = stateDecl
 		{
	$stateset.add($s2.state);
}

 	)* ';'
 ;

 stateDecl returns [State state]
 :
 	ID
 	{
		$state=new State($ID.text);
	}

 	| ID
 	(
 		'{' exp = expression '}'
 	)
 	{
		$state=new State($ID.text, $exp.exp);
	}

 ;

 init returns [State initstate]
 :
 	'init' ID ';'
 	{
	$initstate=new State($ID.text);
}

 ;

 transitions returns [Set<Transition> transitionsret]
 @init {$transitionsret=new HashSet<>();}
 :
 	'trans' transitionset
 	{
		$transitionsret.addAll($transitionset.transitionsret);
	}

 	(
 		transitionset
 		{
		$transitionsret.addAll($transitionset.transitionsret);		
	}

 	)* ';'
 ;

 transitionset returns [Set<Transition> transitionsret]
 @init {$transitionsret=new HashSet<>();}
 :
 	s1 = ID '->' s2 = ID transitionBody
 	{
		$transitionsret.add(new Transition(new State($s1.getText()), new State($s2.getText()), $transitionBody.guardexp, $transitionBody.syncexp,  $transitionBody.assignexp));
	}

 	(
 		',' '->' s3 = ID b2 = transitionBody
 		{
		$transitionsret.add(new Transition(new State($s1.getText()), new State($s3.getText()), $b2.guardexp, $b2.syncexp,  $b2.assignexp));
		
	}

 	)*
 	(
 		',' s1 = ID '->' s2 = ID transitionBody
 		{
		$transitionsret.add(new Transition(new State($s1.getText()), new State($s2.getText()), $transitionBody.guardexp, $transitionBody.syncexp,  $transitionBody.assignexp));
	}

 		(
 			',' '->' s3 = ID b2 = transitionBody
 			{
		$transitionsret.add(new Transition(new State($s1.getText()), new State($s3.getText()), $b2.guardexp, $b2.syncexp,  $b2.assignexp));
		
	}

 		)*
 	)*
 ;

 transitionBody returns
 [Guard guardexp, SyncExpression syncexp, Assign assignexp]
 :
 	'{'
 	(
 		guard{
 			 $guardexp=$guard.guardexp;
 		}
 	)?
 	{
		if($guardexp==null) {$guardexp=new Guard(new HashSet<EQCondition>());}
		}

 	(
 		sync
 		{
		$syncexp=$sync.syncexp;
		}

 	)?
 	(
 		assign{
 			$assignexp=$assign.assignexp;
 		}
 	)? '}'
 	{
		if($assignexp==null){ $assignexp=new Assign(new HashSet<EQAssignement>());}
		}

 ;

 guard returns [Guard guardexp]
 :
 	'guard' exp1 = conditionList ';'
 	{
	$guardexp=new Guard($conditionList.conditions);
}

 ;

 conditionList returns [Set<EQCondition> conditions] @init {
		$conditions=new HashSet();
	}
 :
 	(
 		condition
 		{
				$conditions.add($condition.conditionret);
			}

 	)*
 ;

 condition returns [EQCondition conditionret]
 :
 	id = ID op = EQCOMP value = NAT
 	{
	 	$conditionret=new EQCondition($id.text ,new Value($value.text));
	}

 ;

 sync returns [SyncExpression syncexp]
 :
 	'sync' exp2 = expression op =
 	(
 		'!'
 		| '?'
 	) ';'
 	{
	$syncexp=new SyncExpression($exp2.exp, $op.text);
}

 ;

 assign returns [Assign assignexp]
 :
 	'assign' expl = assignmentList ';'
 	{
	$assignexp=new Assign($assignmentList.assignement);
}

 ;

 assignmentList returns [Set<EQAssignement> assignement] @init {
	$assignement=new HashSet<>();
}
 :
 	(
 		simpleassigment
 		{
				$assignement.add($simpleassigment.assignementsret);
			}

 	)*
 ;

 simpleassigment returns [EQAssignement assignementsret]
 :
 	(
 		id = ID op = EQ nat = NAT
 	)
 	{$assignementsret=new EQAssignement(
 						$id.text,
 						new Value($nat.text)
 					);}

 ;

 //********************************************************************************
 // EXPRESSIONS
 //********************************************************************************

 exprList returns [List<Expression> exprListret]
 @init {$exprListret=new ArrayList<>();}
 :
 	exp1 = expression
 	{
	$exprListret.add($exp1.exp);
}

 	(
 		',' exp2 = expression
 		{
	$exprListret.add($exp2.exp);
	}

 	)*
 ;

 expression returns [Expression exp]
 :
 	ID
 	{
		$exp=new Identifier($ID.text);
	}

 	| NAT
 	{
		$exp=new Value($NAT.text);
	}

 	| exp1 = expression op =
 	(
 		PLUSPLUS
 		| MINUSMINUS
 	)
 	{
      $exp=new RightUnaryOperator($exp1.exp, $op.text);
    }

 	| op =
 	(
 		PLUS
 		| MINUS
 		| PLUSPLUS
 		| MINUSMINUS
 	) exp1 = expression
 	{
    	$exp=new LeftUnaryOperator($op.text, $exp1.exp);
    }

 	| op =
 	(
 		'~'
 		| '!'
 	) exp1 = expression
 	{
    	$exp=new LeftUnaryOperator($op.text, $exp1.exp);
    }

 	| exp1 = expression op =
 	(
 		MULT
 		| FRACT
 		| MOD
 	) exp2 = expression
 	{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op =
 	(
 		PLUS
 		| MINUS
 	) exp2 = expression
 	{
    		BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op =
 	(
 		LEQ
 		| GEQ
 		| GE
 		| LE
 	) exp2 = expression
 	{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op =
 	(
 		EQCOMP
 		| NEQ
 	) exp2 = expression
 	{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op = BITAND exp2 = expression
 	{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op = POW exp2 = expression
 	{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op = BITOR exp2 = expression
 	{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op = AND exp2 = expression
 	{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op = OR exp2 = expression
 	{
    	BinaryExpression exp=new BinaryExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression '?' exp2 = expression ':' exp3 = expression
 	{
    	$exp=new TernaryExpression($exp1.exp, $exp2.exp, $exp3.exp);
    }

 	| exp1 = expression op =
 	(
 		COLUMEQ
 		| EQ
 		| PLUSEQ
 		| MINUSEQ
 		| MULTEQ
 		| FRACTEQ
 		| BITANDEQ
 		| BITOREQ
 		| POWEQ
 		| '>>='
 		| '>>>='
 		| '<<='
 		| MODEQ
 	) exp2 = expression
 	{
    	$exp=new BinaryExpression($exp1.exp, $op.text, $exp2.exp);
    }

 ;

 assignment returns [Expression exp]
 :
 	(
 		ID op = EQ expr = expression
 	)
 	{$exp=new AssignementExpression(
 						new Identifier($ID.text),
 						$op.text, 
 						$expr.exp
 					);}

 	|
 	(
 		ID op = COLUMEQ expr = expression
 	)
 	{$exp=new AssignementExpression(
 						 new Identifier($ID.text),
 						$op.text,
 						$expr.exp
 					);}

 ;

 argList returns [List<Expression> args] @init {
				     $args = new ArrayList<Expression>();
			}
 :
 	(
 		expression
 		(
 			',' argList
 		)*
 	)
 	{
				$args.add($expression.exp);
				$args.addAll($argList.args);
			}

 	|
 ;

 LE
 :
 	'<'
 ;

 LEQ
 :
 	'<='
 ;

 GEQ
 :
 	'>='
 ;

 GE
 :
 	'>'
 ;

 EQCOMP
 :
 	'=='
 ;

 NEQ
 :
 	'!='
 ;

 EQ
 :
 	'='
 ;

 FRACTEQ
 :
 	'/='
 ;

 UNARYOP
 :
 	(
 		'-'
 		| '!'
 	)
 ;

 // MATH OPERATORS

 MODEQ
 :
 	'%='
 ;

 PLUS
 :
 	'+'
 ;

 PLUSPLUS
 :
 	'++'
 ;

 MINUSMINUS
 :
 	'--'
 ;

 MINUS
 :
 	'-'
 ;

 MULT
 :
 	'*'
 ;

 PLUSEQ
 :
 	'+='
 ;

 MINUSEQ
 :
 	'-='
 ;

 COLUMEQ
 :
 	':='
 ;

 MULTEQ
 :
 	'*='
 ;

 POWEQ
 :
 	'^='
 ;

 FRACT
 :
 	'/'
 ;

 MOD
 :
 	'%'
 ;

 POW
 :
 	'^'
 ;

 // LOGIC OPERATORS

 AND
 :
 	'&&'
 ;

 OR
 :
 	'||'
 ;

 BITAND
 :
 	'&'
 ;

 BITANDEQ
 :
 	'&='
 ;

 BITOREQ
 :
 	'|='
 ;

 BITOR
 :
 	'|'
 ;

 /* PARENTHESIS */
 LPAR
 :
 	'('
 ;

 RPAR
 :
 	')'
 ;

 LBRA
 :
 	'['
 ;

 RBRA
 :
 	']'
 ;

 // IDENTIFIERS

 WS
 :
 	[ \n\t\r]+ -> skip
 ;

 ID
 :
 	(
 		'a' .. 'z'
 		| 'A' .. 'Z'
 	)
 	(
 		'a' .. 'z'
 		| 'A' .. 'Z'
 		| '0' .. '9'
 		| '_'
 	)*
 ;

 NAT
 :
 	(
 		'0' .. '9'
 	)
 	(
 		'0' .. '9'
 	)*
 ;

 TRUE
 :
 	'true'
 ;

 FALSE
 :
 	'false'
 ;

 NEWLINE
 :
 	'\r'? '\n'
 ;

 COMMENT
 :
 	'#' ~( '\r' | '\n' )*
 	{skip();}

 ;