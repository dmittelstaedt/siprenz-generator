package de.hsbremen.siprenz;


import de.hsbremen.siprenz.controller.Controller;
import de.hsbremen.siprenz.logic.sim.SimExecutor;

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
