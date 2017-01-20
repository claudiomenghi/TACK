// Generated from TA.g4 by ANTLR 4.4

package ta.parser;

import java.util.*;
import ta.expressions.*;
import ta.expressions.binary.*;
import ta.expressions.unary.*;
import ta.expressions.ternary.*;
import ta.*;
import ta.Transition;
import ta.SystemDecl;
import ta.TA;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TAParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TAVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TAParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(@NotNull TAParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(@NotNull TAParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix(@NotNull TAParser.PrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard(@NotNull TAParser.GuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#commit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommit(@NotNull TAParser.CommitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(@NotNull TAParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull TAParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#fieldDeclId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclId(@NotNull TAParser.FieldDeclIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#caseocc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseocc(@NotNull TAParser.CaseoccContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#transitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransitions(@NotNull TAParser.TransitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStates(@NotNull TAParser.StatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#initialiser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialiser(@NotNull TAParser.InitialiserContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull TAParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull TAParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull TAParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#urgent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrgent(@NotNull TAParser.UrgentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#typeIdList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdList(@NotNull TAParser.TypeIdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#transitionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransitionBody(@NotNull TAParser.TransitionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#procBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcBody(@NotNull TAParser.ProcBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#instantiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiation(@NotNull TAParser.InstantiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(@NotNull TAParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull TAParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(@NotNull TAParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull TAParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#procDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcDecl(@NotNull TAParser.ProcDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#stateList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateList(@NotNull TAParser.StateListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDecl(@NotNull TAParser.ArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#typeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDecl(@NotNull TAParser.TypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#ta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTa(@NotNull TAParser.TaContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull TAParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#variableId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableId(@NotNull TAParser.VariableIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#sync}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSync(@NotNull TAParser.SyncContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#system}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystem(@NotNull TAParser.SystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#transitionset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransitionset(@NotNull TAParser.TransitionsetContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(@NotNull TAParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(@NotNull TAParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#variableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDecl(@NotNull TAParser.VariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#stateDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateDecl(@NotNull TAParser.StateDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull TAParser.AssignContext ctx);
}