package de.hsbremen.siprenz.logic;

import de.hsbremen.siprenz.model.gen.XmlProps;
import de.hsbremen.siprenz.model.num.CmdParseStatus;
import de.hsbremen.siprenz.model.xml.Simulation;

public class Controller {
	
	private String args[];
	private CmdParser cmdParser;
	private SimCreator simCreator;
	private XmlParser xmlParser;
	
	public Controller(String args[]) {
		this.args = args;
		init();
	}
	
	public void start() {
		CmdParseStatus cmdParseStatus = cmdParser.parse();
		
		switch (cmdParseStatus) {
		case OK:
			System.exit(CmdParseStatus.OK.returnCode());
			break;
			
		case CREATEXML:
			createXml();
			System.exit(CmdParseStatus.OK.returnCode());
			break;
			
		case GENCODE:
			genCode();
			System.exit(CmdParseStatus.OK.returnCode());
			break;
			
		case ERROR:
			System.exit(CmdParseStatus.ERROR.returnCode());
			break;
			
		case ILLEGAL:
			System.exit(CmdParseStatus.ILLEGAL.returnCode());
			break;

		default:
			System.exit(100);
			break;
		}
		
	}
	
	private void init() {
		cmdParser = new CmdParser(args);
		simCreator = new SimCreator();
		xmlParser = new XmlParser();
	}
	
	private void createXml() {
		XmlProps xmlProps = cmdParser.getXmlProps();
		Simulation simulation = simCreator.create(xmlProps.getNodesCount());
		xmlParser.write(simulation, xmlProps.getOutputFile());
		System.out.println("Creating XML finished successfully");
	}
	
	private void genCode() {
		
	}

}
