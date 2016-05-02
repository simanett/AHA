/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.service;

import com.aha.businesslogic.model.Employee;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author HB
 */
public interface EmployeeService extends Remote {

    /**
     * Return the Employee object with the given id
     *
     * @param id String that identifies the Employee object
     * @return The Employee object if exists, null otherwise
     * @throws java.rmi.RemoteException
     */
    Employee getEmployeeById(int id) throws RemoteException;

    /**
     * Return the Employee object with the given name
     *
     * @param name String that identifies the Employee object
     * @return The Employee object if exists, null otherwise
     * @throws java.rmi.RemoteException
     */
    Employee getEmployeeByName(String name) throws RemoteException;

    /**
     * Return all Employee objects
     *
     * @return all Employees in the database
     * @throws java.rmi.RemoteException
     */
    List<Employee> getEmployees() throws RemoteException;

}
