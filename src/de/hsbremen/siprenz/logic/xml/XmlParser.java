package de.hsbremen.siprenz.logic.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.hsbremen.siprenz.model.xml.Simulation;

/**
 * Class for parsing the XML.
 * 
 * This class is used for parsing the model from a
 * XML file and writing a model to a XML file.
 * 
 * @author David Mittelstädt
 *
 */
public class XmlParser {
	
	/**
	 * Writes simulation to XML.
	 * 
	 * This function writes a simulation model to a XMl File.
	 * 
	 * @param simulation Simulation to write to XML
	 * @param pathName Name of the full path to save the XML
	 */
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
	
	/**
	 * Reads simulation from XML.
	 * 
	 * This functions reads a simulation model from XML file.
	 * 
	 * @param pathName full path of the XML file to read
	 * @return simulation
	 */
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
