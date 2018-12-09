package cipherByte;

/**
 * Wrapper class for the cipherByte algorithm.
 * 
 * @author StephenCollins
 */
public class CipherByte {
	
	/**
	 * Encrypts byte array data and returns encrypted byte array data.
	 * 
	 * @param byte array data
	 * @param password
	 * @return encrypted byte array data
	 */
	public static byte[] encrypt(byte[] data, String password) {
		
		return CipherProcessor.encrypt(data, password);
	}
	
	/**
	 * Decrypts byte array data and returns decrypted byte array data.
	 * 
	 * @param encrypted byte array data
	 * @param password
	 * @return decrypted byte array data
	 */
	public static byte[] decrypt(byte[] data, String password) {
		
		return CipherProcessor.decrypt(data, password);
	}
}
