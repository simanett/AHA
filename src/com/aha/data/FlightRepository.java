/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.AHA;
import com.aha.businesslogic.model.Airplane;
import com.aha.businesslogic.model.Airport;
import com.aha.businesslogic.model.Flight;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Repository class to handle flight data
 *
 * @author HB
 */
public class FlightRepository {

    /**
     * Return the Flight object with the given flight number
     *
     * @param flightNumber String that identifies the Flight object
     * @return The Flight object if exists, null otherwise
     */
    public Flight getFlightByFlightNumber(String flightNumber) throws SQLException {

        Flight flight = null;
        PreparedStatement stmt = null;

        String query = "SELECT FLIGHTS.ID AS FLIGHT_ID, \n"
                + "    FLIGHTS.FLIGHTNUMBER, \n"
                + "    FLIGHTS.DEPARTURE,\n"
                + "    FLIGHTS.FLIGHTDURATION,\n"
                + "    AIRPLANES.MAXDISTANCE,\n"
                + "    AIRPLANES.ID AS AIRPLANE_ID,\n"
                + "    AIRPLANES.MODEL,\n"
                + "    AIRPORT_FROM.CODE AS FROM_CODE,\n"
                + "    AIRPORT_FROM.CITY AS FROM_CITY,\n"
                + "    AIRPORT_TO.CODE AS TO_CODE,\n"
                + "    AIRPORT_TO.CITY  AS TO_CITY  \n"
                + "FROM AHA.FLIGHTS\n"
                + "JOIN AHA.AIRPLANES ON FLIGHTS.AIRPLANEID = AIRPLANES.ID\n"
                + "JOIN AHA.AIRPORTS AIRPORT_FROM ON FLIGHTS.FROMID = AIRPORT_FROM.CODE \n"
                + "JOIN AHA.AIRPORTS AIRPORT_TO ON FLIGHTS.TOID = AIRPORT_TO.CODE "
                + "WHERE FLIGHTNUMBER = ?";

        try {

            stmt = AHA.connection.prepareStatement(query);
            stmt.setString(1, flightNumber);
            ResultSet rs = stmt.executeQuery();

            boolean flightNumberExist = rs.next();
            if (flightNumberExist) {

                int id = rs.getInt("FLIGHT_ID");
                String flightn = rs.getString("FLIGHTNUMBER");
                Date departure = rs.getDate("DEPARTURE");
                int flightDuration = rs.getInt("FLIGHTDURATION");

                int airplaneId = rs.getInt("AIRPLANE_ID");
                String airplaneModel = rs.getString("MODEL");
                int airplaneMaxdistance = rs.getInt("MAXDISTANCE");

                String fromCode = rs.getString("FROM_CODE");
                String fromCity = rs.getString("FROM_CITY");
                String toCode = rs.getString("TO_CODE");
                String toCity = rs.getString("TO_CITY");

                Airplane airplane = new Airplane();
                airplane.setId(airplaneId);
                airplane.setModel(airplaneModel);
                airplane.setMaxDistance(airplaneMaxdistance);

                Airport fromAirport = new Airport();
                fromAirport.setCode(fromCode);
                fromAirport.setCity(fromCity);

                Airport toAirport = new Airport();
                toAirport.setCode(toCode);
                toAirport.setCity(toCity);

                flight = new Flight();
                flight.setId(id);
                flight.setFlightNumber(flightn);
                flight.setDeparture(departure);
                flight.setFlightDuration(flightDuration);
                flight.setAirplane(airplane);
                flight.setAirportFrom(fromAirport);
                flight.setAirportTo(toAirport);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return flight;

        /* for (Flight flight : this.flights()) {
        if (flight.getFlightNumber().equals(flightNumber)) {
        return flight;
        }
        }
        return null;*/
    }

    /**
     * Return all Flight objects
     *
     * @return All Flights in the application state
     */
    public List<Flight> getFlights() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        Statement stmt = null;
        
        String query = "SELECT FLIGHTS.ID AS FLIGHT_ID, \n"
                + "    FLIGHTS.FLIGHTNUMBER, \n"
                + "    FLIGHTS.DEPARTURE,\n"
                + "    FLIGHTS.FLIGHTDURATION,\n"
                + "    AIRPLANES.MAXDISTANCE,\n"
                + "    AIRPLANES.ID AS AIRPLANE_ID,\n"
                + "    AIRPLANES.MODEL,\n"
                + "    AIRPORT_FROM.CODE AS FROM_CODE,\n"
                + "    AIRPORT_FROM.CITY AS FROM_CITY,\n"
                + "    AIRPORT_TO.CODE AS TO_CODE,\n"
                + "    AIRPORT_TO.CITY  AS TO_CITY  \n"
                + "FROM AHA.FLIGHTS\n"
                + "JOIN AHA.AIRPLANES ON FLIGHTS.AIRPLANEID = AIRPLANES.ID\n"
                + "JOIN AHA.AIRPORTS AIRPORT_FROM ON FLIGHTS.FROMID = AIRPORT_FROM.CODE \n"
                + "JOIN AHA.AIRPORTS AIRPORT_TO ON FLIGHTS.TOID = AIRPORT_TO.CODE ";
    
          try {
            stmt = AHA.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                
                
                 int id = rs.getInt("FLIGHT_ID");
                String flightn = rs.getString("FLIGHTNUMBER");
                Date departure = rs.getDate("DEPARTURE");
                int flightDuration = rs.getInt("FLIGHTDURATION");

                int airplaneId = rs.getInt("AIRPLANE_ID");
                String airplaneModel = rs.getString("MODEL");
                int airplaneMaxdistance = rs.getInt("MAXDISTANCE");

                String fromCode = rs.getString("FROM_CODE");
                String fromCity = rs.getString("FROM_CITY");
                String toCode = rs.getString("TO_CODE");
                String toCity = rs.getString("TO_CITY");

                Airplane airplane = new Airplane();
                airplane.setId(airplaneId);
                airplane.setModel(airplaneModel);
                airplane.setMaxDistance(airplaneMaxdistance);

                Airport fromAirport = new Airport();
                fromAirport.setCode(fromCode);
                fromAirport.setCity(fromCity);

                Airport toAirport = new Airport();
                toAirport.setCode(toCode);
                toAirport.setCity(toCity);

                Flight flight  = new Flight();
                flight.setId(id);
                flight.setFlightNumber(flightn);
                flight.setDeparture(departure);
                flight.setFlightDuration(flightDuration);
                flight.setAirplane(airplane);
                flight.setAirportFrom(fromAirport);
                flight.setAirportTo(toAirport);
                
                flights.add(flight);
                
                
            }}
          catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }}
    return flights;
    }
    
    
    
    
    
        /**
         * Add a new Flight object to the application state and save it to the
         * XML
         *
         * @param flight The Flight object to add
         */
    public void addFlight(Flight flight) {
        flights().add(flight);
        FileSystemManager.getInstance().saveState();
    }

    /**
     * Helper method to get all Flight objects from application state
     *
     * @return List of Flight objects
     */
    private List<Flight> flights() {
        return FileSystemManager.getInstance().getState().getFlights();
    }
}
