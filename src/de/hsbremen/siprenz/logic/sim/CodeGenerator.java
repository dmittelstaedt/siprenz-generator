package de.hsbremen.siprenz.logic.sim;

import de.hsbremen.siprenz.model.xml.Simulation;

/**
 * 
 * @author david
 *
 */
public interface CodeGenerator {
	
	/**
	 * 
	 * @param simulation
	 * @param dirName
	 */
	void generate(Simulation simulation, String dirName);

}
