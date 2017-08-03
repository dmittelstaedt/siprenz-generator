package de.hsbremen.siprenz;


import java.util.ArrayList;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import de.hsbremen.siprenz.logic.CodeGenerator;
import de.hsbremen.siprenz.logic.XmlParser;
import de.hsbremen.siprenz.model.Connection;
import de.hsbremen.siprenz.model.Global;
import de.hsbremen.siprenz.model.Node;
import de.hsbremen.siprenz.model.Simulation;

public class Main {
	
	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LOGGER.info("Test output");
		
		Options options = new Options();
		
		options.addOption("h", "help", false, "display help");
		options.addOption("v", "version", false, "display version");
		
		// create init xml file
		options.addOption("c", "create", false, "create xml file");
		options.addOption("n", "nodes", true, "number of nodes");
		options.addOption("o", "output", true, "output file");
		
		// create code
		options.addOption("g", "gen", false, "generate code");
		options.addOption("i", "input", true, "input file");
		
		CommandLineParser parser = new DefaultParser();
		HelpFormatter formatter = new HelpFormatter();
		CommandLine cmd = null;
		
		try {
			cmd = parser.parse(options, args);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			formatter.printHelp("SimGen", options);
		}
		
		if (cmd.hasOption("help")) {
			formatter.printHelp("SimGen", options);
		}
		
		if (cmd.hasOption("create") && cmd.hasOption("gen")) {
			System.out.println("Only one can specified!");
			System.exit(-1);
		}
		
		if (cmd.hasOption("nodes")) {
			String nodes = cmd.getOptionValue("nodes");
			System.out.println("Number of nodes: " + nodes);
		}
		
//		String pathName = "/home/david/Documents/Model/simulation.xml";
//		
//		Global global = new Global(30.0, "iec61850");
//		
//		ArrayList<Node> nodes = new ArrayList<Node>();
//		nodes.add(new Node("s1", "server", 1.0, 10.0));
//		nodes.add(new Node("s2", "server", 1.0, 10.0));
//		nodes.add(new Node("c1", "client", 5.0, 10.0));
//		
//		ArrayList<Connection> connections = new ArrayList<Connection>();
//		connections.add(new Connection(nodes.get(0), nodes.get(2), "5Mbps", "2ms", "10.1.1.0", "255.255.255.252"));
//		connections.add(new Connection(nodes.get(1), nodes.get(2), "5Mbps", "2ms", "10.1.2.0", "255.255.255.252"));
//		
//		Simulation simulation = new Simulation();
//		simulation.setGlobal(global);
//		simulation.setNodes(nodes);
//		simulation.setConnections(connections);
//	
//		XmlParser xmlParser = new XmlParser();
//		xmlParser.write(simulation, pathName);
//		Simulation simulation = xmlParser.read();
		
//		CodeGenerator codeGenerator = new CodeGenerator();
//		codeGenerator.generate(simulation);
		
//		String pathName = "/home/david/Documents/Model/generated-model.cc";
	}

}
