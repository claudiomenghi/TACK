package ta.converter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.cltloc.CLTLocFormula;
import ta.StateAP;
import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TA2CLTLoc;

public class ConvertingSystemTest {

	@Test
	public void getVariableFormula1Test() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/parser/csmacd/2.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		System.out.println(system);
		TA ta = system.getTimedAutomata().iterator().next();

		Set<StateAP> propositionsOfInterest = new HashSet<>();
		TA2CLTLoc converter = new TA2CLTLoc();
		converter.convert(system, ta, propositionsOfInterest, new HashSet<>());

		CLTLocFormula phi1 = converter.getVariable1();

		
	}

}
