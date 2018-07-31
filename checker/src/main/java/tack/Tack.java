package tack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.google.common.base.Preconditions;

import formulae.cltloc.visitor.ZotPlugin;
import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TANetwork2CLTLoc;
import ta.visitors.TANetwork2CLTLocO;
import ta.visitors.TANetwork2CLTLocRC;
import ta.visitors.liveness.LivenessEachTAProgresses;
import ta.visitors.liveness.NoProgressesRequired;
import tack.checker.SystemChecker;

public class Tack {

	public static void main(String[] args) throws Exception {
		PrintStream out = System.out;
		/*
		 * PrintStream out = new PrintStream(ByteStreams.nullOutputStream());
		 */
		out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------");
		out.println("TACK  - Timed Automata ChecKer");
		out.println("v. 0.0.1 - 18/06/2017\n");
		out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------");

		Preconditions.checkArgument(args.length >= 3,
				"you must specify the file that contains the MITLI formula and the bound to be used");

		String modelFile = args[0];
		String propertyFile = args[1];
		String bound = args[2];

		Preconditions.checkArgument(Files.exists(Paths.get(modelFile)),
				"The file: " + modelFile + " containing the model does not exist");
		Preconditions.checkArgument(Files.exists(Paths.get(propertyFile)),
				"The file: " + propertyFile + " containing the property does not exist");

		out.println("Loading the property: " + propertyFile);
		// loading the property
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(propertyFile));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		out.println("Property loaded" + modelFile);

		// loading the model
		out.println("Loading the model");

		ANTLRInputStream tainput = new ANTLRFileStream(modelFile);
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		out.println("Model loaded");

		TANetwork2CLTLoc converter = null;
		File f = new File("config.txt");
		ZotPlugin zotPlugin = null;
		if (f.exists()) {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("tasemantics: ")) {
					if (line.substring("tasemantics: ".length(), line.length()).equals("rightclosed")) {
						converter = new TANetwork2CLTLocRC();
					}
					if (line.substring("tasemantics: ".length(), line.length()).equals("open")) {
						converter = new TANetwork2CLTLocO();
					}
				}
				if (line.startsWith("liveness: ")) {
					if (line.substring("liveness: ".length(), line.length()).equals("eachTAprogresses")) {
						converter.setLivenessConverter(new LivenessEachTAProgresses());
					}
					if (line.substring("liveness: ".length(), line.length()).equals("noProgressRequired")) {
						converter.setLivenessConverter(new NoProgressesRequired());
					}
				}
			}
			reader.close();
		}

		if (converter == null) {
			converter = new TANetwork2CLTLocRC();
		}

		out.println("Semantic loaded");

		SystemChecker checker = new SystemChecker(system, formula, Integer.parseInt(bound), converter, System.out);
		boolean result = checker.check(null);

		out.println();
		out.println();
		out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------");

		out.println("The property of interest is : " + ((result) ? "satisfied" : "not satisfied"));
		out.println(((result) ? "" : "check the file counterexample.txt to see the violating trace"));
		out.println(((result) ? ""
				: "the mapping between the elements of the model and the used id can be found in the file elementsIDmap.txt"));
		out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.exit((result) ? 0 : 1);
	}

}
