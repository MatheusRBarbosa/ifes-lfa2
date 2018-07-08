package edu.ifes.lfa.calc;

import java.util.List;
import java.util.LinkedList;
import static edu.ifes.lfa.calc.data.CalcFactory.*;
import edu.ifes.lfa.calc.data.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAR=1, RPAR=2, LBRC=3, RBRC=4, PLUS=5, MINUS=6, TIMES=7, DIVIDE=8, EXP=9, 
		COMMA=10, SEMI=11, GETS=12, EQU=13, NEQ=14, GT=15, GEQ=16, LT=17, LEQ=18, 
		AND=19, OR=20, NOT=21, VERUM=22, FALSUM=23, IF=24, THEN=25, ELSIF=26, 
		ELSE=27, WHILE=28, DO=29, DEF=30, INTEGER=31, FLOAT=32, IDENT=33, STRING=34, 
		WS=35;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'('", "')'", "'{'", "'}'", "'+'", "'-'", "'*'", "'/'", "'^'", "','", 
		"';'", "'='", "'=='", "'!='", "'>'", "'>='", "'<'", "'<='", "'&&'", "'||'", 
		"'!'", "'true'", "'false'", "'if'", "'then'", "'elsif'", "'else'", "'while'", 
		"'do'", "'def'", "INTEGER", "FLOAT", "IDENT", "STRING", "WS"
	};
	public static final String[] ruleNames = {
		"LPAR", "RPAR", "LBRC", "RBRC", "PLUS", "MINUS", "TIMES", "DIVIDE", "EXP", 
		"COMMA", "SEMI", "GETS", "EQU", "NEQ", "GT", "GEQ", "LT", "LEQ", "AND", 
		"OR", "NOT", "VERUM", "FALSUM", "IF", "THEN", "ELSIF", "ELSE", "WHILE", 
		"DO", "DEF", "DIGIT", "INTEGER", "FLOAT", "IDENT", "STRING", "WS"
	};


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 35: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2%\u00ef\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3!\6!\u00aa\n!\r!\16"+
		"!\u00ab\3\"\6\"\u00af\n\"\r\"\16\"\u00b0\3\"\3\"\7\"\u00b5\n\"\f\"\16"+
		"\"\u00b8\13\"\3\"\3\"\3\"\5\"\u00bd\n\"\3\"\6\"\u00c0\n\"\r\"\16\"\u00c1"+
		"\5\"\u00c4\n\"\3\"\3\"\6\"\u00c8\n\"\r\"\16\"\u00c9\3\"\3\"\3\"\5\"\u00cf"+
		"\n\"\3\"\6\"\u00d2\n\"\r\"\16\"\u00d3\5\"\u00d6\n\"\5\"\u00d8\n\"\3#\3"+
		"#\7#\u00dc\n#\f#\16#\u00df\13#\3$\3$\3$\3$\7$\u00e5\n$\f$\16$\u00e8\13"+
		"$\3$\3$\3%\3%\3%\3%\2&\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21"+
		"\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1"+
		"%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\1"+
		"9\36\1;\37\1= \1?\2\1A!\1C\"\1E#\1G$\1I%\2\3\2\b\3\2\62;\4\2GGgg\5\2C"+
		"\\aac|\7\2))\62;C\\aac|\4\2$$^^\5\2\13\f\17\17\"\"\u00fb\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\3K\3\2\2\2\5"+
		"M\3\2\2\2\7O\3\2\2\2\tQ\3\2\2\2\13S\3\2\2\2\rU\3\2\2\2\17W\3\2\2\2\21"+
		"Y\3\2\2\2\23[\3\2\2\2\25]\3\2\2\2\27_\3\2\2\2\31a\3\2\2\2\33c\3\2\2\2"+
		"\35f\3\2\2\2\37i\3\2\2\2!k\3\2\2\2#n\3\2\2\2%p\3\2\2\2\'s\3\2\2\2)v\3"+
		"\2\2\2+y\3\2\2\2-{\3\2\2\2/\u0080\3\2\2\2\61\u0086\3\2\2\2\63\u0089\3"+
		"\2\2\2\65\u008e\3\2\2\2\67\u0094\3\2\2\29\u0099\3\2\2\2;\u009f\3\2\2\2"+
		"=\u00a2\3\2\2\2?\u00a6\3\2\2\2A\u00a9\3\2\2\2C\u00d7\3\2\2\2E\u00d9\3"+
		"\2\2\2G\u00e0\3\2\2\2I\u00eb\3\2\2\2KL\7*\2\2L\4\3\2\2\2MN\7+\2\2N\6\3"+
		"\2\2\2OP\7}\2\2P\b\3\2\2\2QR\7\177\2\2R\n\3\2\2\2ST\7-\2\2T\f\3\2\2\2"+
		"UV\7/\2\2V\16\3\2\2\2WX\7,\2\2X\20\3\2\2\2YZ\7\61\2\2Z\22\3\2\2\2[\\\7"+
		"`\2\2\\\24\3\2\2\2]^\7.\2\2^\26\3\2\2\2_`\7=\2\2`\30\3\2\2\2ab\7?\2\2"+
		"b\32\3\2\2\2cd\7?\2\2de\7?\2\2e\34\3\2\2\2fg\7#\2\2gh\7?\2\2h\36\3\2\2"+
		"\2ij\7@\2\2j \3\2\2\2kl\7@\2\2lm\7?\2\2m\"\3\2\2\2no\7>\2\2o$\3\2\2\2"+
		"pq\7>\2\2qr\7?\2\2r&\3\2\2\2st\7(\2\2tu\7(\2\2u(\3\2\2\2vw\7~\2\2wx\7"+
		"~\2\2x*\3\2\2\2yz\7#\2\2z,\3\2\2\2{|\7v\2\2|}\7t\2\2}~\7w\2\2~\177\7g"+
		"\2\2\177.\3\2\2\2\u0080\u0081\7h\2\2\u0081\u0082\7c\2\2\u0082\u0083\7"+
		"n\2\2\u0083\u0084\7u\2\2\u0084\u0085\7g\2\2\u0085\60\3\2\2\2\u0086\u0087"+
		"\7k\2\2\u0087\u0088\7h\2\2\u0088\62\3\2\2\2\u0089\u008a\7v\2\2\u008a\u008b"+
		"\7j\2\2\u008b\u008c\7g\2\2\u008c\u008d\7p\2\2\u008d\64\3\2\2\2\u008e\u008f"+
		"\7g\2\2\u008f\u0090\7n\2\2\u0090\u0091\7u\2\2\u0091\u0092\7k\2\2\u0092"+
		"\u0093\7h\2\2\u0093\66\3\2\2\2\u0094\u0095\7g\2\2\u0095\u0096\7n\2\2\u0096"+
		"\u0097\7u\2\2\u0097\u0098\7g\2\2\u00988\3\2\2\2\u0099\u009a\7y\2\2\u009a"+
		"\u009b\7j\2\2\u009b\u009c\7k\2\2\u009c\u009d\7n\2\2\u009d\u009e\7g\2\2"+
		"\u009e:\3\2\2\2\u009f\u00a0\7f\2\2\u00a0\u00a1\7q\2\2\u00a1<\3\2\2\2\u00a2"+
		"\u00a3\7f\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7h\2\2\u00a5>\3\2\2\2\u00a6"+
		"\u00a7\t\2\2\2\u00a7@\3\2\2\2\u00a8\u00aa\5? \2\u00a9\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00acB\3\2\2\2"+
		"\u00ad\u00af\5? \2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b6\7\60\2\2"+
		"\u00b3\u00b5\5? \2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00c3\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9"+
		"\u00bc\t\3\2\2\u00ba\u00bd\5\13\6\2\u00bb\u00bd\5\r\7\2\u00bc\u00ba\3"+
		"\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00c0\5? \2\u00bf"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00b9\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00d8\3\2\2\2\u00c5\u00c7\7\60\2\2\u00c6\u00c8\5? \2\u00c7\u00c6\3\2"+
		"\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00d5\3\2\2\2\u00cb\u00ce\t\3\2\2\u00cc\u00cf\5\13\6\2\u00cd\u00cf\5"+
		"\r\7\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0"+
		"\u00d2\5? \2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2\2"+
		"\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00cb\3\2\2\2\u00d5\u00d6"+
		"\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00ae\3\2\2\2\u00d7\u00c5\3\2\2\2\u00d8"+
		"D\3\2\2\2\u00d9\u00dd\t\4\2\2\u00da\u00dc\t\5\2\2\u00db\u00da\3\2\2\2"+
		"\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00deF\3"+
		"\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e6\7$\2\2\u00e1\u00e2\7^\2\2\u00e2"+
		"\u00e5\13\2\2\2\u00e3\u00e5\n\6\2\2\u00e4\u00e1\3\2\2\2\u00e4\u00e3\3"+
		"\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7$\2\2\u00eaH\3\2\2\2\u00eb"+
		"\u00ec\t\7\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\b%\2\2\u00eeJ\3\2\2\2\21"+
		"\2\u00ab\u00b0\u00b6\u00bc\u00c1\u00c3\u00c9\u00ce\u00d3\u00d5\u00d7\u00dd"+
		"\u00e4\u00e6";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}