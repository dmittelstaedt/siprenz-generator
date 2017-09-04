package de.hsbremen.siprenz.model.gen;

/**
 * Class representing XML properties
 * 
 * @author David Mittelstädt
 *
 */
public class XmlProps {
	
	/**
	 * Number of nodes
	 */
	private int nodesCount;
	
	/**
	 * Name of output file
	 */
	private String outputFile;
	
	/**
	 * Constructor
	 * 
	 * @param nodesCount Number of nodes
	 * @param outputFile Name of the output file
	 */
	public XmlProps(int nodesCount, String outputFile) {
		this.nodesCount = nodesCount;
		this.outputFile = outputFile;
	}
	
	/**
	 * 
	 * @return Number of nodes
	 */
	public int getNodesCount() {
		return nodesCount;
	}
	
	/**
	 * 
	 * @param nodesCount Number of nodes
	 */
	public void setNodesCount(int nodesCount) {
		this.nodesCount = nodesCount;
	}
	
	/**
	 * 
	 * @return Name of the output file
	 */
	public String getOutputFile() {
		return outputFile;
	}
	
	/**
	 * 
	 * @param outFile Name of the output file
	 */
	public void setOutputFile(String outFile) {
		this.outputFile = outFile;
	}
	
}
