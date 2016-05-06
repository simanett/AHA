/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.service.FlightService;
import com.aha.AHA;
import com.aha.businesslogic.model.Airplane;
import com.aha.businesslogic.model.Airport;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Seat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class FlightRepository implements FlightService {

    /**
     * Return the Flight object with the given flight number
     *
     * @param flightNumber int that identifies the Flight object
     * @return The Flight object if exists, null otherwise
     */
    @Override
    public Flight getFlightByFlightNumber(int flightNumber) {

        Flight flight = null;
        PreparedStatement stmt = null;

        String query = "SELECT FLIGHTS.ID AS FLIGHT_ID, \n"
                + "    FLIGHTS.FLIGHTNUMBER, \n"
                + "    FLIGHTS.DEPARTURE,\n"
                + "    FLIGHTS.FLIGHTDURATION,\n"
                + "    FLIGHTS.BASICPRICE,\n"
                + "    AIRPLANES.MAXDISTANCE,\n"
                + "    AIRPLANES.ID AS AIRPLANE_ID,\n"
                + "    AIRPLANES.MODEL,\n"
                + "    SEATS.ROWNUMBER,\n"
                + "    SEATS.COLUMNLETTER,\n"
                + "    AIRPORT_FROM.CODE AS FROM_CODE,\n"
                + "    AIRPORT_FROM.CITY AS FROM_CITY,\n"
                + "    AIRPORT_TO.CODE AS TO_CODE,\n"
                + "    AIRPORT_TO.CITY  AS TO_CITY  \n"
                + "FROM AHA.FLIGHTS\n"
                + "JOIN AHA.AIRPLANES ON FLIGHTS.AIRPLANEID = AIRPLANES.ID\n"
                + "JOIN AHA.AIRPORTS AIRPORT_FROM ON FLIGHTS.FROMID = AIRPORT_FROM.CODE \n"
                + "JOIN AHA.AIRPORTS AIRPORT_TO ON FLIGHTS.TOID = AIRPORT_TO.CODE "
                + "JOIN SEATS ON AIRPLANES.ID = SEATS.AIRPLANEID "
                + "WHERE FLIGHTNUMBER = ?";

        try {

            stmt = AHA.connection.prepareStatement(query);
            stmt.setInt(1, flightNumber);
            ResultSet rs = stmt.executeQuery();

            boolean flightNumberExist = rs.next();
            if (flightNumberExist) {

                int id = rs.getInt("FLIGHT_ID");
                String flightn = rs.getString("FLIGHTNUMBER");
                Date departure = rs.getDate("DEPARTURE");
                int flightDuration = rs.getInt("FLIGHTDURATION");
                int basicprice = rs.getInt("BASICPRICE");

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

                List<Seat> seats = new ArrayList<>();

                PreparedStatement stmtSeats = null;
                String querySeats = "SELECT SEATS.ID AS SEAT_ID,\n"
                        + "SEATS.ROWNUMBER,\n"
                        + "SEATS.COLUMNLETTER, \n"
                        + "SEATS.MULTIPLIER \n"
                        + "FROM AHA.SEATS\n"
                        + "WHERE AIRPLANEID = ?";
                try {
                    stmtSeats = AHA.connection.prepareStatement(querySeats);
                    stmtSeats.setInt(1, airplaneId);
                    ResultSet rsSeats = stmtSeats.executeQuery();
                    /*?? Do we need to check if airplaneId is NULL?*/
                    while (rsSeats.next()) {
                        int seatId = rsSeats.getInt("SEAT_ID");
                        int seatRowNum = rsSeats.getInt("ROWNUMBER");
                        String seatColumnLetter = rsSeats.getString("COLUMNLETTER");
                        double multiplier = rsSeats.getDouble("MULTIPLIER");
                        Seat seat = new Seat();
                        seat.setId(id);
                        seat.setLetter(seatColumnLetter);
                        seat.setRow(seatRowNum);
                        seat.setMultiplier(multiplier);
                        seats.add(seat);
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

                airplane.setSeats(seats);

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
                flight.setBasicPrice(basicprice);
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
        return flight;
    }
    
    @Override
    public Flight getFlightById(int id) {

        Flight flight = null;
        PreparedStatement stmt = null;

        String query = "SELECT FLIGHTS.ID AS FLIGHT_ID, \n"
                + "    FLIGHTS.FLIGHTNUMBER, \n"
                + "    FLIGHTS.DEPARTURE,\n"
                + "    FLIGHTS.FLIGHTDURATION,\n"
                + "    FLIGHTS.BASICPRICE,\n"
                + "    AIRPLANES.MAXDISTANCE,\n"
                + "    AIRPLANES.ID AS AIRPLANE_ID,\n"
                + "    AIRPLANES.MODEL,\n"
                + "    SEATS.ROWNUMBER,\n"
                + "    SEATS.COLUMNLETTER,\n"
                + "    SEATS.MULTIPLIER,\n"
                + "    AIRPORT_FROM.CODE AS FROM_CODE,\n"
                + "    AIRPORT_FROM.CITY AS FROM_CITY,\n"
                + "    AIRPORT_TO.CODE AS TO_CODE,\n"
                + "    AIRPORT_TO.CITY  AS TO_CITY  \n"
                + "FROM AHA.FLIGHTS\n"
                + "JOIN AHA.AIRPLANES ON FLIGHTS.AIRPLANEID = AIRPLANES.ID\n"
                + "JOIN AHA.AIRPORTS AIRPORT_FROM ON FLIGHTS.FROMID = AIRPORT_FROM.CODE \n"
                + "JOIN AHA.AIRPORTS AIRPORT_TO ON FLIGHTS.TOID = AIRPORT_TO.CODE "
                + "JOIN SEATS ON AIRPLANES.ID = SEATS.AIRPLANEID "
                + "WHERE FLIGHTS.ID = ?";

        try {

            stmt = AHA.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            boolean flightNumberExist = rs.next();
            if (flightNumberExist) {

                int flightId = rs.getInt("FLIGHT_ID");
                String flightn = rs.getString("FLIGHTNUMBER");
                Date departure = rs.getDate("DEPARTURE");
                int flightDuration = rs.getInt("FLIGHTDURATION");
                int basicprice = rs.getInt("BASICPRICE");

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

                List<Seat> seats = new ArrayList<>();

                PreparedStatement stmtSeats = null;
                String querySeats = "SELECT SEATS.ID AS SEAT_ID,\n"
                        + "SEATS.ROWNUMBER,\n"
                        + "SEATS.COLUMNLETTER, \n"
                        + "SEATS.MULTIPLIER\n"
                        + "FROM AHA.SEATS\n"
                        + "WHERE AIRPLANEID = ?";
                try {
                    stmtSeats = AHA.connection.prepareStatement(querySeats);
                    stmtSeats.setInt(1, airplaneId);
                    ResultSet rsSeats = stmtSeats.executeQuery();
                    /*?? Do we need to check if airplaneId is NULL?*/
                    while (rsSeats.next()) {
                        int seatId = rsSeats.getInt("SEAT_ID");
                        int seatRowNum = rsSeats.getInt("ROWNUMBER");
                        String seatColumnLetter = rsSeats.getString("COLUMNLETTER");
                        double multiplier = rsSeats.getDouble("MULTIPLIER");
                        Seat seat = new Seat();
                        seat.setId(seatId);
                        seat.setLetter(seatColumnLetter);
                        seat.setRow(seatRowNum);
                        seat.setMultiplier(multiplier);
                        seats.add(seat);
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

                airplane.setSeats(seats);

                Airport fromAirport = new Airport();
                fromAirport.setCode(fromCode);
                fromAirport.setCity(fromCity);

                Airport toAirport = new Airport();
                toAirport.setCode(toCode);
                toAirport.setCity(toCity);

                flight = new Flight();
                flight.setId(flightId);
                flight.setFlightNumber(flightn);
                flight.setDeparture(departure);
                flight.setFlightDuration(flightDuration);
                flight.setAirplane(airplane);
                flight.setAirportFrom(fromAirport);
                flight.setAirportTo(toAirport);
                flight.setBasicPrice(basicprice);
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
        return flight;

    }

    /**
     * Return all Flight objects
     *
     * @return All Flights in the application state
     */
    @Override
    public List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();
        Statement stmt = null;

        String query = "SELECT FLIGHTS.ID AS FLIGHT_ID, \n"
                + "    FLIGHTS.FLIGHTNUMBER, \n"
                + "    FLIGHTS.DEPARTURE,\n"
                + "    FLIGHTS.FLIGHTDURATION,\n"
                + "    FLIGHTS.BASICPRICE,\n"
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
                int basicprice = rs.getInt("BASICPRICE");

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

                Flight flight = new Flight();
                flight.setId(id);
                flight.setFlightNumber(flightn);
                flight.setDeparture(departure);
                flight.setFlightDuration(flightDuration);
                flight.setAirplane(airplane);
                flight.setAirportFrom(fromAirport);
                flight.setAirportTo(toAirport);
                flight.setBasicPrice(basicprice);

                flights.add(flight);
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
        return flights;
    }

        /**
     * Return all Flight objects
     *
     * @return All Flights in the application state
     */
    @Override
    public List<Flight> getFilteredFlights(String fromAirportCode, String toAirportCode, Date fromDate, Date toDate) {
        List<Flight> flights = new ArrayList<>();
        PreparedStatement stmt = null;

        String query = "SELECT FLIGHTS.ID AS FLIGHT_ID, \n"
                + "    FLIGHTS.FLIGHTNUMBER, \n"
                + "    FLIGHTS.DEPARTURE,\n"
                + "    FLIGHTS.FLIGHTDURATION,\n"
                + "    FLIGHTS.BASICPRICE,\n"
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
                + "WHERE AIRPORT_FROM.CODE = ? and AIRPORT_TO.CODE = ? and FLIGHTS.DEPARTURE between ? and ?";

        try {
            stmt = AHA.connection.prepareStatement(query);
            stmt.setString(1, fromAirportCode);
            stmt.setString(2, toAirportCode);
            stmt.setDate(3, new java.sql.Date(fromDate.getTime()));
            stmt.setDate(4, new java.sql.Date(toDate.getTime()));
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("FLIGHT_ID");
                String flightn = rs.getString("FLIGHTNUMBER");
                Date departure = rs.getDate("DEPARTURE");
                int flightDuration = rs.getInt("FLIGHTDURATION");
                int basicprice = rs.getInt("BASICPRICE");

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

                Flight flight = new Flight();
                flight.setId(id);
                flight.setFlightNumber(flightn);
                flight.setDeparture(departure);
                flight.setFlightDuration(flightDuration);
                flight.setAirplane(airplane);
                flight.setAirportFrom(fromAirport);
                flight.setAirportTo(toAirport);
                flight.setBasicPrice(basicprice);

                flights.add(flight);
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
        return flights;
    }

}
