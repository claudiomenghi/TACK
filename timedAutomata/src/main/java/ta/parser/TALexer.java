// Generated from TA.g4 by ANTLR 4.6

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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TALexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__39=1, T__38=2, T__37=3, T__36=4, T__35=5, T__34=6, T__33=7, T__32=8, 
		T__31=9, T__30=10, T__29=11, T__28=12, T__27=13, T__26=14, T__25=15, T__24=16, 
		T__23=17, T__22=18, T__21=19, T__20=20, T__19=21, T__18=22, T__17=23, 
		T__16=24, T__15=25, T__14=26, T__13=27, T__12=28, T__11=29, T__10=30, 
		T__9=31, T__8=32, T__7=33, T__6=34, T__5=35, T__4=36, T__3=37, T__2=38, 
		T__1=39, T__0=40, LE=41, LEQ=42, GEQ=43, GE=44, EQCOMP=45, NEQ=46, EQASSIGN=47, 
		EQ=48, FRACTEQ=49, MODEQ=50, PLUS=51, PLUSPLUS=52, MINUSMINUS=53, MINUS=54, 
		MULT=55, PLUSEQ=56, MINUSEQ=57, COLUMEQ=58, MULTEQ=59, POWEQ=60, FRACT=61, 
		MOD=62, POW=63, BIN_PROPOSITIONAL_LOGIC_OPERATOR=64, NOT=65, AND=66, OR=67, 
		BITAND=68, BITANDEQ=69, BITOREQ=70, BITOR=71, LPAR=72, RPAR=73, LBRA=74, 
		RBRA=75, SEMICOLUMN=76, WS=77, ID=78, NAT=79, TRUE=80, FALSE=81, NEWLINE=82, 
		COMMA=83, COMMENT=84, LINE_COMMENT=85;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'", 
		"'<'", "'='", "'>'", "'?'", "'@'", "'A'", "'B'", "'C'", "'D'", "'E'", 
		"'F'", "'G'", "'H'", "'I'", "'J'", "'K'", "'L'", "'M'", "'N'", "'O'", 
		"'P'", "'Q'", "'R'", "'S'", "'T'", "'U'"
	};
	public static final String[] ruleNames = {
		"T__39", "T__38", "T__37", "T__36", "T__35", "T__34", "T__33", "T__32", 
		"T__31", "T__30", "T__29", "T__28", "T__27", "T__26", "T__25", "T__24", 
		"T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", "T__16", 
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "LE", 
		"LEQ", "GEQ", "GE", "EQCOMP", "NEQ", "EQASSIGN", "EQ", "FRACTEQ", "MODEQ", 
		"PLUS", "PLUSPLUS", "MINUSMINUS", "MINUS", "MULT", "PLUSEQ", "MINUSEQ", 
		"COLUMEQ", "MULTEQ", "POWEQ", "FRACT", "MOD", "POW", "BIN_PROPOSITIONAL_LOGIC_OPERATOR", 
		"NOT", "AND", "OR", "BITAND", "BITANDEQ", "BITOREQ", "BITOR", "LPAR", 
		"RPAR", "LBRA", "RBRA", "SEMICOLUMN", "WS", "ID", "NAT", "TRUE", "FALSE", 
		"NEWLINE", "COMMA", "COMMENT", "LINE_COMMENT"
	};

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
	 

	public TALexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TA.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2W\u0212\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3!\3!\3!"+
		"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3"+
		".\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\38\38\39\39\39\3:\3"+
		":\3:\3;\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\5A\u01b5\nA\3"+
		"B\3B\3C\3C\3C\3D\3D\3D\3E\3E\3F\3F\3F\3G\3G\3G\3H\3H\3I\3I\3J\3J\3K\3"+
		"K\3L\3L\3M\3M\3N\6N\u01d4\nN\rN\16N\u01d5\3N\3N\3O\3O\7O\u01dc\nO\fO\16"+
		"O\u01df\13O\3P\3P\7P\u01e3\nP\fP\16P\u01e6\13P\3Q\3Q\3Q\3Q\3Q\3R\3R\3"+
		"R\3R\3R\3R\3S\5S\u01f4\nS\3S\3S\3T\3T\3U\3U\3U\3U\7U\u01fe\nU\fU\16U\u0201"+
		"\13U\3U\3U\3U\3U\3U\3V\3V\3V\3V\7V\u020c\nV\fV\16V\u020f\13V\3V\3V\3\u01ff"+
		"\2W\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008d"+
		"H\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1"+
		"R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\3\2\6\5\2\13\f\17\17\"\"\4\2C\\c"+
		"|\6\2\62;C\\aac|\4\2\f\f\17\17\u0218\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2"+
		"\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2"+
		"\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2"+
		"\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2"+
		"\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b"+
		"\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2"+
		"\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\3\u00ad"+
		"\3\2\2\2\5\u00b2\3\2\2\2\7\u00bc\3\2\2\2\t\u00c4\3\2\2\2\13\u00ca\3\2"+
		"\2\2\r\u00d0\3\2\2\2\17\u00d8\3\2\2\2\21\u00df\3\2\2\2\23\u00e4\3\2\2"+
		"\2\25\u00eb\3\2\2\2\27\u00ef\3\2\2\2\31\u00f5\3\2\2\2\33\u00f7\3\2\2\2"+
		"\35\u00f9\3\2\2\2\37\u00fd\3\2\2\2!\u0100\3\2\2\2#\u0104\3\2\2\2%\u0106"+
		"\3\2\2\2\'\u010d\3\2\2\2)\u0113\3\2\2\2+\u0117\3\2\2\2-\u011d\3\2\2\2"+
		"/\u0120\3\2\2\2\61\u0127\3\2\2\2\63\u012d\3\2\2\2\65\u0130\3\2\2\2\67"+
		"\u0135\3\2\2\29\u013c\3\2\2\2;\u0142\3\2\2\2=\u0147\3\2\2\2?\u014e\3\2"+
		"\2\2A\u0150\3\2\2\2C\u0155\3\2\2\2E\u0157\3\2\2\2G\u015c\3\2\2\2I\u015e"+
		"\3\2\2\2K\u0160\3\2\2\2M\u0162\3\2\2\2O\u0167\3\2\2\2Q\u016f\3\2\2\2S"+
		"\u0176\3\2\2\2U\u0178\3\2\2\2W\u017b\3\2\2\2Y\u017e\3\2\2\2[\u0180\3\2"+
		"\2\2]\u0183\3\2\2\2_\u0186\3\2\2\2a\u0189\3\2\2\2c\u018b\3\2\2\2e\u018e"+
		"\3\2\2\2g\u0191\3\2\2\2i\u0193\3\2\2\2k\u0196\3\2\2\2m\u0199\3\2\2\2o"+
		"\u019b\3\2\2\2q\u019d\3\2\2\2s\u01a0\3\2\2\2u\u01a3\3\2\2\2w\u01a6\3\2"+
		"\2\2y\u01a9\3\2\2\2{\u01ac\3\2\2\2}\u01ae\3\2\2\2\177\u01b0\3\2\2\2\u0081"+
		"\u01b4\3\2\2\2\u0083\u01b6\3\2\2\2\u0085\u01b8\3\2\2\2\u0087\u01bb\3\2"+
		"\2\2\u0089\u01be\3\2\2\2\u008b\u01c0\3\2\2\2\u008d\u01c3\3\2\2\2\u008f"+
		"\u01c6\3\2\2\2\u0091\u01c8\3\2\2\2\u0093\u01ca\3\2\2\2\u0095\u01cc\3\2"+
		"\2\2\u0097\u01ce\3\2\2\2\u0099\u01d0\3\2\2\2\u009b\u01d3\3\2\2\2\u009d"+
		"\u01d9\3\2\2\2\u009f\u01e0\3\2\2\2\u00a1\u01e7\3\2\2\2\u00a3\u01ec\3\2"+
		"\2\2\u00a5\u01f3\3\2\2\2\u00a7\u01f7\3\2\2\2\u00a9\u01f9\3\2\2\2\u00ab"+
		"\u0207\3\2\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7{\2\2\u00af\u00b0\7p\2"+
		"\2\u00b0\u00b1\7e\2\2\u00b1\4\3\2\2\2\u00b2\u00b3\7d\2\2\u00b3\u00b4\7"+
		"t\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7f\2\2\u00b7\u00b8"+
		"\7e\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7v\2\2\u00bb"+
		"\6\3\2\2\2\u00bc\u00bd\7f\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7h\2\2\u00bf"+
		"\u00c0\7c\2\2\u00c0\u00c1\7w\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7v\2\2"+
		"\u00c3\b\3\2\2\2\u00c4\u00c5\7i\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7\7c"+
		"\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7f\2\2\u00c9\n\3\2\2\2\u00ca\u00cb"+
		"\7u\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7v\2\2\u00ce"+
		"\u00cf\7g\2\2\u00cf\f\3\2\2\2\u00d0\u00d1\7r\2\2\u00d1\u00d2\7t\2\2\u00d2"+
		"\u00d3\7q\2\2\u00d3\u00d4\7e\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7u\2\2"+
		"\u00d6\u00d7\7u\2\2\u00d7\16\3\2\2\2\u00d8\u00d9\7e\2\2\u00d9\u00da\7"+
		"q\2\2\u00da\u00db\7o\2\2\u00db\u00dc\7o\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de"+
		"\7v\2\2\u00de\20\3\2\2\2\u00df\u00e0\7e\2\2\u00e0\u00e1\7j\2\2\u00e1\u00e2"+
		"\7c\2\2\u00e2\u00e3\7t\2\2\u00e3\22\3\2\2\2\u00e4\u00e5\7t\2\2\u00e5\u00e6"+
		"\7g\2\2\u00e6\u00e7\7v\2\2\u00e7\u00e8\7w\2\2\u00e8\u00e9\7t\2\2\u00e9"+
		"\u00ea\7p\2\2\u00ea\24\3\2\2\2\u00eb\u00ec\7@\2\2\u00ec\u00ed\7@\2\2\u00ed"+
		"\u00ee\7?\2\2\u00ee\26\3\2\2\2\u00ef\u00f0\7y\2\2\u00f0\u00f1\7j\2\2\u00f1"+
		"\u00f2\7k\2\2\u00f2\u00f3\7n\2\2\u00f3\u00f4\7g\2\2\u00f4\30\3\2\2\2\u00f5"+
		"\u00f6\7}\2\2\u00f6\32\3\2\2\2\u00f7\u00f8\7\177\2\2\u00f8\34\3\2\2\2"+
		"\u00f9\u00fa\7>\2\2\u00fa\u00fb\7>\2\2\u00fb\u00fc\7?\2\2\u00fc\36\3\2"+
		"\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff\7h\2\2\u00ff \3\2\2\2\u0100\u0101"+
		"\7h\2\2\u0101\u0102\7q\2\2\u0102\u0103\7t\2\2\u0103\"\3\2\2\2\u0104\u0105"+
		"\7A\2\2\u0105$\3\2\2\2\u0106\u0107\7u\2\2\u0107\u0108\7{\2\2\u0108\u0109"+
		"\7u\2\2\u0109\u010a\7v\2\2\u010a\u010b\7g\2\2\u010b\u010c\7o\2\2\u010c"+
		"&\3\2\2\2\u010d\u010e\7d\2\2\u010e\u010f\7t\2\2\u010f\u0110\7g\2\2\u0110"+
		"\u0111\7c\2\2\u0111\u0112\7m\2\2\u0112(\3\2\2\2\u0113\u0114\7k\2\2\u0114"+
		"\u0115\7p\2\2\u0115\u0116\7v\2\2\u0116*\3\2\2\2\u0117\u0118\7e\2\2\u0118"+
		"\u0119\7n\2\2\u0119\u011a\7q\2\2\u011a\u011b\7e\2\2\u011b\u011c\7m\2\2"+
		"\u011c,\3\2\2\2\u011d\u011e\7f\2\2\u011e\u011f\7q\2\2\u011f.\3\2\2\2\u0120"+
		"\u0121\7u\2\2\u0121\u0122\7y\2\2\u0122\u0123\7k\2\2\u0123\u0124\7v\2\2"+
		"\u0124\u0125\7e\2\2\u0125\u0126\7j\2\2\u0126\60\3\2\2\2\u0127\u0128\7"+
		"v\2\2\u0128\u0129\7t\2\2\u0129\u012a\7c\2\2\u012a\u012b\7p\2\2\u012b\u012c"+
		"\7u\2\2\u012c\62\3\2\2\2\u012d\u012e\7/\2\2\u012e\u012f\7@\2\2\u012f\64"+
		"\3\2\2\2\u0130\u0131\7e\2\2\u0131\u0132\7c\2\2\u0132\u0133\7u\2\2\u0133"+
		"\u0134\7g\2\2\u0134\66\3\2\2\2\u0135\u0136\7c\2\2\u0136\u0137\7u\2\2\u0137"+
		"\u0138\7u\2\2\u0138\u0139\7k\2\2\u0139\u013a\7i\2\2\u013a\u013b\7p\2\2"+
		"\u013b8\3\2\2\2\u013c\u013d\7e\2\2\u013d\u013e\7q\2\2\u013e\u013f\7p\2"+
		"\2\u013f\u0140\7u\2\2\u0140\u0141\7v\2\2\u0141:\3\2\2\2\u0142\u0143\7"+
		"k\2\2\u0143\u0144\7p\2\2\u0144\u0145\7k\2\2\u0145\u0146\7v\2\2\u0146<"+
		"\3\2\2\2\u0147\u0148\7w\2\2\u0148\u0149\7t\2\2\u0149\u014a\7i\2\2\u014a"+
		"\u014b\7g\2\2\u014b\u014c\7p\2\2\u014c\u014d\7v\2\2\u014d>\3\2\2\2\u014e"+
		"\u014f\7<\2\2\u014f@\3\2\2\2\u0150\u0151\7@\2\2\u0151\u0152\7@\2\2\u0152"+
		"\u0153\7@\2\2\u0153\u0154\7?\2\2\u0154B\3\2\2\2\u0155\u0156\7\u0080\2"+
		"\2\u0156D\3\2\2\2\u0157\u0158\7d\2\2\u0158\u0159\7q\2\2\u0159\u015a\7"+
		"q\2\2\u015a\u015b\7n\2\2\u015bF\3\2\2\2\u015c\u015d\7B\2\2\u015dH\3\2"+
		"\2\2\u015e\u015f\7#\2\2\u015fJ\3\2\2\2\u0160\u0161\7%\2\2\u0161L\3\2\2"+
		"\2\u0162\u0163\7g\2\2\u0163\u0164\7n\2\2\u0164\u0165\7u\2\2\u0165\u0166"+
		"\7g\2\2\u0166N\3\2\2\2\u0167\u0168\7v\2\2\u0168\u0169\7{\2\2\u0169\u016a"+
		"\7r\2\2\u016a\u016b\7g\2\2\u016b\u016c\7f\2\2\u016c\u016d\7g\2\2\u016d"+
		"\u016e\7h\2\2\u016eP\3\2\2\2\u016f\u0170\7u\2\2\u0170\u0171\7v\2\2\u0171"+
		"\u0172\7t\2\2\u0172\u0173\7w\2\2\u0173\u0174\7e\2\2\u0174\u0175\7v\2\2"+
		"\u0175R\3\2\2\2\u0176\u0177\7>\2\2\u0177T\3\2\2\2\u0178\u0179\7>\2\2\u0179"+
		"\u017a\7?\2\2\u017aV\3\2\2\2\u017b\u017c\7@\2\2\u017c\u017d\7?\2\2\u017d"+
		"X\3\2\2\2\u017e\u017f\7@\2\2\u017fZ\3\2\2\2\u0180\u0181\7?\2\2\u0181\u0182"+
		"\7?\2\2\u0182\\\3\2\2\2\u0183\u0184\7#\2\2\u0184\u0185\7?\2\2\u0185^\3"+
		"\2\2\2\u0186\u0187\7<\2\2\u0187\u0188\7?\2\2\u0188`\3\2\2\2\u0189\u018a"+
		"\7?\2\2\u018ab\3\2\2\2\u018b\u018c\7\61\2\2\u018c\u018d\7?\2\2\u018dd"+
		"\3\2\2\2\u018e\u018f\7\'\2\2\u018f\u0190\7?\2\2\u0190f\3\2\2\2\u0191\u0192"+
		"\7-\2\2\u0192h\3\2\2\2\u0193\u0194\7-\2\2\u0194\u0195\7-\2\2\u0195j\3"+
		"\2\2\2\u0196\u0197\7/\2\2\u0197\u0198\7/\2\2\u0198l\3\2\2\2\u0199\u019a"+
		"\7/\2\2\u019an\3\2\2\2\u019b\u019c\7,\2\2\u019cp\3\2\2\2\u019d\u019e\7"+
		"-\2\2\u019e\u019f\7?\2\2\u019fr\3\2\2\2\u01a0\u01a1\7/\2\2\u01a1\u01a2"+
		"\7?\2\2\u01a2t\3\2\2\2\u01a3\u01a4\7<\2\2\u01a4\u01a5\7?\2\2\u01a5v\3"+
		"\2\2\2\u01a6\u01a7\7,\2\2\u01a7\u01a8\7?\2\2\u01a8x\3\2\2\2\u01a9\u01aa"+
		"\7`\2\2\u01aa\u01ab\7?\2\2\u01abz\3\2\2\2\u01ac\u01ad\7\61\2\2\u01ad|"+
		"\3\2\2\2\u01ae\u01af\7\'\2\2\u01af~\3\2\2\2\u01b0\u01b1\7`\2\2\u01b1\u0080"+
		"\3\2\2\2\u01b2\u01b5\5\u0085C\2\u01b3\u01b5\5\u0087D\2\u01b4\u01b2\3\2"+
		"\2\2\u01b4\u01b3\3\2\2\2\u01b5\u0082\3\2\2\2\u01b6\u01b7\7#\2\2\u01b7"+
		"\u0084\3\2\2\2\u01b8\u01b9\7(\2\2\u01b9\u01ba\7(\2\2\u01ba\u0086\3\2\2"+
		"\2\u01bb\u01bc\7~\2\2\u01bc\u01bd\7~\2\2\u01bd\u0088\3\2\2\2\u01be\u01bf"+
		"\7(\2\2\u01bf\u008a\3\2\2\2\u01c0\u01c1\7(\2\2\u01c1\u01c2\7?\2\2\u01c2"+
		"\u008c\3\2\2\2\u01c3\u01c4\7~\2\2\u01c4\u01c5\7?\2\2\u01c5\u008e\3\2\2"+
		"\2\u01c6\u01c7\7~\2\2\u01c7\u0090\3\2\2\2\u01c8\u01c9\7*\2\2\u01c9\u0092"+
		"\3\2\2\2\u01ca\u01cb\7+\2\2\u01cb\u0094\3\2\2\2\u01cc\u01cd\7]\2\2\u01cd"+
		"\u0096\3\2\2\2\u01ce\u01cf\7_\2\2\u01cf\u0098\3\2\2\2\u01d0\u01d1\7=\2"+
		"\2\u01d1\u009a\3\2\2\2\u01d2\u01d4\t\2\2\2\u01d3\u01d2\3\2\2\2\u01d4\u01d5"+
		"\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7"+
		"\u01d8\bN\2\2\u01d8\u009c\3\2\2\2\u01d9\u01dd\t\3\2\2\u01da\u01dc\t\4"+
		"\2\2\u01db\u01da\3\2\2\2\u01dc\u01df\3\2\2\2\u01dd\u01db\3\2\2\2\u01dd"+
		"\u01de\3\2\2\2\u01de\u009e\3\2\2\2\u01df\u01dd\3\2\2\2\u01e0\u01e4\4\62"+
		";\2\u01e1\u01e3\4\62;\2\u01e2\u01e1\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4"+
		"\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u00a0\3\2\2\2\u01e6\u01e4\3\2"+
		"\2\2\u01e7\u01e8\7v\2\2\u01e8\u01e9\7t\2\2\u01e9\u01ea\7w\2\2\u01ea\u01eb"+
		"\7g\2\2\u01eb\u00a2\3\2\2\2\u01ec\u01ed\7h\2\2\u01ed\u01ee\7c\2\2\u01ee"+
		"\u01ef\7n\2\2\u01ef\u01f0\7u\2\2\u01f0\u01f1\7g\2\2\u01f1\u00a4\3\2\2"+
		"\2\u01f2\u01f4\7\17\2\2\u01f3\u01f2\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4"+
		"\u01f5\3\2\2\2\u01f5\u01f6\7\f\2\2\u01f6\u00a6\3\2\2\2\u01f7\u01f8\7."+
		"\2\2\u01f8\u00a8\3\2\2\2\u01f9\u01fa\7\61\2\2\u01fa\u01fb\7,\2\2\u01fb"+
		"\u01ff\3\2\2\2\u01fc\u01fe\13\2\2\2\u01fd\u01fc\3\2\2\2\u01fe\u0201\3"+
		"\2\2\2\u01ff\u0200\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0202\3\2\2\2\u0201"+
		"\u01ff\3\2\2\2\u0202\u0203\7,\2\2\u0203\u0204\7\61\2\2\u0204\u0205\3\2"+
		"\2\2\u0205\u0206\bU\2\2\u0206\u00aa\3\2\2\2\u0207\u0208\7\61\2\2\u0208"+
		"\u0209\7\61\2\2\u0209\u020d\3\2\2\2\u020a\u020c\n\5\2\2\u020b\u020a\3"+
		"\2\2\2\u020c\u020f\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e"+
		"\u0210\3\2\2\2\u020f\u020d\3\2\2\2\u0210\u0211\bV\2\2\u0211\u00ac\3\2"+
		"\2\2\n\2\u01b4\u01d5\u01dd\u01e4\u01f3\u01ff\u020d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}