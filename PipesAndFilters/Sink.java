import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/*
*The sink display the output and write to file
*/
public class Sink extends Filter{

	@Override
	public void run(){
		List<String> output = readWord();
		writeOutputToFile(output);
		// Prompt user that program is completed
		System.out.println("KWIC program completed! Check output.txt for results.");
	}
	private static void writeOutputToFile(List<String> orderedLines) {
		
		try {
			writeToFile(orderedLines);
		} catch (IOException e) {
			System.out.println("Exception when writing to the output file. Please try again.");
			System.exit(1);
		}
	}
	public static void writeToFile(List<String> lines) throws IOException {
	
	File file = new File("output.txt");

    FileWriter fw = new FileWriter(file.getAbsoluteFile());
    BufferedWriter bw = new BufferedWriter(fw);
                   
    for (int i = 0; i < lines.size(); i++) {
    	bw.write(lines.get(i));
    	bw.newLine();
    }
    
    bw.close();
	}
}
	