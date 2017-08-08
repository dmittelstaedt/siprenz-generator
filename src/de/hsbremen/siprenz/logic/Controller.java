package de.hsbremen.siprenz.logic;

import de.hsbremen.siprenz.model.gen.CodeProps;
import de.hsbremen.siprenz.model.gen.XmlProps;
import de.hsbremen.siprenz.model.num.CmdParseStatus;
import de.hsbremen.siprenz.model.xml.Simulation;

public class Controller {
	
	private String args[];
	private CmdParser cmdParser;
	private SimCreator simCreator;
	private XmlParser xmlParser;
	private CodeGenerator codeGenerator;
	
	public Controller(String args[]) {
		this.args = args;
		init();
	}
	
	public void copy() {
		
		Simulation simulation = simCreator.create(3);
		
		String test = "/home/david/Documents/Test/Gen/";
		codeGenerator.generate(simulation, test);
	}
	
	public void start() {
		CmdParseStatus cmdParseStatus = cmdParser.parse();
		
		switch (cmdParseStatus) {
		case OK:
			System.exit(CmdParseStatus.OK.returnCode());
			break;
			
		case CREATEXML:
			System.out.println("Creating XML");
			createXml();
			System.out.println("Creating XML finished successfully");
			System.exit(CmdParseStatus.OK.returnCode());
			break;
			
		case GENCODE:
			System.out.println("Generating Code");
			genCode();
			System.out.println("Generating Code finished successfully");
			System.exit(CmdParseStatus.OK.returnCode());
			break;
			
		case ERROR:
			System.exit(CmdParseStatus.ERROR.returnCode());
			break;
			
		case ILLEGAL:
			System.out.println("Illegal combination of arguments");
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
		codeGenerator = new CodeGenerator();
	}
	
	private void createXml() {
		XmlProps xmlProps = cmdParser.getXmlProps();
		if (xmlProps != null) {
			Simulation simulation = simCreator.create(xmlProps.getNodesCount());
			xmlParser.write(simulation, xmlProps.getOutputFile());
		}
	}
	
	private void genCode() {
		CodeProps codeProps = cmdParser.getCodeProps();
		if (codeProps != null) {
			Simulation simulation = xmlParser.read(codeProps.getInputFile());
			codeGenerator.generate(simulation, codeProps.getOutputFile());
		}
	}

}
