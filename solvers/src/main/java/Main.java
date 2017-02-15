import java.io.IOException;
import java.util.HashSet;

import com.beust.jcommander.JCommander;

import checkers.TAChecker;
import formulae.cltloc.CLTLocFormula;
import ta.TA;
import ta.visitors.TA2CLTLoc;

public class Main {

	public static void main(String[] args) throws IOException {
		TAChecker cm = new TAChecker();
		JCommander jc = new JCommander(cm);
		jc.parse(args);
		
		TA ta=TA.parse(cm.modelPath);
		CLTLocFormula formula=new TA2CLTLoc().convert(ta, new HashSet<>());
		
		System.out.println("\n\n\n\n"+formula);
		
	}

}
