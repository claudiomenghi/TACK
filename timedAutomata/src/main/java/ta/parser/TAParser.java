// Generated from TA.g4 by ANTLR 4.5

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
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		LE=39, LEQ=40, GEQ=41, GE=42, EQCOMP=43, NEQ=44, EQASSIGN=45, EQ=46, FRACTEQ=47, 
		MODEQ=48, PLUS=49, PLUSPLUS=50, MINUSMINUS=51, MINUS=52, MULT=53, PLUSEQ=54, 
		MINUSEQ=55, COLUMEQ=56, MULTEQ=57, POWEQ=58, FRACT=59, MOD=60, POW=61, 
		BIN_PROPOSITIONAL_LOGIC_OPERATOR=62, NOT=63, AND=64, OR=65, BITAND=66, 
		BITANDEQ=67, BITOREQ=68, BITOR=69, LPAR=70, RPAR=71, LBRA=72, RBRA=73, 
		SEMICOLUMN=74, WS=75, ID=76, NAT=77, TRUE=78, FALSE=79, NEWLINE=80, COMMA=81, 
		COMMENT=82, LINE_COMMENT=83;
	public static final int
		RULE_ta = 0, RULE_declaration = 1, RULE_instantiation = 2, RULE_system = 3, 
		RULE_parameterList = 4, RULE_parameter = 5, RULE_procDecl = 6, RULE_procBody = 7, 
		RULE_variableDecl = 8, RULE_variableId = 9, RULE_arrayDecl = 10, RULE_type = 11, 
		RULE_fieldDeclId = 12, RULE_prefix = 13, RULE_range = 14, RULE_commit = 15, 
		RULE_urgent = 16, RULE_stateList = 17, RULE_typeDecl = 18, RULE_typeIdList = 19, 
		RULE_fieldDecl = 20, RULE_functionDecl = 21, RULE_block = 22, RULE_statement = 23, 
		RULE_caseocc = 24, RULE_states = 25, RULE_stateDecl = 26, RULE_invariant = 27, 
		RULE_init = 28, RULE_transitions = 29, RULE_transitionset = 30, RULE_transitionBody = 31, 
		RULE_guard = 32, RULE_guardconditionList = 33, RULE_clockconstraint = 34, 
		RULE_clockconstraintprime = 35, RULE_constraintAtom = 36, RULE_sync = 37, 
		RULE_assign = 38, RULE_assignmentList = 39, RULE_assignment = 40, RULE_simpleassigment = 41, 
		RULE_exprList = 42, RULE_exprStatement = 43, RULE_expression = 44, RULE_declarationid = 45, 
		RULE_argList = 46;
	public static final String[] ruleNames = {
		"ta", "declaration", "instantiation", "system", "parameterList", "parameter", 
		"procDecl", "procBody", "variableDecl", "variableId", "arrayDecl", "type", 
		"fieldDeclId", "prefix", "range", "commit", "urgent", "stateList", "typeDecl", 
		"typeIdList", "fieldDecl", "functionDecl", "block", "statement", "caseocc", 
		"states", "stateDecl", "invariant", "init", "transitions", "transitionset", 
		"transitionBody", "guard", "guardconditionList", "clockconstraint", "clockconstraintprime", 
		"constraintAtom", "sync", "assign", "assignmentList", "assignment", "simpleassigment", 
		"exprList", "exprStatement", "expression", "declarationid", "argList"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'system'", "'process'", "'{'", "'}'", "'struct'", "'int'", "'clock'", 
		"'char'", "'bool'", "'urgent'", "'broadcast'", "'const'", "'commit'", 
		"'typedef'", "'for'", "'while'", "'do'", "'if'", "'else'", "'break'", 
		"'switch'", "'return'", "'case'", "':'", "'default'", "'state'", "'init'", 
		"'trans'", "'->'", "'guard'", "'sync'", "'!'", "'?'", "'assign'", "'~'", 
		"'>>='", "'>>>='", "'<<='", "'<'", "'<='", "'>='", "'>'", "'=='", "'!='", 
		null, "'='", "'/='", "'%='", "'+'", "'++'", "'--'", "'-'", "'*'", "'+='", 
		"'-='", null, "'*='", "'^='", "'/'", "'%'", "'^'", null, null, "'&&'", 
		"'||'", "'&'", "'&='", "'|='", "'|'", "'('", "')'", "'['", "']'", "';'", 
		null, null, null, "'true'", "'false'", null, "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "LE", "LEQ", "GEQ", "GE", "EQCOMP", "NEQ", "EQASSIGN", 
		"EQ", "FRACTEQ", "MODEQ", "PLUS", "PLUSPLUS", "MINUSMINUS", "MINUS", "MULT", 
		"PLUSEQ", "MINUSEQ", "COLUMEQ", "MULTEQ", "POWEQ", "FRACT", "MOD", "POW", 
		"BIN_PROPOSITIONAL_LOGIC_OPERATOR", "NOT", "AND", "OR", "BITAND", "BITANDEQ", 
		"BITOREQ", "BITOR", "LPAR", "RPAR", "LBRA", "RBRA", "SEMICOLUMN", "WS", 
		"ID", "NAT", "TRUE", "FALSE", "NEWLINE", "COMMA", "COMMENT", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	  boolean matchedEOF=false;
	 	
	 	 private static Map<String, String> declarations = new HashMap<String, String>();
	 	  private static Map<String, String> currentTaDeclarations = new HashMap<String, String>();
	 	  
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
	 
	public TAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TaContext extends ParserRuleContext {
		public SystemDecl systemret;
		public DeclarationContext dec;
		public DeclarationContext declaration;
		public TerminalNode EOF() { return getToken(TAParser.EOF, 0); }
		public List<InstantiationContext> instantiation() {
			return getRuleContexts(InstantiationContext.class);
		}
		public InstantiationContext instantiation(int i) {
			return getRuleContext(InstantiationContext.class,i);
		}
		public List<SystemContext> system() {
			return getRuleContexts(SystemContext.class);
		}
		public SystemContext system(int i) {
			return getRuleContext(SystemContext.class,i);
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

			((TaContext)_localctx).systemret =  new SystemDecl();
			declarations = new HashMap<String, String>();	
			currentTaDeclarations = new HashMap<String, String>();

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
					setState(94);
					((TaContext)_localctx).dec = ((TaContext)_localctx).declaration = declaration();

								if(((TaContext)_localctx).declaration.timedAutomaton!=null){
									_localctx.systemret.addTA(((TaContext)_localctx).declaration.timedAutomaton);
								}			
							
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
				setState(102);
				instantiation();
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
				setState(108);
				system();
				}
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(113);
			match(EOF);
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
		public VariableDeclContext variableDecl;
		public ProcDeclContext procDecl;
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public TypeDeclContext typeDecl() {
			return getRuleContext(TypeDeclContext.class,0);
		}
		public ProcDeclContext procDecl() {
			return getRuleContext(ProcDeclContext.class,0);
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
		try {
			setState(123);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				functionDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				((DeclarationContext)_localctx).variableDecl = variableDecl();

				 		declarations.putAll(((DeclarationContext)_localctx).variableDecl.variabledeclret);
				 	
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				typeDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				((DeclarationContext)_localctx).procDecl = procDecl();

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
		public List<TerminalNode> ID() { return getTokens(TAParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TAParser.ID, i);
		}
		public DeclarationidContext declarationid() {
			return getRuleContext(DeclarationidContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(TAParser.LPAR, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
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
			setState(125);
			match(ID);
			setState(126);
			declarationid();
			setState(127);
			match(ID);
			setState(128);
			match(LPAR);
			setState(129);
			argList();
			setState(130);
			match(RPAR);
			setState(131);
			match(SEMICOLUMN);
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
			setState(133);
			match(T__0);
			setState(134);
			match(ID);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(135);
				match(COMMA);
				setState(136);
				match(ID);
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			match(SEMICOLUMN);
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
		public TerminalNode LPAR() { return getToken(TAParser.LPAR, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
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
			setState(155);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(144);
				match(LPAR);
				setState(145);
				parameter();
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(146);
					match(COMMA);
					setState(147);
					parameter();
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(153);
				match(RPAR);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode BITAND() { return getToken(TAParser.BITAND, 0); }
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
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
			setState(157);
			type();
			setState(159);
			_la = _input.LA(1);
			if (_la==BITAND) {
				{
				setState(158);
				match(BITAND);
				}
			}

			setState(161);
			match(ID);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(162);
				arrayDecl();
				}
				}
				setState(167);
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
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ProcBodyContext procBody() {
			return getRuleContext(ProcBodyContext.class,0);
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
			setState(168);
			match(T__1);
			setState(169);
			((ProcDeclContext)_localctx).ID = match(ID);
			setState(170);
			parameterList();
			setState(171);
			match(T__2);
			setState(172);
			((ProcDeclContext)_localctx).procBody = procBody();
			setState(173);
			match(T__3);

				
				 
				 cleanCurrentTA();
				 Map<String, String> variabledeclret=((ProcDeclContext)_localctx).procBody.variabledeclret;
				 
				  final Set<Clock> clocks=new HashSet<>();
				  
				  for(Entry<String, String> entry: variabledeclret.entrySet()){
				  	if(entry.getValue().equals("clock")){
				  			clocks.add(new Clock(entry.getKey()));
						
				  	}
				  }
				for(Entry<String, String> entry: declarations.entrySet()){
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
				for(Entry<String, String> entry: declarations.entrySet()){
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
				
					 variableDeclaration.add(new VariableDecl(type,  entry.getKey(), entry.getValue()));
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
		public StatesContext states;
		public InitContext init;
		public TransitionsContext transitions;
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<VariableDeclContext> variableDecl() {
			return getRuleContexts(VariableDeclContext.class);
		}
		public VariableDeclContext variableDecl(int i) {
			return getRuleContext(VariableDeclContext.class,i);
		}
		public List<TypeDeclContext> typeDecl() {
			return getRuleContexts(TypeDeclContext.class);
		}
		public TypeDeclContext typeDecl(int i) {
			return getRuleContext(TypeDeclContext.class,i);
		}
		public CommitContext commit() {
			return getRuleContext(CommitContext.class,0);
		}
		public UrgentContext urgent() {
			return getRuleContext(UrgentContext.class,0);
		}
		public TransitionsContext transitions() {
			return getRuleContext(TransitionsContext.class,0);
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
			 	
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13))) != 0) || _la==ID) {
				{
				setState(182);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(177);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(178);
					((ProcBodyContext)_localctx).variableDecl = variableDecl();

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
					setState(181);
					typeDecl();
					}
					break;
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			((ProcBodyContext)_localctx).states = states();
			setState(189);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(188);
				commit();
				}
			}

			setState(192);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(191);
				urgent();
				}
			}

			setState(194);
			((ProcBodyContext)_localctx).init = init();
			setState(196);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(195);
				((ProcBodyContext)_localctx).transitions = transitions();
				}
			}


			 				    	((ProcBodyContext)_localctx).initstate = ((ProcBodyContext)_localctx).init.initstate;
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

	public static class VariableDeclContext extends ParserRuleContext {
		public Map<String, String> variabledeclret;
		public Map<String, Expression> variableinitializationret;
		public Map<String, Value> clockinitializationret;
		public TypeContext type;
		public VariableIdContext var1;
		public VariableIdContext varn;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VariableIdContext> variableId() {
			return getRuleContexts(VariableIdContext.class);
		}
		public VariableIdContext variableId(int i) {
			return getRuleContext(VariableIdContext.class,i);
		}
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
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
		enterRule(_localctx, 16, RULE_variableDecl);

		 	((VariableDeclContext)_localctx).variabledeclret = new HashMap<>();
		 	((VariableDeclContext)_localctx).variableinitializationret = new HashMap<>();
		 	((VariableDeclContext)_localctx).clockinitializationret = new HashMap<>();
		 	
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			((VariableDeclContext)_localctx).type = type();
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(201);
				arrayDecl();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(207);
			((VariableDeclContext)_localctx).var1 = variableId();

			 			if(definedVar(((VariableDeclContext)_localctx).var1.id)){
			 				
			 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+((VariableDeclContext)_localctx).var1.id);
					
			 			}
			 			_localctx.variabledeclret.put(((VariableDeclContext)_localctx).var1.id, (((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null));
			 			if(((VariableDeclContext)_localctx).var1.exp!=null && !(((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null).equals("clock")){
			 				_localctx.variableinitializationret.put(((VariableDeclContext)_localctx).var1.id, ((VariableDeclContext)_localctx).var1.exp);
			 			}
			 			if(((VariableDeclContext)_localctx).var1.exp!=null && (((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null).equals("clock")){
			 				
			 				 _localctx.clockinitializationret.put(((VariableDeclContext)_localctx).var1.id, (Value) ((VariableDeclContext)_localctx).var1.exp);
			 			}
			 			
			 	
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(209);
				match(COMMA);
				setState(210);
				((VariableDeclContext)_localctx).varn = variableId();

				 			
				 			if(definedVar(((VariableDeclContext)_localctx).varn.id)){
				 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+((VariableDeclContext)_localctx).varn.id);
						
				 			}
				 			_localctx.variabledeclret.put(((VariableDeclContext)_localctx).varn.id, (((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null));
				 			System.out.println((((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null));
				 			if(((VariableDeclContext)_localctx).var1.exp!=null && !(((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null).equals("clock")){
				 				_localctx.variableinitializationret.put(((VariableDeclContext)_localctx).var1.id, ((VariableDeclContext)_localctx).var1.exp);
				 			}
				 		 	if(((VariableDeclContext)_localctx).var1.exp!=null && (((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null).equals("clock")){
								_localctx.clockinitializationret.put(((VariableDeclContext)_localctx).var1.id, (Value) ((VariableDeclContext)_localctx).var1.exp);
				 			}
				 		
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(218);
			match(SEMICOLUMN);
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
		enterRule(_localctx, 18, RULE_variableId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			((VariableIdContext)_localctx).ID = match(ID);

					((VariableIdContext)_localctx).id = (((VariableIdContext)_localctx).ID!=null?((VariableIdContext)_localctx).ID.getText():null);

			setState(226);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(222);
				match(EQ);
				setState(223);
				((VariableIdContext)_localctx).expression = expression(0);

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
		public TerminalNode LBRA() { return getToken(TAParser.LBRA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 20, RULE_arrayDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(LBRA);
			setState(229);
			expression(0);
			setState(230);
			match(RBRA);
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
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
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
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			setState(258);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				prefix();
				setState(233);
				match(ID);
				setState(235);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(234);
					range();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				prefix();
				setState(238);
				match(T__4);
				setState(239);
				match(T__2);
				setState(241); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(240);
					fieldDecl();
					}
					}
					setState(243); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0) || _la==ID );
				setState(245);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				prefix();
				setState(256);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(248);
					match(T__5);
					 ((TypeContext)_localctx).typeret = Integer.class;
					                		 
					}
					break;
				case T__6:
					{
					setState(250);
					match(T__6);
					 ((TypeContext)_localctx).typeret = Clock.class;
					                		 
					}
					break;
				case T__7:
					{
					setState(252);
					match(T__7);
					 ((TypeContext)_localctx).typeret = Character.class;
					                		 
					}
					break;
				case T__8:
					{
					setState(254);
					match(T__8);
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
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
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
		enterRule(_localctx, 24, RULE_fieldDeclId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(ID);
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(261);
				arrayDecl();
				}
				}
				setState(266);
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
		enterRule(_localctx, 26, RULE_prefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(268);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(267);
					match(T__9);
					}
				}

				setState(271);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(270);
					match(T__10);
					}
				}

				}
				break;
			case 2:
				{
				setState(274);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(273);
					match(T__11);
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
		public TerminalNode LBRA() { return getToken(TAParser.LBRA, 0); }
		public List<TerminalNode> NAT() { return getTokens(TAParser.NAT); }
		public TerminalNode NAT(int i) {
			return getToken(TAParser.NAT, i);
		}
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
		enterRule(_localctx, 28, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(LBRA);
			setState(279);
			match(NAT);
			setState(280);
			match(COMMA);
			setState(281);
			match(NAT);
			setState(282);
			match(RBRA);
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
		public StateListContext stateList() {
			return getRuleContext(StateListContext.class,0);
		}
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
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
		enterRule(_localctx, 30, RULE_commit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(T__12);
			setState(285);
			stateList();
			setState(286);
			match(SEMICOLUMN);
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
		public StateListContext stateList() {
			return getRuleContext(StateListContext.class,0);
		}
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
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
		enterRule(_localctx, 32, RULE_urgent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(T__9);
			setState(289);
			stateList();
			setState(290);
			match(SEMICOLUMN);
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
		enterRule(_localctx, 34, RULE_stateList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(ID);
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(293);
				match(COMMA);
				setState(294);
				match(ID);
				}
				}
				setState(299);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TypeIdListContext> typeIdList() {
			return getRuleContexts(TypeIdListContext.class);
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
		enterRule(_localctx, 36, RULE_typeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(T__13);
			setState(301);
			type();
			setState(302);
			typeIdList();
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(303);
				match(COMMA);
				setState(304);
				typeIdList();
				}
				}
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(310);
			match(SEMICOLUMN);
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
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
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
		enterRule(_localctx, 38, RULE_typeIdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(ID);
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(313);
				arrayDecl();
				}
				}
				setState(318);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<FieldDeclIdContext> fieldDeclId() {
			return getRuleContexts(FieldDeclIdContext.class);
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
		enterRule(_localctx, 40, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			type();
			setState(320);
			fieldDeclId();
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(321);
				match(COMMA);
				setState(322);
				fieldDeclId();
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(328);
			match(SEMICOLUMN);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
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
		enterRule(_localctx, 42, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			type();
			setState(331);
			match(ID);
			setState(332);
			parameterList();
			setState(333);
			block();
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
		public TypeDeclContext typeDecl(int i) {
			return getRuleContext(TypeDeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		enterRule(_localctx, 44, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(T__2);
			setState(340);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(338);
					switch (_input.LA(1)) {
					case T__4:
					case T__5:
					case T__6:
					case T__7:
					case T__8:
					case T__9:
					case T__10:
					case T__11:
					case ID:
						{
						setState(336);
						variableDecl();
						}
						break;
					case T__13:
						{
						setState(337);
						typeDecl();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(342);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__34) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
				{
				{
				setState(343);
				statement();
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(349);
			match(T__3);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ExprListContext> exprList() {
			return getRuleContexts(ExprListContext.class);
		}
		public ExprListContext exprList(int i) {
			return getRuleContext(ExprListContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<CaseoccContext> caseocc() {
			return getRuleContexts(CaseoccContext.class);
		}
		public CaseoccContext caseocc(int i) {
			return getRuleContext(CaseoccContext.class,i);
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
		enterRule(_localctx, 46, RULE_statement);
		int _la;
		try {
			setState(409);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				match(SEMICOLUMN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(353);
				expression(0);
				setState(354);
				match(SEMICOLUMN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(356);
				match(T__14);
				setState(357);
				match(LPAR);
				setState(358);
				exprList();
				setState(359);
				match(SEMICOLUMN);
				setState(360);
				exprList();
				setState(361);
				match(SEMICOLUMN);
				setState(362);
				exprList();
				setState(363);
				match(RPAR);
				setState(364);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(366);
				match(T__15);
				setState(367);
				match(LPAR);
				setState(368);
				exprList();
				setState(369);
				match(RPAR);
				setState(370);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(372);
				match(T__16);
				setState(373);
				statement();
				setState(374);
				match(T__15);
				setState(375);
				match(LPAR);
				setState(376);
				exprList();
				setState(377);
				match(RPAR);
				setState(378);
				match(SEMICOLUMN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(380);
				match(T__17);
				setState(381);
				match(LPAR);
				setState(382);
				exprList();
				setState(383);
				match(RPAR);
				setState(384);
				statement();
				setState(387);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(385);
					match(T__18);
					setState(386);
					statement();
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(389);
				match(T__19);
				setState(390);
				match(SEMICOLUMN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(391);
				match(T__20);
				setState(392);
				match(LPAR);
				setState(393);
				exprList();
				setState(394);
				match(RPAR);
				setState(395);
				match(T__2);
				setState(397); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(396);
					caseocc();
					}
					}
					setState(399); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__22 || _la==T__24 );
				setState(401);
				match(T__3);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(403);
				match(T__21);
				setState(404);
				match(SEMICOLUMN);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(405);
				match(T__21);
				setState(406);
				expression(0);
				setState(407);
				match(SEMICOLUMN);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		enterRule(_localctx, 48, RULE_caseocc);
		int _la;
		try {
			setState(428);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				match(T__22);
				setState(412);
				expression(0);
				setState(413);
				match(T__23);
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__34) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
					{
					{
					setState(414);
					statement();
					}
					}
					setState(419);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				match(T__24);
				setState(421);
				match(T__23);
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__34) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
					{
					{
					setState(422);
					statement();
					}
					}
					setState(427);
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
		public List<StateDeclContext> stateDecl() {
			return getRuleContexts(StateDeclContext.class);
		}
		public StateDeclContext stateDecl(int i) {
			return getRuleContext(StateDeclContext.class,i);
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
		enterRule(_localctx, 50, RULE_states);

			((StatesContext)_localctx).stateset = new HashSet<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			match(T__25);
			setState(431);
			((StatesContext)_localctx).s1 = stateDecl();

				_localctx.stateset.add(((StatesContext)_localctx).s1.state);

			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(433);
				match(COMMA);
				setState(434);
				((StatesContext)_localctx).s2 = stateDecl();

					_localctx.stateset.add(((StatesContext)_localctx).s2.state);

				}
				}
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(442);
			match(SEMICOLUMN);
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
		enterRule(_localctx, 52, RULE_stateDecl);
		try {
			setState(453);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(444);
				((StateDeclContext)_localctx).ID = match(ID);

						((StateDeclContext)_localctx).state = new State((((StateDeclContext)_localctx).ID!=null?((StateDeclContext)_localctx).ID.getText():null));
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(446);
				((StateDeclContext)_localctx).ID = match(ID);
				{
				setState(447);
				match(T__2);
				setState(448);
				((StateDeclContext)_localctx).inv = invariant();
				setState(449);
				match(T__3);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LE() { return getToken(TAParser.LE, 0); }
		public TerminalNode LEQ() { return getToken(TAParser.LEQ, 0); }
		public TerminalNode GE() { return getToken(TAParser.GE, 0); }
		public TerminalNode GEQ() { return getToken(TAParser.GEQ, 0); }
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
		enterRule(_localctx, 54, RULE_invariant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			((InvariantContext)_localctx).ID = match(ID);
			setState(456);
			((InvariantContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE))) != 0)) ) {
				((InvariantContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(457);
			((InvariantContext)_localctx).expression = expression(0);

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
		public State initstate;
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
		enterRule(_localctx, 56, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			match(T__26);
			setState(461);
			((InitContext)_localctx).ID = match(ID);
			setState(462);
			match(SEMICOLUMN);

				((InitContext)_localctx).initstate = new State((((InitContext)_localctx).ID!=null?((InitContext)_localctx).ID.getText():null));
				
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
		enterRule(_localctx, 58, RULE_transitions);
		((TransitionsContext)_localctx).transitionsret = new HashSet<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			match(T__27);
			setState(466);
			((TransitionsContext)_localctx).transitionset = transitionset();

					_localctx.transitionsret.addAll(((TransitionsContext)_localctx).transitionset.transitionsret);
				
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(468);
				((TransitionsContext)_localctx).transitionset = transitionset();

						_localctx.transitionsret.addAll(((TransitionsContext)_localctx).transitionset.transitionsret);		
					
				}
				}
				setState(475);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(476);
			match(SEMICOLUMN);
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
		public List<TransitionBodyContext> transitionBody() {
			return getRuleContexts(TransitionBodyContext.class);
		}
		public TransitionBodyContext transitionBody(int i) {
			return getRuleContext(TransitionBodyContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(TAParser.ID); }
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
		enterRule(_localctx, 60, RULE_transitionset);
		((TransitionsetContext)_localctx).transitionsret = new HashSet<>();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			((TransitionsetContext)_localctx).s1 = match(ID);
			setState(479);
			match(T__28);
			setState(480);
			((TransitionsetContext)_localctx).s2 = match(ID);
			setState(481);
			((TransitionsetContext)_localctx).transitionBody = transitionBody();

					_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s2.getText()), ((TransitionsetContext)_localctx).transitionBody.guardexp, ((TransitionsetContext)_localctx).transitionBody.syncexp,  ((TransitionsetContext)_localctx).transitionBody.assignexp));
				
			setState(491);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(483);
					match(COMMA);
					setState(484);
					match(T__28);
					setState(485);
					((TransitionsetContext)_localctx).s3 = match(ID);
					setState(486);
					((TransitionsetContext)_localctx).b2 = ((TransitionsetContext)_localctx).transitionBody = transitionBody();

							_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s3.getText()), ((TransitionsetContext)_localctx).b2.guardexp, ((TransitionsetContext)_localctx).b2.syncexp,  ((TransitionsetContext)_localctx).b2.assignexp));
							
						
					}
					} 
				}
				setState(493);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			setState(513);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(494);
				match(COMMA);
				setState(495);
				((TransitionsetContext)_localctx).s1 = match(ID);
				setState(496);
				match(T__28);
				setState(497);
				((TransitionsetContext)_localctx).s2 = match(ID);
				setState(498);
				((TransitionsetContext)_localctx).transitionBody = transitionBody();

						_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s2.getText()), ((TransitionsetContext)_localctx).transitionBody.guardexp, ((TransitionsetContext)_localctx).transitionBody.syncexp,  ((TransitionsetContext)_localctx).transitionBody.assignexp));
					
				setState(508);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(500);
						match(COMMA);
						setState(501);
						match(T__28);
						setState(502);
						((TransitionsetContext)_localctx).s3 = match(ID);
						setState(503);
						((TransitionsetContext)_localctx).b2 = ((TransitionsetContext)_localctx).transitionBody = transitionBody();

								_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s3.getText()), ((TransitionsetContext)_localctx).b2.guardexp, ((TransitionsetContext)_localctx).b2.syncexp,  ((TransitionsetContext)_localctx).b2.assignexp));
								
							
						}
						} 
					}
					setState(510);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				}
				}
				}
				setState(515);
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
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public SyncContext sync() {
			return getRuleContext(SyncContext.class,0);
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
		enterRule(_localctx, 62, RULE_transitionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			match(T__2);
			setState(520);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(517);
				((TransitionBodyContext)_localctx).guard = guard();

				 			 ((TransitionBodyContext)_localctx).guardexp = ((TransitionBodyContext)_localctx).guard.guardexp;
				 		
				}
			}


					if(_localctx.guardexp==null) {((TransitionBodyContext)_localctx).guardexp = new Guard(new HashSet<VariableConstraint>(), new HashSet<ClockConstraint>());}
					
			setState(526);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(523);
				((TransitionBodyContext)_localctx).sync = sync();

						((TransitionBodyContext)_localctx).syncexp = ((TransitionBodyContext)_localctx).sync.syncexp;
						
				}
			}

			setState(531);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(528);
				((TransitionBodyContext)_localctx).assign = assign();

				 			((TransitionBodyContext)_localctx).assignexp = ((TransitionBodyContext)_localctx).assign.assignexp;
				 		
				}
			}

			setState(533);
			match(T__3);

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
		enterRule(_localctx, 64, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			match(T__29);
			setState(537);
			((GuardContext)_localctx).exp1 = ((GuardContext)_localctx).guardconditionList = guardconditionList();
			setState(538);
			match(SEMICOLUMN);

				((GuardContext)_localctx).guardexp = new Guard(((GuardContext)_localctx).guardconditionList.variableconst==null? new HashSet<VariableConstraint>() :((GuardContext)_localctx).guardconditionList.variableconst, ((GuardContext)_localctx).guardconditionList.clockconst==null? new HashSet<ClockConstraint>():((GuardContext)_localctx).guardconditionList.clockconst);

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
		public Set<VariableConstraint> variableconst;
		public Set<ClockConstraint> clockconst;
		public ClockconstraintContext clockconstraint;
		public List<ClockconstraintContext> clockconstraint() {
			return getRuleContexts(ClockconstraintContext.class);
		}
		public ClockconstraintContext clockconstraint(int i) {
			return getRuleContext(ClockconstraintContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
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
		enterRule(_localctx, 66, RULE_guardconditionList);

				((GuardconditionListContext)_localctx).variableconst = new HashSet<>();
				((GuardconditionListContext)_localctx).clockconst = new HashSet<>();
			
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			((GuardconditionListContext)_localctx).clockconstraint = clockconstraint();

							if(((GuardconditionListContext)_localctx).clockconstraint.clockconst!=null) _localctx.clockconst.add(((GuardconditionListContext)_localctx).clockconstraint.clockconst) ;
							if(((GuardconditionListContext)_localctx).clockconstraint.variableconst!=null) _localctx.variableconst.add(((GuardconditionListContext)_localctx).clockconstraint.variableconst);
						
			setState(549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(543);
				match(COMMA);
				setState(544);
				((GuardconditionListContext)_localctx).clockconstraint = clockconstraint();

								if(((GuardconditionListContext)_localctx).clockconstraint.clockconst!=null) _localctx.clockconst.add(((GuardconditionListContext)_localctx).clockconstraint.clockconst);
								if(((GuardconditionListContext)_localctx).clockconstraint.variableconst!=null)_localctx.variableconst.add(((GuardconditionListContext)_localctx).clockconstraint.variableconst) ;
							
				}
				}
				setState(551);
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
		public ClockConstraint clockconst;
		public VariableConstraint variableconst;
		public ConstraintAtomContext constraintAtom;
		public ClockconstraintprimeContext clockconstraintprime;
		public ConstraintAtomContext constraintAtom() {
			return getRuleContext(ConstraintAtomContext.class,0);
		}
		public ClockconstraintprimeContext clockconstraintprime() {
			return getRuleContext(ClockconstraintprimeContext.class,0);
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
		enterRule(_localctx, 68, RULE_clockconstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			((ClockconstraintContext)_localctx).constraintAtom = constraintAtom();
			setState(553);
			((ClockconstraintContext)_localctx).clockconstraintprime = clockconstraintprime();

					if(((ClockconstraintContext)_localctx).clockconstraintprime.clockconst!=null ){
						if(((ClockconstraintContext)_localctx).constraintAtom.atom!=null){
							((ClockconstraintContext)_localctx).clockconst = new BinaryClockConstraint(((ClockconstraintContext)_localctx).constraintAtom.atom, ((ClockconstraintContext)_localctx).clockconstraintprime.operaror, ((ClockconstraintContext)_localctx).clockconstraintprime.clockconst);
						}
						else{
							((ClockconstraintContext)_localctx).clockconst = ((ClockconstraintContext)_localctx).clockconstraintprime.clockconst;	
						}
					}
					else{
						((ClockconstraintContext)_localctx).clockconst = ((ClockconstraintContext)_localctx).constraintAtom.atom;	
					}
					if(((ClockconstraintContext)_localctx).clockconstraintprime.variableconst!=null){
							if(((ClockconstraintContext)_localctx).constraintAtom.variableAtom!=null){
								((ClockconstraintContext)_localctx).variableconst = new BinaryVariableConstraint(((ClockconstraintContext)_localctx).constraintAtom.variableAtom, ((ClockconstraintContext)_localctx).clockconstraintprime.operaror, ((ClockconstraintContext)_localctx).clockconstraintprime.variableconst);
							}
							else{
								((ClockconstraintContext)_localctx).variableconst = ((ClockconstraintContext)_localctx).clockconstraintprime.variableconst;
							}
					}
					else{
						((ClockconstraintContext)_localctx).variableconst = ((ClockconstraintContext)_localctx).constraintAtom.variableAtom;
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

	public static class ClockconstraintprimeContext extends ParserRuleContext {
		public PropositionalLogicOperator operaror;
		public ClockConstraint clockconst;
		public VariableConstraint variableconst;
		public Token op;
		public ClockconstraintContext c2;
		public ClockconstraintprimeContext clockconstraintprime;
		public ClockconstraintprimeContext clockconstraintprime() {
			return getRuleContext(ClockconstraintprimeContext.class,0);
		}
		public TerminalNode BIN_PROPOSITIONAL_LOGIC_OPERATOR() { return getToken(TAParser.BIN_PROPOSITIONAL_LOGIC_OPERATOR, 0); }
		public ClockconstraintContext clockconstraint() {
			return getRuleContext(ClockconstraintContext.class,0);
		}
		public ClockconstraintprimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clockconstraintprime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterClockconstraintprime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitClockconstraintprime(this);
		}
	}

	public final ClockconstraintprimeContext clockconstraintprime() throws RecognitionException {
		ClockconstraintprimeContext _localctx = new ClockconstraintprimeContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_clockconstraintprime);
		try {
			setState(562);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(556);
				((ClockconstraintprimeContext)_localctx).op = match(BIN_PROPOSITIONAL_LOGIC_OPERATOR);
				setState(557);
				((ClockconstraintprimeContext)_localctx).c2 = clockconstraint();
				setState(558);
				((ClockconstraintprimeContext)_localctx).clockconstraintprime = clockconstraintprime();

						if(_localctx.clockconst!=null){
							((ClockconstraintprimeContext)_localctx).clockconst = new BinaryClockConstraint(((ClockconstraintprimeContext)_localctx).c2.clockconst, _localctx.operaror, _localctx.clockconst);
							((ClockconstraintprimeContext)_localctx).operaror = PropositionalLogicOperator.parse((((ClockconstraintprimeContext)_localctx).op!=null?((ClockconstraintprimeContext)_localctx).op.getText():null));
						}
						else{
								((ClockconstraintprimeContext)_localctx).clockconst = ((ClockconstraintprimeContext)_localctx).c2.clockconst;
								((ClockconstraintprimeContext)_localctx).operaror = PropositionalLogicOperator.parse((((ClockconstraintprimeContext)_localctx).op!=null?((ClockconstraintprimeContext)_localctx).op.getText():null));
						}
					
					
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class ConstraintAtomContext extends ParserRuleContext {
		public ClockConstraintAtom atom;
		public VariableConstraint variableAtom;
		public Token id;
		public Token op;
		public Token value;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode NAT() { return getToken(TAParser.NAT, 0); }
		public TerminalNode EQCOMP() { return getToken(TAParser.EQCOMP, 0); }
		public TerminalNode GE() { return getToken(TAParser.GE, 0); }
		public TerminalNode GEQ() { return getToken(TAParser.GEQ, 0); }
		public TerminalNode LE() { return getToken(TAParser.LE, 0); }
		public TerminalNode LEQ() { return getToken(TAParser.LEQ, 0); }
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
			setState(564);
			((ConstraintAtomContext)_localctx).id = match(ID);
			setState(565);
			((ConstraintAtomContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE) | (1L << EQCOMP))) != 0)) ) {
				((ConstraintAtomContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(566);
			((ConstraintAtomContext)_localctx).value = match(NAT);

					
					if(declarations==null){
						throw new InternalError("The set of the declarations cannot be null");	
					}
					String identifier=(((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null);
					if(!declarations.containsKey((((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)) && (currentTaDeclarations==null || !currentTaDeclarations.containsKey((((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)))){
						throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Variable:"+(((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)+" not defined");
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
			setState(569);
			match(T__30);
			setState(570);
			((SyncContext)_localctx).exp2 = match(ID);
			setState(571);
			((SyncContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__31 || _la==T__32) ) {
				((SyncContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(572);
			match(SEMICOLUMN);

				((SyncContext)_localctx).syncexp = new SyncExpression((((SyncContext)_localctx).exp2!=null?((SyncContext)_localctx).exp2.getText():null), (((SyncContext)_localctx).op!=null?((SyncContext)_localctx).op.getText():null));

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
			setState(575);
			match(T__33);
			setState(576);
			((AssignContext)_localctx).expl = ((AssignContext)_localctx).assignmentList = assignmentList();
			setState(577);
			match(SEMICOLUMN);

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
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
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
			setState(580);
			((AssignmentListContext)_localctx).assignment = assignment();

				 		if(((AssignmentListContext)_localctx).assignment.clockassignementsret!=null){
				 			_localctx.clockassignement.add(((AssignmentListContext)_localctx).assignment.clockassignementsret);
				 		}
				 		if(((AssignmentListContext)_localctx).assignment.variableAssignementret!=null){
				 			_localctx.variableassignement.add(((AssignmentListContext)_localctx).assignment.variableAssignementret);
				 		}
				 	
			}
			setState(589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				{
				setState(583);
				match(COMMA);
				setState(584);
				((AssignmentListContext)_localctx).assignment = assignment();

								if(((AssignmentListContext)_localctx).assignment.clockassignementsret!=null){
					 			_localctx.clockassignement.add(((AssignmentListContext)_localctx).assignment.clockassignementsret);
					 		}
					 		if(((AssignmentListContext)_localctx).assignment.variableAssignementret!=null){
					 			_localctx.variableassignement.add(((AssignmentListContext)_localctx).assignment.variableAssignementret);
					 		}
						
				}
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

	public static class AssignmentContext extends ParserRuleContext {
		public ClockAssignement clockassignementsret;
		public VariableAssignement variableAssignementret;
		public Token id;
		public Token op;
		public Token nat;
		public ExprStatementContext exprStatement;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode NAT() { return getToken(TAParser.NAT, 0); }
		public TerminalNode EQASSIGN() { return getToken(TAParser.EQASSIGN, 0); }
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public ExprStatementContext exprStatement() {
			return getRuleContext(ExprStatementContext.class,0);
		}
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
			setState(603);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(592);
				((AssignmentContext)_localctx).id = match(ID);
				setState(593);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQASSIGN || _la==EQ) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(594);
				((AssignmentContext)_localctx).nat = match(NAT);
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
				setState(597);
				((AssignmentContext)_localctx).id = match(ID);
				setState(598);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQASSIGN || _la==EQ) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(599);
				((AssignmentContext)_localctx).exprStatement = exprStatement();
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
			setState(605);
			((SimpleassigmentContext)_localctx).id = match(ID);
			setState(606);
			((SimpleassigmentContext)_localctx).op = match(EQ);
			setState(607);
			((SimpleassigmentContext)_localctx).nat = match(NAT);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
			setState(611);
			((ExprListContext)_localctx).exp1 = expression(0);

				_localctx.exprListret.add(((ExprListContext)_localctx).exp1.exp);

			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(613);
				match(COMMA);
				setState(614);
				((ExprListContext)_localctx).exp2 = expression(0);

					_localctx.exprListret.add(((ExprListContext)_localctx).exp2.exp);
					
				}
				}
				setState(621);
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
			setState(622);
			((ExprStatementContext)_localctx).expression = expression(0);

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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(TAParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TAParser.MINUS, 0); }
		public TerminalNode PLUSPLUS() { return getToken(TAParser.PLUSPLUS, 0); }
		public TerminalNode MINUSMINUS() { return getToken(TAParser.MINUSMINUS, 0); }
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode NAT() { return getToken(TAParser.NAT, 0); }
		public TerminalNode MULT() { return getToken(TAParser.MULT, 0); }
		public TerminalNode FRACT() { return getToken(TAParser.FRACT, 0); }
		public TerminalNode MOD() { return getToken(TAParser.MOD, 0); }
		public TerminalNode LEQ() { return getToken(TAParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(TAParser.GEQ, 0); }
		public TerminalNode GE() { return getToken(TAParser.GE, 0); }
		public TerminalNode LE() { return getToken(TAParser.LE, 0); }
		public TerminalNode EQCOMP() { return getToken(TAParser.EQCOMP, 0); }
		public TerminalNode NEQ() { return getToken(TAParser.NEQ, 0); }
		public TerminalNode BITAND() { return getToken(TAParser.BITAND, 0); }
		public TerminalNode POW() { return getToken(TAParser.POW, 0); }
		public TerminalNode BITOR() { return getToken(TAParser.BITOR, 0); }
		public TerminalNode AND() { return getToken(TAParser.AND, 0); }
		public TerminalNode OR() { return getToken(TAParser.OR, 0); }
		public TerminalNode COLUMEQ() { return getToken(TAParser.COLUMEQ, 0); }
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public TerminalNode PLUSEQ() { return getToken(TAParser.PLUSEQ, 0); }
		public TerminalNode MINUSEQ() { return getToken(TAParser.MINUSEQ, 0); }
		public TerminalNode MULTEQ() { return getToken(TAParser.MULTEQ, 0); }
		public TerminalNode FRACTEQ() { return getToken(TAParser.FRACTEQ, 0); }
		public TerminalNode BITANDEQ() { return getToken(TAParser.BITANDEQ, 0); }
		public TerminalNode BITOREQ() { return getToken(TAParser.BITOREQ, 0); }
		public TerminalNode POWEQ() { return getToken(TAParser.POWEQ, 0); }
		public TerminalNode MODEQ() { return getToken(TAParser.MODEQ, 0); }
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
			setState(638);
			switch (_input.LA(1)) {
			case PLUS:
			case PLUSPLUS:
			case MINUSMINUS:
			case MINUS:
				{
				setState(626);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0)) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(627);
				((ExpressionContext)_localctx).exp1 = expression(13);

				    	((ExpressionContext)_localctx).exp = new LeftUnaryOperator((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp1.exp);
				    
				}
				break;
			case T__31:
			case T__34:
				{
				setState(630);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__34) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(631);
				((ExpressionContext)_localctx).exp1 = expression(12);

				    	((ExpressionContext)_localctx).exp = new LeftUnaryOperator((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp1.exp);
				    
				}
				break;
			case ID:
				{
				setState(634);
				((ExpressionContext)_localctx).ID = match(ID);

						((ExpressionContext)_localctx).exp = new Identifier((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
					
				}
				break;
			case NAT:
				{
				setState(636);
				((ExpressionContext)_localctx).NAT = match(NAT);

						((ExpressionContext)_localctx).exp = new Value((((ExpressionContext)_localctx).NAT!=null?((ExpressionContext)_localctx).NAT.getText():null));
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(702);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(700);
					switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(640);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(641);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << FRACT) | (1L << MOD))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(642);
						((ExpressionContext)_localctx).exp2 = expression(12);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(645);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(646);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(647);
						((ExpressionContext)_localctx).exp2 = expression(11);

						              		BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              		((ExpressionContext)_localctx).exp = exp;
						              	
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(650);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(651);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(652);
						((ExpressionContext)_localctx).exp2 = expression(10);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(655);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(656);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQCOMP || _la==NEQ) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(657);
						((ExpressionContext)_localctx).exp2 = expression(9);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(660);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(661);
						((ExpressionContext)_localctx).op = match(BITAND);
						setState(662);
						((ExpressionContext)_localctx).exp2 = expression(8);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(665);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(666);
						((ExpressionContext)_localctx).op = match(POW);
						setState(667);
						((ExpressionContext)_localctx).exp2 = expression(7);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(670);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(671);
						((ExpressionContext)_localctx).op = match(BITOR);
						setState(672);
						((ExpressionContext)_localctx).exp2 = expression(6);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(675);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(676);
						((ExpressionContext)_localctx).op = match(AND);
						setState(677);
						((ExpressionContext)_localctx).exp2 = expression(5);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(680);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(681);
						((ExpressionContext)_localctx).op = match(OR);
						setState(682);
						((ExpressionContext)_localctx).exp2 = expression(4);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(685);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(686);
						match(T__32);
						setState(687);
						((ExpressionContext)_localctx).exp2 = expression(0);
						setState(688);
						match(T__23);
						setState(689);
						((ExpressionContext)_localctx).exp3 = expression(3);

						              	((ExpressionContext)_localctx).exp = new TernaryExpression(((ExpressionContext)_localctx).exp1.exp, ((ExpressionContext)_localctx).exp2.exp, ((ExpressionContext)_localctx).exp3.exp);
						              
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(692);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(693);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & ((1L << (T__35 - 36)) | (1L << (T__36 - 36)) | (1L << (T__37 - 36)) | (1L << (EQ - 36)) | (1L << (FRACTEQ - 36)) | (1L << (MODEQ - 36)) | (1L << (PLUSEQ - 36)) | (1L << (MINUSEQ - 36)) | (1L << (COLUMEQ - 36)) | (1L << (MULTEQ - 36)) | (1L << (POWEQ - 36)) | (1L << (BITANDEQ - 36)) | (1L << (BITOREQ - 36)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(694);
						((ExpressionContext)_localctx).exp2 = expression(2);

						              	((ExpressionContext)_localctx).exp = new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp2.exp);
						              
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(697);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(698);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUSPLUS || _la==MINUSMINUS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}

						                ((ExpressionContext)_localctx).exp = new RightUnaryOperator(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						              
						}
						break;
					}
					} 
				}
				setState(704);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
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
			setState(717);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(705);
				((DeclarationidContext)_localctx).ID = match(ID);
				setState(706);
				((DeclarationidContext)_localctx).op = match(EQ);
				setState(707);
				((DeclarationidContext)_localctx).expr = expression(0);
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
				setState(711);
				((DeclarationidContext)_localctx).ID = match(ID);
				setState(712);
				((DeclarationidContext)_localctx).op = match(COLUMEQ);
				setState(713);
				((DeclarationidContext)_localctx).expr = expression(0);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ArgListContext> argList() {
			return getRuleContexts(ArgListContext.class);
		}
		public ArgListContext argList(int i) {
			return getRuleContext(ArgListContext.class,i);
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
			setState(730);
			switch (_input.LA(1)) {
			case T__31:
			case T__34:
			case PLUS:
			case PLUSPLUS:
			case MINUSMINUS:
			case MINUS:
			case ID:
			case NAT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(719);
				((ArgListContext)_localctx).expression = expression(0);
				setState(724);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(720);
						match(COMMA);
						setState(721);
						((ArgListContext)_localctx).argList = argList();
						}
						} 
					}
					setState(726);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
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
		case 44:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3U\u02df\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\7\2d\n\2\f\2\16\2g\13\2\3"+
		"\2\7\2j\n\2\f\2\16\2m\13\2\3\2\6\2p\n\2\r\2\16\2q\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3~\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\7\5\u008c\n\5\f\5\16\5\u008f\13\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6"+
		"\u0097\n\6\f\6\16\6\u009a\13\6\3\6\3\6\5\6\u009e\n\6\3\7\3\7\5\7\u00a2"+
		"\n\7\3\7\3\7\7\7\u00a6\n\7\f\7\16\7\u00a9\13\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00b9\n\t\f\t\16\t\u00bc\13\t\3\t"+
		"\3\t\5\t\u00c0\n\t\3\t\5\t\u00c3\n\t\3\t\3\t\5\t\u00c7\n\t\3\t\3\t\3\n"+
		"\3\n\7\n\u00cd\n\n\f\n\16\n\u00d0\13\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00d8"+
		"\n\n\f\n\16\n\u00db\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00e5"+
		"\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u00ee\n\r\3\r\3\r\3\r\3\r\6\r\u00f4"+
		"\n\r\r\r\16\r\u00f5\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0103"+
		"\n\r\5\r\u0105\n\r\3\16\3\16\7\16\u0109\n\16\f\16\16\16\u010c\13\16\3"+
		"\17\5\17\u010f\n\17\3\17\5\17\u0112\n\17\3\17\5\17\u0115\n\17\5\17\u0117"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\7\23\u012a\n\23\f\23\16\23\u012d\13\23\3\24\3\24"+
		"\3\24\3\24\3\24\7\24\u0134\n\24\f\24\16\24\u0137\13\24\3\24\3\24\3\25"+
		"\3\25\7\25\u013d\n\25\f\25\16\25\u0140\13\25\3\26\3\26\3\26\3\26\7\26"+
		"\u0146\n\26\f\26\16\26\u0149\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\7\30\u0155\n\30\f\30\16\30\u0158\13\30\3\30\7\30\u015b"+
		"\n\30\f\30\16\30\u015e\13\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\5\31\u0186\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\6\31"+
		"\u0190\n\31\r\31\16\31\u0191\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5"+
		"\31\u019c\n\31\3\32\3\32\3\32\3\32\7\32\u01a2\n\32\f\32\16\32\u01a5\13"+
		"\32\3\32\3\32\3\32\7\32\u01aa\n\32\f\32\16\32\u01ad\13\32\5\32\u01af\n"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u01b8\n\33\f\33\16\33\u01bb"+
		"\13\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u01c8"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\7\37\u01da\n\37\f\37\16\37\u01dd\13\37\3\37\3\37\3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u01ec\n \f \16 \u01ef\13 \3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \7 \u01fd\n \f \16 \u0200\13 \7 \u0202\n \f \16"+
		" \u0205\13 \3!\3!\3!\3!\5!\u020b\n!\3!\3!\3!\3!\5!\u0211\n!\3!\3!\3!\5"+
		"!\u0216\n!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\7#\u0226\n#"+
		"\f#\16#\u0229\13#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\5%\u0235\n%\3&\3&\3&\3"+
		"&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\7)\u024e"+
		"\n)\f)\16)\u0251\13)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u025e\n*\3+\3"+
		"+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\7,\u026c\n,\f,\16,\u026f\13,\3-\3-\3-"+
		"\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u0281\n.\3.\3.\3.\3.\3.\3."+
		"\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3."+
		"\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3."+
		"\3.\3.\3.\3.\3.\3.\3.\3.\7.\u02bf\n.\f.\16.\u02c2\13.\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\3/\3/\3/\3/\5/\u02d0\n/\3\60\3\60\3\60\7\60\u02d5\n\60\f\60\16"+
		"\60\u02d8\13\60\3\60\3\60\3\60\5\60\u02dd\n\60\3\60\2\3Z\61\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\"+
		"^\2\r\3\2),\3\2)-\3\2\"#\3\2/\60\3\2\63\66\4\2\"\"%%\4\2\67\67=>\4\2\63"+
		"\63\66\66\3\2-.\6\2&(\60\628<EF\3\2\64\65\u0305\2e\3\2\2\2\4}\3\2\2\2"+
		"\6\177\3\2\2\2\b\u0087\3\2\2\2\n\u009d\3\2\2\2\f\u009f\3\2\2\2\16\u00aa"+
		"\3\2\2\2\20\u00b2\3\2\2\2\22\u00ca\3\2\2\2\24\u00de\3\2\2\2\26\u00e6\3"+
		"\2\2\2\30\u0104\3\2\2\2\32\u0106\3\2\2\2\34\u0116\3\2\2\2\36\u0118\3\2"+
		"\2\2 \u011e\3\2\2\2\"\u0122\3\2\2\2$\u0126\3\2\2\2&\u012e\3\2\2\2(\u013a"+
		"\3\2\2\2*\u0141\3\2\2\2,\u014c\3\2\2\2.\u0151\3\2\2\2\60\u019b\3\2\2\2"+
		"\62\u01ae\3\2\2\2\64\u01b0\3\2\2\2\66\u01c7\3\2\2\28\u01c9\3\2\2\2:\u01ce"+
		"\3\2\2\2<\u01d3\3\2\2\2>\u01e0\3\2\2\2@\u0206\3\2\2\2B\u021a\3\2\2\2D"+
		"\u021f\3\2\2\2F\u022a\3\2\2\2H\u0234\3\2\2\2J\u0236\3\2\2\2L\u023b\3\2"+
		"\2\2N\u0241\3\2\2\2P\u0246\3\2\2\2R\u025d\3\2\2\2T\u025f\3\2\2\2V\u0265"+
		"\3\2\2\2X\u0270\3\2\2\2Z\u0280\3\2\2\2\\\u02cf\3\2\2\2^\u02dc\3\2\2\2"+
		"`a\5\4\3\2ab\b\2\1\2bd\3\2\2\2c`\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2"+
		"fk\3\2\2\2ge\3\2\2\2hj\5\6\4\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2"+
		"lo\3\2\2\2mk\3\2\2\2np\5\b\5\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2"+
		"rs\3\2\2\2st\7\2\2\3t\3\3\2\2\2u~\5,\27\2vw\5\22\n\2wx\b\3\1\2x~\3\2\2"+
		"\2y~\5&\24\2z{\5\16\b\2{|\b\3\1\2|~\3\2\2\2}u\3\2\2\2}v\3\2\2\2}y\3\2"+
		"\2\2}z\3\2\2\2~\5\3\2\2\2\177\u0080\7N\2\2\u0080\u0081\5\\/\2\u0081\u0082"+
		"\7N\2\2\u0082\u0083\7H\2\2\u0083\u0084\5^\60\2\u0084\u0085\7I\2\2\u0085"+
		"\u0086\7L\2\2\u0086\7\3\2\2\2\u0087\u0088\7\3\2\2\u0088\u008d\7N\2\2\u0089"+
		"\u008a\7S\2\2\u008a\u008c\7N\2\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2"+
		"\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d"+
		"\3\2\2\2\u0090\u0091\7L\2\2\u0091\t\3\2\2\2\u0092\u0093\7H\2\2\u0093\u0098"+
		"\5\f\7\2\u0094\u0095\7S\2\2\u0095\u0097\5\f\7\2\u0096\u0094\3\2\2\2\u0097"+
		"\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7I\2\2\u009c\u009e\3\2\2\2\u009d"+
		"\u0092\3\2\2\2\u009d\u009e\3\2\2\2\u009e\13\3\2\2\2\u009f\u00a1\5\30\r"+
		"\2\u00a0\u00a2\7D\2\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00a7\7N\2\2\u00a4\u00a6\5\26\f\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\r\3\2\2\2"+
		"\u00a9\u00a7\3\2\2\2\u00aa\u00ab\7\4\2\2\u00ab\u00ac\7N\2\2\u00ac\u00ad"+
		"\5\n\6\2\u00ad\u00ae\7\5\2\2\u00ae\u00af\5\20\t\2\u00af\u00b0\7\6\2\2"+
		"\u00b0\u00b1\b\b\1\2\u00b1\17\3\2\2\2\u00b2\u00ba\b\t\1\2\u00b3\u00b9"+
		"\5,\27\2\u00b4\u00b5\5\22\n\2\u00b5\u00b6\b\t\1\2\u00b6\u00b9\3\2\2\2"+
		"\u00b7\u00b9\5&\24\2\u00b8\u00b3\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b8\u00b7"+
		"\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00bf\5\64\33\2\u00be\u00c0\5"+
		" \21\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1"+
		"\u00c3\5\"\22\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3"+
		"\2\2\2\u00c4\u00c6\5:\36\2\u00c5\u00c7\5<\37\2\u00c6\u00c5\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\b\t\1\2\u00c9\21\3\2\2"+
		"\2\u00ca\u00ce\5\30\r\2\u00cb\u00cd\5\26\f\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2"+
		"\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\5\24\13\2\u00d2\u00d9\b\n\1\2\u00d3"+
		"\u00d4\7S\2\2\u00d4\u00d5\5\24\13\2\u00d5\u00d6\b\n\1\2\u00d6\u00d8\3"+
		"\2\2\2\u00d7\u00d3\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\7L"+
		"\2\2\u00dd\23\3\2\2\2\u00de\u00df\7N\2\2\u00df\u00e4\b\13\1\2\u00e0\u00e1"+
		"\7\60\2\2\u00e1\u00e2\5Z.\2\u00e2\u00e3\b\13\1\2\u00e3\u00e5\3\2\2\2\u00e4"+
		"\u00e0\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\25\3\2\2\2\u00e6\u00e7\7J\2\2"+
		"\u00e7\u00e8\5Z.\2\u00e8\u00e9\7K\2\2\u00e9\27\3\2\2\2\u00ea\u00eb\5\34"+
		"\17\2\u00eb\u00ed\7N\2\2\u00ec\u00ee\5\36\20\2\u00ed\u00ec\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u0105\3\2\2\2\u00ef\u00f0\5\34\17\2\u00f0\u00f1\7"+
		"\7\2\2\u00f1\u00f3\7\5\2\2\u00f2\u00f4\5*\26\2\u00f3\u00f2\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2"+
		"\2\2\u00f7\u00f8\7\6\2\2\u00f8\u0105\3\2\2\2\u00f9\u0102\5\34\17\2\u00fa"+
		"\u00fb\7\b\2\2\u00fb\u0103\b\r\1\2\u00fc\u00fd\7\t\2\2\u00fd\u0103\b\r"+
		"\1\2\u00fe\u00ff\7\n\2\2\u00ff\u0103\b\r\1\2\u0100\u0101\7\13\2\2\u0101"+
		"\u0103\b\r\1\2\u0102\u00fa\3\2\2\2\u0102\u00fc\3\2\2\2\u0102\u00fe\3\2"+
		"\2\2\u0102\u0100\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u00ea\3\2\2\2\u0104"+
		"\u00ef\3\2\2\2\u0104\u00f9\3\2\2\2\u0105\31\3\2\2\2\u0106\u010a\7N\2\2"+
		"\u0107\u0109\5\26\f\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108"+
		"\3\2\2\2\u010a\u010b\3\2\2\2\u010b\33\3\2\2\2\u010c\u010a\3\2\2\2\u010d"+
		"\u010f\7\f\2\2\u010e\u010d\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2"+
		"\2\2\u0110\u0112\7\r\2\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\u0117\3\2\2\2\u0113\u0115\7\16\2\2\u0114\u0113\3\2\2\2\u0114\u0115\3"+
		"\2\2\2\u0115\u0117\3\2\2\2\u0116\u010e\3\2\2\2\u0116\u0114\3\2\2\2\u0117"+
		"\35\3\2\2\2\u0118\u0119\7J\2\2\u0119\u011a\7O\2\2\u011a\u011b\7S\2\2\u011b"+
		"\u011c\7O\2\2\u011c\u011d\7K\2\2\u011d\37\3\2\2\2\u011e\u011f\7\17\2\2"+
		"\u011f\u0120\5$\23\2\u0120\u0121\7L\2\2\u0121!\3\2\2\2\u0122\u0123\7\f"+
		"\2\2\u0123\u0124\5$\23\2\u0124\u0125\7L\2\2\u0125#\3\2\2\2\u0126\u012b"+
		"\7N\2\2\u0127\u0128\7S\2\2\u0128\u012a\7N\2\2\u0129\u0127\3\2\2\2\u012a"+
		"\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c%\3\2\2\2"+
		"\u012d\u012b\3\2\2\2\u012e\u012f\7\20\2\2\u012f\u0130\5\30\r\2\u0130\u0135"+
		"\5(\25\2\u0131\u0132\7S\2\2\u0132\u0134\5(\25\2\u0133\u0131\3\2\2\2\u0134"+
		"\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0138\3\2"+
		"\2\2\u0137\u0135\3\2\2\2\u0138\u0139\7L\2\2\u0139\'\3\2\2\2\u013a\u013e"+
		"\7N\2\2\u013b\u013d\5\26\f\2\u013c\u013b\3\2\2\2\u013d\u0140\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f)\3\2\2\2\u0140\u013e\3\2\2\2"+
		"\u0141\u0142\5\30\r\2\u0142\u0147\5\32\16\2\u0143\u0144\7S\2\2\u0144\u0146"+
		"\5\32\16\2\u0145\u0143\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2"+
		"\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b"+
		"\7L\2\2\u014b+\3\2\2\2\u014c\u014d\5\30\r\2\u014d\u014e\7N\2\2\u014e\u014f"+
		"\5\n\6\2\u014f\u0150\5.\30\2\u0150-\3\2\2\2\u0151\u0156\7\5\2\2\u0152"+
		"\u0155\5\22\n\2\u0153\u0155\5&\24\2\u0154\u0152\3\2\2\2\u0154\u0153\3"+
		"\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"\u015c\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015b\5\60\31\2\u015a\u0159\3"+
		"\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u015f\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0160\7\6\2\2\u0160/\3\2\2\2"+
		"\u0161\u019c\5.\30\2\u0162\u019c\7L\2\2\u0163\u0164\5Z.\2\u0164\u0165"+
		"\7L\2\2\u0165\u019c\3\2\2\2\u0166\u0167\7\21\2\2\u0167\u0168\7H\2\2\u0168"+
		"\u0169\5V,\2\u0169\u016a\7L\2\2\u016a\u016b\5V,\2\u016b\u016c\7L\2\2\u016c"+
		"\u016d\5V,\2\u016d\u016e\7I\2\2\u016e\u016f\5\60\31\2\u016f\u019c\3\2"+
		"\2\2\u0170\u0171\7\22\2\2\u0171\u0172\7H\2\2\u0172\u0173\5V,\2\u0173\u0174"+
		"\7I\2\2\u0174\u0175\5\60\31\2\u0175\u019c\3\2\2\2\u0176\u0177\7\23\2\2"+
		"\u0177\u0178\5\60\31\2\u0178\u0179\7\22\2\2\u0179\u017a\7H\2\2\u017a\u017b"+
		"\5V,\2\u017b\u017c\7I\2\2\u017c\u017d\7L\2\2\u017d\u019c\3\2\2\2\u017e"+
		"\u017f\7\24\2\2\u017f\u0180\7H\2\2\u0180\u0181\5V,\2\u0181\u0182\7I\2"+
		"\2\u0182\u0185\5\60\31\2\u0183\u0184\7\25\2\2\u0184\u0186\5\60\31\2\u0185"+
		"\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u019c\3\2\2\2\u0187\u0188\7\26"+
		"\2\2\u0188\u019c\7L\2\2\u0189\u018a\7\27\2\2\u018a\u018b\7H\2\2\u018b"+
		"\u018c\5V,\2\u018c\u018d\7I\2\2\u018d\u018f\7\5\2\2\u018e\u0190\5\62\32"+
		"\2\u018f\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192"+
		"\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\7\6\2\2\u0194\u019c\3\2\2\2\u0195"+
		"\u0196\7\30\2\2\u0196\u019c\7L\2\2\u0197\u0198\7\30\2\2\u0198\u0199\5"+
		"Z.\2\u0199\u019a\7L\2\2\u019a\u019c\3\2\2\2\u019b\u0161\3\2\2\2\u019b"+
		"\u0162\3\2\2\2\u019b\u0163\3\2\2\2\u019b\u0166\3\2\2\2\u019b\u0170\3\2"+
		"\2\2\u019b\u0176\3\2\2\2\u019b\u017e\3\2\2\2\u019b\u0187\3\2\2\2\u019b"+
		"\u0189\3\2\2\2\u019b\u0195\3\2\2\2\u019b\u0197\3\2\2\2\u019c\61\3\2\2"+
		"\2\u019d\u019e\7\31\2\2\u019e\u019f\5Z.\2\u019f\u01a3\7\32\2\2\u01a0\u01a2"+
		"\5\60\31\2\u01a1\u01a0\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2"+
		"\u01a3\u01a4\3\2\2\2\u01a4\u01af\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01a7"+
		"\7\33\2\2\u01a7\u01ab\7\32\2\2\u01a8\u01aa\5\60\31\2\u01a9\u01a8\3\2\2"+
		"\2\u01aa\u01ad\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01af"+
		"\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ae\u019d\3\2\2\2\u01ae\u01a6\3\2\2\2\u01af"+
		"\63\3\2\2\2\u01b0\u01b1\7\34\2\2\u01b1\u01b2\5\66\34\2\u01b2\u01b9\b\33"+
		"\1\2\u01b3\u01b4\7S\2\2\u01b4\u01b5\5\66\34\2\u01b5\u01b6\b\33\1\2\u01b6"+
		"\u01b8\3\2\2\2\u01b7\u01b3\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01b7\3\2"+
		"\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bc\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc"+
		"\u01bd\7L\2\2\u01bd\65\3\2\2\2\u01be\u01bf\7N\2\2\u01bf\u01c8\b\34\1\2"+
		"\u01c0\u01c1\7N\2\2\u01c1\u01c2\7\5\2\2\u01c2\u01c3\58\35\2\u01c3\u01c4"+
		"\7\6\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\b\34\1\2\u01c6\u01c8\3\2\2\2"+
		"\u01c7\u01be\3\2\2\2\u01c7\u01c0\3\2\2\2\u01c8\67\3\2\2\2\u01c9\u01ca"+
		"\7N\2\2\u01ca\u01cb\t\2\2\2\u01cb\u01cc\5Z.\2\u01cc\u01cd\b\35\1\2\u01cd"+
		"9\3\2\2\2\u01ce\u01cf\7\35\2\2\u01cf\u01d0\7N\2\2\u01d0\u01d1\7L\2\2\u01d1"+
		"\u01d2\b\36\1\2\u01d2;\3\2\2\2\u01d3\u01d4\7\36\2\2\u01d4\u01d5\5> \2"+
		"\u01d5\u01db\b\37\1\2\u01d6\u01d7\5> \2\u01d7\u01d8\b\37\1\2\u01d8\u01da"+
		"\3\2\2\2\u01d9\u01d6\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01d9\3\2\2\2\u01db"+
		"\u01dc\3\2\2\2\u01dc\u01de\3\2\2\2\u01dd\u01db\3\2\2\2\u01de\u01df\7L"+
		"\2\2\u01df=\3\2\2\2\u01e0\u01e1\7N\2\2\u01e1\u01e2\7\37\2\2\u01e2\u01e3"+
		"\7N\2\2\u01e3\u01e4\5@!\2\u01e4\u01ed\b \1\2\u01e5\u01e6\7S\2\2\u01e6"+
		"\u01e7\7\37\2\2\u01e7\u01e8\7N\2\2\u01e8\u01e9\5@!\2\u01e9\u01ea\b \1"+
		"\2\u01ea\u01ec\3\2\2\2\u01eb\u01e5\3\2\2\2\u01ec\u01ef\3\2\2\2\u01ed\u01eb"+
		"\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u0203\3\2\2\2\u01ef\u01ed\3\2\2\2\u01f0"+
		"\u01f1\7S\2\2\u01f1\u01f2\7N\2\2\u01f2\u01f3\7\37\2\2\u01f3\u01f4\7N\2"+
		"\2\u01f4\u01f5\5@!\2\u01f5\u01fe\b \1\2\u01f6\u01f7\7S\2\2\u01f7\u01f8"+
		"\7\37\2\2\u01f8\u01f9\7N\2\2\u01f9\u01fa\5@!\2\u01fa\u01fb\b \1\2\u01fb"+
		"\u01fd\3\2\2\2\u01fc\u01f6\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2"+
		"\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0201"+
		"\u01f0\3\2\2\2\u0202\u0205\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2"+
		"\2\2\u0204?\3\2\2\2\u0205\u0203\3\2\2\2\u0206\u020a\7\5\2\2\u0207\u0208"+
		"\5B\"\2\u0208\u0209\b!\1\2\u0209\u020b\3\2\2\2\u020a\u0207\3\2\2\2\u020a"+
		"\u020b\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u0210\b!\1\2\u020d\u020e\5L\'"+
		"\2\u020e\u020f\b!\1\2\u020f\u0211\3\2\2\2\u0210\u020d\3\2\2\2\u0210\u0211"+
		"\3\2\2\2\u0211\u0215\3\2\2\2\u0212\u0213\5N(\2\u0213\u0214\b!\1\2\u0214"+
		"\u0216\3\2\2\2\u0215\u0212\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0217\3\2"+
		"\2\2\u0217\u0218\7\6\2\2\u0218\u0219\b!\1\2\u0219A\3\2\2\2\u021a\u021b"+
		"\7 \2\2\u021b\u021c\5D#\2\u021c\u021d\7L\2\2\u021d\u021e\b\"\1\2\u021e"+
		"C\3\2\2\2\u021f\u0220\5F$\2\u0220\u0227\b#\1\2\u0221\u0222\7S\2\2\u0222"+
		"\u0223\5F$\2\u0223\u0224\b#\1\2\u0224\u0226\3\2\2\2\u0225\u0221\3\2\2"+
		"\2\u0226\u0229\3\2\2\2\u0227\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228E"+
		"\3\2\2\2\u0229\u0227\3\2\2\2\u022a\u022b\5J&\2\u022b\u022c\5H%\2\u022c"+
		"\u022d\b$\1\2\u022dG\3\2\2\2\u022e\u022f\7@\2\2\u022f\u0230\5F$\2\u0230"+
		"\u0231\5H%\2\u0231\u0232\b%\1\2\u0232\u0235\3\2\2\2\u0233\u0235\3\2\2"+
		"\2\u0234\u022e\3\2\2\2\u0234\u0233\3\2\2\2\u0235I\3\2\2\2\u0236\u0237"+
		"\7N\2\2\u0237\u0238\t\3\2\2\u0238\u0239\7O\2\2\u0239\u023a\b&\1\2\u023a"+
		"K\3\2\2\2\u023b\u023c\7!\2\2\u023c\u023d\7N\2\2\u023d\u023e\t\4\2\2\u023e"+
		"\u023f\7L\2\2\u023f\u0240\b\'\1\2\u0240M\3\2\2\2\u0241\u0242\7$\2\2\u0242"+
		"\u0243\5P)\2\u0243\u0244\7L\2\2\u0244\u0245\b(\1\2\u0245O\3\2\2\2\u0246"+
		"\u0247\5R*\2\u0247\u0248\b)\1\2\u0248\u024f\3\2\2\2\u0249\u024a\7S\2\2"+
		"\u024a\u024b\5R*\2\u024b\u024c\b)\1\2\u024c\u024e\3\2\2\2\u024d\u0249"+
		"\3\2\2\2\u024e\u0251\3\2\2\2\u024f\u024d\3\2\2\2\u024f\u0250\3\2\2\2\u0250"+
		"Q\3\2\2\2\u0251\u024f\3\2\2\2\u0252\u0253\7N\2\2\u0253\u0254\t\5\2\2\u0254"+
		"\u0255\7O\2\2\u0255\u0256\3\2\2\2\u0256\u025e\b*\1\2\u0257\u0258\7N\2"+
		"\2\u0258\u0259\t\5\2\2\u0259\u025a\5X-\2\u025a\u025b\3\2\2\2\u025b\u025c"+
		"\b*\1\2\u025c\u025e\3\2\2\2\u025d\u0252\3\2\2\2\u025d\u0257\3\2\2\2\u025e"+
		"S\3\2\2\2\u025f\u0260\7N\2\2\u0260\u0261\7\60\2\2\u0261\u0262\7O\2\2\u0262"+
		"\u0263\3\2\2\2\u0263\u0264\b+\1\2\u0264U\3\2\2\2\u0265\u0266\5Z.\2\u0266"+
		"\u026d\b,\1\2\u0267\u0268\7S\2\2\u0268\u0269\5Z.\2\u0269\u026a\b,\1\2"+
		"\u026a\u026c\3\2\2\2\u026b\u0267\3\2\2\2\u026c\u026f\3\2\2\2\u026d\u026b"+
		"\3\2\2\2\u026d\u026e\3\2\2\2\u026eW\3\2\2\2\u026f\u026d\3\2\2\2\u0270"+
		"\u0271\5Z.\2\u0271\u0272\b-\1\2\u0272Y\3\2\2\2\u0273\u0274\b.\1\2\u0274"+
		"\u0275\t\6\2\2\u0275\u0276\5Z.\17\u0276\u0277\b.\1\2\u0277\u0281\3\2\2"+
		"\2\u0278\u0279\t\7\2\2\u0279\u027a\5Z.\16\u027a\u027b\b.\1\2\u027b\u0281"+
		"\3\2\2\2\u027c\u027d\7N\2\2\u027d\u0281\b.\1\2\u027e\u027f\7O\2\2\u027f"+
		"\u0281\b.\1\2\u0280\u0273\3\2\2\2\u0280\u0278\3\2\2\2\u0280\u027c\3\2"+
		"\2\2\u0280\u027e\3\2\2\2\u0281\u02c0\3\2\2\2\u0282\u0283\f\r\2\2\u0283"+
		"\u0284\t\b\2\2\u0284\u0285\5Z.\16\u0285\u0286\b.\1\2\u0286\u02bf\3\2\2"+
		"\2\u0287\u0288\f\f\2\2\u0288\u0289\t\t\2\2\u0289\u028a\5Z.\r\u028a\u028b"+
		"\b.\1\2\u028b\u02bf\3\2\2\2\u028c\u028d\f\13\2\2\u028d\u028e\t\2\2\2\u028e"+
		"\u028f\5Z.\f\u028f\u0290\b.\1\2\u0290\u02bf\3\2\2\2\u0291\u0292\f\n\2"+
		"\2\u0292\u0293\t\n\2\2\u0293\u0294\5Z.\13\u0294\u0295\b.\1\2\u0295\u02bf"+
		"\3\2\2\2\u0296\u0297\f\t\2\2\u0297\u0298\7D\2\2\u0298\u0299\5Z.\n\u0299"+
		"\u029a\b.\1\2\u029a\u02bf\3\2\2\2\u029b\u029c\f\b\2\2\u029c\u029d\7?\2"+
		"\2\u029d\u029e\5Z.\t\u029e\u029f\b.\1\2\u029f\u02bf\3\2\2\2\u02a0\u02a1"+
		"\f\7\2\2\u02a1\u02a2\7G\2\2\u02a2\u02a3\5Z.\b\u02a3\u02a4\b.\1\2\u02a4"+
		"\u02bf\3\2\2\2\u02a5\u02a6\f\6\2\2\u02a6\u02a7\7B\2\2\u02a7\u02a8\5Z."+
		"\7\u02a8\u02a9\b.\1\2\u02a9\u02bf\3\2\2\2\u02aa\u02ab\f\5\2\2\u02ab\u02ac"+
		"\7C\2\2\u02ac\u02ad\5Z.\6\u02ad\u02ae\b.\1\2\u02ae\u02bf\3\2\2\2\u02af"+
		"\u02b0\f\4\2\2\u02b0\u02b1\7#\2\2\u02b1\u02b2\5Z.\2\u02b2\u02b3\7\32\2"+
		"\2\u02b3\u02b4\5Z.\5\u02b4\u02b5\b.\1\2\u02b5\u02bf\3\2\2\2\u02b6\u02b7"+
		"\f\3\2\2\u02b7\u02b8\t\13\2\2\u02b8\u02b9\5Z.\4\u02b9\u02ba\b.\1\2\u02ba"+
		"\u02bf\3\2\2\2\u02bb\u02bc\f\20\2\2\u02bc\u02bd\t\f\2\2\u02bd\u02bf\b"+
		".\1\2\u02be\u0282\3\2\2\2\u02be\u0287\3\2\2\2\u02be\u028c\3\2\2\2\u02be"+
		"\u0291\3\2\2\2\u02be\u0296\3\2\2\2\u02be\u029b\3\2\2\2\u02be\u02a0\3\2"+
		"\2\2\u02be\u02a5\3\2\2\2\u02be\u02aa\3\2\2\2\u02be\u02af\3\2\2\2\u02be"+
		"\u02b6\3\2\2\2\u02be\u02bb\3\2\2\2\u02bf\u02c2\3\2\2\2\u02c0\u02be\3\2"+
		"\2\2\u02c0\u02c1\3\2\2\2\u02c1[\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c3\u02c4"+
		"\7N\2\2\u02c4\u02c5\7\60\2\2\u02c5\u02c6\5Z.\2\u02c6\u02c7\3\2\2\2\u02c7"+
		"\u02c8\b/\1\2\u02c8\u02d0\3\2\2\2\u02c9\u02ca\7N\2\2\u02ca\u02cb\7:\2"+
		"\2\u02cb\u02cc\5Z.\2\u02cc\u02cd\3\2\2\2\u02cd\u02ce\b/\1\2\u02ce\u02d0"+
		"\3\2\2\2\u02cf\u02c3\3\2\2\2\u02cf\u02c9\3\2\2\2\u02d0]\3\2\2\2\u02d1"+
		"\u02d6\5Z.\2\u02d2\u02d3\7S\2\2\u02d3\u02d5\5^\60\2\u02d4\u02d2\3\2\2"+
		"\2\u02d5\u02d8\3\2\2\2\u02d6\u02d4\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02d9"+
		"\3\2\2\2\u02d8\u02d6\3\2\2\2\u02d9\u02da\b\60\1\2\u02da\u02dd\3\2\2\2"+
		"\u02db\u02dd\3\2\2\2\u02dc\u02d1\3\2\2\2\u02dc\u02db\3\2\2\2\u02dd_\3"+
		"\2\2\2=ekq}\u008d\u0098\u009d\u00a1\u00a7\u00b8\u00ba\u00bf\u00c2\u00c6"+
		"\u00ce\u00d9\u00e4\u00ed\u00f5\u0102\u0104\u010a\u010e\u0111\u0114\u0116"+
		"\u012b\u0135\u013e\u0147\u0154\u0156\u015c\u0185\u0191\u019b\u01a3\u01ab"+
		"\u01ae\u01b9\u01c7\u01db\u01ed\u01fe\u0203\u020a\u0210\u0215\u0227\u0234"+
		"\u024f\u025d\u026d\u0280\u02be\u02c0\u02cf\u02d6\u02dc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}