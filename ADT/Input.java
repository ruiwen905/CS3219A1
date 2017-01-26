import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is the Input module for KWIC program.
 * 
 * @author weijieseow
 *
 */
public class Input {

	public static ArrayList<String> readFromFile(String inputFileName) throws IOException, FileNotFoundException {

		ArrayList<String> lines = new ArrayList<String>();

		BufferedReader br = new BufferedReader(new FileReader(inputFileName));
		
		String line;
		
		while ((line = br.readLine()) != null) {
			lines.add(line);
		}
		
		br.close();
		
		return lines;
	}
}
