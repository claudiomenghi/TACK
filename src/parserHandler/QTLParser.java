// $ANTLR 3.5 QTL.g 2013-04-19 19:07:46

package parserHandler;

import java.util.HashMap;
import delegateTranslator.*;
import formulae.*;
import formulae.QTL.*;
import formulae.QTLI.*;
import formulae.MITL.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QTLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND_OP", "ATOM", "COLON", "F_OP", 
		"F_inf_OP", "G_OP", "G_inf_OP", "H_OP", "ID", "IFF_OP", "IMPL_OP", "INT", 
		"LBRA", "LOGIC", "LPAR", "NEG_OP", "NEWLINE", "OR_OP", "P_OP", "RBRA", 
		"RELEASE_OP", "RPAR", "SEMI", "SINCE_OP", "TRIGGER_OP", "UNTIL_OP", "WS", 
		"':bound'", "':def'", "':formula'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public QTLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public QTLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return QTLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "QTL.g"; }


	/** Map variable name to Integer object holding value */
	HashMap<String, Formula> memory = new HashMap<String,Formula>();

	TLParserHandler p;
	String tlogic;



	// $ANTLR start "tlparser"
	// QTL.g:31:1: tlparser : l= logic NEWLINE ':bound' INT NEWLINE ( declaration )* ':formula' fmla NEWLINE ;
	public final void tlparser() throws RecognitionException {
		Token INT1=null;
		String l =null;
		Formula fmla2 =null;

		try {
			// QTL.g:31:9: (l= logic NEWLINE ':bound' INT NEWLINE ( declaration )* ':formula' fmla NEWLINE )
			// QTL.g:31:11: l= logic NEWLINE ':bound' INT NEWLINE ( declaration )* ':formula' fmla NEWLINE
			{
			pushFollow(FOLLOW_logic_in_tlparser35);
			l=logic();
			state._fsp--;

			match(input,NEWLINE,FOLLOW_NEWLINE_in_tlparser37); 
			 
							tlogic = l;
							if (tlogic.equals("qtl"))
								p = new QTLParserHandler();
							else if (tlogic.equals("qtl-opt"))
								p = new QTLIParserHandler();
							else if (tlogic.equals("mitl"))
								p = new MITLParserHandler();				 
					 	
			match(input,31,FOLLOW_31_in_tlparser48); 
			INT1=(Token)match(input,INT,FOLLOW_INT_in_tlparser50); 
			match(input,NEWLINE,FOLLOW_NEWLINE_in_tlparser52); 

							p.setHistoryLength(Integer.valueOf((INT1!=null?INT1.getText():null)));
							System.out.println("Starting parsing formulae...");
						
			// QTL.g:46:4: ( declaration )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==NEWLINE||LA1_0==32) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// QTL.g:46:4: declaration
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

			match(input,33,FOLLOW_33_in_tlparser68); 
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
	// QTL.g:71:1: logic returns [String s] : COLON LOGIC ;
	public final String logic() throws RecognitionException {
		String s = null;


		Token LOGIC3=null;

		try {
			// QTL.g:72:2: ( COLON LOGIC )
			// QTL.g:72:4: COLON LOGIC
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
	// QTL.g:75:1: declaration : ( ':def' s= ID fmla NEWLINE | NEWLINE );
	public final void declaration() throws RecognitionException {
		Token s=null;
		Formula fmla4 =null;

		try {
			// QTL.g:75:12: ( ':def' s= ID fmla NEWLINE | NEWLINE )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==32) ) {
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
					// QTL.g:75:14: ':def' s= ID fmla NEWLINE
					{
					match(input,32,FOLLOW_32_in_declaration108); 
					s=(Token)match(input,ID,FOLLOW_ID_in_declaration112); 
					pushFollow(FOLLOW_fmla_in_declaration118);
					fmla4=fmla();
					state._fsp--;


								 	memory.put((s!=null?s.getText():null), fmla4);
								 
					match(input,NEWLINE,FOLLOW_NEWLINE_in_declaration131); 
					}
					break;
				case 2 :
					// QTL.g:81:5: NEWLINE
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
	// QTL.g:84:1: fmla returns [Formula r] : ( ID | ATOM | LPAR NEG_OP f1= fmla RPAR | LPAR AND_OP f1= fmla f2= fmla RPAR | LPAR OR_OP f1= fmla f2= fmla RPAR | LPAR IMPL_OP f1= fmla f2= fmla RPAR | LPAR IFF_OP f1= fmla f2= fmla RPAR | LPAR F_OP a= INT b= INT f1= fmla RPAR | LPAR F_inf_OP a= INT f1= fmla RPAR | LPAR op= G_OP a= INT b= INT f1= fmla RPAR | LPAR op= G_inf_OP a= INT f1= fmla RPAR | LPAR UNTIL_OP f1= fmla f2= fmla RPAR | LPAR SINCE_OP f1= fmla f2= fmla RPAR | LPAR RELEASE_OP f1= fmla f2= fmla RPAR | LPAR TRIGGER_OP f1= fmla f2= fmla RPAR );
	public final Formula fmla() throws RecognitionException {
		Formula r = null;


		Token a=null;
		Token b=null;
		Token op=null;
		Token ID5=null;
		Token ATOM6=null;
		Token F_OP7=null;
		Token F_inf_OP8=null;
		Formula f1 =null;
		Formula f2 =null;

		try {
			// QTL.g:85:2: ( ID | ATOM | LPAR NEG_OP f1= fmla RPAR | LPAR AND_OP f1= fmla f2= fmla RPAR | LPAR OR_OP f1= fmla f2= fmla RPAR | LPAR IMPL_OP f1= fmla f2= fmla RPAR | LPAR IFF_OP f1= fmla f2= fmla RPAR | LPAR F_OP a= INT b= INT f1= fmla RPAR | LPAR F_inf_OP a= INT f1= fmla RPAR | LPAR op= G_OP a= INT b= INT f1= fmla RPAR | LPAR op= G_inf_OP a= INT f1= fmla RPAR | LPAR UNTIL_OP f1= fmla f2= fmla RPAR | LPAR SINCE_OP f1= fmla f2= fmla RPAR | LPAR RELEASE_OP f1= fmla f2= fmla RPAR | LPAR TRIGGER_OP f1= fmla f2= fmla RPAR )
			int alt3=15;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt3=1;
				}
				break;
			case ATOM:
				{
				alt3=2;
				}
				break;
			case LPAR:
				{
				switch ( input.LA(2) ) {
				case NEG_OP:
					{
					alt3=3;
					}
					break;
				case AND_OP:
					{
					alt3=4;
					}
					break;
				case OR_OP:
					{
					alt3=5;
					}
					break;
				case IMPL_OP:
					{
					alt3=6;
					}
					break;
				case IFF_OP:
					{
					alt3=7;
					}
					break;
				case F_OP:
					{
					alt3=8;
					}
					break;
				case F_inf_OP:
					{
					alt3=9;
					}
					break;
				case G_OP:
					{
					alt3=10;
					}
					break;
				case G_inf_OP:
					{
					alt3=11;
					}
					break;
				case UNTIL_OP:
					{
					alt3=12;
					}
					break;
				case SINCE_OP:
					{
					alt3=13;
					}
					break;
				case RELEASE_OP:
					{
					alt3=14;
					}
					break;
				case TRIGGER_OP:
					{
					alt3=15;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// QTL.g:85:6: ID
					{
					ID5=(Token)match(input,ID,FOLLOW_ID_in_fmla161); 
								
								if (memory.containsKey((ID5!=null?ID5.getText():null))){
									r = memory.get((ID5!=null?ID5.getText():null));					
								}
								
							
					}
					break;
				case 2 :
					// QTL.g:92:6: ATOM
					{
					ATOM6=(Token)match(input,ATOM,FOLLOW_ATOM_in_fmla172); 
						
								Formula f = null;
								if (tlogic.equals("qtl"))	
									f = new QTLAtom((ATOM6!=null?ATOM6.getText():null));
								else if (tlogic.equals("qtl-opt"))
									f = new QTLIAtom((ATOM6!=null?ATOM6.getText():null));
								else if (tlogic.equals("mitl"))
									f = new MITLAtom((ATOM6!=null?ATOM6.getText():null));
									
								r = p.addFormula(f);
								
							
					}
					break;
				case 3 :
					// QTL.g:105:4: LPAR NEG_OP f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla183); 
					match(input,NEG_OP,FOLLOW_NEG_OP_in_fmla185); 
					pushFollow(FOLLOW_fmla_in_fmla189);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla191); 
						
								Formula f = null;
								if (tlogic.equals("qtl")) 
									f = new QTLNegation((QTLFormula) f1);
								else if (tlogic.equals("qtl-opt")) 
									f = new QTLINegation((QTLIFormula) f1);
								else if (tlogic.equals("mitl"))
									f = new MITLNegation((MITLFormula) f1);
									
								r = p.addFormula(f);
							
					}
					break;
				case 4 :
					// QTL.g:117:6: LPAR AND_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla203); 
					match(input,AND_OP,FOLLOW_AND_OP_in_fmla205); 
					pushFollow(FOLLOW_fmla_in_fmla209);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla213);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla215); 
						
								Formula f = null;
								if (tlogic.equals("qtl")) 
									f = new QTLConjunction((QTLFormula)f1,(QTLFormula)f2);
								else if (tlogic.equals("qtl-opt")) 
									f = new QTLIConjunction((QTLIFormula)f1,(QTLIFormula)f2);	
								else if (tlogic.equals("mitl"))
									f = new MITLConjunction((MITLFormula)f1,(MITLFormula)f2);
										
								r = p.addFormula(f);
							
					}
					break;
				case 5 :
					// QTL.g:129:6: LPAR OR_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla226); 
					match(input,OR_OP,FOLLOW_OR_OP_in_fmla228); 
					pushFollow(FOLLOW_fmla_in_fmla232);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla236);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla238); 
						
								Formula f = null;
								if (tlogic.equals("qtl")) 
									f = QTLFormula.or((QTLFormula)f1, (QTLFormula)f2);
								else if (tlogic.equals("qtl-opt")) 
									f = new QTLIDisjunction((QTLIFormula)f1,(QTLIFormula)f2);		
								else if (tlogic.equals("mitl"))
									f = MITLFormula.or((MITLFormula)f1, (MITLFormula)f2);
									
								r = p.addFormula(f);	
							
					}
					break;
				case 6 :
					// QTL.g:141:6: LPAR IMPL_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla249); 
					match(input,IMPL_OP,FOLLOW_IMPL_OP_in_fmla251); 
					pushFollow(FOLLOW_fmla_in_fmla255);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla259);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla261); 
						
								Formula f = null; 
								if (tlogic.equals("qtl")) 
									f = QTLFormula.implies((QTLFormula)f1, (QTLFormula)f2);
								else if (tlogic.equals("qtl-opt")) 
									f = QTLIFormula.implies((QTLIFormula)f1,(QTLIFormula)f2);		
								else if (tlogic.equals("mitl"))
									f = MITLFormula.implies((MITLFormula)f1, (MITLFormula)f2);	
									
								r = p.addFormula(f);	
							
					}
					break;
				case 7 :
					// QTL.g:153:6: LPAR IFF_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla272); 
					match(input,IFF_OP,FOLLOW_IFF_OP_in_fmla274); 
					pushFollow(FOLLOW_fmla_in_fmla278);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla282);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla284); 
						
								Formula f = null; 
								if (tlogic.equals("qtl")) 
									f = QTLFormula.iff((QTLFormula)f1, (QTLFormula)f2);
								else if (tlogic.equals("qtl-opt")) 
									f = QTLIFormula.iff((QTLIFormula)f1,(QTLIFormula)f2);		
								else if (tlogic.equals("mitl"))
									f = MITLFormula.iff((MITLFormula)f1, (MITLFormula)f2);
									
								r = p.addFormula(f);		
							
					}
					break;
				case 8 :
					// QTL.g:165:6: LPAR F_OP a= INT b= INT f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla296); 
					F_OP7=(Token)match(input,F_OP,FOLLOW_F_OP_in_fmla298); 
					a=(Token)match(input,INT,FOLLOW_INT_in_fmla302); 
					b=(Token)match(input,INT,FOLLOW_INT_in_fmla306); 
					pushFollow(FOLLOW_fmla_in_fmla310);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla312); 
						
								Formula f = null;
								String s = String.valueOf((F_OP7!=null?F_OP7.getText():null));
								
								
								if (tlogic.equals("qtl")){
									if (s.compareTo("F_ee") == 0)
										f = QTLFormula.F((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else if (s.compareTo("F_ei") == 0)
										f = QTLFormula.F((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED); 
									else if (s.compareTo("F_ie") == 0)	
										f = QTLFormula.F((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.OPEN); 
									else
										f = QTLFormula.F((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED, Integer.valueOf((b!=null?b.getText():null)), Bounds.CLOSED);
								} else if (tlogic.equals("qtl-opt")){
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
								}
									 
								r = p.addFormula(f);
							
					}
					break;
				case 9 :
					// QTL.g:196:6: LPAR F_inf_OP a= INT f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla324); 
					F_inf_OP8=(Token)match(input,F_inf_OP,FOLLOW_F_inf_OP_in_fmla326); 
					a=(Token)match(input,INT,FOLLOW_INT_in_fmla330); 
					pushFollow(FOLLOW_fmla_in_fmla334);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla336); 
						
								Formula f = null;
								String s = String.valueOf((F_inf_OP8!=null?F_inf_OP8.getText():null));
								
								if (tlogic.equals("qtl")){
									if (s.compareTo("F_e+") == 0)
										f = QTLFormula.F((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN); 
									else
										f = QTLFormula.F((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED); 
								} else if (tlogic.equals("qtl-opt")){
									if (s.compareTo("F_e+") == 0)
										f = QTLIFormula.F((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN); 
									else
										f = QTLIFormula.F((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED); 
								} else if (tlogic.equals("mitl")){
									if (s.compareTo("F_e+") == 0 || s.compareTo("F_i+") == 0)
										f = MITLFormula.F_inf((MITLFormula)f1, Integer.valueOf((a!=null?a.getText():null)));  
								}
									 
								r = p.addFormula(f);
							
					}
					break;
				case 10 :
					// QTL.g:218:6: LPAR op= G_OP a= INT b= INT f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla350); 
					op=(Token)match(input,G_OP,FOLLOW_G_OP_in_fmla354); 
					a=(Token)match(input,INT,FOLLOW_INT_in_fmla358); 
					b=(Token)match(input,INT,FOLLOW_INT_in_fmla362); 
					pushFollow(FOLLOW_fmla_in_fmla366);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla368); 
						
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
								} else if (tlogic.equals("qtl-opt")){
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
								}
									 
								r = p.addFormula(f);
							
					}
					break;
				case 11 :
					// QTL.g:248:6: LPAR op= G_inf_OP a= INT f1= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla380); 
					op=(Token)match(input,G_inf_OP,FOLLOW_G_inf_OP_in_fmla384); 
					a=(Token)match(input,INT,FOLLOW_INT_in_fmla388); 
					pushFollow(FOLLOW_fmla_in_fmla392);
					f1=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla394); 
						
								Formula f = null;
								String s = String.valueOf((op!=null?op.getText():null));
								
								if (tlogic.equals("qtl")){
									if (s.compareTo("G_e+") == 0)
										f = QTLFormula.G((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN); 
									else
										f = QTLFormula.G((QTLFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED); 
								} else if (tlogic.equals("qtl-opt")){
									if (s.compareTo("G_e+") == 0)
										f = QTLIFormula.G((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.OPEN); 
									else
										f = QTLIFormula.G((QTLIFormula)f1, Integer.valueOf((a!=null?a.getText():null)), Bounds.CLOSED); 
								} else if (tlogic.equals("mitl")){
									if (s.compareTo("G_e+") == 0 || s.compareTo("G_i+") == 0)
										f = MITLFormula.G_inf((MITLFormula)f1, Integer.valueOf((a!=null?a.getText():null))); 
								}
								
									 
								r = p.addFormula(f);
							
					}
					break;
				case 12 :
					// QTL.g:271:6: LPAR UNTIL_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla410); 
					match(input,UNTIL_OP,FOLLOW_UNTIL_OP_in_fmla412); 
					pushFollow(FOLLOW_fmla_in_fmla416);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla420);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla422); 

								Formula f = null;
								if (tlogic.equals("qtl"))
								 	f = new QTLUntil((QTLFormula)f1,(QTLFormula)f2);
								else if (tlogic.equals("qtl-opt"))
								 	f = new QTLIUntil((QTLIFormula)f1,(QTLIFormula)f2);
								else if (tlogic.equals("mitl"))
									f = new MITLUntil((MITLFormula)f1,(MITLFormula)f2);
									
								r = p.addFormula(f);
							
					}
					break;
				case 13 :
					// QTL.g:283:6: LPAR SINCE_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla434); 
					match(input,SINCE_OP,FOLLOW_SINCE_OP_in_fmla436); 
					pushFollow(FOLLOW_fmla_in_fmla440);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla444);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla446); 

								Formula f = null;
								if (tlogic.equals("qtl"))
								 	f = new QTLSince((QTLFormula)f1,(QTLFormula)f2);
								else if (tlogic.equals("qtl-opt"))
								 	f = new QTLISince((QTLIFormula)f1,(QTLIFormula)f2);
							
					}
					break;
				case 14 :
					// QTL.g:291:6: LPAR RELEASE_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla460); 
					match(input,RELEASE_OP,FOLLOW_RELEASE_OP_in_fmla462); 
					pushFollow(FOLLOW_fmla_in_fmla466);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla470);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla472); 

								Formula f = null;
								if (tlogic.equals("qtl"))
								 	f = QTLFormula.R((QTLFormula)f1,(QTLFormula)f2);
								else if (tlogic.equals("qtl-opt"))
								 	f = QTLIFormula.R((QTLIFormula)f1,(QTLIFormula)f2);	
								else if (tlogic.equals("mitl"))
								 	f = MITLFormula.R((MITLFormula)f1,(MITLFormula)f2);
								 	
								r = p.addFormula(f);
							
					}
					break;
				case 15 :
					// QTL.g:303:6: LPAR TRIGGER_OP f1= fmla f2= fmla RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_fmla484); 
					match(input,TRIGGER_OP,FOLLOW_TRIGGER_OP_in_fmla486); 
					pushFollow(FOLLOW_fmla_in_fmla490);
					f1=fmla();
					state._fsp--;

					pushFollow(FOLLOW_fmla_in_fmla494);
					f2=fmla();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fmla496); 

								Formula f = null;
								if (tlogic.equals("qtl"))
								 	f = QTLFormula.T((QTLFormula)f1,(QTLFormula)f2);
								else if (tlogic.equals("qtl-opt"))
								 	f = QTLIFormula.T((QTLIFormula)f1,(QTLIFormula)f2);
								 		
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

	// Delegated rules



	public static final BitSet FOLLOW_logic_in_tlparser35 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_NEWLINE_in_tlparser37 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_tlparser48 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INT_in_tlparser50 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_NEWLINE_in_tlparser52 = new BitSet(new long[]{0x0000000300100000L});
	public static final BitSet FOLLOW_declaration_in_tlparser62 = new BitSet(new long[]{0x0000000300100000L});
	public static final BitSet FOLLOW_33_in_tlparser68 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_tlparser70 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_NEWLINE_in_tlparser77 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_logic92 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_LOGIC_in_logic94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_declaration108 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_ID_in_declaration112 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_declaration118 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_NEWLINE_in_declaration131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_declaration137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fmla161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATOM_in_fmla172 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla183 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_NEG_OP_in_fmla185 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla189 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla203 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_AND_OP_in_fmla205 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla209 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla213 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla226 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_OR_OP_in_fmla228 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla232 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla236 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla249 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IMPL_OP_in_fmla251 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla255 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla259 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla272 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_IFF_OP_in_fmla274 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla278 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla282 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla296 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_F_OP_in_fmla298 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INT_in_fmla302 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INT_in_fmla306 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla310 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla312 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla324 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_F_inf_OP_in_fmla326 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INT_in_fmla330 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla334 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla350 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_G_OP_in_fmla354 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INT_in_fmla358 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INT_in_fmla362 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla366 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla368 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla380 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_G_inf_OP_in_fmla384 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INT_in_fmla388 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla392 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla394 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla410 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_UNTIL_OP_in_fmla412 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla416 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla420 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla434 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_SINCE_OP_in_fmla436 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla440 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla444 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla460 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RELEASE_OP_in_fmla462 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla466 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla470 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fmla484 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_TRIGGER_OP_in_fmla486 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla490 = new BitSet(new long[]{0x0000000000041020L});
	public static final BitSet FOLLOW_fmla_in_fmla494 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_fmla496 = new BitSet(new long[]{0x0000000000000002L});
}
