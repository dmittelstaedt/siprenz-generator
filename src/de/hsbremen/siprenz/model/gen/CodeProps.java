package de.hsbremen.siprenz.model.gen;

/**
 * Class representing code properties
 * 
 * @author David Mittelstädt
 *
 */
public class CodeProps {
	
	/**
	 * Name of input file
	 */
	private String inputFile;
	
	/**
	 * Name of output file
	 */
	private String outputFile;
	
	/**
	 * Constructor
	 * 
	 * @param inputFile Name of the input file
	 * @param outputFile Name of the output file
	 */
	public CodeProps(String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}

	/**
	 * Getter-method for inputFile
	 * 
	 * @return Name of the input file
	 */
	public String getInputFile() {
		return inputFile;
	}

	/**
	 * Setter-method for inputFile
	 * 
	 * @param inputFile Name of the input file
	 */
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * Getter-method for outputFile
	 * 
	 * @return Name of the output file
	 */
	public String getOutputFile() {
		return outputFile;
	}

	/**
	 * Setter-method for outputFile
	 * 
	 * @param outputFile Name of the output file
	 */
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

}
