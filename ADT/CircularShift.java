import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the Circular Shift Module for KWIC.
 * 
 * @author weijieseow
 *
 */
public class CircularShift {

	private ArrayList<String> inputLines;
	private ArrayList<String> wordsToIgnore;

	public CircularShift(ArrayList<String> inputLines, ArrayList<String> wordsToIgnore) {
		this.inputLines = inputLines;
		this.wordsToIgnore = wordsToIgnore;
	}

	/**
	 * Retrieve circular shifted lines 
	 */
	public ArrayList<String> getShiftedLines() {
		ArrayList<String> shiftedLines = new ArrayList<String>();
		Queue<String> queue = new LinkedList<String>();

		// Going through all the lines
		for (int i = 0; i < inputLines.size(); i++) {
			queue.offer(inputLines.get(i));
		}

		// Using a queue to go through all possible orders of circular shift 
		// by appending the first word to the end of the string
		while (!queue.isEmpty()) {

			String line = queue.poll();
			
			// Discarding lines that is duplicated
			if (!shiftedLines.contains(line)) {
				
				// Splitting each line into words
				String[] wordsInLine = line.split(" ");

				String firstWord = wordsInLine[0];
				
				// Add the shifted line if the first word is not a ignored word
				if (!wordsToIgnore.contains(firstWord.toLowerCase())) {
					shiftedLines.add(line);
				}
				String modifiedLine = appendFirstWordToEnd(wordsInLine, firstWord);
				queue.offer(modifiedLine);
			}
		}

		return shiftedLines;
	}

	/**
	 * Brings the first word to the end of the string
	 *
	 */
	private String appendFirstWordToEnd(String[] wordsInLine, String firstWord) {

		String result = "";

		for (int i = 1; i < wordsInLine.length; i++) {
			result += wordsInLine[i];
			result += " ";
		}

		result += firstWord;

		return result;
	}
}
