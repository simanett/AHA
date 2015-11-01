/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.businesslogic.model.Airplane;
import java.util.List;

/**
 * Repository class to handle airplane data
 *
 * @author HB
 */
public class AirplaneRepository {

    /**
     * Return the Airplane object with the given model name
     *
     * @param model String representing the model of the airplane, e.g "Boeing"
     * @return The Airplane object if exists, null otherwise
     */
    public Airplane getAirplaneByModel(String model) {
        for (Airplane airplane : airplanes()) {
            if (airplane.getModel().equals(model)) {
                return airplane;
            }
        }
        return null;
    }

    /**
     * Return all Airplane objects
     *
     * @return All Airplanes in the application state
     */
    public List<Airplane> getAirplanes() {
        return airplanes();
    }

    /**
     * Add a new Airplane object to the application state and save it to the XML
     *
     * @param airplane The Airplane object to add
     */
    public void addAirplane(Airplane airplane) {
        airplanes().add(airplane);
        FileSystemManager.getInstance().saveState();
    }

    /**
     * Helper method to get all Airplane objects from application state
     *
     * @return List of Airplane objects
     */
    private List<Airplane> airplanes() {
        return FileSystemManager.getInstance().getState().getAirplanes();
    }

}
