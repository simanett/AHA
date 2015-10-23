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
 *
 * @author simonicsanett
 */
public class FileSystemManager {

    private String fileName = "aha.xml";
    private ApplicationState applicationState;
    
    //Singleton pattern
    private static FileSystemManager instance;
    private FileSystemManager() {
        applicationState = new ApplicationState();
    }

    public static FileSystemManager getInstance() {
        if (instance == null) {
            instance = new FileSystemManager();
            instance.loadState();
        }
        return instance;
    }

    public void loadState() {
        try {
            File file = new File(fileName);
            System.out.println("Loading state from " + file.getAbsolutePath());

            JAXBContext jaxbContext = JAXBContext.newInstance(ApplicationState.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            applicationState = (ApplicationState) jaxbUnmarshaller.unmarshal(file);

        } catch (Exception ex) {
            System.out.println("Could not load application state");
            System.out.println(ex);
        }
    }

    public void saveState() {
        try {
            File file = new File(fileName);
            System.out.println("Saving state to " + file.getAbsolutePath());
            JAXBContext jaxbContext = JAXBContext.newInstance(ApplicationState.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Formatting output
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(applicationState, file);
            jaxbMarshaller.marshal(applicationState, System.out);

        } catch (JAXBException ex) {
            System.out.println("Could not save application state.");
            System.out.println(ex);
        }
    }

    public ApplicationState getState() {
        return applicationState;
    }

}
