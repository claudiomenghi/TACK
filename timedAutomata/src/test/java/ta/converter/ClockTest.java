package ta.converter;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLClock;
import formulae.cltloc.visitor.GetClocksVisitor;
import ta.AP;
import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TA2CLTLoc;

public class ClockTest {

	@Test
	public void apTest1() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/Test1.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();

		CLTLocFormula formula = new TA2CLTLoc().convert(ta, propositionsOfInterest);

		
		Set<CLTLClock> clocks = formula.accept(new GetClocksVisitor());

		System.out.println(clocks);
		Set<CLTLClock> expectedSet = new HashSet<>();
		expectedSet.add(new CLTLClock("A_c"));
		expectedSet.add(new CLTLClock("B_c"));
		expectedSet.add(new CLTLClock("C_c"));

		assertEquals(expectedSet, clocks);

	}

}
