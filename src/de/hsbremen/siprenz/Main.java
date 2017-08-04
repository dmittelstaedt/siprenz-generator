package de.hsbremen.siprenz;


import java.util.ArrayList;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import de.hsbremen.siprenz.logic.CmdParser;
import de.hsbremen.siprenz.logic.CodeGenerator;
import de.hsbremen.siprenz.logic.XmlParser;
import de.hsbremen.siprenz.model.num.CmdParseStatus;
import de.hsbremen.siprenz.model.xml.Connection;
import de.hsbremen.siprenz.model.xml.Global;
import de.hsbremen.siprenz.model.xml.Node;
import de.hsbremen.siprenz.model.xml.Simulation;

public class Main {
	
	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		LOGGER.info("Test output");
		
		CmdParser cmdParser = new CmdParser(args);
		CmdParseStatus cmdParseStatus = cmdParser.parse();
		
		System.out.println("Status: " + cmdParseStatus.name());
		System.out.println("ReturnCode: " + cmdParseStatus.returnCode());
		
		if (cmdParser.getXmlProps() != null) {
			System.out.println("Number of Nodes: " + cmdParser.getXmlProps().getNodesCount());
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
