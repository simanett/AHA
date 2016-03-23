/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.businesslogic.model.Booking;
import java.sql.PreparedStatement;
import java.util.ArrayList;
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
                + "    BOOKINGS.SEATID, \n"
                + "    BOOKINGS.FLIGHTID,\n"
                + "    BOOKINGS.PASSANGERID,\n"
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

        return booking;
    }

    /**
     * Return all Booking objects
     *
     * @return All Bookings in the application state
     */
    public List<Booking> getBookings() {
        return bookings();
    }

    /**
     * Return all approved Booking objects
     *
     * @return All Bookings that are approved (booking.isApproved() == true)
     */
    public List<Booking> getApprovedBookings() {

        List<Booking> approvedBookings = new ArrayList<>();
        for (Booking booking : bookings()) {
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
        for (Booking booking : bookings()) {
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
    public void addBooking(Booking booking) {
        bookings().add(booking);
        FileSystemManager.getInstance().saveState();
    }

    /**
     * Force saving application state to XML
     */
    public void save() {
        FileSystemManager.getInstance().saveState();
    }

    /**
     * Helper method to get all Booking objects from application state
     *
     * @return List of Booking objects
     */
    private List<Booking> bookings() {
        return FileSystemManager.getInstance().getState().getBookings();
    }
}
