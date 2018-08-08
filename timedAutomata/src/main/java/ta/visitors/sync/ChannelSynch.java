package ta.visitors.sync;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.relations.CLTLocEQRelation;
import ta.SystemDecl;
import ta.TA;
import ta.transition.Transition;
import ta.transition.sync.SyncExpression.Operator;
import ta.visitors.TANetwork2CLTLoc;

public class ChannelSynch extends Sync2CLTLoc {

	@Override
	public CLTLocFormula getSyncConstraint(SystemDecl system) {
		CLTLocFormula v1 = CLTLocFormula.TRUE;

		v1 = sendReceive(system, v1, Operator.CHANNEL_SEND, Operator.CHANNEL_RECEIVED);


		CLTLocFormula v2 = CLTLocFormula.TRUE;

		v1 = sendReceive(system, v1, Operator.CHANNEL_RECEIVED, Operator.CHANNEL_SEND);

		return CLTLocFormula.getAnd(v1, v2);
	}

	private CLTLocFormula sendReceive(SystemDecl system, CLTLocFormula v1, Operator op1, Operator op2) {
		for (TA ta : system.getTimedAutomata()) {
			CLTLocFormula taf = CLTLocFormula.TRUE;


			for (Transition t : ta.getTransitions()) {

				if (t.getSync().getOperator().equals(op1)) {

					CLTLocFormula channelSend = new CLTLocEQRelation(formulae.cltloc.atoms.BoundedVariable
							.getBoundedVariable("t" + ta.getId(), ta.getPossibleTransitionVariableValues()),
							new Constant(t.getId()));
				
					CLTLocFormula otherautomatatransitions = CLTLocFormula.FALSE;

					for (TA ta2 : system.getTimedAutomata()) {
						if (!ta2.equals(ta)) {

							CLTLocFormula oneReceives = CLTLocFormula.FALSE;
							CLTLocFormula noOtherReceives = CLTLocFormula.TRUE;

							for (Transition t2 : ta2.getTransitions()) {

								if (t2.getSync().getOperator().equals(op2)
										&& t.getSync().getEvent().equals(t2.getSync().getEvent())) {

									oneReceives = CLTLocFormula.getOr(oneReceives, new CLTLocEQRelation(
											formulae.cltloc.atoms.BoundedVariable.getBoundedVariable("t" + ta2.getId(),
													ta2.getPossibleTransitionVariableValues()),
											new Constant(t2.getId())));

								}
							}
							for (TA ta3 : system.getTimedAutomata()) {
								if (!ta3.getIdentifier().equals(ta2.getIdentifier())) {
									for (Transition t3 : ta3.getTransitions()) {
										if (t3.getSync().getOperator().equals(op2)
												&& t.getSync().getEvent().equals(t3.getSync().getEvent())) {
											noOtherReceives = CLTLocFormula.getAnd(noOtherReceives,
													CLTLocFormula.getNeg(new CLTLocEQRelation(
															formulae.cltloc.atoms.BoundedVariable.getBoundedVariable(
																	"t" + ta3.getId(),
																	ta3.getPossibleTransitionVariableValues()),
															new Constant(t3.getId()))));
										}
									}
								}
							}


							otherautomatatransitions = CLTLocFormula.getOr(otherautomatatransitions,
									CLTLocFormula.getAnd(oneReceives, noOtherReceives));

						}
					}

					
					CLTLocFormula firingtransition = TANetwork2CLTLoc.implicationOperator.apply(channelSend,
							otherautomatatransitions);

					
					taf = CLTLocFormula.getAnd(taf, firingtransition);

				}

				v1 = CLTLocFormula.getAnd(v1, taf);
			}
		}
		return v1;
	}

}
