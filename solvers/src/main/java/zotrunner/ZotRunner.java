package zotrunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Preconditions;

public class ZotRunner {

	private final String zotEncoding;
	private final PrintStream out;

	/**
	 * 
	 * @param zotEncoding
	 *            the zotEncoding to be verified
	 */
	public ZotRunner(String zotEncoding, PrintStream out) {
		Preconditions.checkNotNull(zotEncoding, "the zotEncoding cannot be null");
		this.zotEncoding = zotEncoding;
		this.out = out;
	}

	public boolean run() throws IOException {
		String lispFile = "tmp.zot";

		out.println("Running zot");
		FileUtils.writeStringToFile(new File(lispFile), zotEncoding);

		out.println("Considering the file "+new File(lispFile).getAbsolutePath());
		Process p = Runtime.getRuntime().exec("sh ./run_zot.sh " + lispFile);

		boolean sat = false;

		BufferedReader stdErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(p.getInputStream()));

		String lineer = stdErr.readLine();
		String linein = stdIn.readLine();
		while ((((linein) != null) || ((lineer) != null)) && p.isAlive()) {

			if (linein != null && linein.contains("---SAT---")) {
					sat = true;
				
			}
			if (lineer != null) {
				out.println(lineer);
			}
			if (linein != null) {
				out.println(linein);
			}
			lineer = stdErr.readLine();
			linein = stdIn.readLine();
		}
		out.print("Zot ends");
//		FileUtils.forceDelete(new File(lispFile));
		return sat;
	}

}
