package de.hsbremen.siprenz.model.xml;

import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Class for the node of a simulation model.
 * 
 * @author David Mittelstädt
 *
 */
@XmlRootElement
public class Node {
	
	/**
	 * Used for controlling the id of a node
	 */
	private static final AtomicInteger count = new AtomicInteger(0);
	
	/**
	 * 
	 */
	private int id;
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * Type of a node, e.g client, router, server
	 */
	private String type;
	
	/**
	 * Start Time of application
	 */
	private double startTime;
	
	/**
	 * Stop Time of application
	 */
	private double stopTime;
	
	/**
	 * Default Constructor
	 * 
	 * This constructor is necessary for reading and writing XML.
	 */
	public Node() {
		this.id = count.getAndIncrement();
	}
	
	/**
	 * Constructor with all attributes
	 * 
	 * @param name name of the node
	 * @param type type of the node
	 * @param startTime start time of application
	 * @param stopTime stop Time of application
	 */
	public Node(String name, String type, double startTime, double stopTime) {
		this.id = count.getAndIncrement();
		this.name = name;
		this.type = type;
		this.startTime = startTime;
		this.stopTime = stopTime;
	}
	
	/**
	 * 
	 * @return id of the node
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id id of the node
	 */
	@XmlTransient
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return name of the node
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name name of the node
	 */
	@XmlElement
	@XmlID
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return type type of the node
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 
	 * @param type type type of the node
	 */
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 
	 * @return start time of application
	 */
	public double getStartTime() {
		return startTime;
	}
	
	/**
	 * 
	 * @param startTime start time of application
	 */
	@XmlElement
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * 
	 * @return stop time of application
	 */
	public double getStopTime() {
		return stopTime;
	}
	
	/**
	 * 
	 * @param stopTime stop time of application
	 */
	@XmlElement
	public void setStopTime(double stopTime) {
		this.stopTime = stopTime;
	}

}
