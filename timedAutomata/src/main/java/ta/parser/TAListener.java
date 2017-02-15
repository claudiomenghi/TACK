// Generated from TA.g4 by ANTLR 4.6

package ta.parser;

import java.util.*;
import ta.expressions.*;
import ta.expressions.binary.*;
import ta.expressions.unary.*;
import ta.expressions.ternary.*;
import ta.*;
import ta.transition.Transition;
import ta.transition.Guard;
import ta.transition.EQCondition;
import ta.SystemDecl;
import ta.declarations.Initializer;
import ta.declarations.Variable;
import ta.declarations.Variable;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import ta.TA;
import ta.transition.Assign;
import ta.transition.EQAssignement;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TAParser}.
 */
public interface TAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TAParser#ta}.
	 * @param ctx the parse tree
	 */
	void enterTa(TAParser.TaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#ta}.
	 * @param ctx the parse tree
	 */
	void exitTa(TAParser.TaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(TAParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(TAParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void enterInstantiation(TAParser.InstantiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void exitInstantiation(TAParser.InstantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#system}.
	 * @param ctx the parse tree
	 */
	void enterSystem(TAParser.SystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#system}.
	 * @param ctx the parse tree
	 */
	void exitSystem(TAParser.SystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(TAParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(TAParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(TAParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(TAParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#procDecl}.
	 * @param ctx the parse tree
	 */
	void enterProcDecl(TAParser.ProcDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#procDecl}.
	 * @param ctx the parse tree
	 */
	void exitProcDecl(TAParser.ProcDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#procBody}.
	 * @param ctx the parse tree
	 */
	void enterProcBody(TAParser.ProcBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#procBody}.
	 * @param ctx the parse tree
	 */
	void exitProcBody(TAParser.ProcBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecl(TAParser.VariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecl(TAParser.VariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#variableId}.
	 * @param ctx the parse tree
	 */
	void enterVariableId(TAParser.VariableIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#variableId}.
	 * @param ctx the parse tree
	 */
	void exitVariableId(TAParser.VariableIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDecl(TAParser.ArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDecl(TAParser.ArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void enterInitialiser(TAParser.InitialiserContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void exitInitialiser(TAParser.InitialiserContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TAParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TAParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#fieldDeclId}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclId(TAParser.FieldDeclIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#fieldDeclId}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclId(TAParser.FieldDeclIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#prefix}.
	 * @param ctx the parse tree
	 */
	void enterPrefix(TAParser.PrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#prefix}.
	 * @param ctx the parse tree
	 */
	void exitPrefix(TAParser.PrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(TAParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(TAParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#commit}.
	 * @param ctx the parse tree
	 */
	void enterCommit(TAParser.CommitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#commit}.
	 * @param ctx the parse tree
	 */
	void exitCommit(TAParser.CommitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#urgent}.
	 * @param ctx the parse tree
	 */
	void enterUrgent(TAParser.UrgentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#urgent}.
	 * @param ctx the parse tree
	 */
	void exitUrgent(TAParser.UrgentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#stateList}.
	 * @param ctx the parse tree
	 */
	void enterStateList(TAParser.StateListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#stateList}.
	 * @param ctx the parse tree
	 */
	void exitStateList(TAParser.StateListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void enterTypeDecl(TAParser.TypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void exitTypeDecl(TAParser.TypeDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#typeIdList}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdList(TAParser.TypeIdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#typeIdList}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdList(TAParser.TypeIdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(TAParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(TAParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(TAParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(TAParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(TAParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(TAParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(TAParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(TAParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#caseocc}.
	 * @param ctx the parse tree
	 */
	void enterCaseocc(TAParser.CaseoccContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#caseocc}.
	 * @param ctx the parse tree
	 */
	void exitCaseocc(TAParser.CaseoccContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#states}.
	 * @param ctx the parse tree
	 */
	void enterStates(TAParser.StatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#states}.
	 * @param ctx the parse tree
	 */
	void exitStates(TAParser.StatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#stateDecl}.
	 * @param ctx the parse tree
	 */
	void enterStateDecl(TAParser.StateDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#stateDecl}.
	 * @param ctx the parse tree
	 */
	void exitStateDecl(TAParser.StateDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(TAParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(TAParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#transitions}.
	 * @param ctx the parse tree
	 */
	void enterTransitions(TAParser.TransitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#transitions}.
	 * @param ctx the parse tree
	 */
	void exitTransitions(TAParser.TransitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#transitionset}.
	 * @param ctx the parse tree
	 */
	void enterTransitionset(TAParser.TransitionsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#transitionset}.
	 * @param ctx the parse tree
	 */
	void exitTransitionset(TAParser.TransitionsetContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#transitionBody}.
	 * @param ctx the parse tree
	 */
	void enterTransitionBody(TAParser.TransitionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#transitionBody}.
	 * @param ctx the parse tree
	 */
	void exitTransitionBody(TAParser.TransitionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuard(TAParser.GuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuard(TAParser.GuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#conditionList}.
	 * @param ctx the parse tree
	 */
	void enterConditionList(TAParser.ConditionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#conditionList}.
	 * @param ctx the parse tree
	 */
	void exitConditionList(TAParser.ConditionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(TAParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(TAParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#sync}.
	 * @param ctx the parse tree
	 */
	void enterSync(TAParser.SyncContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#sync}.
	 * @param ctx the parse tree
	 */
	void exitSync(TAParser.SyncContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(TAParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(TAParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#assignmentList}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentList(TAParser.AssignmentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#assignmentList}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentList(TAParser.AssignmentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#simpleassigment}.
	 * @param ctx the parse tree
	 */
	void enterSimpleassigment(TAParser.SimpleassigmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#simpleassigment}.
	 * @param ctx the parse tree
	 */
	void exitSimpleassigment(TAParser.SimpleassigmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(TAParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(TAParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TAParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TAParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(TAParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(TAParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TAParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(TAParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TAParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(TAParser.ArgListContext ctx);
}