/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha;

import com.aha.service.AirplaneService;
import com.aha.service.EmployeeService;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HB
 */
public class Client {

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1234);
            //System.setProperty("java.rmi.server.hostname", "localhost");
            EmployeeService employeeService = (EmployeeService) reg.lookup("EmployeeService");
            AirplaneService airplaneService = (AirplaneService) reg.lookup("AirplaneService");

            //stub.getEmployees();
            System.out.println(employeeService.getEmployees());
            System.out.println(airplaneService.getAirplanes());

        } catch (AccessException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
