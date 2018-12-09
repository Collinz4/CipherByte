package fileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Reads and writes the data to a specified location.
 * 
 * @author StephenCollins
 */
public class FileHandler {
	
	/**
	 * Reads the file and returns file content as a byte array.
	 * 
	 * @param filePath (including file name and file extension)
	 * @return byte array data
	 * @throws IOException
	 */
	public static byte[] readFile(String filePath) throws IOException {
		
		return Files.readAllBytes(Paths.get(filePath));
	}
	
	/**
	 * Creates a new file containing the data if it doesn't exist.
	 * 
	 * @param filePath (including file name and file extension)
	 * @param data
	 * @throws IOException
	 */
	public static void writeFile(String filePath, byte[] data) throws IOException {
		
		Files.write(Paths.get(filePath), data, StandardOpenOption.CREATE_NEW);
	}
}
