package de.hsbremen.siprenz.model.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class for the whole simulation.
 * 
 * @author David Mittelstädt
 *
 */
@XmlRootElement
@XmlType(propOrder={"global", "nodes", "connections"})
public class Simulation {
	
	/**
	 * Global part of the simulation
	 */
	private Global global;
	
	/**
	 * All connections of the simulation
	 */
	private ArrayList<Connection> connections;
	
	/**
	 * All nodes of the simulation
	 */
	private ArrayList<Node> nodes;
	
	/**
	 * 
	 * @return Global part of the simulation
	 */
	public Global getGlobal() {
		return global;
	}

	/**
	 * 
	 * @param global Global part of the simulation
	 */
	@XmlElement
	public void setGlobal(Global global) {
		this.global = global;
	}

	/**
	 * 
	 * @return All connections of the simulation
	 */
	public ArrayList<Connection> getConnections() {
		return connections;
	}
	
	/**
	 * 
	 * @param connections All connections of the simulation
	 */
	@XmlElementWrapper
	@XmlElement(name="connection")
	public void setConnections(ArrayList<Connection> connections) {
		this.connections = connections;
	}
	
	/**
	 * 
	 * @return All nodes of the simulation
	 */
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	
	/**
	 * 
	 * @param nodes All nodes of the simulation
	 */
	@XmlElementWrapper
	@XmlElement(name="node")
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

}
