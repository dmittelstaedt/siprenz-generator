package de.hsbremen.siprenz.model.gen;

public class CodeProps {
	
	private String inFile;
	private String outFile;
	
	public CodeProps(String inFile, String outFile) {
		this.inFile = inFile;
		this.outFile = outFile;
	}
	
	public String getInFile() {
		return inFile;
	}
	
	public void setInFile(String inFile) {
		this.inFile = inFile;
	}
	
	public String getOutFile() {
		return outFile;
	}
	
	public void setOutFile(String outFile) {
		this.outFile = outFile;
	}

}
