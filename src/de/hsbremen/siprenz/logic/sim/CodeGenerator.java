package de.hsbremen.siprenz.logic.sim;

import de.hsbremen.siprenz.model.xml.Simulation;

/**
 * @brief The interfaces for code generators
 * 
 * @author David Mittelstädt
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
