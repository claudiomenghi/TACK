package ta.converter;

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
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.visitor.GetAPVisitor;
import ta.StateAP;
import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TANetwork2CLTLocRC;

public class APTest {

	

	@Ignore
	@Test
	public void apTest2() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/Test2.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.setBuildParseTree(true);
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<StateAP> propositionsOfInterest = new HashSet<>();
		CLTLocFormula formula = new TANetwork2CLTLocRC().convert(system, propositionsOfInterest, new HashSet<>());

		Set<CLTLocAP> atomicPropositions = formula.accept(new GetAPVisitor());

		Set<CLTLocAP> expectedSet = new HashSet<>();
		expectedSet.add(new CLTLocAP("s_start"));
		expectedSet.add(new CLTLocAP("s_call_check"));
		expectedSet.add(new CLTLocAP("s_call_observe"));
		expectedSet.add(new CLTLocAP("s_check_eof"));
		expectedSet.add(new CLTLocAP("s_ex_jam"));
		expectedSet.add(new CLTLocAP("True"));
		
		assertEquals(expectedSet, atomicPropositions);

	}
}
