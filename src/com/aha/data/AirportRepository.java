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
 * @author simonicsanett
 */
public class AirportRepository {

    /**
     * Get an Airport object with the given airport code
     *
     * @param code Three letter identifier of the airport, e.g. DUB
     * @return The airport object if exists, null otherwise
     */
    public Airport getAirportByCode(String codeport) throws SQLException {
        
        
        Airport airport  = null;
        PreparedStatement stmtport = null;
        String query = "select  CODE, CITY "
                + "from AHA.Airports where CODE = ?";
        
        //   ';DROP TABLE AIRPLANES; --
        
        try {
            stmtport = AHA.connection.prepareStatement(query);
            stmtport.setString(1, codeport);
            
            ResultSet rsport = stmtport.executeQuery();

            boolean airportExists = rsport.next();

            if (airportExists) {
              
                String city = rsport.getString("CITY");
                String airportcode = rsport.getString("CODE");

                airport = new Airport();
                airport.setCity(city);
                airport.setCode(airportcode);
               
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmtport != null) {
                stmtport.close();
            }
        }

        return airport;
//        
        
        
     //  for (Airport airport : airports()) {
           // if (airport.getCode().equals(code)) {
          //      return airport;
        //    }
      //  }
     //   return null;//
    }

    /**
     * Return all Airport objects
     *
     * @return All Airport in the application state
     */
    public List<Airport> getAirports() throws SQLException {
        
        List<Airport> airports = new ArrayList<>();

        Statement stmt = null;
        String query = "select CODE, CITY "
                + "from AHA.Airports";
        try {
            stmt = AHA.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                
                String code = rs.getString("CODE");
                String city = rs.getString("CITY");

              Airport airport = new Airport();
                airport.setCity(city);
                airport.setCode(code);
               

                airports.add(airport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return airports;
    }

    /**
     * Add a new Airport object to the application state and save it to the XML
     *
     * @param airport The Airport object to add
     */
    public void addAirport(Airport airport) {
        airports().add(airport);
        FileSystemManager.getInstance().saveState();
    }

    /**
     * Helper method to get all Airport objects from application state
     *
     * @return List of Airport objects
     */
    private List<Airport> airports() {
        return FileSystemManager.getInstance().getState().getAirports();
    }
}
