package cipherByte;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Generates the unique signatures and keys required for the cipher.
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
class KeyFactory {
	
	/**
	 * Returns a unique block key of 64 bytes for that block location.
	 * 
	 * @param password
	 * @param blockId
	 * @param uniqueSignature
	 * @return unique block key
	 */
	protected static byte[] generateBlockKey(byte[] password, byte[] blockId, byte[] uniqueSignature) {
		
		int inputCombinationSize = password.length + blockId.length + uniqueSignature.length;
		byte[] inputCombination = new byte[inputCombinationSize];
		
		
		// Fill 'inputCombination' With Data (order matters: uniqueSignature + password + blockId)
		
		int loopValue = 0;
		
		// Unique Signature
		for(int i = loopValue; i < uniqueSignature.length;  i++) {
			inputCombination[i] = uniqueSignature[i];
			loopValue++;
		}
		
		// Password
		for(int i = loopValue; i < password.length; i++) {
			inputCombination[i] = password[i];
			loopValue++;
		}
		
		// Block ID
		for(int i = loopValue; i < blockId.length; i++) {
			inputCombination[i] = blockId[i];
			loopValue++;
		}
		
		return sha512Hash(inputCombination);
	}
	
    /**
     * Generates a byte array of size n containing random data.
     * 
     * @param n size of the array to generate
     * @return byte array containing random data
     */
    protected static byte[] generateUniqueSignature(int n) {
    	
    	Random r = new Random();
    	byte[] randomData = new byte[n];
    	
    	for(int i = 0; i < randomData.length; i++) {
    		randomData[i] = (byte) r.nextInt(128);
    	}
    	
    	return randomData;
    }
    
    /**
     * Hashes the byte array input using a SHA-512 hash algorithm.
     *
     * @param input byte array to hash
     * @return hashed byte array
     */
	private static byte[] sha512Hash(byte[] input) {
		
		try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(input);
            return messageDigest.digest();
        } catch(NoSuchAlgorithmException e) {
            System.out.println("Error Hashing: " + e.getMessage());
        }
        return null;
	}
}
