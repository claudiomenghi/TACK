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

import checkers.SystemChecker;
import formulae.mitli.MITLIFormula;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import ta.SystemDecl;
import ta.parser.TALexer;
import ta.parser.TAParser;
import zotrunner.ZotException;

public class CSMACDScalabilityTest {

	public static void main(String [ ] args) throws IOException, ZotException {
	
		System.out.println("Starting the Fischer scalability test ");
		File file=new File("CSMACDScalabilityresults.txt");
		FileWriter fileWriter=new FileWriter(file, false);
		
		for(int bound=10; bound<=30; bound=bound+5){
			
			for(int numberOfWriters=2; numberOfWriters<=10; numberOfWriters++){
				fileWriter=new FileWriter(file, true);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				
				System.out.println(dateFormat.format(date)+"\t BOUND: "+bound+"\t NUMBER OF WRITERS: "+numberOfWriters);
			
				String path = (numberOfWriters<10) ? "./csma_input_0"+numberOfWriters+".q":
					"./csma_input_"+numberOfWriters+".q";
		
				
				System.out.println("parsing the formula");
				ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
				MITLILexer lexer = new MITLILexer(input);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				MITLIParser parser = new MITLIParser(tokens);
				parser.setBuildParseTree(true);
				MITLIFormula formula = parser.mitli().formula;
		
				

				System.out.println("parsing the TA");
				path = (numberOfWriters<10) ? "./csma_input_0"+numberOfWriters+".ta":
					"./csma_input_"+numberOfWriters+".ta";
				ANTLRInputStream tainput = new ANTLRFileStream(path);
				TALexer talexer = new TALexer(tainput);
				CommonTokenStream tatokens = new CommonTokenStream(talexer);
				TAParser taparser = new TAParser(tatokens);
				taparser.setBuildParseTree(true);
				SystemDecl system = taparser.ta().systemret;
		
				System.out.println("Running the model checker");
				SystemChecker checker = new SystemChecker(system, formula, bound, new PrintStream(ByteStreams.nullOutputStream()));
				boolean result = checker.check();
				fileWriter.write(bound+"\t"+numberOfWriters+"\t"+"\t"+checker.getMitli2cltlocTime()+"\t"+checker.getTa2clclocTime()+"\t"+checker.getCltloc2zotTime()+"\t"+checker.getCheckingTime()+"\t"+checker.getSattime()+"\t"+checker.getCheckingspace()+"\n");
				System.out.println("BOUND \t NUMBER OF WRITERS \t MITLI2CLTLoc \t TA2CLTLoc \t CLTLoc2zot \t CHECKING \t SAT \t CHEKING SPACE \n");
				
				System.out.println(dateFormat.format(date)+"\t"+bound+"\t"+numberOfWriters+"\t"+checker.getMitli2cltlocTime()+"\t"+checker.getTa2clclocTime()+"\t"+checker.getCltloc2zotTime()+"\t"+checker.getCheckingTime()+"\t"+checker.getSattime()+"\t"+checker.getCheckingspace()+"\n");
				if(result){
					throw new InternalError("The property must be violated");
				}
				fileWriter.close();
			}
		}
		
	}
}
