package de.hsbremen.siprenz.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils {
	
	public static boolean isFile(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}
	
	// TODO: throw the exception
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
	
	public static boolean createDir(String dirName) {
		File dir = new File(dirName);
		return dir.mkdir();
	}
	
	// TODO: Exception Handling with if
	public static boolean createDirs(String dirPath) {
		File dir = new File(dirPath);
		return dir.mkdirs();
	}
	
	public static boolean isDir(String dirName) {
		File dir = new File(dirName);
		return dir.exists() && dir.isDirectory();
	}
	
	// http://roufid.com/how-to-delete-folder-recursively-in-java/
	public static void deleteDir(String dirName) throws IOException {
		Path directory = Paths.get(dirName);
		Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
		   @Override
		   public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		       Files.delete(file);
		       return FileVisitResult.CONTINUE;
		   }

		   @Override
		   public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		       Files.delete(dir);
		       return FileVisitResult.CONTINUE;
		   }
		});
	}

}
