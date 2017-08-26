package de.hsbremen.siprenz;


import de.hsbremen.siprenz.logic.Controller;
import de.hsbremen.siprenz.logic.SimExecutor;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SimExecutor simexec = new SimExecutor();
		simexec.start();
		
//		Controller controller = new Controller(args);
//		controller.start();
//		controller.copy();
	}

}
