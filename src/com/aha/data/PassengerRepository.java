/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.service.PassengerService;
import com.aha.AHA;
import com.aha.businesslogic.model.Passenger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Repository class to handle passenger data
 *
 * @author HB
 */
public class PassengerRepository implements PassengerService {

    /**
     * Return Passenger object of given id.
     *
     * @param id int that identifies the Passenger object.
     * @return the Passenger object if exists, null otherwise.
     */
    @Override
    public Passenger getPassengerById(int id) throws SQLException {
        Passenger passenger = null;
        PreparedStatement stmt = null;

        String query = "select ID, NAME, EMAIL, VIP "
                + "from AHA.PASSENGERS where ID=?";
        try {
            stmt = AHA.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            boolean idExists = rs.next();
            if (idExists) {
                passenger = new Passenger();
                int passengerId = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                boolean vip = rs.getBoolean("VIP");
                passenger.setId(passengerId);
                passenger.setName(name);
                passenger.setEmail(email);
                passenger.setVip(vip);
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
     * @param passengerName String that identifies the Passenger object.
     * @return the Passenger object if exists, null otherwise.
     */
    @Override
    public Passenger getPassengerByName(String passengerName) {
        Passenger passenger = null;
        PreparedStatement stmt = null;

        String query = "select ID, NAME, EMAIL, VIP "
                + "from AHA.PASSENGERS where NAME=?";

        try {
            stmt = AHA.connection.prepareStatement(query);
            stmt.setString(1, passengerName);
            ResultSet rs = stmt.executeQuery();

            boolean passengerExists = rs.next();
            if (passengerExists) {
                passenger = new Passenger();
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                boolean vip = rs.getBoolean("VIP");
                passenger.setId(id);
                passenger.setName(name);
                passenger.setEmail(email);
                passenger.setVip(vip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PassengerRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return passenger;
    }

    /**
     * Return Passenger object of given email.
     *
     * @param passengerEmail String that identifies the Passenger object.
     * @return the Passenger object if exists, null otherwise.
     */
    @Override
    public Passenger getPassengerByEmail(String passengerEmail) {
        Passenger passenger = null;
        PreparedStatement stmt = null;

        String query = "select ID, NAME, EMAIL, VIP "
                + "from AHA.PASSENGERS where EMAIL=?";

        try {
            stmt = AHA.connection.prepareStatement(query);
            stmt.setString(1, passengerEmail);
            ResultSet rs = stmt.executeQuery();

            boolean passengerExists = rs.next();
            if (passengerExists) {
                passenger = new Passenger();
                int id = rs.getInt("ID");
                String passengerName = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                boolean vip = rs.getBoolean("VIP");
                passenger.setId(id);
                passenger.setName(passengerName);
                passenger.setEmail(email);
                passenger.setVip(vip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PassengerRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return passenger;
    }

    /**
     * Return all Passenger objects from database.
     *
     * @return all Passengers in the database.
     */
    @Override
    public List<Passenger> getPassengers() throws SQLException {

        List<Passenger> passengers = new ArrayList<>();
        Statement stmt = null;
        String query = "select ID, NAME, EMAIL, VIP "
                + "from AHA.PASSENGERS ";
        try {
            stmt = AHA.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                boolean vip = rs.getBoolean("VIP");
                Passenger passenger = new Passenger();
                passenger.setId(id);
                passenger.setName(name);
                passenger.setEmail(email);
                passenger.setVip(vip);
                passengers.add(passenger);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return passengers;
    }

    /**
     * Add Passenger object to database.
     *
     * @return void.
     */
    @Override
    public void addPassenger(Passenger passenger) {
        PreparedStatement stmt = null;
        String query = "insert into AHA.PASSENGERS (id, name, email,VIP) "
                + "values (?, ?, ?,?)";
        try {
            stmt = AHA.connection.prepareStatement(query);
            stmt.setInt(1, this.getMaxPassengerId() + 1);
            stmt.setString(2, passenger.getName());
            stmt.setString(3, passenger.getEmail());
            stmt.setBoolean(4, true);
            int modifiedRows = stmt.executeUpdate();
            System.out.println("Modified rows:");
            System.out.println(modifiedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean updatePassenger(Passenger passenger) {
        PreparedStatement stmt = null;
        boolean result = false;
        String query = "update AHA.PASSENGERS set name = ?, email= ?, vip= ? where id = ? ";

        try {
            stmt = AHA.connection.prepareStatement(query);
            stmt.setString(1, passenger.getName());
            stmt.setString(2, passenger.getEmail());
            stmt.setBoolean(3, passenger.isVip());
            stmt.setInt(4, passenger.getId());
            int modifiedRows = stmt.executeUpdate();
            System.out.println("Modified rows:");
            System.out.println(modifiedRows);
            
            if(modifiedRows > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * Get max id number from passenger table.
     *
     * @return the highest id value from passengers table.
     */
    @Override
    public int getMaxPassengerId() {
        int maxPassengerId = 0;
        Statement stmt = null;
        String query = "select MAX(ID) "
                + "from AHA.PASSENGERS ";
        try {
            stmt = AHA.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                maxPassengerId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();

                } catch (SQLException ex) {
                    Logger.getLogger(PassengerRepository.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return maxPassengerId;
    }
}
