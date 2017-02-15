package checkers;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=", commandDescription = "Checks a TA")
public class TAChecker {

	@Parameter(names = "-m", required = true, description = "The file containing the TA")
	public String modelPath;

	@Parameter(names = "-f", required = true, description = "The file containing the MITLI formula")
	public String formulaPath;
	
	
}
