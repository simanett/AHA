/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.AHA;
import com.aha.businesslogic.model.Airplane;
import com.aha.businesslogic.model.Airport;
import com.aha.businesslogic.model.Booking;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Passenger;
import com.aha.businesslogic.model.Seat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * Repository class to handle airplane data
 *
 * @author simonicsanett
 */
public class BookingRepository {

    /**
     * Return the Booking object with the given booking number
     *
     * @param bookingReference String that identifies the Booking object
     * @return The Booking object if exists, null otherwise
     */
    public Booking getBookingByBookingReference(String bookingReference) {
        Booking booking = null;
        PreparedStatement stmt = null;
        String query = "SELECT BOOKINGS.BOOKINGREFERENCE, \n"
                + " BOOKINGS.SEATID, \n"
                + " BOOKINGS.PASSENGERID, \n"
                + " FLIGHTS.ID AS FLIGHT_ID, \n"
                + " FLIGHTS.FLIGHTNUMBER, \n"
                + " FLIGHTS.DEPARTURE, \n"
                + " FLIGHTS.FLIGHTDURATION, \n"
                + " FLIGHTS.AIRPLANEID, \n"
                + " PASSENGERS.NAME AS PASSENGER_NAME, \n"
                + " PASSENGERS.EMAIL AS PASSENGER_EMAIL, \n"
                + " AIRPLANES.ID AS AIRPLANE_ID, \n"
                + " AIRPLANES.MAXDISTANCE, \n"
                + " AIRPLANES.MODEL, \n"
                + " AIRPORT_FROM.CODE AS FROM_CODE, \n"
                + " AIRPORT_FROM.CITY AS FROM_CITY, \n"
                + " AIRPORT_TO.CODE AS TO_CODE, \n"
                + " AIRPORT_TO.CITY AS TO_CITY \n"
                + " FROM BOOKINGS \n"
                + " JOIN FLIGHTS ON BOOKINGS.FLIGHTID = FLIGHTS.ID \n"
                + " JOIN PASSENGERS ON BOOKINGS.PASSENGERID = PASSENGERS.ID "
                + " JOIN AHA.AIRPLANES ON FLIGHTS.AIRPLANEID = AIRPLANES.ID "
                + " JOIN AHA.AIRPORTS AIRPORT_FROM ON FLIGHTS.FROMID = AIRPORT_FROM.CODE "
                + " JOIN AHA.AIRPORTS AIRPORT_TO ON FLIGHTS.TOID = AIRPORT_TO.CODE "
                + " WHERE BOOKINGREFERENCE = ?";
        try {
            stmt = AHA.connection.prepareStatement(query);
            stmt.setString(1, bookingReference);
            ResultSet rs = stmt.executeQuery();

            boolean bookingReferenceExists = rs.next();
            if (bookingReferenceExists) {

                String bookingRef = rs.getString("BOOKINGREFERENCE");
                int seatId = rs.getInt("SEATID");
                int flightId = rs.getInt("FLIGHT_ID");
                int passengerId = rs.getInt("PASSENGERID");
                String flightNumber = rs.getString("FLIGHTNUMBER");
                Date departure = rs.getDate("DEPARTURE");
                int flightDuration = rs.getInt("FLIGHTDURATION");
                int airplaneId = rs.getInt("AIRPLANEID");
                int maxdistance = rs.getInt("MAXDISTANCE");
                String model = rs.getString("MODEL");
                String passengerName = rs.getString("PASSENGER_NAME");
                String passengerEmail = rs.getString("PASSENGER_EMAIL");
                String fromCode = rs.getString("FROM_CODE");
                String fromCity = rs.getString("FROM_CITY");
                String toCode = rs.getString("TO_CODE");
                String toCity = rs.getString("TO_CITY");
                Date bookingDate = new Date();

                Passenger passenger = new Passenger();
                passenger.setId(passengerId);
                passenger.setEmail(passengerEmail);
                passenger.setName(passengerName);

                Airport fromAirport = new Airport();
                fromAirport.setCode(fromCode);
                fromAirport.setCity(fromCity);

                Airport toAirport = new Airport();
                toAirport.setCode(toCode);
                toAirport.setCity(toCity);

                Airplane airplane = new Airplane();
                airplane.setId(airplaneId);
                airplane.setMaxDistance(maxdistance);
                airplane.setModel(model);

                Flight flight = new Flight();
                flight.setId(flightId);
                flight.setFlightNumber(flightNumber);
                flight.setDeparture(departure);
                flight.setFlightDuration(flightDuration);
                flight.setAirplane(airplane);
                flight.setAirportFrom(fromAirport);
                flight.setAirportTo(toAirport);

                booking = new Booking();
                booking.setBookingReference(bookingRef);
                booking.setPassenger(passenger);
                booking.setFlight(flight);
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
        return booking;
    }

    /**
     * Return all Booking objects
     *
     * @return All Bookings in the database
     */
    public List<Booking> getBookings() {
        List<Booking> bookings = new ArrayList<>();
        Statement stmt = null;

        String query = "SELECT BOOKINGS.BOOKINGREFERENCE, \n"
                + " BOOKINGS.SEATID, \n"
                + " BOOKINGS.PASSENGERID, \n"
                + " FLIGHTS.ID AS FLIGHT_ID, \n"
                + " FLIGHTS.FLIGHTNUMBER, \n"
                + " FLIGHTS.DEPARTURE, \n"
                + " FLIGHTS.FLIGHTDURATION, \n"
                + " FLIGHTS.AIRPLANEID, \n"
                + " PASSENGERS.NAME AS PASSENGER_NAME, \n"
                + " PASSENGERS.EMAIL AS PASSENGER_EMAIL, \n"
                + " AIRPLANES.ID AS AIRPLANE_ID, \n"
                + " AIRPLANES.MAXDISTANCE, \n"
                + " AIRPLANES.MODEL, \n"
                + " AIRPORT_FROM.CODE AS FROM_CODE, \n"
                + " AIRPORT_FROM.CITY AS FROM_CITY, \n"
                + " AIRPORT_TO.CODE AS TO_CODE, \n"
                + " AIRPORT_TO.CITY AS TO_CITY \n"
                + " FROM BOOKINGS \n"
                + " JOIN FLIGHTS ON BOOKINGS.FLIGHTID = FLIGHTS.ID \n"
                + " JOIN PASSENGERS ON BOOKINGS.PASSENGERID = PASSENGERS.ID "
                + " JOIN AHA.AIRPLANES ON FLIGHTS.AIRPLANEID = AIRPLANES.ID "
                + " JOIN AHA.AIRPORTS AIRPORT_FROM ON FLIGHTS.FROMID = AIRPORT_FROM.CODE "
                + " JOIN AHA.AIRPORTS AIRPORT_TO ON FLIGHTS.TOID = AIRPORT_TO.CODE ";
        try {
            stmt = AHA.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                String bookingRef = rs.getString("BOOKINGREFERENCE");
                int seatId = rs.getInt("SEATID");
                int flightId = rs.getInt("FLIGHT_ID");
                int passengerId = rs.getInt("PASSENGERID");
                String flightNumber = rs.getString("FLIGHTNUMBER");
                Date departure = rs.getDate("DEPARTURE");
                int flightDuration = rs.getInt("FLIGHTDURATION");
                int airplaneId = rs.getInt("AIRPLANEID");
                int maxdistance = rs.getInt("MAXDISTANCE");
                String model = rs.getString("MODEL");
                String passengerName = rs.getString("PASSENGER_NAME");
                String passengerEmail = rs.getString("PASSENGER_EMAIL");
                String fromCode = rs.getString("FROM_CODE");
                String fromCity = rs.getString("FROM_CITY");
                String toCode = rs.getString("TO_CODE");
                String toCity = rs.getString("TO_CITY");
                Date bookingDate = new Date();

                Passenger passenger = new Passenger();
                passenger.setId(passengerId);
                passenger.setEmail(passengerEmail);
                passenger.setName(passengerName);

                Airport fromAirport = new Airport();
                fromAirport.setCode(fromCode);
                fromAirport.setCity(fromCity);

                Airport toAirport = new Airport();
                toAirport.setCode(toCode);
                toAirport.setCity(toCity);

                Airplane airplane = new Airplane();
                airplane.setId(airplaneId);
                airplane.setMaxDistance(maxdistance);
                airplane.setModel(model);

                Flight flight = new Flight();
                flight.setId(flightId);
                flight.setFlightNumber(flightNumber);
                flight.setDeparture(departure);
                flight.setFlightDuration(flightDuration);
                flight.setAirplane(airplane);
                flight.setAirportFrom(fromAirport);
                flight.setAirportTo(toAirport);

                Booking booking = new Booking();
                booking.setBookingReference(bookingRef);
                booking.setPassenger(passenger);
                booking.setFlight(flight);

                bookings.add(booking);
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
        return bookings;
    }

    public List<Booking> getActiveBookingsByPassenger(Passenger inputpassenger) {
        List<Booking> bookings = new ArrayList<>();
        PreparedStatement stmt = null;

        String query = "SELECT BOOKINGS.BOOKINGREFERENCE, \n"
                + " BOOKINGS.SEATID, \n"
                + " BOOKINGS.PASSENGERID, \n"
                + " FLIGHTS.ID AS FLIGHT_ID, \n"
                + " FLIGHTS.FLIGHTNUMBER, \n"
                + " FLIGHTS.DEPARTURE, \n"
                + " FLIGHTS.FLIGHTDURATION, \n"
                + " FLIGHTS.AIRPLANEID, \n"
                + " PASSENGERS.NAME AS PASSENGER_NAME, \n"
                + " PASSENGERS.EMAIL AS PASSENGER_EMAIL, \n"
                + " AIRPLANES.ID AS AIRPLANE_ID, \n"
                + " AIRPLANES.MAXDISTANCE, \n"
                + " AIRPLANES.MODEL, \n"
                + " AIRPORT_FROM.CODE AS FROM_CODE, \n"
                + " AIRPORT_FROM.CITY AS FROM_CITY, \n"
                + " AIRPORT_TO.CODE AS TO_CODE, \n"
                + " AIRPORT_TO.CITY AS TO_CITY, \n"
                + " SEATS.ID AS SEAT_ID, "
                + " SEATS.ROWNUMBER, "
                + " SEATS.COLUMNLETTER "
                + " FROM BOOKINGS \n"
                + " JOIN FLIGHTS ON BOOKINGS.FLIGHTID = FLIGHTS.ID \n"
                + " JOIN PASSENGERS ON BOOKINGS.PASSENGERID = PASSENGERS.ID "
                + " JOIN AHA.AIRPLANES ON FLIGHTS.AIRPLANEID = AIRPLANES.ID "
                + " JOIN AHA.AIRPORTS AIRPORT_FROM ON FLIGHTS.FROMID = AIRPORT_FROM.CODE "
                + " JOIN AHA.AIRPORTS AIRPORT_TO ON FLIGHTS.TOID = AIRPORT_TO.CODE"
                + " JOIN AHA.SEATS ON BOOKINGS.SEATID = SEATS.ID "
                + " WHERE PASSENGERS.ID = ? AND"
                + " FLIGHTS.DEPARTURE > SYSDATE";
        try {
            stmt = AHA.connection.prepareStatement(query);
            stmt.setInt(1, inputpassenger.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String bookingRef = rs.getString("BOOKINGREFERENCE");
                int seatId = rs.getInt("SEATID");
                int flightId = rs.getInt("FLIGHT_ID");
                int passengerId = rs.getInt("PASSENGERID");
                String flightNumber = rs.getString("FLIGHTNUMBER");
                Date departure = rs.getDate("DEPARTURE");
                int flightDuration = rs.getInt("FLIGHTDURATION");
                int airplaneId = rs.getInt("AIRPLANEID");
                int maxdistance = rs.getInt("MAXDISTANCE");
                String model = rs.getString("MODEL");
                String passengerName = rs.getString("PASSENGER_NAME");
                String passengerEmail = rs.getString("PASSENGER_EMAIL");
                String fromCode = rs.getString("FROM_CODE");
                String fromCity = rs.getString("FROM_CITY");
                String toCode = rs.getString("TO_CODE");
                String toCity = rs.getString("TO_CITY");
                int seatsId = rs.getInt("SEAT_ID");
                int rowNumber = rs.getInt("ROWNUMBER");
                String columnLetter = rs.getString("COLUMNLETTER");
                Date bookingDate = new Date();

                Passenger passenger = new Passenger();
                passenger.setId(passengerId);
                passenger.setEmail(passengerEmail);
                passenger.setName(passengerName);

                Airport fromAirport = new Airport();
                fromAirport.setCode(fromCode);
                fromAirport.setCity(fromCity);

                Airport toAirport = new Airport();
                toAirport.setCode(toCode);
                toAirport.setCity(toCity);

                Airplane airplane = new Airplane();
                airplane.setId(airplaneId);
                airplane.setMaxDistance(maxdistance);
                airplane.setModel(model);

                Flight flight = new Flight();
                flight.setId(flightId);
                flight.setFlightNumber(flightNumber);
                flight.setDeparture(departure);
                flight.setFlightDuration(flightDuration);
                flight.setAirplane(airplane);
                flight.setAirportFrom(fromAirport);
                flight.setAirportTo(toAirport);

                Seat seat = new Seat();

                seat.setId(seatsId);
                seat.setRow(rowNumber);
                seat.setLetter(columnLetter);

                Booking booking = new Booking();
                booking.setBookingReference(bookingRef);
                booking.setPassenger(passenger);
                booking.setFlight(flight);
                booking.setSeat(seat);

                bookings.add(booking);
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
        return bookings;
    }

    /**
     * Return all approved Booking objects
     *
     * @return All Bookings that are approved (booking.isApproved() == true)
     */
    public List<Booking> getApprovedBookings() {

        List<Booking> approvedBookings = new ArrayList<>();
        for (Booking booking : getBookings()) {
            if (booking.isApproved()) {
                approvedBookings.add(booking);
            }
        }
        return approvedBookings;
    }

    /**
     * Return all pending Booking objects
     *
     * @return All Bookings that are pending (booking.isApproved() == false)
     */
    public List<Booking> getPendingBookings() {

        List<Booking> pendingBookings = new ArrayList<>();
        for (Booking booking : getBookings()) {
            if (booking.isApproved() == false) {
                pendingBookings.add(booking);
            }
        }
        return pendingBookings;
    }

    /**
     * Add a new Booking object to the application state and save it to the XML
     *
     * @param booking The Booking object to add
     */
    public boolean addBooking(Booking booking) {
        boolean result = false;
        PreparedStatement stmt = null;
        String query = " insert into AHA.BOOKINGS (BOOKINGREFERENCE, SEATID, FLIGHTID, PASSENGERID) "
                + "values (?, ?, ?, ?) ";

        System.out.println(booking);
        
        try {
            stmt = AHA.connection.prepareStatement(query);
            stmt.setString(1, booking.getBookingReference());
            stmt.setInt(2, booking.getSeat().getId());
            stmt.setInt(3, booking.getFlight().getId());
            stmt.setInt(4, booking.getPassenger().getId());

            int modifiedRows = stmt.executeUpdate();

            if (modifiedRows > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
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

}
