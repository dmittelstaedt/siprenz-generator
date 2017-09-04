package de.hsbremen.siprenz;


import de.hsbremen.siprenz.controller.Controller;

/**
 * @brief Main Class
 * 
 * @author David Mittelstädt
 *
 */
public class Main {

	/**
	 * @param args arguments given from the command-line
	 */
	public static void main(String[] args) {
		
//		SimExecutor simexec = new SimExecutor();
//		simexec.start();
		
		Controller controller = new Controller(args);
		controller.start();
//		controller.copy();
	}

}
