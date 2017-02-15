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
		T__0=1, LPAR=2, RPAR=3, LBRA=4, RBRA=5, TRUE=6, FALSE=7, NEG_OP=8, AND_OP=9, 
		OR_OP=10, IMPL_OP=11, IFF_OP=12, F_OP=13, F_inf_OP=14, G_OP=15, G_inf_OP=16, 
		P_OP=17, H_OP=18, UNTIL_OP=19, SINCE_OP=20, RELEASE_OP=21, TRIGGER_OP=22, 
		COUNT_OP=23, LOGIC=24, COLON=25, SEMI=26, INT=27, ID=28, NEWLINE=29, WS=30, 
		COMMENT=31;
	public static final int
		RULE_mitli = 0, RULE_logic = 1, RULE_declaration = 2, RULE_fmla = 3, RULE_conjuncts_list = 4;
	public static final String[] ruleNames = {
		"mitli", "logic", "declaration", "fmla", "conjuncts_list"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':def'", "'('", "')'", "'['", "']'", "'true'", "'false'", "'!!'", 
		"'&&'", "'||'", "'->'", "'<->'", null, null, null, null, null, null, "'U'", 
		"'S'", "'R'", "'T'", "'C'", null, "':'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "LPAR", "RPAR", "LBRA", "RBRA", "TRUE", "FALSE", "NEG_OP", 
		"AND_OP", "OR_OP", "IMPL_OP", "IFF_OP", "F_OP", "F_inf_OP", "G_OP", "G_inf_OP", 
		"P_OP", "H_OP", "UNTIL_OP", "SINCE_OP", "RELEASE_OP", "TRIGGER_OP", "COUNT_OP", 
		"LOGIC", "COLON", "SEMI", "INT", "ID", "NEWLINE", "WS", "COMMENT"
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
		public MITLIFormula formula;
		public FmlaContext fmla;
		public FmlaContext fmla() {
			return getRuleContext(FmlaContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			((MitliContext)_localctx).fmla = fmla();

						 	((MitliContext)_localctx).formula = ((MitliContext)_localctx).fmla.r;
						 
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
			setState(13);
			match(COLON);
			setState(14);
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
			setState(24);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				match(T__0);
				setState(18);
				((DeclarationContext)_localctx).s = match(ID);
				setState(19);
				fmla();

							
							 
				setState(21);
				match(NEWLINE);
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
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
		public MITLIFormula r;
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
			setState(136);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				match(LPAR);
				setState(27);
				((FmlaContext)_localctx).fmla = fmla();

						((FmlaContext)_localctx).r = _localctx.r;
					
				setState(29);
				match(RPAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(TRUE);

							MITLIFormula f = new MITLITrue();
								
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				match(FALSE);

							MITLIFormula f = new MITLIFalse();
								
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				((FmlaContext)_localctx).ID = match(ID);
					
							
								MITLIFormula f = new MITLIAtom((((FmlaContext)_localctx).ID!=null?((FmlaContext)_localctx).ID.getText():null));
								
								((FmlaContext)_localctx).r =  f;
							
						
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(37);
				match(LPAR);
				setState(38);
				match(NEG_OP);
				setState(39);
				((FmlaContext)_localctx).f1 = fmla();
				setState(40);
				match(RPAR);
					
							MITLIFormula f = new MITLINegation((MITLIFormula) ((FmlaContext)_localctx).f1.r);
								
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(43);
				match(LPAR);
				setState(44);
				match(AND_OP);
				setState(45);
				((FmlaContext)_localctx).conjuncts_list = conjuncts_list();
				setState(46);
				match(RPAR);
					
							MITLIFormula f = null;
							MITLIFormula[] arr = null;
							
							
								arr = new MITLIFormula[((FmlaContext)_localctx).conjuncts_list.l.size()];

								int i = 0;
								for (MITLIFormula fm: ((FmlaContext)_localctx).conjuncts_list.l)
									arr[i++] = fm;
							
								f = MITLIFormula.and((MITLIFormula[]) arr);
							
									
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(49);
				match(LPAR);
				setState(50);
				match(OR_OP);
				setState(51);
				((FmlaContext)_localctx).conjuncts_list = conjuncts_list();
				setState(52);
				match(RPAR);
					
							MITLIFormula f = null;
							MITLIFormula[] arr = null;
							
								arr = new MITLIFormula[((FmlaContext)_localctx).conjuncts_list.l.size()];

								int i = 0;
								for (MITLIFormula fm: ((FmlaContext)_localctx).conjuncts_list.l)
									arr[i++] = fm;
							
								f = MITLIFormula.or((MITLIFormula[]) arr);
							
								
							((FmlaContext)_localctx).r =  f;	
						
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(55);
				match(LPAR);
				setState(56);
				match(IMPL_OP);
				setState(57);
				((FmlaContext)_localctx).f1 = fmla();
				setState(58);
				((FmlaContext)_localctx).f2 = fmla();
				setState(59);
				match(RPAR);
					
							MITLIFormula f = MITLIFormula.implies(((FmlaContext)_localctx).f1.r,((FmlaContext)_localctx).f2.r);	
								
							((FmlaContext)_localctx).r =  f;	
						
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(62);
				match(LPAR);
				setState(63);
				match(IFF_OP);
				setState(64);
				((FmlaContext)_localctx).f1 = fmla();
				setState(65);
				((FmlaContext)_localctx).f2 = fmla();
				setState(66);
				match(RPAR);
					
							MITLIFormula f = MITLIFormula.iff((MITLIFormula)((FmlaContext)_localctx).f1.r,(MITLIFormula)((FmlaContext)_localctx).f2.r);
								
							((FmlaContext)_localctx).r =  f;		
						
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(69);
				match(LPAR);
				setState(70);
				((FmlaContext)_localctx).F_OP = match(F_OP);
				setState(71);
				((FmlaContext)_localctx).a = match(INT);
				setState(72);
				((FmlaContext)_localctx).b = match(INT);
				setState(73);
				((FmlaContext)_localctx).f1 = fmla();
				setState(74);
				match(RPAR);
					
							MITLIFormula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).F_OP!=null?((FmlaContext)_localctx).F_OP.getText():null));
							
								if (s.compareTo("F_ei") == 0 || s.compareTo("F_ii") == 0)
									f = MITLIFormula.F((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null)));  
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(77);
				match(LPAR);
				setState(78);
				((FmlaContext)_localctx).F_inf_OP = match(F_inf_OP);
				setState(79);
				((FmlaContext)_localctx).a = match(INT);
				setState(80);
				((FmlaContext)_localctx).f1 = fmla();
				setState(81);
				match(RPAR);
					
							MITLIFormula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).F_inf_OP!=null?((FmlaContext)_localctx).F_inf_OP.getText():null));
							
							
								if (s.compareTo("F_e+") == 0 || s.compareTo("F_i+") == 0)
									f = MITLIFormula.F_inf((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)));  
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(84);
				match(LPAR);
				setState(85);
				((FmlaContext)_localctx).G_OP = match(G_OP);
				setState(86);
				((FmlaContext)_localctx).a = match(INT);
				setState(87);
				((FmlaContext)_localctx).b = match(INT);
				setState(88);
				((FmlaContext)_localctx).f1 = fmla();
				setState(89);
				match(RPAR);
					
							MITLIFormula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).G_OP!=null?((FmlaContext)_localctx).G_OP.getText():null));
							
							
								if (s.compareTo("G_ei") == 0 || s.compareTo("G_ii") == 0){
									f = MITLIFormula.G((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null))); 
								}
								
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(92);
				match(LPAR);
				setState(93);
				((FmlaContext)_localctx).G_inf_OP = match(G_inf_OP);
				setState(94);
				((FmlaContext)_localctx).a = match(INT);
				setState(95);
				((FmlaContext)_localctx).f1 = fmla();
				setState(96);
				match(RPAR);
					
							MITLIFormula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).G_inf_OP!=null?((FmlaContext)_localctx).G_inf_OP.getText():null));
							
							if (s.compareTo("G_e+") == 0 || s.compareTo("G_i+") == 0)
									f = MITLIFormula.G_inf((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null))); 
							
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(99);
				match(LPAR);
				setState(100);
				((FmlaContext)_localctx).P_OP = match(P_OP);
				setState(101);
				((FmlaContext)_localctx).a = match(INT);
				setState(102);
				((FmlaContext)_localctx).b = match(INT);
				setState(103);
				((FmlaContext)_localctx).f1 = fmla();
				setState(104);
				match(RPAR);
					
							MITLIFormula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).P_OP!=null?((FmlaContext)_localctx).P_OP.getText():null));
							
							
							if (s.compareTo("P_ie") == 0 || s.compareTo("P_ii") == 0)
									f = MITLIFormula.P((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null))); 
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(107);
				match(LPAR);
				setState(108);
				((FmlaContext)_localctx).H_OP = match(H_OP);
				setState(109);
				((FmlaContext)_localctx).a = match(INT);
				setState(110);
				((FmlaContext)_localctx).b = match(INT);
				setState(111);
				((FmlaContext)_localctx).f1 = fmla();
				setState(112);
				match(RPAR);
					
							MITLIFormula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).H_OP!=null?((FmlaContext)_localctx).H_OP.getText():null));
								if (s.compareTo("H_ei") == 0 || s.compareTo("H_ii") == 0)
									f = MITLIFormula.H((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null))); 
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(115);
				match(LPAR);
				setState(116);
				match(UNTIL_OP);
				setState(117);
				((FmlaContext)_localctx).f1 = fmla();
				setState(118);
				((FmlaContext)_localctx).f2 = fmla();
				setState(119);
				match(RPAR);

							MITLIFormula f = null;
								f = MITLIFormula.U((MITLIFormula)((FmlaContext)_localctx).f1.r,(MITLIFormula)((FmlaContext)_localctx).f2.r);
								
								
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(122);
				match(LPAR);
				setState(123);
				match(SINCE_OP);
				setState(124);
				((FmlaContext)_localctx).f1 = fmla();
				setState(125);
				((FmlaContext)_localctx).f2 = fmla();
				setState(126);
				match(RPAR);

							MITLIFormula f = null;
								f = MITLIFormula.S((MITLIFormula)((FmlaContext)_localctx).f1.r,(MITLIFormula)((FmlaContext)_localctx).f2.r);
							 	
							((FmlaContext)_localctx).r =  f; 	
						
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(129);
				match(LPAR);
				setState(130);
				match(RELEASE_OP);
				setState(131);
				((FmlaContext)_localctx).f1 = fmla();
				setState(132);
				((FmlaContext)_localctx).f2 = fmla();
				setState(133);
				match(RPAR);

							MITLIFormula f = null;
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
		public List<MITLIFormula> l;
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
		((Conjuncts_listContext)_localctx).l =  new ArrayList<MITLIFormula>();
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			((Conjuncts_listContext)_localctx).fmla = fmla();
			setState(141);
			switch (_input.LA(1)) {
			case LPAR:
			case TRUE:
			case FALSE:
			case ID:
				{
				setState(139);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u0094\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\5\4\33\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u008b\n\5\3\6\3\6"+
		"\3\6\5\6\u0090\n\6\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\2\u00a1\2\f\3\2\2\2\4"+
		"\17\3\2\2\2\6\32\3\2\2\2\b\u008a\3\2\2\2\n\u008c\3\2\2\2\f\r\5\b\5\2\r"+
		"\16\b\2\1\2\16\3\3\2\2\2\17\20\7\33\2\2\20\21\7\32\2\2\21\22\b\3\1\2\22"+
		"\5\3\2\2\2\23\24\7\3\2\2\24\25\7\36\2\2\25\26\5\b\5\2\26\27\b\4\1\2\27"+
		"\30\7\37\2\2\30\33\3\2\2\2\31\33\7\37\2\2\32\23\3\2\2\2\32\31\3\2\2\2"+
		"\33\7\3\2\2\2\34\35\7\4\2\2\35\36\5\b\5\2\36\37\b\5\1\2\37 \7\5\2\2 \u008b"+
		"\3\2\2\2!\"\7\b\2\2\"\u008b\b\5\1\2#$\7\t\2\2$\u008b\b\5\1\2%&\7\36\2"+
		"\2&\u008b\b\5\1\2\'(\7\4\2\2()\7\n\2\2)*\5\b\5\2*+\7\5\2\2+,\b\5\1\2,"+
		"\u008b\3\2\2\2-.\7\4\2\2./\7\13\2\2/\60\5\n\6\2\60\61\7\5\2\2\61\62\b"+
		"\5\1\2\62\u008b\3\2\2\2\63\64\7\4\2\2\64\65\7\f\2\2\65\66\5\n\6\2\66\67"+
		"\7\5\2\2\678\b\5\1\28\u008b\3\2\2\29:\7\4\2\2:;\7\r\2\2;<\5\b\5\2<=\5"+
		"\b\5\2=>\7\5\2\2>?\b\5\1\2?\u008b\3\2\2\2@A\7\4\2\2AB\7\16\2\2BC\5\b\5"+
		"\2CD\5\b\5\2DE\7\5\2\2EF\b\5\1\2F\u008b\3\2\2\2GH\7\4\2\2HI\7\17\2\2I"+
		"J\7\35\2\2JK\7\35\2\2KL\5\b\5\2LM\7\5\2\2MN\b\5\1\2N\u008b\3\2\2\2OP\7"+
		"\4\2\2PQ\7\20\2\2QR\7\35\2\2RS\5\b\5\2ST\7\5\2\2TU\b\5\1\2U\u008b\3\2"+
		"\2\2VW\7\4\2\2WX\7\21\2\2XY\7\35\2\2YZ\7\35\2\2Z[\5\b\5\2[\\\7\5\2\2\\"+
		"]\b\5\1\2]\u008b\3\2\2\2^_\7\4\2\2_`\7\22\2\2`a\7\35\2\2ab\5\b\5\2bc\7"+
		"\5\2\2cd\b\5\1\2d\u008b\3\2\2\2ef\7\4\2\2fg\7\23\2\2gh\7\35\2\2hi\7\35"+
		"\2\2ij\5\b\5\2jk\7\5\2\2kl\b\5\1\2l\u008b\3\2\2\2mn\7\4\2\2no\7\24\2\2"+
		"op\7\35\2\2pq\7\35\2\2qr\5\b\5\2rs\7\5\2\2st\b\5\1\2t\u008b\3\2\2\2uv"+
		"\7\4\2\2vw\7\25\2\2wx\5\b\5\2xy\5\b\5\2yz\7\5\2\2z{\b\5\1\2{\u008b\3\2"+
		"\2\2|}\7\4\2\2}~\7\26\2\2~\177\5\b\5\2\177\u0080\5\b\5\2\u0080\u0081\7"+
		"\5\2\2\u0081\u0082\b\5\1\2\u0082\u008b\3\2\2\2\u0083\u0084\7\4\2\2\u0084"+
		"\u0085\7\27\2\2\u0085\u0086\5\b\5\2\u0086\u0087\5\b\5\2\u0087\u0088\7"+
		"\5\2\2\u0088\u0089\b\5\1\2\u0089\u008b\3\2\2\2\u008a\34\3\2\2\2\u008a"+
		"!\3\2\2\2\u008a#\3\2\2\2\u008a%\3\2\2\2\u008a\'\3\2\2\2\u008a-\3\2\2\2"+
		"\u008a\63\3\2\2\2\u008a9\3\2\2\2\u008a@\3\2\2\2\u008aG\3\2\2\2\u008aO"+
		"\3\2\2\2\u008aV\3\2\2\2\u008a^\3\2\2\2\u008ae\3\2\2\2\u008am\3\2\2\2\u008a"+
		"u\3\2\2\2\u008a|\3\2\2\2\u008a\u0083\3\2\2\2\u008b\t\3\2\2\2\u008c\u008f"+
		"\5\b\5\2\u008d\u0090\5\n\6\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\b\6\1\2\u0092\13\3\2\2"+
		"\2\5\32\u008a\u008f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}