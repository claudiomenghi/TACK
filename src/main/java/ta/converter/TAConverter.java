package ta.converter;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import ta.AP;
import ta.State;
import ta.TA;
import ta.Transition;
import ta.parser.TAListener;
import ta.parser.TAParser.ArgListContext;
import ta.parser.TAParser.ArrayDeclContext;
import ta.parser.TAParser.AssignContext;
import ta.parser.TAParser.AssignOpContext;
import ta.parser.TAParser.AssignmentContext;
import ta.parser.TAParser.BinBoolOpContext;
import ta.parser.TAParser.BinIntOpContext;
import ta.parser.TAParser.BinexpressionContext;
import ta.parser.TAParser.BlockContext;
import ta.parser.TAParser.CaseoccContext;
import ta.parser.TAParser.CommitContext;
import ta.parser.TAParser.DeclIdContext;
import ta.parser.TAParser.DeclarationContext;
import ta.parser.TAParser.ExprListContext;
import ta.parser.TAParser.ExpressionContext;
import ta.parser.TAParser.FieldDeclContext;
import ta.parser.TAParser.FieldDeclIdContext;
import ta.parser.TAParser.FieldInitContext;
import ta.parser.TAParser.FunctionDeclContext;
import ta.parser.TAParser.GuardContext;
import ta.parser.TAParser.IdexpressionContext;
import ta.parser.TAParser.InitContext;
import ta.parser.TAParser.InitialiserContext;
import ta.parser.TAParser.InstantiationContext;
import ta.parser.TAParser.ParameterContext;
import ta.parser.TAParser.ParameterListContext;
import ta.parser.TAParser.PrefixContext;
import ta.parser.TAParser.ProcBodyContext;
import ta.parser.TAParser.ProcDeclContext;
import ta.parser.TAParser.RangeContext;
import ta.parser.TAParser.RelContext;
import ta.parser.TAParser.StateDeclContext;
import ta.parser.TAParser.StateListContext;
import ta.parser.TAParser.StatementContext;
import ta.parser.TAParser.StatesContext;
import ta.parser.TAParser.SyncContext;
import ta.parser.TAParser.SystemContext;
import ta.parser.TAParser.TaContext;
import ta.parser.TAParser.TernaryexpressionContext;
import ta.parser.TAParser.TernaryexpressionPrimeContext;
import ta.parser.TAParser.TransitionBodyContext;
import ta.parser.TAParser.TransitionContext;
import ta.parser.TAParser.TransitionOptContext;
import ta.parser.TAParser.TransitionsContext;
import ta.parser.TAParser.TypeContext;
import ta.parser.TAParser.TypeDeclContext;
import ta.parser.TAParser.TypeIdListContext;
import ta.parser.TAParser.UnaryOpContext;
import ta.parser.TAParser.UrgentContext;
import ta.parser.TAParser.VariableDeclContext;

public class TAConverter implements TAListener {

	public final Set<State> states;
	public final Set<AP> propositions;
	public final Set<Transition> transitions;

	private State currentSource;
	
	public TAConverter() {
		this.states = new HashSet<>();
		this.propositions = new HashSet<>();
		this.transitions = new HashSet<>();

	}

	public TA getTA() {
		return new TA(propositions, states, transitions);
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterArgList(ArgListContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitArgList(ArgListContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterPrefix(PrefixContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitPrefix(PrefixContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTransitionOpt(TransitionOptContext ctx) {
		// no action is performed when a transitionOpt rule is enetered

	}

	@Override
	public void exitTransitionOpt(TransitionOptContext ctx) {
		// String source = ctx.ID(0).getText();

		// String destination = ctx.ID().getText();

		// transitions.add(new Transition(new State(source), new
		// State(destination)));
		if (ctx.ID() != null && !ctx.ID().equals("null")) {
			String destination = ctx.ID().getText();
			
			//TODO
			transitions.add(new Transition(this.currentSource, new State(destination), null));
		}

	}

	@Override
	public void enterDeclId(DeclIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitDeclId(DeclIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterCommit(CommitContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitCommit(CommitContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterUnaryOp(UnaryOpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitUnaryOp(UnaryOpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTransitions(TransitionsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitTransitions(TransitionsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterType(TypeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitType(TypeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterFieldDeclId(FieldDeclIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitFieldDeclId(FieldDeclIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTernaryexpressionPrime(TernaryexpressionPrimeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitTernaryexpressionPrime(TernaryexpressionPrimeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterInitialiser(InitialiserContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitInitialiser(InitialiserContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterRel(RelContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitRel(RelContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterBlock(BlockContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitBlock(BlockContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterBinexpression(BinexpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitBinexpression(BinexpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTypeIdList(TypeIdListContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitTypeIdList(TypeIdListContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTransitionBody(TransitionBodyContext ctx) {
		// no action is performed when the transition body is entered
	}

	@Override
	public void exitTransitionBody(TransitionBodyContext ctx) {

	}

	@Override
	public void enterProcBody(ProcBodyContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitProcBody(ProcBodyContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterInstantiation(InstantiationContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitInstantiation(InstantiationContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterInit(InitContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitInit(InitContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterFieldDecl(FieldDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitFieldDecl(FieldDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterProcDecl(ProcDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitProcDecl(ProcDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterArrayDecl(ArrayDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitArrayDecl(ArrayDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTypeDecl(TypeDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitTypeDecl(TypeDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterSync(SyncContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitSync(SyncContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterSystem(SystemContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitSystem(SystemContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterParameterList(ParameterListContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitParameterList(ParameterListContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterBinBoolOp(BinBoolOpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitBinBoolOp(BinBoolOpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterFunctionDecl(FunctionDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitFunctionDecl(FunctionDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterAssignOp(AssignOpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitAssignOp(AssignOpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterGuard(GuardContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitGuard(GuardContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterRange(RangeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitRange(RangeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterCaseocc(CaseoccContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitCaseocc(CaseoccContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterFieldInit(FieldInitContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitFieldInit(FieldInitContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterStates(StatesContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitStates(StatesContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterParameter(ParameterContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitParameter(ParameterContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterStatement(StatementContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitStatement(StatementContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterUrgent(UrgentContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitUrgent(UrgentContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterIdexpression(IdexpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitIdexpression(IdexpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExpression(ExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExpression(ExpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterBinIntOp(BinIntOpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitBinIntOp(BinIntOpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterStateList(StateListContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitStateList(StateListContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTa(TaContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitTa(TaContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub

	}

	

	

	@Override
	public void enterTernaryexpression(TernaryexpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitTernaryexpression(TernaryexpressionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExprList(ExprListContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExprList(ExprListContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterVariableDecl(VariableDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitVariableDecl(VariableDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterStateDecl(StateDeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitStateDecl(StateDeclContext ctx) {

		this.states.add(new State(ctx.ID().getText()));

	}

	@Override
	public void enterAssign(AssignContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitAssign(AssignContext ctx) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void enterTransition(TransitionContext ctx) {
		// no actions are performed when a transition is entered
	}
	
	@Override
	public void exitTransition(TransitionContext ctx) {
		String source = ctx.ID(0).getText();
		this.currentSource=new State(source);
		String destination = ctx.ID(1).getText();
		//TODO
		transitions.add(new Transition(new State(source), new State(destination),null));
		
	}

}
