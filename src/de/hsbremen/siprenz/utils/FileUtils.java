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

/**
 * Class for file and directory operations.
 * 
 * @author David Mittelstädt
 *
 */
public class FileUtils {
	
	/**
	 * 
	 * @param fileName name of the file to check
	 * @return whether file exists
	 */
	public static boolean isFile(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}
	
	/**
	 * Creating a new File with given content.
	 * 
	 * @param toWrite content of the file
	 * @param pathName path to file
	 */
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
	
	/**
	 * Creating a directory.
	 * 
	 * @param dirName name of the directory
	 * @return whether directory was successfully created
	 */
	public static boolean createDir(String dirName) {
		File dir = new File(dirName);
		return dir.mkdir();
	}
	
	/**
	 * Creating a directory tree if parent directory doesn't exist.
	 * 
	 * @param dirPath path to directory
	 * @return whether directories were successfully created
	 */
	// TODO: Exception Handling with if
	public static boolean createDirs(String dirPath) {
		File dir = new File(dirPath);
		return dir.mkdirs();
	}
	
	/**
	 * Checks existing directory.
	 * 
	 * @param dirName name of the directory
	 * @return whether directory exists
	 */
	public static boolean isDir(String dirName) {
		File dir = new File(dirName);
		return dir.exists() && dir.isDirectory();
	}
	
	/**
	 * Deleting recursively directories 
	 * 
	 * @see // http://roufid.com/how-to-delete-folder-recursively-in-java/
	 * 
	 * @param dirName name of the parent directory
	 * @throws IOException
	 */
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
