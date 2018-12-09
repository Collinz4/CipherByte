package userInterface;

import java.io.IOException;

import cipherByte.CipherByte;

import fileHandler.FileHandler;

/**
 * Bare bones simple command line user interface.
 * 
 * @author StephenCollins
 */
public class CipherByteApplication {

	public static void main(String[] args) {
		
		String fileInput = "";
		String fileOutput = "";
		String password = "";
		boolean encrypt = false;
		
		for(int i = 0; i < args.length; i++) {
			
			// cipher mode (encrypt / decrypt)
			if(args[i].equals("-e")) {
				
				encrypt = true;
				
			} else if(args[i].equals("-d")) {
				
				encrypt = false;
				
			} else if(args[i].equals("-in")) { // specify input file
				
				fileInput = args[i+1];
				i++;
				
			} else if(args[i].equals("-out")) { // specify output file
				
				fileOutput = args[i+1];
				i++;
				
			} else if(args[i].equals("-p")) { // specify user password
				
				password = args[i+1];
				i++;
				
			} else { // bad user input
				System.out.println("Invaled Entry: ");
			}
		}
		
		// Ensures user has set their own values for the following.
		if(!fileInput.equals("") && !fileOutput.equals("") && !password.equals("")) {
			
			// Encrypt Data (else decrypt)
			if(encrypt) {
				
				try {
					byte[] data = FileHandler.readFile(fileInput);
					data = CipherByte.encrypt(data, password);
					FileHandler.writeFile(fileOutput, data);
					
				} catch(IOException e) {
					System.out.println(e.getMessage());
				}
				
			} else {
				
				try {
					
					byte[] data = FileHandler.readFile(fileInput);
					data = CipherByte.decrypt(data, password);
					FileHandler.writeFile(fileOutput, data);
					
				} catch(IOException e) {
					System.out.println(e.getMessage());
				}
			}
		} else {
			System.out.println("Not All Input Values Set: Must Use [-e] or [-d] and [-p], [-in], [-out]");
		}
	}
}
