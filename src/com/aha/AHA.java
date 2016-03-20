/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha;

import com.aha.businesslogic.model.Airplane;
import com.aha.businesslogic.model.Airport;
import com.aha.businesslogic.model.User;
import com.aha.data.AirplaneRepository;
import com.aha.data.AirportRepository;
import com.aha.data.UserRepository;
import com.aha.userinterface.LoginForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author simonicsanett
 */
public class AHA {

    public static Connection connection;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Invalid number of arguments, program has to be started with following arguments:");
            System.out.println("[url] [user] [password]");
            System.exit(1);
        }
        String dbUrl = args[0];
        String dbUserName = args[1];
        String dbPassWord = args[2];

        try {
            //        DataGenerator generator = new DataGenerator();
//        generator.generate();

            connection = connect(dbUrl, dbUserName, dbPassWord);

            AirplaneRepository repo = new AirplaneRepository();

            Airplane boeing = repo.getAirplaneByModel("Boeing747");
            System.out.println(boeing);

            Airplane kamu = repo.getAirplaneByModel("Kamu");
            System.out.println(kamu);

            List<Airplane> planes = repo.getAirplanes();
            System.out.println("Repulok");
            for (Airplane plane : planes) {
                System.out.println(plane);
            }

            AirportRepository portrepo = new AirportRepository();

            Airport alma = portrepo.getAirportByCode("DUB");
            System.out.println(alma);

            Airport korte = portrepo.getAirportByCode("Kakimaki");
            System.out.println(korte);

            List<Airport> airports = portrepo.getAirports();
            System.out.println("Repterek:");
            for (Airport airport : airports) {
                System.out.println(airport);
            }
            
            
            UserRepository userrepo = new UserRepository();
            
            User geza = userrepo.getUserById(2);
            System.out.println(geza);
            
            User lama = userrepo.getUserByName("Yellow Pages");
              System.out.println(lama);
              
               List<User> users = userrepo.getUsers();
            System.out.println("Userek:");
            for (User user : users) {
                System.out.println(user);
            }
            
            // Show login form
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

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
