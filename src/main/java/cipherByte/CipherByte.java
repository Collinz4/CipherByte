package cipherByte;

/**
 * Wrapper class for the cipherByte algorithm.
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
