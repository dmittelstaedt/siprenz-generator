package de.hsbremen.siprenz.logic.sim;

import de.hsbremen.siprenz.model.xml.Simulation;

/**
 * @brief Interface for creating simulation models
 * 
 * @author David Mittelstädt
 *
 */
public interface SimCreator {
	
	/**
	 * @brief Creates a model for a simulation in ns-3
	 * 
	 * @param nodesCount
	 * @return Simulation object
	 */
	public Simulation create(int nodesCount);
	
}
