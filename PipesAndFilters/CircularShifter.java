import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class CircularShifter extends Filter{
	
	private List<String> wordList;
	private List<String> ignoreList;
	
	@Override
	public void run(){
		wordList = readWord();
		ignoreList = readIgnoreWord();	
		List<String> shiftedLines = getAllCircularShift();
		writeWord(shiftedLines);
	}
	
	/**
	 * Retrieve circular shifted lines 
	 */
	public List<String> getAllCircularShift() {
		ArrayList<String> shiftedLines = new ArrayList<String>();
		Queue<String> queue = new LinkedList<String>();

		// Going through all the lines
		for (int i = 0; i < wordList.size(); i++) {
			queue.offer(wordList.get(i));
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
				if (!ignoreList.contains(firstWord.toLowerCase())) {
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
