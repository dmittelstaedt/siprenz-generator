package de.hsbremen.siprenz.model.num;

public enum CmdParseStatus {
	
	OK(0),
	CREATEXML(0),
	GENCODE(0),
	ERROR(1),
	ILLEGAL(2);
	
	private int returnCode;
	
	CmdParseStatus(int returnCode) {
		this.returnCode = returnCode;
	}
	
	public int returnCode() {
		return returnCode;
	}

}
