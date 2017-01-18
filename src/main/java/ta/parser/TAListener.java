// Generated from TA.g4 by ANTLR 4.4

package ta.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TAParser}.
 */
public interface TAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TAParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(@NotNull TAParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(@NotNull TAParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#prefix}.
	 * @param ctx the parse tree
	 */
	void enterPrefix(@NotNull TAParser.PrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#prefix}.
	 * @param ctx the parse tree
	 */
	void exitPrefix(@NotNull TAParser.PrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#transitionOpt}.
	 * @param ctx the parse tree
	 */
	void enterTransitionOpt(@NotNull TAParser.TransitionOptContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#transitionOpt}.
	 * @param ctx the parse tree
	 */
	void exitTransitionOpt(@NotNull TAParser.TransitionOptContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#declId}.
	 * @param ctx the parse tree
	 */
	void enterDeclId(@NotNull TAParser.DeclIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#declId}.
	 * @param ctx the parse tree
	 */
	void exitDeclId(@NotNull TAParser.DeclIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#commit}.
	 * @param ctx the parse tree
	 */
	void enterCommit(@NotNull TAParser.CommitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#commit}.
	 * @param ctx the parse tree
	 */
	void exitCommit(@NotNull TAParser.CommitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(@NotNull TAParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(@NotNull TAParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#transitions}.
	 * @param ctx the parse tree
	 */
	void enterTransitions(@NotNull TAParser.TransitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#transitions}.
	 * @param ctx the parse tree
	 */
	void exitTransitions(@NotNull TAParser.TransitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull TAParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull TAParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#fieldDeclId}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclId(@NotNull TAParser.FieldDeclIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#fieldDeclId}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclId(@NotNull TAParser.FieldDeclIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#ternaryexpressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterTernaryexpressionPrime(@NotNull TAParser.TernaryexpressionPrimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#ternaryexpressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitTernaryexpressionPrime(@NotNull TAParser.TernaryexpressionPrimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void enterInitialiser(@NotNull TAParser.InitialiserContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void exitInitialiser(@NotNull TAParser.InitialiserContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterRel(@NotNull TAParser.RelContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitRel(@NotNull TAParser.RelContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull TAParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull TAParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#binexpression}.
	 * @param ctx the parse tree
	 */
	void enterBinexpression(@NotNull TAParser.BinexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#binexpression}.
	 * @param ctx the parse tree
	 */
	void exitBinexpression(@NotNull TAParser.BinexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#typeIdList}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdList(@NotNull TAParser.TypeIdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#typeIdList}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdList(@NotNull TAParser.TypeIdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#transitionBody}.
	 * @param ctx the parse tree
	 */
	void enterTransitionBody(@NotNull TAParser.TransitionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#transitionBody}.
	 * @param ctx the parse tree
	 */
	void exitTransitionBody(@NotNull TAParser.TransitionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#procBody}.
	 * @param ctx the parse tree
	 */
	void enterProcBody(@NotNull TAParser.ProcBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#procBody}.
	 * @param ctx the parse tree
	 */
	void exitProcBody(@NotNull TAParser.ProcBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void enterInstantiation(@NotNull TAParser.InstantiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void exitInstantiation(@NotNull TAParser.InstantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(@NotNull TAParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(@NotNull TAParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(@NotNull TAParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(@NotNull TAParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#procDecl}.
	 * @param ctx the parse tree
	 */
	void enterProcDecl(@NotNull TAParser.ProcDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#procDecl}.
	 * @param ctx the parse tree
	 */
	void exitProcDecl(@NotNull TAParser.ProcDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDecl(@NotNull TAParser.ArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDecl(@NotNull TAParser.ArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void enterTypeDecl(@NotNull TAParser.TypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void exitTypeDecl(@NotNull TAParser.TypeDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#sync}.
	 * @param ctx the parse tree
	 */
	void enterSync(@NotNull TAParser.SyncContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#sync}.
	 * @param ctx the parse tree
	 */
	void exitSync(@NotNull TAParser.SyncContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#system}.
	 * @param ctx the parse tree
	 */
	void enterSystem(@NotNull TAParser.SystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#system}.
	 * @param ctx the parse tree
	 */
	void exitSystem(@NotNull TAParser.SystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(@NotNull TAParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(@NotNull TAParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#binBoolOp}.
	 * @param ctx the parse tree
	 */
	void enterBinBoolOp(@NotNull TAParser.BinBoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#binBoolOp}.
	 * @param ctx the parse tree
	 */
	void exitBinBoolOp(@NotNull TAParser.BinBoolOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(@NotNull TAParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(@NotNull TAParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void enterAssignOp(@NotNull TAParser.AssignOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void exitAssignOp(@NotNull TAParser.AssignOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuard(@NotNull TAParser.GuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuard(@NotNull TAParser.GuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(@NotNull TAParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(@NotNull TAParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#caseocc}.
	 * @param ctx the parse tree
	 */
	void enterCaseocc(@NotNull TAParser.CaseoccContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#caseocc}.
	 * @param ctx the parse tree
	 */
	void exitCaseocc(@NotNull TAParser.CaseoccContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#fieldInit}.
	 * @param ctx the parse tree
	 */
	void enterFieldInit(@NotNull TAParser.FieldInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#fieldInit}.
	 * @param ctx the parse tree
	 */
	void exitFieldInit(@NotNull TAParser.FieldInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#states}.
	 * @param ctx the parse tree
	 */
	void enterStates(@NotNull TAParser.StatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#states}.
	 * @param ctx the parse tree
	 */
	void exitStates(@NotNull TAParser.StatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull TAParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull TAParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull TAParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull TAParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#urgent}.
	 * @param ctx the parse tree
	 */
	void enterUrgent(@NotNull TAParser.UrgentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#urgent}.
	 * @param ctx the parse tree
	 */
	void exitUrgent(@NotNull TAParser.UrgentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#idexpression}.
	 * @param ctx the parse tree
	 */
	void enterIdexpression(@NotNull TAParser.IdexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#idexpression}.
	 * @param ctx the parse tree
	 */
	void exitIdexpression(@NotNull TAParser.IdexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull TAParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull TAParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull TAParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull TAParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#binIntOp}.
	 * @param ctx the parse tree
	 */
	void enterBinIntOp(@NotNull TAParser.BinIntOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#binIntOp}.
	 * @param ctx the parse tree
	 */
	void exitBinIntOp(@NotNull TAParser.BinIntOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#stateList}.
	 * @param ctx the parse tree
	 */
	void enterStateList(@NotNull TAParser.StateListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#stateList}.
	 * @param ctx the parse tree
	 */
	void exitStateList(@NotNull TAParser.StateListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#ta}.
	 * @param ctx the parse tree
	 */
	void enterTa(@NotNull TAParser.TaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#ta}.
	 * @param ctx the parse tree
	 */
	void exitTa(@NotNull TAParser.TaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull TAParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull TAParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(@NotNull TAParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(@NotNull TAParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#ternaryexpression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryexpression(@NotNull TAParser.TernaryexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#ternaryexpression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryexpression(@NotNull TAParser.TernaryexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(@NotNull TAParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(@NotNull TAParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecl(@NotNull TAParser.VariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecl(@NotNull TAParser.VariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#stateDecl}.
	 * @param ctx the parse tree
	 */
	void enterStateDecl(@NotNull TAParser.StateDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#stateDecl}.
	 * @param ctx the parse tree
	 */
	void exitStateDecl(@NotNull TAParser.StateDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull TAParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull TAParser.AssignContext ctx);
}