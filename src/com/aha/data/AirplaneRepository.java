/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.AHA;
import com.aha.businesslogic.model.Airplane;
import com.aha.businesslogic.model.Airport;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class to handle airplane data
 *
 * @author HB
 */
public class AirplaneRepository {

    /**
     * Return the Airplane object with the given model name
     *
     * @param airplaneModel String representing the model of the airplane, e.g
     * "Boeing"
     * @return The Airplane object if exists, null otherwise
     */
    public Airplane getAirplaneByModel(String airplaneModel) throws SQLException {
        Airplane airplane = null;
        PreparedStatement stmt = null;
        String query = "select ID, MAXDISTANCE, MODEL "
                + "from AHA.Airplanes where MODEL = ?";
        
        //   ';DROP TABLE AIRPLANES; --
        
        try {
            stmt = AHA.connection.prepareStatement(query);
            stmt.setString(1, airplaneModel);
            
            ResultSet rs = stmt.executeQuery();

            boolean airplaneExists = rs.next();

            if (airplaneExists) {
                int id = rs.getInt("ID");
                int maxDistance = rs.getInt("MAXDISTANCE");
                String model = rs.getString("MODEL");

                airplane = new Airplane();
                airplane.setMaxDistance(maxDistance);
                airplane.setModel(model);
                airplane.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return airplane;

    }

    /**
     * Return all Airplane objects
     *
     * @return All Airplanes in the application state
     */
    public List<Airplane> getAirplanes() throws SQLException {
        List<Airplane> airplanes = new ArrayList<>();

        Statement stmt = null;
        String query = "select ID, MAXDISTANCE, MODEL "
                + "from AHA.Airplanes";
        try {
            stmt = AHA.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                int maxDistance = rs.getInt("MAXDISTANCE");
                String model = rs.getString("MODEL");

                Airplane plane = new Airplane();
                plane.setMaxDistance(maxDistance);
                plane.setModel(model);
                plane.setId(id);

                airplanes.add(plane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return airplanes;
    }

    /**
     * Add a new Airplane object to the application state and save it to the XML
     *
     * @param airplane The Airplane object to add
     */
    public void addAirplane(Airplane airplane) {
        airplanes().add(airplane);
        FileSystemManager.getInstance().saveState();
    }

    /**
     * Helper method to get all Airplane objects from application state
     *
     * @return List of Airplane objects
     */
    private List<Airplane> airplanes() {
        return FileSystemManager.getInstance().getState().getAirplanes();
    }

}
