package scalability;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.google.common.io.ByteStreams;

import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;
import ta.visitors.TANetwork2CLTLocRC;
import tack.checker.SystemChecker;
import zotrunner.ZotException;

public class FischerScalabilityTest {

	
	public static void main(String [ ] args) throws IOException, ZotException{
	

		File file=new File("FisherScalabilityresults.txt");
		FileWriter fileWriter=new FileWriter(file, false);
		
		for(int bound=10; bound<=30; bound=bound+5){
			
			for(int stationsNumber=2; stationsNumber<=10; stationsNumber++){
				fileWriter=new FileWriter(file, true);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				
				String path = (stationsNumber<10) ? ClassLoader.getSystemResource("./fischer_input_0"+stationsNumber+".q").getPath():
					ClassLoader.getSystemResource("./fischer_input_"+stationsNumber+".q").getPath();
		
				ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
				MITLILexer lexer = new MITLILexer(input);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				MITLIParser parser = new MITLIParser(tokens);
				parser.setBuildParseTree(true);
				MITLIFormula formula = parser.mitli().formula;
		
				path = (stationsNumber<10) ? ClassLoader.getSystemResource("./fischer_input_0"+stationsNumber+".ta").getPath():
					ClassLoader.getSystemResource("./fischer_input_"+stationsNumber+".ta").getPath();
		
				ANTLRInputStream tainput = new ANTLRFileStream(path);
				TALexer talexer = new TALexer(tainput);
				CommonTokenStream tatokens = new CommonTokenStream(talexer);
				TAParser taparser = new TAParser(tatokens);
				taparser.setBuildParseTree(true);
				SystemDecl system = taparser.ta().systemret;
		
				SystemChecker checker = new SystemChecker(system, formula, bound, new TANetwork2CLTLocRC(), new PrintStream(ByteStreams.nullOutputStream()));
				boolean result = checker.check(null);
			
				fileWriter.write(bound+"\t"+stationsNumber+"\t"+"\t"+checker.getMitli2cltlocTime()+"\t"+checker.getTa2clclocTime()+"\t"+checker.getCltloc2zotTime()+"\t"+checker.getCheckingTime()+"\t"+checker.getSattime()+"\t"+checker.getCheckingspace()+"\n");
				fileWriter.close();
			}
		}
		
	}
}
