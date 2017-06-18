package tack;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Ignore;
import org.junit.Test;

import formulae.cltloc.CLTLocFormula;
import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;
import solvers.CLTLocsolver;
import ta.SystemDecl;
import ta.TA;
import ta.parser.TALexer;
import ta.parser.TAParser;
import zotrunner.ZotException;

public class TAGetThetaTest {

	Map<MITLIFormula, MITLIFormula> parentRelation = new HashMap<>();

	/**
	 * The property is not related to the model and thus it is not satisfied
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ZotException
	 */
	@Test
	public void testFormula1() throws FileNotFoundException, IOException, ZotException {
		String path = ClassLoader.getSystemResource("tack/ta/examples/formula2.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		MITLI2CLTLocVisitor visitor = new MITLI2CLTLocVisitor(formula);

		formula.accept(visitor);

		populateParentRelation(formula);
		
		CLTLocFormula f = visitor.getckTheta(formula, parentRelation);

		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println(f);
		CLTLocsolver solver = new CLTLocsolver(f, System.out, 5);

		assertTrue(solver.solve());

	}

	private void populateParentRelation(MITLIFormula f) {
		Set<MITLIFormula> chidren = f.getChildren();
		chidren.forEach(c -> parentRelation.put(c, f));

		chidren.forEach(c -> this.populateParentRelation(c));

	}

}
