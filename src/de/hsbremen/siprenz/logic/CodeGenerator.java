package de.hsbremen.siprenz.logic;

import java.util.ArrayList;

import de.hsbremen.siprenz.model.Connection;
import de.hsbremen.siprenz.model.Node;
import de.hsbremen.siprenz.model.Simulation;
import de.hsbremen.siprenz.utils.FileUtils;

public class CodeGenerator {
	
	public CodeGenerator() {
		
	}
	
	public void generate(Simulation simulation) {
		
		ArrayList<Node> nodes = simulation.getNodes();
		ArrayList<Connection> connections = simulation.getConnections();
		
		int clientNr = -1;
		
		// TODO check whether a client is a available
		for (Node node : nodes) {
			if (node.getType().equals("client")) {
				clientNr = nodes.indexOf(node);
			}
		}
		
		// TODO implement a logger
		System.out.println("Starting Generation");
		
		String pathName = "/home/david/Documents/Model/generated-model.cc";
		StringBuilder code = new StringBuilder();
		
		// imports
		code.append("#include \"ns3/core-module.h\"\n");
		code.append("#include \"ns3/dce-module.h\"\n");
		code.append("#include \"ns3/network-module.h\"\n");
		code.append("#include \"ns3/internet-module.h\"\n");
		code.append("#include \"ns3/point-to-point-module.h\"\n");
		code.append("#include \"ns3/applications-module.h\"\n");
		code.append("#include \"ns3/constant-position-mobility-model.h\"\n");
		code.append("#include \"ccnx/misc-tools.h\"\n");
		code.append("#include \"utils/ip-helper.h\"\n");
		code.append("#include \"utils/string-helper.h\"\n");
		code.append("#include \"ns3/config-store.h\"\n\n");
		code.append("#include <string>\n");
		code.append("#include <sstream>\n\n");
		code.append("using namespace ns3;\n");
		code.append("using namespace std;\n\n");
		
		code.append("NS_LOG_COMPONENT_DEFINE (\"GeneratedP2P\");\n");
		
		code.append("int main (int argc, char *argv[])\n{\n");
		
		// variables
		code.append("	string protocol = \"iec61850\";\n");
		code.append("	string server = \"simple-iec-server\";\n");
		code.append("	string client = \"simple-iec-client\";\n");
		code.append("	string dataRate = \"5Mbps\";\n");
		code.append("	string delay = \"2ms\";\n");
		code.append("	string configFileIn = \"\";\n");
		code.append("	string configFileOut = \"\";\n");
		code.append("	bool pcapTracing = false;\n");
		code.append("	bool asciiTracing = false;\n");
		code.append("	double duration = 30.0;\n");
		code.append("	string filePrefix = \"generatedp2p\";\n\n");
		
		// command line parameters
		code.append("	CommandLine cmd;\n");
		code.append("	cmd.AddValue (\"ConfigFileIn\", \"Input config file\", configFileIn);\n");
		code.append("	cmd.AddValue (\"ConfigFileOut\", \"Output config file\", configFileOut);\n");
		code.append("	cmd.AddValue (\"DataRate\", \"Datarate of the connection\", dataRate);\n");
		code.append("	cmd.AddValue (\"Delay\", \"Delay of the connection\", delay);\n");
		code.append("	cmd.AddValue (\"PcapTracing\", \"Tracing with pcap files\", pcapTracing);\n");
		code.append("	cmd.AddValue (\"AsciiTracing\", \"Tracing with ASCII files\", asciiTracing);\n");
		code.append("	cmd.AddValue (\"Duration\", \"Duration of the simulation in sec\", duration);\n");
		code.append("	cmd.Parse (argc, argv);\n\n");
		
		code.append("	NS_LOG_INFO (\"Reading Input.\");\n\n");
		
		code.append("	NS_LOG_INFO (\"Building P2P topology.\");\n\n");
		
		code.append("	NS_LOG_INFO (\"Creating Nodes.\");\n");
		code.append("	NodeContainer nodes;\n");
		code.append("	nodes.Create ("+ simulation.getNodes().size() + ");\n\n");
		
		// point to point helper
		code.append("	NS_LOG_INFO (\"Creating PointToPointHelper.\");\n");
		for (int i=0; i<connections.size(); i++) {
			String p2pName = "pointToPoint_" + i;
			code.append("	PointToPointHelper " + p2pName  + ";\n");
			code.append("	" + p2pName + ".SetDeviceAttribute (\"DataRate\", StringValue (" + connections.get(i).getDataRate() + "));\n");
			code.append("	" + p2pName + ".SetChannelAttribute (\"Delay\", StringValue (" + connections.get(i).getDelay() + "));\n");
		}
		code.append("\n");
		
		// netdevice container
		code.append("	NS_LOG_INFO (\"Creating NetDeviceContainer.\");\n");
		for (int i=0; i<connections.size(); i++) {
			String p2pName = "pointToPoint_" + i;
			String devName = "devices_" + i;
			code.append("	NetDeviceContainer " + devName  + ";\n");
			code.append("	" + devName + " = " + p2pName + ".Install(nodes.Get (" + connections.get(i).getSource().getId() + "), " 
					+ "nodes.Get (" + connections.get(i).getDestination().getId() + "));\n");
		}
		code.append("\n");
		
		// internet stack
		code.append("	NS_LOG_INFO (\"Installing internet stack on all nodes.\");\n");
		code.append("	InternetStackHelper stack;\n");
		code.append("	stack.InstallAll ();\n\n");
		
		// ip addresses
		// TODO if nodes > 255 ip address = 10.2.x.x
		code.append("	NS_LOG_INFO (\"Assigning IP Addresses.\");\n");
		code.append("	Ipv4AddressHelper address;\n");
		code.append("	Ipv4InterfaceContainer interfaces;\n");
		for (int i=0; i<connections.size(); i++) {
			String ip = "10.1." + (i+1) + ".0";
			String devName = "devices_" + i;
			code.append("	address.SetBase (\"" + ip + "\", \"255.255.255.252\");\n");
			code.append("	interfaces.Add(address.Assign (" + devName + "));\n");
		}
		code.append("\n");
		
		code.append("	Ipv4GlobalRoutingHelper::PopulateRoutingTables ();\n\n");
		
		// installing application
		code.append("	NS_LOG_INFO (\"Installing applications.\");\n");
		code.append("	DceManagerHelper dceManager;\n");
		code.append("	DceApplicationHelper dce;\n");
		code.append("	ApplicationContainer apps;\n");
		code.append("	dceManager.Install (nodes);\n\n");
		code.append("	dce.SetStackSize (1<<20);\n\n");
		
		for (int i=0; i<nodes.size(); i++) {
			if (nodes.get(i).getType().equals("server")) {
				code.append("	dce.SetBinary (server);\n");
				code.append("	dce.ResetArguments ();\n");
				code.append("	dce.ResetEnvironment ();\n");
				code.append("	apps = dce.Install (nodes.Get (" + nodes.get(i).getId() + "));\n");
				code.append("	apps.Start (Seconds (2.0));\n\n");
				
				code.append("	dce.SetBinary (client);\n");
				code.append("	dce.ResetArguments ();\n");
				code.append("	dce.ResetEnvironment ();\n");
				code.append("	dce.AddArgument (IpHelper::getIp(nodes.Get(" + nodes.get(i).getId()  + ")));\n");
				code.append("	apps = dce.Install (nodes.Get (" + nodes.get(clientNr).getId() + "));\n");
				code.append("	apps.Start (Seconds ("+ nodes.get(clientNr).getStartTime() + "));\n");
				code.append("	apps.Stop (Seconds (duration));\n\n");
			}
		}
		
		code.append("	if (pcapTracing) {\n");
		code.append("		NS_LOG_INFO (\"Enabling pcap tracing.\");\n");
		code.append("		pointToPoint_0.EnablePcapAll (filePrefix, false);\n");
		code.append("	}\n\n");	     
		
		code.append("	if (asciiTracing) {\n");
		code.append("		NS_LOG_INFO (\"Enabling ASCII tracing.\");\n");
		code.append("		AsciiTraceHelper ascii;\n");
		code.append("		pointToPoint_0.EnableAsciiAll (ascii.CreateFileStream " +
				"(filePrefix + \".tr\"));\n");
		code.append("	}\n\n");
		
		code.append("	Simulator::Stop (Seconds(duration));\n\n");
				
		// starting the simulation
		code.append("	NS_LOG_INFO (\"Running Simulation.\");\n");
		code.append("	Simulator::Run ();\n");
		code.append("	Simulator::Destroy ();\n");
		code.append("	NS_LOG_INFO (\"Simulation done.\");\n\n");	     
		code.append("	return 0;\n}\n");
		
		System.out.println("Finishing Generation");
		
		System.out.println("Writing code to file");
		FileUtils.createFile(code.toString(), pathName);
	}

}
