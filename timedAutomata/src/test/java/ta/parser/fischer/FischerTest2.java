package ta.parser.fischer;

import static org.junit.Assert.*;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.transition.Transition;
import ta.transition.sync.SyncExpression;
import ta.transition.sync.SyncExpression.Operator;

public class FischerTest2 {

	
	
	@Test
	public void testModel() throws IOException {


		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("ta/parser/fischer/fischer_input_03.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TA ta=system.getTimedAutomata().iterator().next();

		System.out.println(system);
		
		assertTrue(system.getClockDeclarations().size()==2);
		assertTrue(system.getVariableDeclaration().size()==1);
		
		
		for(Transition t: ta.getTransitions()){
			SyncExpression e=t.getSync();
			assertTrue(e.getOperator().equals(Operator.TAU));
		}
	}

}
