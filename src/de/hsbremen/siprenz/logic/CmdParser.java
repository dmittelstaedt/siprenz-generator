package de.hsbremen.siprenz.logic;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
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
		
		// option for printing help
		options.addOption(Option.builder("h")
				.longOpt("help")
				.desc("Prints help information")
				.hasArg(false)
				.build());
		
		// option for printing version
		options.addOption(Option.builder("v")
				.longOpt("version")
				.desc("Prints version information")
				.hasArg(false)
				.build());
		
		// option for creating xml
		options.addOption(Option.builder("c")
				.longOpt("create")
				.desc("Creates a model in XML")
				.hasArg(false)
				.build());
		options.addOption(Option.builder("n")
				.longOpt("nodes")
				.desc("Number of nodes")
				.hasArg(true)
				.argName("NUMBER")
				.build());
		options.addOption(Option.builder("o")
				.longOpt("ofile")
				.desc("Filename of XML")
				.hasArg(true)
				.argName("FILENAME")
				.build());
		
		// option for generating code
		options.addOption(Option.builder("g")
				.longOpt("generate")
				.desc("Generates code from XML")
				.hasArg(false)
				.build());
		options.addOption(Option.builder("i")
				.longOpt("ifile")
				.desc("Filename of XML")
				.hasArg(true)
				.argName("FILENAME")
				.build());
		options.addOption(Option.builder("d")
				.longOpt("odir")
				.desc("Directory for the generated code")
				.hasArg(true)
				.argName("DIRNAME")
				.build());
	}
	
	private void printHelp() {
		Options optionsHelp = new Options();
		optionsHelp.addOption(options.getOption("help"));
		optionsHelp.addOption(options.getOption("version"));
		optionsHelp.addOption(options.getOption("create"));
		optionsHelp.addOption(options.getOption("generate"));
		
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("simgen COMMAND", "\nCommands:", optionsHelp, "\nUse \"simgen -command_name -help\" for usage of command_name");
	}
	
	private void printVersion() {
		System.out.println("simgen - SimulationGenerator version 1.0.0");
	}
	
	private void printCreateHelp() {
		Options optionsCreate = new Options();
		optionsCreate.addOption(options.getOption("nodes"));
		optionsCreate.addOption(options.getOption("ofile"));
		
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("simgen -create OPTION...", "\nOptions:", optionsCreate, "\nUse \"simgen -help\" for all available commands");
	}
	
	private void printGenerateHelp() {
		Options optionsGenerate = new Options();
		optionsGenerate.addOption(options.getOption("ifile"));
		optionsGenerate.addOption(options.getOption("odir"));
		
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("simgen -generate OPTION...", "\nOptions:" , optionsGenerate, "\nUse \"simgen -help\" for all available commands");
	}
	
	private void printIllegalHelp() {
		Options optionsHelp = new Options();
		optionsHelp.addOption(options.getOption("help"));
		optionsHelp.addOption(options.getOption("version"));
		optionsHelp.addOption(options.getOption("create"));
		optionsHelp.addOption(options.getOption("generate"));
		
		HelpFormatter formatter = new HelpFormatter();
		System.out.println("ERROR: Illegal Combination of Commands or Arguments\n");
		formatter.printHelp("simgen COMMAND", "\nCommands:", optionsHelp, "\nUse \"simgen -command_name -help\" for usage of command_name");
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
		
		// print help
		if (cmd.hasOption("help") && !cmd.hasOption("version") && !cmd.hasOption("create") && !cmd.hasOption("nodes") && 
				!cmd.hasOption("ofile") && !cmd.hasOption("generate") && !cmd.hasOption("ifile") && !cmd.hasOption("odir")) {
			printHelp();
			return CmdParseStatus.OK;
		}
		
		// print create help
		if (cmd.hasOption("help") && !cmd.hasOption("version") && cmd.hasOption("create") && !cmd.hasOption("nodes") && 
				!cmd.hasOption("ofile") && !cmd.hasOption("generate") && !cmd.hasOption("ifile") && !cmd.hasOption("odir")) {
			printCreateHelp();
			return CmdParseStatus.OK;
		}
		
		// print generate help
		if (cmd.hasOption("help") && !cmd.hasOption("version") && !cmd.hasOption("create") && !cmd.hasOption("nodes") && 
				!cmd.hasOption("ofile") && cmd.hasOption("generate") && !cmd.hasOption("ifile") && !cmd.hasOption("odir")) {
			printGenerateHelp();
			return CmdParseStatus.OK;
		}
		
		// print version
		if (!cmd.hasOption("help") && cmd.hasOption("version") && !cmd.hasOption("create") && !cmd.hasOption("nodes") && 
				!cmd.hasOption("ofile") && !cmd.hasOption("generate") && !cmd.hasOption("ifile") && !cmd.hasOption("odir")) {
			printVersion();
			return CmdParseStatus.OK;
		}
		
		// create xml
		if (!cmd.hasOption("help") && !cmd.hasOption("version") && cmd.hasOption("create") && cmd.hasOption("nodes") && 
				cmd.hasOption("ofile") && !cmd.hasOption("generate") && !cmd.hasOption("ifile") && !cmd.hasOption("odir")) {
			setXmlProps(new XmlProps(Integer.parseInt(cmd.getOptionValue("nodes")), cmd.getOptionValue("ofile")));
			return CmdParseStatus.CREATEXML;
		}
		
		// generate code
		if (!cmd.hasOption("help") && !cmd.hasOption("version") && !cmd.hasOption("create") && !cmd.hasOption("nodes") && 
				!cmd.hasOption("ofile") && cmd.hasOption("generate") && cmd.hasOption("ifile") && cmd.hasOption("odir")) {
			setCodeProps(new CodeProps(cmd.getOptionValue("ifile"), cmd.getOptionValue("odir")));
			return CmdParseStatus.GENCODE;
		}
		
		printIllegalHelp();
		return CmdParseStatus.ILLEGAL;
	}

}
