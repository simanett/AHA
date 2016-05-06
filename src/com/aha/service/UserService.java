/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.service;

import com.aha.businesslogic.model.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author HB
 */
public interface UserService extends Remote {

    /**
     * Return the User object with the given id
     *
     * @param id String that identifies the User object
     * @return The User object if exists, null otherwise
     */
    User getUserById(int id) throws RemoteException;

    /**
     * Return the User object with the given name
     *
     * @param name String that identifies the User object
     * @return The User object if exists, null otherwise
     */
    User getUserByName(String name) throws RemoteException;

    /**
     * Return all User objects
     *
     * @return All Users in the application state
     */
    List<User> getUsers() throws RemoteException;

}
