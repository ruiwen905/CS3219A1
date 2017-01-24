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

	public ArrayList<String> getShiftedLines() {
		ArrayList<String> shiftedLines = new ArrayList<String>();
		Queue<String> queue = new LinkedList<String>();

		// Going through all the lines
		for (int i = 0; i < inputLines.size(); i++) {
			queue.offer(inputLines.get(i));
		}

		while (!queue.isEmpty()) {

			String line = queue.poll();
			
			if (!shiftedLines.contains(line)) {
				// Splitting each line into words
				String[] wordsInLine = line.split(" ");

				String firstWord = wordsInLine[0];

				if (!wordsToIgnore.contains(firstWord.toLowerCase())) {
					shiftedLines.add(line);
				}
				String modifiedLine = appendFirstWordToEnd(wordsInLine, firstWord);
				queue.offer(modifiedLine);
			}
		}

		return shiftedLines;
	}

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
