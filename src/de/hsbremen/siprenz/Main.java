package de.hsbremen.siprenz;

import de.hsbremen.siprenz.logic.CodeGenerator;
import de.hsbremen.siprenz.logic.XmlParser;
import de.hsbremen.siprenz.model.Simulation;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		XmlParser xmlParser = new XmlParser();
		Simulation simulation = xmlParser.read();
		
//		System.out.println(simulation.getNodes().get(1).getId());
		
		CodeGenerator codeGenerator = new CodeGenerator();
		codeGenerator.generate(simulation);
	}

}
