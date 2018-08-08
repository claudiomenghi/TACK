package ta.visitors.sync;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.relations.CLTLocEQRelation;
import ta.SystemDecl;
import ta.TA;
import ta.transition.Transition;
import ta.transition.sync.SyncExpression.Operator;
import ta.visitors.TANetwork2CLTLoc;
import ta.visitors.TANetwork2CLTLocRC;

public class WeakBroadcastSync extends Sync2CLTLoc {

	private TANetwork2CLTLocRC converter;

	public WeakBroadcastSync(TANetwork2CLTLocRC converter) {
		this.converter = converter;
	}
	
	public  CLTLocFormula getSyncConstraint(SystemDecl system) {
		
		CLTLocFormula v1 = ifSentAllReceive(system);

		CLTLocFormula v2 = 			ifReceivedItIsSent(system);

		
		return CLTLocFormula.getAnd(v1, v2);

	}


	protected CLTLocFormula ifSentAllReceive(SystemDecl system) {
		CLTLocFormula v1 = CLTLocFormula.TRUE;

		for (TA ta : system.getTimedAutomata()) {
			
			CLTLocFormula taf = CLTLocFormula.TRUE;

			for (Transition t : ta.getTransitions()) {

				
				if (t.getSync().getOperator().equals(Operator.BROADCAST_SEND)) {

					CLTLocFormula broadcastingTransition = new CLTLocEQRelation(formulae.cltloc.atoms.BoundedVariable
							.getBoundedVariable("t" + ta.getId(), ta.getPossibleTransitionVariableValues()),
							new Constant(t.getId()));
					
					
					CLTLocFormula otherautomatatransitions = CLTLocFormula.TRUE;
					
					for (TA ta2 : system.getTimedAutomata()) {
						if (!ta2.equals(ta)) {
							
							CLTLocFormula transitionFired = CLTLocFormula.FALSE;

							for (Transition t2 : ta2.getTransitions()) {
								if (t2.getSync().getOperator().equals(Operator.BROADCAST_RECEIVE)
										&& t.getSync().getEvent().equals(t2.getSync().getEvent())) {

									transitionFired = CLTLocFormula.getOr(transitionFired, new CLTLocEQRelation(
											formulae.cltloc.atoms.BoundedVariable.getBoundedVariable("t" + ta2.getId(),
													ta2.getPossibleTransitionVariableValues()),
											new Constant(t2.getId())));
								}
							}
							if(transitionFired==CLTLocFormula.FALSE) {
								transitionFired=CLTLocFormula.TRUE;
							}

							CLTLocFormula noTransitionFired = CLTLocFormula.TRUE;

							for (Transition t2 : ta2.getTransitions()) {
								if (t2.getSync().getOperator().equals(Operator.BROADCAST_RECEIVE)
										&& t.getSync().getEvent().equals(t2.getSync().getEvent())) {
								noTransitionFired = CLTLocFormula.getAnd(noTransitionFired,
										CLTLocFormula.getOr(
												new CLTLocNext(CLTLocFormula.getNeg(converter.getClockGuard(ta2, t2))),
												CLTLocFormula.getNeg(converter.getVariableGuard(system, ta2, t2)),
												CLTLocFormula.getNeg(new CLTLocEQRelation(
														formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
																TANetwork2CLTLoc.STATE_PREFIX + ta2.getId(),
																converter.getPossibleStateVariableValues(ta2)),
														new Constant(converter.getId(ta2, t2.getSource()))))));
								}
							}
							

							
							CLTLocFormula noOtherBroadcast = CLTLocFormula.TRUE;

							for (Transition t2 : ta2.getTransitions()) {
								if (t2.getSync().getOperator().equals(Operator.BROADCAST_SEND)
										&&
										 t.getSync().getEvent().equals(t2.getSync().getEvent())
										) {
									noOtherBroadcast = CLTLocFormula.getAnd(noOtherBroadcast,
											CLTLocFormula.getNeg(new CLTLocEQRelation(
													formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
															"t" + ta2.getId(),
															ta2.getPossibleTransitionVariableValues()),
													new Constant(t2.getId()))));
								}
							}
							
							

							//otherautomatatransitions = 		CLTLocFormula.getAnd(otherautomatatransitions, noOtherBroadcast
							//				,CLTLocFormula.getAnd(CLTLocFormula.getOr(transitionFired, noTransitionFired))
							//);
							
							otherautomatatransitions = CLTLocFormula.getAnd(otherautomatatransitions, noOtherBroadcast, transitionFired);

						}
						
					}

					CLTLocFormula firingtransition = TANetwork2CLTLoc.implicationOperator.apply(broadcastingTransition,
							otherautomatatransitions);
					
					taf = CLTLocFormula.getAnd(taf, firingtransition);

				}

			}
			v1 = CLTLocFormula.getAnd(v1, taf);
		}
		return v1;
	}

}
