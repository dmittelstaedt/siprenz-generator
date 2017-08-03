package de.hsbremen.siprenz.model.xml;

import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Node {
	
	private static final AtomicInteger count = new AtomicInteger(0);
	
	private int id;
	private String name;
	private String type;
	private double startTime;
	private double stopTime;
	
	public Node() {
		this.id = count.getAndIncrement();
	}
	
	public Node(String name, String type, double startTime, double stopTime) {
		this.id = count.getAndIncrement();
		this.name = name;
		this.type = type;
		this.startTime = startTime;
		this.stopTime = stopTime;
	}
	
	public int getId() {
		return id;
	}
	
	@XmlTransient
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	@XmlElement
	@XmlID
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}
	
	public double getStartTime() {
		return startTime;
	}
	
	@XmlElement
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	
	public double getStopTime() {
		return stopTime;
	}
	
	@XmlElement
	public void setStopTime(double stopTime) {
		this.stopTime = stopTime;
	}

}
