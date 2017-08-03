package de.hsbremen.siprenz.model.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Global {
	
	private double duration;
	private String protocol;
	
	public Global() {
		
	}
	
	public Global(double duration, String protocol) {
		this.duration = duration;
		this.protocol = protocol;
	}

	public double getDuration() {
		return duration;
	}

	@XmlElement
	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getProtocol() {
		return protocol;
	}

	@XmlElement
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
}
