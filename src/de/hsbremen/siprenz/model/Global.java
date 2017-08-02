package de.hsbremen.siprenz.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Global {
	
	private double duration;
	
	public Global() {
		
	}
	
	public Global(double duration) {
		this.duration = duration;
	}

	public double getDuration() {
		return duration;
	}

	@XmlElement
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
}
