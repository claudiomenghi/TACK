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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MITLILexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "LPAR", "RPAR", "LBRA", "RBRA", "TRUE", "FALSE", 
		"NEG_OP", "AND_OP", "OR_OP", "IMPL_OP", "IFF_OP", "F_OP", "F_inf_OP", 
		"G_OP", "G_inf_OP", "P_OP", "H_OP", "UNTIL_OP", "SINCE_OP", "RELEASE_OP", 
		"TRIGGER_OP", "COUNT_OP", "LOGIC", "COLON", "SEMI", "INT", "ATOM", "ID", 
		"NEWLINE", "WS", "COMMENT"
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


	public MITLILexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MITLI.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 32:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 33:
			COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u0122\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0090\n\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u009a\n\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00ac\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00b6\n\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\5\24\u00c8\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00da\n\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00f8\n\33\3\34"+
		"\3\34\3\35\3\35\3\36\6\36\u00ff\n\36\r\36\16\36\u0100\3\37\3\37\3 \3 "+
		"\3 \3 \7 \u0109\n \f \16 \u010c\13 \3!\5!\u010f\n!\3!\3!\3\"\6\"\u0114"+
		"\n\"\r\"\16\"\u0115\3\"\3\"\3#\3#\7#\u011c\n#\f#\16#\u011f\13#\3#\3#\2"+
		"\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37=\2? A!C\"E#\3\2\4\4\2\13\13\"\"\4\2\f\f\17\17\u0138\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5N\3\2\2\2\7W\3\2\2\2\t"+
		"\\\3\2\2\2\13^\3\2\2\2\r`\3\2\2\2\17b\3\2\2\2\21d\3\2\2\2\23i\3\2\2\2"+
		"\25o\3\2\2\2\27r\3\2\2\2\31u\3\2\2\2\33x\3\2\2\2\35{\3\2\2\2\37\u008f"+
		"\3\2\2\2!\u0099\3\2\2\2#\u00ab\3\2\2\2%\u00b5\3\2\2\2\'\u00c7\3\2\2\2"+
		")\u00d9\3\2\2\2+\u00db\3\2\2\2-\u00dd\3\2\2\2/\u00df\3\2\2\2\61\u00e1"+
		"\3\2\2\2\63\u00e3\3\2\2\2\65\u00f7\3\2\2\2\67\u00f9\3\2\2\29\u00fb\3\2"+
		"\2\2;\u00fe\3\2\2\2=\u0102\3\2\2\2?\u0104\3\2\2\2A\u010e\3\2\2\2C\u0113"+
		"\3\2\2\2E\u0119\3\2\2\2GH\7<\2\2HI\7d\2\2IJ\7q\2\2JK\7w\2\2KL\7p\2\2L"+
		"M\7f\2\2M\4\3\2\2\2NO\7<\2\2OP\7h\2\2PQ\7q\2\2QR\7t\2\2RS\7o\2\2ST\7w"+
		"\2\2TU\7n\2\2UV\7c\2\2V\6\3\2\2\2WX\7<\2\2XY\7f\2\2YZ\7g\2\2Z[\7h\2\2"+
		"[\b\3\2\2\2\\]\7*\2\2]\n\3\2\2\2^_\7+\2\2_\f\3\2\2\2`a\7]\2\2a\16\3\2"+
		"\2\2bc\7_\2\2c\20\3\2\2\2de\7v\2\2ef\7t\2\2fg\7w\2\2gh\7g\2\2h\22\3\2"+
		"\2\2ij\7h\2\2jk\7c\2\2kl\7n\2\2lm\7u\2\2mn\7g\2\2n\24\3\2\2\2op\7#\2\2"+
		"pq\7#\2\2q\26\3\2\2\2rs\7(\2\2st\7(\2\2t\30\3\2\2\2uv\7~\2\2vw\7~\2\2"+
		"w\32\3\2\2\2xy\7/\2\2yz\7@\2\2z\34\3\2\2\2{|\7>\2\2|}\7/\2\2}~\7@\2\2"+
		"~\36\3\2\2\2\177\u0080\7H\2\2\u0080\u0081\7a\2\2\u0081\u0082\7g\2\2\u0082"+
		"\u0090\7g\2\2\u0083\u0084\7H\2\2\u0084\u0085\7a\2\2\u0085\u0086\7g\2\2"+
		"\u0086\u0090\7k\2\2\u0087\u0088\7H\2\2\u0088\u0089\7a\2\2\u0089\u008a"+
		"\7k\2\2\u008a\u0090\7k\2\2\u008b\u008c\7H\2\2\u008c\u008d\7a\2\2\u008d"+
		"\u008e\7k\2\2\u008e\u0090\7g\2\2\u008f\177\3\2\2\2\u008f\u0083\3\2\2\2"+
		"\u008f\u0087\3\2\2\2\u008f\u008b\3\2\2\2\u0090 \3\2\2\2\u0091\u0092\7"+
		"H\2\2\u0092\u0093\7a\2\2\u0093\u0094\7g\2\2\u0094\u009a\7-\2\2\u0095\u0096"+
		"\7H\2\2\u0096\u0097\7a\2\2\u0097\u0098\7k\2\2\u0098\u009a\7-\2\2\u0099"+
		"\u0091\3\2\2\2\u0099\u0095\3\2\2\2\u009a\"\3\2\2\2\u009b\u009c\7I\2\2"+
		"\u009c\u009d\7a\2\2\u009d\u009e\7g\2\2\u009e\u00ac\7g\2\2\u009f\u00a0"+
		"\7I\2\2\u00a0\u00a1\7a\2\2\u00a1\u00a2\7g\2\2\u00a2\u00ac\7k\2\2\u00a3"+
		"\u00a4\7I\2\2\u00a4\u00a5\7a\2\2\u00a5\u00a6\7k\2\2\u00a6\u00ac\7k\2\2"+
		"\u00a7\u00a8\7I\2\2\u00a8\u00a9\7a\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ac"+
		"\7g\2\2\u00ab\u009b\3\2\2\2\u00ab\u009f\3\2\2\2\u00ab\u00a3\3\2\2\2\u00ab"+
		"\u00a7\3\2\2\2\u00ac$\3\2\2\2\u00ad\u00ae\7I\2\2\u00ae\u00af\7a\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0\u00b6\7-\2\2\u00b1\u00b2\7I\2\2\u00b2\u00b3\7a\2\2"+
		"\u00b3\u00b4\7k\2\2\u00b4\u00b6\7-\2\2\u00b5\u00ad\3\2\2\2\u00b5\u00b1"+
		"\3\2\2\2\u00b6&\3\2\2\2\u00b7\u00b8\7R\2\2\u00b8\u00b9\7a\2\2\u00b9\u00ba"+
		"\7g\2\2\u00ba\u00c8\7g\2\2\u00bb\u00bc\7R\2\2\u00bc\u00bd\7a\2\2\u00bd"+
		"\u00be\7g\2\2\u00be\u00c8\7k\2\2\u00bf\u00c0\7R\2\2\u00c0\u00c1\7a\2\2"+
		"\u00c1\u00c2\7k\2\2\u00c2\u00c8\7k\2\2\u00c3\u00c4\7R\2\2\u00c4\u00c5"+
		"\7a\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c8\7g\2\2\u00c7\u00b7\3\2\2\2\u00c7"+
		"\u00bb\3\2\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c8(\3\2\2\2"+
		"\u00c9\u00ca\7J\2\2\u00ca\u00cb\7a\2\2\u00cb\u00cc\7g\2\2\u00cc\u00da"+
		"\7g\2\2\u00cd\u00ce\7J\2\2\u00ce\u00cf\7a\2\2\u00cf\u00d0\7g\2\2\u00d0"+
		"\u00da\7k\2\2\u00d1\u00d2\7J\2\2\u00d2\u00d3\7a\2\2\u00d3\u00d4\7k\2\2"+
		"\u00d4\u00da\7k\2\2\u00d5\u00d6\7J\2\2\u00d6\u00d7\7a\2\2\u00d7\u00d8"+
		"\7k\2\2\u00d8\u00da\7g\2\2\u00d9\u00c9\3\2\2\2\u00d9\u00cd\3\2\2\2\u00d9"+
		"\u00d1\3\2\2\2\u00d9\u00d5\3\2\2\2\u00da*\3\2\2\2\u00db\u00dc\7W\2\2\u00dc"+
		",\3\2\2\2\u00dd\u00de\7U\2\2\u00de.\3\2\2\2\u00df\u00e0\7T\2\2\u00e0\60"+
		"\3\2\2\2\u00e1\u00e2\7V\2\2\u00e2\62\3\2\2\2\u00e3\u00e4\7E\2\2\u00e4"+
		"\64\3\2\2\2\u00e5\u00e6\7s\2\2\u00e6\u00e7\7v\2\2\u00e7\u00f8\7n\2\2\u00e8"+
		"\u00e9\7o\2\2\u00e9\u00ea\7k\2\2\u00ea\u00eb\7v\2\2\u00eb\u00f8\7n\2\2"+
		"\u00ec\u00ed\7s\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7n\2\2\u00ef\u00f0"+
		"\7/\2\2\u00f0\u00f8\7k\2\2\u00f1\u00f2\7o\2\2\u00f2\u00f3\7k\2\2\u00f3"+
		"\u00f4\7v\2\2\u00f4\u00f5\7n\2\2\u00f5\u00f6\7/\2\2\u00f6\u00f8\7k\2\2"+
		"\u00f7\u00e5\3\2\2\2\u00f7\u00e8\3\2\2\2\u00f7\u00ec\3\2\2\2\u00f7\u00f1"+
		"\3\2\2\2\u00f8\66\3\2\2\2\u00f9\u00fa\7<\2\2\u00fa8\3\2\2\2\u00fb\u00fc"+
		"\7=\2\2\u00fc:\3\2\2\2\u00fd\u00ff\4\62;\2\u00fe\u00fd\3\2\2\2\u00ff\u0100"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101<\3\2\2\2\u0102"+
		"\u0103\4c|\2\u0103>\3\2\2\2\u0104\u010a\5=\37\2\u0105\u0109\5=\37\2\u0106"+
		"\u0109\5;\36\2\u0107\u0109\7a\2\2\u0108\u0105\3\2\2\2\u0108\u0106\3\2"+
		"\2\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b@\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010f\7\17\2\2"+
		"\u010e\u010d\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111"+
		"\7\f\2\2\u0111B\3\2\2\2\u0112\u0114\t\2\2\2\u0113\u0112\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117\u0118\b\"\2\2\u0118D\3\2\2\2\u0119\u011d\7%\2\2\u011a\u011c"+
		"\n\3\2\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\b#"+
		"\3\2\u0121F\3\2\2\2\20\2\u008f\u0099\u00ab\u00b5\u00c7\u00d9\u00f7\u0100"+
		"\u0108\u010a\u010e\u0115\u011d\4\3\"\2\3#\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}