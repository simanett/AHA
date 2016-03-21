/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.AHA;
import com.aha.businesslogic.model.Passenger;
import com.aha.businesslogic.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Repository class to handle passenger data
 * 
 * @author HB
 */

public class PassengerRepository {
    /**
     * Return Passenger object of given id.
     *
     * @param id int that identifies the Passenger object.
     * @return the Passenger object if exists, null otherwise.
     */
    public Passenger getPassengerById(int id) throws SQLException{
        Passenger passenger = null;
        PreparedStatement stmt = null;
        String query = "select ID, NAME, EMAIL"
                + "from AHA.PASSENGERS where ID=?";
        try{
            stmt = AHA.connection.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            boolean idExists = rs.next();
            if (idExists) {
                passenger = new Passenger();
                int passengerId = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                passenger.setId(passengerId);
                passenger.setName(name);
                passenger.setEmail(email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return passenger;
    }
    
    /**
     * Return Passenger object of given name.
     *
     * @param passengername String that identifies the Passenger object.
     * @return the Passenger object if exists, null otherwise.
     */
    
    public Passenger getPassengerByName(String passengername) throws SQLException {
        Passenger passenger = null;
        PreparedStatement stmt = null;
        String query = "select ID, NAME, EMAIL"
                + "from AHA.PASSENGERS where NAME=?";
        
        try {
            stmt = AHA.connection.prepareStatement(query);
            stmt.setString(1, passengername);
            ResultSet rs = stmt.executeQuery();

            boolean passengerExists = rs.next();
            if (passengerExists) {
                passenger = new Passenger();
                int id = rs.getInt("ID");
                String passengerName = rs.getNString("NAME");
                String email = rs.getString("EMAIL");

                passenger.setId(id);
                passenger.setName(passengerName);
                passenger.setEmail(email);
            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return passenger;
    }

    /**
     * Return all Passenger objects from database.
     * 
     * @return all Passengers in the database.
     */
    
    public List<User> getPassengers() throws SQLException {

        List<User> passengers = new ArrayList<>();
        Statement stmt = null;

        String query = "select ID, NAME, EMAIL "
                + "from AHA.PASSENGERS ";

        try {
            stmt = AHA.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                Passenger passenger = new Passenger();

                passenger.setId(id);
                passenger.setName(name);
                passenger.setEmail(email);

                passengers.add(passenger);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return passengers;
        }
}
