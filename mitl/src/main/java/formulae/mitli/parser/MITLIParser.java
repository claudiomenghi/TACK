// Generated from MITLI.g4 by ANTLR 4.5

package formulae.mitli.parser;

import java.util.HashMap;
import formulae.*;
import formulae.mitli.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Collections;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MITLIParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, LPAR=4, RPAR=5, LBRA=6, RBRA=7, TRUE=8, FALSE=9, 
		NEG_OP=10, AND_OP=11, OR_OP=12, IMPL_OP=13, IFF_OP=14, F_OP=15, F_inf_OP=16, 
		G_OP=17, G_inf_OP=18, P_OP=19, H_OP=20, UNTIL_OP=21, SINCE_OP=22, RELEASE_OP=23, 
		TRIGGER_OP=24, COUNT_OP=25, LOGIC=26, COLON=27, SEMI=28, INT=29, ID=30, 
		NEWLINE=31, WS=32, COMMENT=33;
	public static final int
		RULE_mitli = 0, RULE_logic = 1, RULE_declaration = 2, RULE_fmla = 3, RULE_conjuncts_list = 4;
	public static final String[] ruleNames = {
		"mitli", "logic", "declaration", "fmla", "conjuncts_list"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':bound'", "':formula'", "':def'", "'('", "')'", "'['", "']'", 
		"'true'", "'false'", "'!!'", "'&&'", "'||'", "'->'", "'<->'", null, null, 
		null, null, null, null, "'U'", "'S'", "'R'", "'T'", "'C'", null, "':'", 
		"';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "LPAR", "RPAR", "LBRA", "RBRA", "TRUE", "FALSE", 
		"NEG_OP", "AND_OP", "OR_OP", "IMPL_OP", "IFF_OP", "F_OP", "F_inf_OP", 
		"G_OP", "G_inf_OP", "P_OP", "H_OP", "UNTIL_OP", "SINCE_OP", "RELEASE_OP", 
		"TRIGGER_OP", "COUNT_OP", "LOGIC", "COLON", "SEMI", "INT", "ID", "NEWLINE", 
		"WS", "COMMENT"
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
	public String getGrammarFileName() { return "MITLI.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MITLIParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MitliContext extends ParserRuleContext {
		public LogicContext l;
		public List<TerminalNode> NEWLINE() { return getTokens(MITLIParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MITLIParser.NEWLINE, i);
		}
		public TerminalNode INT() { return getToken(MITLIParser.INT, 0); }
		public FmlaContext fmla() {
			return getRuleContext(FmlaContext.class,0);
		}
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public MitliContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mitli; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).enterMitli(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).exitMitli(this);
		}
	}

	public final MitliContext mitli() throws RecognitionException {
		MitliContext _localctx = new MitliContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mitli);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			((MitliContext)_localctx).l = logic();
			setState(11);
			match(NEWLINE);
			 
					 	
			setState(13);
			match(T__0);
			setState(14);
			match(INT);
			setState(15);
			match(NEWLINE);

							System.out.println("Starting parsing formulae...");
						
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==NEWLINE) {
				{
				{
				setState(17);
				declaration();
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(23);
			match(T__1);
			setState(24);
			fmla();
							
						
								
						
			setState(26);
			match(NEWLINE);
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

	public static class LogicContext extends ParserRuleContext {
		public String s;
		public Token LOGIC;
		public TerminalNode COLON() { return getToken(MITLIParser.COLON, 0); }
		public TerminalNode LOGIC() { return getToken(MITLIParser.LOGIC, 0); }
		public LogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).enterLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).exitLogic(this);
		}
	}

	public final LogicContext logic() throws RecognitionException {
		LogicContext _localctx = new LogicContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_logic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(COLON);
			setState(29);
			((LogicContext)_localctx).LOGIC = match(LOGIC);
			 ((LogicContext)_localctx).s =  new String((((LogicContext)_localctx).LOGIC!=null?((LogicContext)_localctx).LOGIC.getText():null)); 
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
		public Token s;
		public FmlaContext fmla() {
			return getRuleContext(FmlaContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(MITLIParser.NEWLINE, 0); }
		public TerminalNode ID() { return getToken(MITLIParser.ID, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(39);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				match(T__2);
				setState(33);
				((DeclarationContext)_localctx).s = match(ID);
				setState(34);
				fmla();

							
							 
				setState(36);
				match(NEWLINE);
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(NEWLINE);
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

	public static class FmlaContext extends ParserRuleContext {
		public Formula r;
		public FmlaContext fmla;
		public Token ID;
		public FmlaContext f1;
		public Conjuncts_listContext conjuncts_list;
		public FmlaContext f2;
		public Token F_OP;
		public Token a;
		public Token b;
		public Token F_inf_OP;
		public Token G_OP;
		public Token G_inf_OP;
		public Token P_OP;
		public Token H_OP;
		public TerminalNode LPAR() { return getToken(MITLIParser.LPAR, 0); }
		public List<FmlaContext> fmla() {
			return getRuleContexts(FmlaContext.class);
		}
		public FmlaContext fmla(int i) {
			return getRuleContext(FmlaContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(MITLIParser.RPAR, 0); }
		public TerminalNode TRUE() { return getToken(MITLIParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MITLIParser.FALSE, 0); }
		public TerminalNode ID() { return getToken(MITLIParser.ID, 0); }
		public TerminalNode NEG_OP() { return getToken(MITLIParser.NEG_OP, 0); }
		public TerminalNode AND_OP() { return getToken(MITLIParser.AND_OP, 0); }
		public Conjuncts_listContext conjuncts_list() {
			return getRuleContext(Conjuncts_listContext.class,0);
		}
		public TerminalNode OR_OP() { return getToken(MITLIParser.OR_OP, 0); }
		public TerminalNode IMPL_OP() { return getToken(MITLIParser.IMPL_OP, 0); }
		public TerminalNode IFF_OP() { return getToken(MITLIParser.IFF_OP, 0); }
		public TerminalNode F_OP() { return getToken(MITLIParser.F_OP, 0); }
		public List<TerminalNode> INT() { return getTokens(MITLIParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(MITLIParser.INT, i);
		}
		public TerminalNode F_inf_OP() { return getToken(MITLIParser.F_inf_OP, 0); }
		public TerminalNode G_OP() { return getToken(MITLIParser.G_OP, 0); }
		public TerminalNode G_inf_OP() { return getToken(MITLIParser.G_inf_OP, 0); }
		public TerminalNode P_OP() { return getToken(MITLIParser.P_OP, 0); }
		public TerminalNode H_OP() { return getToken(MITLIParser.H_OP, 0); }
		public TerminalNode UNTIL_OP() { return getToken(MITLIParser.UNTIL_OP, 0); }
		public TerminalNode SINCE_OP() { return getToken(MITLIParser.SINCE_OP, 0); }
		public TerminalNode RELEASE_OP() { return getToken(MITLIParser.RELEASE_OP, 0); }
		public FmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fmla; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).enterFmla(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).exitFmla(this);
		}
	}

	public final FmlaContext fmla() throws RecognitionException {
		FmlaContext _localctx = new FmlaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fmla);
		try {
			setState(151);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(LPAR);
				setState(42);
				((FmlaContext)_localctx).fmla = fmla();

						((FmlaContext)_localctx).r = _localctx.r;
					
				setState(44);
				match(RPAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				match(TRUE);

							Formula f = new MITLITrue();
								
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				match(FALSE);

							Formula f = new MITLIFalse();
								
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				((FmlaContext)_localctx).ID = match(ID);
					
							
								Formula f = new MITLIAtom((((FmlaContext)_localctx).ID!=null?((FmlaContext)_localctx).ID.getText():null));
								
								((FmlaContext)_localctx).r =  f;
							
						
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(52);
				match(LPAR);
				setState(53);
				match(NEG_OP);
				setState(54);
				((FmlaContext)_localctx).f1 = fmla();
				setState(55);
				match(RPAR);
					
							Formula f = new MITLINegation((MITLIFormula) ((FmlaContext)_localctx).f1.r);
								
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(58);
				match(LPAR);
				setState(59);
				match(AND_OP);
				setState(60);
				((FmlaContext)_localctx).conjuncts_list = conjuncts_list();
				setState(61);
				match(RPAR);
					
							Formula f = null;
							Formula[] arr = null;
							
							
								arr = new MITLIFormula[((FmlaContext)_localctx).conjuncts_list.l.size()];

								int i = 0;
								for (Formula fm: ((FmlaContext)_localctx).conjuncts_list.l)
									arr[i++] = fm;
							
								f = MITLIFormula.and((MITLIFormula[]) arr);
							
									
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(64);
				match(LPAR);
				setState(65);
				match(OR_OP);
				setState(66);
				((FmlaContext)_localctx).conjuncts_list = conjuncts_list();
				setState(67);
				match(RPAR);
					
							Formula f = null;
							Formula[] arr = null;
							
								arr = new MITLIFormula[((FmlaContext)_localctx).conjuncts_list.l.size()];

								int i = 0;
								for (Formula fm: ((FmlaContext)_localctx).conjuncts_list.l)
									arr[i++] = fm;
							
								f = MITLIFormula.or((MITLIFormula[]) arr);
							
								
							((FmlaContext)_localctx).r =  f;	
						
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(70);
				match(LPAR);
				setState(71);
				match(IMPL_OP);
				setState(72);
				((FmlaContext)_localctx).f1 = fmla();
				setState(73);
				((FmlaContext)_localctx).f2 = fmla();
				setState(74);
				match(RPAR);
					
							Formula f = MITLIFormula.implies((MITLIFormula)((FmlaContext)_localctx).f1.r,(MITLIFormula)((FmlaContext)_localctx).f2.r);	
								
							((FmlaContext)_localctx).r =  f;	
						
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(77);
				match(LPAR);
				setState(78);
				match(IFF_OP);
				setState(79);
				((FmlaContext)_localctx).f1 = fmla();
				setState(80);
				((FmlaContext)_localctx).f2 = fmla();
				setState(81);
				match(RPAR);
					
							Formula f = MITLIFormula.iff((MITLIFormula)((FmlaContext)_localctx).f1.r,(MITLIFormula)((FmlaContext)_localctx).f2.r);
								
							((FmlaContext)_localctx).r =  f;		
						
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(84);
				match(LPAR);
				setState(85);
				((FmlaContext)_localctx).F_OP = match(F_OP);
				setState(86);
				((FmlaContext)_localctx).a = match(INT);
				setState(87);
				((FmlaContext)_localctx).b = match(INT);
				setState(88);
				((FmlaContext)_localctx).f1 = fmla();
				setState(89);
				match(RPAR);
					
							Formula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).F_OP!=null?((FmlaContext)_localctx).F_OP.getText():null));
							
								if (s.compareTo("F_ei") == 0 || s.compareTo("F_ii") == 0)
									f = MITLIFormula.F((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null)));  
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(92);
				match(LPAR);
				setState(93);
				((FmlaContext)_localctx).F_inf_OP = match(F_inf_OP);
				setState(94);
				((FmlaContext)_localctx).a = match(INT);
				setState(95);
				((FmlaContext)_localctx).f1 = fmla();
				setState(96);
				match(RPAR);
					
							Formula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).F_inf_OP!=null?((FmlaContext)_localctx).F_inf_OP.getText():null));
							
							
								if (s.compareTo("F_e+") == 0 || s.compareTo("F_i+") == 0)
									f = MITLIFormula.F_inf((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)));  
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(99);
				match(LPAR);
				setState(100);
				((FmlaContext)_localctx).G_OP = match(G_OP);
				setState(101);
				((FmlaContext)_localctx).a = match(INT);
				setState(102);
				((FmlaContext)_localctx).b = match(INT);
				setState(103);
				((FmlaContext)_localctx).f1 = fmla();
				setState(104);
				match(RPAR);
					
							Formula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).G_OP!=null?((FmlaContext)_localctx).G_OP.getText():null));
							
							
								if (s.compareTo("G_ei") == 0 || s.compareTo("G_ii") == 0)
									f = MITLIFormula.G((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null))); 
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(107);
				match(LPAR);
				setState(108);
				((FmlaContext)_localctx).G_inf_OP = match(G_inf_OP);
				setState(109);
				((FmlaContext)_localctx).a = match(INT);
				setState(110);
				((FmlaContext)_localctx).f1 = fmla();
				setState(111);
				match(RPAR);
					
							Formula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).G_inf_OP!=null?((FmlaContext)_localctx).G_inf_OP.getText():null));
							
							if (s.compareTo("G_e+") == 0 || s.compareTo("G_i+") == 0)
									f = MITLIFormula.G_inf((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null))); 
							
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(114);
				match(LPAR);
				setState(115);
				((FmlaContext)_localctx).P_OP = match(P_OP);
				setState(116);
				((FmlaContext)_localctx).a = match(INT);
				setState(117);
				((FmlaContext)_localctx).b = match(INT);
				setState(118);
				((FmlaContext)_localctx).f1 = fmla();
				setState(119);
				match(RPAR);
					
							Formula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).P_OP!=null?((FmlaContext)_localctx).P_OP.getText():null));
							
							
							if (s.compareTo("P_ie") == 0 || s.compareTo("P_ii") == 0)
									f = MITLIFormula.P((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null))); 
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(122);
				match(LPAR);
				setState(123);
				((FmlaContext)_localctx).H_OP = match(H_OP);
				setState(124);
				((FmlaContext)_localctx).a = match(INT);
				setState(125);
				((FmlaContext)_localctx).b = match(INT);
				setState(126);
				((FmlaContext)_localctx).f1 = fmla();
				setState(127);
				match(RPAR);
					
							Formula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).H_OP!=null?((FmlaContext)_localctx).H_OP.getText():null));
								if (s.compareTo("H_ei") == 0 || s.compareTo("H_ii") == 0)
									f = MITLIFormula.H((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null))); 
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(130);
				match(LPAR);
				setState(131);
				match(UNTIL_OP);
				setState(132);
				((FmlaContext)_localctx).f1 = fmla();
				setState(133);
				((FmlaContext)_localctx).f2 = fmla();
				setState(134);
				match(RPAR);

							Formula f = null;
								f = MITLIFormula.U((MITLIFormula)((FmlaContext)_localctx).f1.r,(MITLIFormula)((FmlaContext)_localctx).f2.r);
								
								
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(137);
				match(LPAR);
				setState(138);
				match(SINCE_OP);
				setState(139);
				((FmlaContext)_localctx).f1 = fmla();
				setState(140);
				((FmlaContext)_localctx).f2 = fmla();
				setState(141);
				match(RPAR);

							Formula f = null;
								f = MITLIFormula.S((MITLIFormula)((FmlaContext)_localctx).f1.r,(MITLIFormula)((FmlaContext)_localctx).f2.r);
							 	
							((FmlaContext)_localctx).r =  f; 	
						
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(144);
				match(LPAR);
				setState(145);
				match(RELEASE_OP);
				setState(146);
				((FmlaContext)_localctx).f1 = fmla();
				setState(147);
				((FmlaContext)_localctx).f2 = fmla();
				setState(148);
				match(RPAR);

							Formula f = null;
							 	f = MITLIFormula.R((MITLIFormula)((FmlaContext)_localctx).f1.r,(MITLIFormula)((FmlaContext)_localctx).f2.r);
							 	
							((FmlaContext)_localctx).r =  f;
						
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

	public static class Conjuncts_listContext extends ParserRuleContext {
		public List<Formula> l;
		public FmlaContext fmla;
		public Conjuncts_listContext conjuncts_list;
		public FmlaContext fmla() {
			return getRuleContext(FmlaContext.class,0);
		}
		public Conjuncts_listContext conjuncts_list() {
			return getRuleContext(Conjuncts_listContext.class,0);
		}
		public Conjuncts_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjuncts_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).enterConjuncts_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).exitConjuncts_list(this);
		}
	}

	public final Conjuncts_listContext conjuncts_list() throws RecognitionException {
		Conjuncts_listContext _localctx = new Conjuncts_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_conjuncts_list);
		((Conjuncts_listContext)_localctx).l =  new ArrayList<Formula>();
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			((Conjuncts_listContext)_localctx).fmla = fmla();
			setState(156);
			switch (_input.LA(1)) {
			case LPAR:
			case TRUE:
			case FALSE:
			case ID:
				{
				setState(154);
				((Conjuncts_listContext)_localctx).conjuncts_list = conjuncts_list();
				}
				break;
			case RPAR:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

						if (_localctx.l == null)
							_localctx.l.add(((Conjuncts_listContext)_localctx).fmla.r);
						else{
							(_localctx.l).add(((Conjuncts_listContext)_localctx).fmla.r);
							_localctx.l.addAll(_localctx.l);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3#\u00a3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\25"+
		"\n\2\f\2\16\2\30\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\5\4*\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u009a\n\5\3\6\3\6\3"+
		"\6\5\6\u009f\n\6\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\2\u00b1\2\f\3\2\2\2\4\36"+
		"\3\2\2\2\6)\3\2\2\2\b\u0099\3\2\2\2\n\u009b\3\2\2\2\f\r\5\4\3\2\r\16\7"+
		"!\2\2\16\17\b\2\1\2\17\20\7\3\2\2\20\21\7\37\2\2\21\22\7!\2\2\22\26\b"+
		"\2\1\2\23\25\5\6\4\2\24\23\3\2\2\2\25\30\3\2\2\2\26\24\3\2\2\2\26\27\3"+
		"\2\2\2\27\31\3\2\2\2\30\26\3\2\2\2\31\32\7\4\2\2\32\33\5\b\5\2\33\34\b"+
		"\2\1\2\34\35\7!\2\2\35\3\3\2\2\2\36\37\7\35\2\2\37 \7\34\2\2 !\b\3\1\2"+
		"!\5\3\2\2\2\"#\7\5\2\2#$\7 \2\2$%\5\b\5\2%&\b\4\1\2&\'\7!\2\2\'*\3\2\2"+
		"\2(*\7!\2\2)\"\3\2\2\2)(\3\2\2\2*\7\3\2\2\2+,\7\6\2\2,-\5\b\5\2-.\b\5"+
		"\1\2./\7\7\2\2/\u009a\3\2\2\2\60\61\7\n\2\2\61\u009a\b\5\1\2\62\63\7\13"+
		"\2\2\63\u009a\b\5\1\2\64\65\7 \2\2\65\u009a\b\5\1\2\66\67\7\6\2\2\678"+
		"\7\f\2\289\5\b\5\29:\7\7\2\2:;\b\5\1\2;\u009a\3\2\2\2<=\7\6\2\2=>\7\r"+
		"\2\2>?\5\n\6\2?@\7\7\2\2@A\b\5\1\2A\u009a\3\2\2\2BC\7\6\2\2CD\7\16\2\2"+
		"DE\5\n\6\2EF\7\7\2\2FG\b\5\1\2G\u009a\3\2\2\2HI\7\6\2\2IJ\7\17\2\2JK\5"+
		"\b\5\2KL\5\b\5\2LM\7\7\2\2MN\b\5\1\2N\u009a\3\2\2\2OP\7\6\2\2PQ\7\20\2"+
		"\2QR\5\b\5\2RS\5\b\5\2ST\7\7\2\2TU\b\5\1\2U\u009a\3\2\2\2VW\7\6\2\2WX"+
		"\7\21\2\2XY\7\37\2\2YZ\7\37\2\2Z[\5\b\5\2[\\\7\7\2\2\\]\b\5\1\2]\u009a"+
		"\3\2\2\2^_\7\6\2\2_`\7\22\2\2`a\7\37\2\2ab\5\b\5\2bc\7\7\2\2cd\b\5\1\2"+
		"d\u009a\3\2\2\2ef\7\6\2\2fg\7\23\2\2gh\7\37\2\2hi\7\37\2\2ij\5\b\5\2j"+
		"k\7\7\2\2kl\b\5\1\2l\u009a\3\2\2\2mn\7\6\2\2no\7\24\2\2op\7\37\2\2pq\5"+
		"\b\5\2qr\7\7\2\2rs\b\5\1\2s\u009a\3\2\2\2tu\7\6\2\2uv\7\25\2\2vw\7\37"+
		"\2\2wx\7\37\2\2xy\5\b\5\2yz\7\7\2\2z{\b\5\1\2{\u009a\3\2\2\2|}\7\6\2\2"+
		"}~\7\26\2\2~\177\7\37\2\2\177\u0080\7\37\2\2\u0080\u0081\5\b\5\2\u0081"+
		"\u0082\7\7\2\2\u0082\u0083\b\5\1\2\u0083\u009a\3\2\2\2\u0084\u0085\7\6"+
		"\2\2\u0085\u0086\7\27\2\2\u0086\u0087\5\b\5\2\u0087\u0088\5\b\5\2\u0088"+
		"\u0089\7\7\2\2\u0089\u008a\b\5\1\2\u008a\u009a\3\2\2\2\u008b\u008c\7\6"+
		"\2\2\u008c\u008d\7\30\2\2\u008d\u008e\5\b\5\2\u008e\u008f\5\b\5\2\u008f"+
		"\u0090\7\7\2\2\u0090\u0091\b\5\1\2\u0091\u009a\3\2\2\2\u0092\u0093\7\6"+
		"\2\2\u0093\u0094\7\31\2\2\u0094\u0095\5\b\5\2\u0095\u0096\5\b\5\2\u0096"+
		"\u0097\7\7\2\2\u0097\u0098\b\5\1\2\u0098\u009a\3\2\2\2\u0099+\3\2\2\2"+
		"\u0099\60\3\2\2\2\u0099\62\3\2\2\2\u0099\64\3\2\2\2\u0099\66\3\2\2\2\u0099"+
		"<\3\2\2\2\u0099B\3\2\2\2\u0099H\3\2\2\2\u0099O\3\2\2\2\u0099V\3\2\2\2"+
		"\u0099^\3\2\2\2\u0099e\3\2\2\2\u0099m\3\2\2\2\u0099t\3\2\2\2\u0099|\3"+
		"\2\2\2\u0099\u0084\3\2\2\2\u0099\u008b\3\2\2\2\u0099\u0092\3\2\2\2\u009a"+
		"\t\3\2\2\2\u009b\u009e\5\b\5\2\u009c\u009f\5\n\6\2\u009d\u009f\3\2\2\2"+
		"\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1"+
		"\b\6\1\2\u00a1\13\3\2\2\2\6\26)\u0099\u009e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}