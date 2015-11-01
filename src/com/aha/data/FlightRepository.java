/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.businesslogic.model.Flight;
import java.util.List;

/**
 * Repository class to handle flight data
 *
 * @author HB
 */
public class FlightRepository {

    /**
     * Return the Flight object with the given flight number
     *
     * @param flightNumber String that identifies the Flight object
     * @return The Flight object if exists, null otherwise
     */
    public Flight getFlightByFlightNumber(String flightNumber) {
        for (Flight flight : this.flights()) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    /**
     * Return all Flight objects
     *
     * @return All Flights in the application state
     */
    public List<Flight> getFlights() {
        return flights();
    }

    /**
     * Add a new Flight object to the application state and save it to the XML
     *
     * @param flight The Flight object to add
     */
    public void addFlight(Flight flight) {
        flights().add(flight);
        FileSystemManager.getInstance().saveState();
    }

    /**
     * Helper method to get all Flight objects from application state
     *
     * @return List of Flight objects
     */    
    private List<Flight> flights() {
        return FileSystemManager.getInstance().getState().getFlights();
    }
}
