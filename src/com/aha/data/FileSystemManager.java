/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Class responsible for XML serialization / deserialization
 *
 * @author simonicsanett
 */
public class FileSystemManager {

    // File to read / write application state
    private String fileName = "aha.xml";

    // Object containing application state
    private ApplicationState applicationState;

    //Singleton pattern
    private static FileSystemManager instance;

    private FileSystemManager() {
        applicationState = new ApplicationState();
        //Added for testing: to print xml to console
        printState();
    }

    /**
     * Get FileSystemManager singleton instance
     *
     * @return FileSystemManager singleton instance
     */
    public static FileSystemManager getInstance() {
        if (instance == null) {
            instance = new FileSystemManager();
            instance.loadState();
        }
        return instance;
    }

    /**
     * Load application state from XML
     */
    private void loadState() {
        try {
            File file = new File(fileName);
            System.out.println("Loading state from " + file.getAbsolutePath());

            // Create JAXB context and unmarshaler
            JAXBContext jaxbContext = JAXBContext.newInstance(ApplicationState.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
            // Load application state
            applicationState = (ApplicationState) jaxbUnmarshaller.unmarshal(file);

        } catch (Exception ex) {
            System.out.println("Could not load application state");
            System.out.println(ex);
        }
    }

    /**
     * Save application state to XML
     */
    public void saveState() {
        try {
            File file = new File(fileName);
            System.out.println("Saving state to " + file.getAbsolutePath());

            // Create JAXB context and marshaler
            JAXBContext jaxbContext = JAXBContext.newInstance(ApplicationState.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Formatting output
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Save output to XML, also write it to System.out
            jaxbMarshaller.marshal(applicationState, file);
            jaxbMarshaller.marshal(applicationState, System.out);

        } catch (JAXBException ex) {
            System.out.println("Could not save application state.");
            System.out.println(ex);
        }
    }

    //Added for testing: to print xml to console
    private void printState() {
        try {
            loadState();
            System.out.println("Printing state to console");
            JAXBContext jaxbContext = JAXBContext.newInstance(ApplicationState.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Formatting output
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(applicationState, System.out);

        } catch (JAXBException ex) {
            System.out.println("Could not print application state.");
            System.out.println(ex);
        }
    }

    public ApplicationState getState() {
        return applicationState;
    }

}
