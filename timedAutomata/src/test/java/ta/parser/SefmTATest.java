package ta.parser;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ta.Clock;
import ta.SystemDecl;
import ta.TA;
import ta.declarations.VariableDecl;
import ta.expressions.Value;

public class SefmTATest {

	@Test
	public void testTheTAShouldContainClocks() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/parser/sefmta.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		parser.setErrorHandler(new BailErrorStrategy());
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();
		
		assertTrue(ta.getClocks().contains(new Clock("x")));
		System.out.println(ta);
		

	}

	@Test
	public void testTheTAShouldContainAllDeclarations() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/parser/sefmta.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		parser.setErrorHandler(new BailErrorStrategy());
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		
		Set<VariableDecl> decls = new HashSet<>();
		decls.add(new VariableDecl("int", "l0ap", new Value("1")));
		decls.add(new VariableDecl("int", "l1ap", new Value("0")));
		decls.add(new VariableDecl("int", "l2ap", new Value("0")));
	
		
		assertEquals("The set of declaration must contain all and only the expected declarations ", decls, ta.getDeclarations());

	}

}
