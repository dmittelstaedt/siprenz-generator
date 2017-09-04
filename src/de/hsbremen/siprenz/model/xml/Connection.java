package de.hsbremen.siprenz.model.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class for connection element of the simulation.
 * 
 * This class represents the connection object of the simulation.
 * Uses annotations for XML support.
 * 
 * @author David Mittelstädt
 *
 */
@XmlRootElement
@XmlType(propOrder={"source", "destination", "type", "dataRate", "delay", "ip", "subnet"})
public class Connection {
	
	/**
	 * 
	 */
	private Node source;
	
	/**
	 * 
	 */
	private Node destination;
	
	/**
	 * 
	 */
	private String type;
	
	/**
	 * 
	 */
	private String dataRate;
	
	/**
	 * 
	 */
	private String delay;
	
	/**
	 * 
	 */
	private String ip;
	
	/**
	 * 
	 */
	private String subnet;
	
	/**
	 * Default constructor
	 */
	public Connection() {
		
	}
	
	/**
	 * Constructor with all attributes
	 * 
	 * @param source Source node
	 * @param destination Destination node
	 * @param type connection type, e.g. P2P
	 * @param dataRate Data rate
	 * @param delay delay of the connection
	 * @param ip first IP of the given nodes
	 * @param subnet subnet mask
	 */
	public Connection (Node source, Node destination, String type, String dataRate, String delay, 
			String ip, String subnet) {
		this.source = source;
		this.destination = destination;
		this.type = type;
		this.dataRate = dataRate;
		this.delay = delay;
		this.ip = ip;
		this.subnet = subnet;
	}
	
	/**
	 * 
	 * @return Source node
	 */
	public Node getSource() {
		return source;
	}

	/**
	 * 
	 * @param source Source node
	 */
	@XmlElement
	@XmlIDREF
	public void setSource(Node source) {
		this.source = source;
	}

	/**
	 * 
	 * @return Destination node
	 */
	public Node getDestination() {
		return destination;
	}

	/**
	 * 
	 * @param destination Destination node
	 */
	@XmlElement
	@XmlIDREF
	public void setDestination(Node destination) {
		this.destination = destination;
	}

	/**
	 * 
	 * @return connection type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type connection type
	 */
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return Data rate
	 */
	public String getDataRate() {
		return dataRate;
	}
	
	/**
	 *  
	 * @param dataRate Data rate
	 */
	@XmlElement
	public void setDataRate(String dataRate) {
		this.dataRate = dataRate;
	}
	
	/**
	 * 
	 * @return delay of the connection
	 */
	public String getDelay() {
		return delay;
	}
	
	/**
	 * 
	 * @param delay delay of the connection
	 */
	@XmlElement
	public void setDelay(String delay) {
		this.delay = delay;
	}
	
	/**
	 * 
	 * @return first IP of the given nodes
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * 
	 * @param ip first IP of the given nodes
	 */
	@XmlElement
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 * 
	 * @return subnet mask
	 */
	public String getSubnet() {
		return subnet;
	}
	
	/**
	 * 
	 * @param subnet subnet mask
	 */
	@XmlElement
	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}
	
}
