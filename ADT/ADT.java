import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the master control of the KWIC program that controls the sequence and handle exceptions.
 * @author weijieseow
 */
public class ADT {

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
		
		sc.close();
		
		// Retrieve needed information for KWIC
		ArrayList<String> inputLines = readInputFile(inputFileName);
		ArrayList<String> wordsToIgnore = readInputFile(wordsToIgnoreFileName);
		
		// Perform circular shift to each line
		CircularShift circularShift = new CircularShift(inputLines, wordsToIgnore);
		ArrayList<String> shiftedLines = circularShift.getShiftedLines();
		
		// Alphabetize shifted lines in alphabetical order
		Alphabetizer alphabetizer = new Alphabetizer(shiftedLines);
		ArrayList<String> orderedLines = alphabetizer.getAlphabeticallyOrderedLines();
		
		for (int i = 0; i < orderedLines.size(); i++) {
			System.out.println(orderedLines.get(i));
		}
		// Perform output in stated file
	}

	/**
	 * Read from input file and store the content as Strings in a list
	 */
	private static ArrayList<String> readInputFile(String inputFileName) {
		
		ArrayList<String> inputLines = new ArrayList<String>();
		
		try {
			inputLines = Input.readFromFile(inputFileName);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate input file. Please check that the correct file name is entered.");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Exception when reading the input file. Please try again.");
			System.exit(1);
		}
		
		return inputLines;
	}

	
}
