package de.hsbremen.siprenz.logic.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.hsbremen.siprenz.model.xml.Simulation;

public class XmlParser {
	
	public void write(Simulation simulation, String pathName) {
		
		try {
			File file = new File(pathName);
			JAXBContext jaxbContext = JAXBContext.newInstance(Simulation.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// TODO: remove output to console
			jaxbMarshaller.marshal(simulation, file);
			jaxbMarshaller.marshal(simulation, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
			}
	}
	
	public Simulation read(String pathName) {
		
		Simulation simulation;
		
		try {

			File file = new File(pathName);
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
