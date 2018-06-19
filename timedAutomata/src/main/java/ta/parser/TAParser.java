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
	    
	    private void clean(){
	    	boundedVariablesValues=new HashMap<>();
	    	 declarations = new HashMap<String, String>();
	    	 currentTaDeclarations = new HashMap<String, String>();
	    	  currentProc="";
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
		 	
		 		declarations = new HashMap<>();
		 	 	currentTaDeclarations = new HashMap<>();
		 	 	boundedVariablesValues=new HashMap<>();
			 	 currentProc="";
			 	 
		 	
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
			clean();
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(95); ((TaContext)_localctx).dec = ((TaContext)_localctx).declaration = declaration();


									if(((TaContext)_localctx).declaration.timedAutomaton!=null) timedAutomata.add(((TaContext)_localctx).declaration.timedAutomaton);
									if(((TaContext)_localctx).declaration.variableinitializationret!=null) variableinitializationret.putAll(((TaContext)_localctx).declaration.variableinitializationret);
									if(((TaContext)_localctx).declaration.clockinitializationret!=null){
										clockinitializationret.putAll(((TaContext)_localctx).declaration.clockinitializationret);
									}
									
									if(((TaContext)_localctx).declaration.variabledeclret!=null) variabledeclret.putAll(((TaContext)_localctx).declaration.variabledeclret);
									
					 			
							
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(103); instantiation();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109); system();
				}
				}
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__20 );
			setState(114); match(EOF);

			 		
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
			setState(128);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117); ((DeclarationContext)_localctx).boundedVariableDecl = boundedVariableDecl();

						 	declarations.putAll(((DeclarationContext)_localctx).boundedVariableDecl.variabledeclret);
							_localctx.variabledeclret.putAll(((DeclarationContext)_localctx).boundedVariableDecl.variabledeclret);
				 			_localctx.variableinitializationret.putAll(((DeclarationContext)_localctx).boundedVariableDecl.variableinitializationret);
				 			
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120); functionDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121); ((DeclarationContext)_localctx).variableDecl = variableDecl();

				 		declarations.putAll(((DeclarationContext)_localctx).variableDecl.variabledeclret);
				 		_localctx.variabledeclret.putAll(((DeclarationContext)_localctx).variableDecl.variabledeclret);
				 		_localctx.variableinitializationret.putAll(((DeclarationContext)_localctx).variableDecl.variableinitializationret);
				 		((DeclarationContext)_localctx).clockinitializationret = ((DeclarationContext)_localctx).variableDecl.clockinitializationret;
				 	
				 	
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(124); typeDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(125); ((DeclarationContext)_localctx).procDecl = procDecl();

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
			setState(130); match(ID);
			setState(131); declarationid();
			setState(132); match(ID);
			setState(133); match(LPAR);
			setState(134); argList();
			setState(135); match(RPAR);
			setState(136); match(SEMICOLUMN);
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
			setState(138); match(T__20);
			setState(139); match(ID);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(140); match(COMMA);
				setState(141); match(ID);
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147); match(SEMICOLUMN);
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
			setState(160);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(149); match(LPAR);
				setState(150); parameter();
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(151); match(COMMA);
					setState(152); parameter();
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(158); match(RPAR);
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
			setState(162); type();
			setState(164);
			_la = _input.LA(1);
			if (_la==BITAND) {
				{
				setState(163); match(BITAND);
				}
			}

			setState(166); match(ID);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(167); arrayDecl();
				}
				}
				setState(172);
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
			setState(173); match(T__32);
			setState(174); ((ProcDeclContext)_localctx).ID = match(ID);
			currentProc=(((ProcDeclContext)_localctx).ID!=null?((ProcDeclContext)_localctx).ID.getText():null);
			setState(176); parameterList();
			setState(177); match(T__26);
			setState(178); ((ProcDeclContext)_localctx).procBody = procBody();
			setState(179); match(T__25);

				
				
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
			 	
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__30) | (1L << T__18) | (1L << T__17) | (1L << T__10) | (1L << T__8) | (1L << T__4) | (1L << T__1) | (1L << T__0))) != 0) || _la==ID) {
				{
				setState(191);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(183); functionDecl();
					}
					break;
				case 2:
					{
					setState(184); ((ProcBodyContext)_localctx).variableDecl = variableDecl();


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
					setState(187); ((ProcBodyContext)_localctx).boundedVariableDecl = boundedVariableDecl();

							 	_localctx.variabledeclret.putAll(((ProcBodyContext)_localctx).boundedVariableDecl.variabledeclret);
					 			_localctx.variableinitializationret.putAll(((ProcBodyContext)_localctx).boundedVariableDecl.variableinitializationret);
					 			currentTaDeclarations.putAll(((ProcBodyContext)_localctx).boundedVariableDecl.variabledeclret);
					 			
							
					}
					break;
				case 4:
					{
					setState(190); typeDecl();
					}
					break;
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196); ((ProcBodyContext)_localctx).states = states();
			setState(198);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(197); commit();
				}
			}

			setState(201);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(200); urgent();
				}
			}

			setState(203); ((ProcBodyContext)_localctx).init = init();

			 		for(State s: ((ProcBodyContext)_localctx).states.stateset){
			 			if(s.getStringId().equals(((ProcBodyContext)_localctx).init.initString)){
			 				((ProcBodyContext)_localctx).initstate = s;
			 			}
			 		}
			 	
			setState(206);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(205); ((ProcBodyContext)_localctx).transitions = transitions();
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
			setState(210); ((BoundedVariableDeclContext)_localctx).type = type();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(211); arrayDecl();
				}
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(217); ((BoundedVariableDeclContext)_localctx).ID = match(ID);
			setState(218); match(T__26);
			setState(219); ((BoundedVariableDeclContext)_localctx).nat = match(NAT);

			 				values.add(Integer.parseInt((((BoundedVariableDeclContext)_localctx).nat!=null?((BoundedVariableDeclContext)_localctx).nat.getText():null)));
			 				
			 			
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(221); match(COMMA);
				setState(222); ((BoundedVariableDeclContext)_localctx).nat = match(NAT);

				 				 	values.add(Integer.parseInt((((BoundedVariableDeclContext)_localctx).nat!=null?((BoundedVariableDeclContext)_localctx).nat.getText():null)));
				 				
				 			
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(229); match(T__25);

			 			if(definedVar((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null))){
			 				
			 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+(((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null));
					
			 			}
			 			_localctx.variabledeclret.put((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null), (((BoundedVariableDeclContext)_localctx).type!=null?_input.getText(((BoundedVariableDeclContext)_localctx).type.start,((BoundedVariableDeclContext)_localctx).type.stop):null));
			 			boundedVariablesValues.put((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null),values);
			 		
			 		
			setState(235);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(231); match(EQ);
				setState(232); ((BoundedVariableDeclContext)_localctx).expression = expression(0);

				 			_localctx.variableinitializationret.put((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null), ((BoundedVariableDeclContext)_localctx).expression.exp);
						
				}
			}

			setState(237); match(SEMICOLUMN);
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
			setState(239); ((VariableDeclContext)_localctx).type = type();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(240); arrayDecl();
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246); ((VariableDeclContext)_localctx).var1 = variableId();

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
			 		
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(248); match(COMMA);
				setState(249); ((VariableDeclContext)_localctx).varn = variableId();

				 			
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
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(257); match(SEMICOLUMN);
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
			setState(259); ((VariableIdContext)_localctx).ID = match(ID);

					((VariableIdContext)_localctx).id = (((VariableIdContext)_localctx).ID!=null?((VariableIdContext)_localctx).ID.getText():null);

			setState(265);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(261); match(EQ);
				setState(262); ((VariableIdContext)_localctx).expression = expression(0);

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
			setState(267); match(LBRA);
			setState(268); expression(0);
			setState(269); match(RBRA);
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
			setState(297);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(271); prefix();
				setState(272); match(ID);
				setState(274);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(273); range();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(276); prefix();
				setState(277); match(T__0);
				setState(278); match(T__26);
				setState(280); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(279); fieldDecl();
					}
					}
					setState(282); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__30) | (1L << T__18) | (1L << T__17) | (1L << T__10) | (1L << T__8) | (1L << T__4) | (1L << T__0))) != 0) || _la==ID );
				setState(284); match(T__25);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(286); prefix();
				setState(295);
				switch (_input.LA(1)) {
				case T__18:
					{
					setState(287); match(T__18);
					 ((TypeContext)_localctx).typeret = Integer.class;
					                		 
					}
					break;
				case T__17:
					{
					setState(289); match(T__17);
					 ((TypeContext)_localctx).typeret = Clock.class;
					                		 
					}
					break;
				case T__30:
					{
					setState(291); match(T__30);
					 ((TypeContext)_localctx).typeret = Character.class;
					                		 
					}
					break;
				case T__4:
					{
					setState(293); match(T__4);
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
			setState(299); match(ID);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(300); arrayDecl();
				}
				}
				setState(305);
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
			setState(315);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(307);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(306); match(T__8);
					}
				}

				setState(310);
				_la = _input.LA(1);
				if (_la==T__36) {
					{
					setState(309); match(T__36);
					}
				}

				}
				break;
			case 2:
				{
				setState(313);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(312); match(T__10);
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
			setState(317); match(LBRA);
			setState(318); match(NAT);
			setState(319); match(COMMA);
			setState(320); match(NAT);
			setState(321); match(RBRA);
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
			setState(323); match(T__31);
			setState(324); stateList();
			setState(325); match(SEMICOLUMN);
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
			setState(327); match(T__8);
			setState(328); stateList();
			setState(329); match(SEMICOLUMN);
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
			setState(331); match(ID);
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(332); match(COMMA);
				setState(333); match(ID);
				}
				}
				setState(338);
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
			setState(339); match(T__1);
			setState(340); type();
			setState(341); typeIdList();
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(342); match(COMMA);
				setState(343); typeIdList();
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(349); match(SEMICOLUMN);
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
			setState(351); match(ID);
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(352); arrayDecl();
				}
				}
				setState(357);
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
			setState(358); type();
			setState(359); fieldDeclId();
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(360); match(COMMA);
				setState(361); fieldDeclId();
				}
				}
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(367); match(SEMICOLUMN);
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
			setState(369); type();
			setState(370); match(ID);
			setState(371); parameterList();
			setState(372); block();
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
			setState(374); match(T__26);
			setState(379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(377);
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
						setState(375); variableDecl();
						}
						break;
					case T__1:
						{
						setState(376); typeDecl();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__27) | (1L << T__26) | (1L << T__23) | (1L << T__22) | (1L << T__19) | (1L << T__16) | (1L << T__15) | (1L << T__5) | (1L << T__3) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
				{
				{
				setState(382); statement();
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(388); match(T__25);
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
			setState(448);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(390); block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(391); match(SEMICOLUMN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(392); expression(0);
				setState(393); match(SEMICOLUMN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(395); match(T__22);
				setState(396); match(LPAR);
				setState(397); exprList();
				setState(398); match(SEMICOLUMN);
				setState(399); exprList();
				setState(400); match(SEMICOLUMN);
				setState(401); exprList();
				setState(402); match(RPAR);
				setState(403); statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(405); match(T__27);
				setState(406); match(LPAR);
				setState(407); exprList();
				setState(408); match(RPAR);
				setState(409); statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(411); match(T__16);
				setState(412); statement();
				setState(413); match(T__27);
				setState(414); match(LPAR);
				setState(415); exprList();
				setState(416); match(RPAR);
				setState(417); match(SEMICOLUMN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(419); match(T__23);
				setState(420); match(LPAR);
				setState(421); exprList();
				setState(422); match(RPAR);
				setState(423); statement();
				setState(426);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(424); match(T__2);
					setState(425); statement();
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(428); match(T__19);
				setState(429); match(SEMICOLUMN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(430); match(T__15);
				setState(431); match(LPAR);
				setState(432); exprList();
				setState(433); match(RPAR);
				setState(434); match(T__26);
				setState(436); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(435); caseocc();
					}
					}
					setState(438); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__35 || _la==T__12 );
				setState(440); match(T__25);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(442); match(T__29);
				setState(443); match(SEMICOLUMN);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(444); match(T__29);
				setState(445); expression(0);
				setState(446); match(SEMICOLUMN);
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
			setState(467);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(450); match(T__12);
				setState(451); expression(0);
				setState(452); match(T__7);
				setState(456);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__27) | (1L << T__26) | (1L << T__23) | (1L << T__22) | (1L << T__19) | (1L << T__16) | (1L << T__15) | (1L << T__5) | (1L << T__3) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
					{
					{
					setState(453); statement();
					}
					}
					setState(458);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 2);
				{
				setState(459); match(T__35);
				setState(460); match(T__7);
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__27) | (1L << T__26) | (1L << T__23) | (1L << T__22) | (1L << T__19) | (1L << T__16) | (1L << T__15) | (1L << T__5) | (1L << T__3) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
					{
					{
					setState(461); statement();
					}
					}
					setState(466);
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
			setState(469); match(T__33);
			setState(470); ((StatesContext)_localctx).s1 = stateDecl();

				_localctx.stateset.add(((StatesContext)_localctx).s1.state);

			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(472); match(COMMA);
				setState(473); ((StatesContext)_localctx).s2 = stateDecl();

					_localctx.stateset.add(((StatesContext)_localctx).s2.state);

				}
				}
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(481); match(SEMICOLUMN);
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
			setState(492);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(483); ((StateDeclContext)_localctx).ID = match(ID);

						((StateDeclContext)_localctx).state = new State((((StateDeclContext)_localctx).ID!=null?((StateDeclContext)_localctx).ID.getText():null));
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(485); ((StateDeclContext)_localctx).ID = match(ID);
				{
				setState(486); match(T__26);
				setState(487); ((StateDeclContext)_localctx).inv = invariant();
				setState(488); match(T__25);
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
			setState(494); ((InvariantContext)_localctx).ID = match(ID);
			setState(495);
			((InvariantContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE))) != 0)) ) {
				((InvariantContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(496); ((InvariantContext)_localctx).expression = expression(0);

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
			setState(499); match(T__9);
			setState(500); ((InitContext)_localctx).ID = match(ID);
			setState(501); match(SEMICOLUMN);

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
			setState(504); match(T__14);
			setState(505); ((TransitionsContext)_localctx).transitionset = transitionset();

					_localctx.transitionsret.addAll(((TransitionsContext)_localctx).transitionset.transitionsret);
				
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(507); ((TransitionsContext)_localctx).transitionset = transitionset();

						_localctx.transitionsret.addAll(((TransitionsContext)_localctx).transitionset.transitionsret);		
					
				}
				}
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(515); match(SEMICOLUMN);
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
			setState(517); ((TransitionsetContext)_localctx).s1 = match(ID);
			setState(518); match(T__13);
			setState(519); ((TransitionsetContext)_localctx).s2 = match(ID);
			setState(520); ((TransitionsetContext)_localctx).transitionBody = transitionBody();

					_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s2.getText()), ((TransitionsetContext)_localctx).transitionBody.guardexp, ((TransitionsetContext)_localctx).transitionBody.syncexp,  ((TransitionsetContext)_localctx).transitionBody.assignexp));
				
			setState(530);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(522); match(COMMA);
					setState(523); match(T__13);
					setState(524); ((TransitionsetContext)_localctx).s3 = match(ID);
					setState(525); ((TransitionsetContext)_localctx).b2 = ((TransitionsetContext)_localctx).transitionBody = transitionBody();

							_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s3.getText()), ((TransitionsetContext)_localctx).b2.guardexp, ((TransitionsetContext)_localctx).b2.syncexp,  ((TransitionsetContext)_localctx).b2.assignexp));
							
						
					}
					} 
				}
				setState(532);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			setState(552);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(533); match(COMMA);
				setState(534); ((TransitionsetContext)_localctx).s1 = match(ID);
				setState(535); match(T__13);
				setState(536); ((TransitionsetContext)_localctx).s2 = match(ID);
				setState(537); ((TransitionsetContext)_localctx).transitionBody = transitionBody();

						_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s2.getText()), ((TransitionsetContext)_localctx).transitionBody.guardexp, ((TransitionsetContext)_localctx).transitionBody.syncexp,  ((TransitionsetContext)_localctx).transitionBody.assignexp));
					
				setState(547);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(539); match(COMMA);
						setState(540); match(T__13);
						setState(541); ((TransitionsetContext)_localctx).s3 = match(ID);
						setState(542); ((TransitionsetContext)_localctx).b2 = ((TransitionsetContext)_localctx).transitionBody = transitionBody();

								_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s3.getText()), ((TransitionsetContext)_localctx).b2.guardexp, ((TransitionsetContext)_localctx).b2.syncexp,  ((TransitionsetContext)_localctx).b2.assignexp));
								
							
						}
						} 
					}
					setState(549);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				}
				}
				}
				setState(554);
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
			setState(555); match(T__26);
			setState(559);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(556); ((TransitionBodyContext)_localctx).guard = guard();

				 			 ((TransitionBodyContext)_localctx).guardexp = ((TransitionBodyContext)_localctx).guard.guardexp;
				 		
				}
			}


					if(_localctx.guardexp==null) {((TransitionBodyContext)_localctx).guardexp = new Guard(new HashSet<VariableConstraintAtom>(), new HashSet<ClockConstraintAtom>());}
					
			{
			setState(562); ((TransitionBodyContext)_localctx).sync = sync();

					((TransitionBodyContext)_localctx).syncexp = ((TransitionBodyContext)_localctx).sync.syncexp;
					
			}
			setState(568);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(565); ((TransitionBodyContext)_localctx).assign = assign();

				 			((TransitionBodyContext)_localctx).assignexp = ((TransitionBodyContext)_localctx).assign.assignexp;
				 		
				}
			}

			setState(570); match(T__25);

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
			setState(573); match(T__34);
			setState(574); ((GuardContext)_localctx).exp1 = ((GuardContext)_localctx).guardconditionList = guardconditionList();
			setState(575); match(SEMICOLUMN);

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
			setState(578); ((GuardconditionListContext)_localctx).clockconstraint = clockconstraint();

							if(((GuardconditionListContext)_localctx).clockconstraint.clockconst!=null) _localctx.clockconst.add(((GuardconditionListContext)_localctx).clockconstraint.clockconst) ;
							if(((GuardconditionListContext)_localctx).clockconstraint.variableconst!=null) _localctx.variableconst.add(((GuardconditionListContext)_localctx).clockconstraint.variableconst);
						
			setState(590);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (AND - 64)) | (1L << (ID - 64)) | (1L << (COMMA - 64)))) != 0)) {
				{
				{
				setState(583);
				switch (_input.LA(1)) {
				case COMMA:
					{
					setState(580); match(COMMA);
					}
					break;
				case ID:
					{
					}
					break;
				case AND:
					{
					setState(582); match(AND);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(585); ((GuardconditionListContext)_localctx).clockconstraint = clockconstraint();

								if(((GuardconditionListContext)_localctx).clockconstraint.clockconst!=null) _localctx.clockconst.add(((GuardconditionListContext)_localctx).clockconstraint.clockconst);
								if(((GuardconditionListContext)_localctx).clockconstraint.variableconst!=null)_localctx.variableconst.add(((GuardconditionListContext)_localctx).clockconstraint.variableconst) ;
							
				}
				}
				setState(592);
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
			setState(593); ((ClockconstraintContext)_localctx).constraintAtom = constraintAtom();

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
			setState(596); ((ConstraintAtomContext)_localctx).id = match(ID);
			setState(597);
			((ConstraintAtomContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE) | (1L << EQCOMP))) != 0)) ) {
				((ConstraintAtomContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(598); ((ConstraintAtomContext)_localctx).value = match(NAT);

					
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
			setState(613);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				{
				setState(601); match(T__37);
				setState(602); ((SyncContext)_localctx).exp2 = match(ID);
				setState(603);
				((SyncContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__3) ) {
					((SyncContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(604); match(SEMICOLUMN);
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
				setState(607); match(T__37);
				setState(608); ((SyncContext)_localctx).exp2 = match(ID);
				setState(609); match(SEMICOLUMN);
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
			setState(615); match(T__11);
			setState(616); ((AssignContext)_localctx).expl = ((AssignContext)_localctx).assignmentList = assignmentList();
			setState(617); match(SEMICOLUMN);

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
			setState(620); ((AssignmentListContext)_localctx).assignment = assignment();

				 		if(((AssignmentListContext)_localctx).assignment.clockassignementsret!=null){
				 			_localctx.clockassignement.add(((AssignmentListContext)_localctx).assignment.clockassignementsret);
				 		}
				 		if(((AssignmentListContext)_localctx).assignment.variableAssignementret!=null){
				 			_localctx.variableassignement.add(((AssignmentListContext)_localctx).assignment.variableAssignementret);
				 		}
				 	
			}
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				{
				setState(623); match(COMMA);
				setState(624); ((AssignmentListContext)_localctx).assignment = assignment();

								if(((AssignmentListContext)_localctx).assignment.clockassignementsret!=null){
					 			_localctx.clockassignement.add(((AssignmentListContext)_localctx).assignment.clockassignementsret);
					 		}
					 		if(((AssignmentListContext)_localctx).assignment.variableAssignementret!=null){
					 			_localctx.variableassignement.add(((AssignmentListContext)_localctx).assignment.variableAssignementret);
					 		}
						
				}
				}
				}
				setState(631);
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
			setState(643);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(632); ((AssignmentContext)_localctx).id = match(ID);
				setState(633);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQASSIGN || _la==EQ) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(634); ((AssignmentContext)_localctx).nat = match(NAT);
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
				setState(637); ((AssignmentContext)_localctx).id = match(ID);
				setState(638);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQASSIGN || _la==EQ) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(639); ((AssignmentContext)_localctx).exprStatement = exprStatement();
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
			setState(645); ((SimpleassigmentContext)_localctx).id = match(ID);
			setState(646); ((SimpleassigmentContext)_localctx).op = match(EQ);
			setState(647); ((SimpleassigmentContext)_localctx).nat = match(NAT);
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
			setState(651); ((ExprListContext)_localctx).exp1 = expression(0);

				_localctx.exprListret.add(((ExprListContext)_localctx).exp1.exp);

			setState(659);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(653); match(COMMA);
				setState(654); ((ExprListContext)_localctx).exp2 = expression(0);

					_localctx.exprListret.add(((ExprListContext)_localctx).exp2.exp);
					
				}
				}
				setState(661);
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
			setState(662); ((ExprStatementContext)_localctx).expression = expression(0);

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
			setState(678);
			switch (_input.LA(1)) {
			case PLUS:
			case PLUSPLUS:
			case MINUSMINUS:
			case MINUS:
				{
				setState(666);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0)) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(667); ((ExpressionContext)_localctx).exp1 = expression(13);

				    	((ExpressionContext)_localctx).exp = new LeftUnaryOperator((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp1.exp);
				    
				}
				break;
			case T__5:
			case T__3:
				{
				setState(670);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__5 || _la==T__3) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(671); ((ExpressionContext)_localctx).exp1 = expression(12);

				    	((ExpressionContext)_localctx).exp = new LeftUnaryOperator((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp1.exp);
				    
				}
				break;
			case ID:
				{
				setState(674); ((ExpressionContext)_localctx).ID = match(ID);

						((ExpressionContext)_localctx).exp = new Identifier((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
					
				}
				break;
			case NAT:
				{
				setState(676); ((ExpressionContext)_localctx).NAT = match(NAT);

						((ExpressionContext)_localctx).exp = new Value((((ExpressionContext)_localctx).NAT!=null?((ExpressionContext)_localctx).NAT.getText():null));
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(742);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(740);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(680);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(681);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << FRACT) | (1L << MOD))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(682); ((ExpressionContext)_localctx).exp2 = expression(12);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(685);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(686);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(687); ((ExpressionContext)_localctx).exp2 = expression(11);

						              		BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              		((ExpressionContext)_localctx).exp = exp;
						              	
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(690);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(691);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(692); ((ExpressionContext)_localctx).exp2 = expression(10);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(695);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(696);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQCOMP || _la==NEQ) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(697); ((ExpressionContext)_localctx).exp2 = expression(9);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(700);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(701); ((ExpressionContext)_localctx).op = match(BITAND);
						setState(702); ((ExpressionContext)_localctx).exp2 = expression(8);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(705);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(706); ((ExpressionContext)_localctx).op = match(POW);
						setState(707); ((ExpressionContext)_localctx).exp2 = expression(7);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(710);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(711); ((ExpressionContext)_localctx).op = match(BITOR);
						setState(712); ((ExpressionContext)_localctx).exp2 = expression(6);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(715);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(716); ((ExpressionContext)_localctx).op = match(AND);
						setState(717); ((ExpressionContext)_localctx).exp2 = expression(5);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(720);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(721); ((ExpressionContext)_localctx).op = match(OR);
						setState(722); ((ExpressionContext)_localctx).exp2 = expression(4);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(725);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(726); match(T__21);
						setState(727); ((ExpressionContext)_localctx).exp2 = expression(0);
						setState(728); match(T__7);
						setState(729); ((ExpressionContext)_localctx).exp3 = expression(3);

						              	((ExpressionContext)_localctx).exp = new TernaryExpression(((ExpressionContext)_localctx).exp1.exp, ((ExpressionContext)_localctx).exp2.exp, ((ExpressionContext)_localctx).exp3.exp);
						              
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(732);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(733);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__28 - 10)) | (1L << (T__24 - 10)) | (1L << (T__6 - 10)) | (1L << (EQ - 10)) | (1L << (FRACTEQ - 10)) | (1L << (MODEQ - 10)) | (1L << (PLUSEQ - 10)) | (1L << (MINUSEQ - 10)) | (1L << (COLUMEQ - 10)) | (1L << (MULTEQ - 10)) | (1L << (POWEQ - 10)) | (1L << (BITANDEQ - 10)) | (1L << (BITOREQ - 10)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(734); ((ExpressionContext)_localctx).exp2 = expression(2);

						              	((ExpressionContext)_localctx).exp = new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp2.exp);
						              
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(737);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(738);
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
				setState(744);
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
			setState(757);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(745); ((DeclarationidContext)_localctx).ID = match(ID);
				setState(746); ((DeclarationidContext)_localctx).op = match(EQ);
				setState(747); ((DeclarationidContext)_localctx).expr = expression(0);
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
				setState(751); ((DeclarationidContext)_localctx).ID = match(ID);
				setState(752); ((DeclarationidContext)_localctx).op = match(COLUMEQ);
				setState(753); ((DeclarationidContext)_localctx).expr = expression(0);
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
			setState(770);
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
				setState(759); ((ArgListContext)_localctx).expression = expression(0);
				setState(764);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(760); match(COMMA);
						setState(761); ((ArgListContext)_localctx).argList = argList();
						}
						} 
					}
					setState(766);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3U\u0307\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\7\2e\n\2\f\2\16\2h\13"+
		"\2\3\2\7\2k\n\2\f\2\16\2n\13\2\3\2\6\2q\n\2\r\2\16\2r\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0083\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5\u0091\n\5\f\5\16\5\u0094\13\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\7\6\u009c\n\6\f\6\16\6\u009f\13\6\3\6\3\6\5\6\u00a3"+
		"\n\6\3\7\3\7\5\7\u00a7\n\7\3\7\3\7\7\7\u00ab\n\7\f\7\16\7\u00ae\13\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\7\t\u00c2\n\t\f\t\16\t\u00c5\13\t\3\t\3\t\5\t\u00c9\n\t\3\t\5\t\u00cc"+
		"\n\t\3\t\3\t\3\t\5\t\u00d1\n\t\3\t\3\t\3\n\3\n\7\n\u00d7\n\n\f\n\16\n"+
		"\u00da\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00e3\n\n\f\n\16\n\u00e6\13"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00ee\n\n\3\n\3\n\3\13\3\13\7\13\u00f4"+
		"\n\13\f\13\16\13\u00f7\13\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00ff"+
		"\n\13\f\13\16\13\u0102\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u010c"+
		"\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u0115\n\16\3\16\3\16\3\16\3\16"+
		"\6\16\u011b\n\16\r\16\16\16\u011c\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\5\16\u012a\n\16\5\16\u012c\n\16\3\17\3\17\7\17\u0130"+
		"\n\17\f\17\16\17\u0133\13\17\3\20\5\20\u0136\n\20\3\20\5\20\u0139\n\20"+
		"\3\20\5\20\u013c\n\20\5\20\u013e\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u0151\n\24"+
		"\f\24\16\24\u0154\13\24\3\25\3\25\3\25\3\25\3\25\7\25\u015b\n\25\f\25"+
		"\16\25\u015e\13\25\3\25\3\25\3\26\3\26\7\26\u0164\n\26\f\26\16\26\u0167"+
		"\13\26\3\27\3\27\3\27\3\27\7\27\u016d\n\27\f\27\16\27\u0170\13\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u017c\n\31\f\31\16"+
		"\31\u017f\13\31\3\31\7\31\u0182\n\31\f\31\16\31\u0185\13\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u01ad\n\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\6\32\u01b7\n\32\r\32\16\32\u01b8\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\5\32\u01c3\n\32\3\33\3\33\3\33\3\33\7\33"+
		"\u01c9\n\33\f\33\16\33\u01cc\13\33\3\33\3\33\3\33\7\33\u01d1\n\33\f\33"+
		"\16\33\u01d4\13\33\5\33\u01d6\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\7\34\u01df\n\34\f\34\16\34\u01e2\13\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\5\35\u01ef\n\35\3\36\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \7 \u0201\n \f \16 \u0204\13 \3"+
		" \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0213\n!\f!\16!\u0216\13!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0224\n!\f!\16!\u0227\13!\7!\u0229"+
		"\n!\f!\16!\u022c\13!\3\"\3\"\3\"\3\"\5\"\u0232\n\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\5\"\u023b\n\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\5$\u024a"+
		"\n$\3$\3$\3$\7$\u024f\n$\f$\16$\u0252\13$\3%\3%\3%\3&\3&\3&\3&\3&\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0268\n\'\3(\3(\3(\3"+
		"(\3(\3)\3)\3)\3)\3)\3)\3)\7)\u0276\n)\f)\16)\u0279\13)\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\3*\3*\3*\5*\u0286\n*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\7,"+
		"\u0294\n,\f,\16,\u0297\13,\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\5.\u02a9\n.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\7.\u02e7\n"+
		".\f.\16.\u02ea\13.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u02f8\n/\3\60"+
		"\3\60\3\60\7\60\u02fd\n\60\f\60\16\60\u0300\13\60\3\60\3\60\3\60\5\60"+
		"\u0305\n\60\3\60\2\3Z\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^\2\r\3\2),\3\2)-\4\2\23\23%%\3\2/"+
		"\60\3\2\63\66\4\2##%%\4\2\67\67=>\4\2\63\63\66\66\3\2-.\b\2\f\f\20\20"+
		"\"\"\60\628<EF\3\2\64\65\u0334\2`\3\2\2\2\4\u0082\3\2\2\2\6\u0084\3\2"+
		"\2\2\b\u008c\3\2\2\2\n\u00a2\3\2\2\2\f\u00a4\3\2\2\2\16\u00af\3\2\2\2"+
		"\20\u00b8\3\2\2\2\22\u00d4\3\2\2\2\24\u00f1\3\2\2\2\26\u0105\3\2\2\2\30"+
		"\u010d\3\2\2\2\32\u012b\3\2\2\2\34\u012d\3\2\2\2\36\u013d\3\2\2\2 \u013f"+
		"\3\2\2\2\"\u0145\3\2\2\2$\u0149\3\2\2\2&\u014d\3\2\2\2(\u0155\3\2\2\2"+
		"*\u0161\3\2\2\2,\u0168\3\2\2\2.\u0173\3\2\2\2\60\u0178\3\2\2\2\62\u01c2"+
		"\3\2\2\2\64\u01d5\3\2\2\2\66\u01d7\3\2\2\28\u01ee\3\2\2\2:\u01f0\3\2\2"+
		"\2<\u01f5\3\2\2\2>\u01fa\3\2\2\2@\u0207\3\2\2\2B\u022d\3\2\2\2D\u023f"+
		"\3\2\2\2F\u0244\3\2\2\2H\u0253\3\2\2\2J\u0256\3\2\2\2L\u0267\3\2\2\2N"+
		"\u0269\3\2\2\2P\u026e\3\2\2\2R\u0285\3\2\2\2T\u0287\3\2\2\2V\u028d\3\2"+
		"\2\2X\u0298\3\2\2\2Z\u02a8\3\2\2\2\\\u02f7\3\2\2\2^\u0304\3\2\2\2`f\b"+
		"\2\1\2ab\5\4\3\2bc\b\2\1\2ce\3\2\2\2da\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3"+
		"\2\2\2gl\3\2\2\2hf\3\2\2\2ik\5\6\4\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3"+
		"\2\2\2mp\3\2\2\2nl\3\2\2\2oq\5\b\5\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3"+
		"\2\2\2st\3\2\2\2tu\7\2\2\3uv\b\2\1\2v\3\3\2\2\2wx\5\22\n\2xy\b\3\1\2y"+
		"\u0083\3\2\2\2z\u0083\5.\30\2{|\5\24\13\2|}\b\3\1\2}\u0083\3\2\2\2~\u0083"+
		"\5(\25\2\177\u0080\5\16\b\2\u0080\u0081\b\3\1\2\u0081\u0083\3\2\2\2\u0082"+
		"w\3\2\2\2\u0082z\3\2\2\2\u0082{\3\2\2\2\u0082~\3\2\2\2\u0082\177\3\2\2"+
		"\2\u0083\5\3\2\2\2\u0084\u0085\7N\2\2\u0085\u0086\5\\/\2\u0086\u0087\7"+
		"N\2\2\u0087\u0088\7H\2\2\u0088\u0089\5^\60\2\u0089\u008a\7I\2\2\u008a"+
		"\u008b\7L\2\2\u008b\7\3\2\2\2\u008c\u008d\7\24\2\2\u008d\u0092\7N\2\2"+
		"\u008e\u008f\7S\2\2\u008f\u0091\7N\2\2\u0090\u008e\3\2\2\2\u0091\u0094"+
		"\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0095\u0096\7L\2\2\u0096\t\3\2\2\2\u0097\u0098\7H\2\2\u0098"+
		"\u009d\5\f\7\2\u0099\u009a\7S\2\2\u009a\u009c\5\f\7\2\u009b\u0099\3\2"+
		"\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7I\2\2\u00a1\u00a3\3\2"+
		"\2\2\u00a2\u0097\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\13\3\2\2\2\u00a4\u00a6"+
		"\5\32\16\2\u00a5\u00a7\7D\2\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2"+
		"\u00a7\u00a8\3\2\2\2\u00a8\u00ac\7N\2\2\u00a9\u00ab\5\30\r\2\u00aa\u00a9"+
		"\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\r\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7\b\2\2\u00b0\u00b1\7N\2\2"+
		"\u00b1\u00b2\b\b\1\2\u00b2\u00b3\5\n\6\2\u00b3\u00b4\7\16\2\2\u00b4\u00b5"+
		"\5\20\t\2\u00b5\u00b6\7\17\2\2\u00b6\u00b7\b\b\1\2\u00b7\17\3\2\2\2\u00b8"+
		"\u00c3\b\t\1\2\u00b9\u00c2\5.\30\2\u00ba\u00bb\5\24\13\2\u00bb\u00bc\b"+
		"\t\1\2\u00bc\u00c2\3\2\2\2\u00bd\u00be\5\22\n\2\u00be\u00bf\b\t\1\2\u00bf"+
		"\u00c2\3\2\2\2\u00c0\u00c2\5(\25\2\u00c1\u00b9\3\2\2\2\u00c1\u00ba\3\2"+
		"\2\2\u00c1\u00bd\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2"+
		"\2\2\u00c6\u00c8\5\66\34\2\u00c7\u00c9\5\"\22\2\u00c8\u00c7\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00cc\5$\23\2\u00cb\u00ca\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\5<\37\2\u00ce"+
		"\u00d0\b\t\1\2\u00cf\u00d1\5> \2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2"+
		"\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\t\1\2\u00d3\21\3\2\2\2\u00d4\u00d8"+
		"\5\32\16\2\u00d5\u00d7\5\30\r\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2"+
		"\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00d8"+
		"\3\2\2\2\u00db\u00dc\7N\2\2\u00dc\u00dd\7\16\2\2\u00dd\u00de\7O\2\2\u00de"+
		"\u00e4\b\n\1\2\u00df\u00e0\7S\2\2\u00e0\u00e1\7O\2\2\u00e1\u00e3\b\n\1"+
		"\2\u00e2\u00df\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\7\17\2\2"+
		"\u00e8\u00ed\b\n\1\2\u00e9\u00ea\7\60\2\2\u00ea\u00eb\5Z.\2\u00eb\u00ec"+
		"\b\n\1\2\u00ec\u00ee\3\2\2\2\u00ed\u00e9\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00f0\7L\2\2\u00f0\23\3\2\2\2\u00f1\u00f5\5\32\16"+
		"\2\u00f2\u00f4\5\30\r\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2"+
		"\2\2\u00f8\u00f9\5\26\f\2\u00f9\u0100\b\13\1\2\u00fa\u00fb\7S\2\2\u00fb"+
		"\u00fc\5\26\f\2\u00fc\u00fd\b\13\1\2\u00fd\u00ff\3\2\2\2\u00fe\u00fa\3"+
		"\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104\7L\2\2\u0104\25\3\2\2\2"+
		"\u0105\u0106\7N\2\2\u0106\u010b\b\f\1\2\u0107\u0108\7\60\2\2\u0108\u0109"+
		"\5Z.\2\u0109\u010a\b\f\1\2\u010a\u010c\3\2\2\2\u010b\u0107\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\27\3\2\2\2\u010d\u010e\7J\2\2\u010e\u010f\5Z.\2\u010f"+
		"\u0110\7K\2\2\u0110\31\3\2\2\2\u0111\u0112\5\36\20\2\u0112\u0114\7N\2"+
		"\2\u0113\u0115\5 \21\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u012c"+
		"\3\2\2\2\u0116\u0117\5\36\20\2\u0117\u0118\7(\2\2\u0118\u011a\7\16\2\2"+
		"\u0119\u011b\5,\27\2\u011a\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011a"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\7\17\2\2"+
		"\u011f\u012c\3\2\2\2\u0120\u0129\5\36\20\2\u0121\u0122\7\26\2\2\u0122"+
		"\u012a\b\16\1\2\u0123\u0124\7\27\2\2\u0124\u012a\b\16\1\2\u0125\u0126"+
		"\7\n\2\2\u0126\u012a\b\16\1\2\u0127\u0128\7$\2\2\u0128\u012a\b\16\1\2"+
		"\u0129\u0121\3\2\2\2\u0129\u0123\3\2\2\2\u0129\u0125\3\2\2\2\u0129\u0127"+
		"\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u0111\3\2\2\2\u012b\u0116\3\2\2\2\u012b"+
		"\u0120\3\2\2\2\u012c\33\3\2\2\2\u012d\u0131\7N\2\2\u012e\u0130\5\30\r"+
		"\2\u012f\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132"+
		"\3\2\2\2\u0132\35\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0136\7 \2\2\u0135"+
		"\u0134\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0138\3\2\2\2\u0137\u0139\7\4"+
		"\2\2\u0138\u0137\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013e\3\2\2\2\u013a"+
		"\u013c\7\36\2\2\u013b\u013a\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3"+
		"\2\2\2\u013d\u0135\3\2\2\2\u013d\u013b\3\2\2\2\u013e\37\3\2\2\2\u013f"+
		"\u0140\7J\2\2\u0140\u0141\7O\2\2\u0141\u0142\7S\2\2\u0142\u0143\7O\2\2"+
		"\u0143\u0144\7K\2\2\u0144!\3\2\2\2\u0145\u0146\7\t\2\2\u0146\u0147\5&"+
		"\24\2\u0147\u0148\7L\2\2\u0148#\3\2\2\2\u0149\u014a\7 \2\2\u014a\u014b"+
		"\5&\24\2\u014b\u014c\7L\2\2\u014c%\3\2\2\2\u014d\u0152\7N\2\2\u014e\u014f"+
		"\7S\2\2\u014f\u0151\7N\2\2\u0150\u014e\3\2\2\2\u0151\u0154\3\2\2\2\u0152"+
		"\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\'\3\2\2\2\u0154\u0152\3\2\2\2"+
		"\u0155\u0156\7\'\2\2\u0156\u0157\5\32\16\2\u0157\u015c\5*\26\2\u0158\u0159"+
		"\7S\2\2\u0159\u015b\5*\26\2\u015a\u0158\3\2\2\2\u015b\u015e\3\2\2\2\u015c"+
		"\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u015c\3\2"+
		"\2\2\u015f\u0160\7L\2\2\u0160)\3\2\2\2\u0161\u0165\7N\2\2\u0162\u0164"+
		"\5\30\r\2\u0163\u0162\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2"+
		"\u0165\u0166\3\2\2\2\u0166+\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u0169\5"+
		"\32\16\2\u0169\u016e\5\34\17\2\u016a\u016b\7S\2\2\u016b\u016d\5\34\17"+
		"\2\u016c\u016a\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f"+
		"\3\2\2\2\u016f\u0171\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0172\7L\2\2\u0172"+
		"-\3\2\2\2\u0173\u0174\5\32\16\2\u0174\u0175\7N\2\2\u0175\u0176\5\n\6\2"+
		"\u0176\u0177\5\60\31\2\u0177/\3\2\2\2\u0178\u017d\7\16\2\2\u0179\u017c"+
		"\5\24\13\2\u017a\u017c\5(\25\2\u017b\u0179\3\2\2\2\u017b\u017a\3\2\2\2"+
		"\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0183"+
		"\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0182\5\62\32\2\u0181\u0180\3\2\2\2"+
		"\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0186"+
		"\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0187\7\17\2\2\u0187\61\3\2\2\2\u0188"+
		"\u01c3\5\60\31\2\u0189\u01c3\7L\2\2\u018a\u018b\5Z.\2\u018b\u018c\7L\2"+
		"\2\u018c\u01c3\3\2\2\2\u018d\u018e\7\22\2\2\u018e\u018f\7H\2\2\u018f\u0190"+
		"\5V,\2\u0190\u0191\7L\2\2\u0191\u0192\5V,\2\u0192\u0193\7L\2\2\u0193\u0194"+
		"\5V,\2\u0194\u0195\7I\2\2\u0195\u0196\5\62\32\2\u0196\u01c3\3\2\2\2\u0197"+
		"\u0198\7\r\2\2\u0198\u0199\7H\2\2\u0199\u019a\5V,\2\u019a\u019b\7I\2\2"+
		"\u019b\u019c\5\62\32\2\u019c\u01c3\3\2\2\2\u019d\u019e\7\30\2\2\u019e"+
		"\u019f\5\62\32\2\u019f\u01a0\7\r\2\2\u01a0\u01a1\7H\2\2\u01a1\u01a2\5"+
		"V,\2\u01a2\u01a3\7I\2\2\u01a3\u01a4\7L\2\2\u01a4\u01c3\3\2\2\2\u01a5\u01a6"+
		"\7\21\2\2\u01a6\u01a7\7H\2\2\u01a7\u01a8\5V,\2\u01a8\u01a9\7I\2\2\u01a9"+
		"\u01ac\5\62\32\2\u01aa\u01ab\7&\2\2\u01ab\u01ad\5\62\32\2\u01ac\u01aa"+
		"\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01c3\3\2\2\2\u01ae\u01af\7\25\2\2"+
		"\u01af\u01c3\7L\2\2\u01b0\u01b1\7\31\2\2\u01b1\u01b2\7H\2\2\u01b2\u01b3"+
		"\5V,\2\u01b3\u01b4\7I\2\2\u01b4\u01b6\7\16\2\2\u01b5\u01b7\5\64\33\2\u01b6"+
		"\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2"+
		"\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\7\17\2\2\u01bb\u01c3\3\2\2\2\u01bc"+
		"\u01bd\7\13\2\2\u01bd\u01c3\7L\2\2\u01be\u01bf\7\13\2\2\u01bf\u01c0\5"+
		"Z.\2\u01c0\u01c1\7L\2\2\u01c1\u01c3\3\2\2\2\u01c2\u0188\3\2\2\2\u01c2"+
		"\u0189\3\2\2\2\u01c2\u018a\3\2\2\2\u01c2\u018d\3\2\2\2\u01c2\u0197\3\2"+
		"\2\2\u01c2\u019d\3\2\2\2\u01c2\u01a5\3\2\2\2\u01c2\u01ae\3\2\2\2\u01c2"+
		"\u01b0\3\2\2\2\u01c2\u01bc\3\2\2\2\u01c2\u01be\3\2\2\2\u01c3\63\3\2\2"+
		"\2\u01c4\u01c5\7\34\2\2\u01c5\u01c6\5Z.\2\u01c6\u01ca\7!\2\2\u01c7\u01c9"+
		"\5\62\32\2\u01c8\u01c7\3\2\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01c8\3\2\2\2"+
		"\u01ca\u01cb\3\2\2\2\u01cb\u01d6\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01ce"+
		"\7\5\2\2\u01ce\u01d2\7!\2\2\u01cf\u01d1\5\62\32\2\u01d0\u01cf\3\2\2\2"+
		"\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d6"+
		"\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\u01c4\3\2\2\2\u01d5\u01cd\3\2\2\2\u01d6"+
		"\65\3\2\2\2\u01d7\u01d8\7\7\2\2\u01d8\u01d9\58\35\2\u01d9\u01e0\b\34\1"+
		"\2\u01da\u01db\7S\2\2\u01db\u01dc\58\35\2\u01dc\u01dd\b\34\1\2\u01dd\u01df"+
		"\3\2\2\2\u01de\u01da\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0"+
		"\u01e1\3\2\2\2\u01e1\u01e3\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e3\u01e4\7L"+
		"\2\2\u01e4\67\3\2\2\2\u01e5\u01e6\7N\2\2\u01e6\u01ef\b\35\1\2\u01e7\u01e8"+
		"\7N\2\2\u01e8\u01e9\7\16\2\2\u01e9\u01ea\5:\36\2\u01ea\u01eb\7\17\2\2"+
		"\u01eb\u01ec\3\2\2\2\u01ec\u01ed\b\35\1\2\u01ed\u01ef\3\2\2\2\u01ee\u01e5"+
		"\3\2\2\2\u01ee\u01e7\3\2\2\2\u01ef9\3\2\2\2\u01f0\u01f1\7N\2\2\u01f1\u01f2"+
		"\t\2\2\2\u01f2\u01f3\5Z.\2\u01f3\u01f4\b\36\1\2\u01f4;\3\2\2\2\u01f5\u01f6"+
		"\7\37\2\2\u01f6\u01f7\7N\2\2\u01f7\u01f8\7L\2\2\u01f8\u01f9\b\37\1\2\u01f9"+
		"=\3\2\2\2\u01fa\u01fb\7\32\2\2\u01fb\u01fc\5@!\2\u01fc\u0202\b \1\2\u01fd"+
		"\u01fe\5@!\2\u01fe\u01ff\b \1\2\u01ff\u0201\3\2\2\2\u0200\u01fd\3\2\2"+
		"\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0205"+
		"\3\2\2\2\u0204\u0202\3\2\2\2\u0205\u0206\7L\2\2\u0206?\3\2\2\2\u0207\u0208"+
		"\7N\2\2\u0208\u0209\7\33\2\2\u0209\u020a\7N\2\2\u020a\u020b\5B\"\2\u020b"+
		"\u0214\b!\1\2\u020c\u020d\7S\2\2\u020d\u020e\7\33\2\2\u020e\u020f\7N\2"+
		"\2\u020f\u0210\5B\"\2\u0210\u0211\b!\1\2\u0211\u0213\3\2\2\2\u0212\u020c"+
		"\3\2\2\2\u0213\u0216\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215"+
		"\u022a\3\2\2\2\u0216\u0214\3\2\2\2\u0217\u0218\7S\2\2\u0218\u0219\7N\2"+
		"\2\u0219\u021a\7\33\2\2\u021a\u021b\7N\2\2\u021b\u021c\5B\"\2\u021c\u0225"+
		"\b!\1\2\u021d\u021e\7S\2\2\u021e\u021f\7\33\2\2\u021f\u0220\7N\2\2\u0220"+
		"\u0221\5B\"\2\u0221\u0222\b!\1\2\u0222\u0224\3\2\2\2\u0223\u021d\3\2\2"+
		"\2\u0224\u0227\3\2\2\2\u0225\u0223\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0229"+
		"\3\2\2\2\u0227\u0225\3\2\2\2\u0228\u0217\3\2\2\2\u0229\u022c\3\2\2\2\u022a"+
		"\u0228\3\2\2\2\u022a\u022b\3\2\2\2\u022bA\3\2\2\2\u022c\u022a\3\2\2\2"+
		"\u022d\u0231\7\16\2\2\u022e\u022f\5D#\2\u022f\u0230\b\"\1\2\u0230\u0232"+
		"\3\2\2\2\u0231\u022e\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0233\3\2\2\2\u0233"+
		"\u0234\b\"\1\2\u0234\u0235\5L\'\2\u0235\u0236\b\"\1\2\u0236\u023a\3\2"+
		"\2\2\u0237\u0238\5N(\2\u0238\u0239\b\"\1\2\u0239\u023b\3\2\2\2\u023a\u0237"+
		"\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d\7\17\2\2"+
		"\u023d\u023e\b\"\1\2\u023eC\3\2\2\2\u023f\u0240\7\6\2\2\u0240\u0241\5"+
		"F$\2\u0241\u0242\7L\2\2\u0242\u0243\b#\1\2\u0243E\3\2\2\2\u0244\u0245"+
		"\5H%\2\u0245\u0250\b$\1\2\u0246\u024a\7S\2\2\u0247\u024a\3\2\2\2\u0248"+
		"\u024a\7B\2\2\u0249\u0246\3\2\2\2\u0249\u0247\3\2\2\2\u0249\u0248\3\2"+
		"\2\2\u024a\u024b\3\2\2\2\u024b\u024c\5H%\2\u024c\u024d\b$\1\2\u024d\u024f"+
		"\3\2\2\2\u024e\u0249\3\2\2\2\u024f\u0252\3\2\2\2\u0250\u024e\3\2\2\2\u0250"+
		"\u0251\3\2\2\2\u0251G\3\2\2\2\u0252\u0250\3\2\2\2\u0253\u0254\5J&\2\u0254"+
		"\u0255\b%\1\2\u0255I\3\2\2\2\u0256\u0257\7N\2\2\u0257\u0258\t\3\2\2\u0258"+
		"\u0259\7O\2\2\u0259\u025a\b&\1\2\u025aK\3\2\2\2\u025b\u025c\7\3\2\2\u025c"+
		"\u025d\7N\2\2\u025d\u025e\t\4\2\2\u025e\u025f\7L\2\2\u025f\u0260\3\2\2"+
		"\2\u0260\u0268\b\'\1\2\u0261\u0262\7\3\2\2\u0262\u0263\7N\2\2\u0263\u0264"+
		"\7L\2\2\u0264\u0265\3\2\2\2\u0265\u0268\b\'\1\2\u0266\u0268\b\'\1\2\u0267"+
		"\u025b\3\2\2\2\u0267\u0261\3\2\2\2\u0267\u0266\3\2\2\2\u0268M\3\2\2\2"+
		"\u0269\u026a\7\35\2\2\u026a\u026b\5P)\2\u026b\u026c\7L\2\2\u026c\u026d"+
		"\b(\1\2\u026dO\3\2\2\2\u026e\u026f\5R*\2\u026f\u0270\b)\1\2\u0270\u0277"+
		"\3\2\2\2\u0271\u0272\7S\2\2\u0272\u0273\5R*\2\u0273\u0274\b)\1\2\u0274"+
		"\u0276\3\2\2\2\u0275\u0271\3\2\2\2\u0276\u0279\3\2\2\2\u0277\u0275\3\2"+
		"\2\2\u0277\u0278\3\2\2\2\u0278Q\3\2\2\2\u0279\u0277\3\2\2\2\u027a\u027b"+
		"\7N\2\2\u027b\u027c\t\5\2\2\u027c\u027d\7O\2\2\u027d\u027e\3\2\2\2\u027e"+
		"\u0286\b*\1\2\u027f\u0280\7N\2\2\u0280\u0281\t\5\2\2\u0281\u0282\5X-\2"+
		"\u0282\u0283\3\2\2\2\u0283\u0284\b*\1\2\u0284\u0286\3\2\2\2\u0285\u027a"+
		"\3\2\2\2\u0285\u027f\3\2\2\2\u0286S\3\2\2\2\u0287\u0288\7N\2\2\u0288\u0289"+
		"\7\60\2\2\u0289\u028a\7O\2\2\u028a\u028b\3\2\2\2\u028b\u028c\b+\1\2\u028c"+
		"U\3\2\2\2\u028d\u028e\5Z.\2\u028e\u0295\b,\1\2\u028f\u0290\7S\2\2\u0290"+
		"\u0291\5Z.\2\u0291\u0292\b,\1\2\u0292\u0294\3\2\2\2\u0293\u028f\3\2\2"+
		"\2\u0294\u0297\3\2\2\2\u0295\u0293\3\2\2\2\u0295\u0296\3\2\2\2\u0296W"+
		"\3\2\2\2\u0297\u0295\3\2\2\2\u0298\u0299\5Z.\2\u0299\u029a\b-\1\2\u029a"+
		"Y\3\2\2\2\u029b\u029c\b.\1\2\u029c\u029d\t\6\2\2\u029d\u029e\5Z.\17\u029e"+
		"\u029f\b.\1\2\u029f\u02a9\3\2\2\2\u02a0\u02a1\t\7\2\2\u02a1\u02a2\5Z."+
		"\16\u02a2\u02a3\b.\1\2\u02a3\u02a9\3\2\2\2\u02a4\u02a5\7N\2\2\u02a5\u02a9"+
		"\b.\1\2\u02a6\u02a7\7O\2\2\u02a7\u02a9\b.\1\2\u02a8\u029b\3\2\2\2\u02a8"+
		"\u02a0\3\2\2\2\u02a8\u02a4\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a9\u02e8\3\2"+
		"\2\2\u02aa\u02ab\f\r\2\2\u02ab\u02ac\t\b\2\2\u02ac\u02ad\5Z.\16\u02ad"+
		"\u02ae\b.\1\2\u02ae\u02e7\3\2\2\2\u02af\u02b0\f\f\2\2\u02b0\u02b1\t\t"+
		"\2\2\u02b1\u02b2\5Z.\r\u02b2\u02b3\b.\1\2\u02b3\u02e7\3\2\2\2\u02b4\u02b5"+
		"\f\13\2\2\u02b5\u02b6\t\2\2\2\u02b6\u02b7\5Z.\f\u02b7\u02b8\b.\1\2\u02b8"+
		"\u02e7\3\2\2\2\u02b9\u02ba\f\n\2\2\u02ba\u02bb\t\n\2\2\u02bb\u02bc\5Z"+
		".\13\u02bc\u02bd\b.\1\2\u02bd\u02e7\3\2\2\2\u02be\u02bf\f\t\2\2\u02bf"+
		"\u02c0\7D\2\2\u02c0\u02c1\5Z.\n\u02c1\u02c2\b.\1\2\u02c2\u02e7\3\2\2\2"+
		"\u02c3\u02c4\f\b\2\2\u02c4\u02c5\7?\2\2\u02c5\u02c6\5Z.\t\u02c6\u02c7"+
		"\b.\1\2\u02c7\u02e7\3\2\2\2\u02c8\u02c9\f\7\2\2\u02c9\u02ca\7G\2\2\u02ca"+
		"\u02cb\5Z.\b\u02cb\u02cc\b.\1\2\u02cc\u02e7\3\2\2\2\u02cd\u02ce\f\6\2"+
		"\2\u02ce\u02cf\7B\2\2\u02cf\u02d0\5Z.\7\u02d0\u02d1\b.\1\2\u02d1\u02e7"+
		"\3\2\2\2\u02d2\u02d3\f\5\2\2\u02d3\u02d4\7C\2\2\u02d4\u02d5\5Z.\6\u02d5"+
		"\u02d6\b.\1\2\u02d6\u02e7\3\2\2\2\u02d7\u02d8\f\4\2\2\u02d8\u02d9\7\23"+
		"\2\2\u02d9\u02da\5Z.\2\u02da\u02db\7!\2\2\u02db\u02dc\5Z.\5\u02dc\u02dd"+
		"\b.\1\2\u02dd\u02e7\3\2\2\2\u02de\u02df\f\3\2\2\u02df\u02e0\t\13\2\2\u02e0"+
		"\u02e1\5Z.\4\u02e1\u02e2\b.\1\2\u02e2\u02e7\3\2\2\2\u02e3\u02e4\f\20\2"+
		"\2\u02e4\u02e5\t\f\2\2\u02e5\u02e7\b.\1\2\u02e6\u02aa\3\2\2\2\u02e6\u02af"+
		"\3\2\2\2\u02e6\u02b4\3\2\2\2\u02e6\u02b9\3\2\2\2\u02e6\u02be\3\2\2\2\u02e6"+
		"\u02c3\3\2\2\2\u02e6\u02c8\3\2\2\2\u02e6\u02cd\3\2\2\2\u02e6\u02d2\3\2"+
		"\2\2\u02e6\u02d7\3\2\2\2\u02e6\u02de\3\2\2\2\u02e6\u02e3\3\2\2\2\u02e7"+
		"\u02ea\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9[\3\2\2\2"+
		"\u02ea\u02e8\3\2\2\2\u02eb\u02ec\7N\2\2\u02ec\u02ed\7\60\2\2\u02ed\u02ee"+
		"\5Z.\2\u02ee\u02ef\3\2\2\2\u02ef\u02f0\b/\1\2\u02f0\u02f8\3\2\2\2\u02f1"+
		"\u02f2\7N\2\2\u02f2\u02f3\7:\2\2\u02f3\u02f4\5Z.\2\u02f4\u02f5\3\2\2\2"+
		"\u02f5\u02f6\b/\1\2\u02f6\u02f8\3\2\2\2\u02f7\u02eb\3\2\2\2\u02f7\u02f1"+
		"\3\2\2\2\u02f8]\3\2\2\2\u02f9\u02fe\5Z.\2\u02fa\u02fb\7S\2\2\u02fb\u02fd"+
		"\5^\60\2\u02fc\u02fa\3\2\2\2\u02fd\u0300\3\2\2\2\u02fe\u02fc\3\2\2\2\u02fe"+
		"\u02ff\3\2\2\2\u02ff\u0301\3\2\2\2\u0300\u02fe\3\2\2\2\u0301\u0302\b\60"+
		"\1\2\u0302\u0305\3\2\2\2\u0303\u0305\3\2\2\2\u0304\u02f9\3\2\2\2\u0304"+
		"\u0303\3\2\2\2\u0305_\3\2\2\2@flr\u0082\u0092\u009d\u00a2\u00a6\u00ac"+
		"\u00c1\u00c3\u00c8\u00cb\u00d0\u00d8\u00e4\u00ed\u00f5\u0100\u010b\u0114"+
		"\u011c\u0129\u012b\u0131\u0135\u0138\u013b\u013d\u0152\u015c\u0165\u016e"+
		"\u017b\u017d\u0183\u01ac\u01b8\u01c2\u01ca\u01d2\u01d5\u01e0\u01ee\u0202"+
		"\u0214\u0225\u022a\u0231\u023a\u0249\u0250\u0267\u0277\u0285\u0295\u02a8"+
		"\u02e6\u02e8\u02f7\u02fe\u0304";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}