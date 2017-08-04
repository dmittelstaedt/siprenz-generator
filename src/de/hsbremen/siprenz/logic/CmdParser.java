package de.hsbremen.siprenz.logic;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import de.hsbremen.siprenz.model.gen.CodeProps;
import de.hsbremen.siprenz.model.gen.XmlProps;
import de.hsbremen.siprenz.model.num.CmdParseStatus;

public class CmdParser {
	
	private String args[];
	private Options options;
	private XmlProps xmlProps;
	private CodeProps codeProps;
	
	public CmdParser(String args[]) {
		this.args = args;
		init();
	}
	
	public XmlProps getXmlProps() {
		return xmlProps;
	}

	private void setXmlProps(XmlProps xmlProps) {
		this.xmlProps = xmlProps;
	}

	public CodeProps getCodeProps() {
		return codeProps;
	}

	private void setCodeProps(CodeProps codeProps) {
		this.codeProps = codeProps;
	}

	private void init() {
		
		options = new Options();
		
		// help and version
		options.addOption("h", "help", false, "display help");
		options.addOption("v", "version", false, "display version");
		
		// create init xml file
		options.addOption("c", "create", false, "create xml file");
		options.addOption("n", "nodes", true, "number of nodes");
		options.addOption("o", "output", true, "output file");
		
		// create code
		options.addOption("g", "generate", false, "generate code");
		options.addOption("i", "input", true, "input file");
	}
	
	private void printHelp() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("simgen", options);
	}
	
	private void printVersion() {
		System.out.println("simgen - SimulationGenerator version 1.0.0");
	}
	
	public CmdParseStatus parse() {
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = null;
		
		try {
			cmd = parser.parse(options, args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			printHelp();
			return CmdParseStatus.ERROR;
		}
		
		if (cmd.hasOption("help") && !cmd.hasOption("version") && !cmd.hasOption("create") && !cmd.hasOption("nodes") && 
				!cmd.hasOption("output") && !cmd.hasOption("generate") && !cmd.hasOption("input")) {
			printHelp();
			return CmdParseStatus.OK;
		}
		
		if (!cmd.hasOption("help") && cmd.hasOption("version") && !cmd.hasOption("create") && !cmd.hasOption("nodes") && 
				!cmd.hasOption("output") && !cmd.hasOption("generate") && !cmd.hasOption("input")) {
			printVersion();
			return CmdParseStatus.OK;
		}
		
		// create xml
		if (!cmd.hasOption("help") && !cmd.hasOption("version") && cmd.hasOption("create") && cmd.hasOption("nodes") && 
				cmd.hasOption("output") && !cmd.hasOption("generate") && !cmd.hasOption("input")) {
			System.out.println("Creating XML");
			setXmlProps(new XmlProps(Integer.parseInt(cmd.getOptionValue("nodes")), cmd.getOptionValue("output")));
			return CmdParseStatus.CREATEXML;
		}
		
		// generate code
		if (!cmd.hasOption("help") && !cmd.hasOption("version") && !cmd.hasOption("create") && !cmd.hasOption("nodes") && 
				cmd.hasOption("output") && cmd.hasOption("generate") && cmd.hasOption("input")) {
			System.out.println("Generating Code");
			setCodeProps(new CodeProps(cmd.getOptionValue("input"), cmd.getOptionValue("output")));
			return CmdParseStatus.GENCODE;
		}
		
		System.out.println("Illegal combination of arguments");
		return CmdParseStatus.ILLEGAL;
	}

}
