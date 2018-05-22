package solvers;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.google.common.io.ByteStreams;

import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import formulae.mitli.visitors.SubformulaeVisitor;
import zotrunner.ZotException;

public class MITLIsolverTest2 {

	private final PrintStream out = new PrintStream(System.out);

	@Test
	public void test() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/mitlitest.mitli").getPath();

		Reader fileReader = new FileReader(new File(path));
		BufferedReader br = new BufferedReader(fileReader);
		String line;
		while ((line = br.readLine()) != null) {
			ANTLRInputStream input = new ANTLRInputStream(new ByteArrayInputStream(line.getBytes()));
			MITLILexer lexer = new MITLILexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			MITLIParser parser = new MITLIParser(tokens);
			parser.setBuildParseTree(true);
			MITLIFormula formula = parser.mitli().formula;

			
			
			for(MITLIFormula f: formula.accept(new SubformulaeVisitor())){
				System.out.println(f+"\t"+f.getClass());
			}
			MITLIsolver sover = new MITLIsolver(formula, out, 20);

			assertTrue(sover.solve());
		}

		br.close();

	}

	@Test
	public void test2() throws IOException, ZotException {

		String path = ClassLoader.getSystemResource("solvers/mitlitest2.mitli").getPath();

		Reader fileReader = new FileReader(new File(path));
		BufferedReader br = new BufferedReader(fileReader);
		String line;
		while ((line = br.readLine()) != null) {
			ANTLRInputStream input = new ANTLRInputStream(new ByteArrayInputStream(line.getBytes()));
			MITLILexer lexer = new MITLILexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			MITLIParser parser = new MITLIParser(tokens);
			parser.setBuildParseTree(true);
			MITLIFormula formula = parser.mitli().formula;

			
			
			for(MITLIFormula f: formula.accept(new SubformulaeVisitor())){
				System.out.println(f+"\t"+f.getClass());
			}
			MITLIsolver sover = new MITLIsolver(formula, out, 20);

			assertTrue(sover.solve());
		}

		br.close();

	}
}
