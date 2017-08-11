/**
 * Define a grammar called TA
 */
 grammar TA;

 @members {  boolean matchedEOF=false;
 	
 	 private static Map<String, String> declarations = new HashMap<String, String>();
 	  private static Map<String, String> currentTaDeclarations = new HashMap<String, String>();
 	  private static Map<String,Set<Integer>> boundedVariablesValues=new HashMap<>();
 	  private static String currentProc;
 	   private boolean definedVar(String name){
 	    if(!currentTaDeclarations.containsKey(name) && !declarations.containsKey(name)){
        	return false;
        }
        return true;
    }
    
    private void cleanCurrentTA(){
    	currentTaDeclarations = new HashMap<String, String>();
    }

    private void addCurrentTADeecl(String name, String type){
        currentTaDeclarations.put(name, type);
    }
    public static int TAU_COUNTER=0;
 }

 @header {
package ta.parser;

import java.text.ParseException;
import java.util.*;
import ta.declarations.*;
import ta.expressions.*;
import ta.expressions.binary.*;
import ta.expressions.unary.*;
import ta.expressions.ternary.*;
import ta.*;
import java.util.Map.Entry;

import ta.state.*;
import ta.transition.Transition;
import ta.transition.Guard;
import ta.transition.assignments.*;
import ta.SystemDecl;
import ta.Variable;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import ta.TA;
import ta.transition.Assign;
import ta.transition.sync.*;
import ta.transition.guard.*;
import ta.transition.guard.ClockConstraintAtom.ClockConstraintAtomOperator;
import ta.transition.guard.VariableConstraintAtom.VariableConstraintAtomOperator;
import operators.*;
}

 ta returns [SystemDecl systemret]  @init { 
	Set<TA> timedAutomata=new HashSet<>();
	declarations = new HashMap<String, String>();	
	currentTaDeclarations = new HashMap<String, String>();
	  Set<VariableDecl> variableDeclaration=new HashSet<>();
	  Set<ClockDecl> clockDeclaration=new HashSet<>();
	  Map<String, String> variabledeclret=new HashMap<>();
	  Map<String, Expression> variableinitializationret=new HashMap<>();
	   Map<String, Value> clockinitializationret=new HashMap<>();
	  
}
 :
 	(
 		dec = declaration
 		{

				if($declaration.timedAutomaton!=null) timedAutomata.add($declaration.timedAutomaton);
				if($declaration.variableinitializationret!=null) variableinitializationret.putAll($declaration.variableinitializationret);
				if($declaration.clockinitializationret!=null){
					clockinitializationret.putAll($declaration.clockinitializationret);
				}
				
				if($declaration.variabledeclret!=null) variabledeclret.putAll($declaration.variabledeclret);
				
 			
		}

 	)* instantiation* system+ EOF
 	{
 		
 		if(variableinitializationret!=null){
				for(Entry<String,  Expression> entry :variableinitializationret.entrySet()){
				
				String type="";
				if(variabledeclret.containsKey(entry.getKey())){
					type=variabledeclret.get(entry.getKey());
				}
				if(declarations.containsKey(entry.getKey())){
					type=declarations.get(entry.getKey());
				}
			
			if(boundedVariablesValues.containsKey(entry.getKey())){
			variableDeclaration.add(new BoundedVariableDecl(type,  entry.getKey(), entry.getValue(),boundedVariablesValues.get(entry.getKey())));	
		}
		else{
			variableDeclaration.add(new VariableDecl(type,  entry.getKey(), entry.getValue()));	
			}
			
				}
		}
		if(clockinitializationret!=null){
			for(Entry<String,  Value> entry :clockinitializationret.entrySet()){
				 clockDeclaration.add(new ClockDecl("clock",  entry.getKey(), entry.getValue()));
			}
		}
		
	
		$systemret= new SystemDecl(timedAutomata, clockDeclaration, variableDeclaration);
	
 	}
 ;

 declaration returns [TA timedAutomaton, Map<String, String> variabledeclret, Map<String, Expression> variableinitializationret, Map<String, Value> clockinitializationret]@init { 
 	$variabledeclret=new HashMap();
 	$variableinitializationret=new HashMap<>();
 	$clockinitializationret=new HashMap<>();
 	
 }
 
 :
  	boundedVariableDecl
		 {
				declarations.putAll($boundedVariableDecl.variabledeclret);
			$variabledeclret.putAll($boundedVariableDecl.variabledeclret);
 			$variableinitializationret.putAll($boundedVariableDecl.variableinitializationret);
 			
		}
 	| functionDecl
 	| variableDecl
 	{
 		declarations.putAll($variableDecl.variabledeclret);
 		$variabledeclret.putAll($variableDecl.variabledeclret);
 		$variableinitializationret.putAll($variableDecl.variableinitializationret);
 		$clockinitializationret=$variableDecl.clockinitializationret;
 	
 	}
	 	| typeDecl
 	| procDecl
 	{
	$timedAutomaton=$procDecl.timedAutomaton;
}

 ;

 instantiation
 :
 	ID declarationid ID LPAR argList RPAR ';'
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
 	'process' ID{currentProc=$ID.text;} parameterList '{' procBody '}'
 	{
	
	
	 String taID=$ID.text;
	 cleanCurrentTA();
	 Map<String, String> variabledeclret=$procBody.variabledeclret;
	 
	  final Set<Clock> clocks=new HashSet<>();
	  
	  for(Entry<String, String> entry: variabledeclret.entrySet()){
	  	if(entry.getValue().equals("clock")){
	  			clocks.add(new Clock(entry.getKey()));
			
	  	}
	  }

	 
	 final Set<Variable> variables=new HashSet<>();
	  
	  for(Entry<String, String> entry: variabledeclret.entrySet()){
	  	if(!entry.getValue().equals("clock")){
	  			variables.add(new Variable(entry.getKey()));
	  	}
	  }
	
	 Set<VariableDecl> variableDeclaration=new HashSet<>();
	Map<String, Expression> variableinitializationret=$procBody.variableinitializationret;
	if(variableinitializationret!=null){
	for(Entry<String,  Expression> entry :variableinitializationret.entrySet()){
		
		String type="";
		if(variabledeclret.containsKey(entry.getKey())){
			type=variabledeclret.get(entry.getKey());
		}
		if(declarations.containsKey(entry.getKey())){
			type=declarations.get(entry.getKey());
		}
		if(boundedVariablesValues.containsKey(entry.getKey())){
			variableDeclaration.add(new BoundedVariableDecl(type,  entry.getKey(), entry.getValue(),boundedVariablesValues.get(entry.getKey())));	
		}
		else{
			variableDeclaration.add(new VariableDecl(type,  entry.getKey(), entry.getValue()));	
		}
		}
	}
		
		
		
	Set<ClockDecl> clockDeclaration=new HashSet<>();
	Map<String, Value> clockinitializationret=$procBody.clockinitializationret;
	
	if(clockinitializationret!=null){
		for(Entry<String,  Value> entry :clockinitializationret.entrySet()){
			 clockDeclaration.add(new ClockDecl("clock",  entry.getKey(), entry.getValue()));
		}
	}
	
	
		
	$timedAutomaton=new TA($ID.text, null, $procBody.stateset, $procBody.transitionsetret, $procBody.initstate, clocks,variables, variableDeclaration, clockDeclaration);
}

 ;


 procBody returns
 [State initstate, Set<State> stateset, Set<Transition> transitionsetret, Map<String, String> variabledeclret, Map<String, Expression> variableinitializationret, Map<String, Value> clockinitializationret]
 @init {
 	$variabledeclret=new HashMap<>();
 	$variableinitializationret=new HashMap<>();
 	$clockinitializationret=new HashMap<>();
 	}
 :
 {
 		currentTaDeclarations=new  HashMap<String, String>();
 	}

 	(
 		functionDecl
 		| variableDecl
 		{

				$variabledeclret.putAll($variableDecl.variabledeclret);
				if($variableDecl.variabledeclret!=null){
					currentTaDeclarations.putAll($variableDecl.variabledeclret);
				}
				if($variableDecl.variableinitializationret!=null){
					$variableinitializationret.putAll($variableDecl.variableinitializationret);
				}
				if($variableDecl.clockinitializationret!=null){
					$clockinitializationret.putAll($variableDecl.clockinitializationret);
				}
				
			
		}


 		| typeDecl
 	)* states
 	(
 		commit
 	)?
 	(
 		urgent
 	)? init{
 		for(State s: $states.stateset){
 			if(s.getStringId().equals($init.initString)){
 				$initstate=s;
 			}
 		}
 	}
 	(
 		transitions
 	)?
 	{
 				    	$stateset=$states.stateset;
                    	$transitionsetret=$transitions.transitionsret;
    }
 ;

 //********************************************************************************
 // VARIABLE DECLARATION
 //********************************************************************************

boundedVariableDecl returns
 [Map<String, String> variabledeclret, Map<String, Expression> variableinitializationret]
 @init {
 	$variabledeclret=new HashMap<>();
 	$variableinitializationret=new HashMap<>();
 	Set<Integer> values=new HashSet<>();

 	}
 :
 	type arrayDecl*   	ID
 	 '{' 
 			nat=NAT{
 				values.add(Integer.parseInt($nat.text));
 				
 			} (',' nat=NAT{
 				 	values.add(Integer.parseInt($nat.text));
 				
 			} )* '}' 
 	{
 			if(definedVar($ID.text)){
 				
 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+$ID.text);
		
 			}
 			$variabledeclret.put($ID.text, $type.text);
 			boundedVariablesValues.put($ID.text, values);
 		
 		}
 		 (
 		'=' expression
 		{
 			$variableinitializationret.put($ID.text, $expression.exp);
		}

 		)?
 	
 		 ';'
 ;


 
 variableDecl returns
 [Map<String, String> variabledeclret, Map<String, Expression> variableinitializationret, Map<String, Value> clockinitializationret]
 @init {
 	$variabledeclret=new HashMap<>();
 	$variableinitializationret=new HashMap<>();
 	$clockinitializationret=new HashMap<>();
 	}
 :
 	type arrayDecl* var1 = variableId
 	{
 			if(definedVar($var1.id)){
 				
 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+$var1.id);
		
 			}
 			$variabledeclret.put($var1.id, $type.text);
 			if(!$type.text.equals("clock")){
 				if($var1.exp!=null){
 					$variableinitializationret.put($var1.id, $var1.exp);
 				}
 				else{
 					$variableinitializationret.put($var1.id, new EmptyExpression());
 				}
 			}
 			if( $type.text.equals("clock")){
 				if($var1.exp!=null){
 				 	$clockinitializationret.put($var1.id, (Value) $var1.exp);
 				 }
 				 else{
 				 	$clockinitializationret.put($var1.id, new Value("0"));
 				 }
 			}
 		}
 			

 	(
 		',' varn = variableId
 		{
 			
 			if(definedVar($varn.id)){
 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+$varn.id);
		
 			}
 			$variabledeclret.put($varn.id, $type.text);
 			if(!$type.text.equals("clock")){
 				if($varn.exp!=null){
 					$variableinitializationret.put($varn.id, $varn.exp);
 				}
 				else{
 					$variableinitializationret.put($varn.id, new EmptyExpression());
 				}
 			}
 			if( $type.text.equals("clock")){
 				if($varn.exp!=null){
 				 	$clockinitializationret.put($varn.id, (Value) $varn.exp);
 				 }
 				 else{
 				 	$clockinitializationret.put($varn.id, new Value("0"));
 				 }
 			}
 		}

 	)* ';'
 ;

 variableId returns [String id, Expression exp]
 :
 	ID
 	{
		$id=$ID.text;
}

 	(
 		'=' expression
 		{
		$exp=$expression.exp;
}

 	)?
 ;

 //TODO

 arrayDecl
 :
 	LBRA expression RBRA
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
 	'commit' stateList SEMICOLUMN
 ;

 urgent
 :
 	'urgent' stateList SEMICOLUMN
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
 		'{' inv = invariant '}'
 	)
 	{
 		if($inv.inv!=null){
			$state=new State($ID.text, $inv.inv);
		}
		else{
			$state=new State($ID.text, new EmptyInvariant());
		}	
	}

 ;

 invariant returns [Invariant inv]
 :
 	ID op =
 	(
 		LE
 		| LEQ
 		| GE
 		| GEQ
 	) expression
 	{
 		$inv=new ExpInvariant(new Identifier($ID.text), $op.text, $expression.exp);
 	}

 ;

 init returns [String initString]
 :
 	'init' ID ';'
 	{
	$initString=$ID.text;
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
 		guard
 		{
 			 $guardexp=$guard.guardexp;
 		}

 	)?
 	{
		if($guardexp==null) {$guardexp=new Guard(new HashSet<VariableConstraintAtom>(), new HashSet<ClockConstraintAtom>());}
		}

 	(
 		sync
 		{
		$syncexp=$sync.syncexp;
		}

 	)
 	(
 		assign
 		{
 			$assignexp=$assign.assignexp;
 		}

 	)? '}'
 	{
		if($assignexp==null){ $assignexp=new Assign(new HashSet<ClockAssignement>(), new HashSet<VariableAssignement>());}
		}

 ;

 guard returns [Guard guardexp]
 :
 	'guard' exp1 = guardconditionList SEMICOLUMN
 	{
	$guardexp=new Guard($guardconditionList.variableconst==null? new HashSet<VariableConstraintAtom>() :$guardconditionList.variableconst, $guardconditionList.clockconst==null? new HashSet<ClockConstraintAtom>():$guardconditionList.clockconst);
}

 ;

 guardconditionList returns
 [Set<VariableConstraintAtom> variableconst, Set<ClockConstraintAtom> clockconst] @init {
		$variableconst=new HashSet<>();
		$clockconst=new HashSet<>();
	}
 :
 	clockconstraint
 	{
				if($clockconstraint.clockconst!=null) $clockconst.add($clockconstraint.clockconst) ;
				if($clockconstraint.variableconst!=null) $variableconst.add($clockconstraint.variableconst);
			}

 	(
 		(COMMA || AND) clockconstraint
 		{
				if($clockconstraint.clockconst!=null) $clockconst.add($clockconstraint.clockconst);
				if($clockconstraint.variableconst!=null)$variableconst.add($clockconstraint.variableconst) ;
			}

 	)*
 ;

 clockconstraint returns
 [ClockConstraintAtom clockconst, VariableConstraintAtom variableconst]
 :
 	constraintAtom {
				$clockconst=$constraintAtom.atom;	
				$variableconst=$constraintAtom.variableAtom;
			}

 ;


 constraintAtom returns
 [ClockConstraintAtom atom, VariableConstraintAtom variableAtom]
 :
 	id = ID op =
 	(
 		EQCOMP
 		| GE
 		| GEQ
 		| LE
 		| LEQ
 	) value = NAT
 	{
		
		if(declarations==null){
			throw new InternalError("The set of the declarations cannot be null");	
		}
		String identifier=$id.text;
		if(!declarations.containsKey($id.text) && (currentTaDeclarations==null || !currentTaDeclarations.containsKey($id.text))){
			throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Variable:"+$id.text+" not defined");
		}
		
		
		if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("clock")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("clock"))){
			$atom=new ClockConstraintAtom(new Clock($id.text), ClockConstraintAtomOperator.parse($op.text), Integer.parseInt($value.text));
		}
		if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("int")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("int"))){

			$variableAtom=new VariableConstraintAtom(new Variable($id.text), VariableConstraintAtomOperator.parse($op.text), Integer.parseInt($value.text));
		}
	}

 ;

 sync returns [SyncExpression syncexp]
 :
 	(('sync' exp2 = ID op =
 	(
 		'!'
 		| '?'
 		
 	) ';'){
 		if($op.text.equals("!") || $op.text.equals("?")){
 				$syncexp=new SyncExpression($exp2.text, $op.text);		
 		}
 		else{
 			$syncexp=new SyncExpression("tau"+TAU_COUNTER, "TAU");
 			TAU_COUNTER++;
 		}
	}
 	|
	('sync' exp2 = ID  ';'){
 			$syncexp=new SyncExpression("tau"+TAU_COUNTER, "TAU");
 			TAU_COUNTER++;
 	}
	| {
 			$syncexp=new SyncExpression("tau"+TAU_COUNTER, "TAU");
 			TAU_COUNTER++;
 	})
 	

 ;

 assign returns [Assign assignexp]
 :
 	'assign' expl = assignmentList ';'
 	{
	$assignexp=new Assign($assignmentList.clockassignement, $assignmentList.variableassignement);
}

 ;

 assignmentList returns
 [Set<ClockAssignement> clockassignement, Set<VariableAssignement> variableassignement]
 @init {
	$clockassignement=new HashSet<>();
	$variableassignement=new HashSet<>();
}
 :
 	(
 		assignment
 		{
	 		if($assignment.clockassignementsret!=null){
	 			$clockassignement.add($assignment.clockassignementsret);
	 		}
	 		if($assignment.variableAssignementret!=null){
	 			$variableassignement.add($assignment.variableAssignementret);
	 		}
	 	}

 	)
 	(
 		(
 			COMMA assignment
 			{
				if($assignment.clockassignementsret!=null){
	 			$clockassignement.add($assignment.clockassignementsret);
	 		}
	 		if($assignment.variableAssignementret!=null){
	 			$variableassignement.add($assignment.variableAssignementret);
	 		}
		}

 		)
 	)*
 ;

 assignment returns
 [ClockAssignement clockassignementsret, VariableAssignement variableAssignementret]
 :
 	(
 		id = ID op =
 		(
 			EQASSIGN
 			| EQ
 		) nat = NAT
 	)
 	{
 			if(declarations==null){
			throw new InternalError("The set of the declarations cannot be null");	
		}
		String identifier=$id.text;
		if(!declarations.containsKey($id.text) && (currentTaDeclarations==null || !currentTaDeclarations.containsKey($id.text))){
			throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Variable:"+$id.text+" not defined");
		}
		if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("clock")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("clock"))){
			$clockassignementsret=new ClockAssignement(new Clock($id.text), new Value($nat.text));
		}
		if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("int")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("int"))){
			$variableAssignementret=new VariableAssignement(new Variable($id.text), new Value($nat.text));
		}
 	}

 	|
 	(
 		id = ID op =
 		(
 			EQASSIGN
 			| EQ
 		) exprStatement
 	)
 	{
 		if(declarations==null){
			throw new InternalError("The set of the declarations cannot be null");	
		}
		String identifier=$id.text;
		if(!declarations.containsKey($id.text) && (currentTaDeclarations==null || !currentTaDeclarations.containsKey($id.text))){
			throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Variable:"+$id.text+" not defined");
		}
		if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("clock")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("clock"))){
			throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Clock:"+$id.text+" cannot be assigned to an expression but only to an integer value");
		}
		if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("int")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("int"))){
			$variableAssignementret=new VariableAssignement(new Variable($id.text),  $exprStatement.exp);
		}
 		
 		}

 ;

 simpleassigment returns [ClockAssignement assignementsret]
 :
 	(
 		id = ID op = EQ nat = NAT
 	)
 	{$assignementsret=new ClockAssignement(
 						new Clock($id.text),
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

 exprStatement returns [Expression exp]
 :
 	(
 		expression
 		{
	$exp=$expression.exp;
}

 	)
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
    	BinaryArithmeticExpression exp=new BinaryArithmeticExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op =
 	(
 		PLUS
 		| MINUS
 	) exp2 = expression
 	{
    		BinaryArithmeticExpression exp=new BinaryArithmeticExpression($exp1.exp, $op.text ,$exp2.exp);
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
    	BinaryArithmeticExpression exp=new BinaryArithmeticExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op =
 	(
 		EQCOMP
 		| NEQ
 	) exp2 = expression
 	{
    	BinaryArithmeticExpression exp=new BinaryArithmeticExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op = BITAND exp2 = expression
 	{
    	BinaryArithmeticExpression exp=new BinaryArithmeticExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op = POW exp2 = expression
 	{
    	BinaryArithmeticExpression exp=new BinaryArithmeticExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op = BITOR exp2 = expression
 	{
    	BinaryArithmeticExpression exp=new BinaryArithmeticExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op = AND exp2 = expression
 	{
    	BinaryArithmeticExpression exp=new BinaryArithmeticExpression($exp1.exp, $op.text ,$exp2.exp);
    	$exp=exp;
    }

 	| exp1 = expression op = OR exp2 = expression
 	{
    	BinaryArithmeticExpression exp=new BinaryArithmeticExpression($exp1.exp, $op.text ,$exp2.exp);
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
    	$exp=new BinaryArithmeticExpression($exp1.exp, $op.text, $exp2.exp);
    }

 ;

 declarationid returns [Expression exp]
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

 EQASSIGN
 :
 	':='
 ;

 EQ
 :
 	'='
 ;

 FRACTEQ
 :
 	'/='
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

 BIN_PROPOSITIONAL_LOGIC_OPERATOR
 :
 	AND
 	| OR
 ;

 NOT
 :
 	(
 		'!'
 	)
 ;

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

 SEMICOLUMN
 :
 	';'
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

 COMMA
 :
 	','
 ;

 COMMENT
 :
 	'/*' .*? '*/' -> skip
 ;

 LINE_COMMENT
 :
 	'//' ~[\r\n]* -> skip
 ;

 