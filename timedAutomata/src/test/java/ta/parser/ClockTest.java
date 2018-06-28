package ta.parser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Ignore;
import org.junit.Test;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.visitor.GetClocksVisitor;
import ta.StateAP;
import ta.SystemDecl;
import ta.TA;
import ta.visitors.TANetwork2CLTLocRC;

public class ClockTest {

	@Ignore @Test
	public void apTest1() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/Test2.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		parser.setErrorHandler(new BailErrorStrategy());
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<StateAP> propositionsOfInterest = new HashSet<>();

		CLTLocFormula formula = new TANetwork2CLTLocRC().convert(system, propositionsOfInterest, new HashSet<>());

		
		Set<CLTLocClock> clocks = formula.accept(new GetClocksVisitor());

		Set<CLTLocClock> expectedSet = new HashSet<>();
		expectedSet.add(new CLTLocClock("A_c"));
		expectedSet.add(new CLTLocClock("B_c"));
		expectedSet.add(new CLTLocClock("C_c"));

		assertEquals(expectedSet, clocks);

	}

}
