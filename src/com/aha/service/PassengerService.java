/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.service;

import com.aha.businesslogic.model.Passenger;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HB
 */
public interface PassengerService extends Remote {

    /**
     * Add Passenger object to database.
     *
     * @return void.
     */
    void addPassenger(Passenger passenger) throws RemoteException;

    /**
     * Get max id number from passenger table.
     *
     * @return the highest id value from passengers table.
     */
    int getMaxPassengerId() throws RemoteException;

    /**
     * Return Passenger object of given email.
     *
     * @param passengerEmail String that identifies the Passenger object.
     * @return the Passenger object if exists, null otherwise.
     */
    Passenger getPassengerByEmail(String passengerEmail) throws RemoteException;

    /**
     * Return Passenger object of given id.
     *
     * @param id int that identifies the Passenger object.
     * @return the Passenger object if exists, null otherwise.
     */
    Passenger getPassengerById(int id) throws SQLException, RemoteException;

    /**
     * Return Passenger object of given name.
     *
     * @param passengerName String that identifies the Passenger object.
     * @return the Passenger object if exists, null otherwise.
     */
    Passenger getPassengerByName(String passengerName) throws RemoteException;

    /**
     * Return all Passenger objects from database.
     *
     * @return all Passengers in the database.
     */
    List<Passenger> getPassengers() throws SQLException, RemoteException;

    boolean updatePassenger(Passenger passenger) throws RemoteException;

}
