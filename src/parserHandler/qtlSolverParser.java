// $ANTLR 3.5 qtlSolver.g 2013-06-06 22:07:16

package parserHandler;

import java.util.HashMap;
import delegateTranslator.*;
import formulae.*;
import formulae.QTL.*;
import formulae.QTLI.*;
import formulae.QTLI.Counting.*;
import formulae.MITL.*;
import formulae.MITLI.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Collections;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class qtlSolverParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND_OP", "ATOM", "COLON", "COMMENT", 
		"COUNT_OP", "FALSE", "F_OP", "F_inf_OP", "G_OP", "G_inf_OP", "H_OP", "ID", 
		"IFF_OP", "IMPL_OP", "INT", "LBRA", "LOGIC", "LPAR", "NEG_OP", "NEWLINE", 
		"OR_OP", "P_OP", "RBRA", "RELEASE_OP", "RPAR", "SEMI", "SINCE_OP", "TRIGGER_OP", 
		"TRUE", "UNTIL_OP", "WS", "':bound'", "':def'", "':formula'"
	};
	public static final int EOF=-1;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int AND_OP=4;
	public static final int ATOM=5;
	public static final int COLON=6;
	public static final int COMMENT=7;
	public static final int COUNT_OP=8;
	public static final int FALSE=9;
	public static final int F_OP=10;
	public static final int F_inf_OP=11;
	public static final int G_OP=12;
	public static final int G_inf_OP=13;
	public static final int H_OP=14;
	public static final int ID=15;
	public static final int IFF_OP=16;
	public static final int IMPL_OP=17;
	public static final int INT=18;
	public static final int LBRA=19;
	public static final int LOGIC=20;
	public static final int LPAR=21;
	public static final int NEG_OP=22;
	public static final int NEWLINE=23;
	public static final int OR_OP=24;
	public static final int P_OP=25;
	public static final int RBRA=26;
	public static final int RELEASE_OP=27;
	public static final int RPAR=28;
	public static final int SEMI=29;
	public static final int SINCE_OP=30;
	public static final int TRIGGER_OP=31;
	public static final int TRUE=32;
	public static final int UNTIL_OP=33;
	public static final int WS=34;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public qtlSolverParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public qtlSolverParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return qtlSolverParser.tokenNames; }
	@Override public String getGrammarFileName() { return "qtlSolver.g"; }


	/** Map variable name to Integer object holding value */
	HashMap<String, Formula> memory = new HashMap<String,Formula>();

	TLParserHandler p;
	String tlogic;



	// $ANTLR start "tlparser"
	// qtlSolver.g:34:1: tlparser : l= logic NEWLINE ':bound' INT NEWLINE ( declaration )* ':formula' fmla NEWLINE ;
	public final void tlparser() throws RecognitionException {
		Token INT1=null;
		String l =null;
		Formula fmla2 =null;

		try {
			// qtlSolver.g:34:9: (l= logic NEWLINE ':bound' INT NEWLINE ( declaration )* ':formula' fmla NEWLINE )
			// qtlSolver.g:34:11: l= logic NEWLINE ':bound' INT NEWLINE ( declaration )* ':formula' fmla NEWLINE
			{
			pushFollow(FOLLOW_logic_in_tlparser35);
			l=logic();
			state._fsp--;

			match(input,NEWLINE,FOLLOW_NEWLINE_in_tlparser37); 
			 
							tlogic = l;
							if (tlogic.equals("qtl"))
								p = new QTLParserHandler();
							else if (tlogic.equals("qtl-i"))
								p = new QTLIParserHandler();
							else if (tlogic.equals("mitl"))
								p = new MITLParserHandler();
							else if (tlogic.equals("mitl-i"))
								p = new MITLIParserHandler();				 
					 	
			match(input,35,FOLLOW_35_in_tlparser48); 
			INT1=(Token)match(input,INT,FOLLOW_INT_in_tlparser50); 
			match(input,NEWLINE,FOLLOW_NEWLINE_in_tlparser52); 

							p.setHistoryLength(Integer.valueOf((INT1!=null?INT1.getText():null)));
							System.out.println("Starting parsing formulae...");
						
			// qtlSolver.g:51:4: ( declaration )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==NEWLINE||LA1_0==36) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// qtlSolver.g:51:4: declaration
					{
					pushFollow(FOLLOW_declaration_in_tlparser62);
					declaration();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			match(input,37,FOLLOW_37_in_tlparser68); 
			pushFollow(FOLLOW_fmla_in_tlparser70);
			fmla2=fmla();
			state._fsp--;

							
						
								
							p.setCLTLTranslator(CLTLTranslatorEnum.AE2ZOT);
							
							
							FileOutputStream f0 = null;
							
							try {
								f0 = new FileOutputStream("output.cltl");
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
							
							if (f0 != null){
								PrintStream prn = new PrintStream(f0);		
								prn.println(p.translate(fmla2, CLTLTranslatorEnum.AE2ZOT));
							}
							else
								System.out.println("Opps...some errors occurred!");					
						
			match(input,NEWLINE,FOLLOW_NEWLINE_in_tlparser77); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "tlparser"



	// $ANTLR start "logic"
	// qtlSolver.g:76:1: logic returns [String s] : COLON LOGIC ;
	public final String logic() throws RecognitionException {
		String s = null;


		Token LOGIC3=null;

		try {
			// qtlSolver.g:77:2: ( COLON LOGIC )
			// qtlSolver.g:77:4: COLON LOGIC
			{
			match(input,COLON,FOLLOW_COLON_in_logic92); 
			LOGIC3=(Token)match(input,LOGIC,FOLLOW_LOGIC_in_logic94); 
			 s = new String((LOGIC3!=null?LOGIC3.getText():null)); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return s;
	}
	// $ANTLR end "logic"



	// $ANTLR start "declaration"
	// qtlSolver.g:80:1: declaration : ( ':def' s= ID fmla NEWLINE | NEWLINE );
	public final void declaration() throws RecognitionException {
		Token s=null;
		Formula fmla4 =null;

		try {
			// qtlSolver.g:80:12: ( ':def' s= ID fmla NEWLINE | NEWLINE )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==36) ) {
				alt2=1;
			}
			else if ( (LA2_0==NEWLINE) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// qtlSolver.g:80:14: ':def' s= ID fmla NEWLINE
					{
					match(input,36,FOLLOW_36_in_declaration108); 
					s=(Token)match(input,ID,FOLLOW_ID_in_declaration112); 
					pushFollow(FOLLOW_fmla_in_declaration118);
					fmla4=fmla();
					state._fsp--;


								 	if (memory.containsKey((s!=null?s.getText():null)))
										emitErrorMessage("warning: duplicate name formula! " + (s!=null?s.getText():null) + " was already defined.");		
									else
								 		memory.put((s!=null?s.getText():null), fmla4);
								 
					match(input,NEWLINE,FOLLOW_NEWLINE_in_declaration131); 
					}
					break;
				case 2 :
					// qtlSolver.g:89:5: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_declaration137); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declaration"



	// $ANTLR start "fmla"
	// qtlSolver.g:92:1: fmla returns [Formula r] : ( LPAR in_fmla= fmla RPAR | TRUE | FALSE | ID | LPAR NEG_OP f1= fmla RPAR | LPAR AND_OP clist= conjuncts_list RPAR | LPAR OR_OP clist= conjuncts_list RPAR | LPAR IMPL_OP f1= fmla f2= fmla RPAR | LPAR IFF_OP f1= fmla f2= fmla RPAR | LPAR F_OP a= INT b= INT f1= fmla RPAR | LPAR F_inf_OP a= INT f1= fmla RPAR | LPAR op= G_OP a= INT b= INT f1= fmla RPAR | LPAR op= G_inf_OP a= INT f1= fmla RPAR | LPAR P_OP a= INT b= INT f1= fmla RPAR | LPAR H_OP a= INT b= INT f1= fmla RPAR | LPAR UNTIL_OP f1= fmla f2= fmla RPAR | LPAR SINCE_OP f1= fmla f2= fmla RPAR | LPAR RELEASE_OP f1= fmla f2= fmla RPAR | LPAR TRIGGER_OP f1= fmla f2= fmla RPAR | LPAR COUNT_OP n= INT b= INT f1= fmla RPAR );
	public final Formula fmla() throws RecognitionException {
		Formula r = null;


		Token a=null;
		Token b=null;
		Token op=null;
		Token n=null;
		Token ID5=null;
		Token F_OP6=null;
		Token F_inf_OP7=null;
		Token P_OP8=null;
		Token H_OP9=null;
		Formula in_fmla =null;
		Formula f1 =null;
		List<Formula> clist =null;
		Formula f2 =null;

		try {
			// qtlSolver.g:93:2: ( LPAR in_fmla= fmla RPAR | TRUE | FALSE | ID | LPAR NEG_OP f1= fmla RPAR | LPAR AND_OP clist= conjuncts_list RPAR | LPAR OR_OP clist= conjuncts_list RPAR | LPAR IMPL_OP f1= fmla f2= fmla RPAR | LPAR IFF_OP f1= fmla f2= fmla RPAR | LPAR F_OP a= INT b= INT f1= fmla RPAR | LPAR F_inf_OP a= INT f1= fmla RPAR | LPAR op= G_OP a= INT b= INT f1= fmla RPAR | LPAR op= G_inf_OP a= INT f1= fmla RPAR | LPAR P_OP a= INT b= INT f1= fmla RPAR | LPAR H_OP a= INT b= INT f1= fmla RPAR | LPAR UNTIL_OP f1= fmla f2= fmla RPAR | LPAR SINCE_OP f1= fmla f2= fmla RPAR | LPAR RELEASE_OP f1= fmla f2= fmla RPAR | LPAR TRIGGER_OP f1= fmla f2= fmla RPAR | LPAR COUNT_OP n= INT b= INT f1= fmla RPAR )
			int alt3=20;
			switch ( input.LA(1) ) {
			case LPAR:
				{
				switch ( input.LA(2) ) {
				case NEG_OP:
					{
					alt3=5;
					}
					break;
				case AND_OP:
					{
					alt3=6;
					}
					break;
				case OR_OP:
					{
					alt3=7;
					}
					break;
				case IMPL_OP:
					{
					alt3=8;
					}
					break;
				case IFF_OP:
					{
					alt3=9;
					}
					break;
				case F_OP:
					{
					alt3=10;
					}
					break;
				case F_inf_OP:
					{
					alt3=11;
					}
					break;
				case G_OP:
					{
					alt3=12;
					}
					break;
				case G_inf_OP:
					{
					alt3=13;
					}
					break;
				case P_OP:
					{
					alt3=14;
					}
					break;
				case H_OP:
					{
					alt3=15;
					}
					break;
				case UNTIL_OP:
					{
					alt3=16;
					}
					break;
				case SINCE_OP:
					{
					alt3=17;
					}
					break;
				case RELEASE_OP:
					{
					alt3=18;
					}
					break;
				case TRIGGER_OP:
					{
					alt3=19;
					}
					break;
				case COUNT_OP:
					{
					alt3=20;
					}
					break;
				case FALSE:
				case ID:
				case LPAR:
				case TRUE:
					{
					alt3=1;
					}
					break;
				default:
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
				break;
			case TRUE:
				{
				alt3=2;
				}
				break;
			case FALSE:
				{
				alt3=3;
				}
				break;
			case ID:
				{
				alt3=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// qtlSolver.g:93:6: LPAR in_fmla= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla161); 
					pushFollow(FOLLOW_fmla_in_fmla165);
					in_fmla=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla167); 

								r = in_fmla;
							
					}
					break;
				case 2 :
					// qtlSolver.g:97:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_fmla176); 

								Formula f = null;
								if (tlogic.equals("qtl"))	
									f = new QTLTrue();
								else if (tlogic.equals("qtl-i"))
									f = new QTLITrue();
								else if (tlogic.equals("mitl"))
									f = new MITLTrue();
								else if (tlogic.equals("mitl-i"))
									f = new MITLITrue();
									
								r = p.addFormula(f);
							
					}
					break;
				case 3 :
					// qtlSolver.g:111:4: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_fmla185); 

								Formula f = null;
								if (tlogic.equals("qtl"))	
									f = new QTLFalse();
								else if (tlogic.equals("qtl-i"))
									f = new QTLIFalse();
								else if (tlogic.equals("mitl"))
									f = new MITLFalse();
								else if (tlogic.equals("mitl-i"))
									f = new MITLIFalse();
									
								r = p.addFormula(f);
							
					}
					break;
				case 4 :
					// qtlSolver.g:125:6: ID
					{
					ID5=(Token)match(input,ID,FOLLOW_ID_in_fmla196); 
						
								if (memory.containsKey((ID5!=null?ID5.getText():null))){
									r = memory.get((ID5!=null?ID5.getText():null));					
								}
								else{
									Formula f = null;
									if (tlogic.equals("qtl"))	
										f = new QTLAtom((ID5!=null?ID5.getText():null));
									else if (tlogic.equals("qtl-i"))
										f = new QTLIAtom((ID5!=null?ID5.getText():null));
									else if (tlogic.equals("mitl"))
										f = new MITLAtom((ID5!=null?ID5.getText():null));
									else if (tlogic.equals("mitl-i"))
										f = new MITLIAtom((ID5!=null?ID5.getText():null));
									
									r = p.addFormula(f);
								}
							
					}
					break;
				case 5 :
					// qtlSolver.g:144:4: LPAR NEG_OP f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla207); 
					match(input,NEG_OP,FOLLOW_NEG_OP_in_fmla209); 
					pushFollow(FOLLOW_fmla_in_fmla213);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla215); 
						
								Formula f = null;
								if (tlogic.equals("qtl")) 
									f = new QTLNegation((QTLFormula) f1);
								else if (tlogic.equals("qtl-i")) 
									f = new QTLINegation((QTLIFormula) f1);
								else if (tlogic.equals("mitl"))
									f = new MITLNegation((MITLFormula) f1);
								else if (tlogic.equals("mitl-i"))
									f = new MITLINegation((MITLIFormula) f1);
									
								r = p.addFormula(f);
							
					}
					break;
				case 6 :
					// qtlSolver.g:158:6: LPAR AND_OP clist= conjuncts_list RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla227); 
					match(input,AND_OP,FOLLOW_AND_OP_in_fmla229); 
					pushFollow(FOLLOW_conjuncts_list_in_fmla233);
					clist=conjuncts_list();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla235); 
						
								Formula f = null;
								Formula[] arr = null;
								
								if (tlogic.equals("qtl")) 
									f = new QTLConjunction((QTLFormula)(clist).get(0),(QTLFormula)(clist).get(1));
								else if (tlogic.equals("qtl-i")){ 
								
									arr = new QTLIFormula[clist.size()];

									int i = 0;
									for (Formula fm: clist)
										arr[i++] = fm;
								
									f = QTLIFormula.and((QTLIFormula[]) arr);
								}	
								else if (tlogic.equals("mitl"))
									f = new MITLConjunction((MITLFormula)(clist).get(0),(MITLFormula)(clist).get(1));
								else if (tlogic.equals("mitl-i")){ 
								
									arr = new MITLIFormula[clist.size()];

									int i = 0;
									for (Formula fm: clist)
										arr[i++] = fm;
								
									f = MITLIFormula.and((MITLIFormula[]) arr);
								}	
										
								r = p.addFormula(f);
							
					}
					break;
				case 7 :
					// qtlSolver.g:190:6: LPAR OR_OP clist= conjuncts_list RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla246); 
					match(input,OR_OP,FOLLOW_OR_OP_in_fmla248); 
					pushFollow(FOLLOW_conjuncts_list_in_fmla252);
					clist=conjuncts_list();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla254); 
						
								Formula f = null;
								Formula[] arr = null;
								
								if (tlogic.equals("qtl")) 
									f = new QTLDisjunction((QTLFormula)(clist).get(0),(QTLFormula)(clist).get(1));
								else if (tlogic.equals("qtl-i")){ 
								
									arr = new QTLIFormula[clist.size()];

									int i = 0;
									for (Formula fm: clist)
										arr[i++] = fm;
								
									f = QTLIFormula.or((QTLIFormula[]) arr);
								}	
								else if (tlogic.equals("mitl"))
									f = MITLFormula.or((MITLFormula)(clist).get(0),(MITLFormula)(clist).get(1));
								else if (tlogic.equals("mitl-i")){ 
								
									arr = new MITLIFormula[clist.size()];

									int i = 0;
									for (Formula fm: clist)
										arr[i++] = fm;
								
									f = MITLIFormula.or((MITLIFormula[]) arr);
								}
									
								r = p.addFormula(f);	
							
					}
					break;
				case 8 :
					// qtlSolver.g:222:6: LPAR IMPL_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla265); 
					match(input,IMPL_OP,FOLLOW_IMPL_OP_in_fmla267); 
					pushFollow(FOLLOW_fmla_in_fmla271);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla275);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla277); 
						
								Formula f = null; 
								if (tlogic.equals("qtl")) 
									f = QTLFormula.implies((QTLFormula)f1, (QTLFormula)f2);
								else if (tlogic.equals("qtl-i")) 
									f = QTLIFormula.implies((QTLIFormula)f1,(QTLIFormula)f2);		
								else if (tlogic.equals("mitl"))
									f = MITLFormula.implies((MITLFormula)f1, (MITLFormula)f2);
								else if (tlogic.equals("mitl-i")) 
									f = MITLIFormula.implies((MITLIFormula)f1,(MITLIFormula)f2);	
									
								r = p.addFormula(f);	
							
					}
					break;
				case 9 :
					// qtlSolver.g:236:6: LPAR IFF_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla288); 
					match(input,IFF_OP,FOLLOW_IFF_OP_in_fmla290); 
					pushFollow(FOLLOW_fmla_in_fmla294);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla298);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla300); 
						
								Formula f = null; 
								if (tlogic.equals("qtl")) 
									f = QTLFormula.iff((QTLFormula)f1, (QTLFormula)f2);
								else if (tlogic.equals("qtl-i")) 
									f = QTLIFormula.iff((QTLIFormula)f1,(QTLIFormula)f2);		
								else if (tlogic.equals("mitl"))
									f = MITLFormula.iff((MITLFormula)f1, (MITLFormula)f2);
								else if (tlogic.equals("mitl-i")) 
									f = MITLIFormula.iff((MITLIFormula)f1,(MITLIFormula)f2);
									
								r = p.addFormula(f);		
							
					}
					break;
				case 10 :
					// qtlSolver.g:250:6: LPAR F_OP a= INT b= INT f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla312); 
					F_OP6=(Token)match(input,F_OP,FOLLOW_F_OP_in_fmla314); 
					a=(Token)match(input,INT,FOLLOW_INT_in_fmla318); 
					b=(Token)match(input,INT,FOLLOW_INT_in_fmla322); 
					pushFollow(FOLLOW_fmla_in_fmla326);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla328); 
						
								Formula f = null;
								String s = String.valueOf((F_OP6!=null?F_OP6.getText():null));
								
								
								if (tlogic.equals("qtl")){
									if (s.compareTo("F_ee") == 0)
										f = QTLFormula.F((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else if (s.compareTo("F_ei") == 0)
										f = QTLFormula.F((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED); 
									else if (s.compareTo("F_ie") == 0)	
										f = QTLFormula.F((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else
										f = QTLFormula.F((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED);
								} else if (tlogic.equals("qtl-i")){
									if (s.compareTo("F_ee") == 0)
										f = QTLIFormula.F((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else if (s.compareTo("F_ei") == 0)
										f = QTLIFormula.F((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED); 
									else if (s.compareTo("F_ie") == 0)	
										f = QTLIFormula.F((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else
										f = QTLIFormula.F((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED);
								} else if (tlogic.equals("mitl")){
									if (s.compareTo("F_ei") == 0 || s.compareTo("F_ii") == 0)
										f = MITLFormula.F((MITLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Integer.valueOf((b!=null?b.getText():null)));  
								} else if (tlogic.equals("mitl-i")){
									if (s.compareTo("F_ei") == 0 || s.compareTo("F_ii") == 0)
										f = MITLIFormula.F((MITLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Integer.valueOf((b!=null?b.getText():null)));  
								}
									 
								r = p.addFormula(f);
							
					}
					break;
				case 11 :
					// qtlSolver.g:284:6: LPAR F_inf_OP a= INT f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla340); 
					F_inf_OP7=(Token)match(input,F_inf_OP,FOLLOW_F_inf_OP_in_fmla342); 
					a=(Token)match(input,INT,FOLLOW_INT_in_fmla346); 
					pushFollow(FOLLOW_fmla_in_fmla350);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla352); 
						
								Formula f = null;
								String s = String.valueOf((F_inf_OP7!=null?F_inf_OP7.getText():null));
								
								if (tlogic.equals("qtl")){
									if (s.compareTo("F_e+") == 0)
										f = QTLFormula.F((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN); 
									else
										f = QTLFormula.F((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED); 
								} else if (tlogic.equals("qtl-i")){
									if (s.compareTo("F_e+") == 0)
										f = QTLIFormula.F((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN); 
									else
										f = QTLIFormula.F((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED); 
								} else if (tlogic.equals("mitl")){
									if (s.compareTo("F_e+") == 0 || s.compareTo("F_i+") == 0)
										f = MITLFormula.F_inf((MITLFormula)f1, Integer.valueOf((a!=null?a.getText():null)));  
								} else if (tlogic.equals("mitl-i")){
									if (s.compareTo("F_e+") == 0 || s.compareTo("F_i+") == 0)
										f = MITLIFormula.F_inf((MITLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)));  
								}
									 
								r = p.addFormula(f);
							
					}
					break;
				case 12 :
					// qtlSolver.g:309:6: LPAR op= G_OP a= INT b= INT f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla366); 
					op=(Token)match(input,G_OP,FOLLOW_G_OP_in_fmla370); 
					a=(Token)match(input,INT,FOLLOW_INT_in_fmla374); 
					b=(Token)match(input,INT,FOLLOW_INT_in_fmla378); 
					pushFollow(FOLLOW_fmla_in_fmla382);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla384); 
						
								Formula f = null;
								String s = String.valueOf((op!=null?op.getText():null));
								
								if (tlogic.equals("qtl")){
									if (s.compareTo("G_ee") == 0)
										f = QTLFormula.G((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else if (s.compareTo("G_ei") == 0)
										f = QTLFormula.G((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED); 
									else if (s.compareTo("G_ie") == 0)	
										f = QTLFormula.G((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else
										f = QTLFormula.G((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED);
								} else if (tlogic.equals("qtl-i")){
									if (s.compareTo("G_ee") == 0)
										f = QTLIFormula.G((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else if (s.compareTo("G_ei") == 0)
										f = QTLIFormula.G((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED); 
									else if (s.compareTo("G_ie") == 0)	
										f = QTLIFormula.G((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else
										f = QTLIFormula.G((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED);
								} else if (tlogic.equals("mitl")){
									if (s.compareTo("G_ei") == 0 || s.compareTo("G_ii") == 0)
										f = MITLFormula.G((MITLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Integer.valueOf((b!=null?b.getText():null))); 
								} else if (tlogic.equals("mitl-i")){
									if (s.compareTo("G_ei") == 0 || s.compareTo("G_ii") == 0)
										f = MITLIFormula.G((MITLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Integer.valueOf((b!=null?b.getText():null))); 
								}
									 
								r = p.addFormula(f);
							
					}
					break;
				case 13 :
					// qtlSolver.g:342:6: LPAR op= G_inf_OP a= INT f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla396); 
					op=(Token)match(input,G_inf_OP,FOLLOW_G_inf_OP_in_fmla400); 
					a=(Token)match(input,INT,FOLLOW_INT_in_fmla404); 
					pushFollow(FOLLOW_fmla_in_fmla408);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla410); 
						
								Formula f = null;
								String s = String.valueOf((op!=null?op.getText():null));
								
								if (tlogic.equals("qtl")){
									if (s.compareTo("G_e+") == 0)
										f = QTLFormula.G((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN); 
									else
										f = QTLFormula.G((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED); 
								} else if (tlogic.equals("qtl-i")){
									if (s.compareTo("G_e+") == 0)
										f = QTLIFormula.G((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN); 
									else
										f = QTLIFormula.G((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED); 
								} else if (tlogic.equals("mitl")){
									if (s.compareTo("G_e+") == 0 || s.compareTo("G_i+") == 0)
										f = MITLFormula.G_inf((MITLFormula)f1, Integer.valueOf((a!=null?a.getText():null))); 
								} else if (tlogic.equals("mitl-i")){
									if (s.compareTo("G_e+") == 0 || s.compareTo("G_i+") == 0)
										f = MITLIFormula.G_inf((MITLIFormula)f1, Integer.valueOf((a!=null?a.getText():null))); 
								}
								
									 
								r = p.addFormula(f);
							
					}
					break;
				case 14 :
					// qtlSolver.g:368:6: LPAR P_OP a= INT b= INT f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla423); 
					P_OP8=(Token)match(input,P_OP,FOLLOW_P_OP_in_fmla425); 
					a=(Token)match(input,INT,FOLLOW_INT_in_fmla429); 
					b=(Token)match(input,INT,FOLLOW_INT_in_fmla433); 
					pushFollow(FOLLOW_fmla_in_fmla437);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla439); 
						
								Formula f = null;
								String s = String.valueOf((P_OP8!=null?P_OP8.getText():null));
								
								
								if (tlogic.equals("qtl")){
									if (s.compareTo("P_ee") == 0)
										f = QTLFormula.P((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else if (s.compareTo("P_ei") == 0)
										f = QTLFormula.P((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED); 
									else if (s.compareTo("P_ie") == 0)	
										f = QTLFormula.P((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else
										f = QTLFormula.P((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED);
								} else if (tlogic.equals("qtl-i")){
									if (s.compareTo("P_ee") == 0)
										f = QTLIFormula.P((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else if (s.compareTo("P_ei") == 0)
										f = QTLIFormula.P((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED); 
									else if (s.compareTo("P_ie") == 0)	
										f = QTLIFormula.P((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else
										f = QTLIFormula.P((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED);
								} else if (tlogic.equals("mitl")){
										f = null;
								} else if (tlogic.equals("mitl-i")){
										if (s.compareTo("P_ie") == 0 || s.compareTo("P_ii") == 0)
										f = MITLIFormula.P((MITLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Integer.valueOf((b!=null?b.getText():null))); 
								}
									 
								r = p.addFormula(f);
							
					}
					break;
				case 15 :
					// qtlSolver.g:401:6: LPAR H_OP a= INT b= INT f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla452); 
					H_OP9=(Token)match(input,H_OP,FOLLOW_H_OP_in_fmla454); 
					a=(Token)match(input,INT,FOLLOW_INT_in_fmla458); 
					b=(Token)match(input,INT,FOLLOW_INT_in_fmla462); 
					pushFollow(FOLLOW_fmla_in_fmla466);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla468); 
						
								Formula f = null;
								String s = String.valueOf((H_OP9!=null?H_OP9.getText():null));
								
								
								if (tlogic.equals("qtl")){
									f = null;
								} else if (tlogic.equals("qtl-i")){
									if (s.compareTo("H_ee") == 0)
										f = QTLIFormula.H((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else if (s.compareTo("H_ei") == 0)
										f = QTLIFormula.H((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED); 
									else if (s.compareTo("H_ie") == 0)	
										f = QTLIFormula.H((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else
										f = QTLIFormula.H((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED);
								} else if (tlogic.equals("mitl")){
										f = null;
								} else if (tlogic.equals("mitl-i")){
										if (s.compareTo("H_ei") == 0 || s.compareTo("H_ii") == 0)
										f = MITLIFormula.H((MITLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Integer.valueOf((b!=null?b.getText():null))); 
								}
									 
								r = p.addFormula(f);
							
					}
					break;
				case 16 :
					// qtlSolver.g:427:6: LPAR UNTIL_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla488); 
					match(input,UNTIL_OP,FOLLOW_UNTIL_OP_in_fmla490); 
					pushFollow(FOLLOW_fmla_in_fmla494);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla498);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla500); 

								Formula f = null;
								if (tlogic.equals("qtl"))
								 	f = QTLFormula.U((QTLFormula)f1,(QTLFormula)f2);
								else if (tlogic.equals("qtl-i"))
								 	f = QTLIFormula.U((QTLIFormula)f1,(QTLIFormula)f2);
								else if (tlogic.equals("mitl"))
									f = MITLFormula.U((MITLFormula)f1,(MITLFormula)f2);
								else if (tlogic.equals("mitl-i"))
									f = MITLIFormula.U((MITLIFormula)f1,(MITLIFormula)f2);
									
									
								r = p.addFormula(f);
							
					}
					break;
				case 17 :
					// qtlSolver.g:442:6: LPAR SINCE_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla512); 
					match(input,SINCE_OP,FOLLOW_SINCE_OP_in_fmla514); 
					pushFollow(FOLLOW_fmla_in_fmla518);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla522);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla524); 

								Formula f = null;
								if (tlogic.equals("qtl"))
								 	f = QTLFormula.S((QTLFormula)f1,(QTLFormula)f2);
								else if (tlogic.equals("qtl-i"))
								 	f = QTLIFormula.S((QTLIFormula)f1,(QTLIFormula)f2);
								else if (tlogic.equals("mitl"))
									f = null;
								else if (tlogic.equals("mitl-i"))
									f = MITLIFormula.S((MITLIFormula)f1,(MITLIFormula)f2);
								 	
								r = p.addFormula(f); 	
							
					}
					break;
				case 18 :
					// qtlSolver.g:456:6: LPAR RELEASE_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla538); 
					match(input,RELEASE_OP,FOLLOW_RELEASE_OP_in_fmla540); 
					pushFollow(FOLLOW_fmla_in_fmla544);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla548);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla550); 

								Formula f = null;
								if (tlogic.equals("qtl"))
								 	f = QTLFormula.R((QTLFormula)f1,(QTLFormula)f2);
								else if (tlogic.equals("qtl-i"))
								 	f = QTLIFormula.R((QTLIFormula)f1,(QTLIFormula)f2);	
								else if (tlogic.equals("mitl"))
								 	f = MITLFormula.R((MITLFormula)f1,(MITLFormula)f2);
								else if (tlogic.equals("mitl-i"))
								 	f = MITLIFormula.R((MITLIFormula)f1,(MITLIFormula)f2);
								 	
								r = p.addFormula(f);
							
					}
					break;
				case 19 :
					// qtlSolver.g:470:6: LPAR TRIGGER_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla562); 
					match(input,TRIGGER_OP,FOLLOW_TRIGGER_OP_in_fmla564); 
					pushFollow(FOLLOW_fmla_in_fmla568);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla572);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla574); 

								Formula f = null;
								if (tlogic.equals("qtl"))
								 	f = QTLFormula.T((QTLFormula)f1,(QTLFormula)f2);
								else if (tlogic.equals("qtl-i"))
								 	f = QTLIFormula.T((QTLIFormula)f1,(QTLIFormula)f2);
								 		
								r = p.addFormula(f);
							
					}
					break;
				case 20 :
					// qtlSolver.g:481:4: LPAR COUNT_OP n= INT b= INT f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla587); 
					match(input,COUNT_OP,FOLLOW_COUNT_OP_in_fmla589); 
					n=(Token)match(input,INT,FOLLOW_INT_in_fmla593); 
					b=(Token)match(input,INT,FOLLOW_INT_in_fmla597); 
					pushFollow(FOLLOW_fmla_in_fmla601);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla603); 

						      Formula f;
						      f = QTLIFormula.count((QTLIFormula)f1,Integer.valueOf((b!=null?b.getText():null)),Integer.valueOf((n!=null?n.getText():null)));
						  	  r = p.addFormula(f);
						  
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return r;
	}
	// $ANTLR end "fmla"



	// $ANTLR start "conjuncts_list"
	// qtlSolver.g:491:1: conjuncts_list returns [List<Formula> l] : f1= fmla (clist= conjuncts_list |) ;
	public final List<Formula> conjuncts_list() throws RecognitionException {
		List<Formula> l = null;


		Formula f1 =null;
		List<Formula> clist =null;

		l = new ArrayList<Formula>();
		try {
			// qtlSolver.g:492:38: (f1= fmla (clist= conjuncts_list |) )
			// qtlSolver.g:494:2: f1= fmla (clist= conjuncts_list |)
			{
			pushFollow(FOLLOW_fmla_in_conjuncts_list638);
			f1=fmla();
			state._fsp--;

			// qtlSolver.g:494:10: (clist= conjuncts_list |)
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==FALSE||LA4_0==ID||LA4_0==LPAR||LA4_0==TRUE) ) {
				alt4=1;
			}
			else if ( (LA4_0==RPAR) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// qtlSolver.g:494:11: clist= conjuncts_list
					{
					pushFollow(FOLLOW_conjuncts_list_in_conjuncts_list643);
					clist=conjuncts_list();
					state._fsp--;

					}
					break;
				case 2 :
					// qtlSolver.g:494:34: 
					{
					}
					break;

			}


						if (clist == null)
							l.add(f1);
						else{
							(clist).add(f1);
							l = new ArrayList<Formula>(clist);
						}
							
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return l;
	}
	// $ANTLR end "conjuncts_list"

	// Delegated rules



	public static final BitSet FOLLOW_logic_in_tlparser35 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_NEWLINE_in_tlparser37 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_tlparser48 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_tlparser50 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_NEWLINE_in_tlparser52 = new BitSet(new long[]{0x0000003000800000L});
	public static final BitSet FOLLOW_declaration_in_tlparser62 = new BitSet(new long[]{0x0000003000800000L});
	public static final BitSet FOLLOW_37_in_tlparser68 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_tlparser70 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_NEWLINE_in_tlparser77 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_logic92 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_LOGIC_in_logic94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_declaration108 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_declaration112 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_declaration118 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_NEWLINE_in_declaration131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_declaration137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla161 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla165 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_fmla176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_fmla185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fmla196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla207 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_NEG_OP_in_fmla209 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla213 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla227 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_AND_OP_in_fmla229 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_conjuncts_list_in_fmla233 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla246 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_OR_OP_in_fmla248 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_conjuncts_list_in_fmla252 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla265 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_IMPL_OP_in_fmla267 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla271 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla275 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla288 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_IFF_OP_in_fmla290 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla294 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla298 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla312 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_F_OP_in_fmla314 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_fmla318 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_fmla322 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla326 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla340 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_F_inf_OP_in_fmla342 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_fmla346 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla350 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla352 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla366 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_G_OP_in_fmla370 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_fmla374 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_fmla378 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla382 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla396 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_G_inf_OP_in_fmla400 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_fmla404 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla408 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla423 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_P_OP_in_fmla425 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_fmla429 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_fmla433 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla437 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla439 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla452 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_H_OP_in_fmla454 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_fmla458 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_fmla462 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla466 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla488 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_UNTIL_OP_in_fmla490 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla494 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla498 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla512 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_SINCE_OP_in_fmla514 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla518 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla522 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla538 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_RELEASE_OP_in_fmla540 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla544 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla548 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla550 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla562 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_TRIGGER_OP_in_fmla564 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla568 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla572 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla587 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COUNT_OP_in_fmla589 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_fmla593 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INT_in_fmla597 = new BitSet(new long[]{0x0000000100208200L});
	public static final BitSet FOLLOW_fmla_in_fmla601 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla603 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fmla_in_conjuncts_list638 = new BitSet(new long[]{0x0000000100208202L});
	public static final BitSet FOLLOW_conjuncts_list_in_conjuncts_list643 = new BitSet(new long[]{0x0000000000000002L});
}
