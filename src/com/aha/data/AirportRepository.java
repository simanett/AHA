/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.businesslogic.model.Airport;
import java.util.List;

/**
 * Repository class to handle airplane data
 *
 * @author simonicsanett
 */
public class AirportRepository {

    /**
     * Get an Airport object with the given airport code
     *
     * @param code Three letter identifier of the airport, e.g. DUB
     * @return The airport object if exists, null otherwise
     */
    public Airport getAirportByCode(String code) {
        for (Airport airport : airports()) {
            if (airport.getCode().equals(code)) {
                return airport;
            }
        }
        return null;
    }

    /**
     * Return all Airport objects
     *
     * @return All Airport in the application state
     */
    public List<Airport> getAirports() {
        return airports();
    }

    /**
     * Add a new Airport object to the application state and save it to the XML
     *
     * @param airport The Airport object to add
     */
    public void addAirport(Airport airport) {
        airports().add(airport);
        FileSystemManager.getInstance().saveState();
    }

    /**
     * Helper method to get all Airport objects from application state
     *
     * @return List of Airport objects
     */
    private List<Airport> airports() {
        return FileSystemManager.getInstance().getState().getAirports();
    }
}
