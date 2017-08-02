package de.hsbremen.siprenz;


import java.util.logging.Logger;

import de.hsbremen.siprenz.logic.CodeGenerator;
import de.hsbremen.siprenz.logic.XmlParser;
import de.hsbremen.siprenz.model.Simulation;

public class Main {
	
	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LOGGER.info("Test output");
	
		XmlParser xmlParser = new XmlParser();
//		xmlParser.write();
		Simulation simulation = xmlParser.read();
		
//		System.out.println(simulation.getNodes().get(1).getId());
		
		CodeGenerator codeGenerator = new CodeGenerator();
		codeGenerator.generate(simulation);
	}

}
