package fileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Reads and writes the data to a specified location.
 * 
 * Copyright (C) 2018  Stephen J Collins
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
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
