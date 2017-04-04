/**
 * 
 */
package formulae.mitli.csmacd;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.mitli.MITLIFormula;
import formulae.mitli.atoms.MITLIAtom;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;

/**
 * @author Claudio1
 *
 */
public class CSMACDTest {

	@Test
	public void test() throws FileNotFoundException, IOException {
		String path = ClassLoader.getSystemResource("formulae/mitli/csmacd/formula.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		
		System.out.println(formula);

	}

}
