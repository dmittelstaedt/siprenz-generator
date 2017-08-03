package de.hsbremen.siprenz.logic;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class CmdParser {
	
	private String args[];
	private Options options;
	
	public CmdParser(String args[]) {
		this.args = args;
		init();
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
		System.out.println("SimulationGenerator version 1.0.0");
	}
	
	public int parse() {
		int returnCode=1;
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = null;
		
		try {
			cmd = parser.parse(options, args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			printHelp();
			return returnCode;
		}
		
		if (cmd.hasOption("help") && !cmd.hasOption("version") && !cmd.hasOption("create") && !cmd.hasOption("nodes") && 
				!cmd.hasOption("output") && !cmd.hasOption("generate") && !cmd.hasOption("input")) {
			printHelp();
			returnCode=0;
		}
		
		if (!cmd.hasOption("help") && cmd.hasOption("version") && !cmd.hasOption("create") && !cmd.hasOption("nodes") && 
				!cmd.hasOption("output") && !cmd.hasOption("generate") && !cmd.hasOption("input")) {
			printVersion();
			returnCode=0;
		}
		
		if (!cmd.hasOption("help") && !cmd.hasOption("version") && cmd.hasOption("create") && cmd.hasOption("nodes") && 
				cmd.hasOption("output") && !cmd.hasOption("generate") && !cmd.hasOption("input")) {
			System.out.println("Creating XML");
			returnCode=0;
		}
		
		if (!cmd.hasOption("help") && !cmd.hasOption("version") && !cmd.hasOption("create") && !cmd.hasOption("nodes") && 
				cmd.hasOption("output") && cmd.hasOption("generate") && cmd.hasOption("input")) {
			System.out.println("Generating Code");
			returnCode=0;
		}
		
		if (returnCode != 0) {
			System.out.println("Illegal arguments combination");
		}
		return returnCode;
	}

}
