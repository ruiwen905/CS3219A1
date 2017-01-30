import java.util.ArrayList;

/**
 * This is the Circular Shift Module for KWIC program.
 * 
 * @author weijieseow
 */
public class CircularShift {

	private ArrayList<String> inputLines;
	private ArrayList<String> wordsToIgnore;
	private ArrayList<String> shiftedLines;

	public CircularShift(ArrayList<String> inputLines, ArrayList<String> wordsToIgnore) {
		this.inputLines = inputLines;
		this.wordsToIgnore = wordsToIgnore;
		shiftedLines = new ArrayList<String>();
	}

	/**
	 * Retrieve circular shifted lines 
	 */
	public ArrayList<String> getShiftedLines() {
		
		if (shiftedLines.isEmpty()) {
			circularShift();
		}
		
		return shiftedLines;
	}

	/**
	 * Perform circular shift on the lines
	 */	
	private void circularShift() {
		
		// Going through all the lines
		for (int i = 0; i < inputLines.size(); i++) {
			
			String line = inputLines.get(i);
			String[] words = line.split(" ");
			
			int lengthOfLine = words.length;
			
			// Going through each word in line
			for (int j = 0; j < lengthOfLine; j++) {
				
				String firstWord = words[j];
				
				// Add the shifted line if the first word is not a ignored word
				if (!wordsToIgnore.contains(firstWord.toLowerCase())) {
					
					// Forming the correct line by appending the words in order
					String keywordLine = words[j];
					
					// Capitalize first letter of keyword
					keywordLine = keywordLine.substring(0, 1).toUpperCase() + keywordLine.substring(1).toLowerCase();
					
					int start = (j + 1) % lengthOfLine;
					
					while (start != j) {
						
						// making ignore words lower case
						if (wordsToIgnore.contains(words[start].toLowerCase())) {
							words[start] = words[start].toLowerCase();
						}
						
						keywordLine = keywordLine + " " + words[start];
						start = (start + 1) % lengthOfLine;
					}
					
					shiftedLines.add(keywordLine);
				}
			}
		}
	}
}
