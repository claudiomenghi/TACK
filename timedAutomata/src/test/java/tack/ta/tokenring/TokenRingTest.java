package tack.ta.tokenring;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;

public class TokenRingTest {

	@Test
	public void test() throws IOException {

		String path = ClassLoader.getSystemResource("tack/ta/tokenring/token_ring_02.q").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		
		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource("tack/ta/tokenring/token_ring_02.ta").getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		System.out.println(system);
		
	}
	
	
}
