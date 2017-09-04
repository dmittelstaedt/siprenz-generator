package de.hsbremen.siprenz.logic.sim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.hsbremen.siprenz.utils.FileUtils;
import de.hsbremen.siprenz.utils.StreamUtils;

/**
 * @brief Class for executing a simulation
 * 
 * Not full implemented
 * 
 * @author David Mittelstädt
 *
 */
public class SimExecutor {
	
	String command = "/home/david/Documents/my-hello.sh";
	String arg1 = "David";
	String arg2 = "Bremen";
	List<String> args = new ArrayList<String>();
	
	/**
	 * @brief Start a simulation
	 */
	public void start() {
		
		if (FileUtils.isFile(command)) {
			try {
				args.add(command);
				args.add(arg1);
				args.add(arg2);
				Process process = new ProcessBuilder(args).start();
				System.out.println(StreamUtils.getStringFromInputStream(process.getInputStream()));
				System.out.println(process.exitValue());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("File not found!");
		}
		
	}

}
