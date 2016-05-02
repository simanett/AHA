/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha;

import com.aha.businesslogic.model.Booking;
import com.aha.businesslogic.model.Employee;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Passenger;
import com.aha.data.BookingRepository;
import com.aha.data.EmployeeRepository;
import com.aha.data.FlightRepository;
import com.aha.data.PassengerRepository;
import com.aha.service.EmployeeService;
import com.aha.userinterface.LoginForm;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simonicsanett
 */
public class AHA {

    public static Connection connection;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
//        try {
        if (args.length != 3) {
            System.out.println("Invalid number of arguments, program has to be started with following arguments:");
            System.out.println("[url] [user] [password]");
            System.exit(1);
        }
        String dbUrl = args[0];
        String dbUserName = args[1];
        String dbPassWord = args[2];

        connection = connect(dbUrl, dbUserName, dbPassWord);

        EmployeeRepository employeeRepository = new EmployeeRepository();
        try {
            //ezt:
            EmployeeService stub = (EmployeeService) UnicastRemoteObject.exportObject(employeeRepository, 0);
            Registry reg = LocateRegistry.createRegistry(1234);
            System.setProperty("java.rmi.server.hostname", "localhost");
            //ezt:
            reg.bind("aha", stub);
            System.out.println("Fut a szerver...");
            Thread.sleep(120000);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(AHA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(AHA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(AHA.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Show login form
//        LoginForm loginForm = new LoginForm();
//        loginForm.setVisible(true);
//
    }

    private static Connection connect(String url, String user, String password) {

        System.out.println("-------- Oracle JDBC Connection Testing ------");
        try {
            // Check if oracle driver is available
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return null;
        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection newConnection = null;
        try {
            newConnection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }

        if (newConnection != null) {
            System.out.println("Connection successfully created");
        } else {
            System.out.println("Failed to make connection!");
        }

        return newConnection;
    }
}
