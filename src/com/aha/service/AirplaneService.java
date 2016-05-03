/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.service;

import com.aha.businesslogic.model.Airplane;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author simonicsanett
 */
public interface AirplaneService extends Remote  {

    /**
     * Return the Airplane object with the given model name
     *
     * @param airplaneModel String representing the model of the airplane, e.g
     * "Boeing"
     * @return The Airplane object if exists, null otherwise
     * @throws java.rmi.RemoteException
     */
    Airplane getAirplaneByModel(String airplaneModel)throws RemoteException;

    /**
     * Return all Airplane objects
     *
     * @return All Airplanes in the database
     * @throws java.rmi.RemoteException
     */
    List<Airplane> getAirplanes()throws RemoteException;
    
}
