package de.hsbremen.siprenz.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"source", "destination", "dataRate", "delay", "ip", "subnet"})
public class Connection {
	
	private Node source;
	private Node destination;
	private String dataRate;
	private String delay;
	private String ip;
	private String subnet;
	
	public Connection() {
		
	}
	
	public Connection (Node source, Node destination, String dataRate, String delay, 
			String ip, String subnet) {
		this.source = source;
		this.destination = destination;
		this.dataRate = dataRate;
		this.delay = delay;
		this.ip = ip;
		this.subnet = subnet;
	}
	
	public Node getSource() {
		return source;
	}

	@XmlElement
	@XmlIDREF
	public void setSource(Node source) {
		this.source = source;
	}

	public Node getDestination() {
		return destination;
	}

	@XmlElement
	@XmlIDREF
	public void setDestination(Node destination) {
		this.destination = destination;
	}

	public String getDataRate() {
		return dataRate;
	}
	
	@XmlElement
	public void setDataRate(String dataRate) {
		this.dataRate = dataRate;
	}
	
	public String getDelay() {
		return delay;
	}
	
	@XmlElement
	public void setDelay(String delay) {
		this.delay = delay;
	}
	
	public String getIp() {
		return ip;
	}
	
	@XmlElement
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getSubnet() {
		return subnet;
	}
	
	@XmlElement
	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}
	
}
