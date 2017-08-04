package de.hsbremen.siprenz.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.nio.file.Files;
import java.util.Scanner;


public class FileHelper {
	
	public void copy() {
		
//		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = getClass().getResourceAsStream("/res/test.txt");
		
		String result = getStringFromInputStream(inputStream);
		
		System.out.println(result);
		
//		FileUtils.createFile(result, "/home/david/Documents/Model/test.txt");
		
//		File source = new File(getClass().getResource("/res/test.txt").getFile());
//		File dest = new File ("/home/david/Documents/Model/test.txt");
		
//		System.out.println(source.getPath());
//		
//		StringBuilder result = new StringBuilder("");
//		
//		try (Scanner scanner = new Scanner(source)) {
//
//		while (scanner.hasNextLine()) {
//			String line = scanner.nextLine();
//			result.append(line).append("\n");
//		}
//
//		scanner.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(result.toString());
		
//		try {
//			Files.copy(source.toPath(), dest.toPath());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	private String getStringFromInputStream (InputStream inputStream) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		
		String line;
		try {

			br = new BufferedReader(new InputStreamReader(inputStream));
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		//remove last character
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}
