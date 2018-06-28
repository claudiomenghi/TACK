package tack;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.google.common.base.Preconditions;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.relations.CLTLocRelation;
import formulae.cltloc.relations.Relation;
import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TANetwork2CLTLocRC;
import tack.checker.SystemChecker;

public class TackFisherScalability {

	public static void main(String[] args) throws Exception {
		PrintStream out = System.out;
		/*PrintStream out = 
				new PrintStream(ByteStreams.nullOutputStream());
*/
		out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
		out.println("TACK  - Timed Automata ChecKer");
		out.println("v. 0.0.1 - 18/06/2017\n");
		out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		Preconditions.checkArgument(args.length >= 3,
				"you must specify the file that contains the MITLI formula and the bound to be used");

		


		String modelFile = args[0];
		String propertyFile = args[1];		
		String bound=args[2];
		int exampleNumber=Integer.parseInt(args[3]);
		
		Preconditions.checkArgument(Files.exists(Paths.get(modelFile)), "The file: " + modelFile + " containing the model does not exist");
		Preconditions.checkArgument(Files.exists(Paths.get(propertyFile)), "The file: " + propertyFile + " containing the property does not exist");
	
		out.println("Loading the property: "+propertyFile);	
		// loading the property
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(propertyFile));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;

		out.println("Property loaded"+modelFile);
		
		
		// loading the model
		out.println("Loading the model");

		ANTLRInputStream tainput = new ANTLRFileStream(modelFile);
		TALexer talexer = new TALexer(tainput);
		CommonTokenStream tatokens = new CommonTokenStream(talexer);
		TAParser taparser = new TAParser(tatokens);
		taparser.setBuildParseTree(true);
		SystemDecl system = taparser.ta().systemret;

		out.println("Model loaded");
		SystemChecker checker = new SystemChecker(system, formula, Integer.parseInt(bound), new TANetwork2CLTLocRC(), System.out);
		
		CLTLocFormula f=CLTLocFormula.FALSE;
		for(int i=1; i<=exampleNumber; i++){
			f=CLTLocFormula.getOr(f, new CLTLocRelation(new Variable("id"), new Constant(i), Relation.EQ));
		}
		boolean result = checker.check(CLTLocGlobally.create(f));

		out.println();
		out.println();
		out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		out.println("The property of interest is : "+((result) ? "satisfied" : "not satisfied"));
		out.println(((result) ? "" : "check the file output.hist.smt.txt to see the violating trace"));
		out.println(((result) ? "" : "the mapping between the elements of the model and the used id can be found in the file elementsIDmap.txt"));
		out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
	}

}
