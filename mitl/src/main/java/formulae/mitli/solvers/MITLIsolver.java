package formulae.mitli.solvers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import formulae.Formula;
import formulae.mitli.MITLIFormula;
import formulae.mitli.converters.MITLI2zot;

public class MITLIsolver {
	public static void main(String[] args) throws Exception {

		System.out.println("Quantitative - Metric Temporal Logic Solver");
		System.out.println("v. 2.0 - 19/4/2013\n");

		if (args[0].matches("[a-zA-Z][a-zA-Z0-9-]+\\.tl")) {

		//	ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args[0]));
		//	qtlSolverLexer lexer = new qtlSolverLexer(input);
		//	CommonTokenStream tokens = new CommonTokenStream(lexer);
		//	qtlSolverParser parser = new qtlSolverParser(tokens);
			Formula formula = null;
					//parser.tlparser();

			FileOutputStream f0 = null;

			try {
				f0 = new FileOutputStream("output.cltl");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			if (f0 != null) {
				PrintStream prn = new PrintStream(f0);

				MITLIFormula tmpFormula = (MITLIFormula) formula;
				String zotEncoding = new MITLI2zot().apply(tmpFormula, 1000);

				prn.println(zotEncoding);
			} else {
				System.out.println("Opps...some errors occurred!");
			}

			FileInputStream f1 = null;
			try {
				f1 = new FileInputStream("output.cltl");
				String[] cmd = { "mv", "output.cltl", args[0].replaceAll("\\.tl", ".cltl") };
				Runtime r1 = Runtime.getRuntime();
				Process p1 = r1.exec(cmd);
				p1.waitFor();
				f1.close();
				System.out.println("File " + args[0].replaceAll("\\.tl", ".cltl") + " written.");

				if (args.length > 1)
					if (args[1].compareTo("--sat") == 0) {
						String[] cmd2 = { "zot", args[0].replaceAll("\\.tl", ".cltl") };

						Runtime r = Runtime.getRuntime();
						Process p = r.exec(cmd2);
						System.out.print("Solving ...");
						p.waitFor();
						System.out.println("finished!");

						try {
							f1 = new FileInputStream("output.1.txt");
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}

					}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
	}
}