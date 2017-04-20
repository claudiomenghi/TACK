package ta.converter;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.cltloc.CLTLocFormula;
import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TANetwork2CLTLoc;

public class FischerTest {

	@Test
	public void test() throws IOException {
	

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("ta/converter/fischer_input_02.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		TANetwork2CLTLoc  ta2cltloc=new TANetwork2CLTLoc();
		CLTLocFormula f=ta2cltloc.convert(system, new HashSet<>(), new HashSet<>());

		assertNotNull(f);
	}
}
