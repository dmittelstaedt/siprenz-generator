package de.hsbremen.siprenz.model.num;

/**
 * Enumeration representing return codes
 * 
 * @author David Mittelstädt
 *
 */
public enum CmdParseStatus {
	
	/**
	 * OK
	 */
	OK(0),
	
	/**
	 * CREATEXML
	 */
	CREATEXML(0),
	
	/**
	 * GENCODE
	 */
	GENCODE(0),
	
	/**
	 * ERROR
	 */
	ERROR(1),
	
	/**
	 * ILLEGAL
	 */
	ILLEGAL(2);
	
	/**
	 * Return code
	 */
	private int returnCode;
	
	/**
	 * Constructor
	 * 
	 * @param returnCode numeric return code
	 */
	CmdParseStatus(int returnCode) {
		this.returnCode = returnCode;
	}
	
	/**
	 * Returs the return code
	 * 
	 * @return return code
	 */
	public int returnCode() {
		return returnCode;
	}

}
