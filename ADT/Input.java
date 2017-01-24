import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {

	public static ArrayList<String> readFromFile(String inputFileName) throws IOException, FileNotFoundException {

		ArrayList<String> records = new ArrayList<String>();

		BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
		String line;
		while ((line = reader.readLine()) != null) {
			records.add(line);
		}
		reader.close();
		return records;
	}
}
