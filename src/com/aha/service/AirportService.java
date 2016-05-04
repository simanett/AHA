/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.service;

import com.aha.businesslogic.model.Airport;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author simonicsanett
 */
public interface AirportService extends Remote {

    /**
     * Get an Airport object with the given airport code
     *
     * @param codeport
     * @param code Three letter identifier of the airport, e.g. DUB
     * @return The airport object if exists, null otherwise
     */
    Airport getAirportByCode(String codeport)throws RemoteException;

    /**
     * Return all Airport objects
     *
     * @return All Airport in the application state
     */
    List<Airport> getAirports()throws RemoteException;
    
}
