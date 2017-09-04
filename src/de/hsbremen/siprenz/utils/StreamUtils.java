package de.hsbremen.siprenz.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class for some stream operations.
 * 
 * @author David Mittelstädt
 *
 */
public class StreamUtils {
	
	/**
	 * Creates a String from inputStrem
	 * 
	 * @param inputStream InputStream
	 * @return String
	 */
	public static String getStringFromInputStream (InputStream inputStream) {
		BufferedReader bufferedReader = null;
		StringBuilder stringBuilder = new StringBuilder();
		
		String line;
		try {

			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line).append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		//remove last character
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
		return stringBuilder.toString();
	}

}
