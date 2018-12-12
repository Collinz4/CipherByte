package cipherByte;

import cipherByte.KeyFactory;

/**
 * Contains algorithms for the encryption and decryption of data.
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
class CipherProcessor {
	
	/**
	 * This function encrypts byte array data.
	 * 
	 * @param data
	 * @param password
	 * @return encrypted byte array data
	 */
	protected static byte[] encrypt(byte[] data, String password) {
		
		byte[] uniqueSignature = KeyFactory.generateUniqueSignature(25);
		
		int totalBlocks = (int)(Math.ceil(data.length / 64.0)); // each block is 64 bytes
		int dataShiftPosition = 0; // holds position of for data being encrypted
		
		for(int blockNumber = 0; blockNumber < totalBlocks; blockNumber++) {
			
			byte[] blockId = Integer.toString(blockNumber).getBytes();
			byte blockKey[] = KeyFactory.generateBlockKey(uniqueSignature, password.getBytes(), blockId);
			
			for(int i = 0; i < blockKey.length && dataShiftPosition < data.length; i++) {
				
				data[dataShiftPosition] = (byte)(data[dataShiftPosition] ^ blockKey[i]);
				dataShiftPosition++;
			}
		}
		
		return append(uniqueSignature, data);
	}
	
	/**
	 * This function decrypts byte array data.
	 * 
	 * @param data
	 * @param password
	 * @return decrypted byte array data
	 */
	protected static byte[] decrypt(byte[] data, String password) {
		
		byte[] uniqueSignature = copy(data, 0, 25); // pull out uniqueSignature
		data = copy(data, 25, data.length); // remove uniqueSignature
		
		int totalBlocks = (int)(Math.ceil(data.length / 64.0)); // each block is 64 bytes
		int dataShiftPosition = 0; // holds position of for data being encrypted
		
		for(int blockNumber = 0; blockNumber < totalBlocks; blockNumber++) {
			
			byte[] blockId = Integer.toString(blockNumber).getBytes();
			byte blockKey[] = KeyFactory.generateBlockKey(uniqueSignature, password.getBytes(), blockId);
			
			for(int i = 0; i < blockKey.length && dataShiftPosition < data.length; i++) {
				
				data[dataShiftPosition] = (byte)(data[dataShiftPosition] ^ blockKey[i]);
				dataShiftPosition++;
			}
		}
		
		return data;
	}
	
	/**
	 * Appends the two arrays with first being at the beginning and second being at the end.
	 * 
	 * @param first array
	 * @param second array
	 * @return array containing both the first and the second
	 */
	protected static byte[] append(byte[] first, byte[] second) {
		
		int size = first.length + second.length;
		byte[] appendedArray = new byte[size];
		
		int appenededArrayPosition = 0;
		for(int i = 0; i < first.length; i++) {
			appendedArray[appenededArrayPosition] = first[i];
			appenededArrayPosition++;
		}
		
		for(int i = 0; i < second.length; i++) {
			appendedArray[appenededArrayPosition] = second[i];
			appenededArrayPosition++;
		}
		
		return appendedArray;
	}
	
	/**
	 * Copies array data from lowerLimit (inclusive) to upperLimit (exclusive).
	 * 
	 * @param data to copy from
	 * @param lowerLimit
	 * @param upperLimit
	 * @return data within the range of the limits
	 */
	protected static byte[] copy(byte[] data, int lowerLimit, int upperLimit) {
		
		byte[] copiedArray = new byte[upperLimit - lowerLimit];
		
		for(int i = 0; i < copiedArray.length; i++) {
			copiedArray[i] = data[lowerLimit];
			lowerLimit++;
		}
		
		return copiedArray;
	}
}
