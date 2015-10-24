/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.businesslogic.model.Flight;
import java.util.List;

/**
 *
 * @author HB
 */
public class FlightRepository {
    
    public Flight getFlightByFlightNumber(int flightNumber){
        for(Flight flight : this.flights()){
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }
    
    public List<Flight> getFlights(){
        return flights();
    }
    
    public void addFlight(Flight flight){
        flights().add(flight);
        FileSystemManager.getInstance().saveState();
    }
    
    private List<Flight> flights() {
        return FileSystemManager.getInstance().getState().getFlights();
    }
}
