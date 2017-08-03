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
		 
			Set<TA> timedAutomata=new HashSet<>();
			declarations = new HashMap<String, String>();	
			currentTaDeclarations = new HashMap<String, String>();
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
					setState(94);
					((TaContext)_localctx).dec = ((TaContext)_localctx).declaration = declaration();


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
		public BoundedVariableDeclContext boundedVariableDecl() {
			return getRuleContext(BoundedVariableDeclContext.class,0);
		}
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
		 
		 	((DeclarationContext)_localctx).variabledeclret = new HashMap();
		 	((DeclarationContext)_localctx).variableinitializationret = new HashMap<>();
		 	((DeclarationContext)_localctx).clockinitializationret = new HashMap<>();
		 	
		 
		try {
			setState(127);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				((DeclarationContext)_localctx).boundedVariableDecl = boundedVariableDecl();

								declarations.putAll(((DeclarationContext)_localctx).boundedVariableDecl.variabledeclret);
				 			_localctx.variabledeclret.putAll(((DeclarationContext)_localctx).boundedVariableDecl.variabledeclret);
				 			_localctx.variableinitializationret.putAll(((DeclarationContext)_localctx).boundedVariableDecl.variableinitializationret);
				 			
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				functionDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				((DeclarationContext)_localctx).variableDecl = variableDecl();

				 		declarations.putAll(((DeclarationContext)_localctx).variableDecl.variabledeclret);
				 		_localctx.variabledeclret.putAll(((DeclarationContext)_localctx).variableDecl.variabledeclret);
				 		_localctx.variableinitializationret.putAll(((DeclarationContext)_localctx).variableDecl.variableinitializationret);
				 		((DeclarationContext)_localctx).clockinitializationret = ((DeclarationContext)_localctx).variableDecl.clockinitializationret;
				 	
				 	
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				typeDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
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
			setState(129);
			match(ID);
			setState(130);
			declarationid();
			setState(131);
			match(ID);
			setState(132);
			match(LPAR);
			setState(133);
			argList();
			setState(134);
			match(RPAR);
			setState(135);
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
			setState(137);
			match(T__0);
			setState(138);
			match(ID);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(139);
				match(COMMA);
				setState(140);
				match(ID);
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
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
			setState(159);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(148);
				match(LPAR);
				setState(149);
				parameter();
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(150);
					match(COMMA);
					setState(151);
					parameter();
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
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
			setState(161);
			type();
			setState(163);
			_la = _input.LA(1);
			if (_la==BITAND) {
				{
				setState(162);
				match(BITAND);
				}
			}

			setState(165);
			match(ID);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(166);
				arrayDecl();
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
			setState(172);
			match(T__1);
			setState(173);
			((ProcDeclContext)_localctx).ID = match(ID);
			currentProc=(((ProcDeclContext)_localctx).ID!=null?((ProcDeclContext)_localctx).ID.getText():null);
			setState(175);
			parameterList();
			setState(176);
			match(T__2);
			setState(177);
			((ProcDeclContext)_localctx).procBody = procBody();
			setState(178);
			match(T__3);

				
				
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
			 	
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13))) != 0) || _la==ID) {
				{
				setState(187);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(182);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(183);
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
					setState(186);
					typeDecl();
					}
					break;
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
			((ProcBodyContext)_localctx).states = states();
			setState(194);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(193);
				commit();
				}
			}

			setState(197);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(196);
				urgent();
				}
			}

			setState(199);
			((ProcBodyContext)_localctx).init = init();

			 		for(State s: ((ProcBodyContext)_localctx).states.stateset){
			 			if(s.getStringId().equals(((ProcBodyContext)_localctx).init.initString)){
			 				((ProcBodyContext)_localctx).initstate = s;
			 			}
			 		}
			 	
			setState(202);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(201);
				((ProcBodyContext)_localctx).transitions = transitions();
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public List<TerminalNode> NAT() { return getTokens(TAParser.NAT); }
		public TerminalNode NAT(int i) {
			return getToken(TAParser.NAT, i);
		}
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(206);
			((BoundedVariableDeclContext)_localctx).type = type();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(207);
				arrayDecl();
				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(213);
			((BoundedVariableDeclContext)_localctx).ID = match(ID);
			setState(214);
			match(T__2);
			setState(215);
			((BoundedVariableDeclContext)_localctx).nat = match(NAT);

			 				values.add(Integer.parseInt((((BoundedVariableDeclContext)_localctx).nat!=null?((BoundedVariableDeclContext)_localctx).nat.getText():null)));
			 				
			 			
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(217);
				match(COMMA);
				setState(218);
				((BoundedVariableDeclContext)_localctx).nat = match(NAT);

				 				 	values.add(Integer.parseInt((((BoundedVariableDeclContext)_localctx).nat!=null?((BoundedVariableDeclContext)_localctx).nat.getText():null)));
				 				
				 			
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225);
			match(T__3);

			 			if(definedVar((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null))){
			 				
			 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+(((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null));
					
			 			}
			 			_localctx.variabledeclret.put((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null), (((BoundedVariableDeclContext)_localctx).type!=null?_input.getText(((BoundedVariableDeclContext)_localctx).type.start,((BoundedVariableDeclContext)_localctx).type.stop):null));
			 			boundedVariablesValues.put((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null), values);
			 		
			 		
			setState(231);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(227);
				match(EQ);
				setState(228);
				((BoundedVariableDeclContext)_localctx).expression = expression(0);

				 			_localctx.variableinitializationret.put((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null), ((BoundedVariableDeclContext)_localctx).expression.exp);
						
				}
			}

			setState(233);
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
		enterRule(_localctx, 18, RULE_variableDecl);

		 	((VariableDeclContext)_localctx).variabledeclret = new HashMap<>();
		 	((VariableDeclContext)_localctx).variableinitializationret = new HashMap<>();
		 	((VariableDeclContext)_localctx).clockinitializationret = new HashMap<>();
		 	
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			((VariableDeclContext)_localctx).type = type();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(236);
				arrayDecl();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(242);
			((VariableDeclContext)_localctx).var1 = variableId();

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
			 		
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(244);
				match(COMMA);
				setState(245);
				((VariableDeclContext)_localctx).varn = variableId();

				 			
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
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(253);
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
		enterRule(_localctx, 20, RULE_variableId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			((VariableIdContext)_localctx).ID = match(ID);

					((VariableIdContext)_localctx).id = (((VariableIdContext)_localctx).ID!=null?((VariableIdContext)_localctx).ID.getText():null);

			setState(261);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(257);
				match(EQ);
				setState(258);
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
		enterRule(_localctx, 22, RULE_arrayDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(LBRA);
			setState(264);
			expression(0);
			setState(265);
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
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			setState(293);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				prefix();
				setState(268);
				match(ID);
				setState(270);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(269);
					range();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				prefix();
				setState(273);
				match(T__4);
				setState(274);
				match(T__2);
				setState(276); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(275);
					fieldDecl();
					}
					}
					setState(278); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0) || _la==ID );
				setState(280);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(282);
				prefix();
				setState(291);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(283);
					match(T__5);
					 ((TypeContext)_localctx).typeret = Integer.class;
					                		 
					}
					break;
				case T__6:
					{
					setState(285);
					match(T__6);
					 ((TypeContext)_localctx).typeret = Clock.class;
					                		 
					}
					break;
				case T__7:
					{
					setState(287);
					match(T__7);
					 ((TypeContext)_localctx).typeret = Character.class;
					                		 
					}
					break;
				case T__8:
					{
					setState(289);
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
		enterRule(_localctx, 26, RULE_fieldDeclId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(ID);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(296);
				arrayDecl();
				}
				}
				setState(301);
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
			setState(311);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(303);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(302);
					match(T__9);
					}
				}

				setState(306);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(305);
					match(T__10);
					}
				}

				}
				break;
			case 2:
				{
				setState(309);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(308);
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
		enterRule(_localctx, 30, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(LBRA);
			setState(314);
			match(NAT);
			setState(315);
			match(COMMA);
			setState(316);
			match(NAT);
			setState(317);
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
		enterRule(_localctx, 32, RULE_commit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(T__12);
			setState(320);
			stateList();
			setState(321);
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
		enterRule(_localctx, 34, RULE_urgent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(T__9);
			setState(324);
			stateList();
			setState(325);
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
		enterRule(_localctx, 36, RULE_stateList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(ID);
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(328);
				match(COMMA);
				setState(329);
				match(ID);
				}
				}
				setState(334);
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
		enterRule(_localctx, 38, RULE_typeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(T__13);
			setState(336);
			type();
			setState(337);
			typeIdList();
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(338);
				match(COMMA);
				setState(339);
				typeIdList();
				}
				}
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(345);
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
		enterRule(_localctx, 40, RULE_typeIdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(ID);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(348);
				arrayDecl();
				}
				}
				setState(353);
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
		enterRule(_localctx, 42, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			type();
			setState(355);
			fieldDeclId();
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(356);
				match(COMMA);
				setState(357);
				fieldDeclId();
				}
				}
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(363);
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
		enterRule(_localctx, 44, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			type();
			setState(366);
			match(ID);
			setState(367);
			parameterList();
			setState(368);
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
		enterRule(_localctx, 46, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(T__2);
			setState(375);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(373);
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
						setState(371);
						variableDecl();
						}
						break;
					case T__13:
						{
						setState(372);
						typeDecl();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(377);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__34) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
				{
				{
				setState(378);
				statement();
				}
				}
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(384);
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
		enterRule(_localctx, 48, RULE_statement);
		int _la;
		try {
			setState(444);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(386);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
				match(SEMICOLUMN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(388);
				expression(0);
				setState(389);
				match(SEMICOLUMN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(391);
				match(T__14);
				setState(392);
				match(LPAR);
				setState(393);
				exprList();
				setState(394);
				match(SEMICOLUMN);
				setState(395);
				exprList();
				setState(396);
				match(SEMICOLUMN);
				setState(397);
				exprList();
				setState(398);
				match(RPAR);
				setState(399);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(401);
				match(T__15);
				setState(402);
				match(LPAR);
				setState(403);
				exprList();
				setState(404);
				match(RPAR);
				setState(405);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(407);
				match(T__16);
				setState(408);
				statement();
				setState(409);
				match(T__15);
				setState(410);
				match(LPAR);
				setState(411);
				exprList();
				setState(412);
				match(RPAR);
				setState(413);
				match(SEMICOLUMN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(415);
				match(T__17);
				setState(416);
				match(LPAR);
				setState(417);
				exprList();
				setState(418);
				match(RPAR);
				setState(419);
				statement();
				setState(422);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(420);
					match(T__18);
					setState(421);
					statement();
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(424);
				match(T__19);
				setState(425);
				match(SEMICOLUMN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(426);
				match(T__20);
				setState(427);
				match(LPAR);
				setState(428);
				exprList();
				setState(429);
				match(RPAR);
				setState(430);
				match(T__2);
				setState(432); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(431);
					caseocc();
					}
					}
					setState(434); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__22 || _la==T__24 );
				setState(436);
				match(T__3);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(438);
				match(T__21);
				setState(439);
				match(SEMICOLUMN);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(440);
				match(T__21);
				setState(441);
				expression(0);
				setState(442);
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
		enterRule(_localctx, 50, RULE_caseocc);
		int _la;
		try {
			setState(463);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(446);
				match(T__22);
				setState(447);
				expression(0);
				setState(448);
				match(T__23);
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__34) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
					{
					{
					setState(449);
					statement();
					}
					}
					setState(454);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(455);
				match(T__24);
				setState(456);
				match(T__23);
				setState(460);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__34) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
					{
					{
					setState(457);
					statement();
					}
					}
					setState(462);
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
		enterRule(_localctx, 52, RULE_states);

			((StatesContext)_localctx).stateset = new HashSet<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			match(T__25);
			setState(466);
			((StatesContext)_localctx).s1 = stateDecl();

				_localctx.stateset.add(((StatesContext)_localctx).s1.state);

			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(468);
				match(COMMA);
				setState(469);
				((StatesContext)_localctx).s2 = stateDecl();

					_localctx.stateset.add(((StatesContext)_localctx).s2.state);

				}
				}
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(477);
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
		enterRule(_localctx, 54, RULE_stateDecl);
		try {
			setState(488);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				((StateDeclContext)_localctx).ID = match(ID);

						((StateDeclContext)_localctx).state = new State((((StateDeclContext)_localctx).ID!=null?((StateDeclContext)_localctx).ID.getText():null));
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(481);
				((StateDeclContext)_localctx).ID = match(ID);
				{
				setState(482);
				match(T__2);
				setState(483);
				((StateDeclContext)_localctx).inv = invariant();
				setState(484);
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
		enterRule(_localctx, 56, RULE_invariant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			((InvariantContext)_localctx).ID = match(ID);
			setState(491);
			((InvariantContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE))) != 0)) ) {
				((InvariantContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(492);
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
			setState(495);
			match(T__26);
			setState(496);
			((InitContext)_localctx).ID = match(ID);
			setState(497);
			match(SEMICOLUMN);

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
			setState(500);
			match(T__27);
			setState(501);
			((TransitionsContext)_localctx).transitionset = transitionset();

					_localctx.transitionsret.addAll(((TransitionsContext)_localctx).transitionset.transitionsret);
				
			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(503);
				((TransitionsContext)_localctx).transitionset = transitionset();

						_localctx.transitionsret.addAll(((TransitionsContext)_localctx).transitionset.transitionsret);		
					
				}
				}
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(511);
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
		enterRule(_localctx, 62, RULE_transitionset);
		((TransitionsetContext)_localctx).transitionsret = new HashSet<>();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			((TransitionsetContext)_localctx).s1 = match(ID);
			setState(514);
			match(T__28);
			setState(515);
			((TransitionsetContext)_localctx).s2 = match(ID);
			setState(516);
			((TransitionsetContext)_localctx).transitionBody = transitionBody();

					_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s2.getText()), ((TransitionsetContext)_localctx).transitionBody.guardexp, ((TransitionsetContext)_localctx).transitionBody.syncexp,  ((TransitionsetContext)_localctx).transitionBody.assignexp));
				
			setState(526);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(518);
					match(COMMA);
					setState(519);
					match(T__28);
					setState(520);
					((TransitionsetContext)_localctx).s3 = match(ID);
					setState(521);
					((TransitionsetContext)_localctx).b2 = ((TransitionsetContext)_localctx).transitionBody = transitionBody();

							_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s3.getText()), ((TransitionsetContext)_localctx).b2.guardexp, ((TransitionsetContext)_localctx).b2.syncexp,  ((TransitionsetContext)_localctx).b2.assignexp));
							
						
					}
					} 
				}
				setState(528);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			setState(548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(529);
				match(COMMA);
				setState(530);
				((TransitionsetContext)_localctx).s1 = match(ID);
				setState(531);
				match(T__28);
				setState(532);
				((TransitionsetContext)_localctx).s2 = match(ID);
				setState(533);
				((TransitionsetContext)_localctx).transitionBody = transitionBody();

						_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s2.getText()), ((TransitionsetContext)_localctx).transitionBody.guardexp, ((TransitionsetContext)_localctx).transitionBody.syncexp,  ((TransitionsetContext)_localctx).transitionBody.assignexp));
					
				setState(543);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(535);
						match(COMMA);
						setState(536);
						match(T__28);
						setState(537);
						((TransitionsetContext)_localctx).s3 = match(ID);
						setState(538);
						((TransitionsetContext)_localctx).b2 = ((TransitionsetContext)_localctx).transitionBody = transitionBody();

								_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s3.getText()), ((TransitionsetContext)_localctx).b2.guardexp, ((TransitionsetContext)_localctx).b2.syncexp,  ((TransitionsetContext)_localctx).b2.assignexp));
								
							
						}
						} 
					}
					setState(545);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				}
				}
				}
				setState(550);
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
			setState(551);
			match(T__2);
			setState(555);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(552);
				((TransitionBodyContext)_localctx).guard = guard();

				 			 ((TransitionBodyContext)_localctx).guardexp = ((TransitionBodyContext)_localctx).guard.guardexp;
				 		
				}
			}


					if(_localctx.guardexp==null) {((TransitionBodyContext)_localctx).guardexp = new Guard(new HashSet<VariableConstraintAtom>(), new HashSet<ClockConstraintAtom>());}
					
			{
			setState(558);
			((TransitionBodyContext)_localctx).sync = sync();

					((TransitionBodyContext)_localctx).syncexp = ((TransitionBodyContext)_localctx).sync.syncexp;
					
			}
			setState(564);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(561);
				((TransitionBodyContext)_localctx).assign = assign();

				 			((TransitionBodyContext)_localctx).assignexp = ((TransitionBodyContext)_localctx).assign.assignexp;
				 		
				}
			}

			setState(566);
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
		enterRule(_localctx, 66, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
			match(T__29);
			setState(570);
			((GuardContext)_localctx).exp1 = ((GuardContext)_localctx).guardconditionList = guardconditionList();
			setState(571);
			match(SEMICOLUMN);

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
		public List<TerminalNode> AND() { return getTokens(TAParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(TAParser.AND, i);
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
			setState(574);
			((GuardconditionListContext)_localctx).clockconstraint = clockconstraint();

							if(((GuardconditionListContext)_localctx).clockconstraint.clockconst!=null) _localctx.clockconst.add(((GuardconditionListContext)_localctx).clockconstraint.clockconst) ;
							if(((GuardconditionListContext)_localctx).clockconstraint.variableconst!=null) _localctx.variableconst.add(((GuardconditionListContext)_localctx).clockconstraint.variableconst);
						
			setState(586);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (AND - 64)) | (1L << (ID - 64)) | (1L << (COMMA - 64)))) != 0)) {
				{
				{
				setState(579);
				switch (_input.LA(1)) {
				case COMMA:
					{
					setState(576);
					match(COMMA);
					}
					break;
				case ID:
					{
					}
					break;
				case AND:
					{
					setState(578);
					match(AND);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(581);
				((GuardconditionListContext)_localctx).clockconstraint = clockconstraint();

								if(((GuardconditionListContext)_localctx).clockconstraint.clockconst!=null) _localctx.clockconst.add(((GuardconditionListContext)_localctx).clockconstraint.clockconst);
								if(((GuardconditionListContext)_localctx).clockconstraint.variableconst!=null)_localctx.variableconst.add(((GuardconditionListContext)_localctx).clockconstraint.variableconst) ;
							
				}
				}
				setState(588);
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
			setState(589);
			((ClockconstraintContext)_localctx).constraintAtom = constraintAtom();

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
			setState(592);
			((ConstraintAtomContext)_localctx).id = match(ID);
			setState(593);
			((ConstraintAtomContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE) | (1L << EQCOMP))) != 0)) ) {
				((ConstraintAtomContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(594);
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
			setState(609);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				{
				setState(597);
				match(T__30);
				setState(598);
				((SyncContext)_localctx).exp2 = match(ID);
				setState(599);
				((SyncContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__32) ) {
					((SyncContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(600);
				match(SEMICOLUMN);
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
				setState(603);
				match(T__30);
				setState(604);
				((SyncContext)_localctx).exp2 = match(ID);
				setState(605);
				match(SEMICOLUMN);
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
			setState(611);
			match(T__33);
			setState(612);
			((AssignContext)_localctx).expl = ((AssignContext)_localctx).assignmentList = assignmentList();
			setState(613);
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
			setState(616);
			((AssignmentListContext)_localctx).assignment = assignment();

				 		if(((AssignmentListContext)_localctx).assignment.clockassignementsret!=null){
				 			_localctx.clockassignement.add(((AssignmentListContext)_localctx).assignment.clockassignementsret);
				 		}
				 		if(((AssignmentListContext)_localctx).assignment.variableAssignementret!=null){
				 			_localctx.variableassignement.add(((AssignmentListContext)_localctx).assignment.variableAssignementret);
				 		}
				 	
			}
			setState(625);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				{
				setState(619);
				match(COMMA);
				setState(620);
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
				setState(627);
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
			setState(639);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(628);
				((AssignmentContext)_localctx).id = match(ID);
				setState(629);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQASSIGN || _la==EQ) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(630);
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
				setState(633);
				((AssignmentContext)_localctx).id = match(ID);
				setState(634);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQASSIGN || _la==EQ) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(635);
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
			setState(641);
			((SimpleassigmentContext)_localctx).id = match(ID);
			setState(642);
			((SimpleassigmentContext)_localctx).op = match(EQ);
			setState(643);
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
			setState(647);
			((ExprListContext)_localctx).exp1 = expression(0);

				_localctx.exprListret.add(((ExprListContext)_localctx).exp1.exp);

			setState(655);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(649);
				match(COMMA);
				setState(650);
				((ExprListContext)_localctx).exp2 = expression(0);

					_localctx.exprListret.add(((ExprListContext)_localctx).exp2.exp);
					
				}
				}
				setState(657);
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
			setState(658);
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
			setState(674);
			switch (_input.LA(1)) {
			case PLUS:
			case PLUSPLUS:
			case MINUSMINUS:
			case MINUS:
				{
				setState(662);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0)) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(663);
				((ExpressionContext)_localctx).exp1 = expression(13);

				    	((ExpressionContext)_localctx).exp = new LeftUnaryOperator((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp1.exp);
				    
				}
				break;
			case T__31:
			case T__34:
				{
				setState(666);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__34) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(667);
				((ExpressionContext)_localctx).exp1 = expression(12);

				    	((ExpressionContext)_localctx).exp = new LeftUnaryOperator((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp1.exp);
				    
				}
				break;
			case ID:
				{
				setState(670);
				((ExpressionContext)_localctx).ID = match(ID);

						((ExpressionContext)_localctx).exp = new Identifier((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
					
				}
				break;
			case NAT:
				{
				setState(672);
				((ExpressionContext)_localctx).NAT = match(NAT);

						((ExpressionContext)_localctx).exp = new Value((((ExpressionContext)_localctx).NAT!=null?((ExpressionContext)_localctx).NAT.getText():null));
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(738);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(736);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(676);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(677);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << FRACT) | (1L << MOD))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(678);
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
						setState(681);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(682);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(683);
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
						setState(686);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(687);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(688);
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
						setState(691);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(692);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQCOMP || _la==NEQ) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(693);
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
						setState(696);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(697);
						((ExpressionContext)_localctx).op = match(BITAND);
						setState(698);
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
						setState(701);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(702);
						((ExpressionContext)_localctx).op = match(POW);
						setState(703);
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
						setState(706);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(707);
						((ExpressionContext)_localctx).op = match(BITOR);
						setState(708);
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
						setState(711);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(712);
						((ExpressionContext)_localctx).op = match(AND);
						setState(713);
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
						setState(716);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(717);
						((ExpressionContext)_localctx).op = match(OR);
						setState(718);
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
						setState(721);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(722);
						match(T__32);
						setState(723);
						((ExpressionContext)_localctx).exp2 = expression(0);
						setState(724);
						match(T__23);
						setState(725);
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
						setState(728);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(729);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & ((1L << (T__35 - 36)) | (1L << (T__36 - 36)) | (1L << (T__37 - 36)) | (1L << (EQ - 36)) | (1L << (FRACTEQ - 36)) | (1L << (MODEQ - 36)) | (1L << (PLUSEQ - 36)) | (1L << (MINUSEQ - 36)) | (1L << (COLUMEQ - 36)) | (1L << (MULTEQ - 36)) | (1L << (POWEQ - 36)) | (1L << (BITANDEQ - 36)) | (1L << (BITOREQ - 36)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(730);
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
						setState(733);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(734);
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
				setState(740);
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
			setState(753);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(741);
				((DeclarationidContext)_localctx).ID = match(ID);
				setState(742);
				((DeclarationidContext)_localctx).op = match(EQ);
				setState(743);
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
				setState(747);
				((DeclarationidContext)_localctx).ID = match(ID);
				setState(748);
				((DeclarationidContext)_localctx).op = match(COLUMEQ);
				setState(749);
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
			setState(766);
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
				setState(755);
				((ArgListContext)_localctx).expression = expression(0);
				setState(760);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(756);
						match(COMMA);
						setState(757);
						((ArgListContext)_localctx).argList = argList();
						}
						} 
					}
					setState(762);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3U\u0303\4\2\t\2\4"+
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
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00be\n\t"+
		"\f\t\16\t\u00c1\13\t\3\t\3\t\5\t\u00c5\n\t\3\t\5\t\u00c8\n\t\3\t\3\t\3"+
		"\t\5\t\u00cd\n\t\3\t\3\t\3\n\3\n\7\n\u00d3\n\n\f\n\16\n\u00d6\13\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00df\n\n\f\n\16\n\u00e2\13\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u00ea\n\n\3\n\3\n\3\13\3\13\7\13\u00f0\n\13\f\13\16\13"+
		"\u00f3\13\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00fb\n\13\f\13\16\13"+
		"\u00fe\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0108\n\f\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\5\16\u0111\n\16\3\16\3\16\3\16\3\16\6\16\u0117\n"+
		"\16\r\16\16\16\u0118\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u0126\n\16\5\16\u0128\n\16\3\17\3\17\7\17\u012c\n\17\f\17\16"+
		"\17\u012f\13\17\3\20\5\20\u0132\n\20\3\20\5\20\u0135\n\20\3\20\5\20\u0138"+
		"\n\20\5\20\u013a\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u014d\n\24\f\24\16\24\u0150\13"+
		"\24\3\25\3\25\3\25\3\25\3\25\7\25\u0157\n\25\f\25\16\25\u015a\13\25\3"+
		"\25\3\25\3\26\3\26\7\26\u0160\n\26\f\26\16\26\u0163\13\26\3\27\3\27\3"+
		"\27\3\27\7\27\u0169\n\27\f\27\16\27\u016c\13\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\7\31\u0178\n\31\f\31\16\31\u017b\13\31\3"+
		"\31\7\31\u017e\n\31\f\31\16\31\u0181\13\31\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\5\32\u01a9\n\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\6\32\u01b3\n\32\r\32\16\32\u01b4\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\5\32\u01bf\n\32\3\33\3\33\3\33\3\33\7\33\u01c5\n\33\f\33"+
		"\16\33\u01c8\13\33\3\33\3\33\3\33\7\33\u01cd\n\33\f\33\16\33\u01d0\13"+
		"\33\5\33\u01d2\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u01db\n\34"+
		"\f\34\16\34\u01de\13\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\5\35\u01eb\n\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3 \7 \u01fd\n \f \16 \u0200\13 \3 \3 \3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\7!\u020f\n!\f!\16!\u0212\13!\3!\3!\3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\7!\u0220\n!\f!\16!\u0223\13!\7!\u0225\n!\f!\16!\u0228"+
		"\13!\3\"\3\"\3\"\3\"\5\"\u022e\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0237"+
		"\n\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\5$\u0246\n$\3$\3$\3$\7"+
		"$\u024b\n$\f$\16$\u024e\13$\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0264\n\'\3(\3(\3(\3(\3(\3)\3)\3)\3"+
		")\3)\3)\3)\7)\u0272\n)\f)\16)\u0275\13)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\5*\u0282\n*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\7,\u0290\n,\f,\16"+
		",\u0293\13,\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u02a5\n"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\7.\u02e3\n.\f.\16.\u02e6\13"+
		".\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u02f4\n/\3\60\3\60\3\60\7\60"+
		"\u02f9\n\60\f\60\16\60\u02fc\13\60\3\60\3\60\3\60\5\60\u0301\n\60\3\60"+
		"\2\3Z\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":<>@BDFHJLNPRTVXZ\\^\2\r\3\2),\3\2)-\3\2\"#\3\2/\60\3\2\63\66\4\2\"\""+
		"%%\4\2\67\67=>\4\2\63\63\66\66\3\2-.\6\2&(\60\628<EF\3\2\64\65\u032f\2"+
		"e\3\2\2\2\4\u0081\3\2\2\2\6\u0083\3\2\2\2\b\u008b\3\2\2\2\n\u00a1\3\2"+
		"\2\2\f\u00a3\3\2\2\2\16\u00ae\3\2\2\2\20\u00b7\3\2\2\2\22\u00d0\3\2\2"+
		"\2\24\u00ed\3\2\2\2\26\u0101\3\2\2\2\30\u0109\3\2\2\2\32\u0127\3\2\2\2"+
		"\34\u0129\3\2\2\2\36\u0139\3\2\2\2 \u013b\3\2\2\2\"\u0141\3\2\2\2$\u0145"+
		"\3\2\2\2&\u0149\3\2\2\2(\u0151\3\2\2\2*\u015d\3\2\2\2,\u0164\3\2\2\2."+
		"\u016f\3\2\2\2\60\u0174\3\2\2\2\62\u01be\3\2\2\2\64\u01d1\3\2\2\2\66\u01d3"+
		"\3\2\2\28\u01ea\3\2\2\2:\u01ec\3\2\2\2<\u01f1\3\2\2\2>\u01f6\3\2\2\2@"+
		"\u0203\3\2\2\2B\u0229\3\2\2\2D\u023b\3\2\2\2F\u0240\3\2\2\2H\u024f\3\2"+
		"\2\2J\u0252\3\2\2\2L\u0263\3\2\2\2N\u0265\3\2\2\2P\u026a\3\2\2\2R\u0281"+
		"\3\2\2\2T\u0283\3\2\2\2V\u0289\3\2\2\2X\u0294\3\2\2\2Z\u02a4\3\2\2\2\\"+
		"\u02f3\3\2\2\2^\u0300\3\2\2\2`a\5\4\3\2ab\b\2\1\2bd\3\2\2\2c`\3\2\2\2"+
		"dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fk\3\2\2\2ge\3\2\2\2hj\5\6\4\2ih\3\2\2\2"+
		"jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2lo\3\2\2\2mk\3\2\2\2np\5\b\5\2on\3\2\2\2"+
		"pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7\2\2\3tu\b\2\1\2u\3\3\2\2"+
		"\2vw\5\22\n\2wx\b\3\1\2x\u0082\3\2\2\2y\u0082\5.\30\2z{\5\24\13\2{|\b"+
		"\3\1\2|\u0082\3\2\2\2}\u0082\5(\25\2~\177\5\16\b\2\177\u0080\b\3\1\2\u0080"+
		"\u0082\3\2\2\2\u0081v\3\2\2\2\u0081y\3\2\2\2\u0081z\3\2\2\2\u0081}\3\2"+
		"\2\2\u0081~\3\2\2\2\u0082\5\3\2\2\2\u0083\u0084\7N\2\2\u0084\u0085\5\\"+
		"/\2\u0085\u0086\7N\2\2\u0086\u0087\7H\2\2\u0087\u0088\5^\60\2\u0088\u0089"+
		"\7I\2\2\u0089\u008a\7L\2\2\u008a\7\3\2\2\2\u008b\u008c\7\3\2\2\u008c\u0091"+
		"\7N\2\2\u008d\u008e\7S\2\2\u008e\u0090\7N\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7L\2\2\u0095\t\3\2\2\2\u0096\u0097"+
		"\7H\2\2\u0097\u009c\5\f\7\2\u0098\u0099\7S\2\2\u0099\u009b\5\f\7\2\u009a"+
		"\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2"+
		"\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7I\2\2\u00a0"+
		"\u00a2\3\2\2\2\u00a1\u0096\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\13\3\2\2"+
		"\2\u00a3\u00a5\5\32\16\2\u00a4\u00a6\7D\2\2\u00a5\u00a4\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00ab\7N\2\2\u00a8\u00aa\5\30"+
		"\r\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\r\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7\4\2\2"+
		"\u00af\u00b0\7N\2\2\u00b0\u00b1\b\b\1\2\u00b1\u00b2\5\n\6\2\u00b2\u00b3"+
		"\7\5\2\2\u00b3\u00b4\5\20\t\2\u00b4\u00b5\7\6\2\2\u00b5\u00b6\b\b\1\2"+
		"\u00b6\17\3\2\2\2\u00b7\u00bf\b\t\1\2\u00b8\u00be\5.\30\2\u00b9\u00ba"+
		"\5\24\13\2\u00ba\u00bb\b\t\1\2\u00bb\u00be\3\2\2\2\u00bc\u00be\5(\25\2"+
		"\u00bd\u00b8\3\2\2\2\u00bd\u00b9\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1"+
		"\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00c4\5\66\34\2\u00c3\u00c5\5\"\22\2\u00c4\u00c3"+
		"\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c8\5$\23\2\u00c7"+
		"\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\5<"+
		"\37\2\u00ca\u00cc\b\t\1\2\u00cb\u00cd\5> \2\u00cc\u00cb\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\b\t\1\2\u00cf\21\3\2\2"+
		"\2\u00d0\u00d4\5\32\16\2\u00d1\u00d3\5\30\r\2\u00d2\u00d1\3\2\2\2\u00d3"+
		"\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\3\2"+
		"\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7N\2\2\u00d8\u00d9\7\5\2\2\u00d9"+
		"\u00da\7O\2\2\u00da\u00e0\b\n\1\2\u00db\u00dc\7S\2\2\u00dc\u00dd\7O\2"+
		"\2\u00dd\u00df\b\n\1\2\u00de\u00db\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de"+
		"\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3"+
		"\u00e4\7\6\2\2\u00e4\u00e9\b\n\1\2\u00e5\u00e6\7\60\2\2\u00e6\u00e7\5"+
		"Z.\2\u00e7\u00e8\b\n\1\2\u00e8\u00ea\3\2\2\2\u00e9\u00e5\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\7L\2\2\u00ec\23\3\2\2\2"+
		"\u00ed\u00f1\5\32\16\2\u00ee\u00f0\5\30\r\2\u00ef\u00ee\3\2\2\2\u00f0"+
		"\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2"+
		"\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\5\26\f\2\u00f5\u00fc\b\13\1\2\u00f6"+
		"\u00f7\7S\2\2\u00f7\u00f8\5\26\f\2\u00f8\u00f9\b\13\1\2\u00f9\u00fb\3"+
		"\2\2\2\u00fa\u00f6\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0100\7L"+
		"\2\2\u0100\25\3\2\2\2\u0101\u0102\7N\2\2\u0102\u0107\b\f\1\2\u0103\u0104"+
		"\7\60\2\2\u0104\u0105\5Z.\2\u0105\u0106\b\f\1\2\u0106\u0108\3\2\2\2\u0107"+
		"\u0103\3\2\2\2\u0107\u0108\3\2\2\2\u0108\27\3\2\2\2\u0109\u010a\7J\2\2"+
		"\u010a\u010b\5Z.\2\u010b\u010c\7K\2\2\u010c\31\3\2\2\2\u010d\u010e\5\36"+
		"\20\2\u010e\u0110\7N\2\2\u010f\u0111\5 \21\2\u0110\u010f\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u0128\3\2\2\2\u0112\u0113\5\36\20\2\u0113\u0114\7"+
		"\7\2\2\u0114\u0116\7\5\2\2\u0115\u0117\5,\27\2\u0116\u0115\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\u011b\7\6\2\2\u011b\u0128\3\2\2\2\u011c\u0125\5\36\20\2\u011d"+
		"\u011e\7\b\2\2\u011e\u0126\b\16\1\2\u011f\u0120\7\t\2\2\u0120\u0126\b"+
		"\16\1\2\u0121\u0122\7\n\2\2\u0122\u0126\b\16\1\2\u0123\u0124\7\13\2\2"+
		"\u0124\u0126\b\16\1\2\u0125\u011d\3\2\2\2\u0125\u011f\3\2\2\2\u0125\u0121"+
		"\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u010d\3\2\2\2\u0127"+
		"\u0112\3\2\2\2\u0127\u011c\3\2\2\2\u0128\33\3\2\2\2\u0129\u012d\7N\2\2"+
		"\u012a\u012c\5\30\r\2\u012b\u012a\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b"+
		"\3\2\2\2\u012d\u012e\3\2\2\2\u012e\35\3\2\2\2\u012f\u012d\3\2\2\2\u0130"+
		"\u0132\7\f\2\2\u0131\u0130\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\3\2"+
		"\2\2\u0133\u0135\7\r\2\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u013a\3\2\2\2\u0136\u0138\7\16\2\2\u0137\u0136\3\2\2\2\u0137\u0138\3"+
		"\2\2\2\u0138\u013a\3\2\2\2\u0139\u0131\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"\37\3\2\2\2\u013b\u013c\7J\2\2\u013c\u013d\7O\2\2\u013d\u013e\7S\2\2\u013e"+
		"\u013f\7O\2\2\u013f\u0140\7K\2\2\u0140!\3\2\2\2\u0141\u0142\7\17\2\2\u0142"+
		"\u0143\5&\24\2\u0143\u0144\7L\2\2\u0144#\3\2\2\2\u0145\u0146\7\f\2\2\u0146"+
		"\u0147\5&\24\2\u0147\u0148\7L\2\2\u0148%\3\2\2\2\u0149\u014e\7N\2\2\u014a"+
		"\u014b\7S\2\2\u014b\u014d\7N\2\2\u014c\u014a\3\2\2\2\u014d\u0150\3\2\2"+
		"\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\'\3\2\2\2\u0150\u014e"+
		"\3\2\2\2\u0151\u0152\7\20\2\2\u0152\u0153\5\32\16\2\u0153\u0158\5*\26"+
		"\2\u0154\u0155\7S\2\2\u0155\u0157\5*\26\2\u0156\u0154\3\2\2\2\u0157\u015a"+
		"\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015b\u015c\7L\2\2\u015c)\3\2\2\2\u015d\u0161\7N\2\2\u015e"+
		"\u0160\5\30\r\2\u015f\u015e\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3"+
		"\2\2\2\u0161\u0162\3\2\2\2\u0162+\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0165"+
		"\5\32\16\2\u0165\u016a\5\34\17\2\u0166\u0167\7S\2\2\u0167\u0169\5\34\17"+
		"\2\u0168\u0166\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b"+
		"\3\2\2\2\u016b\u016d\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u016e\7L\2\2\u016e"+
		"-\3\2\2\2\u016f\u0170\5\32\16\2\u0170\u0171\7N\2\2\u0171\u0172\5\n\6\2"+
		"\u0172\u0173\5\60\31\2\u0173/\3\2\2\2\u0174\u0179\7\5\2\2\u0175\u0178"+
		"\5\24\13\2\u0176\u0178\5(\25\2\u0177\u0175\3\2\2\2\u0177\u0176\3\2\2\2"+
		"\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017f"+
		"\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017e\5\62\32\2\u017d\u017c\3\2\2\2"+
		"\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0182"+
		"\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183\7\6\2\2\u0183\61\3\2\2\2\u0184"+
		"\u01bf\5\60\31\2\u0185\u01bf\7L\2\2\u0186\u0187\5Z.\2\u0187\u0188\7L\2"+
		"\2\u0188\u01bf\3\2\2\2\u0189\u018a\7\21\2\2\u018a\u018b\7H\2\2\u018b\u018c"+
		"\5V,\2\u018c\u018d\7L\2\2\u018d\u018e\5V,\2\u018e\u018f\7L\2\2\u018f\u0190"+
		"\5V,\2\u0190\u0191\7I\2\2\u0191\u0192\5\62\32\2\u0192\u01bf\3\2\2\2\u0193"+
		"\u0194\7\22\2\2\u0194\u0195\7H\2\2\u0195\u0196\5V,\2\u0196\u0197\7I\2"+
		"\2\u0197\u0198\5\62\32\2\u0198\u01bf\3\2\2\2\u0199\u019a\7\23\2\2\u019a"+
		"\u019b\5\62\32\2\u019b\u019c\7\22\2\2\u019c\u019d\7H\2\2\u019d\u019e\5"+
		"V,\2\u019e\u019f\7I\2\2\u019f\u01a0\7L\2\2\u01a0\u01bf\3\2\2\2\u01a1\u01a2"+
		"\7\24\2\2\u01a2\u01a3\7H\2\2\u01a3\u01a4\5V,\2\u01a4\u01a5\7I\2\2\u01a5"+
		"\u01a8\5\62\32\2\u01a6\u01a7\7\25\2\2\u01a7\u01a9\5\62\32\2\u01a8\u01a6"+
		"\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01bf\3\2\2\2\u01aa\u01ab\7\26\2\2"+
		"\u01ab\u01bf\7L\2\2\u01ac\u01ad\7\27\2\2\u01ad\u01ae\7H\2\2\u01ae\u01af"+
		"\5V,\2\u01af\u01b0\7I\2\2\u01b0\u01b2\7\5\2\2\u01b1\u01b3\5\64\33\2\u01b2"+
		"\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2"+
		"\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\7\6\2\2\u01b7\u01bf\3\2\2\2\u01b8"+
		"\u01b9\7\30\2\2\u01b9\u01bf\7L\2\2\u01ba\u01bb\7\30\2\2\u01bb\u01bc\5"+
		"Z.\2\u01bc\u01bd\7L\2\2\u01bd\u01bf\3\2\2\2\u01be\u0184\3\2\2\2\u01be"+
		"\u0185\3\2\2\2\u01be\u0186\3\2\2\2\u01be\u0189\3\2\2\2\u01be\u0193\3\2"+
		"\2\2\u01be\u0199\3\2\2\2\u01be\u01a1\3\2\2\2\u01be\u01aa\3\2\2\2\u01be"+
		"\u01ac\3\2\2\2\u01be\u01b8\3\2\2\2\u01be\u01ba\3\2\2\2\u01bf\63\3\2\2"+
		"\2\u01c0\u01c1\7\31\2\2\u01c1\u01c2\5Z.\2\u01c2\u01c6\7\32\2\2\u01c3\u01c5"+
		"\5\62\32\2\u01c4\u01c3\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2"+
		"\u01c6\u01c7\3\2\2\2\u01c7\u01d2\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01ca"+
		"\7\33\2\2\u01ca\u01ce\7\32\2\2\u01cb\u01cd\5\62\32\2\u01cc\u01cb\3\2\2"+
		"\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d2"+
		"\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01c0\3\2\2\2\u01d1\u01c9\3\2\2\2\u01d2"+
		"\65\3\2\2\2\u01d3\u01d4\7\34\2\2\u01d4\u01d5\58\35\2\u01d5\u01dc\b\34"+
		"\1\2\u01d6\u01d7\7S\2\2\u01d7\u01d8\58\35\2\u01d8\u01d9\b\34\1\2\u01d9"+
		"\u01db\3\2\2\2\u01da\u01d6\3\2\2\2\u01db\u01de\3\2\2\2\u01dc\u01da\3\2"+
		"\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01df\3\2\2\2\u01de\u01dc\3\2\2\2\u01df"+
		"\u01e0\7L\2\2\u01e0\67\3\2\2\2\u01e1\u01e2\7N\2\2\u01e2\u01eb\b\35\1\2"+
		"\u01e3\u01e4\7N\2\2\u01e4\u01e5\7\5\2\2\u01e5\u01e6\5:\36\2\u01e6\u01e7"+
		"\7\6\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\b\35\1\2\u01e9\u01eb\3\2\2\2"+
		"\u01ea\u01e1\3\2\2\2\u01ea\u01e3\3\2\2\2\u01eb9\3\2\2\2\u01ec\u01ed\7"+
		"N\2\2\u01ed\u01ee\t\2\2\2\u01ee\u01ef\5Z.\2\u01ef\u01f0\b\36\1\2\u01f0"+
		";\3\2\2\2\u01f1\u01f2\7\35\2\2\u01f2\u01f3\7N\2\2\u01f3\u01f4\7L\2\2\u01f4"+
		"\u01f5\b\37\1\2\u01f5=\3\2\2\2\u01f6\u01f7\7\36\2\2\u01f7\u01f8\5@!\2"+
		"\u01f8\u01fe\b \1\2\u01f9\u01fa\5@!\2\u01fa\u01fb\b \1\2\u01fb\u01fd\3"+
		"\2\2\2\u01fc\u01f9\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe"+
		"\u01ff\3\2\2\2\u01ff\u0201\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u0202\7L"+
		"\2\2\u0202?\3\2\2\2\u0203\u0204\7N\2\2\u0204\u0205\7\37\2\2\u0205\u0206"+
		"\7N\2\2\u0206\u0207\5B\"\2\u0207\u0210\b!\1\2\u0208\u0209\7S\2\2\u0209"+
		"\u020a\7\37\2\2\u020a\u020b\7N\2\2\u020b\u020c\5B\"\2\u020c\u020d\b!\1"+
		"\2\u020d\u020f\3\2\2\2\u020e\u0208\3\2\2\2\u020f\u0212\3\2\2\2\u0210\u020e"+
		"\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0226\3\2\2\2\u0212\u0210\3\2\2\2\u0213"+
		"\u0214\7S\2\2\u0214\u0215\7N\2\2\u0215\u0216\7\37\2\2\u0216\u0217\7N\2"+
		"\2\u0217\u0218\5B\"\2\u0218\u0221\b!\1\2\u0219\u021a\7S\2\2\u021a\u021b"+
		"\7\37\2\2\u021b\u021c\7N\2\2\u021c\u021d\5B\"\2\u021d\u021e\b!\1\2\u021e"+
		"\u0220\3\2\2\2\u021f\u0219\3\2\2\2\u0220\u0223\3\2\2\2\u0221\u021f\3\2"+
		"\2\2\u0221\u0222\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221\3\2\2\2\u0224"+
		"\u0213\3\2\2\2\u0225\u0228\3\2\2\2\u0226\u0224\3\2\2\2\u0226\u0227\3\2"+
		"\2\2\u0227A\3\2\2\2\u0228\u0226\3\2\2\2\u0229\u022d\7\5\2\2\u022a\u022b"+
		"\5D#\2\u022b\u022c\b\"\1\2\u022c\u022e\3\2\2\2\u022d\u022a\3\2\2\2\u022d"+
		"\u022e\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0230\b\"\1\2\u0230\u0231\5L"+
		"\'\2\u0231\u0232\b\"\1\2\u0232\u0236\3\2\2\2\u0233\u0234\5N(\2\u0234\u0235"+
		"\b\"\1\2\u0235\u0237\3\2\2\2\u0236\u0233\3\2\2\2\u0236\u0237\3\2\2\2\u0237"+
		"\u0238\3\2\2\2\u0238\u0239\7\6\2\2\u0239\u023a\b\"\1\2\u023aC\3\2\2\2"+
		"\u023b\u023c\7 \2\2\u023c\u023d\5F$\2\u023d\u023e\7L\2\2\u023e\u023f\b"+
		"#\1\2\u023fE\3\2\2\2\u0240\u0241\5H%\2\u0241\u024c\b$\1\2\u0242\u0246"+
		"\7S\2\2\u0243\u0246\3\2\2\2\u0244\u0246\7B\2\2\u0245\u0242\3\2\2\2\u0245"+
		"\u0243\3\2\2\2\u0245\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0248\5H"+
		"%\2\u0248\u0249\b$\1\2\u0249\u024b\3\2\2\2\u024a\u0245\3\2\2\2\u024b\u024e"+
		"\3\2\2\2\u024c\u024a\3\2\2\2\u024c\u024d\3\2\2\2\u024dG\3\2\2\2\u024e"+
		"\u024c\3\2\2\2\u024f\u0250\5J&\2\u0250\u0251\b%\1\2\u0251I\3\2\2\2\u0252"+
		"\u0253\7N\2\2\u0253\u0254\t\3\2\2\u0254\u0255\7O\2\2\u0255\u0256\b&\1"+
		"\2\u0256K\3\2\2\2\u0257\u0258\7!\2\2\u0258\u0259\7N\2\2\u0259\u025a\t"+
		"\4\2\2\u025a\u025b\7L\2\2\u025b\u025c\3\2\2\2\u025c\u0264\b\'\1\2\u025d"+
		"\u025e\7!\2\2\u025e\u025f\7N\2\2\u025f\u0260\7L\2\2\u0260\u0261\3\2\2"+
		"\2\u0261\u0264\b\'\1\2\u0262\u0264\b\'\1\2\u0263\u0257\3\2\2\2\u0263\u025d"+
		"\3\2\2\2\u0263\u0262\3\2\2\2\u0264M\3\2\2\2\u0265\u0266\7$\2\2\u0266\u0267"+
		"\5P)\2\u0267\u0268\7L\2\2\u0268\u0269\b(\1\2\u0269O\3\2\2\2\u026a\u026b"+
		"\5R*\2\u026b\u026c\b)\1\2\u026c\u0273\3\2\2\2\u026d\u026e\7S\2\2\u026e"+
		"\u026f\5R*\2\u026f\u0270\b)\1\2\u0270\u0272\3\2\2\2\u0271\u026d\3\2\2"+
		"\2\u0272\u0275\3\2\2\2\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274Q"+
		"\3\2\2\2\u0275\u0273\3\2\2\2\u0276\u0277\7N\2\2\u0277\u0278\t\5\2\2\u0278"+
		"\u0279\7O\2\2\u0279\u027a\3\2\2\2\u027a\u0282\b*\1\2\u027b\u027c\7N\2"+
		"\2\u027c\u027d\t\5\2\2\u027d\u027e\5X-\2\u027e\u027f\3\2\2\2\u027f\u0280"+
		"\b*\1\2\u0280\u0282\3\2\2\2\u0281\u0276\3\2\2\2\u0281\u027b\3\2\2\2\u0282"+
		"S\3\2\2\2\u0283\u0284\7N\2\2\u0284\u0285\7\60\2\2\u0285\u0286\7O\2\2\u0286"+
		"\u0287\3\2\2\2\u0287\u0288\b+\1\2\u0288U\3\2\2\2\u0289\u028a\5Z.\2\u028a"+
		"\u0291\b,\1\2\u028b\u028c\7S\2\2\u028c\u028d\5Z.\2\u028d\u028e\b,\1\2"+
		"\u028e\u0290\3\2\2\2\u028f\u028b\3\2\2\2\u0290\u0293\3\2\2\2\u0291\u028f"+
		"\3\2\2\2\u0291\u0292\3\2\2\2\u0292W\3\2\2\2\u0293\u0291\3\2\2\2\u0294"+
		"\u0295\5Z.\2\u0295\u0296\b-\1\2\u0296Y\3\2\2\2\u0297\u0298\b.\1\2\u0298"+
		"\u0299\t\6\2\2\u0299\u029a\5Z.\17\u029a\u029b\b.\1\2\u029b\u02a5\3\2\2"+
		"\2\u029c\u029d\t\7\2\2\u029d\u029e\5Z.\16\u029e\u029f\b.\1\2\u029f\u02a5"+
		"\3\2\2\2\u02a0\u02a1\7N\2\2\u02a1\u02a5\b.\1\2\u02a2\u02a3\7O\2\2\u02a3"+
		"\u02a5\b.\1\2\u02a4\u0297\3\2\2\2\u02a4\u029c\3\2\2\2\u02a4\u02a0\3\2"+
		"\2\2\u02a4\u02a2\3\2\2\2\u02a5\u02e4\3\2\2\2\u02a6\u02a7\f\r\2\2\u02a7"+
		"\u02a8\t\b\2\2\u02a8\u02a9\5Z.\16\u02a9\u02aa\b.\1\2\u02aa\u02e3\3\2\2"+
		"\2\u02ab\u02ac\f\f\2\2\u02ac\u02ad\t\t\2\2\u02ad\u02ae\5Z.\r\u02ae\u02af"+
		"\b.\1\2\u02af\u02e3\3\2\2\2\u02b0\u02b1\f\13\2\2\u02b1\u02b2\t\2\2\2\u02b2"+
		"\u02b3\5Z.\f\u02b3\u02b4\b.\1\2\u02b4\u02e3\3\2\2\2\u02b5\u02b6\f\n\2"+
		"\2\u02b6\u02b7\t\n\2\2\u02b7\u02b8\5Z.\13\u02b8\u02b9\b.\1\2\u02b9\u02e3"+
		"\3\2\2\2\u02ba\u02bb\f\t\2\2\u02bb\u02bc\7D\2\2\u02bc\u02bd\5Z.\n\u02bd"+
		"\u02be\b.\1\2\u02be\u02e3\3\2\2\2\u02bf\u02c0\f\b\2\2\u02c0\u02c1\7?\2"+
		"\2\u02c1\u02c2\5Z.\t\u02c2\u02c3\b.\1\2\u02c3\u02e3\3\2\2\2\u02c4\u02c5"+
		"\f\7\2\2\u02c5\u02c6\7G\2\2\u02c6\u02c7\5Z.\b\u02c7\u02c8\b.\1\2\u02c8"+
		"\u02e3\3\2\2\2\u02c9\u02ca\f\6\2\2\u02ca\u02cb\7B\2\2\u02cb\u02cc\5Z."+
		"\7\u02cc\u02cd\b.\1\2\u02cd\u02e3\3\2\2\2\u02ce\u02cf\f\5\2\2\u02cf\u02d0"+
		"\7C\2\2\u02d0\u02d1\5Z.\6\u02d1\u02d2\b.\1\2\u02d2\u02e3\3\2\2\2\u02d3"+
		"\u02d4\f\4\2\2\u02d4\u02d5\7#\2\2\u02d5\u02d6\5Z.\2\u02d6\u02d7\7\32\2"+
		"\2\u02d7\u02d8\5Z.\5\u02d8\u02d9\b.\1\2\u02d9\u02e3\3\2\2\2\u02da\u02db"+
		"\f\3\2\2\u02db\u02dc\t\13\2\2\u02dc\u02dd\5Z.\4\u02dd\u02de\b.\1\2\u02de"+
		"\u02e3\3\2\2\2\u02df\u02e0\f\20\2\2\u02e0\u02e1\t\f\2\2\u02e1\u02e3\b"+
		".\1\2\u02e2\u02a6\3\2\2\2\u02e2\u02ab\3\2\2\2\u02e2\u02b0\3\2\2\2\u02e2"+
		"\u02b5\3\2\2\2\u02e2\u02ba\3\2\2\2\u02e2\u02bf\3\2\2\2\u02e2\u02c4\3\2"+
		"\2\2\u02e2\u02c9\3\2\2\2\u02e2\u02ce\3\2\2\2\u02e2\u02d3\3\2\2\2\u02e2"+
		"\u02da\3\2\2\2\u02e2\u02df\3\2\2\2\u02e3\u02e6\3\2\2\2\u02e4\u02e2\3\2"+
		"\2\2\u02e4\u02e5\3\2\2\2\u02e5[\3\2\2\2\u02e6\u02e4\3\2\2\2\u02e7\u02e8"+
		"\7N\2\2\u02e8\u02e9\7\60\2\2\u02e9\u02ea\5Z.\2\u02ea\u02eb\3\2\2\2\u02eb"+
		"\u02ec\b/\1\2\u02ec\u02f4\3\2\2\2\u02ed\u02ee\7N\2\2\u02ee\u02ef\7:\2"+
		"\2\u02ef\u02f0\5Z.\2\u02f0\u02f1\3\2\2\2\u02f1\u02f2\b/\1\2\u02f2\u02f4"+
		"\3\2\2\2\u02f3\u02e7\3\2\2\2\u02f3\u02ed\3\2\2\2\u02f4]\3\2\2\2\u02f5"+
		"\u02fa\5Z.\2\u02f6\u02f7\7S\2\2\u02f7\u02f9\5^\60\2\u02f8\u02f6\3\2\2"+
		"\2\u02f9\u02fc\3\2\2\2\u02fa\u02f8\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u02fd"+
		"\3\2\2\2\u02fc\u02fa\3\2\2\2\u02fd\u02fe\b\60\1\2\u02fe\u0301\3\2\2\2"+
		"\u02ff\u0301\3\2\2\2\u0300\u02f5\3\2\2\2\u0300\u02ff\3\2\2\2\u0301_\3"+
		"\2\2\2@ekq\u0081\u0091\u009c\u00a1\u00a5\u00ab\u00bd\u00bf\u00c4\u00c7"+
		"\u00cc\u00d4\u00e0\u00e9\u00f1\u00fc\u0107\u0110\u0118\u0125\u0127\u012d"+
		"\u0131\u0134\u0137\u0139\u014e\u0158\u0161\u016a\u0177\u0179\u017f\u01a8"+
		"\u01b4\u01be\u01c6\u01ce\u01d1\u01dc\u01ea\u01fe\u0210\u0221\u0226\u022d"+
		"\u0236\u0245\u024c\u0263\u0273\u0281\u0291\u02a4\u02e2\u02e4\u02f3\u02fa"+
		"\u0300";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}