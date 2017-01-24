import java.io.FileNotFoundException;
import java.io.IOException;
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
		
		ArrayList<String> inputLines = null;
		
		try {
			inputLines = Input.readFromFile(inputFileName);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate input file. Please check that the correct file name is entered.");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Exception when reading the input file. Please try again.");
			System.exit(1);
		}
		
		for (int i = 0; i < inputLines.size(); i++) {
			System.out.println(inputLines.get(i));
		}
		
	}

	
}
