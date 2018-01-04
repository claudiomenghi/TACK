package solvers.output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OutputSpaceParser {

	private final String fileName;
	private final File output1File;
	
	public  OutputSpaceParser(){
		this.fileName="output.1.txt";
		this.output1File=new File(this.fileName);
	}
	
	public  OutputSpaceParser(String fileName){
		this.fileName=fileName;
		this.output1File=new File(this.fileName);
	}
	public double getSpace() throws IOException{
		
		BufferedReader reader=new BufferedReader(new FileReader(output1File));
		
		double space=0;
		 String text = null;
		while ((text = reader.readLine()) != null) {
			if(text.contains(" :max-memory")){
			    
				
	        	space=Double.parseDouble(
	        			text.substring(text.indexOf(":max-memory ")+":max-memory ".length()));
	            
	        }
	    }
		reader.close();
		return space;
	}
}
