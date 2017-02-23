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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MITLIParser}.
 */
public interface MITLIListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MITLIParser#mitli}.
	 * @param ctx the parse tree
	 */
	void enterMitli(MITLIParser.MitliContext ctx);
	/**
	 * Exit a parse tree produced by {@link MITLIParser#mitli}.
	 * @param ctx the parse tree
	 */
	void exitMitli(MITLIParser.MitliContext ctx);
	/**
	 * Enter a parse tree produced by {@link MITLIParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterLogic(MITLIParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by {@link MITLIParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitLogic(MITLIParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by {@link MITLIParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MITLIParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MITLIParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MITLIParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MITLIParser#fmla}.
	 * @param ctx the parse tree
	 */
	void enterFmla(MITLIParser.FmlaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MITLIParser#fmla}.
	 * @param ctx the parse tree
	 */
	void exitFmla(MITLIParser.FmlaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MITLIParser#conjuncts_list}.
	 * @param ctx the parse tree
	 */
	void enterConjuncts_list(MITLIParser.Conjuncts_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MITLIParser#conjuncts_list}.
	 * @param ctx the parse tree
	 */
	void exitConjuncts_list(MITLIParser.Conjuncts_listContext ctx);
}