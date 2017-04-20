package checkers.ta.fischer;

import static org.junit.Assert.assertTrue;

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
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.io.ByteStreams;

import checkers.SystemChecker;
import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;
import zotrunner.ZotException;

public class FischerScalabilityTest {

	
	@Ignore
	@Test
	public void test1() throws IOException, ZotException {
	
		
		System.out.println("Starting the Fischer scalability test ");
		File file=new File("FisherScalabilityresults.txt");
		
		FileWriter fileWriter=new FileWriter(file, false);
		
		for(int bound=10; bound<=30; bound=bound+5){
			
			for(int stationsNumber=2; stationsNumber<=10; stationsNumber++){
				fileWriter=new FileWriter(file, true);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				
				System.out.println(dateFormat.format(date)+"\t BOUND: "+bound+"\t NUMBER OF STATIONS: "+stationsNumber);
				String path = (stationsNumber<10) ? ClassLoader.getSystemResource("checkers/ta/fischer/fischer_input_0"+stationsNumber+".q").getPath():
					ClassLoader.getSystemResource("checkers/ta/fischer/fischer_input_"+stationsNumber+".q").getPath();
		
				System.out.println("parsing the formula");
				ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
				MITLILexer lexer = new MITLILexer(input);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				MITLIParser parser = new MITLIParser(tokens);
				parser.setBuildParseTree(true);
				MITLIFormula formula = parser.mitli().formula;
		
				System.out.println("parsing the TA");
				ANTLRInputStream tainput = new ANTLRFileStream(
						(stationsNumber<10) ? ClassLoader.getSystemResource("checkers/ta/fischer/fischer_input_0"+stationsNumber+".ta").getPath() :
							ClassLoader.getSystemResource("checkers/ta/fischer/fischer_input_"+stationsNumber+".ta").getPath());
				TALexer talexer = new TALexer(tainput);
				CommonTokenStream tatokens = new CommonTokenStream(talexer);
				TAParser taparser = new TAParser(tatokens);
				taparser.setBuildParseTree(true);
				SystemDecl system = taparser.ta().systemret;
		
				System.out.println("Running the model checker");
				SystemChecker checker = new SystemChecker(system, formula, bound, new PrintStream(ByteStreams.nullOutputStream()));
				boolean result = checker.check();
			
				fileWriter.write(bound+"\t"+stationsNumber+"\t"+"\t"+checker.getMitli2cltlocTime()+"\t"+checker.getTa2clclocTime()+"\t"+checker.getCltloc2zotTime()+"\t"+checker.getCheckingTime()+"\t"+checker.getSattime()+"\t"+checker.getCheckingspace()+"\n");
				System.out.println("BOUND \t NUMBER OF STATIONS \t MITLI2CLTLoc \t TA2CLTLoc \t CLTLoc2zot \t CHECKING \t SAT \t CHEKING SPACE \n");
				
				System.out.println(dateFormat.format(date)+"\t"+bound+"\t"+stationsNumber+"\t"+checker.getMitli2cltlocTime()+"\t"+checker.getTa2clclocTime()+"\t"+checker.getCltloc2zotTime()+"\t"+checker.getCheckingTime()+"\t"+checker.getSattime()+"\t"+checker.getCheckingspace()+"\n");
				assertTrue(result);
				fileWriter.close();
			}
		}
		
	}
}
