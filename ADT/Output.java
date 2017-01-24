import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is the Output module for KWIC program.
 * 
 * @author weijieseow
 *
 */
public class Output {

	public static void writeToFile(String fileName, ArrayList<String> lines) throws IOException {
		
		File file = new File(fileName);
		 
        // if file doesnt exists, then create it
        if (!file.exists()) {
           file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
                       
        for (int i = 0; i < lines.size(); i++) {
        	bw.write(lines.get(i));
        	bw.newLine();
        }
        
        bw.close();

	}
}
