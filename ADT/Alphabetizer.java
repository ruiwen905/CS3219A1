import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {

	private ArrayList<String> lines;

	public Alphabetizer(ArrayList<String> lines) {
		this.lines = lines;
	}
	
	public ArrayList<String> getAlphabeticallyOrderedLines() {
		Collections.sort(lines);
		
		return lines;
	}
}
