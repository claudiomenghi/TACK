// $ANTLR 3.5 qtlSolver.g 2013-05-04 11:15:29
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
			// qtlSolver.g:438:5: ( '(' )
			// qtlSolver.g:438:9: '('
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
			// qtlSolver.g:439:5: ( ')' )
			// qtlSolver.g:439:7: ')'
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
			// qtlSolver.g:440:5: ( '[' )
			// qtlSolver.g:440:7: '['
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
			// qtlSolver.g:441:5: ( ']' )
			// qtlSolver.g:441:7: ']'
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
			// qtlSolver.g:446:7: ( '!!' )
			// qtlSolver.g:446:9: '!!'
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
			// qtlSolver.g:447:7: ( '&&' )
			// qtlSolver.g:447:9: '&&'
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
			// qtlSolver.g:448:6: ( '||' )
			// qtlSolver.g:448:8: '||'
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
			// qtlSolver.g:449:8: ( '->' )
			// qtlSolver.g:449:10: '->'
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
			// qtlSolver.g:450:7: ( '<->' )
			// qtlSolver.g:450:9: '<->'
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
			// qtlSolver.g:454:5: ( 'F_ee' | 'F_ei' | 'F_ii' | 'F_ie' )
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
					// qtlSolver.g:454:9: 'F_ee'
					{
					match("F_ee"); 

					}
					break;
				case 2 :
					// qtlSolver.g:454:18: 'F_ei'
					{
					match("F_ei"); 

					}
					break;
				case 3 :
					// qtlSolver.g:454:27: 'F_ii'
					{
					match("F_ii"); 

					}
					break;
				case 4 :
					// qtlSolver.g:454:36: 'F_ie'
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
			// qtlSolver.g:455:9: ( 'F_e+' | 'F_i+' )
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
					// qtlSolver.g:455:12: 'F_e+'
					{
					match("F_e+"); 

					}
					break;
				case 2 :
					// qtlSolver.g:455:21: 'F_i+'
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
			// qtlSolver.g:457:5: ( 'G_ee' | 'G_ei' | 'G_ii' | 'G_ie' )
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
					// qtlSolver.g:457:9: 'G_ee'
					{
					match("G_ee"); 

					}
					break;
				case 2 :
					// qtlSolver.g:457:18: 'G_ei'
					{
					match("G_ei"); 

					}
					break;
				case 3 :
					// qtlSolver.g:457:27: 'G_ii'
					{
					match("G_ii"); 

					}
					break;
				case 4 :
					// qtlSolver.g:457:36: 'G_ie'
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
			// qtlSolver.g:458:9: ( 'G_e+' | 'G_i+' )
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
					// qtlSolver.g:458:12: 'G_e+'
					{
					match("G_e+"); 

					}
					break;
				case 2 :
					// qtlSolver.g:458:21: 'G_i+'
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
			// qtlSolver.g:461:5: ( 'P_ee' | 'P_ei' | 'P_ii' | 'P_ie' )
			int alt5=4;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='P') ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1=='_') ) {
					int LA5_2 = input.LA(3);
					if ( (LA5_2=='e') ) {
						int LA5_3 = input.LA(4);
						if ( (LA5_3=='e') ) {
							alt5=1;
						}
						else if ( (LA5_3=='i') ) {
							alt5=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
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
					else if ( (LA5_2=='i') ) {
						int LA5_4 = input.LA(4);
						if ( (LA5_4=='i') ) {
							alt5=3;
						}
						else if ( (LA5_4=='e') ) {
							alt5=4;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
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
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 5, 2, input);
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

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// qtlSolver.g:461:9: 'P_ee'
					{
					match("P_ee"); 

					}
					break;
				case 2 :
					// qtlSolver.g:461:18: 'P_ei'
					{
					match("P_ei"); 

					}
					break;
				case 3 :
					// qtlSolver.g:461:27: 'P_ii'
					{
					match("P_ii"); 

					}
					break;
				case 4 :
					// qtlSolver.g:461:36: 'P_ie'
					{
					match("P_ie"); 

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
	// $ANTLR end "P_OP"

	// $ANTLR start "H_OP"
	public final void mH_OP() throws RecognitionException {
		try {
			int _type = H_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:462:5: ( 'H_ee' | 'H_ei' | 'H_ii' | 'H_ie' )
			int alt6=4;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='H') ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1=='_') ) {
					int LA6_2 = input.LA(3);
					if ( (LA6_2=='e') ) {
						int LA6_3 = input.LA(4);
						if ( (LA6_3=='e') ) {
							alt6=1;
						}
						else if ( (LA6_3=='i') ) {
							alt6=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA6_2=='i') ) {
						int LA6_4 = input.LA(4);
						if ( (LA6_4=='i') ) {
							alt6=3;
						}
						else if ( (LA6_4=='e') ) {
							alt6=4;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 4, input);
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
								new NoViableAltException("", 6, 2, input);
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
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// qtlSolver.g:462:9: 'H_ee'
					{
					match("H_ee"); 

					}
					break;
				case 2 :
					// qtlSolver.g:462:18: 'H_ei'
					{
					match("H_ei"); 

					}
					break;
				case 3 :
					// qtlSolver.g:462:27: 'H_ii'
					{
					match("H_ii"); 

					}
					break;
				case 4 :
					// qtlSolver.g:462:36: 'H_ie'
					{
					match("H_ie"); 

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
	// $ANTLR end "H_OP"

	// $ANTLR start "UNTIL_OP"
	public final void mUNTIL_OP() throws RecognitionException {
		try {
			int _type = UNTIL_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:465:9: ( 'U' )
			// qtlSolver.g:465:11: 'U'
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
			// qtlSolver.g:466:9: ( 'S' )
			// qtlSolver.g:466:11: 'S'
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
			// qtlSolver.g:467:11: ( 'R' )
			// qtlSolver.g:467:13: 'R'
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
			// qtlSolver.g:468:11: ( 'T' )
			// qtlSolver.g:468:13: 'T'
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
			// qtlSolver.g:471:8: ( 'qtl' | 'mitl' | 'qtl-i' | 'mitl-i' )
			int alt7=4;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='q') ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1=='t') ) {
					int LA7_3 = input.LA(3);
					if ( (LA7_3=='l') ) {
						int LA7_5 = input.LA(4);
						if ( (LA7_5=='-') ) {
							alt7=3;
						}

						else {
							alt7=1;
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 7, 3, input);
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
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA7_0=='m') ) {
				int LA7_2 = input.LA(2);
				if ( (LA7_2=='i') ) {
					int LA7_4 = input.LA(3);
					if ( (LA7_4=='t') ) {
						int LA7_6 = input.LA(4);
						if ( (LA7_6=='l') ) {
							int LA7_9 = input.LA(5);
							if ( (LA7_9=='-') ) {
								alt7=4;
							}

							else {
								alt7=2;
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 7, 6, input);
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
								new NoViableAltException("", 7, 4, input);
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
							new NoViableAltException("", 7, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// qtlSolver.g:471:12: 'qtl'
					{
					match("qtl"); 

					}
					break;
				case 2 :
					// qtlSolver.g:471:18: 'mitl'
					{
					match("mitl"); 

					}
					break;
				case 3 :
					// qtlSolver.g:471:25: 'qtl-i'
					{
					match("qtl-i"); 

					}
					break;
				case 4 :
					// qtlSolver.g:471:33: 'mitl-i'
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
			// qtlSolver.g:473:6: ( ':' )
			// qtlSolver.g:473:8: ':'
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
			// qtlSolver.g:474:5: ( ';' )
			// qtlSolver.g:474:7: ';'
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
			// qtlSolver.g:475:7: ( ( 'a' .. 'z' )+ )
			// qtlSolver.g:475:11: ( 'a' .. 'z' )+
			{
			// qtlSolver.g:475:11: ( 'a' .. 'z' )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
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
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
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
			// qtlSolver.g:476:5: ( ( '0' .. '9' )+ )
			// qtlSolver.g:476:9: ( '0' .. '9' )+
			{
			// qtlSolver.g:476:9: ( '0' .. '9' )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
					alt9=1;
				}

				switch (alt9) {
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
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
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
			// qtlSolver.g:477:3: ( ATOM ( ATOM | INT )* )
			// qtlSolver.g:477:6: ATOM ( ATOM | INT )*
			{
			mATOM(); 

			// qtlSolver.g:477:10: ( ATOM | INT )*
			loop10:
			while (true) {
				int alt10=3;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
					alt10=1;
				}
				else if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
					alt10=2;
				}

				switch (alt10) {
				case 1 :
					// qtlSolver.g:477:11: ATOM
					{
					mATOM(); 

					}
					break;
				case 2 :
					// qtlSolver.g:477:18: INT
					{
					mINT(); 

					}
					break;

				default :
					break loop10;
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
			// qtlSolver.g:478:8: ( ( '\\r' )? '\\n' )
			// qtlSolver.g:478:9: ( '\\r' )? '\\n'
			{
			// qtlSolver.g:478:9: ( '\\r' )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='\r') ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// qtlSolver.g:478:9: '\\r'
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
			// qtlSolver.g:479:5: ( ( ' ' | '\\t' )+ )
			// qtlSolver.g:479:9: ( ' ' | '\\t' )+
			{
			// qtlSolver.g:479:9: ( ' ' | '\\t' )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0=='\t'||LA12_0==' ') ) {
					alt12=1;
				}

				switch (alt12) {
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
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
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
		int alt13=30;
		alt13 = dfa13.predict(input);
		switch (alt13) {
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


	protected DFA13 dfa13 = new DFA13(this);
	static final String DFA13_eotS =
		"\1\uffff\1\35\21\uffff\2\41\1\uffff\1\41\11\uffff\1\41\1\uffff\1\41\1"+
		"\uffff\1\41\4\uffff\1\57\1\41\5\uffff\1\57";
	static final String DFA13_eofS =
		"\61\uffff";
	static final String DFA13_minS =
		"\1\11\1\142\11\uffff\2\137\6\uffff\2\60\1\uffff\1\60\7\uffff\2\145\1\60"+
		"\1\uffff\1\60\1\uffff\1\60\4\53\2\60\5\uffff\1\60";
	static final String DFA13_maxS =
		"\1\174\1\146\11\uffff\2\137\6\uffff\2\172\1\uffff\1\172\7\uffff\2\151"+
		"\1\172\1\uffff\1\172\1\uffff\1\172\4\151\2\172\5\uffff\1\172";
	static final String DFA13_acceptS =
		"\2\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\2\uffff\1\21\1\22\1"+
		"\23\1\24\1\25\1\26\2\uffff\1\31\1\uffff\1\33\1\35\1\36\1\1\1\2\1\3\1\30"+
		"\3\uffff\1\32\1\uffff\1\34\7\uffff\1\15\1\16\1\17\1\20\1\27\1\uffff";
	static final String DFA13_specialS =
		"\61\uffff}>";
	static final String[] DFA13_transitionS = {
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

	static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
	static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
	static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
	static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
	static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
	static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
	static final short[][] DFA13_transition;

	static {
		int numStates = DFA13_transitionS.length;
		DFA13_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
		}
	}

	protected class DFA13 extends DFA {

		public DFA13(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 13;
			this.eot = DFA13_eot;
			this.eof = DFA13_eof;
			this.min = DFA13_min;
			this.max = DFA13_max;
			this.accept = DFA13_accept;
			this.special = DFA13_special;
			this.transition = DFA13_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__31 | T__32 | T__33 | LPAR | RPAR | LBRA | RBRA | NEG_OP | AND_OP | OR_OP | IMPL_OP | IFF_OP | F_OP | F_inf_OP | G_OP | G_inf_OP | P_OP | H_OP | UNTIL_OP | SINCE_OP | RELEASE_OP | TRIGGER_OP | LOGIC | COLON | SEMI | ATOM | INT | ID | NEWLINE | WS );";
		}
	}

}
