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
		T__0=1, LPAR=2, RPAR=3, LBRA=4, RBRA=5, TRUE=6, FALSE=7, NEG_OP=8, AND_OP=9, 
		OR_OP=10, IMPL_OP=11, IFF_OP=12, F_OP=13, F_inf_OP=14, G_OP=15, G_inf_OP=16, 
		P_OP=17, H_OP=18, UNTIL_OP=19, SINCE_OP=20, RELEASE_OP=21, TRIGGER_OP=22, 
		COUNT_OP=23, LOGIC=24, COLON=25, SEMI=26, INT=27, ID=28, NEWLINE=29, WS=30, 
		COMMENT=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "LPAR", "RPAR", "LBRA", "RBRA", "TRUE", "FALSE", "NEG_OP", "AND_OP", 
		"OR_OP", "IMPL_OP", "IFF_OP", "F_OP", "F_inf_OP", "G_OP", "G_inf_OP", 
		"P_OP", "H_OP", "UNTIL_OP", "SINCE_OP", "RELEASE_OP", "TRIGGER_OP", "COUNT_OP", 
		"LOGIC", "COLON", "SEMI", "INT", "ATOM", "ID", "NEWLINE", "WS", "COMMENT"
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
		case 30:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 31:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u010e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16|\n\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u0086\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0098\n\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00a2\n\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00b4\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u00c6\n\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u00e4\n\31\3\32\3\32\3\33\3\33\3\34\6\34"+
		"\u00eb\n\34\r\34\16\34\u00ec\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00f5"+
		"\n\36\f\36\16\36\u00f8\13\36\3\37\5\37\u00fb\n\37\3\37\3\37\3 \6 \u0100"+
		"\n \r \16 \u0101\3 \3 \3!\3!\7!\u0108\n!\f!\16!\u010b\13!\3!\3!\2\2\""+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\2;\36"+
		"=\37? A!\3\2\4\4\2\13\13\"\"\4\2\f\f\17\17\u0124\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\3C\3\2\2\2\5H\3\2\2\2\7J\3\2\2\2\tL\3\2\2\2\13N\3\2\2\2\rP\3\2"+
		"\2\2\17U\3\2\2\2\21[\3\2\2\2\23^\3\2\2\2\25a\3\2\2\2\27d\3\2\2\2\31g\3"+
		"\2\2\2\33{\3\2\2\2\35\u0085\3\2\2\2\37\u0097\3\2\2\2!\u00a1\3\2\2\2#\u00b3"+
		"\3\2\2\2%\u00c5\3\2\2\2\'\u00c7\3\2\2\2)\u00c9\3\2\2\2+\u00cb\3\2\2\2"+
		"-\u00cd\3\2\2\2/\u00cf\3\2\2\2\61\u00e3\3\2\2\2\63\u00e5\3\2\2\2\65\u00e7"+
		"\3\2\2\2\67\u00ea\3\2\2\29\u00ee\3\2\2\2;\u00f0\3\2\2\2=\u00fa\3\2\2\2"+
		"?\u00ff\3\2\2\2A\u0105\3\2\2\2CD\7<\2\2DE\7f\2\2EF\7g\2\2FG\7h\2\2G\4"+
		"\3\2\2\2HI\7*\2\2I\6\3\2\2\2JK\7+\2\2K\b\3\2\2\2LM\7]\2\2M\n\3\2\2\2N"+
		"O\7_\2\2O\f\3\2\2\2PQ\7v\2\2QR\7t\2\2RS\7w\2\2ST\7g\2\2T\16\3\2\2\2UV"+
		"\7h\2\2VW\7c\2\2WX\7n\2\2XY\7u\2\2YZ\7g\2\2Z\20\3\2\2\2[\\\7#\2\2\\]\7"+
		"#\2\2]\22\3\2\2\2^_\7(\2\2_`\7(\2\2`\24\3\2\2\2ab\7~\2\2bc\7~\2\2c\26"+
		"\3\2\2\2de\7/\2\2ef\7@\2\2f\30\3\2\2\2gh\7>\2\2hi\7/\2\2ij\7@\2\2j\32"+
		"\3\2\2\2kl\7H\2\2lm\7a\2\2mn\7g\2\2n|\7g\2\2op\7H\2\2pq\7a\2\2qr\7g\2"+
		"\2r|\7k\2\2st\7H\2\2tu\7a\2\2uv\7k\2\2v|\7k\2\2wx\7H\2\2xy\7a\2\2yz\7"+
		"k\2\2z|\7g\2\2{k\3\2\2\2{o\3\2\2\2{s\3\2\2\2{w\3\2\2\2|\34\3\2\2\2}~\7"+
		"H\2\2~\177\7a\2\2\177\u0080\7g\2\2\u0080\u0086\7-\2\2\u0081\u0082\7H\2"+
		"\2\u0082\u0083\7a\2\2\u0083\u0084\7k\2\2\u0084\u0086\7-\2\2\u0085}\3\2"+
		"\2\2\u0085\u0081\3\2\2\2\u0086\36\3\2\2\2\u0087\u0088\7I\2\2\u0088\u0089"+
		"\7a\2\2\u0089\u008a\7g\2\2\u008a\u0098\7g\2\2\u008b\u008c\7I\2\2\u008c"+
		"\u008d\7a\2\2\u008d\u008e\7g\2\2\u008e\u0098\7k\2\2\u008f\u0090\7I\2\2"+
		"\u0090\u0091\7a\2\2\u0091\u0092\7k\2\2\u0092\u0098\7k\2\2\u0093\u0094"+
		"\7I\2\2\u0094\u0095\7a\2\2\u0095\u0096\7k\2\2\u0096\u0098\7g\2\2\u0097"+
		"\u0087\3\2\2\2\u0097\u008b\3\2\2\2\u0097\u008f\3\2\2\2\u0097\u0093\3\2"+
		"\2\2\u0098 \3\2\2\2\u0099\u009a\7I\2\2\u009a\u009b\7a\2\2\u009b\u009c"+
		"\7g\2\2\u009c\u00a2\7-\2\2\u009d\u009e\7I\2\2\u009e\u009f\7a\2\2\u009f"+
		"\u00a0\7k\2\2\u00a0\u00a2\7-\2\2\u00a1\u0099\3\2\2\2\u00a1\u009d\3\2\2"+
		"\2\u00a2\"\3\2\2\2\u00a3\u00a4\7R\2\2\u00a4\u00a5\7a\2\2\u00a5\u00a6\7"+
		"g\2\2\u00a6\u00b4\7g\2\2\u00a7\u00a8\7R\2\2\u00a8\u00a9\7a\2\2\u00a9\u00aa"+
		"\7g\2\2\u00aa\u00b4\7k\2\2\u00ab\u00ac\7R\2\2\u00ac\u00ad\7a\2\2\u00ad"+
		"\u00ae\7k\2\2\u00ae\u00b4\7k\2\2\u00af\u00b0\7R\2\2\u00b0\u00b1\7a\2\2"+
		"\u00b1\u00b2\7k\2\2\u00b2\u00b4\7g\2\2\u00b3\u00a3\3\2\2\2\u00b3\u00a7"+
		"\3\2\2\2\u00b3\u00ab\3\2\2\2\u00b3\u00af\3\2\2\2\u00b4$\3\2\2\2\u00b5"+
		"\u00b6\7J\2\2\u00b6\u00b7\7a\2\2\u00b7\u00b8\7g\2\2\u00b8\u00c6\7g\2\2"+
		"\u00b9\u00ba\7J\2\2\u00ba\u00bb\7a\2\2\u00bb\u00bc\7g\2\2\u00bc\u00c6"+
		"\7k\2\2\u00bd\u00be\7J\2\2\u00be\u00bf\7a\2\2\u00bf\u00c0\7k\2\2\u00c0"+
		"\u00c6\7k\2\2\u00c1\u00c2\7J\2\2\u00c2\u00c3\7a\2\2\u00c3\u00c4\7k\2\2"+
		"\u00c4\u00c6\7g\2\2\u00c5\u00b5\3\2\2\2\u00c5\u00b9\3\2\2\2\u00c5\u00bd"+
		"\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c6&\3\2\2\2\u00c7\u00c8\7W\2\2\u00c8("+
		"\3\2\2\2\u00c9\u00ca\7U\2\2\u00ca*\3\2\2\2\u00cb\u00cc\7T\2\2\u00cc,\3"+
		"\2\2\2\u00cd\u00ce\7V\2\2\u00ce.\3\2\2\2\u00cf\u00d0\7E\2\2\u00d0\60\3"+
		"\2\2\2\u00d1\u00d2\7s\2\2\u00d2\u00d3\7v\2\2\u00d3\u00e4\7n\2\2\u00d4"+
		"\u00d5\7o\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7v\2\2\u00d7\u00e4\7n\2\2"+
		"\u00d8\u00d9\7s\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7n\2\2\u00db\u00dc"+
		"\7/\2\2\u00dc\u00e4\7k\2\2\u00dd\u00de\7o\2\2\u00de\u00df\7k\2\2\u00df"+
		"\u00e0\7v\2\2\u00e0\u00e1\7n\2\2\u00e1\u00e2\7/\2\2\u00e2\u00e4\7k\2\2"+
		"\u00e3\u00d1\3\2\2\2\u00e3\u00d4\3\2\2\2\u00e3\u00d8\3\2\2\2\u00e3\u00dd"+
		"\3\2\2\2\u00e4\62\3\2\2\2\u00e5\u00e6\7<\2\2\u00e6\64\3\2\2\2\u00e7\u00e8"+
		"\7=\2\2\u00e8\66\3\2\2\2\u00e9\u00eb\4\62;\2\u00ea\u00e9\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed8\3\2\2\2"+
		"\u00ee\u00ef\4c|\2\u00ef:\3\2\2\2\u00f0\u00f6\59\35\2\u00f1\u00f5\59\35"+
		"\2\u00f2\u00f5\5\67\34\2\u00f3\u00f5\7a\2\2\u00f4\u00f1\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f6\u00f7\3\2\2\2\u00f7<\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fb"+
		"\7\17\2\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2"+
		"\u00fc\u00fd\7\f\2\2\u00fd>\3\2\2\2\u00fe\u0100\t\2\2\2\u00ff\u00fe\3"+
		"\2\2\2\u0100\u0101\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0104\b \2\2\u0104@\3\2\2\2\u0105\u0109\7%\2\2\u0106"+
		"\u0108\n\3\2\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2"+
		"\2\2\u0109\u010a\3\2\2\2\u010a\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c"+
		"\u010d\b!\3\2\u010dB\3\2\2\2\20\2{\u0085\u0097\u00a1\u00b3\u00c5\u00e3"+
		"\u00ec\u00f4\u00f6\u00fa\u0101\u0109\4\3 \2\3!\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}