package de.hsbremen.siprenz.model.gen;

public class XmlProps {
	
	private int nodesCount;
	private String outFile;
	
	public XmlProps(int nodesCount, String outFile) {
		this.nodesCount = nodesCount;
		this.outFile = outFile;
	}
	
	public int getNodesCount() {
		return nodesCount;
	}
	
	public void setNodesCount(int nodesCount) {
		this.nodesCount = nodesCount;
	}
	
	public String getOutFile() {
		return outFile;
	}
	
	public void setOutFile(String outFile) {
		this.outFile = outFile;
	}
	
}
