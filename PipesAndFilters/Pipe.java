import java.util.LinkedList;
import java.util.List;

public class Pipe {
	private List<String> wordList;
	private List<String> ignoreWord;

	public Pipe(){
		wordList = new LinkedList<String>();
		ignoreWord = new LinkedList<String>();
	}

	public void writeWordList(List<String> input){
		wordList=input;
	}
	public List<String> readWordList() {
		return wordList;
	}
	
	public void writeIgnoreWord(List<String> ignoreWordList){
		ignoreWord=ignoreWordList;
	}
	public List<String> readIgnoreWord(){
		return ignoreWord;
	}
}