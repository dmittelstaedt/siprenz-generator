package de.hsbremen.siprenz.model.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class for basic attributes of a simulation model.
 * 
 * @author David Mittelstädt
 *
 */
@XmlRootElement
public class Global {
	
	/**
	 * duration of the simulation
	 */
	private double duration;
	
	/**
	 * application protocol of the simulation
	 */
	private String protocol;
	
	/**
	 * Default constructor
	 */
	public Global() {
		
	}
	
	/**
	 * Constructor with all attributes
	 * 
	 * @param duration duration of the simulation
	 * @param protocol application protocol of the simulation
	 */
	public Global(double duration, String protocol) {
		this.duration = duration;
		this.protocol = protocol;
	}

	/**
	 * 
	 * @return duration of the simulation
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * 
	 * @param duration duration of the simulation
	 */
	@XmlElement
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * 
	 * @return application protocol of the simulation
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * 
	 * @param protocol application protocol of the simulation
	 */
	@XmlElement
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
}
