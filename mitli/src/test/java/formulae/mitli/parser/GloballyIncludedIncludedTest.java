package formulae.mitli.parser;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.mitli.MITLIEventually;
import formulae.mitli.MITLIFormula;
import formulae.mitli.MITLIGlobally_AtoB;

public class GloballyIncludedIncludedTest {

	@Test
	public void test() throws FileNotFoundException, IOException {
		String path = ClassLoader.getSystemResource("formulae/mitli/parser/gii.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		System.out.println(formula);
		
		assertTrue(formula instanceof MITLIGlobally_AtoB);

		
	}

}
