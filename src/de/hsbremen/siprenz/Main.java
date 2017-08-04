package de.hsbremen.siprenz;


import java.io.FileOutputStream;
import java.io.InputStream;

import de.hsbremen.siprenz.logic.Controller;
import de.hsbremen.siprenz.utils.FileHelper;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileHelper fileHelper = new FileHelper();
		fileHelper.copy();
				
//		Controller controller = new Controller(args);
//		controller.start();
	}

}
