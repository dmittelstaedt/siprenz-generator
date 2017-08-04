package de.hsbremen.siprenz;


import java.util.logging.Logger;

import de.hsbremen.siprenz.logic.Controller;

public class Main {
	
//	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		LOGGER.info("Test output");
		
		Controller controller = new Controller(args);
		controller.start();
		
//		String pathName = "/home/david/Documents/Model/simulation.xml";
//		String pathName = "/home/david/Documents/Model/generated-model.cc";
	}

}
