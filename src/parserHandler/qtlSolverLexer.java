// $ANTLR 3.5 qtlSolver.g 2013-04-26 15:58:09
 package parserHandler; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class qtlSolverLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int AND_OP=4;
	public static final int ATOM=5;
	public static final int COLON=6;
	public static final int F_OP=7;
	public static final int F_inf_OP=8;
	public static final int G_OP=9;
	public static final int G_inf_OP=10;
	public static final int H_OP=11;
	public static final int ID=12;
	public static final int IFF_OP=13;
	public static final int IMPL_OP=14;
	public static final int INT=15;
	public static final int LBRA=16;
	public static final int LOGIC=17;
	public static final int LPAR=18;
	public static final int NEG_OP=19;
	public static final int NEWLINE=20;
	public static final int OR_OP=21;
	public static final int P_OP=22;
	public static final int RBRA=23;
	public static final int RELEASE_OP=24;
	public static final int RPAR=25;
	public static final int SEMI=26;
	public static final int SINCE_OP=27;
	public static final int TRIGGER_OP=28;
	public static final int UNTIL_OP=29;
	public static final int WS=30;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public qtlSolverLexer() {} 
	public qtlSolverLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public qtlSolverLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "qtlSolver.g"; }

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:4:7: ( ':bound' )
			// qtlSolver.g:4:9: ':bound'
			{
			match(":bound"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:5:7: ( ':def' )
			// qtlSolver.g:5:9: ':def'
			{
			match(":def"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:6:7: ( ':formula' )
			// qtlSolver.g:6:9: ':formula'
			{
			match(":formula"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__33"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:404:5: ( '(' )
			// qtlSolver.g:404:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAR"

	// $ANTLR start "RPAR"
	public final void mRPAR() throws RecognitionException {
		try {
			int _type = RPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:405:5: ( ')' )
			// qtlSolver.g:405:7: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAR"

	// $ANTLR start "LBRA"
	public final void mLBRA() throws RecognitionException {
		try {
			int _type = LBRA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:406:5: ( '[' )
			// qtlSolver.g:406:7: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LBRA"

	// $ANTLR start "RBRA"
	public final void mRBRA() throws RecognitionException {
		try {
			int _type = RBRA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:407:5: ( ']' )
			// qtlSolver.g:407:7: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RBRA"

	// $ANTLR start "NEG_OP"
	public final void mNEG_OP() throws RecognitionException {
		try {
			int _type = NEG_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:412:7: ( '!!' )
			// qtlSolver.g:412:9: '!!'
			{
			match("!!"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEG_OP"

	// $ANTLR start "AND_OP"
	public final void mAND_OP() throws RecognitionException {
		try {
			int _type = AND_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:413:7: ( '&&' )
			// qtlSolver.g:413:9: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND_OP"

	// $ANTLR start "OR_OP"
	public final void mOR_OP() throws RecognitionException {
		try {
			int _type = OR_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:414:6: ( '||' )
			// qtlSolver.g:414:8: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR_OP"

	// $ANTLR start "IMPL_OP"
	public final void mIMPL_OP() throws RecognitionException {
		try {
			int _type = IMPL_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:415:8: ( '->' )
			// qtlSolver.g:415:10: '->'
			{
			match("->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMPL_OP"

	// $ANTLR start "IFF_OP"
	public final void mIFF_OP() throws RecognitionException {
		try {
			int _type = IFF_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:416:7: ( '<->' )
			// qtlSolver.g:416:9: '<->'
			{
			match("<->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IFF_OP"

	// $ANTLR start "F_OP"
	public final void mF_OP() throws RecognitionException {
		try {
			int _type = F_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:420:5: ( 'F_ee' | 'F_ei' | 'F_ii' | 'F_ie' )
			int alt1=4;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='F') ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1=='_') ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2=='e') ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3=='e') ) {
							alt1=1;
						}
						else if ( (LA1_3=='i') ) {
							alt1=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 1, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA1_2=='i') ) {
						int LA1_4 = input.LA(4);
						if ( (LA1_4=='i') ) {
							alt1=3;
						}
						else if ( (LA1_4=='e') ) {
							alt1=4;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 1, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// qtlSolver.g:420:9: 'F_ee'
					{
					match("F_ee"); 

					}
					break;
				case 2 :
					// qtlSolver.g:420:18: 'F_ei'
					{
					match("F_ei"); 

					}
					break;
				case 3 :
					// qtlSolver.g:420:27: 'F_ii'
					{
					match("F_ii"); 

					}
					break;
				case 4 :
					// qtlSolver.g:420:36: 'F_ie'
					{
					match("F_ie"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "F_OP"

	// $ANTLR start "F_inf_OP"
	public final void mF_inf_OP() throws RecognitionException {
		try {
			int _type = F_inf_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:421:9: ( 'F_e+' | 'F_i+' )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='F') ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1=='_') ) {
					int LA2_2 = input.LA(3);
					if ( (LA2_2=='e') ) {
						alt2=1;
					}
					else if ( (LA2_2=='i') ) {
						alt2=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// qtlSolver.g:421:12: 'F_e+'
					{
					match("F_e+"); 

					}
					break;
				case 2 :
					// qtlSolver.g:421:21: 'F_i+'
					{
					match("F_i+"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "F_inf_OP"

	// $ANTLR start "G_OP"
	public final void mG_OP() throws RecognitionException {
		try {
			int _type = G_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:423:5: ( 'G_ee' | 'G_ei' | 'G_ii' | 'G_ie' )
			int alt3=4;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='G') ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1=='_') ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2=='e') ) {
						int LA3_3 = input.LA(4);
						if ( (LA3_3=='e') ) {
							alt3=1;
						}
						else if ( (LA3_3=='i') ) {
							alt3=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 3, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA3_2=='i') ) {
						int LA3_4 = input.LA(4);
						if ( (LA3_4=='i') ) {
							alt3=3;
						}
						else if ( (LA3_4=='e') ) {
							alt3=4;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 3, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 3, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// qtlSolver.g:423:9: 'G_ee'
					{
					match("G_ee"); 

					}
					break;
				case 2 :
					// qtlSolver.g:423:18: 'G_ei'
					{
					match("G_ei"); 

					}
					break;
				case 3 :
					// qtlSolver.g:423:27: 'G_ii'
					{
					match("G_ii"); 

					}
					break;
				case 4 :
					// qtlSolver.g:423:36: 'G_ie'
					{
					match("G_ie"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "G_OP"

	// $ANTLR start "G_inf_OP"
	public final void mG_inf_OP() throws RecognitionException {
		try {
			int _type = G_inf_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:424:9: ( 'G_e+' | 'G_i+' )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='G') ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1=='_') ) {
					int LA4_2 = input.LA(3);
					if ( (LA4_2=='e') ) {
						alt4=1;
					}
					else if ( (LA4_2=='i') ) {
						alt4=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// qtlSolver.g:424:12: 'G_e+'
					{
					match("G_e+"); 

					}
					break;
				case 2 :
					// qtlSolver.g:424:21: 'G_i+'
					{
					match("G_i+"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "G_inf_OP"

	// $ANTLR start "P_OP"
	public final void mP_OP() throws RecognitionException {
		try {
			int _type = P_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:427:5: ( 'P' )
			// qtlSolver.g:427:9: 'P'
			{
			match('P'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "P_OP"

	// $ANTLR start "H_OP"
	public final void mH_OP() throws RecognitionException {
		try {
			int _type = H_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:428:5: ( 'H' )
			// qtlSolver.g:428:9: 'H'
			{
			match('H'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "H_OP"

	// $ANTLR start "UNTIL_OP"
	public final void mUNTIL_OP() throws RecognitionException {
		try {
			int _type = UNTIL_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:429:9: ( 'U' )
			// qtlSolver.g:429:11: 'U'
			{
			match('U'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNTIL_OP"

	// $ANTLR start "SINCE_OP"
	public final void mSINCE_OP() throws RecognitionException {
		try {
			int _type = SINCE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:430:9: ( 'S' )
			// qtlSolver.g:430:11: 'S'
			{
			match('S'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SINCE_OP"

	// $ANTLR start "RELEASE_OP"
	public final void mRELEASE_OP() throws RecognitionException {
		try {
			int _type = RELEASE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:431:11: ( 'R' )
			// qtlSolver.g:431:13: 'R'
			{
			match('R'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RELEASE_OP"

	// $ANTLR start "TRIGGER_OP"
	public final void mTRIGGER_OP() throws RecognitionException {
		try {
			int _type = TRIGGER_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:432:11: ( 'T' )
			// qtlSolver.g:432:13: 'T'
			{
			match('T'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRIGGER_OP"

	// $ANTLR start "LOGIC"
	public final void mLOGIC() throws RecognitionException {
		try {
			int _type = LOGIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:435:8: ( 'qtl' | 'mitl' | 'qtl-i' | 'mitl-i' )
			int alt5=4;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='q') ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1=='t') ) {
					int LA5_3 = input.LA(3);
					if ( (LA5_3=='l') ) {
						int LA5_5 = input.LA(4);
						if ( (LA5_5=='-') ) {
							alt5=3;
						}

						else {
							alt5=1;
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 5, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA5_0=='m') ) {
				int LA5_2 = input.LA(2);
				if ( (LA5_2=='i') ) {
					int LA5_4 = input.LA(3);
					if ( (LA5_4=='t') ) {
						int LA5_6 = input.LA(4);
						if ( (LA5_6=='l') ) {
							int LA5_9 = input.LA(5);
							if ( (LA5_9=='-') ) {
								alt5=4;
							}

							else {
								alt5=2;
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 5, 6, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 5, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// qtlSolver.g:435:12: 'qtl'
					{
					match("qtl"); 

					}
					break;
				case 2 :
					// qtlSolver.g:435:18: 'mitl'
					{
					match("mitl"); 

					}
					break;
				case 3 :
					// qtlSolver.g:435:25: 'qtl-i'
					{
					match("qtl-i"); 

					}
					break;
				case 4 :
					// qtlSolver.g:435:33: 'mitl-i'
					{
					match("mitl-i"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOGIC"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:437:6: ( ':' )
			// qtlSolver.g:437:8: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:438:5: ( ';' )
			// qtlSolver.g:438:7: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "ATOM"
	public final void mATOM() throws RecognitionException {
		try {
			int _type = ATOM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:439:7: ( ( 'a' .. 'z' )+ )
			// qtlSolver.g:439:11: ( 'a' .. 'z' )+
			{
			// qtlSolver.g:439:11: ( 'a' .. 'z' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// qtlSolver.g:
					{
					if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ATOM"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:440:5: ( ( '0' .. '9' )+ )
			// qtlSolver.g:440:9: ( '0' .. '9' )+
			{
			// qtlSolver.g:440:9: ( '0' .. '9' )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// qtlSolver.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:441:3: ( ATOM ( ATOM | INT )* )
			// qtlSolver.g:441:6: ATOM ( ATOM | INT )*
			{
			mATOM(); 

			// qtlSolver.g:441:10: ( ATOM | INT )*
			loop8:
			while (true) {
				int alt8=3;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}
				else if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
					alt8=2;
				}

				switch (alt8) {
				case 1 :
					// qtlSolver.g:441:11: ATOM
					{
					mATOM(); 

					}
					break;
				case 2 :
					// qtlSolver.g:441:18: INT
					{
					mINT(); 

					}
					break;

				default :
					break loop8;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:442:8: ( ( '\\r' )? '\\n' )
			// qtlSolver.g:442:9: ( '\\r' )? '\\n'
			{
			// qtlSolver.g:442:9: ( '\\r' )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='\r') ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// qtlSolver.g:442:9: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:443:5: ( ( ' ' | '\\t' )+ )
			// qtlSolver.g:443:9: ( ' ' | '\\t' )+
			{
			// qtlSolver.g:443:9: ( ' ' | '\\t' )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0=='\t'||LA10_0==' ') ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// qtlSolver.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// qtlSolver.g:1:8: ( T__31 | T__32 | T__33 | LPAR | RPAR | LBRA | RBRA | NEG_OP | AND_OP | OR_OP | IMPL_OP | IFF_OP | F_OP | F_inf_OP | G_OP | G_inf_OP | P_OP | H_OP | UNTIL_OP | SINCE_OP | RELEASE_OP | TRIGGER_OP | LOGIC | COLON | SEMI | ATOM | INT | ID | NEWLINE | WS )
		int alt11=30;
		alt11 = dfa11.predict(input);
		switch (alt11) {
			case 1 :
				// qtlSolver.g:1:10: T__31
				{
				mT__31(); 

				}
				break;
			case 2 :
				// qtlSolver.g:1:16: T__32
				{
				mT__32(); 

				}
				break;
			case 3 :
				// qtlSolver.g:1:22: T__33
				{
				mT__33(); 

				}
				break;
			case 4 :
				// qtlSolver.g:1:28: LPAR
				{
				mLPAR(); 

				}
				break;
			case 5 :
				// qtlSolver.g:1:33: RPAR
				{
				mRPAR(); 

				}
				break;
			case 6 :
				// qtlSolver.g:1:38: LBRA
				{
				mLBRA(); 

				}
				break;
			case 7 :
				// qtlSolver.g:1:43: RBRA
				{
				mRBRA(); 

				}
				break;
			case 8 :
				// qtlSolver.g:1:48: NEG_OP
				{
				mNEG_OP(); 

				}
				break;
			case 9 :
				// qtlSolver.g:1:55: AND_OP
				{
				mAND_OP(); 

				}
				break;
			case 10 :
				// qtlSolver.g:1:62: OR_OP
				{
				mOR_OP(); 

				}
				break;
			case 11 :
				// qtlSolver.g:1:68: IMPL_OP
				{
				mIMPL_OP(); 

				}
				break;
			case 12 :
				// qtlSolver.g:1:76: IFF_OP
				{
				mIFF_OP(); 

				}
				break;
			case 13 :
				// qtlSolver.g:1:83: F_OP
				{
				mF_OP(); 

				}
				break;
			case 14 :
				// qtlSolver.g:1:88: F_inf_OP
				{
				mF_inf_OP(); 

				}
				break;
			case 15 :
				// qtlSolver.g:1:97: G_OP
				{
				mG_OP(); 

				}
				break;
			case 16 :
				// qtlSolver.g:1:102: G_inf_OP
				{
				mG_inf_OP(); 

				}
				break;
			case 17 :
				// qtlSolver.g:1:111: P_OP
				{
				mP_OP(); 

				}
				break;
			case 18 :
				// qtlSolver.g:1:116: H_OP
				{
				mH_OP(); 

				}
				break;
			case 19 :
				// qtlSolver.g:1:121: UNTIL_OP
				{
				mUNTIL_OP(); 

				}
				break;
			case 20 :
				// qtlSolver.g:1:130: SINCE_OP
				{
				mSINCE_OP(); 

				}
				break;
			case 21 :
				// qtlSolver.g:1:139: RELEASE_OP
				{
				mRELEASE_OP(); 

				}
				break;
			case 22 :
				// qtlSolver.g:1:150: TRIGGER_OP
				{
				mTRIGGER_OP(); 

				}
				break;
			case 23 :
				// qtlSolver.g:1:161: LOGIC
				{
				mLOGIC(); 

				}
				break;
			case 24 :
				// qtlSolver.g:1:167: COLON
				{
				mCOLON(); 

				}
				break;
			case 25 :
				// qtlSolver.g:1:173: SEMI
				{
				mSEMI(); 

				}
				break;
			case 26 :
				// qtlSolver.g:1:178: ATOM
				{
				mATOM(); 

				}
				break;
			case 27 :
				// qtlSolver.g:1:183: INT
				{
				mINT(); 

				}
				break;
			case 28 :
				// qtlSolver.g:1:187: ID
				{
				mID(); 

				}
				break;
			case 29 :
				// qtlSolver.g:1:190: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 30 :
				// qtlSolver.g:1:198: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA11 dfa11 = new DFA11(this);
	static final String DFA11_eotS =
		"\1\uffff\1\35\21\uffff\2\41\1\uffff\1\41\11\uffff\1\41\1\uffff\1\41\1"+
		"\uffff\1\41\4\uffff\1\57\1\41\5\uffff\1\57";
	static final String DFA11_eofS =
		"\61\uffff";
	static final String DFA11_minS =
		"\1\11\1\142\11\uffff\2\137\6\uffff\2\60\1\uffff\1\60\7\uffff\2\145\1\60"+
		"\1\uffff\1\60\1\uffff\1\60\4\53\2\60\5\uffff\1\60";
	static final String DFA11_maxS =
		"\1\174\1\146\11\uffff\2\137\6\uffff\2\172\1\uffff\1\172\7\uffff\2\151"+
		"\1\172\1\uffff\1\172\1\uffff\1\172\4\151\2\172\5\uffff\1\172";
	static final String DFA11_acceptS =
		"\2\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\2\uffff\1\21\1\22\1"+
		"\23\1\24\1\25\1\26\2\uffff\1\31\1\uffff\1\33\1\35\1\36\1\1\1\2\1\3\1\30"+
		"\3\uffff\1\32\1\uffff\1\34\7\uffff\1\15\1\16\1\17\1\20\1\27\1\uffff";
	static final String DFA11_specialS =
		"\61\uffff}>";
	static final String[] DFA11_transitionS = {
			"\1\31\1\30\2\uffff\1\30\22\uffff\1\31\1\6\4\uffff\1\7\1\uffff\1\2\1\3"+
			"\3\uffff\1\11\2\uffff\12\27\1\1\1\25\1\12\11\uffff\1\13\1\14\1\16\7\uffff"+
			"\1\15\1\uffff\1\21\1\20\1\22\1\17\5\uffff\1\4\1\uffff\1\5\3\uffff\14"+
			"\26\1\24\3\26\1\23\11\26\1\uffff\1\10",
			"\1\32\1\uffff\1\33\1\uffff\1\34",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\36",
			"\1\37",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\43\47\uffff\23\42\1\40\6\42",
			"\12\43\47\uffff\10\42\1\44\21\42",
			"",
			"\12\43\47\uffff\32\42",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\45\3\uffff\1\46",
			"\1\47\3\uffff\1\50",
			"\12\43\47\uffff\13\42\1\51\16\42",
			"",
			"\12\43\47\uffff\32\42",
			"",
			"\12\43\47\uffff\23\42\1\52\6\42",
			"\1\54\71\uffff\1\53\3\uffff\1\53",
			"\1\54\71\uffff\1\53\3\uffff\1\53",
			"\1\56\71\uffff\1\55\3\uffff\1\55",
			"\1\56\71\uffff\1\55\3\uffff\1\55",
			"\12\43\47\uffff\32\42",
			"\12\43\47\uffff\13\42\1\60\16\42",
			"",
			"",
			"",
			"",
			"",
			"\12\43\47\uffff\32\42"
	};

	static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
	static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
	static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
	static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
	static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
	static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
	static final short[][] DFA11_transition;

	static {
		int numStates = DFA11_transitionS.length;
		DFA11_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
		}
	}

	protected class DFA11 extends DFA {

		public DFA11(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 11;
			this.eot = DFA11_eot;
			this.eof = DFA11_eof;
			this.min = DFA11_min;
			this.max = DFA11_max;
			this.accept = DFA11_accept;
			this.special = DFA11_special;
			this.transition = DFA11_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__31 | T__32 | T__33 | LPAR | RPAR | LBRA | RBRA | NEG_OP | AND_OP | OR_OP | IMPL_OP | IFF_OP | F_OP | F_inf_OP | G_OP | G_inf_OP | P_OP | H_OP | UNTIL_OP | SINCE_OP | RELEASE_OP | TRIGGER_OP | LOGIC | COLON | SEMI | ATOM | INT | ID | NEWLINE | WS );";
		}
	}

}
