// $ANTLR 3.5 qtlSolver.g 2013-05-20 14:51:25
 package parserHandler; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class qtlSolverLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int AND_OP=4;
	public static final int ATOM=5;
	public static final int COLON=6;
	public static final int COMMENT=7;
	public static final int FALSE=8;
	public static final int F_OP=9;
	public static final int F_inf_OP=10;
	public static final int G_OP=11;
	public static final int G_inf_OP=12;
	public static final int H_OP=13;
	public static final int ID=14;
	public static final int IFF_OP=15;
	public static final int IMPL_OP=16;
	public static final int INT=17;
	public static final int LBRA=18;
	public static final int LOGIC=19;
	public static final int LPAR=20;
	public static final int NEG_OP=21;
	public static final int NEWLINE=22;
	public static final int OR_OP=23;
	public static final int P_OP=24;
	public static final int RBRA=25;
	public static final int RELEASE_OP=26;
	public static final int RPAR=27;
	public static final int SEMI=28;
	public static final int SINCE_OP=29;
	public static final int TRIGGER_OP=30;
	public static final int TRUE=31;
	public static final int UNTIL_OP=32;
	public static final int WS=33;

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

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
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
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
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
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
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
	// $ANTLR end "T__36"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:503:5: ( '(' )
			// qtlSolver.g:503:9: '('
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
			// qtlSolver.g:504:5: ( ')' )
			// qtlSolver.g:504:7: ')'
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
			// qtlSolver.g:505:5: ( '[' )
			// qtlSolver.g:505:7: '['
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
			// qtlSolver.g:506:5: ( ']' )
			// qtlSolver.g:506:7: ']'
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

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:508:5: ( 'true' )
			// qtlSolver.g:508:7: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:509:6: ( 'false' )
			// qtlSolver.g:509:8: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "NEG_OP"
	public final void mNEG_OP() throws RecognitionException {
		try {
			int _type = NEG_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:512:7: ( '!!' )
			// qtlSolver.g:512:9: '!!'
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
			// qtlSolver.g:513:7: ( '&&' )
			// qtlSolver.g:513:9: '&&'
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
			// qtlSolver.g:514:6: ( '||' )
			// qtlSolver.g:514:8: '||'
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
			// qtlSolver.g:515:8: ( '->' )
			// qtlSolver.g:515:10: '->'
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
			// qtlSolver.g:516:7: ( '<->' )
			// qtlSolver.g:516:9: '<->'
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
			// qtlSolver.g:520:5: ( 'F_ee' | 'F_ei' | 'F_ii' | 'F_ie' )
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
					// qtlSolver.g:520:9: 'F_ee'
					{
					match("F_ee"); 

					}
					break;
				case 2 :
					// qtlSolver.g:520:18: 'F_ei'
					{
					match("F_ei"); 

					}
					break;
				case 3 :
					// qtlSolver.g:520:27: 'F_ii'
					{
					match("F_ii"); 

					}
					break;
				case 4 :
					// qtlSolver.g:520:36: 'F_ie'
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
			// qtlSolver.g:521:9: ( 'F_e+' | 'F_i+' )
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
					// qtlSolver.g:521:12: 'F_e+'
					{
					match("F_e+"); 

					}
					break;
				case 2 :
					// qtlSolver.g:521:21: 'F_i+'
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
			// qtlSolver.g:523:5: ( 'G_ee' | 'G_ei' | 'G_ii' | 'G_ie' )
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
					// qtlSolver.g:523:9: 'G_ee'
					{
					match("G_ee"); 

					}
					break;
				case 2 :
					// qtlSolver.g:523:18: 'G_ei'
					{
					match("G_ei"); 

					}
					break;
				case 3 :
					// qtlSolver.g:523:27: 'G_ii'
					{
					match("G_ii"); 

					}
					break;
				case 4 :
					// qtlSolver.g:523:36: 'G_ie'
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
			// qtlSolver.g:524:9: ( 'G_e+' | 'G_i+' )
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
					// qtlSolver.g:524:12: 'G_e+'
					{
					match("G_e+"); 

					}
					break;
				case 2 :
					// qtlSolver.g:524:21: 'G_i+'
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
			// qtlSolver.g:527:5: ( 'P_ee' | 'P_ei' | 'P_ii' | 'P_ie' )
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
					// qtlSolver.g:527:9: 'P_ee'
					{
					match("P_ee"); 

					}
					break;
				case 2 :
					// qtlSolver.g:527:18: 'P_ei'
					{
					match("P_ei"); 

					}
					break;
				case 3 :
					// qtlSolver.g:527:27: 'P_ii'
					{
					match("P_ii"); 

					}
					break;
				case 4 :
					// qtlSolver.g:527:36: 'P_ie'
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
			// qtlSolver.g:528:5: ( 'H_ee' | 'H_ei' | 'H_ii' | 'H_ie' )
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
					// qtlSolver.g:528:9: 'H_ee'
					{
					match("H_ee"); 

					}
					break;
				case 2 :
					// qtlSolver.g:528:18: 'H_ei'
					{
					match("H_ei"); 

					}
					break;
				case 3 :
					// qtlSolver.g:528:27: 'H_ii'
					{
					match("H_ii"); 

					}
					break;
				case 4 :
					// qtlSolver.g:528:36: 'H_ie'
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
			// qtlSolver.g:531:9: ( 'U' )
			// qtlSolver.g:531:11: 'U'
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
			// qtlSolver.g:532:9: ( 'S' )
			// qtlSolver.g:532:11: 'S'
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
			// qtlSolver.g:533:11: ( 'R' )
			// qtlSolver.g:533:13: 'R'
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
			// qtlSolver.g:534:11: ( 'T' )
			// qtlSolver.g:534:13: 'T'
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
			// qtlSolver.g:537:8: ( 'qtl' | 'mitl' | 'qtl-i' | 'mitl-i' )
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
					// qtlSolver.g:537:12: 'qtl'
					{
					match("qtl"); 

					}
					break;
				case 2 :
					// qtlSolver.g:537:18: 'mitl'
					{
					match("mitl"); 

					}
					break;
				case 3 :
					// qtlSolver.g:537:25: 'qtl-i'
					{
					match("qtl-i"); 

					}
					break;
				case 4 :
					// qtlSolver.g:537:33: 'mitl-i'
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
			// qtlSolver.g:539:6: ( ':' )
			// qtlSolver.g:539:8: ':'
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
			// qtlSolver.g:540:5: ( ';' )
			// qtlSolver.g:540:7: ';'
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

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:541:5: ( ( '0' .. '9' )+ )
			// qtlSolver.g:541:7: ( '0' .. '9' )+
			{
			// qtlSolver.g:541:7: ( '0' .. '9' )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
					alt8=1;
				}

				switch (alt8) {
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
	// $ANTLR end "INT"

	// $ANTLR start "ATOM"
	public final void mATOM() throws RecognitionException {
		try {
			// qtlSolver.g:542:14: ( 'a' .. 'z' )
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

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ATOM"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:544:3: ( ATOM ( ATOM | INT | '_' )* )
			// qtlSolver.g:544:6: ATOM ( ATOM | INT | '_' )*
			{
			mATOM(); 

			// qtlSolver.g:544:10: ( ATOM | INT | '_' )*
			loop9:
			while (true) {
				int alt9=4;
				switch ( input.LA(1) ) {
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
				case 'g':
				case 'h':
				case 'i':
				case 'j':
				case 'k':
				case 'l':
				case 'm':
				case 'n':
				case 'o':
				case 'p':
				case 'q':
				case 'r':
				case 's':
				case 't':
				case 'u':
				case 'v':
				case 'w':
				case 'x':
				case 'y':
				case 'z':
					{
					alt9=1;
					}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					{
					alt9=2;
					}
					break;
				case '_':
					{
					alt9=3;
					}
					break;
				}
				switch (alt9) {
				case 1 :
					// qtlSolver.g:544:11: ATOM
					{
					mATOM(); 

					}
					break;
				case 2 :
					// qtlSolver.g:544:18: INT
					{
					mINT(); 

					}
					break;
				case 3 :
					// qtlSolver.g:544:24: '_'
					{
					match('_'); 
					}
					break;

				default :
					break loop9;
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
			// qtlSolver.g:546:8: ( ( '\\r' )? '\\n' )
			// qtlSolver.g:546:9: ( '\\r' )? '\\n'
			{
			// qtlSolver.g:546:9: ( '\\r' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='\r') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// qtlSolver.g:546:9: '\\r'
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
			// qtlSolver.g:547:5: ( ( ' ' | '\\t' )+ )
			// qtlSolver.g:547:9: ( ' ' | '\\t' )+
			{
			// qtlSolver.g:547:9: ( ' ' | '\\t' )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='\t'||LA11_0==' ') ) {
					alt11=1;
				}

				switch (alt11) {
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
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
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

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// qtlSolver.g:548:8: ( '#' (~ ( '\\r' | '\\n' ) )* )
			// qtlSolver.g:548:10: '#' (~ ( '\\r' | '\\n' ) )*
			{
			match('#'); 
			// qtlSolver.g:548:13: (~ ( '\\r' | '\\n' ) )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\t')||(LA12_0 >= '\u000B' && LA12_0 <= '\f')||(LA12_0 >= '\u000E' && LA12_0 <= '\uFFFF')) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// qtlSolver.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
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
					break loop12;
				}
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
	// $ANTLR end "COMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// qtlSolver.g:1:8: ( T__34 | T__35 | T__36 | LPAR | RPAR | LBRA | RBRA | TRUE | FALSE | NEG_OP | AND_OP | OR_OP | IMPL_OP | IFF_OP | F_OP | F_inf_OP | G_OP | G_inf_OP | P_OP | H_OP | UNTIL_OP | SINCE_OP | RELEASE_OP | TRIGGER_OP | LOGIC | COLON | SEMI | INT | ID | NEWLINE | WS | COMMENT )
		int alt13=32;
		switch ( input.LA(1) ) {
		case ':':
			{
			switch ( input.LA(2) ) {
			case 'b':
				{
				alt13=1;
				}
				break;
			case 'd':
				{
				alt13=2;
				}
				break;
			case 'f':
				{
				alt13=3;
				}
				break;
			default:
				alt13=26;
			}
			}
			break;
		case '(':
			{
			alt13=4;
			}
			break;
		case ')':
			{
			alt13=5;
			}
			break;
		case '[':
			{
			alt13=6;
			}
			break;
		case ']':
			{
			alt13=7;
			}
			break;
		case 't':
			{
			int LA13_6 = input.LA(2);
			if ( (LA13_6=='r') ) {
				int LA13_33 = input.LA(3);
				if ( (LA13_33=='u') ) {
					int LA13_39 = input.LA(4);
					if ( (LA13_39=='e') ) {
						int LA13_47 = input.LA(5);
						if ( ((LA13_47 >= '0' && LA13_47 <= '9')||LA13_47=='_'||(LA13_47 >= 'a' && LA13_47 <= 'z')) ) {
							alt13=29;
						}

						else {
							alt13=8;
						}

					}

					else {
						alt13=29;
					}

				}

				else {
					alt13=29;
				}

			}

			else {
				alt13=29;
			}

			}
			break;
		case 'f':
			{
			int LA13_7 = input.LA(2);
			if ( (LA13_7=='a') ) {
				int LA13_34 = input.LA(3);
				if ( (LA13_34=='l') ) {
					int LA13_40 = input.LA(4);
					if ( (LA13_40=='s') ) {
						int LA13_48 = input.LA(5);
						if ( (LA13_48=='e') ) {
							int LA13_56 = input.LA(6);
							if ( ((LA13_56 >= '0' && LA13_56 <= '9')||LA13_56=='_'||(LA13_56 >= 'a' && LA13_56 <= 'z')) ) {
								alt13=29;
							}

							else {
								alt13=9;
							}

						}

						else {
							alt13=29;
						}

					}

					else {
						alt13=29;
					}

				}

				else {
					alt13=29;
				}

			}

			else {
				alt13=29;
			}

			}
			break;
		case '!':
			{
			alt13=10;
			}
			break;
		case '&':
			{
			alt13=11;
			}
			break;
		case '|':
			{
			alt13=12;
			}
			break;
		case '-':
			{
			alt13=13;
			}
			break;
		case '<':
			{
			alt13=14;
			}
			break;
		case 'F':
			{
			int LA13_13 = input.LA(2);
			if ( (LA13_13=='_') ) {
				int LA13_35 = input.LA(3);
				if ( (LA13_35=='e') ) {
					int LA13_41 = input.LA(4);
					if ( (LA13_41=='e'||LA13_41=='i') ) {
						alt13=15;
					}
					else if ( (LA13_41=='+') ) {
						alt13=16;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 13, 41, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA13_35=='i') ) {
					int LA13_42 = input.LA(4);
					if ( (LA13_42=='e'||LA13_42=='i') ) {
						alt13=15;
					}
					else if ( (LA13_42=='+') ) {
						alt13=16;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 13, 42, input);
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
							new NoViableAltException("", 13, 35, input);
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
						new NoViableAltException("", 13, 13, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case 'G':
			{
			int LA13_14 = input.LA(2);
			if ( (LA13_14=='_') ) {
				int LA13_36 = input.LA(3);
				if ( (LA13_36=='e') ) {
					int LA13_43 = input.LA(4);
					if ( (LA13_43=='e'||LA13_43=='i') ) {
						alt13=17;
					}
					else if ( (LA13_43=='+') ) {
						alt13=18;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 13, 43, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA13_36=='i') ) {
					int LA13_44 = input.LA(4);
					if ( (LA13_44=='e'||LA13_44=='i') ) {
						alt13=17;
					}
					else if ( (LA13_44=='+') ) {
						alt13=18;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 13, 44, input);
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
							new NoViableAltException("", 13, 36, input);
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
						new NoViableAltException("", 13, 14, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case 'P':
			{
			alt13=19;
			}
			break;
		case 'H':
			{
			alt13=20;
			}
			break;
		case 'U':
			{
			alt13=21;
			}
			break;
		case 'S':
			{
			alt13=22;
			}
			break;
		case 'R':
			{
			alt13=23;
			}
			break;
		case 'T':
			{
			alt13=24;
			}
			break;
		case 'q':
			{
			int LA13_21 = input.LA(2);
			if ( (LA13_21=='t') ) {
				int LA13_37 = input.LA(3);
				if ( (LA13_37=='l') ) {
					int LA13_45 = input.LA(4);
					if ( ((LA13_45 >= '0' && LA13_45 <= '9')||LA13_45=='_'||(LA13_45 >= 'a' && LA13_45 <= 'z')) ) {
						alt13=29;
					}

					else {
						alt13=25;
					}

				}

				else {
					alt13=29;
				}

			}

			else {
				alt13=29;
			}

			}
			break;
		case 'm':
			{
			int LA13_22 = input.LA(2);
			if ( (LA13_22=='i') ) {
				int LA13_38 = input.LA(3);
				if ( (LA13_38=='t') ) {
					int LA13_46 = input.LA(4);
					if ( (LA13_46=='l') ) {
						int LA13_54 = input.LA(5);
						if ( ((LA13_54 >= '0' && LA13_54 <= '9')||LA13_54=='_'||(LA13_54 >= 'a' && LA13_54 <= 'z')) ) {
							alt13=29;
						}

						else {
							alt13=25;
						}

					}

					else {
						alt13=29;
					}

				}

				else {
					alt13=29;
				}

			}

			else {
				alt13=29;
			}

			}
			break;
		case ';':
			{
			alt13=27;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt13=28;
			}
			break;
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'n':
		case 'o':
		case 'p':
		case 'r':
		case 's':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt13=29;
			}
			break;
		case '\n':
		case '\r':
			{
			alt13=30;
			}
			break;
		case '\t':
		case ' ':
			{
			alt13=31;
			}
			break;
		case '#':
			{
			alt13=32;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 13, 0, input);
			throw nvae;
		}
		switch (alt13) {
			case 1 :
				// qtlSolver.g:1:10: T__34
				{
				mT__34(); 

				}
				break;
			case 2 :
				// qtlSolver.g:1:16: T__35
				{
				mT__35(); 

				}
				break;
			case 3 :
				// qtlSolver.g:1:22: T__36
				{
				mT__36(); 

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
				// qtlSolver.g:1:48: TRUE
				{
				mTRUE(); 

				}
				break;
			case 9 :
				// qtlSolver.g:1:53: FALSE
				{
				mFALSE(); 

				}
				break;
			case 10 :
				// qtlSolver.g:1:59: NEG_OP
				{
				mNEG_OP(); 

				}
				break;
			case 11 :
				// qtlSolver.g:1:66: AND_OP
				{
				mAND_OP(); 

				}
				break;
			case 12 :
				// qtlSolver.g:1:73: OR_OP
				{
				mOR_OP(); 

				}
				break;
			case 13 :
				// qtlSolver.g:1:79: IMPL_OP
				{
				mIMPL_OP(); 

				}
				break;
			case 14 :
				// qtlSolver.g:1:87: IFF_OP
				{
				mIFF_OP(); 

				}
				break;
			case 15 :
				// qtlSolver.g:1:94: F_OP
				{
				mF_OP(); 

				}
				break;
			case 16 :
				// qtlSolver.g:1:99: F_inf_OP
				{
				mF_inf_OP(); 

				}
				break;
			case 17 :
				// qtlSolver.g:1:108: G_OP
				{
				mG_OP(); 

				}
				break;
			case 18 :
				// qtlSolver.g:1:113: G_inf_OP
				{
				mG_inf_OP(); 

				}
				break;
			case 19 :
				// qtlSolver.g:1:122: P_OP
				{
				mP_OP(); 

				}
				break;
			case 20 :
				// qtlSolver.g:1:127: H_OP
				{
				mH_OP(); 

				}
				break;
			case 21 :
				// qtlSolver.g:1:132: UNTIL_OP
				{
				mUNTIL_OP(); 

				}
				break;
			case 22 :
				// qtlSolver.g:1:141: SINCE_OP
				{
				mSINCE_OP(); 

				}
				break;
			case 23 :
				// qtlSolver.g:1:150: RELEASE_OP
				{
				mRELEASE_OP(); 

				}
				break;
			case 24 :
				// qtlSolver.g:1:161: TRIGGER_OP
				{
				mTRIGGER_OP(); 

				}
				break;
			case 25 :
				// qtlSolver.g:1:172: LOGIC
				{
				mLOGIC(); 

				}
				break;
			case 26 :
				// qtlSolver.g:1:178: COLON
				{
				mCOLON(); 

				}
				break;
			case 27 :
				// qtlSolver.g:1:184: SEMI
				{
				mSEMI(); 

				}
				break;
			case 28 :
				// qtlSolver.g:1:189: INT
				{
				mINT(); 

				}
				break;
			case 29 :
				// qtlSolver.g:1:193: ID
				{
				mID(); 

				}
				break;
			case 30 :
				// qtlSolver.g:1:196: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 31 :
				// qtlSolver.g:1:204: WS
				{
				mWS(); 

				}
				break;
			case 32 :
				// qtlSolver.g:1:207: COMMENT
				{
				mCOMMENT(); 

				}
				break;

		}
	}



}
