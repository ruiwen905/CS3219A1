import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ADT {
	
	/**
	 * This is the master control of the KWIC program.
	 * @author weijieseow
	 */

	public static void main(String[] args) {
		
		// Printing out reminder for file names to be exact
		System.out.println("This is the KWIC (Key Word In Context) index system.");
		System.out.println("Make sure the file name is correct.");
		
		Scanner sc = new Scanner(System.in);
		
		String inputFileName, wordsToIgnoreFileName, outputFileName;
		
		// Getting input file
		System.out.print("Enter input file name: ");
		inputFileName = sc.next();
		
		// Getting words to ignore file
		System.out.print("Enter words to ignore file name: ");
		wordsToIgnoreFileName = sc.next();
		
		// Getting output file
		System.out.print("Enter output file name: ");
		outputFileName = sc.next();
		
		System.out.println(inputFileName + " " + wordsToIgnoreFileName + " " + outputFileName);
		
		sc.close();
		
		ArrayList<String> inputLines = readFromFile(inputFileName);
		
		for (int i = 0; i < inputLines.size(); i++) {
			System.out.println(inputLines.get(i));
		}
		
	}

	private static ArrayList<String> readFromFile(String inputFileName) {
		
		ArrayList<String> records = new ArrayList<String>();
		  try
		  {
		    BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
		    String line;
		    while ((line = reader.readLine()) != null)
		    {
		      records.add(line);
		    }
		    reader.close();
		    return records;
		  }
		  catch (Exception e)
		  {
		   /* System.err.format("Exception occurred trying to read '%s'.", inputFileName);
		    e.printStackTrace();
		    return null; */
			  System.out.println("Exception occurred trying to read "+ inputFileName + ".");
			  System.exit(1);
			  
			  return null;
		  }
	}
}
