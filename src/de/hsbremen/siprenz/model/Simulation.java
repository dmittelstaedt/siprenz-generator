package de.hsbremen.siprenz.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Simulation {
	
	private ArrayList<Connection> connections;
	private ArrayList<Node> nodes;
	
	public ArrayList<Connection> getConnections() {
		return connections;
	}
	
	@XmlElementWrapper
	@XmlElement(name="connection")
	public void setConnections(ArrayList<Connection> connections) {
		this.connections = connections;
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	
	@XmlElementWrapper
	@XmlElement(name="node")
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

}
