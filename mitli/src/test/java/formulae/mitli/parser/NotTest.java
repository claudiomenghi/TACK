package formulae.mitli.parser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.mitli.MITLIFormula;
import formulae.mitli.atoms.MITLIPropositionalAtom;

public class NotTest {

	@Test
	public void test() throws FileNotFoundException, IOException {
		String path = ClassLoader.getSystemResource("formulae/mitli/parser/not.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		assertNotNull("The parsed formula cannot be null", formula);

		assertTrue("double negation is simplified during parsing",formula.equals(new MITLIPropositionalAtom("a")));
	}

}
