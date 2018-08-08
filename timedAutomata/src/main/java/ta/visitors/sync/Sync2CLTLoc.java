package ta.visitors.sync;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.relations.CLTLocEQRelation;
import ta.SystemDecl;
import ta.TA;
import ta.transition.Transition;
import ta.transition.sync.SyncExpression.Operator;
import ta.visitors.TANetwork2CLTLoc;

public abstract class Sync2CLTLoc {
	
	
	public abstract CLTLocFormula getSyncConstraint(SystemDecl system);
	
	protected CLTLocFormula ifReceivedItIsSent(SystemDecl system) {
		CLTLocFormula v2 = CLTLocFormula.TRUE;
		
		for (TA ta : system.getTimedAutomata()) {
			CLTLocFormula taf = CLTLocFormula.TRUE;

			for (Transition t : ta.getTransitions()) {

				if (t.getSync().getOperator().equals(Operator.BROADCAST_RECEIVE)) {

					CLTLocFormula receivingTransition = new CLTLocEQRelation(formulae.cltloc.atoms.BoundedVariable
							.getBoundedVariable("t" + ta.getId(), ta.getPossibleTransitionVariableValues()),
							new Constant(t.getId()));

					CLTLocFormula sendingTransitions = CLTLocFormula.FALSE;
					
					for (TA ta2 : system.getTimedAutomata()) {
						if (!ta2.equals(ta)) {
							

							for (Transition t2 : ta2.getTransitions()) {
								if (t2.getSync().getOperator().equals(Operator.BROADCAST_SEND)
										&&
										t2.getSync().getEvent().equals(t.getSync().getEvent())) {
									
									sendingTransitions = CLTLocFormula.getOr(sendingTransitions,
											new CLTLocEQRelation(
													formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
															"t" + ta2.getId(),
															ta2.getPossibleTransitionVariableValues()),
													new Constant(t2.getId())));
								}
							}
							

						}
					}

					CLTLocFormula firingtransition = TANetwork2CLTLoc.implicationOperator.apply(receivingTransition,
							sendingTransitions);
					taf = CLTLocFormula.getAnd(taf, firingtransition);

				}

				
			}
			v2 = CLTLocFormula.getAnd(v2, taf);
			
		}
		return v2;
	}

}
