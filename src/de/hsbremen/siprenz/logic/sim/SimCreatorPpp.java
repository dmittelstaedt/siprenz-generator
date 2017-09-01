package de.hsbremen.siprenz.logic.sim;

import java.util.ArrayList;

import de.hsbremen.siprenz.model.xml.Connection;
import de.hsbremen.siprenz.model.xml.Global;
import de.hsbremen.siprenz.model.xml.Node;
import de.hsbremen.siprenz.model.xml.Simulation;

/**
 * 
 * @author david
 *
 */
public class SimCreatorPpp implements SimCreator {
	
	//TODO: check wheter nodesCount is greater than 2
	@Override
	public Simulation create(int nodesCount) {
		Global global = new Global(30.0, "iec61850");
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("r1", "router", 1.0, 10.0));
		for (int i=1; i<nodesCount-1; i++) {
			nodes.add(new Node("s" + i, "server", 1.0, 10.0));
		}
		nodes.add(new Node("c1", "client", 5.0, 10.0));
		
		ArrayList<Connection> connections = new ArrayList<Connection>();
		for (int i=1; i<nodesCount; i++) {
			connections.add(new Connection(nodes.get(0), nodes.get(i), "P2P","5Mbps", "2ms", "10.1." + i + ".0", "255.255.255.252"));
		}
		
		Simulation simulation = new Simulation();
		simulation.setGlobal(global);
		simulation.setNodes(nodes);
		simulation.setConnections(connections);
		
		return simulation;
	}

}
