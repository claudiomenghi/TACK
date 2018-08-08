package zotrunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;

import solvers.output.OutputSpaceParser;

public class ZotRunner {

	private final String zotEncoding;
	private final PrintStream out;

	private long satTime;

	private double checkingspace;

	private float checkingtime;

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

	public boolean run() throws IOException, ZotException {
		String lispFile = "tmp.zot";

		out.println("Writing the zot file");
		FileUtils.writeStringToFile(new File(lispFile), zotEncoding);

		out.println("Considering the file " + new File(lispFile).getAbsolutePath());
		String[] command = { "/bin/bash", "run_zot.sh", lispFile };

		Stopwatch timer = Stopwatch.createUnstarted();
		timer.start();
		ProcessBuilder builder = new ProcessBuilder(command);
		builder.redirectErrorStream(true);
		Process p = builder.start();

		InputStream stdout = p.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
		boolean sat = true;

		boolean resultfound = false;

		String line;
		while ((line = reader.readLine()) != null) {

			if (line.contains("---UNSAT---")) {
				sat = false;
				resultfound = true;
			}
			if (line.contains("---SAT---")) {
				sat = true;
				resultfound = true;
			}

			String resultTime = " seconds of real time";
			if (line.contains(resultTime)) {
				String extracted = line.substring(new String("   ").length() - 1, line.indexOf(resultTime)).replace(",",
						"");
				this.satTime = (long) (Float.parseFloat(extracted) * 1000.0);
			}
			if (line.contains(" bytes consed")) {
				this.checkingspace = new OutputSpaceParser().getSpace();
			}
			// if(line.contains("seconds of real time")){
			// out.println("Verification time:" +line.subSequence(0,
			// line.indexOf("seconds of real time")));
			// }

			// if (resultfound) {
			// out.println("Stdout: " + line);
			// }
		}
		if (!resultfound) {
			throw new ZotException("Problems in ZOT detected");
		}

		

		out.print("Zot ends");
		timer.stop();
		this.checkingtime = timer.elapsed(TimeUnit.MILLISECONDS);

		return sat;
	}

	public long getSatTime() {
		return satTime;
	}

	public double getCheckingspace() {
		return checkingspace;
	}

	public float getCheckingtime() {
		return checkingtime;
	}
}
