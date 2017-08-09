package de.hsbremen.siprenz;


import de.hsbremen.siprenz.logic.Controller;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		Controller controller = new Controller(args);
		controller.start();
//		controller.copy();
	}

}
