/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha;

import com.aha.service.AirplaneService;
import com.aha.service.AirportService;
import com.aha.service.BookingService;
import com.aha.service.EmployeeService;
import com.aha.service.FlightService;
import com.aha.service.PassengerService;
import com.aha.service.UserService;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HB
 */
public class Client {

    public static void main(String[] args) throws SQLException {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1234);
            //System.setProperty("java.rmi.server.hostname", "localhost");
            EmployeeService employeeService = (EmployeeService) reg.lookup("EmployeeService");
            AirplaneService airplaneService = (AirplaneService) reg.lookup("AirplaneService");
            FlightService flightService = (FlightService) reg.lookup("FlightService");
            PassengerService passengerService = (PassengerService) reg.lookup("PassengerService");
            UserService userService = (UserService) reg.lookup("UserService");

            AirportService  airportService = (AirportService) reg.lookup("AirportService");
            BookingService bookingServivce = (BookingService) reg.lookup("BookingService");
            
            //stub.getEmployees();
            System.out.println(employeeService.getEmployees());
            System.out.println(airplaneService.getAirplanes());
            System.out.println(flightService.getFlights());
            System.out.println(passengerService.getPassengers());
            System.out.println(userService.getUsers());

            System.out.println(airportService.getAirports());
            System.out.println(bookingServivce.getBookings());
            
        } catch (AccessException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
