package de.hsbremen.siprenz.logic.sim;

import de.hsbremen.siprenz.model.xml.Simulation;

public interface SimCreator {
	
	/**
	 * 
	 * @param nodesCount
	 * @return
	 */
	public Simulation create(int nodesCount);
	
}
