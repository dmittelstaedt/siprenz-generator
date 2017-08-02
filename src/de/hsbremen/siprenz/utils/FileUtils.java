package de.hsbremen.siprenz.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
	
	public static void createFile(String toWrite, String pathName) {
		File file = new File(pathName);
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(toWrite);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
