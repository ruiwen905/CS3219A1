import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
The pump takes in input text from the user 
*/
public class Pump extends Filter {
	
	private static final String DEFAULT_INPUT_FILE_LOCATION = "input.txt";
    private static final String DEFAULT_NOISE_WORDS_FILE_LOCATION = "ignoreWord.txt";
    
    private String inputFile = new String();
    private String ignoreFile = new String();
	
    public static Scanner sc = new Scanner(System.in);

	public Pump(){
		inputFile = DEFAULT_INPUT_FILE_LOCATION;
		ignoreFile = DEFAULT_NOISE_WORDS_FILE_LOCATION;
	}

	@Override
	public void run(){
		readInput();
		List<String> inputLines = readFile(inputFile);
		List<String> wordsToIgnore = readFile(ignoreFile);

		writeWord(inputLines);
		writeIgnoreWord(wordsToIgnore);
	}

	private void readInput() {
		String option;
		
		System.out.println("====Welcome to KWIC====");
        System.out.println("Default input file name: input.txt");
        System.out.println("Default ignore word file name: ignoreWord.txt");
        
        do {
            System.out.println("Do you want to use the default input and ignore word file name? (y/n)");
            option = sc.next();
        } while(!option.equals("y") && !option.equals("n"));

        if(option.equals("n")) {
            System.out.println("Please enter your input file name:");
            if(sc.hasNext()){
            	inputFile = sc.nextLine();
            }

            System.out.println("Please enter your noise words file name:");
            if(sc.hasNext()){
            	ignoreFile = sc.nextLine();
            }
        }
	}
	private static List<String> readFile(String inputFileName) {
		
		List<String> inputLines = new ArrayList<String>();
		try {
			inputLines = readFromFile(inputFileName);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate file. Please check that the correct file name is entered.");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Exception when reading the file. Please try again.");
			System.exit(1);
		}
		
		return inputLines;
	}
	
	public static List<String> readFromFile(String inputFileName) throws IOException, FileNotFoundException {

		List<String> lines = new LinkedList<String>();

		BufferedReader br = new BufferedReader(new FileReader(inputFileName));
		
		String line;
		
		while ((line = br.readLine()) != null) {
			lines.add(line);
		}
		
		br.close();
		
		return lines;
	}
	

}