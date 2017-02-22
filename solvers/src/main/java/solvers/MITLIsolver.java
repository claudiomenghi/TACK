package solvers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.io.FileUtils;

import com.google.common.base.Preconditions;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.converters.CLTLoc2Zot;
import formulae.cltloc.visitor.NicelyIndentToString;
import formulae.mitli.MITLIFormula;
import formulae.mitli.converters.MITLI2CLTLoc;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;

public class MITLIsolver {
	public static void main(String[] args) throws Exception {

		System.out.println(args[0]);
		System.out.println(args[1]);
		Preconditions.checkArgument(args.length > 1, "you must specify the file that contains the MITLI formula and the bound to be used");
		Preconditions.checkArgument(Files.exists(Paths.get(args[0])), "The file: " + args[0] + " does not exist");
		//Preconditions.checkArgument(args[1]!=null, "The second parameter mus be the bound to be used");
		//Preconditions.checkArgument( Integer.getInteger(args[1])!=null, "Parameter "+args[1]+ " not valid");
		System.out.println("Quantitative - Metric Temporal Logic Solver");
		System.out.println("v. 2.0 - 19/4/2013\n");
		System.out.println("Analizing the file: " + args[0]);

		if (new File(args[0]).isFile()) {
			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args[0]));
			MITLILexer lexer = new MITLILexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			MITLIParser parser = new MITLIParser(tokens);
			parser.setBuildParseTree(true);
			MITLIFormula formula = parser.mitli().formula;

			

			MITLI2CLTLoc converted=new MITLI2CLTLoc(formula, Integer.parseInt(args[1]));
			CLTLocFormula cltlocFormula = converted.apply();

			
			
			System.out.println("Transforming the MITLI formula in CLTLoc");
			String cltlocFile;
			if (args[0].contains(".mitli")) {
				cltlocFile = args[0].replaceAll(".mitli", ".cltloc");
			} else {
				cltlocFile = args[0].concat(".cltloc");
			}
			
			FileUtils.writeStringToFile(new File(cltlocFile), cltlocFormula.accept(new NicelyIndentToString()));
			
			
			
			StringBuilder vocabularyBuilder=new StringBuilder();
			
			for(Entry<Integer, MITLIFormula> entry: converted.getVocabulary().entrySet()){
				vocabularyBuilder.append(entry.getKey()+": "+entry.getValue()+"\n");
			}
			
			String vocabulary;
			if (args[0].contains(".mitli")) {
				vocabulary = args[0].replaceAll(".mitli", ".vocabulary");
			} else {
				vocabulary = args[0].concat(".vocabulary");
			}
			
			FileUtils.writeStringToFile(new File(vocabulary), vocabularyBuilder.toString());
			
			
			System.out.println("CLTLoc formula saved in the file " + cltlocFile);

			String zotEncoding = new CLTLoc2Zot(Integer.parseInt(args[1])).apply(cltlocFormula);

			System.out.println("CLTLoc formula encoded in ZOT");

			String lispFile;
			if (args[0].contains(".mitli")) {
				lispFile = args[0].replaceAll(".mitli", ".lisp");
			} else {
				lispFile = args[0].concat(".lisp");
			}

			System.out.println("The file " + lispFile + " contains the zot encoding");
			FileUtils.writeStringToFile(new File(lispFile), zotEncoding);

			Process p = Runtime.getRuntime().exec("sh ./run_zot.sh " + lispFile);

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));

			StringBuilder builder = new StringBuilder();
			String line = "";
			while ((line = reader.readLine()) != null) {
				builder.append(line + "\n");
			}

			System.out.println(builder.toString());

			reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			builder = new StringBuilder();
			line = "";
			while ((line = reader.readLine()) != null) {
				builder.append(line + "\n");
			}

			System.out.println(builder.toString());

		} else {
			System.out.println(
					"File " + (new File("").getAbsolutePath()) + File.pathSeparator + args[0] + " does not exist");
		}

	}
}