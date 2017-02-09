package solvers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.ProcessBuilder.Redirect;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.io.FileUtils;

import formulae.mitli.MITLIFormula;
import formulae.mitli.converters.MITLI2zot;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;

public class MITLIsolver {
	public static void main(String[] args) throws Exception {

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

			String zotEncoding = new MITLI2zot().apply(formula, 1000);

			System.out.println("MITLI formula encoded in ZOT");

			String lispFile = args[0].replaceAll(".txt", ".lisp");
			System.out.println("The file " + lispFile + " contains the zot encoding");
			FileUtils.writeStringToFile(new File(lispFile), zotEncoding);

			// Process p1 = r1
			// .exec("docker run --rm -v $PWD:/usr/src/myapp -w /usr/src/myapp
			// fmarconi/zot zot " + lispFile);

			// Process p = Runtime.getRuntime().exec("mkdir ciao");

		//	Process p = Runtime.getRuntime()
			//		.exec(new String[] {"docker", "run", "--rm", "-v", "\"","$PWD", "\"",":/usr/src/myapp", "-w", "/usr/src/myapp", "fmarconi/zot", "zot " + lispFile
			//				});
		//	Process p=Runtime.getRuntime().exec("sh ./run_zot.sh "+ lispFile);
	//		p = Runtime.getRuntime().exec("echo ciao  >> ./output.zot");

		/*	p.waitFor();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));

			StringBuilder builder = new StringBuilder();
			String line = "";
			while ((line = reader.readLine()) != null) {
				builder.append(line + "\n");
			}

			System.out.println(builder);

			reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			builder = new StringBuilder();
			line = "";
			while ((line = reader.readLine()) != null) {
				builder.append(line + "\n");
			}

			System.out.println(builder);*/

		} else {
			System.out.println(
					"File " + (new File("").getAbsolutePath()) + File.pathSeparator + args[0] + " does not exist");
		}

	}
}