package ta.converter;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.visitor.GetClocksVisitor;
import ta.AP;
import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TA2CLTLoc;

public class SefmTATest {

	@Test
	public void apTest1() throws IOException {

		ANTLRInputStream input = new ANTLRFileStream(ClassLoader.getSystemResource("ta/Converter/sefmta.ta").getPath());
		TALexer lexer = new TALexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TAParser parser = new TAParser(tokens);
		parser.setBuildParseTree(true);
		parser.setErrorHandler(new BailErrorStrategy());
		SystemDecl system = parser.ta().systemret;

		TA ta = system.getTimedAutomata().iterator().next();

		Set<AP> propositionsOfInterest = new HashSet<>();

		TA2CLTLoc converted=new TA2CLTLoc();
		CLTLocFormula formula = converted.convert(ta, propositionsOfInterest);

		System.out.println("phi_1="+converted.getPhi1());
		System.out.println("phi_2="+converted.getPhi2());
		System.out.println("phi_3="+converted.getPhi3());
		System.out.println("phi_4="+converted.getPhi4());
		System.out.println("phi_5="+converted.getPhi5());
		System.out.println("phi_6="+converted.getPhi6());
		System.out.println("phi_7="+converted.getPhi7());
		

	}

}
