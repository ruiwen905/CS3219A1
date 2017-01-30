import java.util.Collections;
import java.util.List;
/*
The Alphabetizer uses collection.sort to sort in alphabetical order
*/
public class Alphabetizer extends Filter{
	@Override
	public void run(){
		List<String> wordlist=readWord();
		Collections.sort(wordlist);
		writeWord(wordlist);
	}
}