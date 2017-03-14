package ta.parser;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ta.SystemDecl;
import ta.TA;
import ta.Variable;

public class ParserAssignementsTest {

	@Test
	public void testObtainedTAContainsAllTheVariables() throws IOException {
		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/Test2.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		System.out.println(ta);
		
		Set<Variable> variables=new HashSet<>();
		variables.add(new Variable("B_start"));
		variables.add(new Variable("A_stop"));
		assertEquals("The parsed TA must contain all the variables", variables, ta.getVariables());
	}

}
