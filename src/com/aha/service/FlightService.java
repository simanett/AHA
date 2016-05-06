/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.service;

import com.aha.businesslogic.model.Flight;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HB
 */
public interface FlightService extends Remote {

    /**
     * Return all Flight objects
     *
     * @return All Flights in the application state
     */
    List<Flight> getFilteredFlights(String fromAirportCode, String toAirportCode, Date fromDate, Date toDate) throws RemoteException;

    /**
     * Return the Flight object with the given flight number
     *
     * @param flightNumber int that identifies the Flight object
     * @return The Flight object if exists, null otherwise
     */
    Flight getFlightByFlightNumber(int flightNumber) throws RemoteException;

    Flight getFlightById(int id) throws RemoteException;

    /**
     * Return all Flight objects
     *
     * @return All Flights in the application state
     */
    List<Flight> getFlights() throws RemoteException;

}
