package de.hsbremen.siprenz.model.gen;

public class XmlProps {
	
	private int nodesCount;
	private String outputFile;
	
	public XmlProps(int nodesCount, String outputFile) {
		this.nodesCount = nodesCount;
		this.outputFile = outputFile;
	}
	
	public int getNodesCount() {
		return nodesCount;
	}
	
	public void setNodesCount(int nodesCount) {
		this.nodesCount = nodesCount;
	}
	
	public String getOutputFile() {
		return outputFile;
	}
	
	public void setOutputFile(String outFile) {
		this.outputFile = outFile;
	}
	
}
