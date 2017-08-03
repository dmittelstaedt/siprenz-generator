package de.hsbremen.siprenz.model.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"global", "nodes", "connections"})
public class Simulation {
	
	private Global global;
	private ArrayList<Connection> connections;
	private ArrayList<Node> nodes;
	
	public Global getGlobal() {
		return global;
	}

	@XmlElement
	public void setGlobal(Global global) {
		this.global = global;
	}

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