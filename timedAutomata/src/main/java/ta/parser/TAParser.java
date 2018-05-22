// Generated from TA.g4 by ANTLR 4.4

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TAParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__37=1, T__36=2, T__35=3, T__34=4, T__33=5, T__32=6, T__31=7, T__30=8, 
		T__29=9, T__28=10, T__27=11, T__26=12, T__25=13, T__24=14, T__23=15, T__22=16, 
		T__21=17, T__20=18, T__19=19, T__18=20, T__17=21, T__16=22, T__15=23, 
		T__14=24, T__13=25, T__12=26, T__11=27, T__10=28, T__9=29, T__8=30, T__7=31, 
		T__6=32, T__5=33, T__4=34, T__3=35, T__2=36, T__1=37, T__0=38, LE=39, 
		LEQ=40, GEQ=41, GE=42, EQCOMP=43, NEQ=44, EQASSIGN=45, EQ=46, FRACTEQ=47, 
		MODEQ=48, PLUS=49, PLUSPLUS=50, MINUSMINUS=51, MINUS=52, MULT=53, PLUSEQ=54, 
		MINUSEQ=55, COLUMEQ=56, MULTEQ=57, POWEQ=58, FRACT=59, MOD=60, POW=61, 
		BIN_PROPOSITIONAL_LOGIC_OPERATOR=62, NOT=63, AND=64, OR=65, BITAND=66, 
		BITANDEQ=67, BITOREQ=68, BITOR=69, LPAR=70, RPAR=71, LBRA=72, RBRA=73, 
		SEMICOLUMN=74, WS=75, ID=76, NAT=77, TRUE=78, FALSE=79, NEWLINE=80, COMMA=81, 
		COMMENT=82, LINE_COMMENT=83;
	public static final String[] tokenNames = {
		"<INVALID>", "'sync'", "'broadcast'", "'default'", "'guard'", "'state'", 
		"'process'", "'commit'", "'char'", "'return'", "'>>='", "'while'", "'{'", 
		"'}'", "'<<='", "'if'", "'for'", "'?'", "'system'", "'break'", "'int'", 
		"'clock'", "'do'", "'switch'", "'trans'", "'->'", "'case'", "'assign'", 
		"'const'", "'init'", "'urgent'", "':'", "'>>>='", "'~'", "'bool'", "'!'", 
		"'else'", "'typedef'", "'struct'", "'<'", "'<='", "'>='", "'>'", "'=='", 
		"'!='", "EQASSIGN", "'='", "'/='", "'%='", "'+'", "'++'", "'--'", "'-'", 
		"'*'", "'+='", "'-='", "COLUMEQ", "'*='", "'^='", "'/'", "'%'", "'^'", 
		"BIN_PROPOSITIONAL_LOGIC_OPERATOR", "NOT", "'&&'", "'||'", "'&'", "'&='", 
		"'|='", "'|'", "'('", "')'", "'['", "']'", "';'", "WS", "ID", "NAT", "'true'", 
		"'false'", "NEWLINE", "','", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_ta = 0, RULE_declaration = 1, RULE_instantiation = 2, RULE_system = 3, 
		RULE_parameterList = 4, RULE_parameter = 5, RULE_procDecl = 6, RULE_procBody = 7, 
		RULE_boundedVariableDecl = 8, RULE_variableDecl = 9, RULE_variableId = 10, 
		RULE_arrayDecl = 11, RULE_type = 12, RULE_fieldDeclId = 13, RULE_prefix = 14, 
		RULE_range = 15, RULE_commit = 16, RULE_urgent = 17, RULE_stateList = 18, 
		RULE_typeDecl = 19, RULE_typeIdList = 20, RULE_fieldDecl = 21, RULE_functionDecl = 22, 
		RULE_block = 23, RULE_statement = 24, RULE_caseocc = 25, RULE_states = 26, 
		RULE_stateDecl = 27, RULE_invariant = 28, RULE_init = 29, RULE_transitions = 30, 
		RULE_transitionset = 31, RULE_transitionBody = 32, RULE_guard = 33, RULE_guardconditionList = 34, 
		RULE_clockconstraint = 35, RULE_constraintAtom = 36, RULE_sync = 37, RULE_assign = 38, 
		RULE_assignmentList = 39, RULE_assignment = 40, RULE_simpleassigment = 41, 
		RULE_exprList = 42, RULE_exprStatement = 43, RULE_expression = 44, RULE_declarationid = 45, 
		RULE_argList = 46;
	public static final String[] ruleNames = {
		"ta", "declaration", "instantiation", "system", "parameterList", "parameter", 
		"procDecl", "procBody", "boundedVariableDecl", "variableDecl", "variableId", 
		"arrayDecl", "type", "fieldDeclId", "prefix", "range", "commit", "urgent", 
		"stateList", "typeDecl", "typeIdList", "fieldDecl", "functionDecl", "block", 
		"statement", "caseocc", "states", "stateDecl", "invariant", "init", "transitions", 
		"transitionset", "transitionBody", "guard", "guardconditionList", "clockconstraint", 
		"constraintAtom", "sync", "assign", "assignmentList", "assignment", "simpleassigment", 
		"exprList", "exprStatement", "expression", "declarationid", "argList"
	};

	@Override
	public String getGrammarFileName() { return "TA.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	  boolean matchedEOF=false;
	 	
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
	 
	public TAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TaContext extends ParserRuleContext {
		public SystemDecl systemret;
		public DeclarationContext dec;
		public DeclarationContext declaration;
		public SystemContext system(int i) {
			return getRuleContext(SystemContext.class,i);
		}
		public TerminalNode EOF() { return getToken(TAParser.EOF, 0); }
		public InstantiationContext instantiation(int i) {
			return getRuleContext(InstantiationContext.class,i);
		}
		public List<InstantiationContext> instantiation() {
			return getRuleContexts(InstantiationContext.class);
		}
		public List<SystemContext> system() {
			return getRuleContexts(SystemContext.class);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public TaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterTa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitTa(this);
		}
	}

	public final TaContext ta() throws RecognitionException {
		TaContext _localctx = new TaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ta);
		 
			Set<TA> timedAutomata=new HashSet<>();
			  Set<VariableDecl> variableDeclaration=new HashSet<>();
			  Set<ClockDecl> clockDeclaration=new HashSet<>();
			  Map<String, String> variabledeclret=new HashMap<>();
			  Map<String, Expression> variableinitializationret=new HashMap<>();
			   Map<String, Value> clockinitializationret=new HashMap<>();
			  

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(94); ((TaContext)_localctx).dec = ((TaContext)_localctx).declaration = declaration();


									if(((TaContext)_localctx).declaration.timedAutomaton!=null) timedAutomata.add(((TaContext)_localctx).declaration.timedAutomaton);
									if(((TaContext)_localctx).declaration.variableinitializationret!=null) variableinitializationret.putAll(((TaContext)_localctx).declaration.variableinitializationret);
									if(((TaContext)_localctx).declaration.clockinitializationret!=null){
										clockinitializationret.putAll(((TaContext)_localctx).declaration.clockinitializationret);
									}
									
									if(((TaContext)_localctx).declaration.variabledeclret!=null) variabledeclret.putAll(((TaContext)_localctx).declaration.variabledeclret);
									
					 			
							
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(102); instantiation();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(108); system();
				}
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__20 );
			setState(113); match(EOF);

			 		
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
							System.out.println("Variable: "+entry.getKey());
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
					((TaContext)_localctx).systemret =  new SystemDecl(timedAutomata, clockDeclaration, variableDeclaration);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TA timedAutomaton;
		public Map<String, String> variabledeclret;
		public Map<String, Expression> variableinitializationret;
		public Map<String, Value> clockinitializationret;
		public BoundedVariableDeclContext boundedVariableDecl;
		public VariableDeclContext variableDecl;
		public ProcDeclContext procDecl;
		public ProcDeclContext procDecl() {
			return getRuleContext(ProcDeclContext.class,0);
		}
		public BoundedVariableDeclContext boundedVariableDecl() {
			return getRuleContext(BoundedVariableDeclContext.class,0);
		}
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public TypeDeclContext typeDecl() {
			return getRuleContext(TypeDeclContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		 
		 	((DeclarationContext)_localctx).variabledeclret = new HashMap();
		 	((DeclarationContext)_localctx).variableinitializationret = new HashMap<>();
		 	((DeclarationContext)_localctx).clockinitializationret = new HashMap<>();
		 	
		 
		try {
			setState(127);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116); ((DeclarationContext)_localctx).boundedVariableDecl = boundedVariableDecl();

						 	declarations.putAll(((DeclarationContext)_localctx).boundedVariableDecl.variabledeclret);
							_localctx.variabledeclret.putAll(((DeclarationContext)_localctx).boundedVariableDecl.variabledeclret);
				 			_localctx.variableinitializationret.putAll(((DeclarationContext)_localctx).boundedVariableDecl.variableinitializationret);
				 			
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119); functionDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(120); ((DeclarationContext)_localctx).variableDecl = variableDecl();

				 		declarations.putAll(((DeclarationContext)_localctx).variableDecl.variabledeclret);
				 		_localctx.variabledeclret.putAll(((DeclarationContext)_localctx).variableDecl.variabledeclret);
				 		_localctx.variableinitializationret.putAll(((DeclarationContext)_localctx).variableDecl.variableinitializationret);
				 		((DeclarationContext)_localctx).clockinitializationret = ((DeclarationContext)_localctx).variableDecl.clockinitializationret;
				 	
				 	
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(123); typeDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124); ((DeclarationContext)_localctx).procDecl = procDecl();

					((DeclarationContext)_localctx).timedAutomaton = ((DeclarationContext)_localctx).procDecl.timedAutomaton;

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstantiationContext extends ParserRuleContext {
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(TAParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TAParser.ID, i);
		}
		public DeclarationidContext declarationid() {
			return getRuleContext(DeclarationidContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(TAParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(TAParser.RPAR, 0); }
		public InstantiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantiation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitInstantiation(this);
		}
	}

	public final InstantiationContext instantiation() throws RecognitionException {
		InstantiationContext _localctx = new InstantiationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instantiation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(ID);
			setState(130); declarationid();
			setState(131); match(ID);
			setState(132); match(LPAR);
			setState(133); argList();
			setState(134); match(RPAR);
			setState(135); match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SystemContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TAParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TAParser.ID, i);
		}
		public SystemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_system; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterSystem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitSystem(this);
		}
	}

	public final SystemContext system() throws RecognitionException {
		SystemContext _localctx = new SystemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_system);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); match(T__20);
			setState(138); match(ID);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(139); match(COMMA);
				setState(140); match(ID);
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146); match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public TerminalNode LPAR() { return getToken(TAParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(TAParser.RPAR, 0); }
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitParameterList(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(148); match(LPAR);
				setState(149); parameter();
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(150); match(COMMA);
					setState(151); parameter();
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157); match(RPAR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode BITAND() { return getToken(TAParser.BITAND, 0); }
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); type();
			setState(163);
			_la = _input.LA(1);
			if (_la==BITAND) {
				{
				setState(162); match(BITAND);
				}
			}

			setState(165); match(ID);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(166); arrayDecl();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcDeclContext extends ParserRuleContext {
		public TA timedAutomaton;
		public Token ID;
		public ProcBodyContext procBody;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public ProcBodyContext procBody() {
			return getRuleContext(ProcBodyContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ProcDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterProcDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitProcDecl(this);
		}
	}

	public final ProcDeclContext procDecl() throws RecognitionException {
		ProcDeclContext _localctx = new ProcDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_procDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); match(T__32);
			setState(173); ((ProcDeclContext)_localctx).ID = match(ID);
			currentProc=(((ProcDeclContext)_localctx).ID!=null?((ProcDeclContext)_localctx).ID.getText():null);
			setState(175); parameterList();
			setState(176); match(T__26);
			setState(177); ((ProcDeclContext)_localctx).procBody = procBody();
			setState(178); match(T__25);

				
				
				 String taID=(((ProcDeclContext)_localctx).ID!=null?((ProcDeclContext)_localctx).ID.getText():null);
				 cleanCurrentTA();
				 Map<String, String> variabledeclret=((ProcDeclContext)_localctx).procBody.variabledeclret;
				 
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
				Map<String, Expression> variableinitializationret=((ProcDeclContext)_localctx).procBody.variableinitializationret;
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
				Map<String, Value> clockinitializationret=((ProcDeclContext)_localctx).procBody.clockinitializationret;
				
				if(clockinitializationret!=null){
					for(Entry<String,  Value> entry :clockinitializationret.entrySet()){
						 clockDeclaration.add(new ClockDecl("clock",  entry.getKey(), entry.getValue()));
					}
				}
					
				((ProcDeclContext)_localctx).timedAutomaton = new TA((((ProcDeclContext)_localctx).ID!=null?((ProcDeclContext)_localctx).ID.getText():null), null, ((ProcDeclContext)_localctx).procBody.stateset, ((ProcDeclContext)_localctx).procBody.transitionsetret, ((ProcDeclContext)_localctx).procBody.initstate, clocks,variables, variableDeclaration, clockDeclaration);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcBodyContext extends ParserRuleContext {
		public State initstate;
		public Set<State> stateset;
		public Set<Transition> transitionsetret;
		public Map<String, String> variabledeclret;
		public Map<String, Expression> variableinitializationret;
		public Map<String, Value> clockinitializationret;
		public VariableDeclContext variableDecl;
		public BoundedVariableDeclContext boundedVariableDecl;
		public StatesContext states;
		public InitContext init;
		public TransitionsContext transitions;
		public UrgentContext urgent() {
			return getRuleContext(UrgentContext.class,0);
		}
		public VariableDeclContext variableDecl(int i) {
			return getRuleContext(VariableDeclContext.class,i);
		}
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public TypeDeclContext typeDecl(int i) {
			return getRuleContext(TypeDeclContext.class,i);
		}
		public BoundedVariableDeclContext boundedVariableDecl(int i) {
			return getRuleContext(BoundedVariableDeclContext.class,i);
		}
		public List<VariableDeclContext> variableDecl() {
			return getRuleContexts(VariableDeclContext.class);
		}
		public List<BoundedVariableDeclContext> boundedVariableDecl() {
			return getRuleContexts(BoundedVariableDeclContext.class);
		}
		public TransitionsContext transitions() {
			return getRuleContext(TransitionsContext.class,0);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public List<TypeDeclContext> typeDecl() {
			return getRuleContexts(TypeDeclContext.class);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public CommitContext commit() {
			return getRuleContext(CommitContext.class,0);
		}
		public ProcBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterProcBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitProcBody(this);
		}
	}

	public final ProcBodyContext procBody() throws RecognitionException {
		ProcBodyContext _localctx = new ProcBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_procBody);

		 	((ProcBodyContext)_localctx).variabledeclret = new HashMap<>();
		 	((ProcBodyContext)_localctx).variableinitializationret = new HashMap<>();
		 	((ProcBodyContext)_localctx).clockinitializationret = new HashMap<>();
		 	
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			 		currentTaDeclarations=new  HashMap<String, String>();
			 	
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__30) | (1L << T__18) | (1L << T__17) | (1L << T__10) | (1L << T__8) | (1L << T__4) | (1L << T__1) | (1L << T__0))) != 0) || _la==ID) {
				{
				setState(190);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(182); functionDecl();
					}
					break;
				case 2:
					{
					setState(183); ((ProcBodyContext)_localctx).variableDecl = variableDecl();


									_localctx.variabledeclret.putAll(((ProcBodyContext)_localctx).variableDecl.variabledeclret);
									if(((ProcBodyContext)_localctx).variableDecl.variabledeclret!=null){
										currentTaDeclarations.putAll(((ProcBodyContext)_localctx).variableDecl.variabledeclret);
									}
									if(((ProcBodyContext)_localctx).variableDecl.variableinitializationret!=null){
										_localctx.variableinitializationret.putAll(((ProcBodyContext)_localctx).variableDecl.variableinitializationret);
									}
									if(((ProcBodyContext)_localctx).variableDecl.clockinitializationret!=null){
										_localctx.clockinitializationret.putAll(((ProcBodyContext)_localctx).variableDecl.clockinitializationret);
									}
									
								
							
					}
					break;
				case 3:
					{
					setState(186); ((ProcBodyContext)_localctx).boundedVariableDecl = boundedVariableDecl();

							 	_localctx.variabledeclret.putAll(((ProcBodyContext)_localctx).boundedVariableDecl.variabledeclret);
					 			_localctx.variableinitializationret.putAll(((ProcBodyContext)_localctx).boundedVariableDecl.variableinitializationret);
					 			currentTaDeclarations.putAll(((ProcBodyContext)_localctx).boundedVariableDecl.variabledeclret);
					 			
							
					}
					break;
				case 4:
					{
					setState(189); typeDecl();
					}
					break;
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195); ((ProcBodyContext)_localctx).states = states();
			setState(197);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(196); commit();
				}
			}

			setState(200);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(199); urgent();
				}
			}

			setState(202); ((ProcBodyContext)_localctx).init = init();

			 		for(State s: ((ProcBodyContext)_localctx).states.stateset){
			 			if(s.getStringId().equals(((ProcBodyContext)_localctx).init.initString)){
			 				((ProcBodyContext)_localctx).initstate = s;
			 			}
			 		}
			 	
			setState(205);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(204); ((ProcBodyContext)_localctx).transitions = transitions();
				}
			}


			 				    	((ProcBodyContext)_localctx).stateset = ((ProcBodyContext)_localctx).states.stateset;
			                    	((ProcBodyContext)_localctx).transitionsetret = ((ProcBodyContext)_localctx).transitions.transitionsret;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoundedVariableDeclContext extends ParserRuleContext {
		public Map<String, String> variabledeclret;
		public Map<String, Expression> variableinitializationret;
		public TypeContext type;
		public Token ID;
		public Token nat;
		public ExpressionContext expression;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NAT(int i) {
			return getToken(TAParser.NAT, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NAT() { return getTokens(TAParser.NAT); }
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public BoundedVariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boundedVariableDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterBoundedVariableDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitBoundedVariableDecl(this);
		}
	}

	public final BoundedVariableDeclContext boundedVariableDecl() throws RecognitionException {
		BoundedVariableDeclContext _localctx = new BoundedVariableDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_boundedVariableDecl);

		 	((BoundedVariableDeclContext)_localctx).variabledeclret = new HashMap<>();
		 	((BoundedVariableDeclContext)_localctx).variableinitializationret = new HashMap<>();
		 	Set<Integer> values=new HashSet<>();

		 	
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209); ((BoundedVariableDeclContext)_localctx).type = type();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(210); arrayDecl();
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(216); ((BoundedVariableDeclContext)_localctx).ID = match(ID);
			setState(217); match(T__26);
			setState(218); ((BoundedVariableDeclContext)_localctx).nat = match(NAT);

			 				values.add(Integer.parseInt((((BoundedVariableDeclContext)_localctx).nat!=null?((BoundedVariableDeclContext)_localctx).nat.getText():null)));
			 				
			 			
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(220); match(COMMA);
				setState(221); ((BoundedVariableDeclContext)_localctx).nat = match(NAT);

				 				 	values.add(Integer.parseInt((((BoundedVariableDeclContext)_localctx).nat!=null?((BoundedVariableDeclContext)_localctx).nat.getText():null)));
				 				
				 			
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228); match(T__25);

			 			if(definedVar((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null))){
			 				
			 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+(((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null));
					
			 			}
			 			_localctx.variabledeclret.put((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null), (((BoundedVariableDeclContext)_localctx).type!=null?_input.getText(((BoundedVariableDeclContext)_localctx).type.start,((BoundedVariableDeclContext)_localctx).type.stop):null));
			 			boundedVariablesValues.put((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null),values);
			 		
			 		
			setState(234);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(230); match(EQ);
				setState(231); ((BoundedVariableDeclContext)_localctx).expression = expression(0);

				 			_localctx.variableinitializationret.put((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null), ((BoundedVariableDeclContext)_localctx).expression.exp);
						
				}
			}

			setState(236); match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclContext extends ParserRuleContext {
		public Map<String, String> variabledeclret;
		public Map<String, Expression> variableinitializationret;
		public Map<String, Value> clockinitializationret;
		public TypeContext type;
		public VariableIdContext var1;
		public VariableIdContext varn;
		public VariableIdContext variableId(int i) {
			return getRuleContext(VariableIdContext.class,i);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public List<VariableIdContext> variableId() {
			return getRuleContexts(VariableIdContext.class);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public VariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterVariableDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitVariableDecl(this);
		}
	}

	public final VariableDeclContext variableDecl() throws RecognitionException {
		VariableDeclContext _localctx = new VariableDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variableDecl);

		 	((VariableDeclContext)_localctx).variabledeclret = new HashMap<>();
		 	((VariableDeclContext)_localctx).variableinitializationret = new HashMap<>();
		 	((VariableDeclContext)_localctx).clockinitializationret = new HashMap<>();
		 	
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); ((VariableDeclContext)_localctx).type = type();
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(239); arrayDecl();
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(245); ((VariableDeclContext)_localctx).var1 = variableId();

			 			if(definedVar(((VariableDeclContext)_localctx).var1.id)){
			 				
			 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+((VariableDeclContext)_localctx).var1.id);
					
			 			}
			 			_localctx.variabledeclret.put(((VariableDeclContext)_localctx).var1.id, (((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null));
			 			if(!(((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null).equals("clock")){
			 				if(((VariableDeclContext)_localctx).var1.exp!=null){
			 					_localctx.variableinitializationret.put(((VariableDeclContext)_localctx).var1.id, ((VariableDeclContext)_localctx).var1.exp);
			 				}
			 				else{
			 					_localctx.variableinitializationret.put(((VariableDeclContext)_localctx).var1.id, new EmptyExpression());
			 				}
			 			}
			 			if( (((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null).equals("clock")){
			 				if(((VariableDeclContext)_localctx).var1.exp!=null){
			 				 	_localctx.clockinitializationret.put(((VariableDeclContext)_localctx).var1.id, (Value) ((VariableDeclContext)_localctx).var1.exp);
			 				 }
			 				 else{
			 				 	_localctx.clockinitializationret.put(((VariableDeclContext)_localctx).var1.id, new Value("0"));
			 				 }
			 			}
			 		
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(247); match(COMMA);
				setState(248); ((VariableDeclContext)_localctx).varn = variableId();

				 			
				 			if(definedVar(((VariableDeclContext)_localctx).varn.id)){
				 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+((VariableDeclContext)_localctx).varn.id);
						
				 			}
				 			_localctx.variabledeclret.put(((VariableDeclContext)_localctx).varn.id, (((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null));
				 			if(!(((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null).equals("clock")){
				 				if(((VariableDeclContext)_localctx).varn.exp!=null){
				 					_localctx.variableinitializationret.put(((VariableDeclContext)_localctx).varn.id, ((VariableDeclContext)_localctx).varn.exp);
				 				}
				 				else{
				 					_localctx.variableinitializationret.put(((VariableDeclContext)_localctx).varn.id, new EmptyExpression());
				 				}
				 			}
				 			if( (((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null).equals("clock")){
				 				if(((VariableDeclContext)_localctx).varn.exp!=null){
				 				 	_localctx.clockinitializationret.put(((VariableDeclContext)_localctx).varn.id, (Value) ((VariableDeclContext)_localctx).varn.exp);
				 				 }
				 				 else{
				 				 	_localctx.clockinitializationret.put(((VariableDeclContext)_localctx).varn.id, new Value("0"));
				 				 }
				 			}
				 		
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256); match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableIdContext extends ParserRuleContext {
		public String id;
		public Expression exp;
		public Token ID;
		public ExpressionContext expression;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterVariableId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitVariableId(this);
		}
	}

	public final VariableIdContext variableId() throws RecognitionException {
		VariableIdContext _localctx = new VariableIdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258); ((VariableIdContext)_localctx).ID = match(ID);

					((VariableIdContext)_localctx).id = (((VariableIdContext)_localctx).ID!=null?((VariableIdContext)_localctx).ID.getText():null);

			setState(264);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(260); match(EQ);
				setState(261); ((VariableIdContext)_localctx).expression = expression(0);

						((VariableIdContext)_localctx).exp = ((VariableIdContext)_localctx).expression.exp;

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayDeclContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBRA() { return getToken(TAParser.LBRA, 0); }
		public TerminalNode RBRA() { return getToken(TAParser.RBRA, 0); }
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitArrayDecl(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arrayDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); match(LBRA);
			setState(267); expression(0);
			setState(268); match(RBRA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Class typeret;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			setState(296);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(270); prefix();
				setState(271); match(ID);
				setState(273);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(272); range();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(275); prefix();
				setState(276); match(T__0);
				setState(277); match(T__26);
				setState(279); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(278); fieldDecl();
					}
					}
					setState(281); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__30) | (1L << T__18) | (1L << T__17) | (1L << T__10) | (1L << T__8) | (1L << T__4) | (1L << T__0))) != 0) || _la==ID );
				setState(283); match(T__25);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(285); prefix();
				setState(294);
				switch (_input.LA(1)) {
				case T__18:
					{
					setState(286); match(T__18);
					 ((TypeContext)_localctx).typeret = Integer.class;
					                		 
					}
					break;
				case T__17:
					{
					setState(288); match(T__17);
					 ((TypeContext)_localctx).typeret = Clock.class;
					                		 
					}
					break;
				case T__30:
					{
					setState(290); match(T__30);
					 ((TypeContext)_localctx).typeret = Character.class;
					                		 
					}
					break;
				case T__4:
					{
					setState(292); match(T__4);
					 ((TypeContext)_localctx).typeret = Boolean.class;
					                		 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public FieldDeclIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterFieldDeclId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitFieldDeclId(this);
		}
	}

	public final FieldDeclIdContext fieldDeclId() throws RecognitionException {
		FieldDeclIdContext _localctx = new FieldDeclIdContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fieldDeclId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298); match(ID);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(299); arrayDecl();
				}
				}
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixContext extends ParserRuleContext {
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitPrefix(this);
		}
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_prefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(306);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(305); match(T__8);
					}
				}

				setState(309);
				_la = _input.LA(1);
				if (_la==T__36) {
					{
					setState(308); match(T__36);
					}
				}

				}
				break;
			case 2:
				{
				setState(312);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(311); match(T__10);
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeContext extends ParserRuleContext {
		public TerminalNode NAT(int i) {
			return getToken(TAParser.NAT, i);
		}
		public TerminalNode LBRA() { return getToken(TAParser.LBRA, 0); }
		public List<TerminalNode> NAT() { return getTokens(TAParser.NAT); }
		public TerminalNode RBRA() { return getToken(TAParser.RBRA, 0); }
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitRange(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316); match(LBRA);
			setState(317); match(NAT);
			setState(318); match(COMMA);
			setState(319); match(NAT);
			setState(320); match(RBRA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommitContext extends ParserRuleContext {
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public StateListContext stateList() {
			return getRuleContext(StateListContext.class,0);
		}
		public CommitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterCommit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitCommit(this);
		}
	}

	public final CommitContext commit() throws RecognitionException {
		CommitContext _localctx = new CommitContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_commit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322); match(T__31);
			setState(323); stateList();
			setState(324); match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UrgentContext extends ParserRuleContext {
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public StateListContext stateList() {
			return getRuleContext(StateListContext.class,0);
		}
		public UrgentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_urgent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterUrgent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitUrgent(this);
		}
	}

	public final UrgentContext urgent() throws RecognitionException {
		UrgentContext _localctx = new UrgentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_urgent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); match(T__8);
			setState(327); stateList();
			setState(328); match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TAParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TAParser.ID, i);
		}
		public StateListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterStateList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitStateList(this);
		}
	}

	public final StateListContext stateList() throws RecognitionException {
		StateListContext _localctx = new StateListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stateList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330); match(ID);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(331); match(COMMA);
				setState(332); match(ID);
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclContext extends ParserRuleContext {
		public List<TypeIdListContext> typeIdList() {
			return getRuleContexts(TypeIdListContext.class);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeIdListContext typeIdList(int i) {
			return getRuleContext(TypeIdListContext.class,i);
		}
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterTypeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitTypeDecl(this);
		}
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338); match(T__1);
			setState(339); type();
			setState(340); typeIdList();
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(341); match(COMMA);
				setState(342); typeIdList();
				}
				}
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(348); match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeIdListContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public TypeIdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterTypeIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitTypeIdList(this);
		}
	}

	public final TypeIdListContext typeIdList() throws RecognitionException {
		TypeIdListContext _localctx = new TypeIdListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_typeIdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350); match(ID);
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(351); arrayDecl();
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclContext extends ParserRuleContext {
		public Class typeret;
		public List<FieldDeclIdContext> fieldDeclId() {
			return getRuleContexts(FieldDeclIdContext.class);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldDeclIdContext fieldDeclId(int i) {
			return getRuleContext(FieldDeclIdContext.class,i);
		}
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitFieldDecl(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357); type();
			setState(358); fieldDeclId();
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(359); match(COMMA);
				setState(360); fieldDeclId();
				}
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(366); match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368); type();
			setState(369); match(ID);
			setState(370); parameterList();
			setState(371); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<VariableDeclContext> variableDecl() {
			return getRuleContexts(VariableDeclContext.class);
		}
		public VariableDeclContext variableDecl(int i) {
			return getRuleContext(VariableDeclContext.class,i);
		}
		public List<TypeDeclContext> typeDecl() {
			return getRuleContexts(TypeDeclContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TypeDeclContext typeDecl(int i) {
			return getRuleContext(TypeDeclContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(373); match(T__26);
			setState(378);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(376);
					switch (_input.LA(1)) {
					case T__36:
					case T__30:
					case T__18:
					case T__17:
					case T__10:
					case T__8:
					case T__4:
					case T__0:
					case ID:
						{
						setState(374); variableDecl();
						}
						break;
					case T__1:
						{
						setState(375); typeDecl();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(380);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__27) | (1L << T__26) | (1L << T__23) | (1L << T__22) | (1L << T__19) | (1L << T__16) | (1L << T__15) | (1L << T__5) | (1L << T__3) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
				{
				{
				setState(381); statement();
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(387); match(T__25);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<ExprListContext> exprList() {
			return getRuleContexts(ExprListContext.class);
		}
		public List<CaseoccContext> caseocc() {
			return getRuleContexts(CaseoccContext.class);
		}
		public CaseoccContext caseocc(int i) {
			return getRuleContext(CaseoccContext.class,i);
		}
		public ExprListContext exprList(int i) {
			return getRuleContext(ExprListContext.class,i);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_statement);
		int _la;
		try {
			setState(447);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(389); block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(390); match(SEMICOLUMN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(391); expression(0);
				setState(392); match(SEMICOLUMN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(394); match(T__22);
				setState(395); match(LPAR);
				setState(396); exprList();
				setState(397); match(SEMICOLUMN);
				setState(398); exprList();
				setState(399); match(SEMICOLUMN);
				setState(400); exprList();
				setState(401); match(RPAR);
				setState(402); statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(404); match(T__27);
				setState(405); match(LPAR);
				setState(406); exprList();
				setState(407); match(RPAR);
				setState(408); statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(410); match(T__16);
				setState(411); statement();
				setState(412); match(T__27);
				setState(413); match(LPAR);
				setState(414); exprList();
				setState(415); match(RPAR);
				setState(416); match(SEMICOLUMN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(418); match(T__23);
				setState(419); match(LPAR);
				setState(420); exprList();
				setState(421); match(RPAR);
				setState(422); statement();
				setState(425);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(423); match(T__2);
					setState(424); statement();
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(427); match(T__19);
				setState(428); match(SEMICOLUMN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(429); match(T__15);
				setState(430); match(LPAR);
				setState(431); exprList();
				setState(432); match(RPAR);
				setState(433); match(T__26);
				setState(435); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(434); caseocc();
					}
					}
					setState(437); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__35 || _la==T__12 );
				setState(439); match(T__25);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(441); match(T__29);
				setState(442); match(SEMICOLUMN);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(443); match(T__29);
				setState(444); expression(0);
				setState(445); match(SEMICOLUMN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaseoccContext extends ParserRuleContext {
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CaseoccContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseocc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterCaseocc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitCaseocc(this);
		}
	}

	public final CaseoccContext caseocc() throws RecognitionException {
		CaseoccContext _localctx = new CaseoccContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_caseocc);
		int _la;
		try {
			setState(466);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(449); match(T__12);
				setState(450); expression(0);
				setState(451); match(T__7);
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__27) | (1L << T__26) | (1L << T__23) | (1L << T__22) | (1L << T__19) | (1L << T__16) | (1L << T__15) | (1L << T__5) | (1L << T__3) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
					{
					{
					setState(452); statement();
					}
					}
					setState(457);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 2);
				{
				setState(458); match(T__35);
				setState(459); match(T__7);
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__27) | (1L << T__26) | (1L << T__23) | (1L << T__22) | (1L << T__19) | (1L << T__16) | (1L << T__15) | (1L << T__5) | (1L << T__3) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
					{
					{
					setState(460); statement();
					}
					}
					setState(465);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatesContext extends ParserRuleContext {
		public Set<State> stateset;
		public StateDeclContext s1;
		public StateDeclContext s2;
		public StateDeclContext stateDecl(int i) {
			return getRuleContext(StateDeclContext.class,i);
		}
		public List<StateDeclContext> stateDecl() {
			return getRuleContexts(StateDeclContext.class);
		}
		public StatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterStates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitStates(this);
		}
	}

	public final StatesContext states() throws RecognitionException {
		StatesContext _localctx = new StatesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_states);

			((StatesContext)_localctx).stateset = new HashSet<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468); match(T__33);
			setState(469); ((StatesContext)_localctx).s1 = stateDecl();

				_localctx.stateset.add(((StatesContext)_localctx).s1.state);

			setState(477);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(471); match(COMMA);
				setState(472); ((StatesContext)_localctx).s2 = stateDecl();

					_localctx.stateset.add(((StatesContext)_localctx).s2.state);

				}
				}
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(480); match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateDeclContext extends ParserRuleContext {
		public State state;
		public Token ID;
		public InvariantContext inv;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public InvariantContext invariant() {
			return getRuleContext(InvariantContext.class,0);
		}
		public StateDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterStateDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitStateDecl(this);
		}
	}

	public final StateDeclContext stateDecl() throws RecognitionException {
		StateDeclContext _localctx = new StateDeclContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_stateDecl);
		try {
			setState(491);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(482); ((StateDeclContext)_localctx).ID = match(ID);

						((StateDeclContext)_localctx).state = new State((((StateDeclContext)_localctx).ID!=null?((StateDeclContext)_localctx).ID.getText():null));
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(484); ((StateDeclContext)_localctx).ID = match(ID);
				{
				setState(485); match(T__26);
				setState(486); ((StateDeclContext)_localctx).inv = invariant();
				setState(487); match(T__25);
				}

				 		if(((StateDeclContext)_localctx).inv.inv!=null){
							((StateDeclContext)_localctx).state = new State((((StateDeclContext)_localctx).ID!=null?((StateDeclContext)_localctx).ID.getText():null), ((StateDeclContext)_localctx).inv.inv);
						}
						else{
							((StateDeclContext)_localctx).state = new State((((StateDeclContext)_localctx).ID!=null?((StateDeclContext)_localctx).ID.getText():null), new EmptyInvariant());
						}	
					
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvariantContext extends ParserRuleContext {
		public Invariant inv;
		public Token ID;
		public Token op;
		public ExpressionContext expression;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode GEQ() { return getToken(TAParser.GEQ, 0); }
		public TerminalNode GE() { return getToken(TAParser.GE, 0); }
		public TerminalNode LEQ() { return getToken(TAParser.LEQ, 0); }
		public TerminalNode LE() { return getToken(TAParser.LE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InvariantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterInvariant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitInvariant(this);
		}
	}

	public final InvariantContext invariant() throws RecognitionException {
		InvariantContext _localctx = new InvariantContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_invariant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493); ((InvariantContext)_localctx).ID = match(ID);
			setState(494);
			((InvariantContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE))) != 0)) ) {
				((InvariantContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(495); ((InvariantContext)_localctx).expression = expression(0);

			 		((InvariantContext)_localctx).inv = new ExpInvariant(new Identifier((((InvariantContext)_localctx).ID!=null?((InvariantContext)_localctx).ID.getText():null)), (((InvariantContext)_localctx).op!=null?((InvariantContext)_localctx).op.getText():null), ((InvariantContext)_localctx).expression.exp);
			 	
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitContext extends ParserRuleContext {
		public String initString;
		public Token ID;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitInit(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498); match(T__9);
			setState(499); ((InitContext)_localctx).ID = match(ID);
			setState(500); match(SEMICOLUMN);

				((InitContext)_localctx).initString = (((InitContext)_localctx).ID!=null?((InitContext)_localctx).ID.getText():null);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionsContext extends ParserRuleContext {
		public Set<Transition> transitionsret;
		public TransitionsetContext transitionset;
		public List<TransitionsetContext> transitionset() {
			return getRuleContexts(TransitionsetContext.class);
		}
		public TransitionsetContext transitionset(int i) {
			return getRuleContext(TransitionsetContext.class,i);
		}
		public TransitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterTransitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitTransitions(this);
		}
	}

	public final TransitionsContext transitions() throws RecognitionException {
		TransitionsContext _localctx = new TransitionsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_transitions);
		((TransitionsContext)_localctx).transitionsret = new HashSet<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503); match(T__14);
			setState(504); ((TransitionsContext)_localctx).transitionset = transitionset();

					_localctx.transitionsret.addAll(((TransitionsContext)_localctx).transitionset.transitionsret);
				
			setState(511);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(506); ((TransitionsContext)_localctx).transitionset = transitionset();

						_localctx.transitionsret.addAll(((TransitionsContext)_localctx).transitionset.transitionsret);		
					
				}
				}
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(514); match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionsetContext extends ParserRuleContext {
		public Set<Transition> transitionsret;
		public Token s1;
		public Token s2;
		public TransitionBodyContext transitionBody;
		public Token s3;
		public TransitionBodyContext b2;
		public List<TerminalNode> ID() { return getTokens(TAParser.ID); }
		public List<TransitionBodyContext> transitionBody() {
			return getRuleContexts(TransitionBodyContext.class);
		}
		public TransitionBodyContext transitionBody(int i) {
			return getRuleContext(TransitionBodyContext.class,i);
		}
		public TerminalNode ID(int i) {
			return getToken(TAParser.ID, i);
		}
		public TransitionsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitionset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterTransitionset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitTransitionset(this);
		}
	}

	public final TransitionsetContext transitionset() throws RecognitionException {
		TransitionsetContext _localctx = new TransitionsetContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_transitionset);
		((TransitionsetContext)_localctx).transitionsret = new HashSet<>();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(516); ((TransitionsetContext)_localctx).s1 = match(ID);
			setState(517); match(T__13);
			setState(518); ((TransitionsetContext)_localctx).s2 = match(ID);
			setState(519); ((TransitionsetContext)_localctx).transitionBody = transitionBody();

					_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s2.getText()), ((TransitionsetContext)_localctx).transitionBody.guardexp, ((TransitionsetContext)_localctx).transitionBody.syncexp,  ((TransitionsetContext)_localctx).transitionBody.assignexp));
				
			setState(529);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(521); match(COMMA);
					setState(522); match(T__13);
					setState(523); ((TransitionsetContext)_localctx).s3 = match(ID);
					setState(524); ((TransitionsetContext)_localctx).b2 = ((TransitionsetContext)_localctx).transitionBody = transitionBody();

							_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s3.getText()), ((TransitionsetContext)_localctx).b2.guardexp, ((TransitionsetContext)_localctx).b2.syncexp,  ((TransitionsetContext)_localctx).b2.assignexp));
							
						
					}
					} 
				}
				setState(531);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			setState(551);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(532); match(COMMA);
				setState(533); ((TransitionsetContext)_localctx).s1 = match(ID);
				setState(534); match(T__13);
				setState(535); ((TransitionsetContext)_localctx).s2 = match(ID);
				setState(536); ((TransitionsetContext)_localctx).transitionBody = transitionBody();

						_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s2.getText()), ((TransitionsetContext)_localctx).transitionBody.guardexp, ((TransitionsetContext)_localctx).transitionBody.syncexp,  ((TransitionsetContext)_localctx).transitionBody.assignexp));
					
				setState(546);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(538); match(COMMA);
						setState(539); match(T__13);
						setState(540); ((TransitionsetContext)_localctx).s3 = match(ID);
						setState(541); ((TransitionsetContext)_localctx).b2 = ((TransitionsetContext)_localctx).transitionBody = transitionBody();

								_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s3.getText()), ((TransitionsetContext)_localctx).b2.guardexp, ((TransitionsetContext)_localctx).b2.syncexp,  ((TransitionsetContext)_localctx).b2.assignexp));
								
							
						}
						} 
					}
					setState(548);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				}
				}
				}
				setState(553);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionBodyContext extends ParserRuleContext {
		public Guard guardexp;
		public SyncExpression syncexp;
		public Assign assignexp;
		public GuardContext guard;
		public SyncContext sync;
		public AssignContext assign;
		public SyncContext sync() {
			return getRuleContext(SyncContext.class,0);
		}
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TransitionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterTransitionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitTransitionBody(this);
		}
	}

	public final TransitionBodyContext transitionBody() throws RecognitionException {
		TransitionBodyContext _localctx = new TransitionBodyContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_transitionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554); match(T__26);
			setState(558);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(555); ((TransitionBodyContext)_localctx).guard = guard();

				 			 ((TransitionBodyContext)_localctx).guardexp = ((TransitionBodyContext)_localctx).guard.guardexp;
				 		
				}
			}


					if(_localctx.guardexp==null) {((TransitionBodyContext)_localctx).guardexp = new Guard(new HashSet<VariableConstraintAtom>(), new HashSet<ClockConstraintAtom>());}
					
			{
			setState(561); ((TransitionBodyContext)_localctx).sync = sync();

					((TransitionBodyContext)_localctx).syncexp = ((TransitionBodyContext)_localctx).sync.syncexp;
					
			}
			setState(567);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(564); ((TransitionBodyContext)_localctx).assign = assign();

				 			((TransitionBodyContext)_localctx).assignexp = ((TransitionBodyContext)_localctx).assign.assignexp;
				 		
				}
			}

			setState(569); match(T__25);

					if(_localctx.assignexp==null){ ((TransitionBodyContext)_localctx).assignexp = new Assign(new HashSet<ClockAssignement>(), new HashSet<VariableAssignement>());}
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GuardContext extends ParserRuleContext {
		public Guard guardexp;
		public GuardconditionListContext exp1;
		public GuardconditionListContext guardconditionList;
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public GuardconditionListContext guardconditionList() {
			return getRuleContext(GuardconditionListContext.class,0);
		}
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterGuard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitGuard(this);
		}
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572); match(T__34);
			setState(573); ((GuardContext)_localctx).exp1 = ((GuardContext)_localctx).guardconditionList = guardconditionList();
			setState(574); match(SEMICOLUMN);

				((GuardContext)_localctx).guardexp = new Guard(((GuardContext)_localctx).guardconditionList.variableconst==null? new HashSet<VariableConstraintAtom>() :((GuardContext)_localctx).guardconditionList.variableconst, ((GuardContext)_localctx).guardconditionList.clockconst==null? new HashSet<ClockConstraintAtom>():((GuardContext)_localctx).guardconditionList.clockconst);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GuardconditionListContext extends ParserRuleContext {
		public Set<VariableConstraintAtom> variableconst;
		public Set<ClockConstraintAtom> clockconst;
		public ClockconstraintContext clockconstraint;
		public TerminalNode AND(int i) {
			return getToken(TAParser.AND, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public List<ClockconstraintContext> clockconstraint() {
			return getRuleContexts(ClockconstraintContext.class);
		}
		public List<TerminalNode> AND() { return getTokens(TAParser.AND); }
		public ClockconstraintContext clockconstraint(int i) {
			return getRuleContext(ClockconstraintContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public GuardconditionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardconditionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterGuardconditionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitGuardconditionList(this);
		}
	}

	public final GuardconditionListContext guardconditionList() throws RecognitionException {
		GuardconditionListContext _localctx = new GuardconditionListContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_guardconditionList);

				((GuardconditionListContext)_localctx).variableconst = new HashSet<>();
				((GuardconditionListContext)_localctx).clockconst = new HashSet<>();
			
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577); ((GuardconditionListContext)_localctx).clockconstraint = clockconstraint();

							if(((GuardconditionListContext)_localctx).clockconstraint.clockconst!=null) _localctx.clockconst.add(((GuardconditionListContext)_localctx).clockconstraint.clockconst) ;
							if(((GuardconditionListContext)_localctx).clockconstraint.variableconst!=null) _localctx.variableconst.add(((GuardconditionListContext)_localctx).clockconstraint.variableconst);
						
			setState(589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (AND - 64)) | (1L << (ID - 64)) | (1L << (COMMA - 64)))) != 0)) {
				{
				{
				setState(582);
				switch (_input.LA(1)) {
				case COMMA:
					{
					setState(579); match(COMMA);
					}
					break;
				case ID:
					{
					}
					break;
				case AND:
					{
					setState(581); match(AND);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(584); ((GuardconditionListContext)_localctx).clockconstraint = clockconstraint();

								if(((GuardconditionListContext)_localctx).clockconstraint.clockconst!=null) _localctx.clockconst.add(((GuardconditionListContext)_localctx).clockconstraint.clockconst);
								if(((GuardconditionListContext)_localctx).clockconstraint.variableconst!=null)_localctx.variableconst.add(((GuardconditionListContext)_localctx).clockconstraint.variableconst) ;
							
				}
				}
				setState(591);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClockconstraintContext extends ParserRuleContext {
		public ClockConstraintAtom clockconst;
		public VariableConstraintAtom variableconst;
		public ConstraintAtomContext constraintAtom;
		public ConstraintAtomContext constraintAtom() {
			return getRuleContext(ConstraintAtomContext.class,0);
		}
		public ClockconstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clockconstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterClockconstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitClockconstraint(this);
		}
	}

	public final ClockconstraintContext clockconstraint() throws RecognitionException {
		ClockconstraintContext _localctx = new ClockconstraintContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_clockconstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592); ((ClockconstraintContext)_localctx).constraintAtom = constraintAtom();

							((ClockconstraintContext)_localctx).clockconst = ((ClockconstraintContext)_localctx).constraintAtom.atom;	
							((ClockconstraintContext)_localctx).variableconst = ((ClockconstraintContext)_localctx).constraintAtom.variableAtom;
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintAtomContext extends ParserRuleContext {
		public ClockConstraintAtom atom;
		public VariableConstraintAtom variableAtom;
		public Token id;
		public Token op;
		public Token value;
		public TerminalNode EQCOMP() { return getToken(TAParser.EQCOMP, 0); }
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode GEQ() { return getToken(TAParser.GEQ, 0); }
		public TerminalNode GE() { return getToken(TAParser.GE, 0); }
		public TerminalNode LEQ() { return getToken(TAParser.LEQ, 0); }
		public TerminalNode LE() { return getToken(TAParser.LE, 0); }
		public TerminalNode NAT() { return getToken(TAParser.NAT, 0); }
		public ConstraintAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterConstraintAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitConstraintAtom(this);
		}
	}

	public final ConstraintAtomContext constraintAtom() throws RecognitionException {
		ConstraintAtomContext _localctx = new ConstraintAtomContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_constraintAtom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595); ((ConstraintAtomContext)_localctx).id = match(ID);
			setState(596);
			((ConstraintAtomContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE) | (1L << EQCOMP))) != 0)) ) {
				((ConstraintAtomContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(597); ((ConstraintAtomContext)_localctx).value = match(NAT);

					
					if(declarations==null){
						throw new InternalError("The set of the declarations cannot be null");	
					}
					String identifier=(((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null);
					if(!declarations.containsKey((((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)) && 
					!boundedVariablesValues.containsKey((((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)) &&
					(currentTaDeclarations==null || !currentTaDeclarations.containsKey((((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)))){
						throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Variable: "+(((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)+" not defined");
					}
					
					
					if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("clock")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("clock"))){
						((ConstraintAtomContext)_localctx).atom = new ClockConstraintAtom(new Clock((((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)), ClockConstraintAtomOperator.parse((((ConstraintAtomContext)_localctx).op!=null?((ConstraintAtomContext)_localctx).op.getText():null)), Integer.parseInt((((ConstraintAtomContext)_localctx).value!=null?((ConstraintAtomContext)_localctx).value.getText():null)));
					}
					if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("int")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("int"))){

						((ConstraintAtomContext)_localctx).variableAtom = new VariableConstraintAtom(new Variable((((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)), VariableConstraintAtomOperator.parse((((ConstraintAtomContext)_localctx).op!=null?((ConstraintAtomContext)_localctx).op.getText():null)), Integer.parseInt((((ConstraintAtomContext)_localctx).value!=null?((ConstraintAtomContext)_localctx).value.getText():null)));
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SyncContext extends ParserRuleContext {
		public SyncExpression syncexp;
		public Token exp2;
		public Token op;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public SyncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sync; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterSync(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitSync(this);
		}
	}

	public final SyncContext sync() throws RecognitionException {
		SyncContext _localctx = new SyncContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_sync);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				{
				setState(600); match(T__37);
				setState(601); ((SyncContext)_localctx).exp2 = match(ID);
				setState(602);
				((SyncContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__3) ) {
					((SyncContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(603); match(SEMICOLUMN);
				}

				 		if((((SyncContext)_localctx).op!=null?((SyncContext)_localctx).op.getText():null).equals("!") || (((SyncContext)_localctx).op!=null?((SyncContext)_localctx).op.getText():null).equals("?")){
				 				((SyncContext)_localctx).syncexp = new SyncExpression((((SyncContext)_localctx).exp2!=null?((SyncContext)_localctx).exp2.getText():null), (((SyncContext)_localctx).op!=null?((SyncContext)_localctx).op.getText():null));		
				 		}
				 		else{
				 			((SyncContext)_localctx).syncexp = new SyncExpression("tau"+TAU_COUNTER, "TAU");
				 			TAU_COUNTER++;
				 		}
					
				}
				break;
			case 2:
				{
				{
				setState(606); match(T__37);
				setState(607); ((SyncContext)_localctx).exp2 = match(ID);
				setState(608); match(SEMICOLUMN);
				}

				 			((SyncContext)_localctx).syncexp = new SyncExpression("tau"+TAU_COUNTER, "TAU");
				 			TAU_COUNTER++;
				 	
				}
				break;
			case 3:
				{

				 			((SyncContext)_localctx).syncexp = new SyncExpression("tau"+TAU_COUNTER, "TAU");
				 			TAU_COUNTER++;
				 	
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public Assign assignexp;
		public AssignmentListContext expl;
		public AssignmentListContext assignmentList;
		public AssignmentListContext assignmentList() {
			return getRuleContext(AssignmentListContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614); match(T__11);
			setState(615); ((AssignContext)_localctx).expl = ((AssignContext)_localctx).assignmentList = assignmentList();
			setState(616); match(SEMICOLUMN);

				((AssignContext)_localctx).assignexp = new Assign(((AssignContext)_localctx).assignmentList.clockassignement, ((AssignContext)_localctx).assignmentList.variableassignement);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentListContext extends ParserRuleContext {
		public Set<ClockAssignement> clockassignement;
		public Set<VariableAssignement> variableassignement;
		public AssignmentContext assignment;
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public AssignmentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterAssignmentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitAssignmentList(this);
		}
	}

	public final AssignmentListContext assignmentList() throws RecognitionException {
		AssignmentListContext _localctx = new AssignmentListContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_assignmentList);

			((AssignmentListContext)_localctx).clockassignement = new HashSet<>();
			((AssignmentListContext)_localctx).variableassignement = new HashSet<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(619); ((AssignmentListContext)_localctx).assignment = assignment();

				 		if(((AssignmentListContext)_localctx).assignment.clockassignementsret!=null){
				 			_localctx.clockassignement.add(((AssignmentListContext)_localctx).assignment.clockassignementsret);
				 		}
				 		if(((AssignmentListContext)_localctx).assignment.variableAssignementret!=null){
				 			_localctx.variableassignement.add(((AssignmentListContext)_localctx).assignment.variableAssignementret);
				 		}
				 	
			}
			setState(628);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				{
				setState(622); match(COMMA);
				setState(623); ((AssignmentListContext)_localctx).assignment = assignment();

								if(((AssignmentListContext)_localctx).assignment.clockassignementsret!=null){
					 			_localctx.clockassignement.add(((AssignmentListContext)_localctx).assignment.clockassignementsret);
					 		}
					 		if(((AssignmentListContext)_localctx).assignment.variableAssignementret!=null){
					 			_localctx.variableassignement.add(((AssignmentListContext)_localctx).assignment.variableAssignementret);
					 		}
						
				}
				}
				}
				setState(630);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public ClockAssignement clockassignementsret;
		public VariableAssignement variableAssignementret;
		public Token id;
		public Token op;
		public Token nat;
		public ExprStatementContext exprStatement;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode EQASSIGN() { return getToken(TAParser.EQASSIGN, 0); }
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public ExprStatementContext exprStatement() {
			return getRuleContext(ExprStatementContext.class,0);
		}
		public TerminalNode NAT() { return getToken(TAParser.NAT, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_assignment);
		int _la;
		try {
			setState(642);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(631); ((AssignmentContext)_localctx).id = match(ID);
				setState(632);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQASSIGN || _la==EQ) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(633); ((AssignmentContext)_localctx).nat = match(NAT);
				}

				 			if(declarations==null){
							throw new InternalError("The set of the declarations cannot be null");	
						}
						String identifier=(((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null);
						if(!declarations.containsKey((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)) && (currentTaDeclarations==null || !currentTaDeclarations.containsKey((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)))){
							throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Variable:"+(((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)+" not defined");
						}
						if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("clock")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("clock"))){
							((AssignmentContext)_localctx).clockassignementsret = new ClockAssignement(new Clock((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)), new Value((((AssignmentContext)_localctx).nat!=null?((AssignmentContext)_localctx).nat.getText():null)));
						}
						if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("int")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("int"))){
							((AssignmentContext)_localctx).variableAssignementret = new VariableAssignement(new Variable((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)), new Value((((AssignmentContext)_localctx).nat!=null?((AssignmentContext)_localctx).nat.getText():null)));
						}
				 	
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(636); ((AssignmentContext)_localctx).id = match(ID);
				setState(637);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQASSIGN || _la==EQ) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(638); ((AssignmentContext)_localctx).exprStatement = exprStatement();
				}

				 		if(declarations==null){
							throw new InternalError("The set of the declarations cannot be null");	
						}
						String identifier=(((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null);
						if(!declarations.containsKey((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)) && (currentTaDeclarations==null || !currentTaDeclarations.containsKey((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)))){
							throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Variable:"+(((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)+" not defined");
						}
						if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("clock")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("clock"))){
							throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Clock:"+(((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)+" cannot be assigned to an expression but only to an integer value");
						}
						if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("int")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("int"))){
							((AssignmentContext)_localctx).variableAssignementret = new VariableAssignement(new Variable((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)),  ((AssignmentContext)_localctx).exprStatement.exp);
						}
				 		
				 		
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleassigmentContext extends ParserRuleContext {
		public ClockAssignement assignementsret;
		public Token id;
		public Token op;
		public Token nat;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public TerminalNode NAT() { return getToken(TAParser.NAT, 0); }
		public SimpleassigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleassigment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterSimpleassigment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitSimpleassigment(this);
		}
	}

	public final SimpleassigmentContext simpleassigment() throws RecognitionException {
		SimpleassigmentContext _localctx = new SimpleassigmentContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_simpleassigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(644); ((SimpleassigmentContext)_localctx).id = match(ID);
			setState(645); ((SimpleassigmentContext)_localctx).op = match(EQ);
			setState(646); ((SimpleassigmentContext)_localctx).nat = match(NAT);
			}
			((SimpleassigmentContext)_localctx).assignementsret = new ClockAssignement(
			 						new Clock((((SimpleassigmentContext)_localctx).id!=null?((SimpleassigmentContext)_localctx).id.getText():null)),
			 						new Value((((SimpleassigmentContext)_localctx).nat!=null?((SimpleassigmentContext)_localctx).nat.getText():null))
			 					);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<Expression> exprListret;
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitExprList(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_exprList);
		((ExprListContext)_localctx).exprListret = new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650); ((ExprListContext)_localctx).exp1 = expression(0);

				_localctx.exprListret.add(((ExprListContext)_localctx).exp1.exp);

			setState(658);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(652); match(COMMA);
				setState(653); ((ExprListContext)_localctx).exp2 = expression(0);

					_localctx.exprListret.add(((ExprListContext)_localctx).exp2.exp);
					
				}
				}
				setState(660);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprStatementContext extends ParserRuleContext {
		public Expression exp;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterExprStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitExprStatement(this);
		}
	}

	public final ExprStatementContext exprStatement() throws RecognitionException {
		ExprStatementContext _localctx = new ExprStatementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_exprStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(661); ((ExprStatementContext)_localctx).expression = expression(0);

				((ExprStatementContext)_localctx).exp = ((ExprStatementContext)_localctx).expression.exp;

			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression exp;
		public ExpressionContext exp1;
		public Token op;
		public Token ID;
		public Token NAT;
		public ExpressionContext exp2;
		public ExpressionContext exp3;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode FRACT() { return getToken(TAParser.FRACT, 0); }
		public TerminalNode BITOREQ() { return getToken(TAParser.BITOREQ, 0); }
		public TerminalNode MINUSMINUS() { return getToken(TAParser.MINUSMINUS, 0); }
		public TerminalNode EQCOMP() { return getToken(TAParser.EQCOMP, 0); }
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode GEQ() { return getToken(TAParser.GEQ, 0); }
		public TerminalNode PLUSPLUS() { return getToken(TAParser.PLUSPLUS, 0); }
		public TerminalNode LEQ() { return getToken(TAParser.LEQ, 0); }
		public TerminalNode BITANDEQ() { return getToken(TAParser.BITANDEQ, 0); }
		public TerminalNode AND() { return getToken(TAParser.AND, 0); }
		public TerminalNode FRACTEQ() { return getToken(TAParser.FRACTEQ, 0); }
		public TerminalNode NAT() { return getToken(TAParser.NAT, 0); }
		public TerminalNode MINUSEQ() { return getToken(TAParser.MINUSEQ, 0); }
		public TerminalNode POW() { return getToken(TAParser.POW, 0); }
		public TerminalNode COLUMEQ() { return getToken(TAParser.COLUMEQ, 0); }
		public TerminalNode GE() { return getToken(TAParser.GE, 0); }
		public TerminalNode NEQ() { return getToken(TAParser.NEQ, 0); }
		public TerminalNode MULT() { return getToken(TAParser.MULT, 0); }
		public TerminalNode LE() { return getToken(TAParser.LE, 0); }
		public TerminalNode BITOR() { return getToken(TAParser.BITOR, 0); }
		public TerminalNode MOD() { return getToken(TAParser.MOD, 0); }
		public TerminalNode OR() { return getToken(TAParser.OR, 0); }
		public TerminalNode PLUSEQ() { return getToken(TAParser.PLUSEQ, 0); }
		public TerminalNode MULTEQ() { return getToken(TAParser.MULTEQ, 0); }
		public TerminalNode BITAND() { return getToken(TAParser.BITAND, 0); }
		public TerminalNode MODEQ() { return getToken(TAParser.MODEQ, 0); }
		public TerminalNode PLUS() { return getToken(TAParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TAParser.MINUS, 0); }
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode POWEQ() { return getToken(TAParser.POWEQ, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 88;
		enterRecursionRule(_localctx, 88, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			switch (_input.LA(1)) {
			case PLUS:
			case PLUSPLUS:
			case MINUSMINUS:
			case MINUS:
				{
				setState(665);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0)) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(666); ((ExpressionContext)_localctx).exp1 = expression(13);

				    	((ExpressionContext)_localctx).exp = new LeftUnaryOperator((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp1.exp);
				    
				}
				break;
			case T__5:
			case T__3:
				{
				setState(669);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__5 || _la==T__3) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(670); ((ExpressionContext)_localctx).exp1 = expression(12);

				    	((ExpressionContext)_localctx).exp = new LeftUnaryOperator((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp1.exp);
				    
				}
				break;
			case ID:
				{
				setState(673); ((ExpressionContext)_localctx).ID = match(ID);

						((ExpressionContext)_localctx).exp = new Identifier((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
					
				}
				break;
			case NAT:
				{
				setState(675); ((ExpressionContext)_localctx).NAT = match(NAT);

						((ExpressionContext)_localctx).exp = new Value((((ExpressionContext)_localctx).NAT!=null?((ExpressionContext)_localctx).NAT.getText():null));
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(741);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(739);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(679);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(680);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << FRACT) | (1L << MOD))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(681); ((ExpressionContext)_localctx).exp2 = expression(12);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(684);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(685);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(686); ((ExpressionContext)_localctx).exp2 = expression(11);

						              		BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              		((ExpressionContext)_localctx).exp = exp;
						              	
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(689);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(690);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(691); ((ExpressionContext)_localctx).exp2 = expression(10);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(694);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(695);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQCOMP || _la==NEQ) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(696); ((ExpressionContext)_localctx).exp2 = expression(9);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(699);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(700); ((ExpressionContext)_localctx).op = match(BITAND);
						setState(701); ((ExpressionContext)_localctx).exp2 = expression(8);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(704);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(705); ((ExpressionContext)_localctx).op = match(POW);
						setState(706); ((ExpressionContext)_localctx).exp2 = expression(7);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(709);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(710); ((ExpressionContext)_localctx).op = match(BITOR);
						setState(711); ((ExpressionContext)_localctx).exp2 = expression(6);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(714);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(715); ((ExpressionContext)_localctx).op = match(AND);
						setState(716); ((ExpressionContext)_localctx).exp2 = expression(5);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(719);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(720); ((ExpressionContext)_localctx).op = match(OR);
						setState(721); ((ExpressionContext)_localctx).exp2 = expression(4);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(724);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(725); match(T__21);
						setState(726); ((ExpressionContext)_localctx).exp2 = expression(0);
						setState(727); match(T__7);
						setState(728); ((ExpressionContext)_localctx).exp3 = expression(3);

						              	((ExpressionContext)_localctx).exp = new TernaryExpression(((ExpressionContext)_localctx).exp1.exp, ((ExpressionContext)_localctx).exp2.exp, ((ExpressionContext)_localctx).exp3.exp);
						              
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(731);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(732);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__28 - 10)) | (1L << (T__24 - 10)) | (1L << (T__6 - 10)) | (1L << (EQ - 10)) | (1L << (FRACTEQ - 10)) | (1L << (MODEQ - 10)) | (1L << (PLUSEQ - 10)) | (1L << (MINUSEQ - 10)) | (1L << (COLUMEQ - 10)) | (1L << (MULTEQ - 10)) | (1L << (POWEQ - 10)) | (1L << (BITANDEQ - 10)) | (1L << (BITOREQ - 10)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(733); ((ExpressionContext)_localctx).exp2 = expression(2);

						              	((ExpressionContext)_localctx).exp = new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp2.exp);
						              
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(736);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(737);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUSPLUS || _la==MINUSMINUS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();

						                ((ExpressionContext)_localctx).exp = new RightUnaryOperator(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						              
						}
						break;
					}
					} 
				}
				setState(743);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DeclarationidContext extends ParserRuleContext {
		public Expression exp;
		public Token ID;
		public Token op;
		public ExpressionContext expr;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLUMEQ() { return getToken(TAParser.COLUMEQ, 0); }
		public DeclarationidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterDeclarationid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitDeclarationid(this);
		}
	}

	public final DeclarationidContext declarationid() throws RecognitionException {
		DeclarationidContext _localctx = new DeclarationidContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_declarationid);
		try {
			setState(756);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(744); ((DeclarationidContext)_localctx).ID = match(ID);
				setState(745); ((DeclarationidContext)_localctx).op = match(EQ);
				setState(746); ((DeclarationidContext)_localctx).expr = expression(0);
				}
				((DeclarationidContext)_localctx).exp = new AssignementExpression(
				 						new Identifier((((DeclarationidContext)_localctx).ID!=null?((DeclarationidContext)_localctx).ID.getText():null)),
				 						(((DeclarationidContext)_localctx).op!=null?((DeclarationidContext)_localctx).op.getText():null), 
				 						((DeclarationidContext)_localctx).expr.exp
				 					);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(750); ((DeclarationidContext)_localctx).ID = match(ID);
				setState(751); ((DeclarationidContext)_localctx).op = match(COLUMEQ);
				setState(752); ((DeclarationidContext)_localctx).expr = expression(0);
				}
				((DeclarationidContext)_localctx).exp = new AssignementExpression(
				 						 new Identifier((((DeclarationidContext)_localctx).ID!=null?((DeclarationidContext)_localctx).ID.getText():null)),
				 						(((DeclarationidContext)_localctx).op!=null?((DeclarationidContext)_localctx).op.getText():null),
				 						((DeclarationidContext)_localctx).expr.exp
				 					);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public List<Expression> args;
		public ExpressionContext expression;
		public ArgListContext argList;
		public List<ArgListContext> argList() {
			return getRuleContexts(ArgListContext.class);
		}
		public ArgListContext argList(int i) {
			return getRuleContext(ArgListContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitArgList(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_argList);

						     ((ArgListContext)_localctx).args =  new ArrayList<Expression>();
					
		try {
			int _alt;
			setState(769);
			switch (_input.LA(1)) {
			case T__5:
			case T__3:
			case PLUS:
			case PLUSPLUS:
			case MINUSMINUS:
			case MINUS:
			case ID:
			case NAT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(758); ((ArgListContext)_localctx).expression = expression(0);
				setState(763);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(759); match(COMMA);
						setState(760); ((ArgListContext)_localctx).argList = argList();
						}
						} 
					}
					setState(765);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				}
				}

								_localctx.args.add(((ArgListContext)_localctx).expression.exp);
								_localctx.args.addAll(_localctx.args);
							
				}
				break;
			case RPAR:
			case COMMA:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 44: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 11);
		case 1: return precpred(_ctx, 10);
		case 2: return precpred(_ctx, 9);
		case 3: return precpred(_ctx, 8);
		case 4: return precpred(_ctx, 7);
		case 5: return precpred(_ctx, 6);
		case 6: return precpred(_ctx, 5);
		case 7: return precpred(_ctx, 4);
		case 8: return precpred(_ctx, 3);
		case 9: return precpred(_ctx, 2);
		case 10: return precpred(_ctx, 1);
		case 11: return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3U\u0306\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\7\2d\n\2\f\2\16\2g\13\2\3"+
		"\2\7\2j\n\2\f\2\16\2m\13\2\3\2\6\2p\n\2\r\2\16\2q\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0082\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5\u0090\n\5\f\5\16\5\u0093\13\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\7\6\u009b\n\6\f\6\16\6\u009e\13\6\3\6\3\6\5\6\u00a2\n"+
		"\6\3\7\3\7\5\7\u00a6\n\7\3\7\3\7\7\7\u00aa\n\7\f\7\16\7\u00ad\13\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7"+
		"\t\u00c1\n\t\f\t\16\t\u00c4\13\t\3\t\3\t\5\t\u00c8\n\t\3\t\5\t\u00cb\n"+
		"\t\3\t\3\t\3\t\5\t\u00d0\n\t\3\t\3\t\3\n\3\n\7\n\u00d6\n\n\f\n\16\n\u00d9"+
		"\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00e2\n\n\f\n\16\n\u00e5\13\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u00ed\n\n\3\n\3\n\3\13\3\13\7\13\u00f3\n\13"+
		"\f\13\16\13\u00f6\13\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00fe\n\13"+
		"\f\13\16\13\u0101\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u010b\n"+
		"\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u0114\n\16\3\16\3\16\3\16\3\16"+
		"\6\16\u011a\n\16\r\16\16\16\u011b\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\5\16\u0129\n\16\5\16\u012b\n\16\3\17\3\17\7\17\u012f"+
		"\n\17\f\17\16\17\u0132\13\17\3\20\5\20\u0135\n\20\3\20\5\20\u0138\n\20"+
		"\3\20\5\20\u013b\n\20\5\20\u013d\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u0150\n\24"+
		"\f\24\16\24\u0153\13\24\3\25\3\25\3\25\3\25\3\25\7\25\u015a\n\25\f\25"+
		"\16\25\u015d\13\25\3\25\3\25\3\26\3\26\7\26\u0163\n\26\f\26\16\26\u0166"+
		"\13\26\3\27\3\27\3\27\3\27\7\27\u016c\n\27\f\27\16\27\u016f\13\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u017b\n\31\f\31\16"+
		"\31\u017e\13\31\3\31\7\31\u0181\n\31\f\31\16\31\u0184\13\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u01ac\n\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\6\32\u01b6\n\32\r\32\16\32\u01b7\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\5\32\u01c2\n\32\3\33\3\33\3\33\3\33\7\33"+
		"\u01c8\n\33\f\33\16\33\u01cb\13\33\3\33\3\33\3\33\7\33\u01d0\n\33\f\33"+
		"\16\33\u01d3\13\33\5\33\u01d5\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\7\34\u01de\n\34\f\34\16\34\u01e1\13\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\5\35\u01ee\n\35\3\36\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \7 \u0200\n \f \16 \u0203\13 \3"+
		" \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0212\n!\f!\16!\u0215\13!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0223\n!\f!\16!\u0226\13!\7!\u0228"+
		"\n!\f!\16!\u022b\13!\3\"\3\"\3\"\3\"\5\"\u0231\n\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\5\"\u023a\n\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\5$\u0249"+
		"\n$\3$\3$\3$\7$\u024e\n$\f$\16$\u0251\13$\3%\3%\3%\3&\3&\3&\3&\3&\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0267\n\'\3(\3(\3(\3"+
		"(\3(\3)\3)\3)\3)\3)\3)\3)\7)\u0275\n)\f)\16)\u0278\13)\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\3*\3*\3*\5*\u0285\n*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\7,"+
		"\u0293\n,\f,\16,\u0296\13,\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\5.\u02a8\n.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\7.\u02e6\n"+
		".\f.\16.\u02e9\13.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u02f7\n/\3\60"+
		"\3\60\3\60\7\60\u02fc\n\60\f\60\16\60\u02ff\13\60\3\60\3\60\3\60\5\60"+
		"\u0304\n\60\3\60\2\3Z\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^\2\r\3\2),\3\2)-\4\2\23\23%%\3\2/"+
		"\60\3\2\63\66\4\2##%%\4\2\67\67=>\4\2\63\63\66\66\3\2-.\b\2\f\f\20\20"+
		"\"\"\60\628<EF\3\2\64\65\u0333\2e\3\2\2\2\4\u0081\3\2\2\2\6\u0083\3\2"+
		"\2\2\b\u008b\3\2\2\2\n\u00a1\3\2\2\2\f\u00a3\3\2\2\2\16\u00ae\3\2\2\2"+
		"\20\u00b7\3\2\2\2\22\u00d3\3\2\2\2\24\u00f0\3\2\2\2\26\u0104\3\2\2\2\30"+
		"\u010c\3\2\2\2\32\u012a\3\2\2\2\34\u012c\3\2\2\2\36\u013c\3\2\2\2 \u013e"+
		"\3\2\2\2\"\u0144\3\2\2\2$\u0148\3\2\2\2&\u014c\3\2\2\2(\u0154\3\2\2\2"+
		"*\u0160\3\2\2\2,\u0167\3\2\2\2.\u0172\3\2\2\2\60\u0177\3\2\2\2\62\u01c1"+
		"\3\2\2\2\64\u01d4\3\2\2\2\66\u01d6\3\2\2\28\u01ed\3\2\2\2:\u01ef\3\2\2"+
		"\2<\u01f4\3\2\2\2>\u01f9\3\2\2\2@\u0206\3\2\2\2B\u022c\3\2\2\2D\u023e"+
		"\3\2\2\2F\u0243\3\2\2\2H\u0252\3\2\2\2J\u0255\3\2\2\2L\u0266\3\2\2\2N"+
		"\u0268\3\2\2\2P\u026d\3\2\2\2R\u0284\3\2\2\2T\u0286\3\2\2\2V\u028c\3\2"+
		"\2\2X\u0297\3\2\2\2Z\u02a7\3\2\2\2\\\u02f6\3\2\2\2^\u0303\3\2\2\2`a\5"+
		"\4\3\2ab\b\2\1\2bd\3\2\2\2c`\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fk\3"+
		"\2\2\2ge\3\2\2\2hj\5\6\4\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2lo\3"+
		"\2\2\2mk\3\2\2\2np\5\b\5\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3"+
		"\2\2\2st\7\2\2\3tu\b\2\1\2u\3\3\2\2\2vw\5\22\n\2wx\b\3\1\2x\u0082\3\2"+
		"\2\2y\u0082\5.\30\2z{\5\24\13\2{|\b\3\1\2|\u0082\3\2\2\2}\u0082\5(\25"+
		"\2~\177\5\16\b\2\177\u0080\b\3\1\2\u0080\u0082\3\2\2\2\u0081v\3\2\2\2"+
		"\u0081y\3\2\2\2\u0081z\3\2\2\2\u0081}\3\2\2\2\u0081~\3\2\2\2\u0082\5\3"+
		"\2\2\2\u0083\u0084\7N\2\2\u0084\u0085\5\\/\2\u0085\u0086\7N\2\2\u0086"+
		"\u0087\7H\2\2\u0087\u0088\5^\60\2\u0088\u0089\7I\2\2\u0089\u008a\7L\2"+
		"\2\u008a\7\3\2\2\2\u008b\u008c\7\24\2\2\u008c\u0091\7N\2\2\u008d\u008e"+
		"\7S\2\2\u008e\u0090\7N\2\2\u008f\u008d\3\2\2\2\u0090\u0093\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0094\u0095\7L\2\2\u0095\t\3\2\2\2\u0096\u0097\7H\2\2\u0097\u009c"+
		"\5\f\7\2\u0098\u0099\7S\2\2\u0099\u009b\5\f\7\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2"+
		"\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7I\2\2\u00a0\u00a2\3\2\2\2\u00a1"+
		"\u0096\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\13\3\2\2\2\u00a3\u00a5\5\32\16"+
		"\2\u00a4\u00a6\7D\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00ab\7N\2\2\u00a8\u00aa\5\30\r\2\u00a9\u00a8\3\2\2\2\u00aa"+
		"\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\r\3\2\2\2"+
		"\u00ad\u00ab\3\2\2\2\u00ae\u00af\7\b\2\2\u00af\u00b0\7N\2\2\u00b0\u00b1"+
		"\b\b\1\2\u00b1\u00b2\5\n\6\2\u00b2\u00b3\7\16\2\2\u00b3\u00b4\5\20\t\2"+
		"\u00b4\u00b5\7\17\2\2\u00b5\u00b6\b\b\1\2\u00b6\17\3\2\2\2\u00b7\u00c2"+
		"\b\t\1\2\u00b8\u00c1\5.\30\2\u00b9\u00ba\5\24\13\2\u00ba\u00bb\b\t\1\2"+
		"\u00bb\u00c1\3\2\2\2\u00bc\u00bd\5\22\n\2\u00bd\u00be\b\t\1\2\u00be\u00c1"+
		"\3\2\2\2\u00bf\u00c1\5(\25\2\u00c0\u00b8\3\2\2\2\u00c0\u00b9\3\2\2\2\u00c0"+
		"\u00bc\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5"+
		"\u00c7\5\66\34\2\u00c6\u00c8\5\"\22\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8"+
		"\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00cb\5$\23\2\u00ca\u00c9\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\5<\37\2\u00cd\u00cf\b\t"+
		"\1\2\u00ce\u00d0\5> \2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\u00d2\b\t\1\2\u00d2\21\3\2\2\2\u00d3\u00d7\5\32\16\2\u00d4"+
		"\u00d6\5\30\r\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3"+
		"\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da"+
		"\u00db\7N\2\2\u00db\u00dc\7\16\2\2\u00dc\u00dd\7O\2\2\u00dd\u00e3\b\n"+
		"\1\2\u00de\u00df\7S\2\2\u00df\u00e0\7O\2\2\u00e0\u00e2\b\n\1\2\u00e1\u00de"+
		"\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7\7\17\2\2\u00e7\u00ec\b"+
		"\n\1\2\u00e8\u00e9\7\60\2\2\u00e9\u00ea\5Z.\2\u00ea\u00eb\b\n\1\2\u00eb"+
		"\u00ed\3\2\2\2\u00ec\u00e8\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2"+
		"\2\2\u00ee\u00ef\7L\2\2\u00ef\23\3\2\2\2\u00f0\u00f4\5\32\16\2\u00f1\u00f3"+
		"\5\30\r\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2"+
		"\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8"+
		"\5\26\f\2\u00f8\u00ff\b\13\1\2\u00f9\u00fa\7S\2\2\u00fa\u00fb\5\26\f\2"+
		"\u00fb\u00fc\b\13\1\2\u00fc\u00fe\3\2\2\2\u00fd\u00f9\3\2\2\2\u00fe\u0101"+
		"\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0102\u0103\7L\2\2\u0103\25\3\2\2\2\u0104\u0105\7N\2\2"+
		"\u0105\u010a\b\f\1\2\u0106\u0107\7\60\2\2\u0107\u0108\5Z.\2\u0108\u0109"+
		"\b\f\1\2\u0109\u010b\3\2\2\2\u010a\u0106\3\2\2\2\u010a\u010b\3\2\2\2\u010b"+
		"\27\3\2\2\2\u010c\u010d\7J\2\2\u010d\u010e\5Z.\2\u010e\u010f\7K\2\2\u010f"+
		"\31\3\2\2\2\u0110\u0111\5\36\20\2\u0111\u0113\7N\2\2\u0112\u0114\5 \21"+
		"\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u012b\3\2\2\2\u0115\u0116"+
		"\5\36\20\2\u0116\u0117\7(\2\2\u0117\u0119\7\16\2\2\u0118\u011a\5,\27\2"+
		"\u0119\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\7\17\2\2\u011e\u012b\3\2\2\2"+
		"\u011f\u0128\5\36\20\2\u0120\u0121\7\26\2\2\u0121\u0129\b\16\1\2\u0122"+
		"\u0123\7\27\2\2\u0123\u0129\b\16\1\2\u0124\u0125\7\n\2\2\u0125\u0129\b"+
		"\16\1\2\u0126\u0127\7$\2\2\u0127\u0129\b\16\1\2\u0128\u0120\3\2\2\2\u0128"+
		"\u0122\3\2\2\2\u0128\u0124\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012b\3\2"+
		"\2\2\u012a\u0110\3\2\2\2\u012a\u0115\3\2\2\2\u012a\u011f\3\2\2\2\u012b"+
		"\33\3\2\2\2\u012c\u0130\7N\2\2\u012d\u012f\5\30\r\2\u012e\u012d\3\2\2"+
		"\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\35"+
		"\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0135\7 \2\2\u0134\u0133\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0138\7\4\2\2\u0137\u0136\3\2"+
		"\2\2\u0137\u0138\3\2\2\2\u0138\u013d\3\2\2\2\u0139\u013b\7\36\2\2\u013a"+
		"\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u0134\3\2"+
		"\2\2\u013c\u013a\3\2\2\2\u013d\37\3\2\2\2\u013e\u013f\7J\2\2\u013f\u0140"+
		"\7O\2\2\u0140\u0141\7S\2\2\u0141\u0142\7O\2\2\u0142\u0143\7K\2\2\u0143"+
		"!\3\2\2\2\u0144\u0145\7\t\2\2\u0145\u0146\5&\24\2\u0146\u0147\7L\2\2\u0147"+
		"#\3\2\2\2\u0148\u0149\7 \2\2\u0149\u014a\5&\24\2\u014a\u014b\7L\2\2\u014b"+
		"%\3\2\2\2\u014c\u0151\7N\2\2\u014d\u014e\7S\2\2\u014e\u0150\7N\2\2\u014f"+
		"\u014d\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2"+
		"\2\2\u0152\'\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0155\7\'\2\2\u0155\u0156"+
		"\5\32\16\2\u0156\u015b\5*\26\2\u0157\u0158\7S\2\2\u0158\u015a\5*\26\2"+
		"\u0159\u0157\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c"+
		"\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\7L\2\2\u015f"+
		")\3\2\2\2\u0160\u0164\7N\2\2\u0161\u0163\5\30\r\2\u0162\u0161\3\2\2\2"+
		"\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165+\3"+
		"\2\2\2\u0166\u0164\3\2\2\2\u0167\u0168\5\32\16\2\u0168\u016d\5\34\17\2"+
		"\u0169\u016a\7S\2\2\u016a\u016c\5\34\17\2\u016b\u0169\3\2\2\2\u016c\u016f"+
		"\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0170\3\2\2\2\u016f"+
		"\u016d\3\2\2\2\u0170\u0171\7L\2\2\u0171-\3\2\2\2\u0172\u0173\5\32\16\2"+
		"\u0173\u0174\7N\2\2\u0174\u0175\5\n\6\2\u0175\u0176\5\60\31\2\u0176/\3"+
		"\2\2\2\u0177\u017c\7\16\2\2\u0178\u017b\5\24\13\2\u0179\u017b\5(\25\2"+
		"\u017a\u0178\3\2\2\2\u017a\u0179\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a"+
		"\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u0182\3\2\2\2\u017e\u017c\3\2\2\2\u017f"+
		"\u0181\5\62\32\2\u0180\u017f\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3"+
		"\2\2\2\u0182\u0183\3\2\2\2\u0183\u0185\3\2\2\2\u0184\u0182\3\2\2\2\u0185"+
		"\u0186\7\17\2\2\u0186\61\3\2\2\2\u0187\u01c2\5\60\31\2\u0188\u01c2\7L"+
		"\2\2\u0189\u018a\5Z.\2\u018a\u018b\7L\2\2\u018b\u01c2\3\2\2\2\u018c\u018d"+
		"\7\22\2\2\u018d\u018e\7H\2\2\u018e\u018f\5V,\2\u018f\u0190\7L\2\2\u0190"+
		"\u0191\5V,\2\u0191\u0192\7L\2\2\u0192\u0193\5V,\2\u0193\u0194\7I\2\2\u0194"+
		"\u0195\5\62\32\2\u0195\u01c2\3\2\2\2\u0196\u0197\7\r\2\2\u0197\u0198\7"+
		"H\2\2\u0198\u0199\5V,\2\u0199\u019a\7I\2\2\u019a\u019b\5\62\32\2\u019b"+
		"\u01c2\3\2\2\2\u019c\u019d\7\30\2\2\u019d\u019e\5\62\32\2\u019e\u019f"+
		"\7\r\2\2\u019f\u01a0\7H\2\2\u01a0\u01a1\5V,\2\u01a1\u01a2\7I\2\2\u01a2"+
		"\u01a3\7L\2\2\u01a3\u01c2\3\2\2\2\u01a4\u01a5\7\21\2\2\u01a5\u01a6\7H"+
		"\2\2\u01a6\u01a7\5V,\2\u01a7\u01a8\7I\2\2\u01a8\u01ab\5\62\32\2\u01a9"+
		"\u01aa\7&\2\2\u01aa\u01ac\5\62\32\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3"+
		"\2\2\2\u01ac\u01c2\3\2\2\2\u01ad\u01ae\7\25\2\2\u01ae\u01c2\7L\2\2\u01af"+
		"\u01b0\7\31\2\2\u01b0\u01b1\7H\2\2\u01b1\u01b2\5V,\2\u01b2\u01b3\7I\2"+
		"\2\u01b3\u01b5\7\16\2\2\u01b4\u01b6\5\64\33\2\u01b5\u01b4\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\3\2"+
		"\2\2\u01b9\u01ba\7\17\2\2\u01ba\u01c2\3\2\2\2\u01bb\u01bc\7\13\2\2\u01bc"+
		"\u01c2\7L\2\2\u01bd\u01be\7\13\2\2\u01be\u01bf\5Z.\2\u01bf\u01c0\7L\2"+
		"\2\u01c0\u01c2\3\2\2\2\u01c1\u0187\3\2\2\2\u01c1\u0188\3\2\2\2\u01c1\u0189"+
		"\3\2\2\2\u01c1\u018c\3\2\2\2\u01c1\u0196\3\2\2\2\u01c1\u019c\3\2\2\2\u01c1"+
		"\u01a4\3\2\2\2\u01c1\u01ad\3\2\2\2\u01c1\u01af\3\2\2\2\u01c1\u01bb\3\2"+
		"\2\2\u01c1\u01bd\3\2\2\2\u01c2\63\3\2\2\2\u01c3\u01c4\7\34\2\2\u01c4\u01c5"+
		"\5Z.\2\u01c5\u01c9\7!\2\2\u01c6\u01c8\5\62\32\2\u01c7\u01c6\3\2\2\2\u01c8"+
		"\u01cb\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01d5\3\2"+
		"\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01cd\7\5\2\2\u01cd\u01d1\7!\2\2\u01ce"+
		"\u01d0\5\62\32\2\u01cf\u01ce\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf\3"+
		"\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4"+
		"\u01c3\3\2\2\2\u01d4\u01cc\3\2\2\2\u01d5\65\3\2\2\2\u01d6\u01d7\7\7\2"+
		"\2\u01d7\u01d8\58\35\2\u01d8\u01df\b\34\1\2\u01d9\u01da\7S\2\2\u01da\u01db"+
		"\58\35\2\u01db\u01dc\b\34\1\2\u01dc\u01de\3\2\2\2\u01dd\u01d9\3\2\2\2"+
		"\u01de\u01e1\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e2"+
		"\3\2\2\2\u01e1\u01df\3\2\2\2\u01e2\u01e3\7L\2\2\u01e3\67\3\2\2\2\u01e4"+
		"\u01e5\7N\2\2\u01e5\u01ee\b\35\1\2\u01e6\u01e7\7N\2\2\u01e7\u01e8\7\16"+
		"\2\2\u01e8\u01e9\5:\36\2\u01e9\u01ea\7\17\2\2\u01ea\u01eb\3\2\2\2\u01eb"+
		"\u01ec\b\35\1\2\u01ec\u01ee\3\2\2\2\u01ed\u01e4\3\2\2\2\u01ed\u01e6\3"+
		"\2\2\2\u01ee9\3\2\2\2\u01ef\u01f0\7N\2\2\u01f0\u01f1\t\2\2\2\u01f1\u01f2"+
		"\5Z.\2\u01f2\u01f3\b\36\1\2\u01f3;\3\2\2\2\u01f4\u01f5\7\37\2\2\u01f5"+
		"\u01f6\7N\2\2\u01f6\u01f7\7L\2\2\u01f7\u01f8\b\37\1\2\u01f8=\3\2\2\2\u01f9"+
		"\u01fa\7\32\2\2\u01fa\u01fb\5@!\2\u01fb\u0201\b \1\2\u01fc\u01fd\5@!\2"+
		"\u01fd\u01fe\b \1\2\u01fe\u0200\3\2\2\2\u01ff\u01fc\3\2\2\2\u0200\u0203"+
		"\3\2\2\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0204\3\2\2\2\u0203"+
		"\u0201\3\2\2\2\u0204\u0205\7L\2\2\u0205?\3\2\2\2\u0206\u0207\7N\2\2\u0207"+
		"\u0208\7\33\2\2\u0208\u0209\7N\2\2\u0209\u020a\5B\"\2\u020a\u0213\b!\1"+
		"\2\u020b\u020c\7S\2\2\u020c\u020d\7\33\2\2\u020d\u020e\7N\2\2\u020e\u020f"+
		"\5B\"\2\u020f\u0210\b!\1\2\u0210\u0212\3\2\2\2\u0211\u020b\3\2\2\2\u0212"+
		"\u0215\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0229\3\2"+
		"\2\2\u0215\u0213\3\2\2\2\u0216\u0217\7S\2\2\u0217\u0218\7N\2\2\u0218\u0219"+
		"\7\33\2\2\u0219\u021a\7N\2\2\u021a\u021b\5B\"\2\u021b\u0224\b!\1\2\u021c"+
		"\u021d\7S\2\2\u021d\u021e\7\33\2\2\u021e\u021f\7N\2\2\u021f\u0220\5B\""+
		"\2\u0220\u0221\b!\1\2\u0221\u0223\3\2\2\2\u0222\u021c\3\2\2\2\u0223\u0226"+
		"\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0228\3\2\2\2\u0226"+
		"\u0224\3\2\2\2\u0227\u0216\3\2\2\2\u0228\u022b\3\2\2\2\u0229\u0227\3\2"+
		"\2\2\u0229\u022a\3\2\2\2\u022aA\3\2\2\2\u022b\u0229\3\2\2\2\u022c\u0230"+
		"\7\16\2\2\u022d\u022e\5D#\2\u022e\u022f\b\"\1\2\u022f\u0231\3\2\2\2\u0230"+
		"\u022d\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0233\b\""+
		"\1\2\u0233\u0234\5L\'\2\u0234\u0235\b\"\1\2\u0235\u0239\3\2\2\2\u0236"+
		"\u0237\5N(\2\u0237\u0238\b\"\1\2\u0238\u023a\3\2\2\2\u0239\u0236\3\2\2"+
		"\2\u0239\u023a\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\7\17\2\2\u023c"+
		"\u023d\b\"\1\2\u023dC\3\2\2\2\u023e\u023f\7\6\2\2\u023f\u0240\5F$\2\u0240"+
		"\u0241\7L\2\2\u0241\u0242\b#\1\2\u0242E\3\2\2\2\u0243\u0244\5H%\2\u0244"+
		"\u024f\b$\1\2\u0245\u0249\7S\2\2\u0246\u0249\3\2\2\2\u0247\u0249\7B\2"+
		"\2\u0248\u0245\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0247\3\2\2\2\u0249\u024a"+
		"\3\2\2\2\u024a\u024b\5H%\2\u024b\u024c\b$\1\2\u024c\u024e\3\2\2\2\u024d"+
		"\u0248\3\2\2\2\u024e\u0251\3\2\2\2\u024f\u024d\3\2\2\2\u024f\u0250\3\2"+
		"\2\2\u0250G\3\2\2\2\u0251\u024f\3\2\2\2\u0252\u0253\5J&\2\u0253\u0254"+
		"\b%\1\2\u0254I\3\2\2\2\u0255\u0256\7N\2\2\u0256\u0257\t\3\2\2\u0257\u0258"+
		"\7O\2\2\u0258\u0259\b&\1\2\u0259K\3\2\2\2\u025a\u025b\7\3\2\2\u025b\u025c"+
		"\7N\2\2\u025c\u025d\t\4\2\2\u025d\u025e\7L\2\2\u025e\u025f\3\2\2\2\u025f"+
		"\u0267\b\'\1\2\u0260\u0261\7\3\2\2\u0261\u0262\7N\2\2\u0262\u0263\7L\2"+
		"\2\u0263\u0264\3\2\2\2\u0264\u0267\b\'\1\2\u0265\u0267\b\'\1\2\u0266\u025a"+
		"\3\2\2\2\u0266\u0260\3\2\2\2\u0266\u0265\3\2\2\2\u0267M\3\2\2\2\u0268"+
		"\u0269\7\35\2\2\u0269\u026a\5P)\2\u026a\u026b\7L\2\2\u026b\u026c\b(\1"+
		"\2\u026cO\3\2\2\2\u026d\u026e\5R*\2\u026e\u026f\b)\1\2\u026f\u0276\3\2"+
		"\2\2\u0270\u0271\7S\2\2\u0271\u0272\5R*\2\u0272\u0273\b)\1\2\u0273\u0275"+
		"\3\2\2\2\u0274\u0270\3\2\2\2\u0275\u0278\3\2\2\2\u0276\u0274\3\2\2\2\u0276"+
		"\u0277\3\2\2\2\u0277Q\3\2\2\2\u0278\u0276\3\2\2\2\u0279\u027a\7N\2\2\u027a"+
		"\u027b\t\5\2\2\u027b\u027c\7O\2\2\u027c\u027d\3\2\2\2\u027d\u0285\b*\1"+
		"\2\u027e\u027f\7N\2\2\u027f\u0280\t\5\2\2\u0280\u0281\5X-\2\u0281\u0282"+
		"\3\2\2\2\u0282\u0283\b*\1\2\u0283\u0285\3\2\2\2\u0284\u0279\3\2\2\2\u0284"+
		"\u027e\3\2\2\2\u0285S\3\2\2\2\u0286\u0287\7N\2\2\u0287\u0288\7\60\2\2"+
		"\u0288\u0289\7O\2\2\u0289\u028a\3\2\2\2\u028a\u028b\b+\1\2\u028bU\3\2"+
		"\2\2\u028c\u028d\5Z.\2\u028d\u0294\b,\1\2\u028e\u028f\7S\2\2\u028f\u0290"+
		"\5Z.\2\u0290\u0291\b,\1\2\u0291\u0293\3\2\2\2\u0292\u028e\3\2\2\2\u0293"+
		"\u0296\3\2\2\2\u0294\u0292\3\2\2\2\u0294\u0295\3\2\2\2\u0295W\3\2\2\2"+
		"\u0296\u0294\3\2\2\2\u0297\u0298\5Z.\2\u0298\u0299\b-\1\2\u0299Y\3\2\2"+
		"\2\u029a\u029b\b.\1\2\u029b\u029c\t\6\2\2\u029c\u029d\5Z.\17\u029d\u029e"+
		"\b.\1\2\u029e\u02a8\3\2\2\2\u029f\u02a0\t\7\2\2\u02a0\u02a1\5Z.\16\u02a1"+
		"\u02a2\b.\1\2\u02a2\u02a8\3\2\2\2\u02a3\u02a4\7N\2\2\u02a4\u02a8\b.\1"+
		"\2\u02a5\u02a6\7O\2\2\u02a6\u02a8\b.\1\2\u02a7\u029a\3\2\2\2\u02a7\u029f"+
		"\3\2\2\2\u02a7\u02a3\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a8\u02e7\3\2\2\2\u02a9"+
		"\u02aa\f\r\2\2\u02aa\u02ab\t\b\2\2\u02ab\u02ac\5Z.\16\u02ac\u02ad\b.\1"+
		"\2\u02ad\u02e6\3\2\2\2\u02ae\u02af\f\f\2\2\u02af\u02b0\t\t\2\2\u02b0\u02b1"+
		"\5Z.\r\u02b1\u02b2\b.\1\2\u02b2\u02e6\3\2\2\2\u02b3\u02b4\f\13\2\2\u02b4"+
		"\u02b5\t\2\2\2\u02b5\u02b6\5Z.\f\u02b6\u02b7\b.\1\2\u02b7\u02e6\3\2\2"+
		"\2\u02b8\u02b9\f\n\2\2\u02b9\u02ba\t\n\2\2\u02ba\u02bb\5Z.\13\u02bb\u02bc"+
		"\b.\1\2\u02bc\u02e6\3\2\2\2\u02bd\u02be\f\t\2\2\u02be\u02bf\7D\2\2\u02bf"+
		"\u02c0\5Z.\n\u02c0\u02c1\b.\1\2\u02c1\u02e6\3\2\2\2\u02c2\u02c3\f\b\2"+
		"\2\u02c3\u02c4\7?\2\2\u02c4\u02c5\5Z.\t\u02c5\u02c6\b.\1\2\u02c6\u02e6"+
		"\3\2\2\2\u02c7\u02c8\f\7\2\2\u02c8\u02c9\7G\2\2\u02c9\u02ca\5Z.\b\u02ca"+
		"\u02cb\b.\1\2\u02cb\u02e6\3\2\2\2\u02cc\u02cd\f\6\2\2\u02cd\u02ce\7B\2"+
		"\2\u02ce\u02cf\5Z.\7\u02cf\u02d0\b.\1\2\u02d0\u02e6\3\2\2\2\u02d1\u02d2"+
		"\f\5\2\2\u02d2\u02d3\7C\2\2\u02d3\u02d4\5Z.\6\u02d4\u02d5\b.\1\2\u02d5"+
		"\u02e6\3\2\2\2\u02d6\u02d7\f\4\2\2\u02d7\u02d8\7\23\2\2\u02d8\u02d9\5"+
		"Z.\2\u02d9\u02da\7!\2\2\u02da\u02db\5Z.\5\u02db\u02dc\b.\1\2\u02dc\u02e6"+
		"\3\2\2\2\u02dd\u02de\f\3\2\2\u02de\u02df\t\13\2\2\u02df\u02e0\5Z.\4\u02e0"+
		"\u02e1\b.\1\2\u02e1\u02e6\3\2\2\2\u02e2\u02e3\f\20\2\2\u02e3\u02e4\t\f"+
		"\2\2\u02e4\u02e6\b.\1\2\u02e5\u02a9\3\2\2\2\u02e5\u02ae\3\2\2\2\u02e5"+
		"\u02b3\3\2\2\2\u02e5\u02b8\3\2\2\2\u02e5\u02bd\3\2\2\2\u02e5\u02c2\3\2"+
		"\2\2\u02e5\u02c7\3\2\2\2\u02e5\u02cc\3\2\2\2\u02e5\u02d1\3\2\2\2\u02e5"+
		"\u02d6\3\2\2\2\u02e5\u02dd\3\2\2\2\u02e5\u02e2\3\2\2\2\u02e6\u02e9\3\2"+
		"\2\2\u02e7\u02e5\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8[\3\2\2\2\u02e9\u02e7"+
		"\3\2\2\2\u02ea\u02eb\7N\2\2\u02eb\u02ec\7\60\2\2\u02ec\u02ed\5Z.\2\u02ed"+
		"\u02ee\3\2\2\2\u02ee\u02ef\b/\1\2\u02ef\u02f7\3\2\2\2\u02f0\u02f1\7N\2"+
		"\2\u02f1\u02f2\7:\2\2\u02f2\u02f3\5Z.\2\u02f3\u02f4\3\2\2\2\u02f4\u02f5"+
		"\b/\1\2\u02f5\u02f7\3\2\2\2\u02f6\u02ea\3\2\2\2\u02f6\u02f0\3\2\2\2\u02f7"+
		"]\3\2\2\2\u02f8\u02fd\5Z.\2\u02f9\u02fa\7S\2\2\u02fa\u02fc\5^\60\2\u02fb"+
		"\u02f9\3\2\2\2\u02fc\u02ff\3\2\2\2\u02fd\u02fb\3\2\2\2\u02fd\u02fe\3\2"+
		"\2\2\u02fe\u0300\3\2\2\2\u02ff\u02fd\3\2\2\2\u0300\u0301\b\60\1\2\u0301"+
		"\u0304\3\2\2\2\u0302\u0304\3\2\2\2\u0303\u02f8\3\2\2\2\u0303\u0302\3\2"+
		"\2\2\u0304_\3\2\2\2@ekq\u0081\u0091\u009c\u00a1\u00a5\u00ab\u00c0\u00c2"+
		"\u00c7\u00ca\u00cf\u00d7\u00e3\u00ec\u00f4\u00ff\u010a\u0113\u011b\u0128"+
		"\u012a\u0130\u0134\u0137\u013a\u013c\u0151\u015b\u0164\u016d\u017a\u017c"+
		"\u0182\u01ab\u01b7\u01c1\u01c9\u01d1\u01d4\u01df\u01ed\u0201\u0213\u0224"+
		"\u0229\u0230\u0239\u0248\u024f\u0266\u0276\u0284\u0294\u02a7\u02e5\u02e7"+
		"\u02f6\u02fd\u0303";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}