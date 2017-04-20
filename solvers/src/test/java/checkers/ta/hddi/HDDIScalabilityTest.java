package checkers.ta.hddi;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

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

public class HDDIScalabilityTest {

	
	private final int bound=12;
	
	@Ignore
	@Test
	public void test1() throws IOException, ZotException {
	
		
		File file=new File("HDDIscalabilityresults.txt");
		
		FileWriter fileWriter=new FileWriter(file, false);
		for(int i=2; i<=10; i++){
			fileWriter=new FileWriter(file, true);
			System.out.println("i: "+i);
			String path = (i<10) ? ClassLoader.getSystemResource("checkers/ta/hddi/hddi_input_0"+i+".q").getPath():
				ClassLoader.getSystemResource("checkers/ta/hddi/hddi_input_"+i+".q").getPath();
	
			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
			MITLILexer lexer = new MITLILexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			MITLIParser parser = new MITLIParser(tokens);
			parser.setBuildParseTree(true);
			MITLIFormula formula = parser.mitli().formula;
	
			ANTLRInputStream tainput = new ANTLRFileStream(
					(i<10) ? ClassLoader.getSystemResource("checkers/ta/hddi/hddi_input_0"+i+".ta").getPath() :
						ClassLoader.getSystemResource("checkers/ta/hddi/hddi_input_"+i+".ta").getPath());
			TALexer talexer = new TALexer(tainput);
			CommonTokenStream tatokens = new CommonTokenStream(talexer);
			TAParser taparser = new TAParser(tatokens);
			taparser.setBuildParseTree(true);
			SystemDecl system = taparser.ta().systemret;
	

			SystemChecker checker = new SystemChecker(system, formula, bound, new PrintStream(ByteStreams.nullOutputStream()));
			boolean result = checker.check();
			fileWriter.write(i+"\t"+checker.getCheckingTime()+"\t"+checker.getCheckingspace()+"\n");
			System.out.println(i+"\t"+checker.getCheckingTime()+"\t"+checker.getCheckingspace()+"\n");
			assertTrue(result);
			fileWriter.close();
		}
		
	}
}
