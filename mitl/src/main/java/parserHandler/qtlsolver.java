package parserHandler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

import formulae.Formula;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTL2ZotHeaderVisitor;
import formulae.cltloc.visitor.CLTLoc2ZotVisitor;
import formulae.mitl.MITLFormula;
import formulae.mitl.visitors.MITL2CLTLocVisitor;
import formulae.mitli.MITLIFormula;
import formulae.mitli.visitors.MITLI2CLTLocVisitor;

public class qtlsolver {
	public static void main(String[] args) throws Exception {

		System.out.println("Quantitative - Metric Temporal Logic Solver");
		System.out.println("v. 2.0 - 19/4/2013\n");

		if (args[0].matches("[a-zA-Z][a-zA-Z0-9-]+\\.tl")) {

			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args[0]));
			qtlSolverLexer lexer = new qtlSolverLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			qtlSolverParser parser = new qtlSolverParser(tokens);
			Formula formula = parser.tlparser();

			FileOutputStream f0 = null;

			try {
				f0 = new FileOutputStream("output.cltl");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			if (f0 != null) {
				PrintStream prn = new PrintStream(f0);

				CLTLocFormula equivalentCLTLocFormula = null;
				String zotHeader = "";
				zotHeader = zotHeader + new String("(asdf:operate 'asdf:load-op 'ae2zot) (use-package :trio-utils)\n");
				
				if (formula instanceof MITLIFormula) {
					MITLIFormula tmpFormula = (MITLIFormula) formula;
					equivalentCLTLocFormula = tmpFormula.accept(new MITLI2CLTLocVisitor());
				}
				if (formula instanceof MITLFormula) {
					MITLFormula tmpFormula = (MITLFormula) formula;
					equivalentCLTLocFormula = tmpFormula.accept(new MITL2CLTLocVisitor());
					
				}
				zotHeader = zotHeader+equivalentCLTLocFormula.accept(new CLTL2ZotHeaderVisitor());
				String zotEncoding = zotHeader + equivalentCLTLocFormula.accept(new CLTLoc2ZotVisitor());
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
						f0 = null;

						try {
							f1 = new FileInputStream("output.1.txt");
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}

						if (f0 != null) {
							BufferedReader br = new BufferedReader(new InputStreamReader(f1));
							System.out.println(br.readLine());
							br.close();
						} else {
							System.out.println("Opps...some errors occurred!");
						}
					}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
	}
}