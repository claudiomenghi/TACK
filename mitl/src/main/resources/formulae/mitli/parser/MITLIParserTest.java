package formulae.mitli.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.mitli.MITLIFormula;
import formulae.mitli.converters.MITLI2zot;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;

public class MITLIParserTest {

	@Test
	public void testFormulaCorrectlyParser() throws FileNotFoundException, IOException {
		
		String path=ClassLoader
		.getSystemResource("formulae/mitli/parser/formula1.txt").getPath();
	
			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
			MITLILexer lexer = new MITLILexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			MITLIParser parser = new MITLIParser(tokens);
			parser.setBuildParseTree(true);
			MITLIFormula formula = parser.mitli().formula;

			String zotEncoding = new MITLI2zot().apply(formula, 1000);

			System.out.println(zotEncoding);

			
		
	}

}