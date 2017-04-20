package checkers.output;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import zotrunner.ZotException;

public class OutputSpaceParserTest {

	/**
	 * The property is not related to the model and thus it is not satisfied
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ZotException
	 */
	@Test
	public void parserTest() throws FileNotFoundException, IOException, ZotException {
		double space=new OutputSpaceParser(ClassLoader.getSystemResource("checkers/output/output.1.txt").getPath()).getSpace();
		System.out.println(space);
		assertTrue(
				Double.compare(space, 469.57)==0);
	}
	

}
