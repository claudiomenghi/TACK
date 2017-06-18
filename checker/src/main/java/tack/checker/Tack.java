package tack.checker;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.google.common.base.Preconditions;

import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;

public class Tack {

	public static void main(String[] args) throws Exception {
		Preconditions.checkArgument(args.length > 2,
				"you must specify the file that contains the MITLI formula and the bound to be used");

		
		PrintStream out = System.out;

		String modelFile = args[0];
		String propertyFile = args[1];		
		
		Preconditions.checkArgument(Files.exists(Paths.get(modelFile)), "The file: " + modelFile + " containing the model does not exist");
		Preconditions.checkArgument(Files.exists(Paths.get(propertyFile)), "The file: " + propertyFile + " containing the property does not exist");
	
		out.println("TACK  - Timed Automata ChecKer");
		out.println("v. 2.0 - 18/06/2017\n");
		
		// loading the property
		String propertyFilePath = ClassLoader.getSystemResource(propertyFile).getPath();
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(propertyFilePath));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		// loading the model
		String modelFilePath = ClassLoader.getSystemResource(modelFile).getPath();

		ANTLRInputStream tainput = new ANTLRFileStream(
				ClassLoader.getSystemResource(modelFilePath).getPath());
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		SystemChecker checker = new SystemChecker(system, formula, 10, System.out);
		boolean result = checker.check();


		out.println("The property of interest is : "+((result) ? "satisfied" : "not satisfied"));
		out.println(((result) ? "" : "check the file output.hist.smt.txt to see the violating trace"));
		out.println(((result) ? "" : "the mapping between the elements of the model and the used id can be found in the file elementsIDmap.txt"));
		
	}

}
