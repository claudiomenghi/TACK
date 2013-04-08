package parserHandler;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import org.antlr.runtime.*;
 


public class qtlsolver {
    public static void main(String[] args) throws Exception {
    	
    	System.out.println("Quantitative - Metric Temporal Logic Solver");
    	System.out.println("v. 1.0 - 3/3/2013\n");
    	
    	if ( args[0].matches("[a-zA-Z][a-zA-Z0-9-]+\\.tl") ) {
    	
	        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args[0]));
	        QTLLexer lexer = new QTLLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        QTLParser parser = new QTLParser(tokens);
	        parser.tlparser();
	        
	        FileInputStream f0 = null;
	        try {
        		f0 = new FileInputStream("output.cltl");
        		String[] cmd = {"mv", "output.cltl", args[0].replaceAll("\\.tl", ".cltl")};
        		Runtime r1 = Runtime.getRuntime();
            	Process p1 = r1.exec(cmd);	
            	p1.waitFor(); 
            	f0.close();
            	System.out.println("File " + args[0].replaceAll("\\.tl", ".cltl") + " written.");
            	
        	   if (args.length > 1) 
        		   if ( args[1].compareTo("--sat") == 0){
        		   String[] cmd2 = {"sbcl", "--script", args[0].replaceAll("\\.tl", ".cltl")};
        		   
        		   Runtime r = Runtime.getRuntime();
        		   Process p = r.exec(cmd2);
        		   System.out.print("Solving ...");
        		   p.waitFor();        
        		   System.out.println("finished!");
        		   f0 = null;

        		   try {
        			   f0 = new FileInputStream("output.1.txt");
        		   } catch (FileNotFoundException e) {
        			   e.printStackTrace();
        		   }

        		   if (f0 != null){
        			   BufferedReader br = new BufferedReader(new InputStreamReader(f0));			
        			   System.out.println(br.readLine());
        			   br.close();
        		   }
        		   else
        			   System.out.println("Opps...some errors occurred!");
   	        }
            	
            	
        	} catch (FileNotFoundException e) {
        		e.printStackTrace();
        	}
	        
    	}
    }
}