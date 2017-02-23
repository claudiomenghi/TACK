// Generated from MITLI.g4 by ANTLR 4.6

package formulae.mitli.parser;

import java.util.HashMap;
import formulae.*;
import formulae.mitli.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import formulae.mitli.atoms.*;

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
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, OP=2, LPAR=3, RPAR=4, LBRA=5, RBRA=6, TRUE=7, FALSE=8, NEG_OP=9, 
		AND_OP=10, OR_OP=11, IMPL_OP=12, IFF_OP=13, F_OP=14, F_inf_OP=15, G_OP=16, 
		G_inf_OP=17, P_OP=18, H_OP=19, UNTIL_OP=20, SINCE_OP=21, RELEASE_OP=22, 
		TRIGGER_OP=23, COUNT_OP=24, LOGIC=25, COLON=26, SEMI=27, INT=28, ID=29, 
		NEWLINE=30, WS=31, COMMENT=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "OP", "LPAR", "RPAR", "LBRA", "RBRA", "TRUE", "FALSE", "NEG_OP", 
		"AND_OP", "OR_OP", "IMPL_OP", "IFF_OP", "F_OP", "F_inf_OP", "G_OP", "G_inf_OP", 
		"P_OP", "H_OP", "UNTIL_OP", "SINCE_OP", "RELEASE_OP", "TRIGGER_OP", "COUNT_OP", 
		"LOGIC", "COLON", "SEMI", "INT", "ATOM", "ID", "NEWLINE", "WS", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':def'", null, "'('", "')'", "'['", "']'", "'true'", "'false'", 
		"'!!'", "'&&'", "'||'", "'->'", "'<->'", null, null, null, null, null, 
		null, "'U'", "'S'", "'R'", "'T'", "'C'", null, "':'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "OP", "LPAR", "RPAR", "LBRA", "RBRA", "TRUE", "FALSE", "NEG_OP", 
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
		case 31:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 32:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u0117\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3P\n\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\5\17\u0085\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u008f\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00a1\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00ab\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00bd\n\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00cf\n\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u00ed\n\32\3\33\3\33\3\34\3\34\3\35\6\35\u00f4\n\35\r\35\16\35\u00f5"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u00fe\n\37\f\37\16\37\u0101\13\37"+
		"\3 \5 \u0104\n \3 \3 \3!\6!\u0109\n!\r!\16!\u010a\3!\3!\3\"\3\"\7\"\u0111"+
		"\n\"\f\"\16\"\u0114\13\"\3\"\3\"\2\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\2=\37? A!C\"\3\2\4\4\2\13\13\"\"\4\2"+
		"\f\f\17\17\u012f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5O"+
		"\3\2\2\2\7Q\3\2\2\2\tS\3\2\2\2\13U\3\2\2\2\rW\3\2\2\2\17Y\3\2\2\2\21^"+
		"\3\2\2\2\23d\3\2\2\2\25g\3\2\2\2\27j\3\2\2\2\31m\3\2\2\2\33p\3\2\2\2\35"+
		"\u0084\3\2\2\2\37\u008e\3\2\2\2!\u00a0\3\2\2\2#\u00aa\3\2\2\2%\u00bc\3"+
		"\2\2\2\'\u00ce\3\2\2\2)\u00d0\3\2\2\2+\u00d2\3\2\2\2-\u00d4\3\2\2\2/\u00d6"+
		"\3\2\2\2\61\u00d8\3\2\2\2\63\u00ec\3\2\2\2\65\u00ee\3\2\2\2\67\u00f0\3"+
		"\2\2\29\u00f3\3\2\2\2;\u00f7\3\2\2\2=\u00f9\3\2\2\2?\u0103\3\2\2\2A\u0108"+
		"\3\2\2\2C\u010e\3\2\2\2EF\7<\2\2FG\7f\2\2GH\7g\2\2HI\7h\2\2I\4\3\2\2\2"+
		"JP\4>@\2KL\7>\2\2LP\7?\2\2MN\7@\2\2NP\7?\2\2OJ\3\2\2\2OK\3\2\2\2OM\3\2"+
		"\2\2P\6\3\2\2\2QR\7*\2\2R\b\3\2\2\2ST\7+\2\2T\n\3\2\2\2UV\7]\2\2V\f\3"+
		"\2\2\2WX\7_\2\2X\16\3\2\2\2YZ\7v\2\2Z[\7t\2\2[\\\7w\2\2\\]\7g\2\2]\20"+
		"\3\2\2\2^_\7h\2\2_`\7c\2\2`a\7n\2\2ab\7u\2\2bc\7g\2\2c\22\3\2\2\2de\7"+
		"#\2\2ef\7#\2\2f\24\3\2\2\2gh\7(\2\2hi\7(\2\2i\26\3\2\2\2jk\7~\2\2kl\7"+
		"~\2\2l\30\3\2\2\2mn\7/\2\2no\7@\2\2o\32\3\2\2\2pq\7>\2\2qr\7/\2\2rs\7"+
		"@\2\2s\34\3\2\2\2tu\7H\2\2uv\7a\2\2vw\7g\2\2w\u0085\7g\2\2xy\7H\2\2yz"+
		"\7a\2\2z{\7g\2\2{\u0085\7k\2\2|}\7H\2\2}~\7a\2\2~\177\7k\2\2\177\u0085"+
		"\7k\2\2\u0080\u0081\7H\2\2\u0081\u0082\7a\2\2\u0082\u0083\7k\2\2\u0083"+
		"\u0085\7g\2\2\u0084t\3\2\2\2\u0084x\3\2\2\2\u0084|\3\2\2\2\u0084\u0080"+
		"\3\2\2\2\u0085\36\3\2\2\2\u0086\u0087\7H\2\2\u0087\u0088\7a\2\2\u0088"+
		"\u0089\7g\2\2\u0089\u008f\7-\2\2\u008a\u008b\7H\2\2\u008b\u008c\7a\2\2"+
		"\u008c\u008d\7k\2\2\u008d\u008f\7-\2\2\u008e\u0086\3\2\2\2\u008e\u008a"+
		"\3\2\2\2\u008f \3\2\2\2\u0090\u0091\7I\2\2\u0091\u0092\7a\2\2\u0092\u0093"+
		"\7g\2\2\u0093\u00a1\7g\2\2\u0094\u0095\7I\2\2\u0095\u0096\7a\2\2\u0096"+
		"\u0097\7g\2\2\u0097\u00a1\7k\2\2\u0098\u0099\7I\2\2\u0099\u009a\7a\2\2"+
		"\u009a\u009b\7k\2\2\u009b\u00a1\7k\2\2\u009c\u009d\7I\2\2\u009d\u009e"+
		"\7a\2\2\u009e\u009f\7k\2\2\u009f\u00a1\7g\2\2\u00a0\u0090\3\2\2\2\u00a0"+
		"\u0094\3\2\2\2\u00a0\u0098\3\2\2\2\u00a0\u009c\3\2\2\2\u00a1\"\3\2\2\2"+
		"\u00a2\u00a3\7I\2\2\u00a3\u00a4\7a\2\2\u00a4\u00a5\7g\2\2\u00a5\u00ab"+
		"\7-\2\2\u00a6\u00a7\7I\2\2\u00a7\u00a8\7a\2\2\u00a8\u00a9\7k\2\2\u00a9"+
		"\u00ab\7-\2\2\u00aa\u00a2\3\2\2\2\u00aa\u00a6\3\2\2\2\u00ab$\3\2\2\2\u00ac"+
		"\u00ad\7R\2\2\u00ad\u00ae\7a\2\2\u00ae\u00af\7g\2\2\u00af\u00bd\7g\2\2"+
		"\u00b0\u00b1\7R\2\2\u00b1\u00b2\7a\2\2\u00b2\u00b3\7g\2\2\u00b3\u00bd"+
		"\7k\2\2\u00b4\u00b5\7R\2\2\u00b5\u00b6\7a\2\2\u00b6\u00b7\7k\2\2\u00b7"+
		"\u00bd\7k\2\2\u00b8\u00b9\7R\2\2\u00b9\u00ba\7a\2\2\u00ba\u00bb\7k\2\2"+
		"\u00bb\u00bd\7g\2\2\u00bc\u00ac\3\2\2\2\u00bc\u00b0\3\2\2\2\u00bc\u00b4"+
		"\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bd&\3\2\2\2\u00be\u00bf\7J\2\2\u00bf\u00c0"+
		"\7a\2\2\u00c0\u00c1\7g\2\2\u00c1\u00cf\7g\2\2\u00c2\u00c3\7J\2\2\u00c3"+
		"\u00c4\7a\2\2\u00c4\u00c5\7g\2\2\u00c5\u00cf\7k\2\2\u00c6\u00c7\7J\2\2"+
		"\u00c7\u00c8\7a\2\2\u00c8\u00c9\7k\2\2\u00c9\u00cf\7k\2\2\u00ca\u00cb"+
		"\7J\2\2\u00cb\u00cc\7a\2\2\u00cc\u00cd\7k\2\2\u00cd\u00cf\7g\2\2\u00ce"+
		"\u00be\3\2\2\2\u00ce\u00c2\3\2\2\2\u00ce\u00c6\3\2\2\2\u00ce\u00ca\3\2"+
		"\2\2\u00cf(\3\2\2\2\u00d0\u00d1\7W\2\2\u00d1*\3\2\2\2\u00d2\u00d3\7U\2"+
		"\2\u00d3,\3\2\2\2\u00d4\u00d5\7T\2\2\u00d5.\3\2\2\2\u00d6\u00d7\7V\2\2"+
		"\u00d7\60\3\2\2\2\u00d8\u00d9\7E\2\2\u00d9\62\3\2\2\2\u00da\u00db\7s\2"+
		"\2\u00db\u00dc\7v\2\2\u00dc\u00ed\7n\2\2\u00dd\u00de\7o\2\2\u00de\u00df"+
		"\7k\2\2\u00df\u00e0\7v\2\2\u00e0\u00ed\7n\2\2\u00e1\u00e2\7s\2\2\u00e2"+
		"\u00e3\7v\2\2\u00e3\u00e4\7n\2\2\u00e4\u00e5\7/\2\2\u00e5\u00ed\7k\2\2"+
		"\u00e6\u00e7\7o\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7v\2\2\u00e9\u00ea"+
		"\7n\2\2\u00ea\u00eb\7/\2\2\u00eb\u00ed\7k\2\2\u00ec\u00da\3\2\2\2\u00ec"+
		"\u00dd\3\2\2\2\u00ec\u00e1\3\2\2\2\u00ec\u00e6\3\2\2\2\u00ed\64\3\2\2"+
		"\2\u00ee\u00ef\7<\2\2\u00ef\66\3\2\2\2\u00f0\u00f1\7=\2\2\u00f18\3\2\2"+
		"\2\u00f2\u00f4\4\62;\2\u00f3\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6:\3\2\2\2\u00f7\u00f8\4c|\2\u00f8<\3"+
		"\2\2\2\u00f9\u00ff\5;\36\2\u00fa\u00fe\5;\36\2\u00fb\u00fe\59\35\2\u00fc"+
		"\u00fe\7a\2\2\u00fd\u00fa\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2"+
		"\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		">\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0104\7\17\2\2\u0103\u0102\3\2\2\2"+
		"\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\7\f\2\2\u0106@\3"+
		"\2\2\2\u0107\u0109\t\2\2\2\u0108\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\b!"+
		"\2\2\u010dB\3\2\2\2\u010e\u0112\7%\2\2\u010f\u0111\n\3\2\2\u0110\u010f"+
		"\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116\b\"\3\2\u0116D\3\2\2\2"+
		"\21\2O\u0084\u008e\u00a0\u00aa\u00bc\u00ce\u00ec\u00f5\u00fd\u00ff\u0103"+
		"\u010a\u0112\4\3!\2\3\"\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}