package de.hsbremen.siprenz.logic;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.hsbremen.siprenz.model.Connection;
import de.hsbremen.siprenz.model.Node;
import de.hsbremen.siprenz.model.Simulation;

public class XmlParser {
	
	public void write() {
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("s1", "server", 1.0, 10.0));
		nodes.add(new Node("s2", "server", 1.0, 10.0));
		nodes.add(new Node("c1", "client", 5.0, 10.0));
		
		ArrayList<Connection> connections = new ArrayList<Connection>();
		connections.add(new Connection(nodes.get(0), nodes.get(1), "5Mbps", "2ms", "10.1.1.0", "255.255.255.252"));
		
		Simulation simulation = new Simulation();
		simulation.setNodes(nodes);
		simulation.setConnections(connections);
		
		try {
			File file = new File("/home/david/Documents/Model/simulation.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Simulation.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(simulation, file);
			jaxbMarshaller.marshal(simulation, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
			}
	}
	
	public Simulation read() {
		
		Simulation simulation;
		
		try {

			File file = new File("/home/david/Documents/Model/simulation.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Simulation.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			simulation = (Simulation) jaxbUnmarshaller.unmarshal(file);
		  } catch (JAXBException e) {
			  simulation = null;
			  e.printStackTrace();
		  }
		return simulation;
	}
}
